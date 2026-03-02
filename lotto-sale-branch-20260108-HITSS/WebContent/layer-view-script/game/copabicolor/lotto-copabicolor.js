 var idsession = $("#clientId").val();
 
 $(".btnEnlaceGanagol").click(function(){
	 window.location.href = 'juega-ganagol.html';
 });
 
 $("#btn_desktop_ver_mis_jugadas").click(function(){
	 if(idsession == ''){
    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
    }else{
    	 window.location.href = 'premiazoganagol_resultados.html';
    }
});
 
 $("#copacasa-retroceder").click(function(){	 
    window.location.href = 'premiazoganagol.html';   
});
 
 $("#btn_desktop_como_participar_copa").click(function(){	 
   window.location.href = 'como-participar-premiazoganagol.html';   
});
 
 $("#btn_desktop_promo_bicolor").click(function(){
	 if(idsession == ''){
    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
    }else{
    	 window.location.href = 'registrarpromopremiazoganagol.html'; // 
    }
	 
	});
 
//COPA CASA REGISTRO TICKET
 $(document).delegate('#btn_desktop_registra_ticket', 'click', function () {
     window.open('https://www.programateapuesto.pe/', '_blank');
 });
 
 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
 function ValidarCopacasa() {
	 if(idsession == ''){
    	 jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
    }else{
    	 window.location.href = 'premiazoganagol_resultados.html';
    }
   
 }