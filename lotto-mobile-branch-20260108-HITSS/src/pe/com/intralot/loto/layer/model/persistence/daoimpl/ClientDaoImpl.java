package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import oracle.jdbc.OracleTypes;
import pe.com.intralot.loto.layer.model.bean.ClientGetCollectionType;
import pe.com.intralot.loto.layer.model.bean.Reclamacion;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetPasswordCode;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductPozoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProductPriceList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetVirtualesProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginBcpRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginLotocardRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginVisaRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureResetNewPassword;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateBonoQr;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientMail;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateNovusId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePlayerId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateSmsRegister;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateVisaSession;
import pe.com.intralot.loto.layer.model.pojo.ClientTutorial;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.pojo.Country;
import pe.com.intralot.loto.layer.model.pojo.CulqiCard;
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.layer.model.pojo.Region;
import pe.com.intralot.loto.layer.model.pojo.UbicacionRedDigital;
import pe.com.intralot.loto.layer.model.pojo.UbicacionTerminal;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;
import pe.com.intralot.loto.lib.StringLib;

/**
 * <p>
 * NOMBRE: ClientDaoImpl.java
 * <br></p>
 * <p>
 * FUNCION: Implementación del objeto de acceso a datos de la cuenta
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Métodos para la activación y rechazo del bono de TA por recargas Interbank
 * 001   Joel Ramirez     06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Component("beanClientDao")
public class ClientDaoImpl extends HibernateDaoSupport implements ClientDao {

	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public ClientDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".ClientDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public Client findByUser(Object params[]) throws 
	Exception{ 
		LoggerApi.Log.info("findByUser params =" + params.toString());
		
		Client resultQuery= new Client();
		try {			
			
			String queryString =		
								" from " + 
								" Client as c" +
								" where " + 		      		      
								" TRIM(LOWER(c.user))= ?"+
								" and (c.password= ?"+
								" or   c.password= ?)";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params));	
		return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("findByUser resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findByUser resultQuery =" + "null");
			}
			
			
		}
		
	}
	
	@Transactional(readOnly = false)
	public Client findByPk(Integer pk) throws 
	Exception{ 
		//LoggerApi.Log.info("findByPk pk =" + pk);
		
		Client resultQuery=new Client();
		try {
			
			resultQuery= getHibernateTemplate().get(Client.class,pk);
		    
			return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);	
			throw new Exception(e);
			
		} finally {
			/*if(resultQuery!=null){
				LoggerApi.Log.info("findByPk resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findByPk resultQuery =" + "null");
			}
			*/
			
		}	    
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<UbicacionTerminal> findTerminalLocation(String latitude, String longitude) throws Exception {
		
		
		LoggerApi.Log.info("latitude =" + latitude+" longitude="+longitude);
		
		List<UbicacionTerminal> resultQuery = new ArrayList<UbicacionTerminal>();
		HibernateTemplate ht = getHibernateTemplate();		

		try {	 
			String queryString =	
				"FROM " + 
				"UbicacionTerminal p " +			
				"WHERE "+
				//"p.departmentId= 15 AND " +
				//"p.provinceId= 01 AND " +
				//"p.districtId= 01 AND " +
				"p.latitude BETWEEN ( "+latitude+" - 0.008 ) AND ( "+latitude+" + 0.008 ) AND " +
				"p.length BETWEEN ( "+longitude+" - 0.006 ) AND ( "+longitude+" + 0.006 ) AND " +
				"p.status='ACT' AND " +
				"p.modo='INS' "+ 
				"order by trim(p.luckyPoint)";
			/*Object[] params = new Object[4];
			params[0] = longitude;
			params[1] = longitude;
			params[2] = latitude;
			params[3] = latitude;*/
			//params[0] = departmentId;
			//params[1] = provinceId;
			//params[2] = districtId;
			resultQuery = ht.find(queryString);			
			
		    //LoggerApi.Log.info("Salir del metodo: findTerminalLocation.");
		    //LoggerApi.Log.info("Salir de la clase: ClientDaoImpl.");		        
		 
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery =" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery =" + "null");
			}
		}          
	}
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] updateAgreement(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId+" updateAgreement");
        /*List<ClientProcedureUpdateAgreement> resultQuery = new ArrayList<ClientProcedureUpdateAgreement>();
        ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();*/
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            /*Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEAGREEMENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);*/
        	cstmt = conexion.prepareCall("call LOTOCARD.LOTTOMOBILE.updateagreement(?,?)");
            cstmt.setInt(1, p_clientId);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(2);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("cid=" + p_clientId+" updateAgreement");
        }
        //return objectDomain;
        return result;
    }
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getPasswordCode(String mail, String password_code) throws Exception {
        LoggerApi.Log.info("getPasswordCode mail=" + mail);
        /*List<ClientProcedureUpdateAgreement> resultQuery = new ArrayList<ClientProcedureUpdateAgreement>();
        ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();*/
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            /*Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEAGREEMENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);*/
        	cstmt = conexion.prepareCall("call LOTOCARD.CLIENTUPDATE.getpasswordcode(?,?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, mail);//p_mail
            cstmt.setString(3, password_code);//p_password_code
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getPasswordCode mail=" + mail);
        }
        //return objectDomain;
        return result;
    }
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] resetNewPassword(String mail, String password_code, String password1, String password2) throws Exception {
        LoggerApi.Log.info("resetNewPassword mail=" + mail);
        /*List<ClientProcedureUpdateAgreement> resultQuery = new ArrayList<ClientProcedureUpdateAgreement>();
        ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();*/
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            /*Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEAGREEMENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);*/
        	cstmt = conexion.prepareCall("call LOTOCARD.CLIENTUPDATE.resetnewpassword(?,?,?,?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, mail);//p_mail
            cstmt.setString(3, password_code);//p_password_code
            cstmt.setString(4, password1);//p_password_1
            cstmt.setString(5, password2);//p_password_2
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());*/
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("resetNewPassword mail=" + mail);
        }
        //return objectDomain;
        return result;
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String fintUserByMail(String mail, String password_code) throws 
	Exception{
		LoggerApi.Log.info("fintUserByMail mail=" + mail);
		String resultQuery= null;
		try {			
			Object params[] = new Object[2];
			params[0] = mail;
			params[1] = password_code;
			String queryString ="select c.user from Client as c where trim(lower(c.mail))=trim(lower(?)) and c.passwordCode = ?";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params));	
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("fintUserByMail resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("fintUserByMail resultQuery =" + "null");
			}
		}
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
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public List<CulqiCard> listCustomerCard(int clientId) throws Exception {
        List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = "ACT";
            String queryString = "SELECT c.id.itemId, c.lastFour, c.cardBrand FROM CulqiCard c WHERE c.id.clientId=? AND c.cardStatus=?";
            resultQuery = getHibernateTemplate().find(queryString, values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if(resultQuery != null) LoggerApi.Log.info("size= " + resultQuery.size());
        }
        return resultQuery;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Country> findCountry() throws Exception {
		List<Country> resultQuery = new ArrayList<Country>();
		try {
			String queryString = "FROM Country c ORDER BY c.countryName ASC";
			resultQuery = getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQuery != null) LoggerApi.Log.info("size=" + resultQuery.size());			
		}
		return resultQuery;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public List<Region> findRegion() throws Exception {
        List<Region> resultQuery = new ArrayList<Region>();
        try {
            String queryString = "FROM Region r ORDER BY r.regionName ASC";
            resultQuery = getHibernateTemplate().find(queryString);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if(resultQuery != null) LoggerApi.Log.info("size= " + resultQuery.size());
        }
        return resultQuery;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public PromoFirstAccount promotionFirstAccount(Integer cb_client_id,
			Integer cb_balance_item) throws Exception {
		LoggerApi.Log.info("cb_client_id=" + cb_client_id + " cb_balance_item=" + cb_balance_item);
		List<PromoFirstAccount> resultQuery = new ArrayList<PromoFirstAccount>();
		PromoFirstAccount objectDomain = new PromoFirstAccount();
		try{
			Object[] values = new Object[2];
			values[0] = cb_client_id;
			values[1] = cb_balance_item;
			resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_PROMO_FIRST_ACCOUNT", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		}catch(Exception e){
			LoggerApi.severe(e);
			throw e;
		}finally {
			if (objectDomain != null)
                LoggerApi.Log.info("cb_promotion_message=" + objectDomain.getPromotion_message() + " cb_promotion_eco=" + objectDomain.getPromotion_eco());
		}
		
		return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public Client findUserReminder(String email) throws Exception {
    	LoggerApi.Log.info("email=" + email);
    	List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = new Client();
	 	try {
	 		String queryString =	
					"FROM " + 
					"Client c " +			
					"WHERE "+
					"c.mail = ?";
				Object[] values = new Object[1];
				values[0] = email;
				resultQuery = getHibernateTemplate().find(queryString, values);
				objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch(Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("IdClient=" + String.valueOf(objectDomain.getClientId()).toString() + " User=" + String.valueOf(objectDomain.getUser()).toString() + " Name=" + String.valueOf(objectDomain.getName()).toString()
                + " Mail=" + String.valueOf(objectDomain.getMail()).toString() + " MailStatus=" + String.valueOf(objectDomain.getMailStatus()).toString());
		}
	 	return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail+" findGetPasswordCode");
        List<ClientProcedureGetPasswordCode> resultQuery = new ArrayList<ClientProcedureGetPasswordCode>();
        ClientProcedureGetPasswordCode objectDomain = new ClientProcedureGetPasswordCode();
        try {
            Object[] values = new Object[2];
            values[0] = p_mail;
            values[1] = p_password_code;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTUPDATE_GETPASSWORDCODE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_mail=" + p_mail+" p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage() + " p_mail=" + objectDomain.getMail()
                        + " p_user=" + objectDomain.getUser());
            else {
            	LoggerApi.Log.info("p_mail="+p_mail+" objectDomain="+objectDomain);
            }
        }
        return objectDomain;
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public ClientProcedureResetNewPassword resetPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail);
        List<ClientProcedureResetNewPassword> resultQuery = new ArrayList<ClientProcedureResetNewPassword>();
        ClientProcedureResetNewPassword objectDomain = new ClientProcedureResetNewPassword();
        try {
            Object[] values = new Object[4];
            values[0] = p_mail;
            values[1] = p_password_code;
            values[2] = p_password_1;
            values[3] = p_password_2;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTUPDATE_RESETNEWPASSWORD", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " channel=" + channel);
        List<ClientProcedureTokenGeneration> resultQuery = new ArrayList<ClientProcedureTokenGeneration>();
        ClientProcedureTokenGeneration objectDomain = new ClientProcedureTokenGeneration();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = channel;
            values[2] = ip;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " iflexToken=" + objectDomain.getIflexToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureLPTokenGeneration> resultQuery = new ArrayList<ClientProcedureLPTokenGeneration>();
        ClientProcedureLPTokenGeneration objectDomain = new ClientProcedureLPTokenGeneration();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientid;
            values[1] = ip;
            resultQuery = getHibernateTemplate().findByNamedQuery("LAPOLLAWS_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " lapollaToken=" + objectDomain.getLapollaToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception {
		//LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureTANTokenGeneration> resultQuery = new ArrayList<ClientProcedureTANTokenGeneration>();
        ClientProcedureTANTokenGeneration objectDomain = new ClientProcedureTANTokenGeneration();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientid;
            values[1] = ip;
            resultQuery = getHibernateTemplate().findByNamedQuery("TEAPUESTOIFLEXMOBILE_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
                		+ " channel=" + objectDomain.getChannel());
                		*/
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception {
		//LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureTokenValidation> resultQuery = new ArrayList<ClientProcedureTokenValidation>();
        ClientProcedureTokenValidation objectDomain = new ClientProcedureTokenValidation();
        try {
            Object[] values = new Object[2];
            values[0] = p_token;
            values[1] = ip;
            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_TOKENVALIDATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
                		+ " channel=" + objectDomain.getChannel());
                		*/
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureUpdateClientMail resetMail(int p_clientid, String p_mail) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_mail=" + p_mail);
		List<ClientProcedureUpdateClientMail> resultQuery = new ArrayList<ClientProcedureUpdateClientMail>();
		ClientProcedureUpdateClientMail objectDomain = new ClientProcedureUpdateClientMail();
		 try {
	            Object[] values = new Object[2];
	            values[0] = p_clientid;
	            values[1] = p_mail;
	            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATEMAILCLIENT", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}

	
	@SuppressWarnings("unchecked")
	public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception {
		LoggerApi.Log.info("user=" + p_user + " password=***");
        List<ClientProcedureLogin> resultQuery = new ArrayList<ClientProcedureLogin>();
        ClientProcedureLogin objectDomain = new ClientProcedureLogin();
        try {
            Object[] values = new Object[2];
            values[0] = p_user;
            values[1] = p_password;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_LOGIN", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin p_sessionid=" + objectDomain.getSessionId() + " p_clientid=" + objectDomain.getClientId() + " p_cl_nombre=" + objectDomain.getCl_nombre()
                        + " p_status=" + objectDomain.getStatus() + " p_mode=" + objectDomain.getMode() + " p_nsessions=" + objectDomain.getNsessions() + " p_state="
                        + objectDomain.getState() + " p_today=" + objectDomain.getToday() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_balance_amount="
                        + objectDomain.getBalanceAmount() + " p_mail_status=" + objectDomain.getMailStatus() + " p_session_code=" + objectDomain.getSessionCode()
                        + " p_agreement=" + objectDomain.getAgreement() + " p_mail_verified=" + objectDomain.getMailVerified());
        }
        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId, String p_sms) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_sms=" + p_sms);
        List<ClientProcedurePutSmsRegisterData> resultQuery = new ArrayList<ClientProcedurePutSmsRegisterData>();
        ClientProcedurePutSmsRegisterData objectDomain = new ClientProcedurePutSmsRegisterData();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_sms;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_PUTSMSREGISTERDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId, String p_sms, Integer p_time_minutes)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_sms=" + p_sms + " p_time_minutes=" + p_time_minutes);
        List<ClientProcedureUpdateSmsRegister> resultQuery = new ArrayList<ClientProcedureUpdateSmsRegister>();
        ClientProcedureUpdateSmsRegister objectDomain = new ClientProcedureUpdateSmsRegister();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientId;
            values[1] = p_sms;
            values[2] = p_time_minutes;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATESMSREGISTER", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_phone=" + p_phone);
        List<ClientProcedureUpdatePhone> resultQuery = new ArrayList<ClientProcedureUpdatePhone>();
        ClientProcedureUpdatePhone objectDomain = new ClientProcedureUpdatePhone();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_phone;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATEPHONE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("cid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivatePromotion> resultQuery = new ArrayList<ClientProcedureActivatePromotion>();
        ClientProcedureActivatePromotion objectDomain = new ClientProcedureActivatePromotion();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACTIVATEPROMOTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("cid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivateWBPromotion> resultQuery = new ArrayList<ClientProcedureActivateWBPromotion>();
        ClientProcedureActivateWBPromotion objectDomain = new ClientProcedureActivateWBPromotion();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACTIVATEWBPROMOTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureCancelPromotion cancelPromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("cid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureCancelPromotion> resultQuery = new ArrayList<ClientProcedureCancelPromotion>();
        ClientProcedureCancelPromotion objectDomain = new ClientProcedureCancelPromotion();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_CANCELPROMOTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivatePromotionibk> resultQuery = new ArrayList<ClientProcedureActivatePromotionibk>();
        ClientProcedureActivatePromotionibk objectDomain = new ClientProcedureActivatePromotionibk();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACTIVATEPROMOTIONIBK", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivateWBPromotionibk> resultQuery = new ArrayList<ClientProcedureActivateWBPromotionibk>();
        ClientProcedureActivateWBPromotionibk objectDomain = new ClientProcedureActivateWBPromotionibk();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACTIVATEWBPROMOTIONIBK", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureCancelPromotionibk> resultQuery = new ArrayList<ClientProcedureCancelPromotionibk>();
        ClientProcedureCancelPromotionibk objectDomain = new ClientProcedureCancelPromotionibk();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_CANCELPROMOTIONIBK", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<UbicacionRedDigital> findRedDigitalLocation(String latitude, String longitude) throws Exception {
		LoggerApi.Log.info("latitude =" + latitude+" longitude="+longitude);		
		List<UbicacionRedDigital> resultQuery = new ArrayList<UbicacionRedDigital>();
		HibernateTemplate ht = getHibernateTemplate();		

		try {	 
			String queryString =	
				" FROM " + 
				" UbicacionRedDigital u " +			
				" WHERE "+
				" u.latitude BETWEEN ( "+latitude+" - 0.008 ) AND ( "+latitude+" + 0.008 ) AND " +
				" u.length BETWEEN ( "+longitude+" - 0.006 ) AND ( "+longitude+" + 0.006 ) AND " +
				" u.status = 'A' " +
				" order by u.id desc ";
			/*Object[] params = new Object[4];
			params[0] = longitude;
			params[1] = longitude;
			params[2] = latitude;
			params[3] = latitude;*/
			//params[0] = departmentId;
			//params[1] = provinceId;
			//params[2] = districtId;
			resultQuery = ht.find(queryString);			
			
		    //LoggerApi.Log.info("Salir del metodo: findTerminalLocation.");
		    //LoggerApi.Log.info("Salir de la clase: ClientDaoImpl.");		        
		 
	        return resultQuery;
		}catch(Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			LoggerApi.severe(e);
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery =" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery =" + "null");
			}
		}
		//return resultQuery;
	}
	
	public PinPrinted findLotocard(String pin) throws Exception {
		PinPrinted objectDomain = new PinPrinted();
		String queryString = "FROM PinPrinted p WHERE p.pinNumberId=?";
		Object[] values = new Object[1];
		values[0] = StringLib.encodeLabel(pin);
		objectDomain = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString, values));
		return objectDomain;
	}

	@Override
	public ClientTutorial evalTutorial(Object[] values) throws Exception {
        List<ClientTutorial> resultQuery = new ArrayList<ClientTutorial>();
        ClientTutorial objectDomain = new ClientTutorial();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_TUTORIALMOBILE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } 
        return objectDomain;
	}

	@Override
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception {
		pe.com.intralot.loto.lib.Dbms dt = null;
		try {
			dt = new pe.com.intralot.loto.lib.Dbms();
			String sql = " lotocard.compliant_book.insert_compliant_web (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ";
			dt.setProcedure(sql);
			dt.setInt(1, reclamacion.getId()); 
			dt.setString(2, reclamacion.getNombre());          
			dt.setString(3, reclamacion.getDireccion());       
			dt.setString(4, reclamacion.getDni());       
			dt.setString(5, reclamacion.getTelefono());  
			dt.setString(6, reclamacion.getEmail());       
			dt.setString(7, reclamacion.getTipoBien());       
			dt.setString(8, reclamacion.getBien());    
			dt.setString(9, reclamacion.getTipoReclamo());       
			dt.setString(10, reclamacion.getReclamo());          
			dt.setString(11, reclamacion.getMonto());    
			dt.setString(12, reclamacion.getPedido());
			dt.setString(13, reclamacion.getImgEviList()[0]);
			dt.setString(14, reclamacion.getImgEviList()[1]);
			dt.setString(15, reclamacion.getImgEviList()[2]);
			dt.registerOutParameter(16,java.sql.Types.INTEGER);
			dt.registerOutParameter(17,java.sql.Types.VARCHAR);
			dt.executeProcedure();
			int secuencia = dt.getInt(16);
			String fecha  = dt.getString(17);
			reclamacion.setSecuencia(secuencia);
			reclamacion.setFecha(fecha);
		} finally {
			if (dt != null) {
				  try {
					  dt.close();
				  } catch (Exception e1) {}
			}
		}
		return reclamacion;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_playerId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_playerId=" + p_playerId);
        List<ClientProcedureUpdatePlayerId> resultQuery = new ArrayList<ClientProcedureUpdatePlayerId>();
        ClientProcedureUpdatePlayerId objectDomain = new ClientProcedureUpdatePlayerId();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_playerId;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATEPLAYERID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws 
	Exception{ 
		List<ClientProcedureGetCasinoProductList> resultQueryList =  new ArrayList<ClientProcedureGetCasinoProductList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETCASINOPRODUCTS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoProductListOrder> listCasinoProductsOrder() throws 
	Exception{ 
		List<ClientProcedureGetCasinoProductListOrder> resultQueryList =  new ArrayList<ClientProcedureGetCasinoProductListOrder>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETCASINOPRODUCTSORDER");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProductList> listRaspayaProducts() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProductList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProductList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYAPRODUCTS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProductListOrder> listRaspayaProductsOrder() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProductListOrder> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProductListOrder>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYAPRODUCTSORDER");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProductPriceList> listRaspayaProductsPrice() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProductPriceList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProductPriceList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYAPRODUCTSPRICE");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProductPozoList> listRaspayaProductsPozo() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProductPozoList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProductPozoList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYAPRODUCTSPOZO");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesProductList> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesProductList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETVIRTUALESPRODUCTS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesProductListOrder> listVirtualesProductsOrder() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesProductListOrder> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesProductListOrder>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETVIRTUALESPRODUCTSORDER");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findCodUserfilter1(String dni, String nombre) throws Exception {
		String resultQuery= null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = nombre;
			String queryString ="select c.clientId from Client as c where c.docNumber=trim(lower(?)) and trim(lower(c.name))=trim(lower(?))";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params)).toString();
		
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultQuery != null){
				LoggerApi.Log.info("findCodUserfilter1 resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findCodUserfilter1 resultQuery =" + "null");
				return "";
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findCodUserfilter2(String dni, String correo) throws Exception {
		String resultQuery= null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = correo;
			String queryString ="select c.clientId from Client as c where c.docNumber=trim(lower(?)) and trim(lower(c.mail))=trim(lower(?))";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params)).toString();	
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("findCodUserfilter2 resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findCodUserfilter2 resultQuery =" + "null");
				return "";
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findCodUserfilter3(String dni, String celular) throws Exception {
		String resultQuery= null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = celular;
			String queryString ="select c.clientId from Client as c where trim(lower(c.docNumber))=trim(lower(?)) and trim(lower(c.mobilePhone))=trim(lower(?))";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params)).toString();	
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("findCodUserfilter3 resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findCodUserfilter3 resultQuery =" + "null");
				return "";
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoProviderList> listProviders() throws 
	Exception{ 
		List<ClientProcedureGetCasinoProviderList> resultQueryList =  new ArrayList<ClientProcedureGetCasinoProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETCASINOPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoCategoryProviderList> listCategoryProviders() throws 
	Exception{ 
		List<ClientProcedureGetCasinoCategoryProviderList> resultQueryList =  new ArrayList<ClientProcedureGetCasinoCategoryProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETCASINOCATEGORYPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesProviderList> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETVIRTUALESPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesCategoryProviderList> listCategoryProvidersVirtuales() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesCategoryProviderList> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesCategoryProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETVIRTUALESCATEGORYPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProviderList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYAPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaCategoryProviderList> listCategoryProvidersRaspaya() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaCategoryProviderList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaCategoryProviderList>();
			try {			
		    resultQueryList = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETRASPAYACATEGORYPROVIDERS");
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureUpdateVisaSession setVisaSession(int p_clientid, String p_visasession) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_visasession=" + p_visasession);
		List<ClientProcedureUpdateVisaSession> resultQuery = new ArrayList<ClientProcedureUpdateVisaSession>();
		ClientProcedureUpdateVisaSession objectDomain = new ClientProcedureUpdateVisaSession();
		 try {
	            Object[] values = new Object[2];
	            values[0] = p_clientid;
	            values[1] = p_visasession;
	            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_UPDATEVISASESSION", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findVisaSessionById(Integer clientId) throws Exception {
		String resultQuery= null;
		try {			
			Object params[] = new Object[1];
			params[0] = clientId;
			String queryString ="select c.visaSession from Client as c where c.clientId=?";			
		resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params)).toString();	
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("findVisaSessionById resultQuery =" + resultQuery);	
			}else{
				LoggerApi.Log.info("findVisaSessionById resultQuery =" + "null");
				return "";
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount,
			String platform, String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginVisaRecharge p_client_id=" + clientId+" p_amount="+amount+" p_platform="+platform
				+" p_operatorId="+operatorId);
		List<ClientProcedureOriginVisaRecharge> resultQuery = new ArrayList<ClientProcedureOriginVisaRecharge>();
		ClientProcedureOriginVisaRecharge objectDomain = new ClientProcedureOriginVisaRecharge();
		 try {
	            Object[] values = new Object[5];
	            values[0] = sessionKey;
	            values[1] = clientId;
	            values[2] = amount;
	            values[3] = platform;
	            values[4] = operatorId;
	            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_ORIGINVISARECHARGE", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginPefeRecharge  p_platform="+platform +" p_operatorId="+operatorId);
		List<ClientProcedureOriginPefeRecharge> resultQuery = new ArrayList<ClientProcedureOriginPefeRecharge>();
		ClientProcedureOriginPefeRecharge objectDomain = new ClientProcedureOriginPefeRecharge();
		 try {
	            Object[] values = new Object[3];
	            values[0] = transactionId;
	            values[1] = platform;
	            values[2] = operatorId;
	            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_ORIGINPEFERECHARGE", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginBcpRecharge  p_platform="+platform +" p_operatorId="+operatorId);
		List<ClientProcedureOriginBcpRecharge> resultQuery = new ArrayList<ClientProcedureOriginBcpRecharge>();
		ClientProcedureOriginBcpRecharge objectDomain = new ClientProcedureOriginBcpRecharge();
		 try {
	            Object[] values = new Object[3];
	            values[0] = transactionId;
	            values[1] = platform;
	            values[2] = operatorId;
	            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_ORIGINBCPRECHARGE", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId)
			throws Exception {
		LoggerApi.Log.info("setOriginLotocardRecharge p_platform="+platform+" p_operatorId="+operatorId);
		List<ClientProcedureOriginLotocardRecharge> resultQuery = new ArrayList<ClientProcedureOriginLotocardRecharge>();
		ClientProcedureOriginLotocardRecharge objectDomain = new ClientProcedureOriginLotocardRecharge();
		 try {
	            Object[] values = new Object[3];
	            values[0] = transactionId;
	            values[1] = platform;
	            values[2] = operatorId;
	            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_ORIGINLOTOCARDRECHARGE", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	        	LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
	        }
	        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novusId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_novusId=" + p_novusId);
        List<ClientProcedureUpdateNovusId> resultQuery = new ArrayList<ClientProcedureUpdateNovusId>();
        ClientProcedureUpdateNovusId objectDomain = new ClientProcedureUpdateNovusId();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_novusId;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATENOVUSID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_clientid=" + p_clientid+" findGetNovusId");
        List<ClientProcedureGetNovusId> resultQuery = new ArrayList<ClientProcedureGetNovusId>();
        ClientProcedureGetNovusId objectDomain = new ClientProcedureGetNovusId();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientid;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_GETNOVUSID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + p_clientid+" p_clientuser=" + objectDomain.getClientUser() );
            else {
            	LoggerApi.Log.info("p_clientid="+p_clientid+" objectDomain="+objectDomain);
            }
        }
        return objectDomain;
    }
	
	@SuppressWarnings("unchecked")
	public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception {
		LoggerApi.Log.info("user=" + p_user );
        List<ClientProcedureGetLoginData> resultQuery = new ArrayList<ClientProcedureGetLoginData>();
        ClientProcedureGetLoginData objectDomain = new ClientProcedureGetLoginData();
        try {
            Object[] values = new Object[1];
            values[0] = p_user;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_LOGIN_DATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin p_sessionid=" + objectDomain.getSessionId() + " p_clientid=" + objectDomain.getClientId() + " p_cl_nombre=" + objectDomain.getCl_nombre()
                        + " p_status=" + objectDomain.getStatus() + " p_mode=" + objectDomain.getMode() + " p_nsessions=" + objectDomain.getNsessions() + " p_state="
                        + objectDomain.getState() + " p_today=" + objectDomain.getToday() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_balance_amount="
                        + objectDomain.getBalanceAmount() + " p_mail_status=" + objectDomain.getMailStatus() + " p_session_code=" + objectDomain.getSessionCode()
                        + " p_agreement=" + objectDomain.getAgreement() + " p_mail_verified=" + objectDomain.getMailVerified());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_bonoQr=" + p_bonoQr);
        List<ClientProcedureUpdateBonoQr> resultQuery = new ArrayList<ClientProcedureUpdateBonoQr>();
        ClientProcedureUpdateBonoQr objectDomain = new ClientProcedureUpdateBonoQr();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_bonoQr;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_UPDATEBONOQR", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@SuppressWarnings("unchecked")
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId,
			String mobilePhone, String docType, String docNumber) throws Exception {
		LoggerApi.Log.info("validateSession clientId=" + clientId);
		List<ClientUpdateProcedureValidateSession> resultQuery = new ArrayList<ClientUpdateProcedureValidateSession>();
		ClientUpdateProcedureValidateSession objectDomain = new ClientUpdateProcedureValidateSession();
		Object[] values = new Object[5];
        values[0] = tokenSession;
        values[1] = clientId;
        values[2] = mobilePhone;
        values[3] = docType;
        values[4] = docNumber;
        resultQuery = getHibernateTemplate().findByNamedQuery("CLIENT_UPDATE_VALIDATE_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("validateSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@SuppressWarnings("unchecked")
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception {
		LoggerApi.Log.info("expiredSession clientId=" + clientId);
		List<ClientUpdateProcedureExpiredSession> resultQuery = new ArrayList<ClientUpdateProcedureExpiredSession>();
		ClientUpdateProcedureExpiredSession objectDomain = new ClientUpdateProcedureExpiredSession();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = getHibernateTemplate().findByNamedQuery("CLIENT_UPDATE_EXPIRED_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("expiredSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
		
	}

	@SuppressWarnings("unchecked")
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception {
		LoggerApi.Log.info("closedSession clientId=" + clientId);
		List<ClientUpdateProcedureClosedSession> resultQuery = new ArrayList<ClientUpdateProcedureClosedSession>();
		ClientUpdateProcedureClosedSession objectDomain = new ClientUpdateProcedureClosedSession();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = getHibernateTemplate().findByNamedQuery("CLIENT_UPDATE_CLOSED_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("closedSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
		
	}
	
	@Override
	public ClientGetCollectionType getClientAutoPayment(String p_clientId) throws Exception{
        LoggerApi.Log.info("ClientSaleDaoImpl: p_clientid=" + p_clientId);
        ClientGetCollectionType objectDomain = new ClientGetCollectionType();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
            conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.TINKAEXPRESSWS.getcollectiontype(?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, p_clientId.toString());
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            if (rs != null && rs.next()) {
                objectDomain.setPrizeCollection(rs.getString("p_prize_collection"));
            }
        } catch (Exception e) {
        	 LoggerApi.severe(e);
            return objectDomain;
        } finally {
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("ClientSaleDaoImpl: FLAG autopayment = "+ objectDomain.getPrizeCollection() + ", p_clientid=" + p_clientId);
        }
        return objectDomain;
	}
	
	@Override
	public boolean updateAutoPaymentFlag(String p_clientId, String switchStatus) throws Exception{
	   LoggerApi.Log.info("ClientSaleDaoImpl updateAutoPaymentFlag: p_clientid=" + p_clientId);
	   boolean updated = false;
	
	    Connection conexion = null;
	    CallableStatement cstmt = null;
	
	    try {
	        conexion = dataSource.getConnection();
	        cstmt = conexion.prepareCall("{ call LOTOCARD.TINKAEXPRESSWS.updatecollectiontype(?, ?, ?) }");
	
	        cstmt.setString(1, p_clientId.toString());
	        cstmt.setString(2, switchStatus);
	        cstmt.registerOutParameter(3, Types.VARCHAR);
	
	        cstmt.execute();
	
	        String message = cstmt.getString(3);
	        LoggerApi.Log.info("ClientSaleDaoImpl updateAutoPaymentFlag: Respuesta del procedimiento: " + message);
	
	        if ("OK".equalsIgnoreCase(message)) {
	            updated = true;
	        } else {
	            LoggerApi.Log.info("ClientSaleDaoImpl updateAutoPaymentFlag: No se pudo actualizar: " + message);
	        }
	
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	    } finally {
	        try { if (cstmt != null) cstmt.close(); } catch (Exception e) { }
	        try { if (conexion != null) conexion.close(); } catch (Exception e) { }
	        LoggerApi.Log.info("ClientSaleDaoImpl updateAutoPaymentFlag: FIN para p_clientid=" + p_clientId);
	    }
	
	    return updated;
	}
	
}