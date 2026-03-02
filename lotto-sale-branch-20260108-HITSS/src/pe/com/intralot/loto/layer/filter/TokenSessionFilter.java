package pe.com.intralot.loto.layer.filter;

import java.io.IOException;

import javax.servlet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * NOMBRE: TokenSessionFilter.java
 * <br></p>
 * <p>
 * FUNCION: Filtro para verificar sesion del cliente
 * <br></p>
 * <p>
 * NOTAS: Realiza cierre de session por expiracion, inicio de sesion en otro dispositivo, bloqueo de cuenta.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Edgar Narro	  18/04/2024  First comment
 * </pre>
 * <br></p>
 */

@Component
public class TokenSessionFilter implements Filter {	
	
	@Autowired
    private ClientBo clientBo;
	@Autowired
	private SecurityUtils securityUtils;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Aquí va la lógica del filtro
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String url=httpRequest.getRequestURI().toString();
//        ClientUpdateProcedureValidateSession validateSession=null;
    	ClientUpdateProcedureExpiredSession expiredSession=null;
    	JsonParser jparser = null; 
//    	LoggerApi.Log.info("URL que pasa por el filtro: "+url);
//        System.out.println("URL que pasa por el filtro: "+url);
    	String[] aurl=url.split("/");
    	int lng=aurl.length;
    	String suburl=aurl[lng-1];
        
        if ((UserBean) session.getAttribute(Constants.USR_SESION) != null && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpSessionid() != null
                && ((UserBean) session.getAttribute(Constants.USR_SESION)).getpClientid() != null && !suburl.equals("validate-session.html")) {
        	        	
        	// Obtener el tiempo de la última interacción del usuario
            long ultimaInteraccion = session.getLastAccessedTime();
            
            // Obtener el tiempo actual
            long tiempoActual = System.currentTimeMillis();
            
            // Calcular el tiempo transcurrido desde la última interacción
            long tiempoInactivo = tiempoActual - ultimaInteraccion;
            
            //Obtener tiempo para cierre de session
            int tiempoCierre = 30*60;
            String propTiempoCierre =ConnectionFactory.operationProperty("tiempoCierreSesion", Constants.contextSale); 
            tiempoCierre=!propTiempoCierre.equals("")?Integer.parseInt(propTiempoCierre)*60:tiempoCierre;
            
            if(tiempoInactivo/1000>=tiempoCierre) { //cierre de sesion si se supera 30 minutos de inactividad
            	//logica para regitrar evento de cierre de sesion
            	expiredSession=null;
	        	jparser = new JsonParser();
	        	try {
		        	JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
		        	Integer clientId=sessionData.get("clientId").getAsInt();		        	
	            	expiredSession = clientBo.expiredSession(clientId);
	            	//funcion http para cerrar TA
	        		String urlTA=securityUtils.fetchTA(httpRequest, httpResponse);	        		
	            	session.invalidate();
		        	LoggerApi.Log.info("expiredSession: estado="+expiredSession.getState()+" mensaje="+expiredSession.getMessage());
		        	LoggerApi.Log.info("Cierre de session por inactividad: Tiempo de inactividad: "+(tiempoInactivo/1000));
	//	        	System.out.println("Cierre de session por inactividad: Tiempo de inactividad: "+(tiempoInactivo/1000));
		        	session = httpRequest.getSession();
		        	session.setAttribute("closeSession", "closeSession");
		        	session.setAttribute("urlTA", urlTA);
	        	} catch (Exception e) {
					e.printStackTrace();
				}
	        	
	        	if(suburl.equals("rechargei.html")) {
	        		chain.doFilter(request, response);
	        	}else {
	        		httpResponse.sendRedirect("inicio.html");
	        	}
	        	
	        	
            }
//            else if(tiempoInactivo/1000>5) { //cierre de sesion: inicio de sesion en otro dispositivo, bloqueo de cuenta 
//	        	//logica para valiar tokensession
//            	validateSession=null;
//	        	jparser = new JsonParser();      
//	        	
//				try {
//					JsonObject sessionData = jparser.parse(session.getAttribute("sessionData").toString()).getAsJsonObject();
//		        	String tokenSession=sessionData.get("tokenSession").getAsString();
//		        	Integer clientId=sessionData.get("clientId").getAsInt();
//		        	String mobilePhone=sessionData.get("celular").getAsString();
//		        	String docType=sessionData.get("tipoDocumento").getAsString();
//		        	String docNumber=sessionData.get("numeroDocumento").getAsString();
//					validateSession = clientBo.validateSession(tokenSession, clientId, mobilePhone, docType, docNumber);
//					//si token es diferente cerrar sesion
//		        	if(!validateSession.getState().equals("OK")) {
//		        		session.invalidate();
//		        		LoggerApi.Log.info("Cierre de session por validateSession: Tiempo de inactividad: "+(tiempoInactivo/1000));
//		            }
//	//	            	chain.doFilter(request, response);
//		            
//				} catch (Exception e) {
//					e.printStackTrace();
//				}        	
//				chain.doFilter(request, response);
//            
//            }
            else {
            	chain.doFilter(request, response);
            }
                        
        }else {
        	
        	// Llama a chain.doFilter() para continuar con la cadena de filtros
            chain.doFilter(request, response);
        }

        // Aquí puedes agregar lógica de postprocesamiento si es necesario
//        System.out.println("Filtro postprocesamiento: Después de llamar al contexto");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//permite la inyeccion de dependencias en filtros, sin ello no funciona @autowired
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
			      filterConfig.getServletContext());
		
	}

}
