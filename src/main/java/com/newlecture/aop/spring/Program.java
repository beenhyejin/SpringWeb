package com.newlecture.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String arg[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/aop/spring/aop-context.xml");
		Calculator cal = (Calculator) context.getBean("proxy");

		int data = cal.div(3, 0);
		System.out.println("--------------------------------------------------------------");
		cal.add(3, 0);
		//System.out.println("data = " +data);
	}
}
