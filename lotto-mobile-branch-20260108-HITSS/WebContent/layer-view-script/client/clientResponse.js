
var dataClient;
var run = {
	toJSON: function (a) {
        return ((a === '') ? '' : $.parseJSON($.trim(a)));
    }
}

$(document).ready(function () {
	dataClient = run.toJSON( $("#DataClient").val() );
    $("#DataClient").remove();
    initPerfil();
    renderFormFields();
    renderUpdateDataForm();
    renderUpdatePasswordForm();
});


var renderFormFields = function () {
	  // pulldown
	  $(".form__select select").each(function () {
	    var $this = $(this),
	      $pull = $this.parent();

	    if ($pull.find("div").length === 0) {
	      $pull.prepend("<div></div>");
	    }

	    if ($this.val() === "") {
	      $pull.removeClass("selected");
	    } else {
	      $pull.children("div").text($this.children(":selected").text());
	      $pull.addClass("selected");
	    }

	    $this.on('change', function () {
	      $pull.children("div").text($this.children(":selected").text());
	      if ($this.val() === "") {
	        $pull.children("div").text('');
	        $pull.removeClass("selected");
	      } else {
	        $pull.children("div").text($this.children(":selected").text());
	        $pull.addClass("selected");
	      }
	    });
	  });

	  // input
	  $(".form__input input, .form__area textarea").each(function () {
	    var $input = $(this),
	      $parent = $input.parent();

	    if ($input.val() !== '') {
	      $parent.addClass('filled');
	    }

	    $input.on('focus', function () {
	      $parent.addClass('focus filled');
	    });

	    $input.on('blur', function () {
	      if ($input.val() === '' && !$parent.hasClass('form__input-calendar')) {
	        $parent.removeClass('focus filled');
	      } else {
	        $parent.removeClass('focus');
	      }
	    });
	  });

	  // checkbox
	  $('.form__check input').on("click", function () {
	    var $this = $(this);
	    if ($this.is(":checked")) {
	      $this.parent().addClass('checked');
	    } else {
	      $this.parent().removeClass('checked');
	    }
	  }).each(function () {
	    var $this = $(this);
	    if ($this.find('input').is(":checked")) {
	      $this.addClass("checked");
	    } else {
	      $this.removeClass("checked");
	    }
	  }).each(function () {
	    var $this = $(this);
	    if ($this.is(":checked")) {
	      $this.parent().addClass("checked");
	    } else {
	      $this.parent().removeClass("checked");
	    }
	  });

	  // options
	  var $thisOption,
	    $thisInput = $('#horario');

	  $('.form__opts-list-item').on('click', function () {
	    if ($thisOption) {
	      $thisOption.removeClass('checked');
	    }
	    $thisOption = $(this);
	    $thisOption.addClass('checked');
	    $thisInput.val($thisOption.find('.icon').attr('data-value'));
	  });
	};


