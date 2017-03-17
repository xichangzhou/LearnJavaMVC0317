<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有的图片</title>
<style type="text/css">
s:select {
	width: 400px;
}

img {
	width: 200px;
}
</style>

<script type="text/javascript">
	window.onload = function() {
		var s = document.getElementById("select");
		s.onchange = function() {
			document.getElementById('show').src = 'upload/' + this.value;
		}
	}
</script>
</head>
<body>
	<s:select id="select" list="picts" listValue="picName"
		listKey="fileName" label="选择图片" size="5"/>
	<img id="show" src="">
	
	
</body>
</html>