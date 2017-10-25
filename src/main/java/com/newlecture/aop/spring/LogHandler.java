package com.newlecture.aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogHandler implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("������ ���� ��������");

		StopWatch watch = new StopWatch();
		
		watch.start();
		Object result = method.proceed();//�־���
		watch.stop();
		long du = watch.getTotalTimeMillis();
		
		System.out.print("handler -> ");
		System.out.println(method.getMethod().getName() + "()ȣ�⿡ "+du+"�и��ʰ� �ɷȽ��ϴ�.");
		
		return result;
	}

}
