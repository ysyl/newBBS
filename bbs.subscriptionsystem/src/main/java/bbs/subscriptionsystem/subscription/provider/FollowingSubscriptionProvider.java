package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;

@Component
public class FollowingSubscriptionProvider implements SubscriptionProvider<FollowingSubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	public FollowingSubscriptionProvider(SubscriptionDAO subscriptionDAO) {
		super();
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<FollowingSubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		return subscriptionDAO.getAllFollowingSubscriptionByUid(uid);
	}

}
