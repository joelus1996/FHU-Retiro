package pe.com.intralot.loto.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**<p> NAME:    Loggerapi.java    
 *     COMMENTS:     
 *     In logging.properties file, add a # in this line
 *     # handlers= java.util.logging.ConsoleHandler
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          		DATE        COMMENT
 * 001   cristian.cortez	25/11/2016  First comment
 * </pre>
 * </p>
 */

public class LoggerApi extends ConnectionFactory {	
	
	public  static final String LOGGERLAPOLLAAPI      = "pe.com.intralot.loto.lapollaapi";
		
	private static DateAPI loggerDate;
	private static String loggerFile;
	private static String APP="LAPOLLAAPI"; 
	public static Logger Log;
	 
    public LoggerApi() {}
    
	public static void startLogger(String loggerString) {
    	System.out.println("verifyLoggers start "+LoggerApi.LOGGERLAPOLLAAPI);
    	try {
    		DateAPI d = new DateAPI();
    		if (loggerDate!=null) {
        		if (!d.getDate("dd/MM/yyyy").equals(loggerDate.getDate("dd/MM/yyyy"))) 
        			loggerDate=null;
    		}
        	if (loggerDate==null) {
        		closeFileHandler(loggerString);
        		Log = Logger.getLogger(loggerString); 
        		initCardFileHandler();
            	Log.info("verifyLoggers loggerDate="+loggerDate+" loggerFile="+loggerFile+" APP="+APP+" LOGGER="+LOGGERLAPOLLAAPI);
        	}
    		
    	} catch (Exception e) {
        	if (e!=null) e.printStackTrace(System.out);
        	StringWriter sw = new StringWriter();
        	if (e!=null) e.printStackTrace(new PrintWriter(sw));
    	}
    	System.out.println("verifyLoggers end "+LoggerApi.LOGGERLAPOLLAAPI);
    }	
    
    public static String severe(Throwable e) {
    	return severe(e, null, "debug");
    }    

    public static String severe(Throwable e, String message, String debug) {
    	return severe(e, message, debug, true);
    }
    
    public static String severe(Throwable e, String message, String debug, boolean stackTrace) {
    	
    	String code = " (Codigo A-001)";
    	try {
        	Random r = new Random(); 
        	code=" (Codigo "+(char)(r.nextInt(26) + 'A')+"-"+StringLib.padLeft(r.nextInt(999)+"", '0', 3)+")";
    	} catch (Exception e1) { System.out.println(e1.getMessage()); code = " (Codigo A-001)";}
    	
    	if (stackTrace==true) {
        	if (e!=null) e.printStackTrace(System.out);
    	}
    	StringWriter sw = new StringWriter();
    	if (e!=null) e.printStackTrace(new PrintWriter(sw));  	
		String sws = null;
		try {
			sws = sw.toString();
	    	if (message==null && sw!=null) {
	        	message = sws.substring(0,sws.indexOf('\n'));
	    	}
		} catch (Exception e1) {}
		
    	message += code;
    	
    	String area = operationProperty("applicationArea").toUpperCase();
  
    	try {
        	if (stackTrace==true) {
            	Log.severe(message+" \n "+sws);
        	} else {
            	Log.severe(message);
        	}
        	//MailLib.sendErrorMail(e, "area="+area+" app="+APP+" "+message, code.trim()+" "+debug+" ");
    	} catch (Exception e1) { System.out.println(e1.getMessage());}
    	
    	return code;
    } 
    
    public static String severe(Throwable e, String uuid) {
    	return severe(e, null, "debug", uuid);
    }
    
    public static String severe(Throwable e, String message, String debug, String uuid) {
    	return severe(e, message, debug, true, uuid);
    }
    
    public static String severe(Throwable e, String message, String debug, boolean stackTrace, String uuid) {
    	
    	String code = " (Codigo A-001)";
    	try {
        	Random r = new Random(); 
        	code=" (Codigo "+(char)(r.nextInt(26) + 'A')+"-"+StringLib.padLeft(r.nextInt(999)+"", '0', 3)+")";
    	} catch (Exception e1) { System.out.println(e1.getMessage()); code = " (Codigo A-001)";}
    	
    	if (stackTrace==true) {
        	if (e!=null) e.printStackTrace(System.out);
    	}
    	StringWriter sw = new StringWriter();
    	if (e!=null) e.printStackTrace(new PrintWriter(sw));  	
		String sws = null;
		try {
			sws = sw.toString();
	    	if (message==null && sw!=null) {
	        	message = sws.substring(0,sws.indexOf('\n'));
	    	}
		} catch (Exception e1) {}
		
    	message += code;
    	
    	String area = operationProperty("applicationArea").toUpperCase();
  
    	try {
        	if (stackTrace==true) {
            	Log.severe(message+" \n "+sws + " \n "+ "uuid="+uuid);
        	} else {
            	Log.severe(message+ " \n "+ "uuid="+uuid);
        	}
        	//MailLib.sendErrorMail(e, "area="+area+" app="+APP+" "+message, code.trim()+" "+debug+" uuid="+uuid);
    	} catch (Exception e1) { System.out.println(e1.getMessage());}
    	
    	return code;
    } 

