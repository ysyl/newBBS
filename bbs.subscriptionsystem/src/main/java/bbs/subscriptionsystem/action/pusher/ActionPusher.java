package bbs.subscriptionsystem.action.pusher;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.PostTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BbsTrendAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CollectUserAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.pusher.constant.PusherConstant;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;

@Component
public class ActionPusher {

	private UserTrendActionDAO userTrendActionDAO;
	private TopicTrendActionDAO topicTrendActionDAO;
	private PostTrendActionDAO postTrendActionDAO;
	private ForumTrendActionDAO forumTrendActionDAO;
	private SimpMessagingTemplate template;
	private SubscriptionMatcherHolder subscriptionMatcherHolder;

	@Autowired
	public ActionPusher(UserTrendActionDAO userTrendActionDAO, TopicTrendActionDAO topicTrendActionDAO,
			PostTrendActionDAO postTrendActionDAO, ForumTrendActionDAO forumTrendActionDAO,
			SimpMessagingTemplate template, SubscriptionMatcherHolder subscriptionMatcherHolder) {
		super();
		this.userTrendActionDAO = userTrendActionDAO;
		this.topicTrendActionDAO = topicTrendActionDAO;
		this.postTrendActionDAO = postTrendActionDAO;
		this.forumTrendActionDAO = forumTrendActionDAO;
		this.template = template;
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
	}

	//先过滤出collectUserAction，新建一个beFollowedAction 用于匹配，如果返回正确，则
	//同时再推送一个BeFollowedAction, 如果不匹配，则只发布CollectUserAction;
	private void matchAndSendToUser(BaseAction action) {
		for (Entry<String, SubscriptionMatcher> matcherEntry : subscriptionMatcherHolder.entrySet()) {
			String username = matcherEntry.getKey();
			SubscriptionMatcher matcher = matcherEntry.getValue();
		
			MyLogger.info("获取到动作"
					+ action.getClass().getSimpleName()
					+ "，在发送给用户"
					+ username
					+ "之前匹配matcher:");
			boolean isMatch = false;
			//发布一个被关注动作
			if (action instanceof CollectUserAction) {
				MyLogger.info("\n 检测到这个动作属于CollectUserAction, 接下来新建"
						+ "被关注动作，尝试匹配，如果匹配成功，则同时发布BeFollowedAction"
						+ "如果匹配失败，则只发布CollectUserAction");
				BeFollowedAction beFollowedAction = new BeFollowedAction((CollectUserAction) action);
				boolean isBeFollowedActionMatch = matcher.match(beFollowedAction);
				//如果转换出来的BeFollowedAction确实匹配，则替换CollectUserAction
				if (isBeFollowedActionMatch) {
					MyLogger.info("\n fork的BeFollowedAction匹配成功, 被关注者是： " + beFollowedAction.getFollowingUser().getNickname());
					BeFollowedNotice beFollowedNotice = (BeFollowedNotice) NoticeBuilder.transActionToNotice(beFollowedAction);
					
					this.template.convertAndSendToUser(username, PusherConstant.SEND_NOTICE_TO_USER_URL,
							beFollowedNotice);
				}
			}
			
			isMatch = matcher.match(action);

			
			MyLogger.info("动作为 : "
					+ action.getClass().getSimpleName()
					+ "  是否匹配成功: "
					+ isMatch);
			if (isMatch) {
				MyLogger.info("\n\n\n\n\n匹配动作成功， 向用户" + username + "发布通知\n\n\n");
				BaseNotice notice = NoticeBuilder.transActionToNotice(action);
				MyLogger.info("通知内容为: " + notice);
				this.template.convertAndSendToUser(username, PusherConstant.SEND_NOTICE_TO_USER_URL,
						notice);
				break;
			}
		}
	}

	public void pushUserTrendAction(long actionId) {
		UserTrendAction<?> action = userTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushTopicTrendAction(long actionId) {
		TopicTrendAction action = topicTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushPostTrendAction(long actionId) {
		PostTrendAction action = postTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushForumTrendAction(long actionId) {
		ForumTrendAction action = forumTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}
}
