package bbs.web.utils;

import java.io.File;

public class AvatarGeneratorResult {
	
	private String avatarName;
	
	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public AvatarGeneratorResult(String avatarName, File file) {
		super();
		this.avatarName = avatarName;
		this.file = file;
	}

	private File file;

}
