package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.subscriptionsystem.action.entity.PostTrendAction;

public class PostTrendNotice extends BbsTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long topicId;

	private String postDigest; 
	
	private Long postId;

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getPostDigest() {
		return postDigest;
	}

	public void setPostDigest(String postDigest) {
		this.postDigest = postDigest;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PostTrendNotice(PostTrendAction action) {
		super(action.getPubTime(), TrendNoticeType.PostTrendNotice);
		this.postDigest = action.getTargetPost().getContent();
		this.postId = action.getTargetPost().getId();
		this.topicId = action.getTopic().getId();
	}
}
