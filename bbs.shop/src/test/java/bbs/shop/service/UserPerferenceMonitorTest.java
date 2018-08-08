package bbs.shop.service;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.shop.entity.UserPerference;


@Transactional
@Rollback
public class UserPerferenceMonitorTest extends BaseTest {
	
	@Autowired
	ShopService shopService;
	
	private static final Logger logger = MyLogger.getLogger(UserPerferenceMonitorTest.class);

	@Test
	public void testUserPerference() {
		MyLogger.infoln(this.getClass(), "让一个用户获取商品，然后log他的兴趣爱好");
		long VERRICKT_ID = 1L;
		long sampleCommodyId = 1L;
		shopService.getCommody(VERRICKT_ID, sampleCommodyId);
		
		UserPerference up = shopService.getUserPerference(VERRICKT_ID);
		logger.info("\n getUserPerference "+ up.getKeywordStatisticList());
		logger.info("\n getUserPerference size: "+ up.getKeywordStatisticList().size());

		logger.info("\n 再次获取商品，logger 频次 ");
		shopService.getCommody(VERRICKT_ID, sampleCommodyId);
		UserPerference up2 = shopService.getUserPerference(VERRICKT_ID);
		logger.info("\n getUserPerference "+ up2.getKeywordStatisticList());
		
		MyLogger.infoln(this.getClass(), "让匿名用户获取商品");
		shopService.getCommody(null, sampleCommodyId);
	}
	
	@Test 
	public void testSearchMonitor() {
		MyLogger.infoln(this.getClass(), "让一个用户搜索，然后log他的兴趣爱好");
		long VERRICKT_ID = 1L;
		String keywordContent = "测试用的关键词";
		
		shopService.searchByKeyword(VERRICKT_ID, keywordContent);
		UserPerference up = shopService.getUserPerference(VERRICKT_ID);
		assertNotNull(up);
		MyLogger.infoln(this.getClass(), "获取从搜索中提取的关键词： " + up.getKeywordStatisticList());

	}
}
