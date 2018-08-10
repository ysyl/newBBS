package bbs.web.listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.User;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.security.service.BbsSecurityService;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.subscriptionsystem.notice.service.NoticeService;
import bbs.usercenter.userprofile.DTO.UserProfile;
import security.core.DTO.UserPrincipal;

@Component
public class LoginAndLogoutListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	private IAuthenticationFacade authenticationFacade;

	private HttpSession session;

	private BbsSecurityService bbsSecurityService;
	
	private BbsService bbsService;
	
	private NoticeService noticeService;
	
	public static final String NOTICE_COUNT_NAME = "initNoticeCount";

	@Autowired
	public LoginAndLogoutListener(IAuthenticationFacade authenticationFacade, HttpSession session,
			BbsSecurityService bbsSecurityService, BbsService bbsService, NoticeService noticeService) {
		super();
		this.authenticationFacade = authenticationFacade;
		this.session = session;
		this.bbsSecurityService = bbsSecurityService;
		this.bbsService = bbsService;
		this.noticeService = noticeService;
	}

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		MyLogger.info("\n\n\n登录成功\n\n\n");
		this.addUserToSession();
		this.initNoticeStatus(session);
	}

	private void addUserToSession() {
		UserPrincipal userPrincipal = bbsSecurityService.getUserPrincipal(authenticationFacade.getUsername());
		User user = bbsService.getUser(userPrincipal.getId());
		if (session.getAttribute("userPrincipal") != null || session.getAttribute("userProfile") != null) {
			removeUserInSession(); 
		}
		session.setAttribute("userPrincipal", userPrincipal);
		session.setAttribute("userProfile", user);
	}
	
	private void removeUserInSession() {
		session.removeAttribute("userPrincipal");
		session.removeAttribute("userProfile");
	}
	
	public void initNoticeStatus(HttpSession session) {
		Long uid;
		Integer count = 0;
		try {
			uid = authenticationFacade.getUserId();
			count = noticeService.getNoticeCountByUid(uid);
			session.setAttribute(this.NOTICE_COUNT_NAME, count);
		} catch (HasNotLoginException e) {
			session.setAttribute(this.NOTICE_COUNT_NAME, count);
		}
		MyLogger.info("\n\n\n登录成功后测试取出count:"+ count);
	}

}