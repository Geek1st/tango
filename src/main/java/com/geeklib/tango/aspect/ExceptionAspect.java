package com.geeklib.tango.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterThrowing(value = "execution(* com.geeklib.tango.*.*.*(..))",throwing="e")
	public void exceptionProcess(JoinPoint joinPoint, RuntimeException e)
	{
		System.out.println("enter afterThrowing");
		logger.error("",e);
	}
	
	@Before(value = "execution(** com.geeklib.tango.*.*.*(..))")  
    public void doAccessCheck(){  
        System.out.println("前置通知");  
    }  
}
