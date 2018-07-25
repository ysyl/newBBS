package bbs.shop.entity;

import java.util.Date;
import bbs.shop.enuma.CommentType;

public class TCommodyComment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Date pubTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.commody_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Long commodyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.user_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.reply_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Long replyCommentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.content
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.comment_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private CommentType commentType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_comment.belong_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Long belongCommentId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.id
	 * @return  the value of t_commody_comment.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.id
	 * @param id  the value for t_commody_comment.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.pub_time
	 * @return  the value of t_commody_comment.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.pub_time
	 * @param pubTime  the value for t_commody_comment.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.commody_id
	 * @return  the value of t_commody_comment.commody_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Long getCommodyId() {
		return commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.commody_id
	 * @param commodyId  the value for t_commody_comment.commody_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setCommodyId(Long commodyId) {
		this.commodyId = commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.user_id
	 * @return  the value of t_commody_comment.user_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.user_id
	 * @param userId  the value for t_commody_comment.user_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.reply_comment_id
	 * @return  the value of t_commody_comment.reply_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Long getReplyCommentId() {
		return replyCommentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.reply_comment_id
	 * @param replyCommentId  the value for t_commody_comment.reply_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setReplyCommentId(Long replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.content
	 * @return  the value of t_commody_comment.content
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.content
	 * @param content  the value for t_commody_comment.content
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.comment_type
	 * @return  the value of t_commody_comment.comment_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public CommentType getCommentType() {
		return commentType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.comment_type
	 * @param commentType  the value for t_commody_comment.comment_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_comment.belong_comment_id
	 * @return  the value of t_commody_comment.belong_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Long getBelongCommentId() {
		return belongCommentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_comment.belong_comment_id
	 * @param belongCommentId  the value for t_commody_comment.belong_comment_id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setBelongCommentId(Long belongCommentId) {
		this.belongCommentId = belongCommentId;
	}
}