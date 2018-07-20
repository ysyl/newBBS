package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseTrendNotice extends BaseNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TrendNoticeType trendNoticeType;

	public TrendNoticeType getTrendNoticeType() {
		return trendNoticeType;
	}


	public BaseTrendNotice(Date pubTime, TrendNoticeType trendNoticeType) {
		super(pubTime);
		this.trendNoticeType = trendNoticeType;
	}
}
