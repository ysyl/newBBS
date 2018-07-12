package bbs.forum.form;

public class PubAnnounceForm extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer forumId;
	
	private String title;
	
	private String content;

	public Integer getForumId() {
		return forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
