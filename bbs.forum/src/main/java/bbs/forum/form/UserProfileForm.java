package bbs.forum.form;

import bbs.forum.enuma.Sex;

public class UserProfileForm {

	private String nickname;
	
	private Sex sex;

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
	
	
}
