<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件</title>
</head>
<body>
<s:actionmessage/>
<a href="${pageContext.request.contextPath}/down?res=WEB-INF/down/abc.jpg&resType=image/jpeg&resName=aaaa.jpg">下载图片</a>
</body>
</html>