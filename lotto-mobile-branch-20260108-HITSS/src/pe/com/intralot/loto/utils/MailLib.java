package pe.com.intralot.loto.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
//import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import pe.com.intralot.loto.layer.model.pojo.ImgDto;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.mail.internet.MimeBodyPart;

/**<p> NAME:    MailLib.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    25/11/2016  First comment
 * </pre>
 * </p>
 */

public class MailLib extends ConnectionFactory { 
	
	public static void sendMail(String mailTarget, String mailSubject, String mailBody)
	{
		try {
			sendValidMail(mailTarget, mailSubject, mailBody);
		} catch (Exception ex) {
			System.out.println(ex.getMessage()+" "+mailTarget);
		}
	}

	public static void sendMail(String mailSource, String mailTarget, String mailSubject, String mailBody)
	{
		try {
			sendValidMail(mailSource, mailTarget, mailSubject, mailBody);
		} catch (Exception ex) {
			System.out.println(ex.getMessage()+" "+mailTarget);
		}
	}
 

	public static String sendErrorMail (Throwable th, 
			String userMessage,
			String debug)
	{ 
		return sendErrorMail (th, userMessage, debug, operationProperty("mailDebug"));
	}
	
	public static String sendErrorMail (Throwable th, 
			String userMessage,
			String debug,
			String mailDebug)
	{ 
		String exceptionString = ""; 
		String requestString   = "";
		String mailBody        = "";

		if (th !=null) {
			StringWriter writer = new StringWriter();
			th.printStackTrace(new PrintWriter(writer));
			exceptionString = writer.toString();
		}
		
		String serverString      = getServerString("\n<br>*");
		String applicationString = getApplicationString("\n<br>*");

		mailBody =  
		    "\n<br>* exceptionString="+exceptionString +
			"\n<br>* userMessage="+userMessage +
			"\n<br>* debug="+debug + 
			"\n<br>* requestString="+requestString +
			serverString + 
			applicationString;
 			
		try {
			String subject = "";
			if (userMessage!=null) {
				int i = userMessage.indexOf('\n');
				if (i>0) {
					subject = userMessage.substring(0, i);
				} else {
					subject = userMessage;
				}
			}
			sendMail(mailDebug, subject, mailBody);
		}
		catch (Exception e) {
			System.out.println(mailBody);
			e.printStackTrace(System.out);
		}
		finally {}

		return userMessage;
	}

	public static void sendValidMail(String mailTarget, String mailSubject, String mailBody)
	{
		try {
			sendValidMail(null, mailTarget, mailSubject, mailBody);
		} catch (Exception e) {
			System.out.println("sendValidMail="+e.getMessage());
			System.out.println("mailTarget   ="+mailTarget);
			System.out.println("mailSubject  ="+mailSubject);
		}
	}

	public static String sendValidMailEco(String mailTarget, String mailSubject, String mailBody) throws Exception
	{
		sendValidMail(null, mailTarget, mailSubject, mailBody);
		return "OK";
		
	}
	
	private static void sendValidMail(String mailSource, String mailTarget, String mailSubject, String mailBody)
	throws Exception
	{
		sendValidMail(mailSource, mailTarget, mailSubject, mailBody, "text/html; charset=UTF-8");
	}
	
	private static void sendValidMail(String mailSource, String mailTarget, String mailSubject, String mailBody, String contentType)
	throws Exception {
		
		Session session = null;
			
		if (mailSource==null) mailSource = operationProperty("mailSourceUser");//mailSource
		
		try {
			Context ic = new InitialContext();
			session = (Session)ic.lookup("java:Mail"); 
		} catch (javax.naming.NamingException e) {
			try {
				String mailServer = operationProperty("mailServer");
				java.util.Properties props = new java.util.Properties();
				props.put("mail.smtp.host", mailServer);
				session = Session.getInstance(props, null);
			} catch (Exception ex) {
				System.out.println("ex.getMessage()="+ex.getMessage());
			}
		}
	// construct the message

		Message msg = new MimeMessage(session);
		InternetAddress[] ccaddress = InternetAddress.parse(mailTarget);
		
		if (mailSource!=null && !mailSource.equals("")) {
			InternetAddress from = new InternetAddress(mailSource,"LA TINKA");
	        msg.setFrom(from);
		} else {
			System.out.println("mailSource="+mailSource);
		}

		msg.setRecipients(Message.RecipientType.TO,ccaddress);
		msg.setSubject(mailSubject);
		msg.setContent(mailBody, contentType);
		//Transport.send(msg);
	}
	
	protected static String getApplicationString(String nl) {
		return null;
	}
	
