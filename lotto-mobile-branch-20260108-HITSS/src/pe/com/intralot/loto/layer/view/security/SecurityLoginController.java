package pe.com.intralot.loto.layer.view.security;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import java.sql.SQLException;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.client.bo.PaymentPrizeBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.dto.pam.SecurityTokenResponse;
import pe.com.intralot.loto.layer.dto.reniec.DataReniecResponse;
import pe.com.intralot.loto.layer.dto.reniec.ReniecWsRequest;
import pe.com.intralot.loto.layer.dto.reniec.ReniecWsResponse;
import pe.com.intralot.loto.layer.model.pojo.ImgDto;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetLastNotifications;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureHasPendingNotificationsRead;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdateNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocuments;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocumentsTemplate;
import pe.com.intralot.loto.layer.model.bean.Reclamacion;
import pe.com.intralot.loto.layer.model.bean.ResultBean;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientMail;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateSmsRegister;
import pe.com.intralot.loto.layer.model.pojo.ClientTutorial;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ApiClient;
import pe.com.intralot.loto.utils.CasinoXpgUtils;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import sun.misc.BASE64Decoder;
import pe.com.intralot.loto.lib.StringLib;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pe.com.intralot.loto.utils.Constantes.getPropertyContextSale;

/**
 * <p>
 * NOMBRE: SecurityLoginController.java
 * <br></p>
 * <p>
 * FUNCION: Controlador de inicio de sesiÛn
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  MÈtodos de activaciÛn y rechazo del bono TA por recargas Interbank
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Controller
public class SecurityLoginController {

    @Autowired
    private SecurityLoginBo beanSecurityLoginBo;
    @Autowired
	private ClientBalanceBo beanClientBalanceBo;
    @Autowired
	private ClientAccountBo beanClientAccountBo;
    @Autowired
    private IntralotUtils intralotUtils;
    @Autowired
    private SecurityUtils securityUtils;    
    @Autowired
    private SecurityLoginBo securityLoginBo;
	@Autowired
	private PaymentPrizeBo paymentPrizeBo;
	@Autowired
	private ClientLotocardBo clientBo;
    
    @RequestMapping(value = "/autocontrol")
    public String autocontrol(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
    		return "client/interface-autocontrol";
    	}else{
    		return "home/interface-home";
    	}
    }
    
    @RequestMapping(value = "/tutoriales")
    public String tutoriales(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String juegos	= request.getParameter("juegos");
    	objectModelMap.put("juegos", juegos); 
    	 return "client/interface-tutoriales";
    }
    
    @RequestMapping(value = "/notificaciones")
    public String notificaciones(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
    		return "client/interface-notificaciones";
    	}else{
    		return "home/interface-home";
    	}
    }
    
	@RequestMapping(value = "/bienvenido")
    public String bienvenido(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
		try {
			if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
				return "client/interface-welcome";
			}else{
				return "home/interface-home";
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			return "redirect:/home.html";
		}
    }
    
    @RequestMapping(value = "/getNotifications")
    public void getNotifications(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        Gson gson = new Gson();
        try {        	
        	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
        		Integer clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
        		List<PaymentPrizeProcedureGetNotifications> lista = paymentPrizeBo.getNotifications(clientId);
        		o.addProperty("status", "OK");
        		o.addProperty("listaNotificaciones", gson.toJson(lista));
        		session.setAttribute("listaNotificaciones", gson.toJson(lista));
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/getLastNotifications")
    public void getLastNotifications(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        Gson gson = new Gson();
        try {        	
        	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
        		Integer clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
        		List<PaymentPrizeProcedureGetLastNotifications> lista = paymentPrizeBo.getLastNotifications(clientId);
        		o.addProperty("status", "OK");
        		o.addProperty("lastNotifications", gson.toJson(lista));
        		session.setAttribute("lastNotifications", gson.toJson(lista));
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/hasPendingNotificationsRead")
    public void hasPendingNotificationsRead(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        try {        	
        	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
        		Integer clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
        		PaymentPrizeProcedureHasPendingNotificationsRead obj = paymentPrizeBo.hasPendingNotificationsRead(clientId);
        		o.addProperty("status", "OK");
        		if(obj.getPendientes()>0) {
        			o.addProperty("notificacionesPendientes", obj.getPendientes());
            		session.setAttribute("notificacionesPendientes", obj.getPendientes());
        		}else {
        			o.addProperty("notificacionesPendientes", obj.getPendientes());
            		session.setAttribute("notificacionesPendientes", 0);
        		}
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }
    
    @RequestMapping(value = "/updateNotification")
    public void updateNotification(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        try { 
        	if (session != null && session.getAttribute(Constantes.CLIENT_SESION) != null) {
        		Integer clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION)).getClientId();
        		String idNotificacion = request.getParameter("idNotificacion");
        		PaymentPrizeProcedureUpdateNotification obj = paymentPrizeBo.updateNotification(clientId, idNotificacion);
        		o.addProperty("status", obj.getMessage());
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("status", "ERROR");
			out.print(o);
			LoggerApi.severe(e);
		}
    }

    @RequestMapping(value = "/promociones")
    public String promociones(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String loterias	= request.getParameter("loterias");
    	objectModelMap.put("loterias", loterias);
    	 return "client/interface-promociones";
    }
    
    @RequestMapping(value = "/preguntas-frecuentes")
    public String preguntasFrecuentes(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/interface-preguntas-frecuentes";
    }
    
    @RequestMapping(value = "/terminos-condiciones")
    public String terminosCondiciones(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/interface-terminos-condiciones";
    }
	@RequestMapping(value = "/derechos-arco")
    public String formDerechosArco(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {		 
    	 return "wp/interface_form_derechos_arco";
    }
    
    @RequestMapping(value = "/politica-datos")
    public String politicaDatosPersonales(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/interface-politica-datos";
    }
    
    @RequestMapping(value = "/persona-politicamente-expuesta")
    public String personaPoliticamenteExpuesta(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/interface-ppe";
    }
    
//    @RequestMapping(value = "/derechos-arco")
//    public String derechosArco(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
//    	 return "client/interface-derechos-arco";
//    }
    
    @RequestMapping(value = "/politica-cookies")
    public String politicaCookies(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	 return "client/interface-politica-cookies";
    }
    
   @RequestMapping(value = "/libro-reclamaciones")
   public String bookform(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
   	 return "client/form";
   }
   
   @RequestMapping(value = "/libro-reclamaciones-respuesta")
   public String bookecho(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
	   String secuencia	= request.getParameter("secuencia"); 
	   if(secuencia!=null) {
		   return "client/echo";
	   }else {
		   return "client/form";
	   }
   }
   
   @RequestMapping("/registrarReclamacion")
   public void registrarReclamacion(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	JsonObject o = new JsonObject();
   	PrintWriter out = response.getWriter();
   	try {
   		String dni         = request.getParameter("document-number");
       	String email       = request.getParameter("email");
       	String nombre      = request.getParameter("nombre");
       	String direccion   = request.getParameter("direccion");
       	String telefono    = request.getParameter("telefono");
       	String tipobien    = request.getParameter("tipobien");
       	String monto       = request.getParameter("monto");
       	String bien        = request.getParameter("bien");
       	String tiporeclamo = request.getParameter("tiporeclamo");
       	String reclamo     = request.getParameter("reclamo");
       	String pedido      = request.getParameter("pedido");
       	String imgTinka= "https://www.latinka.com.pe/latinka/mailing-sale/logo_tinka.gif?v=2";
		String imgBanner ="https://www.latinka.com.pe/latinka/mailing-sale/collage-logos.gif?v=2";
		String[]  imgEviList = new String[3];
		
   		imgEviList[0] = request.getParameter("imgEvi1")!=null?request.getParameter("imgEvi1").replace(" ","+") :"";
   		imgEviList[1] = request.getParameter("imgEvi2")!=null?request.getParameter("imgEvi2").replace(" ","+") :"";
   		imgEviList[2] = request.getParameter("imgEvi3")!=null?request.getParameter("imgEvi3").replace(" ","+") :"";
   		
       	Reclamacion reclamacion = new Reclamacion();
       	reclamacion.setId(109951);
       	reclamacion.setNombre(nombre);
       	reclamacion.setDireccion(direccion);
       	reclamacion.setDni(dni);
       	reclamacion.setTelefono(telefono);
       	reclamacion.setEmail(email);
       	reclamacion.setTipoBien(tipobien);
       	reclamacion.setBien(bien);
       	reclamacion.setTipoReclamo(tiporeclamo);
       	reclamacion.setReclamo(reclamo);
       	reclamacion.setMonto(monto);
       	reclamacion.setPedido(pedido);
       	reclamacion.setImgEviList(imgEviList); 
       	
       	List<ImgDto> listaImgDto= new ArrayList<ImgDto>();
       	BufferedImage image = null;
		try {
			for(int i=0;i<imgEviList.length;i++) {
	       		if(!imgEviList[i].trim().isEmpty()) {
	       			System.out.println("BASE64["+imgEviList[i]+"] ");
					Double peso = 0.0;
					BASE64Decoder decoder = new BASE64Decoder();
					ImgDto imgdto = new ImgDto();
					byte[] decodedBytes = decoder.decodeBuffer(imgEviList[i].substring(imgEviList[i].indexOf(",")+1)); 
					String extension = imgEviList[i].substring(imgEviList[i].indexOf("/")+1,imgEviList[i].indexOf(";")) ;
					peso = (double) decodedBytes.length;
					if( (peso/1024/1024)<=10.0) {
						try {
							 ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
							 image = ImageIO.read(bis);
							 bis.close();
					        
		        			imgdto.setContenidoImg(decodedBytes);
		        			imgdto.setFileName("img"+(i+1)+"."+extension);
		        			if(extension.contains("png")) {
		        				imgdto.setTipoImg("image/png");
		        			}else if(extension.contains("jpeg")) {
		        				imgdto.setTipoImg("image/jpeg");
		        			}else if(extension.contains("jpg")) {
		        				imgdto.setTipoImg("image/jpg");
		        			}
		        			listaImgDto.add(imgdto);
						}catch(Exception e) {
							System.out.println("El archivo no es una imagen");
							System.out.println("catch IOException : "+e.getMessage());
							o.addProperty("message", "KO");
							o.addProperty("error", "<p>Debes adjuntar im·genes v&aacute;lidas</p>");
							out.print(o);
						}
		    		}else {
		    			o.addProperty("message", "KO");
		    			o.addProperty("error", "T&uacute;s im·genes de Evidencia no debe ser mayor a 10MB");
		    			out.print(o);
		    		}
				}
	    	}
		
       	
			try {
       		
		       	reclamacion = beanClientAccountBo.registrarReclamacion(reclamacion);
		       		
		       	String body = cuerpoMail(imgTinka,imgBanner,reclamacion,0);
		       	String subject = cuerpoMail(imgTinka,imgBanner,reclamacion,1);
		       	
		       	pe.com.intralot.loto.utils.MailLib.sendMail(email , subject , body);
		        pe.com.intralot.loto.lib.MailLib.sendValidMail("reclamos@latinka.com.pe" , subject , body);
		        
		        String sdBody = cuerpoMail(imgTinka,imgBanner,reclamacion,2);
		        String sdSubject = cuerpoMail(imgTinka,imgBanner,reclamacion,3);
		        System.out.println("enviando el correo");
		       	//sendRawMail("reclamosvirtuales@latinka.com.pe","AtencionesSD@latinka.com.pe", sdSubject, sdBody,listaImgDto);
		        sendRawMail("reclamosvirtuales@latinka.com.pe","ventasaltas@sdp731217583.zm.sdpondemand.com", sdSubject, sdBody,listaImgDto);
		        try { sendRawMail("reclamosvirtuales@latinka.com.pe","soporteweb@latinka.com.pe", sdSubject, sdBody,listaImgDto); } catch (Exception e) {;}

		       	o.addProperty("message", "OK");
		       	o.addProperty("dni", dni);
		       	o.addProperty("email", email);
		       	o.addProperty("nombre", nombre);
		       	o.addProperty("direccion", direccion);
		       	o.addProperty("telefono", telefono);
		       	o.addProperty("tipobien", tipobien);
		       	o.addProperty("monto", monto);
		       	o.addProperty("bien", bien);
		       	o.addProperty("tiporeclamo", tiporeclamo);
		       	o.addProperty("reclamo", reclamo);
		       	o.addProperty("pedido", pedido);
		       	o.addProperty("secuencia", reclamacion.getSecuencia());
		       	o.addProperty("fecha", reclamacion.getFecha());
		       	out.print(o);
       	
	       	}catch(SQLException e) {
	       		System.out.println("catch SQL Exception: " + e.getMessage());
				o.addProperty("message", "KO");
				o.addProperty("error", "<p>Ya existe Reclamaci&oacute;n con fecha de hoy para su DNI:"+reclamacion.getDni()+"</p>");
				out.print(o);
	       	 }
		}catch(Exception e) {
			System.out.println("catch de imagenes Exception: " + e.getMessage());
			o.addProperty("message", "KOImg");
			o.addProperty("error", "<p>Se produjo un error inesperado al cargar las im&aacute;genes, int&eacute;ntelo nuevamente</p>");
			out.print(o);
		 } 
	} catch (Exception e) {
		pe.com.intralot.loto.lib.MailLib.sendValidMail("DesarrollodeSistemas@latinka.com.pe" , "LIBRO DE RECLAMACIONES "+e.getMessage(), e.toString() );
		System.out.println("catch final Exception: " + e.getMessage());
		e.printStackTrace();
		o.addProperty("message", "KO");
		o.addProperty("error", "<p>Revise los datos antes de enviarlos. Alguno de ellos puede tener un tama&ntilde;o muy grande o no es compatible.</p>");
		out.print(o);
	}
   }


	private String cuerpoMail(String imgTinka,String imgBanner,Reclamacion reclamacion,int parteMail) {
	String cuerpo= "";
	switch(parteMail) {
		case 0:
			cuerpo = "<html>\r\n" + 
	    			"<head>\r\n" + 
	    			"<title>La Tinka - Libro de Reclamaciones</title>\r\n" + 
	    			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	    			"</head>\r\n" + 
	    			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
	    			"\r\n" + 
	    			"<table width=\"600\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>\r\n" + 
	    			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"3\">\r\n" + 
	    			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>\r\n" + 
	    			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong> " +reclamacion.getNombre()+ "</strong></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"50\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">Tu reclamo N∞ "+reclamacion.getSecuencia()+" ha sido registrado y ser&aacute; atendido dentro del plazo establecido. Te enviamos una copia de los datos recibidos.</td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"	<td width=\"20\"></td>\r\n" + 
	    			"	<td width=\"430\" bgcolor=\"#ffffff\" style=\"display:block; color:#5a5a5a; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">\r\n" + 
	    			"		<strong>HOJA DE RECLAMACI&Oacute;N </strong><br><br>\r\n" + 
	    			"		Fecha: "+reclamacion.getFecha()+"<br>\r\n" + 
	    			"		<br>\r\n" + 
	    			"		<strong>1. IDENTIFICACI&Oacute;N DEL CONSUMIDOR RECLAMANTE </strong><br><br>\r\n" + 
	    			"		Nombre: "+reclamacion.getNombre()+"<br>\r\n" + 
	    			"		Domicilio: "+reclamacion.getDireccion()+"<br>\r\n" + 
	    			"		DNI/CE: "+reclamacion.getDni()+"<br>\r\n" + 
	    			"		Tel&eacute;fono: "+reclamacion.getTelefono()+"<br>\r\n" + 
	    			"		E-mail: "+reclamacion.getEmail()+"<br>\r\n" + 
	    			"		<br>\r\n" + 
	    			"		<strong>2. IDENTIFICACI&Oacute;N DEL BIEN CONTRATADO</strong><br>\r\n" + 
	    			"		"+reclamacion.getTipoBien()+"<br>\r\n" + 
	    			"		Monto reclamado: "+reclamacion.getMonto()+"<br>\r\n" + 
	    			"		Descripci&oacute;n: "+reclamacion.getBien()+"<br>\r\n" + 
	    			"		<br>\r\n" + 
	    			"		<strong>3. DETALLE DE LA RECLAMACI&Oacute;N</strong><br>\r\n" + 
	    			"		"+reclamacion.getTipoReclamo()+"<br>\r\n" + 
	    			"		Detalle: "+reclamacion.getReclamo()+"<br>\r\n" + 
	    			"		Pedido: "+reclamacion.getPedido()+"<br>\r\n" + 
	    			"		<br>\r\n" + 
	    			"\r\n" + 
	    			"		</td>\r\n" + 
	    			"		<td width=\"20\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td width=\"20\"></td>\r\n" + 
	    			"		<td bgcolor=\"#ffffff\" width=\"430\" alt=\"\" style=\"display:block; color:#707070; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:11px; padding-left\">Responderemos tu reclamo en un plazo de 15 d&iacute;as h&aacute;biles, el cual empieza a contar a partir del d&iacute;a siguiente de ingresado.\r\n" + 
	    			"		<br><br></td>\r\n" + 
	    			"		<td width=\"20\"></td>\r\n" + 
	    			"	</tr>	\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"5\" bgcolor=\"#dedede\">\r\n" + 
	    			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"	<tr>\r\n" + 
	    			"		<td colspan=\"5\" bgcolor=\"#dedede\" width=\"600\" height=\"20\" alt=\"\"></td>\r\n" + 
	    			"	</tr>\r\n" + 
	    			"</table>\r\n" + 
	    			"</body>\r\n" + 
	    			"</html>";
			break;
		case 1:
			cuerpo = "Hoja de ReclamaciÛn 109951-"+reclamacion.getSecuencia();
			break;
		case 2:
			cuerpo = "##OPERATION=ADD_REQUEST##\r\n"+
			"##REQUESTTEMPLATE=Reclamos##\r\n"+
			"##CATEGORY=Reclamos##\r\n"+
			"##SUBCATEGORY=Por determinar##\r\n"+
			"##ITEM=Por determinar##\r\n"+
			"##REQUESTER=Service Desk##\r\n"+
			"##REQUESTTYPE=Incident##\r\n"+
			"\r\n"+
			"##SUBJECT=Hoja de ReclamaciÛn Virtual 109951-"+reclamacion.getSecuencia()+"##\r\n"+   
			"##UDF_CHAR12="+reclamacion.getNombre()+"##\r\n"+
			"##UDF_CHAR13="+reclamacion.getDireccion()+"##\r\n"+
			"##UDF_CHAR14=DNI"+reclamacion.getDni()+"##\r\n"+
			"##UDF_CHAR15="+reclamacion.getTelefono()+"##\r\n"+
			"##UDF_CHAR16="+reclamacion.getEmail()+"##\r\n"+
			"##UDF_CHAR17="+reclamacion.getTipoBien()+"##\r\n"+
			"##UDF_DOUBLE2="+reclamacion.getMonto()+"##\r\n"+
			"##UDF_CHAR21="+reclamacion.getBien()+"##\r\n"+
			"##UDF_CHAR18="+reclamacion.getTipoReclamo()+"##\r\n"+
			"##UDF_CHAR19="+reclamacion.getReclamo()+"##\r\n"+
			"##UDF_CHAR20="+reclamacion.getPedido()+"##\r\n"+
			"##UDF_CHAR22=Hoja de ReclamaciÛn Virtual##\r\n";
			cuerpo += "\r\n\r\n" + cuerpo.replace("<br/>", "\r\n");
			break;	
		case 3:
			cuerpo = "###ASD Hoja de ReclamaciÛn Virtual 109951-"+reclamacion.getSecuencia(); 
			break; 
	}
	
	return cuerpo;
}

	private void sendRawMail(String mailSource, String mailTarget, String mailSubject, String mailBody,List<ImgDto> listImgDto) {
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendRawMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendRawMail mailSubject="+mailSubject);
			System.out.println("sendRawMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendRawMail session=java:Mail");
				 
				System.out.println( "host="+session.getProperty("mail.smtp.host") );
				System.out.println( "port="+session.getProperty("mail.smtp.port") );
				System.out.println( "from="+session.getProperty("mail.from") );
				System.out.println( "user="+session.getProperty("User") );
			
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendRawMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendRawMail mailServer="+mailServer);
			}
			
			// construct the message

			Message msg = new MimeMessage(session);
			
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailBody, contentType);
			
			multipart.addBodyPart(messageBodyPart);
			
			if(listImgDto != null) {
				for(ImgDto imgdto : listImgDto) {
	        		BodyPart adjunto = new MimeBodyPart();
		       		ByteArrayDataSource attachment = new  ByteArrayDataSource(imgdto.getContenidoImg(),imgdto.getTipoImg());
		       		adjunto.setDataHandler(new DataHandler(attachment));
		            adjunto.setFileName(imgdto.getFileName());
		            multipart.addBodyPart(adjunto);
	        	}
			}
        	
			System.out.println("sendRawMail contentType="+contentType);

			
			// enviamos todo el contenido
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			msg.setContent(multipart, contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendRawMail mailSource="+mailSource+" mailTarget="+mailTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static void sendRawMail(String mailSource, String mailTarget, String mailSubject, String mailBody)  
	{ 
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendValidMail mailSubject="+mailSubject);
			System.out.println("sendValidMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendValidMail session=java:Mail");
				 
				try {
					System.out.println( "host="+session.getProperty("mail.smtp.host") );
					System.out.println( "port="+session.getProperty("mail.smtp.port") );
					System.out.println( "from="+session.getProperty("mail.from") );
					System.out.println( "user="+session.getProperty("User") );
				} catch (Exception e) {
					;
				}
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendValidMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendValidMail mailServer="+mailServer);
			}
		// construct the message

			Message msg = new MimeMessage(session);
			
			//InternetAddress[] ccaddress = new InternetAddress[1];
			//ccaddress[0] = new InternetAddress(mailTarget);//(destino);
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}

			//System.out.println("mailSource="+mailSource+" mailTarget="+mailTarget+" mailSubject="+mailSubject);
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			//msg.setContent(mailBody, "text/html; charset=UTF-8");//(cuerpo,content);

			System.out.println("sendValidMail contentType="+contentType);
			
			msg.setContent(mailBody, contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
  
   @RequestMapping(value = "/contacto")
   public String contacto(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
   	 return "client/interface-contacto";
   }

	@RequestMapping("/security_login_execute_authentication")
    public ModelAndView executeAuthentication(HttpServletRequest request,ModelMap objectModelMap) throws Exception {
        LoggerApi.Log.info("");
        
        boolean status = false;
        HttpSession session = request.getSession();
        session.setAttribute("locacionTYC", "nn");
        String redirect = "home.html";
        TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocs = new TYCPDPProcedureConsultPendingDocumentsTemplate();
        try {
        	LoggerApi.Log.info("Navigator="+request.getParameter("user-browser"));
            LoggerApi.Log.info("UserAgent="+request.getHeader("User-Agent")+" IP="+request.getRemoteAddr());
            
        	if(session.getAttribute("clientId") != null) status = true;
        	
        	if(request.getParameter("boleto")!=null) {
        		LoggerApi.Log.info("/security_login_execute_authentication boleto="+request.getParameter("boleto"));
        		session.setAttribute("carrierBoleto", request.getParameter("boleto").toString());
        	}
        	
            request.setAttribute("OperatorId", String.valueOf(request.getParameter("operatorId")).toString().trim());
            
            LoggerApi.Log.info("/security_login_execute_authentication status="+status);
            if (!status) {
                if (StringUtils.isNotEmpty(request.getParameter("display")))
                    session.setAttribute("display", request.getParameter("display"));
                LoggerApi.Log.info("/security_login_execute_authentication display="+ request.getParameter("display"));
                session.setAttribute("locacionTYC", "login");
                return new ModelAndView("security/interface-authentication");
            }
            
        	LoggerApi.Log.info("/security_login_execute_authentication display="+session.getAttribute("display"));
            if (!StringUtils.isNotEmpty((String) session.getAttribute("display"))) {
            	return new ModelAndView("redirect:"+redirect);
            }
            
            String displayte=(String)session.getAttribute("display");
            
                    if (StringUtils.equals(Constantes.GameTeapuesto.DISPLAY_TEAPUESTO, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_teapuesto_play_bet.html");
                        redirect = "game_teapuesto_play_bet.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTinkaMegabol.DISPLAY_TINKAMEGABOL, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_tinkamegabol_play_bet.html");
                        redirect = "game_tinkamegabol_play_bet.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTinka.DISPLAY_TINKA, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_tinka_play_bet_result.html");
                        redirect = "game_tinka_play_bet_result.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTinka.DISPLAY_TINKAEXPRESS, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_tinka_play_bet_result.html");
                        redirect = "game_tinka_play_bet_result.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTinka.DISPLAY_TINKA_SUSCRIPCION, displayte)) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_tinka_play_bet_result_suscription.html");
                        redirect = "game_tinka_play_bet_result_suscription.html";
                    }
                    else if (StringUtils.equals(Constantes.GameGanagol.DISPLAY_GANAGOL, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_ganagol_play_bet_result.html");
                        redirect = "game_ganagol_play_bet_result.html";
                    }
                    else if (StringUtils.equals(Constantes.GameGanadiario.DISPLAY_GANADIARIO, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_ganadiario_play_bet_result.html");
                        redirect = "game_ganadiario_play_bet_result.html";
                    }
                    else if (StringUtils.equals(Constantes.GameGanadiario.DISPLAY_GANADIARIO_SUSCRIPCION, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_ganadiario_play_bet_result_suscription.html");
                        redirect = "game_ganadiario_play_bet_result_suscription.html";
                    } 
                    else if (StringUtils.equals(Constantes.GameKabala.DISPLAY_KABALA, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_kabala_play_bet_result.html");
                        redirect = "game_kabala_play_bet_result.html";
                    }
                    else if (StringUtils.equals(Constantes.GameKabala.DISPLAY_KABALA_SUSCRIPCION, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                        //return new ModelAndView("redirect:game_kabala_play_bet_result_suscription.html");
                        redirect = "game_kabala_play_bet_result_suscription.html";
                    }
                    else if (StringUtils.equals(Constantes.GameKinelo.DISPLAY_KINELO, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:game_kinelo_play_bet_result_login.html");
                redirect = "game_kinelo_play_bet_result_login.html";
                    }
                    else if (StringUtils.equals(Constantes.CopaCasa.DISPLAY_COPACASA, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:game_copaentucasa_results.html");
                redirect = "game_copaentucasa_results.html";
                    }
                    else if (StringUtils.equals(Constantes.CopaBicolor.DISPLAY_COPABICOLOR, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:registrarcopabicolor.html");
                redirect = "registrarcopabicolor.html";
                    }
                    else if (StringUtils.equals(Constantes.GameGanagol.DISPLAY_PREMIAZOGANAGOL, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:registrarpromopremiazoganagol.html");
                redirect = "registrarpromopremiazoganagol.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTeapuesto.DISPLAY_AVIONQATAR, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:te-apuesto-te-lleva-final-qatar-registrar.html");
                redirect = "te-apuesto-te-lleva-final-qatar-registrar.html";
                    }
                    else if (StringUtils.equals(Constantes.GameVirtuales.DISPLAY_JUEGA_GANA_DDVV, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:juega-y-gana-con-virtuales-registrar.html");
                redirect = "juega-y-gana-con-virtuales-registrar.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTeapuesto.DISPLAY_AVIONESTAMBUL, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:te-apuesto-te-lleva-final-estambul-registrar.html");
                redirect = "te-apuesto-te-lleva-final-estambul-registrar.html";
                    }
                    else if (StringUtils.equals(Constantes.GameTeapuesto.DISPLAY_AVIONPERU, (String) session.getAttribute("display"))) {
                        session.removeAttribute("display");
                // return new ModelAndView("redirect:te-apuesto-te-lleva-copa-registrar.html");
                redirect = "te-apuesto-te-lleva-copa-registrar.html";
                    }
                    else if(StringUtils.contains((String) session.getAttribute("display"),Constantes.GameVirtuales.DISPLAY_JUEGA_GANA_DDVV_2)) {
                    	String display = (String) session.getAttribute("display");
                    	session.removeAttribute("display");
            	// return new ModelAndView("redirect:"+display+".html");
            	redirect = display + ".html";
                    }
                    else if(StringUtils.contains((String) session.getAttribute("display"),Constantes.GameTeapuesto.DISPLAY_AVIONESTAMBUL_2)) {
                    	String display = (String) session.getAttribute("display");
                    	
                    	session.removeAttribute("display");
            	// return new ModelAndView("redirect:"+display+".html");
            	redirect = display + ".html";
                    }
                    else if(StringUtils.contains((String) session.getAttribute("display"),Constantes.GameTeapuesto.DISPLAY_AVIONPERU_2NEW)) {
                    	String display = (String) session.getAttribute("display");
                    	
                    	session.removeAttribute("display");
            	// return new ModelAndView("redirect:"+display+".html");
            	redirect = display + ".html";
            }
            
            Integer clientId = 0;
			clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId();
			dataPendingDocs = securityUtils.validatePendingDocumentsForApproval(clientId);
			ArrayList<TYCPDPProcedureConsultPendingDocuments> documentsList = dataPendingDocs.getDocuments();
			
			if (!documentsList.isEmpty()) {
				session.setAttribute("redirectCaseLoginCompraTYCPDP", redirect);
				return new ModelAndView("redirect:home.html");
                    }
              
	        return new ModelAndView("redirect:" + redirect);
  
        } catch (Exception e) {
            LoggerApi.severe(e);
            session.setAttribute("locacionTYC", "login");
            return new ModelAndView("security/interface-authentication");
        }
    }
	
    @RequestMapping(value = "/redireccionar")
    public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 return new ModelAndView("client/redirect");
    }
	/*
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	@ResponseBody
	public void createCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int tamanioCodigoCaptcha = CaptchaRandomization.getRandomCodeLength(Integer.valueOf("4"), Integer.valueOf("5"));
		IImageGenerator generadorImagen;
		String levelCaptcha = ((ConnectionFactory.operationProperty("levelCaptcha", Constantes.contextSale) != null)?ConnectionFactory.operationProperty("levelCaptcha", Constantes.contextSale).trim():"2");
		switch (Integer.valueOf(levelCaptcha)) {
			case 1: generadorImagen = new AncientMosaicImageGenerator(); break;
			case 2: generadorImagen = new BlackOverlapImageGenerator(); break;
			case 3: generadorImagen = new BubblesImageGenerator(); break;
			case 4: generadorImagen = new Bullets2ImageGenerator(); break;
			case 5: generadorImagen = new BulletsImageGenerator(); break;
			case 6: generadorImagen = new CaughtInTheNet2ImageGenerator(); break;
			case 7: generadorImagen = new CaughtInTheNetImageGenerator(); break;
			case 8: generadorImagen = new ChalkboardImageGenerator(); break;
			case 9: generadorImagen = new Chess3DImageGenerator(); break;
			case 10: generadorImagen = new ChessImageGenerator(); break;
			case 11: generadorImagen = new ChippedImageGenerator(); break;
			case 12: generadorImagen = new CirclesImageGenerator(); break;
			case 13: generadorImagen = new CollageImageGenerator(); break;
			case 14: generadorImagen = new CorrosionImageGenerator(); break;
			case 15: generadorImagen = new CrossShadow2ImageGenerator(); break;
			case 16: generadorImagen = new CrossShadowImageGenerator(); break;
			case 17: generadorImagen = new CutImageGenerator(); break;
			case 18: generadorImagen = new DartsImageGenerator(); break;
			case 19: generadorImagen = new DistortionImageGenerator(); break;
			case 20: generadorImagen = new ElectricImageGenerator(); break;
			case 21: generadorImagen = new FingerprintsImageGenerator(); break;
			case 22: generadorImagen = new FlashImageGenerator(); break;
			case 23: generadorImagen = new GhostlyImageGenerator(); break;
			case 24: generadorImagen = new Graffiti2ImageGenerator(); break;
			case 25: generadorImagen = new GraffitiImageGenerator(); break;
			case 26: generadorImagen = new HaloImageGenerator(); break;
			case 27: generadorImagen = new InBandagesImageGenerator(); break;
			case 28: generadorImagen = new JailImageGenerator(); break;
			case 29: generadorImagen = new LegoImageGenerator(); break;
			case 30: generadorImagen = new MassImageGenerator(); break;
			case 31: generadorImagen = new MeltingHeat2ImageGenerator(); break;
			case 32: generadorImagen = new MeltingHeatImageGenerator(); break;
			case 33: generadorImagen = new NegativeImageGenerator(); break;
			case 34: generadorImagen = new Neon2ImageGenerator(); break;
			case 35: generadorImagen = new NeonImageGenerator(); break;
			case 36: generadorImagen = new Overlap2ImageGenerator(); break;
			case 37: generadorImagen = new OverlapImageGenerator(); break;
			case 38: generadorImagen = new PaintMessImageGenerator(); break;
			case 39: generadorImagen = new RadarImageGenerator(); break;
			case 40: generadorImagen = new Ripple2ImageGenerator(); break;
			case 41: generadorImagen = new RippleImageGenerator(); break;
			case 42: generadorImagen = new RoughImageGenerator(); break;
			case 43: generadorImagen = new SnowImageGenerator(); break;
			case 44: generadorImagen = new SpiderWeb2ImageGenerator(); break;
			case 45: generadorImagen = new SpiderWebImageGenerator(); break;
			case 46: generadorImagen = new Split2ImageGenerator(); break;
			case 47: generadorImagen = new SplitImageGenerator(); break;
			case 48: generadorImagen = new StitchImageGenerator(); break;
			case 49: generadorImagen = new StrippyImageGenerator(); break;
			case 50: generadorImagen = new SunAndWarmAirImageGenerator(); break;
			case 51: generadorImagen = new Sunrays2ImageGenerator(); break;
			case 52: generadorImagen = new SunraysImageGenerator(); break;
			case 53: generadorImagen = new ThickThinLines2ImageGenerator(); break;
			case 54: generadorImagen = new ThickThinLinesImageGenerator(); break;
			case 55: generadorImagen = new ThinWavyLettersImageGenerator(); break;
			case 56: generadorImagen = new VertigoImageGenerator(); break;
			case 57: generadorImagen = new WantedCircularImageGenerator(); break;
			case 58: generadorImagen = new WaveImageGenerator(); break;
			case 59: generadorImagen = new WavyChessImageGenerator(); break;
			default: generadorImagen = new WavyColorLettersImageGenerator(); break;
		}
		
		ImageSize imageSize = new ImageSize(200, 60);
		CodeStyle estiloCodigoGenerar = CodeStyle.ALPHANUMERIC;
		String textoCaptchaGenerado = generarValorCaptcha(CodeGenerationPurpose.IMAGE_GENERATION, tamanioCodigoCaptcha, estiloCodigoGenerar);
		HttpSession session = request.getSession();
		String captchaEncode = StringLib.encodeLabel(textoCaptchaGenerado);
		session.setAttribute("captcha", captchaEncode);
		final ByteArrayOutputStream captchaByteArrayOutputStream = generadorImagen.generateImage(textoCaptchaGenerado, CaptchaDefaults.LOCALIZATION, imageSize, null, null).getStream(ImageFormat.PNG);
		response.setHeader("Cache-Control", "private,no-cache,no-store");
		response.setContentType("image/" + ImageFormat.PNG.name().toLowerCase());
		response.getOutputStream().write(captchaByteArrayOutputStream.toByteArray());
	}
	
	private String generarValorCaptcha(final CodeGenerationPurpose paramCodeGenerationPurpose, final int tamanio, final CodeStyle codeStyle) {
		CodeCollection codeCollection = new CodeCollection();
		codeCollection.setCharacterSet(CharacterSetFactory.get(CaptchaDefaults.LOCALIZATION, CaptchaDefaults.CUSTOM_CHARACTER_SET_NAME));
		return codeCollection.getCode("", paramCodeGenerationPurpose, codeStyle, tamanio);
	}
	*/
    public boolean validateLength(HttpServletRequest request) {
		int userLength = 0;
		String user = request.getParameter("user"); // user-client
		
		if(user!=null) {
			userLength = user.length();
		} else {
			LoggerApi.Log.info("validateLength user=null");
			return false;
		}
		if(userLength==0 || userLength>35) {
			LoggerApi.Log.info("validateLength userLength="+userLength);
			return false;
		}
		String strippedUser = pe.com.intralot.loto.utils.StringLib.stripXSS(user);
		if (!strippedUser.equals(user)) {
			LoggerApi.Log.info("validateLength user="+user+" strippedUser="+strippedUser);
			return false;
		}
		
		int passwordLength = 0;
		String password = request.getParameter("password"); // password-client
		if(password!=null) {
			passwordLength = password.length();
		} else {
			LoggerApi.Log.info("validateLength password=null");
			return false;
		}
		if(passwordLength==0 || passwordLength>70) {
			LoggerApi.Log.info("validateLength passwordLength="+passwordLength);
			return false;
		}
		String strippedPassword = pe.com.intralot.loto.utils.StringLib.stripXSS(password);
		if (!strippedPassword.equals(password)) {
			try {
				LoggerApi.Log.info("validateLength password="+StringLib.encodeLabel(password)+" strippedPassword="+StringLib.encodeLabel(strippedPassword));
			} catch (Exception e) {}
			return false;
		}
		
		int contentLength = request.getContentLength();
		if(contentLength>419) { // la longitud por default para este request es de 214, por ello 319 considera la longitud del usuario y password
			LoggerApi.Log.info("validateLength request.getContentLength()="+request.getContentLength());
			return false;
		}
		return true;
	}
	
	public boolean validateLengthDocType(HttpServletRequest request) throws Exception {
		int userLength = 0;
		String[] lrdn=intralotUtils.decodeLabel(request.getParameter("lrdn")).split("-");
		String user = intralotUtils.decodeLabel(lrdn[0]).toLowerCase().trim();
		 
		
//		String user = request.getParameter("user"); // user-client
		
		if(user!=null) {
			userLength = user.length();
		} else {
			LoggerApi.Log.info("validateLength user=null");
			return false;
		}
		if(userLength==0 || userLength>35) {
			LoggerApi.Log.info("validateLength userLength="+userLength);
			return false;
		}
		String strippedUser = pe.com.intralot.loto.utils.StringLib.stripXSS(user);
		if (!strippedUser.equals(user)) {
			LoggerApi.Log.info("validateLength user="+user+" strippedUser="+strippedUser);
			return false;
		}
		
		int passwordLength = 0;
		String password = intralotUtils.decodeLabel(lrdn[1]); // password-client
		if(password!=null) {
			passwordLength = password.length();
		} else {
			LoggerApi.Log.info("validateLength password=null");
			return false;
		}
		if(passwordLength==0 || passwordLength>70) {
			LoggerApi.Log.info("validateLength passwordLength="+passwordLength);
			return false;
		}
		String strippedPassword = pe.com.intralot.loto.utils.StringLib.stripXSS(password);
		if (!strippedPassword.equals(password)) {
			try {
				LoggerApi.Log.info("validateLength password="+StringLib.encodeLabel(password)+" strippedPassword="+StringLib.encodeLabel(strippedPassword));
			} catch (Exception e) {}
			return false;
		}
		
		int docTypeLength = 0;
		String docType = request.getParameter("typeDoc"); 
		
		if(docType!=null) {
			docTypeLength = docType.length();
		} else {
			LoggerApi.Log.info("validateLength typeDoc=null");
			return false;
		}
		if(docTypeLength==0 || docTypeLength>5) {
			LoggerApi.Log.info("validateLength docTypeLength="+docTypeLength);
			return false;
		}
		String strippedDocType = pe.com.intralot.loto.utils.StringLib.stripXSS(docType);
		if (!strippedDocType.equals(docType)) {
			LoggerApi.Log.info("validateLength docType="+docType+" strippedUser="+strippedDocType);
			return false;
		}
		
		int contentLength = request.getContentLength();
		if(contentLength>419) { // la longitud por default para este request es de 214, por ello 319 considera la longitud del usuario y password
			LoggerApi.Log.info("validateLength request.getContentLength()="+request.getContentLength());
			return false;
		}
		return true;
	}
    
    @RequestMapping(value = "/redirectAccountActive")
    public void redirectAccountActive(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	LoggerApi.Log.info("-------------- START  redirectAccountActive");
    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
        JsonObject o = new JsonObject();
        
    	HttpSession session = request.getSession();
    	Integer clientIdRegister = (Integer) session.getAttribute("clientIdRegister");
    	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute("clientSesionTMP");
    	Client objectPojo=beanClientAccountBo.findClientById(clientIdRegister);
    	
    	Client clientS = new Client();
    	clientS.setClientId(objectPojo.getClientId());
    	clientS.setName(objectPojo.getName());
    	clientS.setLastname(objectPojo.getLastname());
    	clientS.setMaidenname(objectPojo.getMaidenname());
    	clientS.setMail(objectPojo.getMail());
    	clientS.setDocNumber(objectPojo.getDocNumber());
    	clientS.setDocType(objectPojo.getDocType());
    	HttpSession clientSession = request.getSession();
    	clientSession.setAttribute("CLIENT_SESSION", clientS);
    	clientSession.setAttribute("name",clientS.getName());
    	clientSession.setAttribute("lastname",clientS.getLastname());
    	clientSession.setAttribute("maidenname",clientS.getMaidenname());
    	clientSession.setAttribute("mail",clientS.getMail());
    	clientSession.setAttribute("cid",clientS.getClientId());
    	clientSession.setAttribute(Constantes.CLIENT_SESION, client);
    	clientSession.setAttribute("clientId",client.getClientId()+"");
    	clientSession.setAttribute("agreement","  ");

    	//eval visibilidad tutorial
    	if(Constantes.TUTORIAL_ENABLED.equals("true")) {
    		Object[] values = new Object[4];
    		values[0] = client.getClientId();
    		values[1] = Constantes.TUTORIAL_MAX_PER_DAY;
    		values[2] = Constantes.TUTORIAL_MAX_TOTAL;
    		values[3] = Constantes.TUTORIAL_MAX_DAYS;
    		ClientTutorial clientTutorial = beanClientAccountBo.evalTutorial(values);
    		clientSession.setAttribute("tutorial", clientTutorial);
    	}

    	o.addProperty("clientId", client.getClientId());
    	o.addProperty("agreement", "  ");
    	o.addProperty("message", Constantes.RESULT_OK);
    	o.addProperty("status", Constantes.RESULT_OK);
    	out.print(o);
    	LoggerApi.Log.info("-------------- END  redirectAccountActive");
    }
    
    @RequestMapping("/security_login_session")
    public void loginSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        
        if(!validateLength(request)) {
			o.addProperty("error", "LG");
        	o.addProperty("alertLogin", "Datos de ingreso incorrectos. Ingreso denegado.");
        	out.print(o);
			return;
		}

        ClientProcedureGetLoginData client = null;
        try {
        	HttpSession session = request.getSession();
        	session.removeAttribute("operatorId");
//        	String valor = request.getParameter("sentCaptcha");
//        	if(valor!=null && !valor.trim().isEmpty()) {
//        		Object captcha = session.getAttribute("captcha");
//    			if(captcha!=null && !captcha.toString().isEmpty()){
//    				String captchaDecode = StringLib.decodeLabel(captcha.toString());
//    				if(!valor.equalsIgnoreCase(captchaDecode)){
//    					session.setAttribute("captcha", null);
//    					o.addProperty("error", "LG");
//    					o.addProperty("alertLogin", "El cÛdigo ingresado es incorrecto");
//                    	out.print(o);
//    					return;
//    				}else {
//    					session.setAttribute("captcha", null);
//    					client = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
//    				}
//    			}else {
//    				session.setAttribute("captcha", null);
//    				o.addProperty("error", "LG");
//    				o.addProperty("alertLogin", "Datos no validos");
//                	out.print(o);
//    				return;
//    			}
//        	}else {
//        		session.setAttribute("captcha", null);
//				o.addProperty("error", "LG");
//				o.addProperty("alertLogin", "Acceso no valido");
//            	out.print(o);
//				return;
//        	}
        		
        	client = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
        	if(!client.getStatus().equals("OK")) {
        		o.addProperty("error", client.getStatus());
            	o.addProperty("alertLogin", client.getStatus());
            	o.addProperty("title", client.getTitle());
            	o.addProperty("message", client.getMessage());
            	String button=client.getButton();
            	o.addProperty("button", client.getButton());
            	if(button.equals("127")) {
            		o.addProperty("lrdn", session.getAttribute("lrdn").toString());
            		session.removeAttribute("lrdn");
            	}
            	out.print(o);
            	return;
        	
//            if(client == null || client.getState() == null) {
//            	o.addProperty("error", "LG");
//            	o.addProperty("alertLogin", "El usuario y/o clave son incorrectos");
//            	out.print(o);
//            	return;
//            } else if (client.getState().equals(-1)) {
//            	o.addProperty("error", "LG");
//            	o.addProperty("alertLogin", "El usuario y/o clave son incorrectos [-1]");
//            	out.print(o);
//            	return;
//            } else if (client.getState().equals(2)) {
//            	o.addProperty("error", "LG");
//            	o.addProperty("alertLogin", "El usuario y/o clave son incorrectos [2]");
//            	out.print(o);
//            	return;
//            } else if (client.getState().equals(3)) {
//            	o.addProperty("error", "LG");
//            	//o.addProperty("alertLogin", "El usuario y/o clave son incorrectos [3]");
//            	o.addProperty("alertLogin", "EL USUARIO O CONTRASE—A SON INV¡LIDOS");
//            	out.print(o);
//            	return;
//            } else if (client.getState().equals(5)) {
//            	o.addProperty("error", "LG");
//            	//o.addProperty("alertLogin", "El usuario y/o clave son incorrectos [5]");
//            	o.addProperty("alertLogin", "EL USUARIO O CONTRASE—A SON INV¡LIDOS");
//            	out.print(o);
//            	return;
//            } else if (client.getState().equals(4) || client.getState().equals(6) || client.getState().equals(7)) {
//            	o.addProperty("error", "LG");
//            	o.addProperty("alertLogin", "!Aplication Error ["+client.getState()+"]");
//            	out.print(o);
//            	return;
//            	else if (client.getState().equals(1)) {
            } else {
            	o = validarUsuarioJson(client,1,request);
            	Client objectPojo=beanClientAccountBo.findClientById(client.getClientId());
            	Client clientS = new Client();
            	clientS.setClientId(objectPojo.getClientId());
            	clientS.setName(objectPojo.getName());
            	clientS.setLastname(objectPojo.getLastname());
            	clientS.setMaidenname(objectPojo.getMaidenname());
            	clientS.setMail(objectPojo.getMail());
            	clientS.setDocNumber(objectPojo.getDocNumber());
            	clientS.setDocType(objectPojo.getDocType());
            	
            	
            	session.setAttribute("CLIENT_SESSION", clientS);
            	
            	session.setAttribute("name",clientS.getName());
            	session.setAttribute("lastname",clientS.getLastname());
            	session.setAttribute("maidenname",clientS.getMaidenname());
            	session.setAttribute("mail",clientS.getMail());
            	session.setAttribute("cid",clientS.getClientId());
            	out.print(o);
            	
            	// Corrije NullPointer en el session del lightbox de SMS
            	session.setAttribute(Constantes.CLIENT_SESION, client);
            	
            	//eval visibilidad tutorial
            	if(Constantes.TUTORIAL_ENABLED.equals("true")) {
                	Object[] values = new Object[4];
                	values[0] = client.getClientId();
                	values[1] = Constantes.TUTORIAL_MAX_PER_DAY;
                	values[2] = Constantes.TUTORIAL_MAX_TOTAL;
                	values[3] = Constantes.TUTORIAL_MAX_DAYS;
                	ClientTutorial clientTutorial = beanClientAccountBo.evalTutorial(values);
                	session.setAttribute("tutorial", clientTutorial);
            	}
            	            	
            	/*if(objectPojo.getPlayerIdXpg() == null) {
            		CasinoXpgUtils u = new CasinoXpgUtils("createPlayer",client.getClientId().toString(), beanSecurityLoginBo);            		
            		u.start();            		
            	}*/
            	
            	return;
            }
                
        } catch (Exception e) {
            LoggerApi.severe(e);
           
        } 
    }
    
    @RequestMapping(value = "/offTutorial")
	public void offTutorial(HttpServletRequest request, HttpServletResponse response,
			ModelMap objectModelMap) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("tutorial", null);
	}

    @RequestMapping("/security-close-session")
    public ModelAndView closeSession(HttpServletRequest request, ModelMap objectModelMap) throws Exception {
        try {
            LoggerApi.Log.info("");
            HttpSession session = request.getSession(false);
            ClientUpdateProcedureClosedSession closedSession=null;
            if (session != null) {
            	JsonParser jparser = new JsonParser();
            	if(session.getAttribute("sessionData")!=null) {            		
	            	JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
		        	Integer clientId=sessionData.get("clientId").getAsInt();
	                closedSession=clientBo.closedSession(clientId);
	                LoggerApi.Log.info("closedSession: estado="+closedSession.getState()+" mensaje="+closedSession.getMessage());
            	}
            	String urlTA=securityUtils.fetchTA(request);
            	session.invalidate();
            	session = request.getSession();
                session.setAttribute("urlTA", urlTA);
	            	
            }
            if(request.getParameter("urlRedirect5587") != null ) {
            	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== security-close-session urlRedirect5587="+request.getParameter("urlRedirect5587"));
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5587"));
            }
            if(request.getParameter("urlRedirect5588") != null )
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5588"));
            
            return new ModelAndView("redirect:home.html");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("redirect:home.html");
        }finally {
        	  
        }
    }
    
    @RequestMapping(value = "/close-session")
	public void closeSession(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
            	 session.invalidate();
            }            
            /*
            if(request.getParameter("urlRedirect5587") != null ) {
            	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== security-close-session urlRedirect5587="+request.getParameter("urlRedirect5587"));
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5587"));
            }
            if(request.getParameter("urlRedirect5588") != null )
            	return new ModelAndView("redirect:"+request.getParameter("urlRedirect5588"));
            
            return new ModelAndView("redirect:home.html");
            */
            PrintWriter out = response.getWriter();
        	JsonObject o = new JsonObject();
        	o.addProperty("close", "OK");
        	out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        }
    }
    
    @RequestMapping(value = "/confirma-tyc")
    public void updateAgreement(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
        JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        ClientProcedureGetLoginData client = null;
        try {
            
            client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
            if(client != null) {
                Integer clientId = (client.getClientId()!=null)?client.getClientId():0;
                
                HashMap[] map = null;
                if(clientId != null)
                	map = beanSecurityLoginBo.updateAgreement(clientId);
                	
                if(map != null)
                    for(HashMap hashMap : map)
                    	session.setAttribute("agreement", hashMap.get("P_MESSAGE").toString()); 
            }
           
            if(client != null) client.setAgreement((session.getAttribute("agreement")!=null)?session.getAttribute("agreement").toString():"");
    		session.setAttribute(Constantes.CLIENT_SESION, client);
            o.addProperty("state", 1);
            o.addProperty("message", "OK");
            
        } catch (Exception e) {
        	o.addProperty("message", "Incidente inesperado [9]");
        	o.addProperty("state", 9);	
        	LoggerApi.severe(e); 
        	
        } finally {
        	out.print(o);
        	LoggerApi.Log.info("/confirma-tyc "+o.toString());
        }
    }
    
    
    @RequestMapping(value = "/send_user_mail")
    public void formReminder(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="send_user_mail formReminder";
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
//        String mail = (request.getParameter("email-usr")!=null)?request.getParameter("email-usr"):"";

        String pTypeId = (request.getParameter("typeDoc")!=null)?request.getParameter("typeDoc"):"";
        String pNumberId = "";
        LoggerApi.Log.info("-------------- START "+log);
        JSONObject convertedObject=null;
        try {
        	if("DNI".equals(pTypeId)) {
            	pNumberId = request.getParameter("numberDoc");
            }else if("PASAP".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-pasap");
            }else if("CAREX".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-carex");
            }
        	if (pNumberId == null || pNumberId.trim().equals("")) {
                LoggerApi.Log.info("clientfindByDocument no definido:" + pNumberId);
                o.addProperty("message", "Correo no definido");
                o.addProperty("send", "Su correo no esta definido, verificar el correo.");
        	} else {
//            	mail = mail.trim().toLowerCase();
               
//            	String send = beanSecurityLoginBo.clientSendUserMail(mail);
            	JsonObject jdata = new JsonObject();
        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", pTypeId);
	    		jdata.addProperty("numeroDocumento", pNumberId.trim());
	    		jdata.addProperty("mailOCelular", "MAIL");
	    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
	    		jdata.addProperty("platform", Constantes.PLATAFORM);
	    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi2(jdata.toString(), "recoveryUserByDocNumber"));
                if (convertedObject.getString("estado").equals("OK")) {
                	if(convertedObject.getString("resp_button").equals("201")) {
                		o.addProperty("message", convertedObject.getString("estado"));
//                        o.addProperty("mailEco", convertedObject.getString("mailEco"));
                        o.addProperty("rtitle", convertedObject.getString("resp_title"));
                        o.addProperty("rmessage", convertedObject.getString("resp_message"));
                        o.addProperty("rbutton", convertedObject.getString("resp_button"));
                	}
                	if(convertedObject.getString("resp_button").equals("202")) {
                		o.addProperty("message", convertedObject.getString("mensaje"));
//                        o.addProperty("mailEco", convertedObject.getString("mailEco"));
//                        o.addProperty("rtitle", convertedObject.getString("resp_title"));
                        o.addProperty("rmessage", convertedObject.getString("resp_message"));
                        o.addProperty("rbutton", convertedObject.getString("resp_button"));
                	}
                    
//                } else if(send != null && send.equals("KO")) {
//                	LoggerApi.Log.info("formReminder 1 clientBo.findByMail no existe:" + mail+" send="+send);
//                    o.addProperty("send", "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.");
                } else {
                    LoggerApi.Log.info("message: "+convertedObject.getString("mensaje"));
                    o.addProperty("message", convertedObject.getString("mensaje"));
                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
//                    o.addProperty("send", "Correo no ha sido registrado, verificarlo");
                }
        	}
//            LoggerApi.Log.info("send_user_mail restablecerMail o="+o);
            out.print(o);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("--------------  END " + log+" convertedObject:"+convertedObject.toString());
        }
    }
    

    @RequestMapping(value = "/send_password_mail") 
    public void resettlePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="send_password_mail restablecerPassword";
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        
        String pTypeId = (request.getParameter("typeDoc")!=null)?request.getParameter("typeDoc"):"";
        String pNumberId = "";
        String p_game = request.getParameter("game").toString();
        JSONObject convertedObject=null;
        String mail="";
        Dbms rs = null;
        LoggerApi.Log.info("--------------  START "+log);
