package bbs.usercenter.userprofile.DTO;

import java.io.Serializable;
import java.util.Date;
import bbs.forum.enuma.Sex;

public class UserProfile implements Serializable {

	private Long id;
	
	private String nickname;
	
	private Sex sex;
	
	private Date lastLoginTime;
	
	private Date registerTime;
	
	private Long topicAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Long getTopicAmount() {
		return topicAmount;
	}

	public void setTopicAmount(Long topicAmount) {
		this.topicAmount = topicAmount;
	}
	
}
