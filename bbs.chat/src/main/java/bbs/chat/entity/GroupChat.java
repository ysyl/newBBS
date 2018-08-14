package bbs.chat.entity;

import java.util.List;

import bbs.forum.DTO.User;

public class GroupChat extends BaseChat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> recipients;
	
	private String groupName;

	public List<User> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<User> recipients) {
		this.recipients = recipients;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
