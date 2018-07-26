package bbs.subscriptionsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

@Service("simpSubscriptionService")
@Primary
public class SimpSubscriptionService implements SubscriptionService {
	
	private SubscriptionDAO subscriptionDAO;
	
	@Autowired
	public SimpSubscriptionService(SubscriptionDAO subscriptionDAO) {
		super();
		this.subscriptionDAO = subscriptionDAO;
	}

	public void subscribeTopic(long uid, long topicId) {
		MyLogger.info("订阅Topic: " + topicId);
		if (!subscriptionDAO.hasTopicSubscription(uid, topicId))
			subscriptionDAO.saveTopicSubscription(uid, topicId);
	}

	public void subscribePost(long uid, long postId) {
		MyLogger.info("订阅Post: " + postId);
		if (!subscriptionDAO.hasPostSubscription(uid, postId)) {
			subscriptionDAO.savePostSubscription(uid, postId);
		}
	}

	public void subscribeUserTrend(long uid, long followingId) {
		MyLogger.info("订阅User: " + followingId);
		if (!subscriptionDAO.hasFollowingSubscription(uid, followingId))
			subscriptionDAO.saveUserSubscription(uid, followingId);
	}

	public void subscribeForum(long uid, int forumId) {
		MyLogger.info("订阅Forum: " + forumId);
		if (!subscriptionDAO.hasForumSubscription(uid, forumId))
			subscriptionDAO.saveForumSubscription(uid, forumId);
	}
	
	public void subscribeSelf(long myUid) {
		MyLogger.info("订阅自己的被关注信息: " + myUid);
		subscriptionDAO.saveBeFollowedSubscription(myUid);
	}

	public void unsubscribeForum(long uid, int forumId) {
		subscriptionDAO.removeForumSubscription(uid, forumId);
	}

	public void unsubscribePost(long uid, long postId) {
		subscriptionDAO.removePostSubscription(uid, postId);
	}

	public void unsubscribeTopic(long uid, long topicId) {
		subscriptionDAO.removeTopicSubscription(uid, topicId);
	}

	public void unsubscribeUser(long uid, long followingId) {
		subscriptionDAO.removeUserSubscription(uid, followingId);
	}

	public List<? extends BaseSubscription<?>> getSubscriptions(long uid) {
		List<? extends BaseSubscription<?>> subscriptions = subscriptionDAO.getAllSubscription(uid);
		return subscriptions;
	}

	@Override
	public void updateLastReadTime(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		subscriptionDAO.updateLastReadTime(subscription.getId());
	}

	@Override
	public void subscribeCommody(Long uid, Long commodyId) {
		// TODO Auto-generated method stub
		if (!subscriptionDAO.hasCommodySubscription(uid, commodyId))
			subscriptionDAO.saveCommodySubscription(uid, commodyId);
	}

	@Override
	public void subscribeCommodyComment(Long uid, long commentId) {
		// TODO Auto-generated method stub
		subscriptionDAO.saveCommodyCommentSubscription(uid, commentId);
	}


}
