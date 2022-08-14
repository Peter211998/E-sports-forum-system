package com.sports.enumPackage;

public enum GameEnum {
    LOL(1, "英雄联盟","这是英雄联盟论坛","www.photo.com"),
    DOTA2(2, "刀塔2","这是dota2论坛","www.photo.com"),
    CSGO(3, "CS:GO","这是CS:GO论坛","www.photo.com");
    GameEnum(int type, String name, String introduction, String photoUrl) {
        this.type = type;
        this.name = name;
        this.introduction = introduction;
        this.photoUrl = photoUrl;
    }

    private int type ;//比赛类型
    private String name;
    private String introduction;
    private String photoUrl;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
    public String toString() {
        return "Test{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
