<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE HTML>
<html lang='nl'>
<head>
	<link rel='stylesheet' href='styles/default.css'/>
	<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon'/>
	<meta name='viewport' content='width=device-width,initial-scale=1'>
	<title>Pizza's</title>
</head>

<body> 
	
	<h1>Pizza's</h1>
	<ul class='zebra'>
	<c:forEach var='entry' items='${pizzas}'>
		<li>${entry.key}: ${entry.value.naam} ${entry.value.prijs}&euro;</li>
	</c:forEach>
	</ul>
</body>
</html>