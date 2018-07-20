package bbs.subscriptionsystem.action.entity;
import java.io.Serializable;
import java.util.Date;

public class BaseAction implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date pubTime;

	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
