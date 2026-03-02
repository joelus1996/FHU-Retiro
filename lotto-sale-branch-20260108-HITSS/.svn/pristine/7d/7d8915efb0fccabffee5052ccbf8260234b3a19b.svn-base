var contrastMode = true;
var target = null;
var captcha = false;
function setTarget(targ) {
	target = targ;
}
function getTarget() {
	return $(target);//document.forms[0].elements[target];
}
function setCaptcha(capt) {
	captcha = capt;
}
function getCaptcha() {
	return captcha;
}
function addChar(A) {
	getTarget().val(getTarget().val() + A);
	move();
}
function move(){
	//document.getElementById("vkeyboard").style.top = getTarget().offset().top-getRandom(-70,-30) + "px";
	//document.getElementById("vkeyboard").style.left = getTarget().offset().left-getRandom(160,200) + "px";
	$("#vkeyboard").css({
		top:getRandom(-70,-30)+"px",
		left:getRandom(160,200)+"px"
	});
}
function getRandom(A,B){
	return Math.round(Math.random()*(A-B)+B);
}
function delChar() {
	getTarget().val(getTarget().val().substring(0, getTarget().val().length - 1));
	//document.getElementById(target).value = document.getElementById(target).value.substring(0, document.getElementById(target).value.length - 1);
}
function delAll() {
	getTarget().val("");
	//document.getElementById(target).value = "";
}
function swapContrast() {
	contrastMode = !contrastMode;
	/*for (var i=0; i<44; i++){
		if (contrastMode) {
			document.getElementById("b"+i).style.opacity = "1.0";
			document.getElementById("b"+i).style.filter = "alpha(opacity=100)";
		} else {
			document.getElementById("b"+i).style.opacity = ".25";
			document.getElementById("b"+i).style.filter = "alpha(opacity=25)";
		}
	}*/
	if(contrastMode) {
		//document.getElementById("vkeyboard").style.opacity = "1.0";
		//document.getElementById("vkeyboard").style.opacity = "alpha(opacity=100)";
		$("#vkeyboard").css({filter:"alpha(opacity=100)", opacity:"1.0"})
	} else {
		//document.getElementById("vkeyboard").style.opacity = ".25";
		//document.getElementById("vkeyboard").style.opacity = "alpha(opacity=25)";
		$("#vkeyboard").css({filter:"alpha(opacity=25)", opacity:".25"})
	}
}
function appendKeyNumber(){
	var k = "";
	var str = "";
	while(str.length<10){
		var i = Math.floor(Math.random()*10);
		if(str.indexOf(i)==-1){
			str += i;
			k += "<a href='#' id='b" + i + "' class='ssbuttons' onclick='addChar(\"" + i + "\");return false;'>"+i+"</a>";
		}
	}
	$("#vkeynumber").html(k);
	if(getCaptcha()) appendCaptcha();
}

