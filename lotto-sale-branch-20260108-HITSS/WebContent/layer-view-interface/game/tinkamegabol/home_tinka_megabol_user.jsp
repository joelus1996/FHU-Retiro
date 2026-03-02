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

<c:choose>
    <c:when test="${isLottoSale == true && isTeapuestoSale == false}"><c:redirect url="/inicio.html"/></c:when><c:otherwise></c:otherwise>
</c:choose>
<meta charset="UTF-8">
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type='text/javascript' src='layer-view-script/game/ganadiario/lotto-ganadiario.js?v=3'></script>
<script type='text/javascript' src='layer-view-script/game/ganadiario/lotto-ganadiario-ajax.js'></script>
<link href="layer-view-style/common/normalize.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="layer-view-style/game/ganadiario/theme.css" />
<link rel="stylesheet" type="text/css" href="layer-view-style/game/ganadiario/themeGanaDiario.css" />
<title>Gana Diario</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body style="background: aqua;">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<input type="text" value="${ganadiarioProcedureBetData.numberMore}" disabled="disabled" class="visible" id="more_repeated">
<input type="text" value="${ganadiarioProcedureBetData.numbersLess}" disabled="disabled" class="visible" id="less_repeated">
<input type="text" value="${ganadiarioProcedureBetData.status}" disabled="disabled" class="visible" id="status">
<input type="text" value="${ganadiarioProcedureBetData.simpleBetPrice}" disabled="disabled" class="visible" id="simpleBetPrice_repeated">
<input type="text" value="${ganadiarioProcedureBetData.promotionType}" disabled="disabled" class="visible" id="promo">
<input type="text" value="${ganadiarioProcedureBetData.priceType}" disabled="disabled" class="visible" id="price_type">


<div class="gana_diario">

<div id="center-text">
    <div id="premio">PREMIO s/. 
    <span style="font-size: 26px;">${ganadiarioProcedureBetData.prize} </span></div>
    
 
 	<div id="aviso">&iexcl;Mejora tu vida hoy!</div>
    
</div>
 

 
 	<c:if test="${ganadiarioProcedureBetData.status == 'CIE'}">
 		<div id="hora-ini-juego">
			     	<div>Pr&oacute;ximo sorteo</div>
				  	<div>Abre HOY</div>
				    <div>a las ${ganadiarioProcedureBetData.openHour}</div>
	    </div>
   </c:if>
   
	<c:if test="${ganadiarioProcedureBetData.status == 'ACT'}">  
				<div id="hora-fin-juego">
				  	<div id="center-text-time">Ju&#233;galo HOY</div>
				    <div>hasta ${ganadiarioProcedureBetData.closeHour}</div> 
				</div>
	</c:if>


<div class="">


<div style="margin-top: 5px;">
<div class="transition-one">


</div>
<div id ="help-part1" class="help-off"></div>
<div class="transition-two"></div>
<div id ="help-part2" class="help-off"></div>
<div class="font-play">

<form name="start_play" id="start_play">

<div class="linear">

<div id="part1">
<div class="left">
<div class="text-play">JUGADA A</div>
<div class="number-textarea-button">
<div class="linear"><span class="text-number">Marcar 5
casillas o m&#225;s</span>
<div class="container">
<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_1" value="1" class="J1check_1" /><label id="LJ1check_1"
	for="J1check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J1check" id="J1check_2" value="2" class="J1check_2" /><label
	for="J1check_2" id="LJ1check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J1check" id="J1check_3" value="3"
	class="J1check_3" /><label for="J1check_3" id="LJ1check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J1check"
	id="J1check_4" value="4" class="J1check_4" /><label for="J1check_4"
	id="LJ1check_4" class="check_"><b>4</b></label> <input type="checkbox"
	name="J1check" id="J1check_5" value="5" class="J1check_5" /><label
	for="J1check_5" id="LJ1check_5" class="check_"><b>5</b></label></div>

