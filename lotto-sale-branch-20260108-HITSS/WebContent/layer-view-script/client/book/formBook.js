// variable global para los archivos

var ImgBase64Array = ["","",""];

$(document).ready(function(){
	  		
	 $('#enviar').attr('disabled', true);
	 renderRegisterFormBook();
	 fileupImg.init();
});

/**************************************
 * fileupload image
 **************************************/
const fileupImg = (function () {
	'use strict';
	//const file = $('.ipremio .upimage'),
  	const file = $('#imgEvi'),
	onChangeMultiple = function () {
	  var imgs = this.files,
	    parent = $(this).closest('.fileup-image'),
	    filename = parent.find('.filename-multiple'),
	    filenames = parent.find('.filenames'),
	    img,
	    indice = 0, 
	    imgBase64 = "",
	    html = [],
	    reader=[],
	    imgCanvas =[];
	  if(imgs.length == 0){
		  filenames.addClass('empty');
		  ImgBase64Array = ["","",""];
		  return;
	  }  
	  for(var i = 0 ; i<imgs.length;i++){
		 if(i>=3) break; 
	  	var indice = 0;
		img = imgs[i]; 
		if(img!=undefined && img!=null){
		  if(img.type=="image/png" || img.type=="image/jpeg"){
			  if((img.size/1024/1024)<=10){  
			      if ($(this).val() !== '') { 
			        var sizeImgDNI = img.size;
			        html.push('<span class="filename" key="'+i+'">'+ img.name.match(/[^\/\\]+$/) +'<span class="delimg icon-error-min"></span></span>')	;
			        reader[i] = new FileReader();
				    reader[i].readAsDataURL(img); 
		        	
				    imgCanvas = new Image;
					imgCanvas.src = URL.createObjectURL(img);
					  
					imgCanvas.onload = function(){
						  imgBase64 = reader[indice].result;
						  ImgBase64Array.splice(indice,1,imgBase64);
						  indice++;
						  filename.html(html.join(''));
						  parent.removeClass('is-error');
						  filenames.removeClass('empty'); 
					    }
					    
				      imgCanvas.onerror = function() {
				      	file.val('');
					    filenames.addClass('empty');
					    ImgBase64Array = ["","",""];
					    jAlert("Debes adjuntar imágenes v&aacute;lidas");
				      }
					
			      }  
			  }else{
				  file.val('');
				  filenames.addClass('empty');
				  ImgBase64Array = ["","",""];
				  jAlert("Las imágenes deben ser menor a 10MB.");
			  }
		  }else{
			  file.val('');
			  filenames.addClass('empty');
			  ImgBase64Array = ["","",""];
			  jAlert("Solo se permiten imágenes con extensión JPG o PNG.");
		  }
		}

	  }
	},
	
	delImage = function () {
	  var del = $(this),
	    supercontent = del.closest('.fileup-image'),
	    content = del.closest('.filenames'),
	    key = del.parent().attr('key');
	  
	  del.parent().remove();      
	
	  ImgBase64Array.splice(key,1);
	  
	  if (content.find('.filename').length == 0) {
		  file.val('');
		  ImgBase64Array = ["","",""];
		  content.addClass('empty');
	  }
	},
	
	init = function () {
	  file.on('change', onChangeMultiple);
	  file.closest('.fileup-image').on('click', '.delimg', delImage);
	};

  return {
    init: init
  };
}());

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

/**************************************
 * fileupload image
 **************************************/

	
var renderRegisterFormBook = function () {
  // render fields
	var validateInputReg, validateInputReg3, validateInputReg4;
	 $form = $('#formBook');	
  	 renderTermsField();
		
  // restrict fields
//  $('#full_name').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
  $("#document-number, #phone,#amount").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
//  $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
//  $('#address').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©', allow : '#.,-'});
  
	validateInputReg = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();
	
	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
	  };
	  $('#full_name').on('input', validateInputReg);
	  
	validateInputReg3 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#email').on('input', validateInputReg3);	  
		
	validateInputReg4 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#address').on('input', validateInputReg4);		
     	  
  // validate fields
  $.validate({
    form: '#formBook',
  	modules: 'security, date, logic',	      	    
    scrollToTopOnError: false,		      	  			      	    
    onElementValidate : function(valid, $el, $form) {
      if ($form.isValid({}, {}, false)) {
        $('#enviar').attr('disabled', false);
      } else {
        $('#enviar').attr('disabled', true);
      }
    },
    onError: function ($form) {
      var $error = $form.find('.has-error');
      if ($error.length > 0) {
        $error = $error.first();
        $('html, body').animate({ scrollTop: $error.offset().top - 16 });
      }
    },
    onSuccess: function () {   	      
      return false;
    }
  });
};



var renderTermsField = function () {
   
	var  $form = $('#formBook'),
    onChangeTerms;
     	  
  	var $fullname = $('#full_name');
  	var $direccion = $('#address');
  	var $documento = $('#document-number');
  	var $telefono = $('#phone');
  	var $correo = $('#email');
  	var $descripcion = $('#description');
  	var $detalle = $('#detail');
  	var $monto = $('#amount');
  	var $solicitud = $('#request');
	  
  	onChangeTerms = function () {
	
	    if ($form.isValid({}, {}, false)) {
	      $('#enviar').attr('disabled', false);
	    } else {
	      $('#enviar').attr('disabled', true);
	    }
  };
  		      	     	  
  $fullname.on('keyup', onChangeTerms);
  $direccion.on('keyup', onChangeTerms);
  $documento.on('keyup', onChangeTerms);
  $telefono.on('keyup', onChangeTerms);
  $correo.on('keyup', onChangeTerms);
  $descripcion.on('keyup', onChangeTerms);
  $detalle.on('keyup', onChangeTerms);
  $monto.on('keyup', onChangeTerms);
  $solicitud.on('keyup', onChangeTerms);
  		      	  
};


$('#enviar').click(function(){

	var response = grecaptcha.getResponse();

	var datos = $("#formBook").serialize();
	for(var i=0;i<3;i++){
		datos = datos + ("&imgEvi"+(i+1)) +"="+ImgBase64Array[i];
	}
	
	if(response.length !=0){
				
	  $.ajax({
        url: 'registrarReclamacion.html',
        data: datos,
        type: 'POST',
        dataType: 'json',
        beforeSend: function () {
        	$('body').append('<div id="loader-frm-register"></div>');
        },
        error: function () {
      	  $('body').find('#loader-frm-register').remove();
      	  jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        },
        success: function (data) {
          $('body').find('#loader-frm-register').remove();
      	  if(data.message==="OK"){
      		  $("#secuencia").val(data.secuencia);
      		  $("#fecha").val(data.fecha);
      		  form.submit();
      	  }else{
        		if(data.message==='KOImg'){
          			$('#imgEvi').val('');
      			    $('#imgEvi').closest('.fileup-image').find('.filenames').addClass('empty');
      			    ImgBase64Array = ["","",""];
          		}
          		jAlert(data.error);
      	  }
        }
	  });

	}else{
		jAlert('Por seguridad, debes seleccionar el código captcha');
	}
});

