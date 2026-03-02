package pe.com.intralot.loto.layer.view.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientBalanceBo;
import pe.com.intralot.loto.layer.controller.client.bo.ClientLotocardBo;
import pe.com.intralot.loto.layer.controller.security.bo.SecurityLoginBo;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.view.client.ClientBalanceController;
import pe.com.intralot.loto.layer.view.payment.TupayPage.TupayDepositsRequest.Payer;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;
import pe.com.intralot.loto.utils.IntralotUtils;
import pe.com.intralot.loto.utils.SecurityUtils;
import sun.misc.BASE64Encoder;

@Controller
public class TupayPage {
	
	@Autowired
    private SecurityLoginBo beanSecurityLoginBo;
	@Autowired
	private ClientBalanceBo beanClientBalanceBo;
	@Autowired
	private ClientLotocardBo beanClientLotocardBo;
	@Autowired
	ClientAccountBo beanClientAccountBo;
	@Autowired
	IntralotUtils intralotUtils;
        
    Gson gson = new Gson();

    @RequestMapping({ "/tupay_api" })
    protected void portal_page_api(final HttpServletRequest request, final HttpServletResponse response, final ModelMap objectModelMap) throws ServletException, IOException {
    	String log="tupay_api";
    	LoggerApi.Log.info("-------------- START " +log);
    	PrintWriter out = null;
    	response.setCharacterEncoding(Constantes.CHARSET_UTF8);
        out = response.getWriter();
	    String bono = "", wbbono = "", bonokey = "";
        Integer clientId = 0;
        String rechargetoken=request.getHeader("rechargetoken");
        String ip=SecurityUtils.getClientIp(request);
        try {
        	//Validar token
    		ClientProcedureTokenValidation tokenValidation= new ClientProcedureTokenValidation();
    		tokenValidation = beanSecurityLoginBo.getTokenValidation(rechargetoken, ip);
            if (tokenValidation.getStatus().equals("OK") && tokenValidation.getMessage().equals("Validated")) {
                clientId = Integer.parseInt(tokenValidation.getClientId());
                String channelP = request.getParameter("channel");
                String channel = "";
        	    double maxAmount = 0, minAmount = 0;
        	    Integer amount = 0;
        	    String tamount = "";
        	    String msg = "";
        	    
        	    ClientProcedureAccountDataPart accountDataPart = beanClientBalanceBo.findAccountDataPart(clientId);        		
				if(channelP!=null) {
					if(channelP.trim().equals("YAPE_TP")) {
						channel="YAPE";
						minAmount=accountDataPart.getAmtMinRechargeYapeTupay();
						maxAmount=accountDataPart.getAmtMaxRechargeYapeTupay();
					}else if(channelP.trim().equals("PLIN_TP")) {
						channel="PLIN";
						minAmount=accountDataPart.getAmtMinRechargePlinTupay();
						maxAmount=accountDataPart.getAmtMaxRechargePlinTupay();
					}
				}
				
				if(request.getParameter("posAmount") != null && !request.getParameter("posAmount").equals("")) {
	            	tamount = request.getParameter("posAmount").trim();
	                amount = Integer.parseInt(tamount);
	            }
                
				if(amount >= minAmount) {
					if(amount > maxAmount) {
						msg = "Debes ingresar un monto de carga no mayor de "+intralotUtils.formatCurrency2(maxAmount);
						out.print(" | "+msg);
					}else {
						Client client = beanClientAccountBo.findClientById(clientId);
						String firstname = client.getName();//dataClient.getNombre();
		                String lastname = client.getLastname() + " " + (client.getMaidenname()!=null?client.getMaidenname():"");//dataClient.getApPaterno() + " " + dataClient.getApMaterno();

		                String typeidNum = "";		                
		                if ( client.getDocType()!=null ) {
			                if (client.getDocType().equals("DNI"))
			                    typeidNum = "DNI";
			                else if (client.getDocType().equals("CAREX"))
			                    typeidNum = "CE";
			                else if (client.getDocType().equals("PASAP"))
			                    typeidNum = "PASS";
		                }
		                String numberid = client.getDocNumber();
		                String email = client.getMail();
		                
		                //Obtener codigo promocional
			            String codePromotional = (request.getParameter("codePromotional")!=null)?request.getParameter("codePromotional").toString().trim():"";    			            

			            Logger.getLogger(LoggerAPI.SALECARD).info("/tupay_api: codePromotional="+codePromotional);
		                
		                String notificationUrl=ConnectionFactory.operationProperty("notificationUrl", "tupay").trim();
		                String successUrl=ConnectionFactory.operationProperty("successUrl", "tupay").trim();
		                
		                TupayDepositsRequest tupayDepositsRequest = new TupayDepositsRequest();
		                tupayDepositsRequest.setCountry("PE");
		                tupayDepositsRequest.setCurrency("PEN");
		                tupayDepositsRequest.setAmount(amount);
		                tupayDepositsRequest.setPayment_method("XAQR");
		                tupayDepositsRequest.setMobile(true);
		                Payer payer = tupayDepositsRequest.new Payer();
		                payer.setDocument(numberid);
		                payer.setDocument_type(typeidNum);
		                payer.setEmail(email);
		                payer.setFirst_name(firstname);
		                payer.setLast_name(lastname);
		                tupayDepositsRequest.setPayer(payer);
		                tupayDepositsRequest.setNotification_url(notificationUrl);
		                tupayDepositsRequest.setSuccess_url(successUrl);
		                tupayDepositsRequest.setClientId(clientId);
		                tupayDepositsRequest.setType(channel);
		                tupayDepositsRequest.setPlataforma(Constantes.PLATAFORM);
		                tupayDepositsRequest.setOperatorId(tokenValidation.getOperatorId());
		                tupayDepositsRequest.setWebSite("LATINKA");
		                tupayDepositsRequest.setIp(ip);
		                tupayDepositsRequest.setPromotionKey(codePromotional);
		                
		                //request
		                String userApiTupay=ConnectionFactory.operationProperty("userApiTupay", "tupay").trim();
		                String secretApiTupay=ConnectionFactory.operationProperty("secretApiTupay", "tupay").trim();
		                String depositsApiTupay=ConnectionFactory.operationProperty("depositsApiTupayNew", "tupay").trim();
		                String credenciales = userApiTupay+":"+secretApiTupay;
		    	    	credenciales = new BASE64Encoder().encode(credenciales.getBytes("UTF-8"));
		                URL urlApiLocalTupay = new URL(depositsApiTupay);
		    			HttpURLConnection  cnSession = (HttpURLConnection )urlApiLocalTupay.openConnection();
		        		cnSession.setRequestMethod("POST");
		        		cnSession.setRequestProperty("Content-Type", Constantes.APPLICATION_JSON);
		        		cnSession.setRequestProperty("Accept", Constantes.APPLICATION_JSON);
		        		cnSession.setRequestProperty("Authorization", "Basic "+credenciales);
		        		cnSession.setDoOutput(true);
		        		String jsonInputString = gson.toJson(tupayDepositsRequest);
		                
		            	OutputStream os = cnSession.getOutputStream();
		            	os.write(jsonInputString.getBytes(Constantes.CHARSET_UTF8)); 
		            	os.flush();
		            	os.close();
		                //response
		            	BufferedReader brSession = null;
		            	int responseCodeSession = cnSession.getResponseCode();
		            	if(responseCodeSession < HttpServletResponse.SC_BAD_REQUEST) {
		            		brSession = new BufferedReader(new InputStreamReader((cnSession.getInputStream()),Constantes.CHARSET_UTF8));
		            	}else {
		            		brSession = new BufferedReader(new InputStreamReader((cnSession.getErrorStream()),Constantes.CHARSET_UTF8));
		            	}
		            	            	
		        		StringBuilder sbSession = new StringBuilder();
		        		char[] bufferSession = new char[1000];
		                int leidoSession;
		                while ((leidoSession = brSession.read(bufferSession)) > 0) {
		                	sbSession.append(new String(bufferSession, 0, leidoSession));
		                }
		        		brSession.close();
		        		String jsonResponse = sbSession.toString();
		        		LoggerApi.Log.info("-------------- jsonResponse " +jsonResponse);
		        		if(jsonResponse.equals("ERROR")) {
		        			out.print(" | "+jsonResponse);
		        		}else {
		        			out.print(jsonResponse);
		        		}
					}
				}else {
					msg = "Debe ingresar un monto de carga a partir de " + intralotUtils.formatCurrency2(minAmount);
					out.print(" | "+msg);
				}
            }else {
            	if(tokenValidation.getStatus().equals("TIMEOUTTR")) {
            		String msg = tokenValidation.getStatus();
					out.print(" | "+msg);
            	}
            }
        } catch (Exception ex) {
        	LoggerAPI.severe(LoggerAPI.SALECARD, ex);
        }finally {
        	LoggerApi.Log.info("-------------- END " +log);
        }
    }
    
