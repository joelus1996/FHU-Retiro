var title_error_general = "No pudimos procesar tu petición";
var msg_error_general = "Por favor, inténtalo de nuevo en unos minutos";
var bdate = new Date();
var intervalVisanet = 0;	
var intervalAgora = 0;
var maxMb=10;
var imgBase64P1 = "";
var imgBase64P2 = "";
var imgBase64P1Cash = "";
var imgBase64P2Cash = "";
var imgBase64P1Agora = "";
var imgBase64P2Agora = "";
var imgBase64P1Trans = "";
var imgBase64P2Trans = "";
var imgBase64P1TransPML = "";
var imgBase64P2TransPML = "";
var amountMinEnableDni = 0;
var amountMinEnableDniCash = 0;
var amountMinEnableDniAgora = 0;
var amountMinEnableDniTrans = 0;
var minAccAmtEnblDniVisa = 0;
var minAccAmtEnblDniAgora = 0;
var minAccAmtEnblDniCash = 0;
var minAccAmtEnblDniTrans = 0;
var accAmtVisa = 0;
var accAmtCash = 0;
var accAmtAgora = 0;
var accAmtTrans = 0;
var stateDni = "";
var amountMinRequestCash = 0;
var amountMinRequestVisa = 0;
var amountMinRequestAgora = 0;
var amountMinRequestTrans = 0;
var configLoaded;
var formularioEfectivo;
var formularioTransferencia;
var formularioTransferenciaPML;
var transHorarios="";
var transLimites="";
var transHorariosRan1="";
var transLimitesRan1="";
var transHorariosRan2="";
var transLimitesRan2="";
var transHorariosRan3="";
var transLimitesRan3="";
var transRangoActivo="";
var objListAccount;
var daysElapsedDni=0;
var pantallaListaRecurrente=false;
var htmlPantallaRecurrenteRango1="";
var htmlPantallaRecurrenteRango2_3="";
var htmlBancosDisponiblesRango1='<option value="">Selecciona un banco</option><option value="1">Interbank</option><option value="2">BCP. Banco de Crédito del Perú</option><option value="3">BBVA. Banco Continental</option><option value="4">Scotiabank</option><option value="5">Otro banco - usa tu CCI (código interbancario)</option>';
var htmlBancosDisponiblesRango2_3='<option value="">Selecciona un banco</option><option value="1">Interbank</option><option value="2">BCP. Banco de Crédito del Perú</option><option value="3">BBVA. Banco Continental</option><option value="5">Otro banco - usa tu CCI (código interbancario)</option>';
var hmPremiosMayoresLoterias = new Map();
var tipoTransferencia="";
var premioSeleccionado;
/**************************************
 * Accordion
 **************************************/
const accordion = (function () {
  'use strict';
  const content = $('.accordion'),
    title = content.find('.accordion__item:not(.is-modal) .accordion__title'),

    onClickTitle = function () {
      const li = $(this).closest('li'),
        body = li.find('> .accordion__body');

      if (body.length > 0) {
        if (!li.hasClass('opened')) {
          body.slideDown(300);
          setTimeout(function () {
            li.addClass('opened');
          }, 100);

          li.siblings().removeClass('opened').find('.accordion__body').slideUp(300);
        } else {
          body.slideUp(300, function () {
            li.removeClass('opened');
          });
        }
      }
    },

    init = function () {
      title.on('click', onClickTitle);
    };

  return {
    init: init
  };
}());

/**************************************
 * input
 **************************************/
const inputField = (function () {
  'use strict';
  const input = $('.ipremio .input input'),

    onFocus = function () {
      const parent = $(this).closest('.form-item');
      parent.addClass('is-focus');
    },

    onBlur = function () {
      if ($.trim($(this).val()) === '') {
        const parent = $(this).closest('.form-item');
        parent.removeClass('is-focus');
      }
    },

    init = function () {
      input.on('focus', onFocus);
      input.on('blur', onBlur);
    };

  return {
    init: init
  };
}());

/**************************************
 * select
 **************************************/
const selectField = (function () {
  'use strict';
  const selectAll = $('.ipremio .select select'),

    onChange = function () {
      const select = $(this),
        parent = select.closest('.form-item');

      parent.find(".opt-control").text(select.children(":selected").text());

      if (select.val() === '') {
        parent.removeClass('is-active');
      } else {
        parent.addClass('is-active');
        parent.removeClass('is-error');
      }
    },

    run = function () {
      selectAll.each(onChange)
    },

    init = function () {
      run();
      selectAll.on('change', onChange);
    };

  return {
    init: init
  };
}());

/**************************************
 * fileupload image
 **************************************/
const fileupImg = (function () {
  'use strict';
  //const file = $('.ipremio .upimage'),
  const file = $('#imgDNI'),
  onChangeFile = function () {
      var img = this.files[0],
        parent = $(this).closest('.fileup-image'),
        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
        filenames = parent.find('.filenames'),
        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
        reader;
               
        if(img!=undefined && img!=null){
           if(img.type=="image/png" || img.type=="image/jpeg"){
	    	  if((img.size/1024/1024)<=maxMb){ 
			      if ($(this).val() !== '') {
			    	var sizeImgDNI = img.size;
			    				          
			        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNIVisa" class="delimg icon-error-min"></span></span>');
			        
			        $("#stateDniACT").css("display","none");
			        
			        parent.removeClass('is-error');
			        $('#divDniLabel').removeClass('is-error');
			        filenames.removeClass('empty');        
		        	
		        	var ctx = document.getElementById('canvasDNI').getContext('2d');
		        	var imgCanvas = new Image;
			        if(sizeImgDNI>7000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.2);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>5000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.25);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>4000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.3);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>3000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.38);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>2000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.45);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1500000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.55);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.70);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>800000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.85);
			        		imgBase64P1 = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else{
		        		imgCanvas.onload = function() {
			        		reader = new FileReader();
					        reader.readAsDataURL(img);
				        	reader.onloadend = function () {
				        		imgBase64P1 = reader.result;
				        	};
		        		}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}
			        
			        imgCanvas.onerror = function() {
			        	$("#delimgDNIVisa").trigger("click");
			        	showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
		        	}
			      }  
	    	  }else{
	    		  showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
	    	  }
	      }else{
	    	  showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
	      }
        }else{
        	$("#delimgDNIVisa").trigger("click");
        }
    },

    onChangeMultiple = function () {
      var imgs = this.files,
        parent = $(this).closest('.fileup-image'),
        filename = parent.find('.filename-multiple'),
        filenames = parent.find('.filenames'),
        html = [],
        reader,
        img;

      for (var i = 0; i < imgs.length; i++) {
        img = imgs[i];

        if (img.name !== '') {
          reader = new FileReader();
          reader.readAsDataURL(img);
          html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')
        }
      }

      filename.html(html.join(''));
      parent.removeClass('is-error');
      $('#divDniLabel').removeClass('is-error');
      filenames.removeClass('empty');
    },

    delImage = function () {
      var del = $(this),
        supercontent = del.closest('.fileup-image'),
        content = del.closest('.filenames'),
        type = del.parent().attr('type');

      del.parent().remove();
      supercontent.find('.' + type).removeClass('hide').find('.upimage').val('');

      if (type === 'img-simple') {
        imgBase64P1 = "";
      } else {
        supercontent.find('.img-simple').addClass('hide');
        imgBase64P2 = "";
      }


      if (content.find('.filename').length == 0) {
	  	if(stateDni==='PEN'){
			content.addClass('empty');
		}
        supercontent.find('.img-simple').removeClass('hide');
      }
    },

    init = function () {
      file.on('change', onChangeFile);
      $("#updateDNI").on('click', (function () {$("#imgDNI").trigger("click")}));
      file.closest('.fileup-image').on('click', '.delimg', delImage);
    };

  return {
    init: init
  };
}());

/**************************************
 * fileupload image agora
 **************************************/
const fileupImgAgora = (function () {
  'use strict';

  const file = $('#imgDNIAgora'),
  onChangeFile = function () {
      var img = this.files[0],
        parent = $(this).closest('.fileup-image'),
        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
        filenames = parent.find('.filenames'),
        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
        reader;
        
        if(img!=undefined && img!=null){
	      if(img.type=="image/png" || img.type=="image/jpeg"){
	    	  if((img.size/1024/1024)<=maxMb){  
			      if ($(this).val() !== '') {
			        var sizeImgDNI = img.size;
			    				        
			        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNIAgora" class="delimg icon-error-min"></span></span>');
			      
			        $("#stateDniACTAgora").css("display","none");
			        
			        parent.removeClass('is-error');
			        $('#divDniLabelAgora').removeClass('is-error');
			        filenames.removeClass('empty');
			        		        		 
		        	var ctx = document.getElementById('canvasDNIAgora').getContext('2d');
		        	var imgCanvas = new Image;
			        if(sizeImgDNI>7000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.2);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>5000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.25);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>4000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.3);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>3000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.38);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>2000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.45);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1500000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.55);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.70);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>800000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.85);
			        		imgBase64P1Agora = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else{
			        	imgCanvas.onload = function() {
			        		reader = new FileReader();
					        reader.readAsDataURL(img);
				        	reader.onloadend = function () {
				        		imgBase64P1Agora = reader.result;
				        	};
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}
			        
			        imgCanvas.onerror = function() {
			        	$("#delimgDNIAgora").trigger("click");
			        	showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
		        	}
			      }  
	    	  }else{
	    		  showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
	    	  }
	      }else{
	    	  showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
	      }
        }else{
        	$("#delimgDNIAgora").trigger("click");
        }
    },

    onChangeMultiple = function () {
      var imgs = this.files,
        parent = $(this).closest('.fileup-image'),
        filename = parent.find('.filename-multiple'),
        filenames = parent.find('.filenames'),
        html = [],
        reader,
        img;

      for (var i = 0; i < imgs.length; i++) {
        img = imgs[i];

        if (img.name !== '') {
          reader = new FileReader();
          reader.readAsDataURL(img);
          html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')
        }
      }

      filename.html(html.join(''));
      parent.removeClass('is-error');
      $('#divDniLabelAgora').removeClass('is-error');
      filenames.removeClass('empty');
    },

    delImage = function () {
      var del = $(this),
        supercontent = del.closest('.fileup-image'),
        content = del.closest('.filenames'),
        type = del.parent().attr('type');

      del.parent().remove();      
      supercontent.find('.' + type).removeClass('hide').find('.upimage').val('');

      if (type === 'img-simple') {
    	imgBase64P1Agora = "";
      } else {
        supercontent.find('.img-simple').addClass('hide');
        imgBase64P2Agora = "";
      }

      if (content.find('.filename').length == 0) {
    	  if(stateDni==='PEN'){
    		  content.addClass('empty');
    	  }        
        supercontent.find('.img-simple').removeClass('hide');
      }
    },

    init = function () {
      file.on('change', onChangeFile);
      $("#updateDNIAgora").on('click', (function () {$("#imgDNIAgora").trigger("click")}));
      file.closest('.fileup-image').on('click', '.delimg', delImage);
    };

  return {
    init: init
  };
}());

/**************************************
 * fileupload image efectivo
 **************************************/
const fileupImgEfectivo = (function () {
	  'use strict';
	  const file = $("#imgDNIEfectivo"),

	  onChangeFile = function () {
	      var img = this.files[0],
	        parent = $(this).closest('.fileup-image'),
	        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
	        filenames = parent.find('.filenames'),
	        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
	        reader;
	        
	        if(img!=undefined && img!=null){
		      if(img.type=="image/png" || img.type=="image/jpeg"){
		    	  if((img.size/1024/1024)<=maxMb){  
				      if ($(this).val() !== '') {
				        var sizeImgDNI = img.size;
				    				        
				        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNIEfectivo" class="delimg icon-error-min"></span></span>');
				      
				        $("#stateDniACTEfectivo").css("display","none");
				        	
				        parent.removeClass('is-error');
				        $('#divDniLabelEfectivo').removeClass('is-error');
				        filenames.removeClass('empty'); 
				        		        		 
			        	var ctx = document.getElementById('canvasDNIEfectivo').getContext('2d');
			        	var imgCanvas = new Image;
				        if(sizeImgDNI>7000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.2);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>5000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.25);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>4000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.3);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>3000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.38);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>2000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.45);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>1500000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.55);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>1000000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.70);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else if(sizeImgDNI>800000){
				        	imgCanvas.onload = function() {
				        		var newCanvas = downScaleImage(imgCanvas, 0.85);
				        		imgBase64P1Cash = newCanvas.toDataURL(img.type);
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}else{				        	
				        	imgCanvas.onload = function() {
				        		reader = new FileReader();
						        reader.readAsDataURL(img);
					        	reader.onloadend = function () {
					        		imgBase64P1Cash = reader.result;
					        	};
				        	}
				        	imgCanvas.src = URL.createObjectURL(img);
			        	}
				        
				        imgCanvas.onerror = function() {
				        	$("#delimgDNIEfectivo").trigger("click");
				        	showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
			        	}
				      }  
		    	  }else{
		    		  showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
		    	  }
		      }else{
		    	  
		    	  showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
		      }
	        }else{
	        	$("#delimgDNIEfectivo").trigger("click");
	        }
	    },

	    onChangeMultiple = function () {
	      var imgs = this.files,
	        parent = $(this).closest('.fileup-image'),
	        filename = parent.find('.filename-multiple'),
	        filenames = parent.find('.filenames'),
	        html = [],
	        reader,
	        img;

	      for (var i = 0; i < imgs.length; i++) {
	        img = imgs[i];

	        if (img.name !== '') {
	          reader = new FileReader();
	          reader.readAsDataURL(img);
	          html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')
	        }
	      }

	      filename.html(html.join(''));
	      parent.removeClass('is-error');
	      $('#divDniLabelEfectivo').removeClass('is-error');
	      filenames.removeClass('empty');
	    },

	    delImage = function () {
	      var del = $(this),
	        supercontent = del.closest('.fileup-image'),
	        content = del.closest('.filenames'),
	        type = del.parent().attr('type');

	      del.parent().remove();      
	      supercontent.find('.' + type).removeClass('hide').find('.upimage').val('');

	      if (type === 'img-simple') {
	        imgBase64P1Cash = "";
	      } else {
	        supercontent.find('.img-simple').addClass('hide');
	        imgBase64P2Cash = "";
	      }


	      if (content.find('.filename').length == 0) {
	    	  if(stateDni==='PEN'){
	    		  content.addClass('empty');
	    	  }
	        
	        supercontent.find('.img-simple').removeClass('hide');
	      }
	    },

	    init = function () {
	      file.on('change', onChangeFile);
	      $("#updateDNIEfectivo").on('click', (function () {$("#imgDNIEfectivo").trigger("click")}));
	      file.closest('.fileup-image').on('click', '.delimg', delImage);
	    };

	  return {
	    init: init
	  };
	}());
/**************************************
 * fileupload image transferencia
 **************************************/
const fileupImgTransferencia = (function () {
  'use strict';

  const file = $('#imgDNITransferencia'),
  onChangeFile = function () {
      var img = this.files[0],
        parent = $(this).closest('.fileup-image'),
        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
        filenames = parent.find('.filenames'),
        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
        reader;
        
        if(img!=undefined && img!=null){
	      if(img.type=="image/png" || img.type=="image/jpeg"){
	    	  if((img.size/1024/1024)<=maxMb){  
			      if ($(this).val() !== '') {
			        var sizeImgDNI = img.size;
			    				        
			        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferencia" class="delimg icon-error-min"></span></span>');
			      
			        $("#stateDniACTTransferencia").css("display","none");
			        
			        parent.removeClass('is-error');
			        $('#divDniLabelTransferencia').removeClass('is-error');
			        filenames.removeClass('empty');
			        		        		 
		        	var ctx = document.getElementById('canvasDNITransferencia').getContext('2d');
		        	var imgCanvas = new Image;
			        if(sizeImgDNI>7000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.2);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>5000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.25);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>4000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.3);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>3000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.38);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>2000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.45);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1500000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.55);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.70);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>800000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.85);
			        		imgBase64P1Trans = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else{
			        	imgCanvas.onload = function() {
			        		reader = new FileReader();
					        reader.readAsDataURL(img);
				        	reader.onloadend = function () {
				        		imgBase64P1Trans = reader.result;
				        	};
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}
			        
			        imgCanvas.onerror = function() {
			        	$("#delimgDNITransferencia").trigger("click");
			        	showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
		        	}
			      }  
	    	  }else{
	    		  showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
	    	  }
	      }else{
	    	  showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
	      }
        }else{
        	$("#delimgDNITransferencia").trigger("click");
        }
    },

    onChangeMultiple = function () {
      var imgs = this.files,
        parent = $(this).closest('.fileup-image'),
        filename = parent.find('.filename-multiple'),
        filenames = parent.find('.filenames'),
        html = [],
        reader,
        img;

      for (var i = 0; i < imgs.length; i++) {
        img = imgs[i];

        if (img.name !== '') {
          reader = new FileReader();
          reader.readAsDataURL(img);
          html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')
        }
      }

      filename.html(html.join(''));
      parent.removeClass('is-error');
      $('#divDniLabelTransferencia').removeClass('is-error');
      filenames.removeClass('empty');
    },

    delImage = function () {
      var del = $(this),
        supercontent = del.closest('.fileup-image'),
        content = del.closest('.filenames'),
        type = del.parent().attr('type');

      del.parent().remove();      
      supercontent.find('.' + type).removeClass('hide').find('.upimage').val('');

      if (type === 'img-simple') {
    	imgBase64P1Trans = "";
      } else {
        supercontent.find('.img-simple').addClass('hide');
        imgBase64P2Trans = "";
      }

      if (content.find('.filename').length == 0) {
    	  if(stateDni==='PEN'){
    		  content.addClass('empty');
    	  }        
        supercontent.find('.img-simple').removeClass('hide');
      }
    },

    init = function () {
      file.on('change', onChangeFile);
      $("#updateDNITransferencia").on('click', (function () {$("#imgDNITransferencia").trigger("click")}));
      file.closest('.fileup-image').on('click', '.delimg', delImage);
    };

  return {
    init: init
  };
}());

/**************************************
 * fileupload image transferencia premio mayor loteria PML
 **************************************/
const fileupImgTransferenciaPML = (function () {
  'use strict';

  const file = $('#imgDNITransferenciaPML'),
  onChangeFile = function () {
      var img = this.files[0],
        parent = $(this).closest('.fileup-image'),
        filename = ($(this).hasClass('is-simple')) ? parent.find('.filename-simple'): parent.find('.filename-other'),
        filenames = parent.find('.filenames'),
        type = ($(this).hasClass('is-simple')) ? 'img-simple': 'img-other',
        reader;
        
        if(img!=undefined && img!=null){
	      if(img.type=="image/png" || img.type=="image/jpeg"){
	    	  if((img.size/1024/1024)<=maxMb){  
			      if ($(this).val() !== '') {
			        var sizeImgDNI = img.size;
			    				        
			        filename.html('<span class="filename" type="' + type + '">'+ img.name +'<span id="delimgDNITransferenciaPML" class="delimg icon-error-min"></span></span>');
			      
			        $("#stateDniACTTransferenciaPML").css("display","none");
			        
			        parent.removeClass('is-error');
			        filenames.removeClass('empty');
			        		        		 
		        	var ctx = document.getElementById('canvasDNITransferenciaPML').getContext('2d');
		        	var imgCanvas = new Image;
			        if(sizeImgDNI>7000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.2);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>5000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.25);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>4000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.3);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>3000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.38);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>2000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.45);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1500000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.55);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>1000000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.70);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else if(sizeImgDNI>800000){
			        	imgCanvas.onload = function() {
			        		var newCanvas = downScaleImage(imgCanvas, 0.85);
			        		imgBase64P1TransPML = newCanvas.toDataURL(img.type);
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}else{
			        	imgCanvas.onload = function() {
			        		reader = new FileReader();
					        reader.readAsDataURL(img);
				        	reader.onloadend = function () {
				        		imgBase64P1TransPML = reader.result;
				        	};
			        	}
			        	imgCanvas.src = URL.createObjectURL(img);
		        	}
			        
			        imgCanvas.onerror = function() {
			        	$("#delimgDNITransferenciaPML").trigger("click");
			        	showMessageError(title_error_general,"Debes adjuntar una imagen v&aacute;lida");
		        	}
			      }  
	    	  }else{
	    		  showMessageError(title_error_general,"Tu imagen debe ser menor a "+maxMb+"MB.");
	    	  }
	      }else{
	    	  showMessageError(title_error_general,"Solo se permiten imágenes con extensión JPG o PNG.");
	      }
        }else{
        	$("#delimgDNITransferenciaPML").trigger("click");
        }
    },

    onChangeMultiple = function () {
      var imgs = this.files,
        parent = $(this).closest('.fileup-image'),
        filename = parent.find('.filename-multiple'),
        filenames = parent.find('.filenames'),
        html = [],
        reader,
        img;

      for (var i = 0; i < imgs.length; i++) {
        img = imgs[i];

        if (img.name !== '') {
          reader = new FileReader();
          reader.readAsDataURL(img);
          html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')
        }
      }

      filename.html(html.join(''));
      parent.removeClass('is-error');
      filenames.removeClass('empty');
    },

    delImage = function () {
      var del = $(this),
        supercontent = del.closest('.fileup-image'),
        content = del.closest('.filenames'),
        type = del.parent().attr('type');

      del.parent().remove();      
      supercontent.find('.' + type).removeClass('hide').find('.upimage').val('');

      if (type === 'img-simple') {
    	imgBase64P1TransPML = "";
      } else {
        supercontent.find('.img-simple').addClass('hide');
        imgBase64P2TransPML = "";
      }

      if (content.find('.filename').length == 0) {
    	  if(stateDni==='PEN'){
    		  content.addClass('empty');
    	  }        
        supercontent.find('.img-simple').removeClass('hide');
      }
    },

    init = function () {
      file.on('change', onChangeFile);
      $("#updateDNITransferenciaPML").on('click', (function () {$("#imgDNITransferenciaPML").trigger("click")}));
      file.closest('.fileup-image').on('click', '.delimg', delImage);
    };

  return {
    init: init
  };
}());
/**************************************
 * modal
 **************************************/
