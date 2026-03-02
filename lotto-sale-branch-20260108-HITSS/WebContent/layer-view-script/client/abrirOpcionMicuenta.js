

$(document).ready(function(){

	$("#misPremios").click(function() {	
		$('#tab-item_2').click(function(){ 
			 $("#content-tab-item_2").css("display", "block");
	     });	
		$('#tab-item_2').click();		  
		});	
		
	$("#misJugadas").click(function() {		
		$('#tab-item_3').click(function(){ 
			 $("#content-tab-item_3").css("display", "block");
	     });	
		$('#tab-item_3').click();		  
		});	

	$("#misMovimientos").click(function() {	
		$('#tab-item_5').click(function(){
			 $("#content-tab-item_5").css("display", "block");
	     });	
		$('#tab-item_5').click();	  
		});
	
	
	$("#misDatos").click(function() {	
		$('#tab-item_1').click(function(){
			 $("#content-tab-item_1").css("display", "block");
	     });	
		$('#tab-item_1').click();	  
		});
	
	$("#misMovimientosBono").click(function() {	
		$('#tab-item_6').click(function(){
			 $("#content-tab-item_6").css("display", "block");
	     });	
		$('#tab-item_6').click();	  
		});
	
	$("#misMovimientosOtro").click(function() {	
		$('#tab-item_7').click(function(){
			 $("#content-tab-item_7").css("display", "block");
	     });	
		$('#tab-item_7').click();	  
		});

});