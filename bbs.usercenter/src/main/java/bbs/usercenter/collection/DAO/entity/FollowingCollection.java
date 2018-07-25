package bbs.usercenter.collection.DAO.entity;

import java.io.Serializable;

import bbs.forum.DTO.User;
import bbs.usercenter.userprofile.DTO.UserProfile;

public class FollowingCollection extends BaseCollection {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User following;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getFollowing() {
		return following;
	}

	public void setFollowing(User following) {
		this.following = following;
	}
	
}
