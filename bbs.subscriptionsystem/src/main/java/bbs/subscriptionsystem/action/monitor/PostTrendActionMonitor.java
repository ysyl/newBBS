package bbs.subscriptionsystem.action.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.action.manager.ActionManager;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

//在TopicTrendAction之后执行
@Order(1)
@Component
@Aspect
public class PostTrendActionMonitor {
	
	private ActionManager actionManager;

	public ActionManager getActionManager() {
		return actionManager;
	}

	@Autowired
	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	@Pointcut("execution(* bbs.forum.service.BBSService.savePost(..))"
			+ " && args(uid, topicId, postForm)")
	public void pubPost(long uid, long topicId, PubPostForm postForm) {}
	
	public void pubRepost() {}

	@AfterReturning( pointcut="pubPost(uid, topicId, postForm)", returning="postId")
	public void monitorPubPost(long uid, long topicId, PubPostForm postForm, long postId) {
		if (postForm.getReplyPostId() != null) {
			actionManager.addPostTrendAction(uid, topicId, postForm.getReplyPostId(), postId);
		}
	}
}
