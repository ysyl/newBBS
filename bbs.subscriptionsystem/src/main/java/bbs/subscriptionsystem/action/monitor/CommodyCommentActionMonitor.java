package bbs.subscriptionsystem.action.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.subscriptionsystem.action.DAO.CommodyCommentActionDAO;

@Aspect
@Component
public class CommodyCommentActionMonitor {
	
	private CommodyCommentActionDAO actionDAO;

	@Autowired
	public CommodyCommentActionMonitor(CommodyCommentActionDAO actionDAO) {
		super();
		this.actionDAO = actionDAO;
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
		MyLogger.infoln(this.getClass(), "插入Commody Comment Action");
		actionDAO.save(uid, commentId, commodyId);
	}
	
	@AfterReturning(pointcut="pubReplyCommodyComment(uid, commodyId, replyCommentForm)", returning="commentId")
	public void monitorPubReplyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm,
			long commentId) {
		MyLogger.info(this.getClass(), "插入Commody Comment Action");
		actionDAO.save(uid, commentId, commodyId);
	}
}
