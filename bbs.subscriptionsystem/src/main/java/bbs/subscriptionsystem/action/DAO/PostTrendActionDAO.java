package bbs.subscriptionsystem.action.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.entity.TPostTrendAction;
import bbs.subscriptionsystem.mapper.TPostTrendActionMapper;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;

@Repository
public class PostTrendActionDAO {
	
	public TPostTrendActionMapper gettPostTrendActionMapper() {
		return tPostTrendActionMapper;
	}

	@Autowired
	public void settPostTrendActionMapper(TPostTrendActionMapper tPostTrendActionMapper) {
		this.tPostTrendActionMapper = tPostTrendActionMapper;
	}

	private TPostTrendActionMapper tPostTrendActionMapper;

	public Long savePostTrendAction(long uid, Long postId, Long replyPostId)  {
		TPostTrendAction entity = new TPostTrendAction();
		entity.setReplyPostId(postId);
		entity.setTargetPostId(replyPostId);
		entity.setReplierId(uid);
		tPostTrendActionMapper.insertSelective(entity);
		return entity.getId();
	}
	
	public List<PostTrendAction> selectAllBySubscription(PostSubscription subscription) {
		Date lastReadTime = subscription.getLastReadTime();
		Long postId = subscription.getTarget().getId();
		List<PostTrendAction> actions = tPostTrendActionMapper.selectAllByPostIdAfterLastReadTime(postId, lastReadTime);
		return actions;
	}

	public PostTrendAction selectById(long actionId) {
		// TODO Auto-generated method stub
		return null;
	}
}
