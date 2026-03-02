package com.paysafecard.merchant;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import pe.com.intralot.loto.layer.controller.payment.paysafecard.transSuccess;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.www.sale.client.controller.AccountController;
/**
 * ControllerPaymentPaySafeCard
 * 
 * @package psc-sdk
 * @copyright 2013 Paysafecard.com Wertkarten AG
 * @version 1
 * @since 0.1
 * @access public
 */
public class SOPGClassicMerchantClient {

	private String sysLang;
	private HashMap<String, String> data = new HashMap<String, String>();
	private ArrayList<String> MinKycLevel = new ArrayList<String>();
	private boolean autoCorrect;
	private ArrayList<String> restrictedCountries = new ArrayList<String>();
	
	static {
		speaking();
	}
	
	public SOPGClassicMerchantClient(String mtid, String clientId, String status, boolean debugStatus, String sysLang, boolean autoCorrect, Log log){
		
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" start ---- SOPGClassicMerchantClient");

		log.addLogType("info");
		log.addLogType("error");
		log.addLogType("warning");
		if(Languages.doesLanguageExist(sysLang)){
			this.sysLang = sysLang;
		}else{
			this.sysLang = "en";
		}
		Debug.setDebugenabled(debugStatus);
		this.autoCorrect = autoCorrect;
		this.MinKycLevel.add("SIMPLE");
		this.MinKycLevel.add("FULL");
		reset();
		setStatus(status, log);

		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" end ---- SOPGClassicMerchantClient");

	}
	
	public void setUrl(String ok_url, String nok_url, String pn_url, Log log) throws Exception{
		if(this.autoCorrect == true){
			if(ok_url.contains(":") == true || ok_url.contains("/") == true){
				String tmp_ok_url = ok_url;
				ok_url = URLEncoder.encode(ok_url, "UTF8");
				log.addLog(Languages.getVariable(this.sysLang, "auto_correct_set_ok_url"), "setUrl_AutoCorrect", tmp_ok_url, ok_url, "warning");
			}
			if(nok_url.contains(":") == true || nok_url.contains("/") == true){
				String tmp_nok_url = nok_url;
				nok_url = URLEncoder.encode(nok_url, "UTF8");
				log.addLog(Languages.getVariable(this.sysLang, "auto_correct_set_nok_url"), "setUrl_AutoCorrect", tmp_nok_url, nok_url, "warning");
			}
			if(pn_url.contains(":") == true || pn_url.contains("/") == true){
				String tmp_pn_url = pn_url;
				pn_url = URLEncoder.encode(pn_url, "UTF8");
				log.addLog(Languages.getVariable(this.sysLang, "auto_correct_set_pn_url"), "setUrl_AutoCorrect", tmp_pn_url, pn_url, "warning");
			}
		}
		if(validate("ok_url", ok_url, log)){
			data.put("ok_url", ok_url);
			Debug.addDebug("setUrl_ok_url", data.get("ok_url"));
		}
		if(validate("nok_url", nok_url, log)){
			data.put("nok_url", nok_url);
			Debug.addDebug("setUrl_nok_url", data.get("nok_url"));
		}
		if(validate("pn_url", pn_url, log)){
			data.put("pn_url", pn_url);
			Debug.addDebug("setUrl_pn_url", data.get("pn_url"));
		}
	}
	
	private void setStatus(String status, Log log) {
 
		if(status.equals("test") || status.equals("") ){
			data.put("url", "https://soatest.paysafecard.com/psc/services/PscService?wsdl");
			data.put("redirect_url", "https://customer.test.at.paysafecard.com/psccustomer/GetCustomerPanelServlet");
			Debug.addDebug("setURL_url", data.get("url"));
			Debug.addDebug("setUrl_redirect_url", data.get("redirect_url"));
			if(status == ""){ log.addLog(Languages.getVariable(this.sysLang, "no_status"), "setStatus", "_null_", "_null_", "warning"); }
		}else if(status.equals("live")) {
			data.put("url", "https://soa.paysafecard.com/psc/services/PscService?wsdl");
			data.put("redirect_url", "https://customer.cc.at.paysafecard.com/psccustomer/GetCustomerPanelServlet");
			Debug.addDebug("setURL_url", data.get("url"));
			Debug.addDebug("setUrl_redirect_url", data.get("redirect_url"));			
		}else{
			log.addLog(Languages.getVariable(this.sysLang, "invalide_status"), "setStatus", "_null_", "_null_", "error");
		}
	}

	public boolean confirmMerchantData(String mtid, String currency, Log log) throws Exception{

		String merchantClientId = data.get("merchantClientId");
		setCurrency(currency, log);
		if(log.getLog("error").size() > 0){
			log.addLog(Languages.getVariable(this.sysLang, "error_confirm_merchant"), "confirmMerchantData", "Error-Log", String.valueOf(log.getLog("error").size()), "error");
			Debug.addDebug("confirmMerchantData", "Canceld");
			return false;
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("username", data.get("username"));
		params.put("password", data.get("password"));
		params.put("currency", data.get("currency"));
		PSCSOAPClient client = new PSCSOAPClient();
		client.addElement("getMid", params, new HashMap<String, ArrayList<HashMap<String, String>>>());
		String xml = client.doCall(data.get("url"), log, merchantClientId + " mtid="+mtid);
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + merchantClientId + " mtid="+mtid+" xml confirmMerchantData="+xml);
		if(client.getElement("ns1:resultCode") == "0" && client.getElement("ns1:errorCode") == "0"){ return true; }else{ return false; }
	}
	
	public void setCustomer(String amount, String currency, String mtid, String merchantClientId, Log log) {
		setAmount(number_format(amount), log);
		setMerchantClientId(merchantClientId, log);
		setCurrency(currency, log);
		setMtid(mtid, log);
	}
	
	public void setAmount(String amount, Log log){
		if(this.autoCorrect == true){
			String tmp_amount = amount;
			amount = number_format(amount);
			Debug.addDebug("AutoCorrect_Amount", tmp_amount + " -> " + amount);
			if(tmp_amount != amount){ log.addLog("auto_correct_amount_warning", "setAmount_AutoCorrect", tmp_amount, amount, "warning"); }
		}
		if(validate("amount", amount, log)){
			data.put("amount", amount);
			Debug.addDebug("setAmount", data.get("amount"));
		}
	}
	

	public String getAmount(){
		return data.get("amount");
	}
	
	public void merchant(String username, String password, Log log){
		if(validate("password", password, log)){
			data.put("password", password);
			Debug.addDebug("password", ">>hidden<<");
		}
		if(validate("username", username, log)){
			data.put("username", username);
			Debug.addDebug("username", ">>hidden<<");
		}
	}
	
	public void setMerchantClientId(String merchantClientId, Log log){
		if(validate("merchantClientId", merchantClientId, log)){
			data.put("merchantClientId", merchantClientId);
			Debug.addDebug("setMerchantClientId", merchantClientId);
		}
	}
	
	public void setCurrency(String currency, Log log){
		if(validate("currency", currency, log)){
			data.put("currency", currency);
			Debug.addDebug("setCurrency", currency);
		}
	}
	
	public void setShopId(String shopId, Log log){
		if(validate("shopId", shopId, log)){
			data.put("shopId", shopId);
			Debug.addDebug("setShopId", shopId);
		}
	}
	
	public void setShopLabel(String shopLabel, Log log){
		if(validate("shopLabel", shopLabel, log)){
			data.put("shopLabel", shopLabel);
			Debug.addDebug("setShopLabel", shopLabel);
		}
	}
	
	public void setMtid(String mtid, Log log){
		if(validate("mtid", mtid, log)){
			data.put("mtid", mtid);
			Debug.addDebug("setMtid", mtid);
		}
	}
	
	public void setMinAge(String minAge, Log log){
		if(validate("minAge", minAge, log)){
			data.put("dispositionRestrictionsMinAge", minAge);
			Debug.addDebug("setMinAge", minAge);
		}
	}

	public void setClientIp(String clientIp, Log log){
		if(validate("clientIp", clientIp, log)){
			data.put("clientIp", clientIp);
			Debug.addDebug("setClientIp", clientIp);
		}
	}
	
	public void setSubId(String subId, Log log){
		if(validate("subId", subId, log)){
			data.put("subId", subId);
			Debug.addDebug("setSubId", subId);
		}
	}
	
	public void setClose(String close, Log log){
		if(validate("close", close, log)){
			data.put("close", close);
			Debug.addDebug("setClose", close);
		}
	}
	
	public void setMinKycLevel(String level, Log log){
		if(validate("MinKycLevel", level, log)){
			data.put("dispositionRestrictionsMinKycLevel", level);
			Debug.addDebug("setMinKycLevel", level);
		}
	}
	
	public void setRestrictedCountry(String country, Log log){
		if(this.autoCorrect == true){
			String tmp_country = country;
			country = country.toUpperCase();
			Debug.addDebug("autoCorrect_RestrictedCountry", tmp_country + " -> " + country);
			if(tmp_country != country){ log.addLog(Languages.getVariable(this.sysLang, "auto_correct_res_country"), "setRestrictedCountry_AutoCorrect", tmp_country, country, "warning"); }
		}
		if(validate("restrictedCountry", country, log)){
			restrictedCountries.add(country);
			Debug.addDebug("setRestrictedCountry", country);
		}
	}
	
	private String number_format(String number){
		String tmp_number = number.replace(",", ".");
		if(tmp_number.contains(".")){
			String[] tokens = tmp_number.split("\\.");
			int lastTokenIndex = tokens.length-1;
			if(tokens[lastTokenIndex].length() == 2){
				return tmp_number;
			}else{
				if(tokens[lastTokenIndex].length() > 2){
					int difference = tokens[lastTokenIndex].length()-2;
					return tmp_number.substring(0, tmp_number.length()-difference);
				}else{
					int difference = 2-tokens[lastTokenIndex].length();
					for(int i=0; i<difference; i++){
						tmp_number = tmp_number + "0";
					}
					return tmp_number;
				}
			}
		}else{
			return tmp_number + ".00";
		}
	}

	public String getCustomerPanel(){
		String url;
		url = data.get("redirect_url");
		url += "?currency=" + data.get("currency");
		url += "&mtid=" + data.get("mtid");
		url += "&amount=" + data.get("amount");
		url += "&mid=" + data.get("mid");
		if(data.get("language").isEmpty() == false){
			url += "&language=" + data.get("language");
		}
		if(data.get("locale").isEmpty() == false){
			url += "&locale=" + data.get("locale");
		}
		Debug.addDebug("getCustomerPanel_generated_url", url);
		return url;
	}
	
	public String getSerialNumbers(String mtid, String currency, String subId, Integer clientId, Log log, HttpSession session) throws Exception {

		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" start ---- getSerialNumbers");
		
		String xmlSuccess = ""; 
		String resultCodeSuccess = "0";
		String errorCodeSuccess = "0";		
		String logString = "";
		String retVal = "";
		String dispositionState = ""; 
		String serialNumbers = "";
		
		try {
			setMtid(mtid, log);
			setCurrency(currency, log);
			setSubId(subId, log);
			if(log.getLog("error").size() > 0){
				log.addLog(Languages.getVariable(this.sysLang, "get_serial_num_is_error"), "getSerialNumbers", "Error-Log", String.valueOf(log.getLog("error").size()), "error");
				Debug.addDebug("getSerialNumbers", "Canceled");
				return "";
			}	
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("username", data.get("username"));
			params.put("password", data.get("password"));
			params.put("mtid", data.get("mtid"));
			params.put("subId", data.get("subId"));
			params.put("currency", data.get("currency"));
			PSCSOAPClient client = new PSCSOAPClient();
			client.addElement("getSerialNumbers", params, new HashMap<String, ArrayList<HashMap<String, String>>>());
			xmlSuccess = client.doCall(data.get("url"), log, clientId + " mtid="+mtid);
			HashMap<String, String> response = new HashMap<String, String>();
			response.put("mtid", client.getElement("ns1:mtid"));
			response.put("subId", client.getElement("ns1:subId"));
			response.put("resultCode", client.getElement("ns1:resultCode"));
			response.put("errorCode", client.getElement("ns1:errorCode"));
			response.put("amount", client.getElement("ns1:amount"));
			response.put("currency", client.getElement("ns1:currency"));
			response.put("dispositionState", client.getElement("ns1:dispositionState"));
			response.put("serialNumbers", client.getElement("ns1:serialNumbers"));
			serialNumbers = response.get("serialNumbers");

			if(response.get("resultCode").equals("0") && response.get("errorCode").equals("0")){
				Debug.addDebug("getSerialNumbers_errorCode", "0,0");
				data.put("dispositionState", response.get("dispositionState"));
				dispositionState = data.get("dispositionState");
				if(data.get("dispositionState").equals("S") || data.get("dispositionState").equals("E")){ 
					retVal = "execute";
					return retVal;
				}
				else if(data.get("dispositionState").equals("O")){
					log.addLog(Languages.getVariable(this.sysLang, "payment_done"), "", "", "", "info"); 
					retVal = "true";
					return retVal;
				}else{ 
					for(Map.Entry<String, String> entry : params.entrySet()){
						if(entry.getKey() == "username" || entry.getKey() == "password"){
							logString += entry.getKey() + ": >>hidden<<" + System.getProperty("line.separator");
						}else if(entry.getValue().isEmpty()){
							logString += entry.getKey() + ": >>empty<<" + System.getProperty("line.separator");
						}else{
							logString += entry.getKey() + ": " + entry.getValue() + System.getProperty("line.separator");
						}
					}
					if(data.get("dispositionState").equals("R")){
						log.addLog(Languages.getVariable(this.sysLang, "payment_invalide"), "", "", "", "info");
						log.addLog(Languages.getVariable(this.sysLang, "payment_invalide"), "getSerialNumbers", logString, "R", "error");
					}
					else if(data.get("dispositionState").equals("L")){
						log.addLog(Languages.getVariable(this.sysLang, "payment_cancelled"), "", "", "", "info");
						log.addLog(Languages.getVariable(this.sysLang, "payment_cancelled"), "getSerialNumbers", logString, "L", "error");
					}
					else if(data.get("dispositionState").equals("x")){
						log.addLog(Languages.getVariable(this.sysLang, "payment_expired"), "", "", "", "info");
						log.addLog(Languages.getVariable(this.sysLang, "payment_expired"), "getSerialNumbers", logString, "X", "error");
					}
					else{
						log.addLog(Languages.getVariable(this.sysLang, "msg_execute_debit").replace("[[url]]", data.get("ok_url")), "", "", "", "info");
						log.addLog(Languages.getVariable(this.sysLang, "payment_unknown_error"), "getSerialNumbers", logString, "ERROR", "error");
					}
					retVal = "false";
					return retVal;
				}
			}
			else{
				resultCodeSuccess = response.get("resultCode");
				errorCodeSuccess = response.get("errorCode"); 		 

				data.put("mid", "0");
				Debug.addDebug("getSerialNumbers", "ResultCode: " + resultCodeSuccess+ "ErrorCode: " + errorCodeSuccess);
				for(Map.Entry<String, String> entry : params.entrySet()){
					if(entry.getKey() == "username" || entry.getKey() == "password"){
						logString += entry.getKey() + ": >>hidden<<" + System.getProperty("line.separator");
					}else if(entry.getValue().isEmpty()){
						logString += entry.getKey() + ": >>empty<<" + System.getProperty("line.separator");
					}else{
						logString += entry.getKey() + ": " + entry.getValue() + System.getProperty("line.separator");
					}
				}
				log.addLog(Languages.getVariable(this.sysLang, "error_get_serial_num"), "getSerialNumbers", logString, "ResultCode: " + response.get("resultCode") + "ErrorCode: " + response.get("errorCode"), "error");
				log.addLog(Languages.getVariable(this.sysLang, "msg_execute_debit").replace("[[url]]", data.get("ok_url")), "", "", "", "info");
				Debug.addDebug("getSerialNumbers_params", logString);
				Debug.addDebug("getSrialNumbers_response", "ResultCode: " + response.get("resultCode") + "ErrorCode: " + response.get("errorCode"));
				retVal = "false";
				return retVal;
			}
		} finally {
			String debugString="";
			try {
				debugString = "cid=" + clientId + " mtid="+mtid+" successTransaction mtid="+mtid+"#\nclientId="+clientId+"#\nxmlSuccess="+xmlSuccess+
						"#\nresultCodeSuccess="+resultCodeSuccess+"#\nerrorCodeSuccess="+errorCodeSuccess+
						"#\nserialNumbers="+serialNumbers+"#\ndispositionState="+dispositionState+"#\nretVal="+retVal+"#\nlog?"+log.getString();
				String out = AccountController.successTransactionPaysafe(mtid, String.valueOf(clientId), xmlSuccess, resultCodeSuccess, errorCodeSuccess, 
						serialNumbers, dispositionState, retVal); 
				session.setAttribute("info_log", out);
				debugString +="#\nout="+out;
				Logger.getLogger(LoggerAPI.SALECARD).info(debugString);
			} catch (Exception e) {
				log.addLog("No se ha realizado el proceso [success] de la transaccion", "", "", "", "info");
				LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, "PAYSAFECARD successTransaction", "log="+log.getString()+" debugString="+debugString );
	        	throw e;
			}

			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" end ---- getSerialNumbers");
			
		}
	}
	
	public String createDisposition(String clientId, Log log) throws Exception {

		String merchantClientId = data.get("merchantClientId");
		String mtid = data.get("mtid");
		
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" start ---- createDisposition");
		
		String amount = data.get("amount");
		String currency = data.get("currency");
		String urlDisposition = data.get("url");
		String xmlDisposition = "";
		String customerPanel = "";
		String errorMessage = "";
		Integer errorCode=-1;
		Integer resultCode=-1;
		String logString = ""; 

		try {
			if(log.getLog("error").size() > 0){
				log.addLog(Languages.getVariable(this.sysLang, "create_disp_is_error"), "createDisposition", "Error-log", String.valueOf(log.getLog("error").size()), "error");
				Debug.addDebug("createDisposition", "Canceled");
				log.addLog(Languages.getVariable(this.sysLang, "msg_create_disposition"), "", "", "", "info");
			}
						
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("username", data.get("username"));
			params.put("password", data.get("password"));
			params.put("mtid", data.get("mtid"));
			params.put("subId", data.get("subId"));
			params.put("amount", data.get("amount"));
			params.put("currency", data.get("currency"));
			params.put("okUrl", data.get("ok_url"));
			params.put("nokUrl", data.get("nok_url"));
			params.put("merchantclientid", data.get("merchantClientId"));
			params.put("pnUrl", data.get("pn_url"));
			params.put("clientIp", data.get("clientIp"));
			HashMap<String, ArrayList<HashMap<String, String>>> childs = new HashMap<String, ArrayList<HashMap<String, String>>>();
			ArrayList<HashMap<String, String>> childsList = new ArrayList<HashMap<String, String>>();
			if(data.containsKey("dispositionRestrictionsMinAge") && data.get("dispositionRestrictionsMinAge").isEmpty() == false){ 
				HashMap<String, String> kvp = new HashMap<String, String>();
				kvp.put("key", "MIN_AGE");
				kvp.put("value", data.get("dispositionRestrictionsMinAge"));
				childsList.add(kvp);
			}
			if(data.containsKey("dispositionRestrictionsMinKycLevel") && data.get("dispositionRestrictionsMinKycLevel").isEmpty() == false){ 
				HashMap<String, String> kvp = new HashMap<String, String>();
				kvp.put("key", "MIN_KYC_LEVEL");
				kvp.put("value", data.get("dispositionRestrictionsMinKycLevel"));
				childsList.add(kvp);
			}
			if(restrictedCountries.size() > 0){
				for(int i=0; i<restrictedCountries.size(); i++){
					HashMap<String, String> kvp = new HashMap<String, String>();
					kvp.put("key", "COUNTRY");
					kvp.put("value", restrictedCountries.get(i));
					childsList.add(kvp);
				}
			}
			childs.put("dispositionRestrictions", childsList);
			params.put("shopId", data.get("shopId"));
			params.put("shopLabel", data.get("shopLabel"));
			PSCSOAPClient client = new PSCSOAPClient();
			client.addElement("createDisposition", params, childs); 
			
			xmlDisposition = client.doCall(urlDisposition, log, clientId + " mtid="+mtid);
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" xmlDisposition="+xmlDisposition);
			
			if (xmlDisposition!=null && !xmlDisposition.equals("") &&
					client.getElement("ns1:resultCode").equals("0") && client.getElement("ns1:errorCode").equals("0")){
				data.put("mid", client.getElement("ns1:mid"));
				Debug.addDebug("createDisposition_mid", client.getElement("ns1:mid"));
				customerPanel = getCustomerPanel();

				try { errorCode = Integer.parseInt(client.getElement("ns1:errorCode")); 
				} catch (Exception e) {errorCode=-9001;}

				try { resultCode = Integer.parseInt(client.getElement("ns1:resultCode")); 
				} catch (Exception e) {resultCode=-9001;}
				
				return customerPanel;
			} else {

				data.put("mid", "0");
				Debug.addDebug("createDisposition_mid", "0");
				for(Map.Entry<String, String> entry : params.entrySet()){
					if(entry.getKey() == "username" || entry.getKey() == "password"){
						logString += entry.getKey() + ": >>hidden<<" + System.getProperty("line.separator");
					} else if(entry.getValue().isEmpty()){
						logString += entry.getKey() + ": >>empty<<" + System.getProperty("line.separator");
					} else {
						logString += entry.getKey() + ": " + entry.getValue() + System.getProperty("line.separator");
					}
				}

				try { errorCode = Integer.parseInt(client.getElement("ns1:errorCode")); 
				} catch (Exception e) {errorCode=-8001;}

				try { resultCode = Integer.parseInt(client.getElement("ns1:resultCode")); 
				} catch (Exception e) {resultCode=-8001;}
				
				log.addLog(Languages.getVariable(this.sysLang, "error_create_disposition"), "createDisposition", logString, "ResultCode: " + resultCode + "- ErrorCode: " + errorCode, "error");
				Debug.addDebug("createDisposition_params", logString);
				Debug.addDebug("createDisposition", "ResultCode: " + resultCode + "- ErrorCode: " + errorCode);
				
				errorMessage = ErrorCode.getMessage(errorCode,
						merchantClientId, mtid, amount, currency)+
						". "+Languages.getVariable(this.sysLang, "msg_create_disposition"); 
				
				log.addLog(errorMessage, "", "", "", "info");
				
				customerPanel = "false";
				return "false";
			}
		}
		finally {
			String debugString="";
			try {
				debugString = "cid=" + merchantClientId + " mtid="+mtid+" postTransaction mtid="+mtid+"#\nmerchantClientId="+merchantClientId+"#\nurlDisposition="+urlDisposition+"#\nxmlDisposition="+xmlDisposition+"#\ncustomerPanel="+customerPanel+"#\nresultCode="+resultCode+"#\nerrorCode="+errorCode+"#\nerrorMessage="+errorMessage+"#\nlog="+log.getString();
				String out = AccountController.postTransactionPaysafe(mtid, merchantClientId, urlDisposition, xmlDisposition, customerPanel, 
						String.valueOf(resultCode), String.valueOf(errorCode), errorMessage);
				debugString +="#\nout="+out;
				Logger.getLogger(LoggerAPI.SALECARD).info(debugString);
			} catch (Exception e) {
				log.addLog("No se ha realizado el proceso [post] de la transaccion", "", "", "", "info");
				LoggerAPI.severe("PAYSAFE", LoggerAPI.SALECARD, e, "PAYSAFECARD postTransaction", "log="+log.getString()+" debugString="+debugString );
	        	throw e;
			} 

			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" end ---- createDisposition");
		}
	}
	
	public String executeDebit(String amount, String close, Integer clientId, Log log, HttpSession session) throws Exception {

		String merchantClientId = data.get("merchantClientId");
		String mtid = data.get("mtid");  
		
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" start ---- executeDebit");
		
		String xmlExecute = "";
		String resultCodeExecute = "0";
		String errorCodeExecute = "0";	
		String logString = "";
		String returnExecute = "false";
		boolean hasPreviousPaid = false;		

		// VERIFICAR SI OTRO PROCESO YA CARGO AL SALDO
		try {
			String[] ver = AccountController.getTransactionPaysafe(mtid, String.valueOf(clientId)).split("\\|");
			if (ver[0].equals("OK")) {
				String balanceItem = ver[2];
				if (balanceItem !=null && !balanceItem.equals("null") && Integer.parseInt(balanceItem)>=1) {
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" balanceItem="+balanceItem);
					log.addLog(Languages.getVariable(this.sysLang, "payment_done"), "", "", "", "info");
					returnExecute = "true";
					hasPreviousPaid = true;
					Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" end ---- executeDebit");
					return returnExecute;
				}
			}
		} catch (Exception e) { e.printStackTrace(); }
		//
 
		try {
			setAmount(number_format(amount), log);
			setClose(close, log);
			if(log.getLog("error").size() > 0){
				log.addLog(Languages.getVariable(this.sysLang, "execute_debit_is_error"), "executeDebit", "Error-Log", String.valueOf(log.getLog("error").size()), "error");
				Debug.addDebug("executeDebit", "Canceled");
				log.addLog(Languages.getVariable(this.sysLang, "msg_execute_debit").replace("[[url]]", data.get("ok_url")), "", "", "", "info");
				return "false";
			}
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("username", data.get("username"));
			params.put("password", data.get("password"));
			params.put("mtid", data.get("mtid"));
			params.put("subId", data.get("subId"));
			params.put("amount", data.get("amount"));
			params.put("currency", data.get("currency"));
			params.put("close", data.get("close"));
			
			PSCSOAPClient client = new PSCSOAPClient();
			client.addElement("executeDebit", params, new HashMap<String, ArrayList<HashMap<String, String>>>());
			xmlExecute = client.doCall(data.get("url"), log, clientId + " mtid="+mtid);
			HashMap<String, String> response = new HashMap<String, String>();
			response.put("mtid", client.getElement("ns1:mtid"));
			response.put("subId", client.getElement("ns1:subId"));
			response.put("resultCode", client.getElement("ns1:resultCode"));
			response.put("errorCode", client.getElement("ns1:errorCode")); 

			resultCodeExecute = response.get("resultCode");
			errorCodeExecute = response.get("errorCode"); 	 

			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" data.get(close)="+data.get("close")+
					" resultCodeExecute="+resultCodeExecute+" errorCodeExecute="+errorCodeExecute); 
			
			if(response.get("resultCode").equals("0") && response.get("errorCode").equals("0")){
				log.addLog(Languages.getVariable(this.sysLang, "payment_done"), "", "", "", "info");
				returnExecute = "true";
				return returnExecute;
			}else{ 
				// VERIFICAR SI OTRO PROCESO YA CARGO AL SALDO
				try {
					String[] ver = AccountController.getTransactionPaysafe(mtid, String.valueOf(clientId)).split("\\|");
					if (ver[0].equals("OK")) {
						String balanceItem = ver[2];
						if (balanceItem !=null && !balanceItem.equals("null")  && Integer.parseInt(balanceItem)>=1) {
							log.addLog(Languages.getVariable(this.sysLang, "payment_done"), "", "", "", "info");
							returnExecute = "true";
							hasPreviousPaid = true;
							return returnExecute;
						}
					}
				} catch (Exception e) { e.printStackTrace(); }
				//
				for(Map.Entry<String, String> entry : params.entrySet()){
					if(entry.getKey() == "username" || entry.getKey() == "password"){
						logString += entry.getKey() + ": >>hidden<<" + System.getProperty("line.separator");
					}else if(entry.getValue().isEmpty()){
						logString += entry.getKey() + ": >>empty<<" + System.getProperty("line.separator");
					}else{
						logString += entry.getKey() + ": " + entry.getValue() + System.getProperty("line.separator");
					}
				}
				log.addLog(Languages.getVariable(this.sysLang, "execute_debit_error"), "executeDebit", logString, "ResultCode: " + response.get("resultCode") + "ErrorCode: " + response.get("errorCode"), "error");
				log.addLog(Languages.getVariable(this.sysLang, "msg_execute_debit").replace("[[url]]", data.get("ok_url")), "", "", "", "info");
				Debug.addDebug("executeDebit_params", logString);
				Debug.addDebug("executeDebit_response", "ResultCode: " + response.get("resultCode") + "ErrorCode: " + response.get("errorCode"));
				returnExecute = "false";
				return returnExecute;
			}
		} finally {
			String debugString="";
			if (hasPreviousPaid==false) {
				try {
					debugString = "cid=" + clientId + " mtid="+mtid+" executeTransaction mtid="+mtid+"#\nclientId="+clientId+"#\nxmlExecute="+xmlExecute+"#\nresultCodeExecute="+resultCodeExecute+"#\nerrorCodeExecute="+errorCodeExecute+
							"#\nreturnExecute="+returnExecute+"#\nlog="+log.getString();
					String out = AccountController.executeTransactionPaysafe(mtid, String.valueOf(clientId), xmlExecute, resultCodeExecute, errorCodeExecute, returnExecute );
					session.setAttribute("info_log", out);
					debugString +="#\nout="+out;
					Logger.getLogger(LoggerAPI.SALECARD).info(debugString);
				} catch (Exception e) {
					log.addLog("No se ha realizado el proceso [execute] de la transaccion", "", "", "", "info");
					LoggerAPI.severe("PAYSAFE",LoggerAPI.SALECARD, e, "PAYSAFECARD executeTransaction", "log="+log.getString()+" debugString="+debugString );
		        	throw e;
				}
			}
			Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" end ---- executeDebit");
		}
	}
	
	private boolean validate(String type, String value, Log log){
		if(type == "" && value.isEmpty()){
				log.addLog(Languages.getVariable(this.sysLang, "error_validatation"), "validate", "type & value", ">>empty<<", "error");
				return false;
		}
		if( type == "username"){
					if(value.isEmpty()){ log.addLog(Languages.getVariable(this.sysLang, "username_empty"), "validate_username", "_null_", "_null_", "error"); return false; }
					else if(value.length() <= 3){ log.addLog(Languages.getVariable(this.sysLang, "username_length"), "validate_username", ">>hidden<<", "_null_", "error"); return false; }
					return true;
		}
		else if(type == "password"){
					if(value.isEmpty()){ log.addLog(Languages.getVariable(this.sysLang, "password_empty"), "validate_password", ">>hidden<<", "_null_", "error"); return false; } 
					else if(value.length() <= 5){ log.addLog(Languages.getVariable(this.sysLang, "passwor_length"), "validate_password", ">>hidden<<", "_null_", "error"); return false; }
					return true;
		}
		else if(type == "amount"){
					if(value == "") { log.addLog(Languages.getVariable(this.sysLang, "wrong_amount"), "validate_amount", "_null_", "_null_", "error"); return false; }
					else if((value.contains(",") == true) || (value.contains(".") == false)) { log.addLog(Languages.getVariable(this.sysLang, "dot_amount"), "validate_amount", value, "_null_", "error"); return false; }
					else{
						String[] tokens = value.split("\\.");
						if(tokens.length == 0 || tokens[1].length() != 2){ log.addLog(Languages.getVariable(this.sysLang, "null_amount"), "validate_amount", value, "_null_", "error"); return false; }
					}
					return true;
		}
		else if(type == "merchantClientId"){
					if(value.matches("^.*") != true){ log.addLog(Languages.getVariable(this.sysLang, "invalid_client_id"), "validate_cliet_id", value, "_null_", "error"); return false; }
					return true;
		}
		else if(type == "currency"){
					if(value.length() != 3){ log.addLog(Languages.getVariable(this.sysLang, "wrong_currency"), "validate_currency", value, "_null_", "error"); return false; }
					else if(value.matches("^[A-Z]{3}$") != true){ log.addLog(Languages.getVariable(this.sysLang, "wrong_currency_case"), "validate_currency", value, "_null_", "error"); return false; }
					else { return true; }
		}
		else if(type == "shopId"){
					if(value.matches("^[A-Z0-9a-z-_]{1,60}$") != true){
						if(value.length() < 60){ log.addLog(Languages.getVariable(this.sysLang, "shopid_oversize"), "validate_shopId", value, "_null_", "error"); return false; }
						else if(value.length() < 20) { log.addLog(Languages.getVariable(this.sysLang, "shopid_undersize"), "validate_shopId", value, "_null_", "error"); return false; }
						else{ log.addLog(Languages.getVariable(this.sysLang, "shopid_invalid"), "validate_shopId", value, "_null_", "error"); return false; }
					}
					return true;
		}
		else if(type == "shopLabel"){
					if(value.matches("^[A-Z0-9a-z-_\\s]{1,60}$") != true){
						if(value.length() < 60){ log.addLog(Languages.getVariable(this.sysLang, "shoplabel_oversize"), "validate_shopLabel", value, "_null_", "error"); return false; }
						else if(value.length() < 20){ log.addLog(Languages.getVariable(this.sysLang, "shoplabel_udersize"), "validate_shopLabel", value, "_null_", "error"); return false; }
						else{ log.addLog(Languages.getVariable(this.sysLang, "shoplabel_invalid"), "validate_shopLabel", value, "_null_", "error"); return false; }
					}
					return true;
		}
		else if(type == "mtid"){
					if(value.matches("^.*") != true){
						if(value.length() > 60){ log.addLog(Languages.getVariable(this.sysLang, "mtid_oversize"), "validate_mtid", value, "_null_", "error"); return false; }
						else if(value.length() < 20){ log.addLog(Languages.getVariable(this.sysLang, "mtid_undersize"), "validate_mtid", value, "_null_", "error"); return false; }
						else{ log.addLog(Languages.getVariable(this.sysLang, "mtid_invalid"), "validate_mtid", value, "_null_", "error"); return false; }
					}
					return true;
		}
		else if(type == "subId"){
			return true;
		}
		else if(type == "close"){
					if(value != "1" && value != "0"){ log.addLog(Languages.getVariable(this.sysLang, "invalid_close"), "validate_close", value, "", "error"); return false; }
					return true;
		}
		else if(type == "nok_url"){
				String nok_url;
				try {
					nok_url = URLDecoder.decode(value, "UTF8");
					if(nok_url == null || nok_url.isEmpty() || nok_url.length() < 11){ log.addLog(Languages.getVariable(this.sysLang, "invalid_nok_url"), "validate_nokUrl", value, "_null_", "error"); return false; }
				} catch (UnsupportedEncodingException e) {}
				return true;
		}
		else if(type == "ok_url"){
					try {
						String ok_url = URLDecoder.decode(value, "UTF8");
						if(ok_url == null || ok_url.isEmpty() || ok_url.length() < 11){ log.addLog(Languages.getVariable(this.sysLang, "invalid_ok_url"), "validate_okUrl", value, "_null_", "error"); return false; }
					} catch (UnsupportedEncodingException e) {}
					return true;
		}
		else if(type == "pn_url"){
					try {
						String pn_url = URLDecoder.decode(value, "UTF8");
						if(pn_url == null || pn_url.isEmpty() || pn_url.length() < 11){ log.addLog(Languages.getVariable(this.sysLang, "invalid_pn_url"), "validate_pnUrl", value, "_null_", "error"); return false; }
					} catch (UnsupportedEncodingException e) {}
					return true;
		}
		else if(type == "minAge"){
					if(value.matches("^[0-9]{1,2}$") != true){ log.addLog(Languages.getVariable(this.sysLang, "min_age_invalid"), "validate_minAge", value, "_null_", "error"); return false; }
					return true;
		}
		else if(type == "MinKycLevel"){
					if(this.MinKycLevel.contains(value) != true){log.addLog(Languages.getVariable(this.sysLang, "min_kyc_level_invalide"), "validate_MinKycLevel", value, "_null_", "error"); return false;  }
					return true;
		}
		else if(type == "restrictedCountry"){
					if(value.length() != 2){ log.addLog(Languages.getVariable(this.sysLang, "restricted_country_invalide"), "validate_restrictedCountry", value, "_null_", "error"); return false; }
					if(value.matches("^[A-Z]{2}$") != true){ log.addLog(Languages.getVariable(this.sysLang, "restricted_country_case"), "validate_pnUrl", value, "_null_", "error"); return false; }
					return true;
		}
		else{
					if(type == ""){log.addLog(Languages.getVariable(this.sysLang, "error_validation_type"), "validation_default", "_null_", "_null_", "error"); return false;}
					else{ log.addLog(Languages.getVariable(this.sysLang, "error_validation"), "validation_default", "_null_", "_null_", "error"); return false; }
		}
	}
	
	private static void speaking() {
		Languages.addLanguage("de");
		Languages.addVariable("de", "username_empty", "Benutzername ist leer!");
		Languages.addVariable("de", "username_length", "Der Benutzername muss mehr als 3 Zeichen haben.");
		Languages.addVariable("de", "password_empty", "Das Passwort ist leer!");
		Languages.addVariable("de", "passwor_length", "Das Passwort muss mehr als 5 Zeichen haben.");
		Languages.addVariable("de", "invalid_client_id", "Die angegebene Merchant-Client-ID ist ungültig. Die Merchant-Client-ID muss zwischen 1 und 50 Zeichen lang sein. Erlaubte Zeichen: AZ, az, 0-9 sowie - (Bindestrich) und _ (Unterstrich).");
		Languages.addVariable("de", "no_auto_correct", "Es wurde keine Auto-Korrektur festgelegt.");
		Languages.addVariable("de", "no_sys_lang", "Es wurde keine Systemsprache festgelegt.");
		Languages.addVariable("de", "no_debug", "Es wurde kein Debug-Status angegeben.");
		Languages.addVariable("de", "shopid_oversize", "ShopId ist ungültig. Die ShopId darf nicht mehr als 60 Zeichen haben.");
		Languages.addVariable("de", "shopid_undersize", "ShopId ist ungültig. Die ShopId muss mehr als 20 Zeichen haben.");
		Languages.addVariable("de", "shopid_invalid", "Die Shop-ID ist ungültig. Erlaubte Zeichen A-Z, a-z, 0-9 und â€“ (Bindestrich) und _ (Unterstrich).");
		Languages.addVariable("de", "shoplabel_oversize", "Shoplabel ist ungültig. Shoplabel darf nicht mehr als 60 Zeichen haben.");
		Languages.addVariable("de", "shoplabel_undersize", "Shoplabel ist ungültig. Shoplabel muss mehr als 1 Zeichen haben.");
		Languages.addVariable("de", "shoplabel_invalid", "Shoplabel ist ungültig. Erlaubte Zeichen A-Z, a-z, 0-9 und â€“ (Bindestrich) und _ (Unterstrich).");
		Languages.addVariable("de", "mtid_oversize", "Mtid ist ungültig. Mtid darf nicht mehr als 60 Zeichen haben.");
		Languages.addVariable("de", "mtid_undersize", "Mtid ist ungültig. Mtid muss mehr als 20 Zeichen haben.");
		Languages.addVariable("de", "mtid_invalid", "Mtid ist ungültig. Erlaubte Zeichen A-Z, a-z, 0-9 und â€“ (Bindestrich) und _ (Unterstrich).");
		Languages.addVariable("de", "error_validation_value", "Fehler bei der Validierung. Es wurde kein Wert zur Validierung übergeben!");
		Languages.addVariable("de", "error_validation_type", "Fehler bei der Validierung. Es wurde kein gültiger Typ zur Validierung angegeben!");
		Languages.addVariable("de", "error_validation", "Fehler bei der Validierung.");
		Languages.addVariable("de", "min_age_invalide", "Ungültige Altersbeschränkung. Das Alter muss ein positiver Zahlenwert.");
		Languages.addVariable("de", "min_kyc_level_invalide", "Ungültige Einschränkung. Das Level muss SIMPLE, DOCUMENT oder POSTIDENT sein.");
		Languages.addVariable("de", "restricted_country_invalide", "Invalid restricted country. 2 characters required. The value accepts ISO 3166-1 country codes.");
		Languages.addVariable("de", "restricted_country_case", "Ungültige Ländereinschränkung. Es sind nur GroÃŸbuchstaben erlaubt. Der Wert akzeptiert ISO 3166-1 Ländercodes.");
		Languages.addVariable("de", "invalide_status", "Ungültiger Status. Der Status kann 'test' order 'live' sein.");
		Languages.addVariable("de", "no_status", "Es wurde keine Status angegeben.");
		Languages.addVariable("de", "create_disp_is_error", "createDisposition wurde abgebrochen. Bitte erst alle Fehler beseitigen.");
		Languages.addVariable("de", "execute_debit_is_error", "executeDebit wurde abgebrochen. Bitte erst alle Fehler beseitigen.");
		Languages.addVariable("de", "execute_debit_error", "executeDebit war nicht erfolgreich.");
		Languages.addVariable("de", "wrong_currency", "Ungültige Währung. Die Währung muss 3 Zeichen lange sein (ISO 4217).");
		Languages.addVariable("de", "wrong_currency_case", "Ungültige Währung. Die Währung darf nur in GroÃŸbuchstaben angegeben werden.");
		Languages.addVariable("de", "dot_amount", "Der Betrag muss mit einem Punkt getrennt werden.");
		Languages.addVariable("de", "invalid_nok_url", "Die angegebene nok-URL ist ungültig!");
		Languages.addVariable("de", "invalid_ok_url", "Die angegebene ok-URL ist ungültig!");
		Languages.addVariable("de", "invalid_pn_url", "Die angegebene pn-URL ist ungültig!");
		Languages.addVariable("de", "auto_correct_set_pn_url", "Die angegebene pn-URL wurde mit AutoCorrect berichtigt. Bitte Eingabe überarbeiten!");
		Languages.addVariable("de", "auto_correct_set_nok_url", "Die angegebene nok-URL wurde mit AutoCorrect berichtigt. Bitte Eingabe überarbeiten!");
		Languages.addVariable("de", "auto_correct_set_ok_url", "Die angegebene ok-URL wurde mit AutoCorrect berichtigt. Bitte Eingabe überarbeiten!");
		Languages.addVariable("de", "auto_correct_res_country", "Die Eingabe zu den Ländereinschränkungen wurden mit AutoCorrect berichtig. Bitte Eingabe überarbeiten!");
		Languages.addVariable("de", "auto_correct_amount_warning", "Der angegebene Betrag wurde mit AutoCorrect berichtigt. Der angegebene Betrag entspricht nicht der vorgeschriebenen Formatierung!");
		Languages.addVariable("de", "get_serial_num_is_error", "getSerialNumbers wurde abgebrochen. Bitte erst alle Fehler beseitigen.");
		Languages.addVariable("de", "error_get_serial_num", "getSerialNumbers konnte nicht erfolgreich ausgeführt werden!");
		Languages.addVariable("de", "error_create_disposition", "createDisposition konnte nicht erfolgreich ausgeführt werden!");
		Languages.addVariable("de", "wrong_amount", "Fehlerhafter Betrag");
		Languages.addVariable("de", "error_soap_call", "Bei den Versuch, sich mit der Schnittstelle zu verbinden, trat ein unbekannter Fehler auf.");
		/* CUSTOMER MESSAGES */
		Languages.addVariable("de", "msg_create_disposition", "Bei der Bezahlung ist ein Fehler aufgetreten. Vermutlich ist dies ein temporärer Fehler und die Bezahlung kann durch Neu-Laden der Seite abgeschlossen werden. Falls dieses Problem weiterhin besteht, kontaktieren Sie bitte unseren Support.");
		Languages.addVariable("de", "msg_execute_debit", "Die Zahlung konnte nicht abgeschlossen werden. Es besteht ein temporäres Verbindungsproblem. Bitte drücken Sie den 'reload' Botton im Browser oder den folgenden Link um die Zahlung abzuschlieÃŸen. <a href='[[url]]'>Neuladen</a> <br> Falls dieses Problem weiterhin besteht wenden Sie sich bitte an den Support Sie kÃ¶nnen auf der paysafecard Guthabenübersicht (https://customer.cc.at.paysafecard.com/psccustomer/GetWelcomePanelServlet?language=de) Erfahren wann der reservierte Betrag wieder freigegeben wird.");
		Languages.addVariable("de", "payment_invalide", "Der Bezahlvorgang wurde nicht ordnungsgemäÃŸ abgeschlossen");
		Languages.addVariable("de", "payment_cancelled", "Der Bezahlvorgang wurde auf Ihren Wunsch abgebrochen");
		Languages.addVariable("de", "payment_expired", "Das Zeitfenster ist abgelaufen. Bitte starten Sie den Bezahlvorgang erneut.");
		Languages.addVariable("de", "payment_unknown_error", "Unbekannter Fehler bei der Zahlung. Bitte starten Sie den Bezahlvorgang erneut. Sollte der Fehler weiter auftreten, wenden Sie sich bitte an unseren Support");
		Languages.addVariable("de", "payment_done", "Der Zahlvorgang wurde erfolgreich abgeschlossen.");
		Languages.addLanguage("en");
		Languages.addVariable("en", "username_empty", "Username is empty!");
		Languages.addVariable("en", "username_length", "The username must have more than 3 characters.");
		Languages.addVariable("en", "password_empty", "Password is empty!");
		Languages.addVariable("en", "passwor_length", "The password must have more than 5 characters.");
		Languages.addVariable("en", "invalid_client_id", "The specified Merchant-Client-ID is invalid. The Merchant-Client-ID must be between 1 and 20 characters. Only the following is allowed A-Z, a-z, 0-9 as well as â€“ (hypen) and _ (underline).");
		Languages.addVariable("en", "no_auto_correct", "No auto-correct specified.");
		Languages.addVariable("en", "no_sys_lang", "No system language specified.");
		Languages.addVariable("en", "no_debug", "No debug-status specified.");
		Languages.addVariable("en", "shopid_oversize", "ShopID is invalid. ShopID maximum length is 60 characters.");
		Languages.addVariable("en", "shopid_undersize", "ShopID is invalid. ShopID must have at least 20 characters.");
		Languages.addVariable("en", "shopid_invalid", "ShopID is invalid. Only the following is allowed A-Z, a-z, 0-9 as well as â€“ (hypen) and _ (underline).");
		Languages.addVariable("en", "shoplabel_oversize", "Shoplabel is invalid. Shoplabel maximum length is 60 characters.");
		Languages.addVariable("en", "shoplabel_undersize", "Shoplabel is invalid. Shoplabel must have at least 1 characters.");
		Languages.addVariable("en", "shoplabel_invalid", "Shoplabel is invalid. Only the following is allowed A-Z, a-z, 0-9 as well as â€“ (hypen), _ (underline) and spaces.");
		Languages.addVariable("en", "mtid_oversize", "Mtid is invalid. Mtid maximum length is 60 characters.");
		Languages.addVariable("en", "mtid_undersize", "Mtid is invalid. Mtid must have at least 1 characters.");
		Languages.addVariable("en", "mtid_invalid", "Mtid is invalid. Only the following is allowed A-Z, a-z, 0-9 as well as â€“ (hypen), _ (underline) and spaces.");
		Languages.addVariable("en", "error_validation_value", "Validation errors. There was no value is passed to the validation!");
		Languages.addVariable("en", "error_validation_type", "Validation errors. It was not specified a valid type for the validation!");
		Languages.addVariable("en", "error_validation", "Validation errors.");
		Languages.addVariable("en", "min_age_invalide", "Invalid restricted age. The age must be a positive numbervalue.");
		Languages.addVariable("en", "min_kyc_level_invalide", "Invalid restricted level. The level must be SIMPLE, DOCUMENT or POSTIDENT.");
		Languages.addVariable("en", "restricted_country_invalide", "Invalid restricted country. 2 characters required. The value accepts ISO 3166-1 country codes.");
		Languages.addVariable("en", "restricted_country_case", "Invalid restricted country. There are only capital letters allowed. The value accepts ISO 3166-1 country codes.");
		Languages.addVariable("en", "invalide_status", "Invalid module status. Status can only be 'live' or 'test'.");
		Languages.addVariable("en", "no_status", "It was not specified a status.");
		Languages.addVariable("en", "create_disp_is_error", "create disposition was aborted. Please remove all errors.");
		Languages.addVariable("en", "execute_debit_is_error", "executeDebit was aborted. Resolve all errors before proceeding.");
		Languages.addVariable("en", "execute_debit_error", "executeDebit was not successful.");
		Languages.addVariable("en", "wrong_currency", "Invalid currency. The currency must be 3 characters long (ISO 4217).");
		Languages.addVariable("en", "wrong_currency_case", "Invalid currency. The currency may only be specified in uppercase.");
		Languages.addVariable("en", "dot_amount", "The amount must be separated with a dot.");
		Languages.addVariable("en", "invalid_nok_url", "Specified nok-URL is invalid!");
		Languages.addVariable("en", "invalid_ok_url", "Specified ok-URL is invalid!");
		Languages.addVariable("en", "invalid_pn_url", "Specified pn-URL is invalid!");
		Languages.addVariable("en", "auto_correct_set_pn_url", "Specified pn-URL was corrected with AutoCorrect. Please revise entry!");
		Languages.addVariable("en", "auto_correct_set_nok_url", "Specified nok-URL was corrected with AutoCorrect. Please revise entry!");
		Languages.addVariable("en", "auto_correct_set_ok_url", "Specified ok-URL was corrected with AutoCorrect. Please revise entry!");
		Languages.addVariable("en", "auto_correct_res_country", "Country restrictions entry was corrected with AutoCorrect. Please revise entry!");
		Languages.addVariable("en", "auto_correct_amount_warning", "Specified amount was corrected with AutoCorrect. The specified entry does not have the required formatting!");
		Languages.addVariable("en", "get_serial_num_is_error", "getSerialNumbers was aborted. Resolve all errors before proceeding.");
		Languages.addVariable("en", "error_get_serial_num", "getSerialNumbers was not executed successfully!");
		Languages.addVariable("en", "error_create_disposition", "createDisposition was not executed successfully!");
		Languages.addVariable("en", "wrong_amount", "Incorrect amount");
		Languages.addVariable("en", "error_soap_call", "An unknown error occurred while trying to connect to the api.");
		/* CUSTOMER MESSAGES */
		Languages.addVariable("en", "msg_create_disposition", "Transaction could not be initiated due to connection problems. If the problem persists, please contact our support.");
		Languages.addVariable("en", "msg_execute_debit", "Payment could not be completed. There is a temporary connection problem. Please press the 'reload' button in your browser or click the following link to complete payment. <a href='[[url]]'>Reload</a> <br> If this issue persists, please contact Support On the paysafecard credit overview (https://customer.cc.at.paysafecard.com/psccustomer/GetWelcomePanelServlet?language=de) find out when the reserved amount is released again.");
		Languages.addVariable("en", "payment_invalide", "Failed to complete the payment transaction properly");
		Languages.addVariable("en", "payment_cancelled", "Payment transaction was aborted at your request");
		Languages.addVariable("en", "payment_expired", "Timeout. Please restart the payment transaction.");
		Languages.addVariable("en", "payment_unknown_error", "Unknown error during payment. Please restart the payment transaction. If this issue persists, please contact Support");
		Languages.addVariable("en", "payment_done", "Payment transaction was completed successfully.");
		/* CUSTOMER MESSAGES */
		Languages.addLanguage("es"); 
		Languages.addVariable("es", "msg_create_disposition", "La transacción no puede iniciarse debido a problemas de conexión. Si el problema persiste, póngase en contacto con nuestro soporte.");
		Languages.addVariable("es", "msg_execute_debit", "No se pudo completar el pago. Hay un problema de conexión temporal. Por favor haga clic en el enlace siguiente para completar el pago. <a href='[[url]]'>Recargar</a><br> Si este problema persiste, póngase en contacto con el <a target='_blank' href='https://customer.cc.at.paysafecard.com/psccustomer/GetWelcomePanelServlet?language=es'>Soporte de paysafecard</a> para averiguar cuando la cantidad reservada se ha liberado de nuevo.");
		Languages.addVariable("es", "payment_invalide", "No se pudo completar la operación de pago correctamente.");
		Languages.addVariable("es", "payment_cancelled", "La operación de pago se terminó a su solicitud");
		Languages.addVariable("es", "payment_expired", "El tiempo ha expirado. Por favor, reinicie la operación de pago.");
		Languages.addVariable("es", "payment_unknown_error", "Error desconocido durante el pago. Por favor, reinicie la operación de pago. Si este problema persiste, póngase en contacto con el Soporte.");
		Languages.addVariable("es", "payment_done", "La operación de pago que ha completado con éxito.");

	}

	private void reset(){
		ArrayList<String> fields =  new ArrayList<String>();
		fields.add("username");
		fields.add("password");
		fields.add("mtid");
		fields.add("clientIp");
		fields.add("subId");
		fields.add("merchantClientId");
		fields.add("amount");
		fields.add("currency");
		fields.add("language");
		fields.add("locale");
		fields.add("close");
		fields.add("mid");
		fields.add("shopLabel");
		fields.add("shopId");
		fields.add("ok_url");
		fields.add("nok_url");
		fields.add("pn_url");
		fields.add("dispositionRestrictionsMinAge");
		fields.add("dispositionRestrictionsMinKycLevel");
		fields.add("dispositionState");
		for(int i = 0; i < fields.size(); i++){
			data.put(fields.get(i), "");
		}
		if(autoCorrect){
			autoSet();
		}
	}
	
	private void autoSet(){
		data.put("currency", "EUR");
		Debug.addDebug("Autoset_currency", data.get("currency"));
	}
}
