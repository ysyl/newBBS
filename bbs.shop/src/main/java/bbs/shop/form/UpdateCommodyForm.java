package bbs.shop.form;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UpdateCommodyForm implements Serializable {

	private String title;
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}

	private List<MultipartFile> imgFiles;
	
	private int classificationId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public List<MultipartFile> getImgFiles() {
		return imgFiles;
	}

	public void setImgFiles(List<MultipartFile> imgFiles) {
		this.imgFiles = imgFiles;
	}

}
