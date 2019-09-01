package com.wjh.learn.common;

import java.io.Serializable;

/**
 * 返回值状态码
 * @author wjh
 * @date 2019/8/28 21:07
 */
public class ReturnCode implements Serializable{

    private static final long serialVersionUID = 20190828210713L;

    public static ReturnCode SUCCESS = new ReturnCode(200, "success");
    public static ReturnCode FORBIDDEN = new ReturnCode(403, "forbidden");
    public static ReturnCode NOT_FOUND = new ReturnCode(404, "not found");
    public static ReturnCode SERVER_ERROR = new ReturnCode(500, "Internal server error");

    private int code;
    private String msg;

    ReturnCode() {
    }

    ReturnCode(int code, String msg) {
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

    @Override
    public String toString() {
        return "ReturnCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
