package com.newlecture.aop.spring;

import java.lang.reflect.Method;


import org.springframework.aop.MethodBeforeAdvice;

public class BeforeHandlerHandler implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before");//�־����� ������ ���� ��
		
	}



}
