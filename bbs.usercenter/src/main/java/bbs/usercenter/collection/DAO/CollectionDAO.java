package bbs.usercenter.collection.DAO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import bbs.form.utils.PageParam;
import bbs.helper.utils.MyLogger;
import bbs.usercenter.collection.DAO.entity.CommodyCollection;
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
	
	public void saveCommodyCollection(long uid, long commodyId) {
		// TODO Auto-generated method stub
		TCollection tCollection = new TCollection();
		tCollection.setCollectionType(CollectionType.COMMODY);
		tCollection.setCommodyId(commodyId);
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
	
	public List<CommodyCollection> getAllCommodyCollectionByUserId(long uid, PageParam pageParam) {
		List<CommodyCollection> resultList = (List<CommodyCollection>) tCollectionMapper.selectAllCollectionByUidAndType(uid, CollectionType.COMMODY, pageParam);
		return resultList;
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
	
	public void removeCommodyCollection(long uid, long commodyId) {
		tCollectionMapper.deleteByUidAndTargetId(uid, commodyId, CollectionType.COMMODY);
	}

	public Map<Long, Boolean> isCollectedCommodyList(Long uid, List<Long> commodyIdList) {
		// TODO Auto-generated method stub
		return this.isCollectedSomethingList(uid, commodyIdList, CollectionType.COMMODY);
	}

	public Map<Long, Boolean> isCollectedTopicList(Long uid, List<Long> topicIdList) {
		// TODO Auto-generated method stub
		return this.isCollectedSomethingList(uid, topicIdList, CollectionType.TOPIC);
	}

	public Map<Long, Boolean> isCollectedPostList(Long uid, List<Long> postIdList) {
		// TODO Auto-generated method stub
		return this.isCollectedSomethingList(uid, postIdList, CollectionType.POST);
	}

	public Map<Long, Boolean> isCollectedUserList(Long uid, List<Long> userIdList) {
		// TODO Auto-generated method stub
		return this.isCollectedSomethingList(uid, userIdList, CollectionType.FOLLOWING);

	}

	public boolean isCollectedCommodyList(Long uid, long commodyId) {
		// TODO Auto-generated method stub
		return tCollectionMapper.selectCollectionByUidAndTargetIdAndType(uid, commodyId, CollectionType.COMMODY)!=null;
	}

	public boolean isCollectedPost(Long uid, Long postId) {
		// TODO Auto-generated method stub
		return tCollectionMapper.selectCollectionByUidAndTargetIdAndType(uid, postId, CollectionType.POST) != null;
	}

	public boolean isCollectedTopic(Long uid, Long topicId) {
		// TODO Auto-generated method stub
		return tCollectionMapper.selectCollectionByUidAndTargetIdAndType(uid, topicId, CollectionType.TOPIC) != null;
	}

	public boolean isCollectedUser(Long uid, Long followingId) {
		// TODO Auto-generated method stub
		return tCollectionMapper.selectCollectionByUidAndTargetIdAndType(uid, followingId, CollectionType.FOLLOWING)!=null;
	}

	
	private Map<Long, Boolean> isCollectedSomethingList(Long uid, List<Long> someThingIdList, CollectionType collectionType) {
		List<Long> commodyIdListInterset = tCollectionMapper.selectCollectedTargetIdByUidInTargetIdList(uid, someThingIdList, collectionType);
		MyLogger.infoln(this.getClass(), "获取传入的要匹配的something Id List" + someThingIdList);
		MyLogger.infoln(this.getClass(), "获取已收藏的something Id交集" + commodyIdListInterset);
		Map<Long, Boolean> resultMap = null;
		//当someThingIdList中有重复的值时，toMap会出错，这时候需要传进第三个函数，明确遇到重复key时的行为
		resultMap = someThingIdList.stream()
				.collect(Collectors.toMap( item -> item, commodyIdListInterset::contains, (a, b)->a));
		return resultMap;
	}

}
