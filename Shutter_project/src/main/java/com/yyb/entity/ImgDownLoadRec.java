package com.yyb.entity;

import java.util.Date;

public class ImgDownLoadRec {

    private int id;
    private int userId;
    private int picId;
    private Date dowCreateDate;

    public ImgDownLoadRec() {
    }

    public ImgDownLoadRec(int id, int userId, int picId, Date dowCreateDate) {
        this.id = id;
        this.userId = userId;
        this.picId = picId;
        this.dowCreateDate = dowCreateDate;
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

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public Date getDowCreateDate() {
        return dowCreateDate;
    }

    public void setDowCreateDate(Date dowCreateDate) {
        this.dowCreateDate = dowCreateDate;
    }
}
