package bbs.usercenter.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.helper.PageParam;
import bbs.usercenter.collection.DAO.CollectionDAO;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.form.UpdateUserProfileForm;
import bbs.usercenter.mybatis.entity.TCollection;
import bbs.usercenter.mybatis.mapper.TCollectionMapper;
import bbs.usercenter.service.UserCenterService;
import bbs.usercenter.userprofile.DAO.entity.UserProfile;

@Service
public class UserCenterServiceImp implements UserCenterService {

	private CollectionDAO collectionDAO;
	
	public CollectionDAO getCollectionDAO() {
		return collectionDAO;
	}

	@Autowired
	public void setCollectionDAO(CollectionDAO collectionDAO) {
		this.collectionDAO = collectionDAO;
	}

	@Override
	public void collectTopic(long uid, long topicId) {
		// TODO Auto-generated method stub
		collectionDAO.saveTopicCollection(uid, topicId);
	}

	@Override
	public void collectPost(long uid, long postId) {
		// TODO Auto-generated method stub
		collectionDAO.savePostCollection(uid, postId);
	}

	@Override
	public void follow(long uid, long followingId) {
		// TODO Auto-generated method stub
		collectionDAO.saveFollowingCollection(uid, followingId);
	}

	@Override
	public void collectForum(long uid, int forumId) {
		// TODO Auto-generated method stub
		collectionDAO.saveForumCollection(uid, forumId);
	}

	@Override
	public void updateUserProfile(long uid, UpdateUserProfileForm updateUserProfileForm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TopicCollection> getAllTopicCollectionByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<TopicCollection> tCs = collectionDAO.getAllTopicCollectionByUserId(uid, pageParam);
		return tCs;
	}

	@Override
	public List<ForumCollection> getAllForumCollectionByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<ForumCollection> forumCollectionList = collectionDAO.getAllForumCollectionsByUserId(uid, pageParam);

		return forumCollectionList;
	}

	@Override
	public List<FollowingCollection> getAllFollowingCollectionByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<FollowingCollection> foCs = collectionDAO.getAllFollowingCollectionByUserId(uid, pageParam);
		return foCs;
	}

	@Override
	public List<PostCollection> getAllPostCollectionByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<PostCollection> pCs = collectionDAO.getAllPostCollectionByUserId(uid, pageParam);
		return pCs;
	}

	@Override
	public void removeCollection(long collectionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserProfile getUserProfile(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
