package bbs.chat.entity;

import bbs.forum.DTO.User;

public class PrivateChat extends BaseChat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User recipient;

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	

}
