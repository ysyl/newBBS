package bbs.shop.entity;

public class ReplyCommodyComment extends BaseCommodyComment {

	private ReplyCommodyComment replyTargetComment;
	
	private PrimaryCommodyComment primaryCommodyComment;

	public ReplyCommodyComment getReplyTargetComment() {
		return replyTargetComment;
	}

	public void setReplyTargetComment(ReplyCommodyComment replyTargetComment) {
		this.replyTargetComment = replyTargetComment;
	}

	public PrimaryCommodyComment getPrimaryCommodyComment() {
		return primaryCommodyComment;
	}

	public void setPrimaryCommodyComment(PrimaryCommodyComment primaryCommodyComment) {
		this.primaryCommodyComment = primaryCommodyComment;
	}

}
