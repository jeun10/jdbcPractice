<%@ page language="java" contentType="text/html; charset=utf-8" 
errorPage="errors/boardError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-f">
<title>TITLE</title>
</head>
<body>
	<center>

		<!-- http://localhost:8080/index2.jsp?id=Gurum -->
		<h1>
			<font color='purple'><%=request.getParameter("id").toString()%></font>님
			환영합니다.
		</h1>
		<!-- http://localhost:8080/index.jsp?id=Gurum -->
	</center>
</body>
</html>