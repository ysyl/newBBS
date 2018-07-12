package bbs.usercenter.collection.DAO.entity;

import bbs.forum.DTO.Forum;

public class ForumCollection extends BaseCollection {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Forum forum;

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
