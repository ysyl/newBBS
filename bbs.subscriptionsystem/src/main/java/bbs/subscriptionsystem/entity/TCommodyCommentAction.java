package bbs.subscriptionsystem.entity;

import java.util.Date;

public class TCommodyCommentAction {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment_action.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment_action.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long commodyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment_action.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long commentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment_action.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment_action.pub_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Date pubTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment_action.id
	 * @return  the value of t_commody_comment_action.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment_action.id
	 * @param id  the value for t_commody_comment_action.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment_action.commody_id
	 * @return  the value of t_commody_comment_action.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getCommodyId() {
		return commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment_action.commody_id
	 * @param commodyId  the value for t_commody_comment_action.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setCommodyId(Long commodyId) {
		this.commodyId = commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment_action.comment_id
	 * @return  the value of t_commody_comment_action.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment_action.comment_id
	 * @param commentId  the value for t_commody_comment_action.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment_action.user_id
	 * @return  the value of t_commody_comment_action.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment_action.user_id
	 * @param userId  the value for t_commody_comment_action.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment_action.pub_time
	 * @return  the value of t_commody_comment_action.pub_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment_action.pub_time
	 * @param pubTime  the value for t_commody_comment_action.pub_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
}