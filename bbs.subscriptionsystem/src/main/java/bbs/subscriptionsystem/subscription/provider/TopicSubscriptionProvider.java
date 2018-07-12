package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

@Component
public class TopicSubscriptionProvider implements SubscriptionProvider<TopicSubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	public SubscriptionDAO getSubscriptionDAO() {
		return subscriptionDAO;
	}

	@Autowired
	public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO) {
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<TopicSubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		List<TopicSubscription> subscriptions = subscriptionDAO.getAllTopicSubscription(uid);
		return subscriptions;
	}

}
