package bbs.subscriptionsystem.action.pusher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.service.BBSService;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

@Component
public class SubscriptionMatcherFactory {
	
	@Autowired
	public SubscriptionMatcherFactory(SubscriptionManager subscriptionManager, BBSService bbsService) {
		super();
		this.subscriptionManager = subscriptionManager;
		this.bbsService = bbsService;
	}

	private SubscriptionManager subscriptionManager;
	
	private BBSService bbsService;

	public SubscriptionMatcher createSubscriptionMatcher(String username) {
		MyLogger.info("为用户： " + username + " 创建matcher");
		Long uid = bbsService.getUser(username).getId();
		List<BaseSubscription<?>> subscriptions = subscriptionManager.getAllSubscriptions(uid);
		return new SubscriptionMatcher(username, subscriptions);
	}
}
