<%@ include file="../include/taglibs.jspf"%>
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


    <meta charset="UTF-8">
    <meta name="description" content="La Tinka - Iversionistas">
    <meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />
    
    <link href="//vjs.zencdn.net/6.4.0/video-js.css" rel="stylesheet">
    <link rel="stylesheet" href="layer-view-style/common/landing/daterangepicker.min.css?v=2">
    <link rel="stylesheet" href="layer-view-style/common/landing/common.css?v=<%=Constants.common_css%>">

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Inversionistas La Tinka</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body >

	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	
    <%@ include file="../include/header.jspf" %>

   

    <div class="main-content">
			<div class="main-page inversionistas">
				<ul class="il-r-page-nav">
					<li><a href="#section-informacion-financiera">Información Financiera</a></li>
					<li><a href="#section-memorias">Memorias</a></li>
					<li><a href="https://www.latinka.com.pe/latinka/docs/latinka/directorio/miembros_del_directorio_intralot.pdf" target="_blank">Directores</a></li>
					<li><a href="#section-hechos-de-importancia">Hechos de Importancia</a></li>
				</ul>
				<div id="section-informacion-financiera">
					<h3>Información Financiera</h3>
					<form id="financial-information" action="" method="POST">
						<h4>Seleccionar para descargar</h4>
						<div class="il-r-row-input">
							<input type="hidden" name="financial_information_year" value="">
							<input type="hidden" name="financial_information_trimester" value="">
							<div class="il-r-dropdown" data-dropdown-id="year">
								<a href="#" data-placeholder="Año" data-dropdown-name="financial_information_year">
									<span>Año</span>
									<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 44.5 24.34" width="44.5" height="24.34"><polygon fill="#959595" points="44.5 2.09 42.41 0 22.25 20.16 2.09 0 0 2.09 22.25 24.34 44.5 2.09"/></svg></i>
								</a>
								<ul class="dropdown-select" id="yearFinancial_information">
									
								</ul>
							</div>
							<div class="il-r-dropdown" data-dropdown-id="trimester">
								<a href="#" data-placeholder="Trimestre" data-dropdown-name="financial_information_trimester">
									<span>Trimestre</span>
									<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 44.5 24.34" width="44.5" height="24.34"><polygon fill="#959595" points="44.5 2.09 42.41 0 22.25 20.16 2.09 0 0 2.09 22.25 24.34 44.5 2.09"/></svg></i>
								</a>
								<ul class="dropdown-select" id="js_financial_information_trimester">
									<li data-field-name="financial_information_trimester" data-value="I"><i>I</i></li>
									<li data-field-name="financial_information_trimester" data-value="II"><i>II</i></li>
									<li data-field-name="financial_information_trimester" data-value="III"><i>III</i></li>
									<li data-field-name="financial_information_trimester" data-value="IV"><i>IV</i></li>
									<li data-field-name="financial_information_trimester" data-value="Anual"><i>Anual</i></li>
								</ul>
							</div>
						</div>
						<div class="il-r-input-row">
							<button type="submit" class="il-r-btn" id="submitDoc">
								<span>buscar</span>
								<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16.1" width="16" height="16.1"><path d="M12.7,11.3a6.85,6.85,0,0,0,1.4-4.2A7,7,0,0,0,7.1,0a7.1,7.1,0,0,0,0,14.2,6.64,6.64,0,0,0,4.2-1.4l3,3a1,1,0,0,0,1.4,0,1,1,0,0,0,0-1.4Zm-5.6.8A5,5,0,0,1,2,7.1a5.1,5.1,0,0,1,10.2,0A5,5,0,0,1,7.1,12.1Z" fill="#fff"/></svg></i>
							</button>
						</div>
					</form>
					<h4>Seleccionar para descargar</h4>
					<div class="il-r-table table_documentos" data-search-result-content="financial-information" id="financial-information">
						<div class="il-r-table-row">
							<div class="il-r-table-col">Fecha</div>
							<div class="il-r-table-col">Documento</div>
							<div class="il-r-table-col">descargar</div>
						</div>												
					</div>
				</div>
				<div id="section-memorias">
					<h3>memorias</h3>
					<div class="memories-inner il-clearfix">
						<div>
							<form id="memories" action="" method="POST">
								<h4>SELECCIONAR PARA DESCARGAR:</h4>
								<div class="il-r-row-input">
									<div class="il-r-dropdown" data-dropdown-id="memories">
										<a href="#" data-placeholder="Año" data-dropdown-name="memories_year">
											<span>Año</span>
											<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 44.5 24.34" width="44.5" height="24.34"><polygon fill="#959595" points="44.5 2.09 42.41 0 22.25 20.16 2.09 0 0 2.09 22.25 24.34 44.5 2.09"/></svg></i>
										</a>
										<ul class="dropdown-select" id="js_memoriesyear">
											
										</ul>
									</div>
								</div>
								<div class="il-r-row-input">
									<a href="javascript:void(0)" class="il-r-btn download-memory">
										<span>descargar memoria anual</span>
										<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.89 15.48" width="16.89" height="15.48"><polygon points="4.22 6.33 8.44 11.26 12.66 6.33 9.15 6.33 9.15 0 7.74 0 7.74 6.33 4.22 6.33" fill="#fff"/><path d="M15.48,14.07H1.41V9.85H0v4.93a.7.7,0,0,0,.7.7H16.18a.7.7,0,0,0,.7-.7V9.85H15.48Z" fill="#fff"/></svg></i>
									</a>
								</div>
							</form>
						</div>
						<div>
							<img src="layer-view-image/common/upload/responsabilidad-social/inversionistas01.jpg" alt="">
						</div>
					</div>
				</div>
				<div id="section-hechos-de-importancia">
					<h3>Hechos de importancia</h3>
					<div class="facts-of-importance-inner il-clearfix">
						<div>
							<form id="facts-of-importance" action="" method="POST">
								<h4>Seleccionar para buscar</h4>
								<div class="il-r-row-input">
									<div id="date-range-both">
										<div class="input-row">
											<label for="date-range-1">Desde:</label>
											<input type="text" id="dia_inicio">
										</div>
										<div class="input-row">
											<label for="date-range-2">Hasta:</label>
											<input type="text" id="dia_final">
										</div>
									</div>
								</div>
								<div class="il-r-row-input">
									<button type="submit" class="il-r-btn" id="facts_btn">
										<span>Buscar hechos de importancia</span>
										<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16.1" width="16" height="16.1"><path d="M12.7,11.3a6.85,6.85,0,0,0,1.4-4.2A7,7,0,0,0,7.1,0a7.1,7.1,0,0,0,0,14.2,6.64,6.64,0,0,0,4.2-1.4l3,3a1,1,0,0,0,1.4,0,1,1,0,0,0,0-1.4Zm-5.6.8A5,5,0,0,1,2,7.1a5.1,5.1,0,0,1,10.2,0A5,5,0,0,1,7.1,12.1Z" fill="#fff"/></svg></i>
									</button>
								</div>
							</form>
						</div>
						<div>
							<img src="layer-view-image/common/upload/responsabilidad-social/inversionistas02.jpg" alt="">
						</div>
					</div>
					<div class="il-r-table facts-of-importance" data-search-result-content="facts-of-importance">
						<div class="il-r-table-row">
							<div class="il-r-table-col">fecha</div>
							<div class="il-r-table-col">Descripción de Hecho de importancia</div>
							<div class="il-r-table-col">descargar</div>
						</div>				
						
					</div>
				</div>
			</div>
        
    </div>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery-ui.js'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <%@ include file="../include/footer.jspf" %>

   
    

    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>


    
    <script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/moment.min.js"></script>
    <script src="//vjs.zencdn.net/6.4.0/video.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/videojs-youtube/2.4.1/Youtube.min.js"></script>

    <script type="text/javascript" src="layer-view-script/common/landing/jquery.daterangepicker.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/landing/vanilla-common.js"></script>
    <script type="text/javascript" src="layer-view-script/common/landing/jq-common.js"></script>
    <script type="text/javascript" src="layer-view-script/common/landing/jq-ui.js"></script>