const simpleModal = (function () {
  'use strict';
  let modalClose = $('.modal .iclose'),
      modalToggle = $('.modal [toggle-modal]'),

    open = function (select) {
      let box = $(select);
      box.fadeIn(350);
      $('body').addClass('no-scroll');

    },

    close = function (select) {
      const box = $(select);
      box.fadeOut(250, function () {
        $('body').removeClass('no-scroll');
      });
    },

    onClickClose = function () {
      const box = $(this).closest('.ioverlay');

      box.fadeOut(250, function () {
        $('body').removeClass('no-scroll');
      });
    
      try {
    	  window.parent.postMessage('closeLightboxCollectPrize','*');
	  } catch (e) {   }
      
    },

    preOpen = function (e) {
      e.preventDefault();
      open($(this).attr('open-modal'));
    },

    onToggleModal = function (e) {
      e.preventDefault();
      var target = $(e.currentTarget).attr('toggle-modal');
      const box = $('.ioverlay');
      
      if(target === "#modal-listado"){
    	  var sizeList = getHisPayment();
    	  if(sizeList==0){
    		  target = "#modal-historial-sin-retiro";
    	  }else if(sizeList<0){
    		  return
    	  }
      }
      
      if(target === "#modal-premios"){
    	  cleanPaymentPrize();
      }
      
      box.fadeOut(250, function () {
        $('body').removeClass('no-scroll');
        setTimeout(function () {
          open(target);
        }, 250);
      });
    },
    
    onToggleModalButton = function (e) {
        const target = $(e).attr('toggle-modal');
        const box = $('.ioverlay');
        
        const numberSol =  $(e).attr('data-number'); 
        
        if(target === "#modal-ticket2"){
      	  var state = getTicketsPrizes(numberSol);
      	  if (state<0){
      		  return;
      	  }
        }
        
        box.fadeOut(250, function () {
          $('body').removeClass('no-scroll');
          setTimeout(function () {
            open(target);
          }, 250);
        });
      },
      
      onToggleModalButtonOld = function (e) {
          const target = $(e).attr('toggle-modal');
          const box = $('.ioverlay');
          
          const numberSol =  $(e).attr('data-number'); 
          
          if(target === "#modal-ticket2"){
        	  var state = getTicketsPrizesOld(numberSol);
        	  if (state<0){
          		  return;
          	  }
          }
          
          box.fadeOut(250, function () {
            $('body').removeClass('no-scroll');
            setTimeout(function () {
              open(target);
            }, 250);
          });
        },
      
      onToggleModalMsg = function (toggle) {
          const target = toggle;
          const box = $('.ioverlay');                   
          box.fadeOut(250, function () {
            $('body').removeClass('no-scroll');
            setTimeout(function () {
              open(target);
            }, 250);
          });
        },

    init = function () {
      modalClose.on('click', onClickClose);
      modalToggle.on('click', onToggleModal);
      $('*[open-modal]').on('click', preOpen);
    };

  return {
    init: init,
    open: open,
    close: close,
    onToggleModalButton: onToggleModalButton,
    onToggleModalMsg: onToggleModalMsg,
    onToggleModalButtonOld: onToggleModalButtonOld
  };
}());

/**************************************
 * Alphanumeric
 **************************************/
const setNumeric = function () {
  $('.is-numeric').numeric({
    allowMinus   : false,
    allowPlus    : false,
    allowThouSep : false,
    allowDecSep : false
  });

  $('.is-email').alphanum({
    allowSpace: false,
    disallow: '´ç¡·¿œ®†¥øπ§¶™ƒ∂∫åΩ∑©√ßµ„…',
    allow: '-_@.'
  });
}

/**************************************
 * Calendar
 **************************************/
const setCalendar = (function () {
  const input = $('.is-calendar input'),

    render = function () {
      input.datepicker({
        language: 'es-ES',
        offset: 8,
        autoHide: true,
        format: 'dd/mm/YYYY',
        endDate: bdate
      });

      if (input.length > 0) {
        new Cleave('#startdate', {
          date: true,
          delimiter: '/',
          datePattern: ['d', 'm', 'Y']
        });
        new Cleave('#enddate', {
          date: true,
          delimiter: '/',
          datePattern: ['d', 'm', 'Y']
        });
      }
    },

    change = function () {
      $(this).closest('.form-item').addClass('is-focus');
    },

    range = function () {
      $endDate = $('#enddate');
      $startDate = $('#startdate');

      $endDate.datepicker({
        autoHide: true,
        startDate: $startDate.datepicker('getDate'),
        //endDate: bdate,
      });

      $startDate.on('change blur', function () {
        const orginalDate = new Date($startDate.datepicker('getDate')),
          monthsAddedDate = new Date(new Date(orginalDate).setMonth(orginalDate.getMonth() + 12));

        $endDate.datepicker('setStartDate', $startDate.datepicker('getDate'));
        //$endDate.datepicker('setEndDate', monthsAddedDate);
      });
    }

    init = function () {
      render();
      input.on('change', change);
      range();
    };

  return {
    init: init
  };
}());

/**************************************
 * Premios
 **************************************/
const formVisa = (function () {
  let idCard =  0;
  const form = $('#formvisa'),
    btnSend = form.find('.btn-solicitar'),
    delcard = form.find('.delradio'),
    $divComision = form.find('.subcontent-comision'),
    $inputMonto = form.find('input[name="iamount"]'),
    
    onChangeField = function () {
	  var comision = getComisionVisa(parseInt($inputMonto.val(), 10));
	  if(comision>0){
		  $divComision.removeClass('hidden');
		  $("#monto_comision_visanet").html( $.trim(configLoaded.msjComVisa)+ ' ' + floatFormat(comision));
	  }else{
  		$divComision.addClass('hidden');
  	  }
  	},

    send = function (e) {
      e.preventDefault();
      const valid = form.formValidate();

      if (valid) {
    	  createRequest(e,"createRequestVisa.html","amountVisa="+$('#amountVisa').val()+"&imgDNI="+imgBase64P1);
      }
    },

    openModalDelCard = function () {
      idCard = $(this).parent('.item-radio').attr('key');
      simpleModal.open('#modal-delcard');
    },

    delCard = function () {
      form.find('.item-radio[key="' + idCard + '"]').remove();
      simpleModal.close('#modal-delcard');
    },

    init = function () {
      btnSend.on('click', send);
      delcard.on('click', openModalDelCard);
      $('#modal-delcard .confirmdel').on('click', delCard);
      form.blurValidate();
    };

    $inputMonto.on('change keyup', onChangeField);
    
  return {
    init: init
  };
}());

const formAgora = (function () {
	  const form = $('#formagora'),
	    btnSend = form.find('.btn-solicitar'),
	    $divComision = form.find('.subcontent-comision'),
	    $inputMonto = form.find('input[name="iamount"]'),
	    
	    onChangeField = function () {
		  var comision = getComisionAgora(parseInt($inputMonto.val(), 10));
		  if(comision>0){
			  $divComision.removeClass('hidden');
			  $("#monto_comision_agora").html( $.trim(configLoaded.msjComAgr)+ ' ' + floatFormat(comision));
		  }else{
	  		$divComision.addClass('hidden');
	  	  }
	  	},

	    send = function (e) {
	      e.preventDefault();
	      const valid = form.formValidate();
	     
	      if (valid) {
	    	  createRequest(e,"createRequestAgora.html","amountAgora="+$('#amountAgora').val()+"&imgDNIAgora="+imgBase64P1Agora);
	      }
	    },

	    init = function () {
	      btnSend.on('click', send);
	      form.blurValidate();
	    };
	    
	    $inputMonto.on('change keyup', onChangeField);

	  return {
	    init: init
	  };
}());

const formEfectivo = (function () {
  const form = $('#formefectivo'),
    btnSend = form.find('.btn-solicitar'),

    send = function (e) {
      e.preventDefault();
      const valid = form.formValidate();

      if (valid) {
    	  formularioEfectivo = e;
    	  var montoEfectivo = $('#amountEfectivo').val();
    	  if (montoEfectivo>=100){
    		  confirmarRetiroEfectivo();
    	  }else{
    		  createRequest(e,"createRequest.html","amountEfectivo="+$('#amountEfectivo').val()+"&imgDNI="+imgBase64P1Cash);
    	  }
      }
    },

    init = function () {
      btnSend.on('click', send);
      form.blurValidate();
    };

  return {
    init: init
  };
}());

const formTransferencia = (function () {
	  const form = $('#formtransferencia'),
	    btnSend = form.find('.btn-solicitar'),     
	    bybank = form.find('.bybank'),
	    
	    send = function (e) {
	        e.preventDefault();
	        const valid = form.formValidate();
	        tipoTransferencia="";
	        $('#aceptar-confirmar-retiro-transferencia').removeAttr("disabled");
	    	$('#regresar-transferencia').removeAttr("disabled");
	        
	        if(pantallaListaRecurrente){
	        	if (valid && $('input[name=card]:checked', '#formtransferencia').val()!=undefined) {
	        		formularioTransferencia = e;
	                confirmarRetiroTransferencia();
	        	}
	        }else{
	        	if (valid) {
	        		formularioTransferencia = e;
	                confirmarRetiroTransferencia();
	            }
	        }
	     },
	    
	    changeRangeLength = function () {
	    	var ibanco = $('#ibanco').val();
	    	if(ibanco==1){//ibk
	    		$('#inumacount').attr("maxlength", 13);
	    		$('#inumacount').attr("data-min", 13);
	    		$('#inumacount').attr("data-max", 13);
	    	}else if(ibanco==2){//bcp
	    		$('#inumacount').attr("maxlength", 14);
	    		$('#inumacount').attr("data-min", 14);
	    		$('#inumacount').attr("data-max", 14);
	    	}else if(ibanco==3){//bbva
	    		$('#inumacount').attr("maxlength", 18);
	    		$('#inumacount').attr("data-min", 18);
	    		$('#inumacount').attr("data-max", 18);
	    	}else if(ibanco==4){//scotia
	    		$('#inumacount').attr("maxlength", 10);
	    		$('#inumacount').attr("data-min", 10);
	    		$('#inumacount').attr("data-max", 10);
	    	}else if(ibanco==5){//otros
	    		$('#inumacount').attr("maxlength", 20);
	    		$('#inumacount').attr("data-min", 20);
	    		$('#inumacount').attr("data-max", 20);
	    	}
	    },

	    init = function () {
	      btnSend.on('click', send);
	      form.blurValidate();
	      bybank.on('change', changeRangeLength);
	    };

	  return {
	    init: init
	  };
	}());

const formTransferenciaPML = (function () {
	  const form = $('#formtransferenciapml'),
	    btnSend = form.find('.btn-solicitar'),     
	    bybank = form.find('.bybank'),
	    
	    send = function (e) {
	        e.preventDefault();
	        const valid = form.formValidate();
	        tipoTransferencia="PML";
	        
	    	$('#aceptar-confirmar-retiro-transferencia').removeAttr("disabled");
	    	$('#regresar-transferencia').removeAttr("disabled");
	    	
	        if(pantallaListaRecurrente){
	        	if (valid && $('input[name=card]:checked', '#formtransferenciapml').val()!=undefined) {
	        		formularioTransferenciaPML = e;
	        		confirmarRetiroTransferenciaPML();
	        	}
	        }else{
	        	if (valid) {
	        		formularioTransferenciaPML = e;
	        		confirmarRetiroTransferenciaPML();
	            }
	        }
	                
	     },
	    
	    changeRangeLength = function () {
	    	var ibanco = $('#ibancoPML').val();
	    	if(ibanco==1){//ibk
	    		$('#inumacountPML').attr("maxlength", 13);
	    		$('#inumacountPML').attr("data-min", 13);
	    		$('#inumacountPML').attr("data-max", 13);
	    	}else if(ibanco==2){//bcp
	    		$('#inumacountPML').attr("maxlength", 14);
	    		$('#inumacountPML').attr("data-min", 14);
	    		$('#inumacountPML').attr("data-max", 14);
	    	}else if(ibanco==3){//bbva
	    		$('#inumacountPML').attr("maxlength", 18);
	    		$('#inumacountPML').attr("data-min", 18);
	    		$('#inumacountPML').attr("data-max", 18);
	    	}else if(ibanco==4){//scotia
	    		$('#inumacountPML').attr("maxlength", 10);
	    		$('#inumacountPML').attr("data-min", 10);
	    		$('#inumacountPML').attr("data-max", 10);
	    	}else if(ibanco==5){//otros
	    		$('#inumacountPML').attr("maxlength", 20);
	    		$('#inumacountPML').attr("data-min", 20);
	    		$('#inumacountPML').attr("data-max", 20);
	    	}
	    },

	    init = function () {
	      btnSend.on('click', send);
	      form.blurValidate();
	      bybank.on('change', changeRangeLength);
	    };

	  return {
	    init: init
	  };
	}());
/**************************************
 * Historial
 **************************************/
const chargeDown = (function () {
  'use strict';
  const onClick = function () {
    const elem = $(this),
      detail = elem.closest('.mod__foot').find('.mod__detail');

    if (!elem.hasClass('opened')) {
      detail.slideDown(300);
      elem.addClass('opened');
      elem.attr('text-down') ? elem.html('<span>' + elem.attr('text-down') + '</span>') : '';
    } else {
      detail.slideUp(300);
      elem.removeClass('opened');
      elem.attr('text-up') ? elem.html('<span>' + elem.attr('text-up') + '</span>') : '';
    }
  },

  init = function () {
    $(document).on('click', '.mod .is-charge', onClick);
  };

  return {
    init: init
  };
}());

const filterOptions = (function () {
  'use strict';
  const filter = $('.filter'),
    title = filter.find('.filter__title'),
    logos = filter.find('.filter__logos label'),
    logosRadios = filter.find('.filter__logos input'),
    clear = filter.find('.filter__clear'),
    bydate = filter.find('.bydate'),
    rangeDate = filter.find('.forrange'),

    onDown = function () {
      const elem = $(this),
        detail = elem.closest('.filter').find('.filter__content');

      if (!elem.hasClass('opened')) {
        detail.slideDown(300);
        elem.addClass('opened');
      } else {
        detail.slideUp(300);
        elem.removeClass('opened');
      }
    },

    selectLogo = function () {
      const elem = $(this);

      elem.siblings().removeClass('is-this');
      elem.addClass('is-this');
    },

    clearFilter = function (event) {
      const $form = $(event.currentTarget).closest('form');
      const inputDates = filter.find('.is-calendar input'),
        select = filter.find('.select select');

        logos.removeClass('is-this');
        logosRadios.prop('checked', false);
        select.find('option:eq(0)').prop('selected', true);
        select.change();
        inputDates.datepicker('reset');
        inputDates.closest('.form-item').removeClass('is-focus');
        $form.find('[data-page-number]').val('1');

        setTimeout(function () {
          $form.find('.btn').click();
        }, 100);
    },

    showRangeDate = function () {
      const inputDates = filter.find('.is-calendar input');

      if ($(this).val() === '4') {
        rangeDate.show();
      } else {
        rangeDate.hide();
        inputDates.datepicker('reset');
        inputDates.closest('.form-item').removeClass('is-focus');
      }
    },

    init = function () {
      title.on('click', onDown);
      logos.on('click', selectLogo);
      clear.on('click', clearFilter);
      bydate.on('change', showRangeDate);
    };

  return {
    init: init
  };
}());

/**************************************
 * Enviar por correo
 **************************************/
const sendEmail = (function () {
  'use strict';
  const form = $('.frm-newsletter'),
    btnSend = form.find('.btn-sendemail'),

    send = function (e) {
      e.preventDefault();
      const valid = $(this).closest('.frm-newsletter').formValidate();

      if (valid) {        
    	    let $wrapper = $(e.currentTarget).closest('.content_loading');
    	    $wrapper.addClass('loading');
	        $.ajax({
	            type: "POST",
	            url: "sendMailTicketsPP.html",
	            dataType: "json",
	            beforeSend: function (xhr, settings) {
	            	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	            },
	    	})
	    	.done(function(data) {
	    		$wrapper.removeClass('loading');
	    		if(data.status=="OK"){
	        		showMessageInfo("Enviamos tu recibo a tu email","Revisa la bandeja de entrada de tu correo registrado. ¡Protege tu recibo! recuerda que el cobro es personal.<br>También puedes volver a visualizar tu recibo en el Historial de retiros.");
	        	}else if (data.status=="ERROR_MAIL"){
	        		showMessageError("No pudimos procesar tu solicitud","No tienes un correo registrado en tu cuenta. Comunícate a Servicio al Cliente 5135502 y solicita la actualización de tus datos. Recuerda que también puedes mostrar la pantalla de tu dispositivo para cobrar.");
	        	} else{
	        		showMessageError(title_error_general,msg_error_general);
	       	 	} 	
	    	})
	    	.fail(function( jqXHR, textStatus, errorThrown ) {
	        	if(jqXHR.status==403){
	        		window.location.href = 'inicio.html';
	        	}
	        });
      }
    },

    init = function () {
      btnSend.on('click', send);
      form.blurValidate();
    };

  return {
    init: init
  };
}());

/**************************************
 * Pull info from modals
 **************************************/
const submitFilters = (function () {
  const $form = $('[data-form-ajax]');
  const $btn = $form.find('.btn');

  const send = function (e) {
    if (e) e.preventDefault();
    let $wrapper = $(e.currentTarget).closest('.record__content');
    let $currentForm = $(e.currentTarget).closest('form');
    let url = $currentForm.attr('action');
    let method = $currentForm.attr('method');
    let data = $currentForm.serialize();
    $wrapper.addClass('loading');
    $.ajax({
      type: "POST",
      url: "filterHisPayment.html",
      data: "typeFilterHisPayment="+$("#typeFilterHisPayment").val()+"&startdate="+$("#startdate").val()+"&enddate="+$("#enddate").val(),
      dataType: "json",
      beforeSend: function (xhr, settings) {
      	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
      },
    })
    .done(function(data) {
        $wrapper.removeClass('loading');
        if(data.status=="OK"){
        	var objArray = JSON.parse(data.hisPayment);
   		 	printGridHisPayment(objArray);
        }else if(data.status=="ERROR"){
        	showMessageError(title_error_general,msg_error_general);
        }else if(data.status=="ERROR_FECHA"){
        	showMessageError(title_error_general,data.message);
        }else{
        	showMessageError(title_error_general,msg_error_general);
        }
    })
    .fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
  };

  const init = function () {
    $btn.on('click', send);
  };

  return {
    init: init
  };
}());

const populateFilteredData = function (content, data) {
  let $wrap = content;
  $wrap.find('.items').html(data.items);
  pagerDelegate.init($wrap);
};

/**************************************
 * Pager mechanic
 **************************************/
