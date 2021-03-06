package bbs.usercenter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Post;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.shop.service.ShopService;
import bbs.usercenter.collection.DAO.entity.CommodyCollection;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.exception.RepetitiveCollectException;

@Transactional
@Rollback
public class UserServiceTest extends BaseTest {

	@Autowired
	UserCenterService userCenterService;
	
	@Autowired
	BbsService bbsService;
	
	
	@Autowired
	ShopService shopService;
	
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	
	private static PageParam pageParam = new PageParam(0, 20);
	
	@Test
	public void testCollection() throws RepetitiveCollectException {
		logger.info("\n\n\n测试开始\n\n\n");
		
		logger.info("收藏forum");
		long uid = 2L;
		Integer forumId = 1;
		userCenterService.collectForum(uid, forumId);
		
		ForumCollection fcollection = userCenterService.getAllForumCollectionByUserId(uid, pageParam).get(0);
		assertEquals(forumId, fcollection.getForum().getId());
		
		logger.info("收藏topic");
		long topicId = 1;
		userCenterService.collectTopic(uid, topicId);
		
		TopicCollection tCollection = userCenterService.getAllTopicCollectionByUserId(uid, pageParam).get(0);
		assertNotNull(tCollection);
		assertEquals((Long) topicId, tCollection.getTopic().getId());
		
		logger.info("收藏post");
		Long postId = 1L;
		userCenterService.collectPost(uid, postId);
		
		PostCollection pCollection = userCenterService.getAllPostCollectionByUserId(uid, pageParam).get(0);
		
		assertEquals(postId, pCollection.getPost().getId());
		
		logger.info("收藏Following");
		Long followingId = 3L;
		userCenterService.collectUser(uid, followingId);
		FollowingCollection foCollection = userCenterService
				.getAllFollowingCollectionByUserId(uid, pageParam).get(0);
				
		assertEquals(followingId, foCollection.getFollowing().getId());
		
		logger.info("收藏Commody");
		long commodyId = 1l;
		long verricktId = 1l;
		userCenterService.collectCommody(verricktId, commodyId);
		
		CommodyCollection cCollection = userCenterService.getAllCommodyCollectionByUserId(verricktId).get(0);
		
		assertEquals(commodyId, cCollection.getCommody().getId());
		assertEquals(verricktId, (long)cCollection.getUser().getId());
		

		logger.info("获取forum收藏");
		logger.info("获取topic收藏");
		logger.info("获取post收藏");
		logger.info("获取following收藏");
		
		logger.info("删除收藏");
		userCenterService.uncollectPost(uid, postId);
		List<Long> postIdList = new ArrayList<>(Arrays.asList(bbsService.getPost(postId))).parallelStream()
				.map( post -> post.getId())
				.collect(Collectors.toList());
		Map<Long, Boolean> postCollectStatus = userCenterService.isCollectedPostList(uid, postIdList);
		MyLogger.infoln("postCollectStatus : " + postCollectStatus);
		assertFalse(postCollectStatus.get(postId));
	}
	
	//测试非法输入
	@Test
	public void testIllegalArgument() {
		logger.info("测试重复收藏");
		long verricktId = 1l;
		long luckyPostId = 1l;
		try {
			userCenterService.collectPost(verricktId, luckyPostId);
			userCenterService.collectPost(verricktId, luckyPostId);
		} catch (RepetitiveCollectException e) {
			logger.info("重复收藏");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试判断post列表的收藏情况
	@Test
	public void testPostCollectMatcher() throws RepetitiveCollectException {
		logger.info("测试collectMatcher");
		long userId = 1L;
		long collectedPostId = 1L;
		userCenterService.collectPost(userId, collectedPostId);
		PageParam pageParam = new PageParam(0, 20);
		List<Long> postIdList= bbsService.getPostList(1L, pageParam).parallelStream()
				.map( post -> post.getId())
				.collect(Collectors.toList());
		Map<Long, Boolean> collectStatusMap = userCenterService.isCollectedPostList(userId, postIdList);
		for (Entry<Long, Boolean> entry : collectStatusMap.entrySet()) {
			if (entry.getKey().equals(collectedPostId)) {
				assertTrue(entry.getValue());
			}
		}
	}
	
	//测试collectMatcher的刷新
	@Test
	public void testMatcherFreshMonitor() throws RepetitiveCollectException {
		Long verricktId = 1L;
		Long topicId = 1L;
		Long postId = 1L;
		List<Long> postIdList = bbsService.getPostList(topicId, new PageParam(0, 20)).parallelStream()
				.map( post -> post.getId())
				.collect(Collectors.toList());
		Map<Long, Boolean> postCollectStatus = userCenterService.isCollectedPostList(verricktId, postIdList);
		userCenterService.collectPost(verricktId, postId);
		Map<Long, Boolean> postCollectStatusAfter = userCenterService.isCollectedPostList(verricktId, postIdList);
		Post post = null;
		Boolean beforeStatus = false;
		Boolean afterStatus = null;
		Boolean isCompared = false;
		for (Entry<Long, Boolean> entry : postCollectStatusAfter.entrySet()) {
			if ( entry.getKey().equals(postId)) {
				afterStatus = entry.getValue();
				isCompared = true;
			}
		}
		assertTrue(isCompared);
		assertTrue(afterStatus);
	}
	
}
