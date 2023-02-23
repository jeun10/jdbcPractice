package com.ssamz.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(urlPatterns="*.do")
//@WebFilter(urlPatterns="/getBoardList.do")
public class TimeCheckFilter extends HttpFilter implements Filter {

	public TimeCheckFilter() {
		System.out.println("===> TimeCheckFilter 생성");

	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--->TimeCheckFilter init() 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String uri=req.getRequestURI();
		long startTime=System.currentTimeMillis();
		String path = uri.substring(uri.lastIndexOf("/"));

		chain.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		System.out.println(path + "요청 처리에 소요된 시간 : " +
		(endTime-startTime) + "(ms)초");

	}

	public void destroy() {
		System.out.println("--->TimeCheckFilter destroy() 호출)");
	}

}
