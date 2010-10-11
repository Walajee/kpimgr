<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setAttribute("select", "main");
%>
<html>
<head>
	<title>红河供电局评标对标系统</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/css/base.css" />" />
</head>
<body>
	<div id="outer">
		<div id="hdr" align="center">
			<%@ include file="../layout/header.jsp" %>
		</div>
		<div id="toolbar">
			<%@ include file="../layout/toolbar.jsp" %>
		</div>
		<div id="main">
			<%@ include file="console.jsp" %>
		</div>
	</div>
</body>
</html>