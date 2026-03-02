package pe.com.intralot.loto.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {	
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session = request.getSession(false);
		HttpServletResponse response=(HttpServletResponse)res;
 
		//		if(request.getServletPath()!=null && ( !request.getServletPath().contains("captcha.html") ) && ( request.getServletPath().contains(".html") || request.getServletPath().contains(".jsp")) ){
		if(request.getServletPath()!=null && ( request.getServletPath().contains(".html") || request.getServletPath().contains(".jsp")) ){
			if(request.getServletPath()!=null && ( request.getServletPath().contains("tav2.html") || 
													request.getServletPath().contains("home.jsp") || 
													request.getServletPath().contains("home.html") ||
													request.getServletPath().contains("security_login_execute_authentication.html") ||
													request.getServletPath().contains("client_lotocard_show_form.html") ||
													request.getServletPath().contains("help.html") ||
													request.getServletPath().contains("client_lotocard_show_geolocation_dynamicmap.html") ||
													request.getServletPath().contains("game_tinka_show_menu.html") ||
													request.getServletPath().contains("game_ganagol_show_menu.html") ||
													request.getServletPath().contains("game_kabala_show_menu.html") ||
													request.getServletPath().contains("game_kinelo_show_home.html") ||
													request.getServletPath().contains("game_ganadiario_show_menu.html")) ) {
				if(session == null) {
					session = request.getSession(true);
				}
			}
			
			if(session != null) {
				chain.doFilter(req, res);
			} else {
				request.getSession(true);
				response.sendRedirect(request.getContextPath().concat("/redireccionar.html"));
			}	
		}else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig chain) throws ServletException {
		
	}

}