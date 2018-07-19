package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import bbs.security.helper.SecurityHelper;
import bbs.usercenter.util.CollectMatcher;

@Component
public class CollectMatchFresherListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
	
	private CollectMatcher collectMatcher;
	
	private SecurityHelper helper;
	
	@Autowired
	public CollectMatchFresherListener(CollectMatcher collectMatcher, SecurityHelper helper) {
		super();
		this.collectMatcher = collectMatcher;
		this.helper = helper;
	}


	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		collectMatcher.freshCollections(helper.getCurrentUserId());
	}

}
