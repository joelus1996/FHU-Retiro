package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.bean.Client;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutClient;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.layer.model.pojo.GanagolSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaChChSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.ConnectionFactory;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */
@Component("beanProcedureDao")
public class ProcedureDaoImpl extends HibernateDaoSupport implements ProcedureDao {

    //protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;

    @Autowired
    public ProcedureDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
        ////logger.debug("Entrando a " + this.getClass().getName() + ".ProcedureDaoImpl");
        this.setHibernateTemplate(hibernateTemplate);
    }

    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getClientPlayCoupon(Integer id) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("cid= "+id+" getClientPlayCoupon");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getClientPlayCoupon(?,?)");
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(2);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid= "+id+" getClientPlayCoupon");
        }
        return result;
    }
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getClientRetailPlayCoupon(Integer id) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("cid= "+id+" getClientRetailPlayCoupon");
        try {
        	conexion = ConnectionFactory.getConnectionBDTrans();
            cstmt = conexion.prepareCall("call RETAIL.CLIENTPRO.GETCLIENTPLAYCOUPON(?,?)");
            cstmt.setInt(2, id);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid= "+id+" getClientRetailPlayCoupon");
        }
        return result;
    }    
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getClientPlayCouponPP(Integer id, Integer ticket) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("cid= "+id+" getClientPlayCouponPP");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getClientPlayCouponPP(?,?,?)");
            cstmt.setInt(1, id);
            cstmt.setInt(2, ticket);
            cstmt.registerOutParameter(3, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(3);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid= "+id+" getClientPlayCouponPP");
        }
        return result;
    }

    @Transactional(readOnly = false)
    public HashMap<String, Object> getPendingPrizeByTicketid(Integer gameid, Integer ticketid) throws Exception {
        // System.out.println("gameid="+gameid+" ticketid="+ticketid);
        // HashMap[] result = null;
        HashMap<String, Object> result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
       LoggerApi.Log.info("");
        LoggerApi.Log.info("getPendingPrizeByTicketid gameid="+gameid+" ticketid="+ticketid);
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getPendingPrizeByTicketid(?,?,?)");
            cstmt.setInt(1, gameid);
            cstmt.setInt(2, ticketid);
            cstmt.registerOutParameter(3, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(3);
            ResultSetMetaData rsm = rs.getMetaData();
            while (rs.next()) {
                result = new HashMap<String, Object>();
                for (int i = 1; i <= rsm.getColumnCount(); i++)
                    result.put(rsm.getColumnName(i), rs.getObject(i));
                // System.out.println("column="+rsm.getColumnName(i)+" object="+rs.getObject(i));
            }
            // result = getHashMaps(rs);
            
        } catch (Exception e) {
           LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getPendingPrizeByTicketid gameid="+gameid+" ticketid="+ticketid);
        }
        return result;
    }
    
    // @jmoran 2019-06-24 - inicio
    @Transactional(readOnly = false)
    public HashMap<String, Object> getTicketById(Integer gameid, Integer ticketid) throws Exception {
        // System.out.println("gameid="+gameid+" ticketid="+ticketid);
        // HashMap[] result = null;
        HashMap<String, Object> result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
       LoggerApi.Log.info("");
        LoggerApi.Log.info("getPendingPrizeByTicketid gameid="+gameid+" ticketid="+ticketid);
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getTicketByid(?,?,?)");
            cstmt.setInt(1, gameid);
            cstmt.setInt(2, ticketid);
            cstmt.registerOutParameter(3, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(3);
            ResultSetMetaData rsm = rs.getMetaData();
            while (rs.next()) {
                result = new HashMap<String, Object>();
                for (int i = 1; i <= rsm.getColumnCount(); i++)
                    result.put(rsm.getColumnName(i), rs.getObject(i));
                // System.out.println("column="+rsm.getColumnName(i)+" object="+rs.getObject(i));
            }
            // result = getHashMaps(rs);
            
        } catch (Exception e) {
           LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getPendingPrizeByTicketid gameid="+gameid+" ticketid="+ticketid);
        }
        return result;
    }
    // @jmoran 2019-06-24 - fin

    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getPendingPrize(Integer id) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("cid="+id+" getPendingPrize");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getPendingPrize_pp2(?,?)");
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(2);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
        	e.printStackTrace();
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid="+id+" getPendingPrize");
            
            try {
    			for (HashMap hashMap : result) {
					System.out.println("client_price_show_information getPendingPrize hashMap "+hashMap.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
            
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getNumberConsecutiveTinkamegabol() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getNumberConsecutiveTinkamegabol");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getNumberConsecutiveTinkaMega(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getNumberConsecutiveTinkamegabol");
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getNumberConsecutiveGanadiario() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getNumberConsecutiveGanadiario");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getNumberConsecutiveGanadiario(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getNumberConsecutiveGanadiario");
        }
        return result;
    }

   @SuppressWarnings({ "rawtypes", "unchecked" })
    @Transactional(readOnly = true)
    public Map registerUser(Map param) throws Exception {
        Map result = new HashMap();
        CallableStatement cstmt = null;
        Connection conexion = null;
        LoggerApi.Log.info("registerUser");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.clientweb.putclient(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cstmt.setString(1, MapUtils.getString(param, "name", StringUtils.EMPTY));
            cstmt.setString(2, MapUtils.getString(param, "lastname", StringUtils.EMPTY));
            cstmt.setString(3, MapUtils.getString(param, "maidenname", StringUtils.EMPTY));
            cstmt.setString(4, MapUtils.getString(param, "birth", StringUtils.EMPTY));
            cstmt.setString(5, MapUtils.getString(param, "typeid", StringUtils.EMPTY));
            cstmt.setString(6, MapUtils.getString(param, "numberid", StringUtils.EMPTY));
            cstmt.setString(7, MapUtils.getString(param, "nickname", StringUtils.EMPTY));
            cstmt.setString(8, MapUtils.getString(param, "gender", StringUtils.EMPTY));
            cstmt.setString(9, MapUtils.getString(param, "marital", StringUtils.EMPTY));
            cstmt.setString(10, MapUtils.getString(param, "user", StringUtils.EMPTY));
            cstmt.setString(11, MapUtils.getString(param, "email1", StringUtils.EMPTY));
            cstmt.setString(12, MapUtils.getString(param, "email2", StringUtils.EMPTY));
            cstmt.setString(13, MapUtils.getString(param, "conf", "N"));
            cstmt.setString(14, MapUtils.getString(param, "password", StringUtils.EMPTY));
            cstmt.setString(15, MapUtils.getString(param, "country", StringUtils.EMPTY));
            cstmt.setString(16, MapUtils.getString(param, "region", StringUtils.EMPTY));
            cstmt.setString(17, MapUtils.getString(param, "address", StringUtils.EMPTY));
            cstmt.setInt(18, MapUtils.getInteger(param, "terms", 1));
            cstmt.setString(19, MapUtils.getString(param, "luckyN", StringUtils.EMPTY));
            cstmt.setString(20, MapUtils.getString(param, "luckyN00", StringUtils.EMPTY));
            cstmt.setString(21, MapUtils.getString(param, "comtypeid", StringUtils.EMPTY));
            cstmt.setString(22, MapUtils.getString(param, "comnumberid", StringUtils.EMPTY));
            cstmt.setString(23, MapUtils.getString(param, "comname", StringUtils.EMPTY));
            cstmt.setString(24, MapUtils.getString(param, "comphones", StringUtils.EMPTY));
            cstmt.setString(25, MapUtils.getString(param, "comcountry", StringUtils.EMPTY));
            cstmt.setString(26, MapUtils.getString(param, "comregion", StringUtils.EMPTY));
            cstmt.setString(27, MapUtils.getString(param, "comaddress", StringUtils.EMPTY));
            cstmt.setInt(28, MapUtils.getInteger(param, "mode", 0));
            cstmt.registerOutParameter(29, OracleTypes.NUMBER); // p_clientid
            cstmt.registerOutParameter(30, OracleTypes.NUMBER); // p_state
            cstmt.execute();
            result.put("clientid", cstmt.getString(29));
            result.put("state", cstmt.getInt(30));
            //LoggerApi.Log.info("Salir al clase: ProcedureDaoImpl.");
            //LoggerApi.Log.info("Salir al metodo: registerUser. Estado : Satisfactorio");
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("registerUser");
        }
        return result;
    }
   
   @SuppressWarnings("unchecked")
   @Transactional(readOnly = false)
   public ClientProcedurePutClient findPutclient(Object[] values) throws Exception {
       LoggerApi.Log.info("findPutclient p_nombre=" + values[0] + " p_appaterno=" + values[1] + " p_apmaterno=" + values[2]
    		   + " p_birthdate=" + values[3] + " p_typeid=" + values[4] + " p_numberid=" + values[5] + " p_nickname=" + values[6]
               + " p_gender=" + values[7] + " p_marital=" + values[8] + " p_user=" + values[9] + " p_mail1=" + values[10]
               + " p_mail2=" + values[11] + " p_confirm=" + values[12] + " p_password=*** p_country=" + values[14]
               + " p_region=" + values[15] + " p_address=" + values[16] + " p_terms=" + values[17]+ " p_pnumbers=" + values[18]
               + " p_pnumbers00=" + values[19] + " p_comtypeid=" + values[20] + " p_comnumberid=" + values[21] + " p_comname="+ values[22]
               + " p_comphones=" + values[23] + " p_comcountry=" + values[24]+ " p_comregion="+ values[25] + " p_comaddress=" + values[26]
               + " p_mode=" + values[27]  + " p_fixed_phone=" + values[28]+ " p_mobile_phone=" + values[29]);
       List<ClientProcedurePutClient> resultQuery = new ArrayList<ClientProcedurePutClient>();
       ClientProcedurePutClient objectDomain = new ClientProcedurePutClient();
       try {
           resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_PUTCLIENT", values);
           objectDomain = DataAccessUtils.uniqueResult(resultQuery);
       } catch (Exception e) {
           LoggerApi.severe(e);
           throw e;
       } finally {
           if (objectDomain != null)
               LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() 
                       + " p_message=" + objectDomain.getMessage()+" findPutclient");
       }
       return objectDomain;
   }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Transactional(readOnly = false)
    public HashMap[] getHashMaps(ResultSet rs) throws java.sql.SQLException {
        HashMap[] result = null;
        Vector listado = new Vector();
        ResultSetMetaData rsm = rs.getMetaData();
        while (rs.next()) {
            HashMap ht = new HashMap();
            for (int i = 1; i <= rsm.getColumnCount(); i++)
                ht.put(rsm.getColumnName(i), rs.getObject(i));
            listado.add(ht);
        }
        result = new HashMap[listado.size()];
        result = (HashMap[]) listado.toArray(result);
        return result;
    }

    /*public GanadiarioSale findProcedureGanadiarioBetData() throws Exception {
        LoggerApi.Log.info("");
        Dbms dbms = new Dbms();
		ResultSet rs = null;
	    GanadiarioSale ganadiarioSale=null;
        try {
        	dbms.setProcedure("LOTOCARD.LOTTOMOBILE.BET_DATA_GANADIARIO(?)");
        	dbms.registerOutParameter(1, OracleTypes.CURSOR);
        	dbms.executeProcedure();
			rs = dbms.getObjectRS(1);
			
            if (rs.next()) {
                ganadiarioSale = new GanadiarioSale();
                ganadiarioSale.setActiveDraw(rs.getInt("w_active_draw"));
                ganadiarioSale.setCloseDate(rs.getDate("w_close_date"));
                ganadiarioSale.setCloseHour(rs.getString("w_close_hour").toLowerCase());
                ganadiarioSale.setMessage(rs.getString("w_message"));
                ganadiarioSale.setNextDraw(rs.getInt("w_next_draw"));
                ganadiarioSale.setNumberMore(rs.getString("w_numbers_more"));
                ganadiarioSale.setNumbersLess(rs.getString("w_numbers_less"));
                ganadiarioSale.setOpenDate(rs.getDate("w_open_date"));
                ganadiarioSale.setOpenHour(rs.getString("w_open_hour").toLowerCase());
                ganadiarioSale.setPriceMessage(rs.getString("w_price_message"));
                ganadiarioSale.setPriceType(rs.getString("w_price_type"));
                ganadiarioSale.setPrize(rs.getString("w_prize"));
                ganadiarioSale.setPromotionType(rs.getString("w_promotion_type"));
                ganadiarioSale.setSimpleBetPrice(rs.getDouble("w_simple_bet_price"));
                ganadiarioSale.setStatus(rs.getString("w_status"));
                ganadiarioSale.setAlgorithm(rs.getString("w_algorithm"));
                ganadiarioSale.setBets(rs.getDouble("w_bets"));
                ganadiarioSale.setPay(rs.getDouble("w_pay"));
                ganadiarioSale.setDraws(rs.getDouble("w_draws"));
                ganadiarioSale.setCost(rs.getDouble("w_cost"));
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            try {if (dbms != null) dbms.close(); } catch (Exception e) {}
            try {if (rs != null) rs.close(); } catch (Exception e) {}
            LoggerApi.Log.info("ganadiarioSale="+ganadiarioSale);
        }
        return ganadiarioSale;
    }*/

    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getNumberConsecutiveTinka() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getNumberConsecutiveTinka");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getNumberConsecutiveTinka(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            if(cstmt!=null){
             rs = (ResultSet) cstmt.getObject(1);	
             result = getHashMaps(rs);
            }
          
        } catch (Exception e) {
            
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getNumberConsecutiveTinka");
        }
        return result;
    }
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getNumberConsecutiveKabala() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getNumberConsecutiveKabala");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getNumberConsecutiveKabala(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            if(cstmt!=null){
             rs = (ResultSet) cstmt.getObject(1);	
             result = getHashMaps(rs);
            }
          
        } catch (Exception e) {
            
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getNumberConsecutiveKabala");
        }
        return result;
    }

    /*public KabalaSale findProcedureKabalaBetData() throws Exception {
    	LoggerApi.Log.info("findProcedureKabalaBetData"); 
        KabalaSale kabalaSale = null;
        Dbms dbms = new Dbms();
		ResultSet rs = null;
        try {
        	dbms.setProcedure("LOTOCARD.LOTTOMOBILE.BET_DATA_KABALA(?)");
        	dbms.registerOutParameter(1, OracleTypes.CURSOR);
        	dbms.executeProcedure();

			rs = dbms.getObjectRS(1);
            if (rs.next()) {
                kabalaSale = new KabalaSale();
                kabalaSale.setActiveDraw(rs.getInt("w_active_draw"));
                kabalaSale.setCloseDate(rs.getDate(6)); // "w_close_date"
                kabalaSale.setCloseHour(rs.getString("w_close_hour").toLowerCase());
                kabalaSale.setMessage(rs.getString("w_message"));
                kabalaSale.setNextDraw(rs.getInt("w_next_draw"));
                kabalaSale.setNumberMore(rs.getString("w_numbers_more"));
                kabalaSale.setNumbersLess(rs.getString("w_numbers_less"));
                kabalaSale.setOpenDate(rs.getDate(9)); // "w_open_date"
                kabalaSale.setOpenHour(rs.getString("w_open_hour").toLowerCase());
                kabalaSale.setPriceMessage(rs.getString("w_price_message"));
                kabalaSale.setPriceType(rs.getString("w_price_type"));
                kabalaSale.setPrize(rs.getString("w_prize"));
                kabalaSale.setPromotionType(rs.getString("w_promotion_type"));
                kabalaSale.setSimpleBetPrice(rs.getDouble("w_simple_bet_price"));
                kabalaSale.setStatus(rs.getString("w_status"));
                kabalaSale.setAlgorithm(rs.getString("w_algorithm"));
                kabalaSale.setBets(rs.getDouble("w_bets"));
                kabalaSale.setPay(rs.getDouble("w_pay"));
                kabalaSale.setDraws(rs.getDouble("w_draws"));
                kabalaSale.setCost(rs.getDouble("w_cost"));
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            try {if (dbms != null) dbms.close(); } catch (Exception e) {}
            try {if (rs != null) rs.close(); } catch (Exception e) {}
            LoggerApi.Log.info("kabalaSale="+kabalaSale);
        }
        return kabalaSale;
    }*/
    
    /*public KabalaSale findProcedureKabalaBetDataChCh() throws Exception {
    	LoggerApi.Log.info("findProcedureKabalaBetDataChCh"); 
        KabalaSale kabalaSale = null;
        Dbms dbms = new Dbms();
		ResultSet rs = null;
        try {
        	dbms.setProcedure("LOTOCARD.LOTTOMOBILE.BET_DATA_KABALA_CHCH(?)");
        	dbms.registerOutParameter(1, OracleTypes.CURSOR);
        	dbms.executeProcedure();

			rs = dbms.getObjectRS(1);
            if (rs.next()) {
                kabalaSale = new KabalaSale();
                kabalaSale.setActiveDraw(rs.getInt("w_active_draw"));
                kabalaSale.setCloseDate(rs.getDate(6)); // "w_close_date"
                kabalaSale.setCloseHour(rs.getString("w_close_hour").toLowerCase());
                kabalaSale.setMessage(rs.getString("w_message"));
                kabalaSale.setNextDraw(rs.getInt("w_next_draw"));
                kabalaSale.setNumberMore(rs.getString("w_numbers_more"));
                kabalaSale.setNumbersLess(rs.getString("w_numbers_less"));
                kabalaSale.setOpenDate(rs.getDate(9)); // "w_open_date"
                kabalaSale.setOpenHour(rs.getString("w_open_hour").toLowerCase());
                kabalaSale.setPriceMessage(rs.getString("w_price_message"));
                kabalaSale.setPriceType(rs.getString("w_price_type"));
                kabalaSale.setPrize(rs.getString("w_prize"));
                kabalaSale.setPromotionType(rs.getString("w_promotion_type"));
                kabalaSale.setSimpleBetPrice(rs.getDouble("w_simple_bet_price"));
                kabalaSale.setPrevBetPrice(rs.getDouble("w_prev_bet_price"));
                kabalaSale.setStatus(rs.getString("w_status"));
                kabalaSale.setAlgorithm(rs.getString("w_algorithm"));
                kabalaSale.setBets(rs.getDouble("w_bets"));
                kabalaSale.setPay(rs.getDouble("w_pay"));
                kabalaSale.setDraws(rs.getDouble("w_draws"));
                kabalaSale.setCost(rs.getDouble("w_cost"));
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            try {if (dbms != null) dbms.close(); } catch (Exception e) {}
            try {if (rs != null) rs.close(); } catch (Exception e) {}
            LoggerApi.Log.info("kabalaSale="+kabalaSale);
        }
        return kabalaSale;
    }*/
    
    /*public TinkaSale findProcedureTinkaBetData() throws Exception {
    	LoggerApi.Log.info("findProcedureTinkaBetData"); 
    	TinkaSale tinkaSale = null;
        Dbms dbms = new Dbms();
		ResultSet rs = null;
		SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
        	dbms.setProcedure("LOTOCARD.LOTTOMOBILE.BET_DATA_TINKA(?)");
        	dbms.registerOutParameter(1, OracleTypes.CURSOR);
        	dbms.executeProcedure();

			rs = dbms.getObjectRS(1);
            if (rs.next()) {
            	tinkaSale = new TinkaSale();
            	tinkaSale.setActiveDraw(rs.getInt("w_active_draw"));
            	tinkaSale.setCloseDate((rs.getDate("w_close_date")!=null)?df.format(rs.getDate("w_close_date")):""); // "w_close_date"
            	tinkaSale.setCloseHour(rs.getString("w_close_hour").toLowerCase());
            	tinkaSale.setMessage(rs.getString("w_message"));
            	tinkaSale.setNextDraw(rs.getInt("w_next_draw"));
            	tinkaSale.setLastDraw(rs.getInt("w_last_draw"));
            	tinkaSale.setLastResult(rs.getString("w_result"));
            	tinkaSale.setLastYapa(rs.getString("w_yapa"));
            	tinkaSale.setNumberMore(rs.getString("w_numbers_more"));
            	tinkaSale.setNumbersLess(rs.getString("w_numbers_less"));
            	tinkaSale.setOpenDate(rs.getDate("w_open_date")); // "w_open_date"
            	tinkaSale.setOpenHour(rs.getString("w_open_hour").toLowerCase());
            	tinkaSale.setPriceMessage(rs.getString("w_price_message"));
            	tinkaSale.setPriceType(rs.getString("w_price_type"));
            	tinkaSale.setPrize(rs.getDouble("w_prize"));
            	tinkaSale.setPromotionType(rs.getString("w_promotion_type"));
            	tinkaSale.setSimpleBetPrice(rs.getDouble("w_simple_bet_price"));
            	tinkaSale.setStatus(rs.getString("w_status"));
            	tinkaSale.setAlgorithm(rs.getString("w_algorithm"));
            	tinkaSale.setBets(rs.getDouble("w_bets"));
            	tinkaSale.setPay(rs.getDouble("w_pay"));
            	tinkaSale.setDraws(rs.getDouble("w_draws"));
            	tinkaSale.setCost(rs.getDouble("w_cost"));
            	tinkaSale.setFirstMonths(rs.getInt("w_1st_months"));
            	tinkaSale.setFirstDraws(rs.getInt("w_1st_draws"));
            	tinkaSale.setFirstDiscount(rs.getDouble("w_1st_discount"));
            	tinkaSale.setSecondMonths(rs.getInt("w_2nd_months"));
            	tinkaSale.setSecondDraws(rs.getInt("w_2nd_draws"));
            	tinkaSale.setSecondDiscont(rs.getDouble("w_2nd_discount"));
            	tinkaSale.setThirdMonths(rs.getInt("w_3rd_months"));
            	tinkaSale.setThirdDraws(rs.getInt("w_3rd_draws"));
            	tinkaSale.setThirdDiscount(rs.getDouble("w_3rd_discount"));
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            try {if (dbms != null) dbms.close(); } catch (Exception e) {}
            try {if (rs != null) rs.close(); } catch (Exception e) {}
            LoggerApi.Log.info("tinkaSale="+tinkaSale);
        }
        return tinkaSale;
    }*/
    
    public Client findAccountData(Integer clientId) throws Exception {
    	LoggerApi.Log.info("cid="+clientId+" findAccountData"); 
    	Client client = null;
        Dbms dbms = null;
		ResultSet rs = null;
        try {
        	dbms = new Dbms();
        	dbms.setProcedure("LOTOCARD.LOTTOMOBILE.ACCOUNT_DATA(?, ?)");
        	dbms.registerOutParameter(1, OracleTypes.CURSOR);
        	dbms.setInt(2, clientId);
        	dbms.executeProcedure();

			rs = dbms.getObjectRS(1);
            if (rs.next()) {
            	client = new Client();
            	client.setName(rs.getString("w_client_name"));
            	client.setMailStatus(rs.getString("w_mail_status"));
            	client.setBalanceAmount(rs.getDouble("w_balance_amount"));
            	client.setPromotional(rs.getString("w_promotional"));
            	client.setNumPrizes(rs.getLong("w_num_prizes"));
            	client.setNeoprizeAmount(rs.getDouble("w_neoprize_amount"));
            	client.setKironprizeAmount(rs.getDouble("w_kironprize_amount")); 	           
            }
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            try {
            	if (dbms != null) {
            		dbms.close(); 
            	}
            } catch (Exception e) {
            	System.out.println("<--------------------ProcedureDaoImpl error cerrando conexion------------------->");
				e.printStackTrace();
            }
            try {
            	if (rs != null) {
            		rs.close(); 
            	}
            } catch (Exception e) {
            	System.out.println("<--------------------ProcedureDaoImpl error cerrando conexion------------------->");
				e.printStackTrace();
            }
        	//LoggerApi.Log.info("cid="+clientId+" findAccountData"); 
        }
        return client;
    }

    @SuppressWarnings("unchecked")
	public GanadiarioSale findProcedureGanadiarioBetData(Integer clientId) throws Exception {
		//LoggerApi.Log.info("cid="+clientId+" findProcedureGanadiarioBetData"); 
		
		List<GanadiarioSale> resultQuery = new ArrayList<GanadiarioSale>();
		GanadiarioSale objectDomain = new GanadiarioSale();

		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("GANADIARIOSALE_BET_DATA",values);
			objectDomain = (GanadiarioSale) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("cid="+clientId+" findProcedureGanadiarioBetData ganadiarioSale="+objectDomain);
		}
		
		return objectDomain;
	}
    
    @SuppressWarnings("unchecked")
	public KabalaSale findProcedureKabalaBetData(Integer clientId) throws Exception {
		//LoggerApi.Log.info("cid="+clientId+" findProcedureKabalaBetData"); 
		
		List<KabalaSale> resultQuery = new ArrayList<KabalaSale>();
		KabalaSale objectDomain = new KabalaSale();

		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("KABALASALE_BET_DATA",values);
			objectDomain = (KabalaSale) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("cid="+clientId+" findProcedureKabalaBetData kabalaSale="+objectDomain);
		}
		
		return objectDomain;
	}
    
    @SuppressWarnings("unchecked")
	public KabalaChChSale findProcedureKabalaBetDataChCh(Integer clientId) throws Exception {
		//LoggerApi.Log.info("cid="+clientId+" findProcedureKabalaBetDataChCh"); 
		
		List<KabalaChChSale> resultQuery = new ArrayList<KabalaChChSale>();
		KabalaChChSale objectDomain = new KabalaChChSale();

		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("KABALACHCHSALE_BET_DATA",values);
			objectDomain = (KabalaChChSale) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("cid="+clientId+" findProcedureKabalaBetDataChCh kabalaChChSale="+objectDomain);
		}
		
		return objectDomain;
	}
    
    @SuppressWarnings("unchecked")
	public TinkaSale findProcedureTinkaBetData(Integer clientId) throws Exception {
		//LoggerApi.Log.info("cid="+clientId+" findProcedureTinkaBetData"); 
		
		List<TinkaSale> resultQuery = new ArrayList<TinkaSale>();
		TinkaSale objectDomain = new TinkaSale();

		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("TINKASALE_BET_DATA",values);
			objectDomain = (TinkaSale) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("cid="+clientId+" findProcedureTinkaBetData tinkaSale="+objectDomain);
		}
		
		return objectDomain;
	}
    
	@SuppressWarnings("unchecked")
	public GanagolSale findProcedureGanagolBetData(Integer clientId) throws Exception {
		//LoggerApi.Log.info("cid="+clientId+" findProcedureGanagolBetData"); 
		
		List<GanagolSale> resultQuery = new ArrayList<GanagolSale>();
		GanagolSale objectDomain = new GanagolSale();

		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("GANAGOLSALE_BET_DATA",values);
			objectDomain = (GanagolSale) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("cid="+clientId+" findProcedureGanagolBetData ganagolSale="+objectDomain);
		}
		
		return objectDomain;
	}
	
	public String[] findTinkaNextDraw() 
	throws Exception {
		LoggerApi.Log.info("findTinkaNextDraw"); 
		String[] resultQuery = new String[3];
		String sql = 
			" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
			"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
			"          , draw_id " + 
			"          from lotocard.draw " + 
			"          where game_id = 41 " + 
			"          and draw_id = " + 
			"		          (select min(draw_id) from lotocard.draw where game_id = 41 and  draw_id > " + 
			"		             (select max(draw_id) from lotocard.draw where game_id = 41 and dr_draw_flag=1 ))";
		Dbms rs = null;
		try {
			rs = new Dbms(sql);
			rs.executeQuery();
			if (rs.next()) {
				resultQuery[0] = rs.getString("fecha");
				resultQuery[1] = rs.getString("pozo");
				resultQuery[2] = rs.getString("draw_id");
			}
		} finally {
			try {
				if(rs!=null) {
					System.out.println("<--------------------ProcedureDaoImpl.findTinkaNextDraw cerrando conexion------------------->");
					 rs.close();
				}
			} catch (Exception e) {
				System.out.println("<--------------------ProcedureDaoImpl.findTinkaNextDraw error cerrando conexion------------------->");
				e.printStackTrace();
			}
		}
		LoggerApi.Log.info("findTinkaNextDraw"); 
		
		return resultQuery;
	}
	
	public String[] findKabalaNextDraw() 
			throws Exception {
				LoggerApi.Log.info("findKabalaNextDraw");
				String[] resultQuery = new String[3];
				String sql = 
					" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
					"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
					"          , draw_id " + 
					"          from lotocard.draw " + 
					"          where game_id = 42 " + 
					"          and draw_id = " + 
					"		          (select min(draw_id) from lotocard.draw where game_id = 42 and  draw_id > " + 
					"		             (select max(draw_id) from lotocard.draw where game_id = 42 and dr_draw_flag=1 ))";
				
				Dbms rs = null;
				try {
					rs = new Dbms(sql);
					rs.executeQuery();
					if (rs.next()) {
						resultQuery[0] = rs.getString("fecha");
						resultQuery[1] = rs.getString("pozo");
						resultQuery[2] = rs.getString("draw_id");
					}
				} finally {
					try {
						if(rs!=null) {
							System.out.println("<--------------------ProcedureDaoImpl.findKabalaNextDraw cerrando conexion------------------->");
							 rs.close();
						}
					} catch (Exception e) {
						System.out.println("<--------------------ProcedureDaoImpl.findKabalaNextDraw error cerrando conexion------------------->");
						e.printStackTrace();
					}
				}
				LoggerApi.Log.info("findKabalaNextDraw"); 
				
				return resultQuery;
			}

	public String[] findGanadiarioNextDraw() 
			throws Exception {
				LoggerApi.Log.info("findGanadiarioNextDraw"); 
				String[] resultQuery = new String[3];
				String sql = 
					" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
					"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
					"          , draw_id " + 
					"          from lotocard.draw " + 
					"          where game_id = 164 " + 
					"          and draw_id = " + 
					"		          (select min(draw_id) from lotocard.draw where game_id = 164 and  draw_id > " + 
					"		             (select max(draw_id) from lotocard.draw where game_id = 164 and dr_draw_flag=1 ))";
				
				Dbms rs = null;
				try {
					rs = new Dbms(sql);
					rs.executeQuery();
					if (rs.next()) {
						resultQuery[0] = rs.getString("fecha");
						resultQuery[1] = rs.getString("pozo");
						resultQuery[2] = rs.getString("draw_id");
					}
				} finally {
					try {
						if(rs!=null) {
							System.out.println("<--------------------ProcedureDaoImpl.findGanadiarioNextDraw cerrando conexion------------------->");
							 rs.close();
						}
					} catch (Exception e) {
						System.out.println("<--------------------ProcedureDaoImpl.findGanadiarioNextDraw error cerrando conexion------------------->");
						e.printStackTrace();
					}
				}
				LoggerApi.Log.info("findGanadiarioNextDraw");
				
				return resultQuery;
			}
	
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getClientPlayCouponFilter(Integer id, String start_date,
			String end_date) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("cid= "+id+" getClientPlayCouponFilter");
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getClientPlayCouponFilter(?,?,?,?)");
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.setString(3, start_date);
            cstmt.setString(4, end_date);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(2);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid= "+id+" getClientPlayCouponFilter");
        }
        return result;
    }
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getTicketDetailRetail(Integer p_clientId, Integer gameId, String ticket) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getclientticket_retail p_clientId= "+p_clientId+ " gameId=" + gameId  +" ticket="+ticket);
        try {
        	conexion = ConnectionFactory.getConnectionBDTrans();
            cstmt = conexion.prepareCall("call RETAIL.CLIENTPRO.GETTICKETDETAILMOBILE(?,?,?,?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setInt(2, p_clientId);
            cstmt.setInt(3, gameId);
            cstmt.setString(4, ticket);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getclientticket_retail p_clientId= "+p_clientId+ " gameId=" + gameId  +" ticket="+ticket);
        }
        return result;
    }
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getTicketDetailRetailGrecia(Integer p_programa, Integer p_cpn) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("p_programa= "+p_programa+" p_cpn=" +p_cpn);
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.getclientticket_retailgrecia(?,?,?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setInt(2, p_programa);
            cstmt.setInt(3, p_cpn);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("p_programa= "+p_programa+" p_cpn=" +p_cpn);
        }
        return result;
    }
    
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getClientPlayRetailCouponFilter(Integer id, String start_date,
			String end_date) throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        LoggerApi.Log.info("getClientPlayRetailCouponFilter" + "cid= "+id + "start_date="+start_date + "end_date="+end_date);
        try {
        	conexion = ConnectionFactory.getConnectionBDTrans();
            cstmt = conexion.prepareCall("call RETAIL.CLIENTPRO.GETCLIENTPLAYCOUPONFILTER(?,?,?,?)");
            cstmt.setInt(2, id);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(3, start_date);
            cstmt.setString(4, end_date);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
           
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getClientPlayRetailCouponFilter" + "cid= "+id + "start_date="+start_date + "end_date="+end_date);
        }
        return result;
    }
}