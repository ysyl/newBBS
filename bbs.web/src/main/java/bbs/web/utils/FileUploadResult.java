package bbs.web.utils;

import java.io.File;

public class FileUploadResult {
	
	private String fileName;

	private File file;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String avatarName) {
		this.fileName = avatarName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileUploadResult(String fileName, File file) {
		super();
		this.fileName = fileName;
		this.file = file;
	}

}
