package bbs.subscriptionsystem.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.util.Base64Decoder;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.form.PubAnnounceForm;
import bbs.forum.form.PubPostForm;
import bbs.forum.service.BBSService;
import bbs.forum.serviceImp.BBSServiceImp;
import bbs.helper.PageParam;
import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.service.UserCenterService;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.PubPostAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.pusher.ActionPusher;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Rollback
//@Transactional
//public class BaseJunit4Test {
//
//	@Test
//	public void testNoticeManager() {
//		
//	}
//}

@Transactional
@Rollback
public class SubscriptionSystemTest extends BaseTest{  
	
	@Autowired
	BBSService bbsService;
	
	@Autowired
	UserCenterService userCenterService;
	
	@Autowired
	SubscribedActionService subService;
	
	@Autowired
	SubscriptionManager subManager;
	
	
	private static final Logger logger = Logger.getLogger(SubscriptionSystemTest.class.getName());
	
	private static final PageParam pageParam = new PageParam(0, 20);
	
	private String randomGenerateString() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(random.nextInt(9));
		}
		return sb.toString();
	}
	
	private List<PubPostForm> randomGeneratePubPostForm(Long replyPostId, int amount) {
		List<PubPostForm> forms = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			PubPostForm form = new PubPostForm();
			byte[] contentBytes = new byte[50];
			String content = "回复内容： " + randomGenerateString();
			form.setContent(content);
			form.setReplyPostId(replyPostId);
			forms.add(form);
		}
		return forms;
	}
	//@Test
	public void testActionGenerator() {
		//测试动作产生与存储是否正常
		//选取要发布回复的帖子和发表回复的用户
		Topic firstTopicInGameForum = bbsService.getTopicListByForumId(1, pageParam).get(0);
		Long firstTopicId = firstTopicInGameForum.getId();
		User replier = bbsService.getUser(1L);
		//发布回复
		logger.info("\n\n\n新测试\n\n\n");
		logger.info("发布回复");
		List<PubPostForm> pubPostForms = randomGeneratePubPostForm(null, 10);
		for (PubPostForm form : pubPostForms) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bbsService.savePost(replier.getId(), firstTopicId, form);
		}
		//获取该帖子于某个时间点后产生的动作，此处选择帖子的发布时间
		logger.info("\t发布回复后，获取主题动态");
		List<TopicTrendAction> topicTrendActions = subService
				.getAllTopicTrendActionByIdAfterTime(firstTopicInGameForum.getId(), firstTopicInGameForum.getPubTime(), pageParam);
		//测试所有动作是否与发布过的回复相符，比如回复者ID、回复内容
		for (int i = 0; i < pubPostForms.size(); i++) {
				TopicTrendAction action = topicTrendActions.get(i);
				PubPostForm form = pubPostForms.get(i);
				Post reply = action.getNewReply();
				User newReplier = action.getReplier();
				Date pubtime = action.getPubTime();
				Topic topic = action.getTopic();
				
				assertEquals(form.getContent(), reply.getContent());
				assertEquals(firstTopicId, topic.getId());
				assertEquals(replier.getId(), newReplier.getId());
		}
		
		//获取某一时间点后该回复者的用户动态动作，结果应该为一个发布回复动作(PubPostAction)的列表
		//此处的时间点选取为主题帖子发布的时间；
		logger.info("\t发布回复后，获取用户动态");
		List<UserTrendAction<?>> userTrendActions = subService
				.getAllUserTrendActionByUidAfterTime(replier.getId(), firstTopicInGameForum.getPubTime(), pageParam);
		//测试每个用户动态动作，测试其类型是否是PubPostAction，并且测试动作与上个测试发生的动作是否相符，如回复所属
		//主题，以及回复的内容、回复时间
		logger.info("测试每个用户动态动作，测试其类型是否是PubPostAction，并且测试动作与上个测试发生的主题动态动作是否相符，如回复所属主题，以及回复的内容、回复时间");
		for (int i = 0; i < userTrendActions.size(); i++) 	{
			UserTrendAction<?> userTrendAction = userTrendActions.get(i);
			TopicTrendAction topicTrendAction = topicTrendActions.get(i);
			boolean isPubPostAction = userTrendAction instanceof PubPostAction;
			{
				//测试mybatis的discriminator是否根据type字段将实际类型转换为pubPostAction
				logger.info("测试mybatis的discriminator是否根据type字段将实际类型转换为pubPostAction");
				assertTrue(PubPostAction.class.isInstance(userTrendAction));
			}
			assertTrue(isPubPostAction);
			logger.info("\t如果是PubPostAction实例， 则进行具体字段的测试，测试产生的用户动态动作的字段"
					+ "如内容、回复者、主题是否和预想的一致");
			if (isPubPostAction) {
				PubPostAction pubPostAction = PubPostAction.class.cast(userTrendAction);
				Date pubTime = pubPostAction.getPubTime();
				String replyContent = pubPostAction.getTarget().getContent();
				Long topicId = pubPostAction.getTarget().getTopic().getId();
				Long uid = pubPostAction.getUser().getId();
				
				assertEquals(topicTrendAction.getNewReply().getContent(), replyContent);
				assertEquals(topicTrendAction.getReplier().getId(), uid);
				assertEquals(topicTrendAction.getTopic().getId(), topicId);
				
		}
	}
	}
	
	//让指定用户在指定帖子随机发十个回复
	private List<Long> pubRandomPost(long uid, long topicId, Long replyPost, int amount) {
		List<PubPostForm> forms = this.randomGeneratePubPostForm(replyPost, amount);
		List<Long> postIds = new ArrayList<>();
		for (PubPostForm form : forms) {
			Long postId = bbsService.savePost(uid, topicId, form);
			postIds.add(postId);
		}
		return postIds;
	}
	
	private List<Long> pubRandomPost(long uid, long topicId, int amount) {
		return this.pubRandomPost(uid, topicId, null, amount);
	}
	//@Test
	public void testTopicSubscriptionGenerate() throws InterruptedException, RepetitiveCollectException {
	
		logger.info("\n\n测试订阅的产生和使用\n\n");
		//取出一个用户，扮演使用者，执行下列任务：1.订阅一个主题，获取这个主题的动态动作，2.订阅一个用户，获取这个用户的动态。
		//以上获取的动态都必须是订阅之后产生的
		//最后实际测试产生的notice
		User user = bbsService.getUser(2L);
		
		//在订阅主题前先让一个用户发帖，然后再订阅一个主题，再让另外一个用户发帖，再获取订阅的动作，不应该包含订阅之前的动作
		User beforeMan = bbsService.getUser(1L);
		User afterMan = bbsService.getUser(3L);
		Topic luckTopic = bbsService.getTopic(2L);

		pubRandomPost(beforeMan.getId(), luckTopic.getId(), 10);
		Thread.sleep(500);
		Date subscribeTime = new Date();
		logger.info("订阅主题");
		userCenterService.collectTopic(user.getId(), luckTopic.getId());
		logger.info("订阅主题后再次发布回复");
		pubRandomPost(afterMan.getId(), luckTopic.getId(), 10);
		
		//每次获取action，都应该刷新对应订阅的lastReadTime
		logger.info("每次获取action，都应该刷新对应订阅的lastReadTime");
		List<BaseAction> subscribedAction =  subService.getAllActionByUid(user.getId());
		logger.info("验证通过订阅获取的动作是否不包含订阅前的动作，是否完全包含订阅后的动作");
		assertEquals(10, subscribedAction.size());
		for (BaseAction action : subscribedAction) {
			assertTrue(action instanceof TopicTrendAction);
			if (action instanceof TopicTrendAction) {
				TopicTrendAction topicTrendAction = (TopicTrendAction) action;
				Date actionPubTime = topicTrendAction.getPubTime();
				User replier = topicTrendAction.getReplier();

				assertTrue(actionPubTime.getTime() > subscribeTime.getTime());
				assertEquals(afterMan.getId(), replier.getId());
			}
			
		}
		logger.info("再次发布回复");
		pubRandomPost(afterMan.getId(), luckTopic.getId(),1);
		Thread.sleep(200);
		List<BaseAction> newActions = subService.getAllActionByUid(user.getId());
		BaseAction newAction = newActions.get(0);

		assertEquals(1, newActions.size());
		assertEquals(afterMan.getId(), ((TopicTrendAction)newAction).getReplier().getId());
		
		logger.info("取消订阅");
		userCenterService.uncollectTopic(user.getId(), luckTopic.getId());
		logger.info("取消订阅主题后再次发布回复");
		pubRandomPost(afterMan.getId(), luckTopic.getId(), 10);
		logger.info("获取所有动作");
		List<BaseAction> subscribedAction2 =  subService.getAllActionByUid(user.getId());
		assertEquals(0, subscribedAction2.size());
		
		logger.info("测试结束");

	}
	//测试订阅某个post，当其他人回复时收到提醒
	
	@Test
	public void testPostSubscriptionGenerator() {
		//选取某个用户，发布post，通过aop订阅这个post
		logger.info("测试postTrendAction订阅开始");
		User user = bbsService.getUser(1L);
		//确定这个用户没用订阅topic
		List<BaseSubscription<?>> subs = subManager.getAllSubscriptions(user.getId());
		assertEquals(0, subs.size());
		Topic luckTopic = bbsService.getTopic(2L);
		logger.info("\n\n\nfinal test\n\n");
		List<Long> postIdList = pubRandomPost(user.getId(), luckTopic.getId(), 1);
		subs = subManager.getAllSubscriptions(user.getId());
		for (BaseSubscription<?> sub : subs) {
			logger.info("subscriptionId: "+sub.getId());
		}
		assertEquals(1, subs.size());
		
		logger.info("发完第一个帖子");
		//选择某个用户，对user发送的第一个回复进行三次回复
		User replier = bbsService.getUser(2L);
		int replyAmount = 3;
		this.pubRandomPost(replier.getId(), luckTopic.getId(), postIdList.get(0), replyAmount);
		
		//获取所有replier产生的回复通知
		logger.info("获取所有replier产生的回复通知");
		List<BaseAction> actions = subService.getAllActionByUid(user.getId());
		assertEquals(replyAmount, actions.size());
		for (BaseAction action : actions) {
			boolean isPostTrendAction = action instanceof PostTrendAction;
			assertTrue(isPostTrendAction);
			if (isPostTrendAction) {
				PostTrendAction postTrendAction = (PostTrendAction) action;
				assertEquals(replier.getNickname(), postTrendAction.getReplier().getNickname());
			}
		}
		
		logger.info("2L用户发送5个回复");
		List<Long> postIds = this.pubRandomPost(replier.getId(), luckTopic.getId(), 5);
		List<Long> repostIds = new ArrayList<>();
		//1L对这五个回复分别回复一次
		for (Long postId : postIds) {
			repostIds.addAll(this.pubRandomPost(user.getId(), luckTopic.getId(), postId, 1));
		}
		logger.info("获取通知");
		List<BaseAction> totalPostTrendActions = subService.getAllActionByUid(replier.getId());
		for (BaseAction action : totalPostTrendActions ) {
			logger.info(action.getId().toString());
		}
		assertEquals(5, totalPostTrendActions.size());
		for (int i = 0; i < postIds.size(); i++) {
			logger.info("对比action中的targetid");
			boolean isPostTrendAction = totalPostTrendActions.get(i) instanceof PostTrendAction;
			assertTrue(isPostTrendAction);
			if (isPostTrendAction) {
				PostTrendAction postTrendAction = (PostTrendAction) totalPostTrendActions.get(i);
				assertEquals(postTrendAction.getTargetPost().getId(), postIds.get(i));
				assertEquals(repostIds.get(i), postTrendAction.getReplyPost().getId());
			}
		}
		
		logger.info("测试订阅的刷新最近阅读时间功能，3L用户再次对5个回复中的第一个进行回复，获取通知，数量应该为1");
		this.pubRandomPost(3L, luckTopic.getId(), repostIds.get(0), 1);
		this.pubRandomPost(3L, luckTopic.getId(), repostIds.get(0), 1);
		List<BaseAction> newAction = subService.getAllActionByUid(user.getId());
		assertEquals(2, newAction.size());
	}
	
	//@Test
	public void testCount() throws RepetitiveCollectException {
		logger.info("测试count： 选取用户和帖子，随机发帖1个");
		User verrickt = bbsService.getUser(1L);
		Topic topic = bbsService.getTopic(1L);
		userCenterService.collectTopic(verrickt.getId(), topic.getId());
		logger.info("随机插入以测试count");
		this.pubRandomPost(verrickt.getId(), topic.getId(), 1);
		Integer count = subService.countActionsByUid(verrickt.getId());
		logger.info("测试count结束");
	}
	
	private List<PubAnnounceForm> randomGeneratedAnnounceForm(long managerId, int forumId, int amount) {
		List<PubAnnounceForm> forms = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < amount; i++) {
			StringBuilder randomTitle = new StringBuilder(); 
			randomTitle.append("随机生成标题： ");
			StringBuilder randomContent = new StringBuilder();
			randomContent.append("随机生成公告内容: ");
			for (int j = 0; j < 10; j++) {
				randomTitle.append(random.nextInt(9));
				randomContent.append(random.nextInt(9));
			}
			PubAnnounceForm form = new PubAnnounceForm();
			form.setContent(randomContent.toString());
			form.setTitle(randomTitle.toString());
			form.setForumId(forumId);
			forms.add(form);
		}
		return forms;
	}
	
	private List<Integer> pubRandomAnnounce(long managerId, int forumId, int amount) {
		List<PubAnnounceForm> forms = randomGeneratedAnnounceForm(managerId, forumId, amount);
		List<Integer> announceIds = new ArrayList<>();
		for (PubAnnounceForm form : forms) {
			Integer id = bbsService.saveAnnounce(managerId, form);
			announceIds.add(id);
		}
		return announceIds;
	}
	
	//测试订阅论坛之后，获取论坛公告通知功能
	//@Test
	public void testAnnounce() {
		logger.info("测试订阅论坛之后，获取论坛公告通知功能");
		User manager = bbsService.getUser(1L);
		User normalUser = bbsService.getUser(2L);
		int luckForumId = 1;
		logger.info("订阅forum");
		userCenterService.collectForum(normalUser.getId(), luckForumId);
		logger.info("发布公告");
		List<Integer> announceIds = pubRandomAnnounce(manager.getId(), luckForumId, 2);
		
		logger.info("获取公告通知");
		List<BaseAction> forumTrendActions = subService.getAllActionByUid(normalUser.getId());
		assertEquals(2, forumTrendActions.size());
		for (BaseAction action : forumTrendActions) {
			boolean isForumTrendAction = action instanceof ForumTrendAction;
			assertTrue(isForumTrendAction);
			if (isForumTrendAction) {
				ForumTrendAction forumTrendAction = (ForumTrendAction) action;
				
				assertEquals(luckForumId, (int)forumTrendAction.getForum().getId());
				assertEquals(manager.getId(), forumTrendAction.getPublisher().getId());
			}
		}
		logger.info("测试公告结束");
	}
	
	//非法参数输入测试
	public void testIllegalArgument() {
		
	}
	
	//pusher测试
	public void testPusher() {
		
	}
	
}  
