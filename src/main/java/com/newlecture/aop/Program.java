package com.newlecture.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
	public static void main(String arg[]) {
		Calculator origin = new NewlecCalculator();
		
		// Proxy�� �����ؼ� ���� �� ���� ������ ����
		Calculator cal = (Calculator) Proxy.newProxyInstance(
				NewlecCalculator.class.getClassLoader(), 
				new Class[] {Calculator.class}, 
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = method.invoke(origin, args);//2)�Լ�����
				System.out.println("����ó�� ��������");//3)���
				return result;
			}
		});

		//int data = cal.add(3, 4);
		int data = cal.add(3, 4);//1)�Լ�ȣ��
		
		System.out.println("data = " +data);
	}
}
