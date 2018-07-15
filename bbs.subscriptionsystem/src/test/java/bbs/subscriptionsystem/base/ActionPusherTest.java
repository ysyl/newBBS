package bbs.subscriptionsystem.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.JsonPathExpectationsHelper;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bbs.forum.DTO.User;
import bbs.forum.form.PubPostForm;
import bbs.forum.service.BBSService;
import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.service.UserCenterService;

import org.junit.Before;
import org.junit.Test;

public class ActionPusherTest extends BaseTest {
	
	private static final Logger logger = Logger.getLogger(ActionPusherTest.class.getName());
	
	@Autowired
	BBSService bbsService;
	
	@Autowired
	SubscribedActionService subService;
	
	@Autowired
	UserCenterService userCenterService;
	
	@Autowired
	@Qualifier("clientInboundChannel")
	AbstractSubscribableChannel cliendInBoundChannel;

	@Autowired
	@Qualifier("clientOutboundChannel")
	AbstractSubscribableChannel cliendOutBoundChannel;
	
	@Autowired
	@Qualifier("brokerChannel")
	AbstractSubscribableChannel brokerChannel;
	
	private TestChannelIntercepter cliendOutBoundChannelIntercepter;
	
	private TestChannelIntercepter brokerChannelIntercepter;
	
	private final String subscribeActionPushDesitination = "/app/action";
	
	private final String testSubscribeDesitination = "/app/testaction";
	
	@Before
	public void setup() {
		this.cliendOutBoundChannelIntercepter = new TestChannelIntercepter();
		this.brokerChannelIntercepter = new TestChannelIntercepter();
		
		this.cliendOutBoundChannel.addInterceptor(this.cliendOutBoundChannelIntercepter);
		this.brokerChannel.addInterceptor(this.brokerChannelIntercepter);
	}
	
	private Message<byte[]> createMessage(StompCommand stompCommand, String subscriptionId, String sessionId, String username, 
			String destination) {
		StompHeaderAccessor headers = StompHeaderAccessor.create(stompCommand);
		if (StompCommand.SUBSCRIBE.equals(stompCommand)) {
			headers.setSubscriptionId(subscriptionId);
		}
		headers.setDestination(destination);
		headers.setSessionId(sessionId);
		headers.setUser(new Principal() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return username;
			}
			
		});
		headers.setSessionAttributes(new HashMap<>());
		Message<byte[]> message = MessageBuilder.createMessage(new byte[0], headers.getMessageHeaders());
		return message;
	}
	
	@Test
	public void pureStompTest() throws InterruptedException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
		headers.setSubscriptionId("0");
		headers.setDestination(testSubscribeDesitination);
		headers.setSessionId("0");
		headers.setUser(new Principal() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "zhou";
			}
			
		});
		headers.setSessionAttributes(new HashMap<>());
		Message<byte[]> message = MessageBuilder.createMessage(new byte[0], headers.getMessageHeaders());
		this.cliendOutBoundChannelIntercepter.setIncludeDestinationPatterns(testSubscribeDesitination);
		this.cliendInBoundChannel.send(message);
	
		Message<?> reply = this.cliendOutBoundChannelIntercepter.awaitMessage(5);
		assertNotNull(reply);
		String payload = new String((byte[]) reply.getPayload(), Charset.forName("UTF-8"));
		assertEquals("testComplete", payload);
		
		//测试订阅广播
		logger.info("测试订阅开始");
		Message<?> message2 = this.createMessage(StompCommand.SUBSCRIBE,"3", "3", "verrickt", "/user/topic/test");
		this.cliendOutBoundChannelIntercepter.setIncludeDestinationPatterns("/user/topic/test");
		this.brokerChannelIntercepter.setIncludeDestinationPatterns("/user/**");
		this.cliendInBoundChannel.send(message2);
		
		logger.info("使用@SendToUser发送定点推送");
		Message<?> message233 = this.createMessage(StompCommand.MESSAGE, "4", "6", "veickt", "/app/testUserTopic");
		this.cliendInBoundChannel.send(message233);
		Message<?> reply3 = this.brokerChannelIntercepter.awaitMessage(5);
		System.out.println(reply3);
		assertNotNull(reply3);
		String replyContent = new String((byte[]) reply3.getPayload(), Charset.forName("UTF-8"));
		assertEquals("testSendToUser", replyContent);
		logger.info("测试订阅结束");
		
		//测试JSON转换
		logger.info("测试json转换"
				+ "");
		StompHeaderAccessor headers1 = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
		headers1.setSubscriptionId("1");
		headers1.setDestination("/app/testJson");
		headers1.setSessionId("1");
		headers1.setUser(new Principal() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "zhou";
			}
			
		});
		headers1.setSessionAttributes(new HashMap<>());
		Map<String, String> argMap = new HashMap<>();
		argMap.put("key", "value");
		message = MessageBuilder.createMessage(objectMapper.writeValueAsBytes(argMap), headers1.getMessageHeaders());
		this.cliendOutBoundChannelIntercepter.setIncludeDestinationPatterns("/app/testJson");
		this.cliendInBoundChannel.send(message);
		Message<?> reply2 = this.cliendOutBoundChannelIntercepter.awaitMessage(2);
		System.out.println(reply2);
		assertNotNull(reply2);
		
		String json = new String((byte[]) reply2.getPayload(), Charset.forName("UTF-8"));
		new JsonPathExpectationsHelper("$.testKey").assertValue(json, "testValue");
		

	}
	
	public void preSubscribe() throws RepetitiveCollectException {
		logger.info("\n\n\ntestGetAction\n\n\n");
		//首先用户verrickt先订阅一个主题，然后选取另一个用户zhou对这个主题发布回复，然后stomp获取回复。	
		logger.info("首先用户verrickt订阅一个主题");
		User verrickt = bbsService.getUser(1L);
		
		logger.info("用户verrickt发布订阅,订阅所有action");
		Long luckTopicId = 1L;
		userCenterService.collectTopic(verrickt.getId(), luckTopicId);
	}

	public void testGetAction() throws InterruptedException {
		logger.info("此前已向数据库预置了订阅信息");
		logger.info("用户verrickt 进行websocket订阅");
		StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
		headers.setSubscriptionId("0");
		headers.setDestination(subscribeActionPushDesitination);
		headers.setSessionId("0");
		headers.setUser(new Principal() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "verrickt";
			}
			
		});
		headers.setSessionAttributes(new HashMap<>());
		Message<byte[]> message = MessageBuilder.createMessage(new byte[0], headers.getMessageHeaders());
		
		this.cliendOutBoundChannelIntercepter.setIncludeDestinationPatterns(subscribeActionPushDesitination);
		this.cliendInBoundChannel.send(message);
		//由于是异步，所以等待一段时间
		Thread.sleep(1000);
		
		//用户zhou在verrickt订阅的主题发布回复
		logger.info("用户zhou在verrickt订阅的主题发布回复");
		Long zhouId = 2L;
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent("test websockt action");
		pubPostForm.setReplyPostId(null);
		bbsService.savePost(zhouId, 1L, pubPostForm);
		
		Message<?> reply = this.cliendOutBoundChannelIntercepter.awaitMessage(5);
//		System.out.println(new String((byte[]) reply.getPayload(), Charset.forName("utf-8")));
		assertNotNull(reply);
//		
//		StompHeaderAccessor replyHeaders = StompHeaderAccessor.wrap(reply);
//		assertEquals("0", replyHeaders.getSessionId());
//		assertEquals("0", replyHeaders.getSubscriptionId());
//		assertEquals("/app/action", replyHeaders.getDestination());
		
	}
}
