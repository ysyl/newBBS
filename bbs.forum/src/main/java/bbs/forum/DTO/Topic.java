package bbs.forum.DTO;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {

	private Long id;

	private String title;

	private Date pubTime;

	private User lastReplier;

	private Integer views;

	private Integer replies;

	private Post mainPost;

	private Forum forum;

	private Post lastReplyPost;

	public Post getMainPost() {
		return mainPost;
	}

	public void setMainPost(Post mainPost) {
		this.mainPost = mainPost;
	}

	public Post getLastReplyPost() {
		return lastReplyPost;
	}

	public void setLastReplyPost(Post lastReplyPost) {
		this.lastReplyPost = lastReplyPost;
	}

	private User author;

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getAuthor() {
		return author;
	}

	public Long getId() {
		return id;
	}

	public User getLastReplier() {
		return lastReplier;
	}

	public void setLastReplier(User lastReplier) {
		this.lastReplier = lastReplier;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getReplies() {
		return replies;
	}

	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	public String toString() {
		return "\nTopic: {" + "\n\tid:" + this.id + "\n\ttitle: " + this.title + "\n\tauthor: " + this.author + "\n}";
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
}
