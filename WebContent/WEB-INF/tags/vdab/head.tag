<%@ tag description="head onderdeel van de pagina" pageEncoding="UTF8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ attribute name="title" required="true" type="java.lang.String" %>

<title>${title}</title>

<link rel='shortcut icon' href=<c:url value='/images/favicon.ico'/> type='image/x-icon'/>
<link rel='stylesheet' href=<c:url value='/styles/default.css'/> />

<meta name='viewport' content='width=device-width,initial-scale=1'>
