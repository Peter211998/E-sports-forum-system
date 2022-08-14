package com.sports.model;

import java.util.ArrayList;
import java.util.List;

public class InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoExample() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNull() {
            addCriterion("info_title is null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNotNull() {
            addCriterion("info_title is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleEqualTo(String value) {
            addCriterion("info_title =", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotEqualTo(String value) {
            addCriterion("info_title <>", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThan(String value) {
            addCriterion("info_title >", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("info_title >=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThan(String value) {
            addCriterion("info_title <", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThanOrEqualTo(String value) {
            addCriterion("info_title <=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLike(String value) {
            addCriterion("info_title like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotLike(String value) {
            addCriterion("info_title not like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIn(List<String> values) {
            addCriterion("info_title in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotIn(List<String> values) {
            addCriterion("info_title not in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleBetween(String value1, String value2) {
            addCriterion("info_title between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotBetween(String value1, String value2) {
            addCriterion("info_title not between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoDateIsNull() {
            addCriterion("info_date is null");
            return (Criteria) this;
        }

        public Criteria andInfoDateIsNotNull() {
            addCriterion("info_date is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDateEqualTo(Integer value) {
            addCriterion("info_date =", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotEqualTo(Integer value) {
            addCriterion("info_date <>", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateGreaterThan(Integer value) {
            addCriterion("info_date >", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_date >=", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateLessThan(Integer value) {
            addCriterion("info_date <", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateLessThanOrEqualTo(Integer value) {
            addCriterion("info_date <=", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateIn(List<Integer> values) {
            addCriterion("info_date in", values, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotIn(List<Integer> values) {
            addCriterion("info_date not in", values, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateBetween(Integer value1, Integer value2) {
            addCriterion("info_date between", value1, value2, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotBetween(Integer value1, Integer value2) {
            addCriterion("info_date not between", value1, value2, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdIsNull() {
            addCriterion("info_author_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdIsNotNull() {
            addCriterion("info_author_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdEqualTo(Integer value) {
            addCriterion("info_author_id =", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdNotEqualTo(Integer value) {
            addCriterion("info_author_id <>", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdGreaterThan(Integer value) {
            addCriterion("info_author_id >", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_author_id >=", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdLessThan(Integer value) {
            addCriterion("info_author_id <", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("info_author_id <=", value, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdIn(List<Integer> values) {
            addCriterion("info_author_id in", values, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdNotIn(List<Integer> values) {
            addCriterion("info_author_id not in", values, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("info_author_id between", value1, value2, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("info_author_id not between", value1, value2, "infoAuthorId");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntIsNull() {
            addCriterion("info_view_cnt is null");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntIsNotNull() {
            addCriterion("info_view_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntEqualTo(Integer value) {
            addCriterion("info_view_cnt =", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntNotEqualTo(Integer value) {
            addCriterion("info_view_cnt <>", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntGreaterThan(Integer value) {
            addCriterion("info_view_cnt >", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_view_cnt >=", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntLessThan(Integer value) {
            addCriterion("info_view_cnt <", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntLessThanOrEqualTo(Integer value) {
            addCriterion("info_view_cnt <=", value, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntIn(List<Integer> values) {
            addCriterion("info_view_cnt in", values, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntNotIn(List<Integer> values) {
            addCriterion("info_view_cnt not in", values, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntBetween(Integer value1, Integer value2) {
            addCriterion("info_view_cnt between", value1, value2, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoViewCntNotBetween(Integer value1, Integer value2) {
            addCriterion("info_view_cnt not between", value1, value2, "infoViewCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntIsNull() {
            addCriterion("info_like_cnt is null");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntIsNotNull() {
            addCriterion("info_like_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntEqualTo(Integer value) {
            addCriterion("info_like_cnt =", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntNotEqualTo(Integer value) {
            addCriterion("info_like_cnt <>", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntGreaterThan(Integer value) {
            addCriterion("info_like_cnt >", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_like_cnt >=", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntLessThan(Integer value) {
            addCriterion("info_like_cnt <", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntLessThanOrEqualTo(Integer value) {
            addCriterion("info_like_cnt <=", value, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntIn(List<Integer> values) {
            addCriterion("info_like_cnt in", values, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntNotIn(List<Integer> values) {
            addCriterion("info_like_cnt not in", values, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntBetween(Integer value1, Integer value2) {
            addCriterion("info_like_cnt between", value1, value2, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoLikeCntNotBetween(Integer value1, Integer value2) {
            addCriterion("info_like_cnt not between", value1, value2, "infoLikeCnt");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlIsNull() {
            addCriterion("info_ap_url is null");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlIsNotNull() {
            addCriterion("info_ap_url is not null");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlEqualTo(String value) {
            addCriterion("info_ap_url =", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlNotEqualTo(String value) {
            addCriterion("info_ap_url <>", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlGreaterThan(String value) {
            addCriterion("info_ap_url >", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlGreaterThanOrEqualTo(String value) {
            addCriterion("info_ap_url >=", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlLessThan(String value) {
            addCriterion("info_ap_url <", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlLessThanOrEqualTo(String value) {
            addCriterion("info_ap_url <=", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlLike(String value) {
            addCriterion("info_ap_url like", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlNotLike(String value) {
            addCriterion("info_ap_url not like", value, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlIn(List<String> values) {
            addCriterion("info_ap_url in", values, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlNotIn(List<String> values) {
            addCriterion("info_ap_url not in", values, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlBetween(String value1, String value2) {
            addCriterion("info_ap_url between", value1, value2, "infoApUrl");
            return (Criteria) this;
        }

        public Criteria andInfoApUrlNotBetween(String value1, String value2) {
            addCriterion("info_ap_url not between", value1, value2, "infoApUrl");
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