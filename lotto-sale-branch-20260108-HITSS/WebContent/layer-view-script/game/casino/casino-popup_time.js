function activarPopupCasino(flag){
	checkcount_casino();
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
		var count_casino_desktop = GetCookie('count_casino_desktop')
		if(count_casino_desktop == null) {
			SetCookie('count_casino_desktop','1')
			return 1
		}
		else {
			var newcount = parseInt(count_casino_desktop) + 1;
			DeleteCookie('count_casino_desktop')
			SetCookie('count_casino_desktop',newcount,exp)
			return count_casino_desktop
		}
	}
	function getCookieVal(offset) {
		var endstr = document.cookie.indexOf (";", offset);
		if (endstr == -1)
			endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}

	function checkcount_casino() {
		var count_casino_desktop = GetCookie('count_casino_desktop');
		if (count_casino_desktop == null) {
			var expDays = 1;
			localStorage.removeItem("exp_casino_desktop_nivel");
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_casino_desktop=1;
			SetCookie('count_casino_desktop', count_casino_desktop, exp);
			localStorage.setItem("exp_casino_desktop_nivel", exp);
			openModal("#popup-casino", "");							
		}
		else {
			count_casino_desktop++;
			var auxExp = localStorage.getItem("exp_casino_desktop_nivel");
			try{
				SetCookie('count_casino_desktop', count_casino_desktop, auxExp);
			}catch (e) {
				if (flag=='1')
					closeModal(1);
				else
					console.log(e.message);								
			}									
		}
	}			
}

$(document).delegate('#btn_desktop_ingresar_casino', 'click', function () {			
	 window.location.href = 'juega-casino.html';		   
});

function closeModal(state) {
	$('.overlay-tinka.opened').removeClass('opened');
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
}