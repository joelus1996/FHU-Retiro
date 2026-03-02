package pe.com.intralot.loto.utils;

import java.sql.*;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.naming.InitialContext; 


/**<p> NAME:    Dbms.java         
 * </p>
 * <p> VERSION LOG
 * 
 * Examples
 * 
 * 1. Dbms rs = new Dbms("select .. where column = ? ");
 *    rs.setString(1,"value");
 *    rs.executeQuery();
 *    rs.close();
 *    
 * 2. Dbms rs = new Dbms("update .. where column = ? ");
 *    rs.setString(1,"value");
 *    rs.executeUpdate();
 *    
 * 3. Dbms rs = new Dbms("insert .. values (?) ");
 *    rs.setString(1,"value");
 *    rs.executeInsert();
 *    rs.close();
 *    
 * 4. Dbms rs = new Dbms("delete .. where column = ? ");
 *    rs.setString(1,"value");
 *    rs.executeDelete();
 *    rs.close();
 *    
 * 5. Dbms rs = new Dbms("owner.procedure (?,?) ");
 *    rs.setString(1,"value");
 *    rs.registerOutParameter(2,java.sql.Types.VARCHAR);
 *    rs.executeProcedure();
 *    String output = rs.getString(2);
 *    rs.close();
 * 
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    28/12/2007  Oracle Library
 * </pre>
 * </p>
 */

public class Dbms extends Object {

	protected  Connection   		con   = null;
	protected  ResultSet    		rs    = null;
	protected  PreparedStatement	pstmt = null;
	protected  CallableStatement    cstmt = null;
	protected  String				sql;
	protected  StringBuffer         parameters = new StringBuffer();
	protected  StringBuffer         output = new StringBuffer();
	protected  int 				    columnCount = 0;
	protected  int  				row         = 0;
	protected  int				    numRows     = 0;
	protected  boolean              isProcedure = false;
	protected  boolean              isError     = false;   
	protected  long                 startTime;

	public final static int SPRING_SQLSERVER = 1; 
	public final static int KIRON_MYSQL = 2; 
	
	public Dbms() throws Exception {
		this.con = ConnectionFactory.getConnection();
		con.setAutoCommit(false);
		//this.con = ConnectionFactory.getBasicDataSource().getConnection();
		//Logger.getLogger(ConnectionFactory.getProperties().getLibLogger()).finer(this.getDataSourceStatus());

	}

	public Dbms(int database) 
	throws Exception 
	{ 
		if (database==SPRING_SQLSERVER) {
			this.con = null; // ConnectionFactory.getConnectionSqlServer("CARD-SMS");
		}
		if (database==KIRON_MYSQL) {
			InitialContext ic = null;
		}
	} 
	
	public Dbms(String newSql) 
	throws Exception 
	{ 
		this();
		startSql(newSql);
	}
	
	public Dbms(String driver, String url, String usuario, String password) 
	throws Exception
	{	  	
	    Class.forName(driver).newInstance();
	    this.con = (Connection) DriverManager.getConnection(url,usuario,password);           	     
	}   

