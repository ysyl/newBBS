package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

public class BbsTrendNotice extends BaseNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BbsTrendNotice(int id, Date pubTime, NoticeType trendNoticeType) {
		super(id, pubTime, trendNoticeType);
	}
}
