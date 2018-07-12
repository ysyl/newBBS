package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;

@Component
public class ForumSubscriptionProvider implements SubscriptionProvider<ForumSubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	public SubscriptionDAO getSubscriptionDAO() {
		return subscriptionDAO;
	}

	@Autowired
	public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO) {
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<ForumSubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		List<ForumSubscription> subscriptions = subscriptionDAO.getAllForumSubscription(uid);
		return subscriptions;
	}

}
