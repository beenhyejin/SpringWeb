package com.newlecture.aop.spring;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
//보조업무야~! db연동 가능하나 보조

public class AfterHandlerHandler implements AfterReturningAdvice{
	private Log log = LogFactory.getLog(this.getClass());
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(method.getName()+ "() 호출 후 반환 된 값 :" + returnValue);
	}

}
