package com.sports.enumPackage;

public enum SeasonEnum {
    S1(1, "2022职业联赛春季赛季后赛,季军赛","这是英雄联盟",1);
    SeasonEnum(int seasonId, String seasonName, String introduction, int gameType){
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.introduction = introduction;
        this.gameType = gameType;
    }
    private int seasonId;
    private String seasonName;
    private String introduction;
    private int gameType;

    public int getSeasonId() {
        return seasonId;
    }

    public java.lang.String getIntroduction() {
        return introduction;
    }

    public int getGameType() {
        return gameType;
    }

    public String getSeasonName() {
        return seasonName;
    }
}
