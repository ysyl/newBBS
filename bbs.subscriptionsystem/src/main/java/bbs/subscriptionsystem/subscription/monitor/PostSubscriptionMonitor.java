package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;

//鏀惰棌鍙婂彂甯冨悗璁㈤槄
@Order(2)
@Component
@Aspect
public class PostSubscriptionMonitor {
	
	private SubscriptionService subscriptionManager;
	
	@Autowired
	public PostSubscriptionMonitor(SubscriptionService subscriptionManager) {
		super();
		this.subscriptionManager = subscriptionManager;
	}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectPost(..))"
			+ " && args(uid, postId)")
	public void uncollect(long uid, long postId) {}

	@Pointcut("execution(* bbs.forum.DAO.PostDAO.save1L(..))"
			+ " && args(uid, topicId, postForm)")
	public void pub1L(long uid, long topicId, PubPostForm postForm) {}

	@AfterReturning(value = "execution(* bbs.usercenter.service.UserCenterService.collectPost(..))"
			+ " && args(uid, postId)")
	public void monitor(long uid, long postId) {
		subscriptionManager.subscribePost(uid, postId);
	}
	
	@AfterReturning( value = "execution(* bbs.forum.service.BbsService.savePost(..))"
			+ " && args(uid, topicId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}

	@AfterReturning( pointcut = "pub1L(uid, topicId, postForm)", returning = "pubPostId")
	public void monitorPub1L(long uid, long topicId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}
	
	@AfterReturning(value = "execution(* bbs.forum.service.BbsService.reply(..))"
			+ " && args(uid, topicId, targetPostId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, long targetPostId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}
	
	@AfterReturning("uncollect(uid, postId)")
	public void monitorUncollect(long uid, long postId) {
		subscriptionManager.unsubscribePost(uid, postId);
	}
	

}
