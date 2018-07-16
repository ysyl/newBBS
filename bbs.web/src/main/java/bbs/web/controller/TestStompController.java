package bbs.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherFactory;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;
//测试类
@Controller
public class TestStompController {

	private SubscriptionMatcherHolder matcherHolder;
	
	private SubscriptionMatcherFactory matcherFactory;
	
	private SimpMessagingTemplate template;

	@Autowired
	public TestStompController(SubscriptionMatcherHolder matcherHolder, SubscriptionMatcherFactory matcherFactory,
			SimpMessagingTemplate template) {
		super();
		this.matcherHolder = matcherHolder;
		this.matcherFactory = matcherFactory;
		this.template = template;
	}

	@MessageMapping("/testBroad")
	public String test(Principal principal) {
		System.out.println(principal.getName() + "\n\n\n\n\n");
		this.template.convertAndSend("/topic/testBroad", "testBroad");
		return "testBroad";
	}
	
	@MessageMapping("testSendToUser")
	@SendToUser("/topic/testSendToUser")
	public String testSendToUser() {
		System.out.println("testSendToUser\n\n\n");
		return "testSendToUser";
	}
	
	@MessageMapping("/testTemplateSendToUser")
	public void testTemplateSendToUser(Principal principal) {
		System.out.println("testTemplateSendToUser\n\n\n");
		this.template.convertAndSendToUser(principal.getName(), "/topic/testTemplateSendToUser", "testTemplateSendToUser");
	}
	
}