var renderUpdateTermsField = function () {
	var $input = $('#confirm'),
	    $form = $('#frm-user-update'),
	    $name = $('#name'),
	    $appaterno = $('#ap-paterno'),
	    $documentnumber = $('#document-number'),
	    $documentopasap = $('#document-number-pasap'),
	    $documentocarex = $('#document-number-carex'),
	    $fechanac = $('#fechanac'),
	    $userclient = $('#user-client'),
	    $email = $('#email'),
	    $mobilephone = $('#mobile-phone'),
	    
	    $nacionalidad = $('#nacionalidad'),
	    $domicilio = $('#domicilio'),
	    $departamento = $('#departamento'),
	    $provincia = $('#provincia'),
	    $distrito = $('#distrito'),
	    $ppe = $('#ppe'),
	    
	    onChangeTerms;
	  
	  onChangeTerms = function () {
		
	    if ($form.isValid({}, {}, false)) {
	      $('#btnUpdatePerfil').attr('disabled', false);
	    } else {
	      $('#btnUpdatePerfil').attr('disabled', true);
	    }
	  };

	  $input.on('change', onChangeTerms);
	  
	  $name.on('keyup', onChangeTerms);
	  $appaterno.on('keyup', onChangeTerms);
	  $documentnumber.on('keyup', onChangeTerms);
	  $documentopasap.on('keyup', onChangeTerms);
	  $documentocarex.on('keyup', onChangeTerms);
	  $fechanac.on('keyup', onChangeTerms);
	  $userclient.on('keyup', onChangeTerms);
	  $email.on('keyup', onChangeTerms);
	  $mobilephone.on('keyup', onChangeTerms);
	  
	  $nacionalidad.on('change', onChangeTerms);
	  $domicilio.on('keyup', onChangeTerms);
	  $departamento.on('change', onChangeTerms);
	  $provincia.on('change', onChangeTerms);
	  $distrito.on('change', onChangeTerms);
	  $ppe.on('change', onChangeTerms);
	  
	  $fechanac.focus(function(){
		  if ( $(this).val()!=''){
			  $(this).blur();
		 }
	  });
	  
	  var $select = $('#document-type');
	  
	  $select.focus(function(){
		  if($documentnumber.val()!= '') $select.blur();
		  else if($documentopasap.val()!= '') $select.blur();
		  else if($documentocarex.val()!= '') $select.blur();   
	  });
	  
	  
};

var renderDocumentFields = function () {
	  var $select = $('#document-type'),
	    $fields = $('.form__optional'),
	    onChangeDocument;

	  onChangeDocument = function () {
	    var $input, isTipoDoc;

	    switch ($select.val()) {
	    case 'DNI':
	      $input = $('#document-number');
	      isTipoDoc = true;
	      break;
	    case 'PASAP':
	      $input = $('#document-number-pasap');
	      isTipoDoc = true;
	      break;
	    case 'CAREX':
	      $input = $('#document-number-carex');
	      isTipoDoc = true;
	      break;
	    case '':
	      $input = $('#document-number');
	      isTipoDoc = false;
	      break;
	    }
	    
	    $fields.hide(0);
	    if (isTipoDoc) {
	      $input.parent().show(0);
	      $input.val('').attr('disabled', false).focus();
	    } else {
	      $input.parent().show(0);
	      $input.val('').attr('disabled', true);
	    }
	  };

	  $select.on('change', onChangeDocument);
	};

var renderUpdateDataForm = function () {
	  // render fields
	var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4;
	renderDocumentFields();
	if(onCanlendar){
		renderUpdateDateField();
	}
	//renderPasswordField();
	renderUpdateTermsField();
	 
	// restrict fields
//	$('#name, #ap-paterno').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖÜâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//	$('#user-client, #document-number-pasap, #document-number-carex').alphanum({allowSpace: false, disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//	$('#email').alphanum({allowSpace: false, allow : '-_+@.'});
	$("#mobile-phone, #document-number").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
	$('#fechanac').alphanum({allow: '/', allowUpper: false, allowLower: false});
	
	$('#fechanac').mask('00/00/0000');
	
//	$('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖÜâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©', allow : '#.,-'});
	
	validateInputReg = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();
	
	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
	  };
	  $('#name, #ap-paterno').on('input', validateInputReg);
	  
	validateInputReg2 = function () {
	  // Obtiene el valor actual del campo
	    var inputValue = $(this).val();
	
	    // Elimina caracteres no permitidos
	    inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');
	    
	    // Actualiza el valor del campo
	    $(this).val(inputValue);
	};
	$('#user-client, #document-number-pasap, #document-number-carex').on('input', validateInputReg2);
 
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
	$('#domicilio').on('input', validateInputReg4);	
	
	// validate fields
	$.validate({
	  form: '#frm-user-update',
	  modules: 'security, date, logic',
	  scrollToTopOnError: false,
	  onElementValidate : function(valid, $el, $form) {
		if ($form.isValid({}, {}, false) ) {
		  $('#btnUpdatePerfil').attr('disabled', false);
		} else {
		  $('#btnUpdatePerfil').attr('disabled', true);
		}
	  },
	  onError: function ($form) {
	    var $error = $form.find('.has-error');
	    if ($error.length > 0) {
	      $error = $error.first();
	      $('html, body').animate({ scrollTop: $error.offset().top - 16 });
	    }
	  },
	  onSuccess: function ($form) {
		UpdateDataForm($form);
	    return false;
	  }
	});
};

