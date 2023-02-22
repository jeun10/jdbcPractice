
package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVo;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 로그인 화면에서 사용자 입력 정보 주출
		// id : 자바변수 "id" : login.html의 name에서 가져온다
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB 연동 처리
		UserVo vo = new UserVo();
		vo.setId(id);
		UserDAO dao = new UserDAO();
		UserVo user = dao.getUser(vo);

		// 3. 응답 화면 구성
		// 응답 메시지에 대한 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		// HTTP 응답 프로토콜 message-body와 연결된 출력 스트림 획득
		PrintWriter out = response.getWriter();
		// 메시지 출력
		if (user != null) {
			if (user.getPassword().equals(password)) {

				// 상태 정보를 쿠키에 저장하여 전송한다. 하면서 name = value가 한쌍으로 지정
				//2
				HttpSession session=request.getSession();
				//session.setMaxInactiveInterval(10);

				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getName());
				session.setAttribute("userRole", user.getRole());

				ServletContext context = getServletContext();

				context.setAttribute("welcomeMessage", "님 환영합니다??");
				response.sendRedirect("getBoardList.do");
				
				// 글 목록 화면으로 포워딩한다.
				//RequestDispatcher dispatcher=request.getRequestDispatcher("getBoardList.do");
				//dispatcher.forward(request, response);

				
				//1
				//Cookie userId = new Cookie("userId", user.getId());
				//response.addCookie(userId);
				//response.sendRedirect("/getBoardList.do");
				
				//0
				// Cookie userId = new Cookie("userId", user.getId());
				// response.addCookie(userId);

				// RequestDispatcher dispatcher=request.getRequestDispatcher("getBoardList.do");
				// dispatcher.forward(request, response);
			
				//글 목록 화면에서 사용할 데이터를 HttpServletRequest에 등록한다.


			} else {
				out.println("비밀번호 오류입니다.<br>");
				out.println("<a href='/'>다시 로그인</a>");
			}

		} else {
			out.println("아이디 오류입니다.<br>");
			out.println("<a href='/'>다시 로그인</a>");

		}
	}

}