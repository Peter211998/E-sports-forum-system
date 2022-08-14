package com.sports.enumPackage;

public enum authorEnum {
    LOLG(1,"这是英雄联盟游戏用于发布咨询的官方账号","英雄联盟赛事官方"),
    DOTA2G(2,"这是DOTA2用于发布咨询的官方账号","DOTA2赛事官方"),
    CSGOG(3,"这是CSGO用于发布咨询的官方账号","CS:GO赛事官方");
    authorEnum(int authorId, String introduction,String authorName){
        this.authorId = authorId;
        this.introduction = introduction;
        this.authorName = authorName;
    }
    private int authorId;
    private String authorName;
    private String introduction;

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getIntroduction() {
        return introduction;
    }
}
