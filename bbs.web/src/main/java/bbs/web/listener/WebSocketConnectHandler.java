package bbs.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import bbs.helper.utils.MyLogger;
import bbs.security.service.BbsSecurityService;
import bbs.security.utils.IAuthenticationFacade;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherFactory;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;

@Component
public class WebSocketConnectHandler implements ApplicationListener<SessionConnectedEvent> {
	
	private SubscriptionMatcherHolder subscriptionMatcherHolder;
	
	private SubscriptionMatcherFactory matcherFactory;
	
	private IAuthenticationFacade authenticationFacade;
	
	private BbsSecurityService bbsSecurityService;

	@Autowired
	public WebSocketConnectHandler(SubscriptionMatcherHolder subscriptionMatcherHolder,
			SubscriptionMatcherFactory matcherFactory, IAuthenticationFacade authenticationFacade,
			BbsSecurityService bbsSecurityService) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
		this.matcherFactory = matcherFactory;
		this.authenticationFacade = authenticationFacade;
		this.bbsSecurityService = bbsSecurityService;
	}



	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		// TODO Auto-generated method stub
		MyLogger.info("\n\n\n建立连接之前，检测登录情况\n\n");   
		try {
			String username = event.getUser().getName();
			Long uid = bbsSecurityService.getUserPrincipal(username).getId();
			MyLogger.info("\n\n\n建立连接, 创建相应的subscriptionMatcher\n\n");
			subscriptionMatcherHolder.put(username, matcherFactory.createSubscriptionMatcher(username, uid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
