package bbs.subscriptionsystem.action.pusher;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;

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

	@Pointcut("execution(* bbs.subscriptionsystem.subscription.manager.SubscriptionManager.unsubscribe*(..))")
	public void unsubscribed() {}
	
	@AfterReturning(pointcut = "subscribed()")
	public void freshSubscriptionMatcherAfterSubscribe() {
		MyLogger.info("订阅刷新");
		matcherHolder.freshMatcher();
	}

	@AfterReturning(pointcut = "unsubscribed()")
	public void freshSubscriptionMatcherAfterUnSubscribe() {
		MyLogger.info("退订刷新");
		matcherHolder.freshMatcher();
	}
}
