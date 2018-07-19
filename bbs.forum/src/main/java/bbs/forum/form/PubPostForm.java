package bbs.forum.form;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

public class PubPostForm extends AbstractForm {

	@NotBlank
	private String content;
	
	@NotBlank
	private String htmlContent;
	
	private Long replyPostId;

	@NotBlank
	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

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
