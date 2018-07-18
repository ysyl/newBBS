package bbs.web.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import bbs.forum.form.PubPostForm;
import bbs.forum.service.BBSService;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.usercenter.service.UserCenterService;
import bbs.web.listener.NoticeInitializer;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Transactional
@Rollback
@WebAppConfiguration(value = "/src/main/webapp")
@ActiveProfiles("dev")
public class MockMvcTest extends BaseTest {

	@Autowired
	WebApplicationContext wac;
	@Autowired
	SubscribedActionService subService;
	@Autowired
	BBSService bbsService;
	@Autowired
	UserCenterService userCenterService;
	@Autowired
	UserDetailsService userDetailsService;

	private MockMvc mvc;
	private MockHttpSession mockSession;

	private static final Logger logger = Logger.getLogger(MockMvcTest.class);

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()) // SecurityMockMvcConfigurers.springSecurity()
																				// will perform all of the initial setup
																				// we need to integrate Spring Security
																				// with Spring MVC Test
				.build();
		this.mockSession = new MockHttpSession();
	}

	@Test
	// @WithUserDetails(value = "varrickt",
	// userDetailsServiceBeanName="userDetailsServiceImp")
	public void testLogin() throws Exception {
		UserDetails ud = this.uds.loadUserByUsername("verrickt");
		mvc.perform(get("/").with(user(ud)));
		mvc.perform(logout()).andExpect(unauthenticated());

		mvc.perform(formLogin().user("123").password("invalidpass")).andExpect(unauthenticated());

		mvc.perform(formLogin().user("verrickt").password("123456")).andExpect(authenticated());
	}

	@Test
	public void testActionPull() throws Exception {
		// 预先订阅，然后插入数据
		ObjectMapper om = new ObjectMapper();
		Long luckyUserId = 1L;
		Long luckyTopicId = 1L;
		UserDetails userDetails = userDetailsService.loadUserByUsername("verrickt");
		userCenterService.collectTopic(luckyUserId, luckyTopicId);
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent("新内容");
		logger.info("\n\n插入数据");
		pubPostForm.setReplyPostId(null);
		bbsService.savePost(luckyUserId, luckyTopicId, pubPostForm);
		MvcResult result = mvc.perform(get("/action/test").with(user(userDetails)).param("userId", "1"))
				.andExpect(status().is2xxSuccessful()).andReturn();
		String resultString = result.getResponse().getContentAsString();
		List<BaseAction> actions = om.readValue(resultString, ArrayList.class);
		logger.info("\n\ntest");
		Assert.assertEquals(1, actions.size());
		logger.info(result.getResponse());
		logger.info("\n\n\nresult String" + resultString + "\n\n\n");
	}

	// 测试登录后通知初始化器
	public void testNoticeInit() throws Exception {
		//预先订阅，然后插入数据
				ObjectMapper om = new ObjectMapper();
				Long luckyUserId = 1L;
				Long luckyTopicId = 1L;
				UserDetails userDetails = userDetailsService.loadUserByUsername("verrickt");
				userCenterService.collectTopic(luckyUserId, luckyTopicId);
				PubPostForm pubPostForm = new PubPostForm();
				pubPostForm.setContent("新内容");
				logger.info("\n\n插入数据");
				pubPostForm.setReplyPostId(null);
				bbsService.savePost(luckyUserId, luckyTopicId, pubPostForm);
		Object count =  this.mockSession
				.getAttribute(
						NoticeInitializer.NOTICE_COUNT_NAME);
		logger.info("\n\n\nint" + count);
		assertEquals(1,(int) count);
		logger.info("\n\n\n初始化测试结束");
	}

}
