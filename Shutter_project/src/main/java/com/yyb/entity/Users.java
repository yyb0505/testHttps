package com.yyb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.Date;

//@Slf4j //等同于log4j的日志对象,直接log.info("xxx");
//@Getter
//@Setter
//@Data
public class Users {

    private int userId;
    private String userName;
    private String userPwd;
    private int userSex;
    private String userPhone;
    private String userProfile;
    private int userLevel;
    private int userStatus;
    private Date userCreateTime;

    public Users() {
    }

    public Users(int userId, String userName, String userPwd, int userSex, String userPhone, String userProfile, int userLevel, int userStatus, Date userCreateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userProfile = userProfile;
        this.userLevel = userLevel;
        this.userStatus = userStatus;
        this.userCreateTime = userCreateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

}
