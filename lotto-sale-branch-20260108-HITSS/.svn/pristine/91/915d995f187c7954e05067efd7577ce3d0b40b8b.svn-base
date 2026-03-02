package pe.com.intralot.loto.util;

import java.io.*;

/**<p> NAME:    FileLib.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    25/11/2016  First comment
 * </pre>
 * </p>
 */

public class FileLib {
	
	public static final String PATH = "java.home";
	public static String lineSeparator = System.getProperty("line.separator");
		  
	public static void addStringToFile(String fileName, String data ) 
	throws Exception {
		
		FileOutputStream fos = null;
		DataOutputStream out = null;
		
		try {
			  fos = new FileOutputStream(fileName,true);
			  out = new DataOutputStream(fos);
			  out.writeBytes(data);
			  out.writeBytes(lineSeparator);
			  out.flush();
			  FileDescriptor fd = fos.getFD();
			  fd.sync();			  
		} catch (IOException ioe) {
			throw ioe;
		} finally {  // always close the file
			if (fos != null) try { fos.close(); } catch (IOException ioe2) { } // just ignore it
			if (out != null) try { out.close(); } catch (IOException ioe3) { } // just ignore it
			
		} // end try/catch/finally

   }   
   
   public static StringBuffer readFileToString(String file)
   throws Exception 
   {
	   String dirFile = file.trim() ;
	   
	   BufferedReader fileBuffer = null;
	   StringBuffer fileSource = null;
	   
	   try {

		   fileBuffer = new BufferedReader( new FileReader(dirFile) );

	       String lineFile;
	       
	       fileSource = new StringBuffer();
	   
	       while ((lineFile = fileBuffer.readLine()) != null)
	    	   fileSource.append( lineFile + lineSeparator );
	       
	   } finally {
	       if (fileBuffer!=null) fileBuffer.close();
	   }

       return fileSource;
   } 
   
   public static byte[] readBinaryFile (String file, int size)
   throws Exception
	  {
	   byte [] array = new byte[size];

	   String dirFile = file.trim() ; 

	   FileInputStream fileInput = null;
	   BufferedInputStream bufferedInput = null;

	   try {

		   // open file
		   fileInput = new FileInputStream(dirFile);
		   bufferedInput = new BufferedInputStream(fileInput);

		   // read array
		   bufferedInput.read(array);

	   } finally {
		   // close file
		   if (bufferedInput!=null) bufferedInput.close();
		   if (fileInput!=null) fileInput.close();
	   }

	   return array;
	  }
   
   public static void  runShell(String cmd) {
	   
	   try {
			// String cmd = "ls -l"; // this is the command to execute in the Unix shell
			// create a process for the shell
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
			pb.redirectErrorStream(true); // use this to capture messages sent to stderr
			Process shell = pb.start();
			InputStream shellIn = shell.getInputStream(); // this captures the output from the command
			int shellExitStatus = shell.waitFor(); // wait for the shell to finish and get the return code
			// at this point you can process the output issued by the command
			// for instance, this reads the output and writes it to System.out:
			System.out.println("cmd="+cmd+" shellExitStatus="+shellExitStatus);
			int c;
			while ((c = shellIn.read()) != -1) {System.out.write(c);}
			// close the stream
			try {shellIn.close();} catch (IOException ignoreMe) {}
	   } catch (Exception e) {
            e.printStackTrace(System.out);	   
	   }
		
		
   }

}	  
 
