package bbs.shop.entity;

public class ReplyCommodyComment extends BaseCommodyComment {

	private ReplyCommodyComment replyTargetComment;
	
	private PrimaryCommodyComment belongPrimaryComment;

	public ReplyCommodyComment getReplyTargetComment() {
		return replyTargetComment;
	}

	public void setReplyTargetComment(ReplyCommodyComment replyTargetComment) {
		this.replyTargetComment = replyTargetComment;
	}

	public PrimaryCommodyComment getBelongPrimaryComment() {
		return belongPrimaryComment;
	}

	public void setBelongPrimaryComment(PrimaryCommodyComment belongPrimaryComment) {
		this.belongPrimaryComment = belongPrimaryComment;
	}

}
