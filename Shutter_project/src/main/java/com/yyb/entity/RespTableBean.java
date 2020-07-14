package com.yyb.entity;

import java.util.List;

//数据表格返回对象
public class RespTableBean<E> {

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    private int code;
    private String msg;
    private long count;
    private List<E> data;

    public RespTableBean(int code, String msg, long count, List<E> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public RespTableBean() {

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

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
