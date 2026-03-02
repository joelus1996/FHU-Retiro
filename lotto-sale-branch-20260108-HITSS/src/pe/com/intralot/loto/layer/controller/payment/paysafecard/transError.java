package pe.com.intralot.loto.layer.controller.payment.paysafecard;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

import pe.com.intralot.loto.layer.model.bean.UserBean;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.Constants;

/**
 * Servlet implementation class transError
 */
// @WebServlet("/transError")
public class transError extends HttpServlet { 
 
	private static final long serialVersionUID = 5976331238003627471L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Print Info Log
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String user = ((UserBean) session.getAttribute(Constants.USR_SESION)).getpUser(); 
		String amount = request.getParameter("amount");
		String mtid = request.getParameter("mtid");
		String clientId = request.getParameter("cid");

		response.setContentType("text/html");
		out.println( transSuccess.getHtml((String)session.getAttribute("info_log"),"No se ha realizado la carga de "+amount+" soles") );
		
		//Get error logs and debug logs and OS-specific line break characters
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, String>> error_log = (ArrayList<HashMap<String, String>>) session.getAttribute("error_log");
		String debug = (String) session.getAttribute("debug");
		String newLine = System.getProperty("line.separator");
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" START ====== transError-extends-HttpServlet");
		//Print Debug
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" debug="+debug);
		//Print a line separator
		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+"  ---------------------------------------------");
		//Output the msg variable of each entry in the error log
		if (error_log!=null) {
			for(int i=0; i<error_log.size(); i++){
				Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" "+error_log.get(i).get("msg") );
			}
		}

		Logger.getLogger(LoggerAPI.SALECARD).info("cid=" + clientId + " mtid="+mtid+" END ====== transError-extends-HttpServlet");
	}
}
