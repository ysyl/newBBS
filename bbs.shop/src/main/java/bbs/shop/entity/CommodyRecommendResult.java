package bbs.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommodyRecommendResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Commody> youMayLikeCommodyList = new ArrayList<>();

	private List<Commody> HotCommodyList = new ArrayList<>();
	
	private Map<CommodyClassification, Commody> commodyRecommendMap = new HashMap<>();

	public List<Commody> getYouMayLikeCommodyList() {
		return youMayLikeCommodyList;
	}

	public void setYouMayLikeCommodyList(List<Commody> youMayLikeCommodyList) {
		this.youMayLikeCommodyList = youMayLikeCommodyList;
	}

	public List<Commody> getHotCommodyList() {
		return HotCommodyList;
	}

	public void setHotCommodyList(List<Commody> hotCommodyList) {
		HotCommodyList = hotCommodyList;
	}

	public Map<CommodyClassification, Commody> getCommodyRecommendMap() {
		return commodyRecommendMap;
	}

	public void setCommodyRecommendMap(Map<CommodyClassification, Commody> commodyRecommendMap) {
		this.commodyRecommendMap = commodyRecommendMap;
	}

}
