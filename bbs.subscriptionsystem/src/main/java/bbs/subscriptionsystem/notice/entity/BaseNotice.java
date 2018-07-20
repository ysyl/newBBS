package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseNotice implements Serializable {
	
	private Date pubTime;

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public BaseNotice(Date pubTime) {
		super();
		this.pubTime = pubTime;
	}
	

}