//        HttpSession session = request.getSession();
        try {
        	if("DNI".equals(pTypeId)) {
            	pNumberId = request.getParameter("numberDoc");
            }else if("PASAP".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-pasap");
            }else if("CAREX".equals(pTypeId)) {
            	pNumberId = request.getParameter("documento-carex");
            }
        	if (pNumberId == null || pNumberId.trim().equals("")) {
                LoggerApi.Log.info("clientfindByDocument no definido:" + pNumberId);
                o.addProperty("message", "N˙mero de documento no definido");
                o.addProperty("send", "Su n˙mero de cocument no esta definido, verificar el n˙mero de documento.");
        	} else {
        		LoggerApi.Log.info(log+ " Document Type: " + pTypeId+" Document: "+pNumberId);
        		//obtener operatorid
            	int operatorId=Constantes.OPERATOR_ID;
            	if(p_game.equals("2")) {
            		operatorId=5588;
            	}
        		//obtener el correo de cliente
            	JsonObject jdata = new JsonObject();
        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
        		jdata.addProperty("token", tokenPlayerWebApi);
        		jdata.addProperty("tipoDocumento", pTypeId);
        		jdata.addProperty("numeroDocumento", pNumberId.trim());
        		jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
        		jdata.addProperty("operatorId", operatorId);
        		jdata.addProperty("platform", Constantes.PLATAFORM);
                
        		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
                
                if (convertedObject.getString("status").equals("OK")) {
                	mail=convertedObject.getString("email");
                }else {
                	LoggerApi.Log.info(log+" message: " +convertedObject.getString("resp_title")+" "+convertedObject.getString("resp_message"));
                	o.addProperty("rtitle", convertedObject.getString("resp_title"));
                	o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
                	return;
                }
            	
        		jdata = new JsonObject();
//        		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
	    		jdata.addProperty("token", tokenPlayerWebApi);
	    		jdata.addProperty("tipoDocumento", pTypeId);
	    		jdata.addProperty("numeroDocumento", pNumberId.trim());
	    		jdata.addProperty("mailOCelular", "MAIL");
	    		jdata.addProperty("link", "");
	    		jdata.addProperty("operatorId", operatorId);
	    		jdata.addProperty("platform", Constantes.PLATAFORM);
	    		convertedObject = new JSONObject(securityUtils.requestPlayerWebApi2(jdata.toString(), "recoveryPassByDocNumber"));
                
                if (convertedObject.getString("estado").equals("OK")) {
                	o.addProperty("message", convertedObject.getString("estado"));
                    o.addProperty("mailEco", convertedObject.getString("mailEco"));
                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
                                                                                                              
                } else {
                    LoggerApi.Log.info("message: " +convertedObject.getString("mensaje"));
                    o.addProperty("message", convertedObject.getString("mensaje"));
//                    o.addProperty("rtitle", convertedObject.getString("resp_title"));
                    o.addProperty("rmessage", convertedObject.getString("resp_message"));
                    o.addProperty("rbutton", convertedObject.getString("resp_button"));
                   
                }
        	}
            LoggerApi.Log.info(log+" o="+o);
            
        } catch (Exception e) {
        	o.addProperty("message", "Ocurrio un error");
            o.addProperty("rtitle", "Ocurrio un error");
        	o.addProperty("rmessage", "Ocurrio un error. Revisa si digitaste correctamente y vuelve a intentarlo.");
            LoggerApi.severe(e);
        } finally {
        	out.print(o);
        	try {
				if(rs!=null) {
					System.out.println(log+" cerrando conexion");
					 rs.close();
				}
			} catch (Exception e) {
				System.out.println(log+" cerrando conexion");
				e.printStackTrace();
			}   
            LoggerApi.Log.info("--------------  END "+log+" convertedObject:" + convertedObject.toString());
        }
    }

    @RequestMapping(value = "/change_password")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String log="change_password";
    	LoggerApi.Log.info("-------------- START "+log);
    	JSONObject convertedObject = null;
    	
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        HttpSession session = request.getSession();
        String mail = request.getParameter("email").toString();//email
        String codigoPass = (request.getParameter("codigoPass")!=null)?request.getParameter("codigoPass"):"";//cod-autorizacion
        String pass1 = (request.getParameter("password")!=null)?request.getParameter("password"):"";//new-pass
        String pass2 = (request.getParameter("new-password")!=null)?request.getParameter("new-password"):"";//new-pass2

        try {
	        String clientIdRecoveryPass=session.getAttribute("clientIdRecoveryPass")!=null?session.getAttribute("clientIdRecoveryPass").toString():"";
	    	int operatorId=(session.getAttribute("operatorId")!=null && !session.getAttribute("operatorId").equals(""))?Integer.parseInt(session.getAttribute("operatorId").toString()):0;
	    	if(operatorId==0) {
	    		operatorId=Constantes.OPERATOR_ID;
	    	}
	    	JsonObject jdata = new JsonObject();
			String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
			jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("tipoDocumento", "");
			jdata.addProperty("numeroDocumento", "");
			jdata.addProperty("clientId", clientIdRecoveryPass);
			jdata.addProperty("playerIp", SecurityUtils.getClientIp(request));
			jdata.addProperty("operatorId", operatorId);
			jdata.addProperty("platform", Constantes.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "consultClientData"));
			if (!convertedObject.getString("status").equals("OK")) {
	            o.addProperty("message", "KO");
	            o.addProperty("send", "Revisa si el documento que ingresaste es correcto");
	            o.addProperty("title", "Validaci&oacute;n de datos");
	            out.print(o);
	            LoggerApi.Log.info(clientIdRecoveryPass+":" + convertedObject);
	            return;
	        }
			
			String pUser =convertedObject.getString("usuario");
	        String verifyString = intralotUtils.verifyPassword(pUser, pass1, pass2);
	        if (!verifyString.equals("OK")) {
	            o.addProperty("message", "KO");
	            o.addProperty("send", verifyString);
	            o.addProperty("title", "Validaci&oacute;n de datos");
	            out.print(o);
	            LoggerApi.Log.info(pUser+":" + verifyString);
	            return;
	        }
	        
	    	jdata = new JsonObject();
	    	jdata.addProperty("token", tokenPlayerWebApi);
			jdata.addProperty("transaccionId", "");
			jdata.addProperty("param1", codigoPass);
			jdata.addProperty("param2", mail);
			jdata.addProperty("password", pass1);
			jdata.addProperty("passwordConfirm", pass2);
			jdata.addProperty("operatorId", operatorId);
			jdata.addProperty("platform", Constantes.PLATAFORM);
			convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "updatePasswordMail"));
			if (convertedObject.has("status") && convertedObject.getString("status").equals("OK")) {
				o.addProperty("clientId", clientIdRecoveryPass);
	            o.addProperty("message", convertedObject.getString("status"));
	            o.addProperty("send", convertedObject.getString("resp_message"));
	            if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
	            	o.addProperty("lapolla", Constantes.lapollaGameProviderBaseUrl+" | ");
	            	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== change_password lapolla="+Constantes.lapollaGameProviderBaseUrl+" mail="+mail);
	            	session.removeAttribute("operatorId");
				}
	            if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
	//            	o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | ");
	            	String urlTav2="tav2.html?"+session.getAttribute("urlRedirect5588")+"&"+session.getAttribute("redirectGame");
	            	o.addProperty("tav2", urlTav2);
	            	if(session.getAttribute("urlRedirect5588")==null || session.getAttribute("urlRedirect5588").toString().equals("")) {
	            		o.addProperty("tav2", Constantes.tav2GameProviderCloseUrl);
	            	} 
	            	session.removeAttribute("operatorId");
				}
	            
	            //modificar notificacion de contraseÒa
	            List<PaymentPrizeProcedureGetNotifications> listObj=paymentPrizeBo.getNotifications(Integer.parseInt(clientIdRecoveryPass));
	            for (PaymentPrizeProcedureGetNotifications notifications : listObj) {
					if(notifications.getType().equals("4")) {
//						PaymentPrizeProcedurePasswordNotification obj = paymentPrizeBo.passwordNotification(Integer.parseInt(clientIdRecoveryPass));
						PaymentPrizeProcedureUpdatePasswordNotification obj = paymentPrizeBo.updatePasswordNotification(Integer.parseInt(clientIdRecoveryPass), notifications.getId());
			    		LoggerApi.Log.info(log+" passwordNotification="+obj.getMessage());
					}
				}
				
	            
			}else {
				o.addProperty("message", "KO");
	            o.addProperty("send", convertedObject.getString("resp_message"));
	            o.addProperty("title", convertedObject.getString("resp_title"));
			}
			
            out.print(o);
            
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            LoggerApi.Log.info("EMAIL:" + mail);
        }
    }
    
    @RequestMapping(value = "/send_user_mail_verify_account")
    public void send_user_mail_verify_account (HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        HttpSession session = request.getSession();
        
        ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        String mail = (request.getParameter("email-usr")!=null)?request.getParameter("email-usr").toString().trim():"";
        String clientName = (client!=null && client.getCl_nombre()!=null)?client.getCl_nombre():"";
        String clientMail = (client!=null && client.getMail()!=null)?client.getMail():"";
        String clientMailCode = (client!=null && client.getMailCode()!=null)?client.getMailCode():"";
        String clientId = (client!=null && client.getClientId()!=null)?Integer.toString(client.getClientId()):"";
        
        String verified = (client!=null && client.getMailStatus()!=null)?client.getMailStatus():"";
        boolean update = true;
        
    	
        LoggerApi.Log.info("mail= "+mail+" clientName= "+clientName+" clientMail= "+clientMail+" clientMailCode= "+clientMailCode+" clientId= "+clientId);
        
        if(!IntralotUtils.verifySintaxMail(mail))  {
        	o.addProperty("status", 3);
        	o.addProperty("message", "Ingresar una direcci&oacute;n de correo correcto");
        	out.print(o);
        	return;
        }
        
        if(!mail.equals(clientMail)) {
        	
        	ClientProcedureUpdateClientMail updateMail =  beanClientAccountBo.updateMail(Integer.parseInt(clientId), mail);
        	if(updateMail.getState().equals(5) || updateMail.getState().equals(8)) {
        		update = false;
        		o.addProperty("status", updateMail.getState());
        		o.addProperty("message", updateMail.getMessage());
        		out.print(o);
        		return;	
        	} else {
        		verified = "S";
        	}
        } 

        LoggerApi.Log.info("/send_user_mail_verify_account update= "+update);
        if(update && verified.equals("S")) {
        	o.addProperty("status", 1);
        	if (client!=null) client.setMailVerified(verified);
        	if(!mail.equals(clientMail)) {
        		o.addProperty("message", "Su correo electr&oacute;nico ha sido actualizado.");
        		client.setMail(mail);
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	} else {
        		o.addProperty("message", "La solicitud de activaci&oacute;n ha sido enviada. Revisa tu correo.");
        	}
         	
        } else if (verified.equals("N")) {
        	o.addProperty("status", 9);
         	o.addProperty("message","El e-mail ya se encuentra registrado. Verifique si lo escribi&oacute; correctamente.");
        } 
    
       out.print(o);
    	   	
    }
    
    @RequestMapping(value = "/send-sms-validation")
    public void putSmsRegister(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData ="";
        try {
	        String phone = (request.getParameter("telf-sms")!=null)?request.getParameter("telf-sms").toString().trim():"";	        
	        if(phone.equals("")) {
	        	String registerType=session.getAttribute("registerType")!=null?session.getAttribute("registerType").toString():"";
	        	if(registerType.equals("201")) {
	        		phone=session.getAttribute("celular").toString();
	        	}	        	
	        }

	        ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
	        if(client.getMask_phone()==1 && client.getRegister_incomplete()==1) {
	        	phone=(client!=null)?client.getMobilePhone():"";
	        }
	        Integer idClient= (client!=null && client.getClientId()!=null)?client.getClientId():0;
	    	String phoneClient = (client!=null && client.getMobilePhone()!=null)?client.getMobilePhone():"";
	    	boolean update=true, valid=true;
	        
	    	LoggerApi.Log.info("/putSmsRegister phone= "+phone+" idClient= "+idClient+" phoneClient= "+phoneClient);
	        
	    	 if(!IntralotUtils.verifySintaxMobilePhone(phone)) {
	    		o.addProperty("status", 9);
	         	o.addProperty("message", "Ingresar n&uacute;mero de celular v&acute;lido");
	         	valid=false;
	         }
	    	 
	    	 if(!phone.equals(phoneClient) && valid) {
	    		 //update phone
	    		 ClientProcedureUpdatePhone updatePhone = beanSecurityLoginBo.updatePhoneClient(idClient, phone);
	    		 if(!updatePhone.getState().equals(1)) {
	    			 update = false;
	    			 o.addProperty("status", updatePhone.getState());
		        	 o.addProperty("message", updatePhone.getMessage());
	    		 } 

	    	 }
	    	 
	    	if(update && valid) {
	    		client.setMobilePhone(phone);
	    		session.setAttribute(Constantes.USR_SESION, client);
	    		
	    		ResultBean registerSendSms = securityUtils.putSmsClient(idClient,client.getMobilePhone(),beanSecurityLoginBo);
	    		
//	    		o.addProperty("code", registerSendSms.getCode());
	    		o.addProperty("status", registerSendSms.getState());
        		o.addProperty("message", registerSendSms.getMessage());
        		
//        		session.setAttribute("cel", phone);
        		
	    	}
	         
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [500]");
			LoggerApi.severe(e);
			throw e;
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/putSmsRegister "+o.toString());
		}
    }
    
    @RequestMapping(value = "/send-wa-validation")
    public void putWaRegister(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData ="";
        try {
	        String phone = (request.getParameter("telf-sms")!=null)?request.getParameter("telf-sms").toString().trim():"";	        
	        if(phone.equals("")) {
	        	String registerType=session.getAttribute("registerType")!=null?session.getAttribute("registerType").toString():"";
	        	if(registerType.equals("201")) {
	        		phone=session.getAttribute("celular").toString();
	        	}	        	
	        }

	        ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
	        if(client.getMask_phone()==1 && client.getRegister_incomplete()==1) {
	        	phone=(client!=null)?client.getMobilePhone():"";
	        }
	        Integer idClient= (client!=null && client.getClientId()!=null)?client.getClientId():0;
	    	String phoneClient = (client!=null && client.getMobilePhone()!=null)?client.getMobilePhone():"";
	    	boolean update=true, valid=true;
	        
	    	LoggerApi.Log.info("/putWaRegister phone= "+phone+" idClient= "+idClient+" phoneClient= "+phoneClient);
	        
	    	 if(!IntralotUtils.verifySintaxMobilePhone(phone)) {
	    		o.addProperty("status", 9);
	         	o.addProperty("message", "Ingresar n&uacute;mero de celular v&acute;lido");
	         	valid=false;
	         }
	    	 
	    	 if(!phone.equals(phoneClient) && valid) {
	    		 //update phone
	    		 ClientProcedureUpdatePhone updatePhone = beanSecurityLoginBo.updatePhoneClient(idClient, phone);
	    		 if(!updatePhone.getState().equals(1)) {
	    			 update = false;
	    			 o.addProperty("status", updatePhone.getState());
		        	 o.addProperty("message", updatePhone.getMessage());
	    		 } 

	    	 }
	    	 
	    	if(update && valid) {
	    		client.setMobilePhone(phone);
	    		session.setAttribute(Constantes.USR_SESION, client);
	    		
	    		ResultBean registerSendWa = securityUtils.putWaClient(idClient,client.getMobilePhone(),beanSecurityLoginBo);
	    		
//	    		o.addProperty("code", registerSendSms.getCode());
	    		o.addProperty("status", registerSendWa.getState());
        		o.addProperty("message", registerSendWa.getMessage());
        		
//        		session.setAttribute("cel", phone);
        		
	    	}
	         
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [500]");
			LoggerApi.severe(e);
			throw e;
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/putWaRegister "+o.toString());
		}
    }

    @RequestMapping(value = "/send-code-validation")
    public void updateSmsRegister(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        boolean valid=true;
        ClientProcedureGetLoginData client = null;
        ClientProcedureUpdateSmsRegister domain = null;
        try {
        	String smsCode = (request.getParameter("send-code")!=null)?request.getParameter("send-code").toString().trim():"";
        	
        	String codeValidSize = ConnectionFactory.operationProperty("smsCodeSize", Constantes.contextSale);
        	
        	if(!IntralotUtils.verifySintaxSmsCode(smsCode,codeValidSize)) {
        		o.addProperty("status", 9);
        		o.addProperty("message", "C&oacute;digo incorrecto. Verifique si lo escribi&oacute; correctamente");
        		valid=false;
        	}
        	
        	if(valid) {
        		
        		client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        		if(client != null) {
        			int idClient= client.getClientId();
        		
        			int validTime = Integer.parseInt(ConnectionFactory.operationProperty("smsValidTimeFrame", Constantes.contextSale).toString());
        			domain = beanSecurityLoginBo.updateSmsRegister(idClient, smsCode, validTime);
        		}
            	
        		if(domain != null && domain.getState()==1) {
            		client.setMobileStatus("ACT");
            		session.setAttribute(Constantes.CLIENT_SESION, client);
            		session.removeAttribute("cel");
            	}
            	session.setAttribute("register-login", "register-login");
            	o.addProperty("status", (domain != null ? domain.getState():500));
            	o.addProperty("message", (domain !=null ? domain.getMessage() : "Incidente inesperado [8]"));
        		
        	}

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/updateSmsRegister "+o.toString());
		}
    }
    
	
	private JsonObject validarUsuarioJson(ClientProcedureGetLoginData client, Integer gameCode,
			HttpServletRequest request) throws Exception {
		 
		  Integer cid = client.getClientId();
		  String agreement = client.getAgreement();
		  String mailVerified = client.getMailVerified();
		  String phoneverified = client.getMobileStatus()==null ? "DES" : client.getMobileStatus();
		  String promotion = "";//client.getPromotion();
		  String promotionibk = "";//client.getPromotionibk();
		  String username = client.getUser();
		  
		  /*LoggerApi.Log.info("/common_login validarUsuarioJson cid=" + cid + " username=" + username 
							  + " agreement=" + agreement + " mverified=" + mailVerified + " mail=" + client.getMail() + " phoneverified=" + phoneverified 
							  + " state=" + client.getState()+" gameCode=" + gameCode);*/

		  HttpSession session = (request.getSession()!=null)?request.getSession():request.getSession(false);
		  JsonObject o = new JsonObject();
		  boolean success = false;

		  if (agreement==null || agreement.trim().equals("")) {
        	o.addProperty("alertLogin", "Por favor lea y confirme los nuevos t&eacute;rminos y condiciones.");
    		o.addProperty("error","TC");
    		o.addProperty("redirect", "client_lotocard_show_term.html");
    		
		  } else if (Constantes.flagValidacionSms.equals("true") && phoneverified.equals("DES")) {
			  
			  if (IntralotUtils.verifySintaxMobilePhone(client.getMobilePhone())){
				  ResultBean beanResponseSendSms = securityUtils.putSmsClient(client.getClientId(), client.getMobilePhone().trim(), beanSecurityLoginBo);
				  o.addProperty("error","AC");
				  o.addProperty("content",securityUtils.htmlSmsValidationAccount(client));
				  o.addProperty("phone", client.getMobilePhone());
				  if(client.getMask_phone()==1 && client.getRegister_incomplete()==1) {
                 	 String phone=client.getMobilePhone();
                 	 phone = phone.substring(phone.length()-3, phone.length());
                 	 phone = "*** *** "+phone;
                 	 o.addProperty("phone", phone);
                  }
				  if (!beanResponseSendSms.getMessage().equals("")) {
					  o.addProperty("alertLogin", beanResponseSendSms.getMessage());
				  }
			  } else {
				  	o.addProperty("error","AC");
				  	o.addProperty("content", securityUtils.htmlSmsValidationAccount(client));
				  	o.addProperty("phone","");
			  }
		  
		  } else if(Constantes.flagValidacionMail.equals("true")  && (mailVerified.equals("N"))) {
			  o.addProperty("error","MR");
			  if(mailVerified.equals("N")) {o.addProperty("content", securityUtils.htmlMailValidationAccount(client));} 
    	
		  } else if(gameCode != 0 && Constantes.flagRecargaInterbank.equals("true")  && (promotionibk!=null && !promotionibk.equals(""))) {
			  o.addProperty("content", promotionibk);
			  o.addProperty("error","IB");
		  } else if(gameCode != 0 && Constantes.flagRecargaRedDigital.equals("true")  && (promotion!=null && !promotion.equals(""))) {
			  o.addProperty("content", promotion);
			  o.addProperty("error","RD");
    		
		  } else {

			  ClientProcedureTokenGeneration tokenGeneration = beanSecurityLoginBo.getToken(client.getClientId(), "1", request.getRemoteAddr());
			  if (tokenGeneration!=null && tokenGeneration.getMessage().equals("OK")) {
				  client.setpToken(tokenGeneration.getIflexToken());
			  }
			  ClientProcedureLPTokenGeneration lpTokenGeneration = beanSecurityLoginBo.getLPToken(client.getClientId(), request.getRemoteAddr());
			  if (lpTokenGeneration!=null && lpTokenGeneration.getMessage().equals("OK")) {
				  client.setLapollaToken(lpTokenGeneration.getLapollaToken());
			  }
			  ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(client.getClientId(), request.getRemoteAddr());
			  if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
				  client.setTav2Token(tanTokenGeneration.getTav2Token());
			  }
			  if(session != null) {
				  session.removeAttribute("username");
				  session.removeAttribute("password");
				  session.removeAttribute("register-login");
			  }
      		
			  o.addProperty("state", "OK");
			  o.addProperty("message", "OK");
			  o.addProperty("username", username);
			  o.addProperty("amount", client.getBalanceAmount());
			  o.addProperty("idclient", client.getClientId());
			  
			  if(session != null && session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
          		o.addProperty("lapolla", Constantes.lapollaGameProviderBaseUrl+" | "+ client.getLapollaToken());
              	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== client_lotocard_load_balances lapolla="+Constantes.lapollaGameProviderBalanceUrl+ "clientid= "+client.getClientId());
  				session.removeAttribute("operatorId");
  			 }
  			 
			  if(session != null) { 
		  			 if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
		  				  if(session.getAttribute("redirectGame") != null && session.getAttribute("redirectGame").toString().equals("DV"))
			        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+client.getTav2Token()+"&ref="+session.getAttribute("ref").toString());
			        	  else
			        			o.addProperty("tav2", Constantes.tav2GameProviderBaseUrl+" | "+ client.getTav2Token());
		  				 session.removeAttribute("operatorId");
		  				 session.removeAttribute("redirectGame");
		  				 session.removeAttribute("ref");
		  			 }
		  			success = true;
				 }
		    
			  if(success) {
				  session.setAttribute("username", username);
				  session.setAttribute("clientId", String.valueOf(client.getClientId()));
				  session.setAttribute("clientToken", String.valueOf(client.getpToken()));
				  session.setAttribute(Constantes.USR_SESION, client);
				  if(session.getAttribute(Constantes.CLIENT_SESION)!=null) session.removeAttribute(Constantes.CLIENT_SESION);
			  }
		    
			  ClientProcedureAccountData accountData = beanClientBalanceBo.findAccountData(client.getClientId());
			  accountData = intralotUtils.verifiedTestUsersWelcomeBonus(accountData,session);
			  intralotUtils.updateBalanceSession(session,accountData,0,"");
	      	
			  o.addProperty("welcomeBonusPercentaje", accountData.getWelcomeBonusPercentaje());
			  o.addProperty("welcomeBonusMessage", accountData.getWelcomeBonusMessage());
			  o.addProperty("welcomeBonusMessagePor", accountData.getWelcomeBonusMessagePor());
			  o.addProperty("welcomeBonusStatus", accountData.getWelcomeBonusStatus());
			  o.addProperty("welcomeBonusLastDate", accountData.getWelcomeBonusLastDate());
			  
			  o.addProperty("error","OK");
			  o.addProperty("redirect", "security_login_execute_authentication.html");
		  }
		  return o;
	}
    
    @RequestMapping(value = "/activate-promotion")
    public void activatePromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient;
            values[1] = balanceItem; 
        	ClientProcedureActivatePromotion domain = beanSecurityLoginBo.activatePromotion(values);
        	
        	if(domain.getState()==1) {
        		client.setPromotion("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
        

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activatePromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-wbpromotion")
    public void activateWBPromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient;
            values[1] = balanceItem; 
        	ClientProcedureActivateWBPromotion domain = beanSecurityLoginBo.activateWBPromotion(values);
        	if(domain.getState()==1) {
        		client.setPromotion("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activateWBPromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/cancel-promotion")
    public void cancelPromotion(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureCancelPromotion domain = beanSecurityLoginBo.cancelPromotion(values);
        	
        	if(domain.getState()==1) {
        		client.setPromotion("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
        	

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/cancelPromotion "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-promotionibk")
    public void activatePromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient;
            values[1] = balanceItem; 
        	ClientProcedureActivatePromotionibk domain = beanSecurityLoginBo.activatePromotionibk(values);
        	
        	if(domain.getState()==1) {
        		client.setPromotionibk("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
        

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activatePromotionibk "+o.toString());
		}
    }
    
    @RequestMapping(value = "/activate-wbpromotionibk")
    public void activateWBPromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient;
            values[1] = balanceItem; 
        	ClientProcedureActivateWBPromotionibk domain = beanSecurityLoginBo.activateWBPromotionibk(values);
        	if(domain.getState()==1) {
        		client.setPromotionibk("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/activateWBPromotionibk "+o.toString());
		}
    }
    
    @RequestMapping(value = "/cancel-promotionibk")
    public void cancelPromotionibk(@RequestParam("callback") String callback,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
    	HttpSession session = request.getSession();
    	JsonObject o = new JsonObject();
        PrintWriter out = response.getWriter();
        String outData = "";
        
        try {
        	int balanceItem = Integer.parseInt(request.getParameter("balanceItem").toString().trim());
        		
        	ClientProcedureGetLoginData client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
        	int idClient= client.getClientId();
        	Object[] values = new Object[2];
        	values[0] = idClient; 
            values[1] = balanceItem; 
        	ClientProcedureCancelPromotionibk domain = beanSecurityLoginBo.cancelPromotionibk(values);
        	
        	if(domain.getState()==1) {
        		client.setPromotionibk("");
        		session.setAttribute(Constantes.CLIENT_SESION, client);
        	}
        	o.addProperty("status", domain.getState());
        	o.addProperty("message", domain.getMessage());
        	

		} catch (Exception e) {
			o.addProperty("status", 500);
			o.addProperty("message", "Incidente inesperado [8]");
			LoggerApi.severe(e);
		} finally {
			outData = callback + "(" + o + ")";
			out.print(outData);
			LoggerApi.Log.info("/cancelPromotionibk "+o.toString());
		}
    }
    
    @RequestMapping(value = "/lapolla1")
    public ModelAndView viewLPLoginFrame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/lapolla/lapolla_frame");
        } catch (Exception e) {
        	pe.com.intralot.loto.utils.LoggerApi.severe(e);
            return new ModelAndView("game/lapolla/lapolla_frame");
        } finally {
        }
    }
	
    @RequestMapping(value = "/lapolla")
    public ModelAndView viewLPLoginGame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla");
        try {
            return new ModelAndView("game/lapolla/lapolla_header");
        } catch (Exception e) {
        	pe.com.intralot.loto.utils.LoggerApi.severe(e);
            return new ModelAndView("game/lapolla/lapolla_header");
        } finally {
        	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
    
    @RequestMapping(value = "/lapolla-logout")
    public void viewLPLogout(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-logout");
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
        try {
            HttpSession session = request.getSession(false);
            if(session != null && session.getAttribute(Constantes.USR_SESION) != null) session.invalidate();
            o.addProperty("message", "OK");
            o.addProperty("logout", Constantes.lapollaGameProviderCloseUrl);
        } catch (Exception e) {
        	pe.com.intralot.loto.utils.LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("logout", "");
        } finally {
        	out.print(callback + "(" + o + ")");
            Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-logout jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
    
	@RequestMapping(value = "/lapolla-login")
	public void viewLPLogin(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-login");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData procedureLogin = null;
		
		try {
			//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("Navigator="+request.getParameter("user-browser"));
			//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("UserAgent="+request.getHeader("User-Agent"));
            
			HttpSession session = request.getSession();
            
			if(session.getAttribute(Constantes.CLIENT_SESION)!=null) {
				Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login from SESSION");
        		boolean validate = true;
        		if(session.getAttribute("username")!=null && session.getAttribute("password")!=null && request.getParameter("user")!=null && request.getParameter("password")!=null) {
        			if(!session.getAttribute("username").toString().equals(request.getParameter("user").toLowerCase().trim())) validate=false;
        			if(!session.getAttribute("password").toString().equals(intralotUtils.encrypt(StringUtils.upperCase(request.getParameter("password"))))) validate=false;
        		} else validate = false;
        		if(validate) {
            		Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login validate");
        			try {
        				procedureLogin = (session!=null && session.getAttribute(Constantes.USR_SESION)!=null && !(session.getAttribute(Constantes.USR_SESION).toString().trim()).equals(""))?((ClientProcedureGetLoginData)session.getAttribute(Constantes.USR_SESION)): null;
        			} catch(Exception e) {
        				e.printStackTrace(System.out);
        				procedureLogin = null;
        			}
        		} else if (session.getAttribute("register-login")!=null) {
            		//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login register-login");
        			if(session.getAttribute("register-login").equals("register-login")) {
        				procedureLogin = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
            			session.removeAttribute("register-login");
        			}    			
        		} else {
            		//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login procedureLogin");
        			procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
        		}
        		
        		if (procedureLogin==null) {
            		//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login procedureLogin==null");
        			procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
        		}
        		
        		//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login AGREEMENT= "+procedureLogin.getAgreement()+" ACCOUNT="+procedureLogin.getMobileStatus());
        	} else {
        		//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login from FORM");
        		procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
        		
        	} 
            
            //Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login client="+procedureLogin);
            
			if(procedureLogin != null) {
				state = procedureLogin.getState();
				cid = procedureLogin.getClientId();

				//Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login state=" + state + " cid="+ cid);
				if(state.equals(1)) {
					o = validarUsuarioJson(procedureLogin,0,request);
					String LapollaConfig = "", authToken="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						request.setAttribute("clientSale", procedureLogin);
						o.addProperty("id", cid);
						o.addProperty("user", procedureLogin.getCl_nombre());
						authToken = procedureLogin.getLapollaToken();
						LapollaConfig = Constantes.lapollaGameProviderBaseUrl;
					}
                	
					o.addProperty("lapolla", LapollaConfig+" | "+authToken);
				} else if (state.equals(2)) {
					o.addProperty("state", "CC");
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				} else if (state.equals(3)) {
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				} else if (state.equals(-1)) {
					o.addProperty("message", "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka.");
				} else {
					o.addProperty("message", "El usuario y/o la contrase&ntilde;a son inv&aacute;lidos. Ingreso denegado.");
				}
				Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("lapolla-login cid=" + cid + " state=" + state);
			} else {
				o.addProperty("message", "Usuario no encontrado [404]");
			}
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [500]");
			outData = callback + "(" + o + ")";
			pe.com.intralot.loto.utils.LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
			Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-login jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		}
	}
 
	@RequestMapping(value = "/lapolla-session")
	public void viewLPSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-session");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constantes.USR_SESION)!=null) {//Constantes.CLIENT_SESION)!=null) {
            	client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);//Constantes.CLIENT_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constantes.lapollaGameProviderBaseUrl);
                ClientProcedureLPTokenGeneration lpTokenGeneration = beanSecurityLoginBo.getLPToken(client.getClientId(), request.getRemoteAddr());
              	if (lpTokenGeneration!=null && lpTokenGeneration.getMessage().equals("OK")) {
              		o.addProperty("authToken", lpTokenGeneration.getLapollaToken());
                }
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constantes.lapollaGameProviderCloseUrl);
            }
        } catch (Exception e) {
        	pe.com.intralot.loto.utils.LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-session jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
	
	@RequestMapping(value = "/lapolla-nosession")
	public void viewLPNoSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
    	Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== START lapolla-nosession");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
        try {
        	HttpSession session = request.getSession();
        	if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.lapollaOperatorId.toString().trim())) {
        		o.addProperty("redireccion", Constantes.lapollaGameProviderBalanceUrl);
        		Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== lapolla-nosession redireccion="+Constantes.lapollaGameProviderBalanceUrl);
        		session.removeAttribute("operatorId");
        	}
        } catch (Exception e) {
        	pe.com.intralot.loto.utils.LoggerApi.severe(e);
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            Logger.getLogger(pe.com.intralot.loto.utils.LoggerApi.LOGGERLAPOLLAAPI).info("================== END lapolla-nosession jsonObject="+o.toString()+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
        }
    }
	
	@RequestMapping(value = "/tav21")
    public ModelAndView viewTANLoginFrame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
            return new ModelAndView("game/teapuesto/tav2_frame");
        } catch (Exception e) {
            LoggerApi.severe(e);
            return new ModelAndView("game/teapuesto/tav2_frame");
        } finally {
        }
    }
	
    @RequestMapping(value = "/tav2")
    public void viewTANLoginGame(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
        try {
			HttpSession session = request.getSession();
        	if(session.getAttribute(Constantes.CLIENT_SESION)!=null) {	
        		session.removeAttribute(Constantes.CLIENT_SESION);
        	}
        	String redirectGame = request.getParameter("redirectGame");
        	String urlRedirect5588 = request.getParameter("urlRedirect5588");
        	String ref = (request.getParameter("ref") == null ? "" : request.getParameter("ref"));
        	request.setAttribute("redirectGame", redirectGame);
        	request.setAttribute("urlRedirect5588", urlRedirect5588);
        	request.setAttribute("ref", ref);
        	
        	session.setAttribute("redirectGame", redirectGame);
        	session.setAttribute("urlRedirect5588", urlRedirect5588);
        	session.setAttribute("ref", ref);
        	
        	String urlRedirect5587 = request.getParameter("urlRedirect5587");
        	if(urlRedirect5587!=null && !urlRedirect5587.trim().isEmpty()) {
            	session.setAttribute("operatorId", "5587");
            	session.setAttribute("OperatorId", "5587");
            	session.setAttribute("urlRedirect5587", urlRedirect5587);
            }else {
            	session.setAttribute("operatorId", "5588");
            	session.setAttribute("OperatorId", "5588");
            }
        	
        	// TODO: agregando logica de redireccion al login
        	String redirect = getPropertyContextSale("urlPamLogin");
			if(pe.com.intralot.loto.utils.ConnectionFactory.isDevelopment()) {
				String server = request.getRequestURL().toString();
				server = server.substring(0, server.lastIndexOf('/') + 1 );
				 redirect += "?operatorId=5588&from=teapuesto&tinkaEnvironment=" + server ;
			}else {
				redirect += "?operatorId=5588&from=teapuesto";
			}
			
			String bodyRequest = "{}";
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("X-Ip-Origin", "192.68.1.1"); // TODO : aqui falta modificar el request.getRemoteAddr()
			headers.put("X-Company", "ECOM");
			//obtiene token
			String tokenResponse = ApiClient.post( getPropertyContextSale("urlSecurityToken") , bodyRequest, "12345678", "12345678", headers);

			String token = "" ;
			
			SecurityTokenResponse responseToken = new SecurityTokenResponse();
			Gson gson = new Gson();
			
			responseToken = gson.fromJson(tokenResponse, SecurityTokenResponse.class);
			LoggerApi.Log.info("tokenResponse="+tokenResponse);
			if (responseToken.getToken() != null && !responseToken.getToken().equals("")) {
				token = "&token=" + responseToken.getToken();
			}
        	
			redirect += token + "&ref=" + ref.replaceAll("/","*");
			
			response.sendRedirect(redirect);
	        
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
        }
    }
    
    @RequestMapping(value = "/tav2-logout")
    public void viewTANLogout(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
    	JsonObject o = new JsonObject();
        try {
            HttpSession session = request.getSession(false);
            if(session != null && session.getAttribute(Constantes.USR_SESION) != null) session.invalidate();
            o.addProperty("message", "OK");
            o.addProperty("logout", Constantes.tav2GameProviderCloseUrl);
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("logout", "");
        } finally {
        	out.print(callback + "(" + o + ")");
            LoggerApi.Log.info(o.toString());
        }
    }
    
	@RequestMapping(value = "/laPollaTA")
    public String laPollaTA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "game/lapolla/lapolla_tav2";
    }
    
	@RequestMapping(value = "/laPollaTARedirect")
	public void laPollaTARedirect(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		LoggerApi.Log.info("-------------- START laPollaTARedirect uuid="+uuid.toString());
		response.setCharacterEncoding(Constantes.CHARSET_UTF8);
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		try {
			String urlRedirect5587 = Constantes.lapollaGameProviderBaseUrl;
			HttpSession session = request.getSession();
			ClientProcedureGetLoginData procedureLogin = (ClientProcedureGetLoginData) session.getAttribute(Constantes.CLIENT_SESION);
			if(procedureLogin!=null) {
				urlRedirect5587+="?authToken="+procedureLogin.getLapollaToken();
			}
			System.out.println("laPollaTARedirect urlRedirect5587: " + urlRedirect5587);
			o.addProperty("url", urlRedirect5587);
			out.print(o);
		} catch (Exception e) {
			out.print(o);
			LoggerApi.severe(e);
		}
		LoggerApi.Log.info("-------------- END laPollaTARedirect uuid="+uuid.toString());
	}
    
	@RequestMapping(value = "/tav2-login")
	public void viewTANLogin(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData procedureLogin = null;
		
		if(!validateLength(request)) {
        	o.addProperty("message", "Dato de ingreso incorrecto. Ingreso denegado.");
        	outData = callback + "(" + o + ")";
        	out.print(outData);
			return;
		}
		
		try {
			HttpSession session = request.getSession();
//        	String valor = request.getParameter("sentCaptcha");
//        	if(valor!=null && !valor.trim().isEmpty()) {
//        		Object captcha = session.getAttribute("captcha");
//    			if(captcha!=null && !captcha.toString().isEmpty()){
//    				String captchaDecode = StringLib.decodeLabel(captcha.toString());
//    				if(!valor.equalsIgnoreCase(captchaDecode)){
//    					session.setAttribute("captcha", null);
//    					o.addProperty("message", "El cÛdigo ingresado es incorrecto");
//    					outData = callback + "(" + o + ")";
//    					return;
//    				}else {
//    					session.setAttribute("captcha", null);
//    					procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
//    				}
//    			}else {
//    				session.setAttribute("captcha", null);
//    				o.addProperty("message", "Datos no validos");
//    				outData = callback + "(" + o + ")";
//    				return;
//    			}
//        	}else {
//        		session.setAttribute("captcha", null);
//				o.addProperty("message", "Acceso no valido");
//				outData = callback + "(" + o + ")";
//				return;
//        	}
			procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
			if(procedureLogin != null) {
				state = procedureLogin.getState();
				cid = procedureLogin.getClientId();

				LoggerApi.Log.info("/tav2-login state=" + state + " cid="+ cid );
//				if(state.equals(1)) {
				if (procedureLogin.getStatus().equals("OK")) {
					o = validarUsuarioJson(procedureLogin,1,request);
					String TAV2Config = "", authToken="", ref="";
					String urlRedirect5587="";
					String operatorId="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						session = request.getSession(false);
						if(session==null || !request.isRequestedSessionIdValid()) {
							session = request.getSession();
						}
						
						request.setAttribute("clientSale", procedureLogin);
						o.addProperty("id", cid);
						o.addProperty("user", procedureLogin.getCl_nombre());
						
						if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587") && request.getParameter("urlRedirect5587")!=null) {							
							if (!ConnectionFactory.operationProperty("applicationArea", "sale").toString().trim().toLowerCase().equals("production")) {
								urlRedirect5587 = request.getParameter("urlRedirect5587").toString().trim();
							}else {
								urlRedirect5587 = Constantes.lapollaGameProviderBaseUrl;
							}
							operatorId="5587";
							authToken = procedureLogin.getLapollaToken();
						}else {
							operatorId="5588";
							authToken = procedureLogin.getTav2Token();
						}				
						
						String urlRedirect5588	= (session.getAttribute("urlRedirect5588") != null) ? session.getAttribute("urlRedirect5588").toString() : request.getParameter("urlRedirect5588") ;
						ref = "&ref="+ ( (session.getAttribute("ref") != null) ? session.getAttribute("ref").toString() : request.getParameter("ref") );
						TAV2Config = (urlRedirect5588 != null && !urlRedirect5588.equals("")) ? urlRedirect5588 : Constantes.tav2GameProviderBaseUrl;
						
						Client objectPojo=beanClientAccountBo.findClientById(cid);
	                    session.setAttribute("name",objectPojo.getName());
	                    session.setAttribute("lastname",objectPojo.getLastname());
	                    session.setAttribute("maidenname",objectPojo.getMaidenname());
	                    session.setAttribute("mail",objectPojo.getMail());
	                    session.setAttribute("cid",objectPojo.getClientId());
	                    
	                    Client clientS = new Client();
	                	clientS.setClientId(objectPojo.getClientId());
	                	clientS.setName(objectPojo.getName());
	                	clientS.setLastname(objectPojo.getLastname());
	                	clientS.setMaidenname(objectPojo.getMaidenname());
	                	clientS.setMail(objectPojo.getMail());
	                	clientS.setDocNumber(objectPojo.getDocNumber());
	                	clientS.setDocType(objectPojo.getDocType());
	                	
	                	HttpSession clientSession = request.getSession();
	                	clientSession.setAttribute("CLIENT_SESSION", clientS);
					}
					
					if(operatorId.equals("5588")) {
						System.out.println("tav2: " + TAV2Config+" | "+authToken+ref);
						o.addProperty("tav2", TAV2Config+" | "+authToken+ref);
					}else {
						System.out.println("tav2: " + urlRedirect5587+" | "+authToken);
						o.addProperty("tav2", urlRedirect5587+" | "+authToken);
					}
										
					// Corrije NullPointer en el session del lightbox de SMS
				    session.setAttribute(Constantes.CLIENT_SESION, procedureLogin);
				    
				 // Validacion de contraseÒa expirada para usar en el front
				    if(procedureLogin.getButton()!=null && procedureLogin.getButton().equals("145")) {
				    	o.addProperty("flagPassword", procedureLogin.getButton());
				    	o.addProperty("mensajePassword", procedureLogin.getMessage());
				    	o.addProperty("tituloPassword", procedureLogin.getTitle());
				    }
				} else {
					o.addProperty("error", procedureLogin.getStatus());
	            	o.addProperty("alertLogin", procedureLogin.getStatus());
	            	o.addProperty("title", procedureLogin.getTitle());
	            	o.addProperty("message", procedureLogin.getMessage());
	            	String button=procedureLogin.getButton();
	            	o.addProperty("button", procedureLogin.getButton());
	            	if(button.equals("127")) {
	            		o.addProperty("lrdn", session.getAttribute("lrdn").toString());
	            		session.removeAttribute("lrdn");
	            	}
				}
				
//				else if (state.equals(2)) {
//					o.addProperty("state", "CC");
//					o.addProperty("message", "EL USUARIO O CONTRASE—A SON INV¡LIDOS");
//				} else if (state.equals(3)) {
//					o.addProperty("message", "EL USUARIO O CONTRASE—A SON INV¡LIDOS");
//				} else if (state.equals(-1)) {
//					o.addProperty("message", "Este usuario ha sido bloqueado, comun&iacute;quese a La Tinka;.");
//				} else {
//					o.addProperty("message", "EL USUARIO O CONTRASE—A SON INV¡LIDOS");
//				}

			} else o.addProperty("message", "Usuario no encontrado [404]");
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [500]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
		}
	}
 
	@RequestMapping(value = "/tav2-session")
	public void viewTANSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constantes.USR_SESION)!=null) {//Constantes.CLIENT_SESION)!=null) {
            	client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);//Constantes.CLIENT_SESION);
            	// valida si la cuenta se encuentra activa
              	LoggerApi.Log.info("Cuenta Activa: mobileStatus TA " + client.getMobileStatus());
            	if(client.getMobileStatus().equals("ACT")) {
            		// Arma la url + token para redirigir a te apuesto
                	LoggerApi.Log.info("Redirect a TA: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement() + " status_mail: " + client.getMailStatus());
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constantes.tav2GameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(client.getClientId(), request.getRemoteAddr());
              	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
              		o.addProperty("authToken", tanTokenGeneration.getTav2Token());
                }
            } else {
            		// la cuenta se encuentra desactivada
                	LoggerApi.Log.info("Falta activar cuenta TA: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement());
                	String urlReferer = request.getHeader("Referer");	
                	// invalida la session cuando la referencia no es el modulo de activar cuenta.
                	if(session != null && !urlReferer.endsWith("/activar.html")) session.invalidate();
                	// redirije al home de te apuesto
                	o.addProperty("message", "ON");
                    o.addProperty("redireccion", Constantes.tav2GameProviderCloseUrl);
            	}
            } else {
            	LoggerApi.Log.info("Redireccion incorrecta TA: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement());
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constantes.tav2GameProviderCloseUrl);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/ddvv-session")
	public void viewDDVVSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constantes.USR_SESION)!=null) {//Constantes.CLIENT_SESION)!=null) {
            	client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);//Constantes.CLIENT_SESION);
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constantes.tav2GameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(client.getClientId(), request.getRemoteAddr());
              	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
              		o.addProperty("authToken", tanTokenGeneration.getTav2Token()+"&ref=/virtuals");
                }
            } else {
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constantes.ddvvGameProviderCloseUrl);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	
	@RequestMapping(value = "/tav2-nosession")
	public void viewTANNoSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
        try {
        	HttpSession session = request.getSession();
        	if(session.getAttribute("operatorId")!=null && String.valueOf(session.getAttribute("operatorId")).toString().trim().equals(Constantes.tav2OperatorId.toString().trim())) {
        		if(request.getParameter("redirectGame") != null && request.getParameter("redirectGame").toString().equals("DV"))
        			o.addProperty("redireccion", Constantes.ddvvGameProviderCloseUrl);
        		else
        			o.addProperty("redireccion", Constantes.tav2GameProviderCloseUrl);
        		//o.addProperty("redireccion", Constantes.tav2GameProviderBaseUrl);
        		session.removeAttribute("operatorId");
        		session.removeAttribute("redirectGame");
        	}
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
	@RequestMapping(value ="/enviarDerechosArco")
    public void enviarformDerechosArco(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	JsonObject o = new JsonObject();
    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
     	String tipoDocumento ="";
    	String numeroDocumento="";
    	String tipoDocumentolegal ="";
    	String numeroDocumentolegal="";
    	String codeClient = "";
    	Date fechaHoy = new Date();
    	String pattern = "dd MMM yyyy',' hh:mm:ss";	
    	String tipo_solicitudSW = "";
		SimpleDateFormat simpleDateFormat =
		        new SimpleDateFormat(pattern);
		String strDate = simpleDateFormat.format(fechaHoy).toUpperCase(); 
		String imgTinka= "https://www.latinka.com.pe/latinka/mailing-sale/logo_tinka.gif?v=2";
		String imgBanner ="https://www.latinka.com.pe/latinka/mailing-sale/collage-logos.gif?v=2";
    	
    	try {
    		String dni         = request.getParameter("dni");
    		String pasaporte         = request.getParameter("document-number-pasap");
    		String carnetext         = request.getParameter("document-number-carex");
    		String imgDNI	   = request.getParameter("imgBase64P1Trans")!=null?request.getParameter("imgBase64P1Trans"):"";
    		String imgDNI2	   = request.getParameter("imgBase64P2Trans")!=null?request.getParameter("imgBase64P2Trans"):"";
    		String imgDNI3	   = request.getParameter("imgBase64P3Trans")!=null?request.getParameter("imgBase64P3Trans"):"";
    		String imgDNI4	   = request.getParameter("imgBase64P4Trans")!=null?request.getParameter("imgBase64P4Trans"):"";
        	String email       = request.getParameter("email");
        	String nombres      = request.getParameter("nombres");
        	String apellidos   = request.getParameter("apellidos");
        	String user    	   = request.getParameter("usuario");
        	String nacionalidad = request.getParameter("nacionalidad");
        	String domicilio   = request.getParameter("domicilio");
        	String telefono    = request.getParameter("telefono");
        	String departamento = request.getParameter("departamento");
        	String provincia = request.getParameter("provincia");
        	String distrito = request.getParameter("distrito");
        	String tipo_solicitud = request.getParameter("solicitud");
        	String razon_solicitud = request.getParameter("razon");
        	String nombre_legal= request.getParameter("name-legal");
        	String apellidos_legal= request.getParameter("ap-paterno-legal");
        	String dni_legal= request.getParameter("document-number-legal");
        	String pasaporte_legal= request.getParameter("document-number-pasap-legal");
        	String carnetex_legal= request.getParameter("document-number-carex-legal");
        	String documentType= request.getParameter("document-type");
        	String documentTypeLegal= request.getParameter("document-type-legal");
        	String isRepresentante= request.getParameter("is-representante");
        	
        	String mensajeError ="";
        	
        	if(nombres==null || nombres.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tus nombres";
        	}else if(apellidos==null || apellidos.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tus apellidos";
//        	}else if(user==null || user.trim().isEmpty()) {
//        		mensajeError ="Debes ingresar tu usuario";
        	}else if(documentType==null) {
        		mensajeError ="Debes seleccionar tu tipo de documento";
        	}else if(!documentType.equals("DNI") && !documentType.equals("PASAP") && !documentType.equals("CAREX")) {
        		mensajeError ="Debes seleccionar un tipo de documento v·lido";
        	}else if(documentType.trim().equals("DNI") && (dni==null || dni.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un DNI v·lido";
        	}else if(documentType.trim().equals("PASAP") && (pasaporte==null || pasaporte.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un pasaporte v·lido";
        	}else if(documentType.trim().equals("CAREX") && (carnetext==null || carnetext.trim().isEmpty())) {
        		mensajeError ="Debes ingresar un carnet de extranjerÌa v·lido";
        	}else if(telefono==null || telefono.trim().isEmpty()) {
        		mensajeError ="Debes ingresar un celular v·lido";
        	}else if(email==null || email.trim().isEmpty()) {
        		mensajeError ="Debes ingresar un correo v·lido";
        	}else if(nacionalidad==null || nacionalidad.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu nacionalidad";
        	}else if(domicilio==null || domicilio.trim().isEmpty()) {
        		mensajeError ="Tu domicilio es requerido";
        	}else if(departamento==null || departamento.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu departamento";
        	}else if(provincia==null || provincia.trim().isEmpty()) {
        		mensajeError ="Debes ingresar tu provincia";
        	}else if(distrito==null || distrito.trim().isEmpty()) {
        		mensajeError ="Seleccionar distrito";
        	}else if(imgDNI==null || imgDNI.trim().isEmpty()) {
        		mensajeError ="Debes adjuntar tu documento de identidad";
			}else if(razon_solicitud==null || razon_solicitud.trim().isEmpty()) {
        		mensajeError ="Debes ingresar la razon de tu solicitud";
			}else if(tipo_solicitud==null || tipo_solicitud.trim().isEmpty()) {
        		mensajeError ="Debes seleccionar un tipo de solicitud";
			}else if(!tipo_solicitud.equalsIgnoreCase("RECTIFICACI”N") && !tipo_solicitud.equalsIgnoreCase("ACCESO") && 
					!tipo_solicitud.equalsIgnoreCase("CANCELACI”N") && !tipo_solicitud.equalsIgnoreCase("OPOSICI”N")) {
				mensajeError ="Debes seleccionar un tipo de solicitud v·lido";
			}else if(isRepresentante!=null && isRepresentante.trim().equals("true")) {
				if(nombre_legal==null || nombre_legal.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar tus nombres de representante legal";
	        	}else if(apellidos_legal==null || apellidos_legal.trim().isEmpty()) {
	        		mensajeError ="Debes ingresar tus apellidos de representante legal";
	        	}else if(documentTypeLegal==null) {
	        		mensajeError ="Debes seleccionar tu tipo de documento de representante legal";
	        	}else if(!documentTypeLegal.equals("DNI") && !documentTypeLegal.equals("PASAP") && !documentTypeLegal.equals("CAREX")) {
	        		mensajeError ="Debes seleccionar un tipo de documento v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("DNI") && (dni_legal==null || dni_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un DNI v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("PASAP") && (pasaporte_legal==null || pasaporte_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un pasaporte v·lido de representante legal";
	        	}else if(documentTypeLegal.trim().equals("CAREX") && (carnetex_legal==null || carnetex_legal.trim().isEmpty())) {
	        		mensajeError ="Debes ingresar un carnet de extranjerÌa v·lido de representante legal";
	        	}else if(imgDNI3==null || imgDNI3.trim().isEmpty()) {
	        		mensajeError ="Debes adjuntar tu documento de identidad de representante legal";
				}else if(imgDNI4==null || imgDNI4.trim().isEmpty()) {
	        		mensajeError ="Debes adjuntar tu declaraciÛn jurada de representante legal";
				}
			}
        	
        	//validacion de peso e imagen dni correcta
        	if(mensajeError.isEmpty()) {
        		String mensajeValidacion = Constantes.validarImagen(imgDNI);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de documento de identidad no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de documento de identidad v&aacute;lida";
        			}
        		}
        	}
        	//validacion de peso e imagen evidencia correcta
        	if(mensajeError.isEmpty() && imgDNI2!=null && !imgDNI2.trim().isEmpty()) {
        		String mensajeValidacion = Constantes.validarImagen(imgDNI2);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de evidencia no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de evidencia v&aacute;lida";
        			}
        		}
        	}
        	//validaciones de peso e imagen legal
        	if(mensajeError.isEmpty() &&  isRepresentante!=null && isRepresentante.trim().equals("true")) {
        		String mensajeValidacion = Constantes.validarImagen(imgDNI3);
        		if(!mensajeValidacion.isEmpty()) {
        			if(mensajeValidacion.equals("ERROR_PESO")) {
        				mensajeError="T&uacute; imagen de documento de identidad de representante legal no debe ser mayor a 10mb";
        			}else {
        				mensajeError="Debes adjuntar una imagen de documento de identidad de representante legal v&aacute;lida";
        			}
        		}else {
        			mensajeValidacion = Constantes.validarImagen(imgDNI4);
        			if(!mensajeValidacion.isEmpty()) {
            			if(mensajeValidacion.equals("ERROR_PESO")) {
            				mensajeError="T&uacute; imagen de declaraciÛn jurada de representante legal no debe ser mayor a 10mb";
            			}else {
            				mensajeError="Debes adjuntar una imagen de declaraciÛn jurada de representante legal v&aacute;lida";
            			}
            		}
        		}
        	}
        	
        	if(mensajeError.isEmpty()) {        		
	        	if(!dni.equalsIgnoreCase("")){
	        		tipoDocumento = "DNI";
	        		numeroDocumento = dni;
	        	}else if(!pasaporte.equalsIgnoreCase("")) {
	        		tipoDocumento = "Pasaporte";
	        		numeroDocumento = pasaporte;
	        	}else if(!carnetext.equalsIgnoreCase("")) {
	        		tipoDocumento = "Carnet de Extranjeria";
	        		numeroDocumento = carnetext;
	        	}
	        	
	        	if(!dni_legal.equalsIgnoreCase("")){
	        		tipoDocumentolegal = "DNI";
	        		numeroDocumentolegal = dni;
	        	}else if(!pasaporte_legal.equalsIgnoreCase("")) {
	        		tipoDocumentolegal = "Pasaporte";
	        		numeroDocumentolegal = pasaporte;
	        	}else if(!carnetex_legal.equalsIgnoreCase("")) {
	        		tipoDocumentolegal = "Carnet de Extranjeria";
	        		numeroDocumentolegal = carnetext;
	        	}
	        	
	        	if(codeClient == "" ) {
	        		codeClient = securityLoginBo.findCodUserfilter1(dni, nombres);
	        	}
	        	
	        	if(codeClient  == "") {
	        		codeClient = securityLoginBo.findCodUserfilter2(dni, email);
	        	}
	        	
	        	if(codeClient  == "") {
	        		codeClient = securityLoginBo.findCodUserfilter3(dni, telefono);
	        	}
	        	
	        	if(tipo_solicitud.equalsIgnoreCase("RECTIFICACI”N")) {
	        		tipo_solicitudSW = "RectificaciÛn de Datos Personales";
	        	}else if(tipo_solicitud.equalsIgnoreCase("ACCESO")) {
	        		tipo_solicitudSW = "Acceso a Datos Personales";
	        	}else if(tipo_solicitud.equalsIgnoreCase("CANCELACI”N")) {
	        		tipo_solicitudSW = "CancelaciÛn de Cuenta";
	        	}else if(tipo_solicitud.equalsIgnoreCase("OPOSICI”N")) {
	        		tipo_solicitudSW = "OposiciÛn al uso de datos";
	        	}
	        	
	  	      StringBuffer strbf = new StringBuffer();
	  	      StringBuffer strbf2 = new StringBuffer();
	  	      StringBuffer strbf3 = new StringBuffer();
	  	      StringBuffer strbf4 = new StringBuffer();
	  	      Matcher match = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(apellidos);
	  	      Matcher match2 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(nombres);
	  	      Matcher match3 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(apellidos_legal);
		      Matcher match4 = Pattern.compile("([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—])([a-z·ÈÌÛ˙¡…Õ”⁄‰ÎÔˆ¸ˆƒÀœ÷‹Ò—]*)", Pattern.CASE_INSENSITIVE).matcher(nombre_legal);
	  	      while(match.find()) 
	  	      {
	  	         match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
	  	      }
	  	      while(match2.find()) 
		      {
		         match2.appendReplacement(strbf2, match2.group(1).toUpperCase() + match2.group(2).toLowerCase());
		      }
	  	      while(match3.find()) 
		      {
		    	  match3.appendReplacement(strbf3, match3.group(1).toUpperCase() + match3.group(2).toLowerCase());
		      }
		      while(match4.find()) 
		      {
		    	  match4.appendReplacement(strbf4, match4.group(1).toUpperCase() + match4.group(2).toLowerCase());
		      }

	  	      String f_apellido = match.appendTail(strbf).toString();
	  	      String f_nombres = match2.appendTail(strbf2).toString();
	  	      String fl_apellido = match3.appendTail(strbf3).toString();
		      String fl_nombres = match4.appendTail(strbf4).toString();
	        	        	        	
	        	String bodyCliente = "<html>\r\n" + 
	        			"<head>\r\n" + 
	        			"<title>La Tinka - Derechos Arco</title>\r\n" + 
	        			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	        			"</head>\r\n" + 
	        			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" + 
	        			"\r\n" + 
	        			"<table width=\"600\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>\r\n" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\">\r\n" + 
	        			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>\r\n" + 
	        			"		<td rowspan=\"7\" bgcolor=\"#dedede\"  width=\"65\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>"+f_nombres+" "+f_apellido+"</strong></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"50\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">Recibimos tu solicitud, ser&aacute; atendida dentro del plazo establecido. Te enviamos una copia de los datos recibidos.</td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"	<td width=\"20\"></td>\r\n" + 
	        			"	<td width=\"430\" bgcolor=\"#ffffff\" style=\"display:block; color:#5a5a5a; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:13px;\">\r\n" + 
	        			"		<strong>DATOS DEL TITULAR</strong><br>\r\n" + 
	        			"		Nombre: "+f_nombres+"<br>\r\n" + 
	        			"		Apellidos: "+f_apellido+"<br>\r\n" + 
	        			"		Usuario: "+user+"<br>\r\n" + 
	        			"		DNI: "+dni+"<br>\r\n" + 
	        			"		Pasaporte: "+pasaporte+"<br>\r\n" + 
	        			"		Carnet de Extranjer&iacute;a: "+carnetext+"<br>\r\n" + 
	        			"		N&uacute;mero de Celular: "+telefono+"<br>\r\n" + 
	        			"		E-mail: "+email+"<br>\r\n" + 
	        			"		Nacionalidad: "+nacionalidad+"<br>\r\n" +
	        			"		Domicilio: "+domicilio+"<br>\r\n" + 
	        			"		Departamento: "+departamento+"<br>\r\n" + 
	        			"		Provincia: "+provincia+"<br>\r\n" + 
	        			"		Distrito: "+distrito+"<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>DATOS DEL REPRESENTANTE LEGAL</strong><br>\r\n" + 
	        			"		Nombre: "+fl_nombres+"<br>\r\n" + 
	        			"		Apellidos: "+fl_apellido+"<br>\r\n" + 
	        			"		DNI: "+dni_legal+"<br>\r\n" + 
	        			"		Pasaporte: "+pasaporte_legal+"<br> \r\n" + 
	        			"		Carnet de Extranjer&iacute;a: "+carnetex_legal+"<br> \r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>TIPO DE SOLICITUD</strong> <br>\r\n" + 
	        			"		Tipo: "+tipo_solicitud+"<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<strong>RAZON DE LA SOLICITUD</strong> <br>\r\n" + 
	        			"		Comentario:"+razon_solicitud+"<br>\r\n" + 
	        			"		\r\n" + 
	        			"		<br>\r\n" + 
	        			"		<br>\r\n" + 
	        			"		</td>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"430\"  alt=\"\" style=\"display:block; color:#707070; text-align:justify; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:11px; padding-left\">Responderemos a tu solicitud al correo registrado. Las solicitudes se responder·n dentro de los plazos establecidos en el CapÌtulo I del TÌtulo IV del Reglamento de la Ley de ProtecciÛn de Datos Personales, aprobado por Decreto Supremo No. 003-2013-JUS. Si no obtiene respuesta dentro de los plazos indicados podr· ejercer un procedimiento de tutela ante la DirecciÛn General de ProtecciÛn de Datos Personales (Ministerio de Justicia).\r\n" + 
	        			"		<br><br></td>\r\n" + 
	        			"		<td width=\"20\"></td>\r\n" + 
	        			"	</tr>	\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"3\" bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"5\" bgcolor=\"#dedede\">\r\n" + 
	        			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"	<tr>\r\n" + 
	        			"		<td colspan=\"5\" bgcolor=\"#dedede\" width=\"600\" height=\"20\" alt=\"\"></td>\r\n" + 
	        			"	</tr>\r\n" + 
	        			"</table>\r\n" + 
	        			"</body>\r\n" + 
	        			"</html>";
	        	
	        	String body = 
						"##OPERATION=ADD_REQUEST##\r\n"+
						"##REQUESTTEMPLATE=Default Request##\r\n"+
						"##CATEGORY=Canal Web##\r\n"+
						"##SUBCATEGORY=Derechos ARCO (Datos Personales)##\r\n"+
						"##REQUESTTYPE=Incident##\r\n"+
						"##UDF_DATE1="+strDate+"##\r\n"+
						"##UDF_CHAR1=Autoservicio Datos Personales##\r\n"+
						"##ITEM="+tipo_solicitudSW+"##\r\n"+
						"##UDF_CHAR5="+apellidos+"##\r\n"+
						"##UDF_CHAR6="+nombres+"##\r\n"+
						"##UDF_CHAR7="+user+"##\r\n"+
						"##UDF_CHAR4="+telefono+"##\r\n"+
						"##UDF_CHAR3="+email+"##\r\n"+
						"##UDF_CHAR18="+tipoDocumento+"##\r\n"+
						"##UDF_CHAR19="+numeroDocumento+"##\r\n"+
						"##UDF_CHAR34="+nacionalidad+"##\r\n"+
						"##UDF_CHAR20="+domicilio+"##\r\n"+
						"##UDF_CHAR21="+departamento+"##\r\n"+
						"##UDF_CHAR22="+provincia+"##\r\n"+
						"##UDF_CHAR23="+distrito+"##\r\n"+
						"##UDF_CHAR24="+nombre_legal+"##\r\n"+
						"##UDF_CHAR25="+apellidos_legal+"##\r\n"+
						"##UDF_CHAR26="+tipoDocumentolegal+"##\r\n"+
						"##UDF_CHAR27="+numeroDocumentolegal+"##\r\n"+
						"##UDF_CHAR28="+razon_solicitud+"##\r\n"+
						"##UDF_CHAR2="+codeClient+"##\r\n"+
						"##SUBJECT=ID Cliente "+codeClient+"/ Derechos ARCO - DATOS PERSONALES##\r\n";
	        	
	        	o = generarCorreoFormularioPD(imgDNI,imgDNI2, imgDNI3, imgDNI4, o,body,tipo_solicitud,f_nombres,f_apellido,tipoDocumento,numeroDocumento,bodyCliente,email);
        	}else {
        		o.addProperty("message", "KOO");
    			o.addProperty("error", mensajeError);
        	}
        	out.print(o);
		} catch (Exception e) {
			o.addProperty("message", "KO");
			o.addProperty("error", "<p>Revise los datos antes de enviarlos.</p>");
			out.print(o);
		}
    }
	
	
	public JsonObject generarCorreoFormularioPD(String imgDNI, String imgDNI2,String imgDNI3,String imgDNI4,JsonObject o,String body,String tipo_solicitud,String f_nombres,String f_apellido,String tipoDocumento,String numeroDocumento,String bodyCliente,String email){
		List<ImgDto> listaImgDto= new ArrayList<ImgDto>();
		try {		
			ImgDto imgdto = new ImgDto();
			ImgDto imgdto2 = new ImgDto();
			ImgDto imgdto3 = new ImgDto();
			ImgDto imgdto4 = new ImgDto();
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(imgDNI.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
			imgdto.setContenidoImg(decodedBytes);
			imgdto.setFileName("img1.jpg");
			if(imgDNI.contains("png")) {
				imgdto.setTipoImg("image/png");
			}else if(imgDNI.contains("jpeg")) {
				imgdto.setTipoImg("image/jpeg");
			}
			listaImgDto.add(imgdto);
			if(!imgDNI2.equalsIgnoreCase("")) {
				byte[] decodedBytes2 = decoder.decodeBuffer(imgDNI2.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto2.setContenidoImg(decodedBytes2);
				imgdto2.setFileName("img2.jpg");
				if(imgDNI2.contains("png")) {
					imgdto2.setTipoImg("image/png");
				}else if(imgDNI2.contains("jpeg")) {
					imgdto2.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto2);
			}
			if(!imgDNI3.equalsIgnoreCase("")) {
				byte[] decodedBytes3 = decoder.decodeBuffer(imgDNI3.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto3.setContenidoImg(decodedBytes3);
				imgdto3.setFileName("img3.jpg");
				if(imgDNI3.contains("png")) {
					imgdto3.setTipoImg("image/png");
				}else if(imgDNI3.contains("jpeg")) {
					imgdto3.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto3);
			}
			
			if(!imgDNI4.equalsIgnoreCase("")) {
				byte[] decodedBytes4 = decoder.decodeBuffer(imgDNI4.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", ""));
				imgdto4.setContenidoImg(decodedBytes4);
				imgdto4.setFileName("img4.jpg");
				if(imgDNI4.contains("png")) {
					imgdto4.setTipoImg("image/png");
				}else if(imgDNI4.contains("jpeg")) {
					imgdto4.setTipoImg("image/jpeg");
				}
				listaImgDto.add(imgdto4);
			}
																																																			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(decodedBytes);
			baos.flush();
			baos.close();
	    	
	    	//Envio de correo
			beanSecurityLoginBo.enviarMailClientePD(bodyCliente,tipo_solicitud,f_nombres,f_apellido,tipoDocumento,numeroDocumento,email);
			//String result = sendRawMailPD("reclamosvirtuales@latinka.com.pe","SoporteWeb@latinka.com.pe","###WEB Derechos ARCO", body,baos,listaImgDto);	
			String result = sendRawMailPD("reclamosvirtuales@latinka.com.pe","soporteweb@sdp730275231.zm.sdpondemand.com","###WEB Derechos ARCO", body,baos,listaImgDto);	
			try { sendRawMailPD("reclamosvirtuales@latinka.com.pe","soporteweb@latinka.com.pe","###WEB Derechos ARCO", body,baos,listaImgDto); } catch (Exception e) {;}	
           	
	    	if(result.equalsIgnoreCase("OK")) {
	    		o.addProperty("message", "OK");
	    	}else if(result.equalsIgnoreCase("KO")) {
	    		o.addProperty("message", "KO");
	    	}
		} catch (Exception e) {
			o.addProperty("message", "KO");
			o.addProperty("error", "<p>Revise los datos antes de enviarlos. Alguno de ellos puede tener un tamaÒo muy grande.</p>");
		}
		return o;
	}

	public String sendRawMailPD(String mailSource, String mailTarget, String mailSubject, String mailBody,ByteArrayOutputStream baos,List<ImgDto> listImgDto)  
	{ 
		try {

			Session session = null;
			
			String contentType = "text/plain; charset=UTF-8";
			
			System.out.println(">>>>>> START sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			System.out.println("sendValidMail mailSubject="+mailSubject);
			System.out.println("sendValidMail mailBody="+mailBody);
			
			String mailServer = "";
			
			try {
				Context ic = new InitialContext();
				session = (Session)ic.lookup("java:Mail"); 
				//session = (javax.mail.Session) new javax.naming.InitialContext().lookup("java:Mail");
				System.out.println("sendValidMail session=java:Mail");
				 
				try {
					System.out.println( "host="+session.getProperty("mail.smtp.host") );
					System.out.println( "port="+session.getProperty("mail.smtp.port") );
					System.out.println( "from="+session.getProperty("mail.from") );
					System.out.println( "user="+session.getProperty("User") );
				} catch (Exception e) {
					;
				}
				 
			} catch (javax.naming.NamingException e) {
				//System.out.println("mailBody="+mailBody);
				try {
					mailServer = ConnectionFactory.operationProperty("mailServer", "CARD-SMS"); //MAIL_SERVER;
					//mailSource = operationProperty("mailSource", context); //MAIL_SOURCE;
					//System.out.println("mailServer="+mailServer);
					java.util.Properties props = new java.util.Properties();
					props.put("mail.smtp.host", mailServer);
					session = Session.getInstance(props, null);
				} catch (Exception ex) {
					System.out.println("sendValidMail ex.getMessage()="+ex.getMessage());
					//ex.printStackTrace(System.out);
				}
				System.out.println("sendValidMail mailServer="+mailServer);
			}
		// construct the message
			
			
			BodyPart texto = new MimeBodyPart();
	        texto.setContent(mailBody, contentType);
	        MimeMultipart multiParte = new MimeMultipart();
	        multiParte.addBodyPart(texto);
	        
	        
	        if(baos!=null){
	        	for(ImgDto imgdto : listImgDto) {
	        		BodyPart adjunto = new MimeBodyPart();         
		       		ByteArrayDataSource attachment = new  ByteArrayDataSource(imgdto.getContenidoImg(),imgdto.getTipoImg());
		       		adjunto.setDataHandler(new DataHandler(attachment));
		            adjunto.setFileName(imgdto.getFileName());
		            multiParte.addBodyPart(adjunto);
	        	}
	            
	        }
			
			
			

			Message msg = new MimeMessage(session);
			
			//InternetAddress[] ccaddress = new InternetAddress[1];
			//ccaddress[0] = new InternetAddress(mailTarget);//(destino);
			InternetAddress[] ccaddress = InternetAddress.parse(StringLib.removeWhitespaces(mailTarget));
			
			if (mailSource!=null) {
				InternetAddress from = new InternetAddress(mailSource);//(origen);
		        msg.setFrom(from);
			}

			//System.out.println("mailSource="+mailSource+" mailTarget="+mailTarget+" mailSubject="+mailSubject);
			msg.setRecipients(Message.RecipientType.TO,ccaddress);
			msg.setSubject(mailSubject);//(subject);
			//msg.setContent(mailBody, "text/html; charset=UTF-8");//(cuerpo,content);

			System.out.println("sendValidMail contentType="+contentType);
			
			//msg.setContent(mailBody, contentType);
			msg.setContent(multiParte,contentType);
			msg.setHeader("Content-Transfer-Encoding", "binary");
			
			Transport.send(msg);
			
			System.out.println("<<<<<< END sendValidMail mailSource="+mailSource+" mailTarget="+mailTarget);
			
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "KO";
		}
		
		
		
	}
	
	@RequestMapping(value = "/teapuesto-tav2")
    public String teapuesto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "game/teapuesto/teapuesto_tav2";
    }
	
	@RequestMapping(value = "/juegos-virtuales-session")
	public void viewJuegosVirtualesSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		ClientProcedureGetLoginData client = new ClientProcedureGetLoginData();
		String producto = request.getParameter("producto");
        try {
        	HttpSession session = request.getSession();
            if(session != null && session.getAttribute(Constantes.USR_SESION)!=null) {//Constantes.CLIENT_SESION)!=null) {
            	client = (ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION);//Constantes.CLIENT_SESION);
            	LoggerApi.Log.info("Cuenta Activa: mobileStatus DDVV " + client.getMobileStatus());
            	// valida si la cuenta se encuentra activa
            	if(client.getMobileStatus().equals("ACT")) {
            		// Arma la url + token para redirigir a juegos virtuales
                	LoggerApi.Log.info("Redirect a DDVV: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement() + " status_mail: " + client.getMailStatus());             	
            	o.addProperty("message", "OK");
                o.addProperty("redireccion", Constantes.juegosVirtualesGameProviderBaseUrl);
                ClientProcedureTANTokenGeneration tanTokenGeneration = beanSecurityLoginBo.getTANToken(client.getClientId(), request.getRemoteAddr());
              	if (tanTokenGeneration!=null && tanTokenGeneration.getMessage().equals("OK")) {
              		o.addProperty("authToken", tanTokenGeneration.getTav2Token()+"&ref=/" + producto);
                }
            	}else {
            		// la cuenta se encuentra desactivada
                	LoggerApi.Log.info("Falta activar cuenta DDVV: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement());
                	String urlReferer = request.getHeader("Referer");	
                	// invalida la session cuando la referencia no es el modulo de activar cuenta.
                	if(session != null && !urlReferer.endsWith("/activar.html")) session.invalidate();
                	// redirije al home de te juegos virtuales
                	o.addProperty("message", "ON");
                    o.addProperty("redireccion", Constantes.tav2GameProviderCloseUrl);
            	}

            } else {
            	LoggerApi.Log.info("Redireccion incorrecta DDVV: client_id " + client.getClientId() + " nombre: " + client.getNombre() + " agreement: "+ client.getAgreement());
            	o.addProperty("message", "ON");
                o.addProperty("redireccion", Constantes.juegosVirtualesGameProviderCloseUrl+producto);
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
            o.addProperty("message", "");
            o.addProperty("redireccion", "");
        } finally {
        	out.print(o);
            LoggerApi.Log.info(o.toString());
        }
    }
    
    @RequestMapping("/security-login-session-doc-type")
    public void loginSessionDocType(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        JsonObject o = new JsonObject();
        
        if(!validateLengthDocType(request)) {
			o.addProperty("error", "LG");
        	o.addProperty("alertLogin", "Datos de ingreso incorrectos. Ingreso denegado.");
        	out.print(o);
			return;
		}

        ClientProcedureGetLoginData client = null;
        try {
        		
        	client = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
        	if(!client.getStatus().equals("OK")) {
        		o.addProperty("error", client.getStatus());
            	o.addProperty("alertLogin", client.getStatus());
            	o.addProperty("title", client.getTitle());
            	o.addProperty("message", client.getMessage());
            	o.addProperty("button", client.getButton());
            	out.print(o);
            	return;
        	
            } else {
            	o = validarUsuarioJson(client,1,request);
            	Client objectPojo=beanClientAccountBo.findClientById(client.getClientId());
            	Client clientS = new Client();
            	clientS.setClientId(objectPojo.getClientId());
            	clientS.setName(objectPojo.getName());
            	clientS.setLastname(objectPojo.getLastname());
            	clientS.setMaidenname(objectPojo.getMaidenname());
            	clientS.setMail(objectPojo.getMail());
            	clientS.setDocNumber(objectPojo.getDocNumber());
            	clientS.setDocType(objectPojo.getDocType());
            	
            	HttpSession clientSession = request.getSession();
            	clientSession.setAttribute("CLIENT_SESSION", clientS);
            	
            	clientSession.setAttribute("name",clientS.getName());
            	clientSession.setAttribute("lastname",clientS.getLastname());
            	clientSession.setAttribute("maidenname",clientS.getMaidenname());
            	clientSession.setAttribute("mail",clientS.getMail());
            	clientSession.setAttribute("cid",clientS.getClientId());
            	out.print(o);
            	
            	// Corrije NullPointer en el session del lightbox de SMS
            	clientSession.setAttribute(Constantes.CLIENT_SESION, client);
            	
            	//eval visibilidad tutorial
            	if(Constantes.TUTORIAL_ENABLED.equals("true")) {
                	Object[] values = new Object[4];
                	values[0] = client.getClientId();
                	values[1] = Constantes.TUTORIAL_MAX_PER_DAY;
                	values[2] = Constantes.TUTORIAL_MAX_TOTAL;
                	values[3] = Constantes.TUTORIAL_MAX_DAYS;
                	ClientTutorial clientTutorial = beanClientAccountBo.evalTutorial(values);
                	clientSession.setAttribute("tutorial", clientTutorial);
            	}
            	            	
            	/*if(objectPojo.getPlayerIdXpg() == null) {
            		CasinoXpgUtils u = new CasinoXpgUtils("createPlayer",client.getClientId().toString(), beanSecurityLoginBo);            		
            		u.start();            		
            	}*/
            	
            	return;
            }
                
        } catch (Exception e) {
        	o.addProperty("title", "Datos incorrectos");
        	o.addProperty("message", "Uno de tus datos es incorrecto o no existe. Revisa si digitaste correctamente y vuelve a intentarlo");
        	out.print(o);
            LoggerApi.severe(e);
        	
           return;
        } 
    }
	
	@RequestMapping(value = "/tav2-login-dt")
	public void viewTANLoginDT(@RequestParam("callback") String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		String outData = "";
		Integer cid = 0,state=0;
		ClientProcedureGetLoginData procedureLogin = null;
		
		if(!validateLengthDocType(request)) {
        	o.addProperty("message", "Dato de ingreso incorrecto. Ingreso denegado.");
        	outData = callback + "(" + o + ")";
        	out.print(outData);
			return;
		}
		
		try {
			HttpSession session = request.getSession();

			procedureLogin = securityUtils.obtenerLogin(request,intralotUtils,beanClientAccountBo);
			if(procedureLogin != null) {
				state = procedureLogin.getState();
				cid = procedureLogin.getClientId();

				LoggerApi.Log.info("/tav2-login state=" + state + " cid="+ cid );
				if (procedureLogin.getStatus().equals("OK")) {
					o = validarUsuarioJson(procedureLogin,1,request);
					String TAV2Config = "", authToken="", ref="";
					String urlRedirect5587="";
					String operatorId="";
					if(o.get("state") != null && o.get("state").getAsString().equals("OK")) {
						session = request.getSession(false);
						if(session==null || !request.isRequestedSessionIdValid()) {
							session = request.getSession();
						}
						
						request.setAttribute("clientSale", procedureLogin);
						o.addProperty("id", cid);
						o.addProperty("user", procedureLogin.getCl_nombre());
						
						if(session.getAttribute("OperatorId")!=null && session.getAttribute("OperatorId").toString().trim().equals("5587") && request.getParameter("urlRedirect5587")!=null) {							
							if (!ConnectionFactory.operationProperty("applicationArea", "sale").toString().trim().toLowerCase().equals("production")) {
								urlRedirect5587 = request.getParameter("urlRedirect5587").toString().trim();
							}else {
								urlRedirect5587 = Constantes.lapollaGameProviderBaseUrl;
							}
							operatorId="5587";
							authToken = procedureLogin.getLapollaToken();
						}else {
							operatorId="5588";
							authToken = procedureLogin.getTav2Token();
						}				
						
						String urlRedirect5588	= (session.getAttribute("urlRedirect5588") != null) ? session.getAttribute("urlRedirect5588").toString() : request.getParameter("urlRedirect5588") ;
						ref = "&ref="+ ( (session.getAttribute("ref") != null) ? session.getAttribute("ref").toString() : request.getParameter("ref") );
						TAV2Config = (urlRedirect5588 != null && !urlRedirect5588.equals("")) ? urlRedirect5588 : Constantes.tav2GameProviderBaseUrl;
						
						Client objectPojo=beanClientAccountBo.findClientById(cid);
	                    session.setAttribute("name",objectPojo.getName());
	                    session.setAttribute("lastname",objectPojo.getLastname());
	                    session.setAttribute("maidenname",objectPojo.getMaidenname());
	                    session.setAttribute("mail",objectPojo.getMail());
	                    session.setAttribute("cid",objectPojo.getClientId());
	                    
	                    Client clientS = new Client();
	                	clientS.setClientId(objectPojo.getClientId());
	                	clientS.setName(objectPojo.getName());
	                	clientS.setLastname(objectPojo.getLastname());
	                	clientS.setMaidenname(objectPojo.getMaidenname());
	                	clientS.setMail(objectPojo.getMail());
	                	clientS.setDocNumber(objectPojo.getDocNumber());
	                	clientS.setDocType(objectPojo.getDocType());
	                	
	                	HttpSession clientSession = request.getSession();
	                	clientSession.setAttribute("CLIENT_SESSION", clientS);
					}
					
					if(operatorId.equals("5588")) {
						System.out.println("tav2: " + TAV2Config+" | "+authToken+ref);
						o.addProperty("tav2", TAV2Config+" | "+authToken+ref);
					}else {
						System.out.println("tav2: " + urlRedirect5587+" | "+authToken);
						o.addProperty("tav2", urlRedirect5587+" | "+authToken);
					}
										
					// Corrije NullPointer en el session del lightbox de SMS
				    session.setAttribute(Constantes.CLIENT_SESION, procedureLogin);
				} else {
					o.addProperty("error", procedureLogin.getStatus());
	            	o.addProperty("alertLogin", procedureLogin.getStatus());
	            	o.addProperty("title", procedureLogin.getTitle());
	            	o.addProperty("message", procedureLogin.getMessage());
	            	o.addProperty("button", procedureLogin.getButton());
				}
				

			} else o.addProperty("message", "Usuario no encontrado [404]");
			outData = callback + "(" + o + ")";
		} catch(Exception e) {
			o.addProperty("message", "Sucedio un error al iniciar sesi&oacute;n [500]");
			outData = callback + "(" + o + ")";
			LoggerApi.severe(e);
			throw e;
		} finally {
			out.print(outData);
		}
	}	
	
	@RequestMapping(value = "/get-fast-token")
	public void getFastToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject();
		SecurityTokenResponse responseToken = new SecurityTokenResponse();
		Gson gson = new Gson();
		try {
			String display = request.getParameter("display");
			String boleto = request.getParameter("boleto");
			
			//campos para tinkaexpress
			String totalJugadaA = request.getParameter("totalJugadaA");
			String totalJugadaB = request.getParameter("totalJugadaB");
			String totalJugadaC = request.getParameter("totalJugadaC");
			String totalJugadaD = request.getParameter("totalJugadaD");
			String consecutivas = request.getParameter("consecutivas");
			
			if(display != null) {
				HttpSession session = request.getSession();
				session.setAttribute("display", display);
			}
			if(boleto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("carrierBoleto", boleto);
			}
			LoggerApi.Log.info("hay display? =  " + display);
			LoggerApi.Log.info("hay boleto? =  " + boleto);
			
			o.addProperty("message", "OK");
			if(pe.com.intralot.loto.utils.ConnectionFactory.isDevelopment()) {
				String server = request.getRequestURL().toString();
				server = server.substring(0, server.lastIndexOf('/') + 1 );
				if(display!=null && display.equals("tinka_express")) {
					o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinkaexpress&tinkaEnvironment=" + server);
				}else {
					o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinka&tinkaEnvironment=" + server);
				}
				
			}else {
				if(display!=null && display.equals("tinka_express")) {
					o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinkaexpress");
				}else {
					o.addProperty("redirect", getPropertyContextSale("urlPamLogin") + "?operatorId=1&from=tinka");
				}				
			}
			String bodyRequest = "{}";
			if(display!=null && display.equals("tinka_express")) {
				if(Integer.parseInt(consecutivas)>1) {
					bodyRequest = "{\"data\":{\"isBetLimitExceeded\":\"true\"}}";
				}
				else {
					if(Integer.parseInt(totalJugadaA)>1 || Integer.parseInt(totalJugadaB)>1 || Integer.parseInt(totalJugadaC)>1 || Integer.parseInt(totalJugadaD)>1) {
						bodyRequest = "{\"data\":{\"isBetLimitExceeded\":\"true\"}}";
					}					
				}
				
			}
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("X-Ip-Origin", "192.68.1.1"); // TODO : aqui falta modificar el request.getRemoteAddr()
			headers.put("X-Company", "ECOM");
			//obtiene token
			String tokenResponse = ApiClient.post( getPropertyContextSale("urlSecurityToken") , bodyRequest, "12345678", "12345678", headers);
			o.addProperty("token", "");
			responseToken = gson.fromJson(tokenResponse, SecurityTokenResponse.class);
			LoggerApi.Log.info("tokenResponse="+tokenResponse);
			if (responseToken.getToken() != null && !responseToken.getToken().equals("")) {
				o.addProperty("token", responseToken.getToken());
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			o.addProperty("message", "");
			o.addProperty("redirect", "");
		} finally {
			out.print(o);
			LoggerApi.Log.info(o.toString());
		}
	}
	
	@RequestMapping(value = "/ta-preprod")
    public String viewTANPreprod(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	return "game/teapuesto/tav2_preprod"; 
    }
	
	@RequestMapping(value = "/validate-session")
    public void validateSession(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String log="validateDocument";
//    	LoggerApi.Log.info("-------------- START " +log);
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject oResponse = new JsonObject();
        ClientUpdateProcedureValidateSession validateSession=null;
    	ClientUpdateProcedureExpiredSession expiredSession=null;
    	JsonParser jparser = null;
    	String closeSession=session.getAttribute("closeSession")!=null?(String)session.getAttribute("closeSession"):"";
        try { 
        	if ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION) != null && ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getSessionId() != null
                    && ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId() != null) {
        		// Obtener el tiempo de la ˙ltima interacciÛn del usuario
                long ultimaInteraccion = session.getLastAccessedTime();
                
                // Obtener el tiempo actual
                long tiempoActual = System.currentTimeMillis();
                long lastValidateSession=session.getAttribute("lastValidateSession")!=null?(Long)session.getAttribute("lastValidateSession"):0;
                if(lastValidateSession!=0) {
                	ultimaInteraccion=lastValidateSession;
                }
                session.setAttribute("lastValidateSession",tiempoActual);
                
                // Calcular el tiempo transcurrido desde la ˙ltima interacciÛn
                long tiempoInactivo = tiempoActual - ultimaInteraccion;
                
                //Obtener tiempo para cierre de session
                int tiempoCierre = 30*60;
                String propTiempoCierre =ConnectionFactory.operationProperty("tiempoCierreSesion", Constantes.contextSale); 
                tiempoCierre=!propTiempoCierre.equals("")?Integer.parseInt(propTiempoCierre)*60:tiempoCierre;
                oResponse.addProperty("status","OK");
                oResponse.addProperty("message","Sesion activa");
                if(tiempoInactivo/1000>=tiempoCierre  && closeSession.equals("")) { //cierre de sesion si se supera 30 minutos de inactividad
                	//logica para regitrar evento de cierre de sesion
                	expiredSession=null;
    	        	jparser = new JsonParser();
    		        	JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    		        	Integer clientId=sessionData.get("clientId").getAsInt();
    		        	
    		        	expiredSession = clientBo.expiredSession(clientId);
    		        	//funcion http para cerrar TA
		        		String urlTA=securityUtils.fetchTA(request);
		        		oResponse.addProperty("urlTA",urlTA);
//    		        	session.invalidate();    	            	
//    		        	LoggerApi.Log.info("expiredSession: estado="+expiredSession.getState()+" mensaje="+expiredSession.getMessage());
//    		        	LoggerApi.Log.info("Cierre de session por inactividad: Tiempo de inactividad: "+(tiempoInactivo/1000));
    		        	session = request.getSession();
    		        	session.setAttribute("closeSession", "closeSession");
    		        	oResponse.addProperty("status","ERROR_EXPIRATION");
    	    			oResponse.addProperty("message","Cierre de sesion por tiempo de incatividad"); 
    	    			
//                }else if(tiempoInactivo/1000>2) { //cierre de sesion: inicio de sesion en otro dispositivo, bloqueo de cuenta 
                }else {
                	//logica para valiar tokensession
                	validateSession=null;
    	        	jparser = new JsonParser();      
    				
    					JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
    		        	String tokenSession=sessionData.get("tokenSession").getAsString();
    		        	Integer clientId=sessionData.get("clientId").getAsInt();
    		        	String mobilePhone=sessionData.get("celular").getAsString();
    		        	String docType=sessionData.get("tipoDocumento").getAsString();
    		        	String docNumber=sessionData.get("numeroDocumento").getAsString();
    					validateSession = clientBo.validateSession(tokenSession, clientId, mobilePhone, docType, docNumber);
    					//si token es diferente cerrar sesion
    		        	if(!validateSession.getState().equals("OK")) {
    		        		if(!validateSession.getState().equals("ERROR_TOKEN")) {
	    		        		//funcion http para cerrar TA
	    		        		String urlTA=securityUtils.fetchTA(request);
	    		        		oResponse.addProperty("urlTA",urlTA);
    		        		}
    		        		session.invalidate();
    		        		oResponse.addProperty("status",validateSession.getState());
        	    			oResponse.addProperty("message",validateSession.getMessage());
//    		        		LoggerApi.Log.info("Cierre de session por validateSession: Tiempo de inactividad: "+(tiempoInactivo/1000));
    		            }
                
                }	        		
	    		
        	}else {
//        		session = request.getSession();
//	        	session.setAttribute("closeSession", "closeSession");
        		oResponse.addProperty("status","OK");
    			oResponse.addProperty("message","No se encuentran datos de sesion");
        	}
        	out.print(oResponse);
//        	LoggerApi.Log.info("-------------- END " +log+" oResponse:"+oResponse);
		} catch (Exception e) {
			oResponse.addProperty("status", "OK");
			oResponse.addProperty("message","EXCEPTION");
			out.print(oResponse);
			LoggerApi.severe(e);
		}
    }
	
	@RequestMapping(value = "/validate-session2")
    public void validateSession2(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
    	String log="validateSession2";
//    	LoggerApi.Log.info("-------------- START " +log);
		HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
        JsonObject oResponse = new JsonObject();
        try { 
        	session.removeAttribute("closeSession");
        	session.invalidate();
        	oResponse.addProperty("status","OK");
			oResponse.addProperty("message","Se elimona atributo de cierre de sesion");        	
        	out.print(oResponse);
		} catch (Exception e) {
			oResponse.addProperty("status", "OK");
			oResponse.addProperty("message","EXCEPTION");
			out.print(oResponse);
			LoggerApi.severe(e);
		}
    }
	
	@RequestMapping(value ="/reniecvalidation")
    public void reniecvalidation(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		LoggerApi.Log.info("---------------- start [reniecvalidation]");
    	JsonObject jsonResponse = new JsonObject();
    	
    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
    	PrintWriter out = response.getWriter();
     	String tipoDocumento ="";
    	String numeroDocumento="";
    	String fechaDeNacimiento="";
    	String nombres="";
    	String apellidos="";
    	Gson gson = new Gson();
    	try {
    		tipoDocumento         = request.getParameter("docType");
    		numeroDocumento         = request.getParameter("document");
    		fechaDeNacimiento	=request.getParameter("birthDate");
        	nombres				=request.getParameter("names").toUpperCase();
        	apellidos		=request.getParameter("surnames").toUpperCase();
        	
        	//LoggerApi.Log.info("Tipo de Documento: "+tipoDocumento+" Numero de Documento: "+numeroDocumento+" Fecha de Nacimiento: "+fechaDeNacimiento+" Nombre: "+nombres+" Apellidos: "+apellidos);
        	
        	// Validaciones de los par·metros
            if (tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
                throw new IllegalArgumentException("Debes ingresar el tipo de documento.");
            }
            if (numeroDocumento == null || numeroDocumento.trim().isEmpty()) {
                throw new IllegalArgumentException("Debes ingresar el N∞ de documento.");
            }
            if ((fechaDeNacimiento == null || fechaDeNacimiento.trim().isEmpty()) && "CAREX".equalsIgnoreCase(tipoDocumento)) {
                throw new IllegalArgumentException("Debes ingresar la Fecha de Nacimiento.");
            }
        	
            ReniecWsRequest reniecRequest = new ReniecWsRequest(tipoDocumento, numeroDocumento, fechaDeNacimiento, nombres, apellidos);
            ObjectMapper objectMapper = new ObjectMapper();                                    
            String json = gson.toJson(reniecRequest);

            // Consumir la API Reniec
    		SecurityUtils securityUtils = new SecurityUtils();
    		String reniecResponseApi = securityUtils.validationreniecWs("reniecvalidation",json);
    		JsonNode rootNode = objectMapper.readTree(reniecResponseApi);
            ReniecWsResponse reniecResponse = gson.fromJson(reniecResponseApi, ReniecWsResponse.class);
            
            if (rootNode.has("data")) {
    		    JsonNode dataNode = rootNode.get("data");
    		    if (dataNode.isBoolean() && !dataNode.asBoolean()) {
    		        reniecResponse.setData(null);  
    		    } else if (dataNode.isObject()) {
    		        DataReniecResponse data = objectMapper.treeToValue(dataNode, DataReniecResponse.class);
    		        reniecResponse.setData(data);
    		    }
    		}

            jsonResponse.addProperty("message", "OK");
            jsonResponse.addProperty("error_code", reniecResponse.getError_code());
            jsonResponse.addProperty("error_message", reniecResponse.getError_message());
            //LoggerApi.Log.info("Reniec Response Api: " +reniecResponseApi);
            
            if (reniecResponse.getData() != null && reniecResponse.getData() instanceof DataReniecResponse) {
                DataReniecResponse data = (DataReniecResponse) reniecResponse.getData();
                JsonObject dataJson = new JsonObject();
                dataJson.addProperty("apellidos", data.isApellidos());
                dataJson.addProperty("fechaNacimiento", data.isFechaNacimiento());
                dataJson.addProperty("nombre", data.isNombre());
                jsonResponse.add("data", dataJson);
            } else {
                jsonResponse.add("data", JsonNull.INSTANCE);
            }

            
		} catch (IllegalArgumentException e) {
			jsonResponse.addProperty("message", "KO");
            jsonResponse.addProperty("error", e.getMessage());
		}catch (Exception e) {
			jsonResponse.addProperty("message", "KO"+e);
			jsonResponse.addProperty("error", "Revise los datos antes de enviarlos");
			out.print(jsonResponse);
		}    
    	finally {
            out.print(jsonResponse);
            LoggerApi.Log.info("--------------  END reniecvalidation convertedObject:" + jsonResponse.toString());
        }
    	
    }
	
}

