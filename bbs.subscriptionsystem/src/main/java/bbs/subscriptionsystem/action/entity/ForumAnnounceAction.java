package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.User;

public class ForumAnnounceAction extends BaseTrendAction {

	public User publisher;
	
	public String content;

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
