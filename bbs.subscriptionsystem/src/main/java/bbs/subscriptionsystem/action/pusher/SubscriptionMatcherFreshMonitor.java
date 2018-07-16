package bbs.subscriptionsystem.action.pusher;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SubscriptionMatcherFreshMonitor {
	
	private SubscriptionMatcherHolder matcherHolder;

	@Autowired
	public SubscriptionMatcherFreshMonitor(SubscriptionMatcherHolder matcherHolder) {
		super();
		this.matcherHolder = matcherHolder;
	}

	@Pointcut("execution(* bbs.subscriptionsystem.subscription.manager.SubscriptionManager.subscribe*(..))")
	public void subscribed() {}
	
	@AfterReturning(pointcut = "subscribed()")
	public void freshSubscriptionMatcher() {
		matcherHolder.freshMatcher();
	}
}
