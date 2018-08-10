package bbs.forum.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import bbs.forum.enuma.Sex;

public class User implements Serializable {

	private Long id;
	
	private String nickname;
	
	private Sex sex;
	
	private Integer credit;
	
	private Long topicAmount;
	
	private Long followingAmount;
	
	private String avatar;
	
	private Date registerTime;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	//一个用户由其id和创建日期标记
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Random(this.getClass().getName().hashCode() + this.id).nextInt(Integer.MAX_VALUE);
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
