package bbs.subscriptionsystem.action.pusher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

@Component
public class SubscriptionMatcherFactory {
	
	@Autowired
	public SubscriptionMatcherFactory(SubscriptionService subscriptionManager, BbsService bbsService) {
		super();
		this.subscriptionManager = subscriptionManager;
		this.bbsService = bbsService;
	}

	private SubscriptionService subscriptionManager;
	
	private BbsService bbsService;

	public SubscriptionMatcher createSubscriptionMatcher(String username, long uid) {
		MyLogger.info("为用户： " + username + " 创建matcher");
		List<BaseSubscription<?>> subscriptions = (List<BaseSubscription<?>>) subscriptionManager.getSubscriptions(uid);
		return new SubscriptionMatcher(username, subscriptions);
	}
}
