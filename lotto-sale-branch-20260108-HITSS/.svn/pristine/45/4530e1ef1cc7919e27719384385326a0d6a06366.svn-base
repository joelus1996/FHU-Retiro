<%@ include file="../../include/taglibs.jspf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/normalize.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/game/kabala/themeCotejador.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/game/kabala/themeKabala.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/jquery.alerts.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/carousel.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/menu.css" />
<link media="screen" rel="stylesheet" type="text/css"
 href="layer-view-style/game/super3/theme.css" />
<link media="screen" rel="stylesheet" type="text/css"
 href="layer-view-style/game/super3/themeSuper3.css" />
<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
	
	
<script type="text/javascript">
		var valorCombo="";
        function valChange(obj)
        {
		var valor1 = $("#mySelectBox").val();
		var valor2 = ($("#mySelectBox-2").val())-1;
		var valorCombo= obj.parentNode.getElementsByTagName('div')[0].innerHTML=obj.options[obj.selectedIndex].text;
		var resultadoFecha=parseInt(valor2)+parseInt(valor1);
		$("#fechaCotejo").html(resultadoFecha);
        return true;
        }
	
</script>
	
</head>

<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<input type="hidden" value="${super3SaleBean.numbersMore}" id="more_repeated">
<input type="hidden" value="${super3SaleBean.numbersLess}" id="less_repeated">
<input type="hidden" value="${super3SaleBean.status}" id="status">
<input type="hidden" value="${super3SaleBean.simpleBetPrice}" id="simpleBetPrice_repeated">
<input type="hidden" value="${super3SaleBean.promotionType}" id="promo">
<input type="hidden" value="${super3SaleBean.priceType}" id="price_type">
<input type="hidden" value="${super3SaleBean.algorithm}" id="algorithm">
<input type="hidden" value="${super3SaleBean.bets}" id="bets">
<input type="hidden" value="${super3SaleBean.pay}" id="pay">
<input type="hidden" value="${super3SaleBean.cost}" id="cost">
<input type="hidden" value="${super3SaleBean.draws}" id="draw">


	<div class="cotenedor_kabala_cotejador">
		<div class="logo_kabala_cotejador" id="kabala-cotejo-logo">
			<img src="layer-view-image/game/super3/premios-logo-super3.jpg"
				title="Kabala" alt="Kabala"> <img
				src="layer-view-image/game/kabala/tit-cotejador.gif" title="Kabala"
				alt="Kabala">
		</div>
<form name="start_play" id="start_play">
<div class="linear">

<div id="part1">
<div class="left">
<div class="text-play">JUGADA A</div>


<div class="number-textarea-button">
<div class="paso"></div>
<div class="step_one"><span class="text-number"> Marca una casilla</span><span class="text-number"> o más, c/u S/. 1.00</span>
<input type="checkbox" name="J1_Ocheck"
	id="J1_Ocheck_1" value="O" class="J1_Ocheck_1" /><label id="LJ1_Ocheck_1"
	for="J1_Ocheck_1" class="check_" style="
    margin-top: 5px;
    width: 80px;
"><b>3 en orden</b></label>

<input type="checkbox" name="J1_Ccheck"
	id="J1_Ccheck_1" value="C" class="J1_Ccheck_1" /><label id="LJ1_Ccheck_1"
	for="J1_Ccheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>3 en desorden</b></label>

<input type="checkbox" name="J1_Dcheck"
	id="J1_Dcheck_1" value="D" class="J1_Dcheck_1" /><label id="LJ1_Dcheck_1"
	for="J1_Dcheck_1" class="check_" style="margin-top: 3px;
    width: 80px;
"><b>2 en orden</b></label>

<input type="checkbox" name="J1_Ucheck"
	id="J1_Ucheck_1" value="U" class="J1_Ucheck_1" /><label id="LJ1_Ucheck_1"
	for="J1_Ucheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>1 en orden</b></label>


