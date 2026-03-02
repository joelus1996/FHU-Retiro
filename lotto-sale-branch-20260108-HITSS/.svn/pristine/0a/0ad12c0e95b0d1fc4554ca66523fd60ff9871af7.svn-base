var expDays = 2; // number of days the cookie should last

//var page = "only-popup-once.html";
//var windowprops = "width=300,height=200,location=no,toolbar=no,menubar=no,scrollbars=no,resizable=yes";

function GetCookie (name) {
var arg = name + "=";
var alen = arg.length;
var clen = document.cookie.length;
var i = 0;
while (i < clen) {
var j = i + alen;
if (document.cookie.substring(i, j) == arg)
return getCookieVal (j);
i = document.cookie.indexOf(" ", i) + 1;
if (i == 0) break;
}
return null;
}
function SetCookie (name, value) {
var argv = SetCookie.arguments;
var argc = SetCookie.arguments.length;
var expires = (argc > 2) ? argv[2] : null;
var path = (argc > 3) ? argv[3] : null;
var domain = (argc > 4) ? argv[4] : null;
var secure = (argc > 5) ? argv[5] : false;
document.cookie = name + "=" + escape (value) +
((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
((path == null) ? "" : ("; path=" + path)) +
((domain == null) ? "" : ("; domain=" + domain)) +
((secure == true) ? "; secure" : "");
}
function DeleteCookie (name) {
var exp = new Date();
exp.setTime (exp.getTime() - 1);
var cval = GetCookie (name);
document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}

function amt(){
var count = GetCookie('countcb')
if(count == null) {
SetCookie('countcb','1')
return 1
}
else {
var newcount = parseInt(count) + 1;
DeleteCookie('countcb')
SetCookie('countcb',newcount,exp)
return count
   }
}
function getCookieVal(offset) {
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1)
endstr = document.cookie.length;
return unescape(document.cookie.substring(offset, endstr));
}

function checkCount() {
var count = GetCookie('countcb');
console.log(' GetCookie ' + count);		
if (count == null) {
	localStorage.removeItem("exp_home_desktop");
	var exp = new Date();
	exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
	//exp.setTime(exp.getTime() + (expDays*5*60*1000));
	count=1;
	SetCookie('countcb', count, exp);
	localStorage.setItem("exp_home_desktop", exp);

openModal("#popup-copacasa", "");

}
else {
count++;
auxExp = localStorage.getItem("exp_home_desktop");
try{
	SetCookie('countcb', count, auxExp);
}catch(e){
	console.log(e.message);
}

   }
}





