package bbs.shop.form;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UpdateCommodyForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String description;
	
	private List<Integer> subClassList;

	private List<MultipartFile> imgFiles;
	
	private Integer classificationId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	public List<MultipartFile> getImgFiles() {
		return imgFiles;
	}

	public void setImgFiles(List<MultipartFile> imgFiles) {
		this.imgFiles = imgFiles;
	}

	public List<Integer> getSubClassList() {
		return subClassList;
	}

	public void setSubClassList(List<Integer> subClassList) {
		this.subClassList = subClassList;
	}

}
