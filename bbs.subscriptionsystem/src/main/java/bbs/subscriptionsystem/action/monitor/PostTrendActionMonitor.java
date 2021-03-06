package bbs.subscriptionsystem.action.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.action.manager.ActionManager;

//在TopicTrendAction之后执行
@Order(1)
@Component
@Aspect
public class PostTrendActionMonitor {
	
	private ActionManager actionManager;

	@Autowired
	public PostTrendActionMonitor(ActionManager actionManager) {
		super();
		this.actionManager = actionManager;
	}

	//如果使用这个切面，则无法监控到一楼的发布
	@Pointcut("execution(* bbs.forum.service.BbsService.savePost(..))"
			+ " && args(uid, topicId, postForm)")
	public void pubPost(long uid, long topicId, PubPostForm postForm) {}

	@AfterReturning( pointcut="pubPost(uid, topicId, postForm)", returning="postId")
	public void monitorPubPost(long uid, long topicId, PubPostForm postForm, long postId) {
		if (postForm.getReplyPostId() != null) {
			actionManager.addPostTrendAction(uid, topicId, postForm.getReplyPostId(), postId);
		}
	}

}
