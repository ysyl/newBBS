package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;

public class PostTrendAction extends BbsTrendAction {

	private User replier;
	
	private Post targetPost;
	
	private Post replyPost;
	
	private Topic topic;

	public User getReplier() {
		return replier;
	}

	public void setReplier(User replier) {
		this.replier = replier;
	}

	public Post getTargetPost() {
		return targetPost;
	}

	public void setTargetPost(Post targetPost) {
		this.targetPost = targetPost;
	}

	public Post getReplyPost() {
		return replyPost;
	}

	public void setReplyPost(Post replyPost) {
		this.replyPost = replyPost;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getClass().getName().hashCode() + this.getId().hashCode();
	}
}
