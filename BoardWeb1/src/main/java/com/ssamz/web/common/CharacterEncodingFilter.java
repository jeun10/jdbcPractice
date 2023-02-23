package com.ssamz.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/insertBoard.do", "/insertUser.do", 
		"/updateBoard.do", "/getBoardList.do" }
,initParams=@WebInitParam(name="boardEncoding",value="utf-8"))

public class CharacterEncodingFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	public CharacterEncodingFilter() {
		System.out.println("===> CharacterEncodingFilter 생성");

	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("---> CharacterEncodingFilter init() 호출");
		encoding = config.getInitParameter("boardEncoding");

	}
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//ServletContext context = request.getServletContext();
		//System.out.println(encoding);
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}
	public void destroy() {
		System.out.println("---> CharacterEncodingFilter destroy() 호출)");
	}

}
