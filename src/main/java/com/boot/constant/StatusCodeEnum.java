package com.boot.constant;


/**
 * Created by bst on 2016/12/21.
 */
public enum StatusCodeEnum {
    E0(1, "ok"),
    E1(101, "缺少tokenId"),
    E2(102, "tokenId不正确");


    private int code;

    private String desp;

    StatusCodeEnum(int code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }


}
