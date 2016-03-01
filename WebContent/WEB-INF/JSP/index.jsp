<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>

<!DOCTYPE HTML>
<html lang='nl'>

<head>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<link rel='stylesheet' href='styles/default.css' />
<meta name='viewport' content='width=device-width, initial-scale=1' />
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Pizza Luigi' />
</c:import>
</head>

<body>
	<section>
		<c:import url='/WEB-INF/JSP/menu.jsp' />


		<section class="content" id="begroeting">
			<h1>Pizza Luigi</h1>
			<img src=<c:url value='/images/pizza.jpg'/> alt='pizza'
				class='fullwidth'>
			<h2>${begroeting}</h2>
		</section>
	</section>

	<section class="content" id="zaakvoerder">
		<h2>De zaakvoerder</h2>
		<dl>
			<dt>Naam</dt>
			<dd>${zaakvoerder.naam}</dd>
			<dt>Aantal kinderen</dt>
			<dd>${zaakvoerder.aantalKinderen}</dd>
			<dt>Gehuwd</dt>
			<dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee' }</dd>
			<dt>Adres</dt>
			<dd>${zaakvoerder.adres}</dd>
			<dt>Aantal pizza's verkocht</dt>
			<dd><fmt:formatNumber value="${aantalPizzasVerkocht}"/></dd>
		</dl>
	</section>

	<footer>
		<div class="datum">
			<p>Vandaag: <fmt:formatDate value="${nu }" type="date" dateStyle="full"/></p>
		</div>
		<div class="mailto" id='owner'>
			<a href='mailto:${emailOwner}'>Eigenaar: ${emailOwner}</a>
		</div>
		<div class="mailto" id="webmaster">
			<a href="mailto:${emailWebmaster}">Webmaster: ${initParam.emailWebmaster}</a>
		</div>
		<div id="aantalViews">Deze pagina werd ${aantalViews} keer bekeken.</div>
	</footer>
</body>
</html>