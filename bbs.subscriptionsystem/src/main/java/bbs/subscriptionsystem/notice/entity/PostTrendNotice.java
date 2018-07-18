package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.subscriptionsystem.action.entity.PostTrendAction;

public class PostTrendNotice extends BaseNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Long topicId;

	public String postDigest; 
	
	public Long postId;
	
	public Date pubTime;

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

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PostTrendNotice(PostTrendAction action) {
		this.postDigest = action.getTargetPost().getContent();
		this.postId = action.getTargetPost().getId();
		this.pubTime = action.getPubTime();
		this.topicId = action.getTopic().getId();
		this.setTrendNoticeType(TrendNoticeType.PostTrendNotice);
	}
}
