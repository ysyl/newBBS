package bbs.usercenter.mybatis.entity;

import bbs.forum.enuma.Sex;

public class TUserProfile {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_profile.id
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_profile.nickname
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	private String nickname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_profile.sex
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	private Sex sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_profile.credit
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	private Integer credit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_profile.avatar
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	private String avatar;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_profile.id
	 * @return  the value of t_user_profile.id
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_profile.id
	 * @param id  the value for t_user_profile.id
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_profile.nickname
	 * @return  the value of t_user_profile.nickname
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_profile.nickname
	 * @param nickname  the value for t_user_profile.nickname
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_profile.sex
	 * @return  the value of t_user_profile.sex
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_profile.sex
	 * @param sex  the value for t_user_profile.sex
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_profile.credit
	 * @return  the value of t_user_profile.credit
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public Integer getCredit() {
		return credit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_profile.credit
	 * @param credit  the value for t_user_profile.credit
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_profile.avatar
	 * @return  the value of t_user_profile.avatar
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_profile.avatar
	 * @param avatar  the value for t_user_profile.avatar
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}