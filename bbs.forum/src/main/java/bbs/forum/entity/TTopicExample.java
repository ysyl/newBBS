package bbs.forum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTopicExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public TTopicExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
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

		public Criteria andViewsIsNull() {
			addCriterion("views is null");
			return (Criteria) this;
		}

		public Criteria andViewsIsNotNull() {
			addCriterion("views is not null");
			return (Criteria) this;
		}

		public Criteria andViewsEqualTo(Integer value) {
			addCriterion("views =", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotEqualTo(Integer value) {
			addCriterion("views <>", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsGreaterThan(Integer value) {
			addCriterion("views >", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
			addCriterion("views >=", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsLessThan(Integer value) {
			addCriterion("views <", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsLessThanOrEqualTo(Integer value) {
			addCriterion("views <=", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsIn(List<Integer> values) {
			addCriterion("views in", values, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotIn(List<Integer> values) {
			addCriterion("views not in", values, "views");
			return (Criteria) this;
		}

		public Criteria andViewsBetween(Integer value1, Integer value2) {
			addCriterion("views between", value1, value2, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotBetween(Integer value1, Integer value2) {
			addCriterion("views not between", value1, value2, "views");
			return (Criteria) this;
		}

		public Criteria andRepliesIsNull() {
			addCriterion("replies is null");
			return (Criteria) this;
		}

		public Criteria andRepliesIsNotNull() {
			addCriterion("replies is not null");
			return (Criteria) this;
		}

		public Criteria andRepliesEqualTo(Integer value) {
			addCriterion("replies =", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesNotEqualTo(Integer value) {
			addCriterion("replies <>", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesGreaterThan(Integer value) {
			addCriterion("replies >", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesGreaterThanOrEqualTo(Integer value) {
			addCriterion("replies >=", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesLessThan(Integer value) {
			addCriterion("replies <", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesLessThanOrEqualTo(Integer value) {
			addCriterion("replies <=", value, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesIn(List<Integer> values) {
			addCriterion("replies in", values, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesNotIn(List<Integer> values) {
			addCriterion("replies not in", values, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesBetween(Integer value1, Integer value2) {
			addCriterion("replies between", value1, value2, "replies");
			return (Criteria) this;
		}

		public Criteria andRepliesNotBetween(Integer value1, Integer value2) {
			addCriterion("replies not between", value1, value2, "replies");
			return (Criteria) this;
		}

		public Criteria andLikesIsNull() {
			addCriterion("likes is null");
			return (Criteria) this;
		}

		public Criteria andLikesIsNotNull() {
			addCriterion("likes is not null");
			return (Criteria) this;
		}

		public Criteria andLikesEqualTo(Integer value) {
			addCriterion("likes =", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesNotEqualTo(Integer value) {
			addCriterion("likes <>", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesGreaterThan(Integer value) {
			addCriterion("likes >", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
			addCriterion("likes >=", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesLessThan(Integer value) {
			addCriterion("likes <", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesLessThanOrEqualTo(Integer value) {
			addCriterion("likes <=", value, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesIn(List<Integer> values) {
			addCriterion("likes in", values, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesNotIn(List<Integer> values) {
			addCriterion("likes not in", values, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesBetween(Integer value1, Integer value2) {
			addCriterion("likes between", value1, value2, "likes");
			return (Criteria) this;
		}

		public Criteria andLikesNotBetween(Integer value1, Integer value2) {
			addCriterion("likes not between", value1, value2, "likes");
			return (Criteria) this;
		}

		public Criteria andMainPostIdIsNull() {
			addCriterion("main_post_id is null");
			return (Criteria) this;
		}

		public Criteria andMainPostIdIsNotNull() {
			addCriterion("main_post_id is not null");
			return (Criteria) this;
		}

		public Criteria andMainPostIdEqualTo(Long value) {
			addCriterion("main_post_id =", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdNotEqualTo(Long value) {
			addCriterion("main_post_id <>", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdGreaterThan(Long value) {
			addCriterion("main_post_id >", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdGreaterThanOrEqualTo(Long value) {
			addCriterion("main_post_id >=", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdLessThan(Long value) {
			addCriterion("main_post_id <", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdLessThanOrEqualTo(Long value) {
			addCriterion("main_post_id <=", value, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdIn(List<Long> values) {
			addCriterion("main_post_id in", values, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdNotIn(List<Long> values) {
			addCriterion("main_post_id not in", values, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdBetween(Long value1, Long value2) {
			addCriterion("main_post_id between", value1, value2, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andMainPostIdNotBetween(Long value1, Long value2) {
			addCriterion("main_post_id not between", value1, value2, "mainPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdIsNull() {
			addCriterion("last_reply_post_id is null");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdIsNotNull() {
			addCriterion("last_reply_post_id is not null");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdEqualTo(Long value) {
			addCriterion("last_reply_post_id =", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdNotEqualTo(Long value) {
			addCriterion("last_reply_post_id <>", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdGreaterThan(Long value) {
			addCriterion("last_reply_post_id >", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdGreaterThanOrEqualTo(Long value) {
			addCriterion("last_reply_post_id >=", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdLessThan(Long value) {
			addCriterion("last_reply_post_id <", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdLessThanOrEqualTo(Long value) {
			addCriterion("last_reply_post_id <=", value, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdIn(List<Long> values) {
			addCriterion("last_reply_post_id in", values, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdNotIn(List<Long> values) {
			addCriterion("last_reply_post_id not in", values, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdBetween(Long value1, Long value2) {
			addCriterion("last_reply_post_id between", value1, value2, "lastReplyPostId");
			return (Criteria) this;
		}

		public Criteria andLastReplyPostIdNotBetween(Long value1, Long value2) {
			addCriterion("last_reply_post_id not between", value1, value2, "lastReplyPostId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_topic
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
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
     * This class corresponds to the database table t_topic
     *
     * @mbg.generated do_not_delete_during_merge Sat Jun 23 18:27:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}