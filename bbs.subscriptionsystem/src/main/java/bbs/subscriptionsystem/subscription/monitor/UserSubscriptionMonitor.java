package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

@Aspect
@Component
public class UserSubscriptionMonitor {
	
	private SubscriptionManager subManager;

	@Autowired
	public UserSubscriptionMonitor(SubscriptionManager subManager) {
		super();
		this.subManager = subManager;
	}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectUser(..))"
			+ " && args(uid, followingId)")
	public void follow(long uid, long followingId) {}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectUser(..))"
			+ " && args(uid, followingId)")
	public void unfollow(long uid, long followingId) {}
	
	@AfterReturning("follow(uid, followingId)")
	public void monitorFollow(long uid, long followingId) {
		subManager.subscribeUserTrend(uid, followingId);
	}
	
	@AfterReturning("unfollow(uid, followingId)")
	public void monitorUnfollow(long uid, long followingId) {
		subManager.unsubscribeUser(uid, followingId);
	}
}