<div class="group-number">
<div class="order">
Multiplica tu
premio por:
(opcional)
</div>
<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_2" value="2" class="J1_Mcheck_2" /><label id="LJ1_Mcheck_2"
	for="J1_Mcheck_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J1_Mcheck" id="J1_Mcheck_3" value="3" class="J1_Mcheck_3" /><label
	for="J1_Mcheck_3" id="LJ1_Mcheck_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J1_Mcheck" id="J1_Mcheck_4" value="4"
	class="J1_Mcheck_4" /><label for="J1_Mcheck_4" id="LJ1_Mcheck_4"
	class="check_"><b>4</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_5" value="5" class="J1_Mcheck_5" /><label for="J1_Mcheck_5"
	id="LJ1_Mcheck_5" class="check_"><b>5</b></label> <input type="checkbox"
	name="J1_Mcheck" id="J1_Mcheck_6" value="6" class="J1_Mcheck_6" /><label
	for="J1_Mcheck_6" id="LJ1_Mcheck_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J1Mcheck" id="J1_Mcheck_10" value="10"
	class="J1_Mcheck_10" /><label for="J1_Mcheck_10" id="LJ1_Mcheck_10"
	class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_20" value="20" class="J1_Mcheck_20" /><label
	for="J1_Mcheck_20" id="LJ1_Mcheck_20" class="check_"><b>20</b></label> <input
	type="checkbox" name="J1_Mcheck" id="J1_Mcheck_30" value="30"
	class="J1_Mcheck_30" /><label for="J1_Mcheck_30" id="LJ1_Mcheck_30"
	class="check_"><b>30</b></label> <input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_40" value="40" class="J1_Mcheck_40" /><label
	for="J1_Mcheck_40" id="LJ1_Mcheck_40" class="check_"><b>40</b></label> </div>

<div style="margin-left: -45px;"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_50" value="50" class="J1_Mcheck_50" /><label
	for="J1_Mcheck_50" id="LJ1_Mcheck_50" class="check_"><b>50</b></label></div>

</div>
</div>




<div style="margin-left: 100px;">
	<div class="text-number">Marca una casilla o más en cada columna</div>
<div class="linear">
<div class="container">
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_0" value="0" class="J1_1check_0" /><label id="LJ1_1check_0"
	for="J1_1check_0" class="check_"><b>0</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_0" value="0" class="J1_2check_0" /><label
	for="J1_2check_0" id="LJ1_2check_0" class="check_"><b>0</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_0" value="0"
	class="J1_3check_0" /><label for="J1_3check_0" id="LJ1_3check_0"
	class="check_"><b>0</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_1" value="1" class="J1_1check_1" /><label id="LJ1_1check_1"
	for="J1_1check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_1" value="1" class="J1_2check_1" /><label
	for="J1_2check_1" id="LJ1_2check_1" class="check_"><b>1</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_1" value="1"
	class="J1_3check_1" /><label for="J1_3check_1" id="LJ1_3check_1"
	class="check_"><b>1</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_2" value="2" class="J1_1check_2" /><label for="J1_1check_2"
	id="LJ1_1check_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_2" value="2" class="J1_2check_2" /><label
	for="J1_2check_2" id="LJ1_2check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_2" value="2"
	class="J1_3check_2" /><label for="J1_3check_2" id="LJ1_3check_2"
	class="check_"><b>2</b></label></div>


