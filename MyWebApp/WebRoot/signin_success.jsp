<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	
	<script type="text/javascript">
		function countDown(secs, surl) {
			var jumpTo = document.getElementById('jumpTo');
			jumpTo.innerHTML = secs;
			if (secs-- > 0) {
				setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
			} else {
				location.href = surl;
			}
		}
	</script>
	<h1>注册成功</h1>
	<a href="login.html"><span id="jumpTo">3</span>秒后系统会自动跳转，也可点击本处直接跳</a>
	<script type="text/javascript">
		countDown(3, 'login.html');
	</script>
</body>
</html>