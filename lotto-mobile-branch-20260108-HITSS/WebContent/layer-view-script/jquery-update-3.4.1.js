$(document).ready(function() {
	var version = $.fn.jquery;
	
	if(version!='3.4.1'){
		var url = window.location.href;
		var jquery_status =  url.indexOf("jquery-status");
		
		if(jquery_status<0){
			var head= document.getElementsByTagName('head')[0];
		    var script= document.createElement('script');
		    script.src= 'layer-view-script/common/jquery.js';
		    head.appendChild(script);
			$(location).attr('href',url+'?jquery-status=OK');
		}
	}
});