const pagerDelegate = (function () {
  const init = function ($list) {
    let toShow  = $list.find('[data-show-items]').attr('data-show-items');
    let $items  = $list.find('.items .item');
    let $pager  = $list.find('.pagination .pages');
    let $arrows = $list.find('.pagination .next, .pagination .prev');
    let currentPager = 1;
    let limit = 7;

    const updatePager = function (event) {
      if (event) event.preventDefault();
      currentPager = parseInt($(event.currentTarget).attr('href')) || currentPager || 1;
      if ($(event.currentTarget).hasClass('next')) currentPager+=1;
      if ($(event.currentTarget).hasClass('prev')) currentPager-=1;

      currentPager = currentPager <= 1 ? 1 : currentPager;
      currentPager = currentPager > ($items.length / toShow) + (($items.length % toShow) === 0 ? 0 : 1) ? currentPager-=1 : currentPager;
      $pager.find('a').removeClass('is-this');
      $pager.find('a').eq(currentPager - 1).addClass('is-this');

      showItems(currentPager);
      refreshNumber(currentPager);
    };

    const buildPager = function () {
      if ($items.length <= toShow) {
        $pager.html('');
        $arrows.hide();
        $items.show();
        return;
      }
      let i;
      let tpl = '';
      let pages = ($items.length / toShow) + (($items.length % toShow) === 0 ? 0 : 1);
      for (i = 1; i <= pages; i++) {
        tpl += '<a class="' + (i === 1 ? 'is-this' : '') + '" href="' + i + '">' + i + '</a>';
        if (i === 1 || i === Math.floor(pages) - 1) tpl += '<span class="is-ellipsis">...</span>';
      }
      $pager.html(tpl);
      $arrows.show();
      $pager.find('a').on('click', updatePager);

      $arrows.remove();
      $list.find('.pagination').append('<a class="prev" href="#"><i class="icon-regresar"></i></a>');
      $list.find('.pagination').append('<a class="next" href="#"><i class="icon-siguiente"></i></a>');
      setTimeout(function () {
        let $tmpArrows = $list.find('.pagination .next, .pagination .prev');
        $tmpArrows.on('click', updatePager);
      }, 100);

      currentPager = 1;
      showItems(1);
      refreshNumber(1);
    }

    const refreshNumber = function (current) {
      let i = 0;
      let pages = $pager.find('a').length;
      let dots = 0;
      $pager.find('a').removeClass('avaible');
      $pager.children().first().addClass('avaible');
      $pager.children().last().addClass('avaible');

      if (limit >= pages) {
        $pager.find('a').addClass('avaible');
      } else {
        if ((limit - current) < 2) {
          $pager.children().eq(1).addClass('avaible');
          dots += 1;
        } else {
          if ($pager.children().eq(1).hasClass('avaible')) {
            $pager.children().eq(1).removeClass('avaible');
            dots -= 1;
          }
        }
        if (pages - (current + 2) > 0) {
          $pager.find('span').eq(1).addClass('avaible');
          dots += 1;
        } else {
          if ($pager.find('span').eq(1).hasClass('avaible')) {
            $pager.find('span').eq(1).removeClass('avaible');
            dots -= 1;
          }
        }

        dots = dots === 0 ? 1 : dots;

        do {
          i += 1;

          if (dots === 1 && current < 6) {
            $pager.find('a[href="' + i + '"]').addClass('avaible');
          } else {
            $pager.find('a[href="' + (current-2) + '"]').addClass('avaible');
            $pager.find('a[href="' + (current-1) + '"]').addClass('avaible');
            $pager.find('a[href="' + current + '"]').addClass('avaible');

            if ((pages - current) === 2) {
              $pager.find('a[href="' + (current+1) + '"]').addClass('avaible');
            }

            if ((pages - current) === 1) {
              $pager.find('a[href="' + (current-1) + '"]').addClass('avaible');
              $pager.find('a[href="' + (current-2) + '"]').addClass('avaible');
              $pager.find('a[href="' + (current-3) + '"]').addClass('avaible');
            }
            if ((pages - current) === 0) {
              $pager.find('a[href="' + (current-2) + '"]').addClass('avaible');
              $pager.find('a[href="' + (current-3) + '"]').addClass('avaible');
              $pager.find('a[href="' + (current-4) + '"]').addClass('avaible');
            }
          }

        } while (i <= (limit - 2 - dots));
      }
    }

    const showItems = function (current) {
      let i;
      let from = (current - 1) * toShow;
      let to = from + parseInt(toShow);
      $items.removeClass('shown');

      for (i = from; i < to; i++) {
        $items.eq(i).addClass('shown');
      }
    }

    buildPager();
  }

  return {
    init: init
  };
}());

$(document).ready(function () {
  'use strict';
  accordion.init();
  inputField.init();
  selectField.init();
  fileupImg.init();
  fileupImgAgora.init();
  fileupImgEfectivo.init();
  fileupImgTransferencia.init();
  fileupImgTransferenciaPML.init();
  chargeDown.init();
  filterOptions.init();
  simpleModal.init();
  formVisa.init();
  formAgora.init();
  formEfectivo.init();
  formTransferencia.init();
  formTransferenciaPML.init();
  setCalendar.init();
  sendEmail.init();
  submitFilters.init();
  $('.items').closest('.record__content').each(function (index, elem) {
    pagerDelegate.init($(elem));
  });
  setNumeric();
  
  getNotifications();
  //getHisPayment();
  
});

function onChangeAmountEfectivo(){
	var amountEfectivo = parseInt($("#amountEfectivo").val(), 10);
	if( (amountEfectivo>=amountMinEnableDniCash || (accAmtCash+amountEfectivo>=minAccAmtEnblDniCash)) && amountEfectivo>=amountMinRequestCash ){
		$('#stepUnoEfectivo').removeClass('hiddenStep');
		$('#divStepUnoEfectivo').addClass('step');
		$('#divStepDNIEfectivo').removeClass('hidden');
		$("#delimgDNIEfectivo").trigger("click");
		if(stateDni==='ACT'){
			$("#stateDniACTEfectivo").css("display","block");
			$("#imgDNIEfectivo").removeAttr("data-valid");
		}else{
			$('#imgDNIEfectivo').attr("data-valid", "required");
		}
	}else{
		$('#stepUnoEfectivo').addClass('hiddenStep');
		$('#divStepUnoEfectivo').removeClass('step');
		$('#divStepDNIEfectivo').addClass('hidden');
		$('#divImgDniEfectivo').removeClass('is-error');
		$("#imgDNIEfectivo").removeAttr("data-valid");
		$('#divDniLabelEfectivo').removeClass('is-error');
	}
}

function onChangeAmountVisa(){
	var amountVisa = parseInt($("#amountVisa").val(), 10);
	if( (amountVisa>=amountMinEnableDni || (accAmtVisa+amountVisa>=minAccAmtEnblDniVisa)) && amountVisa>=amountMinRequestVisa ){
		$('#divStepDNI').removeClass('hidden');
		$("#delimgDNIVisa").trigger("click");
		if(stateDni==='ACT'){
			$("#stateDniACT").css("display","block");
			$("#imgDNI").removeAttr("data-valid");
		}else{
			$('#imgDNI').attr("data-valid", "required");
		}
		
		$("#stepCard").html("3");
	}else{
		$('#divStepDNI').addClass('hidden');
		$('#divImgDni').removeClass('is-error');
		$('#divDniLabel').removeClass('is-error');
		$("#imgDNI").removeAttr("data-valid");
		$("#stepCard").html("2");
	}
}

function onChangeAmountAgora(){
	var amountAgora = parseInt($("#amountAgora").val(), 10);
	if( (amountAgora>=amountMinEnableDniAgora || (accAmtAgora+amountAgora>=minAccAmtEnblDniAgora)) && amountAgora>=amountMinRequestAgora ){
		$('#divStepDNIAgora').removeClass('hidden');
		$("#delimgDNIAgora").trigger("click");
		if(stateDni==='ACT'){
			$("#stateDniACTAgora").css("display","block");
			$("#imgDNIAgora").removeAttr("data-valid");
		}else{
			$('#imgDNIAgora').attr("data-valid", "required");
		}
		
		$("#stepCardAgora").html("3");
	}else{
		$('#divStepDNIAgora').addClass('hidden');
		$('#divImgDniAgora').removeClass('is-error');
		$('#divDniLabelAgora').removeClass('is-error');
		$("#imgDNIAgora").removeAttr("data-valid");
		$("#stepCardAgora").html("2");
	}
}

function onChangeAmountTransferencia(){
	var isDniActive=acondicionaSeccionDniTransferencia();
	if(isDniActive){
		$("#stepDeparmentTransferencia").html("5");
	}else{
		$("#stepDeparmentTransferencia").html("4");
	}
}

