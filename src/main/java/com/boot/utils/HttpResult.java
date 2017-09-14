package com.boot.utils;

import com.alibaba.fastjson.JSONObject;

public class HttpResult {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回数据
     */
    private String result;

    public HttpResult() {
    }

    public HttpResult(Integer code, String result) {
        this.code = code;
        this.result = result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        JSONObject json = JSONObject.parseObject(result);
        if(json.containsKey("result")){
            JSONObject result = json.getJSONObject("result");
            return result.toJSONString();
        }
        return result;
    }
    public String getResultCode() {
        JSONObject json = JSONObject.parseObject(result);
        if(json.containsKey("result")){
            JSONObject status = json.getJSONObject("status");
            return status.getString("code");
        }
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("{\"code\":\"%s\",\"result\":%s}", code,
                result);
    }
}
