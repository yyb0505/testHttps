package com.yyb.entity;

import java.util.Date;

public class ImgCategory {

    private int id;
    private String catName;
    private String catDescribe;
    private String catImgPath;
    private int catType;
    private Date catCreateDate;

    public ImgCategory() {
    }

    public ImgCategory(int id, String catName, String catDescribe, String catImgPath, int catType, Date catCreateDate) {
        this.id = id;
        this.catName = catName;
        this.catDescribe = catDescribe;
        this.catImgPath = catImgPath;
        this.catType = catType;
        this.catCreateDate = catCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescribe() {
        return catDescribe;
    }

    public void setCatDescribe(String catDescribe) {
        this.catDescribe = catDescribe;
    }

    public String getCatImgPath() { return catImgPath; }

    public void setCatImgPath(String catImgPath){this.catImgPath = catImgPath;}

    public int getCatType(){return catType;}

    public void setCatType(int catType){this.catType = catType;}

    public Date getCatCreateDate() {
        return catCreateDate;
    }

    public void setCatCreateDate(Date catCreateDate) {
        this.catCreateDate = catCreateDate;
    }
}
