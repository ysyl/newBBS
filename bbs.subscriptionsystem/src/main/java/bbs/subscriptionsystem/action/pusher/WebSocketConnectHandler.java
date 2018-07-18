package bbs.subscriptionsystem.action.pusher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import bbs.helper.service.HelperService;
import bbs.helper.utils.MyLogger;

@Component
public class WebSocketConnectHandler implements ApplicationListener<SessionConnectedEvent> {
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;
	
	private SubscriptionMatcherFactory matcherFactory;

	@Autowired
	public WebSocketConnectHandler(SubscriptionMatcherHolder subscriptionMatcherHolder,
			SubscriptionMatcherFactory matcherFactory) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
		this.matcherFactory = matcherFactory;
	}

	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		// TODO Auto-generated method stub
		String username = event.getUser().getName();
		MyLogger.info("\n\n\n建立连接, 创建相应的subscriptionMatcher\n\n");
		subscriptionMatcherHolder.put(username, matcherFactory.createSubscriptionMatcher(username));
	}

}
