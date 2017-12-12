package com.code.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JxUserExample {
    /**
     * .
    jx_user
     */
    protected String orderByClause;

    /**
     * .
    jx_user
     */
    protected boolean distinct;

    /**
     * .
    jx_user
     */
    protected List<Criteria> oredCriteria;

    public JxUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_user
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNull() {
            addCriterion("is_old is null");
            return (Criteria) this;
        }

        public Criteria andIsOldIsNotNull() {
            addCriterion("is_old is not null");
            return (Criteria) this;
        }

        public Criteria andIsOldEqualTo(Integer value) {
            addCriterion("is_old =", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotEqualTo(Integer value) {
            addCriterion("is_old <>", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThan(Integer value) {
            addCriterion("is_old >", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_old >=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThan(Integer value) {
            addCriterion("is_old <", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldLessThanOrEqualTo(Integer value) {
            addCriterion("is_old <=", value, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldIn(List<Integer> values) {
            addCriterion("is_old in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotIn(List<Integer> values) {
            addCriterion("is_old not in", values, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldBetween(Integer value1, Integer value2) {
            addCriterion("is_old between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andIsOldNotBetween(Integer value1, Integer value2) {
            addCriterion("is_old not between", value1, value2, "isOld");
            return (Criteria) this;
        }

        public Criteria andIdCard1IsNull() {
            addCriterion("id_card1 is null");
            return (Criteria) this;
        }

        public Criteria andIdCard1IsNotNull() {
            addCriterion("id_card1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCard1EqualTo(String value) {
            addCriterion("id_card1 =", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1NotEqualTo(String value) {
            addCriterion("id_card1 <>", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1GreaterThan(String value) {
            addCriterion("id_card1 >", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1GreaterThanOrEqualTo(String value) {
            addCriterion("id_card1 >=", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1LessThan(String value) {
            addCriterion("id_card1 <", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1LessThanOrEqualTo(String value) {
            addCriterion("id_card1 <=", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1Like(String value) {
            addCriterion("id_card1 like", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1NotLike(String value) {
            addCriterion("id_card1 not like", value, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1In(List<String> values) {
            addCriterion("id_card1 in", values, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1NotIn(List<String> values) {
            addCriterion("id_card1 not in", values, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1Between(String value1, String value2) {
            addCriterion("id_card1 between", value1, value2, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard1NotBetween(String value1, String value2) {
            addCriterion("id_card1 not between", value1, value2, "idCard1");
            return (Criteria) this;
        }

        public Criteria andIdCard2IsNull() {
            addCriterion("id_card2 is null");
            return (Criteria) this;
        }

        public Criteria andIdCard2IsNotNull() {
            addCriterion("id_card2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdCard2EqualTo(String value) {
            addCriterion("id_card2 =", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2NotEqualTo(String value) {
            addCriterion("id_card2 <>", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2GreaterThan(String value) {
            addCriterion("id_card2 >", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2GreaterThanOrEqualTo(String value) {
            addCriterion("id_card2 >=", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2LessThan(String value) {
            addCriterion("id_card2 <", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2LessThanOrEqualTo(String value) {
            addCriterion("id_card2 <=", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2Like(String value) {
            addCriterion("id_card2 like", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2NotLike(String value) {
            addCriterion("id_card2 not like", value, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2In(List<String> values) {
            addCriterion("id_card2 in", values, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2NotIn(List<String> values) {
            addCriterion("id_card2 not in", values, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2Between(String value1, String value2) {
            addCriterion("id_card2 between", value1, value2, "idCard2");
            return (Criteria) this;
        }

        public Criteria andIdCard2NotBetween(String value1, String value2) {
            addCriterion("id_card2 not between", value1, value2, "idCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard1IsNull() {
            addCriterion("bank_card1 is null");
            return (Criteria) this;
        }

        public Criteria andBankCard1IsNotNull() {
            addCriterion("bank_card1 is not null");
            return (Criteria) this;
        }

        public Criteria andBankCard1EqualTo(String value) {
            addCriterion("bank_card1 =", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1NotEqualTo(String value) {
            addCriterion("bank_card1 <>", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1GreaterThan(String value) {
            addCriterion("bank_card1 >", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1GreaterThanOrEqualTo(String value) {
            addCriterion("bank_card1 >=", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1LessThan(String value) {
            addCriterion("bank_card1 <", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1LessThanOrEqualTo(String value) {
            addCriterion("bank_card1 <=", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1Like(String value) {
            addCriterion("bank_card1 like", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1NotLike(String value) {
            addCriterion("bank_card1 not like", value, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1In(List<String> values) {
            addCriterion("bank_card1 in", values, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1NotIn(List<String> values) {
            addCriterion("bank_card1 not in", values, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1Between(String value1, String value2) {
            addCriterion("bank_card1 between", value1, value2, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard1NotBetween(String value1, String value2) {
            addCriterion("bank_card1 not between", value1, value2, "bankCard1");
            return (Criteria) this;
        }

        public Criteria andBankCard2IsNull() {
            addCriterion("bank_card2 is null");
            return (Criteria) this;
        }

        public Criteria andBankCard2IsNotNull() {
            addCriterion("bank_card2 is not null");
            return (Criteria) this;
        }

        public Criteria andBankCard2EqualTo(String value) {
            addCriterion("bank_card2 =", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2NotEqualTo(String value) {
            addCriterion("bank_card2 <>", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2GreaterThan(String value) {
            addCriterion("bank_card2 >", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2GreaterThanOrEqualTo(String value) {
            addCriterion("bank_card2 >=", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2LessThan(String value) {
            addCriterion("bank_card2 <", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2LessThanOrEqualTo(String value) {
            addCriterion("bank_card2 <=", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2Like(String value) {
            addCriterion("bank_card2 like", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2NotLike(String value) {
            addCriterion("bank_card2 not like", value, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2In(List<String> values) {
            addCriterion("bank_card2 in", values, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2NotIn(List<String> values) {
            addCriterion("bank_card2 not in", values, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2Between(String value1, String value2) {
            addCriterion("bank_card2 between", value1, value2, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankCard2NotBetween(String value1, String value2) {
            addCriterion("bank_card2 not between", value1, value2, "bankCard2");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualTo(Integer value) {
            addCriterion("bank_id =", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualTo(Integer value) {
            addCriterion("bank_id <>", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThan(Integer value) {
            addCriterion("bank_id >", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bank_id >=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThan(Integer value) {
            addCriterion("bank_id <", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualTo(Integer value) {
            addCriterion("bank_id <=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdIn(List<Integer> values) {
            addCriterion("bank_id in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotIn(List<Integer> values) {
            addCriterion("bank_id not in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdBetween(Integer value1, Integer value2) {
            addCriterion("bank_id between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bank_id not between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeIsNull() {
            addCriterion("last_open_time is null");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeIsNotNull() {
            addCriterion("last_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeEqualTo(Date value) {
            addCriterion("last_open_time =", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeNotEqualTo(Date value) {
            addCriterion("last_open_time <>", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeGreaterThan(Date value) {
            addCriterion("last_open_time >", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_open_time >=", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeLessThan(Date value) {
            addCriterion("last_open_time <", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_open_time <=", value, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeIn(List<Date> values) {
            addCriterion("last_open_time in", values, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeNotIn(List<Date> values) {
            addCriterion("last_open_time not in", values, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeBetween(Date value1, Date value2) {
            addCriterion("last_open_time between", value1, value2, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andLastOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_open_time not between", value1, value2, "lastOpenTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNull() {
            addCriterion("account_balance is null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNotNull() {
            addCriterion("account_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceEqualTo(BigDecimal value) {
            addCriterion("account_balance =", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotEqualTo(BigDecimal value) {
            addCriterion("account_balance <>", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThan(BigDecimal value) {
            addCriterion("account_balance >", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_balance >=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThan(BigDecimal value) {
            addCriterion("account_balance <", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_balance <=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIn(List<BigDecimal> values) {
            addCriterion("account_balance in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotIn(List<BigDecimal> values) {
            addCriterion("account_balance not in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_balance between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_balance not between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountIsNull() {
            addCriterion("old_buy_amount is null");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountIsNotNull() {
            addCriterion("old_buy_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountEqualTo(BigDecimal value) {
            addCriterion("old_buy_amount =", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountNotEqualTo(BigDecimal value) {
            addCriterion("old_buy_amount <>", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountGreaterThan(BigDecimal value) {
            addCriterion("old_buy_amount >", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("old_buy_amount >=", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountLessThan(BigDecimal value) {
            addCriterion("old_buy_amount <", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("old_buy_amount <=", value, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountIn(List<BigDecimal> values) {
            addCriterion("old_buy_amount in", values, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountNotIn(List<BigDecimal> values) {
            addCriterion("old_buy_amount not in", values, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("old_buy_amount between", value1, value2, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andOldBuyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("old_buy_amount not between", value1, value2, "oldBuyAmount");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_user
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_user
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