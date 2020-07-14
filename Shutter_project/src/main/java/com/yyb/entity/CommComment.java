package com.yyb.entity;

import java.util.Date;
import java.util.List;

public class CommComment {

    private int id;
    private int relId;
    private int userId;
    private String comContent;
    private int comLike;
    private int comId;
    private Date comCreateDate;
    private List<CommComment> ccData;

    public CommComment() {
    }

    public CommComment(int id, int relId, int userId, String comContent, int comLike, int comId, Date comCreateDate, List<CommComment> ccData) {
        this.id = id;
        this.relId = relId;
        this.userId = userId;
        this.comContent = comContent;
        this.comLike = comLike;
        this.comId = comId;
        this.comCreateDate = comCreateDate;
        this.ccData = ccData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelId() {
        return relId;
    }

    public void setRelId(int relId) {
        this.relId = relId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public int getComLike() {
        return comLike;
    }

    public void setComLike(int comLike) {
        this.comLike = comLike;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public Date getComCreateDate() {
        return comCreateDate;
    }

    public void setComCreateDate(Date comCreateDate) {
        this.comCreateDate = comCreateDate;
    }

    public List<CommComment> getCcData() {
        return ccData;
    }

    public void setCcData(List<CommComment> ccData) {
        this.ccData = ccData;
    }
}
