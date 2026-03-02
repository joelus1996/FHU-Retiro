package pe.com.intralot.loto.util;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**<p> NAME:    TextLogFormatter.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 002   c_achata    04/07/2018  Se quita la tabla LOTOCARD.LOGGER_LOTTOLAPOLLA
 * 001   c_achata    11/03/2008  First comment
 * </pre>
 * </p>
 */


public class TextLogFormatter  extends Formatter {
	
    // This method is called for every log records
    public String format(LogRecord rec) {
    	
    	DateAPI date = new DateAPI(rec.getMillis());
    	
        StringBuffer buf = new StringBuffer(1000);
        buf.append(rec.getLevel());
        buf.append(' ');
        buf.append(date.getDate("dd/MM/yyyy HH:mm:ss SSS"));
        buf.append(' ');
        buf.append(formatMessage(rec));        
        //buf.append(" ["+rec.getSourceMethodName()+"]");
        
	    String message = formatMessage(rec).toString();
	    System.out.println("MESSAGE="+message);
	    /*
	    //JsonElement je = new JsonParser().parse(message);
	    //JsonObject jo1 = je.getAsJsonObject().getAsJsonObject();
	    //JsonObject jo2 = jo1.getAsJsonObject("INFO");
	    //System.out.println("JO1="+jo1.get("DOCNUM").getAsString());
	    //System.out.println("JO2="+jo2.get("ErrorDescripcion").getAsString());
        Dbms rs = null;*/
	    /*
        if (message.startsWith("...in") || message.startsWith("DbSMS") || message.startsWith("Waiti") || 
	    		message.startsWith("No me") || message.startsWith("Time=") ||  message.startsWith("SMSTh") ) {
	    	;
	    } else {
    		Dbms rs = null;
	    	try {    	
		    	
		    	String sql = "INSERT INTO LOTOCARD.LOGGER_LOTTOLAPOLLA(LLP_LEVEL, LLP_MESSAGE) VALUES(?,?)";	    
		    	rs = new Dbms(sql);
		    	rs.setString(1, rec.getLevel().toString()); 
			    if (message.length()>4000) message = message.substring(0, 4000);
				rs.setString(2, message);
				//rs.setString(3, jo1.get("IP").getAsString().trim());
				//rs.setString(4, jo1.get("DOCNUM").getAsString().trim());
				//rs.setString(5, jo2.get("FlagEncontrado").getAsString().trim());
				//rs.setString(6, jo2.get("ErrorCode").getAsString().trim());
				//rs.setString(7, jo2.get("ErrorDescripcion").getAsString().trim());
				rs.executeUpdateNoLog();
				rs.closeNoLog();
		        rs = null;
	    	} catch(Exception e) {
	    		e.printStackTrace(System.out);
	    		//System.out.println(e);
	    	} finally {
	    		if (rs!=null) try { rs.closeNoLog(); } catch (Exception e1) {}
	    	}
	    }
        */
        buf.append(System.getProperty("line.separator"));
        return buf.toString();
    }

    // This method is called just after the handler using this
    // formatter is created
    public String getHead(Handler h) {
    	DateAPI date = new DateAPI();
        return date.getDateEnglish("EEEE, dd  MMMMM  yyyy  HH:mm:ss SSS")+
               System.getProperty("line.separator");
    }

    // This method is called just after the handler using this
    // formatter is closed
    public String getTail(Handler h) {
        return System.getProperty("line.separator");
    }
}