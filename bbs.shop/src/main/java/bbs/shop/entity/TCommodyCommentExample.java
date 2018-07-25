package bbs.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import bbs.shop.enuma.CommentType;

public class TCommodyCommentExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public TCommodyCommentExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> commentTypeCriteria;
		protected List<Criterion> allCriteria;
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
			commentTypeCriteria = new ArrayList<Criterion>();
		}

		public List<Criterion> getCommentTypeCriteria() {
			return commentTypeCriteria;
		}

		protected void addCommentTypeCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			commentTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		protected void addCommentTypeCriterion(String condition, CommentType value1, CommentType value2,
				String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			commentTypeCriteria
					.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		public boolean isValid() {
			return criteria.size() > 0 || commentTypeCriteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			if (allCriteria == null) {
				allCriteria = new ArrayList<Criterion>();
				allCriteria.addAll(criteria);
				allCriteria.addAll(commentTypeCriteria);
			}
			return allCriteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
			allCriteria = null;
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
			allCriteria = null;
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
			allCriteria = null;
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

		public Criteria andCommodyIdIsNull() {
			addCriterion("commody_id is null");
			return (Criteria) this;
		}

		public Criteria andCommodyIdIsNotNull() {
			addCriterion("commody_id is not null");
			return (Criteria) this;
		}

		public Criteria andCommodyIdEqualTo(Long value) {
			addCriterion("commody_id =", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdNotEqualTo(Long value) {
			addCriterion("commody_id <>", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdGreaterThan(Long value) {
			addCriterion("commody_id >", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdGreaterThanOrEqualTo(Long value) {
			addCriterion("commody_id >=", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdLessThan(Long value) {
			addCriterion("commody_id <", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdLessThanOrEqualTo(Long value) {
			addCriterion("commody_id <=", value, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdIn(List<Long> values) {
			addCriterion("commody_id in", values, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdNotIn(List<Long> values) {
			addCriterion("commody_id not in", values, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdBetween(Long value1, Long value2) {
			addCriterion("commody_id between", value1, value2, "commodyId");
			return (Criteria) this;
		}

		public Criteria andCommodyIdNotBetween(Long value1, Long value2) {
			addCriterion("commody_id not between", value1, value2, "commodyId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdIsNull() {
			addCriterion("reply_comment_id is null");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdIsNotNull() {
			addCriterion("reply_comment_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdEqualTo(Long value) {
			addCriterion("reply_comment_id =", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdNotEqualTo(Long value) {
			addCriterion("reply_comment_id <>", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdGreaterThan(Long value) {
			addCriterion("reply_comment_id >", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("reply_comment_id >=", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdLessThan(Long value) {
			addCriterion("reply_comment_id <", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdLessThanOrEqualTo(Long value) {
			addCriterion("reply_comment_id <=", value, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdIn(List<Long> values) {
			addCriterion("reply_comment_id in", values, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdNotIn(List<Long> values) {
			addCriterion("reply_comment_id not in", values, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdBetween(Long value1, Long value2) {
			addCriterion("reply_comment_id between", value1, value2, "replyCommentId");
			return (Criteria) this;
		}

		public Criteria andReplyCommentIdNotBetween(Long value1, Long value2) {
			addCriterion("reply_comment_id not between", value1, value2, "replyCommentId");
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

		public Criteria andCommentTypeIsNull() {
			addCriterion("comment_type is null");
			return (Criteria) this;
		}

		public Criteria andCommentTypeIsNotNull() {
			addCriterion("comment_type is not null");
			return (Criteria) this;
		}

		public Criteria andCommentTypeEqualTo(CommentType value) {
			addCommentTypeCriterion("comment_type =", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeNotEqualTo(CommentType value) {
			addCommentTypeCriterion("comment_type <>", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeGreaterThan(CommentType value) {
			addCommentTypeCriterion("comment_type >", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeGreaterThanOrEqualTo(CommentType value) {
			addCommentTypeCriterion("comment_type >=", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeLessThan(CommentType value) {
			addCommentTypeCriterion("comment_type <", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeLessThanOrEqualTo(CommentType value) {
			addCommentTypeCriterion("comment_type <=", value, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeIn(List<CommentType> values) {
			addCommentTypeCriterion("comment_type in", values, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeNotIn(List<CommentType> values) {
			addCommentTypeCriterion("comment_type not in", values, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeBetween(CommentType value1, CommentType value2) {
			addCommentTypeCriterion("comment_type between", value1, value2, "commentType");
			return (Criteria) this;
		}

		public Criteria andCommentTypeNotBetween(CommentType value1, CommentType value2) {
			addCommentTypeCriterion("comment_type not between", value1, value2, "commentType");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdIsNull() {
			addCriterion("belong_comment_id is null");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdIsNotNull() {
			addCriterion("belong_comment_id is not null");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdEqualTo(Long value) {
			addCriterion("belong_comment_id =", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdNotEqualTo(Long value) {
			addCriterion("belong_comment_id <>", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdGreaterThan(Long value) {
			addCriterion("belong_comment_id >", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("belong_comment_id >=", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdLessThan(Long value) {
			addCriterion("belong_comment_id <", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdLessThanOrEqualTo(Long value) {
			addCriterion("belong_comment_id <=", value, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdIn(List<Long> values) {
			addCriterion("belong_comment_id in", values, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdNotIn(List<Long> values) {
			addCriterion("belong_comment_id not in", values, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdBetween(Long value1, Long value2) {
			addCriterion("belong_comment_id between", value1, value2, "belongCommentId");
			return (Criteria) this;
		}

		public Criteria andBelongCommentIdNotBetween(Long value1, Long value2) {
			addCriterion("belong_comment_id not between", value1, value2, "belongCommentId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_commody_comment
	 * @mbg.generated  Wed Jul 25 22:39:52 CST 2018
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
     * This class corresponds to the database table t_commody_comment
     *
     * @mbg.generated do_not_delete_during_merge Wed Jul 25 12:10:51 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}