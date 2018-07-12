package bbs.forum.form;

public class PubPostForm extends AbstractForm {

	private String content;
	
	private Long replyPostId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getReplyPostId() {
		return replyPostId;
	}

	public void setReplyPostId(Long postId) {
		this.replyPostId = postId;
	}
}
