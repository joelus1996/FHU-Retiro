<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta charset="utf-8">
<title>Programa Te Apuesto | Lotería Virtual - Zona Segura</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/teapuesto/themeTeApuesto.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

     
DrawData<br/> 
<c:forEach var="entry" items="${DrawData}"> 
	<c:set var="key" value="${entry.key}" /> 
	<c:out value="${key.date}"/><br/> 
	<c:forEach var="val" items="${entry.value}">
	     - <c:out value="${val.teams}"/> L <c:out value="${val.local}"/> E <c:out value="${val.equal}"/> V <c:out value="${val.visitor}"/><br/>
	</c:forEach> 
</c:forEach>
 
<br/>
ExactData<br/> 
<c:forEach var="entry" items="${ExactData}"> 
	<c:set var="key" value="${entry.key}" />  
	<c:out value="${key.teamsMenu}"/><br/> 
	<c:set var="val" value="${entry.value}" />  
	0:0 <c:out value="${val.s00}"/> 2:0 <c:out value="${val.s20}"/> 2:1 <c:out value="${val.s21}"/><br/>
</c:forEach>

<br/> 
SpecialData<br/> 
<c:forEach var="data1" items="${SpecialData}"> 
	<c:set var="header1" value="${data1.key}" /> 
	<c:out value="${header1.name}"/><br/> 
	<c:forEach var="val2" items="${data1.value}">
	     <c:set var="menu2" value="${val2.key}" /> 
	     <c:out value="${menu2.menu}"/> <br/> 
	     <c:forEach var="val3" items="${val2.value}">
	     	<c:set var="group3" value="${val3.key}" /> 
	     	<c:out value="${group3.groupTitle}"/> * <c:out value="${group3.subHeader}"/> <br/> 	     	
		    <c:forEach var="item4" items="${val3.value}"> 
		     	<c:out value="${item4.itemCode}"/>  <c:out value="${item4.itemDescription}"/>   <c:out value="${item4.odds}"/> <br/> 
		    </c:forEach> 
	     </c:forEach> 
	</c:forEach> 
</c:forEach>





    <script type="text/javascript">
        Modernizr.load({
            test: Modernizr.rgba && Modernizr.cssgradients && Modernizr.opacity && Modernizr.borderradius,
            nope: ['layer-view-style/game/teapuesto/old-browser.css', 'layer-view-script/common/jquery.roundOff.js', 'layer-view-script/game/teapuesto/old-browser.js']
        });
    </script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type='text/javascript' src='layer-view-script/game/teapuesto/lotto-te-apuesto.js'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>

    <%@ include file="../../include/message.jspf"%>
</body>
</html>