package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherFactory;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;

@Component
public class WebSocketConnectHandler implements ApplicationListener<SessionConnectedEvent> {
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;
	
	private SubscriptionMatcherFactory matcherFactory;
	
	private SecurityHelper securityHelper;

	@Autowired
	public WebSocketConnectHandler(SubscriptionMatcherHolder subscriptionMatcherHolder,
			SubscriptionMatcherFactory matcherFactory, SecurityHelper securityHelper) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
		this.matcherFactory = matcherFactory;
		this.securityHelper = securityHelper;
	}

	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		// TODO Auto-generated method stub
		String username = event.getUser().getName();
		MyLogger.info("\n\n\n建立连接, 创建相应的subscriptionMatcher\n\n");
		subscriptionMatcherHolder.put(username, matcherFactory.createSubscriptionMatcher(username));
	}

}
