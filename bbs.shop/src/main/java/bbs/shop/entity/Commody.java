package bbs.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import bbs.forum.DTO.User;


public class Commody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private User user;

	private String title;
	
	private String description;
	
	private Integer price;
	
	private List<CommodyImg> commodyImgList;
	
	private Date pubTime;
	
	private Date lastModifiedTime;
	
	private CommodyClassification commodyClassification;
	
	private List<SubClass> subClassList;
	
	private List<Keyword> keywordList;
	
	private Integer views;
	
	private	Integer replies; 
	
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getReplies() {
		return replies;
	}

	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		this.keywordList = keywordList;
	}

	public List<SubClass> getSubClassList() {
		return subClassList;
	}

	public void setSubClassList(List<SubClass> subClassList) {
		this.subClassList = subClassList;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	//一个commody由id user pubTim标记
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) this.id + user.hashCode() + pubTime.hashCode();
	}
	
	
}
