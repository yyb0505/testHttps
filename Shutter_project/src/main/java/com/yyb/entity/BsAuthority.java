package com.yyb.entity;

import java.util.Date;

public class BsAuthority {

    private int id;
    private int autNumber;
    private String autName;
    private Date autCreateDate;

    public BsAuthority() {
    }

    public BsAuthority(int id, int autNumber, String autName, Date autCreateDate) {
        this.id = id;
        this.autNumber = autNumber;
        this.autName = autName;
        this.autCreateDate = autCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutNumber() {
        return autNumber;
    }

    public void setAutNumber(int autNumber) {
        this.autNumber = autNumber;
    }

    public String getAutName() {
        return autName;
    }

    public void setAutName(String autName) {
        this.autName = autName;
    }

    public Date getAutCreateDate() {
        return autCreateDate;
    }

    public void setAutCreateDate(Date autCreateDate) {
        this.autCreateDate = autCreateDate;
    }
}
