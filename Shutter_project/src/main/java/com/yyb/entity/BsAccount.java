package com.yyb.entity;

import java.util.Date;

public class BsAccount {

    private int id;
    private String accName;
    private String accPassword;
    private String accAuthority;
    private Date accCreateDate;

    public BsAccount() {
    }

    public BsAccount(int id, String accName, String accPassword, String accAuthority, Date accCreateDate) {
        this.id = id;
        this.accName = accName;
        this.accPassword = accPassword;
        this.accAuthority = accAuthority;
        this.accCreateDate = accCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    public String getAccAuthority() {
        return accAuthority;
    }

    public void setAccAuthority(String accAuthority) {
        this.accAuthority = accAuthority;
    }

    public Date getAccCreateDate() {
        return accCreateDate;
    }

    public void setAccCreateDate(Date accCreateDate) {
        this.accCreateDate = accCreateDate;
    }
}
