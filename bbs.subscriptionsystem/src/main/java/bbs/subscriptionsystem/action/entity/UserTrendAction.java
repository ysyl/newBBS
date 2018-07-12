package bbs.subscriptionsystem.action.entity;

import java.io.Serializable;
import java.util.Date;

import bbs.forum.DTO.User;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

public abstract class UserTrendAction<T> extends BaseAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private T target;
	
	private UserTrendActionType actionType;
	
	private UserTrendActionTargetType targetType;

	public UserTrendActionTargetType getTargetType() {
		return targetType;
	}

	public void setTargetType(UserTrendActionTargetType targetType) {
		this.targetType = targetType;
	}

	public T getTarget() {
		return this.target;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserTrendActionType getActionType() {
		return actionType;
	}

	public void setActionType(UserTrendActionType actionType) {
		this.actionType = actionType;
	}
	
	public String toString() {
		String result = "\nUserTrendAction: {"
				+ "\n\tactionType: " + this.actionType
				+ "\n\ttargetType: " + this.targetType;
		return result;
	}


}