var UpdateDataForm = function($form){
	document.removeEventListener("click", validateSession);
	document.removeEventListener("keypress", validateSession);
	$.ajax({
     url: $form.attr('action'),
     type: $form.attr('method'),
     data: $form.serialize(),
     dataType: $form.data('responseType'),
     beforeSend: function () {
     	$('body').append('<i id="cargando-1" class="loading" style="z-index: 2147483648 !important;"></i>');
     }
	}).done(function(response){
		
 	if(response.result == "OK"){
 		dataClient =  response.DataClient ;
     	initPerfil();
     	$("#isDataComplete").val("1");
     	$("#btnUpdatePerfil").prop("disabled",true);
     	$("#imgPopupPerfil").attr("src","layer-view-image/client/icon-ok.png");
 		$("#popupPerfilTitulo").html('Se actualiz&oacute correctamente los datos de tu perfil');
     	if(response.status == 200){
         	$("#popupPerfilButton").html('<button onclick="closePopupProfile()" class="my-button" type="button" style="width: 50%;">OK</button>');
     	}else if(response.status == 201){
     		$("#popupPerfilButton").html('<button onclick="cerrarSession(\'phone\')" class="my-button" type="button" style="width: 50%;">CERRAR SESI&OacuteN</button>');
     		$("#popupPerfilMensaje").html('Cierra tu sesi&oacuten, vuelve a iniciarla, y activa tu cuenta con el c&oacutedigo que te enviamos por SMS.');
     	} 
     	popup.openModal("#popupMiPerfil","");
     		
 	}else{
// 		alertMessage(response.message);
 		var titulo = response.title;
		var mensaje = response.message;
        var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
        '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
        $('#close-popup-message').hide();
        $('#msg-message').html(msgError);
    	openModal("#popup-message","");
    	document.addEventListener("click", validateSession);
		document.addEventListener("keypress", validateSession);
 	}
	}).fail(function(){
		var msg = 'Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.';
		alertMessage(msg);
		document.addEventListener("click", validateSession);
		document.addEventListener("keypress", validateSession);
	}).always(function() {
		$('body').find('#cargando-1').remove();
	});
    
}

var renderUpdatePasswordForm = function () {
	  // render fields
	renderPasswordUpdateField();

	//validate fields
	$.validate({
	form: '#frm-user-password',
	modules: 'security, date, logic',
	scrollToTopOnError: false,
	onModulesLoaded: function () {
	  var config = {
	    bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). No usar tus últimas 6 contraseñas.</span>',
	    weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). No usar tus últimas 6 contraseñas.</span>',
	    good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
	    strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
	  };
	
	  $('#new-password').displayPasswordStrength(config);
	  $('#confirm-password').displayPasswordStrength(config);
	},
	onElementValidate : function(valid, $el, $form) {
	  if ($form.isValid({}, {}, false)) {
	    $('#btnUpdatePassword').attr('disabled', false);
	  } else {
	    $('#btnUpdatePassword').attr('disabled', true);
	  }
	},																
	onError: function ($form) {
	  var $error = $form.find('.has-error');
	  if ($error.length > 0) {
	    $error = $error.first();
	    $('html, body').animate({ scrollTop: $error.offset().top - 16 });
	  }
	},
	onSuccess: function ($form) {
	  updatePassForm($form);
	  return false;
	}
	});
};	

