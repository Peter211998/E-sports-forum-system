package com.sports.viewModel;

import java.io.Serializable;

public class CompetitionView implements Serializable {
    private String competitionId;
    private String competitonTime;
    private String competitionStatus;
    private String competitionHtId;
    private String competitionGtId;
    private String competitionHtScore;
    private String competitionGtScore;
    private String competitionInstitution;
    private String seasonName;

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public void setCompetitonTime(String competitonTime) {
        this.competitonTime = competitonTime;
    }

    public void setCompetitionStatus(String competitionStatus) {
        this.competitionStatus = competitionStatus;
    }

    public void setCompetitionHtId(String competitionHtId) {
        this.competitionHtId = competitionHtId;
    }

    public void setCompetitionGtId(String competitionGtId) {
        this.competitionGtId = competitionGtId;
    }

    public void setCompetitionHtScore(String competitionHtScore) {
        this.competitionHtScore = competitionHtScore;
    }

    public void setCompetitionGtScore(String competitionGtScore) {
        this.competitionGtScore = competitionGtScore;
    }

    public void setCompetitionInstitution(String competitionInstitution) {
        this.competitionInstitution = competitionInstitution;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public String getCompetitonTime() {
        return competitonTime;
    }

    public String getCompetitionStatus() {
        return competitionStatus;
    }

    public String getCompetitionHtId() {
        return competitionHtId;
    }

    public String getCompetitionGtId() {
        return competitionGtId;
    }

    public String getCompetitionHtScore() {
        return competitionHtScore;
    }

    public String getCompetitionGtScore() {
        return competitionGtScore;
    }

    public String getCompetitionInstitution() {
        return competitionInstitution;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    @Override
    public String toString() {
        return "CompetitionView{" +
                "competitionId='" + competitionId + '\'' +
                ", competitonTime='" + competitonTime + '\'' +
                ", competitionStatus='" + competitionStatus + '\'' +
                ", competitionHtId='" + competitionHtId + '\'' +
                ", competitionGtId='" + competitionGtId + '\'' +
                ", competitionHtScore='" + competitionHtScore + '\'' +
                ", competitionGtScore='" + competitionGtScore + '\'' +
                ", competitionInstitution='" + competitionInstitution + '\'' +
                '}';
    }
}
