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
// @WebServlet("/transSuccess")
public class transSuccess extends HttpServlet { 
 
	private static final long serialVersionUID = -6559393337711500907L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Auslesen der Variablen
		String amount = request.getParameter("amount");
		boolean debug = Boolean.getBoolean(request.getParameter("debug"));
		String lang = "es";
		String currency = request.getParameter("currency");
		String mtid = request.getParameter("mtid");
		Integer clientId = Integer.parseInt(request.getParameter("cid"));
		boolean autokorrektur = true;
		HttpSession session = request.getSession();

		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" START ====== transSuccess-extends-HttpServlet");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			String[] ver = AccountController.getTransactionPaysafe(mtid, String.valueOf(clientId)).split("\\|");
			if (!ver[0].equals("OK")) {
				out.println( transSuccess.getHtml("TS1 Transaccion incorrecta", ver[0]) );
				return;
			} else {
				amount = ver[1];
			}
		} catch (Exception e) {
			LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, null, "" );
			out.println( transSuccess.getHtml("TS No se ha verificado la transaccion", "Transaccion sin verificar") );
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" END ====== transSuccess-extends-HttpServlet");
			return;
		}
		
		Log log = new Log();
		SOPGClassicMerchantClient client;
		
		// Initlaisieren des Clients
		String paysafecardURLstatus=ConnectionFactory.operationProperty("paysafecardURLstatus", "sale");
		client = new SOPGClassicMerchantClient(mtid, String.valueOf(clientId), paysafecardURLstatus, debug, lang, autokorrektur, log);
		// Setzen der Merchant-Zugangsdaten
		String paysafecardSOPGuser=ConnectionFactory.operationProperty("paysafecardSOPGuser", "sale");
		String paysafecardSOPGpassword=ConnectionFactory.operationProperty("paysafecardSOPGpassword", "sale");
		client.merchant(paysafecardSOPGuser, paysafecardSOPGpassword, log);
		// getserialNumbers ausf�hren und den Status in einer Variable speichern 
		String message="";
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
			// Wenn Status execute: executeDebit ausfhren
			if(status.equals("execute")) {
				// Speichern des R�ckgabewertes von executeDebit in der retVal-Variable
				String retVal = client.executeDebit(amount, "1", clientId, log, session);				 
				if (retVal.equals("true")) {
					message = "Se ha realizado la carga de "+amount+" soles";
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId  + " mtid="+mtid+" Wenn executeDebit true zur-ckgab, dann kann die Transaktion als erfolgreich angesehen werden");
				} else {
					String emtid = mtid;
					try {
						String [] id = mtid.split("_");
						emtid = id[0];
					} catch (Exception e) {}					
					message = "No se ha realizado la carga de "+amount+" soles ("+clientId+" / "+emtid+")";
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId  + " mtid="+mtid+"  Andernfalls nicht");
				}
			}
		} catch (Exception e) { 
			e.printStackTrace(System.out);
			try {
				ArrayList<HashMap<String, String>> error_log = (ArrayList<HashMap<String, String>>) session.getAttribute("error_log");
				StringBuffer buf = new StringBuffer();
				//Output the msg variable of each entry in the error log
				if (error_log!=null) {
					for(int i=0; i<error_log.size(); i++){
						buf.append( error_log.get(i).get("msg") );
					}
				} 
				LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, message, buf.toString() );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" END ====== transSuccess-extends-HttpServlet");
		}
		//Ausgabe des Logs (Typ: Info) 
		out.println( getHtml(log.getInfoLog(), message) );
	}
	
	public static String getHtml(String title, String message) {
		return 
		"<!DOCTYPE html>"+
		"<html lang='es'>"+
		"<head>"+
		"<meta charset='utf-8'>"+
		"<link media='screen' rel='stylesheet' type='text/css' href='layer-view-style/common/normalize.css'>"+
		"<link media='screen' rel='stylesheet' type='text/css' href='layer-view-style/common/selfControl.css'>"+
		"<link media='screen' rel='stylesheet' type='text/css' href='layer-view-style/common/style.css'>"+
		"<title>paysafecard</title>"+
		"</head>"+
		"<body>"+ 
		"<div id='main-content-background'>"+
	    "<div style='width: 370px; margin: 0px 0px 0px 25px;'>"+
	    "    <article id='self-control'>"+
	    "        <h3 class='tab-title'>"+
	    "            <span class='' >"+title+"</span>"+
	    "        </h3>"+
	    "        <div class='content'>"+
	    "            <!-- p class='sub-title'><span class='prominent'>"+title+"</span></p -->"+
	    "            <p class='information'>"+message+"</p>"+
	    "        </div>"+
	    "    </article>"+
	    "</div>"+
	    "</div>"+
	    // "<script type='text/javascript'>;var _gaq=_gaq||[];_gaq.push(['_setAccount','UA-16525433-4']);_gaq.push(['_setDomainName','intralot.com.pe']);_gaq.push(['_trackPageview']);(function(){var ga=document.createElement('script');ga.type='text/javascript';ga.async=true;ga.src=('https:'==document.location.protocol?'https://ssl':'http://www')+'.google-analytics.com/ga.js';var s=document.getElementsByTagName('script')[0];s.parentNode.insertBefore(ga,s)})();</script>"+
	    "</body>"+
	    "</html>";
	}
}
