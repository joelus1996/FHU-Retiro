<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLottoSale == true && isFechazaSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=fechaza"/></c:if>
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
	<meta http-equiv="Content-Type" content="Juega en línea la única lotería que se sortea todos los días !" name="description">
	<title>Fechaza</title>
	<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/fechaza/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/fechaza/themeFechaza.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
	
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
</head>
<body >
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


<%@ include file="../../include/header.jspf" %>

<div id='main-content-background'>
<div id='main-content' class="group">

<%@ include file="../../include/menu.jspf" %>

<div id="fechaza">
    	<input type="hidden" id="fechazaSimplePrice" value="${fechazaSale.simpleBetPrice}">
    	<input type="hidden" id="fechazaNumbersMore" value="${fechazaSale.numbersMore}">
    	<input type="hidden" id="fechazaNumbersLess" value="${fechazaSale.numbersLess}">
        <input type="hidden" id="status" value="${fechazaSale.status}">
		<div class="bann_fechaza">
			<div id="center-text">
				<div id="premio"> Gana hasta 15,000</div>
				<div id="aviso">veces tu apuesta</div>
			</div>
			<div id="hora-juego">
			  	<div id="center-text-time">Juégalo cada 5 minutos desde las 6:00 am hasta 2:00 am del día siguiente</div>
			</div>
		</div>		
		<div class="transition-one" id="panel-transition"> <div id="table-of-prize"></div></div>
		<a id ="help" href="https://latinkaportal.com.pe/" target="_black"></a>   
        <div class="font-play">
        <div class="zona-juego">
            <div class="linear">
                <div id="part1">
                    <div class="left">
                        <div class="text-play">JUGADA 1</div>
                        <div class="play-content"  >
                            <div class="choose-top">
                            </div>	
                            <div class="choose-apuesta">
                                <!-- div class="text-number">Marcar 1 casilla o m&aacute;s,<br> c/u S/.0.50</div -->
                                <div class="text-number">Marcar 1 casilla,<br> c/u S/ 1.00</div>
                                <div style='padding-left:20px;padding-top: 5px;'>
                                    <div class="botom option" rel="off" id="1F" style="width:95px;margin-bottom: 5px;">D&iacute;a / Mes / A&ntilde;o</div>
                                    <div class="botom option" rel="off" id="2F" style="width:95px;margin-bottom: 5px;">D&iacute;a / Mes</div>
                                    <div class="botom option" rel="off" id="3F" style="width:95px;margin-bottom: 5px;" >D&iacute;a</div>
                                    <div class="botom option" rel="off" id="4F" style="width:95px;margin-bottom: 5px;" >Mes</div>
                                    <div class="botom option" rel="off" id="5F" style="width:95px;margin-bottom: 5px;" >A&ntilde;o</div>
                                </div>
                                <div class="text-number" >Multplica tu premio por:<br>(opcional). Marca 1 casilla</div> 


                                <div id="multiply-prize" style="padding-top: 6px;margin-left:3px;">
                                    <div class="margin">

                                        <div class="botom multi-item" id="1X" rel="off">2</div>
                                        <div class="botom multi-item" id="4X" rel="off">4</div>
                                        <div class="botom multi-item" id="6X" rel="off">6</div>
                                        <div class="botom multi-item" id="8X" rel="off">8</div>
                                        <div class="botom multi-item" id="10X" rel="off">10</div>

                                    </div>

                                    <div class="margin">
                                        <div class="botom multi-item" id="20X" rel="off">20</div>
                                        <div class="botom multi-item" id="30X" rel="off">30</div>
                                        <div class="botom multi-item" id="40X" rel="off">40</div>
                                        <div class="botom multi-item" id="50X" rel="off">50</div>
                                        <div class="botom multi-item" id="60X" rel="off">60</div>
                                    </div>

                                    <div class="margin">
                                        <div class="botom multi-item" id="70X" rel="off">70</div>
                                        <div class="botom multi-item" id="80X" rel="off">80</div>
                                        <div class="botom multi-item" id="90X" rel="off">90</div>
                                        <div class="botom multi-item" id="100X" rel="off">100</div>

                                    </div>

                                </div>

                            </div>

                            <div class="choose-numeros">							
                                <div class="choose-numeros-left" >

                                    <div class="choose-number-top" >
                                        <div style='padding-bottom: 5px; padding-top: 5px; '>
                                            <span class="text-number" style="padding-left:0px;" >Marcar las casillas correspondientes seg&uacute;n tu tipo de apuesta </span>
                                        </div>	

                                        <div class="day-area" >

                                            <div class="title-number title-number2" id="title-day" style="width: 201px;height: 17px;padding-top: 4px;" >	
                                                D&Iacute;A
                                            </div>
                                            <div >
                                                <!-- div class="text-number text-number2" id="text-day" style="padding-left:0px;margin-top: 27px;" >Marca una casilla o m&aacute;s</div -->
                                                <div class="text-number text-number2" id="text-day" style="padding-left:0px;margin-top: 27px;" >Marca una casilla</div>
                                            </div>
                                            <div class="container" >
                                                <div class="margin" style="padding:0px">
                                                    <div class="botom day-number botom2" id="1D" rel="off">1</div>
                                                    <div class="botom day-number botom2" id="2D" rel="off">2</div>
                                                    <div class="botom day-number botom2" id="3D" rel="off">3</div>
                                                    <div class="botom day-number botom2" id="4D" rel="off">4</div>
                                                    <div class="botom day-number botom2" id="5D" rel="off">5</div>
                                                    <div class="botom day-number botom2" id="6D" rel="off">6</div>
                                                    <div class="botom day-number botom2" id="7D" rel="off">7</div>
                                                    <div class="botom day-number botom2" id="8D" rel="off">8</div>



                                                </div>
                                                <div class="margin" style="padding:0px">

                                                    <div class="botom day-number botom2" id="9D" rel="off">9</div>
                                                    <div class="botom day-number botom2" id="10D" rel="off">10</div>
                                                    <div class="botom day-number botom2" id="11D" rel="off">11</div>
                                                    <div class="botom day-number botom2" id="12D" rel="off">12</div>
                                                    <div class="botom day-number botom2" id="13D" rel="off">13</div>
                                                    <div class="botom day-number botom2" id="14D" rel="off">14</div>
                                                    <div class="botom day-number botom2" id="15D" rel="off">15</div>
                                                    <div class="botom day-number botom2" id="16D" rel="off">16</div>


                                                </div>
                                                <div class="margin" style="padding:0px">
                                                    <div class="botom day-number botom2" id="17D" rel="off">17</div>
                                                    <div class="botom day-number botom2" id="18D" rel="off">18</div>
                                                    <div class="botom day-number botom2" id="19D" rel="off">19</div>
                                                    <div class="botom day-number botom2" id="20D" rel="off">20</div>
                                                    <div class="botom day-number botom2" id="21D" rel="off">21</div>
                                                    <div class="botom day-number botom2" id="22D" rel="off">22</div>
                                                    <div class="botom day-number botom2" id="23D" rel="off">23</div>
                                                    <div class="botom day-number botom2" id="24D" rel="off">24</div>


                                                </div>
                                                <div class="margin" style="padding:0px">
                                                    <div class="botom day-number botom2" id="25D" rel="off">25</div>
                                                    <div class="botom day-number botom2" id="26D" rel="off">26</div>
                                                    <div class="botom day-number botom2" id="27D" rel="off">27</div>
                                                    <div class="botom day-number botom2" id="28D" rel="off">28</div>
                                                    <div class="botom day-number botom2" id="29D" rel="off">29</div>
                                                    <div class="botom day-number botom2" id="30D" rel="off">30</div>
                                                    <div class="botom day-number botom2" id="31D" rel="off">31</div>
                                                </div>

                                            </div>

                                        </div>


                                        <div class="month-area">
                                            <div class="title-number title-number2" id="title-month" style="width: 81px;height: 17px;padding-top: 4px;margin-bottom: 4px;" >	
                                                MES
                                            </div>
                                            <!-- div class="text-number text-number2" id="text-month" style="line-height: 9px;margin-left: -6px;margin-bottom: -3px;" >Marca una casilla o m&aacute;s</div -->
                                            <div class="text-number text-number2" id="text-month" style="line-height: 9px;margin-left: -6px;margin-bottom: -3px;" >Marca una casilla<br/><br/></div>
                                            <div class="container">	

                                                <div class="margin" style="padding:0px">

                                                    <div class="botom month-number botom2" id="1M" rel="off">1</div>
                                                    <div class="botom month-number botom2" id="2M" rel="off">2</div>
                                                    <div class="botom month-number botom2" id="3M" rel="off">3</div>
                                                </div>

                                                <div class="margin" style="padding:0px">              
                                                    <div class="botom month-number botom2" id="4M" rel="off">4</div>
                                                    <div class="botom month-number botom2" id="5M" rel="off">5</div>
                                                    <div class="botom month-number botom2" id="6M" rel="off">6</div>
                                                </div>

                                                <div class="margin" style="padding:0px">
                                                    <div class="botom month-number botom2" id="7M" rel="off">7</div>
                                                    <div class="botom month-number botom2" id="8M" rel="off">8</div>
                                                    <div class="botom month-number botom2" id="9M" rel="off">9</div>
                                                </div>

                                                <div class="margin" style="padding:0px">					
                                                    <div class="botom month-number botom2" id="10M" rel="off">10</div>
                                                    <div class="botom month-number botom2" id="11M" rel="off">11</div>
                                                    <div class="botom month-number botom2" id="12M" rel="off">12</div>
                                                </div>
                                            </div>	
                                        </div>


                                    </div>



                                    <div class="year-area">

                                        <div class="title-number title-number2" id="title-year" style="width: 299px;height: 17px;padding-top: 4px;" >	
                                            A&Ntilde;O
                                        </div>

                                        <div>
                                            <!-- span class="text-number text-number2" id="text-year"  style="padding-left:0px;float: left;width: 300px;margin-top: 3px;" >Marca 1 casilla en cada fila. M&aacute;ximo 2 para una m&uacuteltiple </span -->
                                            <span class="text-number text-number2" id="text-year"  style="padding-left:0px;float: left;width: 300px;margin-top: 3px;" >Marca 1 casilla en cada fila.</span>
                                        </div>

                                        <div class="container">		
                                            <div class="margin" style="padding:0px">

                                                <div class="botom year-number botom2" id="0Y" rel="off">0</div>
                                                <div class="botom year-number botom2" id="1Y" rel="off">1</div>
                                                <div class="botom year-number botom2" id="2Y" rel="off">2</div>
                                                <div class="botom year-number botom2" id="3Y" rel="off">3</div>
                                                <div class="botom year-number botom2" id="4Y" rel="off">4</div>
                                                <div class="botom year-number botom2" id="5Y" rel="off">5</div>
                                                <div class="botom year-number botom2" id="6Y" rel="off">6</div>
                                                <div class="botom year-number botom2" id="7Y" rel="off">7</div>
                                                <div class="botom year-number botom2" id="8Y" rel="off">8</div>
                                                <div class="botom year-number botom2" id="9Y" rel="off">9</div>

                                            </div>

                                            <div class="margin" style="padding:0px">
                                                <div class="botom year-number2 botom2" id="0YT" rel="off">0</div>
                                                <div class="botom year-number2 botom2" id="1YT" rel="off">1</div>
                                                <div class="botom year-number2 botom2" id="2YT" rel="off">2</div>
                                                <div class="botom year-number2 botom2" id="3YT" rel="off">3</div>
                                                <div class="botom year-number2 botom2" id="4YT" rel="off">4</div>
                                                <div class="botom year-number2 botom2" id="5YT" rel="off">5</div>
                                                <div class="botom year-number2 botom2" id="6YT" rel="off">6</div>
                                                <div class="botom year-number2 botom2" id="7YT" rel="off">7</div>
                                                <div class="botom year-number2 botom2" id="8YT" rel="off">8</div>
                                                <div class="botom year-number2 botom2" id="9YT" rel="off">9</div>
                                            </div>
                                        </div>	


                                    </div>

                                </div>


                                <div class="separate-textarea-number">

                                    <div class="height-div">
                                        <span class="text-number-marcado">Tus n&#250;meros son:</span>
                                        <div class="attribute-textarea"></div>
                                    </div>

                                    <div class="separate-textarea-bottuns">
                                        <div class="attribute-button"> 
                                            <div class="azar">  <img src="layer-view-image/game/fechaza/flecha-f.gif" height="5" width="5" class="icon" /><span class="text">Al azar</span></div>
                                        </div> 				
                                        <div class="separate-bottun"></div> 
                                        <div class="attribute-button" id="clear"> 
                                            <div class="clear">  <img src="layer-view-image/game/fechaza/flecha-f.gif" height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
                                        </div>  
                                        <div class="separate-bottun"></div> 
                                        <div class="attribute-button" id="numbersMore"> 
                                            <img src="layer-view-image/game/fechaza/flecha-f.gif" height="5" width="5" class="icon" /><span class="text">M&#225;s salieron</span>
                                        </div>  																												
                                        <div class="separate-bottun"></div> 
                                        <div class="attribute-button" id="numbersLess"> 
                                            <img src="layer-view-image/game/fechaza/flecha-f.gif" height="5" width="5" class="icon" /><span class="text">Menos salieron</span>
                                        </div>  						
                                    </div>		

                                </div>

                            </div>	


                        </div>


                    </div>


                </div>

				
	<div style="clear: both;padding-top: 20px;padding-left: 16px;padding-bottom: 4px;height: 20px;">			
	<div class='text-sorteos'>Elige en cu&aacute;ntos sorteos consecutivos jugar&aacute;s:</div>			
	<div style="float: left;width: 126px;height: 20px;">			
	<div class="selectBox">
		 <c:forEach items="${fechazaSaleList}" var="fechazaData" begin="0" end="0">
		   <div class="box" id="box">${fechazaData.messageDraw}</div> 
	   </c:forEach>
		 <select  name="model" id="mySelectBox"	onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
	
		<c:forEach items="${fechazaSaleList}" var="fechazaDrawData" >
			<option value="${fechazaDrawData.numDraws}">${fechazaDrawData.messageDraw}</option>
		</c:forEach>
	
		</select>
	</div>
	
	
	
	</div>			
	</div>			
            </div>   <!-- fin de linear-->

	<!-- div class="panel_jugar" -->
	<!-- div class="content-panel-jugar" -->
	<div class="font">
		<div class="center">
			<div class="color-text">
				<div><span id='price-message'>${fechazaSale.priceMessage}</span> | Total de apuestas <span id="comb">0</span></div>
				<div class="bold-type">Total: S/ <span id="total-game">0</span> | <span id="premio-game">Gana hasta S/ <span id='num-apuestas'>15,000</span></span></div>
			</div>
			<!-- div class="buttom-panel-jugar"><div class="button-buy-off" id="btn-jugar" ></div></div -->
			<div id="buy-panel" class="buttom-panel-jugar"><a href="#" class="button-buy" id='btn-jugar' onclick="return false;"></a></div>
		</div>
	</div>    
    <div class="foot-panel-game">Todos los premios estaran afectos al 10% de dscto. por concepto de impuestos y deducciones de ley municipal.</div>
