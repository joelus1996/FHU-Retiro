package pe.com.intralot.loto.util;

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
		
		if(request.getServletPath()!=null && ( request.getServletPath().contains("tav2.html") || 
												request.getServletPath().contains("index.jsp") || 
												request.getServletPath().contains("inicio.html") ||
												request.getServletPath().contains("juega-kinelo.html") ||
												request.getServletPath().contains("juega-tinka.html") ||
												request.getServletPath().contains("juega-raspaya.html") ||
												request.getServletPath().contains("juega-virtuales.html") ||
												request.getServletPath().contains("juega-casino.html") ||
												request.getServletPath().contains("juega-kabala.html") ||
												request.getServletPath().contains("juega-ganadiario.html") ||
												request.getServletPath().contains("juega-ganagol.html") ||
												request.getServletPath().contains("restablecer.html") ||
												request.getServletPath().contains("registro.html") ||
												request.getServletPath().contains("juega-bien.html") ||
												request.getServletPath().contains("inversionistas.html") ||
												request.getServletPath().contains("responsabilidad-social.html"))) {
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
	}

	@Override
	public void init(FilterConfig chain) throws ServletException {
		
	}

}

