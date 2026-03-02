package pe.com.intralot.loto.layer.controller.payment.paysafecard;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.service.client.boimpl.ClientSaleBoImpl;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;
import pe.com.intralot.loto.util.ClientUtils;
import pe.com.intralot.loto.util.Constants;

import com.paysafecard.merchant.Debug;
import com.paysafecard.merchant.Log;
import com.paysafecard.merchant.SOPGClassicMerchantClient;

/**
 * Servlet implementation class index
 */
// @WebServlet("/createDisposition") 
public class createDisposition extends HttpServlet {
	  
	private static final long serialVersionUID = 6222675167005024706L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //@RequestMapping(value = "/createDisposition")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// https://customer.test.at.paysafecard.com/psccustomer/GetCustomerPanelServlet?currency=PEN&mtid=4&amount=21.00&mid=1000005681
		/*
		 * This function reads the form entries and saves them in variables.
		 */
		
		String amount = request.getParameter("amount");
		String shopLabel = request.getParameter("shopLabel");
		//String mtid = BussinessSaleLotos5Dispatcher.getSequenceId("TID"); // request.getParameter("mtid");
		String currency = "PEN"; // request.getParameter("currency");
		String lang = "es"; // request.getParameter("lang");
		String mtid = "";

		String bono = request.getParameter("activ-bono");
		String wbbono = request.getParameter("activ-wbbono");
		String bonokey = "";//((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":"");
		
		HttpSession session = request.getSession();
        
        /*String bonoBienvenida = ClientUtils.verifiedWelcomeBonus(session);

        if (StringUtils.isNotEmpty(bonoBienvenida)) {
        	bonokey = bonoBienvenida;
        } else {
        	bonokey = ((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":"");
        }*/
		bonokey = ((wbbono!=null&&wbbono.trim().equals("true"))?"BBIENVENIDA":((bono!=null&&bono.trim().equals("true"))?"TARECARGATE":((bono!=null&&bono.trim().contains("true-casino"))?bono.split("\\|")[1]:"")));
		
		Logger.getLogger(LoggerAPI.SALECARD).info("/paysafecard-createDisposition: activ-bono="+bono+" activ-wbbono="+wbbono+" bonokey="+bonokey);

