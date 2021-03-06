package com.unbank.spider.mybatis.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZgpjZhitieBillExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public ZgpjZhitieBillExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andDetailurlIsNull() {
			addCriterion("detailurl is null");
			return (Criteria) this;
		}

		public Criteria andDetailurlIsNotNull() {
			addCriterion("detailurl is not null");
			return (Criteria) this;
		}

		public Criteria andDetailurlEqualTo(String value) {
			addCriterion("detailurl =", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlNotEqualTo(String value) {
			addCriterion("detailurl <>", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlGreaterThan(String value) {
			addCriterion("detailurl >", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlGreaterThanOrEqualTo(String value) {
			addCriterion("detailurl >=", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlLessThan(String value) {
			addCriterion("detailurl <", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlLessThanOrEqualTo(String value) {
			addCriterion("detailurl <=", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlLike(String value) {
			addCriterion("detailurl like", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlNotLike(String value) {
			addCriterion("detailurl not like", value, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlIn(List<String> values) {
			addCriterion("detailurl in", values, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlNotIn(List<String> values) {
			addCriterion("detailurl not in", values, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlBetween(String value1, String value2) {
			addCriterion("detailurl between", value1, value2, "detailurl");
			return (Criteria) this;
		}

		public Criteria andDetailurlNotBetween(String value1, String value2) {
			addCriterion("detailurl not between", value1, value2, "detailurl");
			return (Criteria) this;
		}

		public Criteria andProPlaceIsNull() {
			addCriterion("pro_place is null");
			return (Criteria) this;
		}

		public Criteria andProPlaceIsNotNull() {
			addCriterion("pro_place is not null");
			return (Criteria) this;
		}

		public Criteria andProPlaceEqualTo(String value) {
			addCriterion("pro_place =", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceNotEqualTo(String value) {
			addCriterion("pro_place <>", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceGreaterThan(String value) {
			addCriterion("pro_place >", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceGreaterThanOrEqualTo(String value) {
			addCriterion("pro_place >=", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceLessThan(String value) {
			addCriterion("pro_place <", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceLessThanOrEqualTo(String value) {
			addCriterion("pro_place <=", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceLike(String value) {
			addCriterion("pro_place like", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceNotLike(String value) {
			addCriterion("pro_place not like", value, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceIn(List<String> values) {
			addCriterion("pro_place in", values, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceNotIn(List<String> values) {
			addCriterion("pro_place not in", values, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceBetween(String value1, String value2) {
			addCriterion("pro_place between", value1, value2, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProPlaceNotBetween(String value1, String value2) {
			addCriterion("pro_place not between", value1, value2, "proPlace");
			return (Criteria) this;
		}

		public Criteria andProRateIsNull() {
			addCriterion("pro_rate is null");
			return (Criteria) this;
		}

		public Criteria andProRateIsNotNull() {
			addCriterion("pro_rate is not null");
			return (Criteria) this;
		}

		public Criteria andProRateEqualTo(String value) {
			addCriterion("pro_rate =", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateNotEqualTo(String value) {
			addCriterion("pro_rate <>", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateGreaterThan(String value) {
			addCriterion("pro_rate >", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateGreaterThanOrEqualTo(String value) {
			addCriterion("pro_rate >=", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateLessThan(String value) {
			addCriterion("pro_rate <", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateLessThanOrEqualTo(String value) {
			addCriterion("pro_rate <=", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateLike(String value) {
			addCriterion("pro_rate like", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateNotLike(String value) {
			addCriterion("pro_rate not like", value, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateIn(List<String> values) {
			addCriterion("pro_rate in", values, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateNotIn(List<String> values) {
			addCriterion("pro_rate not in", values, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateBetween(String value1, String value2) {
			addCriterion("pro_rate between", value1, value2, "proRate");
			return (Criteria) this;
		}

		public Criteria andProRateNotBetween(String value1, String value2) {
			addCriterion("pro_rate not between", value1, value2, "proRate");
			return (Criteria) this;
		}

		public Criteria andProBankIsNull() {
			addCriterion("pro_bank is null");
			return (Criteria) this;
		}

		public Criteria andProBankIsNotNull() {
			addCriterion("pro_bank is not null");
			return (Criteria) this;
		}

		public Criteria andProBankEqualTo(String value) {
			addCriterion("pro_bank =", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankNotEqualTo(String value) {
			addCriterion("pro_bank <>", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankGreaterThan(String value) {
			addCriterion("pro_bank >", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankGreaterThanOrEqualTo(String value) {
			addCriterion("pro_bank >=", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankLessThan(String value) {
			addCriterion("pro_bank <", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankLessThanOrEqualTo(String value) {
			addCriterion("pro_bank <=", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankLike(String value) {
			addCriterion("pro_bank like", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankNotLike(String value) {
			addCriterion("pro_bank not like", value, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankIn(List<String> values) {
			addCriterion("pro_bank in", values, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankNotIn(List<String> values) {
			addCriterion("pro_bank not in", values, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankBetween(String value1, String value2) {
			addCriterion("pro_bank between", value1, value2, "proBank");
			return (Criteria) this;
		}

		public Criteria andProBankNotBetween(String value1, String value2) {
			addCriterion("pro_bank not between", value1, value2, "proBank");
			return (Criteria) this;
		}

		public Criteria andBillTypeIsNull() {
			addCriterion("bill_type is null");
			return (Criteria) this;
		}

		public Criteria andBillTypeIsNotNull() {
			addCriterion("bill_type is not null");
			return (Criteria) this;
		}

		public Criteria andBillTypeEqualTo(String value) {
			addCriterion("bill_type =", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeNotEqualTo(String value) {
			addCriterion("bill_type <>", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeGreaterThan(String value) {
			addCriterion("bill_type >", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
			addCriterion("bill_type >=", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeLessThan(String value) {
			addCriterion("bill_type <", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeLessThanOrEqualTo(String value) {
			addCriterion("bill_type <=", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeLike(String value) {
			addCriterion("bill_type like", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeNotLike(String value) {
			addCriterion("bill_type not like", value, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeIn(List<String> values) {
			addCriterion("bill_type in", values, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeNotIn(List<String> values) {
			addCriterion("bill_type not in", values, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeBetween(String value1, String value2) {
			addCriterion("bill_type between", value1, value2, "billType");
			return (Criteria) this;
		}

		public Criteria andBillTypeNotBetween(String value1, String value2) {
			addCriterion("bill_type not between", value1, value2, "billType");
			return (Criteria) this;
		}

		public Criteria andProDateIsNull() {
			addCriterion("pro_date is null");
			return (Criteria) this;
		}

		public Criteria andProDateIsNotNull() {
			addCriterion("pro_date is not null");
			return (Criteria) this;
		}

		public Criteria andProDateEqualTo(String value) {
			addCriterion("pro_date =", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateNotEqualTo(String value) {
			addCriterion("pro_date <>", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateGreaterThan(String value) {
			addCriterion("pro_date >", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateGreaterThanOrEqualTo(String value) {
			addCriterion("pro_date >=", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateLessThan(String value) {
			addCriterion("pro_date <", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateLessThanOrEqualTo(String value) {
			addCriterion("pro_date <=", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateLike(String value) {
			addCriterion("pro_date like", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateNotLike(String value) {
			addCriterion("pro_date not like", value, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateIn(List<String> values) {
			addCriterion("pro_date in", values, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateNotIn(List<String> values) {
			addCriterion("pro_date not in", values, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateBetween(String value1, String value2) {
			addCriterion("pro_date between", value1, value2, "proDate");
			return (Criteria) this;
		}

		public Criteria andProDateNotBetween(String value1, String value2) {
			addCriterion("pro_date not between", value1, value2, "proDate");
			return (Criteria) this;
		}

		public Criteria andTimeIsNull() {
			addCriterion("TIME is null");
			return (Criteria) this;
		}

		public Criteria andTimeIsNotNull() {
			addCriterion("TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTimeEqualTo(Date value) {
			addCriterion("TIME =", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotEqualTo(Date value) {
			addCriterion("TIME <>", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThan(Date value) {
			addCriterion("TIME >", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TIME >=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThan(Date value) {
			addCriterion("TIME <", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThanOrEqualTo(Date value) {
			addCriterion("TIME <=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeIn(List<Date> values) {
			addCriterion("TIME in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotIn(List<Date> values) {
			addCriterion("TIME not in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeBetween(Date value1, Date value2) {
			addCriterion("TIME between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotBetween(Date value1, Date value2) {
			addCriterion("TIME not between", value1, value2, "time");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table zgpj_baojia0_bill
	 * @mbggenerated  Wed Jan 21 14:58:15 CST 2015
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
     * This class corresponds to the database table zgpj_baojia0_bill
     *
     * @mbggenerated do_not_delete_during_merge Wed Jan 21 14:57:48 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}