package com.yyb.entity;

import java.util.List;
import java.util.Map;

//数据表格返回对象
public class RespMapBean {

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    private int code;
    private String msg;
    private Map<String,Object> data;

    public RespMapBean() {
    }

    public RespMapBean(int code, String msg, Map<String,Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Map<String,Object> getData() {
        return data;
    }

    public void setData(Map<String,Object> data) {
        this.data = data;
    }
}
