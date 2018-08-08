package bbs.shop.aop;

import java.util.Set;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.shop.DAO.KeywordDAO;
import bbs.shop.DAO.UserPerferenceDAO;
import bbs.shop.entity.Commody;
import bbs.shop.entity.Keyword;
import bbs.shop.keyword.extractor.KeywordExtractor;

@Aspect
@Component
@Transactional
public class UserPerferenceMonitor {
	
	private KeywordExtractor keywordExtractor;  
	
	private UserPerferenceDAO userPerferenceDAO;

	@Autowired
	public UserPerferenceMonitor(KeywordExtractor keywordExtractor, UserPerferenceDAO userPerferenceDAO) {
		super();
		this.keywordExtractor = keywordExtractor;
		this.userPerferenceDAO = userPerferenceDAO;
	}

	@Pointcut("execution(* bbs.shop.service.ShopService.searchByKeyword(..)) "
			+ "&& args(uid, titleKeyword)")
	public void searchPointcut(Long uid, String titleKeyword) {};
	
	@Pointcut("execution(* bbs.shop.service.ShopService.getCommody(..))"
			+ "&& args(uid, commodyId)")
	public void viewCommody(Long uid, Long commodyId) {};
	
	@AfterReturning(pointcut = "searchPointcut(uid, titleKeyword)")
	public void monitorSearch(Long uid, String titleKeyword) {
		if (uid == null) return;
		MyLogger.infoln(this.getClass(), "搜索商品时对关键词进行分词并添加到关键词表和用户喜好表");
		Set<Keyword> keywords = keywordExtractor.seg(titleKeyword);
		for (Keyword keyword : keywords) {
			try {
				userPerferenceDAO.saveKeywordStatistics(uid, keyword);
			} catch (DataIntegrityViolationException e) {
				// TODO Auto-generated catch block
				userPerferenceDAO.updateKeywordStatistics(uid, keyword);
			} 
		}
	}
	
	@AfterReturning(pointcut="viewCommody(uid, commodyId)", returning="commody")
	public void monitorViewCommody(Long uid, Long commodyId, Commody commody) {
		if (uid == null) return;
		MyLogger.infoln(this.getClass(), "获取商品时尝试分词并添加关键词");
		Integer descriptionLength = commody.getDescription().length();
		Integer subEndPos = descriptionLength > 10?10:descriptionLength;
		Set<Keyword> keywords = keywordExtractor.seg(commody.getTitle() + " / " + commody.getDescription().substring(0, subEndPos));
		MyLogger.infoln(this.getClass(), "关键词数量: " + keywords.size());
		for (Keyword keyword : keywords) {
			try {
				userPerferenceDAO.saveKeywordStatistics(uid, keyword);
			} catch (DataIntegrityViolationException e) {
				// TODO Auto-generated catch block
				userPerferenceDAO.updateKeywordStatistics(uid, keyword);
			} ;
		}
		
		MyLogger.infoln(this.getClass(), "获取classification，将classification添加进关键词");
		MyLogger.infoln(this.getClass(), "获取subClass，将subClass添加进关键词");
	}
}
