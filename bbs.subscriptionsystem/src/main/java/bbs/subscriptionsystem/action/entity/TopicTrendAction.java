package bbs.subscriptionsystem.action.entity;

import java.io.Serializable;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;

public class TopicTrendAction extends BaseAction implements Serializable {

	public TopicTrendAction(User replier, Post newReply, Topic topic) {
		super();
		this.replier = replier;
		this.newReply = newReply;
		this.topic = topic;
	}
	public TopicTrendAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User replier;
	private Post newReply;
	private Topic topic;
	public User getReplier() {
		return replier;
	}
	public void setReplier(User replier) {
		this.replier = replier;
	}
	public Post getNewReply() {
		return newReply;
	}
	public void setNewReply(Post newReply) {
		this.newReply = newReply;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
