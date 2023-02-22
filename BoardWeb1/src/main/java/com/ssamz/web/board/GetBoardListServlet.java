package com.ssamz.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;

/*
 * 7.2.1 글 목록 구현
 */
@WebServlet("/getBoardList.do")
public class GetBoardListServlet extends HttpServlet {
	private static final long seralVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 0. 상태 정보 체크( page 229 )
		/*
		 * Cookie[] cookieList = request.getCookies(); if (cookieList == null) {
		 * response.sendRedirect("/login.html"); } else { String userId = null; for
		 * (Cookie cookie : cookieList) { if (cookie.getName().equals("userId")) {
		 * userId = cookie.getValue(); } } // end for if (userId == null) {
		 * response.sendRedirect("/login.html"); } }
		 */

		// 0. 상태 정보 체크
		/*
		 * HttpSession session = request.getSession();
		 * 
		 * String sessionId = session.getId(); if(session.isNew()) {
		 * System.out.println("===> 처음 생성된 세션: " + sessionId); } else {
		 * System.out.println("---> 재사용중인 세션: " + sessionId); }
		 */

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			response.sendRedirect("/");
		}

		// 0-1.사용자 입력정보 추출 : 검색키워드에 한글이 입력 될 수 있으므로 인코딩을 한다.

		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("boardEncoding");
		request.setCharacterEncoding(encoding);
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		// Null Check : 글 목록 화면을 직접요청시 검색값을 전달하지 않으므로 기본값을 설정한다.
		if (searchCondition == null)
			searchCondition = "TITLE";
		if (searchKeyword == null)
			searchKeyword = "";

		session.setAttribute("condition", searchCondition);
		session.setAttribute("keyword", searchKeyword);

		// 1. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 2. 응답 화면 구성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시글 목록</h1>");
		String userName = (String)session.getAttribute("userName");
		String welcomeMessage = (String)context.getAttribute("welcomeMessage");
		out.println("<h3>" + userName + welcomeMessage);
		// out.println("<h3>" + userName + " 님 로그인 환영합니다.......");
		out.println("<a href='logout.do'>Log-out</a></h3>");

		out.println("<!--검색 시작 -->");
		out.println("<form action='getBoardList.do' method='post'>");
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.println("<tr>");
		out.println("<td align='right'>");
		out.println("<select name='searchCondition'>");
		String condition = (String) session.getAttribute("condition");
		if (condition.equals("TITLE")) {
			out.println("<option value='TITLE' selected>제목");
		} else {
			out.println("<option value='TITLE'>제목");
		}
		if (condition.equals("CONTENT")) {
			out.println("<option value='CONTENT' selected>내용");
		} else {
			out.println("<option value='CONTENT'>내용");
		}
		// out.println("<option value='TITLE'>제목");
		// out.println("<option value='CONTENT'>내용");
		// out.println("<input name='searchKeyword' type='text' />");

		out.println("</select>");
		out.println("<input name='searchKeyword' type='text' value='" + session.getAttribute("keyword") + "'/>");

		out.println("<input type='submit' value='검색'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<!--검색 종료 -->");

		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>번호</th>");
		out.println("<th bgcolor='orange' width='200'>제목</th>");
		out.println("<th bgcolor='orange' width='150'>작성자</th>");
		out.println("<th bgcolor='orange' width='150'>등록일</th>");
		out.println("<th bgcolor='orange' width='100'>조회수</th>");
		out.println("</tr>");

		for (BoardVO board : boardList) {
			out.println("<tr>");
			out.println("<td>" + board.getSeq() + "</td>");
			out.println("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle()
					+ "</a></td>");
			out.println("<td>" + board.getWriter() + "</td>");
			out.println("<td>" + board.getRegDate() + "</td>");
			out.println("<td>" + board.getCnt() + "</td>");
		}

		out.println("</table>");
		out.println("<br>");
		out.println("<a href='insertBoard.html'>새글 등록</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}