<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_6" value="6" class="J1check_6" /><label for="J1check_6"
	id="LJ1check_6" class="check_"><b>6</b></label> <input type="checkbox"
	name="J1check" id="J1check_7" value="7" class="J1check_7" /><label
	for="J1check_7" id="LJ1check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J1check" id="J1check_8" value="8"
	class="J1check_8" /><label for="J1check_8" id="LJ1check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J1check"
	id="J1check_9" value="9" class="J1check_9" /><label for="J1check_9"
	id="LJ1check_9" class="check_"><b>9</b></label> <input type="checkbox"
	name="J1check" id="J1check_10" value="10" class="J1check_10" /><label
	for="J1check_10" id="LJ1check_10" class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_11" value="11" class="J1check_11" /><label
	for="J1check_11" id="LJ1check_11" class="check_"><b>11</b></label> <input
	type="checkbox" name="J1check" id="J1check_12" value="12"
	class="J1check_12" /><label for="J1check_12" id="LJ1check_12"
	class="check_"><b>12</b></label> <input type="checkbox" name="J1check"
	id="J1check_13" value="13" class="J1check_13" /><label
	for="J1check_13" id="LJ1check_13" class="check_"><b>13</b></label> <input
	type="checkbox" name="J1check" id="J1check_14" value="14"
	class="J1check_14" /><label for="J1check_14" id="LJ1check_14"
	class="check_"><b>14</b></label> <input type="checkbox" name="J1check"
	id="J1check_15" value="15" class="J1check_15" /><label
	for="J1check_15" id="LJ1check_15" class="check_"><b>15</b></label></div>
<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_16" value="16" class="J1check_16" /><label
	for="J1check_16" id="LJ1check_16" class="check_"><b>16</b></label> <input
	type="checkbox" name="J1check" id="J1check_17" value="17"
	class="J1check_17" /><label for="J1check_17" id="LJ1check_17"
	class="check_"><b>17</b></label> <input type="checkbox" name="J1check"
	id="J1check_18" value="18" class="J1check_18" /><label
	for="J1check_18" id="LJ1check_18" class="check_"><b>18</b></label> <input
	type="checkbox" name="J1check" id="J1check_19" value="19"
	class="J1check_19" /><label for="J1check_19" id="LJ1check_19"
	class="check_"><b>19</b></label> <input type="checkbox" name="J1check"
	id="J1check_20" value="20" class="J1check_20" /><label
	for="J1check_20" id="LJ1check_20" class="check_"><b>20</b></label></div>
<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_21" value="21" class="J1check_21" /><label
	for="J1check_21" id="LJ1check_21" class="check_"><b>21</b></label> <input
	type="checkbox" name="J1check" id="J1check_22" value="22"
	class="J1check_22" /><label for="J1check_22" id="LJ1check_22"
	class="check_"><b>22</b></label> <input type="checkbox" name="J1check"
	id="J1check_23" value="23" class="J1check_23" /><label
	for="J1check_23" id="LJ1check_23" class="check_"><b>23</b></label> <input
	type="checkbox" name="J1check" id="J1check_24" value="24"
	class="J1check_24" /><label for="J1check_24" id="LJ1check_24"
	class="check_"><b>24</b></label> <input type="checkbox" name="J1check"
	id="J1check_25" value="25" class="J1check_25" /><label
	for="J1check_25" id="LJ1check_25" class="check_"><b>25</b></label></div>
<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_26" value="26" class="J1check_26" /><label
	for="J1check_26" id="LJ1check_26" class="check_"><b>26</b></label> <input
	type="checkbox" name="J1check" id="J1check_27" value="27"
	class="J1check_27" /><label for="J1check_27" id="LJ1check_27"
	class="check_"><b>27</b></label> <input type="checkbox" name="J1check"
	id="J1check_28" value="28" class="J1check_28" /><label
	for="J1check_28" id="LJ1check_28" class="check_"><b>28</b></label> <input
	type="checkbox" name="J1check" id="J1check_29" value="29"
	class="J1check_29" /><label for="J1check_29" id="LJ1check_29"
	class="check_"><b>29</b></label> <input type="checkbox" name="J1check"
	id="J1check_30" value="30" class="J1check_30" /><label
	for="J1check_30" id="LJ1check_30" class="check_"><b>30</b></label></div>
<div class="margin"><input type="checkbox" name="J1check"
	id="J1check_31" value="31" class="J1check_31" /><label
	for="J1check_31" id="LJ1check_31" class="check_"><b>31</b></label> <input
	type="checkbox" name="J1check" id="J1check_32" value="32"
	class="J1check_32" /><label for="J1check_32" id="LJ1check_32"
	class="check_"><b>32</b></label> <input type="checkbox" name="J1check"
	id="J1check_33" value="33" class="J1check_33" /><label
	for="J1check_33" id="LJ1check_33" class="check_"><b>33</b></label> <input
	type="checkbox" name="J1check" id="J1check_34" value="34"
	class="J1check_34" /><label for="J1check_34" id="LJ1check_34"
	class="check_"><b>34</b></label> <input type="checkbox" name="J1check"
	id="J1check_35" value="35" class="J1check_35" /><label
	for="J1check_35" id="LJ1check_35" class="check_"><b>35</b></label></div>
