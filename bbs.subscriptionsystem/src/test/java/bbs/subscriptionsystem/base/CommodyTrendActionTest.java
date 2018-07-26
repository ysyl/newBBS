package bbs.subscriptionsystem.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.service.ShopService;
import bbs.subscriptionsystem.notice.entity.CommodyCommentNotice;
import bbs.subscriptionsystem.notice.entity.ShopTrendNotice;
import bbs.subscriptionsystem.notice.service.NoticeService;
import bbs.subscriptionsystem.service.SubscriptionService;

@Transactional
@Rollback
public class CommodyTrendActionTest extends BaseTest {
	
	@Autowired
	SubscriptionService subService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ShopService shopService;
	
	private static final Logger logger = MyLogger.getLogger(CommodyTrendActionTest.class);
	
	@Test
	public void testSubscribe() {
		//先让用户收藏一个商品，再让另一个用户在这个商品下发表评论，再取第一个用户的通知
		Long VERRICKT_ID = 1L;
		Long ZHOU_ID = 2L;
		Long JAY_ID = 3L;
		Long COMMODY_ID = 1L;
		MyLogger.info("\n 订阅一个商品");
		subService.subscribeCommody(VERRICKT_ID, COMMODY_ID);
		MyLogger.info("\n 在商品下发表评论");
		PubPrimaryCommodyCommentForm primaryCommentForm = new PubPrimaryCommodyCommentForm();
		primaryCommentForm.setContent("primaryComment content");
		
		shopService.savePrimaryComment(ZHOU_ID, COMMODY_ID, primaryCommentForm);
		
		MyLogger.info("\n 获取通知");
		List<CommodyCommentNotice> noticeList1 = (List<CommodyCommentNotice>) noticeService.getNoticeByUid(VERRICKT_ID).getShop(); 
		assertEquals(1, noticeList1.size());
		for(ShopTrendNotice sNotice : noticeList1) {
			boolean isCommentNotice = sNotice instanceof CommodyCommentNotice;
			assertTrue(isCommentNotice);
			String content = ((CommodyCommentNotice) sNotice).getComment().getContent();
			assertEquals("primaryComment content", content);
		}
	}
	@Test
	public void testCommentAction() {
		Long VERRICKT_ID = 1L;
		Long ZHOU_ID = 2L;
		Long JAY_ID = 3L;
		Long COMMODY_ID = 1L;	
		

		//先让用户发布一个商品，再让另一个用户在这个商品下发表评论，取第一个用户的通知
		MyLogger.info("\n 发布一个商品");
		int gameClassId = 1;
		PubCommodyForm commodyForm = new PubCommodyForm();
		commodyForm.setCommodyClassificationId(gameClassId);
		commodyForm.setDescription("测试商品");
		commodyForm.setTitle("测试标题");
		commodyForm.setImgFile(null);
		
		long newCommodyId = shopService.saveCommody(VERRICKT_ID, commodyForm);
		
		MyLogger.info("\n 在商品下发表评论");
		PubPrimaryCommodyCommentForm primaryCommentForm1 = new PubPrimaryCommodyCommentForm();
		primaryCommentForm1.setContent("new commody primaryComment content");
		
		long newCommodyCommentId = shopService.savePrimaryComment(ZHOU_ID, newCommodyId, primaryCommentForm1);

		MyLogger.info("\n 获取通知");
		List<? extends ShopTrendNotice> noticeList2 = noticeService.getNoticeByUid(VERRICKT_ID).getShop(); 
		assertEquals(1, noticeList2.size());
		for(ShopTrendNotice sNotice : noticeList2) {
			boolean isCommentNotice = sNotice instanceof CommodyCommentNotice;
			assertTrue(isCommentNotice);
			String content = ((CommodyCommentNotice) sNotice).getComment().getContent();
			assertEquals("new commody primaryComment content", content);
			assertEquals(ZHOU_ID, ((CommodyCommentNotice) sNotice).getUser().getId());
		}


		
		//接上条，再让另一个用户在这条评论下发表楼中楼回复，取第一个用户的通知
		MyLogger.info("\n 发表楼中楼回复");
		PubReplyCommodyCommentForm replyCommentForm1 = new PubReplyCommodyCommentForm();
		replyCommentForm1.setBelongPrimaryCommentId(newCommodyCommentId);
		replyCommentForm1.setReplyTargetCommentId(null);
		replyCommentForm1.setContent("reply commody comment");
		
		long replyCommentId = shopService.saveReplyComment(JAY_ID, newCommodyId, replyCommentForm1);
		MyLogger.info("\n 获取通知");
		List<CommodyCommentNotice> notices = (List<CommodyCommentNotice>) noticeService.getNoticeByUid(ZHOU_ID).getShop();
		assertEquals(1, notices.size());
		
		List<CommodyCommentNotice> notices1 = (List<CommodyCommentNotice>) noticeService.getNoticeByUid(VERRICKT_ID).getShop();
		assertEquals(1, notices1.size());
		
		
		//接上条测试， 再让另一个用户回复楼中楼回复，取评论者的通知和第一个楼中楼回复者的通知
		MyLogger.info("\n 回复楼中楼回复");
		PubReplyCommodyCommentForm replyCommentForm2 = new PubReplyCommodyCommentForm();
		replyCommentForm1.setBelongPrimaryCommentId(newCommodyCommentId);
		replyCommentForm1.setReplyTargetCommentId(replyCommentId);
		replyCommentForm1.setContent("reply reply commody comment");

		long replyCommentId2 = shopService.saveReplyComment(ZHOU_ID, newCommodyId, replyCommentForm1);

		MyLogger.info("\n 获取通知");

		List<CommodyCommentNotice> notices2 = (List<CommodyCommentNotice>) noticeService.getNoticeByUid(ZHOU_ID).getShop();
		assertEquals(1, notices2.size());
		assertEquals("reply reply commody comment", notices2.get(0).getComment().getContent());
	}
}
