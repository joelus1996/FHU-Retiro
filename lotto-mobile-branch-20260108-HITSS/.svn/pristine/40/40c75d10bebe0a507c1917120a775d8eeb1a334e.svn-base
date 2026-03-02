package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oracle.jdbc.OracleTypes;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureRegisterPopupLottery;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientDevice;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePassClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePlayerIdVl;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityWhiteList;
import pe.com.intralot.loto.layer.model.pojo.GetClientSecurity;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientSaleDao;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureEditSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLotteryProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaGameId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;


@Repository
public class ClientSaleDaoImpl extends HibernateBaseDaoImpl implements ClientSaleDao {

	@Autowired
	private DataSource dataSource;
	
    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        //LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        List<ClientProcedureGetClient> resultQuery = new ArrayList<ClientProcedureGetClient>();
        ClientProcedureGetClient objectDomain = new ClientProcedureGetClient();
        try {
            Object[] values = new Object[2];
            values[0] = p_sessionid;
            values[1] = p_clientid;
            resultQuery = super.findForNamed("CLIENTSALE_GETCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_nombre=" + objectDomain.getNombre() + " p_birthdate=" + objectDomain.getBirthdate() + " p_mail=" + objectDomain.getMail()
                        + " p_mailstatus=" + objectDomain.getMailstatus() + " p_item=" + objectDomain.getItem() + " p_amount=" + objectDomain.getAmount() + " p_mail2="
                        + objectDomain.getMail2() + " p_mail2status=" + objectDomain.getMail2status() + " p_address=" + objectDomain.getAddress() + " p_region="
                        + objectDomain.getRegion() + " p_country=" + objectDomain.getCountry() + " p_status=" + objectDomain.getStatus() + " p_terms="
                        + objectDomain.getTerms() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_fixed_phone=" + objectDomain.getFixedPhone() + " p_mobile_phone="
                        + objectDomain.getMobilePhone() + " p_mail_code=" + objectDomain.getMailCode());*/
        }
        return objectDomain;
    }

    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        //LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        List<ClientProcedureGetDataClient> resultQuery = new ArrayList<ClientProcedureGetDataClient>();
        ClientProcedureGetDataClient objectDomain = new ClientProcedureGetDataClient();
        try {
            Object[] values = new Object[2];
            values[0] = p_sessionid;
            values[1] = p_clientid;
            resultQuery = super.findForNamed("CLIENTUPDATE_GETDATACLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            /*if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_nombre=" + objectDomain.getNombre() + " p_appaterno=" + objectDomain.getApPaterno()
                        + " p_apmaterno=" + objectDomain.getApMaterno() + " p_birthdate=" + objectDomain.getBirthDate() + " p_user=" + objectDomain.getUser() + " p_mail="
                        + objectDomain.getMail() + " p_mailstatus=" + objectDomain.getMailStatus() + " p_confirm=" + objectDomain.getConfirm() + " p_region="
                        + objectDomain.getRegion() + " p_mail2=" + objectDomain.getMail2() + " p_mail2status=" + objectDomain.getMail2Status() + " p_nickname="
                        + objectDomain.getNickName() + " p_gender=" + objectDomain.getGender() + " p_country=" + objectDomain.getCountry() + " p_marital="
                        + objectDomain.getMarital() + " p_pnumbers=" + objectDomain.getpNumbers() + " p_pnumbers00=" + objectDomain.getpNumbers00() + " p_typeid="
                        + objectDomain.getTypeId() + " p_numberid=" + objectDomain.getNumberId() + " p_address=" + objectDomain.getAddress() + " p_terms="
                        + objectDomain.getTerms() + " p_comtypeid=" + objectDomain.getComTypeId() + " p_comnumberid=" + objectDomain.getComNumberId() + " p_comname="
                        + objectDomain.getComName() + " p_comphones=" + objectDomain.getComPhones() + " p_comcountry=" + objectDomain.getComCountry() + " p_comregion="
                        + objectDomain.getComRegion() + " p_comaddress=" + objectDomain.getComAddress() + " bizpaystatus=" + objectDomain.getComStatus() + " p_mode="
                        + objectDomain.getMode() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_fixed_phone=" + objectDomain.getFixedPhone() + " p_mobile_phone="
                        + objectDomain.getMobilePhone() + " p_control_amount=" + objectDomain.getControlAmount() + " p_control_hours=" + objectDomain.getControlHours()
                        + " p_control_last_date=" + objectDomain.getControlLastDate());*/
        }
        return objectDomain;
    }
    
    public ClientProcedureIIVVTokenGeneration getIIVVToken(Integer p_clientid, String ip, String device) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureIIVVTokenGeneration> resultQuery = new ArrayList<ClientProcedureIIVVTokenGeneration>();
        ClientProcedureIIVVTokenGeneration objectDomain = new ClientProcedureIIVVTokenGeneration();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = ip;
            values[2] = device;
            resultQuery = super.findForNamed("VIRTUALINSTANTSWS_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " iivvToken=" + objectDomain.getToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
	}
    
    public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientId, String p_device) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId + " p_device=" + p_device);
        List<ClientProcedureUpdateClientDevice> resultQuery = new ArrayList<ClientProcedureUpdateClientDevice>();
        ClientProcedureUpdateClientDevice objectDomain = new ClientProcedureUpdateClientDevice();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_device;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEDEVICE", values);
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
    
    public ClientProcedureUpdateClientFavorite updateFavorite(String p_flagDelete, Integer p_clientId, String p_productid) throws Exception {
		LoggerApi.Log.info("p_flagDelete=" + p_flagDelete + " cid=" + p_clientId + " p_productid=" + p_productid);
        List<ClientProcedureUpdateClientFavorite> resultQuery = new ArrayList<ClientProcedureUpdateClientFavorite>();
        ClientProcedureUpdateClientFavorite objectDomain = new ClientProcedureUpdateClientFavorite();
        try {
            Object[] values = new Object[3];
            values[0] = p_flagDelete;
            values[1] = p_clientId;
            values[2] = p_productid;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEFAVORITECASINO", values);
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
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getFavoriteProduct(String client_id) throws Exception {
        LoggerApi.Log.info("getFavoriteProduct client_id=" + client_id);
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTSALE.getfavoriteproduct(?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, client_id);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getFavoriteProduct client_id=" + client_id);
        }
        return result;
    }
    
    public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception {
		LoggerApi.Log.info("p_name=" + p_name);
        List<ClientProcedureGetRaspayaGameId> resultQuery = new ArrayList<ClientProcedureGetRaspayaGameId>();
        ClientProcedureGetRaspayaGameId objectDomain = new ClientProcedureGetRaspayaGameId();
        try {
            Object[] values = new Object[1];
            values[0] = p_name;
            resultQuery = super.findForNamed("CLIENTSALE_GETRASPAYAGAMEID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("gameId=" + objectDomain.getGameId());
        }
        return objectDomain;
	}
    
    public ClientProcedureDDVVTokenGeneration getDDVVToken(Integer p_clientid, String ip, String device) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureDDVVTokenGeneration> resultQuery = new ArrayList<ClientProcedureDDVVTokenGeneration>();
        ClientProcedureDDVVTokenGeneration objectDomain = new ClientProcedureDDVVTokenGeneration();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = ip;
            values[2] = device;
            resultQuery = super.findForNamed("VIRTUALSPORTSWS_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " ddvvToken=" + objectDomain.getToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
	}
    
    public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception {
		LoggerApi.Log.info("p_token=" + p_token);
        List<ClientProcedureDDVVTokenLogin> resultQuery = new ArrayList<ClientProcedureDDVVTokenLogin>();
        ClientProcedureDDVVTokenLogin objectDomain = new ClientProcedureDDVVTokenLogin();
        try {
            Object[] values = new Object[1];
            values[0] = p_token;
            resultQuery = super.findForNamed("VIRTUALSPORTSWS_LOGIN", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " ddvvToken=" + objectDomain.getToken());
        }
        return objectDomain;
	}
    
    public ClientProcedureUpdateClientFavoriteVirtuales updateFavoriteVirtuales(String p_flagDelete, Integer p_clientId, String p_productid) throws Exception {
		LoggerApi.Log.info("p_flagDelete=" + p_flagDelete + " cid=" + p_clientId + " p_productid=" + p_productid);
        List<ClientProcedureUpdateClientFavoriteVirtuales> resultQuery = new ArrayList<ClientProcedureUpdateClientFavoriteVirtuales>();
        ClientProcedureUpdateClientFavoriteVirtuales objectDomain = new ClientProcedureUpdateClientFavoriteVirtuales();
        try {
            Object[] values = new Object[3];
            values[0] = p_flagDelete;
            values[1] = p_clientId;
            values[2] = p_productid;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEFAVORITEVIRTUALES", values);
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
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getFavoriteProductVirtuales(String client_id) throws Exception {
        LoggerApi.Log.info("getFavoriteProductVirtuales client_id=" + client_id);
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTSALE.getfavoriteproductvirtuales(?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, client_id);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getFavoriteProductVirtuales client_id=" + client_id);
        }
        return result;
    }
    
    public ClientProcedureRegisterPopupLottery registerPopupLottery(Integer p_clientId, String p_device, String p_source, Integer p_game_id) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_device=" + p_device + " p_source=" + p_source + " p_game_id=" + p_game_id);
        List<ClientProcedureRegisterPopupLottery> resultQuery = new ArrayList<ClientProcedureRegisterPopupLottery>();
        ClientProcedureRegisterPopupLottery objectDomain = new ClientProcedureRegisterPopupLottery();
        try {
            Object[] values = new Object[4];
            values[0] = p_clientId;
            values[1] = p_device;
            values[2] = p_source;
            values[3] = p_game_id;
            resultQuery = super.findForNamed("CLIENTSALE_REGISTERPOPUPLOTTERY", values);
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
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getPromoHincha(String client_id) throws Exception {
        LoggerApi.Log.info("getPromoHincha client_id=" + client_id);
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTSALE.getpromohincha(?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, client_id);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getPromoHincha client_id=" + client_id);
        }
        return result;
    }
    
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getFavoriteProductRaspaya(String client_id) throws Exception {
        LoggerApi.Log.info("getFavoriteProductRaspaya client_id=" + client_id);
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTSALE.getfavoriteproductraspaya(?,?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, client_id);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getFavoriteProductRaspaya client_id=" + client_id);
        }
        return result;
    }
	
    @Override
	public ClientProcedureUpdateClientFavoriteRaspaya updateFavoriteRaspaya(String p_flagDelete, Integer p_clientId, String p_productid) throws Exception {
		LoggerApi.Log.info("p_flagDelete=" + p_flagDelete + " cid=" + p_clientId + " p_productid=" + p_productid);
        List<ClientProcedureUpdateClientFavoriteRaspaya> resultQuery = new ArrayList<ClientProcedureUpdateClientFavoriteRaspaya>();
        ClientProcedureUpdateClientFavoriteRaspaya objectDomain = new ClientProcedureUpdateClientFavoriteRaspaya();
        try {
            Object[] values = new Object[3];
            values[0] = p_flagDelete;
            values[1] = p_clientId;
            values[2] = p_productid;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEFAVORITERASPAYA", values);
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
    
	@Override
	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId) throws Exception {
		//LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        List<ClientProcedureUpdateDataClient> resultQuery = new ArrayList<ClientProcedureUpdateDataClient>();
        ClientProcedureUpdateDataClient objectDomain = new ClientProcedureUpdateDataClient();
        try {
            Object[] values = new Object[17];
            values[0] = sessionId;
            values[1] = clientId;
            values[2] = dataClient.getUser();
            values[3] = dataClient.getNombre();
            values[4] = dataClient.getApPaterno();
            values[5] = dataClient.getMail();
            values[6] = dataClient.getBirthDate();
            values[7] = dataClient.getMobilePhone();
            values[8] = dataClient.getTypeId();
            values[9] = dataClient.getNumberId();
            values[10] = dataClient.getConfirm();
            values[11] = dataClient.getAddress2();
            values[12] = dataClient.getRegion();
            values[13] = dataClient.getProvince();
            values[14] = dataClient.getDistrict();
            values[15] = dataClient.getPpe();
            values[16] = dataClient.getCountry();
            
            resultQuery = super.findForNamed("CLIENTUPDATE_PUTCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception{
		List<ClientProcedureUpdatePassClient> resultQuery = new ArrayList<ClientProcedureUpdatePassClient>();
		ClientProcedureUpdatePassClient objectDomain = new ClientProcedureUpdatePassClient();
        try {
            Object[] values = new Object[3];
            values[0] = clientId;
            values[1] = passUpdate;
            values[2] = passConfirm;
            
            resultQuery = super.findForNamed("CLIENTUPDATE_PUTPASSWORD", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return objectDomain;
	}
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getMostPlayedCasino() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTVIRTUALSLOBBY.getmostplayedcasino(?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getMostPlayedCasino ");
        }
        return result;
    }

	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getMostPlayedRaspaya() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTVIRTUALSLOBBY.getmostplayedraspaya(?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getMostPlayedRaspaya ");
        }
        return result;
    }
	
	@SuppressWarnings("rawtypes")
    @Transactional(readOnly = false)
    public HashMap[] getMostPlayedVirtual() throws Exception {
        HashMap[] result = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
        	conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call LOTOCARD.CLIENTVIRTUALSLOBBY.getmostplayedvirtual(?)");
        	cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet) cstmt.getObject(1);
            result = getHashMaps(rs);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("getMostPlayedVirtual ");
        }
        return result;
    }
	
	@Override
	public ClientProcedureGetSelfcontrol getDataSelfcontrol(Integer p_clientId )  throws Exception {
		LoggerApi.Log.info("getDataSelfcontrol input -> idClient=" + p_clientId);
		List<ClientProcedureGetSelfcontrol> resultQuery = new ArrayList<ClientProcedureGetSelfcontrol>();
		ClientProcedureGetSelfcontrol objectDomain = new ClientProcedureGetSelfcontrol();
		Object[] values = new Object[1];
        values[0] = p_clientId;
        resultQuery = super.findForNamed("CLIENTWEB_GET_SELFCONTROL",values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        LoggerApi.Log.info("getDataSelfcontrol output ->"+objectDomain.toString());
		return objectDomain;
	}
	
	@Override
	public ClientProcedureEditSelfcontrol editDataSelfcontrol(Integer p_clientId, double p_amount, String p_type)  throws Exception {
		LoggerApi.Log.info("editDataSelfcontrol inputs -> idClient=" + p_clientId + " p_amount=" +  p_amount + " p_type="+p_type);
		List<ClientProcedureEditSelfcontrol> resultQuery = new ArrayList<ClientProcedureEditSelfcontrol>();
		ClientProcedureEditSelfcontrol objectDomain = new ClientProcedureEditSelfcontrol();
		Object[] values = new Object[3];
        values[0] = p_clientId;
        values[1] = p_amount;
        values[2] = p_type;
        resultQuery = super.findForNamed("CLIENTWEB_EDIT_SELFCONTROL",values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        LoggerApi.Log.info("editDataSelfcontrol output ->"+objectDomain.toString());
		return objectDomain;
	}

	@Override
	public ClientSecurityProcedureCheckIp findGetCheckIp(Integer p_clientId, String ip, String c_plataforma) throws Exception  {
		LoggerApi.Log.info("findGetCheckIp clientId=" + p_clientId+" ip="+ip+" c_plataforma:"+c_plataforma);
		List<ClientSecurityProcedureCheckIp> resultQuery = new ArrayList<ClientSecurityProcedureCheckIp>();
		ClientSecurityProcedureCheckIp objectDomain = new ClientSecurityProcedureCheckIp();
		Object[] values = new Object[3];
        values[0] = p_clientId;
        values[1] = ip;
        values[2] = c_plataforma;
        
        resultQuery = super.findForNamed("LOTOCARD_CLIENTSECURITYTRANSACTION_CHECKIP", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("findGetCheckIp clientId=" + p_clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}

	@Override
	public ClientSecurityWhiteList updateipWhitelis(Integer clientId, String ip, String respuesta_user, String p_plataforma)
			throws Exception {
		LoggerApi.Log.info("updateipWhitelis clientId=" + clientId+" ip="+ip +" respuesta_user="+respuesta_user +" p_plataforma="+p_plataforma);
		List<ClientSecurityWhiteList> resultQuery = new ArrayList<ClientSecurityWhiteList>();
		ClientSecurityWhiteList objectDomain = new ClientSecurityWhiteList();
		Object[] values = new Object[4];
        values[0] = clientId;
        values[1] = ip;
        values[2] = respuesta_user;
        values[3] = p_plataforma;
        resultQuery = super.findForNamed("LOTOCARD_CLIENTSECURITY_WHITELIST_IP", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("updateipWhitelis clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}
	
	@Override
	public GetClientSecurity getipWhitelist(Integer clientId, String ip)
			throws Exception {
		LoggerApi.Log.info("getipWhitelist clientId=" + clientId+" ip="+ip);
		List<GetClientSecurity> resultQuery = new ArrayList<GetClientSecurity>();
		GetClientSecurity objectDomain = new GetClientSecurity();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = ip;
        resultQuery = super.findForNamed("LOTOCARD_CLIENT_WHITELIST_IP", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("getipWhitelist clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}

	@Override
	public List<ClientProcedureGetLotteryProductList> listLotteryProducts() throws Exception {
		List<ClientProcedureGetLotteryProductList> resultQueryList = new ArrayList<ClientProcedureGetLotteryProductList>();
		try {
			resultQueryList = super.findForNamed("CLIENTSALE_GETLOTTERYPRODUCTS", null);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {

		}
		return resultQueryList;
	}

	@Override
	public ClientProcedureUpdatePlayerIdVl updatePlayerIdVl(Integer p_clientId, String p_player_id_vl)
			throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_player_id_vl=" + p_player_id_vl);
        List<ClientProcedureUpdatePlayerIdVl> resultQuery = new ArrayList<ClientProcedureUpdatePlayerIdVl>();
        ClientProcedureUpdatePlayerIdVl objectDomain = new ClientProcedureUpdatePlayerIdVl();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_player_id_vl;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEPLAYERIDVL", values);
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
}