</div>

</div>
<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" disabled="true"
	label="Tus números son:" id="J1-text-area"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J1"><img
	src="layer-view-image/game/ganadiario/flegd.gif" height="5"
	width="5" class="icon" /><span class="text">Al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="clear" id="J1"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="more" id="J1">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span>
</div>
</div>


<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J1" class="less" >
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>
</div>
</div>


<div class="right">

<div class="text-play">JUGADA B</div>
<div class="number-textarea-button">
<div class="linear"><span class="text-number">Marcar 5
casillas o m&#225;s</span>
<div class="container">
<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_1" value="1" class="J2check_1" /><label id="LJ2check_1"
	for="J2check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J2check" id="J2check_2" value="2" class="J2check_2" /><label
	for="J2check_2" id="LJ2check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J2check" id="J2check_3" value="3"
	class="J2check_3" /><label for="J2check_3" id="LJ2check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J2check"
	id="J2check_4" value="4" class="J2check_4" /><label for="J2check_4"
	id="LJ2check_4" class="check_"><b>4</b></label> <input type="checkbox"
	name="J2check" id="J2check_5" value="5" class="J2check_5" /><label
	for="J2check_5" id="LJ2check_5" class="check_"><b>5</b></label></div>

<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_6" value="6" class="J2check_6" /><label for="J2check_6"
	id="LJ2check_6" class="check_"><b>6</b></label> <input type="checkbox"
	name="J2check" id="J2check_7" value="7" class="J2check_7" /><label
	for="J2check_7" id="LJ2check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J2check" id="J2check_8" value="8"
	class="J2check_8" /><label for="J2check_8" id="LJ2check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J2check"
	id="J2check_9" value="9" class="J2check_9" /><label for="J2check_9"
	id="LJ2check_9" class="check_"><b>9</b></label> <input type="checkbox"
	name="J2check" id="J2check_10" value="10" class="J2check_10" /><label
	for="J2check_10" id="LJ2check_10" class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_11" value="11" class="J2check_11" /><label
	for="J2check_11" id="LJ2check_11" class="check_"><b>11</b></label> <input
	type="checkbox" name="J2check" id="J2check_12" value="12"
	class="J2check_12" /><label for="J2check_12" id="LJ2check_12"
	class="check_"><b>12</b></label> <input type="checkbox" name="J2check"
	id="J2check_13" value="13" class="J2check_13" /><label
	for="J2check_13" id="LJ2check_13" class="check_"><b>13</b></label> <input
	type="checkbox" name="J2check" id="J2check_14" value="14"
	class="J2check_14" /><label for="J2check_14" id="LJ2check_14"
	class="check_"><b>14</b></label> <input type="checkbox" name="J2check"
	id="J2check_15" value="15" class="J2check_15" /><label
	for="J2check_15" id="LJ2check_15" class="check_"><b>15</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_16" value="16" class="J2check_16" /><label
	for="J2check_16" id="LJ2check_16" class="check_"><b>16</b></label> <input
	type="checkbox" name="J2check" id="J2check_17" value="17"
	class="J2check_17" /><label for="J2check_17" id="LJ2check_17"
	class="check_"><b>17</b></label> <input type="checkbox" name="J2check"
	id="J2check_18" value="18" class="J2check_18" /><label
	for="J2check_18" id="LJ2check_18" class="check_"><b>18</b></label> <input
	type="checkbox" name="J2check" id="J2check_19" value="19"
	class="J2check_19" /><label for="J2check_19" id="LJ2check_19"
	class="check_"><b>19</b></label> <input type="checkbox" name="J2check"
	id="J2check_20" value="20" class="J2check_20" /><label
	for="J2check_20" id="LJ2check_20" class="check_"><b>20</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_21" value="21" class="J2check_21" /><label
	for="J2check_21" id="LJ2check_21" class="check_"><b>21</b></label> <input
	type="checkbox" name="J2check" id="J2check_22" value="22"
	class="J2check_22" /><label for="J2check_22" id="LJ2check_22"
	class="check_"><b>22</b></label> <input type="checkbox" name="J2check"
	id="J2check_23" value="23" class="J2check_23" /><label
	for="J2check_23" id="LJ2check_23" class="check_"><b>23</b></label> <input
	type="checkbox" name="J2check" id="J2check_24" value="24"
	class="J2check_24" /><label for="J2check_24" id="LJ2check_24"
	class="check_"><b>24</b></label> <input type="checkbox" name="J2check"
	id="J2check_25" value="25" class="J2check_25" /><label
	for="J2check_25" id="LJ2check_25" class="check_"><b>25</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_26" value="26" class="J2check_26" /><label
	for="J2check_26" id="LJ2check_26" class="check_"><b>26</b></label> <input
	type="checkbox" name="J2check" id="J2check_27" value="27"
	class="J2check_27" /><label for="J2check_27" id="LJ2check_27"
	class="check_"><b>27</b></label> <input type="checkbox" name="J2check"
	id="J2check_28" value="28" class="J2check_28" /><label
	for="J2check_28" id="LJ2check_28" class="check_"><b>28</b></label> <input
	type="checkbox" name="J2check" id="J2check_29" value="29"
	class="J2check_29" /><label for="J2check_29" id="LJ2check_29"
	class="check_"><b>29</b></label> <input type="checkbox" name="J2check"
	id="J2check_30" value="30" class="J2check_30" /><label
	for="J2check_30" id="LJ2check_30" class="check_"><b>30</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2check_31" value="31" class="J2check_31" /><label
	for="J2check_31" id="LJ2check_31" class="check_"><b>31</b></label> <input
	type="checkbox" name="J2check" id="J2check_32" value="32"
	class="J2check_32" /><label for="J2check_32" id="LJ2check_32"
	class="check_"><b>32</b></label> <input type="checkbox" name="J2check"
	id="J2check_33" value="33" class="J2check_33" /><label
	for="J2check_33" id="LJ2check_33" class="check_"><b>33</b></label> <input
	type="checkbox" name="J2check" id="J2check_34" value="34"
	class="J2check_34" /><label for="J2check_34" id="LJ2check_34"
	class="check_"><b>34</b></label> <input type="checkbox" name="J2check"
	id="J2check_35" value="35" class="J2check_35" /><label
	for="J2check_35" id="LJ2check_35" class="check_"><b>35</b></label></div>
