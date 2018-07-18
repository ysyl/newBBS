package bbs.web.listener;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;

public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
	
	private HttpSession httpSession;
	
	private NoticeInitializer noticeInitializer;
	
	@Autowired
	public LoginSuccessListener(HttpSession httpSession, NoticeInitializer noticeInitializer) {
		super();
		this.httpSession = httpSession;
		this.noticeInitializer = noticeInitializer;
	}

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		MyLogger.info("\n\n\n登录成功\n\n\n");
		this.noticeInitializer.initNoticeStatus(httpSession);
	}

}
