	
$(document).delegate('#enlaceBanner', 'click', function () {
	 window.open('https://latinkaportal.com.pe/politica-de-cookies/');	   
});

$(document).delegate('#btnBannerCookies', 'click', function () {			
	AceptarCookies();
});

$(document).ready(function(){
	$.ajax({
		type: "POST",
		url: "getConfigBannerCookie.html",
		dataType: "json",
		async: false,
	})
	.done(function(data) {
		if(data.status=="ACTIVO"){
			$("#bannerCookiesModal").addClass("ck-bloqueo");
		}else{
			$("#bannerCookiesModal").removeClass("ck-bloqueo");
			acceptAllAutomatic();
		}
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus||' '||errorThrown);
	});
});

function getCookieBanner(cname) {
	let name = cname + "=";
	let decodedCookie = decodeURIComponent(document.cookie);
	let ca = decodedCookie.split(';');
	for(let i = 0; i <ca.length; i++) {
	  let c = ca[i];
	  while (c.charAt(0) == ' ') {
	    c = c.substring(1);
	  }
	  if (c.indexOf(name) == 0) {
	    return c.substring(name.length, c.length);
	  }
	}
	return "";
}

function BannerCookies(){
//	const varBannerCookies = "bannerCookies";
//	let valueCookie = getCookieBanner(varBannerCookies) ;
//	console.log(valueCookie);
//	if(valueCookie != ""){
//		$("#bannerCookies").addClass("closeBanner");
//	}else{
//		$("#bannerCookies").css("transition","opacity 500ms");
//		$("#bannerCookies").removeClass("closeBanner");
//	}
}	 

function AceptarCookies(){
	const varBannerCookies = "bannerCookies";
	const valueBannerCookies = "true";
	const exdays = 365;
	const d = new Date();
	d.setTime(d.getTime() + (exdays*24*60*60*1000));
	let expires = "expires="+ d.toUTCString();
	document.cookie = varBannerCookies + "=" + valueBannerCookies + ";" + expires  ;
	console.log(varBannerCookies + "=" + valueBannerCookies + ";" + expires + ";path=/");
	$("#bannerCookies").addClass("closeBanner");
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}

function redirectMincetur(){
	window.open("https://www.gob.pe/765-inscribirse-en-el-registro-de-personas-prohibidas-a-acceder-a-juegos-de-casinos-y-maquinas-tragamonedas​", '_blank');
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}

/**********************************************************/
const arr = document.querySelectorAll("#main-accord");
let userAcceptsStatistics = false;
let userAcceptsMarketing = false;

arr.forEach((accord, index) => {
  const arrow = accord.querySelector(`.ck-arrow-${index + 1}`);
  accord.addEventListener("click", () => {
    //arrow.classList.toggle("ck-arrow-icon");
  });
});

function hasAcceptedCookies() {
  return document.cookie.indexOf("cookie_consent=true") !== -1;
}

// Check if user has already accepted cookies
if (hasAcceptedCookies()) {
  // Call GTM to handle accepted cookies
  document.getElementById("cookieBanner").style.display = "none";
  document.getElementById("bannerCookiesModal").style.display = "none";
  document.getElementById("bannerCookies").style.display = "none";
  window.dataLayer = window.dataLayer || [];
  window.dataLayer.push({ event: "consent_update" });
}else{
  document.getElementById("cookieBanner").style.display = "flex";
}

// switches for marketing and statistics

document
  .getElementById("userAcceptsStatistics")
  .addEventListener("change", function (e) {
    const { checked } = e.target;
    userAcceptsStatistics = checked;
  });
document
  .getElementById("userAcceptsMarketing")
  .addEventListener("change", function (e) {
    const { checked } = e.target;
    userAcceptsMarketing = checked;
  });

// Function to set a cookie with a specific name, value, and expiration time in days
function setCookie(cname, cvalue) {
  var now = new Date();
  var time = now.getTime();
  //var expireTime = time + 1000 * 36000;
  var expireTime = time + 180*24*60*60*1000;
  now.setTime(expireTime);
  document.cookie =
    cname + "=" + cvalue + ";expires=" + now.toUTCString() + "; path=/";
}

