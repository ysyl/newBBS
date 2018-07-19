package bbs.furom.serviceImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.service.BBSService;
import bbs.helper.utils.MyLogger;

@Transactional
@Rollback
public class ExternalUtilApiTest extends BaseTest {

	@Autowired
	BBSService bbsService;
	
	@Test
	public void testUsername() {
		String username = bbsService.getUsername(1L);
		assertEquals("verrickt",username );
	}
	
	@Test
	public void testIsMy() {
		long verricktId = 1l;
		long ownTopicId = 1l;
		long ownPostId = 1l;
		
		long otherTopicId = 4L; 
		long otherPostId = 4L;
		
		assertTrue(bbsService.isMyTopic(verricktId, ownTopicId));
		assertTrue(bbsService.isMyPost(verricktId, ownPostId));
		assertFalse(bbsService.isMyTopic(verricktId, otherTopicId));
		assertFalse(bbsService.isMyPost(verricktId, otherPostId));
	}
	
	@Test
	public void testGetLastPostInAllForum() {
		MyLogger.info("测试获取最新Post");
		List<Forum> forums = bbsService.getAllForums();
		Map<Integer, Post> lastPostMap = bbsService.getLastPostInForum();
			//只有两个论坛有帖子
		assertEquals(2, lastPostMap.size());
		MyLogger.info(lastPostMap);
			//测试是否真的取出的是Post
			MyLogger.info("\n测试是否真的取出的是Post");
			assertTrue(lastPostMap.get(1) instanceof Post);
	}
}
