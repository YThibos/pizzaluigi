<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE HTML>
<html>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value="Pizza's" />
</c:import>
<head>
<title></title>
</head>

<body>
<c:import url='/WEB-INF/JSP/menu.jsp'/>
Je browser: ${browser}
<dl>
<c:forEach var='h' items='${headers}'>
<dt>${h.key}</dt><dd>${h.value}</dd>
</c:forEach>
</dl>
</body>

</html>