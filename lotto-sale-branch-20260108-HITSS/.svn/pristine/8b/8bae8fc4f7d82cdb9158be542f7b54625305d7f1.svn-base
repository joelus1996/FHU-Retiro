var gCount = 0;

$(document).ready(function () {
//	setCaptcha();
//	
//	$("#reloadJuego").click(function() {
//		setCaptchaJuego();
//    });
//	
//	$("#reload").click(function() {
//		setCaptcha();
//    });
	
});

function setCaptcha(){
	try {
		if(!($('#index-btnlogin').is('[disabled]'))){
			$("#imagen").attr("src","captcha.html?accion=" + gCount);
			gCount = gCount + 1;
		}
	} catch (e) {
		console.log(e.message);
	}
}

function setCaptchaJuego(){
	try {
		$("#imagenJuego").attr("src","captcha.html?accion=" + gCount);
		gCount = gCount + 1;
	} catch (e) {
		console.log(e.message);
	}
}
