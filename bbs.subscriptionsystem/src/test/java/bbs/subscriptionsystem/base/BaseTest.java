package bbs.subscriptionsystem.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations= {"classpath:subscriptionsystemappcontext.xml"})
@Transactional
@Rollback
@ActiveProfiles("dev")
public class BaseTest {

	@Test
	public void test() {}
}
