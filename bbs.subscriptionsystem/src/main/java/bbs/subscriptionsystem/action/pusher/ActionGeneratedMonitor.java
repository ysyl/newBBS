package bbs.subscriptionsystem.action.pusher;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

@Component
@Aspect
public class ActionGeneratedMonitor {
	
	private ActionPusher actionPusher;
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;

	@Autowired
	public ActionGeneratedMonitor(ActionPusher actionPusher, SubscriptionMatcherHolder subscriptionMatcherHolder) {
		super();
		this.actionPusher = actionPusher;
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
	}

	@Pointcut("execution(* bbs.subscriptionsystem.action.manager.ActionManager.addUserTrendAction(..))"
			+ " && args(actionType, targetType, uid, targetId)")
	private void userTrendActionGenerated(UserTrendActionType actionType, UserTrendActionTargetType targetType,
			long uid, long targetId) {}
	
	@Pointcut("execution(* bbs.subscriptionsystem.action.manager.ActionManager.addTopicTrendAction(..)) "
			+ "&& args(uid, topicId, replyId)")
	private void topicTrendActionGenerated(long uid, long topicId, long replyId) {}
	
	@Pointcut("execution(* bbs.subscriptionsystem.action.manager.ActionManager.addPostTrendAction(..))"
			+ "&& args(uid, postId, replyPostId)")
	private void postTrendActionGenerated(long uid, long postId, long replyPostId) {}
	
	@Pointcut("execution(* bbs.subscriptionsystem.action.manager.ActionManager.addForumTrendAction(..))"
			+ "&& args(managerId, forumId, announceId)")
	private void forumTrendActionGenerated(long managerId, long forumId, long announceId) {}
	
//	@AfterReturning( pointcut="userTrendActionGenerated(actionType, targetType, uid, targetId)", 
//			returning="userTrendActionId")
//	public void pushUserTrendActionToUser(UserTrendActionType actionType, UserTrendActionTargetType targetType,
//			long uid, long targetId, long userTrendActionId) {
//		actionPusher.pushUserTrendAction(userTrendActionId);
//	}
	
	@AfterReturning( pointcut="topicTrendActionGenerated(uid, topicId, replyId)", returning="topicTrendActionId")
	public void pushTopicTrendAction(long uid, long topicId, long replyId, long topicTrendActionId) {
		actionPusher.pushTopicTrendAction(topicTrendActionId);
	}
	
	@AfterReturning( pointcut="postTrendActionGenerated(uid, postId, replyPostId)", returning="postTrendActionId")
	public void pushPostTrendAction(long uid, long postId, long replyPostId, long postTrendActionId) {
		actionPusher.pushPostTrendAction(postTrendActionId);
	}
	
	@AfterReturning( pointcut="forumTrendActionGenerated(managerId, forumId, announceId)", returning="forumTrendActionId")
	public void pushForumTrendAction(long managerId, long forumId, long announceId, long forumTrendActionId) {
		actionPusher.pushForumTrendAction(forumTrendActionId);
	}
	
}
