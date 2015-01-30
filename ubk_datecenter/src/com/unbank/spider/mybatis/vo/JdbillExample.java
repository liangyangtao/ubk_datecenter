package com.unbank.spider.mybatis.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbillExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public JdbillExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
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

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andBillRateIsNull() {
            addCriterion("bill_rate is null");
            return (Criteria) this;
        }

        public Criteria andBillRateIsNotNull() {
            addCriterion("bill_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBillRateEqualTo(String value) {
            addCriterion("bill_rate =", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotEqualTo(String value) {
            addCriterion("bill_rate <>", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateGreaterThan(String value) {
            addCriterion("bill_rate >", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateGreaterThanOrEqualTo(String value) {
            addCriterion("bill_rate >=", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateLessThan(String value) {
            addCriterion("bill_rate <", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateLessThanOrEqualTo(String value) {
            addCriterion("bill_rate <=", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateLike(String value) {
            addCriterion("bill_rate like", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotLike(String value) {
            addCriterion("bill_rate not like", value, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateIn(List<String> values) {
            addCriterion("bill_rate in", values, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotIn(List<String> values) {
            addCriterion("bill_rate not in", values, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateBetween(String value1, String value2) {
            addCriterion("bill_rate between", value1, value2, "billRate");
            return (Criteria) this;
        }

        public Criteria andBillRateNotBetween(String value1, String value2) {
            addCriterion("bill_rate not between", value1, value2, "billRate");
            return (Criteria) this;
        }

        public Criteria andProNumIsNull() {
            addCriterion("pro_num is null");
            return (Criteria) this;
        }

        public Criteria andProNumIsNotNull() {
            addCriterion("pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andProNumEqualTo(String value) {
            addCriterion("pro_num =", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotEqualTo(String value) {
            addCriterion("pro_num <>", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThan(String value) {
            addCriterion("pro_num >", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThanOrEqualTo(String value) {
            addCriterion("pro_num >=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThan(String value) {
            addCriterion("pro_num <", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThanOrEqualTo(String value) {
            addCriterion("pro_num <=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLike(String value) {
            addCriterion("pro_num like", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotLike(String value) {
            addCriterion("pro_num not like", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumIn(List<String> values) {
            addCriterion("pro_num in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotIn(List<String> values) {
            addCriterion("pro_num not in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumBetween(String value1, String value2) {
            addCriterion("pro_num between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotBetween(String value1, String value2) {
            addCriterion("pro_num not between", value1, value2, "proNum");
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

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(String value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(String value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(String value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(String value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(String value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLike(String value) {
            addCriterion("publish_time like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotLike(String value) {
            addCriterion("publish_time not like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<String> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<String> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(String value1, String value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(String value1, String value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(String value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(String value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(String value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(String value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(String value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(String value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLike(String value) {
            addCriterion("publish_date like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotLike(String value) {
            addCriterion("publish_date not like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<String> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<String> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(String value1, String value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(String value1, String value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andBillBankIsNull() {
            addCriterion("bill_bank is null");
            return (Criteria) this;
        }

        public Criteria andBillBankIsNotNull() {
            addCriterion("bill_bank is not null");
            return (Criteria) this;
        }

        public Criteria andBillBankEqualTo(String value) {
            addCriterion("bill_bank =", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankNotEqualTo(String value) {
            addCriterion("bill_bank <>", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankGreaterThan(String value) {
            addCriterion("bill_bank >", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankGreaterThanOrEqualTo(String value) {
            addCriterion("bill_bank >=", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankLessThan(String value) {
            addCriterion("bill_bank <", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankLessThanOrEqualTo(String value) {
            addCriterion("bill_bank <=", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankLike(String value) {
            addCriterion("bill_bank like", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankNotLike(String value) {
            addCriterion("bill_bank not like", value, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankIn(List<String> values) {
            addCriterion("bill_bank in", values, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankNotIn(List<String> values) {
            addCriterion("bill_bank not in", values, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankBetween(String value1, String value2) {
            addCriterion("bill_bank between", value1, value2, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillBankNotBetween(String value1, String value2) {
            addCriterion("bill_bank not between", value1, value2, "billBank");
            return (Criteria) this;
        }

        public Criteria andBillMoneyIsNull() {
            addCriterion("bill_money is null");
            return (Criteria) this;
        }

        public Criteria andBillMoneyIsNotNull() {
            addCriterion("bill_money is not null");
            return (Criteria) this;
        }

        public Criteria andBillMoneyEqualTo(String value) {
            addCriterion("bill_money =", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyNotEqualTo(String value) {
            addCriterion("bill_money <>", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyGreaterThan(String value) {
            addCriterion("bill_money >", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("bill_money >=", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyLessThan(String value) {
            addCriterion("bill_money <", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyLessThanOrEqualTo(String value) {
            addCriterion("bill_money <=", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyLike(String value) {
            addCriterion("bill_money like", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyNotLike(String value) {
            addCriterion("bill_money not like", value, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyIn(List<String> values) {
            addCriterion("bill_money in", values, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyNotIn(List<String> values) {
            addCriterion("bill_money not in", values, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyBetween(String value1, String value2) {
            addCriterion("bill_money between", value1, value2, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillMoneyNotBetween(String value1, String value2) {
            addCriterion("bill_money not between", value1, value2, "billMoney");
            return (Criteria) this;
        }

        public Criteria andBillDayIsNull() {
            addCriterion("bill_day is null");
            return (Criteria) this;
        }

        public Criteria andBillDayIsNotNull() {
            addCriterion("bill_day is not null");
            return (Criteria) this;
        }

        public Criteria andBillDayEqualTo(String value) {
            addCriterion("bill_day =", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotEqualTo(String value) {
            addCriterion("bill_day <>", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayGreaterThan(String value) {
            addCriterion("bill_day >", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayGreaterThanOrEqualTo(String value) {
            addCriterion("bill_day >=", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayLessThan(String value) {
            addCriterion("bill_day <", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayLessThanOrEqualTo(String value) {
            addCriterion("bill_day <=", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayLike(String value) {
            addCriterion("bill_day like", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotLike(String value) {
            addCriterion("bill_day not like", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayIn(List<String> values) {
            addCriterion("bill_day in", values, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotIn(List<String> values) {
            addCriterion("bill_day not in", values, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayBetween(String value1, String value2) {
            addCriterion("bill_day between", value1, value2, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotBetween(String value1, String value2) {
            addCriterion("bill_day not between", value1, value2, "billDay");
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
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table jd_bill
     *
     * @mbggenerated do_not_delete_during_merge Fri Dec 26 14:31:22 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
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
}