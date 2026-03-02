<%@page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.latinka.com.pe/asterisco" prefix="ast"%>
<%@taglib uri="http://www.latinka.com.pe/limit" prefix="limit"%>
<%-- fmt:setLocale value="es_ES" / --%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@page import="pe.com.intralot.loto.lib.ConnectionFactory"%>
<c:set var="flagPromoBicolor"><%=Integer.valueOf(ConnectionFactory.operationProperty("flagPromoBicolor", Constantes.contextCardWeb).trim()).intValue()%></c:set>