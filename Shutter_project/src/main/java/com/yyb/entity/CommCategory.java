package com.yyb.entity;

import java.util.Date;

public class CommCategory {

    private int id;
    private String cateName;
    private String cateDescribe;
    private Date cateCreateDate;

    public CommCategory() {
    }

    public CommCategory(int id, String cateName, String cateDescribe, Date cateCreateDate) {
        this.id = id;
        this.cateName = cateName;
        this.cateDescribe = cateDescribe;
        this.cateCreateDate = cateCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDescribe() {
        return cateDescribe;
    }

    public void setCateDescribe(String cateDescribe) {
        this.cateDescribe = cateDescribe;
    }

    public Date getCateCreateDate() {
        return cateCreateDate;
    }

    public void setCateCreateDate(Date cateCreateDate) {
        this.cateCreateDate = cateCreateDate;
    }
}