</div>

</div>
<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" disabled="true"
	label="Tus números son:" id="J2-text-area"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J2"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Al azar</span></div>

</div>
<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="clear" id="J2"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J2" class="more">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span></div>

</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div  id="J2" class="less">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>
</div>
</div>

</div>


<div id="part2">

<div class="left">

<div class="text-play">JUGADA C</div>
<div class="number-textarea-button">
<div class="linear"><span class="text-number">Marcar 5
casillas o m&#225;s</span>
<div class="container">
<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_1" value="1" class="J3check_1" /><label id="LJ3check_1"
	for="J3check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J3check" id="J3check_2" value="2" class="J3check_2" /><label
	for="J3check_2" id="LJ3check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J3check" id="J3check_3" value="3"
	class="J3check_3" /><label for="J3check_3" id="LJ3check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J3check"
	id="J3check_4" value="4" class="J3check_4" /><label for="J3check_4"
	id="LJ3check_4" class="check_"><b>4</b></label> <input type="checkbox"
	name="J3check" id="J3check_5" value="5" class="J3check_5" /><label
	for="J3check_5" id="LJ3check_5" class="check_"><b>5</b></label></div>

<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_6" value="6" class="J3check_6" /><label for="J3check_6"
	id="LJ3check_6" class="check_"><b>6</b></label> <input type="checkbox"
	name="J3check" id="J3check_7" value="7" class="J3check_7" /><label
	for="J3check_7" id="LJ3check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J3check" id="J3check_8" value="8"
	class="J3check_8" /><label for="J3check_8" id="LJ3check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J3check"
	id="J3check_9" value="9" class="J3check_9" /><label for="J3check_9"
	id="LJ3check_9" class="check_"><b>9</b></label> <input type="checkbox"
	name="J3check" id="J3check_10" value="10" class="J3check_10" /><label
	for="J3check_10" id="LJ3check_10" class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_11" value="11" class="J3check_11" /><label
	for="J3check_11" id="LJ3check_11" class="check_"><b>11</b></label> <input
	type="checkbox" name="J3check" id="J3check_12" value="12"
	class="J3check_12" /><label for="J3check_12" id="LJ3check_12"
	class="check_"><b>12</b></label> <input type="checkbox" name="J3check"
	id="J3check_13" value="13" class="J3check_13" /><label
	for="J3check_13" id="LJ3check_13" class="check_"><b>13</b></label> <input
	type="checkbox" name="J3check" id="J3check_14" value="14"
	class="J3check_14" /><label for="J3check_14" id="LJ3check_14"
	class="check_"><b>14</b></label> <input type="checkbox" name="J3check"
	id="J3check_15" value="15" class="J3check_15" /><label
	for="J3check_15" id="LJ3check_15" class="check_"><b>15</b></label></div>