function getDataCollectPrizes(){
	$.ajax({
        type: "POST",
        url: "getDataCollectPrizes.html",
        dataType: "json",
        async: false,
        beforeSend: function (xhr, settings) {
        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
	})
	.done(function(data) {
		if(data.status=="OK"){
			var amountMinRequestCashFormateado = floatFormat(data.amountMinRequestCash).replace(".00","");
			var amountMaxRequestCashFormateado = floatFormat(data.amountMaxRequestCash).replace(".00","");
			var amountMinRequestVisaFormateado = floatFormat(data.amountMinRequestVisa).replace(".00","");
			var amountMaxRequestVisaFormateado = floatFormat(data.amountMaxRequestVisa).replace(".00","");
			var amountMinRequestAgrFormateado = floatFormat(data.amountMinRequestAgr).replace(".00","");
			var amountMaxRequestAgrFormateado = floatFormat(data.amountMaxRequestAgr).replace(".00","");
			var maxAmountPerWeekVisaFormateado = floatFormat(data.maxAmountPerWeekVisa).replace(".00","");
			
			configLoaded=data;
			daysElapsedDni=parseInt(data.daysElapsedDni,10);
			
			amountMinRequestCash = floatFormat(data.amountMinRequestCash);
			amountMinRequestVisa = floatFormat(data.amountMinRequestVisa);
			amountMinRequestAgora = floatFormat(data.amountMinRequestAgr);
			amountMinRequestTrans = floatFormat(data.amountMinRequestTra);
			
			amountMinEnableDni = parseInt(data.amountMinEnableDni,10);
			amountMinEnableDniCash = parseInt(data.amountMinEnableDniCash,10);
			amountMinEnableDniAgora = parseInt(data.amountMinEnblDniAgr,10);
			amountMinEnableDniTrans = parseInt(data.amountMinEnblDniTra,10);
			
			minAccAmtEnblDniVisa = parseInt(data.minAccAmtEnblDniVisa,10);
			minAccAmtEnblDniCash = parseInt(data.minAccAmtEnblDniCash,10);
			minAccAmtEnblDniAgora = parseInt(data.minAccAmtEnblDniAgr,10);
			minAccAmtEnblDniTrans = parseInt(data.minAccAmtEnblDniTra,10);
			
			accAmtVisa = parseInt(data.accAmtVisa,10);
			accAmtCash = parseInt(data.accAmtCash,10);
			accAmtAgora = parseInt(data.accAmtAgora,10);
			accAmtTrans = parseInt(data.accAmtTrans,10);
			
			maxMb = data.maxMbPerImageVisa;
			stateDni=data.stateDni;
			if(data.stateDni==='ACT'){
				$("#stateDniPEN").css("display","none");
				$("#stateDniACT").css("display","block");
				$("#stateDniPENLabel").css("display","none");
				$("#stateDniACTLabel").css("display","block");
				$("#imgDNI").removeAttr("data-valid");
				$('#filenamesDniVisa').removeClass('empty');
				
				$("#divDniLabel").removeClass('divDniPen');
				$('#filenamesDniVisa').addClass('filenames-act');
				
				$("#stateDniPENEfectivo").css("display","none");
				$("#stateDniACTEfectivo").css("display","block");
				$("#stateDniPENLabelEfectivo").css("display","none");
				$("#stateDniACTLabelEfectivo").css("display","block");
				$("#imgDNIEfectivo").removeAttr("data-valid");
				$('#filenamesDniEfectivo').removeClass('empty');
				
				$("#divDniLabelEfectivo").removeClass('divDniPen');
				$('#filenamesDniEfectivo').addClass('filenames-act');
				
				$("#stateDniPENAgora").css("display","none");
				$("#stateDniACTAgora").css("display","block");
				$("#stateDniPENLabelAgora").css("display","none");
				$("#stateDniACTLabelAgora").css("display","block");
				$("#imgDNIAgora").removeAttr("data-valid");
				$('#filenamesDniAgora').removeClass('empty');
				
				$("#divDniLabelAgora").removeClass('divDniPen');
				$('#filenamesDniAgora').addClass('filenames-act');
				
				$("#divDniLabelTransferencia").removeClass('divDniPen');
				$('#filenamesDniTransferencia').addClass('filenames-act');
				
				$("#stateDniPENTransferencia").css("display","none");
				$("#stateDniACTTransferencia").css("display","block");
				$("#stateDniPENLabelTransferencia").css("display","none");
				$("#stateDniACTLabelTransferencia").css("display","block");
				$("#imgDNITransferencia").removeAttr("data-valid");
				$('#filenamesDniTransferencia').removeClass('empty');
				
				$("#stateDniPENTransferenciaPML").css("display","none");
				$("#stateDniACTTransferenciaPML").css("display","block");
				$("#stateDniPENLabelTransferenciaPML").css("display","none");
				$("#stateDniACTLabelTransferenciaPML").css("display","block");
				$("#imgDNITransferenciaPML").removeAttr("data-valid");
				$('#filenamesDniTransferenciaPML').removeClass('empty');
			}else{
				$("#stateDniPEN").css("display","block");
				$("#stateDniACT").css("display","none");
				$("#stateDniPENLabel").css("display","flex");
				$("#stateDniACTLabel").css("display","none");	
				
				$("#stateDniPENEfectivo").css("display","block");
				$("#stateDniACTEfectivo").css("display","none");
				$("#stateDniPENLabelEfectivo").css("display","flex");
				$("#stateDniACTLabelEfectivo").css("display","none");
				
				$("#stateDniPENAgora").css("display","block");
				$("#stateDniACTAgora").css("display","none");
				$("#stateDniPENLabelAgora").css("display","flex");
				$("#stateDniACTLabelAgora").css("display","none");	
				
				$("#stateDniPENTransferencia").css("display","block");
				$("#stateDniACTTransferencia").css("display","none");
				$("#stateDniPENLabelTransferencia").css("display","flex");
				$("#stateDniACTLabelTransferencia").css("display","none");
				
				$("#stateDniPENTransferenciaPML").css("display","block");
				$("#stateDniACTTransferenciaPML").css("display","none");
				$("#stateDniPENLabelTransferenciaPML").css("display","flex");
				$("#stateDniACTLabelTransferenciaPML").css("display","none");
			}
			
	    	$("#saldoLiquidable").text("S/"+floatFormat(data.saldoLiquidable).replace(".00",""));
	    	$('#items-hispayment').attr("data-show-items", data.itemXPageHRDesktop);
	    	
	    	$("#msgErrorRangoMontosVisa").text("Ingrese un monto entre S/"+amountMinRequestVisaFormateado+" y S/"+amountMaxRequestVisaFormateado+" soles");
	    	
	    	$("#minAmountVisa").html(amountMinRequestVisaFormateado);
	    	$("#maxAmountVisa").html(amountMaxRequestVisaFormateado);
	    	$("#maxRequestPerDayVisa").html(data.maxRequestPerDayVisa);
	    	$("#maxAmountPerWeekVisa").html(maxAmountPerWeekVisaFormateado);
	    	
	    	$("#rangoMontosVisa").html("Monto entre S/"+amountMinRequestVisaFormateado+" - S/"+amountMaxRequestVisaFormateado);
	    	$('#amountVisa').attr("data-min", data.amountMinRequestVisa);
	    	$('#amountVisa').attr("data-max", data.amountMaxRequestVisa);
	    	$("#pesoImgDni").html(data.maxMbPerImageVisa);
	    	$("#pesoImgDniEfectivo").html(data.maxMbPerImageVisa);
	    	
	    	$("#msgErrorRangoMontosEfectivo").text("Ingrese un monto entre S/"+amountMinRequestCashFormateado+" y S/"+amountMaxRequestCashFormateado+" soles");
	    	$("#rangoMontosEfectivo").text("Monto entre S/"+amountMinRequestCashFormateado+" - S/"+amountMaxRequestCashFormateado);
	    	$('#amountEfectivo').attr("data-min", data.amountMinRequestCash);
	    	$('#amountEfectivo').attr("data-max", data.amountMaxRequestCash);
	    	
	    	$("#msgErrorRangoMontosAgora").text("Ingrese un monto entre S/"+amountMinRequestAgrFormateado+" y S/"+amountMaxRequestAgrFormateado+" soles");
	    	$("#rangoMontosAgora").html("Monto entre S/"+amountMinRequestAgrFormateado+" - S/"+amountMaxRequestAgrFormateado);
	    	$('#amountAgora').attr("data-min", data.amountMinRequestAgr);
	    	$('#amountAgora').attr("data-max", data.amountMaxRequestAgr);
	    	$("#pesoImgDniAgora").html(data.maxMbPerImageVisa);
	    	
	    	$("#pesoImgDniTransferencia").html(data.maxMbPerImageVisa);
	    	$("#pesoImgDniTransferenciaPML").html(data.maxMbPerImageVisa);
	    	
	    	$("#numDiasExpiracion").val(data.daysExpireRequest);
	    	
	    	var stateRequestAgr = data.stateRequestAgr;
			if(stateRequestAgr!=undefined && stateRequestAgr=='INACTIVO'){
				$("#accordion_agora").css('display','none');
			}
			
			var stateRequestVisa = data.stateRequestVisa;
			if(stateRequestVisa!=undefined && stateRequestVisa=='INACTIVO'){
				$("#accordion_visa").css('display','none');
			}
			
			var stateRequestCash = data.stateRequestCash;
			if(stateRequestCash!=undefined && stateRequestCash=='INACTIVO'){
				$("#accordion_efectivo").css('display','none');
			}
			
			if(data.stateRequestTra=='INACTIVO' || ( data.stateRequestTraRan3=='INACTIVO' && data.stateRequestTraRan2=='INACTIVO' && data.stateRequestTraRan1=='INACTIVO') ){
				$("#accordion_transferencia").css('display','none');
			}else if(data.stateRequestTra=='ACTIVO'){
				prepararPantallaTransferencia(data);
			}
			
			$("#ibancoPML").html(htmlBancosDisponiblesRango2_3);
			$("#ibancoPML").val("").change();
			$('#divBancoPML').removeClass('is-error');
			
			hmPremiosMayoresLoterias = new Map();
			var htmlListaPremiosMayoresLoterias='<div class="title-method" style="font-weight: normal; text-align: center; margin-top: 15px;">Premios mayores de loterías</div>';
			htmlListaPremiosMayoresLoterias+='<ul class="accordion is-method listaPremiosMayoresLoterias">';
			$.each(JSON.parse(data.listPrizesMajor), function( key,value ) {
				hmPremiosMayoresLoterias.set(value.ticketId,value);
				htmlListaPremiosMayoresLoterias+='<li class="accordion__lottery" id="ticket'+value.ticketId+'">';
				htmlListaPremiosMayoresLoterias+='<div style="display: block;">';
				htmlListaPremiosMayoresLoterias+='<table style="width: 100%;">';
				htmlListaPremiosMayoresLoterias+='<tbody>';
				if(value.gameId==4){//GG
					htmlListaPremiosMayoresLoterias+='<td style="width: 110px;"><img src="layer-view-image/v2/logo-ganagol.png" alt="tinka" style="height: 40px; padding-left: 20px;"></td>';
				}else if(value.gameId==41){//TK
					htmlListaPremiosMayoresLoterias+='<td style="width: 110px;"><img src="layer-view-image/v2/logo-tinka.svg?v=3" alt="tinka" style="height: 15px; padding-left: 20px;"></td>';
				}else if(value.gameId==42){//KB
					htmlListaPremiosMayoresLoterias+='<td style="width: 110px;"><img src="layer-view-image/v2/logo-kabala.svg" alt="tinka" style="height: 40px; padding-left: 20px;"></td>';
				}else if(value.gameId==164){//GD
					htmlListaPremiosMayoresLoterias+='<td style="width: 110px;"><img src="layer-view-image/v2/logo-ganadiario.svg" alt="tinka" style="height: 40px; padding-left: 20px;"></td>';
				}else if(value.gameId==1121){//KN
					htmlListaPremiosMayoresLoterias+='<td style="width: 110px;"><img src="layer-view-image/v2/logo-kinelo.png" alt="tinka" style="height: 40px; padding-left: 20px;"></td>';
				}else{
					//no corresponde
				}
				htmlListaPremiosMayoresLoterias+='<td style="min-width: 130px;"><span style="padding-top: 12px; font-family: Avenir; font-weight: 900; padding-left: 30px; font-size: 18px;">S/ '+floatFormat(value.amountBase).replace(".00","")+'</span></td>';
				htmlListaPremiosMayoresLoterias+='<td style="text-align: right; padding-right: 30px;"><label class="form_lottery_button" onclick="cobrarPremioMayor('+value.ticketId+')">COBRAR</label></td>';
				htmlListaPremiosMayoresLoterias+='</tbody>';
				htmlListaPremiosMayoresLoterias+='</table>';
				htmlListaPremiosMayoresLoterias+='</div>';
				htmlListaPremiosMayoresLoterias+='</li>';
			});
			htmlListaPremiosMayoresLoterias+='</ul>';
			$("#listaPremiosMayoresLoterias").html(htmlListaPremiosMayoresLoterias);
		}else{
			showMessageError(title_error_general,msg_error_general);
   	 	} 
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
}

function downloadTicketsPP(){
	document.getElementById("formDownload").submit();
}

function getTicketsPrizes(requestNumber){
	var state=0;
	$.ajax({
        type: "POST",
        url: "getTicketsPrizes.html",
        dataType: "json",
        data: "requestNumber="+requestNumber,
        async: false,
        beforeSend: function (xhr, settings) {
        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
	})
	.done(function(data) {
		if(data.status=="OK"){
    		$("#tkRequestNumber").text(data.requestNumber);
    		$("#tkRequestDateHour").text(data.requestDateHour);
    		$("#tkDocNumber").text(data.docNumber);
    		$("#tkRequestAmount").text(data.requestAmount);
    		$("#idCliente").text(data.clientIdQR);
    		$("#ganador").text(data.nombresQR);
    		$("#items-tickets-payment-prizes").html(data.htmlText);
    	}else{
    		state = -1;
    		showMessageError(title_error_general,msg_error_general);
   	 	} 	
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
	return state;
}

function getTicketsPrizesOld(ticket){
	var state=0;
	$.ajax({
        type: "POST",
        url: "getTicketsPrizesOld.html",
        dataType: "json",
        data: "ticket="+ticket,
        async: false,
        beforeSend: function (xhr, settings) {
        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
	})
	.done(function(data) {
		if(data.status=="OK"){
    		$("#tkRequestNumber").text(data.requestNumber);
    		$("#tkRequestDateHour").text(data.requestDateHour);
    		$("#tkDocNumber").text(data.docNumber);
    		$("#tkRequestAmount").text(data.requestAmount);
    		$("#idCliente").text(data.clientIdQR);
    		$("#ganador").text(data.nombresQR);
    		$("#items-tickets-payment-prizes").html(data.htmlText);
    	}else{
    		state = -1;
    		showMessageError(title_error_general,msg_error_general);
   	 	} 	
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
	return state;
}

function showModalTickets(e){
	simpleModal.onToggleModalButton(e);
}

function showModalTicketsOld(e){
	simpleModal.onToggleModalButtonOld(e);
}

function printGridHisPayment(objArray){
	 if(objArray.length>0){
		 $("#pagination-items-hispayment").css("display","block");
		 var htmlText = "";
    	 var objAux = objArray[0];
    	 var pendiente=0;
    	 var cobrado=0;
    	 var objArrayEstadoSolApr = [];
    	 htmlText += '<div class="item">' ;
    	 htmlText += '<div class="label-mod">'+objAux.requestDate+'</div>' ;
    	 htmlText += '<div class="mod is-compact">' ;
    	 if(objAux.paymentType=='Premio_Mayor'){
    		 htmlText += '<h3 class="mod__title">TRANSFERENCIA</h3>' ;
    	 }else{
    		 htmlText += '<h3 class="mod__title">'+objAux.paymentType+'</h3>' ;
    	 }
         if(objAux.version=='new'){
        	 htmlText += '<div class="mod__price"><sup>S/</sup>'+objAux.requestAmount+'</div><div class="mod_solicitud">Retiro N° '+objAux.requestNumber+'</div>';
         }else{
        	 htmlText += '<div class="mod__price"><sup>S/</sup>'+objAux.requestAmount+'</div><div class="mod_solicitud">N° '+objAux.requestNumber+'</div>';
         }
    	 if(objAux.requestState=='Recibido'){
    		 if(objAux.paymentType=='Transferencia' || objAux.paymentType=='Premio_Mayor'){
    			 var descBanco = "";
    			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
        		 htmlText += '<div class="mod__detail">';
        		 htmlText += '<div class="detail__body">';        		 
        		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
        			descBanco="Interbank";
        		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
        			descBanco="BCP";
        		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
        			descBanco="BBVA";
        		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
        			descBanco="Scotiabank";
        		 }else{
        			descBanco="CCI";
        		 }
        		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
    		 }else{
    			 //htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span></div></div></div>' ;
    			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
        		 htmlText += '<div class="mod__detail">';
        		 htmlText += '<div class="detail__body">';
        		 htmlText += '<p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
    		 }
    	 }else if(objAux.requestState=='Denegado'){
    		htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">'+objAux.requestState+'</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
    		htmlText += '<div class="mod__detail">';
    		htmlText += '<div class="detail__body">';
    		if(objAux.paymentType=='Transferencia' || objAux.paymentType=='Premio_Mayor'){
    			if(objAux.bank=="Interbank" || objAux.idBank=="1"){
    				descBanco="Interbank";
    			}else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
    				descBanco="BCP";
    			}else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
    				descBanco="BBVA";
    			}else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
    				descBanco="Scotiabank";
    			}else{
    				descBanco="CCI";
    			}
 	       		htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>'+objAux.comments+'</p></div></div></div></div></div>';
      		}else{
      			htmlText += '<p class="inlist">'+objAux.comments+'</p></div></div></div></div></div>';
      		}
    	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Efectivo'){
    		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3" id="estadoSolicitud'+objAux.requestNumber+'">'+objAux.requestState+'</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
    		 htmlText += '<div class="mod__detail">';
    		 htmlText += '<div class="detail__body">';
    		 if(objAux.status=='Pendiente'){
    			 htmlText += '<table class="table"><thead><tr><th>Fecha</th><th>Monto</th><th>Estado</th></tr></thead><tbody><tr><td>'+objAux.cashDate+'</td><td>'+objAux.prize+'</td><td class="is-orange">'+objAux.status+'</td></tr>';
    			 pendiente++;
    		 }else{
    			 htmlText += '<table class="table"><thead><tr><th>Fecha</th><th>Monto</th><th>Estado</th></tr></thead><tbody><tr><td>'+objAux.cashDate+'</td><td>'+objAux.prize+'</td><td class="is-green">'+objAux.status+'</td></tr>';
    			 cobrado++;
    		 }
    	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Visa'){
       		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
       		 htmlText += '<div class="mod__detail">';
   		     htmlText += '<div class="detail__body">';
   		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles. En caso tengas tarjeta de crédito, la transferencia tomará 2 días adicionales.</p></div></div></div></div></div>';
   		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. En caso tu tarjeta sea débito el abono se realiza en menos de 30 minutos y de ser tarjeta de crédito puede tomar hasta 2 días. Verifícalo en los movimientos de tu tarjeta.</p></div></div></div></div></div>';
    	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Agora'){
       		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
       		 htmlText += '<div class="mod__detail">';
   		     htmlText += '<div class="detail__body">';
   		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
   		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. El abono se realiza en menos de 30 minutos. Verifícalo en los movimientos de tu tarjeta.</p></div></div></div></div></div>';
    	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Transferencia'){
       		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
       		 htmlText += '<div class="mod__detail">';
   		     htmlText += '<div class="detail__body">';
	   		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
	   			descBanco="Interbank";
	   		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
	   			descBanco="BCP";
	   		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
	   			descBanco="BBVA";
	   		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
	   			descBanco="Scotiabank";
	   		 }else{
	   			descBanco="CCI";
	   		 }
   		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: left;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. En 1 hora estará en tu cuenta.</p></div></div></div></div></div>';
   		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>';
    	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Premio_Mayor'){
       		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
       		 htmlText += '<div class="mod__detail">';
   		     htmlText += '<div class="detail__body">';
	   		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
	   			descBanco="Interbank";
	   		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
	   			descBanco="BCP";
	   		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
	   			descBanco="BBVA";
	   		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
	   			descBanco="Scotiabank";
	   		 }else{
	   			descBanco="CCI";
	   		 }
	   		 
	   		 if(objAux.transferType=='RANGO_2'){
	   			htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>'; 
	   		 }else{
	   			htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>';
	   		 }	   		 
    	 }else if(objAux.requestState=='PRC'){
    		 var descBanco = "";
			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
    		 htmlText += '<div class="mod__detail">';
    		 htmlText += '<div class="detail__body">';
    		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
				descBanco="Interbank";
    		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
				descBanco="BCP";
    		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
				descBanco="BBVA";
    		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
				descBanco="Scotiabank";
    		 }else{
				descBanco="CCI";
    		 }
    		 
    		 if(objAux.paymentType=='Transferencia'){
        		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
    		 }else{//PM
    			 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles. Un representante se comunicará contigo para coordinar la transferencia de tu retiro.</p></div></div></div></div></div>';
    		 }
    	 }else if(objAux.requestState=='SUB'){//PM
    		 var descBanco = "";
			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
    		 htmlText += '<div class="mod__detail">';
    		 htmlText += '<div class="detail__body">';
    		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
				descBanco="Interbank";
			 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
				descBanco="BCP";
			 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
				descBanco="BBVA";
			 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
				descBanco="Scotiabank";
			 }else{
				descBanco="CCI";
			 }
    		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Los datos ingresados no son correctos, nos contactaremos nuevamente en plazo de 2 días para reintentar el pago.</p></div></div></div></div></div>';
    	 }   	 
    	 
    	 if(objArray.length==1 && objAux.requestState=='APROBADO' && objAux.paymentType=='Efectivo'){
    		 htmlText += '</tbody></table>';
    		 if(objAux.version=='new'){
    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTickets(this)" >Ver ticket</button>';
    		 }else{
    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTicketsOld(this)" >Ver ticket</button>';
    		 }
			 htmlText += '</div></div></div></div></div>';
			 if(pendiente==1){
				 var objEstadoSol = {num:objAux.requestNumber, state: "Pendiente", clase: "is-orange"};
				 objArrayEstadoSolApr.push(objEstadoSol);
			 }
			 if(cobrado==1){
				 var objEstadoSol = {num:objAux.requestNumber, state: "Cobrado", clase: "is-green"};
				 objArrayEstadoSolApr.push(objEstadoSol);
			 }
    	 }
    	 
    	 for(var i=1; i<objArray.length; i++){
    		 if(objArray[i].requestNumber==objAux.requestNumber){
    			 if(objArray[i].status=='Pendiente'){
    				 htmlText += '<tr><td>'+objArray[i].cashDate+'</td><td>'+objArray[i].prize+'</td><td class="is-orange">'+objArray[i].status+'</td></tr>';
    				 pendiente++;
    			 }else{
    				 htmlText += '<tr><td>'+objArray[i].cashDate+'</td><td>'+objArray[i].prize+'</td><td class="is-green">'+objArray[i].status+'</td></tr>';
    				 cobrado++;
    			 }
    			 objAux = objArray[i];
    		 }else{
    			 if(objAux.requestState=='APROBADO' && objAux.paymentType=='Efectivo'){
    				 htmlText += '</tbody></table>';
    				 if(objAux.version=='new'){
    	    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTickets(this)" >Ver ticket</button>';
    	    		 }else{
    	    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTicketsOld(this)" >Ver ticket</button>';
    	    		 }
    				 htmlText += '</div></div></div></div></div>';
    				 
    				 if(pendiente>0 && cobrado>0){
    					 var objEstadoSol = {num:objAux.requestNumber, state: "Parcialmente cobrado", clase: "is-orange"};
    					 objArrayEstadoSolApr.push(objEstadoSol);
    				 }else if(pendiente==0 && cobrado>0){
    					 var objEstadoSol = {num:objAux.requestNumber, state: "Cobrado", clase: "is-green"};
    					 objArrayEstadoSolApr.push(objEstadoSol);
    				 }else if(pendiente>0 && cobrado==0){
    					 var objEstadoSol = {num:objAux.requestNumber, state: "Listo para retirar", clase: "is-orange"};
    					 objArrayEstadoSolApr.push(objEstadoSol);
    				 }
    				 pendiente=0;
    				 cobrado=0;
    			 }
    			 
    			 htmlText += '<div class="item">' ;
        		 if(objArray[i].requestDate!=objAux.requestDate){
        			 htmlText += '<div class="label-mod">'+objArray[i].requestDate+'</div>' ;
        		 }
        		 objAux = objArray[i];
        		 htmlText += '<div class="mod is-compact">' ;
        		 if(objAux.paymentType=='Premio_Mayor'){
            		 htmlText += '<h3 class="mod__title">TRANSFERENCIA</h3>' ;
            	 }else{
            		 htmlText += '<h3 class="mod__title">'+objAux.paymentType+'</h3>' ;
            	 }
                 if(objAux.version=='new'){
                	 htmlText += '<div class="mod__price"><sup>S/</sup>'+objAux.requestAmount+'</div><div class="mod_solicitud">Retiro N° '+objAux.requestNumber+'</div>';
                 }else{
                	 htmlText += '<div class="mod__price"><sup>S/</sup>'+objAux.requestAmount+'</div><div class="mod_solicitud">N° '+objAux.requestNumber+'</div>';
                 }
            	 if(objAux.requestState=='Recibido'){
            		 if(objAux.paymentType=='Transferencia' || objAux.paymentType=='Premio_Mayor'){
            			 var descBanco = "";
            			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
                		 htmlText += '<div class="mod__detail">';
                		 htmlText += '<div class="detail__body">';
                		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
            				descBanco="Interbank";
            			 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
            				descBanco="BCP";
            			 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
            				descBanco="BBVA";
            			 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
            				descBanco="Scotiabank";
            			 }else{
            				descBanco="CCI";
            			 }
                		 //htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: left;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible.</p></div></div></div></div></div>';
                		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
            		 }else{
            			 //htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span></div></div></div>' ;
            			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
                		 htmlText += '<div class="mod__detail">';
                		 htmlText += '<div class="detail__body">';
                		 htmlText += '<p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
            		 } 
            	 }else if(objAux.requestState=='Denegado'){
            		htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">'+objAux.requestState+'</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
             		htmlText += '<div class="mod__detail">';
             		htmlText += '<div class="detail__body">';
             		if(objAux.paymentType=='Transferencia' || objAux.paymentType=='Premio_Mayor'){
             			if(objAux.bank=="Interbank" || objAux.idBank=="1"){
             				descBanco="Interbank";
             			}else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
             				descBanco="BCP";
             			}else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
             				descBanco="BBVA";
             			}else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
             				descBanco="Scotiabank";
             			}else{
             				descBanco="CCI";
             			}
          	       		htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>'+objAux.comments+'</p></div></div></div></div></div>';
               		}else{
               			htmlText += '<p class="inlist">'+objAux.comments+'</p></div></div></div></div></div>';
               		}
            	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Efectivo'){
               		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3" id="estadoSolicitud'+objAux.requestNumber+'">'+objAux.requestState+'</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
            		 htmlText += '<div class="mod__detail">';
            		 htmlText += '<div class="detail__body">';
            		 if(objAux.status=='Pendiente'){
            			 htmlText += '<table class="table"><thead><tr><th>Fecha</th><th>Monto</th><th>Estado</th></tr></thead><tbody><tr><td>'+objAux.cashDate+'</td><td>'+objAux.prize+'</td><td class="is-orange">'+objAux.status+'</td></tr>';
            			 pendiente++;
            		 }else{
            			 htmlText += '<table class="table"><thead><tr><th>Fecha</th><th>Monto</th><th>Estado</th></tr></thead><tbody><tr><td>'+objAux.cashDate+'</td><td>'+objAux.prize+'</td><td class="is-green">'+objAux.status+'</td></tr>';
            			 cobrado++;
            		 }
            	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Visa'){
               		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
               		 htmlText += '<div class="mod__detail">';
           		     htmlText += '<div class="detail__body">';
           		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles. En caso tengas tarjeta de crédito, la transferencia tomará 2 días adicionales.</p></div></div></div></div></div>';
           		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. En caso tu tarjeta sea débito el abono se realiza en menos de 30 minutos y de ser tarjeta de crédito puede tomar hasta 2 días. Verifícalo en los movimientos de tu tarjeta.</p></div></div></div></div></div>';
            	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Agora'){
               		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
               		 htmlText += '<div class="mod__detail">';
           		     htmlText += '<div class="detail__body">';
           		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
           		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Número de tarjeta</strong></td><td>'+objAux.cardNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. El abono se realiza en menos de 30 minutos. Verifícalo en los movimientos de tu tarjeta.</p></div></div></div></div></div>';
            	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Transferencia'){
               		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más"><span>Ver más</span></span>' ;
               		 htmlText += '<div class="mod__detail">';
           		     htmlText += '<div class="detail__body">';
	           		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
	           			descBanco="Interbank";
	           		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
	           			descBanco="BCP";
	           		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
	           			descBanco="BBVA";
	           		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
	           			descBanco="Scotiabank";
	           		 }else{
	           			descBanco="CCI";
	           		 }
           		     //htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: left;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. En 1 hora estará en tu cuenta.</p></div></div></div></div></div>';
           		     htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>';
            	 }else if(objAux.requestState=='APROBADO' && objAux.paymentType=='Premio_Mayor'){
            		 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-green" id="estadoSolicitud'+objAux.requestNumber+'">Cobrado</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
               		 htmlText += '<div class="mod__detail">';
           		     htmlText += '<div class="detail__body">';
            		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
	           			descBanco="Interbank";
	           		 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
	           			descBanco="BCP";
	           		 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
	           			descBanco="BBVA";
	           		 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
	           			descBanco="Scotiabank";
	           		 }else{
	           			descBanco="CCI";
	           		 }
        	   		 
        	   		 if(objAux.transferType=='RANGO_2'){
        	   			htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>'; 
        	   		 }else{
        	   			htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Tu retiro está confirmado. Verifícalo en los movimientos de tu cuenta bancaria.</p></div></div></div></div></div>';
        	   		 }	 
            	 }else if(objAux.requestState=='PRC'){
            		 var descBanco = "";
        			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
            		 htmlText += '<div class="mod__detail">';
            		 htmlText += '<div class="detail__body">';
            		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
        				descBanco="Interbank";
        			 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
        				descBanco="BCP";
        			 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
        				descBanco="BBVA";
        			 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
        				descBanco="Scotiabank";
        			 }else{
        				descBanco="CCI";
        			 }
            		 
            		 if(objAux.paymentType=='Transferencia'){
                		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles.</p></div></div></div></div></div>';
            		 }else{//PM
            			 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Confirmaremos tu retiro lo antes posible, en un plazo máximo de 2 días hábiles. Un representante se comunicará contigo para coordinar la transferencia de tu retiro.</p></div></div></div></div></div>';
            		 }
            	 }else if(objAux.requestState=='SUB'){//PM
            		 var descBanco = "";
        			 htmlText += '<div class="mod__foot ismargin10" style="margin-top: 5px;"><span class="mod__text3 is-orange">Recibido - En evaluación</span><span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más">Ver más</span>' ;
            		 htmlText += '<div class="mod__detail">';
            		 htmlText += '<div class="detail__body">';
            		 if(objAux.bank=="Interbank" || objAux.idBank=="1"){
        				descBanco="Interbank";
        			 }else if(objAux.bank=="Banco de Credito" || objAux.idBank=="2"){
        				descBanco="BCP";
        			 }else if(objAux.bank=="Banco Continental" || objAux.idBank=="3"){
        				descBanco="BBVA";
        			 }else if(objAux.bank=="Scotiabank" || objAux.idBank=="4"){
        				descBanco="Scotiabank";
        			 }else{
        				descBanco="CCI";
        			 }
            		 htmlText += '<table class="table-left"><tbody><tr><td><strong>Cuenta '+descBanco+'</strong></td><td style="text-align: right;">'+objAux.accountNumber+'</td></tr></tbody></table><p>Los datos ingresados no son correctos, nos contactaremos nuevamente en plazo de 2 días para reintentar el pago.</p></div></div></div></div></div>';
            	 }
    		 }
    	 }
    	 
    	 if(objArray.length>1 && objAux.requestState=='APROBADO' && objAux.paymentType=='Efectivo'){
    		 htmlText += '</tbody></table>';
    		 if(objAux.version=='new'){
    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTickets(this)" >Ver ticket</button>';
    		 }else{
    			 htmlText += '<p class="inlist">Para retirar tu premio, acércate a uno de nuestros puntos de venta con tu DNI y presenta tu ticket desde tu móvil.</p><button class="btn is-secondary link" toggle-modal="#modal-ticket2" data-number="'+objAux.requestNumber+'" onclick="showModalTicketsOld(this)" >Ver ticket</button>';
    		 }
			 htmlText += '</div></div></div></div></div>';
			 	    				 
			 if(pendiente>0 && cobrado>0){
				 var objEstadoSol = {num:objAux.requestNumber, state: "Parcialmente cobrado", clase: "is-orange"};
				 objArrayEstadoSolApr.push(objEstadoSol);
			 }else if(pendiente==0 && cobrado>0){
				 var objEstadoSol = {num:objAux.requestNumber, state: "Cobrado", clase: "is-green"};
				 objArrayEstadoSolApr.push(objEstadoSol);
			 }else if(pendiente>0 && cobrado==0){
				 var objEstadoSol = {num:objAux.requestNumber, state: "Listo para retirar", clase: "is-orange"};
				 objArrayEstadoSolApr.push(objEstadoSol);
			 }
			 
			 pendiente=0;
			 cobrado=0;
    	 }
    	 $("#items-hispayment").html("");
    	 $("#items-hispayment").html(htmlText);
    	 
    	 $('.items').closest('.record__content').each(function (index, elem) {
    	   pagerDelegate.init($(elem));
    	 });
    	 
    	 for(var i=0; i<objArrayEstadoSolApr.length; i++){
    		 $("#estadoSolicitud"+objArrayEstadoSolApr[i].num).text(objArrayEstadoSolApr[i].state);
			 $("#estadoSolicitud"+objArrayEstadoSolApr[i].num).addClass(objArrayEstadoSolApr[i].clase);
    	 }
	 }else{
		 $("#items-hispayment").html("<p style='text-align: center;'>No hay resultados</p>");
		 $("#pagination-items-hispayment").css("display","none");
	 }
}

