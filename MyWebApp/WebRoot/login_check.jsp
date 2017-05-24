<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	public static final String url = "jdbc:mysql://127.0.0.1:3306/web?&useSSL=false";
	public static final String user = "root";
	public static final String password = "Zzh970430";
		
	%>
	<%
	Connection conn = null;
	Statement sta = null;
	boolean flag = false;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		sta = conn.createStatement();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select password from userinfo where (username='"+username+"');";
		ResultSet rs = sta.executeQuery(sql);
		if(rs.next()){
			String pswd = rs.getString("password");
			if(pswd.equals(password))
				flag = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			sta.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(flag){
		request.getRequestDispatcher("/login_success.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("/login_failure.jsp").forward(request, response);
	}
	

	%>
</body>
</html>