var renderPasswordUpdateField = function(){
	var $toggle = $('.toglePasswordUpdate'),
	$input, $field,
 onTogglePasswordUp; 
	
	onTogglePasswordUp = function () {
		$input = $(this).prev();
		$field = $input.parent();

		$field.toggleClass('viewing'); 
		$input.attr("type",$field.hasClass('viewing') ? "text" : "password");
		
	};

	$toggle.on('click', onTogglePasswordUp ); 
}

var updatePassForm = function($form){
	
	$.ajax({
     url: $form.attr('action'),
     type: $form.attr('method'),
     data: $form.serialize(),
     dataType: $form.data('responseType'),
     beforeSend: function () {
     	$('body').append('<i id="cargando-1" class="loading" style="z-index: 2147483648 !important;"></i>');
     }
	}).done(function(response){
		
 	if(response.result == "OK"){
 		
			$("#imgPopupPerfil").attr("src","layer-view-image/client/icon-exito.png");
			$("#popupPerfilTitulo").html("&iexcl;Contrase&ntilde;a cambiada!");
			$("#popupPerfilMensaje").html("Vuelve a ingresar con tu usuario y nueva contrase&ntilde;a");
			$("#popupPerfilButton").html('<button onclick="cerrarSession(\'password\')" class="my-button" type="button" style="width: 50%;">OK</button>');
			popup.openModal("#popupMiPerfil","");
     		
 	}else{
 		alertMessage(response.message);
 	}
	}).fail(function(){
		var msg = 'Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.';
		alertMessage(msg);
	}).always(function() {
		$('body').find('#cargando-1').remove();
	});
	
	
} 

var cerrarSession = function (data){ 
	if(data == "phone"){
		$.ajax({
		    type: "POST",
		    url: "close-session.html",
		    dataType: "json",
		    async: false,
		    success: function(response){
		    	window.location.href = 'security-close-session.html';
		    }
		}); 
	}else{
		$.ajax({
		    type: "POST",
		    url: "close-session.html",
		    dataType: "json",
		    async: false,
		    success: function(response){
		    	window.location.href = 'security-close-session.html';
		    }
		}); 
	}
	 
popup.close();

}

var renderUpdateDateField = function () {
	  var $input = $('#fechanac');
	  var bdate = new Date();
	  var sdate = new Date();
	  bdate.setFullYear(bdate.getFullYear() - 18);
	  sdate.setFullYear(sdate.getFullYear() - 100);

	  $input.datepicker({
	    language: 'es-ES',
	    offset: 8,
	    startDate: sdate,
	    endDate: bdate,
	    autoHide: true,
	    //trigger: '#dateBirth'
	  });

	  $input.on('show.datepicker', function () {
	    //$input.trigger('focus');
	  });
	  $input.on('hide.datepicker', function () {
		  $input.trigger('blur');
	  });
	};
	
