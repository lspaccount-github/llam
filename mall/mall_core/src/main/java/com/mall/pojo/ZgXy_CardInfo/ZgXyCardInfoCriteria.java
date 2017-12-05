package com.mall.pojo.ZgXy_CardInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZgXyCardInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ZgXyCardInfoCriteria() {
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

        public Criteria andKidIsNull() {
            addCriterion("Kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("Kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(String value) {
            addCriterion("Kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(String value) {
            addCriterion("Kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(String value) {
            addCriterion("Kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(String value) {
            addCriterion("Kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(String value) {
            addCriterion("Kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(String value) {
            addCriterion("Kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLike(String value) {
            addCriterion("Kid like", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotLike(String value) {
            addCriterion("Kid not like", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<String> values) {
            addCriterion("Kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<String> values) {
            addCriterion("Kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(String value1, String value2) {
            addCriterion("Kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(String value1, String value2) {
            addCriterion("Kid not between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andRyzhIsNull() {
            addCriterion("Ryzh is null");
            return (Criteria) this;
        }

        public Criteria andRyzhIsNotNull() {
            addCriterion("Ryzh is not null");
            return (Criteria) this;
        }

        public Criteria andRyzhEqualTo(String value) {
            addCriterion("Ryzh =", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhNotEqualTo(String value) {
            addCriterion("Ryzh <>", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhGreaterThan(String value) {
            addCriterion("Ryzh >", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhGreaterThanOrEqualTo(String value) {
            addCriterion("Ryzh >=", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhLessThan(String value) {
            addCriterion("Ryzh <", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhLessThanOrEqualTo(String value) {
            addCriterion("Ryzh <=", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhLike(String value) {
            addCriterion("Ryzh like", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhNotLike(String value) {
            addCriterion("Ryzh not like", value, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhIn(List<String> values) {
            addCriterion("Ryzh in", values, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhNotIn(List<String> values) {
            addCriterion("Ryzh not in", values, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhBetween(String value1, String value2) {
            addCriterion("Ryzh between", value1, value2, "ryzh");
            return (Criteria) this;
        }

        public Criteria andRyzhNotBetween(String value1, String value2) {
            addCriterion("Ryzh not between", value1, value2, "ryzh");
            return (Criteria) this;
        }

        public Criteria andKhIsNull() {
            addCriterion("Kh is null");
            return (Criteria) this;
        }

        public Criteria andKhIsNotNull() {
            addCriterion("Kh is not null");
            return (Criteria) this;
        }

        public Criteria andKhEqualTo(String value) {
            addCriterion("Kh =", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhNotEqualTo(String value) {
            addCriterion("Kh <>", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhGreaterThan(String value) {
            addCriterion("Kh >", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhGreaterThanOrEqualTo(String value) {
            addCriterion("Kh >=", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhLessThan(String value) {
            addCriterion("Kh <", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhLessThanOrEqualTo(String value) {
            addCriterion("Kh <=", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhLike(String value) {
            addCriterion("Kh like", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhNotLike(String value) {
            addCriterion("Kh not like", value, "kh");
            return (Criteria) this;
        }

        public Criteria andKhIn(List<String> values) {
            addCriterion("Kh in", values, "kh");
            return (Criteria) this;
        }

        public Criteria andKhNotIn(List<String> values) {
            addCriterion("Kh not in", values, "kh");
            return (Criteria) this;
        }

        public Criteria andKhBetween(String value1, String value2) {
            addCriterion("Kh between", value1, value2, "kh");
            return (Criteria) this;
        }

        public Criteria andKhNotBetween(String value1, String value2) {
            addCriterion("Kh not between", value1, value2, "kh");
            return (Criteria) this;
        }

        public Criteria andRybhIsNull() {
            addCriterion("Rybh is null");
            return (Criteria) this;
        }

        public Criteria andRybhIsNotNull() {
            addCriterion("Rybh is not null");
            return (Criteria) this;
        }

        public Criteria andRybhEqualTo(String value) {
            addCriterion("Rybh =", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhNotEqualTo(String value) {
            addCriterion("Rybh <>", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhGreaterThan(String value) {
            addCriterion("Rybh >", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhGreaterThanOrEqualTo(String value) {
            addCriterion("Rybh >=", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhLessThan(String value) {
            addCriterion("Rybh <", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhLessThanOrEqualTo(String value) {
            addCriterion("Rybh <=", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhLike(String value) {
            addCriterion("Rybh like", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhNotLike(String value) {
            addCriterion("Rybh not like", value, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhIn(List<String> values) {
            addCriterion("Rybh in", values, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhNotIn(List<String> values) {
            addCriterion("Rybh not in", values, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhBetween(String value1, String value2) {
            addCriterion("Rybh between", value1, value2, "rybh");
            return (Criteria) this;
        }

        public Criteria andRybhNotBetween(String value1, String value2) {
            addCriterion("Rybh not between", value1, value2, "rybh");
            return (Criteria) this;
        }

        public Criteria andRymcIsNull() {
            addCriterion("Rymc is null");
            return (Criteria) this;
        }

        public Criteria andRymcIsNotNull() {
            addCriterion("Rymc is not null");
            return (Criteria) this;
        }

        public Criteria andRymcEqualTo(String value) {
            addCriterion("Rymc =", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcNotEqualTo(String value) {
            addCriterion("Rymc <>", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcGreaterThan(String value) {
            addCriterion("Rymc >", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcGreaterThanOrEqualTo(String value) {
            addCriterion("Rymc >=", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcLessThan(String value) {
            addCriterion("Rymc <", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcLessThanOrEqualTo(String value) {
            addCriterion("Rymc <=", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcLike(String value) {
            addCriterion("Rymc like", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcNotLike(String value) {
            addCriterion("Rymc not like", value, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcIn(List<String> values) {
            addCriterion("Rymc in", values, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcNotIn(List<String> values) {
            addCriterion("Rymc not in", values, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcBetween(String value1, String value2) {
            addCriterion("Rymc between", value1, value2, "rymc");
            return (Criteria) this;
        }

        public Criteria andRymcNotBetween(String value1, String value2) {
            addCriterion("Rymc not between", value1, value2, "rymc");
            return (Criteria) this;
        }

        public Criteria andPymIsNull() {
            addCriterion("Pym is null");
            return (Criteria) this;
        }

        public Criteria andPymIsNotNull() {
            addCriterion("Pym is not null");
            return (Criteria) this;
        }

        public Criteria andPymEqualTo(String value) {
            addCriterion("Pym =", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymNotEqualTo(String value) {
            addCriterion("Pym <>", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymGreaterThan(String value) {
            addCriterion("Pym >", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymGreaterThanOrEqualTo(String value) {
            addCriterion("Pym >=", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymLessThan(String value) {
            addCriterion("Pym <", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymLessThanOrEqualTo(String value) {
            addCriterion("Pym <=", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymLike(String value) {
            addCriterion("Pym like", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymNotLike(String value) {
            addCriterion("Pym not like", value, "pym");
            return (Criteria) this;
        }

        public Criteria andPymIn(List<String> values) {
            addCriterion("Pym in", values, "pym");
            return (Criteria) this;
        }

        public Criteria andPymNotIn(List<String> values) {
            addCriterion("Pym not in", values, "pym");
            return (Criteria) this;
        }

        public Criteria andPymBetween(String value1, String value2) {
            addCriterion("Pym between", value1, value2, "pym");
            return (Criteria) this;
        }

        public Criteria andPymNotBetween(String value1, String value2) {
            addCriterion("Pym not between", value1, value2, "pym");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("Xb is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("Xb is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("Xb =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("Xb <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("Xb >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("Xb >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("Xb <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("Xb <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("Xb like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("Xb not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("Xb in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("Xb not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("Xb between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("Xb not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andRymmIsNull() {
            addCriterion("Rymm is null");
            return (Criteria) this;
        }

        public Criteria andRymmIsNotNull() {
            addCriterion("Rymm is not null");
            return (Criteria) this;
        }

        public Criteria andRymmEqualTo(String value) {
            addCriterion("Rymm =", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmNotEqualTo(String value) {
            addCriterion("Rymm <>", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmGreaterThan(String value) {
            addCriterion("Rymm >", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmGreaterThanOrEqualTo(String value) {
            addCriterion("Rymm >=", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmLessThan(String value) {
            addCriterion("Rymm <", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmLessThanOrEqualTo(String value) {
            addCriterion("Rymm <=", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmLike(String value) {
            addCriterion("Rymm like", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmNotLike(String value) {
            addCriterion("Rymm not like", value, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmIn(List<String> values) {
            addCriterion("Rymm in", values, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmNotIn(List<String> values) {
            addCriterion("Rymm not in", values, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmBetween(String value1, String value2) {
            addCriterion("Rymm between", value1, value2, "rymm");
            return (Criteria) this;
        }

        public Criteria andRymmNotBetween(String value1, String value2) {
            addCriterion("Rymm not between", value1, value2, "rymm");
            return (Criteria) this;
        }

        public Criteria andBmidIsNull() {
            addCriterion("BmId is null");
            return (Criteria) this;
        }

        public Criteria andBmidIsNotNull() {
            addCriterion("BmId is not null");
            return (Criteria) this;
        }

        public Criteria andBmidEqualTo(String value) {
            addCriterion("BmId =", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotEqualTo(String value) {
            addCriterion("BmId <>", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThan(String value) {
            addCriterion("BmId >", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThanOrEqualTo(String value) {
            addCriterion("BmId >=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThan(String value) {
            addCriterion("BmId <", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThanOrEqualTo(String value) {
            addCriterion("BmId <=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLike(String value) {
            addCriterion("BmId like", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotLike(String value) {
            addCriterion("BmId not like", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidIn(List<String> values) {
            addCriterion("BmId in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotIn(List<String> values) {
            addCriterion("BmId not in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidBetween(String value1, String value2) {
            addCriterion("BmId between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotBetween(String value1, String value2) {
            addCriterion("BmId not between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andStidIsNull() {
            addCriterion("StId is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("StId is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(String value) {
            addCriterion("StId =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(String value) {
            addCriterion("StId <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(String value) {
            addCriterion("StId >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(String value) {
            addCriterion("StId >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(String value) {
            addCriterion("StId <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(String value) {
            addCriterion("StId <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLike(String value) {
            addCriterion("StId like", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotLike(String value) {
            addCriterion("StId not like", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<String> values) {
            addCriterion("StId in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<String> values) {
            addCriterion("StId not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(String value1, String value2) {
            addCriterion("StId between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(String value1, String value2) {
            addCriterion("StId not between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andYsidIsNull() {
            addCriterion("YsId is null");
            return (Criteria) this;
        }

        public Criteria andYsidIsNotNull() {
            addCriterion("YsId is not null");
            return (Criteria) this;
        }

        public Criteria andYsidEqualTo(String value) {
            addCriterion("YsId =", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotEqualTo(String value) {
            addCriterion("YsId <>", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidGreaterThan(String value) {
            addCriterion("YsId >", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidGreaterThanOrEqualTo(String value) {
            addCriterion("YsId >=", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLessThan(String value) {
            addCriterion("YsId <", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLessThanOrEqualTo(String value) {
            addCriterion("YsId <=", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidLike(String value) {
            addCriterion("YsId like", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotLike(String value) {
            addCriterion("YsId not like", value, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidIn(List<String> values) {
            addCriterion("YsId in", values, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotIn(List<String> values) {
            addCriterion("YsId not in", values, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidBetween(String value1, String value2) {
            addCriterion("YsId between", value1, value2, "ysid");
            return (Criteria) this;
        }

        public Criteria andYsidNotBetween(String value1, String value2) {
            addCriterion("YsId not between", value1, value2, "ysid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidIsNull() {
            addCriterion("StBzjbId is null");
            return (Criteria) this;
        }

        public Criteria andStbzjbidIsNotNull() {
            addCriterion("StBzjbId is not null");
            return (Criteria) this;
        }

        public Criteria andStbzjbidEqualTo(String value) {
            addCriterion("StBzjbId =", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidNotEqualTo(String value) {
            addCriterion("StBzjbId <>", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidGreaterThan(String value) {
            addCriterion("StBzjbId >", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidGreaterThanOrEqualTo(String value) {
            addCriterion("StBzjbId >=", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidLessThan(String value) {
            addCriterion("StBzjbId <", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidLessThanOrEqualTo(String value) {
            addCriterion("StBzjbId <=", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidLike(String value) {
            addCriterion("StBzjbId like", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidNotLike(String value) {
            addCriterion("StBzjbId not like", value, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidIn(List<String> values) {
            addCriterion("StBzjbId in", values, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidNotIn(List<String> values) {
            addCriterion("StBzjbId not in", values, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidBetween(String value1, String value2) {
            addCriterion("StBzjbId between", value1, value2, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andStbzjbidNotBetween(String value1, String value2) {
            addCriterion("StBzjbId not between", value1, value2, "stbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidIsNull() {
            addCriterion("YsBzjbId is null");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidIsNotNull() {
            addCriterion("YsBzjbId is not null");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidEqualTo(String value) {
            addCriterion("YsBzjbId =", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidNotEqualTo(String value) {
            addCriterion("YsBzjbId <>", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidGreaterThan(String value) {
            addCriterion("YsBzjbId >", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidGreaterThanOrEqualTo(String value) {
            addCriterion("YsBzjbId >=", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidLessThan(String value) {
            addCriterion("YsBzjbId <", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidLessThanOrEqualTo(String value) {
            addCriterion("YsBzjbId <=", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidLike(String value) {
            addCriterion("YsBzjbId like", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidNotLike(String value) {
            addCriterion("YsBzjbId not like", value, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidIn(List<String> values) {
            addCriterion("YsBzjbId in", values, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidNotIn(List<String> values) {
            addCriterion("YsBzjbId not in", values, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidBetween(String value1, String value2) {
            addCriterion("YsBzjbId between", value1, value2, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andYsbzjbidNotBetween(String value1, String value2) {
            addCriterion("YsBzjbId not between", value1, value2, "ysbzjbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidIsNull() {
            addCriterion("StGljbId is null");
            return (Criteria) this;
        }

        public Criteria andStgljbidIsNotNull() {
            addCriterion("StGljbId is not null");
            return (Criteria) this;
        }

        public Criteria andStgljbidEqualTo(String value) {
            addCriterion("StGljbId =", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidNotEqualTo(String value) {
            addCriterion("StGljbId <>", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidGreaterThan(String value) {
            addCriterion("StGljbId >", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidGreaterThanOrEqualTo(String value) {
            addCriterion("StGljbId >=", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidLessThan(String value) {
            addCriterion("StGljbId <", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidLessThanOrEqualTo(String value) {
            addCriterion("StGljbId <=", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidLike(String value) {
            addCriterion("StGljbId like", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidNotLike(String value) {
            addCriterion("StGljbId not like", value, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidIn(List<String> values) {
            addCriterion("StGljbId in", values, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidNotIn(List<String> values) {
            addCriterion("StGljbId not in", values, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidBetween(String value1, String value2) {
            addCriterion("StGljbId between", value1, value2, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andStgljbidNotBetween(String value1, String value2) {
            addCriterion("StGljbId not between", value1, value2, "stgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidIsNull() {
            addCriterion("YsGljbId is null");
            return (Criteria) this;
        }

        public Criteria andYsgljbidIsNotNull() {
            addCriterion("YsGljbId is not null");
            return (Criteria) this;
        }

        public Criteria andYsgljbidEqualTo(String value) {
            addCriterion("YsGljbId =", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidNotEqualTo(String value) {
            addCriterion("YsGljbId <>", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidGreaterThan(String value) {
            addCriterion("YsGljbId >", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidGreaterThanOrEqualTo(String value) {
            addCriterion("YsGljbId >=", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidLessThan(String value) {
            addCriterion("YsGljbId <", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidLessThanOrEqualTo(String value) {
            addCriterion("YsGljbId <=", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidLike(String value) {
            addCriterion("YsGljbId like", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidNotLike(String value) {
            addCriterion("YsGljbId not like", value, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidIn(List<String> values) {
            addCriterion("YsGljbId in", values, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidNotIn(List<String> values) {
            addCriterion("YsGljbId not in", values, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidBetween(String value1, String value2) {
            addCriterion("YsGljbId between", value1, value2, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andYsgljbidNotBetween(String value1, String value2) {
            addCriterion("YsGljbId not between", value1, value2, "ysgljbid");
            return (Criteria) this;
        }

        public Criteria andDcxcIsNull() {
            addCriterion("Dcxc is null");
            return (Criteria) this;
        }

        public Criteria andDcxcIsNotNull() {
            addCriterion("Dcxc is not null");
            return (Criteria) this;
        }

        public Criteria andDcxcEqualTo(String value) {
            addCriterion("Dcxc =", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcNotEqualTo(String value) {
            addCriterion("Dcxc <>", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcGreaterThan(String value) {
            addCriterion("Dcxc >", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcGreaterThanOrEqualTo(String value) {
            addCriterion("Dcxc >=", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcLessThan(String value) {
            addCriterion("Dcxc <", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcLessThanOrEqualTo(String value) {
            addCriterion("Dcxc <=", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcLike(String value) {
            addCriterion("Dcxc like", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcNotLike(String value) {
            addCriterion("Dcxc not like", value, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcIn(List<String> values) {
            addCriterion("Dcxc in", values, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcNotIn(List<String> values) {
            addCriterion("Dcxc not in", values, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcBetween(String value1, String value2) {
            addCriterion("Dcxc between", value1, value2, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDcxcNotBetween(String value1, String value2) {
            addCriterion("Dcxc not between", value1, value2, "dcxc");
            return (Criteria) this;
        }

        public Criteria andDyxcIsNull() {
            addCriterion("Dyxc is null");
            return (Criteria) this;
        }

        public Criteria andDyxcIsNotNull() {
            addCriterion("Dyxc is not null");
            return (Criteria) this;
        }

        public Criteria andDyxcEqualTo(String value) {
            addCriterion("Dyxc =", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcNotEqualTo(String value) {
            addCriterion("Dyxc <>", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcGreaterThan(String value) {
            addCriterion("Dyxc >", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcGreaterThanOrEqualTo(String value) {
            addCriterion("Dyxc >=", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcLessThan(String value) {
            addCriterion("Dyxc <", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcLessThanOrEqualTo(String value) {
            addCriterion("Dyxc <=", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcLike(String value) {
            addCriterion("Dyxc like", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcNotLike(String value) {
            addCriterion("Dyxc not like", value, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcIn(List<String> values) {
            addCriterion("Dyxc in", values, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcNotIn(List<String> values) {
            addCriterion("Dyxc not in", values, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcBetween(String value1, String value2) {
            addCriterion("Dyxc between", value1, value2, "dyxc");
            return (Criteria) this;
        }

        public Criteria andDyxcNotBetween(String value1, String value2) {
            addCriterion("Dyxc not between", value1, value2, "dyxc");
            return (Criteria) this;
        }

        public Criteria andStyeIsNull() {
            addCriterion("Stye is null");
            return (Criteria) this;
        }

        public Criteria andStyeIsNotNull() {
            addCriterion("Stye is not null");
            return (Criteria) this;
        }

        public Criteria andStyeEqualTo(String value) {
            addCriterion("Stye =", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeNotEqualTo(String value) {
            addCriterion("Stye <>", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeGreaterThan(String value) {
            addCriterion("Stye >", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeGreaterThanOrEqualTo(String value) {
            addCriterion("Stye >=", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeLessThan(String value) {
            addCriterion("Stye <", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeLessThanOrEqualTo(String value) {
            addCriterion("Stye <=", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeLike(String value) {
            addCriterion("Stye like", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeNotLike(String value) {
            addCriterion("Stye not like", value, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeIn(List<String> values) {
            addCriterion("Stye in", values, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeNotIn(List<String> values) {
            addCriterion("Stye not in", values, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeBetween(String value1, String value2) {
            addCriterion("Stye between", value1, value2, "stye");
            return (Criteria) this;
        }

        public Criteria andStyeNotBetween(String value1, String value2) {
            addCriterion("Stye not between", value1, value2, "stye");
            return (Criteria) this;
        }

        public Criteria andYsyeIsNull() {
            addCriterion("YsYe is null");
            return (Criteria) this;
        }

        public Criteria andYsyeIsNotNull() {
            addCriterion("YsYe is not null");
            return (Criteria) this;
        }

        public Criteria andYsyeEqualTo(String value) {
            addCriterion("YsYe =", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeNotEqualTo(String value) {
            addCriterion("YsYe <>", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeGreaterThan(String value) {
            addCriterion("YsYe >", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeGreaterThanOrEqualTo(String value) {
            addCriterion("YsYe >=", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeLessThan(String value) {
            addCriterion("YsYe <", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeLessThanOrEqualTo(String value) {
            addCriterion("YsYe <=", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeLike(String value) {
            addCriterion("YsYe like", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeNotLike(String value) {
            addCriterion("YsYe not like", value, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeIn(List<String> values) {
            addCriterion("YsYe in", values, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeNotIn(List<String> values) {
            addCriterion("YsYe not in", values, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeBetween(String value1, String value2) {
            addCriterion("YsYe between", value1, value2, "ysye");
            return (Criteria) this;
        }

        public Criteria andYsyeNotBetween(String value1, String value2) {
            addCriterion("YsYe not between", value1, value2, "ysye");
            return (Criteria) this;
        }

        public Criteria andYjIsNull() {
            addCriterion("Yj is null");
            return (Criteria) this;
        }

        public Criteria andYjIsNotNull() {
            addCriterion("Yj is not null");
            return (Criteria) this;
        }

        public Criteria andYjEqualTo(String value) {
            addCriterion("Yj =", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotEqualTo(String value) {
            addCriterion("Yj <>", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThan(String value) {
            addCriterion("Yj >", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThanOrEqualTo(String value) {
            addCriterion("Yj >=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThan(String value) {
            addCriterion("Yj <", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThanOrEqualTo(String value) {
            addCriterion("Yj <=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLike(String value) {
            addCriterion("Yj like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotLike(String value) {
            addCriterion("Yj not like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjIn(List<String> values) {
            addCriterion("Yj in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotIn(List<String> values) {
            addCriterion("Yj not in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjBetween(String value1, String value2) {
            addCriterion("Yj between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotBetween(String value1, String value2) {
            addCriterion("Yj not between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andZkfIsNull() {
            addCriterion("Zkf is null");
            return (Criteria) this;
        }

        public Criteria andZkfIsNotNull() {
            addCriterion("Zkf is not null");
            return (Criteria) this;
        }

        public Criteria andZkfEqualTo(String value) {
            addCriterion("Zkf =", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfNotEqualTo(String value) {
            addCriterion("Zkf <>", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfGreaterThan(String value) {
            addCriterion("Zkf >", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfGreaterThanOrEqualTo(String value) {
            addCriterion("Zkf >=", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfLessThan(String value) {
            addCriterion("Zkf <", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfLessThanOrEqualTo(String value) {
            addCriterion("Zkf <=", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfLike(String value) {
            addCriterion("Zkf like", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfNotLike(String value) {
            addCriterion("Zkf not like", value, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfIn(List<String> values) {
            addCriterion("Zkf in", values, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfNotIn(List<String> values) {
            addCriterion("Zkf not in", values, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfBetween(String value1, String value2) {
            addCriterion("Zkf between", value1, value2, "zkf");
            return (Criteria) this;
        }

        public Criteria andZkfNotBetween(String value1, String value2) {
            addCriterion("Zkf not between", value1, value2, "zkf");
            return (Criteria) this;
        }

        public Criteria andStglfIsNull() {
            addCriterion("StGlf is null");
            return (Criteria) this;
        }

        public Criteria andStglfIsNotNull() {
            addCriterion("StGlf is not null");
            return (Criteria) this;
        }

        public Criteria andStglfEqualTo(String value) {
            addCriterion("StGlf =", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfNotEqualTo(String value) {
            addCriterion("StGlf <>", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfGreaterThan(String value) {
            addCriterion("StGlf >", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfGreaterThanOrEqualTo(String value) {
            addCriterion("StGlf >=", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfLessThan(String value) {
            addCriterion("StGlf <", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfLessThanOrEqualTo(String value) {
            addCriterion("StGlf <=", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfLike(String value) {
            addCriterion("StGlf like", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfNotLike(String value) {
            addCriterion("StGlf not like", value, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfIn(List<String> values) {
            addCriterion("StGlf in", values, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfNotIn(List<String> values) {
            addCriterion("StGlf not in", values, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfBetween(String value1, String value2) {
            addCriterion("StGlf between", value1, value2, "stglf");
            return (Criteria) this;
        }

        public Criteria andStglfNotBetween(String value1, String value2) {
            addCriterion("StGlf not between", value1, value2, "stglf");
            return (Criteria) this;
        }

        public Criteria andYsglfIsNull() {
            addCriterion("YsGlf is null");
            return (Criteria) this;
        }

        public Criteria andYsglfIsNotNull() {
            addCriterion("YsGlf is not null");
            return (Criteria) this;
        }

        public Criteria andYsglfEqualTo(String value) {
            addCriterion("YsGlf =", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfNotEqualTo(String value) {
            addCriterion("YsGlf <>", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfGreaterThan(String value) {
            addCriterion("YsGlf >", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfGreaterThanOrEqualTo(String value) {
            addCriterion("YsGlf >=", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfLessThan(String value) {
            addCriterion("YsGlf <", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfLessThanOrEqualTo(String value) {
            addCriterion("YsGlf <=", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfLike(String value) {
            addCriterion("YsGlf like", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfNotLike(String value) {
            addCriterion("YsGlf not like", value, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfIn(List<String> values) {
            addCriterion("YsGlf in", values, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfNotIn(List<String> values) {
            addCriterion("YsGlf not in", values, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfBetween(String value1, String value2) {
            addCriterion("YsGlf between", value1, value2, "ysglf");
            return (Criteria) this;
        }

        public Criteria andYsglfNotBetween(String value1, String value2) {
            addCriterion("YsGlf not between", value1, value2, "ysglf");
            return (Criteria) this;
        }

        public Criteria andKztIsNull() {
            addCriterion("Kzt is null");
            return (Criteria) this;
        }

        public Criteria andKztIsNotNull() {
            addCriterion("Kzt is not null");
            return (Criteria) this;
        }

        public Criteria andKztEqualTo(String value) {
            addCriterion("Kzt =", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztNotEqualTo(String value) {
            addCriterion("Kzt <>", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztGreaterThan(String value) {
            addCriterion("Kzt >", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztGreaterThanOrEqualTo(String value) {
            addCriterion("Kzt >=", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztLessThan(String value) {
            addCriterion("Kzt <", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztLessThanOrEqualTo(String value) {
            addCriterion("Kzt <=", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztLike(String value) {
            addCriterion("Kzt like", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztNotLike(String value) {
            addCriterion("Kzt not like", value, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztIn(List<String> values) {
            addCriterion("Kzt in", values, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztNotIn(List<String> values) {
            addCriterion("Kzt not in", values, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztBetween(String value1, String value2) {
            addCriterion("Kzt between", value1, value2, "kzt");
            return (Criteria) this;
        }

        public Criteria andKztNotBetween(String value1, String value2) {
            addCriterion("Kzt not between", value1, value2, "kzt");
            return (Criteria) this;
        }

        public Criteria andZgxyifIsNull() {
            addCriterion("ZgXyIf is null");
            return (Criteria) this;
        }

        public Criteria andZgxyifIsNotNull() {
            addCriterion("ZgXyIf is not null");
            return (Criteria) this;
        }

        public Criteria andZgxyifEqualTo(String value) {
            addCriterion("ZgXyIf =", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifNotEqualTo(String value) {
            addCriterion("ZgXyIf <>", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifGreaterThan(String value) {
            addCriterion("ZgXyIf >", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifGreaterThanOrEqualTo(String value) {
            addCriterion("ZgXyIf >=", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifLessThan(String value) {
            addCriterion("ZgXyIf <", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifLessThanOrEqualTo(String value) {
            addCriterion("ZgXyIf <=", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifLike(String value) {
            addCriterion("ZgXyIf like", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifNotLike(String value) {
            addCriterion("ZgXyIf not like", value, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifIn(List<String> values) {
            addCriterion("ZgXyIf in", values, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifNotIn(List<String> values) {
            addCriterion("ZgXyIf not in", values, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifBetween(String value1, String value2) {
            addCriterion("ZgXyIf between", value1, value2, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andZgxyifNotBetween(String value1, String value2) {
            addCriterion("ZgXyIf not between", value1, value2, "zgxyif");
            return (Criteria) this;
        }

        public Criteria andBkrqIsNull() {
            addCriterion("bkrq is null");
            return (Criteria) this;
        }

        public Criteria andBkrqIsNotNull() {
            addCriterion("bkrq is not null");
            return (Criteria) this;
        }

        public Criteria andBkrqEqualTo(String value) {
            addCriterion("bkrq =", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqNotEqualTo(String value) {
            addCriterion("bkrq <>", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqGreaterThan(String value) {
            addCriterion("bkrq >", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqGreaterThanOrEqualTo(String value) {
            addCriterion("bkrq >=", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqLessThan(String value) {
            addCriterion("bkrq <", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqLessThanOrEqualTo(String value) {
            addCriterion("bkrq <=", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqLike(String value) {
            addCriterion("bkrq like", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqNotLike(String value) {
            addCriterion("bkrq not like", value, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqIn(List<String> values) {
            addCriterion("bkrq in", values, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqNotIn(List<String> values) {
            addCriterion("bkrq not in", values, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqBetween(String value1, String value2) {
            addCriterion("bkrq between", value1, value2, "bkrq");
            return (Criteria) this;
        }

        public Criteria andBkrqNotBetween(String value1, String value2) {
            addCriterion("bkrq not between", value1, value2, "bkrq");
            return (Criteria) this;
        }

        public Criteria andRylxidIsNull() {
            addCriterion("rylxID is null");
            return (Criteria) this;
        }

        public Criteria andRylxidIsNotNull() {
            addCriterion("rylxID is not null");
            return (Criteria) this;
        }

        public Criteria andRylxidEqualTo(String value) {
            addCriterion("rylxID =", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidNotEqualTo(String value) {
            addCriterion("rylxID <>", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidGreaterThan(String value) {
            addCriterion("rylxID >", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidGreaterThanOrEqualTo(String value) {
            addCriterion("rylxID >=", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidLessThan(String value) {
            addCriterion("rylxID <", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidLessThanOrEqualTo(String value) {
            addCriterion("rylxID <=", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidLike(String value) {
            addCriterion("rylxID like", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidNotLike(String value) {
            addCriterion("rylxID not like", value, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidIn(List<String> values) {
            addCriterion("rylxID in", values, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidNotIn(List<String> values) {
            addCriterion("rylxID not in", values, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidBetween(String value1, String value2) {
            addCriterion("rylxID between", value1, value2, "rylxid");
            return (Criteria) this;
        }

        public Criteria andRylxidNotBetween(String value1, String value2) {
            addCriterion("rylxID not between", value1, value2, "rylxid");
            return (Criteria) this;
        }

        public Criteria andMzbhIsNull() {
            addCriterion("Mzbh is null");
            return (Criteria) this;
        }

        public Criteria andMzbhIsNotNull() {
            addCriterion("Mzbh is not null");
            return (Criteria) this;
        }

        public Criteria andMzbhEqualTo(String value) {
            addCriterion("Mzbh =", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhNotEqualTo(String value) {
            addCriterion("Mzbh <>", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhGreaterThan(String value) {
            addCriterion("Mzbh >", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhGreaterThanOrEqualTo(String value) {
            addCriterion("Mzbh >=", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhLessThan(String value) {
            addCriterion("Mzbh <", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhLessThanOrEqualTo(String value) {
            addCriterion("Mzbh <=", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhLike(String value) {
            addCriterion("Mzbh like", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhNotLike(String value) {
            addCriterion("Mzbh not like", value, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhIn(List<String> values) {
            addCriterion("Mzbh in", values, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhNotIn(List<String> values) {
            addCriterion("Mzbh not in", values, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhBetween(String value1, String value2) {
            addCriterion("Mzbh between", value1, value2, "mzbh");
            return (Criteria) this;
        }

        public Criteria andMzbhNotBetween(String value1, String value2) {
            addCriterion("Mzbh not between", value1, value2, "mzbh");
            return (Criteria) this;
        }

        public Criteria andGzkkhIsNull() {
            addCriterion("Gzkkh is null");
            return (Criteria) this;
        }

        public Criteria andGzkkhIsNotNull() {
            addCriterion("Gzkkh is not null");
            return (Criteria) this;
        }

        public Criteria andGzkkhEqualTo(String value) {
            addCriterion("Gzkkh =", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhNotEqualTo(String value) {
            addCriterion("Gzkkh <>", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhGreaterThan(String value) {
            addCriterion("Gzkkh >", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhGreaterThanOrEqualTo(String value) {
            addCriterion("Gzkkh >=", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhLessThan(String value) {
            addCriterion("Gzkkh <", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhLessThanOrEqualTo(String value) {
            addCriterion("Gzkkh <=", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhLike(String value) {
            addCriterion("Gzkkh like", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhNotLike(String value) {
            addCriterion("Gzkkh not like", value, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhIn(List<String> values) {
            addCriterion("Gzkkh in", values, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhNotIn(List<String> values) {
            addCriterion("Gzkkh not in", values, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhBetween(String value1, String value2) {
            addCriterion("Gzkkh between", value1, value2, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andGzkkhNotBetween(String value1, String value2) {
            addCriterion("Gzkkh not between", value1, value2, "gzkkh");
            return (Criteria) this;
        }

        public Criteria andCzybhIsNull() {
            addCriterion("Czybh is null");
            return (Criteria) this;
        }

        public Criteria andCzybhIsNotNull() {
            addCriterion("Czybh is not null");
            return (Criteria) this;
        }

        public Criteria andCzybhEqualTo(String value) {
            addCriterion("Czybh =", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhNotEqualTo(String value) {
            addCriterion("Czybh <>", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhGreaterThan(String value) {
            addCriterion("Czybh >", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhGreaterThanOrEqualTo(String value) {
            addCriterion("Czybh >=", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhLessThan(String value) {
            addCriterion("Czybh <", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhLessThanOrEqualTo(String value) {
            addCriterion("Czybh <=", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhLike(String value) {
            addCriterion("Czybh like", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhNotLike(String value) {
            addCriterion("Czybh not like", value, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhIn(List<String> values) {
            addCriterion("Czybh in", values, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhNotIn(List<String> values) {
            addCriterion("Czybh not in", values, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhBetween(String value1, String value2) {
            addCriterion("Czybh between", value1, value2, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzybhNotBetween(String value1, String value2) {
            addCriterion("Czybh not between", value1, value2, "czybh");
            return (Criteria) this;
        }

        public Criteria andCzsjIsNull() {
            addCriterion("Czsj is null");
            return (Criteria) this;
        }

        public Criteria andCzsjIsNotNull() {
            addCriterion("Czsj is not null");
            return (Criteria) this;
        }

        public Criteria andCzsjEqualTo(Date value) {
            addCriterion("Czsj =", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotEqualTo(Date value) {
            addCriterion("Czsj <>", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjGreaterThan(Date value) {
            addCriterion("Czsj >", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjGreaterThanOrEqualTo(Date value) {
            addCriterion("Czsj >=", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjLessThan(Date value) {
            addCriterion("Czsj <", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjLessThanOrEqualTo(Date value) {
            addCriterion("Czsj <=", value, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjIn(List<Date> values) {
            addCriterion("Czsj in", values, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotIn(List<Date> values) {
            addCriterion("Czsj not in", values, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjBetween(Date value1, Date value2) {
            addCriterion("Czsj between", value1, value2, "czsj");
            return (Criteria) this;
        }

        public Criteria andCzsjNotBetween(Date value1, Date value2) {
            addCriterion("Czsj not between", value1, value2, "czsj");
            return (Criteria) this;
        }

        public Criteria andTmpstrIsNull() {
            addCriterion("tmpstr is null");
            return (Criteria) this;
        }

        public Criteria andTmpstrIsNotNull() {
            addCriterion("tmpstr is not null");
            return (Criteria) this;
        }

        public Criteria andTmpstrEqualTo(String value) {
            addCriterion("tmpstr =", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrNotEqualTo(String value) {
            addCriterion("tmpstr <>", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrGreaterThan(String value) {
            addCriterion("tmpstr >", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrGreaterThanOrEqualTo(String value) {
            addCriterion("tmpstr >=", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrLessThan(String value) {
            addCriterion("tmpstr <", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrLessThanOrEqualTo(String value) {
            addCriterion("tmpstr <=", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrLike(String value) {
            addCriterion("tmpstr like", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrNotLike(String value) {
            addCriterion("tmpstr not like", value, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrIn(List<String> values) {
            addCriterion("tmpstr in", values, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrNotIn(List<String> values) {
            addCriterion("tmpstr not in", values, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrBetween(String value1, String value2) {
            addCriterion("tmpstr between", value1, value2, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andTmpstrNotBetween(String value1, String value2) {
            addCriterion("tmpstr not between", value1, value2, "tmpstr");
            return (Criteria) this;
        }

        public Criteria andSfgzidIsNull() {
            addCriterion("sfgzid is null");
            return (Criteria) this;
        }

        public Criteria andSfgzidIsNotNull() {
            addCriterion("sfgzid is not null");
            return (Criteria) this;
        }

        public Criteria andSfgzidEqualTo(String value) {
            addCriterion("sfgzid =", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidNotEqualTo(String value) {
            addCriterion("sfgzid <>", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidGreaterThan(String value) {
            addCriterion("sfgzid >", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidGreaterThanOrEqualTo(String value) {
            addCriterion("sfgzid >=", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidLessThan(String value) {
            addCriterion("sfgzid <", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidLessThanOrEqualTo(String value) {
            addCriterion("sfgzid <=", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidLike(String value) {
            addCriterion("sfgzid like", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidNotLike(String value) {
            addCriterion("sfgzid not like", value, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidIn(List<String> values) {
            addCriterion("sfgzid in", values, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidNotIn(List<String> values) {
            addCriterion("sfgzid not in", values, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidBetween(String value1, String value2) {
            addCriterion("sfgzid between", value1, value2, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andSfgzidNotBetween(String value1, String value2) {
            addCriterion("sfgzid not between", value1, value2, "sfgzid");
            return (Criteria) this;
        }

        public Criteria andBzjeIsNull() {
            addCriterion("bzje is null");
            return (Criteria) this;
        }

        public Criteria andBzjeIsNotNull() {
            addCriterion("bzje is not null");
            return (Criteria) this;
        }

        public Criteria andBzjeEqualTo(String value) {
            addCriterion("bzje =", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeNotEqualTo(String value) {
            addCriterion("bzje <>", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeGreaterThan(String value) {
            addCriterion("bzje >", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeGreaterThanOrEqualTo(String value) {
            addCriterion("bzje >=", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeLessThan(String value) {
            addCriterion("bzje <", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeLessThanOrEqualTo(String value) {
            addCriterion("bzje <=", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeLike(String value) {
            addCriterion("bzje like", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeNotLike(String value) {
            addCriterion("bzje not like", value, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeIn(List<String> values) {
            addCriterion("bzje in", values, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeNotIn(List<String> values) {
            addCriterion("bzje not in", values, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeBetween(String value1, String value2) {
            addCriterion("bzje between", value1, value2, "bzje");
            return (Criteria) this;
        }

        public Criteria andBzjeNotBetween(String value1, String value2) {
            addCriterion("bzje not between", value1, value2, "bzje");
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