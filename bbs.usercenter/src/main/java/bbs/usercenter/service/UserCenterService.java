package bbs.usercenter.service;

import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.form.UpdateUserProfileForm;
import bbs.usercenter.userprofile.DAO.entity.UserProfile;
import bbs.helper.*;

import java.util.List;

import bbs.forum.DTO.*;

public interface UserCenterService {

	void collectTopic(long uid, long topicId);
	
	void collectPost(long uid, long postId);
	
	void follow(long uid, long followingId);
	
	void collectForum(long uid, int forumId);
	
	void updateUserProfile(long uid, UpdateUserProfileForm updateUserProfileForm);
	
	List<TopicCollection> getAllTopicCollectionByUserId(long uid, PageParam pageParam);
	
	List<ForumCollection> getAllForumCollectionByUserId(long uid, PageParam pageParam);

	List<FollowingCollection> getAllFollowingCollectionByUserId(long uid, PageParam pageParam);
	
	List<PostCollection> getAllPostCollectionByUserId(long uid, PageParam pageParam);
	
	void removeCollection(long collectionId);

	UserProfile getUserProfile(long uid);
	
	
	
	
}
