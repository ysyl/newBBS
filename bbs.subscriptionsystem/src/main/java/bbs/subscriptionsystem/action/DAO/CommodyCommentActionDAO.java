package bbs.subscriptionsystem.action.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bbs.shop.mybatis.mapper.TCommodyCommentMapper;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;
import bbs.subscriptionsystem.entity.TCommodyCommentAction;
import bbs.subscriptionsystem.mapper.TCommodyCommentActionMapper;

@Repository
public class CommodyCommentActionDAO {
	
	private TCommodyCommentActionMapper mapper;
	
	@Autowired
	public CommodyCommentActionDAO(TCommodyCommentActionMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public long save(long uid, long commentId, long commodyId) {
		TCommodyCommentAction entity = new TCommodyCommentAction();
		entity.setCommentId(commentId);
		entity.setCommodyId(commodyId);
		entity.setUserId(uid);

		mapper.insertSelective(entity);
		
		return entity.getId();
	}
	
	public List<CommodyCommentAction> getAllCommentActionByCommodyId(long commodyId) {
		return mapper.selectCommodyCommentActionByCommodyId(commodyId);
	}
	
	public CommodyCommentAction getCommentActionById(long actionId) {
		return mapper.selectCommodyCommentActionById(actionId);
	}

	public List<CommodyCommentAction> getAllCommentActionByCommodyIdAfterLastReadTime(Long commodyId,
			Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.selectAllByCommodyIdAfterLastReadTime(commodyId, lastReadTime);
	}

	public List<? extends BaseAction> getAllModifyActionByCommodyIdAfterLastReadTime(Long commodyId,
			Date lastReadTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("未实现");
	}

	public Integer countCommentActionByCommodyIdAfterLastReadTime(Long commodyId, Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.countByCommodyIdAfterLastReadTime(commodyId, lastReadTime);
	}

	public List<? extends BaseAction> getAllCommentActionByCommentIdAfterLastReadTime(Long commentId,
			Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.selectAllByCommentIdAfterLastReadTime(commentId, lastReadTime);
	}

	public Integer getCommodyActionCountByIdAfterLastReadTime(Long commodyId, Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.countByCommodyIdAfterLastReadTime(commodyId, lastReadTime);
	}

	public Integer countCommentActionByCommentIdAfterLastReadTime(Long commentId, Date lastReadTime) {
		// TODO Auto-generated method stub
		return mapper.countByCommentIdAfterLastReadTime(commentId, lastReadTime);
	}

}
