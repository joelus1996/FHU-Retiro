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
<meta name="viewport" content="width=1024">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/normalize.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/game/ganadiario/themeCotejador.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/game/ganadiario/themeGanaDiario.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/jquery.alerts.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>" />
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/menu.css" />
<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
	
<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />
<link rel="stylesheet" href="layer-view-style/v2/estilos.css" type="text/css" />

<script type="text/javascript">
		//var valorCombo="";
        function valChange(obj) {
			/*var valor1 = $("#mySelectBox").val();
			var valor2 = ($("#mySelectBox-2").val())-1;
			var valorCombo= obj.parentNode.getElementsByTagName('div')[0].innerHTML=obj.options[obj.selectedIndex].text;
			var resultadoFecha=parseInt(valor2)+parseInt(valor1);
			$("#fechaCotejo").html(resultadoFecha);
	        return true;*/
	        var obj1 = $("#mySelectBox");
			var obj2 = $("#mySelectBox-2");
			var valorCombo = 0;
			var resultadoFecha = parseInt(obj1.val())+(parseInt(obj2.val())-1);
			if($(obj).attr("id")==obj1.attr("id")) {
				$("#box").text($(obj).children("option:selected").text());
				if(resultadoFecha>parseInt(obj2.children("option:first").val())) {
					valorCombo = parseInt(obj2.children("option:first").val())-(parseInt($(obj).val())-1);
					obj2.val(valorCombo);
					$("#box-2").text(obj2.children("option:selected").text());
					$("#fechaCotejo").text(parseInt(obj2.children("option:first").val()));
				} else {
					$("#fechaCotejo").text(resultadoFecha);
				}
			}
			if($(obj).attr("id")==obj2.attr("id")) {
				$("#box-2").text($(obj).children("option:selected").text());
				if(resultadoFecha>parseInt(obj2.children("option:first").val())) {
					valorCombo = parseInt(obj2.children("option:first").val())-(parseInt($(obj).val())-1);
					obj1.val(valorCombo);
					$("#box").text(obj1.children("option:selected").text());
					$("#fechaCotejo").text(parseInt(obj2.children("option:first").val()));
				} else {
					$("#fechaCotejo").text(resultadoFecha);
				}
			}
        }
	
</script>
<style>
		.body-single-game .check_ {
		    height: 35px;
		    position: relative;
		    font-size: 16px;
		    z-index: 2;
		}
		.body-single-game .check_.colorChecked {
		    color: white;
		}
		.body-single-game .check_.colorChecked:before {
		    background: #00a8eb;
		}
		.modal-coteja-boleto .body-game .button-group h3 {
		    color: #0097cc;
		}
		.kabala_jugada_acerts .kabala_jugada-title {
		    color: #0097cc !important;
		}		
		.body-single-game .check_:before {
		    background: white;
		    content: '';
		    width: 30px;
		    height: 30px;
		    position: absolute;
		    border-radius: 50%;
		    z-index: -1;
		    left: 2px;
		    top: -5px;
		    border:solid 1px rgba(181, 181, 181, 0.58);
		}
		.logo_tinka_cotejador img {
		    float: left;
		}
		.logo_tinka_cotejador {
		    overflow: hidden;
		}
		.logo_tinka_cotejador h2 {
		    float: left;
		    margin-left: 20px;
		    font-size: 18px;
		    color: #0097cc;
		    text-transform: uppercase;
		    position: relative;
		    top: -5px;
		}		
		.main-play .top-single-game h3 {
		    color: #006b2d;
		}
		.main-play .body-play .wrapper-playing .current-games .boxes-current-games .box-current-game:hover a {
		    border: 1px solid #00a8eb;
		    color: #00a8eb;
		    background: white !important;
		}
		.main-play .body-play .wrapper-playing .current-games .boxes-current-games .box-current-game.game-played a {
			border: 1px solid #00a8eb;
		    color: #00a8eb;
		    background: white !important;
		}
		.main-play .body-play .wrapper-playing .current-games .boxes-current-games .box-current-game.game-playing a{
	    	color: #fff !important;
	    	background-color: #00a8eb !important;
		}
		.modal-coteja-boleto.main-play .body-play .wrapper-playing div.selectBox div.box {
		    font-weight: 700;
		    font-family: AllerRegular, Arial, sans-serif;
		}
		#fechaCotejo {
		    font-family: AllerRegular, Arial, sans-serif;
		}
		.main-play .top-single-game:nth-child(2) span {
		    float: none;
		    position: relative;
		    top: -2px;
		    margin-left: 10px;
		}
	</style>	
