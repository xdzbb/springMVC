package com.mvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.orm.jpa.JpaAccessor;
import org.springframework.stereotype.Component;

/*
 * 切面程序
 */
@Component
@Aspect
public class MyAdvise {
	@Before("execution(* com.mvc.dao.*.*(..))")
	public void log(JoinPoint jp){
		System.out.println("开始记录日志...");
	}
	@Around(value="execution(* com.mvc.dao.*.*(..))")  
    public Object around(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("包围方法前");  
        Object result = pjp.proceed();  
        System.out.println("包围方法后");  
        return result;  
    } 
	/** 
     * 调用后通知 
     */  
    @After(value="execution(* com.mvc.dao.*.*(..))")  
    public void after(JoinPoint jp) {  
        System.out.println("记录日志结束...");   
    }  
}
