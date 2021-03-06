package bbs.subscriptionsystem.entity;

import bbs.subscriptionsystem.enuma.SubscriptionType;
import java.util.Date;

public class TSubscription {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.last_read_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Date lastReadTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.subscription_type
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private SubscriptionType subscriptionType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.following_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long followingId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.forum_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Integer forumId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.subscribe_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Date subscribeTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.topic_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long topicId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.post_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long postId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long commodyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subscription.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	private Long commentId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.id
	 * @return  the value of t_subscription.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.id
	 * @param id  the value for t_subscription.id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.last_read_time
	 * @return  the value of t_subscription.last_read_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Date getLastReadTime() {
		return lastReadTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.last_read_time
	 * @param lastReadTime  the value for t_subscription.last_read_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setLastReadTime(Date lastReadTime) {
		this.lastReadTime = lastReadTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.user_id
	 * @return  the value of t_subscription.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.user_id
	 * @param userId  the value for t_subscription.user_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.subscription_type
	 * @return  the value of t_subscription.subscription_type
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.subscription_type
	 * @param subscriptionType  the value for t_subscription.subscription_type
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.following_id
	 * @return  the value of t_subscription.following_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getFollowingId() {
		return followingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.following_id
	 * @param followingId  the value for t_subscription.following_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.forum_id
	 * @return  the value of t_subscription.forum_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Integer getForumId() {
		return forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.forum_id
	 * @param forumId  the value for t_subscription.forum_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.subscribe_time
	 * @return  the value of t_subscription.subscribe_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Date getSubscribeTime() {
		return subscribeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.subscribe_time
	 * @param subscribeTime  the value for t_subscription.subscribe_time
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.topic_id
	 * @return  the value of t_subscription.topic_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getTopicId() {
		return topicId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.topic_id
	 * @param topicId  the value for t_subscription.topic_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.post_id
	 * @return  the value of t_subscription.post_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.post_id
	 * @param postId  the value for t_subscription.post_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.commody_id
	 * @return  the value of t_subscription.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getCommodyId() {
		return commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.commody_id
	 * @param commodyId  the value for t_subscription.commody_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setCommodyId(Long commodyId) {
		this.commodyId = commodyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subscription.comment_id
	 * @return  the value of t_subscription.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subscription.comment_id
	 * @param commentId  the value for t_subscription.comment_id
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
}