package bbs.subscriptionsystem.action.pusher;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

@Component
public class SubscriptionMatcherHolder extends AbstractMap<String, SubscriptionMatcher> {
	
	private SubscriptionService subscriptionManager;
	
	private BbsService bbsService;

	private Map<String, SubscriptionMatcher> matcherMap = new HashMap<>();

	@Autowired
	public SubscriptionMatcherHolder(SubscriptionService subscriptionManager, BbsService bbsService) {
		super();
		this.subscriptionManager = subscriptionManager;
		this.bbsService = bbsService;
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
	
	public void freshMatcher(long uid ) {
		List<BaseSubscription<?>> subscriptions = (List<BaseSubscription<?>>) subscriptionManager.getSubscriptions(uid);
		String username = bbsService.getUsername(uid);
		SubscriptionMatcher matcher = this.matcherMap.get(username);
		if (matcher != null) {
			MyLogger.info("\n\n\nholer.freshMatcher : " + subscriptions.size());
			matcher.freshSubscriptions(subscriptions);
		}
	}
}
