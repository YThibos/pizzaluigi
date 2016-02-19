<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE HTML>
<html>

<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Pizzas tussen prijzen' />
</c:import>
</head>

<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	<section class="content">
	<h1>Kies je minimum en maximumprijs</h1>
	<form> <!--method='get' action='<c:url value='/pizzas/tussenprijzen.htm'/>'-->
		<label>Van prijs
			<span>${fouten.van}</span>
			<input name='van' type="number" min="0" value="${param.van }" autofocus required>
		</label> 
		<label>Tot prijs
			<span>${fouten.tot}</span>
			<input name='tot' type="number" min="0" value="${param.tot }" required>
		</label>
		<input type='submit' value='Zoeken'>
		<c:if test='${!empty pizzas }'>
			<ul class='zebra'>
			<c:forEach var='pizza' items='${pizzas }'>
				<li><c:out value='${pizza.naam }'/> ${pizza.prijs }&euro;</li>
			</c:forEach>
			</ul>
		</c:if>
		<c:if test='${not empty param and empty fouten and empty pizzas}'>
			<div class='fout'>Geen pizza’s gevonden</div>
		</c:if>
	</form>
	</section>

</body>

</html>