package bbs.forum.mapper;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Announce;
import bbs.forum.entity.TAnnounce;
import bbs.forum.entity.TAnnounceExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAnnounceMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	long countByExample(TAnnounceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int deleteByExample(TAnnounceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int insert(TAnnounce record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int insertSelective(TAnnounce record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	List<TAnnounce> selectByExample(TAnnounceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	TAnnounce selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TAnnounce record, @Param("example") TAnnounceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int updateByExample(@Param("record") TAnnounce record, @Param("example") TAnnounceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int updateByPrimaryKeySelective(TAnnounce record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_announce
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	int updateByPrimaryKey(TAnnounce record);

	List<Announce> selectAllAnnounceByForumId(@Param("forumId")Integer forumId, @Param("pageParam") PageParam pageParam);
}