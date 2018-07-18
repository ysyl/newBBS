package bbs.subscriptionsystem.notice.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.subscriptionsystem.action.entity.TopicTrendAction;

public class TopicTrendNotice extends BaseNotice  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String topicTitle;
	
	private Long topicId;
	
	private Date pubTime;
	
	private Long repostId;

	public TopicTrendNotice(TopicTrendAction action) {
		this.topicTitle = action.getTopic().getTitle();
		this.topicId = action.getTopic().getId();
		this.pubTime = action.getPubTime();
		this.repostId = action.getNewReply().getId();
		this.setTrendNoticeType(TrendNoticeType.TopicTrendNotice);
	}

	public Long getRepostId() {
		return repostId;
	}

	public void setRepostId(Long repostId) {
		this.repostId = repostId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	
	
}