		Integer clientId = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid();
		String allParams = ""; 
		
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" START ====== createDisposition-extends-HttpServlet");

		Log log = new Log();
		//Declare a private variable which will later contain the client
		SOPGClassicMerchantClient client;
		
		// A boolean (true or false) is set depending on the value of the field in this and the next parameter.  
		/* if(request.getParameter("autokorrektur") != null && request.getParameter("autokorrektur").equals("on")){
			autokorrektur = true;
		}else{
			autokorrektur = false;
		} 
		boolean debug;
		if(request.getParameter("debug") != null && request.getParameter("debug").equals("on")){
			debug = true;
		} else {
			debug = false;
		} */
		boolean autokorrektur = true;
		boolean debug = false;
		if ( ConnectionFactory.operationProperty("applicationArea", "CARD-WEB").equals("development") ) {
			debug = true;
		}
    	Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" amount="+amount+" currency="+currency+" clientId="+clientId+" shopLabel="+shopLabel+" lang="+lang);

		// Initialize SOPG client
		String paysafecardURLstatus=ConnectionFactory.operationProperty("paysafecardURLstatus", "sale");
		String paysafecardSOPGuser=ConnectionFactory.operationProperty("paysafecardSOPGuser", "sale");
		String paysafecardSOPGpassword=ConnectionFactory.operationProperty("paysafecardSOPGpassword", "sale");

		String clientIp = request.getHeader("X-Forwarded-For");
		if (clientIp==null || clientIp.equals("") || clientIp.equals("NULL")) {
			clientIp = request.getRemoteAddr();
		}
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" paysafecardURLstatus="+paysafecardURLstatus+" paysafecardSOPGuser="+paysafecardSOPGuser);
		
		// Set the URl's
		String baseurl;
		if(request.getServerPort() == 80){
			baseurl = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
		}else{
			baseurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		}

		try {
			if (clientId==null) {
				throw new Exception("No se esta conectado. Ingrese primero a la zonasegura");
			}
			allParams = "?amount="+amount+"&currency=" + currency + "&debug=" + debug + "&lang=" + lang + "&mtid=[mtid]&autokorrektur=" + autokorrektur + "&cid=" + clientId;
			String [] out = AccountController.defineTransactionPaysafe(String.valueOf(clientId), Double.parseDouble(amount), clientIp, shopLabel, currency, paysafecardURLstatus, paysafecardSOPGuser, allParams, bonokey);
			
			if (out==null || out.length!=2 || out[0]==null || out[1]==null || !out[1].equals("OK|OK")) {
				session.setAttribute("info_log", out[1].split("\\|")[0]);
				response.sendRedirect(baseurl + "/transError" + allParams);
				return;
			}
			mtid = out[0];

			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid);

			client = new SOPGClassicMerchantClient(mtid, String.valueOf(clientId), paysafecardURLstatus, debug, lang, autokorrektur, log);
			// Set Merchant access data
			client.merchant(paysafecardSOPGuser, paysafecardSOPGpassword, log);
			// Pass values from form to the client
			client.setCustomer(amount, currency, mtid, String.valueOf(clientId), log);
			client.setShopLabel(shopLabel, log);
			// client.setMinAge("18", log); // solo colocar en produccion
			amount = client.getAmount();
			
			client.setClientIp(clientIp, log);
			client.setMtid(mtid, log);
			
			allParams = "?amount="+amount+"&currency=" + currency + "&debug=" + debug + "&lang=" + lang + "&mtid="+mtid+"&autokorrektur=" + autokorrektur + "&cid=" + clientId;
			
			session.setAttribute("param_debug", debug);
			session.setAttribute("params_autokorrektur", autokorrektur);
			session.setAttribute("param_lang", lang);
			
			client.setUrl(URLEncoder.encode(baseurl + "/transSuccess" + allParams, "UTF8"), 
				          URLEncoder.encode(baseurl + "/transError" + allParams, "UTF8"), 
				          URLEncoder.encode(baseurl + "/transPN" + allParams, "UTF8"), log);
			
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" pnURL="+baseurl + "/transPN" + allParams);
			 
			/* "lotocard.transactionpaysafecardpro.defineTransaction(?,?,?,?,?, ?,?,?,?,?,?)";  */
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" defineTransaction "+mtid+"#\n"+clientId+"#\n"+amount+"#\n"+clientIp+"#\n"+ shopLabel+"#\n"+currency+"#\n"+paysafecardURLstatus+"#\n"+paysafecardSOPGuser+"#\n"+allParams);
			

			//Get URL to confirm payment transaction and save to variable confirmURL
 
			String confirmURL = client.createDisposition(String.valueOf(clientId), log);

			//System.out.println("client.getCustomerPanel()="+client.getCustomerPanel());
			
			// Save log entries and debug in the session
			session.setAttribute("debug", Debug.getDebug());
			//Clear debug
			Debug.clear();
			session.setAttribute("error_log", log.getLog("error"));
			session.setAttribute("info_log", log.getInfoLog());
			
			//Check whether the confirmation URL is not empty, if so: redirect
			if(confirmURL != "false"){
				response.sendRedirect(confirmURL);
			}else{
				response.sendRedirect(baseurl + "/transError" + allParams);
			}
		} catch (Exception e) {
			// Do nothing
			session.setAttribute("info_log", "No se ha creado transaccion paysafecard");
			response.sendRedirect(baseurl + "/transError" + allParams);
			try {
				e.printStackTrace(System.out); 
				ArrayList<HashMap<String, String>> error_log = (ArrayList<HashMap<String, String>>) session.getAttribute("error_log");
				StringBuffer buf = new StringBuffer(); 
				if (error_log!=null) {
					for(int i=0; i<error_log.size(); i++){
						buf.append( error_log.get(i).get("msg") );
					}
				}
				LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, "No se ha creado transaccion PAYSAFECARD", buf.toString() );
			} catch (Exception ee) {;}
		} finally {

		    ClientSaleBo clientSaleBo =  new ClientSaleBoImpl();
			try { ClientUtils.updateClientBalance(session, clientSaleBo);} catch (Exception e) {}
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" END ====== createDisposition-extends-HttpServlet");
		}
	}

}
