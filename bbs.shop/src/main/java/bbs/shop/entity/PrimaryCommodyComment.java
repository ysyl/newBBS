package bbs.shop.entity;

import java.util.List;

public class PrimaryCommodyComment extends BaseCommodyComment {
	
	List<ReplyCommodyComment> replyComments;

	public List<ReplyCommodyComment> getReplyComments() {
		return replyComments;
	}

	public void setReplyComments(List<ReplyCommodyComment> replyComments) {
		this.replyComments = replyComments;
	}

}
