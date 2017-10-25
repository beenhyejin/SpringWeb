package com.newlecture.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("헬러 필터~"); // 서블릿 또는 필터가 실행되기 전에 실행
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		//System.out.println("잘가~ 필터"); //후에 실행
		
	}

}
