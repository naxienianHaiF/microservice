package com.wjh.learn.common;

/**
 * 返回值
 */
public class ResData {
    private int code = 200;
    private String msg;
    private Object data;

    public ResData(int code, String msg) {
        this(code, msg, null);
    }

    public ResData() {
    }

    public ResData(Object data) {
        this.data = data;
    }

    public ResData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResData SUCCESS(Object data) {
        ResData resData = new ResData(200, "success", data);
        return resData;
    }

    public static ResData SUCCESS() {
        return SUCCESS(null);
    }

    public static ResData SUCCESS(String msg) {
        return new ResData(200, msg, null);
    }

    public static ResData fail(int code, String msg) {
        ResData resData = new ResData(code, msg, null);
        return resData;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
