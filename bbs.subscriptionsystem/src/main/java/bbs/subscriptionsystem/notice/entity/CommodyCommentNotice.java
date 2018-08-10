package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.forum.DTO.User;
import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;

public class CommodyCommentNotice extends CommodyTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommodyCommentNotice(CommodyCommentAction action) {
		super(action.hashCode(), action.getPubTime(), action.getCommody());
		this.comment = action.getComment();
		this.setUser(action.getUser());
	}

	private User user;
	
	private BaseCommodyComment comment;

	public BaseCommodyComment getComment() {
		return comment;
	}

	public void setComment(BaseCommodyComment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
