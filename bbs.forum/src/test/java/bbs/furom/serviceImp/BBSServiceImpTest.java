package bbs.furom.serviceImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.Announce;
import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.enuma.Sex;
import bbs.forum.form.ModifyPostForm;
import bbs.forum.form.PubAnnounceForm;
import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.form.UserProfileForm;
import bbs.forum.service.BBSService;
import bbs.helper.PageParam;

@Transactional
@Rollback
public class BBSServiceImpTest extends BaseTest {
	
	@Autowired
	BBSService bbsService;
	
	private static Logger logger = Logger.getLogger(BBSServiceImpTest.class);
	
	private static PageParam pageParam = new PageParam(0, 20);
	
	String forumTestBegin = "获取forum测试开始";
	

	@Test
	public void testService() {
		logger.info("\n\n\n新测试\n\n\n");

		logger.info("获取forum测试");
		Forum gameForum = bbsService.getForum(1);
		assertEquals(gameForum.getForumName(), "game");

		//Post
		logger.info("根据id获取post");
		Post post2L = bbsService.getPost(2L);
		assertEquals(post2L.getContent(), "test game topic#2 main post ");
		
		logger.info("根据topicID获取post");
		List<Post> topic1LPostList = bbsService.getPostList(1L, pageParam);
		assertEquals(topic1LPostList.size(), 3);
		
		logger.info("根据内容搜索回复");
		List<Post> relaMain = bbsService.searchPost("main", pageParam);
		assertEquals(relaMain.size(), 12);
		
		logger.info("获取用户的所有回复，分页");
		List<Post> verricktAllPost = bbsService.getPostByUid(1L, pageParam);
		for (Post verricktPost : verricktAllPost) {
			assertEquals(verricktPost.getAuthor().getNickname(), "verrickt");
		}
		assertEquals(verricktAllPost.size(), 4);
		
		logger.info("获取某个post下的所有回复");
		List<Post> replyPost = bbsService.getReply(4L, pageParam);
		for (Post reply : replyPost) {
			assertEquals((long)reply.getReplyPost().getId(), 4L);
		}
		assertEquals(replyPost.size(), 1);
		
		logger.info("获取某个帖子的主回复");
		Topic topic1L = bbsService.getTopic(1L);
		Post topic1LMainPost = bbsService.getMainPost(1L);System.out.println("\n\n\n:"+ topic1LMainPost.getId());
		assertEquals(topic1LMainPost.getId(), topic1L.getMainPost().getId());

		
		//Topic
		logger.info("根据topicId获取topic");
		Topic topic2L = bbsService.getTopic(2L);
		assertEquals(topic2L.getTitle(), "test game topic #2");
		
		logger.info("获取一个forum下的所有topic，分页");
		List<Topic> forum1LTopicList = bbsService.getTopicListByForumId(1, pageParam);
		for (Topic topic : forum1LTopicList) {
			assertEquals((int)topic.getForum().getId(), 1);
		}
		assertEquals(forum1LTopicList.size(), 6);
		
		logger.info("根据标题搜索主题");
		List<Topic> topicContainGame = bbsService.searchTopic("game", pageParam);
		for (Topic gameTopic : topicContainGame) {
			assertTrue(gameTopic.getTitle().contains("game"));
		}
		
		logger.info("获取1L用户的所有主题");
		List<Topic> user1LAllTopic = bbsService.getTopicListByUid(bbsService.getUser(1L).getId(), pageParam);
		for (Topic userTopic : user1LAllTopic) {
			assertTrue(userTopic.getAuthor().getId().equals(1L));
		}
		assertEquals(3, user1LAllTopic.size());
		
		
		//User
		logger.info("根据用户名搜索用户");
		User verrickt = bbsService.getUser("verrickt");
		assertEquals((long)verrickt.getId(), 1L);
		logger.info("根据用户id获取用户");
		User zhou = bbsService.getUser(2L);
		assertEquals(zhou.getNickname(), "zhou");


//		logger.info("更新用户资料");
//		User user1L = bbsService.getUser(1L);
//		String oldNickname = user1L.getNickname();
//		long uid = verrickt.getId();
//		String newNickname = "verrickt_modified";
//		Sex newSex = Sex.FEMALE;
//
//		UserProfileForm userProfileForm = new UserProfileForm();
//		userProfileForm.setNickname(newNickname);
//		userProfileForm.setSex(newSex);
//
//		User newVerrickt = bbsService.getUser(1L);
//
//		assertNotEquals(oldNickname, newVerrickt.getNickname());
//		assertEquals(userProfileForm.getNickname(), newVerrickt.getNickname());
//		assertEquals(newSex, newVerrickt.getSex());
		
		logger.info("更新回复");
		
		Post oldPost = bbsService.getPost(1L);
		
		Date oldModifiedTime = oldPost.getLastModifiedTime();
		
		String newContent = "更新后的回复内容";
		
		ModifyPostForm modifyPostForm = new ModifyPostForm();
		modifyPostForm.setContent(newContent);
		
		bbsService.updatePost(oldPost.getAuthor().getId(), oldPost.getId(), modifyPostForm);
		
		Post newPost = bbsService.getPost(oldPost.getId());
		
		assertEquals(newContent, newPost.getContent());
		assertNotEquals(oldModifiedTime, newPost.getLastModifiedTime());
		
		logger.info("发布帖子");
		PubTopicForm pubTopicForm = new PubTopicForm();
		pubTopicForm.setContent("新帖子内容");
		pubTopicForm.setTitle("新帖子标题");
		pubTopicForm.setForumId(1);
		
		Long newTopicId = bbsService.saveTopic(1L, pubTopicForm);
		logger.info("\n\n\n\n新主题的id：" + newTopicId);
		Topic testTopic = bbsService.getTopic(newTopicId);
		logger.info("\n\n\n新主题的标题: " + testTopic.getTitle());
		List<Topic> searchNewTopic = bbsService.searchTopic("新帖子", pageParam);
		Post newTopicMainPost = bbsService.getMainPost(searchNewTopic.get(0).getId());

		assertEquals(searchNewTopic.get(0).getTitle(), "新帖子标题");
		assertEquals(newTopicMainPost.getContent(), "新帖子内容");
		
		
logger.info("发布回复");
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent("新回复内容");
		pubPostForm.setReplyPostId(null);
		
		bbsService.savePost(verrickt.getId(), topic1L.getId(), pubPostForm);
		
		List<Post> searchNewPost = bbsService.searchPost("新回复内容", pageParam);
		
		assertEquals("新回复内容", searchNewPost.get(0).getContent());
		assertEquals("verrickt", searchNewPost.get(0).getAuthor().getNickname());
		
		logger.info("回复某个回复");
		PubPostForm replyForm = new PubPostForm();
		replyForm.setContent("回复上一个新回复");
		replyForm.setReplyPostId(searchNewPost.get(0).getId());
		
		bbsService.savePost(verrickt.getId(), topic1L.getId(), replyForm);
		
		List<Post> getNewReply = bbsService.getReply(searchNewPost.get(0).getId(), pageParam);
		assertEquals(replyForm.getContent(), getNewReply.get(0).getContent());
		
		
		logger.info("发布公告");
		User manager = bbsService.getUser(1L);
		Forum luckForum = bbsService.getForum(1);
		PubAnnounceForm pubAnnounceForm = new PubAnnounceForm();
		pubAnnounceForm.setContent("测试公告");
		pubAnnounceForm.setForumId(luckForum.getId());
		pubAnnounceForm.setTitle("测试公告标题");
		bbsService.saveAnnounce(manager.getId(), pubAnnounceForm);
		
		List<Announce> announceList = bbsService.getAllAnnounceByForumId(luckForum.getId(), pageParam);
		Announce firstAnnounce = announceList.get(0);
		
		logger.info("验证Announce的各个字段");
		assertEquals(pubAnnounceForm.getContent(), firstAnnounce.getContent());
		assertEquals(pubAnnounceForm.getForumId(), firstAnnounce.getForum().getId());
		assertEquals(pubAnnounceForm.getTitle(), firstAnnounce.getTitle());
		assertEquals(manager.getId(), firstAnnounce.getPublisher().getId());
	}
	//测试监视器
	@Test
	public void testAspectMonitor() {
		logger.info("测试监视器");
		logger.info("发布回复");
		long verricktId = 1L;
		long luckyTopicId = 1L;
		Topic luckyTopic = bbsService.getTopic(luckyTopicId);
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent("测试监视器");
		pubPostForm.setReplyPostId(null);
		int oldViews = luckyTopic.getViews();
		int oldReplies = luckyTopic.getReplies();
		
		bbsService.savePost(verricktId, luckyTopicId, pubPostForm);
		//这里也view了一次topic
		Topic afterTopic = bbsService.getTopic(luckyTopicId);
		int newViews = afterTopic.getViews();
		int newReplies = afterTopic.getReplies();
		
		assertEquals(1, newViews - oldViews);
		assertEquals(1, newReplies - oldReplies);
	}
}