function getHisPayment(){
	var size = 0;    
    $.ajax({
        type: "POST",
        url: "getHisPayment.html",
        dataType: "json",
        async: false,
        beforeSend: function (xhr, settings) {
        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
	})
    .done(function(data) {
		if(data.status=='OK'){
       		 var objArray = JSON.parse(data.hisPayment);
       		 printGridHisPayment(objArray);
       		 size = objArray.length;
       	}else{
       		 size = -1;
       		 showMessageError(title_error_general,msg_error_general);
       	}
    })
    .fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
	return size;
}

function showMessageInfo(title,message) {
    $('#title-message-info').html(title);
    $('#message-info').html(message);
    $('#modal-msg-info').fadeIn(350);
}

function closeMessageInfo(){
	$('#modal-msg-info').fadeOut(250);
	$('#title-message-info').html("");
	$('#message-info').html("");
}

function showMessageError(title,message) {
    $('#title-message-error').html(title);
    $('#message-error').html(message);
    $('#modal-msg-error').fadeIn(350);
}

function closeMessageError(){
	$('#modal-msg-error').fadeOut(250);
	$('#title-message-error').html("");
	$('#message-error').html("");
}

function showMessageErrorVisa(title,message) {
    $('#title-message-error-visa').html(title);
    $('#message-error-visa').html(message);
    $('#modal-msg-error-visa').fadeIn(350);
}

function closeMessageErrorVisa(){
	$('#modal-msg-error-visa').fadeOut(250);
	$('#title-message-error-visa').html("");
	$('#message-error-visa').html("");
	showTokenization();
}

function showMessageErrorAgora(title,message) {
    $('#title-message-error-agora').html(title);
    $('#message-error-agora').html(message);
    $('#modal-msg-error-agora').fadeIn(350);
}

function closeMessageErrorAgora(){
	$('#modal-msg-error-agora').fadeOut(250);
	$('#title-message-error-agora').html("");
	$('#message-error-agora').html("");
	showTokenizationAgora();
}

function showModalPremios(){
	$('#modal-error').fadeOut(250, function () {
		$('body').removeClass('no-scroll');
        setTimeout(function () {
        	$('#modal-premios').fadeIn(350);
        	$('body').addClass('no-scroll');
        }, 250);
    });
}

function volverModalRetiros(){
	$('#modal-ticket2').fadeOut(250, function () {
		$('body').removeClass('no-scroll');
        setTimeout(function () {
        	$('#modal-listado').fadeIn(350);
        	$('body').addClass('no-scroll');
        }, 250);
    });
}

function showTokenization(){
	$('body').find('#div-lightbox-tokenization-ilot').remove();	
	$('body').append('<i id="loadTokenization" class="loadingMobile" style="z-index: 10001 !important;"></i>');
	$('body').append('<div id="div-lightbox-tokenization-ilot" style="position:fixed; top:0; left:0;z-index: 10002;width:100%; height: 100%; display: block;"><iframe id="frmLightboxTokenization" frameborder="0" src="tokenizationCard.html" style="z-index: 10003; width:100%; height:100%;"></iframe></div>');
}

function showTokenizationAgora(){
	$('body').find('#div-lightbox-tokenization-ilot').remove();	
	$('body').append('<i id="loadTokenization" class="loadingMobile" style="z-index: 10001 !important;"></i>');
	$('body').append('<div id="div-lightbox-tokenization-ilot" style="position:fixed; top:0; left:0;z-index: 10002;width:100%; height: 100%; display: block;"><iframe id="frmLightboxTokenization" frameborder="0" src="tokenizationCardAgora.html" style="z-index: 10003; width:100%; height:100%;"></iframe></div>');
}

function handleMessage(e) {
	if(e!=null && e!=undefined && e.data!=null && e.data!=undefined){
		var arrayData = e.data.split("|");
		//var operacion = e.data;
		var operacion = arrayData[0];
		if(operacion==='hideLoadingTokenization'){
			$('body').find('#loadTokenization').remove();	
		}else if(operacion==='hideLightboxTokenization'){
			$('body').find('#loadTokenization').remove();	
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCard();
			clearInterval(intervalVisanet);
		}else if(operacion==='hideLightboxTokenizationAgora'){
			$('body').find('#loadTokenization').remove();	
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCardAgora();
			clearInterval(intervalAgora);
		}else if(operacion==='observerLightboxTokenization'){
			intervalVisanet = setInterval(checkFormVisanet, 1000);
		}else if(operacion==='observerLightboxTokenizationAgora'){
			intervalAgora = setInterval(checkFormAgora, 1000);
		}else if(operacion==='errorLoadingTokenization'){
			$('body').find('#loadTokenization').remove();	
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCard();
			clearInterval(intervalVisanet);
			var mensaje = arrayData[1];
			showMessageError(title_error_general,mensaje);
		}else if(operacion==='errorLoadingTokenizationAgora'){
			$('body').find('#loadTokenization').remove();	
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCardAgora();
			clearInterval(intervalAgora);
			var mensaje = arrayData[1];
			showMessageError(title_error_general,mensaje);
		}
	}
}

function checkFormVisanet(){
	try {
		var frameVisa = document.getElementById("frmLightboxTokenization");
		var iframeDocument = frameVisa.contentDocument;
		var framePago = iframeDocument.getElementById("visaNetJS");
		if(framePago==null || framePago==undefined){//si ya tokenizo
			$('body').find('#loadTokenization').remove();
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			clearInterval(intervalVisanet);
			
			$('body').append('<i id="loadTokenization" class="loadingMobile" style="z-index: 10001 !important;"></i>');
			$.ajax({
		        type: "POST",
		        url: "getTokenizedCard.html",
		        dataType: "json",
		        beforeSend: function (xhr, settings) {
		        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
		        },
			})
			.done(function(data) {
				if(data.status=="OK"){
					$('#tarjetaTokenizada').text("Tarjeta: "+data.cardNumber);
					$('#txtTarjetaTokenizada').val(data.cardNumber);
					$('#divVisa').removeClass('is-error');
					
					$('#visaCardButton').fadeOut(250, function () {
						setTimeout(function () {
						  $('#visaCardText').removeClass('hidden');
						}, 250);
					});
				}else{
					deleteTokenizedCard();
					showMessageErrorVisa(title_error_general,data.message);
				}
				$('body').find('#loadTokenization').remove();
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				if(jqXHR.status==403){
					window.location.href = 'inicio.html';
		    	}else{
		    		$('body').find('#loadTokenization').remove();
					showMessageError(title_error_general,msg_error_general);
		    	}	
			});
		}else if(framePago.style.display == 'none'){//si cancelo
			$('body').find('#loadTokenization').remove();
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCard();
			clearInterval(intervalVisanet);
		}
	} catch (e) {
		$('body').find('#loadTokenization').remove();
		$('body').find('#div-lightbox-tokenization-ilot').remove();	
		deleteTokenizedCard();
		clearInterval(intervalVisanet);
	}
}

function checkFormAgora(){
	try {
		var frameVisa = document.getElementById("frmLightboxTokenization");
		var iframeDocument = frameVisa.contentDocument;
		var framePago = iframeDocument.getElementById("visaNetJS");
		if(framePago==null || framePago==undefined){//si ya tokenizo
			$('body').find('#loadTokenization').remove();
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			clearInterval(intervalAgora);
			
			$('body').append('<i id="loadTokenization" class="loadingMobile" style="z-index: 10001 !important;"></i>');
			$.ajax({
		        type: "POST",
		        url: "getTokenizedCardAgora.html",
		        dataType: "json",
		        beforeSend: function (xhr, settings) {
		        	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
		        },
			})
			.done(function(data) {
				if(data.status=="OK"){
					$('#tarjetaTokenizadaAgora').text("Tarjeta: "+data.cardNumber);
					$('#txtTarjetaTokenizadaAgora').val(data.cardNumber);
					$('#divAgora').removeClass('is-error');
					
					$('#visaCardButtonAgora').fadeOut(250, function () {
						setTimeout(function () {
						  $('#visaCardTextAgora').removeClass('hidden');
						}, 250);
					});
				}else{
					deleteTokenizedCardAgora();
					showMessageErrorAgora(title_error_general,data.message);
				}
				$('body').find('#loadTokenization').remove();
			})
			.fail(function(jqXHR, textStatus, errorThrown ) {
				if(jqXHR.status==403){
					window.location.href = 'inicio.html';
		    	}else{
		    		$('body').find('#loadTokenization').remove();
					showMessageError(title_error_general,msg_error_general);
		    	}				
			});
		}else if(framePago.style.display == 'none'){//si cancelo
			$('body').find('#loadTokenization').remove();
			$('body').find('#div-lightbox-tokenization-ilot').remove();	
			deleteTokenizedCardAgora();
			clearInterval(intervalAgora);
		}
	} catch (e) {
		$('body').find('#loadTokenization').remove();
		$('body').find('#div-lightbox-tokenization-ilot').remove();	
		deleteTokenizedCardAgora();
		clearInterval(intervalAgora);
	}
}

function deleteTokenizedCard(){
	$('#tarjetaTokenizada').text("");
	$('#txtTarjetaTokenizada').val("");
	
	$('#visaCardText').addClass('hidden');
	$('#visaCardButton').fadeIn(1);
	
//	$.ajax({
//        type: "POST",
//        url: "deleteTokenizedCard.html",
//        dataType: "json",
//        success: function (data) {
//            
//        }
//    });
	$.ajax({
	  type: "POST",
	  url: "deleteTokenizedCard.html",
	  dataType: "json",
	  beforeSend: function (xhr, settings) {
      	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
      },
	})
	.done(function(data) {
		
	})
    .fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
}

function deleteTokenizedCardAgora(){
	$('#tarjetaTokenizadaAgora').text("");
	$('#txtTarjetaTokenizadaAgora').val("");
	
	$('#visaCardTextAgora').addClass('hidden');
	$('#visaCardButtonAgora').fadeIn(1);
	
//	$.ajax({
//        type: "POST",
//        url: "deleteTokenizedCardAgora.html",
//        dataType: "json",
//        success: function (data) {
//            
//        }
//    });
	
	$.ajax({
	  type: "POST",
	  url: "deleteTokenizedCardAgora.html",
	  dataType: "json",
	  beforeSend: function (xhr, settings) {
      	xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
      },
	})
	.done(function(data) {
		
	})
    .fail(function( jqXHR, textStatus, errorThrown ) {
    	if(jqXHR.status==403){
    		window.location.href = 'inicio.html';
    	}
    });
}

function createRequest(e,url,data){
	let $wrapper = $(e.currentTarget).closest('.content_loading');
	$.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        data: data,
        beforeSend: function (xhr, settings) {
      	  $wrapper.addClass('loading');
      	  xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
    })
    .done(function(data) {
    	if (data.status === 'OK' && data.message === 'OK') { 	            	  
      	  showRequestSuccessModal(data);
        }else{
      	  if(data.clean!=undefined && data.clean==='OK'){
      		  cleanPaymentPrizeVisa();
      	  }else if(data.cleanCash!=undefined && data.cleanCash==='OK'){
    		  cleanPaymentPrizeCash();
    	  }else if(data.cleanAgora!=undefined && data.cleanAgora==='OK'){
      		  cleanPaymentPrizeAgora();
      	  }else if(data.cleanTrans!=undefined && data.cleanTrans==='OK'){
      		cleanPaymentPrizeTrans();
      	  }
      	  
      	  if(data.titulo!=undefined && data.titulo!=''){
      		$("#title-modal-error").html(data.titulo);
      	  }else{
      		$("#title-modal-error").html("No pudimos procesar tu solicitud");
      	  }
      	  
      	  $("#mensajeErrorSolicitud").html(data.message);
      	  simpleModal.onToggleModalMsg("#modal-error");
        }
    	$wrapper.removeClass('loading');
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
		if(jqXHR.status==403){
			window.location.href = 'inicio.html';
		}else{
			$wrapper.removeClass('loading');
			cleanPaymentPrize();
			showMessageError("Tuviste una interrupción al solicitar tu retiro",
					"Verifica tu retiro en Historial de Retiros en unos minutos. De estar listado, ten en cuenta que la mayoría de los retiros se procesan en menos de 30 minutos; caso contrario, podría demorar hasta 48 horas");
		}
	});
}

function showRequestSuccessModal(data){	
	if(data.paymentType==='VISA'){
		accAmtVisa+=parseInt(data.amount,10);
	}else if(data.paymentType==='AGORA'){
		accAmtAgora+=parseInt(data.amount,10);
	}else if(data.paymentType==='TRANSFERENCIA'){
		accAmtTrans+=parseInt(data.amount,10);
		if(data.guardarRecurrente!=undefined && data.guardarRecurrente=="true"){
			objListAccount = JSON.parse(data.getSavingsAccount);
			if(objListAccount.length>0){
				prepararPantallaRecurrenteTransferencia(objListAccount);
			}
		}
		
		if(data.daysElapsedDni!=undefined && data.daysElapsedDni>=0){
			daysElapsedDni=parseInt(data.daysElapsedDni,10);
		}
		
		if(premioSeleccionado!=undefined && premioSeleccionado!=null){
			$("#ticket"+premioSeleccionado.ticketId).remove();
		}
	}else{
		accAmtCash+=parseInt(data.amount,10);
	}
	
	if(data.stateDni!=undefined && data.stateDni==='ACT'){
		$("#stateDniPEN").css("display","none");
		$("#stateDniACT").css("display","block");
		$("#imgDNI").removeAttr("data-valid");
		$("#stateDniPENLabel").css("display","none");
		$("#stateDniACTLabel").css("display","block");
		$('#filenamesDniVisa').removeClass('empty');
		stateDni='ACT';
		
		$("#divDniLabel").removeClass('divDniPen');
		$('#filenamesDniVisa').addClass('filenames-act');
		
		$("#stateDniPENAgora").css("display","none");
		$("#stateDniACTAgora").css("display","block");
		$("#imgDNIAgora").removeAttr("data-valid");
		$("#stateDniPENLabelAgora").css("display","none");
		$("#stateDniACTLabelAgora").css("display","block");
		$('#filenamesDniAgora').removeClass('empty');
		
		$("#divDniLabelAgora").removeClass('divDniPen');
		$('#filenamesDniAgora').addClass('filenames-act');
		
		$("#stateDniPENEfectivo").css("display","none");
		$("#stateDniACTEfectivo").css("display","block");
		$("#imgDNIEfectivo").removeAttr("data-valid");
		$("#stateDniPENLabelEfectivo").css("display","none");
		$("#stateDniACTLabelEfectivo").css("display","block");
		$('#filenamesDniEfectivo').removeClass('empty');
		
		$("#divDniLabelEfectivo").removeClass('divDniPen');
		$('#filenamesDniEfectivo').addClass('filenames-act');
		
		$("#divDniLabelTransferencia").removeClass('divDniPen');
		$('#filenamesDniTransferencia').addClass('filenames-act');
		$("#stateDniPENTransferencia").css("display","none");
		$("#stateDniACTTransferencia").css("display","block");
		$("#imgDNITransferencia").removeAttr("data-valid");
		$("#stateDniPENLabelTransferencia").css("display","none");
		$("#stateDniACTLabelTransferencia").css("display","block");
		$('#filenamesDniTransferencia').removeClass('empty');
		
		$("#stateDniPENTransferenciaPML").css("display","none");
		$("#stateDniACTTransferenciaPML").css("display","block");
		$("#imgDNITransferenciaPML").removeAttr("data-valid");
		$("#stateDniPENLabelTransferenciaPML").css("display","none");
		$("#stateDniACTLabelTransferenciaPML").css("display","block");
		$('#filenamesDniTransferenciaPML').removeClass('empty');
	}	  
	if(data.evaluacion==='MANUAL'){
		$("#montoSolicitado").html("Recibimos tu retiro por <br> "+"S/"+floatFormat(data.amount).replace(".00","") );	  
	}else{
		//$("#montoSolicitado").html("¡Tu retiro está aprobado! <br> "+"S/"+floatFormat(data.amount).replace(".00","") );
		$("#montoSolicitado").html("¡Tu retiro de S/"+floatFormat(data.amount).replace(".00","")+" <br>está aprobado!");
	}
	$("#message-modal-success").html(data.messageSuccess);
	$("#saldoLiquidable").text("S/"+floatFormat(data.saldoLiquidable).replace(".00",""));
	cleanPaymentPrize();
	simpleModal.onToggleModalMsg("#modal-success");
} 

function cleanPaymentPrizeVisa(){
	$("#delimgDNIVisa").trigger("click");
	$('#amountVisa').val("");
	$('.listaMetodosRetiro').find('.accordion__body').css('display','none');
	$('.listaMetodosRetiro').find('li').removeClass('opened');
	$('#divVisa').removeClass('is-error');
	$('#divMontoVisa').removeClass('is-error');
	$('#divDniLabel').removeClass('is-error');
	
	$('#divStepDNI').addClass('hidden');
	$('#divImgDni').removeClass('is-error');
	$("#imgDNI").removeAttr("data-valid");
	$("#stepCard").html("2");

	deleteTokenizedCard();
	$('#formvisa').find('.subcontent-comision').addClass('hidden');
}

function cleanPaymentPrizeAgora(){
	$("#delimgDNIAgora").trigger("click");
	$('#amountAgora').val("");
	$('.listaMetodosRetiro').find('.accordion__body').css('display','none');
	$('.listaMetodosRetiro').find('li').removeClass('opened');
	$('#divAgora').removeClass('is-error');
	$('#divMontoAgora').removeClass('is-error');
	$('#divDniLabelAgora').removeClass('is-error');
	
	$('#divStepDNIAgora').addClass('hidden');
	$('#divImgDniAgora').removeClass('is-error');
	$("#imgDNIAgora").removeAttr("data-valid");
	$("#stepCardAgora").html("2");
	
	deleteTokenizedCardAgora();
	$('#formagora').find('.subcontent-comision').addClass('hidden');
}

function cleanPaymentPrizeCash(){
	$("#delimgDNIEfectivo").trigger("click");
	$('#amountEfectivo').val("");
	$('.listaMetodosRetiro').find('.accordion__body').css('display','none');
	$('.listaMetodosRetiro').find('li').removeClass('opened');
	$('#divImgDniEfectivo').removeClass('is-error');
	$('#divMontoEfectivo').removeClass('is-error');
	
	$('#stepUnoEfectivo').addClass('hiddenStep');
	$('#divStepUnoEfectivo').removeClass('step');
	$('#divStepDNIEfectivo').addClass('hidden');
	$("#imgDNIEfectivo").removeAttr("data-valid");
	
	$('#divDniLabelEfectivo').removeClass('is-error');
}