    public class TupayDepositsRequest {

    	private String country;
    	private String currency;
    	private Integer amount;
    	private String payment_method;
    	private boolean mobile;
    	private Payer payer;
    	private String notification_url;
    	private String back_url;
    	private String success_url;
    	private String error_url;
    	private Integer clientId;
    	private String type;
    	private String plataforma;
    	private String operatorId;
    	private String webSite;
    	private String ip;
    	private String promotionKey;
    	
    	public boolean isMobile() {
    		return mobile;
    	}
    	public void setMobile(boolean mobile) {
    		this.mobile = mobile;
    	}
    	public String getCountry() {
    		return country;
    	}
    	public void setCountry(String country) {
    		this.country = country;
    	}
    	public String getCurrency() {
    		return currency;
    	}
    	public void setCurrency(String currency) {
    		this.currency = currency;
    	}
    	public Integer getAmount() {
    		return amount;
    	}
    	public void setAmount(Integer amount) {
    		this.amount = amount;
    	}
    	public String getPayment_method() {
    		return payment_method;
    	}
    	public void setPayment_method(String payment_method) {
    		this.payment_method = payment_method;
    	}
    	public Payer getPayer() {
    		return payer;
    	}
    	public void setPayer(Payer payer) {
    		this.payer = payer;
    	}
    	public String getNotification_url() {
    		return notification_url;
    	}
    	public void setNotification_url(String notification_url) {
    		this.notification_url = notification_url;
    	}
    	public String getBack_url() {
    		return back_url;
    	}
    	public void setBack_url(String back_url) {
    		this.back_url = back_url;
    	}
    	public String getSuccess_url() {
    		return success_url;
    	}
    	public void setSuccess_url(String success_url) {
    		this.success_url = success_url;
    	}
    	public String getError_url() {
    		return error_url;
    	}
    	public void setError_url(String error_url) {
    		this.error_url = error_url;
    	}
    	public Integer getClientId() {
			return clientId;
		}
		public void setClientId(Integer clientId) {
			this.clientId = clientId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPlataforma() {
			return plataforma;
		}
		public void setPlataforma(String plataforma) {
			this.plataforma = plataforma;
		}
		public String getOperatorId() {
			return operatorId;
		}
		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}
		public String getWebSite() {
			return webSite;
		}
		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getPromotionKey() {
			return promotionKey;
		}
		public void setPromotionKey(String promotionKey) {
			this.promotionKey = promotionKey;
		}

		public class Payer{
    		private String document_type;
    		private String document;
    		private String first_name;
    		private String last_name;
    		private String email;
    		
    		public String getDocument_type() {
    			return document_type;
    		}
    		public void setDocument_type(String document_type) {
    			this.document_type = document_type;
    		}
    		public String getDocument() {
    			return document;
    		}
    		public void setDocument(String document) {
    			this.document = document;
    		}
    		public String getFirst_name() {
    			return first_name;
    		}
    		public void setFirst_name(String first_name) {
    			this.first_name = first_name;
    		}
    		public String getLast_name() {
    			return last_name;
    		}
    		public void setLast_name(String last_name) {
    			this.last_name = last_name;
    		}
    		public String getEmail() {
    			return email;
    		}
    		public void setEmail(String email) {
    			this.email = email;
    		}
    	}
    }
}