</head>

<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5WTQR7D"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


<input type="hidden" value="${kabalaSale.numbersMore}" id="more_repeated">
<input type="hidden" value="${kabalaSale.numbersLess}" id="less_repeated">
<input type="hidden" value="${kabalaSale.status}" id="status">
<input type="hidden" value="${kabalaSale.simpleBetPrice}" id="simpleBetPrice_repeated">
<input type="hidden" value="${kabalaSale.promotionType}" id="promo">
<input type="hidden" value="${kabalaSale.priceType}" id="price_type">
<input type="hidden" value="${kabalaSale.algorithm}" id="algorithm">
<input type="hidden" value="${kabalaSale.bets}" id="bets">
<input type="hidden" value="${kabalaSale.pay}" id="pay">
<input type="hidden" value="${kabalaSale.cost}" id="cost">
<input type="hidden" value="${kabalaSale.draws}" id="draw">

<div class="row cotenedor_kabala_cotejador modal-kabala modal-ganadiario">
		<div class="col-12 col-md-8">
			<div class="main-panel">
				<div class="main-play modal-coteja-boleto modal-kabala" style="width: 630px">
					<div class="body-play">
						<div class="logo_tinka_cotejador" id="kabala-cotejo-logo">
							<img src="layer-view-image/game/ganadiario/premios-logo-ganadiario.jpg"
								title="kabala" alt="kabala" class="align-img"> <h2>Coteja tu Ganadiario y entérate si ganaste un premio</h2>
						</div>	
						<div class="wrapper-playing">
							<div class="boxes-playing">
								<form name="start_play" id="start_play">
									<div class="box-playing">
										<div class="row no-gutters">
											<div class="col-6">
												<div class="box-wrapper-game box-content-left">
													<div class="box-content-game">
														<div class="box-play-main box-play-a">
															<div class="content-single-game">
																<div class="top-single-game">
																	<h3>JUGADA A <span>Marca 5 bolillas o más</span></h3>
																</div>
																<div class="body-single-game">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">
																			<div class="margin">
																				<input type="checkbox" name="check" id="J1check_1" value="1"
																					class="J1check_1" /> <label id="LJ1check_1" for="J1check_1"
																					class="check_">1</label> <input type="checkbox" name="check"
																					id="J1check_2" value="2" class="J1check_2" /> <label
																					for="J1check_2" id="LJ1check_2" class="check_">2</label> <input
																					type="checkbox" name="check" id="J1check_3" value="3"
																					class="J1check_3" /> <label for="J1check_3" id="LJ1check_3"
																					class="check_">3</label> <input type="checkbox" name="check"
																					id="J1check_4" value="4" class="J1check_4" /><label
																					for="J1check_4" id="LJ1check_4" class="check_">4</label> <input
																					type="checkbox" name="check" id="J1check_5" value="5"
																					class="J1check_5" /><label for="J1check_5" id="LJ1check_5"
																					class="check_">5</label> <input type="checkbox" name="check"
																					id="J1check_6" value="6" class="J1check_6" /> <label
																					for="J1check_6" id="LJ1check_6" class="check_">6</label>
																			</div>
																			<div class="margin">
																				<input type="checkbox" name="check" id="J1check_7" value="7"
																					class="J1check_7" /><label for="J1check_7" id="LJ1check_7"
																					class="check_">7</label> <input type="checkbox" name="check"
																					id="J1check_8" value="8" class="J1check_8" /><label
																					for="J1check_8" id="LJ1check_8" class="check_">8</label> <input
																					type="checkbox" name="check" id="J1check_9" value="9"
																					class="J1check_9" /><label for="J1check_9" id="LJ1check_9"
																					class="check_">9</label> <input type="checkbox" name="check"
																					id="J1check_10" value="10" class="J1check_10" /><label
																					for="J1check_10" id="LJ1check_10" class="check_">10</label> <input
																					type="checkbox" name="check" id="J1check_11" value="11"
																					class="J1check_11" /><label for="J1check_11"
																					id="LJ1check_11" class="check_">11</label> <input
																					type="checkbox" name="check" id="J1check_12" value="12"
																					class="J1check_12" /><label for="J1check_12"
																					id="LJ1check_12" class="check_">12</label>
																			</div>
																			<div class="margin">
																				<input type="checkbox" name="check" id="J1check_13" value="13"
																					class="J1check_13" /><label for="J1check_13"
																					id="LJ1check_13" class="check_">13</label> <input
																					type="checkbox" name="check" id="J1check_14" value="14"
																					class="J1check_14" /><label for="J1check_14"
																					id="LJ1check_14" class="check_">14</label> <input
																					type="checkbox" name="check" id="J1check_15" value="15"
																					class="J1check_15" /><label for="J1check_15"
																					id="LJ1check_15" class="check_">15</label> <input
																					type="checkbox" name="check" id="J1check_16" value="16"
																					class="J1check_16" /><label for="J1check_16"
																					id="LJ1check_16" class="check_">16</label> <input
																					type="checkbox" name="check" id="J1check_17" value="17"
																					class="J1check_17" /><label for="J1check_17"
																					id="LJ1check_17" class="check_">17</label> <input
																					type="checkbox" name="check" id="J1check_18" value="18"
																					class="J1check_18" /><label for="J1check_18"
																					id="LJ1check_18" class="check_">18</label>
																			</div>
																			<div class="margin">
																					<input type="checkbox" name="check" id="J1check_19" value="19"
																					class="J1check_19" /><label for="J1check_19"
																					id="LJ1check_19" class="check_">19</label> <input
																					type="checkbox" name="check" id="J1check_20" value="20"
																					class="J1check_20" /><label for="J1check_20"
																					id="LJ1check_20" class="check_">20</label> <input
																					type="checkbox" name="check" id="J1check_21" value="21"
																					class="J1check_21" /><label for="J1check_21"
																					id="LJ1check_21" class="check_">21</label> <input
																					type="checkbox" name="check" id="J1check_22" value="22"
																					class="J1check_22" /><label for="J1check_22"
																					id="LJ1check_22" class="check_">22</label> <input
																					type="checkbox" name="check" id="J1check_23" value="23"
																					class="J1check_23" /><label for="J1check_23"
																					id="LJ1check_23" class="check_">23</label> <input
																					type="checkbox" name="check" id="J1check_24" value="24"
																					class="J1check_24" /><label for="J1check_24"
																					id="LJ1check_24" class="check_">24</label>
																			</div>
																			<div class="margin">
																				<input type="checkbox" name="check" id="J1check_25" value="25"
																					class="J1check_25" /><label for="J1check_25"
																					id="LJ1check_25" class="check_">25</label> <input
																					type="checkbox" name="check" id="J1check_26" value="26"
																					class="J1check_26" /><label for="J1check_26"
																					id="LJ1check_26" class="check_">26</label> <input
																					type="checkbox" name="check" id="J1check_27" value="27"
																					class="J1check_27" /><label for="J1check_27"
																					id="LJ1check_27" class="check_">27</label> <input
																					type="checkbox" name="check" id="J1check_28" value="28"
																					class="J1check_28" /><label for="J1check_28"
																					id="LJ1check_28" class="check_">28</label> <input
																					type="checkbox" name="check" id="J1check_29" value="29"
																					class="J1check_29" /><label for="J1check_29"
																					id="LJ1check_29" class="check_">29</label> <input
																					type="checkbox" name="check" id="J1check_30" value="30"
																					class="J1check_30" /><label for="J1check_30"
																					id="LJ1check_30" class="check_">30</label>
																			</div>
																			<div class="margin">
																				<input type="checkbox" name="check" id="J1check_31" value="31"
																					class="J1check_31" /><label for="J1check_31"
																					id="LJ1check_31" class="check_">31</label> <input
																					type="checkbox" name="check" id="J1check_32" value="32"
																					class="J1check_32" /><label for="J1check_32"
																					id="LJ1check_32" class="check_">32</label> <input
																					type="checkbox" name="check" id="J1check_33" value="33"
																					class="J1check_33" /><label for="J1check_33"
																					id="LJ1check_33" class="check_">33</label> <input
																					type="checkbox" name="check" id="J1check_34" value="34"
																					class="J1check_34" /><label for="J1check_34"
																					id="LJ1check_34" class="check_">34</label> <input
																					type="checkbox" name="check" id="J1check_35" value="35"
																					class="J1check_35" /><label for="J1check_35"
																					id="LJ1check_35" class="check_">35</label>
																			</div>																	
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-12">
																			<div class="footer-single-right">
																				<button type="button" id="J1clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																		
																</div>
															</div>
															<div class="box-content-detail">
																<h5>Tus números son:</h5>
																<textarea id="J1-text-area" class="current-numbers" readonly="readonly"></textarea>
															</div>
														</div>
														<div class="box-play-main box-play-b" style="display: none">
															<div class="content-single-game">
																<div class="top-single-game">
																	<h3>JUGADA B <span>Marca 5 bolillas o más</span></h3>
																</div>
																<div class="body-single-game">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">
																			<div class="margin">
																				<input class="J2check_1" value="1" id="J2check_1" name="check"
																					type="checkbox"><label class="check_" for="J2check_1"
																					id="LJ2check_1">1</label> <input class="J2check_2" value="2"
																					id="J2check_2" name="check" type="checkbox"><label
																					class="check_" id="LJ2check_2" for="J2check_2">2</label> <input
																					class="J2check_3" value="3" id="J2check_3" name="check"
																					type="checkbox"><label class="check_" id="LJ2check_3"
																					for="J2check_3">3</label> <input class="J2check_4" value="4"
																					id="J2check_4" name="check" type="checkbox"><label
																					class="check_" id="LJ2check_4" for="J2check_4">4</label> <input
																					class="J2check_5" value="5" id="J2check_5" name="check"
																					type="checkbox"><label class="check_" id="LJ2check_5"
																					for="J2check_5">5</label> <input class="J2check_6" value="6"
																					id="J2check_6" name="check" type="checkbox"><label
																					class="check_" id="LJ2check_6" for="J2check_6">6</label>
																			</div>
																			<div class="margin">
																				<input class="J2check_7" value="7" id="J2check_7" name="check"
																					type="checkbox"><label class="check_" id="LJ2check_7"
																					for="J2check_7">7</label> <input class="J2check_8" value="8"
																					id="J2check_8" name="check" type="checkbox"><label
																					class="check_" id="LJ2check_8" for="J2check_8">8</label> <input
																					class="J2check_9" value="9" id="J2check_9" name="check"
																					type="checkbox"><label class="check_" id="LJ2check_9"
																					for="J2check_9">9</label> <input class="J2check_10"
																					value="10" id="J2check_10" name="check" type="checkbox"><label
																					class="check_" id="LJ2check_10" for="J2check_10">10</label> <input
																					class="J2check_11" value="11" id="J2check_11" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_11" for="J2check_11">11</label> <input
																					class="J2check_12" value="12" id="J2check_12" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_12" for="J2check_12">12</label>
																			</div>
																			<div class="margin">
																				<input class="J2check_13" value="13" id="J2check_13"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ2check_13" for="J2check_13">13</label> <input
																					class="J2check_14" value="14" id="J2check_14" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_14" for="J2check_14">14</label> <input
																					class="J2check_15" value="15" id="J2check_15" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_15" for="J2check_15">15</label> <input
																					class="J2check_16" value="16" id="J2check_16" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_16" for="J2check_16">16</label> <input
																					class="J2check_17" value="17" id="J2check_17" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_17" for="J2check_17">17</label> <input
																					class="J2check_18" value="18" id="J2check_18" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_18" for="J2check_18">18</label>
																			</div>
																			<div class="margin">
																				<input class="J2check_19" value="19" id="J2check_19"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ2check_19" for="J2check_19">19</label> <input
																					class="J2check_20" value="20" id="J2check_20" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_20" for="J2check_20">20</label> <input
																					class="J2check_21" value="21" id="J2check_21" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_21" for="J2check_21">21</label> <input
																					class="J2check_22" value="22" id="J2check_22" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_22" for="J2check_22">22</label> <input
																					class="J2check_23" value="23" id="J2check_23" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_23" for="J2check_23">23</label> <input
																					class="J2check_24" value="24" id="J2check_24" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_24" for="J2check_24">24</label>
																			</div>
																			<div class="margin">
																				<input class="J2check_25" value="25" id="J2check_25"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ2check_25" for="J2check_25">25</label> <input
																					class="J2check_26" value="26" id="J2check_26" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_26" for="J2check_26">26</label> <input
																					class="J2check_27" value="27" id="J2check_27" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_27" for="J2check_27">27</label> <input
																					class="J2check_28" value="28" id="J2check_28" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_28" for="J2check_28">28</label> <input
																					class="J2check_29" value="29" id="J2check_29" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_29" for="J2check_29">29</label> <input
																					class="J2check_30" value="30" id="J2check_30" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_30" for="J2check_30">30</label>
																			</div>
																			<div class="margin">
																				<input class="J2check_31" value="31" id="J2check_31"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ2check_31" for="J2check_31">31</label> <input
																					class="J2check_32" value="32" id="J2check_32" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_32" for="J2check_32">32</label> <input
																					class="J2check_33" value="33" id="J2check_33" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_33" for="J2check_33">33</label> <input
																					class="J2check_34" value="34" id="J2check_34" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_34" for="J2check_34">34</label> <input
																					class="J2check_35" value="35" id="J2check_35" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ2check_35" for="J2check_35">35</label>
																			</div>																			
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-12">
																			<div class="footer-single-right">
																				<button type="button" id="J2clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																		
																</div>
															</div>
															<div class="box-content-detail">
																<h5>Tus números son</h5>
																<textarea class="current-numbers" id="J2-text-area" readonly="readonly"></textarea>
															</div>
														</div>
														<div class="box-play-main box-play-c" style="display: none">
															<div class="content-single-game">
																<div class="top-single-game">
																	<h3>JUGADA C <span>Marca 5 bolillas o más</span></h3>
																</div>
																<div class="body-single-game">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">
																			<div class="margin">
																				<input class="J3check_1" value="1" id="J3check_1" name="check"
																				type="checkbox"><label class="check_" for="J3check_1"
																				id="LJ3check_1">1</label> <input class="J3check_2" value="2"
																				id="J3check_2" name="check" type="checkbox"><label
																				class="check_" id="LJ3check_2" for="J3check_2">2</label> <input
																				class="J3check_3" value="3" id="J3check_3" name="check"
																				type="checkbox"><label class="check_" id="LJ3check_3"
																				for="J3check_3">3</label> <input class="J3check_4" value="4"
																				id="J3check_4" name="check" type="checkbox"><label
																				class="check_" id="LJ3check_4" for="J3check_4">4</label> <input
																				class="J3check_5" value="5" id="J3check_5" name="check"
																				type="checkbox"><label class="check_" id="LJ3check_5"
																				for="J3check_5">5</label> <input class="J3check_6" value="6"
																				id="J3check_6" name="check" type="checkbox"><label
																				class="check_" id="LJ3check_6" for="J3check_6">6</label>
																			</div>
																			<div class="margin">
																				<input class="J3check_7" value="7" id="J3check_7" name="check"
																					type="checkbox"><label class="check_" id="LJ3check_7"
																					for="J3check_7">7</label> <input class="J3check_8" value="8"
																					id="J3check_8" name="check" type="checkbox"><label
																					class="check_" id="LJ3check_8" for="J3check_8">8</label> <input
																					class="J3check_9" value="9" id="J3check_9" name="check"
																					type="checkbox"><label class="check_" id="LJ3check_9"
																					for="J3check_9">9</label> <input class="J3check_10"
																					value="10" id="J3check_10" name="check" type="checkbox"><label
																					class="check_" id="LJ3check_10" for="J3check_10">10</label> <input
																					class="J3check_11" value="11" id="J3check_11" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_11" for="J3check_11">11</label> <input
																					class="J3check_12" value="12" id="J3check_12" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_12" for="J3check_12">12</label>
																			</div>
																			<div class="margin">
																				<input class="J3check_13" value="13" id="J3check_13"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ3check_13" for="J3check_13">13</label> <input
																					class="J3check_14" value="14" id="J3check_14" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_14" for="J3check_14">14</label> <input
																					class="J3check_15" value="15" id="J3check_15" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_15" for="J3check_15">15</label> <input
																					class="J3check_16" value="16" id="J3check_16" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_16" for="J3check_16">16</label> <input
																					class="J3check_17" value="17" id="J3check_17" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_17" for="J3check_17">17</label> <input
																					class="J3check_18" value="18" id="J3check_18" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_18" for="J3check_18">18</label>
																			</div>
																			<div class="margin">
																				<input class="J3check_19" value="19" id="J3check_19"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ3check_19" for="J3check_19">19</label> <input
																					class="J3check_20" value="20" id="J3check_20" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_20" for="J3check_20">20</label> <input
																					class="J3check_21" value="21" id="J3check_21" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_21" for="J3check_21">21</label> <input
																					class="J3check_22" value="22" id="J3check_22" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_22" for="J3check_22">22</label> <input
																					class="J3check_23" value="23" id="J3check_23" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_23" for="J3check_23">23</label> <input
																					class="J3check_24" value="24" id="J3check_24" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_24" for="J3check_24">24</label>
																			</div>
																			<div class="margin">
																				<input class="J3check_25" value="25" id="J3check_25"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ3check_25" for="J3check_25">25</label> <input
																					class="J3check_26" value="26" id="J3check_26" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_26" for="J3check_26">26</label> <input
																					class="J3check_27" value="27" id="J3check_27" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_27" for="J3check_27">27</label> <input
																					class="J3check_28" value="28" id="J3check_28" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_28" for="J3check_28">28</label> <input
																					class="J3check_29" value="29" id="J3check_29" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_29" for="J3check_29">29</label> <input
																					class="J3check_30" value="30" id="J3check_30" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_30" for="J3check_30">30</label>
																			</div>
																			<div class="margin">
																				<input class="J3check_31" value="31" id="J3check_31"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ3check_31" for="J3check_31">31</label> <input
																					class="J3check_32" value="32" id="J3check_32" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_32" for="J3check_32">32</label> <input
																					class="J3check_33" value="33" id="J3check_33" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_33" for="J3check_33">33</label> <input
																					class="J3check_34" value="34" id="J3check_34" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_34" for="J3check_34">34</label> <input
																					class="J3check_35" value="35" id="J3check_35" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ3check_35" for="J3check_35">35</label>
																			</div>											
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-12">
																			<div class="footer-single-right">
																				<button type="button" id="J3clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																	
																</div>
															</div>
															<div class="box-content-detail">
																<h5>Tus números son</h5>
																<textarea class="current-numbers" id="J3-text-area" readonly="readonly"></textarea>
															</div>
														</div>
														<div class="box-play-main box-play-d" style="display: none">
															<div class="content-single-game">
																<div class="top-single-game">
																	<h3>JUGADA D <span>Marca 6 bolillas o más</span></h3>
																</div>
																<div class="body-single-game">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">
																			<div class="margin">
																				<input class="J4check_1" value="1" id="J4check_1" name="check"
																				type="checkbox"><label class="check_" for="J4check_1"
																				id="LJ4check_1">1</label> <input class="J4check_2" value="2"
																				id="J4check_2" name="check" type="checkbox"><label
																				class="check_" id="LJ4check_2" for="J4check_2">2</label> <input
																				class="J4check_3" value="3" id="J4check_3" name="check"
																				type="checkbox"><label class="check_" id="LJ4check_3"
																				for="J4check_3">3</label> <input class="J4check_4" value="4"
																				id="J4check_4" name="check" type="checkbox"><label
																				class="check_" id="LJ4check_4" for="J4check_4">4</label> <input
																				class="J4check_5" value="5" id="J4check_5" name="check"
																				type="checkbox"><label class="check_" id="LJ4check_5"
																				for="J4check_5">5</label> <input class="J4check_6" value="6"
																				id="J4check_6" name="check" type="checkbox"><label
																				class="check_" id="LJ4check_6" for="J4check_6">6</label>
																			</div>
																			<div class="margin">
																					<input class="J4check_7" value="7" id="J4check_7" name="check"
																					type="checkbox"><label class="check_" id="LJ4check_7"
																					for="J4check_7">7</label> <input class="J4check_8" value="8"
																					id="J4check_8" name="check" type="checkbox"><label
																					class="check_" id="LJ4check_8" for="J4check_8">8</label> <input
																					class="J4check_9" value="9" id="J4check_9" name="check"
																					type="checkbox"><label class="check_" id="LJ4check_9"
																					for="J4check_9">9</label> <input class="J4check_10"
																					value="10" id="J4check_10" name="check" type="checkbox"><label
																					class="check_" id="LJ4check_10" for="J4check_10">10</label> <input
																					class="J4check_11" value="11" id="J4check_11" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_11" for="J4check_11">11</label> <input
																					class="J4check_12" value="12" id="J4check_12" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_12" for="J4check_12">12</label>
																			</div>
																			<div class="margin">
																				<input class="J4check_13" value="13" id="J4check_13"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ4check_13" for="J4check_13">13</label> <input
																					class="J4check_14" value="14" id="J4check_14" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_14" for="J4check_14">14</label> <input
																					class="J4check_15" value="15" id="J4check_15" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_15" for="J4check_15">15</label> <input
																					class="J4check_16" value="16" id="J4check_16" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_16" for="J4check_16">16</label> <input
																					class="J4check_17" value="17" id="J4check_17" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_17" for="J4check_17">17</label> <input
																					class="J4check_18" value="18" id="J4check_18" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_18" for="J4check_18">18</label>
																			</div>
																			<div class="margin">
																				<input class="J4check_19" value="19" id="J4check_19"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ4check_19" for="J4check_19">19</label> <input
																					class="J4check_20" value="20" id="J4check_20" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_20" for="J4check_20">20</label> <input
																					class="J4check_21" value="21" id="J4check_21" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_21" for="J4check_21">21</label> <input
																					class="J4check_22" value="22" id="J4check_22" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_22" for="J4check_22">22</label> <input
																					class="J4check_23" value="23" id="J4check_23" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_23" for="J4check_23">23</label> <input
																					class="J4check_24" value="24" id="J4check_24" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_24" for="J4check_24">24</label>
																			</div>
																			<div class="margin">
																					<input class="J4check_25" value="25" id="J4check_25"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ4check_25" for="J4check_25">25</label> <input
																					class="J4check_26" value="26" id="J4check_26" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_26" for="J4check_26">26</label> <input
																					class="J4check_27" value="27" id="J4check_27" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_27" for="J4check_27">27</label> <input
																					class="J4check_28" value="28" id="J4check_28" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_28" for="J4check_28">28</label> <input
																					class="J4check_29" value="29" id="J4check_29" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_29" for="J4check_29">29</label> <input
																					class="J4check_30" value="30" id="J4check_30" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_30" for="J4check_30">30</label>
																			</div>
																			<div class="margin">
																					<input class="J4check_31" value="31" id="J4check_31"
																					name="check" type="checkbox"><label class="check_"
																					id="LJ4check_31" for="J4check_31">31</label> <input
																					class="J4check_32" value="32" id="J4check_32" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_32" for="J4check_32">32</label> <input
																					class="J4check_33" value="33" id="J4check_33" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_33" for="J4check_33">33</label> <input
																					class="J4check_34" value="34" id="J4check_34" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_34" for="J4check_34">34</label> <input
																					class="J4check_35" value="35" id="J4check_35" name="check"
																					type="checkbox"><label class="check_"
																					id="LJ4check_35" for="J4check_35">35</label>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-12">
																			<div class="footer-single-right">
																				<button type="button" id="J4clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																	
																</div>
															</div>
															<div class="box-content-detail">
																<h5>Tus números son</h5>
																<textarea class="current-numbers" id="J4-text-area" readonly="readonly"></textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-6">
												<div class="box-wrapper-game box-content-right">
													<div class="box-content-game">
														<div class="current-games">
															<div class="boxes-current-games clearfix">
																<div data-game="a" class="box-current-game game-playing">
																	<a href="#">A</a>
																</div>
																<div data-game="b" class="box-current-game">
																	<a href="#">B</a>
																</div>
																<div data-game="c" class="box-current-game">
																	<a href="#">C</a>
																</div>
																<div data-game="d" class="box-current-game">
																	<a href="#">D</a>
																</div>
															</div>
														</div>
														<div class="current-game-detail">
															<div class="row">
																<div class="col-4">
																	<h5>Boleto<br> v&aacute;lido para</h5>
																</div>
																<div class="col-4">
																	<div class="selectBoxCotejo selectBox">

																		<c:forEach items="${GanadiarioValoresBoleto}" var="num" begin="0" end="0">
																			<div class="box" id="box">${num}</div> 
																		</c:forEach>

																		<select  name="model" id="mySelectBox" 																	onChange="valChange(this);">
																		<c:forEach items="${GanadiarioValoresBoleto}" var="cantBoleto" >
																			<option value="${cantBoleto}">${cantBoleto}</option>
																		</c:forEach>
																		</select>
																		
																		
																	</div>


			
																</div>
																<div class="col-4">
																	<span>sorteo (s)</span>

																</div>
															</div>
															
															
															<div class="main-box-detail noleft">
																<div class="row">
																	<div class="col-3">
																		<h5>Desde</h5>
																	</div>
																	<div class="col-9">

																		<div class="selectBox">
																			<c:forEach items="${ganadiarioSaleList}" var="ganadiarioSaleList" begin="0" end="0">
																		   		<div class="box" id="box-2">${ganadiarioSaleList.id.drawId} el ${ganadiarioSaleList.drCloseDate}</div> 
																		   	</c:forEach>
																		   
																			<select  name="model" id="mySelectBox-2" onChange="valChange(this);">
																			<c:forEach items="${ganadiarioSaleList}" var="ganadiarioSaleList" >
																				<option value="${ganadiarioSaleList.id.drawId}">${ganadiarioSaleList.id.drawId} el ${ganadiarioSaleList.drCloseDate}</option>
																			</c:forEach>
																			</select>
																		</div>
																	</div>
																</div>
															</div>
															<div class="main-box-detail noleft">
																<div class="row">
																	<div class="col-3">
																		<h5>Hasta</h5>
																	</div>
																	<div class="col-9">
																		<div class="selectBox">
																			<div class="fechaCant">
																				<div class="checkcotent">
																		 			<c:forEach items="${ganadiarioSaleList}" var="ganadiarioSaleList" begin="0" end="0">
																				     <span id="fechaCotejo">${ganadiarioSaleList.id.drawId}</span>
																				     </c:forEach>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>

															<div class="action-buy">
