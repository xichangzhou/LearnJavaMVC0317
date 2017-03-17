<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="loginPro" method="post">
		<!-- User对象的name和pass属性 -->
		用户名:<input type="text" name="user.name"><br>
		用户名:<input type="text" name="user.pass"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>