</div>

	<div class="finalize-purchase" style="display:none;">    
    <div id='content-purchase'>
        <div class='left-panel'>
            <span class='label_1'>FECHAZA</span>
            <div id="content-grid-result"></div>
            <div id="num_link"></div>
        </div>
        <div class='right-panel'>
            <div class='label_2'>dd/mm/yy</div>
            <div class="result_purchase">
                <div class="label_resu1">TOTAL A PAGAR </div>
                <div class="label_resu2">${fechazaSale.priceMessage}</div>  
                <div class="label_resu3"></div>
                <!-- div class="label_resu4"></div -->
                <div class="result1">S/ 0.00</div>
            </div>
             <div id="panel_more_plays"><a href="#" class="class_more_plays" id='more_plays' onclick="return false;"></a></div>
             <div id="panel_keep-playing"><a href="juega-fechaza.html" class="class-keep-playing" id='keep-playing'></a></div>
             <div id="panel_game-history"><a href="mi-cuenta.html#jugadas" class="class-game-history" id='game-history'></a></div>
        </div>
        <div id="sub_purchase">
        <div id="sub_panel">
          
          	<div id="login_section">
            <div class="label1">LOGIN: Ingresa a tu cuenta para realizar tu pago.</div>
            <div>
            <form id="frmLoginClient">
            <table border='0'>
            <tr>
            	<td><span class='label-login'>Usuario:</span></td>
				<td><input id='user-client' type='text' name='user-client' class='text-pass'></td>
				<td><span class='label-login'>Contrase&ntilde;a</span></td>
				<td><input id='password-client' type="password" name='password-client' class='text-pass'></td>
				<td><input type="submit" value="Ingresar" class="button-ingresar" id="home-btnlogin"></td>
            </tr>
            </table>
            </form>
            </div>
            <div class="label2"><a href="#">¿Olvidaste tu usuario?</a> | <a href="restablecer.html">¿Olvidaste tu Contrase&ntilde;a?</a> </div>         
            
            </div>
          
          
			<form id="frmLoadBalance">
            <div id="payments_section">
                <div id="pan_0">
                	<div class="label1">PAGAR</div>
              		<table>
              		<tr>
                        <td><input type="radio" name="option-card" checked="checked" value="0" id="option-card-0"></td>
       			        <td>
       			        	<label for="option-card-0"><span>Quiero descontar de mi saldo disponible S/ </span><span id="field-balance-amount">${fechazaSale.balanceAmount}</span></label>
       						<br>       						
       					</td>
                       </tr>
              		</table>
             </div>
            <div id="separator_hr"></div>
			<div id="pan_1">
				<div class="label2">RECARGAS POR INTERNET</div>
				<table>
			<c:forTokens var="channel1Order" items="${fechazaSale.channel1Order}" delims=",">
				<%@ include file="../../include/balance1.jspf"%>
			</c:forTokens>
			</table>
			<div class="label2">RECARGAS F&Iacute;SICAS</div>
			<table>
			<c:forTokens var="channel2Order" items="${fechazaSale.channel2Order}" delims=",">
				<%@ include file="../../include/balance2.jspf"%>
			</c:forTokens>
			</table>
			</div>
			<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div>
            </div>
			</form>
        </div>
     <!-- div class="btn_finaliza_compra" id="btn_finaliza_compra"></div -->
     <div id="panel_finaliza_compra"><a href="#" class="btn_finaliza_compra" id='btn_finaliza_compra' onclick="return false;"></a></div>
       </div>
    </div>
    <div id="ico-block">
	    <div id="ico-title">&iexcl;SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
	    <div id="ico-panel">
			<a href="juega-tinka.html" class="button-icotinka" id='icotinka'></a>
			<a href="juega-kabala.html" class="button-icokabala" id='icokabala'></a>
			<a href="juega-ganadiario.html" class="button-icoganadiario" id='icoganadiario'></a>
			<a href="juega-kinelo.html" class="button-icokinelo" id='icokinelo'></a>
			<a onclick="toTAV2();" class="button-icoteapuesto hand" id='icoteapuesto'></a>
			<a href="juega-ganagol.html" class="button-icoganagol" id='icoganagol'></a>
			<!-- a href="juega-clicygana.html" class="button-icoclicygana" id='icoclicygana'></a -->
			<!-- a href="juega-deportesvirtuales.html" class="button-icodeportesvirtuales" id='icodeportesvirtuales'></a -->
			<!-- a href="juega-super3.html" class="button-icosuper3" id='icosuper3'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/reventon" class="button-icoelreventon" id='icoelreventon'></a -->
			<!-- a href="juega-rapitinkas.html" class="button-icorapitinkas" id='icorapitinkas'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/instantaneas" class="button-icorapigana" id='icorapigana'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/giromagico" class="button-icogiromagico" id='icogiromagico'></a -->
			<!-- a href="juega-fechaza.html" class="button-icofechaza" id='icofechaza'></a --> 
		</div> 
    </div>
    <div class="img_zona_segura"></div>
    
    
</div>




        </div>   <!-- fin de font-play-->

</div> <!-- fin del div contiene a todo  -->

<iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width = "300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>

<%@ include file="../../include/footer.jspf" %>

</div>

</div>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type='text/javascript' src='layer-view-script/game/fechaza/lotto-fechaza.js'></script>
<script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>

</body>
</html>


