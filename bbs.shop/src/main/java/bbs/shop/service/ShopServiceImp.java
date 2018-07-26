package bbs.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bbs.shop.DAO.CommodyCommentDAO;
import bbs.shop.DAO.CommodyDAO;
import bbs.shop.DTO.Commody;
import bbs.shop.DTO.PrimaryCommodyComment;
import bbs.shop.DTO.BaseCommodyComment;
import bbs.shop.entity.TCommodyComment;
import bbs.shop.enuma.CommentType;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.UpdateCommodyForm;

@Service
public class ShopServiceImp implements ShopService {
	
	private CommodyDAO commodyDAO;
	
	private CommodyCommentDAO commentDAO;

	@Autowired
	public ShopServiceImp(CommodyDAO commodyDAO, CommodyCommentDAO commentDAO) {
		super();
		this.commodyDAO = commodyDAO;
		this.commentDAO = commentDAO;
	}

	public long saveCommody(long uid, PubCommodyForm pubCommodyForm) {
		// TODO Auto-generated method stub
		String title = pubCommodyForm.getTitle();
		String description = pubCommodyForm.getDescription();
		List<MultipartFile> imgFiles = pubCommodyForm.getImgFile();
		int commodyClassificationId = pubCommodyForm.getCommodyClassificationId();
		List<String> imgFileNames = new ArrayList<>();
		return commodyDAO.save(uid, title, description, imgFileNames, commodyClassificationId);
	}

	public Commody getCommody(long commodyId) {
		// TODO Auto-generated method stub
		return commodyDAO.get(commodyId);
	}

	public void updateCommody(long commodyId, UpdateCommodyForm updateCommodyForm) {
		// TODO Auto-generated method stub
		int classificationId = updateCommodyForm.getClassificationId();
		String description = updateCommodyForm.getDescription();
		String title = updateCommodyForm.getTitle();
		List<String> imgFileNames = new ArrayList<>();
		
		commodyDAO.update(commodyId, title, description, imgFileNames, classificationId);
	}

	@Override
	public long savePrimaryComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm) {
		// TODO Auto-generated method stub
		String content = commentForm.getContent();
		
		long commentId = commentDAO.savePrimaryComment(uid, commodyId, content);
		
		
		return commentId;
	}

	@Override
	public PrimaryCommodyComment getCommodyCommentByCommentId(long commentId) {
		// TODO Auto-generated method stub
		return commentDAO.get(commentId);
	}

	@Override
	public List<PrimaryCommodyComment> getAllPrimaryCommentByCommodyId(Long commodyId) {
		// TODO Auto-generated method stub
		return commentDAO.getAllPrimaryCommentByCommodyId(commodyId);
	}

	@Override
	public long saveReplyComment(Long uid, Long commodyId, PubReplyCommodyCommentForm replyCommentForm) {
		// TODO Auto-generated method stub
		return commentDAO.saveReplyComment(uid, commodyId , replyCommentForm.getBelongPrimaryCommentId(), replyCommentForm.getReplyTargetCommentId(),
				replyCommentForm.getContent());
	}

}
