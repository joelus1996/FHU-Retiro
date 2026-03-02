package pe.com.intralot.loto.layer.controller.payment.paysafecard;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

/**
 * Servlet implementation class showErrorAndDebug
 */
//@WebServlet("/showErrorAndDebug")
public class showErrorAndDebug extends HttpServlet { 
 
	private static final long serialVersionUID = 9157507880301059593L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//Get error logs and debug logs and OS-specific line break characters
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, String>> error_log = (ArrayList<HashMap<String, String>>) session.getAttribute("error_log");
		String debug = (String) session.getAttribute("debug");
		String newLine = System.getProperty("line.separator");
		//Print Debug
		out.println(debug);
		//Print a line separator
		out.println("---------------------------------------------");
		//Output the msg variable of each entry in the error log
		for(int i=0; i<error_log.size(); i++){
			out.println(error_log.get(i).get("msg") + newLine);
		}
	}
}
