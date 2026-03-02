package pe.com.intralot.loto.layer.filter;

import static pe.com.intralot.loto.util.Constants.getPropertyContextSale;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.google.gson.Gson;
import pe.com.intralot.loto.layer.dto.pam.LoginDataResponse;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.ApiClient;
import pe.com.intralot.loto.util.SecurityUtils;

@Component
public class InternavegacionFilter implements Filter {

	@Autowired
	private SecurityUtils securityUtils;
	
    @Autowired
    private ClientSaleBo clientSaleBo; 

	private static final Pattern GAME_PATTERN = Pattern.compile("/internavegacion/([\\w\\-]+)");

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String contextPath = httpRequest.getContextPath();
		String requestURI = httpRequest.getRequestURI();
		String queryString = httpRequest.getQueryString();
		String relativeURI = requestURI.replace(contextPath, "");
		
	    // Obtener parámetros
        String token = httpRequest.getParameter("token");  
        String fragment = httpRequest.getParameter("fragment");

        // Manejo para URLs con "redirect.html"
        if (requestURI.contains("redirect.html")) {
            chain.doFilter(request, response);
            return;
        }
        
        // verifica la redireccion de loyalty
        if (relativeURI.startsWith("/internavegacion/")) {
		if (relativeURI.endsWith(".html")) {
            chain.doFilter(request, response);
            return;
        }
	
		Matcher matcher = GAME_PATTERN.matcher(relativeURI);
		if (matcher.matches()) {
			String game = matcher.group(1);
                System.out.println("GAME: " + game);
			String newURI = contextPath + "/internavegacion/" + game + ".html";
			if (queryString != null) {
				newURI += "?" + queryString;
			}
			httpResponse.sendRedirect(newURI);
			return;
		}

		chain.doFilter(request, response);
            return;
        }
        
        // Validar y procesar el token
       	if (token != null && !token.isEmpty()) {

       		try {
       			Gson gson = new Gson();	
	  			String ip = httpRequest.getRemoteAddr();
	  			
	  		    Map<String,String> headers = new HashMap<String,String>();
	  			headers.put("X-Ip-Origin", "192.68.1.1");
	  			headers.put("X-Company", "ECOM");
	  			
	  			String tokenResponse = ApiClient.get( getPropertyContextSale("urlSecurityToken")+"/"+token, "12345678", "12345678", headers);	  			
	  			LoginDataResponse responseLogin = gson.fromJson(tokenResponse, LoginDataResponse.class);
	  			
	  			if (responseLogin.getResult() != null) { 
	  			   
	  				// Login exitoso: crear sesión y redirigir
	  			   HttpSession session = httpRequest.getSession();					
	  			   securityUtils.createSession(responseLogin.getResult(), clientSaleBo, session, ip, httpResponse);	  			   
	  			   String urlBeforeToken = (fragment != null && !fragment.isEmpty()) 
	  					   ? requestURI + "#" + fragment 
	  							   : requestURI;	    
	                httpResponse.sendRedirect(urlBeforeToken);
	                return;

	  			} else {
	  				// Invalidar la sesión
	  				HttpSession getsession = httpRequest.getSession(false); 
	  				if (getsession != null) {
	  					getsession.invalidate();  
	  				}
	  				httpResponse.sendRedirect(requestURI);
	  				return;
	}

       		} catch(Exception e) {
       			LoggerApi.severe(e);
                LoggerApi.Log.info("Error: " + e.getMessage());
                // Redirige al inicio en caso de error
                httpResponse.sendRedirect(contextPath);
    		} 
      		
     	}         	
       	 // Si no hay token, continuar con el filtro
         chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			//permite la inyeccion de dependencias en filtros, sin ello no funciona @autowired
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				      filterConfig.getServletContext());		
	}

}
