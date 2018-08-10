package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseNotice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//标志通知以免重复
	private int id;
	
	private Date pubTime;

	private NoticeType noticeType;

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public BaseNotice(int id, Date pubTime, NoticeType noticeType) {
		super();
		this.setId(id);
		this.pubTime = pubTime;
		this.setNoticeType(noticeType);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}
	

}
