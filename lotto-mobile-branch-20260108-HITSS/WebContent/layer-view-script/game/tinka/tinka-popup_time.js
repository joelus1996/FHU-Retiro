function activarPopupTinka(flag){
	checkcount_tinka();
	//}
	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}
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
		var count_tinka_mobile = GetCookie('count_tinka_mobile')
		if(count_tinka_mobile == null) {
			SetCookie('count_tinka_mobile','1')
			return 1
		}
		else {
			var newcount = parseInt(count_tinka_mobile) + 1;
			DeleteCookie('count_tinka_mobile')
			SetCookie('count_tinka_mobile',newcount,exp)
			return count_tinka_mobile
		}
	}
	function getCookieVal(offset) {
		var endstr = document.cookie.indexOf (";", offset);
		if (endstr == -1)
			endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}

	function checkcount_tinka() {
		var count_tinka_mobile = GetCookie('count_tinka_mobile');
		if (count_tinka_mobile == null) {
			var expDays = 1;
			localStorage.removeItem("exp_tinka_mobile_nivel");
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_tinka_mobile=1;
			SetCookie('count_tinka_mobile', count_tinka_mobile, exp);
			localStorage.setItem("exp_tinka_mobile_nivel", exp);
			openModal("#popup-tinka", "");							
		}
		else {
			count_tinka_mobile++;
			var auxExp = localStorage.getItem("exp_tinka_mobile_nivel");
			try{
				SetCookie('count_tinka_mobile', count_tinka_mobile, auxExp);
			}catch (e) {
				if(flag=='1')
					closeModal(1);
				else
					console.log(e.message);								
			}									
		}
	}	
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
}

$(document).delegate('#btn_mobile_ingresar_tinka', 'click', function () {			
	 window.location.href = 'popup-tinka.html?source=E&device=mobile';		   
});

$(document).delegate('#btn_mobile_ingresar_tinka_ta', 'click', function () {			
	window.open("popup-tinka.html?source=T&device=mobile","_blank");
	$('.overlay-tinka.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
});