package bbs.forum.entity;

import bbs.forum.enuma.ManagerGroup;

public class TManager {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_manager.id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_manager.user_id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_manager.manager_group
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	private ManagerGroup managerGroup;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_manager.id
	 * @return  the value of t_manager.id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_manager.id
	 * @param id  the value for t_manager.id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_manager.user_id
	 * @return  the value of t_manager.user_id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_manager.user_id
	 * @param userId  the value for t_manager.user_id
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_manager.manager_group
	 * @return  the value of t_manager.manager_group
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public ManagerGroup getManagerGroup() {
		return managerGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_manager.manager_group
	 * @param managerGroup  the value for t_manager.manager_group
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setManagerGroup(ManagerGroup managerGroup) {
		this.managerGroup = managerGroup;
	}
}