<div class="margin"><input type="checkbox" name="J1check"
	id="J1_1check_3" value="" class="J1_1check_3" /><label
	for="J1_1check_3" id="LJ1_1check_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_3" value="3"
	class="J1_2check_3" /><label for="J1_2check_3" id="LJ1_2check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_3" value="3" class="J1_3check_3" /><label
	for="J1_3check_3" id="LJ1_3check_3" class="check_"><b>3</b></label> </div>
    
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_4" value="4" class="J1_1check_4" /><label
	for="J1_1check_4" id="LJ1_1check_4" class="check_"><b>4</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_4" value="4"
	class="J1_2check_4" /><label for="J1_2check_4" id="LJ1_2check_4"
	class="check_"><b>4</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_4" value="4" class="J1_3check_4" /><label
	for="J1_3check_4" id="LJ1_3check_4" class="check_"><b>4</b></label> </div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_5" value="5" class="J1_1check_5" /><label
	for="J1_1check_5" id="LJ1_1check_5" class="check_"><b>5</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_5" value="5"
	class="J1_2check_5" /><label for="J1_2check_5" id="LJ1_2check_5"
	class="check_"><b>5</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_5" value="5" class="J1_3check_5" /><label
	for="J1_3check_5" id="LJ1_3check_5" class="check_"><b>5</b></label></div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_6" value="6" class="J1_1check_6" /><label
	for="J1_1check_6" id="LJ1_1check_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_6" value="6"
	class="J1_2check_6" /><label for="J1_2check_6" id="LJ1_2check_6"
	class="check_"><b>6</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_6" value="6" class="J1_3check_6" /><label
	for="J1_3check_6" id="LJ1_3check_6" class="check_"><b>6</b></label> </div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_7" value="7" class="J1_1check_7" /><label
	for="J1_1check_7" id="LJ1_1check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_7" value="7"
	class="J1_2check_7" /><label for="J1_2check_7" id="LJ1_2check_7"
	class="check_"><b>7</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_7" value="7" class="J1_3check_7" /><label
	for="J1_3check_7" id="LJ1_3check_7" class="check_"><b>7</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_8" value="8" class="J1_1check_8" /><label
	for="J1_1check_8" id="LJ1_1check_8" class="check_"><b>8</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_8" value="8"
	class="J1_2check_8" /><label for="J1_2check_8" id="LJ1_2check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_8" value="8" class="J1_3check_8" /><label
	for="J1_3check_8" id="LJ1_3check_8" class="check_"><b>8</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_9" value="9" class="J1_1check_9" /><label
	for="J1_1check_9" id="LJ1_1check_9" class="check_"><b>9</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_9" value="9"
	class="J1_2check_9" /><label for="J1_2check_9" id="LJ1_2check_9"
	class="check_"><b>9</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_9" value="9" class="J1_3check_9" /><label
	for="J1_3check_9" id="LJ1_3check_9" class="check_"><b>9</b></label></div>
    
</div>
</div>

<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" 
	 id="J1-text-area" readonly="readonly"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J1azar"><img
	src="layer-view-image/game/super3/flecha-s3.gif" height="5"
	width="5" class="icon" /><span class="text">Agregar al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="clear" id="J1clear"><img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="more" id="J1more">
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span>
</div>
</div>


<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J1less" class="less" >
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>

</div>





</div>

</div>


<div class="right">

<div class="text-play">JUGADA B</div>



<div class="number-textarea-button">
<div class="paso"></div>
<div class="step_one"><span class="text-number"> Marca una casilla</span><span class="text-number"> o más, c/u S/. 1.00</span>
<input type="checkbox" name="J2_Ocheck"
	id="J2_Ocheck_1" value="O" class="J2_Ocheck_1" /><label id="LJ2_Ocheck_1"
	for="J2_Ocheck_1" class="check_" style="
    margin-top: 5px;
    width: 80px;
"><b>3 en orden</b></label>

<input type="checkbox" name="J2_Ccheck"
	id="J2_Ccheck_1" value="C" class="J2_Ccheck_1" /><label id="LJ2_Ccheck_1"
	for="J2_Ccheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>3 en desorden</b></label>

<input type="checkbox" name="J2_Dcheck"
	id="J2_Dcheck_1" value="D" class="J2_Dcheck_1" /><label id="LJ2_Dcheck_1"
	for="J2_Dcheck_1" class="check_" style="margin-top: 3px;
    width: 80px;
"><b>2 en orden</b></label>

