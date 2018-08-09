package bbs.subscriptionsystem.subscription.monitor;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
			+ " && args(uid, title, description, price, imgFileNames, commodyClassificationId, subClassList)")
	public void pubCommody(long uid, String title,  String description, Integer price, List<String> imgFileNames, Integer commodyClassificationId, List<Integer> subClassList) {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectCommody(..))"
			+ " && args(uid, commodyId)")
	public void collectCommody(long uid, long commodyId) {}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectCommody(..))"
			+ " && args(uid, commodyId)")
	public void uncollectCommody(long uid, long commodyId) {}
	
	@AfterReturning(pointcut = "pubCommody(uid, title, description, price,imgFileNames, commodyClassificationId, subClassList)", returning="commodyId")
	public void monitorPubCommody(long uid, String title, String description, Integer price, List<String> imgFileNames, Integer commodyClassificationId, List<Integer> subClassList, long commodyId) {
		subService.subscribeCommody(uid, commodyId);
	}
	
	@AfterReturning(pointcut = "collectCommody(uid, commodyId)")
	public void monitorCollectCommody(long uid, long commodyId) {
		subService.subscribeCommody(uid, commodyId);
	}
	
	@AfterReturning(pointcut = "uncollectCommody(uid, commodyId)")
	public void monitorUnCollectCommody(long uid, long commodyId) {
		subService.unsubscribeCommody(uid, commodyId);
	}

}
