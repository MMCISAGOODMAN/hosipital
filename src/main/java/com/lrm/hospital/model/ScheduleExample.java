package com.lrm.hospital.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(String value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(String value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(String value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(String value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(String value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLike(String value) {
            addCriterion("doctor_id like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotLike(String value) {
            addCriterion("doctor_id not like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<String> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<String> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(String value1, String value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(String value1, String value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNull() {
            addCriterion("schedule_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNotNull() {
            addCriterion("schedule_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date =", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date <>", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("schedule_date >", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date >=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThan(Date value) {
            addCriterionForJDBCDate("schedule_date <", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("schedule_date <=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIn(List<Date> values) {
            addCriterionForJDBCDate("schedule_date in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("schedule_date not in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("schedule_date between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("schedule_date not between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIsNull() {
            addCriterion("total_quota is null");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIsNotNull() {
            addCriterion("total_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaEqualTo(Integer value) {
            addCriterion("total_quota =", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotEqualTo(Integer value) {
            addCriterion("total_quota <>", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaGreaterThan(Integer value) {
            addCriterion("total_quota >", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_quota >=", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaLessThan(Integer value) {
            addCriterion("total_quota <", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("total_quota <=", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIn(List<Integer> values) {
            addCriterion("total_quota in", values, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotIn(List<Integer> values) {
            addCriterion("total_quota not in", values, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaBetween(Integer value1, Integer value2) {
            addCriterion("total_quota between", value1, value2, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_quota not between", value1, value2, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaIsNull() {
            addCriterion("current_quota is null");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaIsNotNull() {
            addCriterion("current_quota is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaEqualTo(Integer value) {
            addCriterion("current_quota =", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaNotEqualTo(Integer value) {
            addCriterion("current_quota <>", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaGreaterThan(Integer value) {
            addCriterion("current_quota >", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_quota >=", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaLessThan(Integer value) {
            addCriterion("current_quota <", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("current_quota <=", value, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaIn(List<Integer> values) {
            addCriterion("current_quota in", values, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaNotIn(List<Integer> values) {
            addCriterion("current_quota not in", values, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaBetween(Integer value1, Integer value2) {
            addCriterion("current_quota between", value1, value2, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("current_quota not between", value1, value2, "currentQuota");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberIsNull() {
            addCriterion("current_number is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberIsNotNull() {
            addCriterion("current_number is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberEqualTo(Integer value) {
            addCriterion("current_number =", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberNotEqualTo(Integer value) {
            addCriterion("current_number <>", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberGreaterThan(Integer value) {
            addCriterion("current_number >", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_number >=", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberLessThan(Integer value) {
            addCriterion("current_number <", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("current_number <=", value, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberIn(List<Integer> values) {
            addCriterion("current_number in", values, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberNotIn(List<Integer> values) {
            addCriterion("current_number not in", values, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberBetween(Integer value1, Integer value2) {
            addCriterion("current_number between", value1, value2, "currentNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("current_number not between", value1, value2, "currentNumber");
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