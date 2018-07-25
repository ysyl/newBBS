package bbs.forum.form;

import org.springframework.web.multipart.MultipartFile;

import bbs.forum.enuma.Sex;

public class UpdateUserProfileForm {
	
	private MultipartFile avatarFile;

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

	public MultipartFile getAvatarFile() {
		return avatarFile;
	}

	public void setAvatarFile(MultipartFile avatarFile) {
		this.avatarFile = avatarFile;
	}
	
	
}
