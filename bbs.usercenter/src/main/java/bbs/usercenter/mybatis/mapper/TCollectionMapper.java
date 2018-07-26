package bbs.usercenter.mybatis.mapper;

import bbs.form.utils.PageParam;
import bbs.usercenter.collection.DAO.entity.BaseCollection;
import bbs.usercenter.collection.DAO.entity.ForumCollection;
import bbs.usercenter.enuma.CollectionType;
import bbs.usercenter.mybatis.entity.TCollection;
import bbs.usercenter.mybatis.entity.TCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

public interface TCollectionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	long countByExample(TCollectionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int deleteByExample(TCollectionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int insert(TCollection record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int insertSelective(TCollection record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	List<TCollection> selectByExample(TCollectionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	TCollection selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TCollection record, @Param("example") TCollectionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int updateByExample(@Param("record") TCollection record, @Param("example") TCollectionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int updateByPrimaryKeySelective(TCollection record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_collection
	 * @mbg.generated  Thu Jul 26 15:46:59 CST 2018
	 */
	int updateByPrimaryKey(TCollection record);

	List<? extends BaseCollection> selectAllCollectionByUidAndType(@Param("userId") long uid, 
			@Param("collectionType") CollectionType forum,@Param("pageParam") PageParam pageParam);

	BaseCollection selectCollectionByUidAndTargetIdAndType(@Param("userId") long uid, 
			@Param("targetId") long targetId,
			@Param("collectionType") CollectionType forum,@Param("pageParam") PageParam pageParam);

	void deleteByUidAndTargetId(@Param("userId")Long uid,@Param("targetId") long targetId, @Param("collectionType") CollectionType collectionType);
}