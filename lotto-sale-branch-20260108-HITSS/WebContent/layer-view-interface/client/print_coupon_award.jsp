<%--
<p> NAME:    print_coupon.jsp
</p>
<p> VERSION LOG
<pre>
VER   BY				DATE        COMMENT
001   cristian.cortez	27/02/2013  First comment
</pre>
</p>
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/taglibs.jspf"%>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta name="viewport" content="width=1024">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<title>La Tinka | Impresión tickets</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<link rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"/>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>" ></script>  

<style type="text/css">
.option-item {
	float: left;
	padding: 4px 0 0 5px;
	margin: 0;
	border: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: bold;
	color: #808080;
	line-height: 5px;
}

.option-box {
	float: left;
	margin: 0 0 0 448px;
}
.grid-block div a.form-button_print {
	float: left;
	width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-imprimir-off.png) top left
		no-repeat;
	margin: 0 0 0 480px;
	padding: 0;
	border: 0;
}

.grid-block div a.form-button_print:hover {
	background: url(layer-view-image/common/btn-imprimir-over.png) top left
		no-repeat;
}

.grid-block div a.form-button_send {
	float: left;
	width: 118px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-enviar-a-correo-off.png) top
		left no-repeat;
	margin: 0 0 0 19px;
	padding: 0;
	border: 0;
}

.grid-block div a.form-button_send:hover {
	background: url(layer-view-image/common/btn-enviar-a-correo-over.png)
		top left no-repeat;
}
/*******/
.margen_option div a#form_balance {
	display:block;
	width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-cargar-saldo-off.png);
	margin: 10px 0 0 0;
	padding: 0;
	border: 0;
	z-index: 1;
	/*position: absolute;*/
}

.margen_option div a#form_balance:hover {
	background: url(layer-view-image/common/btn-cargar-saldo-over.png);
}


.margen_option div span.form_activar{
	cursor:pointer;
	width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-activar-codigo-off.png);
	margin: 6px 0 0 0;
	padding: 0;
	border: 0;
	z-index: 1;
	position: absolute;
}
.margen_option div span.form_activar:hover {
	background: url(layer-view-image/common/btn-activar-codigo-over.png);
}


.margen_option div a.form_print{
	margin: 6px 0 0 0;
    width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-imprimir-off.png);
	padding: 0;
	border: 0;
	z-index: 1;
	position: absolute;
	float: left;
}

.margen_option div a.form_print:hover {
    background: url(layer-view-image/common/btn-imprimir-over.png)
}


.margen_option div a#form_charge, .margen_option a#form_charge {
    display: block;
	width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-cobrar-en-linea-off.png);
	margin: 10px 0 0 0;
	padding: 0;
	border: 0;
	z-index: 1
}

.margen_option div a#form_charge:hover, .margen_option a#form_charge:hover {
	background: url(layer-view-image/common/btn-cobrar-en-linea-over.png)
}


/**********/


.content-box {
	display: block;
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
	border: 0;
}

.content-box-data {
	display: block;
	padding: 0;
	margin: 0;
	border: 0;
}

.grid-block {
	float: left;
	width: 740px;
	height: auto;/*66px;*/
	padding: 14px 0 0 0;
	margin: 0;
	border: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	text-align: center;
}

.part1_check_on {
	margin-left: 0px;
}

.part1_check_off {
	margin-left: 360px;
	position: absolute;
	top: 80px;
	width: 360px;
}

.option-box_on {
	float: left;
	margin: 0 0 0 300px;
}

.grid-block div a.form-button_print_on {
	float: left;
	width: 80px;
	height: 22px;
	text-decoration: none;
	background: url(layer-view-image/common/btn-imprimir-off.png) top left
		no-repeat;
	margin: 0 0 0 330px;
	padding: 0;
	border: 0;
}

