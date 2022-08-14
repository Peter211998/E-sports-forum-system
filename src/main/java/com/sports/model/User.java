package com.sports.model;

public class User {
    private Integer userId;

    private String userName;

    private String userAccountName;

    private String userPassword;

    private String userPhotoUrl;

    private String userEmail;

    private Long userRegisterTime;

    private Integer isEnable;

    private String salt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName == null ? null : userAccountName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl == null ? null : userPhotoUrl.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Long getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Long userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccountName='" + userAccountName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhotoUrl='" + userPhotoUrl + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegisterTime=" + userRegisterTime +
                ", isEnable=" + isEnable +
                ", salt='" + salt + '\'' +
                '}';
    }
}