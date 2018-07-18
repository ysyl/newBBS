package bbs.web.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import bbs.forum.DAO.TopicDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration( locations = {"classpath:applicationContext.xml"})
@ActiveProfiles("dev")
public class BaseTest {
	
	private static final Logger logger = Logger.getLogger(BaseTest.class);
	
	@Autowired
	TopicDAO topicDAO;
	
	@Autowired
	UserDetailsService uds;

	@Test
	public void test() {
		logger.info("baseTest");
	}
}
