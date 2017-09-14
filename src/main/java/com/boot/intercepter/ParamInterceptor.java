package com.boot.intercepter;

import com.boot.constant.StatusCodeEnum;
import com.boot.utils.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by bst on 2016/12/19.
 * 在controller前对请求和参数做处理
 */
@Configuration
public class ParamInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ParamInterceptor.class);

    /**
     * 验证权限
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI() == null ? "" : request.getRequestURI();
        logger.info("请求的ip={},接口={}", request.getRemoteHost(), uri);
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ExceptionResponse(response, StatusCodeEnum.E1);
            return false;
        }
        String token = authHeader.substring(7);
        if ("".equals(token)) {
            ExceptionResponse(response, StatusCodeEnum.E2);
            return false;
        }
        return true;
    }

    /**
     * 拦截器直接返回
     *
     * @param response
     * @param ex
     */
    public void ExceptionResponse(HttpServletResponse response, StatusCodeEnum ex) {
        ReturnData returnObject = new ReturnData(ex);
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(returnObject.toString());
            writer.flush();
        } catch (IOException e) {

        }
    }
}
