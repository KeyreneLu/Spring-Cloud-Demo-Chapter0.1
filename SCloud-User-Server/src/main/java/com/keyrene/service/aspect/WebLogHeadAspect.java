package com.keyrene.service.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class WebLogHeadAspect {

    private Logger logger = Logger.getLogger(getClass());

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    private static final String PRE_TAG = "SpringCloud---";

    @Pointcut(value = "execution(public * com.keyrene.service.controller..*.*(..))")
    public void webLog(){}

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        startTime.set(System.currentTimeMillis());

        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求的内容
        logger.info(PRE_TAG+"(doBefore)URL:"+request.getRequestURL().toString());
        logger.info(PRE_TAG+"(doBefore)HTTP_METHOD:"+ request.getMethod());
        logger.info(PRE_TAG+"(doBefore)IP:"+request.getRemoteAddr());
        logger.info(PRE_TAG+"(doBefore)CLASS_METHOD"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info(PRE_TAG+"(doBefore)ARGS"+ Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Exception{

        //处理完请求，记录返回结果
        logger.info(PRE_TAG+"(doAfterReturning)RESPONSE"+ret);
        logger.info(PRE_TAG+"(doAfterReturning)"+(System.currentTimeMillis()-startTime.get()));
    }
}

