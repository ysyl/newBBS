package bbs.chat.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.forum.DTO.User;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String content;
	
	private Date pubTime;
	
	private Boolean isReaded; 
	
	private User sender;
	
	private BaseChat chat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Boolean getIsReaded() {
		return isReaded;
	}

	public void setIsReaded(Boolean isReaded) {
		this.isReaded = isReaded;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public BaseChat getChat() {
		return chat;
	}

	public void setChat(BaseChat chat) {
		this.chat = chat;
	}
}
