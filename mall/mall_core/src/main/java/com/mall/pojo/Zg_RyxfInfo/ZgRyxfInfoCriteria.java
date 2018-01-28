package com.mall.pojo.Zg_RyxfInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZgRyxfInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ZgRyxfInfoCriteria() {
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

        public Criteria andRyxfidIsNull() {
            addCriterion("RyxfId is null");
            return (Criteria) this;
        }

        public Criteria andRyxfidIsNotNull() {
            addCriterion("RyxfId is not null");
            return (Criteria) this;
        }

        public Criteria andRyxfidEqualTo(String value) {
            addCriterion("RyxfId =", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidNotEqualTo(String value) {
            addCriterion("RyxfId <>", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidGreaterThan(String value) {
            addCriterion("RyxfId >", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidGreaterThanOrEqualTo(String value) {
            addCriterion("RyxfId >=", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidLessThan(String value) {
            addCriterion("RyxfId <", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidLessThanOrEqualTo(String value) {
            addCriterion("RyxfId <=", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidLike(String value) {
            addCriterion("RyxfId like", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidNotLike(String value) {
            addCriterion("RyxfId not like", value, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidIn(List<String> values) {
            addCriterion("RyxfId in", values, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidNotIn(List<String> values) {
            addCriterion("RyxfId not in", values, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidBetween(String value1, String value2) {
            addCriterion("RyxfId between", value1, value2, "ryxfid");
            return (Criteria) this;
        }

        public Criteria andRyxfidNotBetween(String value1, String value2) {
            addCriterion("RyxfId not between", value1, value2, "ryxfid");
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

        public Criteria andGrpidIsNull() {
            addCriterion("GrpId is null");
            return (Criteria) this;
        }

        public Criteria andGrpidIsNotNull() {
            addCriterion("GrpId is not null");
            return (Criteria) this;
        }

        public Criteria andGrpidEqualTo(String value) {
            addCriterion("GrpId =", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidNotEqualTo(String value) {
            addCriterion("GrpId <>", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidGreaterThan(String value) {
            addCriterion("GrpId >", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidGreaterThanOrEqualTo(String value) {
            addCriterion("GrpId >=", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidLessThan(String value) {
            addCriterion("GrpId <", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidLessThanOrEqualTo(String value) {
            addCriterion("GrpId <=", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidLike(String value) {
            addCriterion("GrpId like", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidNotLike(String value) {
            addCriterion("GrpId not like", value, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidIn(List<String> values) {
            addCriterion("GrpId in", values, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidNotIn(List<String> values) {
            addCriterion("GrpId not in", values, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidBetween(String value1, String value2) {
            addCriterion("GrpId between", value1, value2, "grpid");
            return (Criteria) this;
        }

        public Criteria andGrpidNotBetween(String value1, String value2) {
            addCriterion("GrpId not between", value1, value2, "grpid");
            return (Criteria) this;
        }

        public Criteria andBzidIsNull() {
            addCriterion("BzId is null");
            return (Criteria) this;
        }

        public Criteria andBzidIsNotNull() {
            addCriterion("BzId is not null");
            return (Criteria) this;
        }

        public Criteria andBzidEqualTo(String value) {
            addCriterion("BzId =", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidNotEqualTo(String value) {
            addCriterion("BzId <>", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidGreaterThan(String value) {
            addCriterion("BzId >", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidGreaterThanOrEqualTo(String value) {
            addCriterion("BzId >=", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidLessThan(String value) {
            addCriterion("BzId <", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidLessThanOrEqualTo(String value) {
            addCriterion("BzId <=", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidLike(String value) {
            addCriterion("BzId like", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidNotLike(String value) {
            addCriterion("BzId not like", value, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidIn(List<String> values) {
            addCriterion("BzId in", values, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidNotIn(List<String> values) {
            addCriterion("BzId not in", values, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidBetween(String value1, String value2) {
            addCriterion("BzId between", value1, value2, "bzid");
            return (Criteria) this;
        }

        public Criteria andBzidNotBetween(String value1, String value2) {
            addCriterion("BzId not between", value1, value2, "bzid");
            return (Criteria) this;
        }

        public Criteria andCkjidIsNull() {
            addCriterion("CkjId is null");
            return (Criteria) this;
        }

        public Criteria andCkjidIsNotNull() {
            addCriterion("CkjId is not null");
            return (Criteria) this;
        }

        public Criteria andCkjidEqualTo(String value) {
            addCriterion("CkjId =", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidNotEqualTo(String value) {
            addCriterion("CkjId <>", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidGreaterThan(String value) {
            addCriterion("CkjId >", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidGreaterThanOrEqualTo(String value) {
            addCriterion("CkjId >=", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidLessThan(String value) {
            addCriterion("CkjId <", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidLessThanOrEqualTo(String value) {
            addCriterion("CkjId <=", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidLike(String value) {
            addCriterion("CkjId like", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidNotLike(String value) {
            addCriterion("CkjId not like", value, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidIn(List<String> values) {
            addCriterion("CkjId in", values, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidNotIn(List<String> values) {
            addCriterion("CkjId not in", values, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidBetween(String value1, String value2) {
            addCriterion("CkjId between", value1, value2, "ckjid");
            return (Criteria) this;
        }

        public Criteria andCkjidNotBetween(String value1, String value2) {
            addCriterion("CkjId not between", value1, value2, "ckjid");
            return (Criteria) this;
        }

        public Criteria andZflbIsNull() {
            addCriterion("Zflb is null");
            return (Criteria) this;
        }

        public Criteria andZflbIsNotNull() {
            addCriterion("Zflb is not null");
            return (Criteria) this;
        }

        public Criteria andZflbEqualTo(String value) {
            addCriterion("Zflb =", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbNotEqualTo(String value) {
            addCriterion("Zflb <>", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbGreaterThan(String value) {
            addCriterion("Zflb >", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbGreaterThanOrEqualTo(String value) {
            addCriterion("Zflb >=", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbLessThan(String value) {
            addCriterion("Zflb <", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbLessThanOrEqualTo(String value) {
            addCriterion("Zflb <=", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbLike(String value) {
            addCriterion("Zflb like", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbNotLike(String value) {
            addCriterion("Zflb not like", value, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbIn(List<String> values) {
            addCriterion("Zflb in", values, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbNotIn(List<String> values) {
            addCriterion("Zflb not in", values, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbBetween(String value1, String value2) {
            addCriterion("Zflb between", value1, value2, "zflb");
            return (Criteria) this;
        }

        public Criteria andZflbNotBetween(String value1, String value2) {
            addCriterion("Zflb not between", value1, value2, "zflb");
            return (Criteria) this;
        }

        public Criteria andCbidIsNull() {
            addCriterion("CbId is null");
            return (Criteria) this;
        }

        public Criteria andCbidIsNotNull() {
            addCriterion("CbId is not null");
            return (Criteria) this;
        }

        public Criteria andCbidEqualTo(String value) {
            addCriterion("CbId =", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidNotEqualTo(String value) {
            addCriterion("CbId <>", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidGreaterThan(String value) {
            addCriterion("CbId >", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidGreaterThanOrEqualTo(String value) {
            addCriterion("CbId >=", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidLessThan(String value) {
            addCriterion("CbId <", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidLessThanOrEqualTo(String value) {
            addCriterion("CbId <=", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidLike(String value) {
            addCriterion("CbId like", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidNotLike(String value) {
            addCriterion("CbId not like", value, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidIn(List<String> values) {
            addCriterion("CbId in", values, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidNotIn(List<String> values) {
            addCriterion("CbId not in", values, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidBetween(String value1, String value2) {
            addCriterion("CbId between", value1, value2, "cbid");
            return (Criteria) this;
        }

        public Criteria andCbidNotBetween(String value1, String value2) {
            addCriterion("CbId not between", value1, value2, "cbid");
            return (Criteria) this;
        }

        public Criteria andKeyhIsNull() {
            addCriterion("Keyh is null");
            return (Criteria) this;
        }

        public Criteria andKeyhIsNotNull() {
            addCriterion("Keyh is not null");
            return (Criteria) this;
        }

        public Criteria andKeyhEqualTo(String value) {
            addCriterion("Keyh =", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhNotEqualTo(String value) {
            addCriterion("Keyh <>", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhGreaterThan(String value) {
            addCriterion("Keyh >", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhGreaterThanOrEqualTo(String value) {
            addCriterion("Keyh >=", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhLessThan(String value) {
            addCriterion("Keyh <", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhLessThanOrEqualTo(String value) {
            addCriterion("Keyh <=", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhLike(String value) {
            addCriterion("Keyh like", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhNotLike(String value) {
            addCriterion("Keyh not like", value, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhIn(List<String> values) {
            addCriterion("Keyh in", values, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhNotIn(List<String> values) {
            addCriterion("Keyh not in", values, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhBetween(String value1, String value2) {
            addCriterion("Keyh between", value1, value2, "keyh");
            return (Criteria) this;
        }

        public Criteria andKeyhNotBetween(String value1, String value2) {
            addCriterion("Keyh not between", value1, value2, "keyh");
            return (Criteria) this;
        }

        public Criteria andCmcIsNull() {
            addCriterion("Cmc is null");
            return (Criteria) this;
        }

        public Criteria andCmcIsNotNull() {
            addCriterion("Cmc is not null");
            return (Criteria) this;
        }

        public Criteria andCmcEqualTo(String value) {
            addCriterion("Cmc =", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcNotEqualTo(String value) {
            addCriterion("Cmc <>", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcGreaterThan(String value) {
            addCriterion("Cmc >", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcGreaterThanOrEqualTo(String value) {
            addCriterion("Cmc >=", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcLessThan(String value) {
            addCriterion("Cmc <", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcLessThanOrEqualTo(String value) {
            addCriterion("Cmc <=", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcLike(String value) {
            addCriterion("Cmc like", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcNotLike(String value) {
            addCriterion("Cmc not like", value, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcIn(List<String> values) {
            addCriterion("Cmc in", values, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcNotIn(List<String> values) {
            addCriterion("Cmc not in", values, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcBetween(String value1, String value2) {
            addCriterion("Cmc between", value1, value2, "cmc");
            return (Criteria) this;
        }

        public Criteria andCmcNotBetween(String value1, String value2) {
            addCriterion("Cmc not between", value1, value2, "cmc");
            return (Criteria) this;
        }

        public Criteria andXfjeIsNull() {
            addCriterion("Xfje is null");
            return (Criteria) this;
        }

        public Criteria andXfjeIsNotNull() {
            addCriterion("Xfje is not null");
            return (Criteria) this;
        }

        public Criteria andXfjeEqualTo(String value) {
            addCriterion("Xfje =", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotEqualTo(String value) {
            addCriterion("Xfje <>", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeGreaterThan(String value) {
            addCriterion("Xfje >", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeGreaterThanOrEqualTo(String value) {
            addCriterion("Xfje >=", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeLessThan(String value) {
            addCriterion("Xfje <", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeLessThanOrEqualTo(String value) {
            addCriterion("Xfje <=", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeLike(String value) {
            addCriterion("Xfje like", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotLike(String value) {
            addCriterion("Xfje not like", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeIn(List<String> values) {
            addCriterion("Xfje in", values, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotIn(List<String> values) {
            addCriterion("Xfje not in", values, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeBetween(String value1, String value2) {
            addCriterion("Xfje between", value1, value2, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotBetween(String value1, String value2) {
            addCriterion("Xfje not between", value1, value2, "xfje");
            return (Criteria) this;
        }

        public Criteria andDjIsNull() {
            addCriterion("Dj is null");
            return (Criteria) this;
        }

        public Criteria andDjIsNotNull() {
            addCriterion("Dj is not null");
            return (Criteria) this;
        }

        public Criteria andDjEqualTo(String value) {
            addCriterion("Dj =", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotEqualTo(String value) {
            addCriterion("Dj <>", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThan(String value) {
            addCriterion("Dj >", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjGreaterThanOrEqualTo(String value) {
            addCriterion("Dj >=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThan(String value) {
            addCriterion("Dj <", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLessThanOrEqualTo(String value) {
            addCriterion("Dj <=", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjLike(String value) {
            addCriterion("Dj like", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotLike(String value) {
            addCriterion("Dj not like", value, "dj");
            return (Criteria) this;
        }

        public Criteria andDjIn(List<String> values) {
            addCriterion("Dj in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotIn(List<String> values) {
            addCriterion("Dj not in", values, "dj");
            return (Criteria) this;
        }

        public Criteria andDjBetween(String value1, String value2) {
            addCriterion("Dj between", value1, value2, "dj");
            return (Criteria) this;
        }

        public Criteria andDjNotBetween(String value1, String value2) {
            addCriterion("Dj not between", value1, value2, "dj");
            return (Criteria) this;
        }

        public Criteria andSlIsNull() {
            addCriterion("Sl is null");
            return (Criteria) this;
        }

        public Criteria andSlIsNotNull() {
            addCriterion("Sl is not null");
            return (Criteria) this;
        }

        public Criteria andSlEqualTo(String value) {
            addCriterion("Sl =", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotEqualTo(String value) {
            addCriterion("Sl <>", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThan(String value) {
            addCriterion("Sl >", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThanOrEqualTo(String value) {
            addCriterion("Sl >=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThan(String value) {
            addCriterion("Sl <", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThanOrEqualTo(String value) {
            addCriterion("Sl <=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLike(String value) {
            addCriterion("Sl like", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotLike(String value) {
            addCriterion("Sl not like", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlIn(List<String> values) {
            addCriterion("Sl in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotIn(List<String> values) {
            addCriterion("Sl not in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlBetween(String value1, String value2) {
            addCriterion("Sl between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotBetween(String value1, String value2) {
            addCriterion("Sl not between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andYeIsNull() {
            addCriterion("Ye is null");
            return (Criteria) this;
        }

        public Criteria andYeIsNotNull() {
            addCriterion("Ye is not null");
            return (Criteria) this;
        }

        public Criteria andYeEqualTo(String value) {
            addCriterion("Ye =", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeNotEqualTo(String value) {
            addCriterion("Ye <>", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeGreaterThan(String value) {
            addCriterion("Ye >", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeGreaterThanOrEqualTo(String value) {
            addCriterion("Ye >=", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeLessThan(String value) {
            addCriterion("Ye <", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeLessThanOrEqualTo(String value) {
            addCriterion("Ye <=", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeLike(String value) {
            addCriterion("Ye like", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeNotLike(String value) {
            addCriterion("Ye not like", value, "ye");
            return (Criteria) this;
        }

        public Criteria andYeIn(List<String> values) {
            addCriterion("Ye in", values, "ye");
            return (Criteria) this;
        }

        public Criteria andYeNotIn(List<String> values) {
            addCriterion("Ye not in", values, "ye");
            return (Criteria) this;
        }

        public Criteria andYeBetween(String value1, String value2) {
            addCriterion("Ye between", value1, value2, "ye");
            return (Criteria) this;
        }

        public Criteria andYeNotBetween(String value1, String value2) {
            addCriterion("Ye not between", value1, value2, "ye");
            return (Criteria) this;
        }

        public Criteria andXfrqIsNull() {
            addCriterion("Xfrq is null");
            return (Criteria) this;
        }

        public Criteria andXfrqIsNotNull() {
            addCriterion("Xfrq is not null");
            return (Criteria) this;
        }

        public Criteria andXfrqEqualTo(String value) {
            addCriterion("Xfrq =", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqNotEqualTo(String value) {
            addCriterion("Xfrq <>", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqGreaterThan(String value) {
            addCriterion("Xfrq >", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqGreaterThanOrEqualTo(String value) {
            addCriterion("Xfrq >=", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqLessThan(String value) {
            addCriterion("Xfrq <", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqLessThanOrEqualTo(String value) {
            addCriterion("Xfrq <=", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqLike(String value) {
            addCriterion("Xfrq like", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqNotLike(String value) {
            addCriterion("Xfrq not like", value, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqIn(List<String> values) {
            addCriterion("Xfrq in", values, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqNotIn(List<String> values) {
            addCriterion("Xfrq not in", values, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqBetween(String value1, String value2) {
            addCriterion("Xfrq between", value1, value2, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfrqNotBetween(String value1, String value2) {
            addCriterion("Xfrq not between", value1, value2, "xfrq");
            return (Criteria) this;
        }

        public Criteria andXfsjIsNull() {
            addCriterion("Xfsj is null");
            return (Criteria) this;
        }

        public Criteria andXfsjIsNotNull() {
            addCriterion("Xfsj is not null");
            return (Criteria) this;
        }

        public Criteria andXfsjEqualTo(String value) {
            addCriterion("Xfsj =", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotEqualTo(String value) {
            addCriterion("Xfsj <>", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjGreaterThan(String value) {
            addCriterion("Xfsj >", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjGreaterThanOrEqualTo(String value) {
            addCriterion("Xfsj >=", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjLessThan(String value) {
            addCriterion("Xfsj <", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjLessThanOrEqualTo(String value) {
            addCriterion("Xfsj <=", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjLike(String value) {
            addCriterion("Xfsj like", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotLike(String value) {
            addCriterion("Xfsj not like", value, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjIn(List<String> values) {
            addCriterion("Xfsj in", values, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotIn(List<String> values) {
            addCriterion("Xfsj not in", values, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjBetween(String value1, String value2) {
            addCriterion("Xfsj between", value1, value2, "xfsj");
            return (Criteria) this;
        }

        public Criteria andXfsjNotBetween(String value1, String value2) {
            addCriterion("Xfsj not between", value1, value2, "xfsj");
            return (Criteria) this;
        }

        public Criteria andBjIsNull() {
            addCriterion("bj is null");
            return (Criteria) this;
        }

        public Criteria andBjIsNotNull() {
            addCriterion("bj is not null");
            return (Criteria) this;
        }

        public Criteria andBjEqualTo(String value) {
            addCriterion("bj =", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotEqualTo(String value) {
            addCriterion("bj <>", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjGreaterThan(String value) {
            addCriterion("bj >", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjGreaterThanOrEqualTo(String value) {
            addCriterion("bj >=", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLessThan(String value) {
            addCriterion("bj <", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLessThanOrEqualTo(String value) {
            addCriterion("bj <=", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjLike(String value) {
            addCriterion("bj like", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotLike(String value) {
            addCriterion("bj not like", value, "bj");
            return (Criteria) this;
        }

        public Criteria andBjIn(List<String> values) {
            addCriterion("bj in", values, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotIn(List<String> values) {
            addCriterion("bj not in", values, "bj");
            return (Criteria) this;
        }

        public Criteria andBjBetween(String value1, String value2) {
            addCriterion("bj between", value1, value2, "bj");
            return (Criteria) this;
        }

        public Criteria andBjNotBetween(String value1, String value2) {
            addCriterion("bj not between", value1, value2, "bj");
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

        public Criteria andChjcbzIsNull() {
            addCriterion("Chjcbz is null");
            return (Criteria) this;
        }

        public Criteria andChjcbzIsNotNull() {
            addCriterion("Chjcbz is not null");
            return (Criteria) this;
        }

        public Criteria andChjcbzEqualTo(String value) {
            addCriterion("Chjcbz =", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzNotEqualTo(String value) {
            addCriterion("Chjcbz <>", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzGreaterThan(String value) {
            addCriterion("Chjcbz >", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzGreaterThanOrEqualTo(String value) {
            addCriterion("Chjcbz >=", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzLessThan(String value) {
            addCriterion("Chjcbz <", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzLessThanOrEqualTo(String value) {
            addCriterion("Chjcbz <=", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzLike(String value) {
            addCriterion("Chjcbz like", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzNotLike(String value) {
            addCriterion("Chjcbz not like", value, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzIn(List<String> values) {
            addCriterion("Chjcbz in", values, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzNotIn(List<String> values) {
            addCriterion("Chjcbz not in", values, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzBetween(String value1, String value2) {
            addCriterion("Chjcbz between", value1, value2, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andChjcbzNotBetween(String value1, String value2) {
            addCriterion("Chjcbz not between", value1, value2, "chjcbz");
            return (Criteria) this;
        }

        public Criteria andJqmIsNull() {
            addCriterion("jqm is null");
            return (Criteria) this;
        }

        public Criteria andJqmIsNotNull() {
            addCriterion("jqm is not null");
            return (Criteria) this;
        }

        public Criteria andJqmEqualTo(String value) {
            addCriterion("jqm =", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmNotEqualTo(String value) {
            addCriterion("jqm <>", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmGreaterThan(String value) {
            addCriterion("jqm >", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmGreaterThanOrEqualTo(String value) {
            addCriterion("jqm >=", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmLessThan(String value) {
            addCriterion("jqm <", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmLessThanOrEqualTo(String value) {
            addCriterion("jqm <=", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmLike(String value) {
            addCriterion("jqm like", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmNotLike(String value) {
            addCriterion("jqm not like", value, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmIn(List<String> values) {
            addCriterion("jqm in", values, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmNotIn(List<String> values) {
            addCriterion("jqm not in", values, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmBetween(String value1, String value2) {
            addCriterion("jqm between", value1, value2, "jqm");
            return (Criteria) this;
        }

        public Criteria andJqmNotBetween(String value1, String value2) {
            addCriterion("jqm not between", value1, value2, "jqm");
            return (Criteria) this;
        }

        public Criteria andZklIsNull() {
            addCriterion("zkl is null");
            return (Criteria) this;
        }

        public Criteria andZklIsNotNull() {
            addCriterion("zkl is not null");
            return (Criteria) this;
        }

        public Criteria andZklEqualTo(String value) {
            addCriterion("zkl =", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklNotEqualTo(String value) {
            addCriterion("zkl <>", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklGreaterThan(String value) {
            addCriterion("zkl >", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklGreaterThanOrEqualTo(String value) {
            addCriterion("zkl >=", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklLessThan(String value) {
            addCriterion("zkl <", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklLessThanOrEqualTo(String value) {
            addCriterion("zkl <=", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklLike(String value) {
            addCriterion("zkl like", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklNotLike(String value) {
            addCriterion("zkl not like", value, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklIn(List<String> values) {
            addCriterion("zkl in", values, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklNotIn(List<String> values) {
            addCriterion("zkl not in", values, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklBetween(String value1, String value2) {
            addCriterion("zkl between", value1, value2, "zkl");
            return (Criteria) this;
        }

        public Criteria andZklNotBetween(String value1, String value2) {
            addCriterion("zkl not between", value1, value2, "zkl");
            return (Criteria) this;
        }

        public Criteria andSjxfjeIsNull() {
            addCriterion("sjxfje is null");
            return (Criteria) this;
        }

        public Criteria andSjxfjeIsNotNull() {
            addCriterion("sjxfje is not null");
            return (Criteria) this;
        }

        public Criteria andSjxfjeEqualTo(String value) {
            addCriterion("sjxfje =", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeNotEqualTo(String value) {
            addCriterion("sjxfje <>", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeGreaterThan(String value) {
            addCriterion("sjxfje >", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeGreaterThanOrEqualTo(String value) {
            addCriterion("sjxfje >=", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeLessThan(String value) {
            addCriterion("sjxfje <", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeLessThanOrEqualTo(String value) {
            addCriterion("sjxfje <=", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeLike(String value) {
            addCriterion("sjxfje like", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeNotLike(String value) {
            addCriterion("sjxfje not like", value, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeIn(List<String> values) {
            addCriterion("sjxfje in", values, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeNotIn(List<String> values) {
            addCriterion("sjxfje not in", values, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeBetween(String value1, String value2) {
            addCriterion("sjxfje between", value1, value2, "sjxfje");
            return (Criteria) this;
        }

        public Criteria andSjxfjeNotBetween(String value1, String value2) {
            addCriterion("sjxfje not between", value1, value2, "sjxfje");
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