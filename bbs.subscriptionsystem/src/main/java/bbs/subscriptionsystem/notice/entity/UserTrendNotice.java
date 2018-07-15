package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.subscriptionsystem.action.entity.AbstractCollectAction;
import bbs.subscriptionsystem.action.entity.AbstractPubAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;

public class UserTrendNotice extends BaseNotice  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nickname;
	
	private Long userId;
	
	private String actionType;
	
	private String targetType;
	
	private String targetDigest;
	
	private Long targetId;
	
	private Date pubTime;

	public UserTrendNotice(UserTrendAction<?> action) {
		this.nickname = action.getUser().getNickname();
		this.userId = action.getUser().getId();
		this.setPubTime(action.getPubTime());

		if (action instanceof AbstractCollectAction) {
			this.actionType = "收藏了";
		} 
		else if (action instanceof AbstractPubAction) {
			this.actionType = "发布了";
		}

		switch(action.getTargetType()) {
		case TOPIC:
			this.targetType = "主题";
			Topic topic = ((Topic)action.getTarget());
			this.targetDigest = topic.getTitle();
			this.targetId = topic.getId();
			break;
		case POST:
			this.targetType = "回复";
			Post post = ((Post)action.getTarget());
			this.targetDigest = post.getContent();
			this.targetId = post.getId();
			break;
		}
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getTargetDigest() {
		return targetDigest;
	}

	public void setTargetDigest(String targetDigest) {
		this.targetDigest = targetDigest;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
}
