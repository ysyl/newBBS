package bbs.subscriptionsystem.action.pusher;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Pointcut("execution(* bbs.subscriptionsystem.service.SubscriptionService.subscribe*(..))"
			+ " && args(uid, targetId)")
	public void subscribed(long uid, long targetId) {}
	
	@Pointcut("execution(* bbs.subscriptionsystem.service.SubscriptionService.subscribeForum(..))"
			+ " && args(uid, forumId)")
	public void subscribeForum(long uid, int forumId) {}

	@Pointcut("execution(* bbs.subscriptionsystem.service.SubscriptionService.unsubscribe*(..))"
			+ " && args(uid, targetId)")
	public void unsubscribed(long uid, long targetId) {}
	
	@Pointcut("execution(* bbs.subscriptionsystem.service.SubscriptionService.unsubscribeForum(..))"
			+ " && args(uid, forumId)")
	public void unsubscribeForum(long uid, int forumId) {}

	@AfterReturning(pointcut = "subscribed(uid, targetId)")
	public void freshSubscriptionMatcherAfterSubscribe(long uid, long targetId) {
		MyLogger.info("订阅刷新");
		matcherHolder.freshMatcher(uid);
	}

	@AfterReturning(pointcut = "unsubscribed(uid, targetId)")
	public void freshSubscriptionMatcherAfterUnSubscribe(long uid, long targetId ) {
		MyLogger.info("退订刷新");
		matcherHolder.freshMatcher(uid);
	}

	@AfterReturning(pointcut = "subscribeForum(uid, forumId)")
	public void freshSubscriptionMatcherAfterSubscribeForum(long uid, int forumId) {
		MyLogger.info("订阅刷新");
		matcherHolder.freshMatcher(uid);
	}

	@AfterReturning(pointcut = "unsubscribeForum(uid, forumId)")
	public void freshSubscriptionMatcherAfterUnSubscribeForum(long uid, int forumId ) {
		MyLogger.info("退订刷新");
		matcherHolder.freshMatcher(uid);
	}
}
