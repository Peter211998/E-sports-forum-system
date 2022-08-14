package com.sports.viewModel;

import java.io.Serializable;

public class InfoListView implements Serializable {
    private int infoId;
    private String infoTitle;
    private String infoDate;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(String infoDate) {
        this.infoDate = infoDate;
    }

    @Override
    public String toString() {
        return "infoListView{" +
                "infoId=" + infoId +
                ", infoTitle='" + infoTitle + '\'' +
                ", infoDate=" + infoDate +
                '}';
    }
}
