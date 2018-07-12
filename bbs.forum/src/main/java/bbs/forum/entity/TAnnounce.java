package bbs.forum.entity;

import java.util.Date;

public class TAnnounce {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.publisher_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private Long publisherId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.content
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.forum_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private Integer forumId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.pub_time
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private Date pubTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_announce.title
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	private String title;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.id
	 * @return  the value of t_announce.id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.id
	 * @param id  the value for t_announce.id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.publisher_id
	 * @return  the value of t_announce.publisher_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public Long getPublisherId() {
		return publisherId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.publisher_id
	 * @param publisherId  the value for t_announce.publisher_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.content
	 * @return  the value of t_announce.content
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.content
	 * @param content  the value for t_announce.content
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.forum_id
	 * @return  the value of t_announce.forum_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public Integer getForumId() {
		return forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.forum_id
	 * @param forumId  the value for t_announce.forum_id
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.pub_time
	 * @return  the value of t_announce.pub_time
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.pub_time
	 * @param pubTime  the value for t_announce.pub_time
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_announce.title
	 * @return  the value of t_announce.title
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_announce.title
	 * @param title  the value for t_announce.title
	 * @mbg.generated  Tue Jul 10 12:44:08 CST 2018
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}