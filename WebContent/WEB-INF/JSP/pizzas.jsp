<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE HTML>
<html lang='nl'>
<head>
<link rel='stylesheet' href='styles/default.css' />
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Pizza Luigi' />
</c:import>
</head>

<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />

	<h1>Pizza's</h1>
	<ul class='zebra'>
		<c:forEach var='pizza' items='${pizzas}'>
			<li>${pizza.id}:
				<c:out value='${pizza.naam}' /> ${pizza.prijs} &euro; ${pizza.pikant ? "[pikant]" : "[niet pikant]"} 
				<c:url value='/pizzas/detail.htm' var='detailURL'>
					<c:param name='id' value="${pizza.id}" />
				</c:url> <a href="<c:out value='${detailURL}'/>">Detail</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>