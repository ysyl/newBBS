package bbs.shop.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import bbs.usercenter.userprofile.DTO.UserProfile;


public class Commody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private UserProfile user;
	
	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String title;
	
	private String description;
	
	private List<CommodyImg> commodyImgList;
	
	private Date pubTime;
	
	private Date lastModifiedTime;
	
	private CommodyClassification commodyClassification;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<CommodyImg> getCommodyImgList() {
		return commodyImgList;
	}

	public void setCommodyImgList(List<CommodyImg> commodyImgList) {
		this.commodyImgList = commodyImgList;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public CommodyClassification getCommodyClassification() {
		return commodyClassification;
	}

	public void setCommodyClassification(CommodyClassification commodyClassification) {
		this.commodyClassification = commodyClassification;
	}
	
	
}
