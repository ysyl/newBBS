package bbs.usercenter.collection.DAO.entity;

import bbs.forum.DTO.Post;

public class PostCollection extends BaseCollection {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
