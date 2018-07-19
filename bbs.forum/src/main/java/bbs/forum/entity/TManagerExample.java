package bbs.forum.entity;

import bbs.forum.enuma.ManagerGroup;
import java.util.ArrayList;
import java.util.List;

public class TManagerExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public TManagerExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> managerGroupCriteria;
		protected List<Criterion> allCriteria;
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
			managerGroupCriteria = new ArrayList<Criterion>();
		}

		public List<Criterion> getManagerGroupCriteria() {
			return managerGroupCriteria;
		}

		protected void addManagerGroupCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			managerGroupCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		protected void addManagerGroupCriterion(String condition, ManagerGroup value1, ManagerGroup value2,
				String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			managerGroupCriteria
					.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
			allCriteria = null;
		}

		public boolean isValid() {
			return criteria.size() > 0 || managerGroupCriteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			if (allCriteria == null) {
				allCriteria = new ArrayList<Criterion>();
				allCriteria.addAll(criteria);
				allCriteria.addAll(managerGroupCriteria);
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

		public Criteria andManagerGroupIsNull() {
			addCriterion("manager_group is null");
			return (Criteria) this;
		}

		public Criteria andManagerGroupIsNotNull() {
			addCriterion("manager_group is not null");
			return (Criteria) this;
		}

		public Criteria andManagerGroupEqualTo(ManagerGroup value) {
			addManagerGroupCriterion("manager_group =", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupNotEqualTo(ManagerGroup value) {
			addManagerGroupCriterion("manager_group <>", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupGreaterThan(ManagerGroup value) {
			addManagerGroupCriterion("manager_group >", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupGreaterThanOrEqualTo(ManagerGroup value) {
			addManagerGroupCriterion("manager_group >=", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupLessThan(ManagerGroup value) {
			addManagerGroupCriterion("manager_group <", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupLessThanOrEqualTo(ManagerGroup value) {
			addManagerGroupCriterion("manager_group <=", value, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupIn(List<ManagerGroup> values) {
			addManagerGroupCriterion("manager_group in", values, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupNotIn(List<ManagerGroup> values) {
			addManagerGroupCriterion("manager_group not in", values, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupBetween(ManagerGroup value1, ManagerGroup value2) {
			addManagerGroupCriterion("manager_group between", value1, value2, "managerGroup");
			return (Criteria) this;
		}

		public Criteria andManagerGroupNotBetween(ManagerGroup value1, ManagerGroup value2) {
			addManagerGroupCriterion("manager_group not between", value1, value2, "managerGroup");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_manager
	 * @mbg.generated  Wed Jul 18 20:48:30 CST 2018
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
     * This class corresponds to the database table t_manager
     *
     * @mbg.generated do_not_delete_during_merge Sun Jul 01 15:00:51 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}