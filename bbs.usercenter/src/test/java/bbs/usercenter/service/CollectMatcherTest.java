package bbs.usercenter.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.usercenter.util.CollectMatcher;

@Transactional
@Rollback
public class CollectMatcherTest extends BaseTest {
	
	@Autowired
	UserCenterService userCenterService;

	@Test
	public void testCollectMatcher() {
		Long VERRICKT_ID = 1L;
		
		userCenterService.collectCommody(VERRICKT_ID, 1L);
		
		List<Long> testCommodyIdList = Arrays.asList(1L, 2L, 3L);
		
		Map<Long, Boolean> resultMap = userCenterService.isCollectedCommodyList(VERRICKT_ID, testCommodyIdList);
		
		MyLogger.infoln(this.getClass(), "检查商品收藏" + resultMap);
		assertTrue(resultMap.get(1L));
	}
}
