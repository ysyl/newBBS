package bbs.forum.DTO;

import java.io.Serializable;

import bbs.forum.enuma.Sex;

public class User implements Serializable {

	private Long id;
	
	private String nickname;
	
	private Sex sex;
	
	private Integer credit;
	
	private Long topicAmount;
	
	private Long followingAmount;

	public Long getTopicAmount() {
		return topicAmount;
	}

	public void setTopicAmount(Long topicAmount) {
		this.topicAmount = topicAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String toString() {
		return "\nUser: {"
		   		+ "\n\tid:" + this.id
				   + "\n\tnickname: " + this.nickname
				   + "\n}";
	}

	public Long getFollowingAmount() {
		return followingAmount;
	}

	public void setFollowingAmount(Long followingAmount) {
		this.followingAmount = followingAmount;
	}
}
