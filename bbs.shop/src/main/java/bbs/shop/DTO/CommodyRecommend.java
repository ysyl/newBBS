package bbs.shop.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommodyRecommend implements Serializable {

	private long id;
	
	private Date pubTime;
	
	private List<Commody> commodyList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public List<Commody> getCommodyList() {
		return commodyList;
	}

	public void setCommodyList(List<Commody> commodyList) {
		this.commodyList = commodyList;
	}
}