var onCanlendar=true;	
var initPerfil = function (){
	 
	var userClient = $('#user-client').val(dataClient.user);
// userClient.parents(".form__input").addClass( userClient.val()!='' ?  'disabledInput' : '');
 userClient.parents(".form__input").addClass('disabledInput');
 userClient.prop('readonly', userClient.val()!='');
 
 var email = $('#email').val(dataClient.email);
 email.parents(".form__input").addClass( (email.val()!='' && dataClient.mailUpdate!='Y') ?  'disabledInput' : '') ;
 email.prop('readonly', (email.val()!='' && dataClient.mailUpdate!='Y'));
 
 var name = $('#name').val(dataClient.fullName); 
 name.parents(".form__input").addClass( name.val()!='' ?  'disabledInput' : '') ;
 name.prop('readonly', name.val()!='');
 
 var lastName = $('#ap-paterno').val(dataClient.lastName); 
 lastName.parents(".form__input").addClass( lastName.val()!='' ?  'disabledInput' : '') ;
 lastName.prop('readonly', lastName.val()!='');
 
 renderDocumentPerfil();
 
 var fechaNac = $('#fechanac').val(dataClient.birthDate); 
 fechaNac.parents(".form__input").addClass(fechaNac.val()!='' ?  'disabledInput' : '') ;
 fechaNac.prop('readonly', true);
 $("#showCalendar").css('display',(fechaNac.val()!='') ? 'none' : 'block');
 if(fechaNac.val()!=''){
	 fechaNac.datepicker('destroy');
 } 
 onCanlendar=fechaNac.val()!='' ?  false : true;
 
 var mobilePhone = $('#mobile-phone').val(((dataClient.comPhones!=null)?dataClient.comPhones+" ":"")+((dataClient.mobilePhone!=null)?dataClient.mobilePhone:""));
 mobilePhone.parents(".form__input").addClass( (mobilePhone.val()!='' && dataClient.mobileUpdate!='Y') ?  'disabledInput' : '') ;
 mobilePhone.prop('readonly', (mobilePhone.val()!='' && dataClient.mobileUpdate!='Y'));
 
 if(dataClient.ppe === '1'){
	$('#nacionalidad').val(dataClient.nacionalidad);
 	var tnacionalidad = $('#tnacionalidad').val(dataClient.nnacionalidad);
 	tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'disabledInput' : '') ;
 	tnacionalidad.prop('readonly', tnacionalidad.val()!='');
 	tnacionalidad.parents(".form__input").prop('hidden', tnacionalidad.val()=='');
 	
 	 var domicilio = $('#domicilio').val(dataClient.domicilio); 
     domicilio.parents(".form__input").addClass( domicilio.val()!='' ?  'disabledInput' : '') ;
     domicilio.prop('readonly', domicilio.val()!='');
     
 	$('#departamento').val(dataClient.region);
 	var tdepartamento = $('#tdepartamento').val(dataClient.nregion);
 	tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'disabledInput' : '') ;
 	tdepartamento.prop('readonly', tdepartamento.val()!='');
 	tdepartamento.parents(".form__input").prop('hidden', tdepartamento.val()=='');
     
 	$('#provincia').val(dataClient.provincia);
     var tprovincia = $('#tprovincia').val(dataClient.nprovincia); 
     tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'disabledInput' : '') ;
     tprovincia.prop('readonly', tprovincia.val()!='');
     tprovincia.parents(".form__input").prop('hidden', tprovincia.val()=='');
     
     $('#distrito').val(dataClient.distrito);
     var tdistrito = $('#tdistrito').val(dataClient.ndistrito); 
     tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'disabledInput' : '') ;
     tdistrito.prop('readonly', tdistrito.val()!='');
     tdistrito.parents(".form__input").prop('hidden', tdistrito.val()=='');
 }
 if($('#ppe').length>0){
 	var ppe = $('#ppe').prop('checked', (dataClient.ppe === '1'));
 	ppe.parents(".form__check").addClass( dataClient.ppe === '1' ?  'disabledInput2' : '') ;
 	ppe.prop('readonly', dataClient.ppe === '1');
 	
 }
 
 $('#confirm').prop('checked', (dataClient.confirm == 'Y'));
 
	   
}

