package com.newlecture.aop.spring;

import java.util.Calendar;

public class NewlecCalculator implements Calculator{

	@Override
	public int add(int x, int y) {
		System.out.println("�ֺ�����");
		
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
		int result = 0;			
		try {
			result = x/y;			
		} catch (Exception e) {
			System.out.println("0���� ������ ���ܰ� �߻��Ͽ����ϴ�.");
		}
		return result;
	}



}
