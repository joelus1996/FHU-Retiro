 var idsession = $("#clientId").val();
 
 $("#btn_desktop_ver_mis_jugadas").click(function(){
	 if(idsession == ''){
    	 jAlert("Para ver tus jugadas con los que participas en la promoción, debes ingresar a tu cuenta.","Aviso");
    }else{
    	 window.location.href = 'juega-copaentucasa-results.html';
    }
});
 
 $("#copacasa-retroceder").click(function(){	 
   // window.location.href = 'lacopaentucasa.html';   
});
 
 $("#btn_desktop_como_participar_copa").click(function(){	 
   window.location.href = 'juega-copaentucasa-information.html';   
});
 
//COPA CASA REGISTRO TICKET
 $(document).delegate('#btn_mobile_registra_ticket', 'click', function () {
     window.open('https://www.programateapuesto.pe/', '_blank');
 });
 
 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
 function ValidarCopacasa() {
	 if(idsession == ''){
    	 jAlert("Para ver tus jugadas con los que participas en la promoción, debes ingresar a tu cuenta.","Aviso");
    }else{
    	 window.location.href = 'juega-copaentucasa-results.html';
    }
   
 }