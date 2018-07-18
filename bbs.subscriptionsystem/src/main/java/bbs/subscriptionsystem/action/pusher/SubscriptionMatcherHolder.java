package bbs.subscriptionsystem.action.pusher;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.service.HelperService;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

@Component
public class SubscriptionMatcherHolder extends AbstractMap<String, SubscriptionMatcher> {
	
	private SubscriptionManager subscriptionManager;
	
	private HelperService helperService;
	
	@Autowired
	public SubscriptionMatcherHolder(SubscriptionManager subscriptionManager, HelperService helperService) {
		super();
		this.subscriptionManager = subscriptionManager;
		this.helperService = helperService;
	}

	private Map<String, SubscriptionMatcher> matcherMap = new HashMap<>();

	public SubscriptionMatcherHolder(Map<String, SubscriptionMatcher> matcherMap) {
		super();
		this.matcherMap = matcherMap;
	}

	public SubscriptionMatcherHolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Entry<String, SubscriptionMatcher>> entrySet() {
		// TODO Auto-generated method stub
		return matcherMap.entrySet();
	}

	@Override
	public SubscriptionMatcher put(String key, SubscriptionMatcher value) {
		// TODO Auto-generated method stub
		MyLogger.info("将用户: " + key + " 的matcher放入holder");
		return matcherMap.put(key, value);
	}
	
	public void freshMatcher() {
		String username = helperService.getCurrentUsername();
		Long uid = helperService.getCurrentUserId();
		List<BaseSubscription<?>> subscriptions = subscriptionManager.getAllSubscriptions(uid);
		SubscriptionMatcher matcher = this.matcherMap.get(username);
		if (matcher != null) {
			MyLogger.info("\n\n\nholer.freshMatcher : " + subscriptions.size());
			matcher.freshSubscriptions(subscriptions);
		}
	}
}
