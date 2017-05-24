<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录页</h1>
	<form action="login_check.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function checkUserName() {
			var name = document.getElementsByName("username"); 
			if (name.length == 0) {
				alert("请输入用户名");
				name.focus();
			}
		}
	</script>
	<script type="text/javascript">
		checkUserName();
	</script>

</body>
</html>