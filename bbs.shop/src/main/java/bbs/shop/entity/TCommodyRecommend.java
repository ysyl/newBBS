package bbs.shop.entity;

import java.util.Date;
import bbs.shop.enuma.RecommendType;

public class TCommodyRecommend {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_recommend.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_recommend.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private Date pubTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_commody_recommend.recommend_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	private RecommendType recommendType;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_recommend.id
	 * @return  the value of t_commody_recommend.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_recommend.id
	 * @param id  the value for t_commody_recommend.id
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_recommend.pub_time
	 * @return  the value of t_commody_recommend.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_recommend.pub_time
	 * @param pubTime  the value for t_commody_recommend.pub_time
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_commody_recommend.recommend_type
	 * @return  the value of t_commody_recommend.recommend_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public RecommendType getRecommendType() {
		return recommendType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_commody_recommend.recommend_type
	 * @param recommendType  the value for t_commody_recommend.recommend_type
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setRecommendType(RecommendType recommendType) {
		this.recommendType = recommendType;
	}
}