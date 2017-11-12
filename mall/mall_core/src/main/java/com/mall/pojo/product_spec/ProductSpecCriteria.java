package com.mall.pojo.product_spec;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ProductSpecCriteria() {
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

        public Criteria andSpceIdIsNull() {
            addCriterion("spce_id is null");
            return (Criteria) this;
        }

        public Criteria andSpceIdIsNotNull() {
            addCriterion("spce_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpceIdEqualTo(Long value) {
            addCriterion("spce_id =", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdNotEqualTo(Long value) {
            addCriterion("spce_id <>", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdGreaterThan(Long value) {
            addCriterion("spce_id >", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spce_id >=", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdLessThan(Long value) {
            addCriterion("spce_id <", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdLessThanOrEqualTo(Long value) {
            addCriterion("spce_id <=", value, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdIn(List<Long> values) {
            addCriterion("spce_id in", values, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdNotIn(List<Long> values) {
            addCriterion("spce_id not in", values, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdBetween(Long value1, Long value2) {
            addCriterion("spce_id between", value1, value2, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceIdNotBetween(Long value1, Long value2) {
            addCriterion("spce_id not between", value1, value2, "spceId");
            return (Criteria) this;
        }

        public Criteria andSpceNameIsNull() {
            addCriterion("spce_name is null");
            return (Criteria) this;
        }

        public Criteria andSpceNameIsNotNull() {
            addCriterion("spce_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpceNameEqualTo(String value) {
            addCriterion("spce_name =", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameNotEqualTo(String value) {
            addCriterion("spce_name <>", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameGreaterThan(String value) {
            addCriterion("spce_name >", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameGreaterThanOrEqualTo(String value) {
            addCriterion("spce_name >=", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameLessThan(String value) {
            addCriterion("spce_name <", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameLessThanOrEqualTo(String value) {
            addCriterion("spce_name <=", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameLike(String value) {
            addCriterion("spce_name like", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameNotLike(String value) {
            addCriterion("spce_name not like", value, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameIn(List<String> values) {
            addCriterion("spce_name in", values, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameNotIn(List<String> values) {
            addCriterion("spce_name not in", values, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameBetween(String value1, String value2) {
            addCriterion("spce_name between", value1, value2, "spceName");
            return (Criteria) this;
        }

        public Criteria andSpceNameNotBetween(String value1, String value2) {
            addCriterion("spce_name not between", value1, value2, "spceName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLunchFeeIsNull() {
            addCriterion("lunch_fee is null");
            return (Criteria) this;
        }

        public Criteria andLunchFeeIsNotNull() {
            addCriterion("lunch_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLunchFeeEqualTo(Double value) {
            addCriterion("lunch_fee =", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeNotEqualTo(Double value) {
            addCriterion("lunch_fee <>", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeGreaterThan(Double value) {
            addCriterion("lunch_fee >", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("lunch_fee >=", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeLessThan(Double value) {
            addCriterion("lunch_fee <", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeLessThanOrEqualTo(Double value) {
            addCriterion("lunch_fee <=", value, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeIn(List<Double> values) {
            addCriterion("lunch_fee in", values, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeNotIn(List<Double> values) {
            addCriterion("lunch_fee not in", values, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeBetween(Double value1, Double value2) {
            addCriterion("lunch_fee between", value1, value2, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andLunchFeeNotBetween(Double value1, Double value2) {
            addCriterion("lunch_fee not between", value1, value2, "lunchFee");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryIsNull() {
            addCriterion("current_inventory is null");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryIsNotNull() {
            addCriterion("current_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryEqualTo(Long value) {
            addCriterion("current_inventory =", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryNotEqualTo(Long value) {
            addCriterion("current_inventory <>", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryGreaterThan(Long value) {
            addCriterion("current_inventory >", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryGreaterThanOrEqualTo(Long value) {
            addCriterion("current_inventory >=", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryLessThan(Long value) {
            addCriterion("current_inventory <", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryLessThanOrEqualTo(Long value) {
            addCriterion("current_inventory <=", value, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryIn(List<Long> values) {
            addCriterion("current_inventory in", values, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryNotIn(List<Long> values) {
            addCriterion("current_inventory not in", values, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryBetween(Long value1, Long value2) {
            addCriterion("current_inventory between", value1, value2, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andCurrentInventoryNotBetween(Long value1, Long value2) {
            addCriterion("current_inventory not between", value1, value2, "currentInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryIsNull() {
            addCriterion("max_inventory is null");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryIsNotNull() {
            addCriterion("max_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryEqualTo(Long value) {
            addCriterion("max_inventory =", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryNotEqualTo(Long value) {
            addCriterion("max_inventory <>", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryGreaterThan(Long value) {
            addCriterion("max_inventory >", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryGreaterThanOrEqualTo(Long value) {
            addCriterion("max_inventory >=", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryLessThan(Long value) {
            addCriterion("max_inventory <", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryLessThanOrEqualTo(Long value) {
            addCriterion("max_inventory <=", value, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryIn(List<Long> values) {
            addCriterion("max_inventory in", values, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryNotIn(List<Long> values) {
            addCriterion("max_inventory not in", values, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryBetween(Long value1, Long value2) {
            addCriterion("max_inventory between", value1, value2, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andMaxInventoryNotBetween(Long value1, Long value2) {
            addCriterion("max_inventory not between", value1, value2, "maxInventory");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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