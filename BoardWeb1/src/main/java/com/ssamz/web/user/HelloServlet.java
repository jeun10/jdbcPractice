package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 사용자 입력 정보 추출
				String id = request.getParameter("id");
				
				//2. 응답화면 구성
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<title>Title</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<center>");
				out.println("<h1> <font color='blue'>" + id + " </font> 님 환영합니다.</h1>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
	}

}
