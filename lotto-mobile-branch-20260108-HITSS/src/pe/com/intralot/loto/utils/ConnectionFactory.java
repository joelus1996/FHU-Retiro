package pe.com.intralot.loto.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author:   Cristian Cortez
 * @rol:	  Analista en Desarrollo de Sistemas
 * @proyecto: lotto-promotora
 *
 */

public class ConnectionFactory {
 
	private static final int DATASOURCE_LOOKUP = 1; 
	private static int connectionMode = DATASOURCE_LOOKUP;
	private static String ORACLE_DS = "lottomobileDS";
	private static String ORACLE_DS_BDTRANS = "lottobdtransDS";
	public static String context = "lapollaapi";
	// private static BasicDataSource dataSource = setupDataSource();

	public ConnectionFactory() {}
	
    public static Connection getConnection() throws NamingException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection conn = null;
		if ( connectionMode == DATASOURCE_LOOKUP) {
			try {
				ic = new InitialContext();	
				ds = (DataSource)ic.lookup("java:/"+ORACLE_DS);
				conn = ds.getConnection();
				conn.setAutoCommit (false); 
				connectionMode = DATASOURCE_LOOKUP;
			} catch (SQLException sqle) {
				System.out.println("Error obteniendo la conexion en ConnectionFactory: " +sqle.getMessage());
			}			
		} 
		return conn;
	}
    
    public static Connection getConnectionBDTrans() throws NamingException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection conn = null;
		if ( connectionMode == DATASOURCE_LOOKUP) {
			try {
				ic = new InitialContext();	
				ds = (DataSource)ic.lookup("java:/"+ORACLE_DS_BDTRANS);
				conn = ds.getConnection();
				conn.setAutoCommit (false); 
				connectionMode = DATASOURCE_LOOKUP;
			} catch (SQLException sqle) {
				System.out.println("Error obteniendo la conexion en ConnectionFactory: " +sqle.getMessage());
			}			
		} 
		return conn;
	}
	
	public static String operationProperty(String property) {
		java.util.Properties properties = new java.util.Properties();
		String sep = System.getProperty("file.separator");
    	String path = System.getProperty("java.home")+sep+"setup"+sep;
    	InputStream inputStream = null;
		String file=path+context.toLowerCase()+".properties";
		try {
			inputStream = new FileInputStream(file);
			//load the inputStream using the Properties
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//get the value of the property
		String ret = properties.getProperty(property);

		if (ret==null) {
			System.out.println("[][][][] Parametro '"+property+"' falta en "+file+" !!!");
			ret="";
		} else {
			ret = ret.trim();
		}
		return ret;
	}

	 
    public static boolean isDevelopment() {
    	return ConnectionFactory.operationProperty("applicationArea").equals("development");
    }
	
}
