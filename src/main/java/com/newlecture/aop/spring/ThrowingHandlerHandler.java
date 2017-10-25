package com.newlecture.aop.spring;

import org.springframework.aop.ThrowsAdvice;

public class ThrowingHandlerHandler implements ThrowsAdvice{
	
	public void afterThrowing(ArithmeticException e) throws Throwable{
		System.out.println("예외가 발생하였습니다 : " + e.getMessage());
	}

}
