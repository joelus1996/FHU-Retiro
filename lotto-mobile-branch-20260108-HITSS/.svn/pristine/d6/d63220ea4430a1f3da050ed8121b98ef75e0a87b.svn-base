package pe.com.intralot.loto.utils;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pe.com.intralot.loto.lib.StringLib;

/**
 * @author:   Angel Chata
 * @rol:	  Jefe de Desarrollo de Sistemas
 * @proyecto: lotto-mobile
 *
 */

public class Node {

	//public static final String JBOSS_SERVER_NAME = System.getProperty("jboss.server.name");
	//public static final String JBOSS_HOST_NAME = System.getProperty("jboss.host.name");
	public static final String JBOSS_NODE_NAME = System.getProperty("jboss.node.name");
	public static String node = "";
	
	static {
	    try {
	    	node = JBOSS_NODE_NAME;
	    	if (node==null || node.equals("")) {
	    		node = InetAddress.getLocalHost().getHostName();
	    	}
	    	if (node==null) {
	    		node="";
	    	}
	    	node = StringLib.generatePassword (2) + node.toLowerCase();
	    } catch (Exception e) {
	        ;
	    }
	}

	public static String nodeString() {
		SimpleDateFormat formatter= new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss z");  
		Date date = new Date(System.currentTimeMillis());  
    	return node + formatter.format(date);
	}
}
