package bbs.forum.resultentity;

import java.io.Serializable;
import java.util.HashMap;

import bbs.forum.DTO.Post;

public class LastPostInForumResult implements Serializable {
	
	private int forumId;
	
	private Post post;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
