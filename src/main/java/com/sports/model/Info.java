package com.sports.model;

public class Info {
    private Integer infoId;

    private String infoTitle;

    private Integer infoDate;

    private Integer infoAuthorId;

    private Integer infoViewCnt;

    private Integer infoLikeCnt;

    private String infoApUrl;

    private Integer isEnable;

    private String infoText;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public Integer getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Integer infoDate) {
        this.infoDate = infoDate;
    }

    public Integer getInfoAuthorId() {
        return infoAuthorId;
    }

    public void setInfoAuthorId(Integer infoAuthorId) {
        this.infoAuthorId = infoAuthorId;
    }

    public Integer getInfoViewCnt() {
        return infoViewCnt;
    }

    public void setInfoViewCnt(Integer infoViewCnt) {
        this.infoViewCnt = infoViewCnt;
    }

    public Integer getInfoLikeCnt() {
        return infoLikeCnt;
    }

    public void setInfoLikeCnt(Integer infoLikeCnt) {
        this.infoLikeCnt = infoLikeCnt;
    }

    public String getInfoApUrl() {
        return infoApUrl;
    }

    public void setInfoApUrl(String infoApUrl) {
        this.infoApUrl = infoApUrl == null ? null : infoApUrl.trim();
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText == null ? null : infoText.trim();
    }
}