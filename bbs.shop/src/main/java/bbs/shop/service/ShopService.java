package bbs.shop.service;

import java.util.List;
import java.util.Map;

import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.Keyword;
import bbs.shop.entity.PrimaryCommodyComment;
import bbs.shop.entity.SubClass;
import bbs.shop.entity.UserPerference;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.UpdateCommodyForm;

public interface ShopService {

	Long saveCommody(Long uid, String title, String description, Integer price, List<String> imgFileNames, Integer commodyClassificationId, List<Integer> subClassList  ); 

	Commody getCommody(Long uid, Long commodyId); 
	
	List<Commody> getAllCommodyBySellerId(long userId);

	void updateCommody(Long commodyId, String title, String description,Integer price, List<String> imgFileNames, int commodyClassificationId, List<Integer> subClassIdList);

	Long savePrimaryComment(Long uid, Long commodyId ,PubPrimaryCommodyCommentForm commentForm);

	BaseCommodyComment getCommodyCommentByCommentId(Long commentId);

	List<PrimaryCommodyComment> getAllPrimaryCommentByCommodyId(Long commodyId);

	Long saveReplyComment(Long uid, Long commodyId , PubReplyCommodyCommentForm replyCommentForm);

	void saveToUserPerference(Long uid, List<Keyword> keywordList);
	
	List<CommodyClassification> getAllClassification();
	
	List<Commody> getYouMayLikeCommody(Long uid);
	
	Map<CommodyClassification, List<Commody>> getAllClassRecommendCommody(Long uid);
	
	UserPerference getUserPerference(Long uid);
	
	List<Commody> searchByKeyword(Long uid, String titleKeyword);

	CommodyClassification getCommodyClassificationById(Integer classificationId);

	List<Commody> searchByClassificationId(Long uid, Integer classificationId);

	List<Commody> searchBySubClassId(Long uid, int subClassId);

	SubClass getSubClass(int subClassId);
}
