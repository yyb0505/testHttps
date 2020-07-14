package com.yyb.entity;

import java.util.Date;

public class CommFans {

    private int id;
    private int userId;
    private int fanId;
    private Date fanCreateDate;

    public CommFans() {
    }

    public CommFans(int id, int userId, int fanId, Date fanCreateDate) {
        this.id = id;
        this.userId = userId;
        this.fanId = fanId;
        this.fanCreateDate = fanCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFanId() {
        return fanId;
    }

    public void setFanId(int fanId) {
        this.fanId = fanId;
    }

    public Date getFanCreateDate() {
        return fanCreateDate;
    }

    public void setFanCreateDate(Date fanCreateDate) {
        this.fanCreateDate = fanCreateDate;
    }
}
