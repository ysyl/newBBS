package bbs.subscriptionsystem.action.monitor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.service.BBSService;
import bbs.subscriptionsystem.action.manager.ActionManager;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

@Component
@Order(2)
@Aspect
public class UserTrendActionMonitor extends AbstractActionMonitor {
	
	private ActionManager actionManager;
	
	public ActionManager getActionManager() {
		return actionManager;
	}

	@Autowired
	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	@Pointcut("execution(* bbs.forum.service.BBSService.saveTopic(..))"
			+ "&& args(uid, pubTopicForm)")
	private void pubTopic(long uid, PubTopicForm pubTopicForm) {};
	
	@Pointcut("execution(* bbs.forum.service.BBSService.savePost(..))"
			+ "&& args(uid, topicId, pubPostForm)")
	private void pubPost(long uid, long topicId, PubPostForm pubPostForm) {};
	
	@Pointcut("execution(* bbs.forum.service.BBSService.likeTopic(..))"
			+ "&& args(topicId) ")
	private void likeTopic(long topicId) {};
	
	@Pointcut("execution(* bbs.forum.service.BBSService.likePost(..))"
			+ "&& args(postId) ")
	private void likePost(long postId) {};
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectTopic(..))"
			+ "&& args(uid, topicId)")
	private void collectTopic(long uid, long topicId) {};
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectPost(..))"
			+ "&& args(uid, postId)")
	private void collectPost(long uid, long postId) {};

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectUser(..))"
			+ "&& args(uid, followingId)")
	private void collectUser(long uid, long followingId) {};
	
	@Transactional
	@AfterReturning(value = "pubTopic(uid, pubTopicForm)", returning = "topicId")
	public void monitorPubTopic(long uid, PubTopicForm pubTopicForm, Long topicId) {
		actionManager.addUserTrendAction(UserTrendActionType.PUB, UserTrendActionTargetType.TOPIC, uid, topicId);
	}
	
	@AfterReturning(value = "pubPost(uid, topicId, pubPostForm)", returning = "postId")
	public void monitorPubPost(long uid,long topicId, PubPostForm pubPostForm, Long postId) {
		actionManager.addUserTrendAction(UserTrendActionType.PUB, UserTrendActionTargetType.POST, uid, postId);
	}

	@AfterReturning(value = "collectTopic(uid, topicId)")
	public void monitorCollectTopic(long uid,long topicId) {
		actionManager.addUserTrendAction(UserTrendActionType.COLLECT, UserTrendActionTargetType.TOPIC, uid, topicId);
	}

	@AfterReturning(value = "collectPost(uid, postId)")
	public void monitorCollectPost(long uid,long postId) {
		actionManager.addUserTrendAction(UserTrendActionType.COLLECT, UserTrendActionTargetType.POST, uid, postId);
	}

	@AfterReturning(value = "collectUser(uid, followingId)")
	public void monitorCollectUser(long uid,long followingId) {
		actionManager.addUserTrendAction(UserTrendActionType.COLLECT, UserTrendActionTargetType.USER, uid, followingId);
	}

	
	@After("likeTopic(topicId)")
	public void monitorLikeTopic(long topicId) {
	}
	
	@After("likePost(postId)")
	public void monitorLikePost(long postId) {
	}
}
