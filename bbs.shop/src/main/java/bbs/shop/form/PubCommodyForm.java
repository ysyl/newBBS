package bbs.shop.form;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PubCommodyForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String description;
	
	private Integer price;
	
	private List<MultipartFile> imgFile;
	
	private int commodyClassificationId;
	
	private List<Integer> subClassList;

	public int getCommodyClassificationId() {
		return commodyClassificationId;
	}

	public void setCommodyClassificationId(int commodyClassificationId) {
		this.commodyClassificationId = commodyClassificationId;
	}

	public List<MultipartFile> getImgFile() {
		return imgFile;
	}

	public void setImgFile(List<MultipartFile> imgFile) {
		this.imgFile = imgFile;
	}

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

	public List<Integer> getSubClassList() {
		return subClassList;
	}

	public void setSubClassList(List<Integer> subClassList) {
		this.subClassList = subClassList;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
