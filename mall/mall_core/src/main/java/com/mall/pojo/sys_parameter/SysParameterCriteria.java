package com.mall.pojo.sys_parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysParameterCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public SysParameterCriteria() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andParameterNameIsNull() {
            addCriterion("parameter_name is null");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNotNull() {
            addCriterion("parameter_name is not null");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualTo(String value) {
            addCriterion("parameter_name =", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualTo(String value) {
            addCriterion("parameter_name <>", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThan(String value) {
            addCriterion("parameter_name >", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_name >=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThan(String value) {
            addCriterion("parameter_name <", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualTo(String value) {
            addCriterion("parameter_name <=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLike(String value) {
            addCriterion("parameter_name like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotLike(String value) {
            addCriterion("parameter_name not like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameIn(List<String> values) {
            addCriterion("parameter_name in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotIn(List<String> values) {
            addCriterion("parameter_name not in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameBetween(String value1, String value2) {
            addCriterion("parameter_name between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotBetween(String value1, String value2) {
            addCriterion("parameter_name not between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterStatusIsNull() {
            addCriterion("parameter_status is null");
            return (Criteria) this;
        }

        public Criteria andParameterStatusIsNotNull() {
            addCriterion("parameter_status is not null");
            return (Criteria) this;
        }

        public Criteria andParameterStatusEqualTo(String value) {
            addCriterion("parameter_status =", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusNotEqualTo(String value) {
            addCriterion("parameter_status <>", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusGreaterThan(String value) {
            addCriterion("parameter_status >", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_status >=", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusLessThan(String value) {
            addCriterion("parameter_status <", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusLessThanOrEqualTo(String value) {
            addCriterion("parameter_status <=", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusLike(String value) {
            addCriterion("parameter_status like", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusNotLike(String value) {
            addCriterion("parameter_status not like", value, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusIn(List<String> values) {
            addCriterion("parameter_status in", values, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusNotIn(List<String> values) {
            addCriterion("parameter_status not in", values, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusBetween(String value1, String value2) {
            addCriterion("parameter_status between", value1, value2, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterStatusNotBetween(String value1, String value2) {
            addCriterion("parameter_status not between", value1, value2, "parameterStatus");
            return (Criteria) this;
        }

        public Criteria andParameterValueIsNull() {
            addCriterion("parameter_value is null");
            return (Criteria) this;
        }

        public Criteria andParameterValueIsNotNull() {
            addCriterion("parameter_value is not null");
            return (Criteria) this;
        }

        public Criteria andParameterValueEqualTo(String value) {
            addCriterion("parameter_value =", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotEqualTo(String value) {
            addCriterion("parameter_value <>", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueGreaterThan(String value) {
            addCriterion("parameter_value >", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_value >=", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLessThan(String value) {
            addCriterion("parameter_value <", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLessThanOrEqualTo(String value) {
            addCriterion("parameter_value <=", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLike(String value) {
            addCriterion("parameter_value like", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotLike(String value) {
            addCriterion("parameter_value not like", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueIn(List<String> values) {
            addCriterion("parameter_value in", values, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotIn(List<String> values) {
            addCriterion("parameter_value not in", values, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueBetween(String value1, String value2) {
            addCriterion("parameter_value between", value1, value2, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotBetween(String value1, String value2) {
            addCriterion("parameter_value not between", value1, value2, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyIsNull() {
            addCriterion("parameter_company is null");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyIsNotNull() {
            addCriterion("parameter_company is not null");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyEqualTo(String value) {
            addCriterion("parameter_company =", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyNotEqualTo(String value) {
            addCriterion("parameter_company <>", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyGreaterThan(String value) {
            addCriterion("parameter_company >", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_company >=", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyLessThan(String value) {
            addCriterion("parameter_company <", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyLessThanOrEqualTo(String value) {
            addCriterion("parameter_company <=", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyLike(String value) {
            addCriterion("parameter_company like", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyNotLike(String value) {
            addCriterion("parameter_company not like", value, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyIn(List<String> values) {
            addCriterion("parameter_company in", values, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyNotIn(List<String> values) {
            addCriterion("parameter_company not in", values, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyBetween(String value1, String value2) {
            addCriterion("parameter_company between", value1, value2, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andParameterCompanyNotBetween(String value1, String value2) {
            addCriterion("parameter_company not between", value1, value2, "parameterCompany");
            return (Criteria) this;
        }

        public Criteria andCarTimeIsNull() {
            addCriterion("car_time is null");
            return (Criteria) this;
        }

        public Criteria andCarTimeIsNotNull() {
            addCriterion("car_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarTimeEqualTo(Date value) {
            addCriterion("car_time =", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeNotEqualTo(Date value) {
            addCriterion("car_time <>", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeGreaterThan(Date value) {
            addCriterion("car_time >", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("car_time >=", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeLessThan(Date value) {
            addCriterion("car_time <", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeLessThanOrEqualTo(Date value) {
            addCriterion("car_time <=", value, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeIn(List<Date> values) {
            addCriterion("car_time in", values, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeNotIn(List<Date> values) {
            addCriterion("car_time not in", values, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeBetween(Date value1, Date value2) {
            addCriterion("car_time between", value1, value2, "carTime");
            return (Criteria) this;
        }

        public Criteria andCarTimeNotBetween(Date value1, Date value2) {
            addCriterion("car_time not between", value1, value2, "carTime");
            return (Criteria) this;
        }

        public Criteria andUpdUserIsNull() {
            addCriterion("upd_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIsNotNull() {
            addCriterion("upd_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserEqualTo(String value) {
            addCriterion("upd_user =", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserNotEqualTo(String value) {
            addCriterion("upd_user <>", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserGreaterThan(String value) {
            addCriterion("upd_user >", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user >=", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserLessThan(String value) {
            addCriterion("upd_user <", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserLessThanOrEqualTo(String value) {
            addCriterion("upd_user <=", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserLike(String value) {
            addCriterion("upd_user like", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserNotLike(String value) {
            addCriterion("upd_user not like", value, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserIn(List<String> values) {
            addCriterion("upd_user in", values, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserNotIn(List<String> values) {
            addCriterion("upd_user not in", values, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserBetween(String value1, String value2) {
            addCriterion("upd_user between", value1, value2, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdUserNotBetween(String value1, String value2) {
            addCriterion("upd_user not between", value1, value2, "updUser");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
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