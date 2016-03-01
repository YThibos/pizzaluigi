<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri='http://vdab.be/tags' prefix='vdab'%>

<!DOCTYPE HTML>
<html>
<vdab:head title="Headers"/>
<head>
<title></title>
</head>

<body>
<vdab:menu></vdab:menu>
Je browser: ${browser}
<dl>
<c:forEach var='h' items='${headers}'>
<dt>${h.key}</dt><dd>${h.value}</dd>
</c:forEach>
</dl>
</body>

</html>