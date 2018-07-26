package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.form.PubCommodyForm;
import bbs.subscriptionsystem.service.SubscriptionService;

@Aspect
@Component
public class CommodySubscriptoinMonitor {
	
	private SubscriptionService subService;
	
	@Autowired
	public CommodySubscriptoinMonitor(SubscriptionService subService) {
		super();
		this.subService = subService;
	}

	@Pointcut("execution(* bbs.shop.service.ShopService.saveCommody(..))"
			+ " && args(uid, pubCommodyForm)")
	public void pubCommody(long uid, PubCommodyForm pubCommodyForm) {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectCommody(..))"
			+ " && args(uid, commodyId)")
	public void collectCommody(long uid, long commodyId) {}
	
	@AfterReturning(pointcut = "pubCommody(uid, pubCommodyForm)", returning="commodyId")
	public void monitorPubCommody(long uid, PubCommodyForm pubCommodyForm, long commodyId) {
		subService.subscribeCommody(uid, commodyId);
	}
	
	@AfterReturning(pointcut = "collectCommody(uid, commodyId)")
	public void monitorCollectCommody(long uid, long commodyId) {
		subService.subscribeCommody(uid, commodyId);
	}

}
