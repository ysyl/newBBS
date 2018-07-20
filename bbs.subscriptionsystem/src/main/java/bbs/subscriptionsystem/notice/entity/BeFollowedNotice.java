package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.forum.DTO.User;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;

//消息格式：用户xxx关注了你
public class BeFollowedNotice extends BaseNotice {
	
	private User follower;

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public BeFollowedNotice(BeFollowedAction action) {
		super(action.getPubTime());
		this.follower = action.getFollower();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
