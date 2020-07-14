package com.yyb.entity;

import java.util.Date;

public class CommRelease {

    private int id;
    private String relTitle;
    private String relDescribe;
    private int relPageView;
    private int userId;
    private int catId;
    private Date relCreateDate;

    public CommRelease() {
    }

    public CommRelease(int id, String relTitle, String relDescribe, int relPageView, int userId, int catId, Date relCreateDate) {
        this.id = id;
        this.relTitle = relTitle;
        this.relDescribe = relDescribe;
        this.relPageView = relPageView;
        this.userId = userId;
        this.catId = catId;
        this.relCreateDate = relCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelTitle() {
        return relTitle;
    }

    public void setRelTitle(String relTitle) {
        this.relTitle = relTitle;
    }

    public String getRelDescribe() {
        return relDescribe;
    }

    public void setRelDescribe(String relDescribe) {
        this.relDescribe = relDescribe;
    }

    public int getRelPageView() {
        return relPageView;
    }

    public void setRelPageView(int relPageView) {
        this.relPageView = relPageView;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public Date getRelCreateDate() {
        return relCreateDate;
    }

    public void setRelCreateDate(Date relCreateDate) {
        this.relCreateDate = relCreateDate;
    }
}
