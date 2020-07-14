package com.yyb.entity;

import java.util.Date;

public class CommPicture {

    private int id;
    private String picNumber;
    private String picDescribe;
    private long picSize;
    private String picType;
    private String picPath;
    private int relId;
    private Date picCreateDate;

    public CommPicture() {
    }

    public CommPicture(int id, String picNumber, String picDescribe, long picSize, String picType, String picPath, int relId, Date picCreateDate) {
        this.id = id;
        this.picNumber = picNumber;
        this.picDescribe = picDescribe;
        this.picSize = picSize;
        this.picType = picType;
        this.picPath = picPath;
        this.relId = relId;
        this.picCreateDate = picCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getPicDescribe() {
        return picDescribe;
    }

    public void setPicDescribe(String picDescribe) {
        this.picDescribe = picDescribe;
    }

    public double getPicSize() {
        return picSize;
    }

    public void setPicSize(long picSize) {
        this.picSize = picSize;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getRelId() {
        return relId;
    }

    public void setRelId(int relId) {
        this.relId = relId;
    }

    public Date getPicCreateDate() {
        return picCreateDate;
    }

    public void setPicCreateDate(Date picCreateDate) {
        this.picCreateDate = picCreateDate;
    }
}
