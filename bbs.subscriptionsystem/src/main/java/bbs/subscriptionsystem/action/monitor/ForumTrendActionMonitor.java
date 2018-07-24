package bbs.subscriptionsystem.action.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.form.PubAnnounceForm;
import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;

@Order(0)
@Component
@Aspect
public class ForumTrendActionMonitor {

	private ForumTrendActionDAO forumTrendActionDAO;

	public ForumTrendActionDAO getForumTrendActionDAO() {
		return forumTrendActionDAO;
	}

	@Autowired
	public void setForumTrendActionDAO(ForumTrendActionDAO forumTrendActionDAO) {
		this.forumTrendActionDAO = forumTrendActionDAO;
	}
	
	@Pointcut("execution(* bbs.forum.service.BbsService.saveAnnounce(..))"
			+ " && args(managerId, pubAnnounceForm)")
	public void pubAnnounce(long managerId, PubAnnounceForm pubAnnounceForm) {}
	
	@AfterReturning( pointcut="pubAnnounce(managerId, pubAnnounceForm)", returning= "announceId")
	public void monitorPubAnnounce(long managerId, PubAnnounceForm pubAnnounceForm, int announceId) {
		forumTrendActionDAO.saveForumTrendAction(managerId, pubAnnounceForm.getForumId(), announceId);
	}
}
