<%@ page language="java" contentType="text/html; charset=utf-8" 
errorPage="errors/boardError.jsp" 
session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-f">
<title>TITLE</title>
</head>
<body>
<center>
<!-- HTML 주석입니다.-->
<%-- JSP 주석입니다. --%>
<h1><font color=green> <%= request.getParameter("id").toString() %></font>님 환영합니다.</h1>
세션 아이디 : <%=session.getId() %>
</center>

</body>
</html>