<input type="checkbox" name="J2_Ucheck"
	id="J2_Ucheck_1" value="U" class="J2_Ucheck_1" /><label id="LJ2_Ucheck_1"
	for="J2_Ucheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>1 en orden</b></label>


<div class="group-number">
<div class="order">
Multiplica tu
premio por:
(opcional)
</div>
<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_2" value="2" class="J2_Mcheck_2" /><label id="LJ2_Mcheck_2"
	for="J2_Mcheck_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J2_Mcheck" id="J2_Mcheck_3" value="3" class="J2_Mcheck_3" /><label
	for="J2_Mcheck_3" id="LJ2_Mcheck_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_4" value="4"
	class="J2_Mcheck_4" /><label for="J2_Mcheck_4" id="LJ2_Mcheck_4"
	class="check_"><b>4</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_5" value="5" class="J2_Mcheck_5" /><label for="J2_Mcheck_5"
	id="LJ2_Mcheck_5" class="check_"><b>5</b></label> <input type="checkbox"
	name="J2_Mcheck" id="J2_Mcheck_6" value="6" class="J2_Mcheck_6" /><label
	for="J2_Mcheck_6" id="LJ2_Mcheck_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_10" value="10"
	class="J2_Mcheck_10" /><label for="J2_Mcheck_10" id="LJ2_Mcheck_10"
	class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_20" value="20" class="J2_Mcheck_20" /><label
	for="J2_Mcheck_20" id="LJ2_Mcheck_20" class="check_"><b>20</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_30" value="30"
	class="J2_Mcheck_30" /><label for="J2_Mcheck_30" id="LJ2_Mcheck_30"
	class="check_"><b>30</b></label> <input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_40" value="40" class="J2_Mcheck_40" /><label
	for="J2_Mcheck_40" id="LJ2_Mcheck_40" class="check_"><b>40</b></label> </div>

<div style="margin-left: 18px;
text-align: left;"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_50" value="50" class="J2_Mcheck_50" /><label
	for="J2_Mcheck_50" id="LJ2_Mcheck_50" class="check_"><b>50</b></label></div>

</div>
</div>




<div style="margin-left: 100px;">
	<div class="text-number">Marca una casilla o más en cada columna
	</div>
<div class="linear">
<div class="container">
<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_0" value="0" class="J2_1check_0" /><label id="LJ2_1check_0"
	for="J2_1check_0" class="check_"><b>0</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_0" value="0" class="J2_2check_0" /><label
	for="J2_2check_0" id="LJ2_2check_0" class="check_"><b>0</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_0" value="0"
	class="J2_3check_0" /><label for="J2_3check_0" id="LJ2_3check_0"
	class="check_"><b>0</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_1" value="1" class="J2_1check_1" /><label id="LJ2_1check_1"
	for="J2_1check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_1" value="1" class="J2_2check_1" /><label
	for="J2_2check_1" id="LJ2_2check_1" class="check_"><b>1</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_1" value="1"
	class="J2_3check_1" /><label for="J2_3check_1" id="LJ2_3check_1"
	class="check_"><b>1</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_2" value="2" class="J2_1check_2" /><label for="J2_1check_2"
	id="LJ2_1check_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_2" value="2" class="J2_2check_2" /><label
	for="J2_2check_2" id="LJ2_2check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_2" value="2"
	class="J2_3check_2" /><label for="J2_3check_2" id="LJ2_3check_2"
	class="check_"><b>2</b></label></div>


<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_3" value="" class="J2_1check_3" /><label
	for="J2_1check_3" id="LJ2_1check_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_3" value="3"
	class="J2_2check_3" /><label for="J2_2check_3" id="LJ2_2check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_3" value="3" class="J2_3check_3" /><label
	for="J2_3check_3" id="LJ2_3check_3" class="check_"><b>3</b></label> </div>
    
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_4" value="4" class="J2_1check_4" /><label
	for="J2_1check_4" id="LJ2_1check_4" class="check_"><b>4</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_4" value="4"
	class="J2_2check_4" /><label for="J2_2check_4" id="LJ2_2check_4"
	class="check_"><b>4</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_4" value="4" class="J2_3check_4" /><label
	for="J2_3check_4" id="LJ2_3check_4" class="check_"><b>4</b></label> </div>
