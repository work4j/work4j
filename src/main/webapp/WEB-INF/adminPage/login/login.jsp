<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台登录</title>
<%@ include file="../common/head_admin.jsp"%> 
</head>
<body>
	<div>欢迎来到程序员联盟，来，登录。</div>
	<br />
	<div>
		<form action="<%=basePath%>admin/login" method="post">
			<input type="text" name="username" placeholder="用户名" /> <input type="text" name="password" placeholder="密码" /> <input type="submit" value="提交" />
		</form>
	</div>
</body>
</html>