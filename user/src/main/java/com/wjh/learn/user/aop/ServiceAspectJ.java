package com.wjh.learn.user.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wjh
 * @date 2019/9/1 15:49
 */
@Component
@Aspect
public class ServiceAspectJ {
    private static final Logger log = LoggerFactory.getLogger(ServiceAspectJ.class);

    @Pointcut("within(@org.springframework.stereotype.Service *) " +
            "|| within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {

    }

    @Pointcut("within(com.wjh.learn.user.service.*) " +
            "|| within(com.wjh.learn.user.mapper.*)")
    public void application() {}

    @Around("springBeanPointcut() && application()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);

        return result;
    }
}
