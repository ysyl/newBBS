package bbs.usercenter.service;

import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.form.PubUserProfileForm;
import bbs.usercenter.userprofile.DAO.entity.UserProfile;

import java.util.List;

import bbs.form.utils.*;
import bbs.forum.DTO.*;
import bbs.forum.form.UpdateUserProfileForm;

public interface UserCenterService {
	
	long createUserProfile(PubUserProfileForm userProfileForm); 

	void collectTopic(long uid, long topicId) throws RepetitiveCollectException;
	
	void collectPost(long uid, long postId) throws RepetitiveCollectException;
	
	void collectUser(long uid, long followingId);
	
	void collectForum(long uid, int forumId);
	
	void updateUserProfile(long uid, PubUserProfileForm updateUserProfileForm);
	
	List<TopicCollection> getAllTopicCollectionByUserId(long uid);

	List<TopicCollection> getAllTopicCollectionByUserId(long uid, PageParam pageParam);
	
	List<ForumCollection> getAllForumCollectionByUserId(long uid);

	List<ForumCollection> getAllForumCollectionByUserId(long uid, PageParam pageParam);

	List<FollowingCollection> getAllFollowingCollectionByUserId(long uid);

	List<FollowingCollection> getAllFollowingCollectionByUserId(long uid, PageParam pageParam);

	List<PostCollection> getAllPostCollectionByUserId(long uid);
	
	List<PostCollection> getAllPostCollectionByUserId(long uid, PageParam pageParam);

	UserProfile getUserProfile(long uid);

	void uncollectPost(Long uid, long postId);

	void uncollectTopic(long uid, long topicId);

	void uncollectForum(long uid, int forumId);

	void uncollectUser(long uid, long followingId);

	void updateUserProfile(Long uid, UpdateUserProfileForm updateUserProfileForm);
	
	
	
	
}
