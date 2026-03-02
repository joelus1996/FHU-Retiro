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
	href="layer-view-style/game/ganagol/themeCotejador.css" />
<link media="screen" rel="stylesheet" type="text/css"
 href="layer-view-style/game/ganagol/themeGanagol.css?v=1">	
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
	
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript"
		src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript"
		src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>	
<%--<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>--%>

<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />
<link rel="stylesheet" href="layer-view-style/v2/estilos.css" type="text/css" />

<script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
<script type="text/javascript"
		src="layer-view-script/game/ganagol/lotto-ganagol-cotejador.js?v=4"></script>
		
			
<script type="text/javascript">
		var valorCombo="";
        function valChange(obj) {
		var valorCombo= obj.parentNode.getElementsByTagName('div')[0].innerHTML=obj.options[obj.selectedIndex].text;
		valorCombo=valorCombo.substring(0,4);
		partidosDraw(valorCombo);
        }
		
		function teamValueTable(){
		var posicion=document.getElementById('mySelectBox-2').options.selectedIndex;
		valorTeam=document.getElementById('mySelectBox-2').options[posicion].text; 
		valorTeam=valorTeam.substring(0,4);
		partidosDraw(valorTeam);
		}
</script>
	
</head>

<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->



<input type="hidden" value="ACT" id="status">
<input type="hidden" value="${ganagolSale.priceType}" id="priceType">
<input type="hidden" value="${ganagolSale.simpleBetPrice}" id="simpleBetPrice">
<input type="hidden" value="${ganagolSale.promotionType}" id="promotionType">
<input type="hidden" value="${ganagolSale.balanceAmount}" disabled="disabled" class="visible" id="balanceAmount">
<input type="hidden" value="${ganagolSale.balanceAmountGame}" id="balanceAmountGame">
<input type="hidden" value="${ganagolSale.algorithm}" id="algorithm">
<input type="hidden" value="${ganagolSale.bets}" id="bets">
<input type="hidden" value="${ganagolSale.pay}" id="pay">
<input type="hidden" value="${ganagolSale.draws}" id="draws">
<input type="hidden" value="${ganagolSale.cost}" id="cost">
<input type="hidden" value="${ganagolSale.prize}" id="prize">

