package com.newlecture.aop.spring;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
//����������~! db���� �����ϳ� ����

public class AfterHandlerHandler implements AfterReturningAdvice{
	private Log log = LogFactory.getLog(this.getClass());
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(method.getName()+ "() ȣ�� �� ��ȯ �� �� :" + returnValue);
	}

}
