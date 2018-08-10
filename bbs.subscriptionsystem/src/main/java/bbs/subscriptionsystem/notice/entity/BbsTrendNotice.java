package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

public class BbsTrendNotice extends BaseNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ForumTrendNoticeType forumTrendNoticeType;

	public BbsTrendNotice(int id, Date pubTime, NoticeType trendNoticeType, ForumTrendNoticeType forumTrendNoticeType) {
		super(id, pubTime, trendNoticeType);
		this.setForumTrendNoticeType(forumTrendNoticeType);
	}

	public ForumTrendNoticeType getForumTrendNoticeType() {
		return forumTrendNoticeType;
	}

	public void setForumTrendNoticeType(ForumTrendNoticeType forumTrendNoticeType) {
		this.forumTrendNoticeType = forumTrendNoticeType;
	}
	
}
