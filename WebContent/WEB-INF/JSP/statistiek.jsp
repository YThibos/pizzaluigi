<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri='http://vdab.be/tags' prefix='vdab'%>

<!doctype html>
<html lang='nl'>

<head>
<vdab:head title="Statistieken"/>
</head>

<body>
	<vdab:menu></vdab:menu>
	
<section class="content">
	<h1>Statistiek</h1>
	<dl>
		<dt>Welkom</dt>
		<dd>${indexRequests}</dd>
		<dt>Pizzas</dt>
		<dd>${pizzasRequests}</dd>
		<dt>Statistieken</dt>
		<dd>${statistiekRequests }</dd>
		<dt>Aantal Mandjes</dt>
		<dd>${aantalMandjes} mandje(s)</dd>
	</dl>
</section>
</body>

</html>