package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.mapper.TSubscriptionMapper;
import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;

@Component
public class PostSubscriptionProvider implements SubscriptionProvider<PostSubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	public SubscriptionDAO getSubscriptionDAO() {
		return subscriptionDAO;
	}

	@Autowired
	public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO) {
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<PostSubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		List<PostSubscription> subscriptions = subscriptionDAO.getAllPostSubscription(uid);
		return subscriptions;
	}

}
