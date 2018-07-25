package bbs.shop.DAO;

import bbs.shop.DTO.CommodyRecommend;
import bbs.shop.mapper.TCommodyRecommendMapper;

public class CommodyRecommendDAO {
	
	private TCommodyRecommendMapper mapper;

	public CommodyRecommend getCommodyRecommendById(int recommendId) {
		return mapper.selectCommodyRecommendById(recommendId);
	}
}
