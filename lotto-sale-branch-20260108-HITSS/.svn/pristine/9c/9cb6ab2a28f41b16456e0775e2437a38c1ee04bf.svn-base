/**<p> NAME:    utils.js
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY                    DATE        COMMENT
 * 001   oscar.candela        04/02/2008  First comment
 * 001   cristian.cortez    16/07/2008  New
 * 001   barreragz.emanuel	21/09/2017  
 * </pre>
 * </p>
 */


/*********************************************************
 * trim y leftPad
 *************************************************/
String.prototype.trim = function () {
  return this.replace(/^\s+|\s+$/g, '');
};
String.prototype.leftPad = function (l, c) {
  return new Array(l - this.length + 1).join(c || '0') + this;
};
/********************************************************************
 * Valida el ingreso de caracteres a un control de texto
 *********************************************************************/
var DBL_PATTERN = /^[a-i\d`nÂ¾]*$/;
var INT_PATTERN = /^[a-i\d`]*$/;
var DATE_PATTERN = /^\d{0,2}\/?\d{0,2}\/?\d{0,4}$/;
var ALFA_PATTERN = /^[\s\w\.\,\/\-`½¾]*$/;
var LETTER_PATTERN = /^[a-zA-Z\sñÑáéíóú'ÞÀÛ]*$/;
var MAIL_PATTERN = /^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@+([_a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]{2,200}\.[a-zA-Z]{2,6}$/;
var URL_PATTERN = /^http::\/\/(www\.)?(\w)+\.(\w){2,}\/\.*$/;

var ctrl = false;
var flagEfectivoInterbank=0;

function validKey(e, format, cp, target) {
  var ret = false;
  var obj = document.forms[0].elements;
  var index = 0;
  var e = window.event || e;
  var key = (document.all) ? e.keyCode : e.which;
  var k = String.fromCharCode(key);
  //if(key != 16 && key != 17) jAlert("key="+key+" k="+k+" test="+format.test(k));
  if (key == 8 || key == 37 || key == 39) {
    ctrl = false;
    ret = true;
  } else if (key == 9) {
    if (target != null) {
      for (var i = 0; i < obj.length; i++) {
        if (obj[i] == target) {
          index = i;
          break;
        }
      }
      for (var j = index + 1; j < obj.length; j++) {
        if (obj[j].type == "text" || obj[j].type == "password" || obj[j].type == "radio" || obj[j].type == "select-one" || obj[j].type == "checkbox") {
          index = j;
          break;
        }
      }
      obj[index].focus();
      if (!obj[j].type == "select-one") obj[index].select();
      ctrl = false;
      ret = false;
    } else return true;
  } else if (key == 17) {
    ctrl = true;
    ret = true;
  } else if (key == 86) {
    if (cp == false && ctrl == true) {
      ctrl = true;
      ret = false;
    } else if (cp == true && ctrl == true) {
      ctrl = false;
      ret = true;
    } else {
      ctrl = false;
      ret = true;
    }
  } else if (key == 13) {
    keyEnter();
  } else {
    ctrl = false;
    if (format == 'none') ret = true;
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
  return val.replace(/ /g, '');
}
String.prototype.removeAccents = function () {
  var __r = {
    'À': 'A',
    'Á': 'A',
    'Â': 'A',
    'Ã': 'A',
    'Ä': 'A',
    'Å': 'A',
    'Æ': 'E',
    'È': 'E',
    'É': 'E',
    'Ê': 'E',
    'Ë': 'E',
    'Ì': 'I',
    'Í': 'I',
    'Î': 'I',
    'Ï': 'I',
    'Ò': 'O',
    'Ó': 'O',
    'Ô': 'O',
    'Ö': 'O',
    'Ù': 'U',
    'Ú': 'U',
    'Û': 'U',
    'Ü': 'U',
    'Ñ': 'N'
  };
  return this.replace(/[ÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÒÓÔÖÙÚÛÜÑ]/gi, function (m) {
    var ret = __r[m.toUpperCase()];
    if (m === m.toLowerCase())
      ret = ret.toLowerCase();
    return ret;
  });
};

function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(?:\d{3})+(?!\d))/g, ",");
}
/********************************************************************
 *Valida el texto de un control de texto como dato fecha
 *********************************************************************/
function isDate(text) {
  var arDate = text.split("/");
  var blnRet;
  if (arDate.length == 3) {
    var aDate = new Date(arDate[2], arDate[1] - 1, arDate[0]);
    blnRet = (aDate.getFullYear() == arDate[2] && aDate.getMonth() == arDate[1] - 1 && aDate.getDate() == arDate[0]);
  }
  return (arDate.length == 3 && blnRet);
}
/**********************************************
 ** crea una ventana popup
 *************************************************/
function openWin(url, w, h, targetFrame) {
  var l = (screen.availWidth - w) / 2;
  var t = 0;
  var win = window.open(url, targetFrame, "width=" + w + ",height=" + h + ",left=" + l + ",top=" + t + ",fullscreen=no,status=no,toolbar=no,directories=no,location=no,menubar=no,resizable=no,titlebar=no,scrollbars=yes,channelmode=no", true);
  win.focus();
  return win;
}

function openWinp(url, w, h, targetFrame) {
  var l = (screen.availWidth - w) / 2;
  var t = 0;
  var win = window.open(url, targetFrame, "width=" + w + ",height=" + h + ",left=" + l + ",top=" + t + ",resizable=no,scrollbars=no,toolbar=no,location=no,directories=no,status=no,menubar=no,fullscreen=no,titlebar=no,channelmode=no,copyhistory=no,visible=none", true);
  win.focus();
  return win;
}

function openWindow(url, targetFrame) {
  var win = window.open(url, targetFrame);
  win.focus();
  return false; //win;
}

function openWindowWithScrolls(url, name, w, h, title) {
  var ajaxwin = dhtmlwindow.open(name, "ajax", url, title, "width=" + w + ",height=" + h + ",scrolling=1,center=1,resize=1");
}

function openWindowWithScrollsIf(url, name, w, h, title) {
  var ajaxwin = dhtmlwindow.open(name, "iframe", url, title, "width=" + w + ",height=" + h + ",scrolling=1,center=1,resize=1", "recal");
}

function loadPage(urlDoc) {
  document.open(urlDoc, "ibody", "", true);
}

function openPreviewWindow(gameid, gamename, parameterId) {
	  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa.html?gameId=" + gameid + "&parameterId=" + parameterId, "boleto " + gamename.toLowerCase(), "width=755,height=680,scrolling=1,center=1,resize=1", "recal");
}

function openWindowGames(gameid, gamename, parameterId, canalVenta) { 
	  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa_games.html?gameId=" + gameid + "&parameterId=" + parameterId + "&canalVenta=" + canalVenta, "boleto " + gamename.toLowerCase(), "width=755,height=680,scrolling=1,center=1,resize=1", "recal"); 
}

function openWindowGameIflex(gameid, gamename, parameterId, canalVenta, cpn, programa) {
	  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa_ta_iflex.html?gameId=" + gameid + "&parameterId=" + parameterId + "&canalVenta=" + canalVenta + "&cpn=" + cpn + "&programa=" + programa, "boleto " + gamename.toLowerCase(), "width=980,height=470,scrolling=1,center=1,resize=1", "recal"); 

}

function openPreviewWindowPP(gameid, gamename, parameterId) {
  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa_pp.html?gameId=" + gameid + "&parameterId=" + parameterId, "Boleto " + gamename, "width=360,height=420,scrolling=0,center=1,resize=1", "recal");
}

function openIflexWindow(url, gamename, couponId) {
  ///dhtmlwindow.open("resultbox", "iframe", url, "boleto " + gamename, "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
	openTANwindows(url, couponId);
}

function openTyCWindow(url) {
//  dhtmlwindow.open("resultbox", "iframe", "https://www.intralot.com.pe/intralot/minisite/combos-tinkeros/", "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
  dhtmlwindow.open("resultbox", "iframe", url, "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
}

function openTyCKabalaWindow(url) {
//  dhtmlwindow.open("resultbox", "iframe", "https://www.intralot.com.pe/intralot/minisite/combos-kabala/", "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
  dhtmlwindow.open("resultbox", "iframe", url, "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
}

function openTyCGanadiarioWindow(url) {
//  dhtmlwindow.open("resultbox", "iframe", "https://www.intralot.com.pe/intralot/minisite/combos-ganadiario/", "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
  dhtmlwindow.open("resultbox", "iframe", url, "TÉRMINOS Y CONDICIONES", "width=600,height=400,scrolling=1,center=1,resize=1", "recal");
}

function openVirtualesWindow(url, gamename, couponId) {
	  ///dhtmlwindow.open("resultbox", "iframe", url, "boleto " + gamename, "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
		openVIRTwindows(url, couponId);
}

function openTeApuestoNovus(url, gamename, couponId) {
		openTANovusWindows(url, couponId);
}



function validar(e) {
  tecla = (document.all) ? e.keyCode : e.which;
  if (tecla == 8) return true; //Tecla de retroceso (para poder borrar)
  if (tecla == 44) return false; //Coma ( En este caso para diferenciar los decimales )
  if (tecla == 48) return true;
  if (tecla == 49) return true;
  if (tecla == 50) return true;
  if (tecla == 51) return true;
  if (tecla == 52) return true;
  if (tecla == 53) return true;
  if (tecla == 54) return true;
  if (tecla == 55) return true;
  if (tecla == 56) return true;
  patron = /9/;
  te = String.fromCharCode(tecla);
  return patron.test(te)
}

var nameGeneral = '';

function message(gameId, parameterId) {

  if (gameId == 249) {

    //$(location).attr("href","verifyByTicket.html?parameterId="+parameterId+"&gameId="+gameId);

    $.ajax({
      type: "post",
      url: "verifyByTicket.html",
      data: "parameterId=" + parameterId + "&gameId=" + gameId,
      dataType: "text",
      global: false,
      async: false,
      success: function (e) {
        var msg = e;
        jAlert(msg, null, function (r) {
          if (r) {
            window.location.replace('mi-cuenta.html')
          }
        });
      }

    });

  }

}

function openPreviewWindow_award(gameId, gameName, parameterId, printPay, prizesSet) {
  nameGeneral = gameName;
  if (printPay === 'YES') {
	//dhtmlwindow.open("resultboxAward", "iframe", "ticket_vista_previa_Award.html?gameId=" + gameId + "&parameterId=" + parameterId + "&printPay=" + printPay + "&prizesSet=" + prizesSet, "boleto " + gameName.toLowerCase(), "width=760,height=645,scrolling=1,center=1,resize=1", "recal");
	  dhtmlwindow.open("resultboxAward", "iframe", "ticket_vista_previa_Award.html?gameId=" + gameId + "&parameterId=" + parameterId + "&printPay=" + printPay + "&prizesSet=" + prizesSet, "boleto " + gameName.toLowerCase(), "width=780,height=665,scrolling=1,center=1,resize=1", "recal");
  } else {
    dhtmlwindow.open("resultboxAward", "iframe", "ticket_vista_previa.html?gameId=" + gameId + "&parameterId=" + parameterId, "boleto " + gameName.toLowerCase(), "width=744,height=608,scrolling=1,center=1,resize=1", "recal");
  }
}

function openPreviewWindow_ganadiario(ticketid, gameid) {
  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa_popup_ganadiario.html?ticketId=" + 6169 + "&gameId=" + 164, "DETALLE DE PREMIO", "width=744,height=450,scrolling=1,center=1,resize=1", "recal");
}

function openPreviewWindow_kabala(ticketid, gameid) {
  dhtmlwindow.open("resultbox", "iframe", "ticket_vista_previa_popup_kabala.html?ticketId=" + 346 + "&gameId=" + 42, "DETALLE DE PREMIO", "width=744,height=450,scrolling=1,center=1,resize=1", "recal");
}

function openPreviewWindowTableKinelo() {
  dhtmlwindow.open("resultbox", "iframe", "prize_table_kinelo.html", "¿CUÁNTO PUEDO GANAR CON KINELO?", "width=640,height=452,scrolling=0,center=1,resize=1", "recal");
}

function openPreviewWindowTableFechaza() {
  dhtmlwindow.open("resultbox", "iframe", "prize_table_fechaza.html", "¿CUÁNTO PUEDO GANAR CON FECHAZA?", "width=522,height=394,scrolling=0,center=1,resize=1", "recal");
}
/**********************************************
 ** Valida formularios
 *************************************************/
function _findObj(n, d) { //v4.01
  var p, i, x;
  if (!d) d = document;
  if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
    d = parent.frames[n.substring(p + 1)].document;
    n = n.substring(0, p);
  }
  if (!(x = d[n]) && d.all) x = d.all[n];
  for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
  for (i = 0; !x && d.layers && i < d.layers.length; i++) x = _findObj(n, d.layers[i].document);
  if (!x && d.getElementById) x = d.getElementById(n);
  return x;
}

function validateForm() { //v4.0
  var i, p, q, nm, test, num, min, max, errors = '',
    args = validateForm.arguments;
  for (i = 0; i < (args.length - 2); i += 3) {
    test = args[i + 2];
    val = _findObj(args[i]);
    if (val) {
      nm = args[i + 1] != '' ? args[i + 1] : val.name; //etiqueta
      if ((val = val.value.trim()) != "") {
        if (test.indexOf('isDate') != -1) {
          if (!isDate(val)) errors += '-' + nm + ' debe contener una fecha v?lida con formato (dd/mm/yyyy).\n';
        } else if (test.indexOf('isEmail') != -1) {
          p = val.indexOf('@');
          if (p < 1 || p == (val.length - 1)) errors += '- ' + nm + ' debe contener una direcci?n de correo.\n';
        } else if (test.indexOf('inLength') != -1) {
          len = test.substring(9);
          if (len != val.length) errors += '- ' + nm + ' debe tener ' + len + ' caracteres.\n';
        } else if (test != 'R') {
          num = parseFloat(val);
          if (isNaN(val)) errors += '- ' + nm + ' debe contener un n?mero.\n';
          if (test.indexOf('inRange') != -1) {
            p = test.indexOf(':');
            min = test.substring(8, p);
            max = test.substring(p + 1);
            if (num < min || max < num) errors += '- ' + nm + ' debe contener un n?mero entre ' + min + ' y ' + max + '.\n';
          }
        }
      } else if (test.charAt(0) == 'R') errors += '- ' + nm + ' es obligatorio.\n';
    }
  }
  if (errors) jAlert('Han ocurrido los siguientes errores:\n' + errors, null);
  return (errors == '');
}
/**********************************************
 ** Función para dar formato a una fecha
 **********************************************/
Date.prototype.format = function (format) {
  var returnStr = '';
  var replace = Date.replaceChars;
  for (var i = 0; i < format.length; i++) {
    var curChar = format.charAt(i);
    if (replace[curChar]) {
      returnStr += replace[curChar].call(this);
    } else {
      returnStr += curChar;
    }
  }
  return returnStr;
};
Date.replaceChars = {
  shortMonths: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
  longMonths: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
  shortDays: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
  longDays: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
  d: function () {
    return (this.getDate() < 10 ? '0' : '') + this.getDate();
  },
  D: function () {
    return Date.replaceChars.shortDays[this.getDay()];
  },
  j: function () {
    return this.getDate();
  },
  l: function () {
    return Date.replaceChars.longDays[this.getDay()];
  },
  N: function () {
    return this.getDay() + 1;
  },
  S: function () {
    return (this.getDate() % 10 == 1 && this.getDate() != 11 ? 'st' : (this.getDate() % 10 == 2 && this.getDate() != 12 ? 'nd' : (this.getDate() % 10 == 3 && this.getDate() != 13 ? 'rd' : 'th')));
  },
  w: function () {
    return this.getDay();
  },
  z: function () {
    return "Not Yet Supported";
  },
  W: function () {
    return "Not Yet Supported";
  },
  F: function () {
    return Date.replaceChars.longMonths[this.getMonth()];
  },
  m: function () {
    return (this.getMonth() < 9 ? '0' : '') + (this.getMonth() + 1);
  },
  M: function () {
    return Date.replaceChars.shortMonths[this.getMonth()];
  },
  n: function () {
    return this.getMonth() + 1;
  },
  t: function () {
    return "Not Yet Supported";
  },
  L: function () {
    return "Not Yet Supported";
  },
  o: function () {
    return "Not Supported";
  },
  Y: function () {
    return this.getFullYear();
  },
  y: function () {
    return ('' + this.getFullYear()).substr(2);
  },
  a: function () {
    return this.getHours() < 12 ? 'a.m.' : 'p.m.';
  },
  A: function () {
    return this.getHours() < 12 ? 'AM' : 'PM';
  },
  B: function () {
    return "Not Yet Supported";
  },
  g: function () {
    return this.getHours() % 12 || 12;
  },
  G: function () {
    return this.getHours();
  },
  h: function () {
    return ((this.getHours() % 12 || 12) < 10 ? '0' : '') + (this.getHours() % 12 || 12);
  },
  H: function () {
    return (this.getHours() < 10 ? '0' : '') + this.getHours();
  },
  i: function () {
    return (this.getMinutes() < 10 ? '0' : '') + this.getMinutes();
  },
  s: function () {
    return (this.getSeconds() < 10 ? '0' : '') + this.getSeconds();
  },
  e: function () {
    return "de";
  },
  I: function () {
    return "Not Supported";
  },
  O: function () {
    return (-this.getTimezoneOffset() < 0 ? '-' : '+') + (Math.abs(this.getTimezoneOffset() / 60) < 10 ? '0' : '') + (Math.abs(this.getTimezoneOffset() / 60)) + '00';
  },
  T: function () {
    var m = this.getMonth();
    this.setMonth(0);
    var result = this.toTimeString().replace(/^.+ \(?([^\)]+)\)?$/, '$1');
    this.setMonth(m);
    return result;
  },
  Z: function () {
    return -this.getTimezoneOffset() * 60;
  },
  c: function () {
    return "Not Yet Supported";
  },
  r: function () {
    return this.toString();
  },
  U: function () {
    return this.getTime() / 1000;
  }
};
/**********************************************
 ** Valida una fecha
 **********************************************/
function validateDate(strDate) {
  var isdate = true;
  var date = new String(strDate);
  var realDate = new Date();
  var year = new String(date.substring(date.lastIndexOf("/") + 1, date.length));
  var month = new String(date.substring(date.indexOf("/") + 1, date.lastIndexOf("/")));
  var day = new String(date.substring(0, date.indexOf("/")));
  if ((strDate.charAt(2) != "/") && (strDate.charAt(5) != "/")) {
    jAlert("fecha inválida: " + strDate, null);
    isdate = false;
  } else if (isNaN(year) || year.length < 4 || parseFloat(year) < 1900) {
    jAlert("Año inválido: " + strDate, null);
    isdate = false;
  } else if (isNaN(month) || parseFloat(month) < 1 || parseFloat(month) > 12) {
    jAlert("Mes inválido: " + strDate, null);
    isdate = false;
  } else if (isNaN(day) || parseInt(day, 10) < 1 || parseInt(day, 10) > 31) {
    jAlert("Día inválido: " + strDate, null);
    isdate = false;
  } else if (month == 2) {
    if (isLeap(year)) {
      if (parseInt(day) > 29) {
        jAlert("Día inválido: " + strDate, null);
        isdate = false;
      }
    } else {
      if (parseInt(day) > 28) {
        jAlert("Día inválido: " + strDate, null);
        isdate = false;
      }
    }
  } else if (month == 4 || month == 6 || month == 9 || month == 11 || month == 2) {
    if (day > 30) {
      jAlert("Día inválido: " + strDate, null);
      isdate = false;
    }
  }
  return isdate;
}
//Valida si es año bisiñsto
function isLeap(year) {
  var leap;
  if (parseInt(year) % 4 == 0) {
    if (parseInt(year) % 100 == 0) {
      if (parseInt(year) % 400 == 0) leap = true;
      else leap = false;
    } else leap = true;
  } else leap = false;
  return leap;
}
//Convierte a fecha yyyyMMdd
function convertDate(date) {
  var year = new String(date.substring(date.lastIndexOf("/") + 1, date.length));
  var month = new String(date.substring(date.indexOf("/") + 1, date.lastIndexOf("/")));
  var day = new String(date.substring(0, date.indexOf("/")));
  return year + "" + month + "" + day;
}
//Valida RUC
function validRucSunat(lcNroRuc) {
  var nroRuc = parseFloat(lcNroRuc.trim());
  if ((nroRuc + "").length != 11 || isNaN(nroRuc)) {
    jAlert("El n�mero de RUC debe contener once d�gitos");
    return false;
  }
  var aArrayRuc = new Array(3);
  for (var i = 0; i < 3; i++) {
    aArrayRuc[i] = new Array(11);
  }
  for (var i = 0; i < 11; i++) {
    aArrayRuc[0][i] = lcNroRuc.charAt(i);
  }
  aArrayRuc[1][0] = 5;
  aArrayRuc[1][1] = 4;
  aArrayRuc[1][2] = 3;
  aArrayRuc[1][3] = 2;
  aArrayRuc[1][4] = 7;
  aArrayRuc[1][5] = 6;
  aArrayRuc[1][6] = 5;
  aArrayRuc[1][7] = 4;
  aArrayRuc[1][8] = 3;
  aArrayRuc[1][9] = 2;
  aArrayRuc[2][10] = 0;
  for (var i = 0; i < 10; i++) {
    aArrayRuc[2][i] = parseFloat(aArrayRuc[0][i]) * parseFloat(aArrayRuc[1][i]);
    aArrayRuc[2][10] = parseFloat(aArrayRuc[2][10]) + parseFloat(aArrayRuc[2][i]);
  }
  var lnResiduo = aArrayRuc[2][10] % 11;
  var lnUltDigito = 11 - lnResiduo;
  switch (lnUltDigito) {
    case 11, 1:
      lnUltDigito = 1;
      break;
    case 10, 0:
      lnUltDigito = 0;
      break;
  }
  if (lnUltDigito == aArrayRuc[0][10]) return true;
  else return false;
}
/**********************************************
 ** Funciones varias
 **********************************************/
//Define una longitud de ingreso al objeto
function MaxLength(Object, MaxLen, e) {
  var key = (document.all) ? e.keyCode : e.which;
  if (key == 8 || key == 9 || key == 46 || (key >= 37 && key <= 40)) return true;
  return (Object.value.length < MaxLen)
}
//redimenciona la página
function resizeIframe() {
  var ifrm = document.getElementById("ibody");
  if (ifrm.contentDocument) {
    ifrm.style.height = (ifrm.contentDocument.body.offsetHeight + 1) + "px";
  } else {
    ifrm.style.height = (ifrm.contentWindow.document.body.scrollHeight + 1) + "px";
  }
}
//Muestra objetos flash
function flashObject(p_body, p_file, p_width, p_height) {
  document.getElementById(p_body).innerHTML = '<object style="width:' + p_width + 'px; height:' + p_height + 'px;">' +
    '<param name="movie" value="' + p_file + '?hl=es_ES&fs=1&version=3&autoplay=1">' +
    '<param name="allowFullScreen" value="true">' +
    '<param name="allowScriptAccess" value="always">' +
    '<param name="wmode" value="transparent">' +
    '<embed src="' + p_file + '?hl=es_ES&fs=1&version=3&autoplay=1" ' +
    'type="application/x-shockwave-flash" allowfullscreen="true" allowScriptAccess="always"' +
    'wmode="transparent" width="' + p_width + '" height="' + p_height + '">' +
    '</object>'
}

function viewCoteja(i) {
  if (i == 1) top.document.getElementById('collate').style.display = "";
  else top.document.getElementById('collate').style.display = "none";
}
//Refresco de ventana
var cnt = 0;

function ref(c) {
  if (top.cnt < 1) {
    top.cnt++;
    if (c == 0) loadPage("login_action.do?method=viewFormLogout");
    if (c == 1) loadPage("welcome_action.do?method=viewFormPendingPrize");
    setTimeout("ref(" + c + ")", 120)
  }
}
//Para nuevo pago de premios
function optionChange(a) {
  var flag = false;
  $(a).attr("checked", true);
  if ($(a).attr("id") == "option2x1" && $(a).prop("checked")) {
    $("#optionfree").attr("checked", false);
    flag = true;
    desist = false;
  } else if ($(a).attr("id") == "optionfree" && $(a).prop("checked")) {
    $("#option2x1").attr("checked", false);
    flag = true;
    desist = true;
  }
  if (flag) $("#award-list").html(awardList());
  //alert("DESIST1="+($("#option2x1").attr("checked"))+" DESIST2="+($("#option2x1").prop("checked"))+" DESIST3="+($("#option2x1").is(":checked"))+" desist="+desist);
  return flag;
}

function awardList() {
  var t = "<table border='0' cellpadding='0' cellspacing='0' width='355' style='margin:7px auto;'>" +
    "<tr style='height:19px;background-color:#0283bc;text-align:center;color:#fff;font-weight:bold;'><th width='72' style='border-bottom:1px solid #fff;padding-top:2px;'>BOLETO Nº</th><th width='23' style='border-bottom:1px solid #fff;padding-top:2px;'> </th><th width='56' style='border-bottom:1px solid #fff;padding-top:2px;'>JUGADAS</th>" +
    "<th width='79' style='border-bottom:1px solid #fff;padding-top:2px;'>CONCEPTO</th><th width='59' style='border-bottom:1px solid #fff;padding-top:2px;'>SORTEOS</th><th width='66' style='border-bottom:1px solid #fff;padding-top:2px;'>COSTO</th></tr>";
  cnt = 0;
  for (var i = 0; i < arrGroup.length; i++) {
    var d = arrGroup[i].split("|");
    if (d[1] == '(2x1)' && desist) {
      t += "<tr style='height:14px;background-color:#ffeeee;text-align:center;'><td style='border-bottom:1px solid #fff;'>" + d[0] + "</td><td style='border-bottom:1px solid #fff;'>" + d[1] + "</td><td style='border-bottom:1px solid #fff;'>" + d[2] + "</td><td style='border-bottom:1px solid #fff;'>NO COBRAR</td><td style='border-bottom:1px solid #fff;'>" + d[4] + "</td><td style='border-bottom:1px solid #fff;'>" + d[5] + "</td></tr>";
    } else {
      t += "<tr style='height:14px;background-color:#efeff1;text-align:center;'><td style='border-bottom:1px solid #fff;'>" + d[0] + "</td><td style='border-bottom:1px solid #fff;'>" + d[1] + "</td><td style='border-bottom:1px solid #fff;'>" + d[2] + "</td><td style='border-bottom:1px solid #fff;'>" + d[3] + "</td><td style='border-bottom:1px solid #fff;'>" + d[4] + "</td><td style='border-bottom:1px solid #fff;'>" + d[5] + "</td></tr>";
      //arrTemp[cnt] = arrGroup[i]
      cnt++;
    }
  }
  t += "</table>";
  return t;
}
var desist = false;
var groups = 0;
var sdesist = "true";
var scredit = "true";
var arrGroup = new Array();
/**PREMIO**/
var premio = function () {

	  $('.pago').on('click', function () {

		    //	var gameId = $(this).attr('rel');		  

		    var gameId = $(".pago").data('premio').id;
		    var parameterId = $(".pago").data('premio').parameterId;
		    var apGratis = $(".pago").data('premio').apGratis;
		    var money = $(".pago").data('premio').money;
		    var mitPrec = $(".pago").data('premio').mitPrec;
		    var dmaxMoney = $(".pago").data('premio').dmaxMoney;
		    var dmoney = $(".pago").data('premio').dmoney;

		    var gtis = "";
		    var mprecio = "";
		    var moneda = "";
		    var j = 0;
		    
		    if ($("input[name=opcion]:checked").val() == 2 || ($("input[name=opcion]:checked").val() == 1 && parseFloat(dmoney) <= parseFloat(dmaxMoney))) {
		    	if (money != 0 && money != "0" && money != "" && money != "0.0") {
			      moneda = " de S/. " + money;
			      j++;
			    }
			    if (apGratis != 0 && apGratis != "0" && apGratis != "") {
			      if (j == 1) {
			        gtis = " | ";
			      }
			      gtis = gtis + apGratis + " jugadas gratis ";

			      j++;
			    }
			    if (mitPrec != 0 && mitPrec != "0" && mitPrec != "") {
			      if (j >= 1) {
			        mprecio = " y ";
			      }
			      mprecio = mprecio + mitPrec + " jugadas a mitad de precio (2x1)";
			    }
			    //var txt = "Cuentas con un premio " + moneda + "" + gtis + "" + mprecio + ".\n\n";
			    var txt = "<div style='font-family:Arial, Helvetica, sans-serif;font-size:11px;text-align:justify;'><div style='color:#0283bc;font-weight:bold;'>TIENES PREMIOS DE</div>";
			    if (money != null && money != "" && money != "0" && money != "0.00") {
		            txt += "<div>- <span style='font-weight:bold;'>S/. " + money + "</span>. ";
		            txt += "Se cargará automáticamente al saldo de tu Cuenta La Tinka.</div>";
		        }
			    if (apGratis != null && apGratis != "" && apGratis != "0") {
			    	txt += "<div>- <span style='font-weight:bold;'>" + apGratis + ((apGratis > 1) ? " jugadas gratis" : " jugada gratis") + "</span>.</div>";
			    }
			    if (mitPrec != null && mitPrec != "" && mitPrec != "0") {
			    	txt += "<div>- <span style='font-weight:bold;'>" + mitPrec + ((mitPrec > 1) ? " jugadas de 2x1" : " jugada de 2x1") + "</span>. Se realizará 50% en jugadas gratis y 50% en jugadas pagadas." + "</div>";
		        }
			    txt += "<div>";
			    if (apGratis != 0 && apGratis != "0" && apGratis != "") txt += "Todas las jugadas gratis se generaran al azar automaticamente.\n";
			    if (mitPrec != 0 && mitPrec != "0" && mitPrec != "") txt += "Todas las jugadas 2x1 se generaran al azar automaticamente (50% gratis y 50% pagadas que se restaran de tu saldo).\n";
			    //if (money != 0 && money != "0" && money != "" && money != "0.0") txt += "El premio monetario será cargado al saldo de tu cuenta Intralot Virtual.\n";
			    //if (money != 0 && money != "0" && money != "" && money != "0.0") txt += "\nPresiona ACEPTAR para sumar el premio a tu saldo";
			    if (apGratis != 0 && apGratis != "0" && apGratis != "") txt += ", generar todas la jugadas gratis";
			    if (mitPrec != 0 && mitPrec != "0" && mitPrec != "") txt += "y 2x1 al azar, y cobrar las jugadas 2x1.";
			    txt += "</div>";
			    /*
			    txt += "\nSI DESEA COBRARLO EN EFECTIVO, presiona CANCELAR\n" +
			      "e imprime el boleto haciendo clic en el icono de la columna Ver.\n" +
			      "Acercate a un punto de venta con la impresión \n" +
			      "de tu boleto para cobrar tu premio en efectivo.";
			    */
			    jConfirm(txt, "Cobrar en línea", function (r) {
			      if (r) {

			        pagoPremio(gameId, parameterId)

			      }
			    })
		    } else jAlert("El máximo premio para cobrar es de S/." + dmaxMoney.replace(".0","") + ". Para premios mayores a este monto, selecciona la opción Cobrar en el Punto de Venta", "ERROR", null);
  })
		  
  $('.npago').on('click', function () {
    var parameterId = $(".npago").data('premio').parameterId;
    var gameId = $(".npago").data('premio').id;
    var apGratis = "";
    var money = $(".npago").data('premio').money;
    var maxMoney = $(".npago").data('premio').maxMoney;
    var dmoney = $(".npago").data('premio').dmoney;
    var dmaxMoney = $(".npago").data('premio').dmaxMoney;
    var mitPrec = "";
    var frAmount = "";
    var totalOption2x1Amount = 0;
    var cashPrize = ($(".npago").data('premio').cash != null) ? $(".npago").data('premio').cash : 0;
    var flag = false;
    var group = "";
    var mensaje = "";
    //var coption = "";
    desist = false;
    if ($("input[name=opcion]:checked").val() == 2 || ($("input[name=opcion]:checked").val() == 1 && parseFloat(dmoney) <= parseFloat(dmaxMoney))) {
      if (cashPrize != null && cashPrize == 1 && $("input[name=opcion]:checked").length == 0) {
        jAlert("Debes elegir una forma de cobrar tus premios en efectivo.", "ERROR", null);
        cashPrize = 0;
      } else {
        //coption = (cashPrize != null && cashPrize==1)?$("input[name=opcion]:checked").val():"";
        //jAlert("Eligió la opción:"+$("input[name=opcion]:checked").val(), "ERROR", null);
        cashPrize = (cashPrize == 1 && $("input[name=opcion]:checked").val() == 2) ? 1 : 0;
        $.ajax({
          type: "post",
          url: "premios_juegos.html",
          data: "parameterId=" + parameterId + "&idGame=" + gameId,
          dataType: "text",
          global: false,
          async: false,
          success: function (e) {
            var cadena = "";
            if (e != null && e != "") {
              cadena = e.split(";");
              mensaje = (cadena[0].trim() != "null") ? cadena[0].trim() : "";
              //alert(mensaje);
              if (mensaje == "OK") {
                flag = true;
                money = cadena[1].trim();
                totalOption2x1Amount = cadena[2].trim();
                apGratis = parseFloat(cadena[3].trim());
                mitPrec = parseFloat(cadena[4].trim());
                frAmount = cadena[5].trim();
                group = cadena[6].trim();
              }
            }
          }
        });
        if (flag) {
          var txt = "<div style='font-family:Arial, Helvetica, sans-serif;font-size:11px;text-align:justify;'><div style='color:#0283bc;font-weight:bold;'>TIENES PREMIOS DE</div>";
          if (money != null && money != "" && money != "0" && money != "0.00") {
            txt += "<div>- <span style='font-weight:bold;'>S/. " + money + "</span>. ";
            //if(coption == 2) {
            if (cashPrize == 1) {
              txt += "Se generarán boletos con montos predefinidos hasta completar el monto total a liquidar.";
              if ((apGratis == null || apGratis == "" || apGratis == "0") && (mitPrec == null || mitPrec == "" || mitPrec == "0")) txt += "</br>Ingresa a la sección Premios de tu Cuenta para imprimirlos.</div>";
            } else txt += "Se cargará automáticamente al saldo de tu Cuenta La Tinka.</div>";
            flag = true;
          }
          if (apGratis != null && apGratis != "" && apGratis != "0" && (frAmount == null || frAmount == "" || frAmount == "0" || frAmount == "0.00")) {
            txt += "<div>- <span style='font-weight:bold;'>" + apGratis + ((apGratis > 1) ? " jugadas gratis" : " jugada gratis") + "</span>.</div>";
          }
          if (frAmount != null && frAmount != "" && frAmount != "0" && frAmount != "0.00") {
            txt += "<div>- <span style='font-weight:bold;'>S/. " + frAmount + "</span>. Equivalente a jugadas gratis se cargará automáticamente al Saldo para jugar Kábala.</div>";
          }
          if (mitPrec != null && mitPrec != "" && mitPrec != "0") {
            txt += "<div>- <span style='font-weight:bold;'>" + mitPrec + ((mitPrec > 1) ? " jugadas de 2x1" : " jugada de 2x1") + "</span>. Se realizará 50% en jugadas gratis y 50% en jugadas pagadas: <span style='font-weight: bold;'>S/. " + totalOption2x1Amount + "</span>.</div>";
          }
          if (group != null && group != "" && (frAmount == null || frAmount == "" || frAmount == "0" || frAmount == "0.00")) {
            arrGroup = group.split("||");
            txt += "<div id='award-list'>" + awardList() + "</div>";
          }
          if (mitPrec != null && mitPrec != "" && mitPrec != "0" && apGratis != null && apGratis != "" && apGratis != "0") {
            txt += "Las jugadas que aparecen como premio 2x1, están repartidas, la mitad en jugadas gratis y la otra mitad, en jugadas con costo, por " +
              "lo que para poder cobrar dichas jugadas 2x1, deberás contar con saldo suficiente en tu cuenta, recargar el saldo suficiente o permitir " +
              "que éste costo se descuente de tus premios en efectivo. Sólo tienes una oportunidad para cobrar la totalidad de tus jugadas gratis y " +
              "2x1, y caduca a los 180 días calendario siguientes luego de haber sido realizado el sorteo donde obtuviste dichas jugadas de premio." +
              "<ul style='margin:0;padding:12px 0 12px 12px;'>" +
              "<li>Si tienes saldo mínimo para cobrar tus jugadas 2x1, selecciona en <b>Paso 1: “Todas las jugadas gratis y 2x1”</b> y presiona el botón <b>“Continuar”.</b></li>" +
              "<li>Si no deseas cobrar tus jugadas 2x1, selecciona en <b>Paso 1: “Sólo jugadas gratis”</b> y presiona el botón <b>“Continuar”</b>. Al hacer esto, renuncias a tus jugadas 2x1, perdiendo el derecho al cobro de dichas jugadas.</li>" +
              "<li>Si deseas cargar saldo para poder cobrar tus jugadas 2x1, presiona el botón <b>“Ir a cargar saldo”</b>.</li>" +
              "<li>Si deseas salir para cobrar todos tus premios en otro momento presiona el botón <b>“Cancelar”</b>.</li>" +
              "</ul>" +
              "<b>IMPORTANTE:</b> Para generar tus jugadas de manera satisfactoria deberás presionar el botón “FINALIZAR”, al cierre del proceso, caso contrario las jugadas escogidas no serán procesadas.</div>" +
              "<div style='padding:12px 0 0 0;color:#0283bc;font-weight:bold;'>PASO 1: SELECCIONA LOS NÚMEROS DE TUS JUGADAS EN LINEA AHORA</div><div style='padding:5px 0 5px 0;'>" +
              "<input type='checkbox' id='option2x1' onclick='return optionChange(this);' style='margin:0 7px 0 0;' checked='checked' />" +
              "<label style='font-weight:bold;vertical-align:top;line-height:14px'>Todas las jugadas gratis y 2x1.</label>" +
              "<input type='checkbox' id='optionfree' onclick='return optionChange(this);' style='margin:0 7px 0 30px;' />" +
              "<label style='font-weight:bold;vertical-align:top;line-height:14px'>Sólo jugadas gratis.</label>" +
              "</div>";
          } else if ((apGratis == null || apGratis == "" || apGratis == "0") && mitPrec != null && mitPrec != "" && mitPrec != "0") {
            txt += "Las jugadas que aparecen como premio 2x1, están repartidas, la mitad en jugadas gratis y la otra mitad, en jugadas con costo, por " +
              "lo que para poder cobrar dichas jugadas 2x1, deberás contar con saldo suficiente en tu cuenta, recargar el saldo suficiente o permitir " +
              "que éste costo se descuente de tus premios en efectivo. Sólo tienes una oportunidad para cobrar la totalidad de tus jugadas gratis y " +
              "2x1, y caduca a los 180 días calendario siguientes luego de haber sido realizado el sorteo donde obtuviste dichas jugadas de premio." +
              "<ul style='margin:0;padding:12px 0 12px 12px;'>" +
              "<li>Si tienes saldo mínimo para cobrar tus jugadas 2x1, selecciona en <b>Paso 1: “Todas las jugadas gratis y 2x1”</b> y presiona el botón <b>“Continuar”.</b></li>" +
              "<li>Si no deseas cobrar tus jugadas 2x1, selecciona en <b>Paso 1: “No deseo cobrar las jugadas 2x1”</b> y presiona el botón <b>“Continuar”</b>. Al hacer esto, renuncias a tus jugadas 2x1, perdiendo el derecho al cobro de dichas jugadas.</li>" +
              "<li>Si deseas cargar saldo para poder cobrar tus jugadas 2x1, presiona el botón <b>“Ir a cargar saldo”</b>.</li>" +
              "<li>Si deseas salir para cobrar todos tus premios en otro momento presiona el botón <b>“Cancelar”</b>.</li>" +
              "</ul>" +
              "<b>IMPORTANTE:</b> Para generar tus jugadas de manera satisfactoria deberás presionar el botón “FINALIZAR”, al cierre del proceso, caso contrario las jugadas escogidas no serán procesadas.</div>" +
              "<div style='padding:12px 0 0 0;color:#0283bc;font-weight:bold;'>PASO 1: SELECCIONA LOS NÚMEROS DE TUS JUGADAS EN LINEA AHORA</div><div style='padding:5px 0 5px 0;'>" +
              "<input type='checkbox' id='option2x1' onclick='return optionChange(this);' style='margin:0 7px 0 0;' checked='checked' />" +
              "<label style='font-weight:bold;vertical-align:top;line-height:14px'>Todas las jugadas 2x1.</label>" +
              "<input type='checkbox' id='optionfree' onclick='return optionChange(this);' style='margin:0 7px 0 30px;' />" +
              "<label style='font-weight:bold;vertical-align:top;line-height:14px'>No deseo cobrar las jugadas 2x1.</label>" +
              "</div>";
          } else if ((mitPrec == null || mitPrec == "" || mitPrec == "0") && apGratis != null && apGratis != "" && apGratis != "0" && (frAmount == null || frAmount == "" || frAmount == "0" || frAmount == "0.00")) {
            txt += "Sólo tienes una oportunidad para cobrar la totalidad de tus jugadas gratis y caduca a los 180 días calendario siguientes luego de haber sido realizado el sorteo donde obtuviste dichas jugadas de premio.<br/><br/>" +
              "<b>IMPORTANTE:</b> Para generar tus jugadas de manera satisfactoria deberás presionar el botón “FINALIZAR”, al cierre del proceso, caso contrario las jugadas escogidas no serán procesadas.</div>" +
              "<div style='padding:12px 0 0 0;color:#0283bc;font-weight:bold;'>PASO 1: SELECCIONA LOS NÚMEROS DE TUS JUGADAS EN LINEA AHORA</div>";
          }
          if (money != null && money != "" && money != "0" && money != "0.00" && (apGratis == null || apGratis == "" || apGratis == "0") && (mitPrec == null || mitPrec == "" || mitPrec == "0")) {
            jConfirm(txt, "Cobrar en línea", function (r) {
              if (r) {
                toAward(gameId, parameterId, desist, money, apGratis, mitPrec, frAmount, cashPrize);
              }
            })
          } else {
            jAwards(txt, "Cobrar en línea", function (r) {
              if (r) {
                toAward(gameId, parameterId, desist, money, apGratis, mitPrec, frAmount, cashPrize);
              }
            }, ((mitPrec != null && mitPrec != "" && mitPrec != "0") ? (function (s) {
              if (s) {
                toAward(0, null, null, null, null, null, null);
              }
            }) : null))
          }
        } else jAlert((mensaje != "") ? mensaje + "<br/>Vuelva a intentar en unos minutos." : "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.", "ERROR", null);
      }
    } else jAlert("El máximo premio para cobrar es de S/." + maxMoney.replace(".0","") + ". Para premios mayores a este monto, selecciona la opción Cobrar en el Punto de Venta", "ERROR", null);
  })

  $('.advais').on('click', function () {

    var gameId = $(".advais").data('premio').id;
    var apGratis = $(".advais").data('premio').apGratis;
    var money = $(".advais").data('premio').money;
    var mitPrec = $(".advais").data('premio').mitPrec;

    var gtis = "";
    var mprecio = "";
    var moneda = "";

    if (money != 0 && money != "0" && money != "" && money != "0.0") {
      moneda = " de S/. " + money;
    }
    if (apGratis != 0 && apGratis != "0" && apGratis != "") {
      jAlert("Solo puede retirar premios en efetivo por este medio");
      return;
    }
    if (mitPrec != 0 && mitPrec != "0" && mitPrec != "") {
      jAlert("Solo puede retirar premios en efetivo por este medio");
      return;
    }

    jConfirm("Cuentas con un premio " + moneda + "" + gtis + "" + mprecio +
      "\n\nPresiona ACEPTAR para transferir el premio monetario a tu cuenta Jet Point\n" +
      "\nSI DESEA COBRARLO EN EFECTIVO o CARGAR EL PREMIO A TU CUENTA LA TINKA, presiona CANCELAR\n", "Cargar a tu cuenta Jet Point",
      function (r) {

        if (r) {

          var gameId = $(".advais").data('premio').id;
          var parameterId = $(".advais").data('premio').parameterId;

          $.ajax({
            type: "POST",
            url: "payAwardMoneyAdvais.html",
            dataType: "text",
            data: "idGame=" + gameId + "&parameterId=" + parameterId,
            global: false,
            async: false,
            success: function (e) {
              if (e != null && e != "" && e != "null") {
                var cadena = (e + "").split(";");
                var mensaje = cadena[0].trim();
                if (mensaje == "OK") {
                  var amount = cadena[1].trim();
                  var transactionId = cadena[2].trim();
                  var advaisURL = cadena[3].trim();
                  var redireccion = advaisURL + "?par=" + transactionId;
                  var advaisWin = window.open(redireccion, "_blank");

                  jAlert("Se ha cobrado " + amount + " del premio para abonarse en Jet Point " + transactionId, null);

                  $(parent.location).attr('href', 'mi-cuenta.html');
                  return true;
                } else {
                  jAlert(mensaje, null);
                }
              } else {
                jAlert("No se puede cobrar por este medio", null);
              }
            }
          })

        }
      })
  })
};
$(premio);

function pagoPremio(gameId, parameterId) {

  var money = ""; //$(".pago").data('premio').money;
  //var gameId = $(".pago").data('premio').id;
  //var parameterId = $(".pago").data('premio').parameterId;

  /*var nameGame = "general";
  if (gameId == 164) {
      nameGame = "ganadiario"
  }
  if (gameId == 42) {
      nameGame = "kabala"
  }
  if (gameId == 41) {
      nameGame = "tinka"
  }
  if (gameId == 163) {
      nameGame = "Super3"
  }
  if (gameId == 4) {
      nameGame = "Ganagol"
  }*/

  $.ajax({
    type: "POST",
    url: "payAwardMoney.html", //url: "payAwardMoney" + nameGame + ".html",
    dataType: "text",
    data: "idGame=" + gameId + "&parameterId=" + parameterId,
    global: false,
    async: false,
    success: function (e) {

      var cadena = (e + "").split(";");
      var mensaje = cadena[0].trim();
      if (mensaje == "OK") {
        money = cadena[1];
        tId = cadena[3];
        apGratis = cadena[4];
        mitPrec = cadena[5];
        var moneda = "";
        var gtis = "";
        var mprecio = "";
        var tcam = "";

        var i = 0;
        if (money != "0" && money != "0.0" && money != "" && money != " " && money != null && money.length != 0 && money != 0 && money != 0.0) {
          moneda = "S/. " + money;
          i++;
        }
        if (apGratis != "0" && apGratis != "0.0" && apGratis != "" && apGratis != " " && apGratis != null && apGratis.length != 0 && apGratis != 0 && apGratis != 0.0) {
          if (i == 1)
            gtis = " | ";
          gtis = gtis + apGratis + " ticket gratis ";
          i++;
        }
        if (mitPrec != "0" && mitPrec != "0.0" && mitPrec != "" && mitPrec != " " && mitPrec != null && mitPrec.length != 0 && mitPrec != 0 && mitPrec != 0.0) {
          if (i >= 1)
            mprecio = "|";
          mprecio = mprecio + mitPrec + " pagado (2x1)";
          i++;
        }

        if (tId != "" && tId != " " && tId != "null" && tId != null && tId.length != 0) {
          tcam = "\n Su Ticket de Cambio es " + tId;
        }

        jAlert("Tu premio ha sido cobrado: " + moneda + gtis + mprecio + tcam, null, function (r) {
          if (r) {
            $(parent.location).attr('href', 'mi-cuenta.html')
          }
        });
      } else {
        jAlert(cadena[0], null, function (r) {
          if (r) {
            $(parent.location).attr('href', 'mi-cuenta.html')
          }
        })
      }
    }
  })
}

function pagoPremioMonetario(gameId, parameterId) {
  var money = "";
  var mensaje = "";
  var tId = "";
  $.ajax({
    type: "POST",
    url: "pago_premio.html",
    dataType: "text",
    data: "dato=" + parameterId + "&desist=" + top.sdesist + "&credit=" + top.scredit + "&game=" + gameId,
    global: false,
    async: false,
    success: function (e) {
      var fila = e.split("#");
      for (var n = 0; n < fila.length; n++) {
        var items = fila[n].split("|");
        var procesos = items[4].split("&");
        if (n == 0) {
          mensaje = procesos[0].trim();
          money = procesos[2].trim();
        } else {
          if (procesos[0].trim() == "TC") tId = procesos[1].trim();
        }
      }
    }
  })
  var moneda = "";
  var tcam = "";
  if (mensaje == "OK") {
    var i = 0;
    if (money != "0" && money != "0.0" && money != "" && money != " " && money != null && money.length != 0 && money != 0 && money != 0.0) {
      moneda = "S/. " + money;
      i++;
    }
    if (tId != "" && tId != " " && tId != "null" && tId != null && tId.length != 0) {
      tcam = "\n Su Ticket de Cambio es " + tId;
    }
    jAlert("Tu premio ha sido cargado a tu saldo.\n Tu nuevo saldo es: " + moneda + tcam, null, function (r) {
      if (r) {
        $("#clientSale-amount", window.parent.document).text(money);
        $(".account-balance h4 b", window.parent.document).text("S/ " + money);
        //$('#tab-item_4', window.parent.document).children('.text-item-2').text("Disponible S/." + money);
        $('#content-tab-item_4', window.parent.document).find('.item-title-2').text("Disponible S/." + money);
        top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
        $(parent.location).attr('href', 'mi-cuenta.html')
        $('#tab-item_5', window.parent.document).trigger('click');
      }
    });
  } else {
    jAlert(mensaje, null, function (r) {
      if (r) {
        $(parent.location).attr('href', 'mi-cuenta.html#premios');
      }
    })
  }
}
/*function toAward(gameId) {
    if (gameId == 164) {
        top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
        $(parent.location).attr('href', 'premio_ganadiario.html');
    }
    if (gameId == 108) {
    }//teapuesto
    if (gameId == 4) {
    }//ganagol
    if (gameId == 42) {
        top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
        $(parent.location).attr('href', 'premio_kabala.html');
    }//kabala
    if (gameId == 44) {
    }//tinkaMegagol
    if (gameId == 163) {
    }//super3
    if (gameId == 41) {
        top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
        $(parent.location).attr('href', 'premio_tinka.html');
    }//tinka
    if (gameId == 1121) {
    }//kinelo
    if (gameId == 715) {
    }//click y gana
    if (gameId == 42) {
    }//kalaba
}*/
function toAward(g, p, d, m, ag, mp, fa, c) {
  $("#popup_cancel", parent.window.document).trigger("click");
  if (cnt > 0 && (g == 41 || g == 42 || g == 164)) {
    if ((mp != null && mp != "" && mp != "0") || (ag != null && ag != "" && ag != "0")) {
      top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
      $(parent.location).attr('href', 'verifica_premio.html?g=' + g + '&d=' + d + '&c=' + c);
    }
  } else if (cnt == 0 && g > 0) {
    if (m != null && m != "" && m != "0" && m != "0.00") {
      if (arrGroup.length == 0) {
        //pagoPremio(g,p);
        pagoPremioMonetario(g, p);
      } else {
        var txt = "<div style='font-family:Arial, Helvetica, sans-serif;font-size:11px;text-align:justify;'><div style='color:#0283bc;font-weight:bold;'>TIENES PREMIOS DE</div>" +
          "<div>- <span style='font-weight:bold;'>S/. " + m + "</span>. Se cargará automáticamente al saldo de tu Cuenta La Tinka.</div>";
        jConfirm(txt, "Cobrar en línea", function (r) {
          if (r) {
            //pagoPremio(g,p);
            pagoPremioMonetario(g, p);
          }
        })
      }
    } else if (fa != null && fa != "" && fa != "0" && fa != "0.00") {
      pagoPremioMonetario(g, p);
    }
  } else if (g == 0) {
    top.dhtmlwindow.close(top.document.getElementById("resultboxAward"));
	top.document.getElementById("resultboxAward").classList.add("resultboxAward-index");
	top.document.getElementById("dhtmlwindowoverlay").classList.add("dhtmlwindowoverlay-index");
    $('#tab-item_4', parent.window.document).trigger('click')
  }
}


$.fn.myGameAwards = function (opciones) {
  var defec = {
    list: [],
    columns: [{
      title: "BOLETO Nº",
      width: "90px",
      left: "10px",
      align: "center"
    }, {
      title: "JUGADAS",
      width: "70px",
      left: "100px",
      align: "center"
    }, {
      title: "CONCEPTO",
      width: "170px",
      left: "170px",
      align: "center"
    }, {
      title: "SORTEOS",
      width: "70px",
      left: "340px",
      align: "center"
    }, {
      title: "COSTO",
      width: "80px",
      left: "410px",
      align: "center"
    }, {
      title: "<img src='layer-view-image/common/check-white.png' width='18' height='14' />",
      width: "75px",
      left: "490px",
      align: "center"
    }]
  };
  $.extend(defec, opciones);
  $("#grilla_my_awards").html(dibuja_grilla());


  function dibuja_grilla() {
    var dato = defec.columns;
    var awards = defec.awards;
    var count_column = 0;
    var cabecera = "<div class='columns-grid' >";
    for (var i in dato) {
      cabecera += "<div class='column' style='" + "left:" + dato[i].left + ";" + "width:" + dato[i].width + ";" + "text-align:" + dato[i].align + ";'>" + dato[i].title + "</div>";
      count_column++
    }
    cabecera += "</div><div id='paging' class='paging' >";
    var content = "";
    var contador = 0;
    var count_row = 0;
    var state = 0;

    var list = awards.group;

    if (awards != null && awards != "") {

      state = parseFloat(awards.state);

      if (list != null && list != "") {

        (list).map(function (a, b) {
          var classCss = "row-grid2";
          
          if (b == state) classCss += " tractual";
          
          content += "<div class='state-row_2 " + classCss + "'>";
          content += "<div class='row' style='" + "left:" + dato[0].left + ";" + "width:" + dato[0].width + ";" + "text-align:" + dato[0].align + ";'>" + (b + 1) + ' ' + a.prizeType + "</div>";
          content += "<div class='row' style='" + "left:" + dato[1].left + ";" + "width:" + dato[1].width + ";" + "text-align:" + dato[1].align + ";'>" + a.ticketGroups + "</div>";
          content += "<div class='row' style='" + "left:" + dato[2].left + ";" + "width:" + dato[2].width + ";" + "text-align:" + dato[2].align + ";'>" + a.saleType + "</div>";
          content += "<div class='row' style='" + "left:" + dato[3].left + ";" + "width:" + dato[3].width + ";" + "text-align:" + dato[3].align + ";'>" + a.ticketDraws + "</div>";
          content += "<div class='row' style='" + "left:" + dato[4].left + ";" + "width:" + dato[4].width + ";" + "text-align:" + dato[4].align + ";'>" + a.amount + "</div>";

          if (b < state) content += "<div class='row' style='" + "left:" + dato[5].left + ";" + "width:" + dato[5].width + ";" + "text-align:" + dato[5].align + ";margin-left: 20px;border-right: none;'><img src='layer-view-image/common/check-orange.png' width='18' height='14' /></div>";

          content += "</div>";

          if (b == state) {
            groups = parseFloat(a.ticketGroups);
            d = "<b class='font-opac-bold'>BOLETO Nº " + (b + 1) + (a.prizeType != '' ? ' ' + a.prizeType : '') + ":</b></br> Selecciona " + a.ticketGroups + " " + (groups > 1 ? 'jugadas' : 'jugada') + " <span style='text-transform:lowercase;'>" + a.saleType + "</span> que " + (groups > 1 ? 'participan' : 'participa') +
              " en " + a.ticketDraws + " " + (parseFloat(a.ticketDraws) > 1 ? 'sorteos' : 'sorteo') + " y haz clic en el botón OK.";

            $("#box-play-a").removeClass("game-played");
            $("#box-play-b").removeClass("game-played");
            $("#box-play-c").removeClass("game-played");
            $("#box-play-d").removeClass("game-played");

            $("#box-play-a").removeClass("disabled");
            $("#box-play-b").removeClass("disabled");
            $("#box-play-c").removeClass("disabled");
            $("#box-play-d").removeClass("disabled");

            $("#box-play-a").trigger('click');

            if (groups == 1) {
              $("#box-play-a").removeClass("disabled");
              $("#box-play-b").addClass("disabled");
              $("#box-play-c").addClass("disabled");
              $("#box-play-d").addClass("disabled");

            } else if (groups == 2) {
              $("#box-play-a").removeClass("disabled");
              $("#box-play-b").removeClass("disabled");
              $("#box-play-c").addClass("disabled");
              $("#box-play-d").addClass("disabled");

            } else if (groups == 3) {
              $("#box-play-a").removeClass("disabled");
              $("#box-play-b").removeClass("disabled");
              $("#box-play-c").removeClass("disabled");
              $("#box-play-d").addClass("disabled");
            } else if (groups == 4) {
              $("#box-play-a").removeClass("disabled");
              $("#box-play-b").removeClass("disabled");
              $("#box-play-c").removeClass("disabled");
              $("#box-play-d").removeClass("disabled");
            }
          }
        });


        if (list.length == state) {
          d = "Has seleccionado todas tus jugadas correctamente. </br> Haz clic en el botón <b>FINALIZAR</b>.";
          $("#box-play-a").addClass("disabled");
          $("#box-play-b").addClass("disabled");
          $("#box-play-c").addClass("disabled");
          $("#box-play-d").addClass("disabled");
          $("#finalize").removeClass("btn-disabled-award");
          $("#finalize").addClass("button-orange");
          $("#detail-add-info").addClass("disabled");
          $("#detail-add-btn").addClass("disabled");
          $("#info-final-panel").removeClass("disabled");
          $("#playing-panel").addClass("disable-all");

          $("#info-final-panel").html(d);
        } else {
          $("#info-final-panel").addClass("disabled");
          $("#detail-add-info").removeClass("disabled");
          $("#detail-add-btn").removeClass("disabled");
          $("#info-add-panel").html(d);
        }
      }

      awards.state = state + 1;
      $("#game-award").data('award', awards);
    } else {
      $("#box-play-a").addClass("disabled");
      $("#box-play-b").addClass("disabled");
      $("#box-play-c").addClass("disabled");
      $("#box-play-d").addClass("disabled");
      $("#finalize").removeClass("button-orange");
      $("#finalize").addClass("btn-disabled-award");

      
      content += "<span>No se han encontrado jugadas. Vuelva a intentarlo.</span>";
    }
    if (parseFloat(awards.balance) > 0 && parseFloat(awards.cash) == 0) $("#award-amount-panel").html("<div class='bold-type-finalize font-opac-bold'>PREMIO MONETARIO: S/. " + awards.balance + "</div>Se cargará automáticamente al saldo.");
    else if (parseFloat(awards.balance) > 0 && parseFloat(awards.cash) > 0) $("#award-amount-panel").html("<div class='bold-type-finalize font-opac-bold'>PREMIO MONETARIO: S/. " + awards.balance + "</div>Se generarán uno o varios boletos con montos predefinidos hasta completar el monto total a liquidar.");
    else $("#award-amount-panel").html("");

    return cabecera + content + "</div>"

  }

}

function awardPaid() {
  var c;
  var d = "";
  var n = 0;
  var s = "";
  var t = "";
  c = $("#game-award").data('award');
  t = "";
  if (parseFloat(c.gameid) == 41) t += "<span class='font-opac-bold'>JUGADAS GRATIS Y/O 2X1</span></br>";
  else t += "<span>JUGADAS GRATIS</span></br>";

  t += '<div id="grilla_my_awards" style="margin-top:10px;"></div>';

  $("#award-group-panel").html(t);

  sdesist = c.desist;
  scredit = c.cash;

  $('#grilla_my_awards').myGameAwards({
    awards: c,
  });
 
}

function toFechazaLotos() {
  if (top.isFechazaLotos) {
    loadPage('home_fechazalotos_visitor_action.do?method=viewHome');
  } else jAlert("Disponible próximamente.", null);
}

function toPollayPollon() {
  return;
  // loadPage('home_pollaypollon_visitor_action.do?method=viewHome');
}

function toIflexLogged(a) {

  window.open(a, "_self");
  $("#form-sign-in").resetForm();
  $("#form-sign-in").lockForm(false);

  $("#user-kept").addClass("disabled");
  $("#user-logout").addClass("disabled");
  $("#user-login").removeClass("disabled");

}


var iflexWin = null;

function redirectTeApuesto(a, b) {
  if (a != null) {

  }
}


function toIflex() {
  if (iflexWin != null) iflexWin.close();

  // <game provider base url>?playerId={id}&language={language code}&operatorId={id representing Ilot Peru in the system}&authToken={Token}¤cy={currency}

  var baseUrl = "";
  var playerId = "";
  var language = "";
  var operatorId = "";
  var authToken = "";
  var currency = "";
  var flag = false;
  $.ajax({
    type: "post",
    url: "iflex_launch.html",
    data: "channel=1",
    dataType: "text",
    global: false,
    async: false,
    success: function (e) {
      var cadena = "";
      if (e != null && e != "") {
        cadena = e.split("|");
        mensaje = (cadena[6].trim() != "null") ? cadena[6].trim() : "";
        baseUrl = cadena[0].trim();
        if (mensaje == "LOGGED") {
          flag = true;
          language = cadena[1].trim();
          operatorId = cadena[2].trim();
          currency = cadena[3].trim();
          playerId = cadena[4].trim();
          authToken = cadena[5].trim();
        }
      }
    }
  });
  if (flag === true) {
    var url = baseUrl + "?playerId=" + playerId + "&language=" + language + "&operatorId=" + operatorId + "&authToken=" + authToken + "&currency=" + currency;
    //console.log("url=["+url+"]");
    iflexWin = window.open(url, "_self");
  } else {
    //jAlert(mensaje, null);
    iflexWin = window.open(baseUrl, "_self");
  }
  return false;
}

function toGiromagico() {
  loadPage('home_giromagico_visitor_action.do?method=viewHome');
}
var cliyganaWin = null;

function toDemoClicYGana(stateportal) {
  if (cliyganaWin != null) cliyganaWin.close();
  cliyganaWin = window.open("home_clicygana_visitor_action.do?method=viewHomeDemo&stateportal=" + stateportal, "_blank");
  return false;
}

function toInicioClicYGana(stateportal, terms, termsobj) {
  if (cliyganaWin != null) cliyganaWin.close();
  cliyganaWin = window.open("home_clicygana_user_action.do?method=viewHome&stateportal=" + stateportal + "&terms=" + terms + "&termsobj=" + termsobj, "_blank");
  return false;
}
var deportesvirtualesWin = null;

function toDemoDeportesVirtuales(url, stateportal) {
  if (deportesvirtualesWin != null) deportesvirtualesWin.close();
  //deportesvirtualesWin = window.open("home_deportesvirtuales_visitor_action.do?method=viewHomeDemo&stateportal="+stateportal,"_blank");
  //return false;
  var options = "resizable=1,scrollbars=0,menubar=0,status=0,width=788,height=500";
  return deportesvirtualesWin = window.open(url + '/?lang=es&mode=demo', '_blank', options);
}

function toInicioDeportesVirtuales(url, token, stateportal, terms, termsobj) {
  if (deportesvirtualesWin != null) deportesvirtualesWin.close();
  //deportesvirtualesWin = window.open("home_deportesvirtuales_user_action.do?method=viewHome&stateportal="+stateportal+"&terms="+terms+"&termsobj="+termsobj,"_blank");
  //return false;
  var options = "resizable=1,scrollbars=0,menubar=0,status=0,width=788,height=500";
  return deportesvirtualesWin = window.open(url + '/?token=' + token + '&lang=es&mode=real', '_blank', options);
}

function callSecurity() {
  openWindowWithScrollsIf('informacion-seguridad.html', 'ajaxbox', 620, 450, "Información Sobre Seguridad");
}

function callPolicies() {
  openWindowWithScrollsIf('politicas-ventas.html', 'ajaxbox', 620, 400, "Política de Ventas por Internet");
}

function callTerms() {
  openWindowWithScrollsIf('terminos-condiciones.html', 'ajaxbox', 620, 450, "Términos y Condiciones - Clic&Gana");
}

function toViewGames() {
  var coteja = top.statecoteja;
  if (coteja == 0) {
    var usinfo = window.frames['ibody'].userInfo;
    if (usinfo == undefined) {
      usinfo = top.userInfo;
      top.userInfo = null;
      if (usinfo == "null") loadPage("login_action.do?method=viewFormLogout");
      else loadPage("welcome_action.do?method=viewFormWelcome");
    } else {
      if (usinfo == "null") loadPage("login_action.do?method=viewFormLogout");
      else loadPage("welcome_action.do?method=viewFormWelcome");
    }
  }
  if (coteja == 11)
    top.dhtmlwindow.open("tinka-compare-box", "iframe", "i.do?m=viewPopupTinkaCompareBets&tinkaCompareStateTitle=1&tinkamegabolCompareStateUri=1", "", "width=735,height=600,scrolling=1,center=1,resize=1");

  if (coteja == 21) //ganagol
    top.dhtmlwindow.open("ganagol-compare-box", "iframe", "i.do?m=viewPopupGanagolCompareBets&ganagolCompareStateTitle=1", "", "width=735,height=600,scrolling=1,center=1,resize=1");

  if (coteja == 31) //ganadiario
    top.dhtmlwindow.open("ganadiario-compare-box", "iframe", "i.do?m=viewPopupGanadiarioCompareBets&ganadiarioCompareStateTitle=1", "", "width=780,height=545,scrolling=1,center=1,resize=1");

  if (coteja == 41) //kabala
    top.dhtmlwindow.open("kabala-compare-box", "iframe", "i.do?m=viewPopupKabalaCompareBets&kabalaCompareStateTitle=1", "", "width=735,height=545,scrolling=1,center=1,resize=1");

  if (coteja == 51) //super3
    top.dhtmlwindow.open("super3-compare-box", "iframe", "i.do?m=viewPopupSuper3CompareBets&super3CompareStateTitle=1", "", "width=717,height=545,scrolling=1,center=1,resize=1");

  if (coteja == 61) //elreventon
    top.dhtmlwindow.open("reventon-compare-box", "iframe", "i.do?m=viewPopupReventonCompareBets&reventonCompareStateTitle=1", "", "width=724,height=599,scrolling=1,center=1,resize=1");

  if (coteja == 71) //fechaza
    top.dhtmlwindow.open("fechaza-compare-box", "iframe", "i.do?m=viewPopupFechazaLotosCompareBets&fechazaCompareStateTitle=1", "", "width=750,height=599,scrolling=1,center=1,resize=1");

  if (coteja == 81) //tinkamegabol
    top.dhtmlwindow.open("tinkamegabol-compare-box", "iframe", "i.do?m=viewPopupTinkaMegabolCompareBets&tinkamegabolCompareStateTitle=1&tinkaCompareStateUri=1", "", "width=735,height=600,scrolling=1,center=1,resize=1");

  if (coteja == 101) //kinelo
    top.dhtmlwindow.open("kinelo-compare-box", "iframe", "i.do?m=viewPopupKineloCompareBets&kineloCompareStateTitle=1&kineloCompareStateUri=1", "", "width=730,height=515,scrolling=1,center=1,resize=1");

  if (coteja == 102) //giromagico
    top.dhtmlwindow.open("giromagico-compare-box", "iframe", "i.do?m=viewPopupGiroMagicoCompareBets&giromagicoCompareStateTitle=1&giromagicoCompareStateUri=1", "", "width=555,height=515,scrolling=1,center=1,resize=1");

}

function callLastResults(r) {
  openWindowWithScrolls("i.do?m=viewResults&s=" + r, "ajaxbox", 800, 500, "Resultados Tinka");
}

function callOutResults(r) {
  var h = 0;
  var w = 0;
  var t = "";
  if (r == 4) {
    w = 700;
    h = 450;
    t = "Resultados Ganagol";
  } else if (r == 108) {
    w = 700;
    h = 450;
    t = "Resultados Te Apuesto";
  } else if (r == 13) {
    w = 700;
    h = 450;
    t = "Resultados El Revent�n";
  } else if (r == 41) {
    w = 590;
    h = 470;
    t = "Resultados Tinka";
  } else if (r == 42) {
    w = 590;
    h = 450;
    t = "Resultados Kabala";
  } else if (r == 164) {
    w = 590;
    h = 500;
    t = "Resultados Gana Diario";
  } else if (r == 163) {
    w = 590;
    h = 450;
    t = "Resultados Super 3";
  } else if (r == 716) {
    w = 580;
    h = 470;
    t = "Resultados Fechaza";
  } else if (r == 1121) {
    w = 610;
    h = 430;
    t = "Resultados Kinelo";
  } else if (r == 8103) {
    w = 610;
    h = 430;
    t = "Resultados Giro Mágico";
  }
  top.dhtmlwindow.open("resultbox", "iframe", "i.do?m=resultados&t=1&s=" + r, t, "width=" + w + ",height=" + h + ",scrolling=1,center=1,resize=1");
}

function callReportVPOS() {
  dhtmlwindow.open("resultbox", "iframe", "reporte_vpos.html", "Resultado del Comercio", "width=700,height=450,scrolling=1,center=1,resize=1", "recal");
}

function callHelpGame() {
  loadPage("html/ayuda.htm");
}

function outstandingGame() {
  toClicYGana("123_1")
}

function outstandingGame2() {
  toClicYGana("134_1")
}

function outstandingGame3() {
  toDeportesVirtuales()
}
//Comprueba si el primer caracter es numero
function isNumFirstCharacter(s) {
  var val = s.substring(0, 1);
  return isNaN(val)
}
//Comprueba version del IE
function verIE() {
  var _n = navigator,
    _w = window,
    _d = document;
  var version = "NA";
  var na = _n.userAgent;
  if (/msie/i.test(na) && (!_w.opera)) {
    if (_w.attachEvent && _w.ActiveXObject) {
      version = (na.match(/.+ie\s([\d.]+)/i) || [])[1];
      if (parseInt(version) == 7) {
        if (_d.documentMode) version = 8
      }
    }
  }
  return version
}
//Control de un clic
function messageProcess() {
  //if(!top.oneclick) {
  jAlert("Se esta procesando la operacion. Espere unos segundos.<br/><br/>Si no hay cambios luego de un tiempo prolongado, refresque la pagina y vuelva a intentarlo.", null);
  //	return false;
  //}
}
//Deshabilita el forward
function backButtonOverride() {
  setTimeout("backButtonOverrideBody()", 1);
}

function backButtonOverrideBody() {
  try {
    history.forward();
  } catch (e) {}
  setTimeout("backButtonOverrideBody()", 500);
}
//Deshabilita el menu emergente
//function oncontextmenuHandler() {return false;}
function oncontextmenuHandler(e) {
  var target = window.event ? window.event.srcElement : e ? e.target : null;
  if (target.type) {
    if (target.type != "text" && target.type != "textarea" && target.type != "password") return false;
    return true;
  } else return false
}

function noReturn() {
  return false
}
// document.oncontextmenu = oncontextmenuHandler;
// End -->
function floatFormat(number) {
  number = number += '';
  var x1 = '',
    x2 = '',
    rgx = /(\d+)(\d{3})/;
  if (number !== '') {
    var x = number.split('.');
    x1 = x[0];
    if (x[1] != undefined) {
      x[1] = x[1].length < 2 ? x[1] + '0' : x[1]
    } else {
      x[1] = '00'
    }
    x2 = x.length > 1 ? '.' + x[1] : '';
    while (rgx.test(x1)) {
      x1 = x1.replace(rgx, '$1' + ',' + '$2')
    }
  }
  return x1 + x2
}

function openKabalaCotejador() {
  var printwin_01 = dhtmlwindow.open("resultbox", "iframe", "Kabala_cotejador_jugada.html", "COTEJADOR KABALA", "width=630,height=630,scrolling=0,center=1,resize=1", "recal");
  $("#resultbox").css('z-index', 2147483000);
  try {
	  datalayerComboCotejar('¡Combos Kábala! No te pierdas ni un sorteo');
	  CotejaBoleto('Kabala');				
	} catch (e) {
		console.error(e);
	}
  
}

function openTinkaCotejador() {
  var printwin_02 = dhtmlwindow.open("resultbox", "iframe", "Tinka_cotejador_jugada.html", "COTEJADOR TINKA", "width=630,height=580,scrolling=0,center=1,resize=1", "recal");
  $("#resultbox").css('z-index', 2147483000);
  try {
	  datalayerComboCotejar('¡Combos Tinkeros! No te pierdas ni un sorteo');
	  CotejaBoleto('Tinka');				
	} catch (e) {
		console.error(e);
	}
  
//  console.log(openTinkaCotejador);
}

function openGanadiarioCotejador() {
  var printwin_03 = dhtmlwindow.open("resultbox", "iframe", "Ganadiario_cotejador_jugada.html", "COTEJADOR GANA DIARIO", "width=650,height=630,scrolling=0,center=1,resize=1", "recal");
  $("#resultbox").css('z-index', 2147483000);
  try {
	  	datalayerComboCotejar('¡Combos Gana Diario! No te pierdas ni un sorteo');
  		CotejaBoleto('Gana Diario');			
	} catch (e) {
		console.error(e);
	}

}

function openGanagolCotejador() {
  var printwin_04 = dhtmlwindow.open("resultbox", "iframe", "Ganagol_cotejador_jugada.html", "COTEJADOR GANAGOL", "width=630,height=840,scrolling=0,center=1,resize=1", "recal");
  $("#resultbox").css('z-index', 2147483000);
}

function openSuper3Cotejador() {
  var printwin_05 = dhtmlwindow.open("resultbox", "iframe", "Super3_cotejador_jugada.html", "COTEJADOR SUPER3", "width=654,height=481,scrolling=0,center=1,resize=1", "recal");
}

function reloadKaptcha() {
  $("#imgkaptcha").attr('src', 'Kaptcha.jpg?' + Math.floor(Math.random() * 100));
}
var vkflg = true;

function keyEnter() {
  if (getTarget().attr("id") == "password-client-header") $("#index-btnlogin").trigger("click");
  if (getTarget().attr("id") == "password-client") $("#home-btnlogin").trigger("click");
  removeKeyboard();
  vkflg = true;
}
//TA LA POLLA
function toLaPolla() {
	$.ajax({
        type: 'post',
        url: 'lapolla-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}
//TA V2 HOME
function toTAV2() {
	$.ajax({
        type: 'post',
        url: 'tav2-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}
function toDDVV() {
	$.ajax({
        type: 'post',
        url: 'ddvv-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}

function toJuegosVirtuales(producto) {
	$.ajax({
        type: 'post',
        url: 'juegos-virtuales-session.html',
        dataType: 'json',
        data: "producto="+producto
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}

function CotejaBoleto(game){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'cotejaBoleto',
	    'category': 'UI :: Coteja',
	    'action': game+' :: Click',  //Aquí incluir el nombre del juego  
	    'label': 'Coteja tu boleto'
	});
	
	var tag="cotejaBoleto";
	console.log("Taggin event: "+tag+", juego: "+game);

}

function cotejarOK(game){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'cotejarBoleto',
		    'category': 'UI :: Coteja',
		    'action': game+' :: Resultado', //Aquí incluir el nombre del juego 
		    'label': 'Cotejar OK' 
		});
		
		var tag="Cotejar OK";
		console.log("Taggin event: "+tag+", juego: "+game);				
	} catch (e) {
		console.error(e);
	}
}

function cotejaBoletoError(game, label){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'cotejaBoletoError',
		    'category': 'UI :: Coteja',
		    'action': 'Error :: '+game,  //Incluir el juego que corresponda
		    'label': label //Incluir mensaje de error
		});
		
		var tag="Coteja Boleto Error";
		console.log("Taggin event: "+tag+", juego: "+game+", etiqueta: "+label);		
	} catch (e) {
		console.error(e);
	}

}

function tagginAlAzar(game){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'alAzar',
	    'category': 'UI :: Jugar',
	    'action': game+' :: Click', // Incluir el nombre del juego que corresponda
	    'label': 'Al azar'
	});
	
	var tag=game+" - Al azar";
	console.log("Taggin event: "+tag);

}

function tagginPopupError(game,label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'popupError',
	    'category': 'UI :: Jugar',
	    'action': game+' :: Error',  // Incluir el nombre del juego que corresponda
	    'label': label // Aquí deberían indicar ‘Elegir bolillas’ o ‘Elegir combo’
	});
	
	var tag="popupError "+game;
	console.log("Taggin event: "+tag+", label: "+label);
}

function tagginEEaddToCart(game,nCombos, price){
	if(nCombos!=undefined && nCombos!=null && nCombos!=''){
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{
		        'name': game+' Combo '+ nCombos +' jugadas', // nombre del juego
		        'id': game.toLowerCase().split(" ")[0]+'C'+nCombos, // ID del juego
		        'price': price, // Precio del juego
		        'brand': 'Juegos', // Según slide 96
		        'quantity': '1', // Valor único para todos los juegos
		        'category': game      // Según slide 96
		       }]
		    }
		  }
		});
		
		var tag="EEaddToCart "+game;
		console.log("Taggin event: "+tag+", Combo: "+nCombos+", precio: "+price);
	}
}

function tagginJugadaNoProcesada(game, label) {
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: '+game,  //Indicar el juego donde sucedió el error
		    'label': label  //Enviar el mensaje de error que corresponda
		});
		var tag = game+" jugadaNoProcesada: "+label;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginTabCargarSaldo(label, flagEfectivo) {
	try {
		//No ejecutar al cargar el pupop cargar saldo
		if(label==="efectivoInterbank" && flagEfectivoInterbank==0){
			flagEfectivoInterbank=1;
			return;
		}
		//Ejecutar solo en el primer evento click en tab Efectivo, default: label==="efectivoInterbank"
		if(flagEfectivo!=null){
			if(flagEfectivoInterbank==1){
				flagEfectivoInterbank=2;
			}else{
				return;
			}			
		}
		
		var action = window.location.href;
		action=action.split('&')[1].split('/')[4].split('.')[0];
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'Click boton',
		    'category': 'UI :: Recarga',
		    'action': action,
		    'label': label
		});

		var tag = "tagginTabCargarSaldo "+action+" - "+label;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEaddToCart() {
	try {
		var price=parseInt($("#monto_visanet").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet Visa',
		        'id': 'int-visa',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		var tag = "tagginSaldoEEaddToCart, precio:  "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoEEcheckout() {
	try {
		var price=parseInt($("#monto_visanet").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet Visa',
		          'id': 'int-visa',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		var tag = "tagginSaldoEEcheckout, precio:  "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}


function tagginSaldoEEpurchase(id, price) {	
	try {		
		var lastIdTransaction=localStorage.getItem("lastIdTransaction");
		if(!(lastIdTransaction===id)){
			price=parseFloat(price).toFixed(2);
			var idTransaction="VS-"+id;
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			  'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': idTransaction,               //  Código de la transacción       
			        'revenue': price,    // Monto total cargado
			      },
			      'products': [{                            
			        'name': 'Recarga Internet Visa',   
			        'id': 'int-visa',
			        'price': price,       // Monto de la recarga
			        'brand': 'Saldo',
			        'quantity': '1',
			        'category': 'Recarga Saldo'
			       }]
			    }
			  }
			});

			localStorage.setItem("lastIdTransaction",id);
			var tag = "tagginSaldoEEpurchase, id de transaccion:  "+idTransaction+", precio: "+price;
			console.log("Taggin event: " + tag);
		}
		
	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEaddToCart() {
	try {		
		var price=parseInt($("#monto_bcp").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet BCP',
		        'id': 'int-bcp',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoBCPEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEremoveFromCart(price) {
	try {		
		
		price=parseFloat(price.split("/")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': 'Recarga Internet BCP',
		          'id': 'int-bcp',
		          'price': price,      // Indicar el monto a remover
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		
		var tag = "tagginSaldoBCPEEremoveFromCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEcheckout(price) {
	try {		
		price=parseFloat(price.split("/")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet BCP',
		          'id': 'int-bcp',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoBCPEEcheckout, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBCPEEpurchase(code, date, price) {
	try {
		date=(date.split(" ")[0]).split("/");
		date=date[2]+date[1]+date[0];
		var idTransaction="BC-"+code+date;
		price=parseFloat(price.split("/")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet BCP',   
		        'id': 'int-bcp',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoBCPEEpurchase, id de transaccion: "+idTransaction+", precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

var agrillaBCP=[];
function getGrillaBCP(){
	try{
		agrillaBCP=[];
		var igrillaBCP=$("#grillaBCP");
		var irows = $('#grillaBCP>tr');
		var icountRows = $('#grillaBCP>tr').length;
		for (var i = 1; i < icountRows; i++) {
			var price=irows[i].cells[0].innerHTML;	  
			var code=irows[i].cells[1].innerHTML;
			var date=irows[i].cells[2].innerHTML;
			var aobject=[];
			aobject["price"]=price;
			aobject["date"]=date;
			agrillaBCP[code]=aobject;		
		}
	}catch (e) {
		console.error(e);
	}	
}

function taggingCheckoutAndPurchaseBCP(){
	try{
		var fgrillaBCP=$("#grillaBCP");
		var rows = $('#grillaBCP>tr');
		var countRows = $('#grillaBCP>tr').length;
		
		for (var i = 1; i < countRows; i++) {	  
			var code=rows[i].cells[1].innerHTML;
			delete agrillaBCP[code];
		}
		
		for (var code in agrillaBCP) {
			var price=agrillaBCP[code]["price"];
			var date=agrillaBCP[code]["date"];			
			tagginSaldoBCPEEcheckout(price);
			tagginSaldoBCPEEpurchase(code, date, price);
		}
	}catch (e) {
		console.error(e);
	}
}

function tagginSaldoPEfectivoEEaddToCart() {
	try {
		var price=parseInt($("#monto_pagoefectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Pago Efectivo',
		        'id': 'int-pagoefectivo',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoPEfectivoEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoYAPEEEaddToCart() {
	try {
		var price=parseInt($("#monto_yape").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Yape',
		        'id': 'int-yape',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoYAPEEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoPLINEEaddToCart() {
	try {
		var price=parseInt($("#monto_plin").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Plin',
		        'id': 'int-plin',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoPLINEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoSPayEEaddToCart() {
	try {
		var price=parseInt($("#monto_safetypay").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Recarga Internet Safety Pay',
		        'id': 'int-safetypay',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoSPayEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEPEfectivoEEaddToCart() {
	try {
		var price=parseInt($("#monto_pagoefectivo_efectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Efectivo Pago Efectivo',
		        'id': 'efe-pagoefectivo',
		        'price': price,    //Indicar el monto a cargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoEEPEfectivoEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEESPayEEaddToCart() {
	try {
		var price=parseInt($("#monto_safetypay_efectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Efectivo Safety Pay',
		        'id': 'efe-safetypay',
		        'price': price,    // Indicar el monto a cargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoEESPayEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEaddToCart(price) {
	try {
//		var price=parseInt($("#monto_safetypay_efectivo").val());
//		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Recarga Efectivo Lotocard',
		        'id': 'efe-lotocard',
		        'price': price,    //Deben indicar el monto asociado a la tarjeta
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});

		
		var tag = "tagginSaldoLotocardEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEcheckout(price) {
	try {
//		var price=parseInt($("#monto_safetypay_efectivo").val());
//		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Efectivo Lotocard',
		          'id': 'efe-lotocard',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});


		
		var tag = "tagginSaldoLotocardEEcheckout, precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEpurchase(idTransaction, price) {
	try {
//		var price=parseInt($("#monto_safetypay_efectivo").val());
//		idTransaction=idTransaction.toFixed(2);
		idTransaction="LC-"+idTransaction;
//		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Efectivo Lotocard',   
		        'id': 'efe-lotocard',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});



		
		var tag = "tagginSaldoLotocardEEpurchase, id de transacción: "+idTransaction+", precio: "+price;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoErrorRecarga(action, label) {
	try {
//		var price=parseInt($("#monto_safetypay_efectivo").val());
//		price=price.toFixed(2);
		label=label.replace(/\n/g,' ');
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'errorRecarga',
		    'category': 'UI :: Recarga',
		    'action': 'Error :: '+action,  //Indicar la modalidad de recarga donde sucedió el error ejm. Efectivo Lotocard
		    'label': label  //Enviar el mensaje de error que corresponda
		});
		
		var tag = "tagginSaldoErrorRecarga, action: "+action+", label: "+label;
		console.log("Taggin event: " + tag);

	} catch (e) {
		console.error(e);
	}

}


/*
$(document).ready(function () {
  var element = "";
  if ($("#isVKeyboardEnabled").val() == "true") {
    $("#password-client-header,#password-client").on("click focus", function (event) {
      event.stopPropagation();
      if (getTarget().attr("id") != $(this).attr("id")) {
        removeKeyboard();
        vkflg = true;
      }
      if (!$("#keyboard").length && (($(this).attr("id") == "password-client-header") || ($(this).attr("id") == "password-client"))) {
        setTarget(this);
        appendKeyboard();
      }
      if ($("#keyboard").hasClass("disabled")) {
        $("#keyboard").removeClass("disabled");
        appendKeyNumber();
      }
    });
    $("body").on("click", function () {
      $("#keyboard").mouseover(function () {
        vkflg = true;
      })
      $("#keyboard").mouseout(function () {
        vkflg = false;
      })
      if (!vkflg) {
        $("#keyboard").addClass("disabled");
      }
    });
  }
});*/

function tagginSaldoAgoraEEaddToCart() {
	try {
		var price=parseInt($("#monto_agora").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet Agora',
		        'id': 'int-agora',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		var tag = "tagginSaldoAgoraEEaddToCart, precio:  "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoAgoraEEcheckout() {
	try {
		var price=parseInt($("#monto_agora").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet Agora',
		          'id': 'int-agora',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		var tag = "tagginSaldoAgoraEEcheckout, precio:  "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoAgoraEEpurchase(idTransaction, price) {
	try {		
		price=parseFloat(price).toFixed(2);
		idTransaction="AG-"+idTransaction;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet Agora',   
		        'id': 'int-agora',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		var tag = "tagginSaldoAgoraEEpurchase, id de transaccion:  "+idTransaction+", precio: "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBBVAEEaddToCart() {
	try {		
		var price=parseInt($("#monto_bbva").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet BBVA',
		        'id': 'int-bbva',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBBVAEEremoveFromCart(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': 'Recarga Internet BBVA',
		          'id': 'int-bbva',
		          'price': price,      // Indicar el monto a remover
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		console.log("tagginSaldoBBVAEEremoveFromCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBBVAEEcheckout(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet BBVA',
		          'id': 'int-bbva',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEcheckout: " + price);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBBVAEEpurchase(code, date, price) {
	try {
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		date=(date.split(" ")[0]).split("/");
		date=date[2]+date[1]+date[0];
		var idTransaction="BC-"+code+date;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet BBVA',   
		        'id': 'int-bbva',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEpurchase: " + idTransaction);

	} catch (e) {
		console.error(e);
	}

}

var renderNewPasswordField = function () {
	   var $input = $('#password-client-header'),	   	
	     $field = $input.parent(),	     
	     $toggle = $('#toglePassword'),	    
	     onTogglePassword;

	   onTogglePassword = function () {
	     $field.toggleClass('viewing');
	     if ($field.hasClass('viewing')) {
	       $input.attr("type", "text");
	     } else {
	       $input.attr("type", "password");
	     }
	   };
	  
	   $toggle.on('click', onTogglePassword);
	  
	 };

	 $(".form-group input").each(function () {
		    var $input = $(this),
		      $parent = $input.parent();

		    if ($input.val() !== '') {
		      $parent.addClass('filled');
		    }

		    $input.on('focus', function () {
		      $parent.addClass('focus filled');
		    });

		    $input.on('blur', function () {
		      if ($input.val() === '') {
		        $parent.removeClass('focus filled');
		      } else {
		        $parent.removeClass('focus');
		      }
		    });
		  });
	 
	 var renderNewPasswordFieldHeader = function () {
		   var $input = $('#password-client-header'),	   	
		     $field = $input.parent(),	     
		     $toggle = $('#toglePasswordHeader'),	    
		     onTogglePassword;

		   onTogglePassword = function () {
		     $field.toggleClass('viewing');
		     if ($field.hasClass('viewing')) {
		       $input.attr("type", "text");
		     } else {
		       $input.attr("type", "password");
		     }
		   };
		  
		   $toggle.on('click', onTogglePassword);
		  
		 };
	 
	 $(".fixeds-input input").each(function () {
		    var $input = $(this),
		      $parent = $input.parent();

		    if ($input.val() !== '') {
		      $parent.addClass('filled');
		    }

		    $input.on('focus', function () {
		      $parent.addClass('focus filled');
		    });

		    $input.on('blur', function () {
		      if ($input.val() === '') {
		        $parent.removeClass('focus filled');
		      } else {
		        $parent.removeClass('focus');
		      }
		    });
		  });
	 
	 var renderNewPasswordFieldGame = function () {
		   var $input = $('#password-client'),	   	
		     $field = $input.parent(),	     
		     $toggle = $('#toglePassword'),	    
		     onTogglePassword;

		   onTogglePassword = function () {
		     $field.toggleClass('viewing');
		     if ($field.hasClass('viewing')) {
		       $input.attr("type", "text");
		     } else {
		       $input.attr("type", "password");
		     }
		   };
		  
		   $toggle.on('click', onTogglePassword);
		  
		 };
	 
	 $(".box-login-section input").each(function () {
		    var $input = $(this),
		      $parent = $input.parent();

		    if ($input.val() !== '') {
		      $parent.addClass('filled');
		    }

		    $input.on('focus', function () {
		      $parent.addClass('focus filled');
		    });

		    $input.on('blur', function () {
		      if ($input.val() === '') {
		        $parent.removeClass('focus filled');
		      } else {
		        $parent.removeClass('focus');
		      }
		    });
		  });
	 
	 // Inicio de la función para validar y obtener los documentos pendientes de confirmación del cliente
	 function mainValidatePendingsDocsForAproval(fnTraza = "") {
		$.ajax({
			url: 'get-pending-docs-for-aproval.html',
			type: 'post',
			contentType: 'application/json',
			dataType: 'json',
			success: function(response) {
				if (response.dataPendingDocs && response.dataPendingDocs.status == 'OK' && response.dataPendingDocs.documents.length > 0) {
					$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
					$('body').append(
							'<div id="div-lightbox-tyc-pdp" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 10000;">' +
								'<iframe id="frmLightboxTYCPDP" scrolling="no" frameborder="0" onload="retirar_loading();" src="tyc-pdp.html" style="width:100%; height: 100%; z-index: 10000 !important; border:0;"></iframe>' +
							'</div>'
					);
					const iframe = document.getElementById('frmLightboxTYCPDP');
					iframe.onload = function() {
						updateformTycPdpWithRetry(response.dataPendingDocs, 3, fnTraza);
					};
				} else {
					if (fnTraza != "") {
	    				window.parent.postMessage(fnTraza, "*");			
	    			}
				}
			},
			error: function(xhr, status, error) {
				console.error("Error en la petición:" + status + " " + error);
			}
		});
	 }
	 // Fin de la función para validar y obtener los documentos pendientes de confirmación del cliente

	 // Inicio de la función para actualizar el formulario del popup de los documentos pendientes de confirmación
	 function waitForIframe(iframeId, maxRetries = 20, interval = 100) {
		return new Promise((resolve, reject) => {
	        let retries = 0;
	        const iframe = document.getElementById(iframeId);

	        if (!iframe) {
	            reject(`No se encontró el iframe con ID ${iframeId}`);
	            return;
	        }

	        const checkIframe = setInterval(() => {
	            if (iframe.contentWindow && iframe.contentWindow.document.readyState === "complete") {
	                clearInterval(checkIframe);
	                console.log(`Iframe ${iframeId} cargado correctamente`);
	                resolve(iframe.contentWindow.document);
	            } else if (retries >= maxRetries) {
	                clearInterval(checkIframe);
	                reject(`El iframe ${iframeId} no cargó después de ${maxRetries * interval}ms`);
	            }
	            retries++;
	        }, interval);
	    });
	 }
 
	 async function updateformTycPdpWithRetry(data, retries = 3, fnTraza) {
	    for (let i = 0; i < retries; i++) {

	        try {
	            let iframeDoc = await waitForIframe('frmLightboxTYCPDP');
	            console.log('Iframe cargado correctamente');
	            updateformTycPdp(iframeDoc, data, fnTraza);
	            return;
	        } catch (error) {
	            console.error(`Intento ${i + 1} fallido:`, error);
	            if (i === retries - 1) {
	                console.error('No se pudo actualizar el iframe después de varios intentos');
	            } else {
	                // Recargar el iframe en caso de fallo
	                $('#frmLightboxTYCPDP').attr('src', $('#frmLightboxTYCPDP').attr('src'));
	            }
	        }
    	}
	 }
	 
	 function updateformTycPdp(iframeDoc, data, fnTraza){
	  	(async function () {
	  	    try {
	  	    	let urlQWLocal = $("#urlQw").val();
	  	    	let arrTitleTYCPDP = [];
	  	    	let arrDescriptionTYCPDP = [];

	             let blockTyc = $(iframeDoc).find('#blockTyc');
	             let blockPdp = $(iframeDoc).find('#blockPdp');
	             let blockTitlePendingDocs = $(iframeDoc).find('#blockTitlePendingDocs');
	             let blockDescriptionPendingDocs = $(iframeDoc).find('#blockDescriptionPendingDocs');
	             let blockButtonTycPdp = $(iframeDoc).find('#blockButtonTycPdp');
	  	    	
	  	    	$.each(data.documents, function(index, doc) {
	  	    		if (doc.docType == "TYC") {
	  	    			arrTitleTYCPDP.push("términos y condiciones");
	  	    			arrDescriptionTYCPDP.push("los términos y condiciones");
	  	            	blockTyc.append(`
	  	            		<a class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" onclick="" href="${urlQWLocal}/terminos-y-condiciones/" target="_blank">
	  	            			Ir a Términos y Condiciones
	  	            		</a>
	  	            		Versión ${doc.version}: ${formatDateEs(doc.publicationDate)}
	  	            	`);
	  	    		} else if (doc.docType == "PDP") {
	  	    			arrTitleTYCPDP.push("política de datos personales");
	  	    			arrDescriptionTYCPDP.push("la política de datos personales");
	  	    			blockPdp.append(`
	  	    				<a class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" onclick="" href="${urlQWLocal}/politica-de-datos-personales/ " target="_blank">
	  	    					Ir a Política de privacidad
	     					</a> 
	     					Versión ${doc.version}: ${formatDateEs(doc.publicationDate)}
	     				`);
	  	    		}
	  	        });
	  	    	
	  	    	let stringTitleTYCPDP = arrTitleTYCPDP.join(" y ");
	  	    	let stringDescriptionTYCPDP = arrDescriptionTYCPDP.join(" y ");
	  	    	
	  	    	blockTitlePendingDocs.append(`Actualización de ${stringTitleTYCPDP}`);
	  	    	blockDescriptionPendingDocs.append(`Hemos realizado actualizaciones a ${stringDescriptionTYCPDP}, desde tu última sesión. Por favor infórmate y confirma la aceptación para continuar usando nuestra plataforma virtual.`);
	  	    	blockButtonTycPdp.append(`
	  	    		<button id="btnSaveAcepptedDocuments" class="my-button" onclick="saveAcceptedDocumentsTYCPDP('${fnTraza}')" type="button" style="width: 50%; height: 40px">
	  	    			ACEPTAR
  	    			</button>	
	  	    	`);
	  	    	
	  	    } catch (error) {
	  	        console.error(error);
	  	    }
	  	})();
	 }
	 // Fin de la función para actualizar el formulario del popup de los documentos pendientes de confirmación
	 function formatDateEs(fechaStr) {
	    let fecha = new Date(fechaStr);
	    return fecha.toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' }); // Formato dd/mm/yyyy
	 }