.award {
	-pie-background: linear-gradient(top, #f9f9f9 45%, #c7c6c2 100%);
	background: -moz-linear-gradient(top, #f9f9f9 45%, #c7c6c2 100%);
	background: -webkit-gradient(linear, 0% 45%, 0% 100%, from(#f9f9f9),
		to(#c7c6c2) );
	background: -webkit-linear-gradient(top, #f9f9f9 45%, #c7c6c2 100%);
	background: -o-linear-gradient(top, #f9f9f9 45%, #c7c6c2 100%);
	background: -ms-linear-gradient(top, #f9f9f9 45%, #c7c6c2 100%);
	width: 270px;
	height: 590px;
	margin-left: 7px;
	top: 12px;
	border-color: #8B8989;
	border-radius: 5px;
	border: 1px double #8B8989;
	position: relative;
	behavior: url(layer-view-script/common/PIE/PIE.htc);
}

.part_1 {
	width: 269px;
	height: 43px;
	background: #8B8989;
	color: #FFF;
	border-radius: 5px 5px 0px 0px;
	border-color: #8B8989;
	border: 1px double #8B8989;
	font-weight: bold;
	font-family: arial;
	font-size: 12px;
	behavior: url(layer-view-script/common/PIE/PIE.htc);
}

.option {
	position: relative;
	top:-3px;
	/*line-height: 20px;*/
	margin-left: 6px;
	font-weight: bold;
}

.margen_option {
	margin-bottom: 9px;
}

.margen_option .bolded {
    font-weight:bold;
}

.margen_option .justified {
    text-align:justify;
    margin: 8px 0;
}

#option_1 {
	/*width: 219px;*/
	margin-left: 20px;
	/*height: 70px;
	margin-bottom: -8px;*/
	line-height: 12px;
	text-align: justify;
}

#option_2 {
	/*width: 219px;*/
	margin-left: 20px;
	/*height: 220px;*/
	line-height: 12px;
	text-align: justify;
}

#option_3 {
	/*width: 219px;*/
	margin-left: 20px;
	line-height: 12px;
	text-align: justify;
}

#option_4 {
	/*width: 219px;*/
	margin-left: 20px;
	line-height: 12px;
	text-align: justify;
}

#option_5 {
	/*width: 219px;*/
	margin-left: 20px;
	line-height: 12px;
	text-align: justify;
}

.cerrar a {
    background: url("layer-view-image/common/btn-cerrar-off.png") no-repeat scroll left top #F99631;
    float: left;
    height: 20px;
    text-decoration: none;
    width: 58px;
    border-radius : 4px;
}
.cerrar a:hover {
    background: url("layer-view-image/common/btn-cerrar-over.png") no-repeat scroll left top #F9A144;
}


.contenedor {
	color: #5A5A5A; font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: normal; /*position: relative; top: 15px;17px;*/ margin: 9px 13px 0 13px;/*10px;*/
}
	
.contenedor input[type="radio"]{margin:4px 0 0 0;padding:0;}
	
	/****input-texto*/
 .text-number{
 	background-color: #F1F8FF;
	border: 1px solid #ACD4FF;
	border-radius: 5px 5px 5px 5px;
	color: #818181;
	font-size: 11px;
	height: 12px;
	margin: 7px 0 0;
	padding: 7px;
	width: 80px;
	behavior: url(layer-view-script/common/PIE/PIE.htc);
}

.text-nopdf {
    width: 320px;
    margin: 5px 0 5px 340px;
    padding: 0;
    display: inline-block;
}
	
	/*******/
</style>

<!--[if (IE 7) | (IE 8)]>
<style>
.award{
	-pie-background: linear-gradient(top,  #f9f9f9 45%, #c7c6c2 100%);
    background: -moz-linear-gradient(top,  #f9f9f9 45%, #c7c6c2 100%);
	background: -webkit-gradient(linear, 0% 45%, 0% 100%, from(#f9f9f9), to(#c7c6c2));
	background: -webkit-linear-gradient(top,  #f9f9f9 45%, #c7c6c2 100%);
	background: -o-linear-gradient(top,  #f9f9f9 45%, #c7c6c2 100%);
	background: -ms-linear-gradient(top,  #f9f9f9 45%, #c7c6c2 100%);
	
	width: 265px;
	height: 590px;
	margin-left: 5px;
	top: -65px;
	border-color:#c0bcb9;
	border-radius:5px;
	border: 1px double #c0bcb9;
	position: relative;
	behavior:url(layer-view-script/common/PIE/PIE.htc);
	
		}
   .contenedor{
			color: #5A5A5A; 
			font-family: arial; 
			font-size: 11px; 
			font-weight: bold; 
			position: relative; 
			top: 50px; 
			margin-left: 10px;	
	}
     .text-number{
	 	background-color: #F1F8FF;
	    border: 1px solid #ACD4FF;
	    border-radius: 5px 5px 5px 5px;
	    color: #818181;
	    font-size: 11px;
	    height: 15px;
	    margin: 10px 0 0;
	    padding: 7px;
	    width: 80px;
	    position:absolute;
	    z-index=1;
		behavior: url(layer-view-script/common/PIE/PIE.htc);
	}
 </style>
<![endif]-->

<script type="text/javascript">
	<%String htmlTextS = "";
			if (request.getAttribute("htmlText") != null)
				htmlTextS = (String) request.getAttribute("htmlText");
			session.removeAttribute("htmlTextS");
			session.setAttribute("htmlTextS", htmlTextS);
			%>
	var ctTwDefinePrize = '<%=request.getAttribute("ctTwDefinePrize")%>';
	function doClose() {	
		window.close();
	}
	
	function printCoupon2(){
		  var b = /MSIE/.test(navigator.userAgent);
		if(b) {
					document.coupon.focus();
					document.coupon.print();  
				} else {				
					window.frames['coupon'].focus();
					window.frames['coupon'].print();}}
	
	function printCoupon() {
			if(($("#opcion1").is(':checked')) || ( ( $("#opcion2").is(':checked'))  || ($("#opcion3").is(':checked')) )  ){
                var b = /MSIE/.test(navigator.userAgent);
				 if (b) {
					document.coupon.focus();
					document.coupon.print();
				 } else {
					window.frames['coupon'].focus();
					window.frames['coupon'].print();
                }	
			} else {			
    			jPrint("Para tu seguridad el código de barras sólo se mostrará en \n caso tu boleto este premiado y hayas elegido la opción de \n 	cobrar tu premio en el Punto de Venta.", null,function(r){if(r){printCoupon2();}})
            }									
	}
	
	function doOnload() {
		try {
			if(ctTwDefinePrize == 2){
			 $("#numberPhone").attr('disabled','disabled'); 
				$("#opcion3").attr('checked',false);
				$("#opcion1").attr('checked',false); }				
		 		var htmlText = "<%=htmlTextS%>";
			//var doc = window.frames["coupon"].document;//document.all?document.coupon.body:window.frames['coupon'].document.body;
			var doc = window.frames['coupon'].document;
			$(".premio").addClass("award");
			$(".part1").addClass("part1_check_off");
			doc.body.innerHTML = htmlText;
			if ((window.frames['coupon'].document.getElementById('tblSolved')) != null){
				window.frames['coupon'].document.getElementById('tblSolved').style.display = "none";			
				}else{
					$(".option-box").hide();
					$(".option-item").hide();
				}			
			var gameid = "<c:out value='${gameid}'/>";
			if(gameid == 717 || gameid == 715 || gameid == 10102){
			$("#chk").hide();
			$(".form-button_print").css({'margin-left' : '330px'});
			$(".premio").hide();
			$(".part1").removeClass("part1_check_off");
			$(".part1").addClass("part1_check_on");
			}
			//$('#coupon').contents().find('body').html(htmlText); 
			//doc.close();
			//doc.open();
			//doc.writeln(htmlText);
			//doc.close();
			$("#option_1").hide();
			$("#option_2").hide();
			$("#option_5").hide();
			$("#option_4").hide();
			document.forms[0].solved.checked = false;
		} catch (e) {
			alert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos. Error: "	+ e);
		}
		
		if (gameid == 717 || gameid == 715 || gameid == 10102) { // alinear recomendacion
			$('#recomendacion1').hide();
			$('#recomendacion2').show();
		}else{
			$('#recomendacion1').show();
			$('#recomendacion2').hide();
		}
	}
	
	
	function viewSolved() {
		var form = document.forms[0];
		if (form.solved.checked) {
			window.frames['coupon'].document.getElementById('tblSolved').style.display = "";
			$(".form-button_print").css({'margin-left' : '330px'});
			$(".option-box").css({'margin-left': '295px'});
			$(".premio").hide();
			$(".part1").removeClass("part1_check_off");
			$(".part1").addClass("part1_check_on");
		} else {
			$(".premio").show();
			$(".part1").removeClass("part1_check_on");
			$(".part1").addClass("part1_check_off");
			$(".form-button_print").css({'margin-left' : '480px'});
			$(".option-box").css({'margin-left': '448px'});
			window.frames['coupon'].document.getElementById('tblSolved').style.display = "none";
		}
	}
	/*
	function jalert(txt, title) {
		alert(txt);	
	}
	*/
	function option(op){
		switch(op){
			case 1:	
			 if(ctTwDefinePrize == 2){
				  $("#opcion1").attr('checked',false);
				  jAlert("Usted ya eligio cobrar en el punto de venta.", null);
				  $("#option_4").hide();
				  $("#option_3").hide(); 
			      $("#option_2").hide(); 
			      $("#option_1").hide(); 
			      $("#option_5").hide();
			   }
			if(ctTwDefinePrize == 0){
			  $("#option_5").hide();
			  $("#option_4").hide();
			  $("#option_3").hide(); 
			  $("#option_2").hide(); 
			  $("#option_1").show(); }			
			  break;
		     case 2:
		      $("#option_5").hide();
			  $("#option_4").hide();
			  $("#option_3").hide(); 
			  $("#option_1").hide(); 
			  $("#option_2").show(); break;
		     case 3:	
			   if(ctTwDefinePrize == 2){
				  $("#opcion3").attr('checked',false);
				  jAlert("Usted ya eligio cobrar en el punto de venta.");
				  $("#option_4").hide();
				  $("#option_3").hide(); 
			      $("#option_2").hide(); 
			      $("#option_1").hide(); 
			      $("#option_5").hide();}				  
			   if(ctTwDefinePrize == 0){			
				  $("#option_4").hide();
				  $("#option_3").hide(); 
			      $("#option_2").hide(); 
			      $("#option_1").hide(); 
			      $("#option_5").show();}				  
				  break;
		     case 4:	
				   if(ctTwDefinePrize == 2){
					  $("#opcion3").attr('checked',false);
					  jAlert("Usted ya eligio cobrar en el punto de venta.");
					  $("#option_4").hide();
					  $("#option_3").hide(); 
				      $("#option_2").hide(); 
				      $("#option_1").hide(); 
				      $("#option_5").hide();}				  
				   if(ctTwDefinePrize == 0){			
					  $("#option_4").show();
					  $("#option_3").hide(); 
				      $("#option_2").hide(); 
				      $("#option_1").hide(); 
				      $("#option_5").hide();}				  
					  break;
		     case 5:		
				   if(ctTwDefinePrize == 2){
					   $("input[name=opcion]").prop('checked',false);
					  jAlert("Usted ya eligio cobrar en el punto de venta.");
				   }
		    	 break;
			}	
		}	
	function value_pay(cad0){
		  c0 = cad0.split("||");
	}
		
		
		var mensaje;
		var activar = function(){
     $('#activar').on('click', function(){
		//var GameId = $("#activar").data("id");
		var GameId = $("#activar").data('parameter').id;
		var nameGame="general";
		if(GameId=="164"){
			nameGame = "ganadiario";
					}
		if(GameId=="42"){
			nameGame = "kabala";
		}
		if(GameId=="41"){
			nameGame = "tinka";
		}
		if(ctTwDefinePrize==0){
			var numberPhone = $("#numberPhone").val();
			/**ajax parra premio punto de venta**/
			$.ajax({
			type:"POST",
			url:"premio_punto_venta_"+nameGame+".html",
			dataType:"text",
			data:"numberPhone="+numberPhone+"&idGame="+GameId,//+"&editionId="+c0[0]+"&prizeBook="+c0[1]+"&prizeNum="+c0[2],
			async:false,
			success:function(e){
				result = (e+"").split("|||");
				var doc = window.frames['coupon'].document;
				var res = result[1].split('"+"');
				var total = res[0]+res[1];
				doc.body.innerHTML = total;
				mensaje = result[0].trim();
					//console.log("mensaje=["+mensaje+"] total=["+total+"]");	
				if(mensaje =="OK"){
					$("#numberPhone").attr('disabled','disabled'); 
				    $("#opcion1").attr('checked',false);
					$("#activar").off('click');
					ctTwDefinePrize = 2;
					
					// cambiar el Estado del premio con javascript
					var rownum = window.parent.document.getElementById('hdPrizeRowSelected').value;
					var cel_prize_status = window.parent.document.getElementById('prize_status_'+rownum);
					cel_prize_status.innerHTML  = 'Cobrar en Efectivo';
					// mensaje de confirmacion
					jAlert("Para cobrar el premio en efectivo, debe imprimir este boleto y cobrar en un Punto de Venta.", null);
				} else {
					jAlert(result[0], null);
				}									
			    window.frames['coupon'].document.getElementById('tblSolved').style.display = "none";					
				}
			});			
			/*if(mensaje == "OK"){
				$("#numberPhone").attr('disabled','disabled'); 
			    $("#opcion1").attr('checked',false);
				$("#activar").off('click');
				ctTwDefinePrize = 2;
			}*/
		} else {
			$("#activar").off('click');
		}		
	});
	
};$(activar);	


	function cerrar(){
			top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
	}
	
</script>
</head>
<body onLoad="doOnload();">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<!--  % 	boolean isAdvais = Boolean.valueOf(ConnectionFactory.operationProperty("advaisEnabled",Constants.contextSale).trim()).booleanValue();
% -->
<form name="start_print" id="start_print">
<div class="content-box">
<div class="content-box-data">

<div class="grid-block">

<div style="width: 720px; float: right;">
	<div id="chk" style="float: right;position: absolute;left: 150px;top: 20px;">
		<input type="checkbox" name="solved" class="option-box" onClick="viewSolved();" /><label class="option-item">Ver apuestas m&uacute;ltiples</label> 
	</div>
	<a href="#" class="form-button_print" onClick="printCoupon(); return false;"></a>
	<br/>
	<p id="recomendacion1" align="center" style="width:320px;margin:10px 35px 10px 0;padding:0;display:inline-block;float: right;">Recomendamos imprimir sus boletos desde una de las opciones de su PC o Laptop, y no en archivos PDF</p>
	<p id="recomendacion2" align="center" style="width:320px;padding:0;display:inline-block;">Recomendamos imprimir sus boletos desde una de las opciones de su PC o Laptop, y no en archivos PDF</p>
</div>

</div>
<div class="premio">
<div class="part_1">
<div style="position: absolute; margin-left: 14px; margin-top: 7px;">
<span>¡FELICIDADES HAS GANADO!</span><br />
<span style="font-size: 11px;">Elige c&oacute;mo cobrar tu premio</span>
</div>
</div>

<div style="margin: 8px 0 0 13px;">
<div style="color: #0681BC; font-family: arial; font-size: 11px;">
<span style="font-weight: bold;">Tienes un boleto premiado de:</span> <br/>
	<c:if test="${apGratis != 0 && apGratis != 0.0}">
		<span>-&nbsp;<c:out value="${apGratis}"/>&nbsp;jugadas gratis</span>
		<br/>
	</c:if>
	<c:if test="${apMtadPrmio != 0 && apMtadPrmio != 0.0}">
		<span>-&nbsp;<c:out value="${apMtadPrmio * 2}"/>&nbsp;jugadas de 2x1</span><!-- de jugadas a mitad de precio</span -->
		<br/>
	</c:if>
	<c:if test="${money != 0 && money != '0' && money != '0.00'}">
        <span>-&nbsp;S/.&nbsp;<c:out value="${money}"/></span>
    </c:if>
</div>
</div>


<div class="contenedor">
<c:choose>
<c:when test="${consecutive > 0 and cashPrizeEnabled and (gameid eq 41 or gameid eq 42 or gameid eq 164)}">
<c:if test="${money != '0.00' && apMtadPrmio == 0 && apGratis == 0}">
	<div class="margen_option">
		<span style="font-weight:bold;margin-bottom:4px;display:block;">1.&nbsp;Elige la forma de cobrar tus premios en efectivo</span>
		<input type="radio" name="opcion" id="opcion1" value="1" onClick="option(5);" /><label for="opcion1" class="option">Cargar al Saldo.</label>
		<div>
			<div style="margin:0 0 0 20px;text-align:justify;">
				<span>Se cargar&aacute; autom&aacute;ticamente a tu saldo.</span><br/>
			</div>
		</div>
	</div>
	<div class="margen_option">
		<input type="radio" name="opcion" id="opcion3" value="2" onClick="option(5);" /><label for="opcion3" class="option">Liquidar para cobrar en el Punto de Venta.</label>
		<div>
			<div style="margin:0 0 0 20px;text-align:justify;">
				<span>Se generar&aacute;n uno o varios boletos con montos predefinicos hasta completar el monto total a liquidar. Para imprimir los boletos, deber&aacute;s ingresar a la secci&oacute;n Premios de tu Cuenta.</span><br/>
			</div>
		</div>
    	<a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}", "cash":"1"}' ></a>
	</div>
</c:if>
<c:if test="${(apMtadPrmio != 0 || apGratis != 0) && (money==0 || money=='0' || money=='0.00')}">
	<div class="margen_option">
		<div class="justified">
			<span class="bolded">1.&nbsp;</span><span>Todos tus premios de jugadas gratis y/o jugadas 2x1 sean cobrados 
               generando jugadas a trav&eacute;s de la web. Las jugadas de premio 2x1, ser&aacute;n generadas de la siguiente 
               manera: El 50% de la cantidad total de jugadas 2x1 consistir&aacute; en jugadas gratis y; el otro 50% de la cantidad  
               total de jugadas 2x1 se cargar&aacute; a tu saldo, por lo tanto para poder cobrar dichas jugadas 2x1, deber&aacute;s 
               contar con saldo suficiente en tu cuenta, recargar el saldo, o permitir que el monto a pagar se descuente de tus 
               premios en efectivo.<br/><br/><u>RECUERDA</u>: S&oacute;lo tienes una oportunidad para cobrar la TOTALIDAD de tus 
               jugadas gratis y 2x1, y &eacute;sta oportunidad caduca a los 180 d&iacute;as calendario siguientes luego de haber sido 
               realizado el sorteo donde obtuviste dichas jugadas como premio.</span>
       	</div>
        <a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}", "cash":"1"}' ></a>
	</div>
</c:if>
<c:if test="${(apMtadPrmio != 0 || apGratis != 0) && money!=0 && money!='0' && money!='0.00'}">
	<div class="margen_option">
		<span style="font-weight:bold;margin-bottom:4px;display:block;">1.&nbsp;Elige la forma de cobrar tus premios en efectivo</span>
		<input type="radio" name="opcion" id="opcion1" value="1" onClick="option(5);" /><label for="opcion1" class="option">Cargar al Saldo.</label>
		<div style="margin:0 0 0 20px;text-align:justify;">
			<span>Se cargar&aacute; autom&aacute;ticamente a tu saldo.</span><br/>
		</div>
	</div>
	<div class="margen_option">
		<input type="radio" name="opcion" id="opcion3" value="2" onClick="option(5);" /><label for="opcion3" class="option">Liquidar para cobrar en el Punto de Venta.</label>
		<div style="margin:0 0 0 20px;text-align:justify;">
			<span>Se generar&aacute;n uno o varios boletos con montos predefinicos hasta completar el monto total a liquidar. Para imprimir los boletos, deber&aacute;s ingresar a la secci&oacute;n Premios de tu Cuenta.</span><br/>
		</div>
	</div>
	<div class="margen_option">
		<div class="justified">
			<span class="bolded">2.&nbsp;</span><span>Todos tus premios de jugadas gratis y/o jugadas 2x1 sean cobrados 
               generando jugadas a trav&eacute;s de la web. Las jugadas de premio 2x1, ser&aacute;n generadas de la siguiente 
               manera: El 50% de la cantidad total de jugadas 2x1 consistir&aacute; en jugadas gratis y; el otro 50% de la cantidad  
               total de jugadas 2x1 se cargar&aacute; a tu saldo, por lo tanto para poder cobrar dichas jugadas 2x1, deber&aacute;s 
               contar con saldo suficiente en tu cuenta, recargar el saldo, o permitir que el monto a pagar se descuente de tus 
               premios en efectivo.<br/><br/><u>RECUERDA</u>: S&oacute;lo tienes una oportunidad para cobrar la TOTALIDAD de tus 
               jugadas gratis y 2x1, y &eacute;sta oportunidad caduca a los 180 d&iacute;as calendario siguientes luego de haber sido 
               realizado el sorteo donde obtuviste dichas jugadas como premio.</span>
       	</div>
        <a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}", "cash":"1"}' ></a>
	</div>
</c:if>
</c:when>
<c:otherwise>
<c:if test="${money != '0.00' && apMtadPrmio == 0 && apGratis == 0}">
	<div class="margen_option">
		<input type="radio" name="opcion"  id ="opcion1" value="1" onClick="option(1);"/><label for="opcion1" class="option">Cargar a Saldo</label>
		<div id="option_1">
			<div style="margin-top:4px">
				<span>Tu premio se cargar&aacute;
				autom&aacute;ticamente a tu saldo</span><br/>
				<c:choose>
                <c:when test="${awardsEnabled and (gameid eq 41 or gameid eq 42 or gameid eq 164)}">
                <a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}' ></a>
                </c:when>
                <c:otherwise>
				<a href="#" id="form_balance" class="pago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}'></a>
				</c:otherwise>
                </c:choose>
				</div>
		</div>
	</div>

</c:if>

<c:if test="${(apMtadPrmio != 0 || apGratis != 0) && (freeAmount==0 || freeAmount=='0' || freeAmount=='0.00')}">

	<div class="margen_option">
		<input type="radio" name="opcion" id ="opcion3" value="1" onClick="option(3);"/>
        <label class="option">Cobrar en l&iacute;nea</label>
		<div id="option_5">
			<div class="justified">
				<span>Al elegir cobrar en l&iacute;nea te permite:</span>
				<br/>
				<span class="bolded">1.&nbsp;</span><span>Que tus premios en efectivo se cargen autom&aacute;ticamente a tu saldo.</span>
				<br/>
                <c:choose>
                <c:when test="${awardsEnabled}">
				<span class="bolded">2.&nbsp;</span><span>Que todos tus premios de jugadas gratis y/o jugadas 2x1 sean cobrados 
                generando jugadas a trav&eacute;s de la web. Las jugadas de premio 2x1, ser&aacute;n generadas de la siguiente 
                manera: El 50% de la cantidad total de jugadas 2x1 consistir&aacute; en jugadas gratis y; el otro 50% de la cantidad  
                total de jugadas 2x1 se cargar&aacute; a tu saldo, por lo tanto para poder cobrar dichas jugadas 2x1, deber&aacute;s 
                contar con saldo suficiente en tu cuenta, recargar el saldo, o permitir que el monto a pagar se descuente de tus 
                premios en efectivo.<br/><u>RECUERDA</u>: S&oacute;lo tienes una oportunidad para cobrar la TOTALIDAD de tus 
                jugadas gratis y 2x1, y &eacute;sta oportunidad caduca a los 180 d&iacute;as calendario siguientes luego de haber sido 
                realizado el sorteo donde obtuviste dichas jugadas como premio.</span> 
                <br />
                <a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}' ></a>
                </c:when>
                <c:otherwise>
                <span class="bolded">2.&nbsp;</span><span>Que todos tus premios con jugadas gratis se generaran al azar en l&iacute;nea. 
                Todos tus premios con jugadas a mitad de precio se generaran al azar, 50% en jugadas gratis y 50% en jugadas pagadas que se restaran de tu saldo. 
                S&oacute;lo tienes una opci&oacute;n para cobrar todas tu jugadas.</span>
                <br />
                <a href="#" id="form_charge" class="pago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}' ></a>
                </c:otherwise>
                </c:choose> 
        	</div>
		</div>
	</div>
</c:if>
<c:if test="${(apMtadPrmio != 0 || apGratis != 0) && freeAmount!=0 && freeAmount!='0' && freeAmount!='0.00'}">
	<div class="margen_option">
		<input type="radio" name="opcion" id="opcion3" value="1" onClick="option(3);"/>
        <label class="option">Cobrar en l&iacute;nea</label>
		<div id="option_5">
			<div class="justified-kabala">
				<br/>
				<span class="bolded">1.&nbsp;</span><span>Tus premios en efectivo se cargar&aacute;n autom&aacute;ticamente a tu saldo.</span>
				<br/>
				<br/>
				<span class="bolded">2.&nbsp;</span><span>El monto equivalente al n&uacute;mero de jugadas gratis se cargar&aacute;n 
				autom&aacute;ticamente a <b>Saldo para realizar jugadas de K&aacute;bala</b>, debido a que el juego est&aacute; bajo 
				un proceso de renovaci&oacute;n, por lo cual, desde el mi&eacute;rcoles 11 de Mayo de 2016, la opci&oacute;n de jugadas 
				consecutivas se encuentran desactivadas hasta nuevo aviso.<br/><u>RECUERDA</u>: S&oacute;lo tienes una oportunidad para 
				cobrar la TOTALIDAD de tus jugadas gratis y &eacute;sta oportunidad caduca a los 180 d&iacute;as calendario siguientes 
				luego de haber sido realizado el sorteo donde obtuviste dichas jugadas gratis como premio</span> 
                <br />
                <a href="#" id="form_charge" class="npago" data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}' ></a>
        	</div>
		</div>
	</div>
</c:if>
<div class="margen_option"><input type="radio" name="opcion" id="opcion2" value="2" onClick="option(2);"/>
<label for="opcion2" class="option">Cobrar en el Punto de Venta</label>
<div id="option_2">
<div class="justified">
<!-- span class="bolded">1.&nbsp;</span><span>Ingresa un n&uacute;mero telef&oacute;nico el cual nuestro operador se pueda comunicar en breve y guiarte en el cobro de tu premio</span>
<input type="text" class="text-number" maxlength="9" id="numberPhone"/><label style="color:#0681BC;">&nbsp;* Obligatorio</label>
</div -->


  
<span class="bolded">1.&nbsp;</span><span>Activar el c&oacute;digo de barras de tu boleto</span>
<br />
<span  class="form_activar" id="activar" data-parameter='{"id": "${gameid}","name": "${gameName}" }'></span><label style="color: #0681BC; line-height: 3;margin-left: 96px;" >&nbsp;* Obligatorio</label>
	<br />

<span class="bolded">2.&nbsp;</span><span>Imprime tu boleto con el c&oacute;digo de barras para presentarlo en el Punto de Venta de La Tinka</span>
<br /><a href="#" class="form_print" onClick='printCoupon(); return false;'></a>
<label style="color: #0681BC;line-height: 3;margin-left: 96px; ">&nbsp;* Obligatorio</label>
<br />
<span class="bolded">3.&nbsp;</span><span>Si tu premio es mayor o igual a S/2,000, puedes solicitar una transferencia bancaria a tu cuenta Interbank, BCP, Continental o Interbancaria de ser otro banco.
<br />
Env&iacute;a la imagen de tu boleto con el c&oacute;digo de barras activado (punto 1), la foto de tu DNI (ambas caras), n&uacute;mero de cuenta bancaria a tu nombre y tel&eacute;fono contacto a <a href="mailto:cobratupremio@latinka.com.pe">cobratupremio@latinka.com.pe</a>
</span>
</div>
</div>
</div>
</c:otherwise>
</c:choose>
<!-- <div class="margen_option"><input type="radio" name="opcion" /><label
	class="option">Cargar en cuenta bancaria</label>
<div id="option_3"></div>
</div>

<div class="margen_option"><input type="radio" name="opcion" /><label
	class="option">Cargar a billetera movil</label>
<div id="option_4"></div>
</div>-->

<c:if test="${isAdvaisEnabled == 'true'}">
	<c:if test="${money != 0 && apMtadPrmio == 0 && apGratis == 0}">
	
		<div class="margen_option"><input type="radio" name="opcion" id ="opcion4" value="2" onClick="option(4);"/>
		    <label for="opcion4" class="option">Cargar a Jet Point</label>
			<div id="option_4" >
				<div class="justified">
					<span>Al elegir cargar a tu Jet Point te permite:</span>
					<br/>
					<span class="bolded">1.&nbsp;</span><span>Que tu premio en efectivo se cargue autom&aacute;ticamente a
					tu cuenta Jet Point.</span>
					<br /> 
					<c:if test="${apMtadPrmio != 0 || apGratis != 0}">
							<span class="bolded">2.&nbsp;</span><span>Que todos tus premios con jugadas gratis se generaran al azar en l&iacute;nea. 
							Todos tus premios con jugadas a mitad de precio se generaran al azar, 50% en jugadas gratis y 50% en jugadas pagadas que se restaran de tu saldo.
							Debes contar con saldo en tu cuenta para el cobro de estas jugadas.  
							S&oacute;lo tienes una opci&oacute;n para cobrar todas tu jugadas.</span> 
							<br />
					</c:if>
					<a href="#" id="form_charge" class="advais"  data-premio='{"id":"${gameid}", "apGratis":"${apGratis}", "money":"${money}", "mitPrec":"${apMtadPrmio * 2}", "maxMoney":"${maxMoney}", "dmoney":"${dmoney}", "dmaxMoney":"${dmaxMoney}", "parameterId":"${parameterId}"}' ></a>
				</div>
			</div>
			
		</div>
	
	</c:if>
</c:if>


</div>

</div>




<div class="part1">

<iframe id="coupon" name="coupon"
	style="background: #FFFFFF; width: 100%; height: 524px;"
	src="about:blank" marginheight="0" marginwidth="0" frameborder="0"
	scrolling="auto"></iframe></div>

<div style="float: right; margin-right: 18px; margin-top: 18px;" class="cerrar"><a href="" onclick="cerrar(); return false;" /></a>
</div>

</div>

</div>
</form>
<%@ include file="../include/message.jspf"%>

</body>
</html>
