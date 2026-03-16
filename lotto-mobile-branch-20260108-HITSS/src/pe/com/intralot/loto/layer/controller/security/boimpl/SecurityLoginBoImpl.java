package pe.com.intralot.loto.layer.controller.security.boimpl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.validator.routines.RegexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetPasswordCode;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureResetNewPassword;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateBonoQr;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateNovusId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePlayerId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateSmsRegister;
import pe.com.intralot.loto.layer.model.pojo.ImgDto;
import pe.com.intralot.loto.layer.view.security.SecurityLoginController;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
//import pe.com.intralot.loto.lib.MailLib;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.MailLib;
import pe.com.intralot.loto.www.sale.client.lib.ClientUtils;

/**
 * <p>
 * NOMBRE: SecurityLoginBoImpl.java
 * <br></p>
 * <p>
 * FUNCION: Implementaci�n del objeto de l�gica de negocio del inicio de sesi�n
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  M�todos para la activaci�n y rechazo del bono de TA por recargas Interbank
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Service("beanSecurityLoginBo")
public class SecurityLoginBoImpl implements SecurityLoginBo {
	
	@Autowired
	private ClientDao beanClientDao;
	
	@Autowired
	private IntralotUtils intralotUtils;
	    
 
	@SuppressWarnings("rawtypes")
	public Client validaLogin(Object params[]) throws Exception {
		Client objectPojo= new Client();
		try {
			LoggerApi.Log.info("params:"+params.length);
			
			objectPojo = beanClientDao.findByUser(params);
			return objectPojo;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectPojo!=null){
				LoggerApi.Log.info("objectList: "+objectPojo.toString());	
			}else{
				LoggerApi.Log.info("objectList: "+"null");	
			}
			
		}
	
	}
	
    public HashMap[] updateAgreement(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId);
        //ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        HashMap[] objectMap= null;
        try {
        	objectMap = beanClientDao.updateAgreement(p_clientId);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        }
        //return objectDomain;
    }
    
    public HashMap[] getPasswordCode(String mail, String password_code) throws Exception {
        LoggerApi.Log.info("mail=" + mail);
        //ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        HashMap[] objectMap= null;
        try {
        	objectMap = beanClientDao.getPasswordCode(mail, password_code);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        }
        //return objectDomain;
    }
    
    public HashMap[] resetNewPassword(String mail, String password_code, String password1, String password2) throws Exception {
        LoggerApi.Log.info("mail=" + mail);
        //ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        HashMap[] objectMap= null;
        try {
        	objectMap = beanClientDao.resetNewPassword(mail, password_code, password1, password2);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        }
        //return objectDomain;
    }
    
    //@Override
    public String clientSendMail(String email, String name, String code, int option, String user,String game) {
        /* System.out.println("INGRESO PARA ENVIAR EMAIL "); */
        String context = "CARD-WEB";
        StringBuffer mailBodyConfirm = new StringBuffer();
        StringBuffer mailBodyNewCode = new StringBuffer();
        StringBuffer mailBodyPass = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Cambia tu contrase�a";
        String mailBody = "";
        String result = "";
        String codedecoded = "";
        String urlRecuperarContrasenia="";
                       
        //System.out.println("codigo encriptado : "+code);
        String emailEncryt = intralotUtils.encrypt(email);
        //System.out.println("codigo email encriptado : "+emailEncryt);
        /* try {
            codedecoded = StringLib.decodeLabel(code);           
        } catch (Exception e) {} */
        
        if(game.equals("1")) {
        	 urlRecuperarContrasenia = Constantes.latinkaUrlContrasenia+"?param1="+code+"&&param2="+emailEncryt;
             System.out.println(urlRecuperarContrasenia);
        }else if (game.equals("2")) {
        	 urlRecuperarContrasenia = Constantes.latinkaUrlContraseniaTA+"?param1="+code+"&&param2="+emailEncryt;
            System.out.println(urlRecuperarContrasenia);
        }
        
        String imgTinka= ConnectionFactory.operationProperty("logoTinka", context);
        String imgBanner= ConnectionFactory.operationProperty("bannerTinka", context);
        String imgButton= ConnectionFactory.operationProperty("buttonContrasenia", context);
                        
        mailBodyConfirm.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>" + "<tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-email-val.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td width='549' valign='top' bgcolor='#F7F7F7' style='background: #F7F7F7; "
                + "font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e; text-align:justify;'><strong>Hola "
                + ClientUtils.formatHtml(name)
                + "</strong><br/><br/>&iexcl;Bienvenido a La Tinka!<br/><br/>Con el fin de completar tu registro y "
                + "convertirte en un miembro de La Tinka, debes activar el registro de tu correo electr&oacute;nico. Por "
                + "favor, haz clic en el siguiente v&iacute;nculo para confirmar la activaci&oacute;n de su correo "
                + "(de no haber ingresado al sistema previamente deber&aacute; hacerlo para poder activar su cuenta):"
                + "<br/><br/><a href='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "p/inicio.html#activar'>Activar mi cuenta</a><br/>"
                + "<br/>Si al hacer clic en el v&iacute;nculo parece que est&aacute; roto, c&oacute;pialo "
                + "y p&eacute;galo en una ventana nueva del navegador. Accede a tu cuenta La Tinka con tu usuario y "
                + "contrase&ntilde;a e ingresa el siguiente c&oacute;digo, cuando el sistema lo requiera.<br/>"
                + "<br/>C&oacute;digo: <strong style='color:#f78f1e'>"
                + code
                + "</strong><br/><br/>Gracias a esta confirmaci&oacute;n, tendr&aacute;s la "
                + "satisfacci&oacute;n de recibir en la cuenta de correo "
                + email
                + ", desde la comodidad de tu casa, mensajes sobre "
                + "promociones, resultados de los sorteos, los tickets de tus jugadas y los premios que has ganado.<br/><br/>"
                + "<br/>Le deseamos suerte con sus jugadas <br/>Departamento de Marketing de La Tinka.</td><td style='"
                + "background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-right.gif) repeat-y; "
                + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr><tr><td colspan='3' align='center'><table "
                + "width='768' border='0' cellspacing='0' cellpadding='0'><tr><td width='75'>&nbsp;</td><td width='616' "
                + "style='font-family: Arial, Helvetica, sans-serif; font-size: 10px; color:#999999; text-align: justify;'>"
                + "Derechos Reservados. En <a href='http://www.latinka.com.pe/' title='http://www.latinka.com.pe/'>LA TINKA "
                + "S.A.</a> nos comprometemos con la privacidad de los datos de nuestros usuarios suscriptores. "
                + "Su direcci&oacute;n de correo electr&oacute;nico figura suscrita a la lista de correos electr&oacute;nicos "
                + "de nuestro sistema de suscripci&oacute;n on line, formando parte de un fichero automatizado de env&iacute;o "
                + "de informaci&oacute;n seleccionada por el suscriptor. Si tiene alguna pregunta o comentario que hacernos, o "
                + "si desea plantearnos alguna preocupaci&oacute;n, ll&aacute;menos al n&uacute;mero de tel&eacute;fono 01 513 5502.</td>"
                + "<td width='77'>&nbsp;</td></tr></table></td></tr></table></td></tr></table></body></html>");
        mailBodyNewCode.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>" + "<tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-email-val.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td width='549' valign='top' bgcolor='#F7F7F7' style='background: #F7F7F7; "
                + "font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e; text-align:justify;'><strong>Hola "
                + ClientUtils.formatHtml(name)
                + "</strong><br/><br/>&iexcl;Solicitud de c&oacute;digo de seguridad!<br/><br/>Se ha generado un nuevo c&oacute;digo de seguridad para "
                + "activar el registro de tu correo electr&oacute;nico. Por "
                + "favor, haz clic en el siguiente v&iacute;nculo para confirmar la activaci&oacute;n de su correo "
                + "(de no haber ingresado al sistema previamente deber&aacute; hacerlo para poder activar su cuenta):"
                + "<br/><br/><a href='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "p/inicio.html#activar'>Activar mi cuenta</a><br/>"
                + "<br/>Si al hacer clic en el v&iacute;nculo parece que est&aacute; roto, c&oacute;pialo "
                + "y p&eacute;galo en una ventana nueva del navegador. Accede a tu cuenta La Tinka con tu usuario y "
                + "contrase&ntilde;a e ingresa el siguiente c&oacute;digo para proceder con la activaci&oacute;n.<br/>"
                + "<br/>C&oacute;digo: <strong style='color:#f78f1e'>"
                + code
                + "</strong><br/><br/>Gracias a esta confirmaci&oacute;n, tendr&aacute;s la satisfacci&oacute;n de recibir en la cuenta de correo "
                + email
                + ", desde la comodidad de tu casa, mensajes sobre "
                + "promociones, resultados de los sorteos, los tickets de tus jugadas y los premios que has ganado.<br/><br/>"
                + "<br/>Le deseamos suerte con sus jugadas <br/>Departamento de Marketing de La Tinka.</td><td style='"
                + "background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-right.gif) repeat-y; "
                + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr><tr><td colspan='3' align='center'><table "
                + "width='768' border='0' cellspacing='0' cellpadding='0'><tr><td width='75'>&nbsp;</td><td width='616' "
                + "style='font-family: Arial, Helvetica, sans-serif; font-size: 10px; color:#999999; text-align: justify;'>"
                + "Derechos Reservados. En <a href='http://www.latinka.com.pe/' title='http://www.latinka.com.pe/'>LA TINKA "
                + " S.A.</a> nos comprometemos con la privacidad de los datos de nuestros usuarios suscriptores. "
                + "Su direcci&oacute;n de correo electr&oacute;nico figura suscrita a la lista de correos electr&oacute;nicos "
                + "de nuestro sistema de suscripci&oacute;n on line, formando parte de un fichero automatizado de env&iacute;o "
                + "de informaci&oacute;n seleccionada por el suscriptor. Si tiene alguna pregunta o comentario que hacernos, o "
                + "si desea plantearnos alguna preocupaci&oacute;n, ll&aacute;menos al n&uacute;mero de tel&eacute;fono 01 513 5502.</td>"
                + "<td width='77'>&nbsp;</td></tr></table></td></tr></table></td></tr></table></body></html>");
        /*mailBodyPass.append("<html><head></head>" + 
        		"<body marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' bottommargin='0'>" + 
        		"<div><table width='600px' border='0' align='center' cellpadding='0' cellspacing='0' style='text-align:center;'>" + 
        		"<tr><td width='50px' style='background-color:#ffe510;'>&nbsp;</td><td width='500px' style='background-color:#ffe510;'>&nbsp; " + 
        		"</td><td width='50px' style='background-color:#ffe510;'>&nbsp;</td> " + 
        		"<tr><td width='50px' style='background-color:#ffe510;'>&nbsp;</td>" + 
        		"<td width='500px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"</td><td width='50px' style='background-color:#ffe510;'>&nbsp;</td></tr><tr>  " + 
        		"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr><tr>" + 
        		"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' height='35px' style=\"text-align: left;\"><img src='"+imgTinka+"' style='margin-left:10px;'>" +  
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#ffe510;'>&nbsp;" + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#5a5a5a;'><strong><span>�Hola "+ClientUtils.formatHtml(name)+"!</span></strong>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'><span>Haz click para cambiar tu contrase�a en la Tinka.</span>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'><a style='text-decoration: none;color: white;border-radius: 1.45em;background-color: #1a6d30;padding-top: 10px;padding-bottom: 10px;padding-left: 15px;padding-right: 15px;font-weight: 800;' href='"+urlRecuperarContrasenia+"'>CAMBIAR CONTRASE&Ntilde;A</a><br/>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'>Si tu no pediste el cambio, ignora este correo.  " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td> " + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;</td> " + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;</td></tr><tr>  " + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td> " + 
        		"            <td width='500px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr><tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td>   " + 
        		"            <td width='500px' style='background-color:#dedede;font-family: Arial, Helvetica, sans-serif; font-size: 12.3px; color:#999999;'><span>&Eacute;ste es un correo generado autom&aacute;ticamente y caducar&aacute; a las 24hrs de la fecha." + 
        		"			<br/>en que lo recibiste. Si quieres actualizar tus datos o necesitas informaci&oacute;n<br/>" + 
        		"			adicional, cont&aacute;ctate con nosotros al 513 5502.</span></td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr><tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr>" + 
        		"<tr>" + 
        		"        <td  colspan='3' width='600px' style='background-color:#dedede;'> <img src='"+imgBanner+"' >" + 
        		"		</td>" +  
        		"		</tr>"+
        		"</table></div></div></body></html>");*/
        
        mailBodyPass.append("<html>" + 
        		"<head>" + 
        		"<title>La Tinka - Cambia tu contrase&ntilde;a</title>" + 
        		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + 
        		"</head>" + 
        		"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" + 
        		"<table width=\"600\" height=\"700\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" + 
        		"	<tr>" + 
        		"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
        		"		<td bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>" + 
        		"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td>" + 
        		"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td rowspan=\"9\" bgcolor=\"#dedede\"  width=\"65\" height=\"359\" alt=\"\"></td>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>" + 
        		"		<td rowspan=\"9\" bgcolor=\"#dedede\"  width=\"65\" height=\"359\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>�Hola "+ClientUtils.formatHtml(name)+"!</strong></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Haz click aqu&iacute; para cambiar tu contrase&ntilde;a en La Tinka.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" align=\"center\"><a href='"+urlRecuperarContrasenia+"' target=_blank>" + 
        		"			<img src='"+imgButton+"' width=\"265\" height=\"36\" alt=\"Cambiar contrase&ntilde;a\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></a></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Si t&uacute; no pediste el cambio, ignora este correo.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"49\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#dedede\" width=\"470\" height=\"76\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\">Este es un correo generado autom&aacute;ticamente. El enlace cambiar contrase�a <strong>caducar&aacute; a las 24hrs</strong> de la fecha en que lo recibiste. Si quieres actualizar tus datos o necesitas informaci&oacute;n adicional, cont&aacute;ctate con nosotros al 5135502.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td colspan=\"3\" bgcolor=\"#dedede\">" + 
        		"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td colspan=\"3\" bgcolor=\"#dedede\" width=\"600\" height=\"117\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"</table>" + 
        		"</body>" + 
        		"</html>");
        switch (option) {
            case 1:
                mailSubject += " " + "Confirmaci�n de correo electr�nico";
                mailBody = mailBodyConfirm.toString();
                break;
            case 2:
                mailSubject += " " + "Solicitud de c�digo de seguridad";
                mailBody = mailBodyNewCode.toString();
                break;
            case 3:
                
                mailBody = mailBodyPass.toString();
                break;
            default:
                break;
        }
        try {
            MailLib.sendMail(mailSender, mailSubject, mailBody);
            result = "Se ha enviado un mensaje a su direccion de correo electr&oacute;nico.";
        } catch (Exception e) {
            LoggerApi.severe(e);
            result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
    }
	
    public String fintUserByMail(String mail, String password_code) throws Exception {
        LoggerApi.Log.info("mail=" + mail);
        //ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        String result= null;
        try {
        	result = beanClientDao.fintUserByMail(mail, password_code);
        	return result;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(result!=null){
				LoggerApi.Log.info("objectMap: "+result);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        }
        //return objectDomain;
    }
    
    public String clientSendUserMail(String email) {
    	String context = "CARD-WEB";
        StringBuffer mailBodyUser = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Recordatorio de usuario";
        String mailBody = "";
        String result = "KO";
        
        String imgTinka= ConnectionFactory.operationProperty("logoTinka", context);
        String imgBanner= ConnectionFactory.operationProperty("bannerTinka", context);  
        
        try {
	        Client client = beanClientDao.findUserReminder(email);
	        if(client!=null && client.getClientId()!=0) {
	        	/*mailBodyUser.append("<html><head></head><body marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' bottommargin='0'>" + 
	        			"<div><table width='600px' border='0' align='center' cellpadding='0' cellspacing='0' style='text-align:center;'><tr>" + 
	        			"<td width='50px' style='background-color:#ffe510;'>&nbsp;</td><td width='500px' style='background-color:#ffe510;'>&nbsp;</td>" + 
	        			"<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"</td><tr>" + 
	        			"        	<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"		</td>  " + 
	        			"			" + 
	        			"        </tr>" + 
	        			"		<tr>" + 
	        			"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        " + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' height='35px' style=\"text-align: left;\"><img src='"+imgTinka+"' style='margin-left:10px;'>" + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        " + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#5a5a5a;'><strong><span>�Hola "+client.getName()+"!</span></strong>   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp; " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'><span>Tu nombre de usuario es</span>  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#126639;'><strong><span>"+client.getUser()+"</span></strong>   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;font-family: Arial, Helvetica, sans-serif; font-size: 12.3px; color:#999999;'><span>&Eacute;ste es un correo generado autom&aacute;ticamente y caducar&aacute; las 24hrs de la fecha." + 
	        			"									<br/>en que lo recibiste. Si quieres actualizar tus datos o necesitas informacio&acute;n<br/> " + 
	        			"									adicional, cont&aacute;ctate con nosotros al 513 5502.</span>  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"<tr>" + 
	            		"        <td  colspan='3' width='600px' style='background-color:#dedede;'> <img src='"+imgBanner+"' >" + 
	            		"		</td>" +  
	            		"		</tr>"+
	        			"</table></div></div></body></html>");*/
	               
	        	mailBodyUser.append("<html>" + 
	        			"<head>" + 
	        			"<title>La Tinka - Recordatorio de usuario</title>" + 
	        			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + 
	        			"</head>" + 
	        			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" + 
	        			"<table width=\"600\" height=\"365\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" + 
	        			"	<tr>" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
	        			"		<td bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td>" + 
	        			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td rowspan=\"6\" bgcolor=\"#dedede\"  width=\"65\" height=\"283\" alt=\"\"></td>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>" + 
	        			"		<td rowspan=\"6\" bgcolor=\"#dedede\"  width=\"65\" height=\"283\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>�Hola "+client.getName()+"!</strong></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Tu nombre de usuario es</td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"43\" align=\"center\" style=\"display:block; color:#126639; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>"+client.getUser()+"</strong></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"49\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#dedede\" width=\"470\" height=\"76\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\">Este es un correo generado autom&aacute;ticamente. Si quieres actualizar tus datos o necesitas informaci&oacute;n adicional, cont&aacute;ctate con nosotros al 5135502.</td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td colspan=\"3\" bgcolor=\"#dedede\">" + 
	        			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td colspan=\"3\" bgcolor=\"#dedede\" width=\"600\" height=\"117\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"</table>" + 
	        			"</body>" + 
	        			"</html>");
	        	
	                mailBody = mailBodyUser.toString();
		            //MailLib.sendMail(mailSender, mailSubject, mailBody);
	                MailLib.sendMail(mailSender, mailSubject, mailBody);
		            result = "OK";
		        } else {
		        	result = "NE";
		        }
	        } catch (Exception e) {
	            result = "KO";
	            LoggerApi.severe(e);
	        } finally {
	        	LoggerApi.Log.info(result);
	        }
        return result;
    }
    
    public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception {
        LoggerApi.Log.info("findGetPasswordCode p_mail=" + p_mail);
        ClientProcedureGetPasswordCode objectDomain = new ClientProcedureGetPasswordCode();
        try {
            objectDomain = beanClientDao.findGetPasswordCode(p_mail, p_password_code);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_mail=" + p_mail+" p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage() + " p_mail=" + objectDomain.getMail()
                        + " p_passsword_code=***" );
            else {
            	LoggerApi.Log.info("objectDomain="+objectDomain);
            }
        }
        return objectDomain;
    }

    public ClientProcedureResetNewPassword resetPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail+" p_password_code=***");
        ClientProcedureResetNewPassword objectDomain = new ClientProcedureResetNewPassword();
        try {
            objectDomain = beanClientDao.resetPassword(p_mail, p_password_code, p_password_1, p_password_2);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_mail=" + p_mail+" p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
  
    public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception {
        //LoggerApi.Log.info("cid=" + p_clientid + " channel=" + channel);
        ClientProcedureTokenGeneration objectDomain = new ClientProcedureTokenGeneration();
        try {
            objectDomain = beanClientDao.getToken(p_clientid, channel, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            //if (objectDomain != null)
            //    LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " iflexToken=" + objectDomain.getIflexToken() 
            //    		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
    
    public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid);
        ClientProcedureLPTokenGeneration objectDomain = new ClientProcedureLPTokenGeneration();
        try {
            objectDomain = beanClientDao.getLPToken(p_clientid, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " lapollaToken=" + objectDomain.getLapollaToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
    
    public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception {
        //LoggerApi.Log.info("cid=" + p_clientid);
        ClientProcedureTANTokenGeneration objectDomain = new ClientProcedureTANTokenGeneration();
        try {
            objectDomain = beanClientDao.getTANToken(p_clientid, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            //if (objectDomain != null)
            //    LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
             //   		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }

	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId, String p_sms) throws Exception {
		ClientProcedurePutSmsRegisterData objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_sms:"+p_sms);
			objectPojo = beanClientDao.putSmsRegisterData(p_clientId, p_sms);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId, String p_sms, Integer p_time_minutes)
			throws Exception {
		ClientProcedureUpdateSmsRegister objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_sms:"+p_sms+" p_time_minutes:"+p_time_minutes);
			objectPojo = beanClientDao.updateSmsRegister(p_clientId, p_sms, p_time_minutes);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception {
		ClientProcedureUpdatePhone objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_phone:"+p_phone);
			objectPojo = beanClientDao.updatePhoneClient(p_clientId, p_phone);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception {
		ClientProcedureActivatePromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.activatePromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception {
		ClientProcedureActivateWBPromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.activateWBPromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureCancelPromotion cancelPromotion(Object[] values)
			throws Exception {
		ClientProcedureCancelPromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.cancelPromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception {
		ClientProcedureActivatePromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.activatePromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception {
		ClientProcedureActivateWBPromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.activateWBPromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values)
			throws Exception {
		ClientProcedureCancelPromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = beanClientDao.cancelPromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_playerId) throws Exception {
		ClientProcedureUpdatePlayerId objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_playerId:"+p_playerId);
			objectPojo = beanClientDao.updatePlayerId(p_clientId, p_playerId);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception {
		ClientProcedureTokenValidation objectDomain = new ClientProcedureTokenValidation();
        ////Validar token
		String expRegToken="[a-z\\d\\-]{120,120}";
		Boolean veryfyCodePromotional= new RegexValidator(expRegToken).isValid(p_token);
		if(!veryfyCodePromotional) {
			objectDomain.setMessage("TOKEN NO EXISTE");
			objectDomain.setStatus("ERROR");
			return objectDomain;
		}		
        try {
            objectDomain = beanClientDao.getTokenValidation(p_token, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            //if (objectDomain != null)
            //    LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
             //   		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
	
		@Override
	public String enviarMailPD(ByteArrayOutputStream bis,List<ImgDto> listImgDto,String mailBody,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento,String numeroDocumento) {
		
		String result="";
		//String mailSubject = "Solicitud de Derechos Arco de " + tipo_solicitud +"-" + apellidos +" "+nombres+ "-"+ tipoDocumento + " "+ numeroDocumento;
		String mailSubject= "###WEB Derechos ARCO";
		
		try {
			//MailLib.sendValidMailPD(null,"SoporteWeb@latinka.com.pe",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
			//MailLib.sendValidMailPD(null,"diegoruizcarranza@gmail.com",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
			//MailLib.sendValidMailPD(null,"angel.chata@latinka.com.pe",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
		
//			SecurityLoginController.sendRawMail("reclamosvirtuales@intralot.com.pe", "SoporteWeb@latinka.com.pe", mailSubject, mailBody);
//			SecurityLoginController.sendRawMail("reclamosvirtuales@intralot.com.pe", "diegoruizcarranza@gmail.com", mailSubject, mailBody);
//			SecurityLoginController.sendRawMail("reclamosvirtuales@intralot.com.pe", "angel.chata@latinka.com.pe", mailSubject, mailBody);
          
			result = "OK";
        } catch (Exception e) {
            LoggerApi.severe(e);
         
            result = "KO";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
	}
		
		
		@Override
		public String enviarMailClientePD(String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento, String numeroDocumento, String email) {
			
			String result="";
			String mailSubject = "Solicitud de Derechos Arco de " + tipo_solicitud +"-" + apellidos +" "+nombres+ "-"+ tipoDocumento + " "+ numeroDocumento;
			//String mailSubject = "###WEB Derehos ARCO";
			String mailTarget = email+","+"datospersonales@latinka.com.pe";
			
			try {
				MailLib.sendMail(mailTarget, mailSubject, body);
	            //result = "Se ha enviado un mensaje a su direcci&oacute;n de correo electr&oacute;nico.";
				result = "OK";
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            //result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
	            result = "KO";
	        } finally {
	            LoggerApi.Log.info(result);
	        }
	        return result;
		}	

		@Override
		public String findCodUserfilter1(String dni, String nombre) throws Exception {
			 String result=null;
		        try {
		        	result = beanClientDao.findCodUserfilter1(dni, nombre);
		        	return result;
		        } catch (Exception e) {
		            LoggerApi.severe(e);           
		            throw new Exception(e);	
		        } finally {
		        	if(result!=null){
						LoggerApi.Log.info("objectMap: "+result);
					} else {
						LoggerApi.Log.info("objectMap: "+"null");
						return "";
					}
		          
		        }
		}

		@Override
		public String findCodUserfilter2(String dni, String correo) throws Exception {
			String result= null;
	        try {
	        	result = beanClientDao.findCodUserfilter2(dni, correo);
	        	return result;
	        } catch (Exception e) {
	            LoggerApi.severe(e);           
	            throw new Exception(e);	
	        } finally {
	        	if(result!=null){
					LoggerApi.Log.info("objectMap: "+result);
				} else {
					LoggerApi.Log.info("objectMap: "+"null");
					return "";
				}
	          
	        }
		}

		@Override
		public String findCodUserfilter3(String dni, String celular) throws Exception {
			String result= null;
	        try {
	        	result = beanClientDao.findCodUserfilter3(dni, celular);
	        	return result;
	        } catch (Exception e) {
	            LoggerApi.severe(e);           
	            throw new Exception(e);	
	        } finally {
	        	if(result!=null){
					LoggerApi.Log.info("objectMap: "+result);
				} else {
					LoggerApi.Log.info("objectMap: "+"null");	
					return "";
				}
	          
	        }
		}
	
		public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novusId) throws Exception {
			ClientProcedureUpdateNovusId objectPojo= null;
			try {
				LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_novusId:"+p_novusId);
				objectPojo = beanClientDao.updateNovusId(p_clientId, p_novusId);
				return objectPojo;
			} catch (Exception e) {
				LoggerApi.severe(e);
	            throw e;
			} finally{ 
				if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
				else LoggerApi.Log.info("objectPojo: "+"null");
			}
		}
		
		public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception {
	        LoggerApi.Log.info("findGetNovusId p_clientid=" + p_clientid);
	        ClientProcedureGetNovusId objectDomain = new ClientProcedureGetNovusId();
	        try {
	            objectDomain = beanClientDao.findGetNovusId(p_clientid);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("p_clientid=" + p_clientid+" p_user=" + objectDomain.getClientUser() );
	            else {
	            	LoggerApi.Log.info("objectDomain="+objectDomain);
	            }
	        }
	        return objectDomain;
	    }
		
		@Override
		public String getLinkRecoverPassword(String email, String name, String code, int option, String user,String game) {
			String urlRecuperarContrasenia="";
			String emailEncryt ="";
			try {
	            emailEncryt = StringLib.encodeLabel(email);
	            System.out.println("codigo email encriptado : "+emailEncryt);
				
	            System.out.println("codigo encriptado : "+code);
	            emailEncryt = StringLib.encodeLabel(email);
	            System.out.println("codigo email encriptado : "+emailEncryt);
	        } catch (Exception e) {}
	        
	        if(game.equals("1")) {
	       	 urlRecuperarContrasenia = Constantes.latinkaUrlContrasenia+"?param1="+code+"&&param2="+emailEncryt;
	            System.out.println(urlRecuperarContrasenia);
	       }else if (game.equals("2")) {
	       	 urlRecuperarContrasenia = Constantes.latinkaUrlContraseniaTA+"?param1="+code+"&&param2="+emailEncryt;
	           System.out.println(urlRecuperarContrasenia);
	       }
	        
	        return urlRecuperarContrasenia;
	    }
		
		public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception {
			ClientProcedureUpdateBonoQr objectPojo= null;
			try {
				LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_bonoQr:"+p_bonoQr);
				objectPojo = beanClientDao.updateBonoQr(p_clientId, p_bonoQr);
				return objectPojo;
			} catch (Exception e) {
				LoggerApi.severe(e);
	            throw e;
			} finally{ 
				if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
				else LoggerApi.Log.info("objectPojo: "+"null");
			}
		}

		@Override
		public String requestWSIflexApiRecharge(String json, String service) {
			LoggerApi.Log.info("start requestWSIflexApiRecharge: "+json);
			String jsonResponseIflexApiRecharge="";
			try {
				String urlIflexapiRecharge = ConnectionFactory.operationProperty("urlIflexapiRecharge", Constantes.contextRechargeApi);
				String secretIflexapiRecharge = ConnectionFactory.operationProperty("secretIflexapiRecharge", Constantes.contextRechargeApi);
				String userIflexapiRecharge = ConnectionFactory.operationProperty("userIflexapiRecharge", Constantes.contextRechargeApi);
				String passIflexapiRecharge = ConnectionFactory.operationProperty("passIflexapiRecharge", Constantes.contextRechargeApi);
				String credenciales = userIflexapiRecharge+":"+passIflexapiRecharge;
				credenciales = Base64.encodeBase64String(credenciales.getBytes()); 	    	
	 	    	URL url = new URL(urlIflexapiRecharge+service);
	 			HttpURLConnection  con = (HttpURLConnection )url.openConnection();
	 			con.setRequestMethod("POST");
	 			con.setRequestProperty("Authorization", "Basic "+credenciales);
	 			con.setRequestProperty("Secret", secretIflexapiRecharge);
	 			con.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
	 			con.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
	     		con.setDoOutput(true);
	     		OutputStream os = con.getOutputStream();
	 			os.write(json.getBytes(Constantes.CHARSET_UTF8));
	 			os.flush();
	 			os.close();
	 			BufferedReader br = null;
	 			int responseCode = con.getResponseCode();
	 			if(responseCode < HttpServletResponse.SC_BAD_REQUEST) {
	 				br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
	 			}else {
	 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE HTTP CODE: "+responseCode + " json: "+json);
	 				if (con.getErrorStream() != null) {
	 					br = new BufferedReader(new InputStreamReader((con.getErrorStream()),Constantes.CHARSET_UTF8));
	 				} else if (con.getInputStream() != null) {
	 					br = new BufferedReader(new InputStreamReader((con.getInputStream()),Constantes.CHARSET_UTF8));
	 				}
	 			}
	 			StringBuilder sb = new StringBuilder();
	 			if (br != null) {
	 				char[] buffer = new char[1000];
	 	        	int leido;
	 	        	while ((leido = br.read(buffer)) > 0) {
	 	        		sb.append(new String(buffer, 0, leido));
	 	        	}
	 				br.close();
	 			}
	 			con.disconnect();
	 			jsonResponseIflexApiRecharge = sb.toString();
	 			if (!looksLikeJsonObject(jsonResponseIflexApiRecharge)) {
	 				jsonResponseIflexApiRecharge = buildIflexApiRechargeErrorJson(service, responseCode, jsonResponseIflexApiRecharge);
	 			}
	 			if(responseCode >= HttpServletResponse.SC_BAD_REQUEST) {
	 				LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE"+ service+"Response: "+jsonResponseIflexApiRecharge + " json: "+json);	
	 			}
	 			LoggerApi.Log.info("API TOKENGENERATION IFEXAPI-RECHARGE "+service+"Response: "+jsonResponseIflexApiRecharge);
			} catch (Throwable e) {
				LoggerApi.severe(e);
			}finally {
				LoggerApi.Log.info("end requestWSIflexApiRecharge: "+jsonResponseIflexApiRecharge);
			}
			return jsonResponseIflexApiRecharge;
		}

		private static boolean looksLikeJsonObject(String body) {
			if (body == null) {
				return false;
			}
			String trimmed = body.trim();
			return trimmed.startsWith("{") && trimmed.endsWith("}");
		}

		private static String buildIflexApiRechargeErrorJson(String service, int httpCode, String rawBody) {
			String safeService = (service == null) ? "" : service;
			String safeRaw = (rawBody == null) ? "" : rawBody;
			safeRaw = safeRaw.replace("\\", "\\\\");
			safeRaw = safeRaw.replace("\"", "\\\"");
			safeRaw = safeRaw.replace("\r", "\\r").replace("\n", "\\n").replace("\t", "\\t");
			if (safeRaw.length() > 1000) {
				safeRaw = safeRaw.substring(0, 1000);
			}
			String message = (httpCode == HttpServletResponse.SC_UNAUTHORIZED) ? "UNAUTHORIZED" : "NON_JSON_RESPONSE";
			return "{\"status\":\"ERROR\",\"httpCode\":" + httpCode + ",\"service\":\"" + safeService + "\",\"message\":\"" + message + "\",\"raw\":\"" + safeRaw + "\"}";
		}
}