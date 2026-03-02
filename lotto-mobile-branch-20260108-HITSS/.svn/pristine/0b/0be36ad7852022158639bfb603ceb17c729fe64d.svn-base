/**<p> NAME:    utils.js         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY					DATE        COMMENT
 * 001   oscar.candela		04/02/2008  First comment
 * 001   cristian.cortez	16/07/2008  New
 * </pre>
 * </p>
 */

/*********************************************************
* trim y leftPad
*************************************************/
String.prototype.trim = function(){return this.replace(/^\s+|\s+$/g,'');}
String.prototype.leftPad = function(l,c){return new Array(l - this.length + 1).join(c || '0') + this;}
/********************************************************************
* Valida el ingreso de caracteres a un control de texto
*********************************************************************/
var DBL_PATTERN=/^[a-i\d`n�]*$/;
var INT_PATTERN=/^[a-i\d`]*$/;
var DATE_PATTERN=/^\d{0,2}\/?\d{0,2}\/?\d{0,4}$/;
var ALFA_PATTERN=/^[\s\w\.\,\/\-`��]*$/;
var LETTER_PATTERN=/^[a-zA-Z\s�������'���]*$/;
var MAIL_PATTERN= /^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@+([_a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]{2,200}\.[a-zA-Z]{2,6}$/;
var URL_PATTERN= /^http::\/\/(www\.)?(\w)+\.(\w){2,}\/\.*$/;

var ctrl = false;
function validKey(e,format,cp,target) {
	var ret = false;
	var obj = document.forms[0].elements;
	var index = 0;
	var e = window.event || e;
	var key = (document.all) ? e.keyCode : e.which;
	var k = String.fromCharCode(key);
	//if(key != 16 && key != 17) alert("key="+key+" k="+k+" test="+format.test(k));
	if(key == 8 || key == 37 || key == 39) {
		ctrl = false;
		ret = true;
	} else if(key == 9) {
		if(target != null) {
			for(var i=0; i<obj.length; i++) {
				if(obj[i] == target) {
					index = i;
					break;
				}
			}
			for(var j=index+1; j<obj.length; j++) {
				if(obj[j].type == "text" || obj[j].type == "password" || obj[j].type == "radio" || obj[j].type == "select-one" || obj[j].type == "checkbox") {
					index = j;
					break;
				}
			}
			obj[index].focus();
			if(!obj[j].type == "select-one") obj[index].select();
			ctrl = false;
			ret = false;
		} else return true;
	} else if(key == 17) {
		ctrl = true;
		ret = true;
	} else if(key == 86) {
		if(cp == false && ctrl == true) {
			ctrl = true;
			ret = false;
		} else if(cp == true && ctrl == true) {
			ctrl = false;
			ret = true;
		} else {
			ctrl = false;
			ret = true;
		}
	} else {
		ctrl = false;
		if(format == 'none') ret = true;
		else ret = format.test(k);
	}
	return ret;
}
function validEmail(strValue) {
	return MAIL_PATTERN.test(strValue.trim());
}
function validNumber(numValue) {
	return INT_PATTERN.test(numValue.trim());
}
function noSpaces(val) {
	return val.replace(/ /g, "");
}
String.prototype.removeAccents = function (){
	var __r = {
			'�':'A','�':'A','�':'A','�':'A','�':'A','�':'A','�':'E',
			'�':'E','�':'E','�':'E','�':'E',
			'�':'I','�':'I','�':'I','�':'I',
			'�':'O','�':'O','�':'O','�':'O',
			'�':'U','�':'U','�':'U','�':'U',
			'�':'N'};
	return this.replace(/[������������������������]/gi, function(m){
		var ret = __r[m.toUpperCase()];
		if (m === m.toLowerCase())
			ret = ret.toLowerCase();
		return ret;
	});
};
/********************************************************************
*Valida el texto de un control de texto como dato fecha
*********************************************************************/
function isDate(text){
	var arDate=text.split("/");	
	var blnRet;
	if(arDate.length==3){
		var aDate = new Date(arDate[2],arDate[1]-1,arDate[0]);
		blnRet = (aDate.getFullYear()==arDate[2]&&aDate.getMonth()==arDate[1]-1&&aDate.getDate()==arDate[0]);
	}
	return (arDate.length==3 && blnRet);
}
/**********************************************
** crea una ventana popup
*************************************************/
function openWin(url,w,h,targetFrame){
	var l=(screen.availWidth-w)/2;
	var t=0;
	var win = window.open(url,targetFrame,"width="+w+",height="+h+",left="+l+",top="+t+",fullscreen=no,status=no,toolbar=no,directories=no,location=no,menubar=no,resizable=no,titlebar=no,scrollbars=yes,channelmode=no",true);
	win.focus();
	return win;
}
function openWinp(url,w,h,targetFrame){
	var l=(screen.availWidth-w)/2;
	var t=0;
	var win = window.open(url,targetFrame,"width="+w+",height="+h+",left="+l+",top="+t+",resizable=no,scrollbars=no,toolbar=no,location=no,directories=no,status=no,menubar=no,fullscreen=no,titlebar=no,channelmode=no,copyhistory=no,visible=none",true);
	win.focus();
	return win;
}
function openWindow(url,targetFrame){
	var w=(screen.availWidth-10).toString();
	var h=(screen.availHeight-95).toString();
	var win = window.open(url,targetFrame,"width="+w+",height="+h+",fullscreen=no,status=no,toolbar=no,directories=no,location=no,menubar=no,resizable=no,titlebar=no,scrollbars=yes,channelmode=no",true);
	win.focus();
	return win;	
}
function openWindowWithScrolls(url,name,w,h,title){
	var ajaxwin=top.dhtmlwindow.open(name, "ajax", url, title, "width="+w+",height="+h+",scrolling=1,center=1,resize=1");
}
function openWindowWithScrollsIf(url,name,w,h,title){
	var ajaxwin=top.dhtmlwindow.open(name, "iframe", url, title, "width="+w+",height="+h+",scrolling=1,center=1,resize=1");
}
function loadPage(urlDoc){	
	document.open(urlDoc,"ibody","",true);
}
/**********************************************
** Valida formularios
*************************************************/
function _findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function validateForm() { //v4.0
	var i,p,q,nm,test,num,min,max,errors='',args=validateForm.arguments;
	for(i=0; i<(args.length-2); i+=3) {
		test=args[i+2]; val=_findObj(args[i]);
		if(val) {
			nm=args[i+1]!=''?args[i+1]:val.name; //etiqueta
			if((val=val.value.trim())!="") {
				if(test.indexOf('isDate')!=-1) {
					if(!isDate(val)) errors+='-'+nm+' debe contener una fecha v?lida con formato (dd/mm/yyyy).\n';
				} else if(test.indexOf('isEmail')!=-1) {
					p=val.indexOf('@');
					if(p<1 || p==(val.length-1)) errors+='- '+nm+' debe contener una direcci?n de correo.\n';
				} else if(test.indexOf('inLength') != -1) { 
					len=test.substring(9);
					if (len!=val.length) errors+='- '+nm+' debe tener '+len+' caracteres.\n';
				} else if (test!='R') {
					num = parseFloat(val);
					if (isNaN(val)) errors+='- '+nm+' debe contener un n?mero.\n';
					if (test.indexOf('inRange') != -1) { 
						p=test.indexOf(':');
						min=test.substring(8,p); max=test.substring(p+1);
						if (num<min || max<num) errors+='- '+nm+' debe contener un n?mero entre '+min+' y '+max+'.\n';
					}
				}
			} else if (test.charAt(0) == 'R') errors += '- '+nm+' es obligatorio.\n';
		}
	}
	if (errors) jalert('Han ocurrido los siguientes errores:\n'+errors,null);
	return (errors == '');
}
/**********************************************
** Funci�n para dar formato a una fecha
**********************************************/
Date.prototype.format = function(format){
	var returnStr='';
	var replace=Date.replaceChars;
	for(var i=0;i<format.length;i++){
		var curChar=format.charAt(i);
		if(replace[curChar]){
			returnStr+=replace[curChar].call(this);
		} else {
			returnStr+=curChar;
		}
	}
	return returnStr;
};
Date.replaceChars = {
	shortMonths:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	longMonths:['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
	shortDays:['Dom','Lun','Mar','Mi&eacute;','Jue','Vie','S&aacute;b'],
	longDays:['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
	d:function(){return(this.getDate()<10?'0':'')+this.getDate();},
	D:function(){return Date.replaceChars.shortDays[this.getDay()];},
	j:function(){return this.getDate();},
	l:function(){return Date.replaceChars.longDays[this.getDay()];},
	N:function(){return this.getDay()+1;},
	S:function(){return(this.getDate()%10==1&&this.getDate()!=11?'st':(this.getDate()%10==2&&this.getDate()!=12?'nd':(this.getDate()%10==3&&this.getDate()!=13?'rd':'th')));},
	w:function(){return this.getDay();},
	z:function(){return"Not Yet Supported";},
	W:function(){return"Not Yet Supported";},
	F:function(){return Date.replaceChars.longMonths[this.getMonth()];},
	m:function(){return(this.getMonth()<9?'0':'')+(this.getMonth()+1);},
	M:function(){return Date.replaceChars.shortMonths[this.getMonth()];},
	n:function(){return this.getMonth()+1;},
	t:function(){return"Not Yet Supported";},
	L:function(){return"Not Yet Supported";},
	o:function(){return"Not Supported";},
	Y:function(){return this.getFullYear();},
	y:function(){return(''+this.getFullYear()).substr(2);},
	a:function(){return this.getHours()<12?'a.m.':'p.m.';},
	A:function(){return this.getHours()<12?'AM':'PM';},
	B:function(){return"Not Yet Supported";},
	g:function(){return this.getHours()%12||12;},
	G:function(){return this.getHours();},
	h:function(){return((this.getHours()%12||12)<10?'0':'')+(this.getHours()%12||12);},
	H:function(){return(this.getHours()<10?'0':'')+this.getHours();},
	i:function(){return(this.getMinutes()<10?'0':'')+this.getMinutes();},
	s:function(){return(this.getSeconds()<10?'0':'')+this.getSeconds();},
	e:function(){return"de";},
	I:function(){return"Not Supported";},
	O:function(){return(-this.getTimezoneOffset()<0?'-':'+')+(Math.abs(this.getTimezoneOffset()/60)<10?'0':'')+(Math.abs(this.getTimezoneOffset()/60))+'00';},
	T:function(){var m=this.getMonth();this.setMonth(0);var result=this.toTimeString().replace(/^.+ \(?([^\)]+)\)?$/,'$1');this.setMonth(m);return result;},
	Z:function(){return-this.getTimezoneOffset()*60;},
	c:function(){return"Not Yet Supported";},
	r:function(){return this.toString();},
	U:function(){return this.getTime()/1000;}
};
/**********************************************
** Valida una fecha
**********************************************/
function validateDate(strDate){
	var isdate = true;
	var date= new String(strDate);
	var realDate= new Date();
	var year= new String(date.substring(date.lastIndexOf("/")+1,date.length));
	var month= new String(date.substring(date.indexOf("/")+1,date.lastIndexOf("/")));
	var day= new String(date.substring(0,date.indexOf("/")));
	if ((strDate.charAt(2) != "/") && (strDate.charAt(5) != "/")){
		jalert("fecha inv�lida: " + strDate,null);
		isdate = false;
	}
	else if (isNaN(year) || year.length<4 || parseFloat(year)<1900){
		jalert("A�o inv�lido: " + strDate,null);
		isdate = false;
	}
	else if (isNaN(month) || parseFloat(month)<1 || parseFloat(month)>12){
		jalert("Mes inv�lido: " + strDate,null);
		isdate = false;
	}
	else if (isNaN(day) || parseInt(day, 10)<1 || parseInt(day, 10)>31){
		jalert("D�a inv�lido: " + strDate,null);
		isdate = false;
	}
	else if(month == 2){ 
		if(isLeap(year)){
			if(parseInt(day) > 29) {
				jalert("D�a inv�lido: " + strDate,null);
				isdate = false;
			}
		} else {
			if(parseInt(day) > 28){
				jalert("D�a inv�lido: " + strDate,null);
				isdate = false;
			}
		}
	}
	else if (month==4 || month==6 || month==9 || month==11 || month==2) {
		if (day>30) {
			jalert("D�a inv�lido: " + strDate,null);
			isdate = false;
		}
	}
	return isdate;
}
//Valida si es a�o bisiesto
function isLeap(year){
	var leap;
	if(parseInt(year)%4==0){
		if(parseInt(year)%100==0){
			if(parseInt(year)%400==0) leap=true;
			else leap=false;
		}
		else leap=true;
	}
	else leap=false;
	return leap;
}
//Convierte a fecha yyyyMMdd
function convertDate(date){
	var year= new String(date.substring(date.lastIndexOf("/")+1,date.length));
	var month= new String(date.substring(date.indexOf("/")+1,date.lastIndexOf("/")));
	var day= new String(date.substring(0,date.indexOf("/")));
	return year + "" + month + "" + day;
}
//Valida RUC
function validRucSunat(lcNroRuc) {
	var nroRuc = parseFloat(lcNroRuc.trim());
	if((nroRuc+"").length != 11 || isNaN(nroRuc)) { 
		alert("El numero de RUC debe contener once digitos");
		return false;
	}
	var aArrayRuc = new Array(3);
	for(var i=0; i<3; i++) {
		aArrayRuc[i] = new Array(11);
	}
	for(var i=0; i<11; i++) {
		aArrayRuc[0][i] = lcNroRuc.charAt(i);
	}
	aArrayRuc[1][0]=5;
	aArrayRuc[1][1]=4;
	aArrayRuc[1][2]=3;
	aArrayRuc[1][3]=2;
	aArrayRuc[1][4]=7;
	aArrayRuc[1][5]=6;
	aArrayRuc[1][6]=5;
	aArrayRuc[1][7]=4;
	aArrayRuc[1][8]=3;
	aArrayRuc[1][9]=2;
	aArrayRuc[2][10]=0;
	for(var i=0; i<10; i++) {
		aArrayRuc[2][i] = parseFloat(aArrayRuc[0][i]) * parseFloat(aArrayRuc[1][i]);
		aArrayRuc[2][10] = parseFloat(aArrayRuc[2][10]) + parseFloat(aArrayRuc[2][i]);
	}
	var lnResiduo = aArrayRuc[2][10] % 11;
	var lnUltDigito = 11 - lnResiduo;
	switch(lnUltDigito) {
		case 11,1:
			lnUltDigito = 1;
			break;
		case 10,0:
			lnUltDigito = 0;
			break;
	}
	if(lnUltDigito == aArrayRuc[0][10]) return true;
	else return false;
}
/**********************************************
** Funciones varias
**********************************************/
//Define una longitud de ingreso al objeto
function maxLength(Object, MaxLen, e) {
	var key = (document.all) ? e.keyCode : e.which;
	if(key == 8 || key == 9 || key == 46 || (key>=37 && key <=40)) return true;
	return (Object.value.length < MaxLen);
			
}
//redimenciona la p�gina
function resizeIframe() {
	if(document.all) {
		document.getElementById("ibody").style.height = document.getElementById("ibody").Document.body.scrollHeight+"px";
	} else {
		document.getElementById("ibody").style.height = document.getElementById("ibody").contentDocument.body.offsetHeight+"px";
	}
}
//Muestra objetos flash
function flashObject(p_file,p_width,p_height) {
	var oFlash= '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version="9,0,28,0" width="'+p_width+'" height="'+p_height+'" id="flashMovie">' +
				'<param name="movie" value="'+p_file+'">' +
				'<param name="allowScriptAccess" value="always">' +
				'<param name="allowNetworking" value="internal">' +
				'<param name="quality" value="high">' +
				'<param name="bgcolor" value="#000000">' +
				'<param name="menu" value="false" >' +
				'<embed src="'+p_file+'" bgcolor="#000000" menu="false" allowScriptAccess="always" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="'+p_width+'" height="'+p_height+'" swLiveConnect=true name="flashMovie"></embed>' +
				'</object>';
	return oFlash;
}
/**********************************************
** carga el objeto flash para la ayuda
*************************************************/
function flashObjectHelp(p,p_body,p_file,p_width,p_height) {
	var oFlash= '<object style="width:'+p_width+'px; height:'+p_height+'px;">' +
				'<param name="movie" value="'+p_file+'?hl=es_ES&amp;fs=1&amp;version=3">' +
				'<param name="allowFullScreen" value="true">' +
				'<param name="allowScriptAccess" value="always">' +
				'<param name="wmode" value="transparent">' +
				'<embed src="'+p_file+'?hl=es_ES&amp;fs=1&amp;version=3" ' +
				'type="application/x-shockwave-flash" allowfullscreen="true" allowScriptAccess="always"' +
				'wmode="transparent" width="'+p_width+'" height="'+p_height+'">' +
				'</object>';
	document.getElementById(p_body).innerHTML=oFlash;
	document.getElementById('lnktinka').className = 'help-video-tinka';
	document.getElementById('lnkganagol').className = 'help-video-ganagol';
	document.getElementById('lnkganadiario').className = 'help-video-ganadiario';
	document.getElementById('lnkkabala').className = 'help-video-kabala';
	document.getElementById('lnksuper3').className = 'help-video-super3';
	document.getElementById('lnkreventon').className = 'help-video-reventon';
	document.getElementById('lnkrapintinkas').className = 'help-video-rapintinkas';
	document.getElementById('lnkcargarsaldo').className = 'help-video-cargarsaldo';
	document.getElementById('lnkjugarsms').className = 'help-video-jugarsms';
	document.getElementById('lnkptosuerte').className = 'help-video-ptosuerte';
	if(p == 1) document.getElementById('lnktinka').className = 'help-video-tinka selected-tinka';
	if(p == 2) document.getElementById('lnkganagol').className = 'help-video-ganagol selected-ganagol';
	if(p == 3) document.getElementById('lnkganadiario').className = 'help-video-ganadiario selected-ganadiario';
	if(p == 4) document.getElementById('lnkkabala').className = 'help-video-kabala selected-kabala';
	if(p == 5) document.getElementById('lnksuper3').className = 'help-video-super3 selected-super3';
	if(p == 6) document.getElementById('lnkreventon').className = 'help-video-reventon selected-reventon';
	if(p == 7) document.getElementById('lnkrapintinkas').className = 'help-video-rapintinkas selected-rapintinkas';
	if(p == 8) document.getElementById('lnkcargarsaldo').className = 'help-video-cargarsaldo selected-cargarsaldo';
	if(p == 9) document.getElementById('lnkjugarsms').className = 'help-video-jugarsms selected-jugarsms';
	if(p == 10) document.getElementById('lnkptosuerte').className = 'help-video-ptosuerte selected-ptosuerte';
}
/**********************************************
** carga la ayuda seg�n opci�n elegida
*************************************************/
function viewHelp(page) {
	document.getElementById("lnkhelpplay").style.fontWeight = "normal";
	document.getElementById("lnkhelpcharge").style.fontWeight = "normal";
	document.getElementById("lnkhelpplaysms").style.fontWeight = "normal";
	document.getElementById("lnkhelpcollectprize").style.fontWeight = "normal";
	document.getElementById("lnkhelpsynchronize").style.fontWeight = "normal";
	document.getElementById("lnk"+page).style.fontWeight = "bold";
	document.getElementById("helpplay").style.display = "none";
	document.getElementById("helpcharge").style.display = "none";
	document.getElementById("helpplaysms").style.display = "none";
	document.getElementById("helpcollectprize").style.display = "none";
	document.getElementById("helpsynchronize").style.display = "none";
	document.getElementById(page).style.display = "";
	if(page == "helpcharge") flashObjectHelp(8,'bvideo','http://www.youtube.com/v/zsEd1SGr0eU',240,160);
	else if(page == "helpplaysms") flashObjectHelp(9,'bvideo','http://www.youtube.com/v/AC8P23UsZHk',240,160);
	else flashObjectHelp(1,'bvideo','http://www.youtube.com/v/TiqidZQS07k',240,160);
	top.resizeIframe();
}
//Muestra usuario en sesion
function loginHead(s, n) {
	if(s == "null") {
		top.document.getElementById('login-share').style.display = "";
		top.document.getElementById('logout-share').style.display = "none";
	} else {
		top.document.getElementById('login-share').style.display = "none";
		top.document.getElementById('logout-share').style.display = "";
		top.document.getElementById('usname').innerHTML = n;
	}
}
//Cambio de estilo en botones
function changeStyle(p) {
	top.document.getElementById('styles').href="css/account/"+p+".css";
	if(p=="inicio" || p=="micuenta" || p=="contactenos") {
		top.document.getElementById("logo").innerHTML="<a href='https://latinkaportal.com.pe' target='_blank' title='Intralot'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='https://latinkaportal.com.pe/como-jugar/?origin=i' target='_blank'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='https://latinkaportal.com.pe/puntos-de-venta/?origin=i' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/zsEd1SGr0eU><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/zsEd1SGr0eU type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"C&oacute;mo Jugar - La Tinka\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="tinka") {
		top.document.getElementById("logo").innerHTML="<a href='https://www.latinka.com.pe/p/juega-tinka.html' target='_blank' title='Tinka'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='https://latinkaportal.com.pe/como-jugar/tinka/' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='https://latinkaportal.com.pe/puntos-de-venta/?origin=i' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/TiqidZQS07k><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/TiqidZQS07k type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Tinka - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="ganagol") {
		top.document.getElementById("logo").innerHTML="<a href='https://www.latinka.com.pe/p/juega-ganagol.html' target='_blank' title='Ganagol'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='https://latinkaportal.com.pe/como-jugar/ganagol/' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='https://latinkaportal.com.pe/puntos-de-venta/?origin=i' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/mGoXuN_Ii2o><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/mGoXuN_Ii2o type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Ganagol - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="ganadiario") {
		top.document.getElementById("logo").innerHTML="<a href='https://www.latinka.com.pe/p/juega-ganadiario.html' target='_blank' title='Gana Diario'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='https://latinkaportal.com.pe/como-jugar/gana-diario/' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='https://latinkaportal.com.pe/puntos-de-venta/?origin=i' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/56TByf_doL0><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/56TByf_doL0 type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Gana Diario - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="kabala") {
		top.document.getElementById("logo").innerHTML="<a href='https://www.latinka.com.pe/p/juega-kabala.html' target='_blank' title='K�bala'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='https://latinkaportal.com.pe/como-jugar/kabala/' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='https://latinkaportal.com.pe/puntos-de-venta/?origin=i' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/mYAgQDFgN4k><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/mYAgQDFgN4k type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Nueva K&aacute;bala - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="super3") {
		top.document.getElementById("logo").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/super3' target='_blank' title='Super 3'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/super3/cjugar' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/super3/psuerte' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/4pCDTIL0fNA><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/4pCDTIL0fNA type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Super 3 - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="reventon") {
		top.document.getElementById("logo").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/reventon' target='_blank' title='Revent�n'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/reventon/cjugar' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/reventon/psuerte' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/zrtCZ1w7BlY><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/zrtCZ1w7BlY type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"El Revent&oacute;n - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	} else if(p=="instantaneas") {
		top.document.getElementById("logo").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/rapigana' target='_blank' title='Rapitinkas y Rapigana'></a>";
		top.document.getElementById("cjugar").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/rapigana/cjugar' target='_blank' title='Intralot'>Aprende a Jugar</a>";
		top.document.getElementById("psuerte").innerHTML="<a href='http://www.intralot.com.pe/portal/public/Intralot/rapigana/psuerte' target='_blank'>Puntos de la Suerte</a>";
		top.document.getElementById("ajugar").innerHTML="<a href='#' onclick='dhtmlwindow.open(\"prizebox\",\"inline\",\"<object style=height:344px;width:425px>" +
		"<param name=movie value=http://www.youtube.com/v/RD4_KPrCZBg><param name=allowFullScreen value=true><param name=allowScriptAccess value=always>" +
		"<embed src=http://www.youtube.com/v/RD4_KPrCZBg type=application/x-shockwave-flash allowfullscreen=true allowScriptAccess=always width=425 height=344>" +
		"</object>\",\"Instant&aacute;neas - C&oacute;mo Jugar\",\"width=430,height=344,center=1\");return false;'>&iquest;C&oacute;mo Jugar?</a>";
	}
	top.document.getElementById("contact").innerHTML="<a href='#' onclick='toContactUs(\""+p+"\");'>cont&aacute;ctanos</a>";
}
function viewCoteja(i) {
	if(i == 1) top.document.getElementById('collate').style.display = "";
	else top.document.getElementById('collate').style.display = "none";
}
//Refresco de ventana
var cnt = 0;
function ref(c) {
	if(top.cnt < 1) {
		top.cnt++;
		if(c == 0) loadPage("login_action.do?method=viewFormLogout");
		if(c == 1) loadPage("welcome_action.do?method=viewFormPendingPrize");
		setTimeout("ref("+c+")",120);
	}
}
//Env�a al formulario de registrar
function toRegister() {
	//loadPage("register_action.do?method=viewFormRegister");
	window.parent.location.href = "/p/registro.html";
}
//Env�a al formulario de registrar asociado
function toRegisterPartner() {
	var form = top.document.forms[0];
	var user = form.user.value;
	loadPage("register_action.do?method=viewFormPartnerRegister&usr="+user);
}
//Env�a al formulario de logeo
function toLogin() {
	loadPage("login_action.do?method=viewFormLogout");
}
//Realiza un logout
function toLogOut() {
	loadPage("login_action.do?method=viewFormLogout&state=0");
}
function toHome() {
	loadPage('home_action.do?method=viewFormHome');
}
function toTinka() {
	loadPage('home_tinka_visitor_action.do?method=viewHome');
}
function toGanadiario() {
	loadPage('home_ganadiario_visitor_action.do?method=viewHome');
}
function toGanagol(usr) {
	loadPage('home_ganagol_visitor_action.do?method=viewHome&name='+usr);
}
function toSuper3() {
	loadPage('home_super3_visitor_action.do?method=viewHome');
}
function toReventon() {
	if(top.isReventon) loadPage('home_reventon_visitor_action.do?method=viewHome');
	else jalert("Disponible próximamente.",null);
}
function toKabala() {
	loadPage('home_kabala_visitor_action.do?method=viewHome');
}
function toTinkaPartner() {
	loadPage("home_tinka_user_action.do?method=viewHomePartner");
}
function toGanadiarioPartner() {
	loadPage("home_ganadiario_user_action.do?method=viewHomePartner");
}
function toGanagolPartner() {
	loadPage("home_ganagol_user_action.do?method=viewHomePartner");
}
function toSuper3Partner() {
	loadPage("home_super3_user_action.do?method=viewHomePartner");
}
function toReventonPartner() {
	if(top.isReventon) loadPage('home_reventon_user_action.do?method=viewHomePartner');
	else jalert("Disponible próximamente.",null);
}
function toKabalaPartner() {
	loadPage("home_kabala_user_action.do?method=viewHomePartner");
}
function toInstantaneas(stateportal) {
	if(top.isInstant) {
		if(stateportal == null) loadPage('home_instantaneas_visitor_action.do?method=viewHome');
		else {
			loadPage('home_instantaneas_visitor_action.do?method=viewHome&stateportal='+stateportal);
		}
	}
	else jalert("Disponible próximamente.",null);
}
function toContactUs(g) {
	if(g == undefined) g = "contactenos";
	loadPage('contact_action.do?method=viewFormContactUs&game='+g);
}
function toInicioInstantaneas(stateportal) {
	if(stateportal != null) loadPage('home_instantaneas_visitor_action.do?method=viewShortcutInstantaneas&stateportal='+stateportal);
	else alert("No se ha definido un juego");
	//loadPage('home_instantaneas_visitor_action.do?method=viewShortcutInstantaneas');
}
function toShoppingCartVisitor() {
	loadPage("prepaid_action.do?method=viewFormChargeAccount");
}
function toShoppingCartUser() {
	loadPage("playcoupon_action.do?method=viewFormPlayCoupon&state=0");
}
/*function toChargePOS() {
	//document.location.href="Contactenos.do?m=formulario&game=Ganagolazo";
	var form = top.document.forms[0];
	form.action = "index_action.do";
	form.method.value="pasarelaPagoVPOS";
	//form.game.value = "Ganagolazo";
	form.submit();
}*/
function callSecurity() {
	openWindowWithScrollsIf('html/security.htm','ajaxbox',620,450,"Informaci�n Sobre Seguridad");
}
function callPolicies() {
	openWindowWithScrollsIf('html/policies.htm','ajaxbox',620,450,"Política de Ventas por Internet");
}
function toViewGames() {
	var coteja = top.statecoteja;
	if(coteja == 0) {
		var usinfo = window.frames['ibody'].userInfo;
		if(usinfo == undefined){
			usinfo = top.userInfo;
			top.userInfo = null;
			if(usinfo == "null") loadPage("login_action.do?method=viewFormLogout");
			else loadPage("welcome_action.do?method=viewFormWelcome");
		} else {
			if(usinfo == "null") loadPage("login_action.do?method=viewFormLogout");
			else loadPage("welcome_action.do?method=viewFormWelcome");
		}
	}
	if(coteja == 11) //tinka
		top.dhtmlwindow.open("tinka-compare-box", "iframe", "i.do?m=viewPopupTinkaCompareBets&tinkaCompareStateTitle=1", "", "width=735,height=545,scrolling=1,center=1,resize=1");

	if(coteja == 21) //ganagol
		top.dhtmlwindow.open("ganagol-compare-box", "iframe", "i.do?m=viewPopupGanagolCompareBets&ganagolCompareStateTitle=1", "", "width=735,height=600,scrolling=1,center=1,resize=1");

	if(coteja == 31) //ganadiario
		top.dhtmlwindow.open("ganadiario-compare-box", "iframe", "i.do?m=viewPopupGanadiarioCompareBets&ganadiarioCompareStateTitle=1", "", "width=735,height=545,scrolling=1,center=1,resize=1");

	if(coteja == 41) //kabala
		top.dhtmlwindow.open("kabala-compare-box", "iframe", "i.do?m=viewPopupKabalaCompareBets&kabalaCompareStateTitle=1", "", "width=735,height=545,scrolling=1,center=1,resize=1");
	
	if(coteja == 51) //super3
		top.dhtmlwindow.open("super3-compare-box", "iframe", "i.do?m=viewPopupSuper3CompareBets&super3CompareStateTitle=1", "", "width=717,height=545,scrolling=1,center=1,resize=1");
	
	if(coteja == 61) //reventon
		top.dhtmlwindow.open("reventon-compare-box", "iframe", "i.do?m=viewPopupReventonCompareBets&reventonCompareStateTitle=1", "", "width=724,height=545,scrolling=1,center=1,resize=1");
}
function callLastResults(r) {
	openWindowWithScrolls("i.do?m=viewResults&s="+r,"ajaxbox",800,500,"Resultados Tinka");
}
function callOutResults(r) {
	var h = 0;
	var w = 0;
	var t = "";
	if(r == 4) {
		w = 700;
		h = 450;
		t = "Resultados Ganagol";
	} else if(r == 13) {
		w = 700;
		h = 450;
		t = "Resultados El Revent�n";
	} else if(r == 41) {
		w = 590;
		h = 470;
		t = "Resultados Tinka";
	} else if(r == 42) {
		w = 590;
		h = 450;
		t = "Resultados Kabala";
	} else if(r == 164) {
		w = 590;
		h = 500;
		t = "Resultados Gana Diario";
	} else if(r == 163) {
		w = 590;
		h = 450;
		t = "Resultados Super 3";
	}
	top.dhtmlwindow.open("resultbox", "iframe", "i.do?m=resultados&t=1&s="+r, t, "width="+w+",height="+h+",scrolling=1,center=1,resize=1");
}
function callReportVPOS() {
	//top.dhtmlwindow.open("reportbox", "iframe", "index_action.do?method=resportVPOS", "Resultado del Comercio", "width=700,height=450,scrolling=1,center=1,resize=1");
	top.dhtmlwindow.open("reportbox", "iframe", "i.do?m=reportVPOS", "Resultado del Comercio", "width=700,height=450,scrolling=1,center=1,resize=1");
}
function callHelpGame(){
	loadPage("html/ayuda.htm");
}
//Comprueba version del IE
function verIE() {
	var _n=navigator,_w=window,_d=document;
	var version="NA";
	var na=_n.userAgent;
	if(/msie/i.test(na) && (!_w.opera)) {
		if(_w.attachEvent && _w.ActiveXObject){
			version = (na.match(/.+ie\s([\d.]+)/i) || [])[1];
			if(parseInt(version) == 7) {
				if(_d.documentMode) version = 8;
			}
		}
	}
	return version;
}
function IEVersion() {
	var _n=navigator,_w=window,_d=document;
	var version="NA";
	var na=_n.userAgent;
	// Look for msie and make sure its not opera in disguise
	if(/msie/i.test(na) && (!_w.opera)) {
		// also check for spoofers by checking known IE objects
		if(_w.attachEvent && _w.ActiveXObject) {
			// Get version displayed in UA although if its IE 8 running in 7 or compat mode it will appear as 7
			version = (na.match( /.+ie\s([\d.]+)/i ) || [])[1];
			// Its IE 8 pretending to be IE 7 or in compat mode
			if(parseInt(version)==7) {
				// documentMode is only supported in IE 8 so we know if its here its really IE 8
				if(_d.documentMode) version = 8;
			}
		}
	}
	return " UserAgent="+na+" Version="+version;
}
//Alerts
function jalert(txt, title) {
    try {top.jAlert(txt, title);}
    catch(e) {alert(txt);}
}
function jconfirm(txt, title, func) {
    try {top.jConfirm(txt, title, func);}
    catch(e) {if (confirm(txt, title)) func();}
}
function jprompt(txt, input, title, func){
    try {top.jPrompt(txt, input, title, func);}
    catch(e) {func(prompt(txt, input, title));}
}
//Deshabilita el forward
function backButtonOverride() {
	setTimeout("backButtonOverrideBody()", 1);
}
function backButtonOverrideBody() {
	try {history.forward();} catch (e) {}
	setTimeout("backButtonOverrideBody()", 500);
}
//Deshabilita el menu emergente
function oncontextmenuHandler() {return false;}
document.oncontextmenu = oncontextmenuHandler;
// End -->
