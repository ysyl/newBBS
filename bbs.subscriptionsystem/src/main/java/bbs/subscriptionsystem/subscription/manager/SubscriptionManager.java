package bbs.subscriptionsystem.subscription.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;
import bbs.subscriptionsystem.subscription.provider.SubscriptionProvider;

@Component("mySubscriptionManager")
public class SubscriptionManager {
	
	private SubscriptionDAO subscriptionDAO;
	
	private List<? extends SubscriptionProvider<?>> providers;

	public SubscriptionDAO getSubscriptionDAO() {
		return subscriptionDAO;
	}

	@Autowired
	public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO) {
		this.subscriptionDAO = subscriptionDAO;
	}

	public List<? extends SubscriptionProvider<?>> getProviders() {
		return providers;
	}

	@Autowired
	public void setProviders(List<? extends SubscriptionProvider<?>> providers) {
		this.providers = providers;
	}

	public void subscribeTopic(long uid, long topicId) {
		subscriptionDAO.saveTopicSubscription(uid, topicId);
	}
	
	public void subscribePost(long uid, long postId) {
		subscriptionDAO.savePostSubscription(uid, postId);
	}
	
	public void subscribeUserTrend(long uid, long followingId) {
		subscriptionDAO.saveUserSubscription(uid, followingId);
	}

	public void subscribeForum(long uid, int forumId) {
		subscriptionDAO.saveForumSubscription(uid, forumId);
	}
	
	public List<? extends BaseSubscription<?>> getSubscriptions(long uid) {
		List<? extends BaseSubscription<?>> subscriptions = subscriptionDAO.getAllSubscription(uid);
		return subscriptions;
	}
	
	public List<BaseSubscription<?>> getAllSubscriptions(long uid) {
		List<BaseSubscription<?>> subscriptions = new ArrayList<>();
		for (SubscriptionProvider<?> provider : providers) {
			List<? extends BaseSubscription<?>> tempSubscriptions = (List<BaseSubscription<?>>) provider.getSubscriptionByUid(uid);
			subscriptions.addAll(tempSubscriptions);
		}
		return subscriptions;
	}

	public void updateLastReadTime(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		subscriptionDAO.updateLastReadTime(subscription.getId());
	}
}
