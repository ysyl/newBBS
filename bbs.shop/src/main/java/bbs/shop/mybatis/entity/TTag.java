package bbs.shop.mybatis.entity;

public class TTag {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_tag.id
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_tag.name
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	private String name;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_tag.id
	 * @return  the value of t_tag.id
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_tag.id
	 * @param id  the value for t_tag.id
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_tag.name
	 * @return  the value of t_tag.name
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_tag.name
	 * @param name  the value for t_tag.name
	 * @mbg.generated  Fri Aug 03 10:55:22 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}
}