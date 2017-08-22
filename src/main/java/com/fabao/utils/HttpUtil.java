package com.fabao.utils;


import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bst on 2016/11/16.
 */
@Component
@ConfigurationProperties
public class HttpUtil {
    private static final Logger logger = Logger.getLogger(HttpUtil.class);

    @Value("${url}")
    String url;
    @Autowired
    private HttpClient httpClient;

    /**
     * 发送http请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public HttpResult postForFabao(String url, Map<String, String> params, HttpPost httpPost) throws Exception {

        if (httpPost == null) {
            httpPost = new HttpPost(url);
        }
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        if (params != null) {
            List<NameValuePair> paramters = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                paramters.add(new BasicNameValuePair(key, params.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramters, "UTF-8");
            httpPost.setEntity(formEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = (CloseableHttpResponse) httpClient.execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }


}


