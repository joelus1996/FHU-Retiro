function activarPopupHincha(flag,tipo){
	var flag_count=0;
	checkcount_hincha(tipo);
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

	function getCookieVal(offset) {
		var endstr = document.cookie.indexOf (";", offset);
		if (endstr == -1)
			endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}

	function checkcount_hincha(tipo) {
		var count_hincha_desktop = GetCookie('count_hincha_desktop_'+tipo);
		if (count_hincha_desktop == null) {
			var expDays = 1;
			localStorage.removeItem("exp_hincha_desktop_"+tipo);
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_hincha_desktop=1;
			SetCookie('count_hincha_desktop_'+tipo, count_hincha_desktop, exp);
			localStorage.setItem("exp_hincha_desktop_"+tipo, exp);
			$.ajax({
		        type: "POST",
		        url: "verificar_promocion_hincha.html",
		        dataType: "json",
		        async: false,
		        success: function (data) {

					var clienteParticipa = data.flagParticipa;
					console.log('participa en la promo : ' +clienteParticipa);

					if(clienteParticipa == false){
						openModal("#popup-hincha-"+tipo, "");
					}				
		        }
		    });
		}
		else {
			count_hincha_desktop++;
			flag_count = count_hincha_desktop;
			var auxExp = localStorage.getItem("exp_hincha_desktop_"+tipo);
			try{
				SetCookie('count_hincha_desktop_'+tipo, count_hincha_desktop, auxExp);
			}catch (e) {
				if (flag=='1')
					closeModal(1);
				else
					console.log(e.message);								
			}									
		}
	}	
	return flag_count;
}

$(document).delegate('#btn_desktop_informate_hincha', 'click', function () {			
	window.location.href = $('#urlQw').val() + '/promociones/el-avion-del-hincha/?origin=i';		   
});

$(document).delegate('#btn_desktop_participa_hincha', 'click', function () {			
	 $.ajax({
	        type: "POST",
	        url: "registrar_promocion_hincha.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
				
	        }
	    });	
	 //ajax graba participacion, luego redirije a TA
	 toTAV2();
});

$(document).delegate('#btn_desktop_participa_hincha_ta', 'click', function () {			
	$('.overlay-hincha.opened').removeClass('opened');
	$.ajax({
        type: "POST",
        url: "registrar_promocion_hincha.html",
        dataType: "json",
        async: false,
        success: function (data) {
			
        }
    });
	window.open(baseUrl+"?authToken="+authToken,"_parent");
});

function closeModal(state) {
	$('.overlay-hincha.opened').removeClass('opened');
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
}