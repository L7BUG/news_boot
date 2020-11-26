package com.l.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Aspect
@Component
public class MyAspect {
    @Qualifier("aopDateFormat")
    @Autowired
    private DateFormat dateFormat;

    @Pointcut("execution(* com.l.mapper.*Mapper.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(dateFormat.format(new Date()) + ":执行====>" + joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        System.out.println(dateFormat.format(new Date()) + ":结果====>" + proceed);
        return proceed;
    }
}
