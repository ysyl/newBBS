package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.User;
import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;

public class CommodyCommentAction extends CommodyTrendAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	//CommodyCommentAction由user和comment标记
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getClass().getName().hashCode() + this.getId().hashCode();
	}

}
