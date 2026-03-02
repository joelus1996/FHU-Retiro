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
    <title>Juego responsable La Tinka</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body >

		<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	
	
    <%@ include file="../include/header.jspf" %>

   

   <div class="main-content">
			<div class="main-page responsabilidad-social">
				<div class="il-rs-contribution-betefits">
					<h1>APORTE ENTREGADO A LAS BENEFICENCIAS</h1>
					<h2 id="jsid_monto"></h2>
					<div class="il-caption">
						<div class="il-rs-container">
							<p id="jsid_description"></p>
						</div>
					</div>
				</div>
				<div class="il-rs-article">
					<div class="il-rs-container">
						<div class="il-caption">
							<p id="jsid_sumilla"></p>
						</div>
						<a href="#" class="il-rs-link" data-jsx-modal-open="#md-article-1">Leer más</a>
					</div>
				</div>
				<div class="il-rs-social-responsability">
					<div class="il-rs-container">
						<h3 class="il-rs-section-title">Responsabilidad Social</h3>
						<div class=" il-clearfix overHidden">
						<form name="responsocial" action="/" method="POST">
							<input type="hidden" id="title" name="title"/>
							<input type="hidden" id="date" name="date"/>
							<input type="hidden" id="image" name="image"/>
							<input type="hidden" id="contenido" name="contenido"/>
							<article id="idjs_social_items" class="il-rs-social-items"></article>
							<div class="fixedRight overControl dontSee" id="fixedM">
							</div>
						</form>	
						</div>
						<a href="javascript:void(0)" class="il-rs-link" id="idjs_morearticle">Ver más articulos</a>
					</div>
				</div>
				<div class="il-rs-social-videos">
					<div class="il-rs-container">
						<div class="il-rs-section-title-row il-clearfix">
							<h3 class="il-rs-section-title">Videos</h3>
							<ul class="il-rs-video-controls">
								<li><a href="#" class="il-rs-video-control-prev"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 192 320" width="192" height="320"><polygon points="192 32.4 159.7 0 0 160 0 160 0 160 159.7 320 192 287.6 64.7 160 192 32.4" fill="#e6822f"/></svg></a></li>
								<li><a href="#" class="il-rs-video-control-next"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 193.41 321.42" width="193.41" height="321.42"><polygon points="0.71 33.11 33.01 0.71 192.71 160.71 192.71 160.71 192.71 160.71 33.01 320.71 0.71 288.31 128.01 160.71 0.71 33.11" fill="#e6822f" stroke="#fff" stroke-miterlimit="10"/></svg></a></li>
							</ul>
						</div>
						<div class="il-rs-video-list" id="idjs_video_list">
							
						</div>
					</div>
				</div>
				<div class="il-rs-social-campaigns">
					<div class="il-rs-container">
						<h3 class="il-rs-section-title">Campañas Vigentes</h3>
						<ul class="row" id="idjs_logo">
						</ul>
					</div>
				</div>
				
			</div>
		</div>

		<div data-jsx-modal-id="#md-article-1" class="md-wrapper">
			<div class="md-content">
				<span class="md-close" data-jsx-modal-close="#md-article-1">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="512" height="512"><polygon points="512 493.56 274.43 256 512 18.43 493.56 0 256 237.57 18.43 0 0 18.43 237.57 256 0 493.56 18.43 512 256 274.43 493.57 512 512 493.56" fill="#fff"/></svg>
				</span>
				<div class="md-caption">
					<p id="jsid_sumilla_detalle"></p>
				</div>
			</div>
		</div>
			
		<div id="idjs_videocontent">
		</div>				
		<div id="idjs_logocontent">
		</div>	

    

    <style type="text/css">
		.md-wrapper .md-caption p {
		    text-align: justify;
		}
	    #fixedM.active {
		    position: fixed;
		    right: auto;
		    left: auto;
		    margin-left: 890px;
		}
    	span.alingTop.notmove {
		    background: #b1b1b1;
		    pointer-events: none;
		}
		span.alingBottom.notmove {
		    background: #b1b1b1;
		    pointer-events: none;
		}

    </style>

    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
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
<!--     <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>     -->
    <script  type="text/javascript">
	    function printvaloresgenerales(id,valortest,data) {
	    	var valor = data[0].getElementsByTagName(valortest)[0].childNodes[0];
			$('#'+id).html(valor);
		}
		function replaceAll( text, busca, reemplaza ){
		  while (text.toString().indexOf(busca) != -1) { text = text.toString().replace(busca,reemplaza); }
		  return text;
		}
		function changeprintvaloresgenerales(id,valortest,data) {
	    	var valor = data[0].getElementsByTagName(valortest)[0].textContent;	    	
	    	valor = replaceAll(valor,'[','<');
	    	valor = replaceAll(valor,']','>');
			$('#'+id).html(valor);			
		}

	    function videoslide() {
				var lvideo = $('.il-rs-video-item').length;
				$('.il-rs-video-item').eq(0).addClass('is-prev');
				$('.il-rs-video-item').eq(1).addClass('is-active');
				$('.il-rs-video-item').eq(lvideo-1).addClass('is-next');
		
		
		
				if ( document.querySelector('.il-rs-video-list') ) {
		        var videoSlides = document.querySelectorAll('.il-rs-video-item');
		        var videoSlideActive = document.querySelector('.il-rs-video-item.is-active');
		        for ( var i = 0; i < videoSlides.length; i++ ) {
		            videoSlides[i].addEventListener('click', function() {
		                for ( var j = 0; j < videoSlides.length; j++ ) {
		                    if ( videoSlides[j].classList.contains('is-active') ) {
		                        videoSlides[j].classList.remove('is-active');
		                    }
		
		                    if ( videoSlides[j].classList.contains('is-prev') ) {
		                        videoSlides[j].classList.remove('is-prev');
		                    }
		
		                    if ( videoSlides[j].classList.contains('is-next') ) {
		                        videoSlides[j].classList.remove('is-next');
		                    }
		                }
		
		                if ( ! this.classList.contains('is-active') ) {
		                    this.classList.add('is-active');
		
		                    if ( this.previousElementSibling ) {
		                        this.previousElementSibling.classList.add('is-prev');
		                    } else {
		                        videoSlides[videoSlides.length-1].classList.add('is-prev');
		                    }
		
		                    if ( this.nextElementSibling ) {
		                        this.nextElementSibling.classList.add('is-next');
		                    } else {
		                        console.log(videoSlides[0]);
		                        videoSlides[0].classList.add('is-next');
		                    }
		                }
		            }, false);
		        }
		
		        document.querySelector('.il-rs-video-control-prev').addEventListener('click', function( e ) {
		            e.preventDefault();
		
		        }, false);
		
			    document.querySelector('.il-rs-video-control-next').addEventListener('click', function( e ) {
			            e.preventDefault();
		
			            var activeIdx = 0;
		
			            for ( var k = 0; k < videoSlides.length; k++ ) {
			                if ( videoSlides[k] == videoSlideActive ) {
			                    activeIdx = k;
			                }
			            }
			        }, false);
			    }
		}
    function arrayListTemplate($id,data,valorarray,valoritem,tagsArray,varsArray,template,showPost){
		var valMax = data[0].getElementsByTagName(valorarray)[0];
		var valMItem = valMax.getElementsByTagName(valoritem);	
		var newtemplate = template;		
		if (showPost==0){
			showPost=valMItem.length;
		}
		for (var r=0;r<showPost;r++) {
			for (var a=0;a<tagsArray.length;a++){
				var valRoute = valMItem[r].getElementsByTagName(tagsArray[a]);
				if (valRoute.length > 0){
					var vartext = valRoute[0].textContent;	
					vartext = replaceAll(vartext,'[','<');
	    			vartext = replaceAll(vartext,']','>');
                    var allLett = new RegExp(varsArray[a], 'g');
					template= template.replace(allLett,vartext);
				}
			}	
			$id.append(template);	
            console.log(template);
			template = newtemplate; 			
		}	
		
	}

	function arrayself(){
		var heiht = $('#idjs_social_items').height();
		var cantFilas = Math.round(heiht/395);
		console.log(cantFilas);
		$('#fixedM').append('<span class="alingTop"></span><span class="alingBottom notmove"></span></div>');
		var countFila = 0;
		$('.alingTop').on('click',function(){  
			countFila++;
			if (countFila < cantFilas-2) {
			    var ccFila = 395*countFila;
			    console.log(ccFila);
			    var trs = 'translateY(-'+ccFila+'px)';
				$('#idjs_social_items').css('transform',trs);		    
		    }
		    else {
		    	if (countFila == cantFilas-2) {
				    var ccFila = 395*countFila;
				    console.log(ccFila);
				    var trs = 'translateY(-'+ccFila+'px)';
					$('#idjs_social_items').css('transform',trs);		    
					$('.alingTop').addClass('notmove');
			    } else {
			    	$('.alingTop').addClass('notmove');	
			    }		    	
		    }
		    $('.alingBottom').removeClass('notmove');
		    console.log(countFila);
		});
		$('.alingBottom').on('click',function(){  
			$('.alingTop').removeClass('notmove');
			countFila--;
			if (countFila > 0 ) {
			    var ccFila = 395*countFila;
				console.log(ccFila);
			    var trs = 'translateY(-'+ccFila+'px)';
				$('#idjs_social_items').css('transform',trs);		    
			}			
			else {
				if (countFila == 0){
					$('.alingBottom').addClass('notmove');
					var ccFila = 395*countFila;
					console.log(ccFila);
				    var trs = 'translateY(-'+ccFila+'px)';
					$('#idjs_social_items').css('transform',trs);		    
				} else {
					$('.alingBottom').addClass('notmove');
				}
			}
			console.log(countFila);
		});		

		$(window).scroll(function(){
			var scrollT = $(window).scrollTop();
			var sc = scrollT - 10;
			var h_inicial = $('.il-rs-social-responsability').offset().top;	
			var h_height = $('.il-rs-social-responsability').height();	
			if (sc > h_inicial && sc < h_height+250){
				$('#fixedM').addClass('active');
			}
			else {		
				$('#fixedM').removeClass('active');
			}
		});

	}
	
	function ToSeoUrl(url) {
	  var encodedUrl = url.toString().toLowerCase(); 
	  encodedUrl = encodedUrl.split(/\&+/).join("-y-")
	  encodedUrl = encodedUrl.replace(/á/gi,"a");
	  encodedUrl = encodedUrl.replace(/é/gi,"e");
	  encodedUrl = encodedUrl.replace(/í/gi,"i");
	  encodedUrl = encodedUrl.replace(/ó/gi,"o");
	  encodedUrl = encodedUrl.replace(/ú/gi,"u");
	  encodedUrl = encodedUrl.replace(/ñ/gi,"n");
	  encodedUrl = encodedUrl.split(/[^a-z0-9]/).join("-");  
	  encodedUrl = encodedUrl.split(/-+/).join("-");
	  encodedUrl = encodedUrl.trim('-'); 
	  return encodedUrl; 
	}

	function ajaxDoom(){
		$('.ajaxTrigger').on('click',function(){
			var $this = $(this);
			$this.closest('.il-rs-item-caption').find('.ajaxPost').trigger('click');	
		});

		$('.ajaxPost').on('click',function(){
			var $this = $(this);
			document.forms['responsocial']['title'].value = $this.attr('data-title');
			document.forms['responsocial']['image'].value = $this.attr('data-image');
			document.forms['responsocial']['date'].value = $this.attr('data-date');
			document.forms['responsocial']['contenido'].value = $this.attr('data-contenido'); 
			var htmlTitle = ToSeoUrl($this.attr('data-title'));
			document.forms['responsocial'].action = '/p/responsabilidad-social/'+htmlTitle+'.html';
			
			document.forms['responsocial'].submit();

		});
	}
	
	
	var articlesTemplate = `<div>
		<div class="il-rs-item-image">
			<span style="background-image: url({image})"></span>
		</div>
		<div class="il-rs-item-caption">
			<a href="javascript:void(0)" class="ajaxPost il-rs-item-title" data-title="{title}" data-image="{image}" data-date="{date}" data-contenido="{contenido}">{title}</a>
			<small>{date}</small>
			<div>
				<a href="javascript:void(0)" class="il-rs-item-link ajaxTrigger">
					<i><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 416 416" width="416" height="416"><path d="M208,0C93.1,0,0,93.1,0,208S93.1,416,208,416s208-93.1,208-208S322.9,0,208,0Zm0,398.7C102.9,398.7,17.3,313.2,17.3,208S102.9,17.3,208,17.3,398.7,102.9,398.7,208,313.1,398.7,208,398.7Z" fill="#df802f"/><polygon points="216.1 80 199.3 80 199.3 199.9 80 199.9 80 216.7 199.3 216.7 199.3 336 216.1 336 216.1 216.7 336 216.7 336 199.9 216.1 199.9 216.1 80" fill="#df802f"/></svg></i>
					<span>Ver más</span>
				</a>
			</div>
		</div>
		</div>`;

	var videosTemplate = `<div class="il-rs-video-item"><span style="background-image: url({image})"></span>
		<ul>
			<li><a href="javascript:void(0)" class="openModalVideo"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 34 34" width="34" height="34"><path d="M17,0A17,17,0,1,0,34,17,17,17,0,0,0,17,0Zm0,31A14,14,0,1,1,31,17,14,14,0,0,1,17,31Z" fill="#fff"/><polygon points="13.92 23.71 22.92 17 13.92 10.29 13.92 23.71" fill="#fff"/></svg></a></li>
			<li>
				<h5>{title}</h5>
				<p>{detalle}</p>
			</li>
		</ul>
	</div>`;

		var videoiframeTemplate = `<div class="md-wrapper modalVideo">
				<div class="md-content">
				<span class="md-close closeModalVideo">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="512" height="512"><polygon points="512 493.56 274.43 256 512 18.43 493.56 0 256 237.57 18.43 0 0 18.43 237.57 256 0 493.56 18.43 512 256 274.43 493.57 512 512 493.56" fill="#fff"/></svg>
				</span>
				<iframe src="{youtube}" frameborder="0"  frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen>></iframe>
				</div>
			</div>`;
			
		var logoTemplate = `<li class="col-md-2"><a href="javascript:void(0)" class="logoModalOpen"><img src="{imagen}"></a></li>`;
			
			var logoTemplateContent = `<div class="md-wrapper logoModal">
			<div class="md-content ">
			<span class="md-close logoModalClose">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="512" height="512"><polygon points="512 493.56 274.43 256 512 18.43 493.56 0 256 237.57 18.43 0 0 18.43 237.57 256 0 493.56 18.43 512 256 274.43 493.57 512 512 493.56" fill="#fff"/></svg>
			</span>
			<div class="md-caption imagenTemplateLogo">
			<span><img src="{image}"></span>
			<p>{detalle}</p>
			</div>
			</div>
			</div>`;
		var mostrarArticles = 2;
	$.ajax({    		  
		url: "<%= Constants.responsabilidadSocialXML %>",
		cache: false,
		success: function(res) {
		  	var xmlDoc = res;
		  	var data = xmlDoc.getElementsByTagName("responsabilidad_social");
		  	if (data[0]) {  		  		
		  		printvaloresgenerales('jsid_monto','rs_monto',data);
		  		printvaloresgenerales('jsid_description','rs_descripcion',data);
		  		printvaloresgenerales('jsid_sumilla','rs_sumilla',data);
		  		changeprintvaloresgenerales('jsid_sumilla_detalle','rs_sumilla_detalle',data);

		  		arrayListTemplate($('#idjs_social_items'),data,'rs_articles','rs_article',['rs_title','rs_image_route','rs_date','rs_content'],['{title}','{image}','{date}','{contenido}'],articlesTemplate,2);	

				arrayListTemplate($('#idjs_video_list'),data,'rs_videos','rs_video',['rs_title','rs_image_route','rs_detalle'],['{title}','{image}','{detalle}'],videosTemplate,0);

				arrayListTemplate($('#idjs_videocontent'),data,'rs_videos','rs_video',['rs_youtube_route'],['{youtube}'],videoiframeTemplate,0);

				arrayListTemplate($('#idjs_logo'),data,'rs_logos','rs_logo',['rs_image_route'],['{imagen}'],logoTemplate,0);

				arrayListTemplate($('#idjs_logocontent'),data,'rs_logos','rs_logo',['rs_detalle','rs_image_route'],['{detalle}','{image}'],logoTemplateContent,0);
				
		  		var articlesL = data[0].getElementsByTagName('rs_articles')[0].getElementsByTagName('rs_article').length;
		  		$('#idjs_morearticle').on('click',function(){
		  			mostrarArticles = mostrarArticles + 2;
		  			console.log(mostrarArticles+':'+articlesL);
		  			if(mostrarArticles == 4) {
			  			$('#idjs_social_items').html('');
		  				arrayListTemplate($('#idjs_social_items'),data,'rs_articles','rs_article',['rs_title','rs_image_route','rs_date','rs_content'],['{title}','{image}','{date}','{contenido}'],articlesTemplate,4);
		  				arrayself();
		  				ajaxDoom();	
			  		}		  			
			  		if (mostrarArticles == 6) {
				  		$('.overControl').removeClass('dontSee');
				  		$('#fixedM').html('');
			  			$('#idjs_social_items').html('');
			  			arrayListTemplate($('#idjs_social_items'),data,'rs_articles','rs_article',['rs_title','rs_image_route','rs_date','rs_content'],['{title}','{image}','{date}','{contenido}'],articlesTemplate,0);
			  			arrayself();		  			
			  			ajaxDoom();			  			
		  				$('#idjs_morearticle').addClass('bloqued');
				  	}			  		
			  	});
		  		videoslide();
		  		ajaxDoom();
		  		$('.openModalVideo').on("click",function(){
					var $this = $(this);
				 	var ind = $this.closest('.il-rs-video-item').index();
					console.log(ind);
					$('#idjs_videocontent .modalVideo').eq(ind).addClass('active');
				});
				$('.closeModalVideo').on("click",function(){
					var $this = $(this);
				 	$this.closest('.modalVideo').removeClass('active');
				 	var $video = $this.closest('.modalVideo').find('iframe');
				 	var src = $video.attr("src");
				    $video.attr("src","");
				    $video.attr("src",src);
				});
				$('.logoModalOpen').on("click",function(){
					var $this = $(this);
				 	var ind = $this.closest('li').index();
					console.log(ind);
					$('#idjs_logocontent .logoModal').eq(ind).addClass('active');
				});
				$('.logoModalClose').on("click",function(){
					var $this = $(this);
				 	$this.closest('.logoModal').removeClass('active');
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