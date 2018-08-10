package bbs.shop.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.forum.DTO.User;

public class BaseCommodyComment implements Serializable {
	
	private Long id;

	private String content;
	
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	//一个comment由user，commody, id标记
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return  id.hashCode() + user.hashCode() + commody.hashCode();
	}
}