<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_5" value="5" class="J2_1check_5" /><label
	for="J2_1check_5" id="LJ2_1check_5" class="check_"><b>5</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_5" value="5"
	class="J2_2check_5" /><label for="J2_2check_5" id="LJ2_2check_5"
	class="check_"><b>5</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_5" value="5" class="J2_3check_5" /><label
	for="J2_3check_5" id="LJ2_3check_5" class="check_"><b>5</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_6" value="6" class="J2_1check_6" /><label
	for="J2_1check_6" id="LJ2_1check_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J2check" id="J2_2check_6" value="6"
	class="J2_2check_6" /><label for="J2_2check_6" id="LJ2_2check_6"
	class="check_"><b>6</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_6" value="6" class="J2_3check_6" /><label
	for="J2_3check_6" id="LJ2_3check_6" class="check_"><b>6</b></label> </div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_7" value="7" class="J2_1check_7" /><label
	for="J2_1check_7" id="LJ2_1check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_7" value="7"
	class="J2_2check_7" /><label for="J2_2check_7" id="LJ2_2check_7"
	class="check_"><b>7</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_7" value="7" class="J2_3check_7" /><label
	for="J2_3check_7" id="LJ2_3check_7" class="check_"><b>7</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_8" value="8" class="J2_1check_8" /><label
	for="J2_1check_8" id="LJ2_1check_8" class="check_"><b>8</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_8" value="8"
	class="J2_2check_8" /><label for="J2_2check_8" id="LJ2_2check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_8" value="8" class="J2_3check_8" /><label
	for="J2_3check_8" id="LJ2_3check_8" class="check_"><b>8</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_9" value="9" class="J2_1check_9" /><label
	for="J2_1check_9" id="LJ2_1check_9" class="check_"><b>9</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_9" value="9"
	class="J2_2check_9" /><label for="J2_2check_9" id="LJ2_2check_9"
	class="check_"><b>9</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_9" value="9" class="J2_3check_9" /><label
	for="J2_3check_9" id="LJ2_3check_9" class="check_"><b>9</b></label></div>
    
</div>
</div>

<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" 
	 id="J2-text-area" readonly="readonly"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J2azar"><img
	src="layer-view-image/game/super3/flecha-s3.gif" height="5"
	width="5" class="icon" /><span class="text">Agregar al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="clear" id="J2clear"><img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="more" id="J2more">
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span>
</div>
</div>


<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J2less" class="less" >
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>

</div>


</div>


</div>

</div>






</div>



<div style="color: #818181; font-family: arial; font-size: 11px;">

<div class="linear" style="margin-left: 2px; margin-top: 19px;">Elige en
cu&#225;ntos sorteos consecutivos jugar&#225;s:</div>
<div style="padding: 0px 234px; margin-bottom: 18px;">

<div class="selectBox">
<c:forEach items="${super3SaleList}" var="super3SaleList" begin="0" end="0">

   <div class="box" id="box">${super3SaleList.messageDraw}</div> 

   </c:forEach>
	<select  name="model" id="mySelectBox" 
	onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
	<c:forEach items="${super3SaleList}" var="super3SaleList" >
		<option value="${super3SaleList.numDraws}">${super3SaleList.messageDraw}</option>
	</c:forEach>
	</select>

</div>
</div>
</div>

<div class="font">
	<div class="center">
		<div class="color-text">
			<div><span id='price-message'>${super3SaleBean.priceMessage}</span> | Total de Apuestas: <span id="comb">0</span></div>
			<div class="bold-type">Total: S/.<span id="total_apagar">0</span></div>
		</div>
		<!-- div class="text-distance"><input type="button" name="buy" id="buy" class="button-buy-off"/></div -->
		<div id="buy-panel"><a href="#" class="button-buy" id='buy' onclick="return false;"></a></div>
	</div>
