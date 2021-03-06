package bbs.forum.entity;

import bbs.forum.enuma.Sex;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TUserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public TUserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user_profile
	 * @mbg.generated  Fri Aug 10 00:34:01 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> sexCriteria;
		protected List<Criterion> allCriteria;
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
			sexCriteria = new ArrayList<Criterion>();
		}

		public List<Criterion> getSexCriteria() {
			return sexCriteria;
		}

		protected void addSexCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			sexCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		protected void addSexCriterion(String condition, Sex value1, Sex value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			sexCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		public boolean isValid() {
			return criteria.size() > 0 || sexCriteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			if (allCriteria == null) {
				allCriteria = new ArrayList<Criterion>();
				allCriteria.addAll(criteria);
				allCriteria.addAll(sexCriteria);
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

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Sex value) {
			addSexCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Sex value) {
			addSexCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Sex value) {
			addSexCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Sex value) {
			addSexCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Sex value) {
			addSexCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Sex value) {
			addSexCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Sex> values) {
			addSexCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Sex> values) {
			addSexCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Sex value1, Sex value2) {
			addSexCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Sex value1, Sex value2) {
			addSexCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andCreditIsNull() {
			addCriterion("credit is null");
			return (Criteria) this;
		}

		public Criteria andCreditIsNotNull() {
			addCriterion("credit is not null");
			return (Criteria) this;
		}

		public Criteria andCreditEqualTo(Integer value) {
			addCriterion("credit =", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotEqualTo(Integer value) {
			addCriterion("credit <>", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditGreaterThan(Integer value) {
			addCriterion("credit >", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditGreaterThanOrEqualTo(Integer value) {
			addCriterion("credit >=", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditLessThan(Integer value) {
			addCriterion("credit <", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditLessThanOrEqualTo(Integer value) {
			addCriterion("credit <=", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditIn(List<Integer> values) {
			addCriterion("credit in", values, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotIn(List<Integer> values) {
			addCriterion("credit not in", values, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditBetween(Integer value1, Integer value2) {
			addCriterion("credit between", value1, value2, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotBetween(Integer value1, Integer value2) {
			addCriterion("credit not between", value1, value2, "credit");
			return (Criteria) this;
		}

		public Criteria andAvatarIsNull() {
			addCriterion("avatar is null");
			return (Criteria) this;
		}

		public Criteria andAvatarIsNotNull() {
			addCriterion("avatar is not null");
			return (Criteria) this;
		}

		public Criteria andAvatarEqualTo(String value) {
			addCriterion("avatar =", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotEqualTo(String value) {
			addCriterion("avatar <>", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThan(String value) {
			addCriterion("avatar >", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThanOrEqualTo(String value) {
			addCriterion("avatar >=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThan(String value) {
			addCriterion("avatar <", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThanOrEqualTo(String value) {
			addCriterion("avatar <=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLike(String value) {
			addCriterion("avatar like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotLike(String value) {
			addCriterion("avatar not like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarIn(List<String> values) {
			addCriterion("avatar in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotIn(List<String> values) {
			addCriterion("avatar not in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarBetween(String value1, String value2) {
			addCriterion("avatar between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotBetween(String value1, String value2) {
			addCriterion("avatar not between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIsNull() {
			addCriterion("register_time is null");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIsNotNull() {
			addCriterion("register_time is not null");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeEqualTo(Date value) {
			addCriterion("register_time =", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotEqualTo(Date value) {
			addCriterion("register_time <>", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeGreaterThan(Date value) {
			addCriterion("register_time >", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("register_time >=", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeLessThan(Date value) {
			addCriterion("register_time <", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
			addCriterion("register_time <=", value, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeIn(List<Date> values) {
			addCriterion("register_time in", values, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotIn(List<Date> values) {
			addCriterion("register_time not in", values, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeBetween(Date value1, Date value2) {
			addCriterion("register_time between", value1, value2, "registerTime");
			return (Criteria) this;
		}

		public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
			addCriterion("register_time not between", value1, value2, "registerTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user_profile
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
     * This class corresponds to the database table t_user_profile
     *
     * @mbg.generated do_not_delete_during_merge Sat Jun 23 18:27:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}