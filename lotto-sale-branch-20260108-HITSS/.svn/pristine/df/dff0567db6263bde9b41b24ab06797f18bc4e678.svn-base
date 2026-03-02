/**
 * 
 */
 $(document).ready(function(){
	 /* Cargar Suertudito */
	 cargarSuertudito();
 });
 
 function cargarSuertudito(){
	 /* Cargar Suertudito */
     $.ajax({
         type: "post",
         url: "checkChatbot.html",
         dataType: 'json',
         contentType: 'application/json',
         success: function (e) {
        	var chatbot_visible = e.visible; 
         	if(e.visible=='TRUE'){
         		var chatbot_urls = e.urls;
            	var array_chatboturls = chatbot_urls.split(';');
            	var aux_url = 0;  
            	
            	if(chatbot_urls=='*'){
            		aux_url = 1;
            	}else{
                	for (let i=0;i<array_chatboturls.length;i++){
                		if (location.href.split(array_chatboturls[i]).length > 1) {
                			aux_url = 1;
                			break;
                		}
                	}
            	}
         		if (aux_url == 1) {
	         		var script_chatbot = document.createElement("script");
	                script_chatbot.type = "text/javascript";
	                script_chatbot.src = e.src;
	                script_chatbot.id = "chatbotscript";
	                $("head").append(script_chatbot);
	                 
	                $("#aivochat-launcher").css({
	                    'cssText': 'z-index: 2147483646 !important'
	                });
         		}
         	}
         },
         error: function () {
        	 jAlert('Ocurri&oacute; un problema inesperado al cargar el chatbot');
         }
     });
 }