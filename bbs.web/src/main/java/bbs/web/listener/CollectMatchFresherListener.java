package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.usercenter.util.CollectMatcher;

public class CollectMatchFresherListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
	
	private CollectMatcher collectMatcher;

	@Autowired
	public CollectMatchFresherListener(CollectMatcher collectMatcher) {
		super();
		this.collectMatcher = collectMatcher;
	}


	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
	}

}
