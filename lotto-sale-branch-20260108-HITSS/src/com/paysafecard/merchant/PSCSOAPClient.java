package com.paysafecard.merchant;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection; 
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.NodeList; 

import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;

public class PSCSOAPClient { 
	
	private SOAPMessage soapMessage;
	private SOAPMessage soapResponse;
	
	public PSCSOAPClient() throws Exception{
		MessageFactory messageFactory = MessageFactory.newInstance();
		soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("urn", "urn:pscservice");
	}
	
	public String doCall(String url, Log log, String cid){
		String strMsg = "";
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			
			  // Send SOAP Message to SOAP Server 
// D:\java\jdk1.6.0_45\bin\keytool -importcert -file soatest.paysafecard.com -keystore identitytruststore.jks -storepass jkspass -alias paysafecard -keypass keypass
// D:\java\jdk1.6.0_45\bin\keytool -genkey -alias laptopIdentity -keystore laptopIdentity.jks
// /usr/java/jdk1.6.0_45/jre/setup/sale/keytool -genkey -alias jbossIdentity -keystore jbossIdentity.jks
/*
[root@jboss-desa1 sale]# keytool -genkey -alias jbossIdentity -keystore jbossIdentity.jks
Escriba la contrase�a del almacen de claves:
Volver a escribir la contrase�a nueva:
¿Cu�les son su nombre y su apellido?
  [Unknown]:  Angel Chata
¿Cu�l es el nombre de su unidad de organizaci�n?
  [Unknown]:  Sistemas
¿Cu�l es el nombre de su organizaci�n?
  [Unknown]:  INTRALOT DE PERU S.A.
¿Cual es el nombre de su ciudad o localidad?
  [Unknown]:  Lima
¿Cual es el nombre de su estado o provincia?
  [Unknown]:  Lima
¿Cual es el c�digo de pa�s de dos letras de la unidad?
  [Unknown]:  PE
¿Es correcto CN=Angel Chata, OU=Sistemas, O=INTRALOT DE PERU S.A., L=Lima, ST=Lima, C=PE?
  [no]:  si

Escriba la contraseña clave para <jbossIdentity>
        (INTRO si es la misma contraseña que la del almacen de claves):
Volver a escribir la contraseña nueva:
[root@jboss-desa1 sale]#

 */
			String paysafecardJbosskeyStoreJKSFile=ConnectionFactory.operationProperty("paysafecardJbosskeyStoreJKSFile", "sale");
			String paysafecardJbosskeyStorePassword=ConnectionFactory.operationProperty("paysafecardJbosskeyStorePassword", "sale");
			String paysafecardJbosskeyStoreType=ConnectionFactory.operationProperty("paysafecardJbosskeyStoreType", "sale");
			
			Logger.getLogger(LoggerAPI.SALECARD).info("paysafecardJbosskeyStoreJKSFile="+paysafecardJbosskeyStoreJKSFile+" paysafecardJbosskeyStorePassword="+paysafecardJbosskeyStorePassword+" paysafecardJbosskeyStoreType="+paysafecardJbosskeyStoreType);
			
			String paysafecardServertrustStoreJKSFile=ConnectionFactory.operationProperty("paysafecardServertrustStoreJKSFile", "sale");
			String paysafecardServertrustStorePassword=ConnectionFactory.operationProperty("paysafecardServertrustStorePassword", "sale");
			String paysafecardServertrustStoreType=ConnectionFactory.operationProperty("paysafecardServertrustStoreType", "sale");

			Logger.getLogger(LoggerAPI.SALECARD).info("paysafecardServertrustStoreJKSFile="+paysafecardServertrustStoreJKSFile+" paysafecardServertrustStorePassword="+paysafecardServertrustStorePassword+" paysafecardServertrustStoreType="+paysafecardServertrustStoreType);
			
			File jbosskeyStoreJKSFile = new File (paysafecardJbosskeyStoreJKSFile);
			if (jbosskeyStoreJKSFile.exists()) {
				Logger.getLogger(LoggerAPI.SALECARD).info("jbosskeyStoreJKSFile file exists :abs path = "+ jbosskeyStoreJKSFile.getAbsolutePath());
			}
			else {	
				Logger.getLogger(LoggerAPI.SALECARD).info("jbosskeyStoreJKSFile file does not exist :abs path = "+ jbosskeyStoreJKSFile.getAbsolutePath());
			}
			File servertrustStoreJKSFile = new File (paysafecardServertrustStoreJKSFile);
			if (servertrustStoreJKSFile.exists()) {
				Logger.getLogger(LoggerAPI.SALECARD).info("servertrustStoreJKSFile file exists :abs path = "+ servertrustStoreJKSFile.getAbsolutePath());
			}
			else {	
				Logger.getLogger(LoggerAPI.SALECARD).info("servertrustStoreJKSFile file does not exist :abs path = "+ servertrustStoreJKSFile.getAbsolutePath());
			}
			
			//System.setProperty("javax.net.debug","ssl");
			System.setProperty("javax.net.ssl.keyStoreType",paysafecardJbosskeyStoreType); // "JKS" 
			System.setProperty("javax.net.ssl.keyStore",paysafecardJbosskeyStoreJKSFile); // "D:/laptopIdentity.jks"); 
			System.setProperty("javax.net.ssl.keyStorePassword",paysafecardJbosskeyStorePassword); // "jkspass"); 
			System.setProperty("javax.net.ssl.trustStoreType",paysafecardServertrustStoreType); // "jks" 
			System.setProperty("javax.net.ssl.trustStore",paysafecardServertrustStoreJKSFile); // "D:/identitytruststore.jks");
			System.setProperty("javax.net.ssl.trustStorePassword",paysafecardServertrustStorePassword); // "jkspass");
					
			   URL https_url = new URL(url);
			   HttpsURLConnection con = (HttpsURLConnection) https_url.openConnection();
			   //Use below (2 lines) if Host name verification needs to turned off
			   MyHostnameVerifier hostVerifier = new MyHostnameVerifier();
			   con.setHostnameVerifier(hostVerifier);
			   HttpsURLConnection.setDefaultHostnameVerifier(hostVerifier); 
			   con.connect();  
			   SOAPMessage response = soapConnection.call(soapMessage,https_url); 
			   
			//SOAPMessage response = soapConnection.call(soapMessage, url);
			soapResponse = response;
			soapConnection.close();
			 
			ByteArrayOutputStream in = new ByteArrayOutputStream();
			soapMessage.writeTo(in);
			String strMsgIn = new String(in.toByteArray());

			Logger.getLogger(LoggerAPI.SALECARD).info("cid="+cid+" [IN] "+strMsgIn);
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.writeTo(out);
			strMsg = new String(out.toByteArray());

			Logger.getLogger(LoggerAPI.SALECARD).info("cid="+cid+" [OUT] "+strMsg);
			
		} catch(Exception e) {
			log.addLog("error_soap_call", "doCall", url, "_null_", "error");
			log.addLog("No se ha realizado el proceso [call] de la transaccion", "", "", "", "info");
			LoggerAPI.severe("PAYSAFE", LoggerAPI.SALECARD, e, "PAYSAFECARD doCall", "url="+url+" log="+log.getString() );
			strMsg = null;
		}
		return strMsg;
	}
	
	public void addElement(String name, HashMap<String, String> kvp, HashMap<String, ArrayList<HashMap<String, String>>> childElements) throws Exception{
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElement = soapBody.addChildElement(name, "urn");
		for(Map.Entry<String, String> entry : kvp.entrySet()){
			soapBodyElement.addChildElement(entry.getKey(), "urn").addTextNode(entry.getValue());
		}
		if(childElements.isEmpty() == false){
			for(Entry<String, ArrayList<HashMap<String, String>>> entry : childElements.entrySet()){
				for(int i=0; i<childElements.get(entry.getKey()).size(); i++){
					SOAPElement element = soapBodyElement.addChildElement(entry.getKey(), "urn");
					HashMap<String, String> elementMap = childElements.get(entry.getKey()).get(i);
					element.addChildElement("key", "urn").addTextNode(elementMap.get("key"));
					element.addChildElement("value", "urn").addTextNode(elementMap.get("value"));
				}
			}
		}
		soapMessage.saveChanges();
	}
	
	public String getElement(String name) throws Exception{
		NodeList nl = soapResponse.getSOAPBody().getElementsByTagName(name);
		return nl.item(0).getTextContent();
	}
}