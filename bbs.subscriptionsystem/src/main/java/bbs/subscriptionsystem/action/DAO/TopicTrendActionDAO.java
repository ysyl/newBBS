package bbs.subscriptionsystem.action.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.service.BBSService;
import bbs.helper.PageParam;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.entity.TTopicTrendAction;
import bbs.subscriptionsystem.mapper.TTopicTrendActionMapper;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

@Component
public class TopicTrendActionDAO {
	
	private TTopicTrendActionMapper topicTrendActionMapper;

	public TTopicTrendActionMapper getTopicTrendActionMapper() {
		return topicTrendActionMapper;
	}

	@Autowired
	public void setTopicTrendActionMapper(TTopicTrendActionMapper topicTrendActionMapper) {
		this.topicTrendActionMapper = topicTrendActionMapper;
	}

	public List<TopicTrendAction> selectAllByIdAfterLastReadTime(long topicId, Date lastReadTime, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<TopicTrendAction> result = topicTrendActionMapper
					.selectAllByTopicIdAfterLastReadTime(topicId, lastReadTime);
		return result;
	}

	public Long saveTopicTrendAction(long uid, Long topicId, long replyId) {
		// TODO Auto-generated method stub
		TTopicTrendAction entity = new TTopicTrendAction();
		entity.setReplierId(uid);
		entity.setReplyPostId(replyId);
		entity.setTopicId(topicId);
		topicTrendActionMapper.insertSelective(entity);
		return entity.getId();
	}

	public List<TopicTrendAction> selectAllBySubscription(TopicSubscription topicSubscription) {
		// TODO Auto-generated method stub
		long topicId = topicSubscription.getTarget().getId();
		Date lastReadTime = topicSubscription.getLastReadTime();
		List<TopicTrendAction> actions = topicTrendActionMapper.selectAllByTopicIdAfterLastReadTime(topicId, lastReadTime);
		return actions;
	}

	public TopicTrendAction selectById(long actionId) {
		return topicTrendActionMapper.selectTopicTrendActionById(actionId);
		// TODO Auto-generated method stub
		
	}

	public Integer CountBySubscription(TopicSubscription subscription) {
		// TODO Auto-generated method stub
		long topicId = subscription.getTarget().getId();
		Date lastReadTime = subscription.getLastReadTime();
		Integer count = topicTrendActionMapper.countByTopicIdAfterLastReadTime(topicId, lastReadTime);

		return count;
	}
	
}
