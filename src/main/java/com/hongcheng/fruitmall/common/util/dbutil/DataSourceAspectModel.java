package com.hongcheng.fruitmall.common.util.dbutil;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DataSourceAspectModel implements AfterReturningAdvice,MethodBeforeAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        JdbcContextHolder.clearJdbcType();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        DataSource d = method.getAnnotation(DataSource.class);
        if(d != null) {
            JdbcContextHolder.setJdbcType(d.value());
        }
    }
}
