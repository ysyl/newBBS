package bbs.subscriptionsystem.action.entity;

import bbs.forum.DTO.Post;
import bbs.forum.DTO.User;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

public class PubPostAction extends AbstractPubAction<Post> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Post target;

	@Override
	public Post getTarget() {
		// TODO Auto-generated method stub
		return target;
	}

	@Override
	public UserTrendActionTargetType getTargetType() {
		// TODO Auto-generated method stub
		return UserTrendActionTargetType.POST;
	}

}