<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_16" value="16" class="J3check_16" /><label
	for="J3check_16" id="LJ3check_16" class="check_"><b>16</b></label> <input
	type="checkbox" name="J3check" id="J3check_17" value="17"
	class="J3check_17" /><label for="J3check_17" id="LJ3check_17"
	class="check_"><b>17</b></label> <input type="checkbox" name="J3check"
	id="J3check_18" value="18" class="J3check_18" /><label
	for="J3check_18" id="LJ3check_18" class="check_"><b>18</b></label> <input
	type="checkbox" name="J3check" id="J3check_19" value="19"
	class="J3check_19" /><label for="J3check_19" id="LJ3check_19"
	class="check_"><b>19</b></label> <input type="checkbox" name="J3check"
	id="J3check_20" value="20" class="J3check_20" /><label
	for="J3check_20" id="LJ3check_20" class="check_"><b>20</b></label></div>
<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_21" value="21" class="J3check_21" /><label
	for="J3check_21" id="LJ3check_21" class="check_"><b>21</b></label> <input
	type="checkbox" name="J3check" id="J3check_22" value="22"
	class="J3check_22" /><label for="J3check_22" id="LJ3check_22"
	class="check_"><b>22</b></label> <input type="checkbox" name="J3check"
	id="J3check_23" value="23" class="J3check_23" /><label
	for="J3check_23" id="LJ3check_23" class="check_"><b>23</b></label> <input
	type="checkbox" name="J3check" id="J3check_24" value="24"
	class="J3check_24" /><label for="J3check_24" id="LJ3check_24"
	class="check_"><b>24</b></label> <input type="checkbox" name="J3check"
	id="J3check_25" value="25" class="J3check_25" /><label
	for="J3check_25" id="LJ3check_25" class="check_"><b>25</b></label></div>
<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_26" value="26" class="J3check_26" /><label
	for="J3check_26" id="LJ3check_26" class="check_"><b>26</b></label> <input
	type="checkbox" name="J3check" id="J3check_27" value="27"
	class="J3check_27" /><label for="J3check_27" id="LJ3check_27"
	class="check_"><b>27</b></label> <input type="checkbox" name="J3check"
	id="J3check_28" value="28" class="J3check_28" /><label
	for="J3check_28" id="LJ3check_28" class="check_"><b>28</b></label> <input
	type="checkbox" name="J3check" id="J3check_29" value="29"
	class="J3check_29" /><label for="J3check_29" id="LJ3check_29"
	class="check_"><b>29</b></label> <input type="checkbox" name="J3check"
	id="J3check_30" value="30" class="J3check_30" /><label
	for="J3check_30" id="LJ3check_30" class="check_"><b>30</b></label></div>
<div class="margin"><input type="checkbox" name="J3check"
	id="J3check_31" value="31" class="J3check_31" /><label
	for="J3check_31" id="LJ3check_31" class="check_"><b>31</b></label> <input
	type="checkbox" name="J3check" id="J3check_32" value="32"
	class="J3check_32" /><label for="J3check_32" id="LJ3check_32"
	class="check_"><b>32</b></label> <input type="checkbox" name="J3check"
	id="J3check_33" value="33" class="J3check_33" /><label
	for="J3check_33" id="LJ3check_33" class="check_"><b>33</b></label> <input
	type="checkbox" name="J3check" id="J3check_34" value="34"
	class="J3check_34" /><label for="J3check_34" id="LJ3check_34"
	class="check_"><b>34</b></label> <input type="checkbox" name="J3check"
	id="J3check_35" value="35" class="J3check_35" /><label
	for="J3check_35" id="LJ3check_35" class="check_"><b>35</b></label></div>
