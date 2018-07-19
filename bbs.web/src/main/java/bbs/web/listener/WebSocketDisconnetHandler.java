package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;

@Component
public class WebSocketDisconnetHandler implements ApplicationListener<SessionDisconnectEvent> {
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;

	@Autowired
	public WebSocketDisconnetHandler(SubscriptionMatcherHolder subscriptionMatcherHolder) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
	}

	@Override
	public void onApplicationEvent(SessionDisconnectEvent e) {
		// TODO Auto-generated method stub
		String username = e.getUser().getName();
		MyLogger.info("\n\n\n断开连接\n\n\n");
		subscriptionMatcherHolder.remove(username);
	}

}
