package com.sports.model;

import io.swagger.models.auth.In;

public class Competition {
    private Integer compeId;

    private String compeTitle;

    private Integer compeType;

    private Integer compeStatus;

    private Integer compeHostScore;

    private Integer compeGuestScore;

    private Integer compeTime;

    private String compeVideoUrl;

    private Integer compeHtId;

    private Integer compeGtId;

    private Integer compeInstitution;

    private Integer compeWtId;

    private Integer compeSeason;

    private Integer isEnable;

    public Integer getCompeId() {
        return compeId;
    }

    public void setCompeId(Integer compeId) {
        this.compeId = compeId;
    }

    public String getCompeTitle() {
        return compeTitle;
    }

    public void setCompeTitle(String compeTitle) {
        this.compeTitle = compeTitle == null ? null : compeTitle.trim();
    }

    public Integer getCompeType() {
        return compeType;
    }

    public void setCompeType(Integer compeType) {
        this.compeType = compeType;
    }

    public Integer getCompeStatus() {
        return compeStatus;
    }

    public void setCompeStatus(Integer compeStatus) {
        this.compeStatus = compeStatus;
    }

    public Integer getCompeHostScore() {
        return compeHostScore;
    }

    public void setCompeHostScore(Integer compeHostScore) {
        this.compeHostScore = compeHostScore;
    }

    public Integer getCompeGuestScore() {
        return compeGuestScore;
    }

    public void setCompeGuestScore(Integer compeGuestScore) {
        this.compeGuestScore = compeGuestScore;
    }

    public Integer getCompeTime() {
        return compeTime;
    }

    public void setCompeTime(Integer compeTime) {
        this.compeTime = compeTime;
    }

    public String getCompeVideoUrl() {
        return compeVideoUrl;
    }

    public void setCompeVideoUrl(String compeVideoUrl) {
        this.compeVideoUrl = compeVideoUrl == null ? null : compeVideoUrl.trim();
    }

    public Integer getCompeHtId() {
        return compeHtId;
    }

    public void setCompeHtId(Integer compeHtId) {
        this.compeHtId = compeHtId;
    }

    public Integer getCompeGtId() {
        return compeGtId;
    }

    public void setCompeGtId(Integer compeGtId) {
        this.compeGtId = compeGtId;
    }

    public Integer getCompeInstitution() {
        return compeInstitution;
    }

    public void setCompeInstitution(Integer compeInstitution) {
        this.compeInstitution = compeInstitution;
    }

    public Integer getCompeWtId() {
        return compeWtId;
    }

    public void setCompeWtId(Integer compeWtId) {
        this.compeWtId = compeWtId;
    }

    public Integer getCompeSeason() {
        return compeSeason;
    }

    public void setCompeSeason(Integer compeSeason) {
        this.compeSeason = compeSeason;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}