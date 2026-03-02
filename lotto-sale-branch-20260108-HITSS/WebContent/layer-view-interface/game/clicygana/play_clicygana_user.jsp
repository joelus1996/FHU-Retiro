<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta charset="UTF-8">
<title>Clic & Gana</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<script type="text/javascript">
<%String clicYGanaURI = String.valueOf(ConnectionFactory.operationProperty("neogamesURI", Constants.contextCardWeb)).toString().trim();%>
window.opener.top.oneclick = true;

function NeoGamesCommand(Command) {
    switch (Command) {        
        case 'Cashier':          
            var sessionCode = "${sessionCode}"; 
            $.ajax({
                type: 'POST',
                url: 'command_cashier.html',
                dataType: 'text',
                data: "sessionCode="+sessionCode,
                success: function (e) { 
                    var message=e;                  
                    jAlert(message);
                }
            });         
            break;

        case 'SwitchToMoney':             
            window.close();
            window.opener.focus();
            break;
            
        case 'Chat':
            // Sent in case player clicks on Cashier
            // Hosting system should reload NeoGames client with Money mode
            window.open ("https://zonasegura.intralot.com.pe/p/contacto.html","mywindow","menubar=1,resizable=1,width=800,height=600");
            break;
            
        case 'ContactUs':
            // Sent in case player clicks on Cashier
            // Hosting system should reload NeoGames client with Money mode
            //alert('Ha presionado la opción ContactUs. Esperar ha que se habilite la función.');
            window.open ("https://zonasegura.intralot.com.pe/p/contacto.html","mywindow","menubar=1,resizable=1,width=800,height=600");
            break;

        case 'Logout': 
            // Sent in case player clicks on Cashier
            // Hosting system should reload NeoGames client with Money mode
            window.close();
            window.opener.focus();
            //self.close();
            break;          

        case 'HostingSystemAPIError':
            // Received an error from the hosting system API
            // identify the ErrorCode and act accordingly
            var sessionCode = "${sessionCode}"; 
            commandClose(sessionCode);            
            //alert('SESION HA EXPIRADO. VUELVA A INGRESAR A CLIC Y GANA.');
            window.close();
            window.opener.location.href = "juega-clicygana.html";//"login_action.do?method=viewFormLogout&state=0";
            break;

        case 'NGSystemError':
            // Error detected by NG System
            // Reporting NG internal errors that require HS action
            var sessionCode = "${sessionCode}"; 
            commandClose(sessionCode);   
            //alert('SESION HA EXPIRADO. VUELVA A INGRESAR A CLIC Y GANA.');
            window.close();
            window.opener.location.href = "juega-clicygana.html";//"login_action.do?method=viewFormLogout&state=0";
            break;

        case 'RequestStatusUnknown':         
            // Call to the hosting system server has timed out
            var sessionCode = "${sessionCode}"; 
            commandClose(sessionCode);
            
            //alert('SESION HA EXPIRADO. VUELVA A INGRESAR A CLIC Y GANA.');
            window.close();
            window.opener.location.href = "juega-clicygana.html";//"login_action.do?method=viewFormLogout&state=0";
            break;

        default:
            // Hosting website might want to display a message
            jAlert('Unknown NeoGames Command: ' + Command);      
            window.close();
            window.opener.focus();
            //self.close();
            break;
    }
}
function commandClose(sessionCode){
    $.ajax({
        type: 'POST',
        url: 'command_close.html',
        dataType: 'text',
        data: "sessionCode="+sessionCode,
        success: function (e) { 
            var message=e;                  
            jAlert(message);
        }
    }); 
}
var run = {
        confirmExit: function () {
            window.onbeforeunload = function exitAlert() {
                var textillo = "¿Estás seguro que deseas abandonar Clic&Gana?";
                return textillo;
            }
        },
        other: function () {
        }
    };
    var $main = function () {
        run.confirmExit()
    };
    $($main);

    
function HandleOnClose() {
    var answer = confirm("¿Estás seguro que deseas abandonar Clic&Gana?\nHaga clic en Aceptar para continuar o en Cancelar\npara permanecer en Clic&Gana.");
    if(answer == true) window.close();
    else event.returnValue = '';
    return;
}
</script>
<script type="text/javascript"  src="<%=clicYGanaURI%>"></script>
</head>
<body  style="padding: 0; margin: 0px; overflow: auto; background-color: #CFCFCF;" onbeforeunload="HandleOnClose();">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tbody>
<tr valign="middle">
    <td align="center">
    <table cellspacing="0" cellpadding="0" border="0">
    <tbody>
    <tr>
        <td>
        <script type="text/javascript">
        //if(parseFloat("<c:out value='${home_clicygana_user_form.state}'/>") == 1) {           
         if("<c:out value='${idTipGameParameter}'/>" ==  "0"){         	
        	 try {                
     			LoadLobby(72, "PER", "PEN", "", "", "D", null, null, null, "${gameId}", null, null, null, null);    
             } catch(e) {
                 jAlert("ERROR: "+e);
             }
        	
        }else{       		try {                
                    LoadLobby(72, "PER", "PEN","${sessionCode}","${user}","${mode}", null, null, "${nickName}", "${gameId}", null, null, null, null);        
                } catch(e) {
                    jAlert("ERROR: "+e);
                }       		
        	
        }
            
            
        /*}*/
        </script>
        </td>
    </tr>
    </tbody>
    </table>
    </td>
</tr>
</tbody>
</table>

</body>
</html>