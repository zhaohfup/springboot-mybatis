package com.boot.intercepter;

import com.boot.utils.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理controller抛出异常
 * Created by bst on 2016/12/20.
 */
@ControllerAdvice
public class ControllerAdviceHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    /**
     * 处理controller方法异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ReturnData exp(HttpServletRequest request, Exception e) {
        logger.info("统一处理controller方法的异常:", e);
        request.setAttribute("e", e);

        return null;
    }

    /**
     * 处理传参校验失败异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ReturnData handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errorMessage = new HashMap<String, String>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return null;
    }
}
