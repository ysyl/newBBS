package bbs.subscriptionsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TForumTrendActionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public TForumTrendActionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
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

		public Criteria andForumIdIsNull() {
			addCriterion("forum_id is null");
			return (Criteria) this;
		}

		public Criteria andForumIdIsNotNull() {
			addCriterion("forum_id is not null");
			return (Criteria) this;
		}

		public Criteria andForumIdEqualTo(Integer value) {
			addCriterion("forum_id =", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotEqualTo(Integer value) {
			addCriterion("forum_id <>", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdGreaterThan(Integer value) {
			addCriterion("forum_id >", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("forum_id >=", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdLessThan(Integer value) {
			addCriterion("forum_id <", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdLessThanOrEqualTo(Integer value) {
			addCriterion("forum_id <=", value, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdIn(List<Integer> values) {
			addCriterion("forum_id in", values, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotIn(List<Integer> values) {
			addCriterion("forum_id not in", values, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdBetween(Integer value1, Integer value2) {
			addCriterion("forum_id between", value1, value2, "forumId");
			return (Criteria) this;
		}

		public Criteria andForumIdNotBetween(Integer value1, Integer value2) {
			addCriterion("forum_id not between", value1, value2, "forumId");
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

		public Criteria andPublisherIdIsNull() {
			addCriterion("publisher_id is null");
			return (Criteria) this;
		}

		public Criteria andPublisherIdIsNotNull() {
			addCriterion("publisher_id is not null");
			return (Criteria) this;
		}

		public Criteria andPublisherIdEqualTo(Long value) {
			addCriterion("publisher_id =", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdNotEqualTo(Long value) {
			addCriterion("publisher_id <>", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdGreaterThan(Long value) {
			addCriterion("publisher_id >", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdGreaterThanOrEqualTo(Long value) {
			addCriterion("publisher_id >=", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdLessThan(Long value) {
			addCriterion("publisher_id <", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdLessThanOrEqualTo(Long value) {
			addCriterion("publisher_id <=", value, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdIn(List<Long> values) {
			addCriterion("publisher_id in", values, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdNotIn(List<Long> values) {
			addCriterion("publisher_id not in", values, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdBetween(Long value1, Long value2) {
			addCriterion("publisher_id between", value1, value2, "publisherId");
			return (Criteria) this;
		}

		public Criteria andPublisherIdNotBetween(Long value1, Long value2) {
			addCriterion("publisher_id not between", value1, value2, "publisherId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdIsNull() {
			addCriterion("announce_id is null");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdIsNotNull() {
			addCriterion("announce_id is not null");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdEqualTo(Integer value) {
			addCriterion("announce_id =", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdNotEqualTo(Integer value) {
			addCriterion("announce_id <>", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdGreaterThan(Integer value) {
			addCriterion("announce_id >", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("announce_id >=", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdLessThan(Integer value) {
			addCriterion("announce_id <", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdLessThanOrEqualTo(Integer value) {
			addCriterion("announce_id <=", value, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdIn(List<Integer> values) {
			addCriterion("announce_id in", values, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdNotIn(List<Integer> values) {
			addCriterion("announce_id not in", values, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdBetween(Integer value1, Integer value2) {
			addCriterion("announce_id between", value1, value2, "announceId");
			return (Criteria) this;
		}

		public Criteria andAnnounceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("announce_id not between", value1, value2, "announceId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_forum_trend_action
	 * @mbg.generated  Sun Jul 01 18:39:56 CST 2018
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
     * This class corresponds to the database table t_forum_trend_action
     *
     * @mbg.generated do_not_delete_during_merge Sun Jul 01 16:22:01 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}