package bbs.subscriptionsystem.subscription.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.subscriptionsystem.entity.TSubscription;
import bbs.subscriptionsystem.enuma.SubscriptionType;
import bbs.subscriptionsystem.mapper.TSubscriptionMapper;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

@Component
@Transactional
public class SubscriptionDAO {
	
	private TSubscriptionMapper mapper;

	public TSubscriptionMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TSubscriptionMapper mapper) {
		this.mapper = mapper;
	}

	public void saveTopicSubscription(long uid, long topicId) {
		// TODO Auto-generated method stub
		TSubscription entity = new TSubscription();
		entity.setSubscriptionType(SubscriptionType.TOPIC);
		entity.setTopicId(topicId);
		entity.setUserId(uid);
		mapper.insertSelective(entity);
	}

	public void savePostSubscription(long uid, long postId) {
		// TODO Auto-generated method stub
		TSubscription entity = new TSubscription();
		entity.setSubscriptionType(SubscriptionType.POST);
		entity.setPostId(postId);
		entity.setUserId(uid);
		mapper.insertSelective(entity);
	}

	public void saveUserSubscription(long uid, long followingId) {
		// TODO Auto-generated method stub
		TSubscription entity = new TSubscription();
		entity.setSubscriptionType(SubscriptionType.USER);
		entity.setFollowingId(followingId);
		entity.setUserId(uid);
		mapper.insertSelective(entity);
	}

	public void saveForumSubscription(long uid, int forumId) {
		// TODO Auto-generated method stub
		TSubscription entity = new TSubscription();
		entity.setSubscriptionType(SubscriptionType.FORUM);
		entity.setForumId(forumId);
		entity.setUserId(uid);
		mapper.insertSelective(entity);
	}
	public boolean hasTopicSubscription(long uid, long topicId) {
		boolean hasSubscription = mapper.countSubscriptionByUidAndTargetIdAndType(uid, topicId, SubscriptionType.TOPIC) != 0;
		return hasSubscription;
	}
	public boolean hasForumSubscription(long uid, int forumId) {
		boolean hasSubscription = mapper.countSubscriptionByUidAndTargetIdAndType(uid, forumId, SubscriptionType.FORUM) != 0;
		return hasSubscription;
	}
	public boolean hasFollowingSubscription(long uid, long followingId) {
		boolean hasSubscription = mapper.countSubscriptionByUidAndTargetIdAndType(uid, followingId, SubscriptionType.FOLLOW) != 0;
		return hasSubscription;
	}
	public boolean hasPostSubscription(long uid, long postId) {
		boolean hasSubscription = mapper.countSubscriptionByUidAndTargetIdAndType(uid, postId, SubscriptionType.POST) != 0;
		return hasSubscription;
	}

	public List<? extends BaseSubscription<?>> getAllSubscription(long uid) {
		// TODO Auto-generated method stub
		List<? extends BaseSubscription<?>> subscriptions = mapper.selectAllByUid(uid);
		return subscriptions;
	}

	public List<TopicSubscription> getAllTopicSubscription(long uid) {
		// TODO Auto-generated method stub
		List<TopicSubscription> subscription = mapper.selectAllTopicSubscriptionByUid(uid);
		return subscription;
	}
	
	public List<PostSubscription> getAllPostSubscription(long uid) {
		List<PostSubscription> subscriptions = mapper.selectAllPostSubscriptionByUid(uid);
		return subscriptions;
	}
	
	public List<ForumSubscription> getAllForumSubscription(long uid) {
		return mapper.selectAllForumSubscriptionByUid(uid);
	}

	public void updateLastReadTime(Long id) {
		// TODO Auto-generated method stub
		TSubscription entity = new TSubscription();
		entity.setId(id);
		entity.setLastReadTime(new Date());
		mapper.updateByPrimaryKeySelective(entity);
	}

	public void removeForumSubscription(long uid, long targetId) {
		// TODO Auto-generated method stub
		mapper.deleteByUidAndTargetId(uid, targetId, SubscriptionType.FORUM);
	}
	public void removeTopicSubscription(long uid, long targetId) {
		// TODO Auto-generated method stub
		mapper.deleteByUidAndTargetId(uid, targetId, SubscriptionType.TOPIC);
	}
	public void removePostSubscription(long uid, long targetId) {
		// TODO Auto-generated method stub
		mapper.deleteByUidAndTargetId(uid, targetId, SubscriptionType.POST);
	}
	public void removeUserSubscription(long uid, long targetId) {
		// TODO Auto-generated method stub
		mapper.deleteByUidAndTargetId(uid, targetId, SubscriptionType.USER);
	}
	
}
