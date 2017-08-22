package com.fabao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by bst on 2017/1/5.
 */
@Aspect
@Component
public class Aop {
    public Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("execution(* com.fabao.controller..*(..))")
    public void webLog() {
    }

//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容
////        logger.info("IP : " + request.getRemoteAddr());
////        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }

    @AfterReturning(pointcut = "webLog()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        logger.info("请求返回值-------" + returnValue);
    }


}

