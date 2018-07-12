package bbs.usercenter.collection.DAO.entity;

import bbs.forum.DTO.Topic;

public class TopicCollection extends BaseCollection {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Topic topic;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