</div>

</div>
<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" disabled="true"
	label="Tus números son:" id="J3-text-area"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J3"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="clear" id="J3"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="more" id="J3">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span></div>

</div>

<div class="separate-bottun" title="J3"></div>
<div class="attribute-button" >
<div class="less" id="J3"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>
</div>
</div>
</div>
</div>




<div class="right">
<div class="text-play">JUGADA D</div>
<div class="number-textarea-button">
<div class="linear"><span class="text-number">Marcar 5
casillas o m&#225;s</span>
<div class="container">
<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_1" value="1" class="J4check_1" /><label id="LJ4check_1"
	for="J4check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J4check" id="J4check_2" value="2" class="J4check_2" /><label
	for="J4check_2" id="LJ4check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J4check" id="J4check_3" value="3"
	class="J4check_3" /><label for="J4check_3" id="LJ4check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J4check"
	id="J4check_4" value="4" class="J4check_4" /><label for="J4check_4"
	id="LJ4check_4" class="check_"><b>4</b></label> <input type="checkbox"
	name="J4check" id="J4check_5" value="5" class="J4check_5" /><label
	for="J4check_5" id="LJ4check_5" class="check_"><b>5</b></label></div>

<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_6" value="6" class="J4check_6" /><label for="J4check_6"
	id="LJ4check_6" class="check_"><b>6</b></label> <input type="checkbox"
	name="J4check" id="J4check_7" value="7" class="J4check_7" /><label
	for="J4check_7" id="LJ4check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J4check" id="J4check_8" value="8"
	class="J4check_8" /><label for="J4check_8" id="LJ4check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J4check"
	id="J4check_9" value="9" class="J4check_9" /><label for="J4check_9"
	id="LJ4check_9" class="check_"><b>9</b></label> <input type="checkbox"
	name="J4check" id="J4check_10" value="10" class="J4check_10" /><label
	for="J4check_10" id="LJ4check_10" class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_11" value="11" class="J4check_11" /><label
	for="J4check_11" id="LJ4check_11" class="check_"><b>11</b></label> <input
	type="checkbox" name="J4check" id="J4check_12" value="12"
	class="J4check_12" /><label for="J4check_12" id="LJ4check_12"
	class="check_"><b>12</b></label> <input type="checkbox" name="J4check"
	id="J4check_13" value="13" class="J4check_13" /><label
	for="J4check_13" id="LJ4check_13" class="check_"><b>13</b></label> <input
	type="checkbox" name="J4check" id="J4check_14" value="14"
	class="J4check_14" /><label for="J4check_14" id="LJ4check_14"
	class="check_"><b>14</b></label> <input type="checkbox" name="J4check"
	id="J4check_15" value="15" class="J4check_15" /><label
	for="J4check_15" id="LJ4check_15" class="check_"><b>15</b></label></div>
<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_16" value="16" class="J4check_16" /><label
	for="J4check_16" id="LJ4check_16" class="check_"><b>16</b></label> <input
	type="checkbox" name="J4check" id="J4check_17" value="17"
	class="J4check_17" /><label for="J4check_17" id="LJ4check_17"
	class="check_"><b>17</b></label> <input type="checkbox" name="J4check"
	id="J4check_18" value="18" class="J4check_18" /><label
	for="J4check_18" id="LJ4check_18" class="check_"><b>18</b></label> <input
	type="checkbox" name="J4check" id="J4check_19" value="19"
	class="J4check_19" /><label for="J4check_19" id="LJ4check_19"
	class="check_"><b>19</b></label> <input type="checkbox" name="J4check"
	id="J4check_20" value="20" class="J4check_20" /><label
	for="J4check_20" id="LJ4check_20" class="check_"><b>20</b></label></div>
<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_21" value="21" class="J4check_21" /><label
	for="J4check_21" id="LJ4check_21" class="check_"><b>21</b></label> <input
	type="checkbox" name="J4check" id="J4check_22" value="22"
	class="J4check_22" /><label for="J4check_22" id="LJ4check_22"
	class="check_"><b>22</b></label> <input type="checkbox" name="J4check"
	id="J4check_23" value="23" class="J4check_23" /><label
	for="J4check_23" id="LJ4check_23" class="check_"><b>23</b></label> <input
	type="checkbox" name="J4check" id="J4check_24" value="24"
	class="J4check_24" /><label for="J4check_24" id="LJ4check_24"
	class="check_"><b>24</b></label> <input type="checkbox" name="J4check"
	id="J4check_25" value="25" class="J4check_25" /><label
	for="J4check_25" id="LJ4check_25" class="check_"><b>25</b></label></div>
