package com.yyb.entity;

import java.util.Date;

public class ImgGroup {

    private int id;
    private String groName;
    private String groDescribe;
    private String groImgPath;
    private int catId;
    private Date groCreateDate;

    public ImgGroup() {
    }

    public ImgGroup(int id, String groName, String groDescribe,String groImgPath, int catId, Date groCreateDate) {
        this.id = id;
        this.groName = groName;
        this.groDescribe = groDescribe;
        this.groImgPath = groImgPath;
        this.catId = catId;
        this.groCreateDate = groCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroName() {
        return groName;
    }

    public void setGroName(String groName) {
        this.groName = groName;
    }

    public String getGroDescribe() {
        return groDescribe;
    }

    public String getGroImgPath() {
        return groImgPath;
    }

    public void setGroImgPath(String groImgPath) {
        this.groImgPath = groImgPath;
    }

    public void setGroDescribe(String groDescribe) {
        this.groDescribe = groDescribe;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public Date getGroCreateDate() {
        return groCreateDate;
    }

    public void setGroCreateDate(Date groCreateDate) {
        this.groCreateDate = groCreateDate;
    }
}
