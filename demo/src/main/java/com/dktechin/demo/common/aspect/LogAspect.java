package com.dktechin.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    @After("execution(* com.dktechin.demo.sample..*(..))")
    public void logAfter() {
        logger.info("==== AOP After ====");
    }
 
    @Before("execution(* com.dktechin.demo.sample..*(..))")
    public void logBefore() {
        logger.info("==== AOP Before ========");
    }

    @Around("execution(* com.dktechin.demo.sample..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint)  throws Throwable {
        logger.info("==== AOP Around =======");
        return joinPoint.proceed();
    }


}
