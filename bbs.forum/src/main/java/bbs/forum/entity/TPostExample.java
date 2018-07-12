package bbs.forum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPostExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public TPostExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIsNull() {
			addCriterion("author_id is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIsNotNull() {
			addCriterion("author_id is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdEqualTo(Long value) {
			addCriterion("author_id =", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotEqualTo(Long value) {
			addCriterion("author_id <>", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThan(Long value) {
			addCriterion("author_id >", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
			addCriterion("author_id >=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThan(Long value) {
			addCriterion("author_id <", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
			addCriterion("author_id <=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIn(List<Long> values) {
			addCriterion("author_id in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotIn(List<Long> values) {
			addCriterion("author_id not in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdBetween(Long value1, Long value2) {
			addCriterion("author_id between", value1, value2, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
			addCriterion("author_id not between", value1, value2, "authorId");
			return (Criteria) this;
		}

		public Criteria andPubTimeIsNull() {
			addCriterion("pub_time is null");
			return (Criteria) this;
		}

		public Criteria andPubTimeIsNotNull() {
			addCriterion("pub_time is not null");
			return (Criteria) this;
		}

		public Criteria andPubTimeEqualTo(Date value) {
			addCriterion("pub_time =", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeNotEqualTo(Date value) {
			addCriterion("pub_time <>", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeGreaterThan(Date value) {
			addCriterion("pub_time >", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("pub_time >=", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeLessThan(Date value) {
			addCriterion("pub_time <", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeLessThanOrEqualTo(Date value) {
			addCriterion("pub_time <=", value, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeIn(List<Date> values) {
			addCriterion("pub_time in", values, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeNotIn(List<Date> values) {
			addCriterion("pub_time not in", values, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeBetween(Date value1, Date value2) {
			addCriterion("pub_time between", value1, value2, "pubTime");
			return (Criteria) this;
		}

		public Criteria andPubTimeNotBetween(Date value1, Date value2) {
			addCriterion("pub_time not between", value1, value2, "pubTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIsNull() {
			addCriterion("last_modified_time is null");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIsNotNull() {
			addCriterion("last_modified_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeEqualTo(Date value) {
			addCriterion("last_modified_time =", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotEqualTo(Date value) {
			addCriterion("last_modified_time <>", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeGreaterThan(Date value) {
			addCriterion("last_modified_time >", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("last_modified_time >=", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeLessThan(Date value) {
			addCriterion("last_modified_time <", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeLessThanOrEqualTo(Date value) {
			addCriterion("last_modified_time <=", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIn(List<Date> values) {
			addCriterion("last_modified_time in", values, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotIn(List<Date> values) {
			addCriterion("last_modified_time not in", values, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeBetween(Date value1, Date value2) {
			addCriterion("last_modified_time between", value1, value2, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotBetween(Date value1, Date value2) {
			addCriterion("last_modified_time not between", value1, value2, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdIsNull() {
			addCriterion("reply_post_id is null");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdIsNotNull() {
			addCriterion("reply_post_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdEqualTo(Long value) {
			addCriterion("reply_post_id =", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdNotEqualTo(Long value) {
			addCriterion("reply_post_id <>", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdGreaterThan(Long value) {
			addCriterion("reply_post_id >", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdGreaterThanOrEqualTo(Long value) {
			addCriterion("reply_post_id >=", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdLessThan(Long value) {
			addCriterion("reply_post_id <", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdLessThanOrEqualTo(Long value) {
			addCriterion("reply_post_id <=", value, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdIn(List<Long> values) {
			addCriterion("reply_post_id in", values, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdNotIn(List<Long> values) {
			addCriterion("reply_post_id not in", values, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdBetween(Long value1, Long value2) {
			addCriterion("reply_post_id between", value1, value2, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andReplyPostIdNotBetween(Long value1, Long value2) {
			addCriterion("reply_post_id not between", value1, value2, "replyPostId");
			return (Criteria) this;
		}

		public Criteria andTopicIdIsNull() {
			addCriterion("topic_id is null");
			return (Criteria) this;
		}

		public Criteria andTopicIdIsNotNull() {
			addCriterion("topic_id is not null");
			return (Criteria) this;
		}

		public Criteria andTopicIdEqualTo(Long value) {
			addCriterion("topic_id =", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdNotEqualTo(Long value) {
			addCriterion("topic_id <>", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdGreaterThan(Long value) {
			addCriterion("topic_id >", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdGreaterThanOrEqualTo(Long value) {
			addCriterion("topic_id >=", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdLessThan(Long value) {
			addCriterion("topic_id <", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdLessThanOrEqualTo(Long value) {
			addCriterion("topic_id <=", value, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdIn(List<Long> values) {
			addCriterion("topic_id in", values, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdNotIn(List<Long> values) {
			addCriterion("topic_id not in", values, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdBetween(Long value1, Long value2) {
			addCriterion("topic_id between", value1, value2, "topicId");
			return (Criteria) this;
		}

		public Criteria andTopicIdNotBetween(Long value1, Long value2) {
			addCriterion("topic_id not between", value1, value2, "topicId");
			return (Criteria) this;
		}

		public Criteria andHtmlContentIsNull() {
			addCriterion("html_content is null");
			return (Criteria) this;
		}

		public Criteria andHtmlContentIsNotNull() {
			addCriterion("html_content is not null");
			return (Criteria) this;
		}

		public Criteria andHtmlContentEqualTo(String value) {
			addCriterion("html_content =", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentNotEqualTo(String value) {
			addCriterion("html_content <>", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentGreaterThan(String value) {
			addCriterion("html_content >", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentGreaterThanOrEqualTo(String value) {
			addCriterion("html_content >=", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentLessThan(String value) {
			addCriterion("html_content <", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentLessThanOrEqualTo(String value) {
			addCriterion("html_content <=", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentLike(String value) {
			addCriterion("html_content like", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentNotLike(String value) {
			addCriterion("html_content not like", value, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentIn(List<String> values) {
			addCriterion("html_content in", values, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentNotIn(List<String> values) {
			addCriterion("html_content not in", values, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentBetween(String value1, String value2) {
			addCriterion("html_content between", value1, value2, "htmlContent");
			return (Criteria) this;
		}

		public Criteria andHtmlContentNotBetween(String value1, String value2) {
			addCriterion("html_content not between", value1, value2, "htmlContent");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_post
	 * @mbg.generated  Thu Jul 12 17:13:32 CST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_post
     *
     * @mbg.generated do_not_delete_during_merge Sat Jun 23 18:27:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}