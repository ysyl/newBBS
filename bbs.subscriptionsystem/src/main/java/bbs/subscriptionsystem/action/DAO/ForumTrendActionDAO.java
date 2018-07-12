package bbs.subscriptionsystem.action.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.entity.TForumTrendAction;
import bbs.subscriptionsystem.mapper.TForumTrendActionMapper;

@Repository
public class ForumTrendActionDAO {
	
	private TForumTrendActionMapper tForumTrendActionMapper;

	public TForumTrendActionMapper gettForumTrendActionMapper() {
		return tForumTrendActionMapper;
	}

	@Autowired
	public void settForumTrendActionMapper(TForumTrendActionMapper tForumTrendActionMapper) {
		this.tForumTrendActionMapper = tForumTrendActionMapper;
	}

	public Long saveForumTrendAction(long managerId, int forumId, int announceId) {
		// TODO Auto-generated method stub
		TForumTrendAction entity = new TForumTrendAction();
		entity.setPublisherId(managerId);
		entity.setForumId(forumId);
		entity.setAnnounceId(announceId);
		tForumTrendActionMapper.insertSelective(entity);
		return entity.getId();
	}

	public List<ForumTrendAction> selectAllForumTrendActionByForumIdAfterLastReadTime(Integer forumId,
			Date lastReadTime) {
		// TODO Auto-generated method stub
		List<ForumTrendAction> actions = tForumTrendActionMapper.selectAllForumTrendActionByForumIdAfterLastReadTime(forumId, lastReadTime);
		return actions;
	}

	public ForumTrendAction selectById(long actionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
