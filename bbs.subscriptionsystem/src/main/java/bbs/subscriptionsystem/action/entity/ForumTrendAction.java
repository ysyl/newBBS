package bbs.subscriptionsystem.action.entity;

import java.util.Date;

import bbs.forum.DTO.Announce;
import bbs.forum.DTO.Forum;
import bbs.forum.DTO.User;

public class ForumTrendAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date pubTime;
	
	private User publisher;
	
	private Forum forum;
	
	private Announce announce;

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
