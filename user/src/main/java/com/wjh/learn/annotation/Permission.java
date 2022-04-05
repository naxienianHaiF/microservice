package com.wjh.learn.annotation;

import java.lang.annotation.*;

/**
 * 权限控制
 * @author WJH
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    /**
     * 是否需要权限
     * @return true表示需要，false表示不需要
     */
    boolean need() default true;

    /**
     * 权限实现类
     * @return 实现类全限定名
     */
    String detailClass() default "";

    /**
     * 方法名
     * @return 权限实现类的实现方法
     */
    String detailName() default "permissionControl";

}
