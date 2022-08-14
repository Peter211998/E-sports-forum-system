package com.sports.model;

import java.util.ArrayList;
import java.util.List;

public class CompetitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompetitionExample() {
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

        public Criteria andCompeTitleIsNull() {
            addCriterion("compe_title is null");
            return (Criteria) this;
        }

        public Criteria andCompeTitleIsNotNull() {
            addCriterion("compe_title is not null");
            return (Criteria) this;
        }

        public Criteria andCompeTitleEqualTo(String value) {
            addCriterion("compe_title =", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleNotEqualTo(String value) {
            addCriterion("compe_title <>", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleGreaterThan(String value) {
            addCriterion("compe_title >", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("compe_title >=", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleLessThan(String value) {
            addCriterion("compe_title <", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleLessThanOrEqualTo(String value) {
            addCriterion("compe_title <=", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleLike(String value) {
            addCriterion("compe_title like", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleNotLike(String value) {
            addCriterion("compe_title not like", value, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleIn(List<String> values) {
            addCriterion("compe_title in", values, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleNotIn(List<String> values) {
            addCriterion("compe_title not in", values, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleBetween(String value1, String value2) {
            addCriterion("compe_title between", value1, value2, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTitleNotBetween(String value1, String value2) {
            addCriterion("compe_title not between", value1, value2, "compeTitle");
            return (Criteria) this;
        }

        public Criteria andCompeTypeIsNull() {
            addCriterion("compe_type is null");
            return (Criteria) this;
        }

        public Criteria andCompeTypeIsNotNull() {
            addCriterion("compe_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompeTypeEqualTo(Integer value) {
            addCriterion("compe_type =", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeNotEqualTo(Integer value) {
            addCriterion("compe_type <>", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeGreaterThan(Integer value) {
            addCriterion("compe_type >", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_type >=", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeLessThan(Integer value) {
            addCriterion("compe_type <", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("compe_type <=", value, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeIn(List<Integer> values) {
            addCriterion("compe_type in", values, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeNotIn(List<Integer> values) {
            addCriterion("compe_type not in", values, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeBetween(Integer value1, Integer value2) {
            addCriterion("compe_type between", value1, value2, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_type not between", value1, value2, "compeType");
            return (Criteria) this;
        }

        public Criteria andCompeStatusIsNull() {
            addCriterion("compe_status is null");
            return (Criteria) this;
        }

        public Criteria andCompeStatusIsNotNull() {
            addCriterion("compe_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompeStatusEqualTo(Integer value) {
            addCriterion("compe_status =", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusNotEqualTo(Integer value) {
            addCriterion("compe_status <>", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusGreaterThan(Integer value) {
            addCriterion("compe_status >", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_status >=", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusLessThan(Integer value) {
            addCriterion("compe_status <", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("compe_status <=", value, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusIn(List<Integer> values) {
            addCriterion("compe_status in", values, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusNotIn(List<Integer> values) {
            addCriterion("compe_status not in", values, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusBetween(Integer value1, Integer value2) {
            addCriterion("compe_status between", value1, value2, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_status not between", value1, value2, "compeStatus");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreIsNull() {
            addCriterion("compe_host_score is null");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreIsNotNull() {
            addCriterion("compe_host_score is not null");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreEqualTo(Byte value) {
            addCriterion("compe_host_score =", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreNotEqualTo(Byte value) {
            addCriterion("compe_host_score <>", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreGreaterThan(Byte value) {
            addCriterion("compe_host_score >", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("compe_host_score >=", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreLessThan(Byte value) {
            addCriterion("compe_host_score <", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreLessThanOrEqualTo(Byte value) {
            addCriterion("compe_host_score <=", value, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreIn(List<Byte> values) {
            addCriterion("compe_host_score in", values, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreNotIn(List<Byte> values) {
            addCriterion("compe_host_score not in", values, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreBetween(Byte value1, Byte value2) {
            addCriterion("compe_host_score between", value1, value2, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeHostScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("compe_host_score not between", value1, value2, "compeHostScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreIsNull() {
            addCriterion("compe_guest_score is null");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreIsNotNull() {
            addCriterion("compe_guest_score is not null");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreEqualTo(Byte value) {
            addCriterion("compe_guest_score =", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreNotEqualTo(Byte value) {
            addCriterion("compe_guest_score <>", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreGreaterThan(Byte value) {
            addCriterion("compe_guest_score >", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("compe_guest_score >=", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreLessThan(Byte value) {
            addCriterion("compe_guest_score <", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreLessThanOrEqualTo(Byte value) {
            addCriterion("compe_guest_score <=", value, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreIn(List<Byte> values) {
            addCriterion("compe_guest_score in", values, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreNotIn(List<Byte> values) {
            addCriterion("compe_guest_score not in", values, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreBetween(Byte value1, Byte value2) {
            addCriterion("compe_guest_score between", value1, value2, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeGuestScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("compe_guest_score not between", value1, value2, "compeGuestScore");
            return (Criteria) this;
        }

        public Criteria andCompeTimeIsNull() {
            addCriterion("compe_time is null");
            return (Criteria) this;
        }

        public Criteria andCompeTimeIsNotNull() {
            addCriterion("compe_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompeTimeEqualTo(Integer value) {
            addCriterion("compe_time =", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeNotEqualTo(Integer value) {
            addCriterion("compe_time <>", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeGreaterThan(Integer value) {
            addCriterion("compe_time >", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_time >=", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeLessThan(Integer value) {
            addCriterion("compe_time <", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("compe_time <=", value, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeIn(List<Integer> values) {
            addCriterion("compe_time in", values, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeNotIn(List<Integer> values) {
            addCriterion("compe_time not in", values, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeBetween(Integer value1, Integer value2) {
            addCriterion("compe_time between", value1, value2, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_time not between", value1, value2, "compeTime");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlIsNull() {
            addCriterion("compe_video_url is null");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlIsNotNull() {
            addCriterion("compe_video_url is not null");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlEqualTo(String value) {
            addCriterion("compe_video_url =", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlNotEqualTo(String value) {
            addCriterion("compe_video_url <>", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlGreaterThan(String value) {
            addCriterion("compe_video_url >", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("compe_video_url >=", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlLessThan(String value) {
            addCriterion("compe_video_url <", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("compe_video_url <=", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlLike(String value) {
            addCriterion("compe_video_url like", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlNotLike(String value) {
            addCriterion("compe_video_url not like", value, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlIn(List<String> values) {
            addCriterion("compe_video_url in", values, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlNotIn(List<String> values) {
            addCriterion("compe_video_url not in", values, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlBetween(String value1, String value2) {
            addCriterion("compe_video_url between", value1, value2, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeVideoUrlNotBetween(String value1, String value2) {
            addCriterion("compe_video_url not between", value1, value2, "compeVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdIsNull() {
            addCriterion("compe_ht_id is null");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdIsNotNull() {
            addCriterion("compe_ht_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdEqualTo(Integer value) {
            addCriterion("compe_ht_id =", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdNotEqualTo(Integer value) {
            addCriterion("compe_ht_id <>", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdGreaterThan(Integer value) {
            addCriterion("compe_ht_id >", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_ht_id >=", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdLessThan(Integer value) {
            addCriterion("compe_ht_id <", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdLessThanOrEqualTo(Integer value) {
            addCriterion("compe_ht_id <=", value, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdIn(List<Integer> values) {
            addCriterion("compe_ht_id in", values, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdNotIn(List<Integer> values) {
            addCriterion("compe_ht_id not in", values, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdBetween(Integer value1, Integer value2) {
            addCriterion("compe_ht_id between", value1, value2, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeHtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_ht_id not between", value1, value2, "compeHtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdIsNull() {
            addCriterion("compe_gt_id is null");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdIsNotNull() {
            addCriterion("compe_gt_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdEqualTo(Integer value) {
            addCriterion("compe_gt_id =", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdNotEqualTo(Integer value) {
            addCriterion("compe_gt_id <>", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdGreaterThan(Integer value) {
            addCriterion("compe_gt_id >", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_gt_id >=", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdLessThan(Integer value) {
            addCriterion("compe_gt_id <", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdLessThanOrEqualTo(Integer value) {
            addCriterion("compe_gt_id <=", value, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdIn(List<Integer> values) {
            addCriterion("compe_gt_id in", values, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdNotIn(List<Integer> values) {
            addCriterion("compe_gt_id not in", values, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdBetween(Integer value1, Integer value2) {
            addCriterion("compe_gt_id between", value1, value2, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeGtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_gt_id not between", value1, value2, "compeGtId");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionIsNull() {
            addCriterion("compe_institution is null");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionIsNotNull() {
            addCriterion("compe_institution is not null");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionEqualTo(Byte value) {
            addCriterion("compe_institution =", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionNotEqualTo(Byte value) {
            addCriterion("compe_institution <>", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionGreaterThan(Byte value) {
            addCriterion("compe_institution >", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionGreaterThanOrEqualTo(Byte value) {
            addCriterion("compe_institution >=", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionLessThan(Byte value) {
            addCriterion("compe_institution <", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionLessThanOrEqualTo(Byte value) {
            addCriterion("compe_institution <=", value, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionIn(List<Byte> values) {
            addCriterion("compe_institution in", values, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionNotIn(List<Byte> values) {
            addCriterion("compe_institution not in", values, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionBetween(Byte value1, Byte value2) {
            addCriterion("compe_institution between", value1, value2, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeInstitutionNotBetween(Byte value1, Byte value2) {
            addCriterion("compe_institution not between", value1, value2, "compeInstitution");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdIsNull() {
            addCriterion("compe_wt_id is null");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdIsNotNull() {
            addCriterion("compe_wt_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdEqualTo(Integer value) {
            addCriterion("compe_wt_id =", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdNotEqualTo(Integer value) {
            addCriterion("compe_wt_id <>", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdGreaterThan(Integer value) {
            addCriterion("compe_wt_id >", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_wt_id >=", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdLessThan(Integer value) {
            addCriterion("compe_wt_id <", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdLessThanOrEqualTo(Integer value) {
            addCriterion("compe_wt_id <=", value, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdIn(List<Integer> values) {
            addCriterion("compe_wt_id in", values, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdNotIn(List<Integer> values) {
            addCriterion("compe_wt_id not in", values, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdBetween(Integer value1, Integer value2) {
            addCriterion("compe_wt_id between", value1, value2, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeWtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_wt_id not between", value1, value2, "compeWtId");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonIsNull() {
            addCriterion("compe_season is null");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonIsNotNull() {
            addCriterion("compe_season is not null");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonEqualTo(Integer value) {
            addCriterion("compe_season =", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonNotEqualTo(Integer value) {
            addCriterion("compe_season <>", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonGreaterThan(Integer value) {
            addCriterion("compe_season >", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("compe_season >=", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonLessThan(Integer value) {
            addCriterion("compe_season <", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonLessThanOrEqualTo(Integer value) {
            addCriterion("compe_season <=", value, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonIn(List<Integer> values) {
            addCriterion("compe_season in", values, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonNotIn(List<Integer> values) {
            addCriterion("compe_season not in", values, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonBetween(Integer value1, Integer value2) {
            addCriterion("compe_season between", value1, value2, "compeSeason");
            return (Criteria) this;
        }

        public Criteria andCompeSeasonNotBetween(Integer value1, Integer value2) {
            addCriterion("compe_season not between", value1, value2, "compeSeason");
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