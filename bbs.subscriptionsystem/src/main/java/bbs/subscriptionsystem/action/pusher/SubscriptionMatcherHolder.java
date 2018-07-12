package bbs.subscriptionsystem.action.pusher;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SubscriptionMatcherHolder extends AbstractMap<String, SubscriptionMatcher> {
	
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
		return matcherMap.put(key, value);
	}
}
