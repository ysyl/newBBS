package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.CommodySubscription;

@Component
public class CommodySubscriptionProvider implements SubscriptionProvider<CommodySubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	@Autowired
	public CommodySubscriptionProvider(SubscriptionDAO subscriptionDAO) {
		super();
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<CommodySubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		return subscriptionDAO.getAllCommodySubscriptionByUid(uid);
	}

}