function appendKeyboard(){
	//if($("#keyboard").length) $("#keyboard").remove();
	var k = "<div id='keyboard' class=''><div class='kbtop'><div class='kbpanel'><span class='kbtitle'>Para tu seguridad:</span>" +
			"<span><b>Ingresa tu contrase&ntilde;a</b> usando<br/>el teclado virtual de la derecha.</span><div id='vkeyboard'><div id='vkeynumber'></div>";
	
	k += "<a href='#' id='b10' class='ssbuttons' style='width:37px;font-size:10px;' title='Limpiar todo' onclick='delAll();return false;'>Limpiar</a>" +

	"<a href='#' id='b11' class='ssbuttons' onclick='addChar(\"Q\");return false;'>Q</a>" +
	"<a href='#' id='b12' class='ssbuttons' onclick='addChar(\"W\");return false;'>W</a>" +
	"<a href='#' id='b13' class='ssbuttons' onclick='addChar(\"E\");return false;'>E</a>" +
	"<a href='#' id='b14' class='ssbuttons' onclick='addChar(\"R\");return false;'>R</a>" +
	"<a href='#' id='b15' class='ssbuttons' onclick='addChar(\"T\");return false;'>T</a>" +
	"<a href='#' id='b16' class='ssbuttons' onclick='addChar(\"Y\");return false;'>Y</a>" +
	"<a href='#' id='b17' class='ssbuttons' onclick='addChar(\"U\");return false;'>U</a>" +
	"<a href='#' id='b18' class='ssbuttons' onclick='addChar(\"I\");return false;'>I</a>" +
	"<a href='#' id='b19' class='ssbuttons' onclick='addChar(\"O\");return false;'>O</a>" +
	"<a href='#' id='b20' class='ssbuttons' onclick='addChar(\"P\");return false;'>P</a>" +
	"<a href='#' id='b21' class='ssbuttons' style='width:37px;font-size:20px;line-height:10px;' title='Borrar' onclick='delChar();return false;'>&lArr;</a>" +
	
	"<a href='#' id='b22' class='ssbuttons' onclick='addChar(\"A\");return false;'>A</a>" +
	"<a href='#' id='b23' class='ssbuttons' onclick='addChar(\"S\");return false;'>S</a>" +
	"<a href='#' id='b24' class='ssbuttons' onclick='addChar(\"D\");return false;'>D</a>" +
	"<a href='#' id='b25' class='ssbuttons' onclick='addChar(\"F\");return false;'>F</a>" +
	"<a href='#' id='b26' class='ssbuttons' onclick='addChar(\"G\");return false;'>G</a>" +
	"<a href='#' id='b27' class='ssbuttons' onclick='addChar(\"H\");return false;'>H</a>" +
	"<a href='#' id='b28' class='ssbuttons' onclick='addChar(\"J\");return false;'>J</a>" +
	"<a href='#' id='b29' class='ssbuttons' onclick='addChar(\"K\");return false;'>K</a>" +
	"<a href='#' id='b30' class='ssbuttons' onclick='addChar(\"L\");return false;'>L</a>" +
	"<a href='#' id='b31' class='ssbuttons' onclick='addChar(\"Ñ\");return false;'>Ñ</a>" +
	"<a href='#' id='b32' class='ssbuttons' style='width:37px;font-size:20px;line-height:10px;' title='Ingresar' onclick='keyEnter();return false;'>&crarr;</a>" +
	
	"<a href='#' id='b33' class='ssbuttons' onclick='addChar(\"Z\");return false;'>Z</a>" +
	"<a href='#' id='b34' class='ssbuttons' onclick='addChar(\"X\");return false;'>X</a>" +
	"<a href='#' id='b35' class='ssbuttons' onclick='addChar(\"C\");return false;'>C</a>" +
	"<a href='#' id='b36' class='ssbuttons' onclick='addChar(\"V\");return false;'>V</a>" +
	"<a href='#' id='b37' class='ssbuttons' onclick='addChar(\"B\");return false;'>B</a>" +
	"<a href='#' id='b38' class='ssbuttons' onclick='addChar(\"N\");return false;'>N</a>" +
	"<a href='#' id='b39' class='ssbuttons' onclick='addChar(\"M\");return false;'>M</a>" +
	"<a href='#' id='b40' class='ssbuttons' onclick='addChar(\"@\");return false;'>@</a>" +
	"<a href='#' id='b41' class='ssbuttons' onclick='addChar(\"$\");return false;'>$</a>" +
	"<a href='#' id='b42' class='ssbuttons' onclick='addChar(\"Ç\");return false;'>Ç</a>" +
	"<a href='#' id='b43' class='ssbuttons' style='width:37px;font-size:20px;line-height:10px;' title='Contraste' onclick='swapContrast();return false;'>&curren;</a>";
	//$("#vkeyboard").html(k);
	k += "</div></div><div id='vkcaptcha'></div></div><div class='kbbottom'><a href='#' onclick='keyEnter();return false;' class='lnk-enter'></a></div></div>";
	getTarget().after(k);
	//contrastMode = true;
	appendKeyNumber();
	$("#keyboard").css({
		top:(getTarget().attr("id")=="password-client-header")?"24px":(getTarget().attr("id")=="password-client")?"60px":"0",
		left:(getTarget().attr("id")=="password-client-header")?"-100px":(getTarget().attr("id")=="password-client")?"20px":"0"
	});
	move();
}
function removeKeyboard(){
	if($("#keyboard").length) $("#keyboard").remove();
	setTarget(null);
	contrastMode = true;
}
function appendCaptcha(){
    $("#vkcaptcha").html("<div class='kbfield'><span><b>Ingresa el texto de la imagen de la derecha.</b><br/>Si prefieres, otra imagen <a href='#' id='relKaptcha' onclick='reloadKaptcha();return false;'>haz clic aqu&iacute;</a>.</span>" +
    		"<input type='text' id='captcha-code' name='captcha-client' autocomplete='off'/></div><div class='kfield'><img src='Kaptcha.jpg' id='imgkaptcha' /></div>");
    reloadKaptcha();
}