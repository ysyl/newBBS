package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;

public class BaseNotice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TrendNoticeType trendNoticeType;

	public TrendNoticeType getTrendNoticeType() {
		return trendNoticeType;
	}

	public void setTrendNoticeType(TrendNoticeType trendNoticeType) {
		this.trendNoticeType = trendNoticeType;
	}
}