<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_26" value="26" class="J4check_26" /><label
	for="J4check_26" id="LJ4check_26" class="check_"><b>26</b></label> <input
	type="checkbox" name="J4check" id="J4check_27" value="27"
	class="J4check_27" /><label for="J4check_27" id="LJ4check_27"
	class="check_"><b>27</b></label> <input type="checkbox" name="J4check"
	id="J4check_28" value="28" class="J4check_28" /><label
	for="J4check_28" id="LJ4check_28" class="check_"><b>28</b></label> <input
	type="checkbox" name="J4check" id="J4check_29" value="29"
	class="J4check_29" /><label for="J4check_29" id="LJ4check_29"
	class="check_"><b>29</b></label> <input type="checkbox" name="J4check"
	id="J4check_30" value="30" class="J4check_30" /><label
	for="J4check_30" id="LJ4check_30" class="check_"><b>30</b></label></div>
<div class="margin"><input type="checkbox" name="J4check"
	id="J4check_31" value="31" class="J4check_31" /><label
	for="J4check_31" id="LJ4check_31" class="check_"><b>31</b></label> <input
	type="checkbox" name="J4check" id="J4check_32" value="32"
	class="J4check_32" /><label for="J4check_32" id="LJ4check_32"
	class="check_"><b>32</b></label> <input type="checkbox" name="J4check"
	id="J4check_33" value="33" class="J4check_33" /><label
	for="J4check_33" id="LJ4check_33" class="check_"><b>33</b></label> <input
	type="checkbox" name="J4check" id="J4check_34" value="34"
	class="J4check_34" /><label for="J4check_34" id="LJ4check_34"
	class="check_"><b>34</b></label> <input type="checkbox" name="J4check"
	id="J4check_35" value="35" class="J4check_35" /><label
	for="J4check_35" id="LJ4check_35" class="check_"><b>35</b></label></div>
</div>

</div>
<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" disabled="true"
	label="Tus números son:" id="J4-text-area"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J4"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="clear" id="J4"><img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>
<div class="separate-bottun" ></div>
<div class="attribute-button">
<div id="J4" class="more">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon"/><span class="text">M&#225;s
salieron</span></div></div>


<div class="separate-bottun" ></div>
<div class="attribute-button">
<div id="J4"  class="less">
<img src="layer-view-image/game/ganadiario/flegd.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div></div>


</div>
</div>
</div>
</div>
</div>
</div>


<div class="right_flecha">
<div class="flecha_next"></div>
<div class="flecha_back"></div>
<div class="play_go_3_4_gd"></div>

</div>



<div style="color: #818181; font-family: arial; font-size: 11px;">

<div class="linear" style="margin-left: 2px;">Elige en
cu&#225;ntos sorteos consecutivos jugar&#225;s:</div>
<div style="padding: 0px 234px; margin-bottom: 18px;">

<div class="selectBox">
<c:forEach items="${ganadiarioProcedureDrawDataList}" var="ganProBetDat" begin="0" end="0">

   <div class="box" id="box">${ganProBetDat.messageDraw}</div> 

   </c:forEach>
	<select  name="model" id="mySelectBox" 
	onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
	<c:forEach items="${ganadiarioProcedureDrawDataList}" var="ganProBetDraw" >
		<option value="${ganProBetDraw.numDraws}">${ganProBetDraw.messageDraw}</option>
	</c:forEach>
	</select>
	
	


</div>
</div>
</div>




<div class="font">
	<div class="center">
		<div class="color-text">
			<div>${ganadiarioProcedureBetData.priceMessage} | Total de Apuestas: <span id="comb">0</span></div>
			<div class="bold-type">Total: S/.<span id="total_apagar">0</span></div>
		</div>
		<!-- div class="text-distance"><input type="button" name="buy" id="buy" class="button-buy-off"/></div -->
		<div id="buy-panel"><a href="#" class="button-buy" id='buy' onclick="return false;"></a></div>
	</div>
</div>
</form>
</div>
</div>

<div>

<div>
<form name="finish-play"></form>
</div>
</div>
</div>

</body>
</html>