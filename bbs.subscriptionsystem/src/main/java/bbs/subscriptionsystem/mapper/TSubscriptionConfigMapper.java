package bbs.subscriptionsystem.mapper;

import bbs.subscriptionsystem.entity.TSubscriptionConfig;
import bbs.subscriptionsystem.entity.TSubscriptionConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSubscriptionConfigMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	long countByExample(TSubscriptionConfigExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int deleteByExample(TSubscriptionConfigExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int insert(TSubscriptionConfig record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int insertSelective(TSubscriptionConfig record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	List<TSubscriptionConfig> selectByExample(TSubscriptionConfigExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	TSubscriptionConfig selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TSubscriptionConfig record,
			@Param("example") TSubscriptionConfigExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByExample(@Param("record") TSubscriptionConfig record,
			@Param("example") TSubscriptionConfigExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByPrimaryKeySelective(TSubscriptionConfig record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_subscription_config
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByPrimaryKey(TSubscriptionConfig record);
}