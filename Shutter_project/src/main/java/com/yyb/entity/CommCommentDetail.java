package com.yyb.entity;

import java.util.Date;
import java.util.List;

public class CommCommentDetail {

    private int id;
    private int relId;
    private int userId;
    private String userName;
    private String comContent;
    private int comLike;
    private int comId;
    private int faUserId;
    private String faUserName;
    private String userProfile;
    private Date comCreateDate;
    private List<CommCommentDetail> ccData;

    public CommCommentDetail() {
    }

    public CommCommentDetail(int id, int relId, int userId, String userName, String comContent, int comLike, int comId, int faUserId, String faUserName, String userProfile, Date comCreateDate, List<CommCommentDetail> ccData) {
        this.id = id;
        this.relId = relId;
        this.userId = userId;
        this.userName = userName;
        this.comContent = comContent;
        this.comLike = comLike;
        this.comId = comId;
        this.faUserId = faUserId;
        this.faUserName = faUserName;
        this.userProfile = userProfile;
        this.comCreateDate = comCreateDate;
        this.ccData = ccData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelId() {
        return relId;
    }

    public void setRelId(int relId) {
        this.relId = relId;
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

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public int getComLike() {
        return comLike;
    }

    public void setComLike(int comLike) {
        this.comLike = comLike;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getFaUserId() {
        return faUserId;
    }

    public void setFaUserId(int faUserId) {
        this.faUserId = faUserId;
    }

    public String getFaUserName() {
        return faUserName;
    }

    public void setFaUserName(String faUserName) {
        this.faUserName = faUserName;
    }

    public Date getComCreateDate() {
        return comCreateDate;
    }

    public void setComCreateDate(Date comCreateDate) {
        this.comCreateDate = comCreateDate;
    }

    public List<CommCommentDetail> getCcData() {
        return ccData;
    }

    public void setCcData(List<CommCommentDetail> ccData) {
        this.ccData = ccData;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }
}
