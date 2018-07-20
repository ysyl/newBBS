package bbs.subscriptionsystem.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.notice.service.NoticeResultMap;
import bbs.subscriptionsystem.notice.service.NoticeService;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;
import bbs.usercenter.service.UserCenterService;

@Transactional
@Rollback
public class BeFollowedTest extends BaseTest {
	private static final Logger logger  = MyLogger.getLogger(BeFollowedTest.class);
	
	@Autowired
	@Qualifier("mySubscriptionManager")
	SubscriptionManager subManager;
	
	@Autowired
	UserCenterService userCenterService;
	
	@Autowired
	NoticeService noticeService;
	
	@Test
	public void testBeFollowed() {
		logger.info("\n 先获取一个用户，再验证这个用户是否用被关注订阅，然后获取另一个用户，让这个用户去关注前一个用户，"
				+ "再获取NoticeResultMap，检测beFollowed notice的size，和其中notice的类型, 以及关注的对象");
		Long verricktId = 1L;
		long zhouId = 2L;
		
		assertNotNull(subManager);
		
		List<BaseSubscription<?>> subscriptionList = subManager.getAllSubscriptions(verricktId);
		
		assertEquals(1, subscriptionList.size());
		
		logger.info("\n zhou 收藏 verrickt");
		userCenterService.collectUser(zhouId, verricktId);
		
		NoticeResultMap noticeResultMap = noticeService.getNoticeByUid(verricktId);
		
		assertEquals(1, noticeResultMap.getBeFollowed().size());
		
		noticeResultMap = noticeService.getNoticeByUid(verricktId);
		
		assertEquals(0, noticeResultMap.getBeFollowed().size());
		
		userCenterService.collectUser(3L, verricktId);
		userCenterService.collectUser(4L, verricktId);
		userCenterService.collectUser(5L, verricktId);

		noticeResultMap = noticeService.getNoticeByUid(verricktId);

		assertEquals(3, noticeResultMap.getBeFollowed().size());
	}
}
