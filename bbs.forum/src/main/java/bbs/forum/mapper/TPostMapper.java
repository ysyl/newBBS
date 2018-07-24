package bbs.forum.mapper;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Post;
import bbs.forum.entity.TPost;
import bbs.forum.entity.TPostExample;
import bbs.forum.resultentity.LastPostInForumResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface TPostMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	long countByExample(TPostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int deleteByExample(TPostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int insert(TPost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int insertSelective(TPost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	List<TPost> selectByExample(TPostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	TPost selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TPost record, @Param("example") TPostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int updateByExample(@Param("record") TPost record, @Param("example") TPostExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int updateByPrimaryKeySelective(TPost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Sat Jul 21 11:56:46 CST 2018
	 */
	int updateByPrimaryKey(TPost record);

	List<Post> selectAllPostByTopicId(@Param("topicId") long topicId,@Param("pageParam") PageParam pageParam);

	List<Post> selectAllPostByAuthorId(@Param("authorId")long authorId, @Param("pageParam") PageParam pageParam);

	Post selectMainPost(@Param("topicId")long topicId);

	List<Post> searchAll(@Param("content") String content,@Param("pageParam") PageParam pageParam);

	List<Post> selectAllReply(@Param("replyId")long postId,@Param("pageParam") PageParam pageParam);

	void likesPlusOne(@Param("postId") long postId);

	Post selectPostById(long postId);

	int countByUidAndPostId(@Param("userId")Long uid,@Param("postId") long postId);

	List<LastPostInForumResult> selectLastPostByForumId();
}