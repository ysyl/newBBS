package bbs.subscriptionsystem.action.pusher;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.PostTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.pusher.constant.PusherConstant;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
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

	private void matchAndSendToUser(BaseAction action) {
		for (Entry<String, SubscriptionMatcher> matcherEntry : subscriptionMatcherHolder.entrySet()) {
			String username = matcherEntry.getKey();
			SubscriptionMatcher matcher = matcherEntry.getValue();
		
			System.out.println("获取到动作，准备匹配matcher，并发送给用户");
			
			if (matcher.match(action)) {
				System.out.println("\n\n\n匹配动作成功， 向用户" + username + "发布通知\n\n\n");
				BaseNotice notice = NoticeBuilder.transActionToNotice(action);
				System.out.println("通知内容为: " + notice);
				this.template.convertAndSendToUser(username, PusherConstant.SEND_NOTICE_TO_USER_URL,
						notice);
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
