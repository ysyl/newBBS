package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.subscriptionsystem.service.SubscriptionService;

@Aspect
@Component
public class CommodyCommentSubscriptionMonitor {

	private SubscriptionService subService;

	@Autowired
	public CommodyCommentSubscriptionMonitor(SubscriptionService subService) {
		super();
		this.subService = subService;
	}
	
	@Pointcut("execution(* bbs.shop.service.ShopService.savePrimaryComment(..))"
			+ " && args(uid, commodyId, commentForm)")
	public void pubPrimaryCommodyComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm) {}
	
	@Pointcut("execution(* bbs.shop.service.ShopService.saveReplyComment(..))"
			+ " && args(uid, commodyId, replyCommentForm)")
	public void pubReplyCommodyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm) {}
	
	@AfterReturning(pointcut="pubPrimaryCommodyComment(uid, commodyId, commentForm)", returning="commentId")
	public void monitorPubPrimaryComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm,
			long commentId) {
		subService.subscribeCommodyComment(uid, commentId);
	}
	
	@AfterReturning(pointcut="pubReplyCommodyComment(uid, commodyId, replyCommentForm)", returning="commentId")
	public void monitorPubReplyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm,
			long commentId) {
		subService.subscribeCommodyComment(uid, commentId);
	}
}
