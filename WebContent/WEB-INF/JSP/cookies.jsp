<%@ page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${not empty sessionScope.locale}">
	<fmt:setLocale value="${sessionScope.locale }"/>
</c:if>

<fmt:setBundle basename="resourceBundles.teksten" />

<!DOCTYPE HTML>
<html lang="nl">

<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Cookies" />
</c:import>
</head>

<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>
		<fmt:message key="cookieVoorbeeld" />
	</h1>
	<form method="post">
		<label><fmt:message key="naam" /> <input name="naam"
			value="${naam}" autofocus required
		/></label> <input type="submit" value="<fmt:message key="onthoudMe" />" />
	</form>
	<c:if test="${not empty naam}">
		<div>
			<h2>
				<fmt:message key="welkom" />
				, ${naam}
			</h2>
			<p>
				<fmt:message key="naamLetters">
					<fmt:param value="${naam.length()}" />
				</fmt:message>
			</p>
		</div>
	</c:if>

	<div>
		<c:url value='' var='nlBEURL'>
			<c:param name='locale' value='nl-BE' />
		</c:url>
		<c:url value='' var='enUSURL'>
			<c:param name='locale' value='en-US' />
		</c:url>
		<a href='${nlBEURL}'>Ik spreek Nederlands</a> 
		<a href='${enUSURL}'>I speak English</a>
	</div>
</body>

</html>