package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.forum.DTO.User;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;

//消息格式：用户xxx关注了你
public class BeFollowedNotice extends BaseNotice {
	
	private Long userId;
	
	private String nickname;

	public BeFollowedNotice(BeFollowedAction action) {
		super(action.hashCode(), action.getPubTime(), NoticeType.BEFOLLOWED_NOTICE);
		this.userId = action.getFollower().getId();
		this.nickname = action.getFollower().getNickname();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
