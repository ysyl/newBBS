package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;

@Component
@Aspect
public class ForumSubscriptionMonitor {
	
	private SubscriptionDAO subscriptionDAO;
	
	public SubscriptionDAO getSubscriptionDAO() {
		return subscriptionDAO;
	}

	@Autowired
	public void setSubscriptionDAO(SubscriptionDAO subscriptionDAO) {
		this.subscriptionDAO = subscriptionDAO;
	}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectForum(..))"
			+ " && args(uid, forumId)")
	private void collectForum(long uid, int forumId) {}

	@AfterReturning("collectForum(uid, forumId)")
	public void monitorCollectForum(long uid, int forumId) {
		subscriptionDAO.saveForumSubscription(uid, forumId);
	}
}