	public static void sendValidMail(String mailSource, String mailSourceName, String mailTarget, String mailSubject, String mailBody, String contentType, 
			ByteArrayOutputStream baos,String filename, String imgpath, String imgpath2)
	throws Exception {
		Session session = null;
		
		if (mailSource==null) mailSource = operationProperty("mailSource");
		
		try {
			Context ic = new InitialContext();
			session = (Session)ic.lookup("java:Mail"); 
		} catch (javax.naming.NamingException e) {
			try {
				String mailServer = operationProperty("mailServer");
				java.util.Properties props = new java.util.Properties();
				props.put("mail.smtp.host", mailServer);
				session = Session.getInstance(props, null);
			} catch (Exception ex) {
				System.out.println("ex.getMessage()="+ex.getMessage());
			}
		}
		
        BodyPart texto = new MimeBodyPart();
        texto.setContent(mailBody, contentType);
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        
        if(imgpath!=null && !imgpath.trim().isEmpty()) {           
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID", "<logoimg>");
            imagePart.setDisposition(MimeBodyPart.INLINE); 
            imagePart.attachFile(new File(imgpath));
            multiParte.addBodyPart(imagePart); 
        }
        
        if(imgpath2!=null && !imgpath2.trim().isEmpty()) {           
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID", "<juegosimg>");
            imagePart.setDisposition(MimeBodyPart.INLINE); 
            imagePart.attachFile(new File(imgpath2));
            multiParte.addBodyPart(imagePart); 
        }
        
        if(baos!=null){
            BodyPart adjunto = new MimeBodyPart();         
       		ByteArrayDataSource attachment = new  ByteArrayDataSource(baos.toByteArray(),"application/octet-stream");
       		adjunto.setDataHandler(new DataHandler(attachment));
            adjunto.setFileName(filename);
            multiParte.addBodyPart(adjunto);
        }
        
        MimeMessage msg = new MimeMessage(session);
		InternetAddress[] ccaddress = InternetAddress.parse(mailTarget);
		
		if (mailSource!=null && !mailSource.equals("")) {
			InternetAddress from = new InternetAddress(mailSource, mailSourceName);
	        msg.setFrom(from);
		} else {
			System.out.println("mailSource="+mailSource + " mailSourceName="+mailSourceName);
		}

		msg.setRecipients(Message.RecipientType.TO,ccaddress);
		msg.setSubject(mailSubject);
		msg.setContent(multiParte, contentType);
		Transport.send(msg);
	}
		
	public static String getServerString(String nl) {

		String ppidString = "";
		
		try {
		    Vector commands=new Vector();
		    commands.add("/bin/bash");
		    commands.add("-c");
		    commands.add("echo $PPID");
		    ProcessBuilder pb=new ProcessBuilder(commands);
		    Process pr=pb.start();
		    pr.waitFor();
		    if (pr.exitValue()==0) {
		      BufferedReader outReader=new BufferedReader(new InputStreamReader(pr.getInputStream()));
		      ppidString = "PPID="+outReader.readLine().trim();
		    } else {
		    	ppidString = "Error PPID";
		    }		
		    
		    Vector commands1=new Vector();
		    commands1.add("/bin/bash");
		    commands1.add("-c");
		    commands1.add("echo $TTY");
		    ProcessBuilder pb1=new ProcessBuilder(commands1);
		    Process pr1=pb1.start();
		    pr1.waitFor();
		    if (pr1.exitValue()==0) {
		      BufferedReader outReader=new BufferedReader(new InputStreamReader(pr1.getInputStream()));
		      ppidString += " TTY="+outReader.readLine().trim();
		    } else {
		    	ppidString += " Error TTY";
		    }	
		    
		} catch (Exception e) { 
			ppidString = "It is not a Unix System";
		}            
			
		return 
		nl+" java.home=" + System.getProperty("java.home") + 
		nl+" java.version=" + System.getProperty("java.version") + 
		nl+" user.name=" + System.getProperty("user.name") + 
		nl+" user.home=" + System.getProperty("user.home") + 
		nl+" user.dir=" + System.getProperty("user.dir") + 
		nl+" os.name=" + System.getProperty("os.name") + 
		nl+" os.arch=" + System.getProperty("os.arch") + 
		nl+" os.version=" + System.getProperty("os.version")+
		nl+" Unix process ID="+ppidString ;
	}
	public static void sendValidMailPD(String mailSource, String mailTarget, String mailSubject, String mailBody, String contentType, ByteArrayOutputStream baos,String filename,List<ImgDto> listImgDto)
			throws Exception {
				Session session = null;
				
				if (mailSource==null) mailSource = operationProperty("mailSourceUserPD");
				
				try {
					Context ic = new InitialContext();
					session = (Session)ic.lookup("java:Mail"); 
				} catch (javax.naming.NamingException e) {
					try {
						String mailServer = operationProperty("mailServer");
						java.util.Properties props = new java.util.Properties();
						props.put("mail.smtp.host", mailServer);
						session = Session.getInstance(props, null);
					} catch (Exception ex) {
						System.out.println("ex.getMessage()="+ex.getMessage());
					}
				}
				
		        BodyPart texto = new MimeBodyPart();
		        texto.setContent(mailBody, contentType);
		        MimeMultipart multiParte = new MimeMultipart();
		        multiParte.addBodyPart(texto);
		        
		        
		        if(baos!=null){
		        	for(ImgDto imgdto : listImgDto) {
		        		BodyPart adjunto = new MimeBodyPart();         
			       		ByteArrayDataSource attachment = new  ByteArrayDataSource(imgdto.getContenidoImg(),imgdto.getTipoImg());
			       		adjunto.setDataHandler(new DataHandler(attachment));
			            adjunto.setFileName(imgdto.getFileName());
			            multiParte.addBodyPart(adjunto);
		        	}
		            
		        }
		        		        		        
		        MimeMessage msg = new MimeMessage(session);
				InternetAddress[] ccaddress = InternetAddress.parse(mailTarget);
				
				if (mailSource!=null && !mailSource.equals("")) {
					InternetAddress from = new InternetAddress(mailSource);
			        msg.setFrom(from);
				} else {
					System.out.println("mailSource="+mailSource);
				}

				msg.setRecipients(Message.RecipientType.TO,ccaddress);
				msg.setSubject(mailSubject);
				msg.setContent(multiParte,contentType);
				Transport.send(msg);														
	}
	