<style>
	.row.container {
	    top: 0px;
	}
	#valorJugadaCotejo {
	    margin-top: 20px;
	    margin-bottom: 20px;
	    height: calc(75vh);
	    max-height: calc(75vh);
	}
	.kabala_jugada_acerts .cotejador {
	    position: relative;
	    margin-left: 5px;
	    margin-top: 0px !important;
	}
	#cotejo-panel {
	    float: none;
	    display: inline-block;
	}
	#cotejar {
	    text-align: center;
	}
	.content_jugada .container {
	    top: 0;
	}
    .ganagol_cotejador .logo_kabala_cotejador img {
        position: relative;
        top: 12px;
    }
    .ganagol_cotejador .logo_kabala_cotejador {
        margin-bottom: 7px;
        font-family: AllerBold, Arial, sans-serif;
        font-size: 16px;
        color: #e12728;
        line-height: 0px;
        margin-top: -20px;
        text-transform: uppercase;
    }
    .headerGanagolCotejador {
        position: relative;
        border: solid 1px #cacaca;
        border-radius: 10px;
        padding: 10px;
        margin: 15px;
    }
    .validarform .selectBox {
	    float: right;
	    background: white;
	    height: 30px;
	    /* padding-top: 25px !important; */
	}
    .validarform:after {
        content: '';
        display: table;
        clear: both;
    }
    .validarform span {
	    float: left;
	    margin-right: 6px;
	    font-weight: 700;
	    position: relative;
	    top: 6px;
	    font-size: 14px;
	}
    .validarform {
	    float: left;
	    margin-right: 10px;
	    position: relative;
	    top: 6px;
	    z-index:2;
	}
    .jugadaTitle h2 {
    	margin: 0px;
    	font-size: 20px;
    	text-transform: uppercase;
	}
    .headerGanagolCotejador:after {
        content: '';
        display: table;
        clear: both;
    } 
    .box-current-game.game-playing a {
        color: white !important;
        background: #357427;
        border-color: #357427;
    }
    .box-current-game a:hover {
        color: #357427;
        border-color: #357427;
    }
    .box-current-game a {
        text-decoration: none;
        font-size: 20px;
        padding: 5px 10px;
        display: block;
        border: solid 1px #a7a7a7;
        border-radius: 7px;
        color: #a7a7a7;
        font-weight: 700;
        margin: 0px 2px;
    }
    .box-current-game {
        float: left;
    }
    .game-box {
        position: relative;
    	z-index: 3;
    	float: right;
    }  
    .validarform .selectBox .box {
	    font-size: 12px;
	    font-family: AllerRegular, Arial, sans-serif;
	    top: 6px;
	}
    .jugadaTitle {
        position: absolute;
        top: 16px;
        text-align: center;
        width: 100%;
        color: #e12728;
    }
    .col-md-4 {
	    width: 195px;
	    float: right;
	    padding-right: 0px;
	}
    .content_jugada {
        border: solid 1px #cacaca;
        border-radius: 10px;
    }
    .linear-collator {
        float: none;
    }
    .font-cotejador {
        position: relative;
        top: 0px;
        width: 100%;
        left: 0px;
        margin: 10px 0px;
        background: transparent;
    }
    .col-md-8 {
        width: 403px;
        float: left;
    }
    .row.marginextra {
	    margin-left: 0px;
	    margin-right: 0px;
	}
	#cotejo {
	    padding-top: 10px;
	    padding-left: 5px;
	    padding-bottom: 10px;
	}
	#cotejo:after {
	    content: '';
	    width: 393px;
	    height: 100%;
	    border: solid 1px #cacaca;
	    border-radius: 10px;
	    position: absolute;
	    top: 0;
	    left: 15px;
	    pointer-events: none;	    
	}
	.action-buy.footcotejar {
	    text-align: center;
	}
	.action-buy.footcotejar button {
	    display: inline-block;
	    width: auto;
	}
	.content_jugada {
	    padding-top: 40px;
	}
	.content_jugada .margin {
	    height: 29px;
	}
	.content_jugada .margin label {
	    background: white !important;
	    height: 20px !important;
	    width: 44px !important;
	    margin-right: 1px;
	}
	.content_jugada .margin label.colorChecked {
	    background: #357427 !important;
	    border-color: #357427 !important;
	    color: white !important;
	}
	.align-clear-btn {
	    margin-top: 10px;
	    margin-bottom: 10px;
	    width: 80%;
	    display: inline-block;
	    background: #4d4d4d;
	    border-radius: 10px;
	    padding: 5px;
	    font-size: 16px;
	    color: white;
	}
	.attribute-button {
	    width: 100%;
	    text-align: center;
	    background: transparent !important;
	    text-align: center;
	    height: auto;
	}
	.linear-collator label {
	    background: -moz-linear-gradient(top, #f9f9f9 0%, #c7c6c2 100%);
	    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#f9f9f9), to(#c7c6c2));
	    background: -webkit-linear-gradient(top, #f9f9f9 0%, #c7c6c2 100%);
	    background: -o-linear-gradient(top, #f9f9f9 0%, #c7c6c2 100%);
	    background: -ms-linear-gradient(top, #f9f9f9 0%, #c7c6c2 100%);
	    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#f9f9f9, endColorstr=#c7c6c2, gradientType=0);
	    display: inline-block;
	    width: 17px;
	    height: 17px;
	    color: #646462;
	    cursor: pointer;
	    font-size: 10px;
	    border-color: #c0bcb9;
	    border-radius: 5px;
	    text-align: center;
	    line-height: 17px;
	    font-weight: bold;
	    border: 1px solid #c0bcb9;
	}
	.box-current-game.game-played a {
	    border-color: #357427;
	    color: #357427;
	}
	.linear-collator input[type=checkbox] {
	    left: 8px;
	    position: absolute;
	    top: 5px;
	    z-index: -999;
	}
	.modal-ganadiario .main-play .top-single-game h3 {
	    color: #3c6b34;
	}
	
</style>

<div class="row cotenedor_kabala_cotejador modal-kabala modal-ganadiario">
    <div class="col-12 col-md-8">
        <div class="main-panel">
            <div class="main-play modal-coteja-boleto modal-kabala" style="width: 613px">
                <div class="cotejaGG">
                    <div class="ganagol_cotejador">
                        <div class="logo_kabala_cotejador" id="kabala-cotejo-logo">
                           <img src="layer-view-image/game/ganagol/premios-logo-ganagol.jpg" title="Ganagol" alt="Ganagol"> Coteja tu ganagol y entérate si ganaste un premio
                        </div>
                        <div class="headerGanagolCotejador">
                            <div class="validarform">
                                <span>PROGRAMA</span>
                                <div class="selectBox">
                                    <c:forEach items="${GanagolSaleList}" var="GanagolSaleList" begin="0" end="0">
                                       <div class="box" id="box">${GanagolSaleList.id.drawId} del ${GanagolSaleList.drCloseDate}</div> 
                                    </c:forEach>  

                                    <select  name="model" id="mySelectBox-2" 
                                        onChange="valChange(this);">
                                        <c:forEach items="${GanagolSaleList}" var="GanagolSaleList" >
                                            <option value="${GanagolSaleList.id.drawId}">${GanagolSaleList.id.drawId} del ${GanagolSaleList.drCloseDate}</option>
                                        </c:forEach>
                                    </select>                    
                                </div>
                            </div>
                            <div class="jugadaTitle">
                                <h2>Jugada 01</h2>
                            </div>
                            <div class="game-box">
                                <div class="current-games">
                                    <div class="boxes-current-games clearfix">
                                        <div data-game="primer-part-collator" class="box-current-game game-playing" data-name="jugada 01">
                                            <a href="#">01</a>
                                        </div>
                                        <div data-game="segunda-part-collator" class="box-current-game" data-name="jugada 02">
                                            <a href="#">02</a>
                                        </div>
                                        <div data-game="tercera-part-collator" class="box-current-game" data-name="jugada 03">
                                            <a href="#">03</a>
                                        </div>
                                        <div data-game="cuarta-part-collator" class="box-current-game" data-name="jugada 04">
                                            <a href="#">04</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="row marginextra">
                        <div class="col-md-8 ">
                            <div id="cotejo">
                                <input type="hidden" id="jugadaCompletaKabala">
                                <div id="valorEquipo"></div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="content_jugada">
                                <div class="linear-collator" id="primer-part-collator">    
                                    <div class="container">
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_1" value="L" data-row="0" data-col="0" class="check"><label for="J1check_1" id="LJ1check_1" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_2" value="E" data-row="0" data-col="1" class="check"><label for="J1check_2" id="LJ1check_2" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_3" value="V" data-row="0" data-col="2" class="check"><label for="J1check_3" id="LJ1check_3" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_4" value="L" data-row="1" data-col="0" class="check"><label id="LJ1check_4" for="J1check_4" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_5" value="E" data-row="1" data-col="1" class="check"><label for="J1check_5" id="LJ1check_5" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_6" value="V" data-row="1" data-col="2" class="check"><label for="J1check_6" id="LJ1check_6" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_7" value="L" data-row="2" data-col="0" class="check"><label for="J1check_7" id="LJ1check_7" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_8" value="E" data-row="2" data-col="1" class="check"><label for="J1check_8" id="LJ1check_8" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_9" value="V" data-row="2" data-col="2" class="check"><label for="J1check_9" id="LJ1check_9" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_10" value="L" data-row="3" data-col="0" class="check"><label for="J1check_10" id="LJ1check_10" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_11" value="E" data-row="3" data-col="1" class="check"><label for="J1check_11" id="LJ1check_11" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_12" value="V" data-row="3" data-col="2" class="check"><label for="J1check_12" id="LJ1check_12" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_13" value="L" data-row="4" data-col="0" class="check"><label for="J1check_13" id="LJ1check_13" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_14" value="E" data-row="4" data-col="1" class="check"><label for="J1check_14" id="LJ1check_14" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_15" value="V" data-row="4" data-col="2" class="check"><label for="J1check_15" id="LJ1check_15" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_16" value="L" data-row="5" data-col="0" class="check"><label for="J1check_16" id="LJ1check_16" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_17" value="E" data-row="5" data-col="1" class="check"><label for="J1check_17" id="LJ1check_17" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_18" value="V" data-row="5" data-col="2" class="check"><label for="J1check_18" id="LJ1check_18" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_19" value="L" data-row="6" data-col="0" class="check"><label for="J1check_19" id="LJ1check_19" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_20" value="E" data-row="6" data-col="1" class="check"><label for="J1check_20" id="LJ1check_20" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_21" value="V" data-row="6" data-col="2" class="check"><label for="J1check_21" id="LJ1check_21" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_22" value="L" data-row="7" data-col="0" class="check"><label for="J1check_22" id="LJ1check_22" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_23" value="E" data-row="7" data-col="1" class="check"><label for="J1check_23" id="LJ1check_23" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_24" value="V" data-row="7" data-col="2" class="check"><label for="J1check_24" id="LJ1check_24" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_25" value="L" data-row="8" data-col="0" class="check"><label for="J1check_25" id="LJ1check_25" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_26" value="E" data-row="8" data-col="1" class="check"><label for="J1check_26" id="LJ1check_26" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_27" value="V" data-row="8" data-col="2" class="check"><label for="J1check_27" id="LJ1check_27" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_28" value="L" data-row="9" data-col="0" class="check"><label for="J1check_28" id="LJ1check_28" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_29" value="E" data-row="9" data-col="1" class="check"><label for="J1check_29" id="LJ1check_29" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_30" value="V" data-row="9" data-col="2" class="check"><label for="J1check_30" id="LJ1check_30" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_31" value="L" data-row="10" data-col="0" class="check"><label for="J1check_31" id="LJ1check_31" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_32" value="E" data-row="10" data-col="1" class="check"><label for="J1check_32" id="LJ1check_32" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_33" value="V" data-row="10" data-col="2" class="check"><label for="J1check_33" id="LJ1check_33" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_34" value="L" data-row="11" data-col="0" class="check"><label for="J1check_34" id="LJ1check_34" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_35" value="E" data-row="11" data-col="1" class="check"><label for="J1check_35" id="LJ1check_35" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_36" value="V" data-row="11" data-col="2" class="check"><label for="J1check_36" id="LJ1check_36" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_37" value="L" data-row="12" data-col="0" class="check"><label for="J1check_37" id="LJ1check_37" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_38" value="E" data-row="12" data-col="1" class="check"><label for="J1check_38" id="LJ1check_38" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_39" value="V" data-row="12" data-col="2" class="check"><label for="J1check_39" id="LJ1check_39" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J1check" id="J1check_40" value="L" data-row="13" data-col="0" class="check"><label for="J1check_40" id="LJ1check_40" class="check_">L</label>
                                            <input type="checkbox" name="J1check" id="J1check_41" value="E" data-row="13" data-col="1" class="check"><label for="J1check_41" id="LJ1check_41" class="check_">E</label>
                                            <input type="checkbox" name="J1check" id="J1check_42" value="V" data-row="13" data-col="2" class="check"><label for="J1check_42" id="LJ1check_42" class="check_">V</label>
                                        </div>
                                    </div>
                                    <div class="attribute-button">
                                        <div class="clear align-clear-btn btnClean" id="J1clear">
                                            Limpiar
                                        </div>
                                    </div>
                                </div>
                                <div class="linear-collator" id="segunda-part-collator" style="display:none">    
                                    <div class="container">
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_1" value="L" data-row="0" data-col="0" class="check"><label id="LJ2check_1" for="J2check_1" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_2" value="E" data-row="0" data-col="1" class="check"><label for="J2check_2" id="LJ2check_2" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_3" value="V" data-row="0" data-col="2" class="check"><label for="J2check_3" id="LJ2check_3" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_4" value="L" data-row="1" data-col="0" class="check"><label id="LJ2check_4" for="J2check_4" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_5" value="E" data-row="1" data-col="1" class="check"><label for="J2check_5" id="LJ2check_5" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_6" value="V" data-row="1" data-col="2" class="check"><label for="J2check_6" id="LJ2check_6" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_7" value="L" data-row="2" data-col="0" class="check"><label for="J2check_7" id="LJ2check_7" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_8" value="E" data-row="2" data-col="1" class="check"><label for="J2check_8" id="LJ2check_8" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_9" value="V" data-row="2" data-col="2" class="check"><label for="J2check_9" id="LJ2check_9" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_10" value="L" data-row="3" data-col="0" class="check"><label for="J2check_10" id="LJ2check_10" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_11" value="E" data-row="3" data-col="1" class="check"><label for="J2check_11" id="LJ2check_11" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_12" value="V" data-row="3" data-col="2" class="check"><label for="J2check_12" id="LJ2check_12" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_13" value="L" data-row="4" data-col="0" class="check"><label for="J2check_13" id="LJ2check_13" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_14" value="E" data-row="4" data-col="1" class="check"><label for="J2check_14" id="LJ2check_14" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_15" value="V" data-row="4" data-col="2" class="check"><label for="J2check_15" id="LJ2check_15" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_16" value="L" data-row="5" data-col="0" class="check"><label for="J2check_16" id="LJ2check_16" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_17" value="E" data-row="5" data-col="1" class="check"><label for="J2check_17" id="LJ2check_17" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_18" value="V" data-row="5" data-col="2" class="check"><label for="J2check_18" id="LJ2check_18" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_19" value="L" data-row="6" data-col="0" class="check"><label for="J2check_19" id="LJ2check_19" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_20" value="E" data-row="6" data-col="1" class="check"><label for="J2check_20" id="LJ2check_20" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_21" value="V" data-row="6" data-col="2" class="check"><label for="J2check_21" id="LJ2check_21" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_22" value="L" data-row="7" data-col="0" class="check"><label for="J2check_22" id="LJ2check_22" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_23" value="E" data-row="7" data-col="1" class="check"><label for="J2check_23" id="LJ2check_23" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_24" value="V" data-row="7" data-col="2" class="check"><label for="J2check_24" id="LJ2check_24" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_25" value="L" data-row="8" data-col="0" class="check"><label for="J2check_25" id="LJ2check_25" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_26" value="E" data-row="8" data-col="1" class="check"><label for="J2check_26" id="LJ2check_26" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_27" value="V" data-row="8" data-col="2" class="check"><label for="J2check_27" id="LJ2check_27" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_28" value="L" data-row="9" data-col="0" class="check"><label for="J2check_28" id="LJ2check_28" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_29" value="E" data-row="9" data-col="1" class="check"><label for="J2check_29" id="LJ2check_29" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_30" value="V" data-row="9" data-col="2" class="check"><label for="J2check_30" id="LJ2check_30" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_31" value="L" data-row="10" data-col="0" class="check"><label for="J2check_31" id="LJ2check_31" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_32" value="E" data-row="10" data-col="1" class="check"><label for="J2check_32" id="LJ2check_32" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_33" value="V" data-row="10" data-col="2" class="check"><label for="J2check_33" id="LJ2check_33" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_34" value="L" data-row="11" data-col="0" class="check"><label for="J2check_34" id="LJ2check_34" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_35" value="E" data-row="11" data-col="1" class="check"><label for="J2check_35" id="LJ2check_35" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_36" value="V" data-row="11" data-col="2" class="check"><label for="J2check_36" id="LJ2check_36" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_37" value="L" data-row="12" data-col="0" class="check"><label for="J2check_37" id="LJ2check_37" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_38" value="E" data-row="12" data-col="1" class="check"><label for="J2check_38" id="LJ2check_38" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_39" value="V" data-row="12" data-col="2" class="check"><label for="J2check_39" id="LJ2check_39" class="check_">V</label>
                                                </div>
                                                <div class="margin">
                                                    <input type="checkbox" name="J2check" id="J2check_40" value="L" data-row="13" data-col="0" class="check"><label for="J2check_40" id="LJ2check_40" class="check_">L</label>
                                                    <input type="checkbox" name="J2check" id="J2check_41" value="E" data-row="13" data-col="1" class="check"><label for="J2check_41" id="LJ2check_41" class="check_">E</label>
                                                    <input type="checkbox" name="J2check" id="J2check_42" value="V" data-row="13" data-col="2" class="check"><label for="J2check_42" id="LJ2check_42" class="check_">V</label>
                                                </div>
                                    </div>
                                    <div class="attribute-button">
                                        <div class="clear align-clear-btn btnClean" id="J2clear">
                                            Limpiar
                                        </div>
                                    </div>                                
                                </div>
                                <div class="linear-collator" id="tercera-part-collator" style="display:none">    
                                    <div class="container">
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_1" value="L" data-row="0" data-col="0" class="check"><label id="LJ3check_1" for="J3check_1" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_2" value="E" data-row="0" data-col="1" class="check"><label for="J3check_2" id="LJ3check_2" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_3" value="V" data-row="0" data-col="2" class="check"><label for="J3check_3" id="LJ3check_3" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_4" value="L" data-row="1" data-col="0" class="check"><label id="LJ3check_4" for="J3check_4" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_5" value="E" data-row="1" data-col="1" class="check"><label for="J3check_5" id="LJ3check_5" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_6" value="V" data-row="1" data-col="2" class="check"><label for="J3check_6" id="LJ3check_6" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_7" value="L" data-row="2" data-col="0" class="check"><label for="J3check_7" id="LJ3check_7" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_8" value="E" data-row="2" data-col="1" class="check"><label for="J3check_8" id="LJ3check_8" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_9" value="V" data-row="2" data-col="2" class="check"><label for="J3check_9" id="LJ3check_9" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_10" value="L" data-row="3" data-col="0" class="check"><label for="J3check_10" id="LJ3check_10" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_11" value="E" data-row="3" data-col="1" class="check"><label for="J3check_11" id="LJ3check_11" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_12" value="V" data-row="3" data-col="2" class="check"><label for="J3check_12" id="LJ3check_12" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_13" value="L" data-row="4" data-col="0" class="check"><label for="J3check_13" id="LJ3check_13" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_14" value="E" data-row="4" data-col="1" class="check"><label for="J3check_14" id="LJ3check_14" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_15" value="V" data-row="4" data-col="02" class="check"><label for="J3check_15" id="LJ3check_15" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_16" value="L" data-row="5" data-col="0" class="check"><label for="J3check_16" id="LJ3check_16" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_17" value="E" data-row="5" data-col="1" class="check"><label for="J3check_17" id="LJ3check_17" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_18" value="V" data-row="5" data-col="2" class="check"><label for="J3check_18" id="LJ3check_18" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_19" value="L" data-row="6" data-col="0" class="check"><label for="J3check_19" id="LJ3check_19" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_20" value="E" data-row="6" data-col="1" class="check"><label for="J3check_20" id="LJ3check_20" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_21" value="V" data-row="6" data-col="2" class="check"><label for="J3check_21" id="LJ3check_21" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_22" value="L" data-row="7" data-col="0" class="check"><label for="J3check_22" id="LJ3check_22" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_23" value="E" data-row="7" data-col="1" class="check"><label for="J3check_23" id="LJ3check_23" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_24" value="V" data-row="7" data-col="2" class="check"><label for="J3check_24" id="LJ3check_24" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_25" value="L" data-row="8" data-col="0" class="check"><label for="J3check_25" id="LJ3check_25" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_26" value="E" data-row="8" data-col="1" class="check"><label for="J3check_26" id="LJ3check_26" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_27" value="V" data-row="8" data-col="2" class="check"><label for="J3check_27" id="LJ3check_27" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_28" value="L" data-row="9" data-col="0" class="check"><label for="J3check_28" id="LJ3check_28" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_29" value="E" data-row="9" data-col="1" class="check"><label for="J3check_29" id="LJ3check_29" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_30" value="V" data-row="9" data-col="2" class="check"><label for="J3check_30" id="LJ3check_30" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_31" value="L" data-row="10" data-col="0" class="check"><label for="J3check_31" id="LJ3check_31" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_32" value="E" data-row="10" data-col="1" class="check"><label for="J3check_32" id="LJ3check_32" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_33" value="V" data-row="10" data-col="2" class="check"><label for="J3check_33" id="LJ3check_33" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_34" value="L" data-row="11" data-col="0" class="check"><label for="J3check_34" id="LJ3check_34" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_35" value="E" data-row="11" data-col="1" class="check"><label for="J3check_35" id="LJ3check_35" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_36" value="V" data-row="11" data-col="2" class="check"><label for="J3check_36" id="LJ3check_36" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_37" value="L" data-row="12" data-col="0" class="check"><label for="J3check_37" id="LJ3check_37" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_38" value="E" data-row="12" data-col="1" class="check"><label for="J3check_38" id="LJ3check_38" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_39" value="V" data-row="12" data-col="2" class="check"><label for="J3check_39" id="LJ3check_39" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J3check" id="J3check_40" value="L" data-row="13" data-col="0" class="check"><label for="J3check_40" id="LJ3check_40" class="check_">L</label>
                                            <input type="checkbox" name="J3check" id="J3check_41" value="E" data-row="13" data-col="1" class="check"><label for="J3check_41" id="LJ3check_41" class="check_">E</label>
                                            <input type="checkbox" name="J3check" id="J3check_42" value="V" data-row="13" data-col="2" class="check"><label for="J3check_42" id="LJ3check_42" class="check_">V</label>
                                        </div>
                                    </div>
                                    <div class="attribute-button">
                                        <div class="clear align-clear-btn btnClean" id="J3clear">
                                            Limpiar
                                        </div>
                                    </div>  
                                </div>
                                <div class="linear-collator" id="cuarta-part-collator" style="display:none">    
                                    <div class="container">
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_1" value="L" data-row="0" data-col="0" class="check"><label id="LJ4check_1" for="J4check_1" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_2" value="E" data-row="0" data-col="1" class="check"><label for="J4check_2" id="LJ4check_2" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_3" value="V" data-row="0" data-col="2" class="check"><label for="J4check_3" id="LJ4check_3" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_4" value="L" data-row="1" data-col="0" class="check"><label id="LJ4check_4" for="J4check_4" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_5" value="E" data-row="1" data-col="1" class="check"><label for="J4check_5" id="LJ4check_5" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_6" value="V" data-row="1" data-col="2" class="check"><label for="J4check_6" id="LJ4check_6" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_7" value="L" data-row="2" data-col="0" class="check"><label for="J4check_7" id="LJ4check_7" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_8" value="E" data-row="2" data-col="1" class="check"><label for="J4check_8" id="LJ4check_8" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_9" value="V" data-row="2" data-col="2" class="check"><label for="J4check_9" id="LJ4check_9" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_10" value="L" data-row="3" data-col="0" class="check"><label for="J4check_10" id="LJ4check_10" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_11" value="E" data-row="3" data-col="1" class="check"><label for="J4check_11" id="LJ4check_11" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_12" value="V" data-row="3" data-col="2" class="check"><label for="J4check_12" id="LJ4check_12" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_13" value="L" data-row="4" data-col="0" class="check"><label for="J4check_13" id="LJ4check_13" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_14" value="E" data-row="4" data-col="1" class="check"><label for="J4check_14" id="LJ4check_14" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_15" value="V" data-row="4" data-col="2" class="check"><label for="J4check_15" id="LJ4check_15" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_16" value="L" data-row="5" data-col="0" class="check"><label for="J4check_16" id="LJ4check_16" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_17" value="E" data-row="5" data-col="1" class="check"><label for="J4check_17" id="LJ4check_17" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_18" value="V" data-row="5" data-col="2" class="check"><label for="J4check_18" id="LJ4check_18" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_19" value="L" data-row="6" data-col="0" class="check"><label for="J4check_19" id="LJ4check_19" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_20" value="E" data-row="6" data-col="1" class="check"><label for="J4check_20" id="LJ4check_20" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_21" value="V" data-row="6" data-col="2" class="check"><label for="J4check_21" id="LJ4check_21" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_22" value="L" data-row="7" data-col="0" class="check"><label for="J4check_22" id="LJ4check_22" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_23" value="E" data-row="7" data-col="1" class="check"><label for="J4check_23" id="LJ4check_23" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_24" value="V" data-row="7" data-col="2" class="check"><label for="J4check_24" id="LJ4check_24" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_25" value="L" data-row="8" data-col="0" class="check"><label for="J4check_25" id="LJ4check_25" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_26" value="E" data-row="8" data-col="1" class="check"><label for="J4check_26" id="LJ4check_26" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_27" value="V" data-row="8" data-col="2" class="check"><label for="J4check_27" id="LJ4check_27" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_28" value="L" data-row="9" data-col="0" class="check"><label for="J4check_28" id="LJ4check_28" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_29" value="E" data-row="9" data-col="1" class="check"><label for="J4check_29" id="LJ4check_29" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_30" value="V" data-row="9" data-col="2" class="check"><label for="J4check_30" id="LJ4check_30" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_31" value="L" data-row="10" data-col="0" class="check"><label for="J4check_31" id="LJ4check_31" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_32" value="E" data-row="10" data-col="1" class="check"><label for="J4check_32" id="LJ4check_32" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_33" value="V" data-row="10" data-col="2" class="check"><label for="J4check_33" id="LJ4check_33" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_34" value="L" data-row="11" data-col="0" class="check"><label for="J4check_34" id="LJ4check_34" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_35" value="E" data-row="11" data-col="1" class="check"><label for="J4check_35" id="LJ4check_35" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_36" value="V" data-row="11" data-col="2" class="check"><label for="J4check_36" id="LJ4check_36" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_37" value="L" data-row="12" data-col="0" class="check"><label for="J4check_37" id="LJ4check_37" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_38" value="E" data-row="12" data-col="1" class="check"><label for="J4check_38" id="LJ4check_38" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_39" value="V" data-row="12" data-col="2" class="check"><label for="J4check_39" id="LJ4check_39" class="check_">V</label>
                                        </div>
                                        <div class="margin">
                                            <input type="checkbox" name="J4check" id="J4check_40" value="L" data-row="13" data-col="0" class="check"><label for="J4check_40" id="LJ4check_40" class="check_">L</label>
                                            <input type="checkbox" name="J4check" id="J4check_41" value="E" data-row="13" data-col="1" class="check"><label for="J4check_41" id="LJ4check_41" class="check_">E</label>
                                            <input type="checkbox" name="J4check" id="J4check_42" value="V" data-row="13" data-col="2" class="check"><label for="J4check_42" id="LJ4check_42" class="check_">V</label>
                                        </div>
                                    </div>
                                    <div class="attribute-button">
                                        <div class="clear align-clear-btn btnClean" id="J4clear">
                                            Limpiar
                                        </div>
                                    </div>                
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="wrapper-footer-playing" id="box-content-game-collate">
											<div class="box-wrapper-game" id="box-wrapper-game-gg">
												<div class="box-content-game" >
													<div class="box-play-main box-play-primer-part-collator">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game">																	
																	<div class="left-extra-game">
																		<div class="content-left-extra">
																			<label for="J1-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">Marca el rango de gol</span><br />
																		<span class="value-extra-game">si lo elegiste en tu compra</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix">
																	<label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J1check_43"
																		id="LJ1check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J1check_44"
																		id="LJ1check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J1check_45"
																		id="LJ1check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J1check_46"
																		id="LJ1check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J1check_47"
																		id="LJ1check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J1check_48"
																		id="LJ1check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J1check_49"
																		id="LJ1check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J1check_50"
																		id="LJ1check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J1check_51"
																		id="LJ1check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J1check_52"
																		id="LJ1check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-segunda-part-collator" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game">																	
																	<div class="left-extra-game">
																		<div class="content-left-extra">
																			<label for="J2-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">Marca el rango de gol</span><br />
																		<span class="value-extra-game">si lo elegiste en tu compra</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix">
																	<label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J2check_43"
																		id="LJ2check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J2check_44"
																		id="LJ2check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J2check_45"
																		id="LJ2check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J2check_46"
																		id="LJ2check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J2check_47"
																		id="LJ2check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J2check_48"
																		id="LJ2check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J2check_49"
																		id="LJ2check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J2check_50"
																		id="LJ2check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J2check_51"
																		id="LJ2check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J2check_52"
																		id="LJ2check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-tercera-part-collator" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game">
																	<div class="left-extra-game">
																		<div class="content-left-extra">
																			<label for="J3-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">Marca el rango de gol</span><br />
																		<span class="value-extra-game">si lo elegiste en tu compra</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix">
																	<label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J3check_43"
																		id="LJ3check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J3check_44"
																		id="LJ3check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J3check_45"
																		id="LJ3check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J3check_46"
																		id="LJ3check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J3check_47"
																		id="LJ3check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J3check_48"
																		id="LJ3check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J3check_49"
																		id="LJ3check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J3check_50"
																		id="LJ3check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J3check_51"
																		id="LJ3check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J3check_52"
																		id="LJ3check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-cuarta-part-collator" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game">
																	<div class="left-extra-game">
																		<div class="content-left-extra">
																			<label for="J4-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">Marca el rango de gol</span><br />
																		<span class="value-extra-game">si lo elegiste en tu compra</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix">
																	<label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J4check_43"
																		id="LJ4check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J4check_44"
																		id="LJ4check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J4check_45"
																		id="LJ4check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J4check_46"
																		id="LJ4check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J4check_47"
																		id="LJ4check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J4check_48"
																		id="LJ4check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J4check_49"
																		id="LJ4check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J4check_50"
																		id="LJ4check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J4check_51"
																		id="LJ4check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J4check_52"
																		id="LJ4check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
												</div>
											</div>
										</div>
                    
                    
                    <div class="font-cotejador" id="cotejar">
                        <div class="center">
                            <div id="cotejo-panel">
                            	<div class="action-buy">
<!-- 									<button id="buy" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"> -->
<!-- 										<b>COTEJAR</b> -->
<!-- 									</button> -->
									<button id="btn_desktop_cotejar_boleto_ganagol" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange">
										<b>COTEJAR</b>
									</button>
								</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="jugadaCotejo">
                    <input type="hidden" id="jugadaCompletaKabala">
                    <div id="valorJugadaCotejo" class="" ></div>
                    <div class="action-buy footcotejar" style="display:none">
                    	<h3>¡Profe, recuerda que hay premios desde los 10 aciertos!</h3>
						<button id="more_plays" type="button" class="button button-lg button-no-shadow button-block button-orange button-green-new"><b>REGRESAR</b><button onclick="datalayerJuegaAqui();window.parent.location.href='juega-ganagol.html'" type="button" class="button button-lg button-no-shadow button-block button-red-juega button-red-new"><b>JUEGA AQU&Iacute;</b></button></button>
					</div>
                </div>
            </div>
        </div>
    </div>
</div>
	
		
	<script type="text/javascript">
		teamValueTable();
	</script>
	<script>
	function addbull(){
		var $bux = $('.linear-collator');
		for (var a=0;a<$bux.length;a++){
			var $input = $bux.eq(a).find('input');
			for (var b=0;b<$input.length;b++) {
				if($input.eq(b).is(':checked')){
					$('.box-current-game').eq(a).addClass('game-played');		
				}	
			}			
		}	
	}
	
	$('.box-current-game a').on('click',function(e){
		e.preventDefault();
	    var $this = $(this);
		var game = $this.closest('.box-current-game').attr('data-game');
		game='#'+game;
		var name = $this.closest('.box-current-game').attr('data-name');		
		//$('.box-current-game').removeClass('game-playing');
		//$this.closest('.box-current-game').addClass('game-playing');
		addbull();
		$('.jugadaTitle h2').html(name);
		$('.linear-collator').hide();
		$(game).show();
	});

	$('.button-group.checkboxes-ball').on('click', '.check', function() {
        if ($(this).siblings('span.button-group-item').hasClass('colorChecked')) {
            var valorDelInput = $(this).val();
            datalayerPaso2Cotejar(valorDelInput);
        }
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