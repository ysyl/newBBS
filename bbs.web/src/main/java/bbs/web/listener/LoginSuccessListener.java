package bbs.web.listener;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.User;
import bbs.forum.service.BBSService;
import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;
import bbs.usercenter.util.CollectMatcher;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
	
	private CollectMatcher collectMatcher;
	
	private SecurityHelper securityHelper;
	
	private HttpSession session;
	
	private BBSService bbsService;
	
	@Autowired
	public LoginSuccessListener(CollectMatcher collectMatcher, SecurityHelper securityHelper, HttpSession session,
			BBSService bbsService) {
		super();
		this.collectMatcher = collectMatcher;
		this.securityHelper = securityHelper;
		this.session = session;
		this.bbsService = bbsService;
	}

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		MyLogger.info("\n\n\n登录成功\n\n\n");
		collectMatcher.freshCollections(securityHelper.getCurrentUserId());
		this.addUserToSession();
	}
	
	private void addUserToSession() {
		Long uid = securityHelper.getCurrentUserId();
		User user = bbsService.getUser(uid);
		session.setAttribute("user", user);
	}

}
