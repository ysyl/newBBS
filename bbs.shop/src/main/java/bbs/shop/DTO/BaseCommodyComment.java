package bbs.shop.DTO;

import java.io.Serializable;
import java.util.Date;

import bbs.usercenter.userprofile.DTO.UserProfile;

public class BaseCommodyComment implements Serializable {
	
	private Long id;

	private String content;
	
	private UserProfile user;
	
	private Commody commody;
	
	private Date pubTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Commody getCommody() {
		return commody;
	}

	public void setCommody(Commody commody) {
		this.commody = commody;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
}
