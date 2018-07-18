package bbs.subscriptionsystem.action.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.form.PubPostForm;
import bbs.helper.PageParam;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.entity.TUserTrendAction;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;
import bbs.subscriptionsystem.mapper.TUserTrendActionMapper;

@Component
public class UserTrendActionDAO {

	private TUserTrendActionMapper mapper;

	public TUserTrendActionMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TUserTrendActionMapper mapper) {
		this.mapper = mapper;
	}
	
	public Long saveUserTrendAction(UserTrendActionType actionType, UserTrendActionTargetType targetType,
			long uid, long targetId) {
		TUserTrendAction entity = new TUserTrendAction();
		entity.setActionType(actionType);
		entity.setTargetType(targetType);
		entity.setUserId(uid);
		switch(targetType) {
		case TOPIC:
			entity.setTopicId(targetId);
			break;
		case POST:
			entity.setPostId(targetId);
			break;
		}
		mapper.insertSelective(entity);
		return entity.getId();
	}
	

	public void savePubTopicAction(long uid, Long topicId) {
		// TODO Auto-generated method stub
		TUserTrendAction entity = new TUserTrendAction();
		entity.setActionType(UserTrendActionType.PUB);
		entity.setTargetType(UserTrendActionTargetType.TOPIC);
		entity.setUserId(uid);
		entity.setTopicId(topicId);
		mapper.insert(entity);
		
	}

	public void savePubPostAction(long uid, long topicId, PubPostForm pubPostForm, Long postId) {
		// TODO Auto-generated method stub
		TUserTrendAction entity = new TUserTrendAction();
		entity.setActionType(UserTrendActionType.PUB);
		entity.setTargetType(UserTrendActionTargetType.POST);
		entity.setUserId(uid);
		entity.setPostId(postId);
		mapper.insertSelective(entity);
	}
	
	public void saveLikeTopicAction(long uid, Long topicId) {
		TUserTrendAction entity = new TUserTrendAction();
		entity.setActionType(UserTrendActionType.LIKE);
		entity.setTargetType(UserTrendActionTargetType.TOPIC);
		entity.setUserId(uid);
		entity.setTopicId(topicId);
		mapper.insert(entity);
	}
	
	public void saveLikePostAction(long uid, Long postId) {
		TUserTrendAction entity = new TUserTrendAction();
		entity.setActionType(UserTrendActionType.LIKE);
		entity.setTargetType(UserTrendActionTargetType.POST);
		entity.setUserId(uid);
		entity.setPostId(postId);
		mapper.insert(entity);
		
	}

	public List<UserTrendAction<?>> selectAllByUidAfterLasterReadTime(Long uid, Date lastReadTime) {
		// TODO Auto-generated method stub
		List<UserTrendAction<?>> actions = mapper.selectAllUidAfterLastReadTime(uid, lastReadTime, null, null);
		return actions;
	}

	public UserTrendAction<?> selectById(long actionId) {
		// TODO Auto-generated method stub
		return mapper.selectUserTrendActionById(actionId);
	}

	public Integer countByUidAfterLastReadTime(Long uid, Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.countUidAfterLastReadTime(uid, lastReadTime);
	}

}
