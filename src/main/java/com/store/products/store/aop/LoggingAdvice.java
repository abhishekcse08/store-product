package com.store.products.store.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);


    @Pointcut("execution(* com.store.products.store.*.*.*(..)) ")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className  = pjp.getClass().getName();
        Object[] array = pjp.getArgs();
        log.info("method invoke " +" : class Name :"+ className+" Method Name :" +methodName +"Arguments :" +mapper.writeValueAsString(array));

        Object object = pjp.proceed();

        log.info(" class Name :"+ className+" Method Name :" +methodName +"Response :" +mapper.writeValueAsString(object));


        return object;

    }
}
