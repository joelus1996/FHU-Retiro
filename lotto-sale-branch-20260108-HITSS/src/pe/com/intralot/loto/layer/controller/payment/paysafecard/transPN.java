package pe.com.intralot.loto.layer.controller.payment.paysafecard;
import javax.servlet.ServletException;

import java.io.IOException;
 

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;

import com.paysafecard.merchant.*;

/**
 * Servlet implementation class transSuccess
 */
// @WebServlet("/transPN")
public class transPN extends HttpServlet {
 
	private static final long serialVersionUID = 5975637115794974175L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// currency = request.getParameter("currency");
		if (ConnectionFactory.operationProperty("applicationArea", "sale").equals("development")==true) {
			doPost(request, response);
		 }
	}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//run doGet to grad the GET-variable for currency and amount
		// doGet(request, response);
		String currency = request.getParameter("currency");
		String amount = request.getParameter("amount");
		// Get these variables from the session
		HttpSession session = request.getSession();
		boolean debug = Boolean.getBoolean(request.getParameter("debug"));
		String lang = "es"; // (String) session.getAttribute("param_lang");
		boolean autokorrektur = true; // (Boolean) session.getAttribute("param_autokorrektur");
		// Get the other variables
		String mtid = request.getParameter("mtid");
		Integer clientId = Integer.parseInt(request.getParameter("cid"));

		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " START ====== transPN-extends-HttpServlet");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			String[] ver = AccountController.getTransactionPaysafe(mtid, String.valueOf(clientId)).split("\\|");
			if (!ver[0].equals("OK")) {
				out.println( transSuccess.getHtml("TP Transaccion incorrecta", ver[0]) );
				return;
			} else {
				amount = ver[1];
			}
		} catch (Exception e) {
			LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, null, "" );
			out.println( transSuccess.getHtml("TP No se ha verificado la transaccion", "Transaccion sin verificar") );		
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " END ====== transPN-extends-HttpServlet");
			return;
		}
		
		Log log = new Log();
		SOPGClassicMerchantClient client;
	    // String currency;
	    // String amount;

		// Initialize client
		String paysafecardURLstatus=ConnectionFactory.operationProperty("paysafecardURLstatus", "sale");
		client = new SOPGClassicMerchantClient(mtid, String.valueOf(clientId), paysafecardURLstatus, debug, lang, autokorrektur, log);
		// Set Merchant access data
		String paysafecardSOPGuser=ConnectionFactory.operationProperty("paysafecardSOPGuser", "sale");
		String paysafecardSOPGpassword=ConnectionFactory.operationProperty("paysafecardSOPGpassword", "sale");
		client.merchant(paysafecardSOPGuser, paysafecardSOPGpassword, log);
		String message="";
		// Run getserialNumbers and save the status in a variablen
		try {
			// Set the URl's
			String baseurl;
			if(request.getServerPort() == 80){
				baseurl = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
			}else{
				baseurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			}
			String allParams = "?amount=" + amount + "&currency=" + currency + "&debug=" + debug + "&lang=" + lang + "&mtid=" + mtid + "&autokorrektur=" + autokorrektur + "&cid=" + clientId;
			client.setUrl(URLEncoder.encode(baseurl + "/transSuccess" + allParams, "UTF8"), 
				          URLEncoder.encode(baseurl + "/transError" + allParams, "UTF8"), 
				          URLEncoder.encode(baseurl + "/transPN" + allParams, "UTF8"), log);
				
			String status = client.getSerialNumbers(mtid, currency, "", clientId, log, session);
			// When status is execute: run executeDebit
			if(status.equals("execute")) {
				//Save the result of executeDebit in a variable to care about it later
				String retVal = client.executeDebit(amount, "1", clientId, log, session);
				if (retVal.equals("true")) {
					message = "Se ha realizado la carga de "+amount+" soles";
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " If executedebit returned true, the transaction has been successfull");
				} else {
					message = "No se ha realizado la carga de "+amount+" soles ("+clientId+"/"+mtid+")";
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " Otherwise not");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			try {
				ArrayList<HashMap<String, String>> error_log = (ArrayList<HashMap<String, String>>) session.getAttribute("error_log");
				StringBuffer buf = new StringBuffer();
				//Output the msg variable of each entry in the error log
				if (error_log!=null) {
					for(int i=0; i<error_log.size(); i++) {
						buf.append( error_log.get(i).get("msg") );
					}
				} 
				LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, message, buf.toString() );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " END ====== transPN-extends-HttpServlet");
		}
		out.println(log.getInfoLog()+" "+message);
	}
}
