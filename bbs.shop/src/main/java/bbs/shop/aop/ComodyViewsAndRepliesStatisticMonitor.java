package bbs.shop.aop;

import java.util.Set;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.shop.DAO.CommodyDAO;
import bbs.shop.entity.Commody;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;

@Aspect
@Component
public class ComodyViewsAndRepliesStatisticMonitor {
	
	private CommodyDAO commodyDAO;

	@Autowired
	public ComodyViewsAndRepliesStatisticMonitor(CommodyDAO commodyDAO) {
		super();
		this.commodyDAO = commodyDAO;
	}

	@Pointcut("execution(* bbs.shop.service.ShopService.getCommody(..))"
			+ "&& args(uid, commodyId)")
	public void viewCommody(Long uid, Long commodyId) {};
	
	@Pointcut("execution(* bbs.shop.service.ShopService.savePrimaryComment(..))"
			+ " && args(uid, commodyId, commentForm)")
	public void pubPrimaryCommodyComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm) {}
	
	@Pointcut("execution(* bbs.shop.service.ShopService.saveReplyComment(..))"
			+ " && args(uid, commodyId, replyCommentForm)")
	public void pubReplyCommodyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm) {}
	
	@AfterReturning(pointcut="viewCommody(uid, commodyId)", returning="commody")
	public void monitorViewCommody(Long uid, Long commodyId, Commody commody) {
		commodyDAO.updateViews(commodyId);
	}
	
	@AfterReturning(pointcut="pubPrimaryCommodyComment(uid, commodyId, commentForm)", returning="commentId")
	public void monitorPubPrimaryComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm,
			long commentId) {
		commodyDAO.updateReplies(commodyId);
	}
	
	@AfterReturning(pointcut="pubReplyCommodyComment(uid, commodyId, replyCommentForm)", returning="commentId")
	public void monitorPubReplyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm,
			long commentId) {
		commodyDAO.updateReplies(commodyId);
	}

}
