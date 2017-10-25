package com.newlecture.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
	public static void main(String arg[]) {
		Calculator origin = new NewlecCalculator();
		
		// Proxy를 생성해서 실제 주 업무 로직을 위임
		Calculator cal = (Calculator) Proxy.newProxyInstance(
				NewlecCalculator.class.getClassLoader(), 
				new Class[] {Calculator.class}, 
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = method.invoke(origin, args);//2)함수연산
				System.out.println("사전처리 보조업무");//3)출력
				return result;
			}
		});

		//int data = cal.add(3, 4);
		int data = cal.add(3, 4);//1)함수호출
		
		System.out.println("data = " +data);
	}
}
