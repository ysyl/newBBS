package bbs.usercenter.collection.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import bbs.helper.PageParam;
import bbs.usercenter.collection.DAO.entity.FollowingCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.collection.DAO.entity.PostCollection;
import bbs.usercenter.collection.DAO.entity.TopicCollection;
import bbs.usercenter.enuma.CollectionType;
import bbs.usercenter.mybatis.entity.TCollection;
import bbs.usercenter.mybatis.mapper.TCollectionMapper;

@Repository
public class CollectionDAO {
	
	private TCollectionMapper tCollectionMapper;
	
	public TCollectionMapper gettCollectionMapper() {
		return tCollectionMapper;
	}

	@Autowired
	public void settCollectionMapper(TCollectionMapper tCollectionMapper) {
		this.tCollectionMapper = tCollectionMapper;
	}

	public void saveFollowingCollection(long uid, long followingId) {
		TCollection tCollection = new TCollection();
		tCollection.setCollectionType(CollectionType.FOLLOWING);
		tCollection.setFollowingId(followingId);
		tCollection.setUserId(uid);
		
		tCollectionMapper.insertSelective(tCollection);
	}
	
	public void saveForumCollection(long uid, int forumId) {
		TCollection tCollection = new TCollection();
		tCollection.setCollectionType(CollectionType.FORUM);
		tCollection.setForumId(forumId);
		tCollection.setUserId(uid);
		
		tCollectionMapper.insertSelective(tCollection);
	}
	
	public void saveTopicCollection(long uid, long topicId) {
		TCollection tCollection = new TCollection();
		tCollection.setCollectionType(CollectionType.TOPIC);
		tCollection.setTopicId(topicId);
		tCollection.setUserId(uid);
		
		tCollectionMapper.insertSelective(tCollection);
	}
	
	public void savePostCollection(long uid, long postId) throws DataIntegrityViolationException {
		TCollection tCollection = new TCollection();
		tCollection.setCollectionType(CollectionType.POST);
		tCollection.setPostId(postId);
		tCollection.setUserId(uid);
		
		tCollectionMapper.insertSelective(tCollection);
	}
	

	public List<ForumCollection> getAllForumCollectionsByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<ForumCollection> fCs = (List<ForumCollection>) tCollectionMapper.selectAllCollectionByUidAndType(uid, CollectionType.FORUM, pageParam);
		return fCs;
	}

	public List<TopicCollection> getAllTopicCollectionByUserId(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<TopicCollection> tCs = (List<TopicCollection>) tCollectionMapper.selectAllCollectionByUidAndType(uid, CollectionType.TOPIC, pageParam);
		return tCs;
	}
	
	public List<PostCollection> getAllPostCollectionByUserId(long uid, PageParam pageParam) {
		List<PostCollection> pCs = (List<PostCollection>) tCollectionMapper.selectAllCollectionByUidAndType(uid, CollectionType.POST, pageParam);
		return pCs;
	}
	
	public List<FollowingCollection> getAllFollowingCollectionByUserId(long uid, PageParam pageParam) {
		List<FollowingCollection> foCs = (List<FollowingCollection>) tCollectionMapper.selectAllCollectionByUidAndType(uid, CollectionType.FOLLOWING, pageParam);
		return foCs;
	}

	public void removePostCollection(Long uid, long postId) {
		// TODO Auto-generated method stub
		tCollectionMapper.deleteByUidAndTargetId(uid, postId, CollectionType.POST);
	}

	public void removeTopicCollection(long uid, long topicId) {
		// TODO Auto-generated method stub
		tCollectionMapper.deleteByUidAndTargetId(uid, topicId, CollectionType.TOPIC);
	}

	public void removeForumCollection(long uid, int forumId) {
		// TODO Auto-generated method stub
		tCollectionMapper.deleteByUidAndTargetId(uid, forumId, CollectionType.FORUM);
	}

	public void removeFollowingCollection(long uid, long followingId) {
		// TODO Auto-generated method stub
		tCollectionMapper.deleteByUidAndTargetId(uid, followingId, CollectionType.FOLLOWING);
	}
}
