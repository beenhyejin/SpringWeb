package com.newlecture.aop;

import java.util.Calendar;

public class NewlecCalculator implements Calculator{

	@Override
	public int add(int x, int y) {
		System.out.println("주변업무");
		
		int result = x+y;
		return result;
	}

	@Override
	public int sub(int x, int y) {
		int result = x-y;
		return result;
	}

	@Override
	public int multi(int x, int y) {
		int result = x*y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result = x/y;
		return result;
	}



}
