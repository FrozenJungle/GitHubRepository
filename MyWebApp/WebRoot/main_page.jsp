<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>

	<h1>
		hi!<%=session.getAttribute("username")%></h1>	
	<%
		if (session.getAttribute("username") == null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
	%>

	<p>
		sessionid:
		<%=session.getId()%></p>
	<a href="AddBook"><input type="button" value="增加图书"></a>
	<a href="delbook.jsp"><input type="button" value="删除图书"></a>
	<a href="altbook.jsp"><input type="button" value="修改图书"></a>
	<a href="fndbook.jsp"><input type="button" value="查询图书"></a>
</body>

</html>