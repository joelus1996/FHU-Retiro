function activarPopupmotazoDDVV(flag){
	checkcount_motazoDDVV();
	//}  
	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		//$('body').addClass('modal');
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
		var count_motazoDDVV_desktop = GetCookie('count_motazoDDVV_desktop')
		if(count_motazoDDVV_desktop == null) {
			SetCookie('count_motazoDDVV_desktop','1')
			return 1
		}
		else {
			var newcount = parseInt(count_motazoDDVV_desktop) + 1;
			DeleteCookie('count_motazoDDVV_desktop')
			SetCookie('count_motazoDDVV_desktop',newcount,exp)
			return count_motazoDDVV_desktop
		}
	}
	function getCookieVal(offset) {
		var endstr = document.cookie.indexOf (";", offset);
		if (endstr == -1)
			endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}

	function checkcount_motazoDDVV() {
		var count_motazoDDVV_desktop = GetCookie('count_motazoDDVV_desktop');
		if (count_motazoDDVV_desktop == null) {
			var expDays = 1; // dia que expirará
			localStorage.removeItem("exp_motazoDDVV_desktop_nivel");
			var exp = new Date();
			exp.setDate(exp.getDate() + expDays);
			//exp.setHours(exp.getHours(),exp.getMinutes(),exp.getSeconds() + 10,exp.getMilliseconds()); // desarrollo
			count_motazoDDVV_desktop=1;
			SetCookie('count_motazoDDVV_desktop', count_motazoDDVV_desktop, exp);
			localStorage.setItem("exp_motazoDDVV_desktop_nivel", exp);
			openModal("#popup-motazoDDVV", "");							
		}
		else {
			count_motazoDDVV_desktop++;
			var auxExp = localStorage.getItem("exp_motazoDDVV_desktop_nivel");
			try{
				SetCookie('count_motazoDDVV_desktop', count_motazoDDVV_desktop, auxExp);
			}catch (e) {
				if (flag=='1')
					closeModal(1);
				else
					console.log(e.message);								
			}									
		}
	}			
}
