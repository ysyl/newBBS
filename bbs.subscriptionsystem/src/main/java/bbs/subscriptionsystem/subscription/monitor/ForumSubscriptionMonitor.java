package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;

@Component
@Aspect
public class ForumSubscriptionMonitor {
	
	private SubscriptionService subManager;

	@Autowired
	public ForumSubscriptionMonitor(SubscriptionService subManager) {
		super();
		this.subManager = subManager;
	}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectForum(..))"
			+ " && args(uid, forumId)")
	private void collectForum(long uid, int forumId) {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectForum(..))"
			+ " && args(uid, forumId)")
	private void uncollectForum(long uid, int forumId) {}

	@AfterReturning("collectForum(uid, forumId)")
	public void monitorCollectForum(long uid, int forumId) {
		subManager.subscribeForum(uid, forumId);
	}
	
	@AfterReturning("uncollectForum(uid, forumId)")
	public void monitorUncollectForum(long uid, int forumId) {
		subManager.unsubscribeForum(uid, forumId);
	}
}
