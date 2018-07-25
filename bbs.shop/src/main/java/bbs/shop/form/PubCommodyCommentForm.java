package bbs.shop.form;

import java.io.Serializable;

public class PubCommodyCommentForm implements Serializable {

	private String content;
	
	private Long commodyId;
	
	private Long replyCommentId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCommodyId() {
		return commodyId;
	}

	public void setCommodyId(Long commodyId) {
		this.commodyId = commodyId;
	}

	public Long getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(Long replyCommentId) {
		this.replyCommentId = replyCommentId;
	}
}
