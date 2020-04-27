package com.community.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("`id` like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("`id` not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBreakfastIsNull() {
            addCriterion("`breakfast` is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastIsNotNull() {
            addCriterion("`breakfast` is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastEqualTo(String value) {
            addCriterion("`breakfast` =", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotEqualTo(String value) {
            addCriterion("`breakfast` <>", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThan(String value) {
            addCriterion("`breakfast` >", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThanOrEqualTo(String value) {
            addCriterion("`breakfast` >=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThan(String value) {
            addCriterion("`breakfast` <", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThanOrEqualTo(String value) {
            addCriterion("`breakfast` <=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLike(String value) {
            addCriterion("`breakfast` like", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotLike(String value) {
            addCriterion("`breakfast` not like", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastIn(List<String> values) {
            addCriterion("`breakfast` in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotIn(List<String> values) {
            addCriterion("`breakfast` not in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastBetween(String value1, String value2) {
            addCriterion("`breakfast` between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotBetween(String value1, String value2) {
            addCriterion("`breakfast` not between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andLunchIsNull() {
            addCriterion("`lunch` is null");
            return (Criteria) this;
        }

        public Criteria andLunchIsNotNull() {
            addCriterion("`lunch` is not null");
            return (Criteria) this;
        }

        public Criteria andLunchEqualTo(String value) {
            addCriterion("`lunch` =", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotEqualTo(String value) {
            addCriterion("`lunch` <>", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThan(String value) {
            addCriterion("`lunch` >", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThanOrEqualTo(String value) {
            addCriterion("`lunch` >=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThan(String value) {
            addCriterion("`lunch` <", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThanOrEqualTo(String value) {
            addCriterion("`lunch` <=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLike(String value) {
            addCriterion("`lunch` like", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotLike(String value) {
            addCriterion("`lunch` not like", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchIn(List<String> values) {
            addCriterion("`lunch` in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotIn(List<String> values) {
            addCriterion("`lunch` not in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchBetween(String value1, String value2) {
            addCriterion("`lunch` between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotBetween(String value1, String value2) {
            addCriterion("`lunch` not between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andDinnerIsNull() {
            addCriterion("`dinner` is null");
            return (Criteria) this;
        }

        public Criteria andDinnerIsNotNull() {
            addCriterion("`dinner` is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerEqualTo(String value) {
            addCriterion("`dinner` =", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotEqualTo(String value) {
            addCriterion("`dinner` <>", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerGreaterThan(String value) {
            addCriterion("`dinner` >", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerGreaterThanOrEqualTo(String value) {
            addCriterion("`dinner` >=", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerLessThan(String value) {
            addCriterion("`dinner` <", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerLessThanOrEqualTo(String value) {
            addCriterion("`dinner` <=", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerLike(String value) {
            addCriterion("`dinner` like", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotLike(String value) {
            addCriterion("`dinner` not like", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerIn(List<String> values) {
            addCriterion("`dinner` in", values, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotIn(List<String> values) {
            addCriterion("`dinner` not in", values, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerBetween(String value1, String value2) {
            addCriterion("`dinner` between", value1, value2, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotBetween(String value1, String value2) {
            addCriterion("`dinner` not between", value1, value2, "dinner");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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