var renderDocumentPerfil = function () {
	 
	  var $select = $('#document-type'),
	    $fields = $('.form__optional'),
	    $input=$('#document-number'),
	    isTipoDoc = false;
	    //dataClient.typeId dataClient.numberId
	  	if(dataClient.typeId != null)
	  		$select.val(dataClient.typeId);
	  	else
	  		$select.val('');
	  	
	    switch ($select.val()) {
	    case 'DNI':
	      $input = $('#document-number');
	      isTipoDoc = true;
	      break;
	    case 'PASAP':
	      $input = $('#document-number-pasap');
	      isTipoDoc = true;
	      break;
	    case 'CAREX':
	      $input = $('#document-number-carex');
	      isTipoDoc = true;
	      break;
	    }
	    
	    $fields.hide(0);
	    
	    if (isTipoDoc) {
	      $input.parent().show(0);
	      $input.val(dataClient.numberId).attr('disabled', false);
	      $input.parents(".form__input").addClass( $input.val()!='' ?  'disabledInput' : '');
	      $input.prop("readonly",$input.val()!='');
	      $select.parents(".form__select").addClass( $select.val()!='' ?  'disabledInput' : '');
	      $select.prop("readonly",$select.val()!='');
	    } else {
	      $select.val('DNI');
	      $input.parent().show(0);
	      $input.val('').attr('disabled', false);
	    } 
	};
	
	function closePopupProfile(){
		if($('#departamento')[0].tagName === 'SELECT'){
			//nacionalidad			
			var valor=$("#nacionalidad").val();
			var texto=$("#nacionalidad option[value='"+valor+"']").text();
			$( "#div-nacionalidad" ).remove();
			$( "#div_nacionalidad2" ).append( '<input type="text" name="nacionalidad" id="nacionalidad" hidden="">' );
			$( "#div_nacionalidad2" ).append( '<div class="form__input">'+
		            '<label for="tnacionalidad">Nacionalidad</label>'+	
					  '<input type="text" name="tnacionalidad" id="tnacionalidad" tabindex="19" data-validation="required" data-validation-error-msg="Seleccionar tu pa&iacute;s">'+
		          '</div>' );		
			$('#nacionalidad').val(valor);
			$('#tnacionalidad').val(texto);
			var tnacionalidad = $('#tnacionalidad'); 
			tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'disabledInput' : '') ;
			tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'filled' : '') ;
			tnacionalidad.prop('readonly', tnacionalidad.val()!='');
			
			//departamento			
			var valor=$("#departamento").val();
			var texto=$("#departamento option[value='"+valor+"']").text();
			$( "#div-departamento" ).remove();
			$( "#contact-information" ).append( '<input type="text" name="departamento" id="departamento" hidden="">' );
			$( "#contact-information" ).append( '<div class="form__input">'+
		            '<label for="departamento">Departamento</label>'+	
					  '<input type="text" name="tdepartamento" id="tdepartamento" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">'+
		          '</div>' );	
			$('#departamento').val(valor);
			$('#tdepartamento').val(texto);
			var tdepartamento = $('#tdepartamento'); 
			tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'disabledInput' : '') ;
			tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'filled' : '') ;
			tdepartamento.prop('readonly', tdepartamento.val()!='');
			
			//provincia				
			valor=$("#provincia").val();
			texto=$("#provincia option[value='"+valor+"']").text();
			$( "#div-provincia" ).remove();
			$( "#contact-information" ).append( '<input type="text" name="provincia" id="provincia" hidden="">' );
			$( "#contact-information" ).append( '<div class="form__input">'+
		            '<label for="provincia">Provincia</label>'+	
					  '<input type="text" name="tprovincia" id="tprovincia" tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">'+
		          '</div>' );
			$('#provincia').val(valor);
			$('#tprovincia').val(texto);
			var tprovincia = $('#tprovincia'); 
			tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'disabledInput' : '') ;
			tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'filled' : '') ;
			tprovincia.prop('readonly', tprovincia.val()!='');
			
			//distrito				
			valor=$("#distrito").val();
			texto=$("#distrito option[value='"+valor+"']").text();
			$( "#div-distrito" ).remove();
			$( "#contact-information" ).append( '<input type="text" name="distrito" id="distrito" hidden="">' );
			$( "#contact-information" ).append( '<div class="form__input">'+
		            '<label for="distrito">Distrito</label> '+	
					  '<input type="text" name="tdistrito" id="tdistrito" tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">'+
		          '</div>' );
			$('#distrito').val(valor);
			$('#tdistrito').val(texto);
			var tdistrito = $('#tdistrito'); 
			tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'disabledInput' : '') ;
			tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'filled' : '') ;
			tdistrito.prop('readonly', tdistrito.val()!='');
		}
		$('#clientMobile-name').text('Hola '+$('#name').val());
		popup.close();
	}