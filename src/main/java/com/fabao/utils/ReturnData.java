package com.fabao.utils;

import com.fabao.constant.StatusCodeEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 封装统一返回结果
 * <p>
 * Created by bst on 2016/12/21.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReturnData {
    private StatusCodeEnum code;
    private Object data;

    public ReturnData() {
        this.code = StatusCodeEnum.E0;
    }

    public ReturnData(StatusCodeEnum code) {
        this.code = code;
    }

    public StatusCodeEnum getCode() {
        return code;
    }

    public void setCode(StatusCodeEnum code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        Map<Object, Object> res = new HashMap<Object, Object>();
        res.put("code", code.getCode());
        res.put("message", code.getDesp());
        res.put("data", data);
        return toJSONString(res);// json序列化对象可根据注解的格式
    }

    public Map toMap() {
        Map<Object, Object> res = new HashMap<Object, Object>();
        res.put("code", code.getCode());
        res.put("message", code.getDesp());
        res.put("data", data);
        return res;
    }
}
