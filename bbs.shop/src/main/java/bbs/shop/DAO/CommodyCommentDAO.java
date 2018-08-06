package bbs.shop.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.PrimaryCommodyComment;
import bbs.shop.enuma.CommentType;
import bbs.shop.mybatis.entity.TCommodyComment;
import bbs.shop.mybatis.mapper.TCommodyCommentMapper;

@Component
public class CommodyCommentDAO {
	
	private TCommodyCommentMapper mapper;

	@Autowired
	public CommodyCommentDAO(TCommodyCommentMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public long savePrimaryComment(Long uid, Long commodyId, String content) {
		// TODO Auto-generated method stub
		TCommodyComment entity = new TCommodyComment();
		entity.setCommodyId(commodyId);
		entity.setUserId(uid);
		entity.setContent(content);
		entity.setCommentType(CommentType.PRIMARY);
		
		mapper.insertSelective(entity);
		
		return entity.getId();
	}

	public List<PrimaryCommodyComment> getAllPrimaryCommentByCommodyId(long commentId) {
		// TODO Auto-generated method stub
		return mapper.selectAllPrimaryCommentByCommodyId(commentId);
	}

	public PrimaryCommodyComment get(long commentId) {
		// TODO Auto-generated method stub
		return mapper.selectPrimaryCommentById(commentId);
	}

	public long saveReplyComment(Long uid, Long commodyId, Long belongPrimaryCommentId, Long replyTargetCommentId, String content) {
		// TODO Auto-generated method stub
		TCommodyComment entity = new TCommodyComment();
		entity.setCommodyId(commodyId);
		entity.setUserId(uid);
		entity.setContent(content);
		entity.setCommentType(CommentType.REPLY);
		entity.setBelongCommentId(belongPrimaryCommentId);
		entity.setReplyCommentId(replyTargetCommentId);
		
		mapper.insertSelective(entity);

		return entity.getId();
	}

}