</div>
<div id="noteSuper3"> 
        <span class="text-number">Nota: El estado de los premios de tu boleto S&uacute;per 3 se actualizan en tu Cuenta todos los d&iacute;as a las 12:00 m y 3:00 am</span>
</div>
</form>


	</div>


	<div class="right_flecha_cotejador" id="kabala-flecha-cotejo">
		<div class="flecha_next"></div>
		<div class=flecha_back></div>
		<div class="play_go_3_4_gd"></div>
	</div>



	<div class="kabala_fechas_cotejador" id="kabala-fechas-cotejo">


		<div class="validez_boleto_cotejador">Boleto v&aacute;lido para</div>
		<div class="cont_opciones_cotejador">
			<div class="selectBoxCotejo">

			<c:forEach items="${kabalaValoresBoleto}" var="num" begin="0" end="0">
			<div class="box" id="box">${num}</div> 
			</c:forEach>

				<select  name="model" id="mySelectBox" 
				onChange="valChange(this);">
				<c:forEach items="${kabalaValoresBoleto}" var="cantBoleto" >
					<option value="${cantBoleto}">${cantBoleto}</option>
				</c:forEach>
				</select>
				
				
			</div>
			
			
		</div>
		
		
		<div class="validez_from_sorteo">sorteo(s)
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Desde</div>
			
		<div class="selectBox" style="bottom: 84px; top: 376px; left: 306px; position: absolute;">
			   <c:forEach items="${kabalaSaleList}" var="kabalaSaleList" begin="0" end="0">
			   <div class="box" id="box">${kabalaSaleList.id.drawId} el ${kabalaSaleList.drCloseDate}</div> 
			   </c:forEach>
			   
				<select  name="model" id="mySelectBox-2" 
				onChange="valChange(this);">
				<c:forEach items="${kabalaSaleList}" var="kabalaSaleList" >
					<option value="${kabalaSaleList.id.drawId}">${kabalaSaleList.id.drawId} el ${kabalaSaleList.drCloseDate}</option>
				</c:forEach>
				</select>
				
		</div>
	
	
	
		
		<div class="validez_to_sorteo">hasta</div>
			
		<div class="cantFecha">
			<div class="BotonCotejo">
				 <c:forEach items="${kabalaSaleList}" var="kabalaSaleList" begin="0" end="0">
			     <span id="fechaCotejo" Style="left: 7px; margin-top: 2px; position: absolute">${kabalaSaleList.id.drawId}</span>
			     </c:forEach>
				
				
			</div>
		</div>
	</div>


	<div class="font-cotejador" id="cotejar">
		<div class="center">
			<!-- div class="text-distance"><input type="button" name="buy" id="buy" class="button-buy-off"/></div -->
			<div id="cotejo-panel">
				<a href="#" class="button-cotejo" id='buy' onclick="return false;"></a>
			</div>
		</div>
	</div>
	
	<div class="font-cotejador-back" id="regresarCotejo" >
		<div class="center">
			<!-- div class="text-distance"><input type="button" name="buy" id="buy" class="button-buy-off"/></div -->
			<div id="back-cotejo-panel">
				<a href="#" class="button-cotejo-back" id='more_plays' onclick="return false;"></a>
			</div>
		</div>
	</div>
	
	

	<div id="cotejoKabala" Style="position: absolute;top: 60px;display:none;margin-left: 12px;">
	<input type="hidden" id="jugadaCompletaKabala">
	<div id="valorJugada" Style="margin-left:9px;overflow:auto;height:342px;width:609px"></div>
	</div>
	
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
	<script type='text/javascript'
		src='layer-view-script/common/jquery.scripts.js'></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	<script type='text/javascript'
		src='layer-view-script/game/kabala/lotto-kabala-cotejador.js'></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.carouFredSel.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
</body>
</html>