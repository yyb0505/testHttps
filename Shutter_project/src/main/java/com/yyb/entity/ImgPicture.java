package com.yyb.entity;

import java.util.Date;

public class ImgPicture {

    private int id;
    private String picNumber;
    private String picDescribe;
    private long picSize;
    private String picType;
    private String picPath;
    private int groId;
    private Date picCreateDate;

    public ImgPicture() {
    }

    public ImgPicture(int id, String picNumber, String picDescribe, long picSize, String picType, String picPath, int groId, Date picCreateDate) {
        this.id = id;
        this.picNumber = picNumber;
        this.picDescribe = picDescribe;
        this.picSize = picSize;
        this.picType = picType;
        this.picPath = picPath;
        this.groId = groId;
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

    public int getGroId() {
        return groId;
    }

    public void setGroId(int groId) {
        this.groId = groId;
    }

    public Date getPicCreateDate() {
        return picCreateDate;
    }

    public void setPicCreateDate(Date picCreateDate) {
        this.picCreateDate = picCreateDate;
    }
}
