package bbs.shop.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.shop.DTO.BaseCommodyComment;
import bbs.shop.DTO.Commody;
import bbs.shop.DTO.PrimaryCommodyComment;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.UpdateCommodyForm;

@Transactional
@Rollback
public class ShopServiceTest extends BaseTest {
	
	@Autowired
	ShopService shopService;
	
	private static final Logger logger = MyLogger.getLogger(ShopServiceTest.class);
	
	private long pubCommodyWithoutImg(long uid, String title, String description, int classificationId) {
		PubCommodyForm pubCommodyForm = new PubCommodyForm();
		pubCommodyForm.setDescription(description);
		pubCommodyForm.setTitle(title);
		pubCommodyForm.setCommodyClassificationId(classificationId);
		long commodyId =  shopService.saveCommody(uid, pubCommodyForm);
		return commodyId;
	}

	@Test
	public void testAddCommodyAndComment() {
		MyLogger.infoln("测试商品的添加和更新");
		Long VERRICKT_ID = 1L;
		int GAME_CLASS_ID = 1;
		int MOVIE_CLASS_ID = 2;
		
		long commodyId = this.pubCommodyWithoutImg(VERRICKT_ID, "标题", "描述", 1);
		
		Commody newCommody = shopService.getCommody(commodyId);
		
		assertEquals("描述",newCommody.getDescription());
		assertEquals("标题", newCommody.getTitle());
		assertEquals(VERRICKT_ID, newCommody.getUser().getId());
	
		UpdateCommodyForm updateCommodyForm = new UpdateCommodyForm();
		updateCommodyForm.setDescription("新描述");
		updateCommodyForm.setTitle("新标题");
		updateCommodyForm.setClassificationId(GAME_CLASS_ID);
		
		shopService.updateCommody(commodyId, updateCommodyForm);
		
		newCommody = shopService.getCommody(commodyId);
		
		assertEquals("新描述", newCommody.getDescription());
		assertEquals("新标题", newCommody.getTitle());
		
		//测试添加评论
		PubPrimaryCommodyCommentForm commentForm = new PubPrimaryCommodyCommentForm();
		commentForm.setContent("评论内容");
		
		long commentId = shopService.savePrimaryComment(VERRICKT_ID, commodyId ,commentForm);
		
		BaseCommodyComment newComment = shopService.getCommodyCommentByCommentId(commentId);
		//测试评论内容
		assertEquals("评论内容", newComment.getContent());
		//测试从评论中获取的商品信息
		assertEquals(commodyId, newComment.getCommody().getId());
		//测试从评论中获取的用户信息
		assertEquals("verrickt", newComment.getUser().getNickname());
		//打印评论的发布时间
		logger.info("\n " + newComment.getPubTime());
	}
	
	@Test
	public void testAddCommodyComment() {
		//测试获取主要回复
		Long commodyId = 1L;
		List<PrimaryCommodyComment> primaryCommodyComments = shopService.getAllPrimaryCommentByCommodyId(commodyId);
		
		//初始数据中包含两个主要回复，分别包含3个
		PrimaryCommodyComment firstPrimaryComment = primaryCommodyComments.get(0);
		assertEquals(1, firstPrimaryComment.getCommody().getId());
		assertEquals(3, firstPrimaryComment.getReplyComments().size());
		
		PrimaryCommodyComment secendryPrimaryComment = primaryCommodyComments.get(1);
		assertEquals(1, secendryPrimaryComment.getCommody().getId());
		assertEquals(0, secendryPrimaryComment.getReplyComments().size());
	}
	
	@Test
	public void testPubPrimaryCommentAndReplyComment() {
		logger.info("\n 先发布基本评论");
		Long VERRICKT_ID = 1l;
		PubPrimaryCommodyCommentForm primaryCommentForm = new PubPrimaryCommodyCommentForm();
		primaryCommentForm.setContent("1L 测试基本评论");
		long commodyId = 1l;
		
		long primaryCommentId = shopService.savePrimaryComment(VERRICKT_ID, commodyId ,primaryCommentForm);

		logger.info("\n 再发布楼中楼评论"); 
		PubReplyCommodyCommentForm replyCommentForm1 = new PubReplyCommodyCommentForm();
		replyCommentForm1.setReplyTargetCommentId(null);
		replyCommentForm1.setBelongPrimaryCommentId(primaryCommentId);
		replyCommentForm1.setContent("测试楼中楼");
		
		long replyCommentForm1Id = shopService.saveReplyComment(VERRICKT_ID, commodyId, replyCommentForm1);
		
		logger.info("\n 测试");
		PrimaryCommodyComment pcc = (PrimaryCommodyComment)shopService.getCommodyCommentByCommentId(primaryCommentId);
		assertEquals("1L 测试基本评论", pcc.getContent());
		assertEquals(1, pcc.getReplyComments().size());
		assertEquals("测试楼中楼", pcc.getReplyComments().get(0).getContent());

	}
}
