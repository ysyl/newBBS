package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.User;

public class PostTrendAction extends BaseAction {

	private User replier;
	
	private Post targetPost;
	
	private Post replyPost;

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
}
