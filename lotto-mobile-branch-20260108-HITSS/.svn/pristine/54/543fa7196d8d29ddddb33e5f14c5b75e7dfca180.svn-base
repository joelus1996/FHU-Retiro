package pe.com.intralot.loto.layer.view.client;

import java.io.PrintWriter;
import java.security.Security;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jettison.json.JSONObject;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.controller.client.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocuments;
import pe.com.intralot.loto.layer.model.pojo.TYCPDPProcedureConsultPendingDocumentsTemplate;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ApiGoldenUtils;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.SecurityUtils;
import pe.com.intralot.loto.lib.ConnectionFactory;

@Controller
public class TYCPDPController {
	
	@Autowired
	private SecurityUtils securityUtils;

    //@Autowired
    //private CulqiBo culqiBo;
    
    @Autowired
    private DeportesVirtualesBo deportesVirtualesBo;
    
    @Autowired
    ApiGoldenUtils  apiGoldenUtils = new ApiGoldenUtils(deportesVirtualesBo);
    
    @PostConstruct
    public void init() {
        Security.addProvider(new BouncyCastleProvider());
    }
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/get-pending-docs-for-aproval")
	public void consultPendingDocumentsForApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- STAR get-pending-docs-for-aproval"); 
		
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		JsonObject o = new JsonObject(); 
		JsonObject joDataPendingDocs = new JsonObject();
		TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocs = new TYCPDPProcedureConsultPendingDocumentsTemplate();
		try {
			
			if (session == null || session.getAttribute(Constantes.USR_SESION) == null) {
				o.addProperty("result", "KO");
				o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
				return;
			} 
			if (((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId().toString().equals("")) {
				o.addProperty("result", "KO");
				o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
				return;
			}
			Integer clientId = 0;
			clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId();
			dataPendingDocs = securityUtils.validatePendingDocumentsForApproval(clientId);
			// convertir de entidad a objeto 
			joDataPendingDocs = PendingDocsTemplateConvertJson(dataPendingDocs);
	
			session.setAttribute("tycPdpInitLogin", "0");
			if(!dataPendingDocs.getStatus().equals("OK")) {
				o.addProperty("result", "KO");
				o.addProperty("title",dataPendingDocs.getResp_title());
				o.addProperty("message",dataPendingDocs.getMessage());
				o.addProperty("button",dataPendingDocs.getResp_button());
				return;
			}
			
			o.add("dataPendingDocs", joDataPendingDocs);
			o.addProperty("result", "OK");
			
		} catch (Exception e) {
			o.addProperty("result", "KO");
			o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info("-------------- END get-pending-docs-for-aproval");
		}
	}
	
	private JsonObject PendingDocsTemplateConvertJson(TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocsRequest) {
		JsonObject joDataPendingDocs = new JsonObject();
	    Gson gson = new Gson();
		joDataPendingDocs.addProperty("state", (dataPendingDocsRequest.getState() !=null ) ? dataPendingDocsRequest.getState() : null);
		joDataPendingDocs.addProperty("status", (dataPendingDocsRequest.getStatus() !=null) ? dataPendingDocsRequest.getStatus() : null);
		joDataPendingDocs.addProperty("error", (dataPendingDocsRequest.getError() !=null) ? dataPendingDocsRequest.getError() : null);
		joDataPendingDocs.addProperty("message", (dataPendingDocsRequest.getMessage() !=null) ? dataPendingDocsRequest.getMessage() : null);
		joDataPendingDocs.addProperty("resp_title", (dataPendingDocsRequest.getResp_title() !=null) ? dataPendingDocsRequest.getResp_title() : null);
		joDataPendingDocs.addProperty("resp_message", (dataPendingDocsRequest.getResp_message() !=null) ? dataPendingDocsRequest.getResp_message() : null);
		joDataPendingDocs.addProperty("resp_button", (dataPendingDocsRequest.getResp_button() !=null) ? dataPendingDocsRequest.getResp_button() : null);

		ArrayList<TYCPDPProcedureConsultPendingDocuments> documentsList = dataPendingDocsRequest.getDocuments();
	    if (documentsList != null) {
	        JsonArray jsonDocuments = new JsonArray();
	        for (TYCPDPProcedureConsultPendingDocuments doc : documentsList) {
	            JsonElement jsonElement = gson.toJsonTree(doc);
	            jsonDocuments.add(jsonElement);
	        }
	        joDataPendingDocs.add("documents", jsonDocuments);
	    } else {
	        joDataPendingDocs.add("documents", new JsonArray()); // Si no hay documentos, poner un array vacío
	    }
		    
		LoggerApi.Log.info("joDataPendingDocs: "+ joDataPendingDocs.toString() );
		return joDataPendingDocs;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/save-accepted-documents")
	public void saveAcceptedDocuments(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoggerApi.Log.info("-------------- STAR save-accepted-documents"); 
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer clientId = 0;
		JsonObject o = new JsonObject(); 
		TYCPDPProcedureConsultPendingDocumentsTemplate dataPendingDocs = new TYCPDPProcedureConsultPendingDocumentsTemplate();
		
		try {
			
			if (session == null || session.getAttribute(Constantes.USR_SESION) == null) {
				o.addProperty("result", "KO");
				o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.");    
				return;
			} 
			if (((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId().toString().equals("")) {
				o.addProperty("result", "KO");
				o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
				return;
			}
			
			clientId = ((ClientProcedureGetLoginData) session.getAttribute(Constantes.USR_SESION)).getClientId();
    		JsonObject jdata = new JsonObject();
    		String tokenPlayerWebApi = ConnectionFactory.operationProperty("tokenPlayerWebApi", Constantes.contextPlayerWebApi);
    		jdata.addProperty("token", tokenPlayerWebApi);
    		jdata.addProperty("clientId", String.valueOf(clientId));
    		jdata.addProperty("platform", Constantes.PLATAFORM);
    		jdata.addProperty("operatorId", Constantes.OPERATOR_ID);
    		
    		// Obtener data de los documentos pendientes (API)
    		dataPendingDocs = securityUtils.validatePendingDocumentsForApproval(clientId);
    		ArrayList<TYCPDPProcedureConsultPendingDocuments> documentsList = dataPendingDocs.getDocuments();
    	    if (!documentsList.isEmpty()) {
    	        for (TYCPDPProcedureConsultPendingDocuments doc : documentsList) {
    	            if (doc.getDocType().equals("TYC")) {
    	            	jdata.addProperty("docTypeTYC", doc.getDocType());
    	    			jdata.addProperty("versionTYC", doc.getVersion());
    	            } else if (doc.getDocType().equals("PDP")) {
    	            	jdata.addProperty("docTypePDP", doc.getDocType());
    	    			jdata.addProperty("versionPDP", doc.getVersion());
    	            }
    	        }
    	        
    	        // Guardar los documentos pendientes de confirmación
    	        JSONObject convertedObject = new JSONObject(securityUtils.requestPlayerWebApi(jdata.toString(), "saveAcceptedDocuments"));
                
        		o.addProperty("result", "OK");
        		o.addProperty("status", convertedObject.getString("status").equals("OK")?convertedObject.getString("state"):"0");
            	o.addProperty("message", convertedObject.getString("message"));
            	
            	if(!convertedObject.getString("status").equals("OK")) {
            		o.addProperty("result", "KO");
                	o.addProperty("title",convertedObject.getString("resp_title"));
                	o.addProperty("message",convertedObject.getString("resp_message"));
                	o.addProperty("button",convertedObject.getString("resp_button"));
            		return;
            	}
    	        
    	    } else {
    	    	o.addProperty("result", "KO");
				o.addProperty("message", "No hay documentos pendientes de confirmación."); 
				return;
    	    }
			
		} catch (Exception e) {
			o.addProperty("result", "KO");
			o.addProperty("message", "Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde."); 
			LoggerApi.severe(e);
		} finally {
			out.print(o);
			LoggerApi.Log.info("-------------- END save-accepted-documents");
		}
	}
	
	@RequestMapping(value = "/tyc-pdp")
	public String payment_prizes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	session.removeAttribute("PIN_SESSION");
		return "client/interface-tycpdp_form";
	}
	
	@RequestMapping(value = "/off-redirect-login-compra-typpdp")
	public void offRedirectCaseLoginCompraTYCPDP(HttpServletRequest request, HttpServletResponse response, ModelMap objectModelMap) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("redirectCaseLoginCompraTYCPDP", "");
	}
}
