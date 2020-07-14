package com.yyb.entity;

import java.util.List;

//增加，删除，修改的响应数据对象
public class RespBean {

    public static final int SUCCESS = 200;
    public static final int ERROR = 400;

    private int code;
    private String msg;

    public RespBean() {
    }

    public RespBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