//Function para obtener la fecha actual con formato correcto
/*
function obtenerFechaActual() {
    const fechaActual = new Date();
    const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
    const [year, month, day] = fechaActual.toLocaleDateString(undefined, options).split('/');
    const fechaFormateada = `${day.padStart(2, '0')}-${month.padStart(2, '0')}-${year}`;
  
    return fechaFormateada;
  }
 */

function obtenerFechaActual() {
	const fechaActual = new Date(); 
	const year = fechaActual.getFullYear(); 
	const month = (fechaActual.getMonth() + 1).toString().padStart(2, '0'); // getMonth() devuelve un índice basado en 0 
	const day = fechaActual.getDate().toString().padStart(2, '0'); 
	const fechaFormateada = `${year}-${month}-${day}`; 
	return fechaFormateada; 
}

//Function generador de UUID
function generateUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = (Math.random() * 16) | 0,
          v = c === 'x' ? r : (r & 0x3) | 0x8;
      return v.toString(16);
    });
  }

// Guardar el UUID en el localStorage
var uuid = generateUUID();

//Function de envío a la DB de la Nube
function enviarDatosConsentimiento(fecha,clientId, adStorage, analyticsStorage, functionalityStorage, personalizationStorage, securityStorage) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
  
    var raw = JSON.stringify({
      "Fecha": fecha,
      "client_id": clientId,
      "ad_storage": adStorage,
      "analytics_storage": analyticsStorage,
      "functionality_storage": functionalityStorage,
      "personalization_storage": personalizationStorage,
      "security_storage": securityStorage
    });
  
    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
  
    return fetch("https://us-central1-prd-tinka-ga4.cloudfunctions.net/accepted_consent_data", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
  }
  

// Function to check if the user has rejected the cookies

document
  .getElementById("rejectCustomizationsBtn")
  .addEventListener("click", function () {
    setCookie("ad_storage", "denied");
    setCookie("security_storage", "granted");
    setCookie("analytics_storage", "denied");
    setCookie("functionality_storage", "granted");
    setCookie("personalization_storage", "granted");
    setCookie("cookieStrictlyNecessary", "granted");

    document.getElementById("cookieBanner").style.display = "none";
    document.getElementById("bannerCookiesModal").style.display = "none";
    document.getElementById("bannerCookies").style.display = "none";

    // Set main consent cookie after customizations are accepted
    setCookie("cookie_consent", "true");

    // Llamada a la función con nuevos valores
    enviarDatosConsentimiento(obtenerFechaActual(),uuid, "denied", "denied", "granted", "granted", "granted");
    localStorage.setItem('client_uuid', uuid);
    // Call GTM to handle accepted cookies
    window.dataLayer = window.dataLayer || [];
    window.dataLayer.push({ event: "consent_update" });
  });

document
  .getElementById("acceptCustomizationsBtn")
  .addEventListener("click", function () {
    if (userAcceptsStatistics && userAcceptsMarketing) {
      window.dataLayer.push({
        event: "virtualPageGA4",
        pagePath: "{{pagePath}}",
        pageTitle: "{{pageTitle}}",
      });
      // Llamada a la función con nuevos valores
      enviarDatosConsentimiento(obtenerFechaActual(),uuid, "granted", "granted", "granted", "granted", "granted");
    }

    // statistic cookies
    if (userAcceptsStatistics) setCookie("analytics_storage", "granted");
    else setCookie("analytics_storage", "denied");

    // marketing cookies
    if (userAcceptsMarketing) setCookie("ad_storage", "granted");
    else setCookie("ad_storage", "denied");

    setCookie("cookieStrictlyNecessary", "granted"); // Strictly necessary cookie

    document.getElementById("cookieBanner").style.display = "none";
    document.getElementById("bannerCookiesModal").style.display = "none";
    document.getElementById("bannerCookies").style.display = "none";

    // Set main consent cookie after customizations are accepted
    setCookie("cookie_consent", "true");
    setCookie("functionality_storage", "granted");
    setCookie("personalization_storage", "granted");
    setCookie("security_storage", "granted");

    if (userAcceptsStatistics&&!userAcceptsMarketing){
        // Llamada a la función con nuevos valores
        enviarDatosConsentimiento(obtenerFechaActual(),uuid, "denied", "granted", "granted", "granted", "granted");
    }else if (!userAcceptsStatistics&&userAcceptsMarketing){
        // Llamada a la función con nuevos valores
        enviarDatosConsentimiento(obtenerFechaActual(),uuid, "granted", "denied", "granted", "granted", "granted");
    }else if (!userAcceptsStatistics&&!userAcceptsMarketing){
        enviarDatosConsentimiento(obtenerFechaActual(),uuid, "denied", "denied", "granted", "granted", "granted");
    }
    localStorage.setItem('client_uuid', uuid);
    // Call GTM to handle accepted cookies
    window.dataLayer = window.dataLayer || [];
    window.dataLayer.push({ event: "consent_update" });
  });
