package com.newlecture.aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogHandler implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("스프링 사전 보조업무");

		StopWatch watch = new StopWatch();
		
		watch.start();
		Object result = method.proceed();//주업무
		watch.stop();
		long du = watch.getTotalTimeMillis();
		
		System.out.print("handler -> ");
		System.out.println(method.getMethod().getName() + "()호출에 "+du+"밀리초가 걸렸습니다.");
		
		return result;
	}

}
