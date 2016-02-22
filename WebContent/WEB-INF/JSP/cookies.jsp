<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE HTML>
<html lang='nl'>

<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Cookies' />
</c:import>
</head>

<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	<h1>Cookies</h1>
	<form method='post'>
		<label>Naam<input name='naam' value='${naam}' autofocus /></label> 
		<input type='submit' value='Onthoud me'>
	</form>
	<c:if test='${not empty naam}'>
		<h2>Welkom, ${naam}</h2>
	</c:if>
</body>

</html>