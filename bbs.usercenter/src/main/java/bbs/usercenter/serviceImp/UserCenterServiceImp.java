package bbs.usercenter.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import bbs.form.utils.PageParam;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.helper.utils.MyLogger;
import bbs.usercenter.collection.DAO.CollectionDAO;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.form.PubUserProfileForm;
import bbs.usercenter.mybatis.entity.TCollection;
import bbs.usercenter.mybatis.mapper.TCollectionMapper;
import bbs.usercenter.profile.DAO.UserProfileDAO;
import bbs.usercenter.service.UserCenterService;
import bbs.usercenter.userprofile.DAO.entity.UserProfile;

@Service
public class UserCenterServiceImp implements UserCenterService {

	private CollectionDAO collectionDAO;
	
	private UserProfileDAO userProfileDAO;
	
	public CollectionDAO getCollectionDAO() {
		return collectionDAO;
	}

	@Autowired
	public UserCenterServiceImp(CollectionDAO collectionDAO, UserProfileDAO userProfileDAO) {
		super();
		this.collectionDAO = collectionDAO;
		this.userProfileDAO = userProfileDAO;
	}


	@Override
	public void collectTopic(long uid, long topicId) {
		// TODO Auto-generated method stub
		collectionDAO.saveTopicCollection(uid, topicId);
	}

	@Override
	public void collectPost(long uid, long postId) throws RepetitiveCollectException {
		// TODO Auto-generated method stub
		try {
			collectionDAO.savePostCollection(uid, postId);
		} catch (DuplicateKeyException  e) {
			// TODO Auto-generated catch block
			
				throw new RepetitiveCollectException("重复收藏一个post");
		}
		MyLogger.info("收藏Post id：" + postId);
	}

	@Override
	public void collectUser(long uid, long followingId) {
		// TODO Auto-generated method stub
		collectionDAO.saveFollowingCollection(uid, followingId);
	}

	@Override
	public void collectForum(long uid, int forumId) {
		// TODO Auto-generated method stub
		collectionDAO.saveForumCollection(uid, forumId);
	}

	@Override
	public void updateUserProfile(long uid, PubUserProfileForm updateUserProfileForm) {
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
	public UserProfile getUserProfile(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicCollection> getAllTopicCollectionByUserId(long uid) {
		// TODO Auto-generated method stub
		PageParam infinityPageParam = new PageParam(0, Integer.MAX_VALUE);
		return getAllTopicCollectionByUserId(uid, infinityPageParam);
	}

	@Override
	public List<ForumCollection> getAllForumCollectionByUserId(long uid) {
		// TODO Auto-generated method stub
		PageParam infinityPageParam = new PageParam(0, Integer.MAX_VALUE);
		return getAllForumCollectionByUserId(uid, infinityPageParam);
	}

	@Override
	public List<FollowingCollection> getAllFollowingCollectionByUserId(long uid) {
		// TODO Auto-generated method stub
		PageParam infinityPageParam = new PageParam(0, Integer.MAX_VALUE);
		return getAllFollowingCollectionByUserId(uid, infinityPageParam);
	}

	@Override
	public List<PostCollection> getAllPostCollectionByUserId(long uid) {
		// TODO Auto-generated method stub
		PageParam infinityPageParam = new PageParam(0, Integer.MAX_VALUE);
		return getAllPostCollectionByUserId(uid, infinityPageParam);
	}

	@Override
	public void uncollectPost(Long uid, long postId) {
		// TODO Auto-generated method stub
		collectionDAO.removePostCollection(uid, postId);
	}

	@Override
	public void uncollectTopic(long uid, long topicId) {
		// TODO Auto-generated method stub
		collectionDAO.removeTopicCollection(uid, topicId);
	}

	@Override
	public void uncollectForum(long uid, int forumId) {
		// TODO Auto-generated method stub
		collectionDAO.removeForumCollection(uid, forumId);
	}

	@Override
	public void uncollectUser(long uid, long followingId) {
		// TODO Auto-generated method stub
		collectionDAO.removeFollowingCollection(uid, followingId);
	}

	@Override
	public long createUserProfile(PubUserProfileForm userProfileForm) {
		// TODO Auto-generated method stub
		return userProfileDAO.save(userProfileForm);
	}

	@Override
	public void updateUserProfile(Long uid, UpdateUserProfileForm updateUserProfileForm) {
		// TODO Auto-generated method stub
		
	}

}
