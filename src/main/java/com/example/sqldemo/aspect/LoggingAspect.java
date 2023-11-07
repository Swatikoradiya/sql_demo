package com.example.sqldemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class LoggingAspect {

    @Before(value = "execution(* com.example.sqldemo..*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("join point : {}", joinPoint.getArgs());
        log.info("join point : {}", joinPoint.getTarget());
        log.info("join point : {}", joinPoint.getThis());
        log.info("Requested to " + joinPoint.getSignature());
    }

    @After(value = "execution(* com.example.sqldemo..*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("join point response : {}", joinPoint.getArgs());
        log.info("join point response : {}", joinPoint.getTarget());
        log.info("join point response : {}", joinPoint.getThis());

        log.info("Returned response from " + joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(* com.example.sqldemo..*.*(..))", returning = "o")
    public void afterReturningMethod(JoinPoint joinPoint, Object o) {
        log.info("After returning response : {}, signature : {}", o, joinPoint.getSignature());
    }

    @Around(value = "execution(* com.example.sqldemo..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        log.info("Before execution of method : {}", joinPoint.getSignature());

        Object o;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        log.info("After execution of method : {}, data : {}", joinPoint.getSignature(), o);
        return o;
    }
}