function cleanPaymentPrizeTrans(){
	$('#amountTransferencia').val("");
	$('.listaMetodosRetiro').find('.accordion__body').css('display','none');
	$('.listaMetodosRetiro').find('li').removeClass('opened');
	$('#divMontoTransferencia').removeClass('is-error');
	
	$("#delimgDNITransferencia").trigger("click");
	
	if(transRangoActivo=="1"){
		var isDniActive=acondicionaSeccionDniTransferencia();
		if(htmlPantallaRecurrenteRango1!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango1);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
	}else{
		var isDniActive=acondicionaSeccionDniTransferencia();
		if(htmlPantallaRecurrenteRango2_3!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
	}
		
	$("#recurrenteTra").prop("checked", false); 
	$("#ibanco").val("").change();
	$('#divBanco').removeClass('is-error');
	$('#inumacount').val("");
	$('#divCuenta').removeClass('is-error');
	$("#ideparment").val("").change();
	$('#divDepartamento').removeClass('is-error');
	$('#divDniLabelTransferencia').removeClass('is-error');
}

function cleanPaymentPrizeTransPML(){
	$("#delimgDNITransferenciaPML").trigger("click");
	
	if(htmlPantallaRecurrenteRango2_3!=""){
		$("#listaCuentaAhorrosPML").html(htmlPantallaRecurrenteRango2_3);
		if(pantallaListaRecurrente==false){
			activarPantallaRecurrenteTransferencia();
		}
	}else{
		if(pantallaListaRecurrente){
			desactivarPantallaRecurrenteTransferencia();
		}
	}
	
	$("#recurrenteTra").prop("checked", false); 
	$("#ibancoPML").val("").change();
	$('#divBancoPML').removeClass('is-error');
	$('#inumacountPML').val("");
	$('#divCuentaPML').removeClass('is-error');
	$("#ideparmentPML").val("").change();
	$('#divDepartamentoPML').removeClass('is-error');
}

function cleanPaymentPrize(){
	$('#tarjetaTokenizada').text("");
	$('#txtTarjetaTokenizada').val("");
	$('#tarjetaTokenizadaAgora').text("");
	$('#txtTarjetaTokenizadaAgora').val("");
	$("#delimgDNIVisa").trigger("click");
	$("#delimgDNIAgora").trigger("click");
	$("#delimgDNIEfectivo").trigger("click");
	
	$('#divStepDNI').addClass('hidden');
	$('#divImgDni').removeClass('is-error');
	$('#divDniLabel').removeClass('is-error');
	$("#imgDNI").removeAttr("data-valid");
	$("#stepCard").html("2");
	$('#divStepDNIEfectivo').addClass('hidden');
	$('#divImgDniEfectivo').removeClass('is-error');
	$("#imgDNIEfectivo").removeAttr("data-valid");
	
	$('#divStepDNIAgora').addClass('hidden');
	$('#divImgDniAgora').removeClass('is-error');
	$('#divDniLabelAgora').removeClass('is-error');
	$("#imgDNIAgora").removeAttr("data-valid");
	$("#stepCardAgora").html("2");
		
	$('#amountVisa').val("");
	$('#amountEfectivo').val("");
	$('#amountAgora').val("");
	$('#amountTransferencia').val("");
	$('.listaMetodosRetiro').find('.accordion__body').css('display','none');
	$('.listaMetodosRetiro').find('li').removeClass('opened');
	$('#divVisa').removeClass('is-error');
	$('#divAgora').removeClass('is-error');
	$('#divMontoVisa').removeClass('is-error');
	$('#divMontoAgora').removeClass('is-error');
	$('#divMontoEfectivo').removeClass('is-error');
	$('#divMontoTransferencia').removeClass('is-error');
	
	$('#stepUnoEfectivo').addClass('hiddenStep');
	$('#divStepUnoEfectivo').removeClass('step');

	$('#divDniLabelEfectivo').removeClass('is-error');
	deleteTokenizedCard();
	deleteTokenizedCardAgora();
	
	$('#formvisa').find('.subcontent-comision').addClass('hidden');
	$('#formagora').find('.subcontent-comision').addClass('hidden');
	
	$("#delimgDNITransferencia").trigger("click");
	
	if(transRangoActivo=="1"){
		var isDniActive=acondicionaSeccionDniTransferencia();	
		if(htmlPantallaRecurrenteRango1!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango1);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
	}else{
		var isDniActive=acondicionaSeccionDniTransferencia();
		if(htmlPantallaRecurrenteRango2_3!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
	}
	
	$("#recurrenteTra").prop("checked", false); 
	$("#ibanco").val("").change();
	$('#divBanco').removeClass('is-error');
	$('#inumacount').val("");
	$('#divCuenta').removeClass('is-error');
	$("#ideparment").val("").change();
	$('#divDepartamento').removeClass('is-error');
	$('#divDniLabelTransferencia').removeClass('is-error');
}

//scales the image by (float) scale < 1
//returns a canvas containing the scaled image.
function downScaleImage(img, scale) {
var imgCV = document.createElement('canvas');
imgCV.width = img.width;
imgCV.height = img.height;
var imgCtx = imgCV.getContext('2d');
imgCtx.drawImage(img, 0, 0);
return downScaleCanvas(imgCV, scale);
}

//scales the canvas by (float) scale < 1
//returns a new canvas containing the scaled image.
function downScaleCanvas(cv, scale) {
if (!(scale < 1) || !(scale > 0)) throw ('scale must be a positive number <1 ');
var sqScale = scale * scale; // square scale = area of source pixel within target
var sw = cv.width; // source image width
var sh = cv.height; // source image height
var tw = Math.floor(sw * scale); // target image width
var th = Math.floor(sh * scale); // target image height
var sx = 0, sy = 0, sIndex = 0; // source x,y, index within source array
var tx = 0, ty = 0, yIndex = 0, tIndex = 0; // target x,y, x,y index within target array
var tX = 0, tY = 0; // rounded tx, ty
var w = 0, nw = 0, wx = 0, nwx = 0, wy = 0, nwy = 0; // weight / next weight x / y
// weight is weight of current source point within target.
// next weight is weight of current source point within next target's point.
var crossX = false; // does scaled px cross its current px right border ?
var crossY = false; // does scaled px cross its current px bottom border ?
var sBuffer = cv.getContext('2d').
getImageData(0, 0, sw, sh).data; // source buffer 8 bit rgba
var tBuffer = new Float32Array(3 * tw * th); // target buffer Float32 rgb
var sR = 0, sG = 0,  sB = 0; // source's current point r,g,b
/* untested !
var sA = 0;  //source alpha  */    

for (sy = 0; sy < sh; sy++) {
   ty = sy * scale; // y src position within target
   tY = 0 | ty;     // rounded : target pixel's y
   yIndex = 3 * tY * tw;  // line index within target array
   crossY = (tY != (0 | ty + scale)); 
   if (crossY) { // if pixel is crossing botton target pixel
       wy = (tY + 1 - ty); // weight of point within target pixel
       nwy = (ty + scale - tY - 1); // ... within y+1 target pixel
   }
   for (sx = 0; sx < sw; sx++, sIndex += 4) {
       tx = sx * scale; // x src position within target
       tX = 0 |  tx;    // rounded : target pixel's x
       tIndex = yIndex + tX * 3; // target pixel index within target array
       crossX = (tX != (0 | tx + scale));
       if (crossX) { // if pixel is crossing target pixel's right
           wx = (tX + 1 - tx); // weight of point within target pixel
           nwx = (tx + scale - tX - 1); // ... within x+1 target pixel
       }
       sR = sBuffer[sIndex    ];   // retrieving r,g,b for curr src px.
       sG = sBuffer[sIndex + 1];
       sB = sBuffer[sIndex + 2];

       /* !! untested : handling alpha !!
          sA = sBuffer[sIndex + 3];
          if (!sA) continue;
          if (sA != 0xFF) {
              sR = (sR * sA) >> 8;  // or use /256 instead ??
              sG = (sG * sA) >> 8;
              sB = (sB * sA) >> 8;
          }
       */
       if (!crossX && !crossY) { // pixel does not cross
           // just add components weighted by squared scale.
           tBuffer[tIndex    ] += sR * sqScale;
           tBuffer[tIndex + 1] += sG * sqScale;
           tBuffer[tIndex + 2] += sB * sqScale;
       } else if (crossX && !crossY) { // cross on X only
           w = wx * scale;
           // add weighted component for current px
           tBuffer[tIndex    ] += sR * w;
           tBuffer[tIndex + 1] += sG * w;
           tBuffer[tIndex + 2] += sB * w;
           // add weighted component for next (tX+1) px                
           nw = nwx * scale
           tBuffer[tIndex + 3] += sR * nw;
           tBuffer[tIndex + 4] += sG * nw;
           tBuffer[tIndex + 5] += sB * nw;
       } else if (crossY && !crossX) { // cross on Y only
           w = wy * scale;
           // add weighted component for current px
           tBuffer[tIndex    ] += sR * w;
           tBuffer[tIndex + 1] += sG * w;
           tBuffer[tIndex + 2] += sB * w;
           // add weighted component for next (tY+1) px                
           nw = nwy * scale
           tBuffer[tIndex + 3 * tw    ] += sR * nw;
           tBuffer[tIndex + 3 * tw + 1] += sG * nw;
           tBuffer[tIndex + 3 * tw + 2] += sB * nw;
       } else { // crosses both x and y : four target points involved
           // add weighted component for current px
           w = wx * wy;
           tBuffer[tIndex    ] += sR * w;
           tBuffer[tIndex + 1] += sG * w;
           tBuffer[tIndex + 2] += sB * w;
           // for tX + 1; tY px
           nw = nwx * wy;
           tBuffer[tIndex + 3] += sR * nw;
           tBuffer[tIndex + 4] += sG * nw;
           tBuffer[tIndex + 5] += sB * nw;
           // for tX ; tY + 1 px
           nw = wx * nwy;
           tBuffer[tIndex + 3 * tw    ] += sR * nw;
           tBuffer[tIndex + 3 * tw + 1] += sG * nw;
           tBuffer[tIndex + 3 * tw + 2] += sB * nw;
           // for tX + 1 ; tY +1 px
           nw = nwx * nwy;
           tBuffer[tIndex + 3 * tw + 3] += sR * nw;
           tBuffer[tIndex + 3 * tw + 4] += sG * nw;
           tBuffer[tIndex + 3 * tw + 5] += sB * nw;
       }
   } // end for sx 
} // end for sy

// create result canvas
var resCV = document.createElement('canvas');
resCV.width = tw;
resCV.height = th;
var resCtx = resCV.getContext('2d');
var imgRes = resCtx.getImageData(0, 0, tw, th);
var tByteBuffer = imgRes.data;
// convert float32 array into a UInt8Clamped Array
var pxIndex = 0; //  
for (sIndex = 0, tIndex = 0; pxIndex < tw * th; sIndex += 3, tIndex += 4, pxIndex++) {
   tByteBuffer[tIndex] = Math.ceil(tBuffer[sIndex]);
   tByteBuffer[tIndex + 1] = Math.ceil(tBuffer[sIndex + 1]);
   tByteBuffer[tIndex + 2] = Math.ceil(tBuffer[sIndex + 2]);
   tByteBuffer[tIndex + 3] = 255;
}
// writing result to canvas.
resCtx.putImageData(imgRes, 0, 0);
return resCV;
}

function getComisionVisa(monto){
	var comision = 0;
	if(monto>=configLoaded.comMinRan1Visa && monto<=configLoaded.comMaxRan1Visa){
		comision=configLoaded.comAmtRan1Visa;
	}else if(monto>=configLoaded.comMinRan2Visa && monto<=configLoaded.comMaxRan2Visa){
		comision=configLoaded.comAmtRan2Visa;
	}else if(monto>=configLoaded.comMinRan3Visa && monto<=configLoaded.comMaxRan3Visa){
		comision=configLoaded.comAmtRan3Visa;
	}else if(monto>=configLoaded.comMinRan4Visa && monto<=configLoaded.comMaxRan4Visa){
		comision=configLoaded.comAmtRan4Visa;
	}
	return comision;
}

function getComisionAgora(monto){
	var comision = 0;
	if(monto>=configLoaded.comMinRan1Agr && monto<=configLoaded.comMaxRan1Agr){
		comision=configLoaded.comAmtRan1Agr;
	}else if(monto>=configLoaded.comMinRan2Agr && monto<=configLoaded.comMaxRan2Agr){
		comision=configLoaded.comAmtRan2Agr;
	}else if(monto>=configLoaded.comMinRan3Agr && monto<=configLoaded.comMaxRan3Agr){
		comision=configLoaded.comAmtRan3Agr;
	}else if(monto>=configLoaded.comMinRan4Agr && monto<=configLoaded.comMaxRan4Agr){
		comision=configLoaded.comAmtRan4Agr;
	}
	return comision;
}

function confirmarRetiroEfectivo(){
    $('#modal-confirmar-retiro-efectivo').fadeIn(350);
}

function continuarRetiroEfectivo(){
	$('#modal-confirmar-retiro-efectivo').fadeOut(250);
	createRequest(formularioEfectivo,"createRequest.html","amountEfectivo="+$('#amountEfectivo').val()+"&imgDNI="+imgBase64P1Cash);
}

function irVisa(){
	$("#amountVisa").val($("#amountEfectivo").val());
	$("#amountVisa").keyup();
	cleanPaymentPrizeCash();
	$("#accordion_visa").addClass('opened');
	$("#accordion_visa").find('.accordion__body').css('display','block');
	setTimeout(function() { $("#amountVisa").focus(); }, 0);
	$('#modal-confirmar-retiro-efectivo').fadeOut(250);
}

function confirmarRetiroTransferencia(){   
	$('#confirmaMontoTransferencia').html(floatFormat($('#amountTransferencia').val()).replace(".00",""));
	
	if(pantallaListaRecurrente){
		var numeroCuentaTrans = $('input[name=card]:checked', '#formtransferencia').val();
		for(var i=0; i<objListAccount.length; i++){		
			if(numeroCuentaTrans==objListAccount[i].accountNumber){
				var banco = objListAccount[i].bank;
				if(banco=="Interbank"){
					$('#confirmaBancoTransferencia').html("Interbank");
				}else if(banco=="Banco de Credito"){
					$('#confirmaBancoTransferencia').html("BCP");
				}else if(banco=="Banco Continental"){
					$('#confirmaBancoTransferencia').html("BBVA");
				}else if(banco=="Scotiabank"){
					$('#confirmaBancoTransferencia').html("Scotiabank");
				}else{
					$('#confirmaBancoTransferencia').html("Otros");
				}
				$('#confirmaDepartamentoTransferencia').html(objListAccount[i].department);
				break;
			}	
		}
		$('#confirmaNumCuentaTransferencia').html(numeroCuentaTrans);
	}else{
		var ibanco = $('#ibanco').val();
		if(ibanco==1){//ibk
			$('#confirmaBancoTransferencia').html("Interbank");
		}else if(ibanco==2){//bcp
			$('#confirmaBancoTransferencia').html("BCP");
		}else if(ibanco==3){//bbva
			$('#confirmaBancoTransferencia').html("BBVA");
		}else if(ibanco==4){//scotia
			$('#confirmaBancoTransferencia').html("Scotiabank");
		}else if(ibanco==5){//otros
			$('#confirmaBancoTransferencia').html("Otros");
		}
		$('#confirmaNumCuentaTransferencia').html($('#inumacount').val());
		$('#confirmaDepartamentoTransferencia').html($("#ideparment").children("option:selected").text());
	}
	
	$('#confirmaNombresTransferencia').html(configLoaded.names + " " + configLoaded.lastname);
	$('#confirmaDocumentoTransferencia').html(configLoaded.doctype + " " + configLoaded.docnumber);
    $('#modal-confirmar-retiro-transferencia').fadeIn(350);
}

function continuarRetiroTransferencia(){
	$('#aceptar-confirmar-retiro-transferencia').attr("disabled", "disabled");
	$('#regresar-transferencia').attr("disabled", "disabled");
	$('#modal-confirmar-retiro-transferencia').fadeOut(250);
	if(tipoTransferencia=="PML"){
		if( $('#recurrenteTra').prop('checked') && pantallaListaRecurrente==false) {
			createRequest(formularioTransferenciaPML,"createRequestTransferencia.html","amountTransferencia="+ premioSeleccionado.prizeAmount +"&guardarRecurrente=true&recurrenteSeleccionado=false&imgDNITransferencia="+imgBase64P1TransPML+"&banco="+$('#ibancoPML').val()+"&cuenta="+$('#inumacountPML').val()+"&departamento="+$('#ideparmentPML').val()+"&ncRecurrenteSeleccionado=&tipoTransferencia="+tipoTransferencia+"&ticketId="+premioSeleccionado.ticketId);
		}else if( !$('#recurrenteTra').prop('checked') && pantallaListaRecurrente==false){
			createRequest(formularioTransferenciaPML,"createRequestTransferencia.html","amountTransferencia="+ premioSeleccionado.prizeAmount +"&guardarRecurrente=false&recurrenteSeleccionado=false&imgDNITransferencia="+imgBase64P1TransPML+"&banco="+$('#ibancoPML').val()+"&cuenta="+$('#inumacountPML').val()+"&departamento="+$('#ideparmentPML').val()+"&ncRecurrenteSeleccionado=&tipoTransferencia="+tipoTransferencia+"&ticketId="+premioSeleccionado.ticketId);
		}else if(pantallaListaRecurrente){
			createRequest(formularioTransferenciaPML,"createRequestTransferencia.html","amountTransferencia="+ premioSeleccionado.prizeAmount +"&guardarRecurrente=false&recurrenteSeleccionado=true&imgDNITransferencia="+imgBase64P1TransPML+"&banco="+$('#ibancoPML').val()+"&cuenta="+$('#inumacountPML').val()+"&departamento="+$('#ideparmentPML').val()+"&ncRecurrenteSeleccionado="+$('input[name=card]:checked', '#formtransferenciapml').val()+"&tipoTransferencia="+tipoTransferencia+"&ticketId="+premioSeleccionado.ticketId);
		}else{
			console.log("no valido");
		}
	}else{		
		if( $('#recurrenteTra').prop('checked') && pantallaListaRecurrente==false) {
			createRequest(formularioTransferencia,"createRequestTransferencia.html","amountTransferencia="+$('#amountTransferencia').val()+"&guardarRecurrente=true&recurrenteSeleccionado=false&imgDNITransferencia="+imgBase64P1Trans+"&banco="+$('#ibanco').val()+"&cuenta="+$('#inumacount').val()+"&departamento="+$('#ideparment').val()+"&ncRecurrenteSeleccionado=");
		}else if( !$('#recurrenteTra').prop('checked') && pantallaListaRecurrente==false){
			createRequest(formularioTransferencia,"createRequestTransferencia.html","amountTransferencia="+$('#amountTransferencia').val()+"&guardarRecurrente=false&recurrenteSeleccionado=false&imgDNITransferencia="+imgBase64P1Trans+"&banco="+$('#ibanco').val()+"&cuenta="+$('#inumacount').val()+"&departamento="+$('#ideparment').val()+"&ncRecurrenteSeleccionado=");
		}else if(pantallaListaRecurrente){
			createRequest(formularioTransferencia,"createRequestTransferencia.html","amountTransferencia="+$('#amountTransferencia').val()+"&guardarRecurrente=false&recurrenteSeleccionado=true&imgDNITransferencia="+imgBase64P1Trans+"&banco="+$('#ibanco').val()+"&cuenta="+$('#inumacount').val()+"&departamento="+$('#ideparment').val()+"&ncRecurrenteSeleccionado="+$('input[name=card]:checked', '#formtransferencia').val());
		}else{
			console.log("no valido");
		}
	}
}

function regresarRetiroTransferencia(){
	$('#modal-confirmar-retiro-transferencia').fadeOut(250);
}

function pantallaTraRango1(){
	if(transRangoActivo!="1"){
		transRangoActivo="1";
		var amountMinRequestTraFormateado = floatFormat(configLoaded.amountMinRequestTra).replace(".00","");
		var amountMaxRequestTraFormateado = floatFormat(configLoaded.amountMaxRequestTra).replace(".00","");
		
		$('#transHorarioText').html(transHorariosRan1);
		$('#transLimitesText').html(transLimitesRan1);
		$('#transRango1').css("background-color","#006841");
		$('#transRango1').css("color","white");
		$('#transRango2').css("background-color","#e9e5df");
		$('#transRango2').css("color","black");
		$('#transRango3').css("background-color","#e9e5df");
		$('#transRango3').css("color","black");
		$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto entre S/"+amountMinRequestTraFormateado+" y S/"+amountMaxRequestTraFormateado+" soles");		    	
    	$('#amountTransferencia').attr("data-min", configLoaded.amountMinRequestTra);
    	$('#amountTransferencia').attr("data-max", configLoaded.amountMaxRequestTra);
    	
    	var isDniActive=acondicionaSeccionDniTransferencia();
		if(htmlPantallaRecurrenteRango1!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango1);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
		
		$("#ibanco").html(htmlBancosDisponiblesRango1);
		$("#ibanco").val("").change();
		$('#divBanco').removeClass('is-error');
	}
}

function pantallaTraRango2(){
	if(transRangoActivo!="2"){
		transRangoActivo="2";
		var amountMinRquTraRan2Formateado = floatFormat(configLoaded.amountMinRquTraRan2).replace(".00","");
		var amountMaxRquTraRan2Formateado = floatFormat(configLoaded.amountMaxRquTraRan2).replace(".00","");
		
		$('#transHorarioText').html(transHorariosRan2);
		$('#transLimitesText').html(transLimitesRan2);
		$('#transRango1').css("background-color","#e9e5df");
		$('#transRango1').css("color","black");
		$('#transRango2').css("background-color","#006841");
		$('#transRango2').css("color","white");
		$('#transRango3').css("background-color","#e9e5df");
		$('#transRango3').css("color","black");
		$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto entre S/"+amountMinRquTraRan2Formateado+" y S/"+amountMaxRquTraRan2Formateado+" soles");
    	$('#amountTransferencia').attr("data-min", configLoaded.amountMinRquTraRan2);
    	$('#amountTransferencia').attr("data-max", configLoaded.amountMaxRquTraRan2);

    	var isDniActive=acondicionaSeccionDniTransferencia();
		if(htmlPantallaRecurrenteRango2_3!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
		
		$("#ibanco").html(htmlBancosDisponiblesRango2_3);
		$("#ibanco").val("").change();
		$('#divBanco').removeClass('is-error');
	}
}

function pantallaTraRango3(){
	if(transRangoActivo!="3"){
		transRangoActivo="3";
		var amountMinRquTraRan3Formateado = floatFormat(configLoaded.amountMinRquTraRan3).replace(".00","");
		
		$('#transHorarioText').html(transHorariosRan3);
		$('#transLimitesText').html(transLimitesRan3);
		$('#transRango1').css("background-color","#e9e5df");
		$('#transRango1').css("color","black");
		$('#transRango2').css("background-color","#e9e5df");
		$('#transRango2').css("color","black");
		$('#transRango3').css("background-color","#006841");
		$('#transRango3').css("color","white");
		$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto a partir de S/"+amountMinRquTraRan3Formateado+" soles");
		$('#amountTransferencia').attr("data-min", configLoaded.amountMinRquTraRan3);
    	$('#amountTransferencia').attr("data-max", 99999999);

    	var isDniActive=acondicionaSeccionDniTransferencia();    	
		if(htmlPantallaRecurrenteRango2_3!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(pantallaListaRecurrente){
				desactivarPantallaRecurrenteTransferencia();
			}
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
		
		$("#ibanco").html(htmlBancosDisponiblesRango2_3);
		$("#ibanco").val("").change();
		$('#divBanco').removeClass('is-error');
	}
}

function prepararPantallaTransferencia(data){
	var stateRequestTra = data.stateRequestTra;
	var stateRequestTraRan1 = data.stateRequestTraRan1;
	var stateRequestTraRan2 = data.stateRequestTraRan2;
	var stateRequestTraRan3 = data.stateRequestTraRan3;
	
	objListAccount = JSON.parse(data.getSavingsAccount);
	if(objListAccount.length>0){
		prepararPantallaRecurrenteTransferencia(objListAccount);
	}//else{
		//$("#stepDniTransferencia").html("4");
	//}
	
	var amountMinRquTraRan3Formateado = floatFormat(data.amountMinRquTraRan3).replace(".00","");
	var maxAmtPerWeekTraRan3Formateado = floatFormat(data.maxAmtPerWeekTraRan3).replace(".00","");
	var amountMinRquTraRan2Formateado = floatFormat(data.amountMinRquTraRan2).replace(".00","");
	var amountMaxRquTraRan2Formateado = floatFormat(data.amountMaxRquTraRan2).replace(".00","");
	var maxAmtPerWeekTraRan2Formateado = floatFormat(data.maxAmtPerWeekTraRan2).replace(".00","");
	var amountMinRequestTraFormateado = floatFormat(data.amountMinRequestTra).replace(".00","");
	var amountMaxRequestTraFormateado = floatFormat(data.amountMaxRequestTra).replace(".00","");
	var maxAmountPerWeekTraFormateado = floatFormat(data.maxAmountPerWeekTra).replace(".00","");
	
	if(stateRequestTraRan3=='ACTIVO'){
		$("#rangoMontosTransferencia").html("Monto a partir de S/"+amountMinRquTraRan3Formateado);
		$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto a partir de S/"+amountMinRquTraRan3Formateado+" soles");
		$('#amountTransferencia').attr("data-min", data.amountMinRquTraRan3);
    	$('#amountTransferencia').attr("data-max", 99999999);
		
		transHorarios="Por tu seguridad, un representante de La Tinka se contactará contigo para coordinar el proceso de tu pago en un plazo máximo de 90 días";
		if(data.maxRquPerDayTraRan3=="1"){
			transLimites="Retira 1 transacción diaria."+(data.maxAmtPerWeekTraRan3>0?(" Retiro máximo semanal S/"+maxAmtPerWeekTraRan3Formateado):"");
		}else{
			transLimites="Retira hasta en "+data.maxRquPerDayTraRan3+" transacciones diarias."+(data.maxAmtPerWeekTraRan3>0?(" Retiro máximo semanal S/"+maxAmtPerWeekTraRan3Formateado):"");
		}
		transHorariosRan3=transHorarios;
		transLimitesRan3=transLimites;
		
		$("#divTransRangos").css('margin-bottom','93px');
		$("#divTransRangos").html(
				'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
		             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
		        '</div>'+        
		        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
		        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
		        '</div>'
		);

		transRangoActivo="3";
		var isDniActive=acondicionaSeccionDniTransferencia();
		
		if(htmlPantallaRecurrenteRango2_3!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
			activarPantallaRecurrenteTransferencia();
		}else{
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
		
		$("#ibanco").html(htmlBancosDisponiblesRango2_3);
		$("#ibanco").val("").change();
		$('#divBanco').removeClass('is-error');
	}
	
	if(stateRequestTraRan2=='ACTIVO'){
    	$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto entre S/"+amountMinRquTraRan2Formateado+" y S/"+amountMaxRquTraRan2Formateado+" soles");
    	$('#amountTransferencia').attr("data-min", data.amountMinRquTraRan2);
    	$('#amountTransferencia').attr("data-max", data.amountMaxRquTraRan2);
    	
		transHorarios="Por tu seguridad, un representante de La Tinka se contactará contigo para coordinar el proceso de tu pago en un plazo máximo de 30 días";
		if(data.maxRquPerDayTraRan2=="1"){
			transLimites="Retira 1 transacción diaria."+(data.maxAmtPerWeekTraRan2>0?(" Retiro máximo semanal S/"+maxAmtPerWeekTraRan2Formateado):"");
		}else{
			transLimites="Retira hasta en "+data.maxRquPerDayTraRan2+" transacciones diarias."+(data.maxAmtPerWeekTraRan2>0?(" Retiro máximo semanal S/"+maxAmtPerWeekTraRan2Formateado):"");
		}
		transHorariosRan2=transHorarios;
		transLimitesRan2=transLimites;
		
		if(stateRequestTraRan3=='ACTIVO'){
			$("#rangoMontosTransferencia").html("Monto a partir de S/"+amountMinRquTraRan2Formateado);
			
			$("#divTransRangos").css('margin-bottom','145px');
			$("#divTransRangos").html(
					'<div>'+
						'<div id="transRango2" onclick="pantallaTraRango2()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #006841;color: white;text-align: center;margin-right: 1%;">'+
				          '<p>De S/ '+amountMinRquTraRan2Formateado+'<br>a S/ '+amountMaxRquTraRan2Formateado+'</p>'+
				        '</div>'+
				        '<div id="transRango3" onclick="pantallaTraRango3()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #e9e5df;color: black;text-align: center;margin-right: 1%;">'+
				          '<p>Apartir de <br>S/ '+amountMinRquTraRan3Formateado+'</p>'+
				        '</div>'+
				    '</div>'+
					'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
			             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
			        '</div>'+        
			        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
			        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
			        '</div>'
			);
		}else{
			$("#rangoMontosTransferencia").html("Monto entre S/"+amountMinRquTraRan2Formateado+" - S/"+amountMaxRquTraRan2Formateado);
			
			$("#divTransRangos").css('margin-bottom','93px');
			$("#divTransRangos").html(
					'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
			             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
			        '</div>'+        
			        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
			        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
			        '</div>'
			);
			
			if(htmlPantallaRecurrenteRango2_3!=""){
				$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
				activarPantallaRecurrenteTransferencia();
			}
			
			$("#ibanco").html(htmlBancosDisponiblesRango2_3);
			$("#ibanco").val("").change();
			$('#divBanco').removeClass('is-error');
		}
		transRangoActivo="2";
		var isDniActive=acondicionaSeccionDniTransferencia();
		if(isDniActive){
			$("#stepDeparmentTransferencia").html("5");
		}else{
			$("#stepDeparmentTransferencia").html("4");
		}
	}
	
	if(stateRequestTraRan1=='ACTIVO'){	
    	$("#msgErrorRangoMontosTransferencia").text("Ingrese un monto entre S/"+amountMinRequestTraFormateado+" y S/"+amountMaxRequestTraFormateado+" soles");		    	
    	$('#amountTransferencia').attr("data-min", data.amountMinRequestTra);
    	$('#amountTransferencia').attr("data-max", data.amountMaxRequestTra);
		
		transHorarios="Confirmado tu retiro, éste será transferido dentro de los siguientes 60 minutos, de lunes a viernes de 9:00 am a 7:00 pm y sábados de 9:00 am a 2:00 pm.";
		if(data.maxRequestPerDayTra=="1"){
			transLimites="Retira 1 transacción diaria."+(data.maxAmountPerWeekTra>0?(" Retiro máximo semanal S/"+maxAmountPerWeekTraFormateado):"");
		}else{
			transLimites="Retira hasta en "+data.maxRequestPerDayTra+" transacciones diarias."+(data.maxAmountPerWeekTra>0?(" Retiro máximo semanal S/"+maxAmountPerWeekTraFormateado):"");
		}
		transHorariosRan1=transHorarios;
		transLimitesRan1=transLimites;
		
		if(stateRequestTraRan3=='ACTIVO'){
			$("#rangoMontosTransferencia").html("Monto a partir de S/"+amountMinRequestTraFormateado);
			
			if(stateRequestTraRan2=='ACTIVO'){
				$("#divTransRangos").css('margin-bottom','145px');
				$("#divTransRangos").html(
						'<div>'+
					        '<div id="transRango1" onclick="pantallaTraRango1()" style="cursor: pointer;width: 32%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #006841;color: white;text-align: center;margin-right: 1%;">'+
					        	'<p>De S/ '+amountMinRequestTraFormateado+'<br>a S/ '+amountMaxRequestTraFormateado+'</p>'+
					        '</div>'+
							'<div id="transRango2" onclick="pantallaTraRango2()" style="cursor: pointer;width: 32%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #e9e5df;color: black;text-align: center;margin-right: 1%;">'+
					          	'<p>De S/ '+amountMinRquTraRan2Formateado+'<br>a S/ '+amountMaxRquTraRan2Formateado+'</p>'+
					        '</div>'+
					        '<div id="transRango3" onclick="pantallaTraRango3()" style="cursor: pointer;width: 33%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #e9e5df;color: black;text-align: center;">'+
					          '<p>Apartir de <br>S/ '+amountMinRquTraRan3Formateado+'</p>'+
					        '</div>'+
					    '</div>'+
						'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
				             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
				        '</div>'+        
				        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
				        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
				        '</div>'
				);
			}else{
				$("#divTransRangos").css('margin-bottom','145px');
				$("#divTransRangos").html(
						'<div>'+
					        '<div id="transRango1" onclick="pantallaTraRango1()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #006841;color: white;text-align: center;margin-right: 1%;">'+
					        	'<p>De S/ '+amountMinRequestTraFormateado+'<br>a S/ '+amountMaxRequestTraFormateado+'</p>'+
					        '</div>'+								        
					        '<div id="transRango3" onclick="pantallaTraRango3()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #e9e5df;color: black;text-align: center;margin-right: 1%;">'+
					          '<p>Apartir de <br>S/ '+amountMinRquTraRan3Formateado+'</p>'+
					        '</div>'+
					    '</div>'+
						'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
				             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
				        '</div>'+        
				        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
				        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
				        '</div>'
				);
			}
		}else{
			if(stateRequestTraRan2=='ACTIVO'){
				$("#rangoMontosTransferencia").html("Monto entre S/"+amountMinRequestTraFormateado+" - S/"+amountMaxRquTraRan2Formateado);
				
				$("#divTransRangos").css('margin-bottom','145px');
				$("#divTransRangos").html(
						'<div>'+
					        '<div id="transRango1" onclick="pantallaTraRango1()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #006841;color: white;text-align: center;margin-right: 1%;">'+
					        	'<p>De S/ '+amountMinRequestTraFormateado+'<br>a S/ '+amountMaxRequestTraFormateado+'</p>'+
					        '</div>'+
							'<div id="transRango2" onclick="pantallaTraRango2()" style="cursor: pointer;width: 49%;margin: 0px;float: left;font-family: Roboto, sans-serif;font-size: 12px;background-color: #e9e5df;color: black;text-align: center;margin-right: 1%;">'+
					          	'<p>De S/ '+amountMinRquTraRan2Formateado+'<br>a S/ '+amountMaxRquTraRan2Formateado+'</p>'+
					        '</div>'+
					    '</div>'+
						'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
				             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
				        '</div>'+        
				        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
				        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
				        '</div>'
				);
			}else{
				$("#rangoMontosTransferencia").html("Monto entre S/"+amountMinRequestTraFormateado+" - S/"+amountMaxRequestTraFormateado);
				
				$("#divTransRangos").css('margin-bottom','93px');
				$("#divTransRangos").html(
						'<div id="transHorario" style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">'+
				             '<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transHorarioText">'+transHorarios+'</p>'+
				        '</div>'+        
				        '<div id="transLimites" style="float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 12px;text-align: justify;color: black;">'+
				        	'<p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="transLimitesText">'+transLimites+'</p>'+
				        '</div>'
				);
			}
		}	

		transRangoActivo="1";
		var isDniActive=acondicionaSeccionDniTransferencia();
		
		if(htmlPantallaRecurrenteRango1!=""){
			$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango1);
			if(pantallaListaRecurrente==false){
				activarPantallaRecurrenteTransferencia();
			}
		}else{
			if(isDniActive){
				$("#stepDeparmentTransferencia").html("5");
			}else{
				$("#stepDeparmentTransferencia").html("4");
			}
		}
		
		$("#ibanco").html(htmlBancosDisponiblesRango1);
		$("#ibanco").val("").change();
		$('#divBanco').removeClass('is-error');
	}
}

function desactivarPantallaRecurrenteTransferencia(){
	pantallaListaRecurrente=false;
	$("#stepBancoTransferencia").removeClass('hidden');
	$("#stepCuentaTransferencia").removeClass('hidden');
	$("#divStepDeparmentTransferencia").removeClass('hidden');
	$("#divRecurrencia").removeClass('hidden');
	$('#stepRecurrentesTransferencia').addClass('hidden');
	$("#stepDniTransferencia").html("4");
	$('#ibanco').attr("data-valid", "required");
	$('#inumacount').attr("data-valid", "account");
	$('#ideparment').attr("data-valid", "required");
	$('#listaCuentaAhorros').removeAttr("data-valid");
	onChangeAmountTransferencia();
}

function activarPantallaRecurrenteTransferencia(){
	pantallaListaRecurrente=true;
	$("#stepBancoTransferencia").addClass('hidden');
	$("#stepCuentaTransferencia").addClass('hidden');
	$("#divStepDeparmentTransferencia").addClass('hidden');
	$("#divRecurrencia").addClass('hidden');
	$('#stepRecurrentesTransferencia').removeClass('hidden');
	$("#stepDniTransferencia").html("3");
	$('#ibanco').removeAttr("data-valid");
	$('#inumacount').removeAttr("data-valid");
	$('#ideparment').removeAttr("data-valid");
	$('#listaCuentaAhorros').attr("data-valid", "radio-group");
}

function prepararPantallaRecurrenteTransferencia(objListAccount){
	htmlPantallaRecurrenteRango1="";
	htmlPantallaRecurrenteRango2_3="";
	//var htmlListAccount="<hr>";
	var htmlListAccount="";
	for(var i=0; i<objListAccount.length; i++){						 
		 if("Interbank"==objListAccount[i].bank){
			 htmlListAccount=  '<div class="item-radio" style="margin-top: 10px;margin-bottom: 10px;">'+
								  '<label class="lq-radio" style="margin-bottom: 0px;">'+
									'<input class="lq-radio__input" type="radio" name="card" onchange="handleCuentaSeleccionadaTrans();" value="'+objListAccount[i].accountNumber+'">'+
									'<img class="logo-ibk-pp" style="height: 22px; width: 50px;" src="layer-view-image/client/logo-interbank-pp.png">'+
									'<span style="float: right; margin-top: 2px; padding-left: 10px;">'+objListAccount[i].accountNumber+'</span>'+
									'<div class="check"></div>'+
								  '</label>'+
								  '<div class="delradio" onclick="confirmarEliminarCuentaTransferencia(\''+objListAccount[i].accountNumber+'\',\''+objListAccount[i].bank+'\')" style="margin-top: 3px;"><img class="icon_eliminar" style="width: 14px;" src="layer-view-image/client/papelera.png"></div>'+
								'</div>'+
								'<hr>';
			 htmlPantallaRecurrenteRango1+=htmlListAccount;
			 htmlPantallaRecurrenteRango2_3+=htmlListAccount;
		 }else if("Banco de Credito"==objListAccount[i].bank){
			 htmlListAccount=  '<div class="item-radio" style="margin-top: 10px;margin-bottom: 10px;">'+
								  '<label class="lq-radio" style="margin-bottom: 0px;">'+
									'<input class="lq-radio__input" type="radio" name="card" onchange="handleCuentaSeleccionadaTrans();" value="'+objListAccount[i].accountNumber+'">'+
									'<img class="logo-bcp-pp" style="height: 20px; width: 60px;" src="layer-view-image/client/logo-bcp-pp.png">'+
									'<span style="float: right; margin-top: 2px; padding-left: 10px;">'+objListAccount[i].accountNumber+'</span>'+
									'<div class="check"></div>'+
								  '</label>'+
								  '<div class="delradio" onclick="confirmarEliminarCuentaTransferencia(\''+objListAccount[i].accountNumber+'\',\''+objListAccount[i].bank+'\')" style="margin-top: 3px;"><img class="icon_eliminar" style="width: 14px;" src="layer-view-image/client/papelera.png"></div>'+
								'</div>'+
								'<hr>';
			 htmlPantallaRecurrenteRango1+=htmlListAccount;
			 htmlPantallaRecurrenteRango2_3+=htmlListAccount;
		 }else if("Banco Continental"==objListAccount[i].bank){
			 htmlListAccount=  '<div class="item-radio" style="margin-top: 10px;margin-bottom: 10px;">'+
								  '<label class="lq-radio" style="margin-bottom: 0px;">'+
									'<input class="lq-radio__input" type="radio" name="card" onchange="handleCuentaSeleccionadaTrans();" value="'+objListAccount[i].accountNumber+'">'+
									'<img class="logo-bbva-pp" style="height: 20px; width: 60px;" src="layer-view-image/client/logo-bbva-pp.png">'+
									'<span style="float: right; margin-top: 2px; padding-left: 10px;">'+objListAccount[i].accountNumber+'</span>'+
									'<div class="check"></div>'+
								  '</label>'+
								  '<div class="delradio" onclick="confirmarEliminarCuentaTransferencia(\''+objListAccount[i].accountNumber+'\',\''+objListAccount[i].bank+'\')" style="margin-top: 3px;"><img class="icon_eliminar" style="width: 14px;" src="layer-view-image/client/papelera.png"></div>'+
								'</div>'+
								'<hr>';
			 htmlPantallaRecurrenteRango1+=htmlListAccount;
			 htmlPantallaRecurrenteRango2_3+=htmlListAccount;
		 }else if("Scotiabank"==objListAccount[i].bank){
			 htmlListAccount=  '<div class="item-radio" style="margin-top: 10px;margin-bottom: 10px;">'+
								  '<label class="lq-radio" style="margin-bottom: 0px;">'+
									'<input class="lq-radio__input" type="radio" name="card" onchange="handleCuentaSeleccionadaTrans();" value="'+objListAccount[i].accountNumber+'">'+
									'<img class="logo-sck-pp" style="height: 20px; width: 65px;" src="layer-view-image/client/logo-scotiabank-pp.png">'+
									'<span style="float: right; margin-top: 2px; padding-left: 10px;">'+objListAccount[i].accountNumber+'</span>'+
									'<div class="check"></div>'+
								  '</label>'+
								  '<div class="delradio" onclick="confirmarEliminarCuentaTransferencia(\''+objListAccount[i].accountNumber+'\',\''+objListAccount[i].bank+'\')" style="margin-top: 3px;"><img class="icon_eliminar" style="width: 14px;" src="layer-view-image/client/papelera.png"></div>'+
								'</div>'+
								'<hr>';
			 htmlPantallaRecurrenteRango1+=htmlListAccount;
		 }else{
			 htmlListAccount=  '<div class="item-radio" style="margin-top: 10px;margin-bottom: 10px;">'+
								  '<label class="lq-radio" style="margin-bottom: 0px;">'+
									'<input class="lq-radio__input" type="radio" name="card" onchange="handleCuentaSeleccionadaTrans();" value="'+objListAccount[i].accountNumber+'"><span style="float: right; margin-top: 2px;">CCI '+objListAccount[i].accountNumber+'</span>'+
									'<div class="check"></div>'+
								  '</label>'+
								  '<div class="delradio" onclick="confirmarEliminarCuentaTransferencia(\''+objListAccount[i].accountNumber+'\',\''+objListAccount[i].bank+'\')" style="margin-top: 3px;"><img class="icon_eliminar" style="width: 14px;" src="layer-view-image/client/papelera.png"></div>'+
								'</div>'+
								'<hr>';
			 htmlPantallaRecurrenteRango1+=htmlListAccount;
			 htmlPantallaRecurrenteRango2_3+=htmlListAccount;
		 }
	}	
	if(htmlPantallaRecurrenteRango1!=""){
		htmlPantallaRecurrenteRango1="<hr>"+htmlPantallaRecurrenteRango1+'<div class="input__error" id="msgErrorSeleccionarCuentaRecurrente">Selecciona una cuenta de ahorros</div>';
	}
	if(htmlPantallaRecurrenteRango2_3!=""){
		htmlPantallaRecurrenteRango2_3="<hr>"+htmlPantallaRecurrenteRango2_3+'<div class="input__error" id="msgErrorSeleccionarCuentaRecurrente">Selecciona una cuenta de ahorros</div>';
	}
	//htmlPantallaRecurrenteRango1=htmlListAccount;
	//$("#listaCuentaAhorros").html(htmlListAccount);
}

function confirmarEliminarCuentaTransferencia(cuenta,banco){
	if(banco=="Interbank"){
		banco="Interbank";
	}else if(banco=="Banco de Credito"){
		banco="BCP";
	}else if(banco=="Banco Continental"){
		banco="BBVA";
	}else if(banco=="Scotiabank"){
		banco="Scotiabank";
	}else{
		banco="CCI";
	}
	
	$('#numCuentaSeleccionadaEliminar').val(cuenta);
	$('#textoEliminarCuentaTransferencia').html("¿Estás seguro que quieres eliminar de la lista la cuenta de ahorros "+banco+" "+cuenta+"?");
    $('#modal-confirmar-eliminar-cuenta-transferencia').fadeIn(350);
}

function cancelarEliminarCuentaTransferencia(){
	$('#modal-confirmar-eliminar-cuenta-transferencia').fadeOut(250);
}

function eliminarCuentaTransferencia(){
	let $wrapper = $("#bodyPrincipal");
	$.ajax({
        type: "POST",
        url: "eliminarCuentaTransferencia.html",
        dataType: "json",
        data: "cuenta="+$('#numCuentaSeleccionadaEliminar').val(),
        beforeSend: function (xhr, settings) {
      	  $wrapper.addClass('loading');
      	  $('#modal-confirmar-eliminar-cuenta-transferencia').fadeOut(250);
      	  xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
        },
    })
    .done(function(data) {
    	if (data.status === 'OK' && data.message === 'OK') {    	            	  
    		objListAccount = JSON.parse(data.getSavingsAccount);
    		if(objListAccount.length>0){
    			prepararPantallaRecurrenteTransferencia(objListAccount);
    		}else{
    			htmlPantallaRecurrenteRango1="";
    			htmlPantallaRecurrenteRango2_3="";
    		}
    		
    		if(transRangoActivo=="1"){

    			var isDniActive=acondicionaSeccionDniTransferencia();
    			if(htmlPantallaRecurrenteRango1!=""){
    				$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango1);
    			}else{
   					desactivarPantallaRecurrenteTransferencia();
   					if(isDniActive){
   						$("#stepDeparmentTransferencia").html("5");
   					}else{
   						$("#stepDeparmentTransferencia").html("4");
   					}
    			}
    		}else{
    			var isDniActive=acondicionaSeccionDniTransferencia();
    			
    			if(htmlPantallaRecurrenteRango2_3!=""){
    				$("#listaCuentaAhorros").html(htmlPantallaRecurrenteRango2_3);
    			}else{
    				desactivarPantallaRecurrenteTransferencia();
    				
    				if(isDniActive){
    					$("#stepDeparmentTransferencia").html("5");
    				}else{
    					$("#stepDeparmentTransferencia").html("4");
    				}
    			}
    		}
    		
        }else{
        	showMessageError("No fue posible eliminar la cuenta", "Por favor, int&eacute;ntalo de nuevo en unos minutos.");
        }
    	$wrapper.removeClass('loading');
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
		if(jqXHR.status==403){
			window.location.href = 'inicio.html';
    	}else{
    		$wrapper.removeClass('loading');
    		showMessageError("No fue posible eliminar la cuenta", "Por favor, int&eacute;ntalo de nuevo en unos minutos.");
    	}	
	});
}
         
function irTransferencia(){
	$("#amountTransferencia").val($("#amountEfectivo").val());
	$("#amountTransferencia").keyup();
	cleanPaymentPrizeCash();
	$("#accordion_transferencia").addClass('opened');
	$("#accordion_transferencia").find('.accordion__body').css('display','block');
	setTimeout(function() { $("#amountTransferencia").focus(); }, 0);
	$('#modal-confirmar-retiro-efectivo').fadeOut(250);
}

function acondicionaSeccionDniTransferencia(){
	var isActive=false;
	if(transRangoActivo=="1"){
		var amountTransferencia = parseInt($("#amountTransferencia").val(), 10);
		if( $("#amountTransferencia").val()!="" && (amountTransferencia>=amountMinEnableDniTrans || (accAmtTrans+amountTransferencia>=minAccAmtEnblDniTrans)) && amountTransferencia>=amountMinRequestTrans ){
			//acciones para activar solicitar DNI
			//mostrar div dni
			$('#divStepDNITransferencia').removeClass('hidden');
			//quitar error
			$('#divImgDniTransferencia').removeClass('is-error');
			//eliminar archivo en caso de haber adjuntsdo
			//$("#delimgDNITransferencia").trigger("click");
			//si esta inactivo 
			if(stateDni!='ACT'){
				//agregar obligatorio
				$('#imgDNITransferencia').attr("data-valid", "required");
				//mostrar adjuntar dni
				$("#stateDniPENTransferencia").css("display","block");
				$("#stateDniPENLabelTransferencia").css("display","flex");
				if(imgBase64P1Trans==""){
					$('#filenamesDniTransferencia').addClass('empty');
				}else{
					$('#filenamesDniTransferencia').removeClass('empty');
				}
				//ocultar actualizar dni
				$("#stateDniACTTransferencia").css("display","none");		
				$("#stateDniACTLabelTransferencia").css("display","none");
			}else{
				//quitar obligatorio
				$("#imgDNITransferencia").removeAttr("data-valid");
				//ocultar adjuntar dni
				$("#stateDniPENTransferencia").css("display","none");
				$("#stateDniPENLabelTransferencia").css("display","none");
				$('#filenamesDniTransferencia').removeClass('empty');
				//mostrar actualizar dni
				if(imgBase64P1Trans==""){
					$("#stateDniACTTransferencia").css("display","block");	
				}else{
					$("#stateDniACTTransferencia").css("display","none");	
				}	
				$("#stateDniACTLabelTransferencia").css("display","block");
			}	
			$("#stepDeparmentTransferencia").html("5");
			isActive=true;
		}else{
			//ocultar div dni
			$('#divStepDNITransferencia').addClass('hidden');
			//quitar error
			$('#divImgDniTransferencia').removeClass('is-error');
			//quitar obligatorio
			$("#imgDNITransferencia").removeAttr("data-valid");
		}
	}else if(transRangoActivo=="2"){
		//acciones para activar solicitar DNI
		//mostrar div dni
		$('#divStepDNITransferencia').removeClass('hidden');
		//quitar error
		$('#divImgDniTransferencia').removeClass('is-error');
		//eliminar archivo en caso de haber adjuntsdo
		//$("#delimgDNITransferencia").trigger("click");
		//si esta inactivo o caduco es obligatorio
		if(stateDni!='ACT' || daysElapsedDni>=configLoaded.validityDniTraRan2){
			//agregar obligatorio
			$('#imgDNITransferencia').attr("data-valid", "required");
			//mostrar adjuntar dni
			$("#stateDniPENTransferencia").css("display","block");
			$("#stateDniPENLabelTransferencia").css("display","flex");
			if(imgBase64P1Trans==""){
				$('#filenamesDniTransferencia').addClass('empty');
			}else{
				$('#filenamesDniTransferencia').removeClass('empty');
			}
			//ocultar actualizar dni
			$("#stateDniACTTransferencia").css("display","none");		
			$("#stateDniACTLabelTransferencia").css("display","none");
		}else{//activo o vigente
			//quitar obligatorio
			$("#imgDNITransferencia").removeAttr("data-valid");
			//ocultar adjuntar dni
			$("#stateDniPENTransferencia").css("display","none");
			$("#stateDniPENLabelTransferencia").css("display","none");
			$('#filenamesDniTransferencia').removeClass('empty');
			//mostrar actualizar dni
			if(imgBase64P1Trans==""){
				$("#stateDniACTTransferencia").css("display","block");	
			}else{
				$("#stateDniACTTransferencia").css("display","none");	
			}	
			$("#stateDniACTLabelTransferencia").css("display","block");
		}
		isActive=true;
	}else if(transRangoActivo=="3"){
		//acciones para activar solicitar DNI
		//mostrar div dni
		$('#divStepDNITransferencia').removeClass('hidden');
		//quitar error
		$('#divImgDniTransferencia').removeClass('is-error');
		//eliminar archivo en caso de haber adjuntsdo
		//$("#delimgDNITransferencia").trigger("click");
		//si esta inactivo o caduco es obligatorio
		if(stateDni!='ACT' || daysElapsedDni>=configLoaded.validityDniTraRan3){
			//agregar obligatorio
			$('#imgDNITransferencia').attr("data-valid", "required");
			//mostrar adjuntar dni
			$("#stateDniPENTransferencia").css("display","block");
			$("#stateDniPENLabelTransferencia").css("display","flex");
			if(imgBase64P1Trans==""){
				$('#filenamesDniTransferencia').addClass('empty');
			}else{
				$('#filenamesDniTransferencia').removeClass('empty');
			}
			//ocultar actualizar dni
			$("#stateDniACTTransferencia").css("display","none");		
			$("#stateDniACTLabelTransferencia").css("display","none");
			
			//actualiza forma desktop
			$("#divDniLabelTransferencia").addClass('divDniPen');
			$('#filenamesDniTransferencia').removeClass('filenames-act');
		}else{//activo o vigente
			//quitar obligatorio
			$("#imgDNITransferencia").removeAttr("data-valid");
			//ocultar adjuntar dni
			$("#stateDniPENTransferencia").css("display","none");
			$("#stateDniPENLabelTransferencia").css("display","none");
			$('#filenamesDniTransferencia').removeClass('empty');
			//mostrar actualizar dni
			if(imgBase64P1Trans==""){
				$("#stateDniACTTransferencia").css("display","block");	
			}else{
				$("#stateDniACTTransferencia").css("display","none");	
			}	
			$("#stateDniACTLabelTransferencia").css("display","block");
			
			//registra forma desktop
			$("#divDniLabelTransferencia").removeClass('divDniPen');
			$('#filenamesDniTransferencia').addClass('filenames-act');
		}
		isActive=true;
	}
	return isActive;
}

function handleCuentaSeleccionadaTrans(){
	$("#listaCuentaAhorros").removeClass('is-error');
}

function cobrarPremioMayor(id){
	premioSeleccionado = hmPremiosMayoresLoterias.get(id);

	if(premioSeleccionado.gameId==4){//GG
		$("#logoProductoPPML").html('<img src="layer-view-image/v2/logo-ganagol.png" style="height: 50px; padding-left: 10px;">');
		$("#logoProductoPPML").css("margin-top","-27");
	}else if(premioSeleccionado.gameId==41){//TK
		$("#logoProductoPPML").html('<img src="layer-view-image/v2/logo-tinka.svg?v=3" style="height: 20px; padding-left: 10px;">');
		$("#logoProductoPPML").css("margin-top","-29");
	}else if(premioSeleccionado.gameId==42){//KB
		$("#logoProductoPPML").html('<img src="layer-view-image/v2/logo-kabala.svg" style="height: 50px; padding-left: 10px;">');
		$("#logoProductoPPML").css("margin-top","-20");
	}else if(premioSeleccionado.gameId==164){//GD
		$("#logoProductoPPML").html('<img src="layer-view-image/v2/logo-ganadiario.svg" style="height: 40px; padding-left: 10px;">');
		$("#logoProductoPPML").css("margin-top","-12");
	}else if(premioSeleccionado.gameId==1121){//KN
		$("#logoProductoPPML").html('<img src="layer-view-image/v2/logo-kinelo.png" style="height: 40px; padding-left: 10px;">');
	}
	
	var fecha = new Date(premioSeleccionado.expirationDate);	
	$("#monto_base").html("S/ "+floatFormat(premioSeleccionado.amountBase).replace(".00",""));
	$("#impuesto").html(floatFormat(premioSeleccionado.amountTax).replace(".00",""));
	$("#neto").html(floatFormat(premioSeleccionado.prizeAmount).replace(".00",""));
	$("#ticketId").html("N° "+premioSeleccionado.ticketId);
	$("#fechaExpiracion").html("Expira, "+fecha.getDate()+" "+fecha.toLocaleString('default', { month: 'long' })+" de "+fecha.getFullYear());
	
	//acciones para activar solicitar DNI
	//mostrar div dni
	$('#divStepDNITransferenciaPML').removeClass('hidden');
	//quitar error
	$('#divImgDniTransferenciaPML').removeClass('is-error');
	//eliminar archivo en caso de haber adjuntsdo
	//$("#delimgDNITransferencia").trigger("click");
	//si esta inactivo
	if(stateDni!='ACT'){
		//agregar obligatorio
		$('#imgDNITransferenciaPML').attr("data-valid", "required");
		//mostrar adjuntar dni
		$("#stateDniPENTransferenciaPML").css("display","block");
		$("#stateDniPENLabelTransferenciaPML").css("display","flex");
		if(imgBase64P1Trans==""){
			$('#filenamesDniTransferenciaPML').addClass('empty');
		}else{
			$('#filenamesDniTransferenciaPML').removeClass('empty');
		}
		//ocultar actualizar dni
		$("#stateDniACTTransferenciaPML").css("display","none");		
		$("#stateDniACTLabelTransferenciaPML").css("display","none");
	}else{//activo o vigente
		//quitar obligatorio
		$("#imgDNITransferenciaPML").removeAttr("data-valid");
		//ocultar adjuntar dni
		$("#stateDniPENTransferenciaPML").css("display","none");
		$("#stateDniPENLabelTransferenciaPML").css("display","none");
		$('#filenamesDniTransferenciaPML').removeClass('empty');
		//mostrar actualizar dni
		if(imgBase64P1Trans==""){
			$("#stateDniACTTransferenciaPML").css("display","block");	
		}else{
			$("#stateDniACTTransferenciaPML").css("display","none");	
		}	
		$("#stateDniACTLabelTransferenciaPML").css("display","block");
	}
	
	
	
	
	$('#modal-premios').fadeOut(250, function () {
		$('#modal-pm').fadeIn();
    });	
}


function confirmarRetiroTransferenciaPML(){
	$('#confirmaMontoTransferencia').html(floatFormat(premioSeleccionado.prizeAmount).replace(".00",""));
	
	if(pantallaListaRecurrente){
		var numeroCuentaTrans = $('input[name=card]:checked', '#formtransferenciapml').val();
		for(var i=0; i<objListAccount.length; i++){		
			if(numeroCuentaTrans==objListAccount[i].accountNumber){
				var banco = objListAccount[i].bank;
				if(banco=="Interbank"){
					$('#confirmaBancoTransferencia').html("Interbank");
				}else if(banco=="Banco de Credito"){
					$('#confirmaBancoTransferencia').html("BCP");
				}else if(banco=="Banco Continental"){
					$('#confirmaBancoTransferencia').html("BBVA");
				}else if(banco=="Scotiabank"){
					$('#confirmaBancoTransferencia').html("Scotiabank");
				}else{
					$('#confirmaBancoTransferencia').html("Otros");
				}
				$('#confirmaDepartamentoTransferencia').html(objListAccount[i].department);
				break;
			}	
		}
		$('#confirmaNumCuentaTransferencia').html(numeroCuentaTrans);
	}else{
		var ibanco = $('#ibancoPML').val();
		if(ibanco==1){//ibk
			$('#confirmaBancoTransferencia').html("Interbank");
		}else if(ibanco==2){//bcp
			$('#confirmaBancoTransferencia').html("BCP");
		}else if(ibanco==3){//bbva
			$('#confirmaBancoTransferencia').html("BBVA");
		}else if(ibanco==4){//scotia
			$('#confirmaBancoTransferencia').html("Scotiabank");
		}else if(ibanco==5){//otros
			$('#confirmaBancoTransferencia').html("Otros");
		}
		$('#confirmaNumCuentaTransferencia').html($('#inumacountPML').val());
		$('#confirmaDepartamentoTransferencia').html($("#ideparmentPML").children("option:selected").text());
	}
	
	$('#confirmaNombresTransferencia').html(configLoaded.names + " " + configLoaded.lastname);
	$('#confirmaDocumentoTransferencia').html(configLoaded.doctype + " " + configLoaded.docnumber);
    $('#modal-confirmar-retiro-transferencia').fadeIn(350);
}

function desactivarPantallaRecurrenteTransferenciaPML(){
	pantallaListaRecurrente=false;
	$("#stepBancoTransferenciaPML").removeClass('hidden');
	$("#stepCuentaTransferenciaPML").removeClass('hidden');
	$("#divStepDeparmentTransferenciaPML").removeClass('hidden');
	$("#divRecurrenciaPML").removeClass('hidden');
	$('#stepRecurrentesTransferenciaPML').addClass('hidden');
	$('#ibancoPML').attr("data-valid", "required");
	$('#inumacountPML').attr("data-valid", "account");
	$('#ideparmentPML').attr("data-valid", "required");
	$('#listaCuentaAhorrosPML').removeAttr("data-valid");
}

function activarPantallaRecurrenteTransferenciaPML(){
	pantallaListaRecurrente=true;
	$("#stepBancoTransferenciaPML").addClass('hidden');
	$("#stepCuentaTransferenciaPML").addClass('hidden');
	$("#divStepDeparmentTransferenciaPML").addClass('hidden');
	$("#divRecurrenciaPML").addClass('hidden');
	$('#stepRecurrentesTransferenciaPML').removeClass('hidden');
	$('#ibancoPML').removeAttr("data-valid");
	$('#inumacountPML').removeAttr("data-valid");
	$('#ideparmentPML').removeAttr("data-valid");
	$('#listaCuentaAhorrosPML').attr("data-valid", "radio-group");
}



function redirige(url, id){
	$.ajax({
        type: "POST",
        url: "updateNotification.html",
        dataType: "json",
        data: "idNotificacion="+id,
        async: false
	})
	.done(function(data) {
		location.href=url;
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
		location.href=url;
    });			
} 
 
function getNotifications(){
	$.ajax({
        type: "POST",
        url: "getNotifications.html",
        dataType: "json",
        async: false
	})
	.done(function(data) {
		var htmlNotificaciones = '';
		var contador = 0;
		if(data.status=="OK"){
			if(JSON.parse(data.listaNotificaciones).length>0){
				$("#pagination-items-hispayment").css("display","block");
				htmlNotificaciones += '<div style="text-align: left;">';
				$.each(JSON.parse(data.listaNotificaciones), function( key,value ) {
					contador++;
					if(contador%2==0){
						htmlNotificaciones+='<div class="item" style="margin-left: 10px; margin-right: 20px; width: 46.5%; text-align: justify; line-height: 1.5;">';
					}else{
						htmlNotificaciones+='<div class="item" style="margin-left: 20px; margin-right: 10px; width: 46.5%; text-align: justify; line-height: 1.5;">';
					}
					if(value.flag=="0"){
						htmlNotificaciones+='<div style="margin-top: 20px; margin-bottom: 5px; border: 1px solid #53c1a9; border-radius: 5px; box-shadow: 0 0 5px #53c1a9; padding: 10px 15px; width: 100%;">';
					}else{
						htmlNotificaciones+='<div style="margin-top: 20px; margin-bottom: 5px; border: 1px solid #53c1a9; border-radius: 5px; padding: 10px 15px; width: 100%;">';
					}
					htmlNotificaciones+='<div>';
					htmlNotificaciones+='<div style="float: left;">';
					if(value.type!=4){
						htmlNotificaciones+='<svg viewBox="0 0 18 18"  xmlns="http://www.w3.org/2000/svg" style="width: 13px; height: 13px;">';
						htmlNotificaciones+='<path d="M16.418 4.219h-2.146c.332-.441.529-.99.529-1.582A2.64 2.64 0 0 0 12.164 0c-.876 0-1.521.314-2.032.987-.428.564-.74 1.351-1.132 2.345-.392-.994-.704-1.78-1.132-2.345C7.358.314 6.712 0 5.836 0a2.64 2.64 0 0 0-2.637 2.637c0 .593.197 1.14.529 1.582H1.582C.71 4.219 0 4.929 0 5.8v1.054c0 .688.44 1.274 1.055 1.492v8.071c0 .872.71 1.582 1.582 1.582h12.726c.873 0 1.582-.71 1.582-1.582V8.347A1.585 1.585 0 0 0 18 6.855V5.801c0-.873-.71-1.582-1.582-1.582zm-6.45-.466c.808-2.05 1.115-2.698 2.196-2.698.872 0 1.582.71 1.582 1.582 0 .872-.71 1.582-1.582 1.582h-2.38l.184-.466zM5.836 1.055c1.081 0 1.388.648 2.196 2.698l.184.466h-2.38c-.872 0-1.582-.71-1.582-1.582 0-.873.71-1.582 1.582-1.582zm1.055 15.89H2.637a.528.528 0 0 1-.528-.527v-7.98h4.782v8.507zm0-9.562H1.582a.528.528 0 0 1-.527-.528V5.801c0-.291.236-.528.527-.528h5.309v2.11zm3.164 9.562h-2.11V5.273h2.11v11.672zm5.836-.527c0 .29-.237.527-.528.527H11.11V8.437h4.782v7.981zm1.054-9.563c0 .291-.236.528-.527.528h-5.309v-2.11h5.309c.29 0 .527.237.527.528v1.054z" fill="#e02120"/>';
						htmlNotificaciones+='</svg>';
					}else{
						htmlNotificaciones+='<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 23 23" fill="none" stroke="#e02120" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">';
						htmlNotificaciones+='<circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line>';
						htmlNotificaciones+='</svg>';
					}
					htmlNotificaciones+='</div>';
					if(value.type==1){ 
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<b>¡Felicidades tienes premios!</b><br>';
						htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta y, si aún tienes saldo disponible, recuerda que puedes seguir jugando o retirarlo cuando quieras.</span><br>';
						htmlNotificaciones+='<span style="font-size: 11px; color: black;">' + value.insertDate + '</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html#movimientos\',\''+value.id+'\')" style="cursor: pointer; color: #00d4f8; margin-left: 18px; text-decoration: underline;">Ir a Mis Movimientos ></a>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html?redirige=premios\',\''+value.id+'\')" style="cursor: pointer;position: relative; right: -180px;color: #00d4f8; text-decoration: underline;">Retirar Premios ></a>';			
					}else if(value.type==2){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<b>¡Felicidades tienes un premio mayor de '+value.game+'!</b><br>';
						htmlNotificaciones+='<span>Cóbralo antes de que venza el plazo de cobro. Hasta '+value.expirationDate+'</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html?redirige=premios\',\''+value.id+'\')" style="cursor: pointer;color: #00d4f8; text-decoration: underline; margin-left: 20px;">Cobrar premios ></a>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html#jugadas\',\''+value.id+'\')" style="cursor: pointer;position: relative; right: -216px; color: #00d4f8; text-decoration: underline;">Ir a mis jugadas ></a>';
					}else if(value.type==3){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='Tu retiro N° '+value.requestNumber+' ya está en tu cuenta '+value.requestType+'<br>';
						htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta '+value.requestType+' o tu historial de retiros</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html?redirige=historial\',\''+value.id+'\')" style="color: #00d4f8; text-decoration: underline; margin-left: 20px; cursor: pointer;">Ir a historial de retiros ></a>';
					}else if(value.type==4){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<b>Tu contraseña expira en 5 días</b><br>';
						htmlNotificaciones+='<span>Actualizalo ahora, ingresando a Mi Perfil.</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<a onclick="redirige(\'mi-cuenta.html#yo-cambiar-pwd\',\''+value.id+'\')" style="cursor: pointer;position: relative; left: 83%; color: #00d4f8; text-decoration: underline;">Ir a Mi Perfil ></a>';
					}
					htmlNotificaciones+='</div>';
					htmlNotificaciones+='</div>';
					htmlNotificaciones+='</div>'; 
				});
				
				
			}else{
				$("#pagination-items-hispayment").css("display","none");
				htmlNotificaciones+='<br><br><div style="text-align: center;"><h1>Aún no tienes notificaciones</h1></div><div style="text-align: center;"><img class="nofound__img" src="layer-view-image/client/no-retiros.svg?v=2"></div>';
			}
		}
//		$("#notificaciones").html(htmlNotificaciones);
		$("#items-hispayment").html(htmlNotificaciones);
				
		$('.items').closest('.record__content').each(function (index, elem) {
    	   pagerDelegate.init($(elem));
    	 });
		
		
		if(JSON.parse(data.listaNotificaciones).length>0 && JSON.parse(data.listaNotificaciones).length<9){
			$('.item').css("display","inline-flex");
		}
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
    	
    });
}

function closeLightboxRechargeIlot(){
	$('body').find('#loading-ilot').remove();
	$('body').css('overflow-y', 'scroll');
	$('body').find('#div-lightbox-recharge-ilot').remove();
	
	var ban = localStorage.getItem("ban");
	if(ban=="OK"){
		location.reload();
	}
	
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text(floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        	$("#clientSale-amount-2").text(floatFormat(data.billetera1));
        }
	});
}