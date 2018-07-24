package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import bbs.helper.utils.MyLogger;
import bbs.security.utils.IAuthenticationFacade;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;

@Component
public class WebSocketDisconnetHandler implements ApplicationListener<SessionDisconnectEvent> {
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;
	
	private IAuthenticationFacade authenticationFacade;

	@Autowired
	public WebSocketDisconnetHandler(SubscriptionMatcherHolder subscriptionMatcherHolder,
			IAuthenticationFacade authenticationFacade) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
		this.authenticationFacade = authenticationFacade;
	}

	@Override
	public void onApplicationEvent(SessionDisconnectEvent e) {
		// TODO Auto-generated method stub
			String username = authenticationFacade.getUsername();
			MyLogger.info("\n\n\n断开连接\n\n\n");
			subscriptionMatcherHolder.remove(username);
	}

}
