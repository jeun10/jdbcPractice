package com.ssamz.web.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVo;

@WebServlet(urlPatterns="/InsertUser.do")
//initParams=@WebInitParam(name="boardEncoding", value="UTF-8"))
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	
	//@Override
	//public void init(ServletConfig config) throws ServletException {
		//encoding = config.getInitParameter("boardEncoding");
		//System.out.println("---> Encoding: " + encoding);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext context = getServletContext();
		//encoding=context.getInitParameter("boardEncoding");
		//System.out.println("---> Encoding: " + encoding);
		//1.
		//request.setCharacterEncoding(encoding);
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String selfInfo = request.getParameter("selfInfo");
		String[] languages = request.getParameterValues ("languages");
		String age = request.getParameter("age");
		/*
		 * System.out.println("아이디 : " + id); System.out.println("비밀번호 : " + password);
		 * System.out.println("이름 : " + name); System.out.println("권한 : " + role);
		 * System.out.println("자기소개 : " + selfInfo); System.out.print("언어 경험 : ");
		 * for(String language:languages){ System.out.print(language+", "); }
		 * System.out.println(); System.out.println("나이 : " + age);
		 */
		
		UserVo vo = new UserVo();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		UserDAO dao = new UserDAO();
		dao.InsertUser(vo);
		// 3. 화면 이동
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login.html");
				dispatcher.forward(request, response);


	}

}
