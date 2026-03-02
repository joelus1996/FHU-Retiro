//Ejecutar función setBtagCookie al cargar página
$(document).ready(function() {
	try{
		setBtagCookie();
	}catch(err){
		console.log(err);
	}
});

// funcion para obtener parametro btag y crear cookie
function setBtagCookie(){
	var operationId=$("#operatorIdApi").val();
	if (operationId==5588){
		btag=getQueryParam('btag');
		if (!document.cookie.includes('btag') && btag!='') {					
		    document.cookie = "btag="+btag + "; path=/; max-age=2592000";
		}								
	}
}

// funcion para obtner parametro de url
function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param) || '';
}

//funcion para elimiar cookie btag despues del registro
function deleteBtagCookie(){
	if (document.cookie.includes('btag')) {					
	    document.cookie = "btag=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	}
}