package bbs.subscriptionsystem.entity;

import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TUserTrendActionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public TUserTrendActionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> actionTypeCriteria;
		protected List<Criterion> targetTypeCriteria;
		protected List<Criterion> allCriteria;
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
			actionTypeCriteria = new ArrayList<Criterion>();
			targetTypeCriteria = new ArrayList<Criterion>();
		}

		public List<Criterion> getActionTypeCriteria() {
			return actionTypeCriteria;
		}

		protected void addActionTypeCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			actionTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		protected void addActionTypeCriterion(String condition, UserTrendActionType value1, UserTrendActionType value2,
				String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			actionTypeCriteria
					.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		public List<Criterion> getTargetTypeCriteria() {
			return targetTypeCriteria;
		}

		protected void addTargetTypeCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			targetTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		protected void addTargetTypeCriterion(String condition, UserTrendActionTargetType value1,
				UserTrendActionTargetType value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			targetTypeCriteria
					.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		public boolean isValid() {
			return criteria.size() > 0 || actionTypeCriteria.size() > 0 || targetTypeCriteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			if (allCriteria == null) {
				allCriteria = new ArrayList<Criterion>();
				allCriteria.addAll(criteria);
				allCriteria.addAll(actionTypeCriteria);
				allCriteria.addAll(targetTypeCriteria);
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

		public Criteria andActionTypeIsNull() {
			addCriterion("action_type is null");
			return (Criteria) this;
		}

		public Criteria andActionTypeIsNotNull() {
			addCriterion("action_type is not null");
			return (Criteria) this;
		}

		public Criteria andActionTypeEqualTo(UserTrendActionType value) {
			addActionTypeCriterion("action_type =", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotEqualTo(UserTrendActionType value) {
			addActionTypeCriterion("action_type <>", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeGreaterThan(UserTrendActionType value) {
			addActionTypeCriterion("action_type >", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeGreaterThanOrEqualTo(UserTrendActionType value) {
			addActionTypeCriterion("action_type >=", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeLessThan(UserTrendActionType value) {
			addActionTypeCriterion("action_type <", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeLessThanOrEqualTo(UserTrendActionType value) {
			addActionTypeCriterion("action_type <=", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeIn(List<UserTrendActionType> values) {
			addActionTypeCriterion("action_type in", values, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotIn(List<UserTrendActionType> values) {
			addActionTypeCriterion("action_type not in", values, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeBetween(UserTrendActionType value1, UserTrendActionType value2) {
			addActionTypeCriterion("action_type between", value1, value2, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotBetween(UserTrendActionType value1, UserTrendActionType value2) {
			addActionTypeCriterion("action_type not between", value1, value2, "actionType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNull() {
			addCriterion("target_type is null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNotNull() {
			addCriterion("target_type is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeEqualTo(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type =", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotEqualTo(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type <>", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThan(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type >", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThanOrEqualTo(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type >=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThan(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type <", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThanOrEqualTo(UserTrendActionTargetType value) {
			addTargetTypeCriterion("target_type <=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIn(List<UserTrendActionTargetType> values) {
			addTargetTypeCriterion("target_type in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotIn(List<UserTrendActionTargetType> values) {
			addTargetTypeCriterion("target_type not in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeBetween(UserTrendActionTargetType value1, UserTrendActionTargetType value2) {
			addTargetTypeCriterion("target_type between", value1, value2, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotBetween(UserTrendActionTargetType value1, UserTrendActionTargetType value2) {
			addTargetTypeCriterion("target_type not between", value1, value2, "targetType");
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

		public Criteria andFollowingIdIsNull() {
			addCriterion("following_id is null");
			return (Criteria) this;
		}

		public Criteria andFollowingIdIsNotNull() {
			addCriterion("following_id is not null");
			return (Criteria) this;
		}

		public Criteria andFollowingIdEqualTo(Long value) {
			addCriterion("following_id =", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdNotEqualTo(Long value) {
			addCriterion("following_id <>", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdGreaterThan(Long value) {
			addCriterion("following_id >", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdGreaterThanOrEqualTo(Long value) {
			addCriterion("following_id >=", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdLessThan(Long value) {
			addCriterion("following_id <", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdLessThanOrEqualTo(Long value) {
			addCriterion("following_id <=", value, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdIn(List<Long> values) {
			addCriterion("following_id in", values, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdNotIn(List<Long> values) {
			addCriterion("following_id not in", values, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdBetween(Long value1, Long value2) {
			addCriterion("following_id between", value1, value2, "followingId");
			return (Criteria) this;
		}

		public Criteria andFollowingIdNotBetween(Long value1, Long value2) {
			addCriterion("following_id not between", value1, value2, "followingId");
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

		public Criteria andPostIdIsNull() {
			addCriterion("post_id is null");
			return (Criteria) this;
		}

		public Criteria andPostIdIsNotNull() {
			addCriterion("post_id is not null");
			return (Criteria) this;
		}

		public Criteria andPostIdEqualTo(Long value) {
			addCriterion("post_id =", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotEqualTo(Long value) {
			addCriterion("post_id <>", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThan(Long value) {
			addCriterion("post_id >", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThanOrEqualTo(Long value) {
			addCriterion("post_id >=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThan(Long value) {
			addCriterion("post_id <", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThanOrEqualTo(Long value) {
			addCriterion("post_id <=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdIn(List<Long> values) {
			addCriterion("post_id in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotIn(List<Long> values) {
			addCriterion("post_id not in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdBetween(Long value1, Long value2) {
			addCriterion("post_id between", value1, value2, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotBetween(Long value1, Long value2) {
			addCriterion("post_id not between", value1, value2, "postId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user_trend_action
	 * @mbg.generated  Thu Jul 26 22:08:32 CST 2018
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
     * This class corresponds to the database table t_user_trend_action
     *
     * @mbg.generated do_not_delete_during_merge Tue Jun 12 21:48:44 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}