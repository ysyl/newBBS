package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;
import bbs.usercenter.userprofile.DTO.UserProfile;

public class CommodyCommentNotice extends CommodyTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommodyCommentNotice(CommodyCommentAction action) {
		super(action.getPubTime(), action.getCommody());
		this.comment = action.getComment();
		this.user = action.getUser();
	}

	private UserProfile user;
	
	private BaseCommodyComment comment;

	public BaseCommodyComment getComment() {
		return comment;
	}

	public void setComment(BaseCommodyComment comment) {
		this.comment = comment;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}	

}
