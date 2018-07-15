package bbs.usercenter.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.usercenter.collection.DAO.entity.BaseCollection;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.service.UserCenterService;

@Component
public class CollectMatcher {
	private UserCenterService userCenterService;
	
	private List<PostCollection> postCollections;
	
	private List<ForumCollection> forumCollections;

	private List<TopicCollection> topicCollections;

	private List<FollowingCollection> followingCollections;

	@Autowired
	public CollectMatcher(UserCenterService userCenterService) {
		super();
		this.userCenterService = userCenterService;
	}

	public Map<Post, Boolean> checkPostCollectStatus(List<Post> postList, long uid) {
		Map<Post, Boolean> postCollectStatusMap = new HashMap<>();
		for(Post post : postList ) {
			Boolean isCollected = this.checkPostIsCollected(post);
			postCollectStatusMap.put(post, isCollected);
		}
		return postCollectStatusMap;
	}
	
	public void freshCollections(long uid) {
		this.postCollections = userCenterService.getAllPostCollectionByUserId(uid);
		this.forumCollections = userCenterService.getAllForumCollectionByUserId(uid);
		this.topicCollections = userCenterService.getAllTopicCollectionByUserId(uid);
		this.followingCollections = userCenterService.getAllFollowingCollectionByUserId(uid);
	}
	
	public Boolean checkPostIsCollected(Post post) {
		Boolean result = false;
		for( PostCollection postCollection : this.postCollections) {
			 if(postCollection.getPost().getId().equals(post.getId())) {
				 result = true;
			 }
		}
		return result;
	}
	
	public Boolean checkTopicIsCollected(long topicId) {
		Boolean result = false;
		for(TopicCollection topicCollection : this.topicCollections) {
			if(topicCollection.getTopic().getId().equals(topicId)) {
				result = true;
			}
		}
		return result;
	}
}
