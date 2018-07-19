package bbs.web.utils;

import bbs.forum.DAO.TopicDAO;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DAO.PostDAO;
import bbs.forum.DAO.UserDAO;
import bbs.forum.DTO.Post;
import bbs.forum.service.BBSService;
import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;

//用于检测用户当前访问和要收藏的对象是不是自己已经订阅的，如果是，则取消方法调用
@Component
public class OwnChecker {
	
	private BBSService bbsService;
	
	private SecurityHelper securityHelper;

	@Autowired
	public OwnChecker(BBSService bbsService, SecurityHelper securityHelper) {
		super();
		this.bbsService = bbsService;
		this.securityHelper = securityHelper;
	}
	
	public Map<Long, Boolean> checkPostListOwnStatus(List<Post> postList) {
		Map<Long, Boolean> postOwnStatusMap = new HashMap<>();
		for (Post post : postList) {
			Long postId = post.getId();
			Boolean isMyPost = this.isMyPost(postId);
			postOwnStatusMap.put(postId, isMyPost);
			MyLogger.info("\n\npostId: " + postId + "isMyPost: " + isMyPost);
		}
		return postOwnStatusMap;
	}

	public boolean isMyTopic(long topicId) {
		Long uid = securityHelper.getCurrentUserId();
		return bbsService.isMyTopic(uid, topicId);
	}
	
	public boolean isMyPost(long postId) {
		Long uid = securityHelper.getCurrentUserId();
		boolean result = bbsService.isMyPost(uid, postId);

		MyLogger.info("\n\nmatchOwn " + result + "postId: " + postId);
		return result;
	}
	
	public boolean isMe(long followingId) {
		return followingId == securityHelper.getCurrentUserId(); 
	}
}
