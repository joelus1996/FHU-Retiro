$(document).ready(function(){
	//obtener lista de paises
	if($('#nacionalidad')[0].tagName === 'SELECT'){
	$.ajax({
		type: "GET",
		url: "getPaises.html",
		dataType: "json",
	        async: false,
        success: function (data) {

	        	$.each(data,function(i,obj){
	        		if(obj.countryId==='PE'){
	        			var $pull = $('#nacionalidad').parent();
	        			if ($pull.find("div").length === 0) {
        			      $pull.prepend("<div></div>");
        			    }
	        			$('#nacionalidad').append('<option value='+obj.countryId+' selected>'+obj.countryName+'</option>');
	        			$('#nacionalidad').siblings('div').html(obj.countryName);
	        	        $pull.addClass("selected");
	        	        $pull.addClass("has-success");
	        		}else{
	        			$('#nacionalidad').append('<option value='+obj.countryId+'>'+obj.countryName+'</option>');
	        		}
	        	 });					
	        }    
  	        
		});
	}
	
	
	if($('#departamento')[0].tagName === 'SELECT'){		
		$.ajax({
		        type: "POST",
		        url: "getDepartamentos.html",
		        dataType: "json",
		        async: false,
		        success: function (data) {
	        		$('#departamento').append('<option value=""></option>');
		        	$.each(data,function(i,obj){
	        		$('#departamento').append('<option value='+obj.departmentId+'>'+obj.departmentName+'</option>');			     	
		        	 });					
		        }    		  	        
			});	
	}
	renderFormFields4();
});

$('#departamento').change(function(){
	var $this = $(this)
	depart = $this.children(":selected").text()
	dep = $('#departamento').val();
	
	console.log(dep);
	
	$('#provincia').parent().removeClass('selected');
	$('#provincia').siblings('div').html('');
	$('#provincia').empty().append('<option value="" ></option> ');

	$('#distrito').parent().removeClass('selected');
	$('#distrito').siblings('div').html('');
	$('#distrito').empty().append('<option value="" ></option> ');


	$.ajax({
		type: "GET",
		url: "getProvincias.html?departamento=" + dep,
		dataType: "json",
	        async: false,
        success: function (data) {

	        	$.each(data,function(i,obj){
	        		$('#provincia').append('<option value='+obj.provinceId+'>'+obj.provinceName+'</option>');
	     	
	        	 });					
	        }    
  	        
		});  
							
});

$('#provincia').change(function(){
	var $this = $(this)
	provi = $this.children(":selected").text()
	var prov = $('#provincia').val();
	console.log(prov);
	
	$('#distrito').parent().removeClass('selected');
	$('#distrito').siblings('div').html('');
	$('#distrito').empty().append('<option value="" ></option> ');
				

	$.ajax({
		type: "GET",
		url: "getDistritos.html?provincia=" + prov +"&&departamento=" + dep,
		dataType: "json",
	        async: false,
        success: function (data) {

	        	$.each(data,function(i,obj){
	        		$('#distrito').append('<option value='+obj.districId+'>'+obj.districtName+'</option>');
	     	
	        	 });					
	        }    
  	        
		});  
							
});

$('#distrito').change(function(){
	var $this = $(this)
	distri = $this.children(":selected").text()

});

var renderFormFields4 = function () {
	  // pulldown
	  $(".form__select4 select").each(function () {
	    var $this = $(this),
	      $pull = $this.parent();

	    if ($pull.find("div").length === 0) {
	      $pull.prepend("<div></div>");
	    }

	    if ($this.val() === "" || $this.val() === null) {
	      $pull.removeClass("selected");
	    }

	    $this.on('change', function () {
	      $pull.children("div").text($this.children(":selected").text());
	      if ($this.val() === "") {
	        $pull.children("div").text('');
	        $pull.removeClass("selected");
	      } else {
	        $pull.children("div").text($this.children(":selected").text());
	        $pull.removeClass("has-error");
	        $pull.addClass("selected");
	        $pull.addClass("has-success");
	        var s=$pull.children("span");
	        s.remove();	        
	      }
	    });
	  });

};

