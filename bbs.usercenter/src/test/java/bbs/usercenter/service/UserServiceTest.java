package bbs.usercenter.service;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.PageParam;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;

@Transactional
@Rollback
public class UserServiceTest extends BaseTest {

	@Autowired
	UserCenterService userCenterService;
	
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	
	private static PageParam pageParam = new PageParam(0, 20);
	
	@Test
	public void testCollection() {
		logger.info("\n\n\n测试开始\n\n\n");
		
		logger.info("收藏forum");
		long uid = 1L;
		Integer forumId = 1;
		userCenterService.collectForum(uid, forumId);
		
		ForumCollection fcollection = userCenterService.getAllForumCollectionByUserId(uid, pageParam).get(0);
		assertEquals(forumId, fcollection.getForum().getId());
		
		logger.info("收藏topic");
		long topicId = 1;
		userCenterService.collectTopic(uid, topicId);
		
		TopicCollection tCollection = userCenterService.getAllTopicCollectionByUserId(uid, pageParam).get(0);
		assertEquals((Long) topicId, tCollection.getTopic().getId());
		
		logger.info("收藏post");
		Long postId = 1L;
		userCenterService.collectPost(uid, postId);
		
		PostCollection pCollection = userCenterService.getAllPostCollectionByUserId(uid, pageParam).get(0);
		
		assertEquals(postId, pCollection.getPost().getId());
		
		logger.info("收藏Following");
		Long followingId = 2L;
		try {
			userCenterService.follow(uid, followingId);
		} catch(UnsupportedOperationException e) {
			logger.info(e.getMessage());
		}
		userCenterService.follow(uid, followingId);
		FollowingCollection foCollection = userCenterService
				.getAllFollowingCollectionByUserId(uid, pageParam).get(0);
				
		assertEquals(followingId, foCollection.getFollowing().getId());

		logger.info("获取forum收藏");
		logger.info("获取topic收藏");
		logger.info("获取post收藏");
		logger.info("获取following收藏");
		
		logger.info("删除收藏");
	}
}
