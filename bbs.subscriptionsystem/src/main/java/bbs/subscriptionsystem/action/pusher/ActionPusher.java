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

@Component
public class ActionPusher {
	
	private UserTrendActionDAO userTrendActionDAO;
	private TopicTrendActionDAO topicTrendActionDAO;
	private PostTrendActionDAO postTrendActionDAO;
	private ForumTrendActionDAO forumTrendActionDAO;
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder; 
	
	
	private final String destination = "/user/queue/action";
	
	@Autowired
	public ActionPusher(UserTrendActionDAO userTrendActionDAO, TopicTrendActionDAO topicTrendActionDAO,
			PostTrendActionDAO postTrendActionDAO, ForumTrendActionDAO forumTrendActionDAO,
			SubscriptionMatcherHolder subscriptionMatcherHolder) {
		super();
		this.userTrendActionDAO = userTrendActionDAO;
		this.topicTrendActionDAO = topicTrendActionDAO;
		this.postTrendActionDAO = postTrendActionDAO;
		this.forumTrendActionDAO = forumTrendActionDAO;
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
	}

	private void matchAndSendToUser(BaseAction action) {
		for (Entry<String, SubscriptionMatcher> matcherEntry : subscriptionMatcherHolder.entrySet()) {
			String username = matcherEntry.getKey();
			SubscriptionMatcher matcher = matcherEntry.getValue();
			if (matcher.match(action)) {
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
