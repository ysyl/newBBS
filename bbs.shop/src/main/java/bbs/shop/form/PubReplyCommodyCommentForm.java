package bbs.shop.form;

import java.io.Serializable;

public class PubReplyCommodyCommentForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content;
	
	private Long belongPrimaryCommentId;
	
	private Long replyTargetCommentId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getBelongPrimaryCommentId() {
		return belongPrimaryCommentId;
	}

	public void setBelongPrimaryCommentId(Long belongPrimaryCommentId) {
		this.belongPrimaryCommentId = belongPrimaryCommentId;
	}

	public Long getReplyTargetCommentId() {
		return replyTargetCommentId;
	}

	public void setReplyTargetCommentId(Long replyTargetCommentId) {
		this.replyTargetCommentId = replyTargetCommentId;
	}

}