<!-- 																<button id="buy" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"><b>COTEJAR</b></button> -->
																<button id="btn_desktop_cotejar_boleto_ganadiario" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"><b>COTEJAR</b></button>
															</div>

														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>	
					</div>
					<div id="cotejoKabala"">
						<input type="hidden" id="jugadaCompletaKabala">
						<div id="valorJugada"></div>
						<div id="movefoot" class="footer-single-game" style="display:none">
							<div>
								<div class="action-buy volver-a-cotejar">
									<button id="more_plays" type="button" class="button button-lg button-no-shadow button-block button-orange button-green-new">
									<b>REGRESAR</b>
									</button>
									<button onclick="datalayerJuegaAqui();window.parent.location.href='juega-ganadiario.html'" type="button" class="button button-lg button-no-shadow button-block button-red-juega button-red-new">
									<b>JUEGA AQU&Iacute;</b>
									</button>
								</div>
					</div>
				</div>
			</div>
		</div>
</div>

	
				
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
	<script type='text/javascript'
		src='layer-view-script/common/jquery.scripts.js'></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
		<script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
	<script type='text/javascript'
		src='layer-view-script/game/ganadiario/lotto-ganadiario-cotejador.js?v=5'></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.carouFredSel.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
	
		<script>
	function addbull(){
		var $bux = $('.current-numbers');
		for (var a=0;a<$bux.length;a++){
			if($bux.eq(a).val()){
				$('.box-current-game').eq(a).addClass('game-played');		
			}			
		}	
	}
	
	$('.box-current-game a').on('click',function(e){
		e.preventDefault();
	    var $this = $(this);
		var game = $this.closest('.box-current-game').attr('data-game');
		$('.box-current-game').removeClass('game-playing');
		$this.closest('.box-current-game').addClass('game-playing');
		addbull();
		$('.box-play-main').hide();
		console.log('.box-play-'+game);
		$('.box-play-'+game).show();
		if(dataLayerlimpiar)
			datalayerPaso2Cotejar( 'Jugada ' + game.toUpperCase() );
	});

	$("#more_plays").on('click', function(e){
		
		datalayerJuegoJugadaIntencion(obtenerJugadasCotejadas(),'Regresar','REGRESAR');
		
	});

	function datalayerJuegaAqui(){
		datalayerJuegoJugadaIntencion(obtenerJugadasCotejadas(),'Jugar','JUEGA AQUI');
	}

	function obtenerJugadasCotejadas(){
		var jugadasTexto = [];
		$(".body-single-game .button-group.checkboxes-ball").each(function() {
	        var textoH3 = $(this).find('h3').text();
	        if( textoH3.includes('JUGADA') )
	        	jugadasTexto.push(textoH3);
	    });
	    return jugadasTexto.join(", ");
	}
	
	</script>
	
</body>
</html>