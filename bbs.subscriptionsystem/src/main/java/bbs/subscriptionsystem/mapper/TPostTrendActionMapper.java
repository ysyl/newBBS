package bbs.subscriptionsystem.mapper;

import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.entity.TPostTrendAction;
import bbs.subscriptionsystem.entity.TPostTrendActionExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPostTrendActionMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	long countByExample(TPostTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int deleteByExample(TPostTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int insert(TPostTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int insertSelective(TPostTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	List<TPostTrendAction> selectByExample(TPostTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	TPostTrendAction selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TPostTrendAction record,
			@Param("example") TPostTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByExample(@Param("record") TPostTrendAction record, @Param("example") TPostTrendActionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByPrimaryKeySelective(TPostTrendAction record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	int updateByPrimaryKey(TPostTrendAction record);

	List<PostTrendAction> selectAllByPostIdAfterLastReadTime(@Param("targetPostId") Long postId,@Param("lastReadTime") Date lastReadTime);

	Integer countByPostIdAfterLastReadTime(@Param("targetPostId") Long postId,@Param("lastReadTime") Date lastReadTime);

	PostTrendAction selectPostTrendActionById(long actionId);
}