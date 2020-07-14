package com.yyb.entity;

import java.util.Date;

public class ImgFavoriteRec {

    private int id;
    private int favId;
    private int picId;
    private Date favRecCreateDate;

    public ImgFavoriteRec() {
    }

    public ImgFavoriteRec(int id, int favId, int picId, Date favRecCreateDate) {
        this.id = id;
        this.favId = favId;
        this.picId = picId;
        this.favRecCreateDate = favRecCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavId() {
        return favId;
    }

    public void setFavId(int favId) {
        this.favId = favId;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public Date getFavRecCreateDate() {
        return favRecCreateDate;
    }

    public void setFavRecCreateDate(Date favRecCreateDate) {
        this.favRecCreateDate = favRecCreateDate;
    }
}