	public static boolean isClosed() {
		//long startTime = System.currentTimeMillis();
		boolean closed = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();	//ConnectionFactory.getBasicDataSource().getConnection();	
			pstmt = con.prepareStatement("select 1 from dual");
			try { if (rs!=null ) rs.close(); } catch (SQLException sqle) {}
			rs = pstmt.executeQuery();
			if (rs.next()) closed = false;				
		} catch (Exception e) {
			closed = true;
			try {
				LoggerApi.severe( e, "Test Database", "isClosed()");
			} catch (Exception e1) {
				MailLib.sendErrorMail (e1,"isClosed()","");
			}
		} finally {
			if (rs != null) {try {rs.close();}catch (Exception ex) {}}
			if (pstmt != null) {try {pstmt.close();}catch (Exception ex) {}}
			if (con != null) {try {con.close();}catch (Exception ex) {}}
		}
		//System.out.println( (System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
		return closed;
	}
	
	public ResultSet getResultSet() {
		return rs;
	}
	public void startSql(String newSql) 
	throws Exception {
		try {
			
			this.sql = newSql.trim();
			
			int param = this.sql.indexOf("?");
			
			if (this.sql.toUpperCase().startsWith("SELECT")) {
				if (param<=0) executeQuery(this.sql);
				else setSql(sql);
				isProcedure = false;
			}
			else if (this.sql.toUpperCase().startsWith("UPDATE")) {
				if (param<=0) executeUpdate(this.sql);
				else setSql(sql);
				isProcedure = false;
			} 
			else if (this.sql.toUpperCase().startsWith("INSERT")) {
				if (param<=0) executeUpdate(this.sql);
				else setSql(sql);
				isProcedure = false;
			}
			else if (this.sql.toUpperCase().startsWith("DELETE")) {
				if (param<=0) executeUpdate(this.sql);
				else setSql(sql);
				isProcedure = false;
			}
			else  {
				if (param<=0) executeProcedure(this.sql);
				else setProcedure(sql);
				isProcedure = true;
			}
		}
		catch (SQLException ex) {
			throw (new SQLException(this.sql + "\n" + ex.getMessage()));
		}
	}
	
	public String toString() {
		
		String output = "";
		try {
			output = "UserName = " + this.con.getMetaData().getUserName()+
	                 "\nURL = " + this.con.getMetaData().getURL()+			
			         "\nDatabaseProductVersion = " + this.con.getMetaData().getDatabaseProductVersion();
		}
		catch (Exception e) {
			try {
				LoggerApi.severe(e);
			} catch (Exception e1) {
				MailLib.sendErrorMail (e1,"toString()","");
			}
		}
		finally { 
			this.close(); 
		}
		return output;
	}

	public void executeQuery() throws SQLException {
		int k=1;
		while (true) {
			try {
				startTime = System.currentTimeMillis();
				try { if (rs!=null) rs.close(); } catch (SQLException sqle) {}
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				this.columnCount = rsmd.getColumnCount();
				break;
			}
			catch (SQLException sqle) {
				k++;
				System.out.println("End of try "+k);
				if (k>10) {
					LoggerApi.severe( sqle, "executeQuery()", getSql() + " \n " + parameters+" \n "+sqle.getMessage());
					System.out.println("ERRORS FOUND!");
					System.exit(0);
				}
			} finally {; }
		}
	}

	public void executeQueryNoLog() throws SQLException {
		try {
			startTime = System.currentTimeMillis();
			try { if (rs!=null) rs.close(); } catch (SQLException sqle) {}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			this.columnCount = rsmd.getColumnCount();
		}
		catch (SQLException sqle) {
			throw (new SQLException(sql + "\n" + sqle.getMessage()));
		} finally {
            ;
		}
	}

	
	public void executeQuery(String sql) throws SQLException {
		setSql(sql);
		executeQuery();
	}

	public void executeUpdate() throws SQLException {
		try {
			Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info(getSql()+"\n"+parameters);
		} catch (Exception e) {
			MailLib.sendErrorMail (e,"executeUpdate()","");
		}

		try {
			startTime = System.currentTimeMillis();
			numRows = pstmt.executeUpdate();
			con.commit(); 
			isError = false;
		}
		catch (SQLException sqle) {
			String e1 = sqle.getMessage();
			String e2 = "";
			try { con.rollback(); } catch (SQLException sqld) { e2 = sqle.getMessage(); }
			isError = true;
			// throw (new SQLException(sql + "\n" +e1+ "\n" +e2 + "\n" +parameters ));
			LoggerApi.severe( sqle, "executeUpdate()", getSql() + "\n" +e1+ "\n" +e2 + "\n" +parameters);
			System.out.println("ERRORS FOUND!");
			System.exit(0);
		}
	}
	
	public void executeUpdateNoLog() {
		try {
			startTime = System.currentTimeMillis();
			numRows = pstmt.executeUpdate();
			con.commit(); 
			isError = false;
		}
		catch (SQLException sqle) {
			//String e1 = sqle.getMessage();
			try { con.rollback(); } catch (SQLException sqld) { }
			isError = true;
			System.out.println( sqle.getMessage());
		}
	}

	public void executeUpdate(String sql) throws SQLException {
		setSql(sql);
		executeUpdate();
	}
	
	public void executeInsert() throws SQLException {
		executeUpdate();
	}
	
	public void executeInsert(String sql) throws SQLException {
		executeUpdate(sql);
	}	
	
	public void executeDelete() throws SQLException {
		executeUpdate();
	}
	
	public void executeDelete(String sql) throws SQLException {
		executeUpdate(sql);
	}
	
	public void setSql(String newSql) throws SQLException {
		this.sql = newSql;
		isProcedure = false;
		try {
			if (pstmt != null)  pstmt.close();
			if (cstmt != null)  cstmt.close();
			pstmt = con.prepareStatement(newSql);
			pstmt.clearParameters();
			parameters.setLength(0);
		}
		catch (SQLException sqle) {
			throw new SQLException(sql + "\n" + sqle.getMessage());
		}
	}
	
	public void executeProcedure() throws SQLException {
		try {
			Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info(getSql()+"\n"+parameters);
		} catch (Exception e) {
			MailLib.sendErrorMail (e,"executeProcedure()","");
		}		
		try {
			startTime = System.currentTimeMillis();
			cstmt.execute();
			con.commit(); 
			isError = false;
		}
		catch (SQLException sqle) {
			String e1 = sqle.getMessage();
			String e2 = "";
			try { con.rollback(); } catch (SQLException sqld) { e2 = sqle.getMessage(); }
			isError = true;
			//throw (new SQLException(sql + "\n" +e1+ "\n" +e2 ));
			LoggerApi.severe( sqle, "executeProcedure()", getSql() + "\n" +e1+ "\n" +e2 + "\n" +parameters);
			System.out.println("ERRORS FOUND!");
			System.exit(0);
		}
	}

	public void executeProcedure(String sql) throws SQLException {
		setProcedure(sql);
		executeProcedure();
	}
	
	public void setProcedure(String newSql) throws SQLException {
		this.sql = newSql;
		isProcedure = true;
		try {
			if (cstmt != null)  cstmt.close();
			if (pstmt != null)  pstmt.close();
			cstmt = con.prepareCall("{call "+sql+"}");
			cstmt.clearParameters();
			parameters.setLength(0);
			output.setLength(0);
		}
		catch (SQLException sqle) {
			throw new SQLException(sql + "\n" + sqle.getMessage());
		}
	}	
	
	public String getSentence() {
		return sql+" "+parameters+" "+output+" row="+row+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ";

	}
	
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {}
		}
		if (pstmt != null) {
			try {
				Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info("Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
			} catch (Exception e) {
				MailLib.sendErrorMail (e,"close()","pstmt");
			}
			try {
				pstmt.close();
				pstmt = null;
			} catch (Exception ex) { }
		}
		if (cstmt != null) {
			try {
				Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info(sql+" "+parameters+" "+output+" Time="+(System.currentTimeMillis()-startTime)/1000.0 +" seconds ");
			} catch (Exception e) {
				MailLib.sendErrorMail (e,"close()","cstmt");
			}			
			try {
				cstmt.close();
				cstmt = null;
			} catch (Exception ex) {}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {}
		}
	}

	public void closeNoLog() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception ex) {}
		}
		if (cstmt != null) {
			try {
				cstmt.close();
			} catch (Exception ex) {}
		} 
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {}
		} 
	}
	
	protected void finalize() {

		if (rs != null) {
			try {
				rs.close();
			}
			catch (Exception ex) {}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			}
			catch (Exception ex) {}
		}
		if (cstmt != null) {
			try {
				cstmt.close();
			}
			catch (Exception ex) {}
		}
		try {
			if (con != null) {
				if (!con.isClosed()) {
					try {
						Logger.getLogger(LoggerApi.LOGGERLAPOLLAAPI).info("finalize! Dbms : "+sql);
						MailLib.sendErrorMail (null,"finalize(Dbms)",sql);
					} catch (Exception e) {}
				}
				try {
					con.close();
				} catch (Exception ex) { }
			}
		}
		catch (Exception e) {}
	}

	public float getFloat(int column) throws SQLException {
		if (isProcedure) {
			float result = cstmt.getFloat(column);
			output.append(column+"="+result+" ");
			return result;
		}
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getFloat(column);
		}
		return 0;
	}

	public double getDouble(int column) throws SQLException {
		if (isProcedure) {
			double result = cstmt.getDouble(column);
			output.append(column+"="+result+" ");
			return result;
		}
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getDouble(column);
		}
		return 0;
	}

	public float getFloat(String column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getFloat(column);
		}
		return 0;
	}

	public double getDouble(String column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getDouble(column);
		}
		return 0;
	}
	
	public int getInt(int column) throws SQLException {

		if (isProcedure) {
			int result = cstmt.getInt(column);
			output.append(column+"="+result+" ");
			return result;
		}
		
		if (rs != null) {
			if (row == 0)
				this.next();
			//return rs.getInt(column);
			Integer ord = new Integer(rs.getInt(column));
			return ord;

		}
		return 0;
	}

	public int getInt(String column) throws SQLException { 
		if (rs != null) {
			if (row == 0)
				this.next(); 
			Integer ord = new Integer(rs.getInt(column));
			return ord;
		}
		return 0;
	}

	public long getLong(int column) throws SQLException {

		if (isProcedure) {
			long result = cstmt.getLong(column);
			output.append(column+"="+result+" ");
			return result;
		}
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getLong(column);
		}
		return 0;
	}

	public long getLong(String column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getLong(column);
		}
		return 0;
	}

	public Timestamp getTimestamp(int column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getTimestamp(column);
		}
		return null;
	}

	public Date getDate(int column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getDate(column);
		}
		return null;
	}

	public Time getTime(int column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getTime(column);
		}
		return null;
	}

	public Connection getCon() throws Exception {
		return this.con; 
	}

	public String[] getResultSetArray() throws SQLException {
		if (rs == null) {
			String[] row = new String[columnCount];
			return row;
		}
		if (row == 0)
			this.next();
		String[] row = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			row[i] = rs.getString(i + 1);
		}
		return row;
	}

	public String getSql() {
		StringTokenizer parToken = new StringTokenizer(parameters.toString(),"\t");
		StringTokenizer sqlToken = new StringTokenizer(sql,"?");
		StringBuffer buf = new StringBuffer();
		while (parToken.hasMoreTokens()) {
			String parSet = parToken.nextToken();
			int p = parSet.indexOf('=');
			
			if (p>=0) parSet = parSet.substring(p+1);
			else break;
			
			String sqlSet = null;
			if (sqlToken.hasMoreTokens()) {
				sqlSet = sqlToken.nextToken();				
			} else {
				break;
			}
			buf.append(sqlSet+parSet);
		}
		while (sqlToken.hasMoreTokens()) {
			buf.append( sqlToken.nextToken() );		
		}
		buf.append(';');
		return buf.toString();
	}

	public String getString(int column) throws SQLException {

		if (isProcedure) {
			String result = cstmt.getString(column);
			output.append(column+"="+result+" ");
			return result;
		}
		
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getString(column);
		}
		return null;
	}

	public String getString(String column) throws SQLException {
		
		if (rs != null) {
			if (row == 0) 
				this.next();
			try {
				String result = rs.getString(column);
			    return result;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	public String getStringNVL(String column) throws SQLException {
		
		if (rs != null) {
			if (row == 0)
				this.next();
			String result = rs.getString(column);
			if ( result == null )    result = "";
			result = result.trim();
			return result;
		}
		return null;
	}

	public String getStringNVL(int column) throws SQLException {
		if (isProcedure) {
			String result = cstmt.getString(column);
			if ( result == null )    result = "";
			result = result.trim();
			output.append(column+"="+result+" ");
			return result;
		}

        if (rs != null) {
			if (row == 0)
				this.next();
			String result = rs.getString(column);
			if ( result == null )    result = "";
			result = result.trim();
			return result;
		}
		return null;
	}

	public String getString(String column, String defaultValue) 
	throws SQLException {
		
		if (rs != null) {
			if (row == 0) {
				this.next();
			}    
			if  (rs.getString(column)==null) {
				return defaultValue;
			}   
			else {
				return rs.getString(column);
			}   
		}
		return defaultValue;
	}
	
	public DateAPI getDate(String column) 
	throws SQLException {
		String date = getString(column,"");
		DateAPI dateApi = null;
		if (!date.equals("")) dateApi = new DateAPI(date, "dd/MM/yyyy HH:mm:ss");
		return dateApi;
	}
	
	public boolean next() throws SQLException {
		try {
			row += 1;
			return (rs.next());
		}
		catch (SQLException ex) {
			throw (new SQLException(sql + "\n" + ex.getMessage()));
		}

	}
	public void setFloat(int i, float parameter) throws SQLException {
		if (pstmt != null) {
			pstmt.setFloat(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
		if (cstmt != null) {
			cstmt.setFloat(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
	}
	public void setDouble(int i, double parameter) throws SQLException {
		if (pstmt != null) {
			pstmt.setDouble(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
		if (cstmt != null) {
			cstmt.setDouble(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
	}
	
	public void setInt(int i, int parameter) throws SQLException {
		if (pstmt != null) {
			pstmt.setInt(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
		if (cstmt != null) {
			cstmt.setInt(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
	}

	public void setLong(int i, long parameter) throws SQLException {
		if (pstmt != null) {
			pstmt.setLong(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
		if (cstmt != null) {
			cstmt.setLong(i, parameter);
			parameters.append(i+"="+parameter+"\t");
		}
	}
	
	public void setString(int i, String parameter) throws SQLException {
		if (pstmt != null) {
			pstmt.setString(i, parameter);		
			parameters.append(i+"='"+parameter+"'\t");
		}
		if (cstmt != null) {
			cstmt.setString(i, parameter);		
			parameters.append(i+"='"+parameter+"'\t");
		}
	}
	
	public void registerOutParameter(int i, int sqlType) throws SQLException {
		cstmt.registerOutParameter(i,sqlType);
	}
	
	public int getNumRows() throws SQLException {
		return numRows;
	}

	public String getObject(int column) throws SQLException {
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getObject(column).toString();
		}
		return null;
	}

	public String getObject(String column) throws SQLException {
		if (rs != null) {
			if (row == 0)
				this.next();
			return rs.getObject(column).toString();
		}
		return null;
	}
	
	public ResultSet getObjectRS(int column) throws SQLException {
		if (isProcedure) {
			ResultSet result = (ResultSet)cstmt.getObject(column);
			output.append(column+"="+result.toString()+" ");
			return result;
		}
		return null;
	}
	
	public ResultSet getObjectRS(String column) throws SQLException {
		if (isProcedure) {
			ResultSet result = (ResultSet)cstmt.getObject(column);
			output.append(column+"="+result.toString()+" ");
			return result;
		}
		return null;
	}
}
