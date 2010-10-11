<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Spring 3.0 MVC Series: Index - ViralPatel.net</title>
		<script type="text/javascript" src='<c:url value="/scripts/jquery/jquery-1.3.2.min.js" />'></script>
		<script>
			jQuery(document).ready(function() {
				jQuery('#testJson').click(function(){
					$.getJSON('app/demo/add', function(data) {
						alert(data);
					});
				});
			});
		</script>
	</head>
	<body>
		<a href="app/demo">Say Hello</a><br>
		<a id="testJson" href="#">testJson</a>
	</body>
</html>