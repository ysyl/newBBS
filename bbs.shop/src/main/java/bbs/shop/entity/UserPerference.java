package bbs.shop.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import bbs.forum.DTO.User;

public class UserPerference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	private List<KeywordStatistic> keywordStatisticList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<KeywordStatistic> getKeywordStatisticList() {
		return keywordStatisticList;
	}

	public void setKeywordStatisticList(List<KeywordStatistic> keywordStatisticList) {
		this.keywordStatisticList = keywordStatisticList;
	}
	

}
