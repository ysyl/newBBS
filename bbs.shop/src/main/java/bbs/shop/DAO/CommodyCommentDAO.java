package bbs.shop.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.DTO.BaseCommodyComment;
import bbs.shop.DTO.PrimaryCommodyComment;
import bbs.shop.entity.TCommodyComment;
import bbs.shop.enuma.CommentType;
import bbs.shop.mapper.TCommodyCommentMapper;

@Component
public class CommodyCommentDAO {
	
	private TCommodyCommentMapper mapper;

	@Autowired
	public CommodyCommentDAO(TCommodyCommentMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public long save(Long uid, CommentType commentType ,Long commodyId, String content, Long replyCommentId) {
		// TODO Auto-generated method stub
		TCommodyComment entity = new TCommodyComment();
		entity.setCommodyId(commodyId);
		entity.setReplyCommentId(null);
		entity.setUserId(uid);
		entity.setContent(content);
		entity.setCommentType(commentType);
		
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

}
