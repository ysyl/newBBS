package bbs.subscriptionsystem.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import bbs.forum.DAO.TopicDAO;
import bbs.forum.form.PubTopicForm;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherFactory;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcher;

@Controller
@Profile("dev")
public class SubscribeActionPushController {

	private SubscriptionMatcherHolder subscriptionMatcherHolder;
	
	
	private SubscriptionMatcherFactory subscriptionMatcherFactory;
	
	private TopicDAO topicDAO;
	
	private SimpMessagingTemplate template;
	
	@Autowired
	public SubscribeActionPushController(SubscriptionMatcherHolder subscriptionMatcherHolder,
			SubscriptionMatcherFactory subscriptionMatcherFactory, TopicDAO topicDAO, SimpMessagingTemplate template) {
		super();
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
		this.subscriptionMatcherFactory = subscriptionMatcherFactory;
		this.topicDAO = topicDAO;
		this.template = template;
	}

	@SubscribeMapping("/action")
	public void handleSubscribeAction(Principal principal) {
		String username = principal.getName(); 
		subscriptionMatcherHolder.put(username, subscriptionMatcherFactory.createSubscriptionMatcher(username));
		MyLogger.info(subscriptionMatcherHolder.size());
	}
	
	@SubscribeMapping("/testaction")
	public String testSubscribe(Principal principal) {
		String username = principal.getName();
		return "testComplete";
	}
	
	@SubscribeMapping("/testJson")
	public Map<String, String> testJson(@RequestBody Map<String, String> argMap, Principal principal) {
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("testKey", "testValue");
		return resultMap;
	}
	
	@SubscribeMapping("/test")
	public String testSub() {
		MyLogger.info("testSub");
		return "testSub";
	}
	
	@MessageMapping("/testUserTopic")
	@SendToUser("/topic/test")
	public String testUserTopic(Principal p) {
		MyLogger.info("enter testUserTopic");
		MyLogger.info("p.getUsername: " + p.getName());
		return "testSendToUser";
	}
	
	@MessageMapping("/testTemplate")
	public void testTemplate() {
		MyLogger.info("enter /testTemplate");
		this.template.convertAndSendToUser("verrickt", "/topic/test", "testTemplate");
	}
	
	@MessageMapping("actionIntegrate")
	public String testIntegrateMessage() {
		return "testIntegrateMessage";
	}
}
