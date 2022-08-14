package com.sports.model;

import java.util.ArrayList;
import java.util.List;

public class ResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultExample() {
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

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(Integer value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(Integer value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(Integer value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(Integer value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<Integer> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<Integer> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(Integer value1, Integer value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andCompeIdIsNull() {
            addCriterion("compe_id is null");
            return (Criteria) this;
        }

        public Criteria andCompeIdIsNotNull() {
            addCriterion("compe_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompeIdEqualTo(Integer value) {
            addCriterion("compe_id =", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdNotEqualTo(Integer value) {
            addCriterion("compe_id <>", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdGreaterThan(Integer value) {
            addCriterion("compe_id >", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_id >=", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdLessThan(Integer value) {
            addCriterion("compe_id <", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdLessThanOrEqualTo(Integer value) {
            addCriterion("compe_id <=", value, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdIn(List<Integer> values) {
            addCriterion("compe_id in", values, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdNotIn(List<Integer> values) {
            addCriterion("compe_id not in", values, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdBetween(Integer value1, Integer value2) {
            addCriterion("compe_id between", value1, value2, "compeId");
            return (Criteria) this;
        }

        public Criteria andCompeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_id not between", value1, value2, "compeId");
            return (Criteria) this;
        }

        public Criteria andResHtScoreIsNull() {
            addCriterion("res_ht_score is null");
            return (Criteria) this;
        }

        public Criteria andResHtScoreIsNotNull() {
            addCriterion("res_ht_score is not null");
            return (Criteria) this;
        }

        public Criteria andResHtScoreEqualTo(Integer value) {
            addCriterion("res_ht_score =", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreNotEqualTo(Integer value) {
            addCriterion("res_ht_score <>", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreGreaterThan(Integer value) {
            addCriterion("res_ht_score >", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_ht_score >=", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreLessThan(Integer value) {
            addCriterion("res_ht_score <", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreLessThanOrEqualTo(Integer value) {
            addCriterion("res_ht_score <=", value, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreIn(List<Integer> values) {
            addCriterion("res_ht_score in", values, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreNotIn(List<Integer> values) {
            addCriterion("res_ht_score not in", values, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreBetween(Integer value1, Integer value2) {
            addCriterion("res_ht_score between", value1, value2, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResHtScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("res_ht_score not between", value1, value2, "resHtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreIsNull() {
            addCriterion("res_gt_score is null");
            return (Criteria) this;
        }

        public Criteria andResGtScoreIsNotNull() {
            addCriterion("res_gt_score is not null");
            return (Criteria) this;
        }

        public Criteria andResGtScoreEqualTo(Integer value) {
            addCriterion("res_gt_score =", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreNotEqualTo(Integer value) {
            addCriterion("res_gt_score <>", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreGreaterThan(Integer value) {
            addCriterion("res_gt_score >", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_gt_score >=", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreLessThan(Integer value) {
            addCriterion("res_gt_score <", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreLessThanOrEqualTo(Integer value) {
            addCriterion("res_gt_score <=", value, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreIn(List<Integer> values) {
            addCriterion("res_gt_score in", values, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreNotIn(List<Integer> values) {
            addCriterion("res_gt_score not in", values, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreBetween(Integer value1, Integer value2) {
            addCriterion("res_gt_score between", value1, value2, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResGtScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("res_gt_score not between", value1, value2, "resGtScore");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonIsNull() {
            addCriterion("res_ht_Ldragon is null");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonIsNotNull() {
            addCriterion("res_ht_Ldragon is not null");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonEqualTo(Byte value) {
            addCriterion("res_ht_Ldragon =", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonNotEqualTo(Byte value) {
            addCriterion("res_ht_Ldragon <>", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonGreaterThan(Byte value) {
            addCriterion("res_ht_Ldragon >", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_ht_Ldragon >=", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonLessThan(Byte value) {
            addCriterion("res_ht_Ldragon <", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonLessThanOrEqualTo(Byte value) {
            addCriterion("res_ht_Ldragon <=", value, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonIn(List<Byte> values) {
            addCriterion("res_ht_Ldragon in", values, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonNotIn(List<Byte> values) {
            addCriterion("res_ht_Ldragon not in", values, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_Ldragon between", value1, value2, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtLdragonNotBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_Ldragon not between", value1, value2, "resHtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonIsNull() {
            addCriterion("res_gt_Ldragon is null");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonIsNotNull() {
            addCriterion("res_gt_Ldragon is not null");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonEqualTo(Byte value) {
            addCriterion("res_gt_Ldragon =", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonNotEqualTo(Byte value) {
            addCriterion("res_gt_Ldragon <>", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonGreaterThan(Byte value) {
            addCriterion("res_gt_Ldragon >", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_gt_Ldragon >=", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonLessThan(Byte value) {
            addCriterion("res_gt_Ldragon <", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonLessThanOrEqualTo(Byte value) {
            addCriterion("res_gt_Ldragon <=", value, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonIn(List<Byte> values) {
            addCriterion("res_gt_Ldragon in", values, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonNotIn(List<Byte> values) {
            addCriterion("res_gt_Ldragon not in", values, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_Ldragon between", value1, value2, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResGtLdragonNotBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_Ldragon not between", value1, value2, "resGtLdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonIsNull() {
            addCriterion("res_ht_Sdragon is null");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonIsNotNull() {
            addCriterion("res_ht_Sdragon is not null");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonEqualTo(Byte value) {
            addCriterion("res_ht_Sdragon =", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonNotEqualTo(Byte value) {
            addCriterion("res_ht_Sdragon <>", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonGreaterThan(Byte value) {
            addCriterion("res_ht_Sdragon >", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_ht_Sdragon >=", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonLessThan(Byte value) {
            addCriterion("res_ht_Sdragon <", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonLessThanOrEqualTo(Byte value) {
            addCriterion("res_ht_Sdragon <=", value, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonIn(List<Byte> values) {
            addCriterion("res_ht_Sdragon in", values, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonNotIn(List<Byte> values) {
            addCriterion("res_ht_Sdragon not in", values, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_Sdragon between", value1, value2, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtSdragonNotBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_Sdragon not between", value1, value2, "resHtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonIsNull() {
            addCriterion("res_gt_Sdragon is null");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonIsNotNull() {
            addCriterion("res_gt_Sdragon is not null");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonEqualTo(Byte value) {
            addCriterion("res_gt_Sdragon =", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonNotEqualTo(Byte value) {
            addCriterion("res_gt_Sdragon <>", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonGreaterThan(Byte value) {
            addCriterion("res_gt_Sdragon >", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_gt_Sdragon >=", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonLessThan(Byte value) {
            addCriterion("res_gt_Sdragon <", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonLessThanOrEqualTo(Byte value) {
            addCriterion("res_gt_Sdragon <=", value, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonIn(List<Byte> values) {
            addCriterion("res_gt_Sdragon in", values, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonNotIn(List<Byte> values) {
            addCriterion("res_gt_Sdragon not in", values, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_Sdragon between", value1, value2, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResGtSdragonNotBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_Sdragon not between", value1, value2, "resGtSdragon");
            return (Criteria) this;
        }

        public Criteria andResHtGoldIsNull() {
            addCriterion("res_ht_gold is null");
            return (Criteria) this;
        }

        public Criteria andResHtGoldIsNotNull() {
            addCriterion("res_ht_gold is not null");
            return (Criteria) this;
        }

        public Criteria andResHtGoldEqualTo(Integer value) {
            addCriterion("res_ht_gold =", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldNotEqualTo(Integer value) {
            addCriterion("res_ht_gold <>", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldGreaterThan(Integer value) {
            addCriterion("res_ht_gold >", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_ht_gold >=", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldLessThan(Integer value) {
            addCriterion("res_ht_gold <", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldLessThanOrEqualTo(Integer value) {
            addCriterion("res_ht_gold <=", value, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldIn(List<Integer> values) {
            addCriterion("res_ht_gold in", values, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldNotIn(List<Integer> values) {
            addCriterion("res_ht_gold not in", values, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldBetween(Integer value1, Integer value2) {
            addCriterion("res_ht_gold between", value1, value2, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("res_ht_gold not between", value1, value2, "resHtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldIsNull() {
            addCriterion("res_gt_gold is null");
            return (Criteria) this;
        }

        public Criteria andResGtGoldIsNotNull() {
            addCriterion("res_gt_gold is not null");
            return (Criteria) this;
        }

        public Criteria andResGtGoldEqualTo(Integer value) {
            addCriterion("res_gt_gold =", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldNotEqualTo(Integer value) {
            addCriterion("res_gt_gold <>", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldGreaterThan(Integer value) {
            addCriterion("res_gt_gold >", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_gt_gold >=", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldLessThan(Integer value) {
            addCriterion("res_gt_gold <", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldLessThanOrEqualTo(Integer value) {
            addCriterion("res_gt_gold <=", value, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldIn(List<Integer> values) {
            addCriterion("res_gt_gold in", values, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldNotIn(List<Integer> values) {
            addCriterion("res_gt_gold not in", values, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldBetween(Integer value1, Integer value2) {
            addCriterion("res_gt_gold between", value1, value2, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResGtGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("res_gt_gold not between", value1, value2, "resGtGold");
            return (Criteria) this;
        }

        public Criteria andResHtGuardIsNull() {
            addCriterion("res_ht_guard is null");
            return (Criteria) this;
        }

        public Criteria andResHtGuardIsNotNull() {
            addCriterion("res_ht_guard is not null");
            return (Criteria) this;
        }

        public Criteria andResHtGuardEqualTo(Byte value) {
            addCriterion("res_ht_guard =", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardNotEqualTo(Byte value) {
            addCriterion("res_ht_guard <>", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardGreaterThan(Byte value) {
            addCriterion("res_ht_guard >", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_ht_guard >=", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardLessThan(Byte value) {
            addCriterion("res_ht_guard <", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardLessThanOrEqualTo(Byte value) {
            addCriterion("res_ht_guard <=", value, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardIn(List<Byte> values) {
            addCriterion("res_ht_guard in", values, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardNotIn(List<Byte> values) {
            addCriterion("res_ht_guard not in", values, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_guard between", value1, value2, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResHtGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("res_ht_guard not between", value1, value2, "resHtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardIsNull() {
            addCriterion("res_gt_guard is null");
            return (Criteria) this;
        }

        public Criteria andResGtGuardIsNotNull() {
            addCriterion("res_gt_guard is not null");
            return (Criteria) this;
        }

        public Criteria andResGtGuardEqualTo(Byte value) {
            addCriterion("res_gt_guard =", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardNotEqualTo(Byte value) {
            addCriterion("res_gt_guard <>", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardGreaterThan(Byte value) {
            addCriterion("res_gt_guard >", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_gt_guard >=", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardLessThan(Byte value) {
            addCriterion("res_gt_guard <", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardLessThanOrEqualTo(Byte value) {
            addCriterion("res_gt_guard <=", value, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardIn(List<Byte> values) {
            addCriterion("res_gt_guard in", values, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardNotIn(List<Byte> values) {
            addCriterion("res_gt_guard not in", values, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_guard between", value1, value2, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResGtGuardNotBetween(Byte value1, Byte value2) {
            addCriterion("res_gt_guard not between", value1, value2, "resGtGuard");
            return (Criteria) this;
        }

        public Criteria andResTagIsNull() {
            addCriterion("res_tag is null");
            return (Criteria) this;
        }

        public Criteria andResTagIsNotNull() {
            addCriterion("res_tag is not null");
            return (Criteria) this;
        }

        public Criteria andResTagEqualTo(Byte value) {
            addCriterion("res_tag =", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagNotEqualTo(Byte value) {
            addCriterion("res_tag <>", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagGreaterThan(Byte value) {
            addCriterion("res_tag >", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagGreaterThanOrEqualTo(Byte value) {
            addCriterion("res_tag >=", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagLessThan(Byte value) {
            addCriterion("res_tag <", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagLessThanOrEqualTo(Byte value) {
            addCriterion("res_tag <=", value, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagIn(List<Byte> values) {
            addCriterion("res_tag in", values, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagNotIn(List<Byte> values) {
            addCriterion("res_tag not in", values, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagBetween(Byte value1, Byte value2) {
            addCriterion("res_tag between", value1, value2, "resTag");
            return (Criteria) this;
        }

        public Criteria andResTagNotBetween(Byte value1, Byte value2) {
            addCriterion("res_tag not between", value1, value2, "resTag");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Byte value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Byte value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Byte value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Byte value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Byte value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Byte> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Byte> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Byte value1, Byte value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
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