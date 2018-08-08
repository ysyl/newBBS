package bbs.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import bbs.shop.DAO.CommodyClassificationDAO;
import bbs.shop.DAO.CommodyCommentDAO;
import bbs.shop.DAO.CommodyDAO;
import bbs.shop.DAO.SubClassDAO;
import bbs.shop.DAO.UserPerferenceDAO;
import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.Keyword;
import bbs.shop.entity.PrimaryCommodyComment;
import bbs.shop.entity.SubClass;
import bbs.shop.entity.UserPerference;
import bbs.shop.enuma.CommentType;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.UpdateCommodyForm;
import bbs.shop.generator.CommodyRecommendGenerator;

@Service
@Transactional
public class ShopServiceImp implements ShopService {
	
	private CommodyDAO commodyDAO;
	
	private CommodyCommentDAO commentDAO;
	
	private UserPerferenceDAO userPerferenceDAO;
	
	private CommodyClassificationDAO classDAO;
	
	private SubClassDAO subClassDAO;
	
	private CommodyRecommendGenerator recommendGenerator;

	@Autowired
	public ShopServiceImp(CommodyDAO commodyDAO, CommodyCommentDAO commentDAO, UserPerferenceDAO userPerferenceDAO,
			CommodyClassificationDAO classDAO, SubClassDAO subClassDAO, CommodyRecommendGenerator recommendGenerator) {
		super();
		this.commodyDAO = commodyDAO;
		this.commentDAO = commentDAO;
		this.userPerferenceDAO = userPerferenceDAO;
		this.classDAO = classDAO;
		this.subClassDAO = subClassDAO;
		this.recommendGenerator = recommendGenerator;
	}

	public Long saveCommody(Long uid, String title, String description, Integer price, List<String> imgFileNames, Integer commodyClassificationId, List<Integer> subClassList  ) {
		// TODO Auto-generated method stub
		return commodyDAO.save(uid, title, description, price, imgFileNames, commodyClassificationId, subClassList);
	}

	public Commody getCommody(Long uid, Long commodyId) {
		// TODO Auto-generated method stub
		return commodyDAO.get(commodyId);
	}

	public void updateCommody(Long commodyId, String title, String description,Integer price,  List<String> imgFileNames, int commodyClassificationId, List<Integer> subClassIdList) {
		// TODO Auto-generated method stub
		
		commodyDAO.update(commodyId, title, description, price, imgFileNames, commodyClassificationId, subClassIdList);
	}

	@Override
	public Long savePrimaryComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm) {
		// TODO Auto-generated method stub
		String content = commentForm.getContent();
		
		Long commentId = commentDAO.savePrimaryComment(uid, commodyId, content);
		
		
		return commentId;
	}

	@Override
	public PrimaryCommodyComment getCommodyCommentByCommentId(Long commentId) {
		// TODO Auto-generated method stub
		return commentDAO.get(commentId);
	}

	@Override
	public List<PrimaryCommodyComment> getAllPrimaryCommentByCommodyId(Long commodyId) {
		// TODO Auto-generated method stub
		return commentDAO.getAllPrimaryCommentByCommodyId(commodyId);
	}

	@Override
	public Long saveReplyComment(Long uid, Long commodyId, PubReplyCommodyCommentForm replyCommentForm) {
		// TODO Auto-generated method stub
		return commentDAO.saveReplyComment(uid, commodyId , replyCommentForm.getBelongPrimaryCommentId(), replyCommentForm.getReplyTargetCommentId(),
				replyCommentForm.getContent());
	}

	@Override
	public void saveToUserPerference(Long uid, List<Keyword> keywordList) {
		// TODO Auto-generated method stub
		for(Keyword keyword : keywordList) {
			userPerferenceDAO.saveKeywordStatistics(uid, keyword);
		}
	}

	@Override
	public List<CommodyClassification> getAllClassification() {
		// TODO Auto-generated method stub
		return classDAO.getAllClassification();
	}

	@Override
	public List<Commody> getYouMayLikeCommody(Long uid) {
		// TODO Auto-generated method stub
		return recommendGenerator.generateYouMayLikeCommodyRecommend(uid);
	}

	@Override
	public Map<CommodyClassification, List<Commody>> getAllClassRecommendCommody(Long uid) {
		// TODO Auto-generated method stub
		return recommendGenerator.generateCommodyClassHotRecommend(uid);
	}

	@Override
	public UserPerference getUserPerference(Long uid) {
		// TODO Auto-generated method  stub
		return userPerferenceDAO.getUserPerferenceByUid(uid);
	}

	@Override
	public List<Commody> searchByKeyword(Long uid, String titleKeyword) {
		// TODO Auto-generated method stub
		return commodyDAO.searchByKeyword(titleKeyword);
	}

	@Override
	public CommodyClassification getCommodyClassificationById(Integer classificationId) {
		// TODO Auto-generated method stub
		return classDAO.getById(classificationId);
	}

	@Override
	public List<Commody> searchByClassificationId(Long uid, Integer classificationId) {
		return commodyDAO.searchCommodyByClassificationId(classificationId);
	}

	@Override
	public List<Commody> searchBySubClassId(Long uid, int subClassId) {
		// TODO Auto-generated method stub
		return commodyDAO.searchCommodyBySubClassId(subClassId);
	}

	@Override
	public SubClass getSubClass(int subClassId) {
		// TODO Auto-generated method stub
		return subClassDAO.getSubClass(subClassId);
	}

	@Override
	public List<Commody> getAllCommodyBySellerId(long userId) {
		// TODO Auto-generated method stub
		return commodyDAO.getCommodyBySellerId(userId);
	}

}
