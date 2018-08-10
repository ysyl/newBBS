package bbs.usercenter.service;

import bbs.usercenter.collection.DAO.entity.CommodyCollection;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.form.PubUserProfileForm;
import bbs.usercenter.userprofile.DTO.UserProfile;

import java.util.List;
import java.util.Map;

import bbs.form.utils.*;
import bbs.forum.DTO.*;
import bbs.forum.enuma.Sex;
import bbs.forum.form.UpdateUserProfileForm;

public interface UserCenterService {
	
	long createUserProfile(PubUserProfileForm userProfileForm); 

	void collectTopic(long uid, long topicId) throws RepetitiveCollectException;
	
	void collectPost(long uid, long postId) throws RepetitiveCollectException;
	
	void collectUser(long uid, long followingId);
	
	void collectForum(long uid, int forumId);
	
	void collectCommody(long uid, long commodyId);
	
	void updateUserProfile(long uid, PubUserProfileForm updateUserProfileForm);
	
	List<TopicCollection> getAllTopicCollectionByUserId(long uid);

	List<TopicCollection> getAllTopicCollectionByUserId(long uid, PageParam pageParam);
	
	List<ForumCollection> getAllForumCollectionByUserId(long uid);

	List<ForumCollection> getAllForumCollectionByUserId(long uid, PageParam pageParam);

	List<FollowingCollection> getAllFollowingCollectionByUserId(long uid);

	List<FollowingCollection> getAllFollowingCollectionByUserId(long uid, PageParam pageParam);

	List<PostCollection> getAllPostCollectionByUserId(long uid);
	
	List<PostCollection> getAllPostCollectionByUserId(long uid, PageParam pageParam);
	
	List<CommodyCollection> getAllCommodyCollectionByUserId(long uid);

	List<CommodyCollection> getAllCommodyCollectionByUserId(long uid, PageParam pageParam);

	UserProfile getUserProfile(long uid);

	void uncollectPost(Long uid, long postId);

	void uncollectTopic(long uid, long topicId);

	void uncollectForum(long uid, int forumId);

	void uncollectUser(long uid, long followingId);
	
	void uncollectCommody(long uid, long commodyId);

	void updateUserProfile(Long uid, String avatarFilename, String nickname, Sex sex);

	boolean isCollectedCommody(Long uid, long commodyId);
	
	boolean isCollectedPost(Long uid, Long postId);

	boolean isCollectedTopic(Long uid, Long topicId);

	boolean isCollectedUser(Long uid, Long followingId);

	Map<Long, Boolean> isCollectedCommodyList(Long uid, List<Long> commodyIdList);

	Map<Long, Boolean> isCollectedTopicList(Long uid, List<Long> topicIdList);

	Map<Long, Boolean> isCollectedPostList(Long uid, List<Long> postIdList);

	Map<Long, Boolean> isCollectedUserList(Long uid, List<Long> userIdList);
	
	
	
	
}
