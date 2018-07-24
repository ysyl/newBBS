package bbs.subscriptionsystem.action.monitor;

import java.io.Serializable;

import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.Post;
import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.manager.ActionManager;

@Order(0)
@Component
@Aspect
public class TopicTrendActionMonitor extends AbstractActionMonitor {
	
	private ActionManager actionManager;

	public ActionManager getActionManager() {
		return actionManager;
	}

	@Autowired
	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	
	@Pointcut("execution(* bbs.forum.DAO.PostDAO.save1L(..))"
			+ " && args(uid, topicId, postForm)")
	public void pub1L(long uid, long topicId, PubPostForm postForm) {}

	//发布回复后，发布帖子动态动作
	@Transactional
	@AfterReturning(value = "execution(* bbs.forum.service.BbsService.savePost(..)) "
			+ "&& args(uid, topicId, postForm)", returning = "postId")
	public void monitor(long uid, long topicId, PubPostForm postForm, Long postId) {
		actionManager.addTopicTrendAction(uid, topicId, postId);
	}
	
	@AfterReturning(pointcut = "pub1L(uid, topicId, postForm)", returning = "postId")
	public void monitor1L(long uid, long topicId, PubPostForm postForm, Long postId) {
		actionManager.addTopicTrendAction(uid, topicId, postId);
	}

}
