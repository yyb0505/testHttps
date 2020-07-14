package com.yyb.entity;

import java.util.Date;

public class ImgSlideShow {
    private int id;
    private String sliName;
    private String sliDescribe;
    private String sliPath;
    private int sliStatus;
    private Date sliCreateTime;

    public ImgSlideShow() {
    }

    public ImgSlideShow(int id, String sliName, String sliDescribe, String sliPath,int sliStatus, Date sliCreateTime) {
        this.id = id;
        this.sliName = sliName;
        this.sliDescribe = sliDescribe;
        this.sliPath = sliPath;
        this.sliStatus = sliStatus;
        this.sliCreateTime = sliCreateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSliName() {
        return sliName;
    }

    public void setSliName(String sliName) {
        this.sliName = sliName;
    }

    public String getSliDescribe() {
        return sliDescribe;
    }

    public void setSliDescribe(String sliDescribe) {
        this.sliDescribe = sliDescribe;
    }

    public String getSliPath() {
        return sliPath;
    }

    public void setSliPath(String sliPath) {
        this.sliPath = sliPath;
    }

    public Date getSliCreateTime() {
        return sliCreateTime;
    }

    public int getSliStatus() {
        return sliStatus;
    }

    public void setSliStatus(int sliStatus) {
        this.sliStatus = sliStatus;
    }

    public void setSliCreateTime(Date sliCreateTime) {
        this.sliCreateTime = sliCreateTime;
    }
}
