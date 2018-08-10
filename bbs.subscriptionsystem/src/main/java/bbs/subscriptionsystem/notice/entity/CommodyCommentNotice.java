package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.forum.DTO.User;
import bbs.shop.entity.BaseCommodyComment;
import bbs.shop.entity.Commody;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;

public class CommodyCommentNotice extends CommodyTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommodyCommentNotice(CommodyCommentAction action) {
		super(action.hashCode(), action.getPubTime(), action.getCommody().getTitle(), action.getCommody().getId(),
				ShopTrendNoticeType.COMMODY_COMMENT);
		this.nickname = action.getUser().getNickname();
		this.userId = action.getUser().getId();
		this.commentId = action.getComment().getId();
		this.commentContent = action.getComment().getContent();
	}

	private String nickname;
	
	private Long userId;
	
	private Long commentId;
	
	private String commentContent;

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

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

}
