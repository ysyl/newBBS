package bbs.subscriptionsystem.subscription.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.forum.DTO.User;

public class BaseSubscription<Target> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date subscribeTime;
	private User user;
	private Date lastReadTime;
	private Target target;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public Date getLastReadTime() {
		return lastReadTime;
	}
	public void setLastReadTime(Date lastReadTime) {
		this.lastReadTime = lastReadTime;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
