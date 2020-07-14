package com.yyb.entity;

import java.util.Date;

public class ImgFavorite {

    private int id;
    private String favName;
    private String favDescribe;
    private int userId;
    private Date favCreateDate;

    public ImgFavorite() {
    }

    public ImgFavorite(int id, String favName, String favDescribe, int userId, Date favCreateDate) {
        this.id = id;
        this.favName = favName;
        this.favDescribe = favDescribe;
        this.userId = userId;
        this.favCreateDate = favCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavName() {
        return favName;
    }

    public void setFavName(String favName) {
        this.favName = favName;
    }

    public String getFavDescribe() {
        return favDescribe;
    }

    public void setFavDescribe(String favDescribe) {
        this.favDescribe = favDescribe;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getFavCreateDate() {
        return favCreateDate;
    }

    public void setFavCreateDate(Date favCreateDate) {
        this.favCreateDate = favCreateDate;
    }
}
