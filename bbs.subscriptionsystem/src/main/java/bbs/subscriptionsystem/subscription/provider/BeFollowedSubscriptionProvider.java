package bbs.subscriptionsystem.subscription.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.BeFollowedSubscription;

@Component
public class BeFollowedSubscriptionProvider implements SubscriptionProvider<BeFollowedSubscription> {
	
	private SubscriptionDAO subscriptionDAO;

	@Autowired
	public BeFollowedSubscriptionProvider(SubscriptionDAO subscriptionDAO) {
		super();
		this.subscriptionDAO = subscriptionDAO;
	}

	@Override
	public List<BeFollowedSubscription> getSubscriptionByUid(long uid) {
		// TODO Auto-generated method stub
		List<BeFollowedSubscription> resultList = new ArrayList<>();
		resultList.add(subscriptionDAO.getBeFollowedSubscriptionByUid(uid));
		return resultList;
	}

}
