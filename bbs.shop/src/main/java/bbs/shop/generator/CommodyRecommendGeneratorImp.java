package bbs.shop.generator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.DAO.CommodyClassificationDAO;
import bbs.shop.DAO.CommodyDAO;
import bbs.shop.DAO.UserPerferenceDAO;
import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.CommodyIndexRecommend;
import bbs.shop.entity.CommodyRecommend;
import bbs.shop.entity.UserPerference;

@Component
public class CommodyRecommendGeneratorImp implements CommodyRecommendGenerator {

	private CommodyDAO commodyDAO;

	private CommodyClassificationDAO classDAO;

	private UserPerferenceDAO userPerferenceDAO;

	@Autowired
	public CommodyRecommendGeneratorImp(CommodyDAO commodyDAO, CommodyClassificationDAO classDAO,
			UserPerferenceDAO userPerferenceDAO) {
		super();
		this.commodyDAO = commodyDAO;
		this.classDAO = classDAO;
		this.userPerferenceDAO = userPerferenceDAO;
	}

	public Map<CommodyClassification, List<Commody>> generateCommodyClassHotRecommend(Long uid) {
		List<CommodyClassification> classifications;
		Map<CommodyClassification, List<Commody>> commodyClassHotRecommendResultMap;
		//如果用户未登录
		if (uid == null) {
			classifications = classDAO.getAllClassification();
			commodyClassHotRecommendResultMap = new LinkedHashMap<>(); 
			for (CommodyClassification classification : classifications) {
				List<Commody> recommendCommodys = commodyDAO.getHotCommodyByClassifitionId(classification.getId());
				commodyClassHotRecommendResultMap.put(classification, recommendCommodys);
			}
			return commodyClassHotRecommendResultMap;
		}
		classifications = classDAO.getAllClassification();
		commodyClassHotRecommendResultMap = new LinkedHashMap<>(); 
		for (CommodyClassification classification : classifications) {
			List<Commody> recommendCommodys = commodyDAO.getHotCommodyByClassifitionId(classification.getId());
			commodyClassHotRecommendResultMap.put(classification, recommendCommodys);
		}
		return commodyClassHotRecommendResultMap;
	}

	public List<Commody> generateYouMayLikeCommodyRecommend(Long uid) {
		if (uid == null) {
			List<Commody> youMayLikeCommodys = commodyDAO.getAll();
			return youMayLikeCommodys;
		}
		List<Commody> youMayLikeCommodys = commodyDAO.getAll();
		return youMayLikeCommodys;
	}
}