    public static void event(String service, Throwable e, String message, String debug) {

    	String area = operationProperty("applicationArea");
    	
		String output= "? ? ? ? ? "+message+" "+debug+" "+(e!=null ? e.getMessage() :"");
		Log.info(output);
		
    	try {
    		MailLib.sendErrorMail(e, "area="+area+" app="+APP+" "+message, debug);
    	} catch (Exception e1) { System.out.println(e1.getMessage());}

    	try {
        	String mailEvent = operationProperty("mailEvent");
        	MailLib.sendMail(mailEvent,"area="+area+" "+APP+" "+message, debug);    
    	} catch (Exception e1) { System.out.println(e1.getMessage());}
    	 
    }  
    
    private static void closeFileHandler(String LoggerString) {
    	try {
    		Logger logger = Logger.getLogger(LoggerString);
    		while (logger.getHandlers().length>0) {
    			logger.getHandlers()[0].close();
    			logger.removeHandler(logger.getHandlers()[0]);    		 
    		}
    	} catch (Exception e) {}
    }
 
    private static void initCardFileHandler() throws Exception {

		System.out.println("properties="+System.getProperty("java.home")+System.getProperty("file.separator")+"setup"+System.getProperty("file.separator")+context.toLowerCase()+".properties");
		
        loggerDate = new DateAPI();
    	
        loggerFile =  operationProperty("loggerPath")+
                      APP+
    	              "_LOG_"+loggerDate.getDate("yyyy_MM_dd")+"_%u.txt";
		    	
		String sep = System.getProperty("file.separator");
        System.out.println("Logger FileHandler "+loggerFile+" starting!");
        
        String propsFile = System.getProperty("java.home")+sep+"lib"+sep+"logging.properties";
        System.out.println("Logger FileHandler logging.properties="+propsFile);
        
        try {
            String propsString = FileLib.readFileToString(propsFile).toString();
            String []ss = propsString.split("\n");
            for (String s:ss) {
            	if (!s.startsWith("#") && !s.trim().equals("") && !s.trim().equals("\n")) {
            		if (s.indexOf("java.util.logging.ConsoleHandler")>0) {
                		System.out.println("WARNING!!! In logging.properties file, you should comment #handlers= java.util.logging.ConsoleHandler");   
            		}
            		System.out.print(s+" ");   
            	}
            }
        } catch (Exception e) {
        	e.printStackTrace(System.out);
        }    	
    	String path = System.getProperty("java.home")+System.getProperty("file.separator")+"setup"+System.getProperty("file.separator");

    	System.out.println();
    	System.out.println("JAVA_HOME                ----> "+System.getProperty("java.home"));
    	System.out.println("properties file          ----> "+path+context.toLowerCase()+".properties");
    	System.out.println("loggerPath in props file ----> "+operationProperty("loggerPath"));
    	
    	Dbms dbms = null;
    	try {
    		dbms = new Dbms();//("");    	
        	System.out.println("DBMS                     ----> "+dbms);    	
		} finally {
			try {
				if(dbms!=null) {
					System.out.println("<--------------------LoggerApi cerrando conexion------------------->");
					dbms.close();//("");
				}
			} catch (Exception e) {
				System.out.println("<--------------------LoggerApi error cerrando conexion------------------->");
				e.printStackTrace();
			}
			
		}
    
        
        try {
            // Create an appending file handler
            boolean append = true;
            FileHandler fileHandler       = new FileHandler(loggerFile, append);   
            
            // Don't uses the XML formatter
            fileHandler.setFormatter(new TextLogFormatter());
                    
            // Add to the desired logger
            Logger logger = Log;
            
            logger.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setErrorManager( new ErrorManagerAPI());
            
            logger.addHandler(fileHandler);
            
            System.out.println("Logger FileHandler "+loggerFile+" started!");
            logger.info("1. Logger FileHandler "+loggerFile+" started!");
            logger.info("2. "+loggerFile+" "+LoggerApi.LOGGERLAPOLLAAPI);
            
        } catch (IOException e) {
        	e.printStackTrace(System.out);
        }    	
    }
    

    public static void debug(Throwable e, String message, String debug) {

    	StringWriter sw = new StringWriter();
    	if (e!=null) {
    		e.printStackTrace(System.out);
        	e.printStackTrace(new PrintWriter(sw));
    	}
    	if (message==null && e!=null)  message = e.getMessage();
    	
    	if (sw!=null) {
        	debug = debug+" \n "+sw.toString();
    	}
    	
    	Log.severe(message+" "+debug);
		if (e!=null) Log.severe(e.getMessage());

    	String area = operationProperty("applicationArea").toUpperCase();
    	
    	MailLib.sendErrorMail(e, "area="+area+" app="+APP+" "+message, debug);
    	
    }  

    public static String getAPP() {
		return APP;
	}

	public static void setAPP(String aPP) {
		APP = aPP;
	}   
}