	public static String sendValidMailEco_Security(String mailSource, String mailTarget, String mailSubject, String mailBody ,String imgpath, String imgpath2,String mailServer) throws Exception
	{
		sendValidMail_Security(mailSource, mailTarget, mailSubject, mailBody, imgpath, imgpath2,mailServer);
		return "OK";
		
	}
	
	private static void sendValidMail_Security(String mailSource, String mailTarget, String mailSubject, String mailBody,String imgpath, String imgpath2, String mailServer)
	throws Exception
	{
		sendValidMail_Segurity(mailSource, mailTarget, mailSubject, mailBody, "text/html; charset=UTF-8", imgpath, imgpath2, mailServer );
	}
	
	
	private static void sendValidMail_Segurity(String mailSource, String mailTarget, String mailSubject, String mailBody, String contentType,String imgpath, String imgpath2, String mailServer )
			throws Exception {
				
				Session session = null;
				
				if (mailSource==null) mailSource = operationProperty("mailSource");//mailSourceApp
				
				try {
					Context ic = new InitialContext();
					session = (Session)ic.lookup("java:Mail"); 
				} catch (javax.naming.NamingException e) {
					try {
						java.util.Properties props = new java.util.Properties();
						props.put("mail.smtp.host", mailServer);
						session = Session.getInstance(props, null);
					} catch (Exception ex) {
						System.out.println("ex.getMessage()="+ex.getMessage());
					}
				}
			// construct the message
				
				BodyPart texto = new MimeBodyPart();
		        texto.setContent(mailBody, contentType);
		        MimeMultipart multiParte = new MimeMultipart();
		        multiParte.addBodyPart(texto);
		        

		        if(imgpath!=null && !imgpath.trim().isEmpty()) {           
		            MimeBodyPart imagePart = new MimeBodyPart();
		            imagePart.setHeader("Content-ID", "<logoimg>");
		            imagePart.setDisposition(MimeBodyPart.INLINE); 
		            imagePart.attachFile(new File(imgpath));
		            multiParte.addBodyPart(imagePart); 
		        }
		        
		        if(imgpath2!=null && !imgpath2.trim().isEmpty()) {           
		            MimeBodyPart imagePart = new MimeBodyPart();
		            imagePart.setHeader("Content-ID", "<juegosimg>");
		            imagePart.setDisposition(MimeBodyPart.INLINE); 
		            imagePart.attachFile(new File(imgpath2));
		            multiParte.addBodyPart(imagePart); 
		        }
		        
		        MimeMessage msg = new MimeMessage(session);
				InternetAddress[] ccaddress = InternetAddress.parse(mailTarget);
				
				/*Message msg = new MimeMessage(session);
				InternetAddress[] ccaddress = InternetAddress.parse(mailTarget);*/
				
				if (mailSource!=null && !mailSource.equals("")) {
					InternetAddress from = new InternetAddress(mailSource,"LA TINKA");
			        msg.setFrom(from);
				} else {
					System.out.println("mailSource="+mailSource);
				}
				
				
				msg.setRecipients(Message.RecipientType.TO,ccaddress);
				msg.setSubject(mailSubject);
				//msg.setContent(mailBody, contentType);
				msg.setContent(multiParte, contentType);
				Transport.send(msg);
			}
	
}