// });

// Event listener for Accept All button click
document.getElementById("acceptAllBtn").addEventListener("click", function () {
  document.getElementById("cookieBanner").style.display = "none";
  document.getElementById("bannerCookiesModal").style.display = "none";
  document.getElementById("bannerCookies").style.display = "none";
  setCookie("ad_storage", "granted");
  setCookie("security_storage", "granted");
  setCookie("analytics_storage", "granted");
  setCookie("functionality_storage", "granted");
  setCookie("personalization_storage", "granted");
  setCookie("cookieStrictlyNecessary", "granted"); // Strictly necessary cookie

  // Set main consent cookie after accepting all cookies
  setCookie("cookie_consent", "true");

  // Llamada a la función con nuevos valores
  enviarDatosConsentimiento(obtenerFechaActual(),uuid, "granted", "granted", "granted", "granted", "granted");
  localStorage.setItem('client_uuid', uuid);
  // Call GTM to handle accepted cookies
  window.dataLayer = window.dataLayer || [];
  window.dataLayer.push({ event: "consent_update" });
});

function acceptAllAutomatic(){
  setCookie("ad_storage", "granted");
  setCookie("security_storage", "granted");
  setCookie("analytics_storage", "granted");
  setCookie("functionality_storage", "granted");
  setCookie("personalization_storage", "granted");
  setCookie("cookieStrictlyNecessary", "granted");

  // Llamada a la función con nuevos valores
  enviarDatosConsentimiento(obtenerFechaActual(),uuid, "granted", "granted", "granted", "granted", "granted");
  localStorage.setItem('client_uuid', uuid);
  // Call GTM to handle accepted cookies
  window.dataLayer = window.dataLayer || [];
  window.dataLayer.push({ event: "consent_update" });
}

function recuperarUUID() {
	return localStorage.getItem('client_uuid')
}

function enviarDatosUserName(fecha,clientId,user_name) {
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
	var raw = JSON.stringify({
	"Fecha": fecha,
	"client_id": clientId,
	"user_name": user_name
	});
	
	var requestOptions = {
	method: 'POST',
	headers: myHeaders,
	body: raw,
	redirect: 'follow'
	};
	
	return 	fetch("https://us-central1-prd-tinka-ga4.cloudfunctions.net/user_consent_data", requestOptions)
	.then(response => response.text())
	.then(result => console.log(result))
	.catch(error => console.log('error', error));
}

function hideModalCK(){
	$("#cookieModal").css("display","none");
	$(".modal-backdrop").css("display","none");
}

$(".accordion-item").on("click", function() {
  const svg = $(this).find("#arrow");
  if (svg.hasClass('ck-arrow-1')) {
	  $("#arrow.ck-arrow-2").removeClass('ck-arrow-icon').addClass('collapsed');
	  $("#arrow.ck-arrow-3").removeClass('ck-arrow-icon').addClass('collapsed');
  }else if(svg.hasClass('ck-arrow-2')){
	  $("#arrow.ck-arrow-1").removeClass('ck-arrow-icon').addClass('collapsed');
	  $("#arrow.ck-arrow-3").removeClass('ck-arrow-icon').addClass('collapsed');
  }else if(svg.hasClass('ck-arrow-3')){
	  $("#arrow.ck-arrow-2").removeClass('ck-arrow-icon').addClass('collapsed');
	  $("#arrow.ck-arrow-1").removeClass('ck-arrow-icon').addClass('collapsed');
  }  
  
  if(svg.hasClass('ck-arrow-icon')){
	  svg.removeClass('ck-arrow-icon');
	  svg.addClass('collapsed');
  }else{
	  svg.removeClass('collapsed');
	  svg.addClass('ck-arrow-icon');
  }  
} );