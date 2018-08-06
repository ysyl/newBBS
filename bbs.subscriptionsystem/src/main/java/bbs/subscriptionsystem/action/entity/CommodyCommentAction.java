package bbs.subscriptionsystem.action.entity;

import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.usercenter.userprofile.DTO.UserProfile;

public class CommodyCommentAction extends CommodyTrendAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserProfile user;
	
	private BaseCommodyComment comment;

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public BaseCommodyComment getComment() {
		return comment;
	}

	public void setComment(BaseCommodyComment comment) {
		this.comment = comment;
	}

}
