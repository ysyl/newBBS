package bbs.shop.mybatis.mapper;

import bbs.shop.entity.CommodyClassification;
import bbs.shop.mybatis.entity.TCommodyClassification;
import bbs.shop.mybatis.entity.TCommodyClassificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCommodyClassificationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	long countByExample(TCommodyClassificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int deleteByExample(TCommodyClassificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int insert(TCommodyClassification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int insertSelective(TCommodyClassification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	List<TCommodyClassification> selectByExample(TCommodyClassificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	TCommodyClassification selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TCommodyClassification record,
			@Param("example") TCommodyClassificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int updateByExample(@Param("record") TCommodyClassification record,
			@Param("example") TCommodyClassificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int updateByPrimaryKeySelective(TCommodyClassification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_classification
	 * @mbg.generated  Sun Aug 05 20:14:06 CST 2018
	 */
	int updateByPrimaryKey(TCommodyClassification record);

	List<CommodyClassification> selectAllClassification();

	CommodyClassification selectCommodyClassificationById(Integer classificationId);
}