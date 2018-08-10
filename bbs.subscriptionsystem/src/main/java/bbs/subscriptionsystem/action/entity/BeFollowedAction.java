package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.User;

public class BeFollowedAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CollectUserAction rawAction;
	
	private User follower;
	
	private User followingUser;
	
	public CollectUserAction getRawAction() {
		return rawAction;
	}

	public void setRawAction(CollectUserAction rawAction) {
		this.rawAction = rawAction;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public BeFollowedAction(CollectUserAction collectUserAction) {
		this.follower = collectUserAction.getUser();
		this.followingUser = collectUserAction.getTarget();
		this.rawAction = collectUserAction;
	}

	public User getFollowingUser() {
		return followingUser;
	}

	public void setFollowingUser(User followingUser) {
		this.followingUser = followingUser;
	}

	//BeFollowingAction 由 follower followingUser标记
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getClass().getName().hashCode() + this.rawAction.hashCode();
	}
}
