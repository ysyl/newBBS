package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

//鏀惰棌鍙婂彂甯冨悗璁㈤槄
@Order(2)
@Component
@Aspect
public class PostSubscriptionMonitor {
	
	private SubscriptionManager subscriptionManager;
	
	@Autowired
	public PostSubscriptionMonitor(SubscriptionManager subscriptionManager) {
		super();
		this.subscriptionManager = subscriptionManager;
	}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectPost(..))"
			+ " && args(uid, postId)")
	public void uncollect(long uid, long postId) {}

	@AfterReturning(value = "execution(* bbs.usercenter.service.UserCenterService.collectPost(..))"
			+ " && args(uid, postId)")
	public void monitor(long uid, long postId) {
		subscriptionManager.subscribePost(uid, postId);
	}
	
	@AfterReturning( value = "execution(* bbs.forum.service.BBSService.savePost(..))"
			+ " && args(uid, topicId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}
	
	@AfterReturning(value = "execution(* bbs.forum.service.BBSService.reply(..))"
			+ " && args(uid, topicId, targetPostId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, long targetPostId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}
	
	@AfterReturning("uncollect(uid, postId)")
	public void monitorUncollect(long uid, long postId) {
		subscriptionManager.unsubscribePost(uid, postId);
	}

}
