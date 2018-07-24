package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.usercenter.form.PubUserProfileForm;

@Aspect
@Component
public class BeFollowedSubscriptionMonitor {

	private SubscriptionService subManager;
	
	@Autowired
	public BeFollowedSubscriptionMonitor(SubscriptionService subManager) {
		super();
		this.subManager = subManager;
	}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.createUserProfile(..))"
			+ " && args(userProfileForm)")
	public void createUserProfile(PubUserProfileForm userProfileForm) {}
	
	@AfterReturning( pointcut="createUserProfile(userProfileForm)", returning="userId") 
	public void monitorCreateUserProfile(PubUserProfileForm userProfileForm, long userId) {
		MyLogger.info(this.getClass(), "注册被关注订阅");
		subManager.subscribeSelf(userId);
	}
}
