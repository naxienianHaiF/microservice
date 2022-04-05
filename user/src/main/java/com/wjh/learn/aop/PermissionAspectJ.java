package com.wjh.learn.aop;

import com.wjh.learn.annotation.Permission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class PermissionAspectJ {
    private static final Logger log = LoggerFactory.getLogger(PermissionAspectJ.class);

    @Pointcut("execution(* com.wjh.learn.*..* (..))")
    public void applactionBean() {

    }

    @Pointcut("@annotation(com.wjh.learn.annotation.Permission)")
    public void annotationPermission() {

    }


    @Around("applactionBean() && annotationPermission() && @annotation(permission)")
    public Object around(ProceedingJoinPoint joinPoint, Permission permission) throws Throwable {
        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        boolean need = permission.need();
        log.info("is need permission? {}", need);
        log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);

        return result;
    }
}
