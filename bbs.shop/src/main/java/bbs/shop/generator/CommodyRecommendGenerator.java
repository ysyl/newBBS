package bbs.shop.generator;

import java.util.List;
import java.util.Map;

import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.UserPerference;

public interface CommodyRecommendGenerator {
	
	public Map<CommodyClassification, List<Commody>> generateCommodyClassHotRecommend(Long uid);
	
	public List<Commody> generateYouMayLikeCommodyRecommend(Long uid);

}
