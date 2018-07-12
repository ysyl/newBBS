package bbs.subscriptionsystem.mapper;

import bbs.helper.PageParam;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.entity.TUserTrendAction;
import bbs.subscriptionsystem.entity.TUserTrendActionExample;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserTrendActionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	long countByExample(TUserTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int deleteByExample(TUserTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int insert(TUserTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int insertSelective(TUserTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	List<TUserTrendAction> selectByExample(TUserTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	TUserTrendAction selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TUserTrendAction record,
			@Param("example") TUserTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int updateByExample(@Param("record") TUserTrendAction record, @Param("example") TUserTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int updateByPrimaryKeySelective(TUserTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	int updateByPrimaryKey(TUserTrendAction record);

	List<TUserTrendAction> selectByIdAfterLastReadTime(long uid, Date lastReadTime);

	List<TUserTrendAction> selectByUid(long uid);
	
	List<UserTrendAction<?>> selectAllUidAndTypeAfterLastReadTime(@Param("userId")long uid, 
			@Param("lastReadTime") Date lastReadTime,
			@Param("actionType") UserTrendActionType actionType, 
			@Param("targetType") UserTrendActionTargetType targetType);

	UserTrendAction<?> selectUserTrendActionById(long actionId);
	
//	List<UserTrendAction<?>> selectAllByUidAfterLastReadTime(@Param("userId")long uid, 
//			@Param("lastReadTime") Date lastReadTime,
//			@Param("pageParam") PageParam pageParam);
}