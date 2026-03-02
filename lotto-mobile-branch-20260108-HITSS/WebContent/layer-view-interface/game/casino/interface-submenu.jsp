<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<html lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<link rel="stylesheet"  href="layer-view-style/game/casino/categorias.css?v=2" type="text/css" media="all">
<link rel="stylesheet"  href="layer-view-style/game/casino/main-casino.css?v=3" type="text/css" media="all">
<%-- <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" /> --%>
 <style>
     body {
         overflow: auto;
         background-color: #fff;
     }
 </style>
 <script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
</head>
<body>
	<div id="tutorial" >
		<ul class="list-categories">
			<li id="m-todos" class="active">
				<a href="javascript:juegos('todos');" data-category="Todos">Todos</a>
			</li>
			<c:if test="${sesion eq 1 }">
			<li id="m-favoritos">
				<a href="javascript:juegos('favoritos');" data-category="Favoritos">Favoritos<img class="star-submenu" src="layer-view-image/game/casino/icon_star.gif"></a>
			</li>
			</c:if>
			<li id="m-slots">
				<a href="javascript:juegos('slots');" data-category="Slots">Slots</a>
			</li>
			<li id="m-jackpot">
				<a href="javascript:juegos('jackpot');" data-category="Jackpot">Jackpots</a>
			</li>
			<li id="m-virtual">
				<a href="javascript:juegos('virtual');" data-category="Virtual">Virtual Games</a>
			</li>
		</ul>
		<hr class="linea-submenu">
	</div>	
</body>
</html>