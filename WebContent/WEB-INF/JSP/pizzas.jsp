<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri='http://vdab.be/tags' prefix='vdab'%>

<!DOCTYPE HTML>
<html lang='nl'>
<head>
	<vdab:head title="Pizza's"/>
</head>

<body>
	<vdab:menu></vdab:menu>

<section class="content">
	<h1>Pizza's</h1>
	<ul class='zebra'>
		<c:forEach var='pizza' items='${pizzas}'>
			<li>${pizza.id}:
				<c:out value='${pizza.naam}' /> ${pizza.prijs} &euro; ${pizza.pikant ? "[pikant]" : "[niet pikant]"} 
				<c:url value='/pizzas/detail.htm' var='detailURL'>
					<c:param name='id' value="${pizza.id}" />
				</c:url> <a href="<c:out value='${detailURL}'/>">Detail</a>
				<c:if test='${pizzaIdsMetFoto.contains(pizza.id) }'>
					<c:url value='/pizzafotos/${pizza.id}.jpg' var='fotoURL'/>
					<a href='${fotoURL}'>Foto</a>
				</c:if>
			</li>
		</c:forEach>
	</ul>
</section>
</body>
</html>