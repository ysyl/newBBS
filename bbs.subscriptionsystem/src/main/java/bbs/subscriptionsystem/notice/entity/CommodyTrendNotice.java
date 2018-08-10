package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.shop.entity.Commody;

public class CommodyTrendNotice extends ShopTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommodyTrendNotice(int id, Date pubTime, String commodyTitle, Long commodyId, ShopTrendNoticeType shopTrendNoticeType) {
		super(id, pubTime, shopTrendNoticeType);
		// TODO Auto-generated constructor stub
		this.commodyTitle = commodyTitle;
		this.commodyId = commodyId;
	}
	
	private String commodyTitle;
	
	private Long commodyId;

	public String getCommodyTitle() {
		return commodyTitle;
	}

	public void setCommodyTitle(String commodyTitle) {
		this.commodyTitle = commodyTitle;
	}

	public Long getCommodyId() {
		return commodyId;
	}

	public void setCommodyId(Long commodyId) {
		this.commodyId = commodyId;
	}

}