<!--     <script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
    <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
    <script>	 
    	Array.prototype.unique=function(a){
		  return function(){return this.filter(a)}}(function(a,b,c){return c.indexOf(a,b+1)<0
		});  
			  var dateToday = new Date();
			  var yrRange = (dateToday.getFullYear() - 2) + ":" + dateToday.getFullYear();
			 var dateFormat = "dd/mm/yy",
		      from = $( "#dia_inicio" )
		        .datepicker({
		          changeMonth: true,
		          changeYear: true,
		          yearRange : yrRange,
		          dateFormat: dateFormat,
		          numberOfMonths: 1,
		          monthNamesShort: [ "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" ],
		          monthNames: [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ],
		          dayNamesMin: [ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" ]
		        })
		        .on( "change", function() {
		          to.datepicker( "option", "minDate", getDate( this ) );
		        }),
		      to = $( "#dia_final" ).datepicker({
		        changeMonth: true,
		        changeYear: true,
		        yearRange : yrRange,
		        dateFormat: dateFormat,
		        monthNamesShort: [ "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" ],
		        dayNamesMin: [ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" ],
		        monthNames: [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ]
		      })
		      .on( "change", function() {
		        from.datepicker( "option", "maxDate", getDate( this ) );
		      });
		 
		    function getDate( element ) {
		      var date;
		      try {
		        date = $.datepicker.parseDate( dateFormat, element.value );
		      } catch( error ) {
		        date = null;
		      }
		 
		      return date;
		    }

		function dropdonw($id){
			$id.find('li').on('click',function(){
				var $this = $(this);
				var value = $this.attr('data-value');
				$this.closest('.il-r-dropdown').find('a').find('span').html(value);
				$this.closest('.il-r-dropdown').find('a').attr('data-val',value);
			});			
		}

		function filter(arrayXml,filtertag,filterval){
			var arrayReturn = [];
			for (var aux=0;aux<arrayXml.length;aux++) {
				var valueShort = arrayXml[aux].getElementsByTagName(filtertag)[0].textContent;
				if (filterval == valueShort) {
					arrayReturn.push(arrayXml[aux]);
				}
			}
			return arrayReturn;
		}

		function forceDownload(href) {
			var anchor = document.createElement('a');
			anchor.href = href;
			anchor.download = href;
			document.body.appendChild(anchor);
			anchor.click();
		}

		function betweentodays(dateFrom,dateTo,dateCheck){
			var d1 = dateFrom.split("/");
			var d2 = dateTo.split("/");
			var c = dateCheck.split("/");

			var from = new Date(d1[2], parseInt(d1[1])-1, d1[0]);  // -1 because months are from 0 to 11
			var to   = new Date(d2[2], parseInt(d2[1])-1, d2[0]);
			var check = new Date(c[2], parseInt(c[1])-1, c[0]);

			if (check > from && check < to) {
			   return 1;
			}
			else {
			   return 0;
			}
		}

    	$.ajax({    		  
		url: "<%= Constants.inversionistasXML %>",
		cache: false,
		success: function(res) {
		  	var xmlDoc = res;
		  	var data = xmlDoc.getElementsByTagName("inversionistas");
		  	if (data[0]) {  		  				  		
		  		var arrayArchivos = data[0].getElementsByTagName("in_archivo");
		  		var aux_in_descripcion = [];
		  		var aux_in_url = [];
		  		var aux_in_tipo = [];
		  		var aux_in_periodo = [];
		  		var aux_in_anio = [];
		  		var aux_in_anio_if = [];
		  		var aux_in_anio_memoria = [];
		  		var aux_in_fecha = [];
		  		//for all vals 
		  		for (var b=0;b<arrayArchivos.length;b++){
		  			aux_in_descripcion.push(arrayArchivos[b].getElementsByTagName("in_descripcion")[0].textContent);
		  			aux_in_url.push(arrayArchivos[b].getElementsByTagName("in_url")[0].textContent);
		  			aux_in_tipo.push(arrayArchivos[b].getElementsByTagName("in_tipo")[0].textContent);
		  			aux_in_periodo.push(arrayArchivos[b].getElementsByTagName("in_periodo")[0].textContent);		
		  			aux_in_anio.push(arrayArchivos[b].getElementsByTagName("in_anio")[0].textContent);	
		  			aux_in_fecha.push(arrayArchivos[b].getElementsByTagName("in_fecha")[0].textContent);
		  		}
		  		//for unique array
		  		aux_in_descripcion = aux_in_descripcion.unique();
				aux_in_url = aux_in_url.unique();
				aux_in_tipo = aux_in_tipo.unique();
				aux_in_periodo = aux_in_periodo.unique();
				aux_in_anio = aux_in_anio.unique();
				aux_in_fecha = aux_in_fecha.unique();

				var aux_in_informacion_financiera = filter(arrayArchivos,'in_tipo','INFORMACION FINANCIERA');
				var aux_in_memoria = filter(arrayArchivos,'in_tipo','MEMORIA');

				for (var b=0;b<aux_in_informacion_financiera.length;b++){
		  			aux_in_anio_if.push(aux_in_informacion_financiera[b].getElementsByTagName("in_anio")[0].textContent);			  			
		  		}
				for (var b=0;b<aux_in_memoria.length;b++){
		  			aux_in_anio_memoria.push(aux_in_memoria[b].getElementsByTagName("in_anio")[0].textContent);			  			
		  		}
				aux_in_anio_if = aux_in_anio_if.unique();
				aux_in_anio_memoria = aux_in_anio_memoria.unique();

				//completeInformation
				//array description
					for (var a = 0; a<aux_in_anio_if.length; a++) {
						//variables
							var anios = aux_in_anio_if[a];
						//templates
							var tmpl_financial_information_year = '<li data-field-name="financial_information_year" data-value="'+anios+'"><i>'+anios+'</i></li>';
						//integration
							$('#yearFinancial_information').append(tmpl_financial_information_year);
					}

					for (var a = 0; a<aux_in_anio_memoria.length; a++) {
						//variables
							var anios = aux_in_anio_memoria[a];//aux_in_memoria[a].getElementsByTagName("in_anio")[0].textContent;
						//templates
							var tmpl_memories_year = '<li data-field-name="memories_year" data-value="'+anios+'"><i>'+anios+'</i></li>';
						//integration
							$('#js_memoriesyear').append(tmpl_memories_year);
					}
				//array URL
					for (var a = 0; a<aux_in_url.length; a++) {

					}
				//array tipo
					for (var a = 0; a<aux_in_tipo.length; a++) {
					
					}
				
				//array anio
					for (var a = 0; a<aux_in_anio.length; a++) {
					
					}
				//array fecha
					for (var a = 0; a<aux_in_fecha.length; a++) {
					
					}

				//dropdown
				dropdonw($('#yearFinancial_information'));
				dropdonw($('#js_memoriesyear'));
				dropdonw($('#js_financial_information_trimester'));

				//usefilters
				$('#submitDoc').on('click',function(){
					var valor_year = $('#yearFinancial_information').closest('.il-r-dropdown').find('a').attr('data-val');
					var valor_trimestre = $('#js_financial_information_trimester').closest('.il-r-dropdown').find('a').attr('data-val');
					var arrayp = filter(arrayArchivos,'in_anio',valor_year);
					var arrayp2 = filter(arrayp,'in_periodo',valor_trimestre);
					$('.table_documentos').html('<div class="il-r-table-row"><div class="il-r-table-col">Fecha</div><div class="il-r-table-col">Documento</div><div class="il-r-table-col">descargar</div></div>');
					for (var f=0;f<arrayp2.length;f++) {
						var templateG = '<div class="il-r-table-row"><div class="il-r-table-col"><span>' + arrayp2[f].getElementsByTagName("in_fecha")[0].textContent + '</span></div><div class="il-r-table-col"><span>' + arrayp2[f].getElementsByTagName("in_descripcion")[0].textContent + '</span></div><div class="il-r-table-col"><a href="' + arrayp2[f].getElementsByTagName("in_url")[0].textContent + '" download><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.89 15.48" width="16.89" height="15.48"><polygon points="4.22 6.33 8.44 11.26 12.66 6.33 9.15 6.33 9.15 0 7.74 0 7.74 6.33 4.22 6.33" fill="#959595"/><path d="M15.48,14.07H1.41V9.85H0v4.93a.7.7,0,0,0,.7.7H16.18a.7.7,0,0,0,.7-.7V9.85H15.48Z" fill="#959595"/></svg></a></div></div>';
						$('.table_documentos').append(templateG);
					}
				});

				$('.download-memory').on('click',function(e){
					e.preventDefault();
					var dataval = $('#js_memoriesyear').closest('.il-r-dropdown').find('a').attr('data-val');
					var arrayp = filter(arrayArchivos,'in_anio',dataval);
					var arrayp2 = filter(arrayp,'in_tipo','MEMORIA');
					for (var a=0;a<arrayp2.length;a++) {
						forceDownload(arrayp2[a].getElementsByTagName("in_url")[0].textContent);
					}	
				});

				$('#facts_btn').on('click',function(){
					var dateInicio = $('#dia_inicio').val();	
					var dateFinal = $('#dia_final').val();	
					$('.facts-of-importance').html('<div class="il-r-table-row"><div class="il-r-table-col">fecha</div><div class="il-r-table-col">Descripción de Hecho de importancia</div><div class="il-r-table-col">descargar</div></div>');	
					var arrayp2 = filter(arrayArchivos,'in_tipo','HECHO DE IMPORTANCIA');			
					for (var fa=0;fa<arrayp2.length;fa++){
			  			var dat = arrayp2[fa].getElementsByTagName("in_fecha")[0].textContent;
			  			var condicional = betweentodays(dateInicio,dateFinal,dat);
			  			if (condicional == 1) {
			  				var templateG = '<div class="il-r-table-row"><div class="il-r-table-col"><span>' + arrayp2[fa].getElementsByTagName("in_fecha")[0].textContent + '</span></div><div class="il-r-table-col"><span>' + arrayp2[fa].getElementsByTagName("in_descripcion")[0].textContent + '</span></div><div class="il-r-table-col"><a href="' + arrayp2[fa].getElementsByTagName("in_url")[0].textContent + '" download><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.89 15.48" width="16.89" height="15.48"><polygon points="4.22 6.33 8.44 11.26 12.66 6.33 9.15 6.33 9.15 0 7.74 0 7.74 6.33 4.22 6.33" fill="#959595"/><path d="M15.48,14.07H1.41V9.85H0v4.93a.7.7,0,0,0,.7.7H16.18a.7.7,0,0,0,.7-.7V9.85H15.48Z" fill="#959595"/></svg></a></div></div>';
			  				$('.facts-of-importance').append(templateG);
			  			}			  			
			  		}
				});
		  		
	
		  		
		  	} else {
		  		console.log('no data')
		  	}

		}, error: function(e) {
		  	console.log('error obteniendo xml...')
		}
		});
    
    </script>
</body>
</html>