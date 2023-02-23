<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<!-- html주석 -->
	<%-- jsp주석 --%>
		<h1>
			<font color='blue'> <%=request.getParameter("id")%></font>님
			환영합니다.
		</h1>
	</center>
</body>
</html>