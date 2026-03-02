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
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;

import oracle.jdbc.OracleTypes;
import pe.com.intralot.loto.layer.model.domain.ClientAddressLog;
import pe.com.intralot.loto.layer.model.domain.ClientGetCollectionType;
import pe.com.intralot.loto.layer.model.bean.ClientBean;
import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateClientSamp;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivatePromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCancelPromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivatePromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateWBPromotion;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureActivateWBPromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCancelPromotionibk;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureCodeValidation;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureEditSelfcontrol;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLoginData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetLotteryProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetNewCode;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetNovusId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetPasswordCode;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetPlayerId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaGameId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductPozoList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProductPriceList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetRaspayaProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesCategoryProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetVirtualesProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureNewSessionData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginBcpRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginLotocardRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureOriginVisaRecharge;
import pe.com.intralot.loto.layer.model.domain.ClientProcedurePutClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedurePutNewClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedurePutSmsRegisterData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureRegisterPopupLottery;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureResetNewPassword;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureSaleLoadPrepaidCard;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureSessionData;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTANTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureTokenValidation;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateAgreement;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateBonoQr;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientDevice;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateMail;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateNovusId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePassClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePassword;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePhone;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePlayerId;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePlayerIdVl;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePromo;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateSmsRegister;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateStateRechargeAgora;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateVisaSession;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureValidateNewPhoneAgora;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClientBond;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureVerifyClientPromo;
import pe.com.intralot.loto.layer.model.domain.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.domain.ClientSecurityWhiteList;
import pe.com.intralot.loto.layer.model.domain.GetClientSecurity;
import pe.com.intralot.loto.layer.model.domain.PinPrinted;
import pe.com.intralot.loto.layer.model.domain.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.domain.ProcedureYapePlinVerifyTransaction;
import pe.com.intralot.loto.layer.model.domain.PromoFirstAccount;
import pe.com.intralot.loto.layer.model.domain.Reclamacion;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientSaleDao;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * <p>
 * NOMBRE: ClientSaleDaoImpl.java
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
 * 002   Cristian Cortez  25/06/2018  Métodos para la activación y rechazo del bono TA por recargas Interbank
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

@Repository
public class ClientSaleDaoImpl extends HibernateBaseDaoImpl implements ClientSaleDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
    public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<ClientProcedureAccountData> resultQuery = new ArrayList<ClientProcedureAccountData>();
        ClientProcedureAccountData objectDomain = new ClientProcedureAccountData();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_ACCOUNTDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findAccountData cid=" + p_clientId+" w_client_name=" + objectDomain.getClientName() + " w_mail_status=" + objectDomain.getMailStatus() + " w_balance_amount="
                        + objectDomain.getBalanceAmount() + " w_promotional=" + objectDomain.getPromotional() + " w_num_prizes=" + objectDomain.getNumPrizes()
                        + " w_neoprize_amount=" + objectDomain.getNeoprizeAmount() + " w_kironprize_amount=" + objectDomain.getKironPrizeAmount() + " w_bonus_status=" + objectDomain.getBonusStatus()
                        + " w_bonus_message=" + objectDomain.getBonusMessage() + " w_bonus_date=" + objectDomain.getBonusDate() + " w_bonus_client_status=" + objectDomain.getBonusClientStatus()
                        + " w_bonus_added_balance=" + objectDomain.getBonusAddedBalance() + " w_bonus_forplay=" + objectDomain.getBonusForPlay() + " w_bonus_last_date=" + objectDomain.getBonusLastDate()
                        + " w_min_odd=" + objectDomain.getMinOdd() + " w_bonus_amount=" + objectDomain.getBonusAmount() + " w_bonus_limit=" + objectDomain.getBonusLimit() + " w_bonus_percentage=" + objectDomain.getBonusPercentage()
                		+ " welcomeBonusStatus=" + objectDomain.getWelcomeBonusStatus() +" welcomeBonusPercentaje=" + objectDomain.getWelcomeBonusPercentaje() + " welcomeBonusMessage=" + objectDomain.getWelcomeBonusMessage()
                		+ " welcomeBonusLastDate=" + objectDomain.getWelcomeBonusLastDate() + " w_bonus_game=" + objectDomain.getBonusGame() + " w_other_amount=" + objectDomain.getOtherAmount()+" w_other_quantity=" + objectDomain.getOtherQuantity());
        }
        return objectDomain;
    }
    
    @Override
    public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception {
    	try {
			super.save(clientAddressLog);
		} catch (Exception e) {
			 LoggerApi.severe(e);
	         throw e;
		}
    }

    @Override
    public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception {
        LoggerApi.Log.info("user=" + p_user + " password=***");
        List<ClientProcedureLogin> resultQuery = new ArrayList<ClientProcedureLogin>();
        ClientProcedureLogin objectDomain = new ClientProcedureLogin();
        try {
            Object[] values = new Object[2];
            values[0] = p_user;
            values[1] = StringLib.encodeLabel(p_password);
            resultQuery = super.findForNamed("CLIENTSALE_LOGIN", values);
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
                        + " p_agreement=" + objectDomain.getAgreement() + " p_mail_verified=" + objectDomain.getMailVerified()+ " p_mobile_phone=" + objectDomain.getMobilePhone()+ " p_mobile_sms_status=" + objectDomain.getMobileStatus()
                        + " p_promotion=" + objectDomain.getPromotion() + " p_promotion_ibk=" + objectDomain.getPromotionibk());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedurePutClient findPutclient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pNombre=" + clientBean.getpNombre() + " pApPaterno=" + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate="
                + clientBean.getpBirthDate() + " pTypeId=" + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName()
                + " pGender=" + clientBean.getpGender() + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1()
                + " pMail2=" + clientBean.getpMail2() + " pConfirm=" + clientBean.getpConfirm() + " pPassword= ***" + " pCountry=" + clientBean.getpCountry() + " pRegion="
                + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers=" + clientBean.getpPNnumbers()
                + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId=" + clientBean.getpComNumberId() + " pComName="
                + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry=" + clientBean.getpCountry() + " pComRegion="
                + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress() + " pMode=" + clientBean.getpMode());
        List<ClientProcedurePutClient> resultQuery = new ArrayList<ClientProcedurePutClient>();
        ClientProcedurePutClient objectDomain = new ClientProcedurePutClient();
        try {
            Object[] values = new Object[30];
            values[0] = clientBean.getpNombre();
            values[1] = clientBean.getpApPaterno();
            values[2] = clientBean.getpApMaterno();
            values[3] = clientBean.getpBirthDate();
            values[4] = clientBean.getpTypeId();
            values[5] = clientBean.getpNumberId();
            values[6] = clientBean.getpNickName();
            values[7] = clientBean.getpGender();
            values[8] = clientBean.getpMarital();
            values[9] = clientBean.getpUser();
            values[10] = clientBean.getpMail1();
            values[11] = clientBean.getpMail2();
            values[12] = clientBean.getpConfirm();
            values[13] = StringLib.encodeLabel(clientBean.getpPassword());
            values[14] = clientBean.getpCountry();
            values[15] = clientBean.getpRegion();
            values[16] = clientBean.getpAddress();
            values[17] = clientBean.getpTerms();
            values[18] = clientBean.getpPNnumbers();
            values[19] = clientBean.getpPNumbers00();
            values[20] = clientBean.getpComTypeId();
            values[21] = clientBean.getpComNumberId();
            values[22] = clientBean.getpComName();
            values[23] = clientBean.getpComPhones();
            values[24] = clientBean.getpCountry();
            values[25] = clientBean.getpComRegion();
            values[26] = clientBean.getpComAddress();
            values[27] = clientBean.getpMode();
            //values[28] = clientBean.getpLuckyIcon();
            values[28] = clientBean.getpFixedPhone();
            values[29] = clientBean.getpMobilePhone();
            resultQuery = super.findForNamed("CLIENTSALE_PUTCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() 
                        + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    @Override
    public ClientProcedurePutNewClient putNewClient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pNombre=" + clientBean.getpNombre() + " pApPaterno=" + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate="
                + clientBean.getpBirthDate() + " pTypeId=" + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName()
                + " pGender=" + clientBean.getpGender() + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1()
                + " pMail2=" + clientBean.getpMail2() + " pConfirm=" + clientBean.getpConfirm() + " pPassword= ***" + " pCountry=" + clientBean.getpCountry() + " pRegion="
                + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers=" + clientBean.getpPNnumbers()
                + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId=" + clientBean.getpComNumberId() + " pComName="
                + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry=" + clientBean.getpCountry() + " pComRegion="
                + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress() + " pMode=" + clientBean.getpMode()+ " pReniecValid=" + clientBean.getpReniecValid());
        List<ClientProcedurePutNewClient> resultQuery = new ArrayList<ClientProcedurePutNewClient>();
        ClientProcedurePutNewClient objectDomain = new ClientProcedurePutNewClient();
        try {
        	Object[] values = null;//new Object[31];
        	if(clientBean.getpReniecValid()!=null && !clientBean.getpReniecValid().trim().equals("")) values = new Object[32];
        	else values = new Object[31];
            values[0] = clientBean.getpNombre();
            values[1] = clientBean.getpApPaterno();
            values[2] = clientBean.getpApMaterno();
            values[3] = clientBean.getpBirthDate();
            values[4] = clientBean.getpTypeId();
            values[5] = clientBean.getpNumberId();
            values[6] = clientBean.getpNickName();
            values[7] = clientBean.getpGender();
            values[8] = clientBean.getpMarital();
            values[9] = clientBean.getpUser();
            values[10] = clientBean.getpMail1();
            values[11] = clientBean.getpMail2();
            values[12] = clientBean.getpConfirm();
            values[13] = StringLib.encodeLabel(clientBean.getpPassword());
            values[14] = clientBean.getpCountry();
            values[15] = clientBean.getpRegion();
            values[16] = clientBean.getpAddress();
            values[17] = clientBean.getpTerms();
            values[18] = clientBean.getpPNnumbers();
            values[19] = clientBean.getpPNumbers00();
            values[20] = clientBean.getpComTypeId();
            values[21] = clientBean.getpComNumberId();
            values[22] = clientBean.getpComName();
            values[23] = clientBean.getpComPhones();
            values[24] = clientBean.getpCountry();
            values[25] = clientBean.getpComRegion();
            values[26] = clientBean.getpComAddress();
            values[27] = clientBean.getpMode();
            values[28] = clientBean.getpLuckyIcon();
            values[29] = clientBean.getpFixedPhone();
            values[30] = clientBean.getpMobilePhone();
            if(clientBean.getpReniecValid()!=null && !clientBean.getpReniecValid().trim().equals("")) values[31] = clientBean.getpReniecValid();//reniecValidStatus
            resultQuery = super.findForNamed("CLIENTSALE_PUTNEWCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() + " p_mail_code=" + objectDomain.getMailCode()
                        + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureUpdateClient updateClient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pSessionid=" + clientBean.getpSessionid() + " pClientid=" + clientBean.getpClientid() + " pNombre=" + clientBean.getpNombre() + " pApPaterno="
                + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate=" + clientBean.getpBirthDate() + " pTypeId="
                + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName() + " pGender=" + clientBean.getpGender()
                + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1() + " pMail2=" + clientBean.getpMail2()
                + " pConfirm=" + clientBean.getpConfirm() + " pPrevpass=" + clientBean.getpPrevpass() + " pPassword=***" + " pCountry=" + clientBean.getpCountry()
                + " pRegion=" + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers="
                + clientBean.getpPNnumbers() + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId="
                + clientBean.getpComNumberId() + " pComName=" + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry="
                + clientBean.getpCountry() + " pComRegion=" + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress());
        List<ClientProcedureUpdateClient> resultQuery = new ArrayList<ClientProcedureUpdateClient>();
        ClientProcedureUpdateClient objectDomain = new ClientProcedureUpdateClient();
        try {
            Object[] values = new Object[32];
            values[0] = clientBean.getpSessionid();
            values[1] = clientBean.getpClientid();
            values[2] = clientBean.getpNombre();
            values[3] = clientBean.getpApPaterno();
            values[4] = clientBean.getpApMaterno();
            values[5] = clientBean.getpBirthDate();
            values[6] = clientBean.getpTypeId();
            values[7] = clientBean.getpNumberId();
            values[8] = clientBean.getpNickName();
            values[9] = clientBean.getpGender();
            values[10] = clientBean.getpMarital();
            values[11] = clientBean.getpUser();
            values[12] = clientBean.getpMail1();
            values[13] = clientBean.getpMail2();
            values[14] = clientBean.getpConfirm();
            values[15] = clientBean.getpPrevpass();
            values[16] = clientBean.getpPassword();
            values[17] = clientBean.getpCountry();
            values[18] = clientBean.getpRegion();
            values[19] = clientBean.getpAddress();
            values[20] = clientBean.getpTerms();
            values[21] = clientBean.getpPNnumbers();
            values[22] = clientBean.getpPNumbers00();
            values[23] = clientBean.getpComTypeId();
            values[24] = clientBean.getpComNumberId();
            values[25] = clientBean.getpComName();
            values[26] = clientBean.getpComPhones();
            values[27] = clientBean.getpCountry();
            values[28] = clientBean.getpComRegion();
            values[29] = clientBean.getpComAddress();
            //values[30] = clientBean.getpLuckyIcon();
            values[30] = clientBean.getpFixedPhone();
            values[31] = clientBean.getpMobilePhone();
            resultQuery = super.findForNamed("CLIENTSALE_UPDATECLIENT", values);
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
    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
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
            if (objectDomain != null)
                LoggerApi.Log.info("p_nombre=" + objectDomain.getNombre() + " p_birthdate=" + objectDomain.getBirthdate() + " p_mail=" + objectDomain.getMail()
                        + " p_mailstatus=" + objectDomain.getMailstatus() + " p_item=" + objectDomain.getItem() + " p_amount=" + objectDomain.getAmount() + " p_mail2="
                        + objectDomain.getMail2() + " p_mail2status=" + objectDomain.getMail2status() + " p_address=" + objectDomain.getAddress() + " p_region="
                        + objectDomain.getRegion() + " p_country=" + objectDomain.getCountry() + " p_status=" + objectDomain.getStatus() + " p_terms="
                        + objectDomain.getTerms() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_fixed_phone=" + objectDomain.getFixedPhone() + " p_mobile_phone="
                        + objectDomain.getMobilePhone() + " p_mail_code=" + objectDomain.getMailCode());
        }
        return objectDomain;
    }
    
    @Override
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
				resultQuery = super.find(queryString, values);
				objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch(Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("IdClient=" + objectDomain.getIdClient() + " User=" + objectDomain.getUser() + " Name=" + objectDomain.getName()
                + " Mail=" + objectDomain.getMail() + " MailStatus=" + objectDomain.getMailStatus());
		}
	 	return objectDomain;
	}

    @Override
    public ClientProcedureSessionData updateRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid + " p_randomcode=" + p_randomcode);
        List<ClientProcedureSessionData> resultQuery = new ArrayList<ClientProcedureSessionData>();
        ClientProcedureSessionData objectDomain = new ClientProcedureSessionData();
        try {
            Object[] values = new Object[3];
            values[0] = p_sessionid;
            values[1] = p_clientid;
            values[2] = p_randomcode;
            resultQuery = super.findForNamed("CLIENTSALE_SESSIONDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("message=" + objectDomain.getMessage() + " sessionDate=" + objectDomain.getSessiondate());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureNewSessionData setRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid + " p_randomcode=" + p_randomcode);
        List<ClientProcedureNewSessionData> resultQuery = new ArrayList<ClientProcedureNewSessionData>();
        ClientProcedureNewSessionData objectDomain = new ClientProcedureNewSessionData();
        try {
            Object[] values = new Object[3];
            values[0] = p_sessionid;
            values[1] = p_clientid;
            values[2] = p_randomcode;
            resultQuery = super.findForNamed("CLIENTSALE_NEWSESSIONDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("message=" + objectDomain.getMessage() + "sessionDate=" + objectDomain.getSessiondate());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureSaleLoadPrepaidCard findSaleLoadPrepaidCard(Integer p_clientId, String p_company, String p_carrier, String p_phone, String p_ip, String p_pin)
            throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId + " company=" + p_company + " carrier=" + p_carrier + " phone=" + p_phone + " ip=" + p_ip + " pin="
                + StringLib.cover(p_pin));
        List<ClientProcedureSaleLoadPrepaidCard> resultQuery = new ArrayList<ClientProcedureSaleLoadPrepaidCard>();
        ClientProcedureSaleLoadPrepaidCard objectDomain = new ClientProcedureSaleLoadPrepaidCard();
        try {
            Object[] values = new Object[6];
            values[0] = p_clientId;
            values[1] = p_company;
            values[2] = p_carrier;
            values[3] = p_phone;
            values[4] = p_ip;
            values[5] = StringLib.encodeLabel(p_pin);
            resultQuery = super.findForNamed("CLIENTSALE_SALELOADPREPAIDCARD", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("w_amount_loaded=" + objectDomain.getAmountLoaded() + " w_new_amount=" + objectDomain.getNewAmount() + " w_client_id="
                        + objectDomain.getClientId() + " w_balance_item=" + objectDomain.getBalanceItem() + " w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    
    

    @Override
    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
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
            if (objectDomain != null)
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
                        + " p_control_last_date=" + objectDomain.getControlLastDate()+ " p_insert_date=" + objectDomain.getInsertDate());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureGetNewCode findGetNewCode(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId);
        List<ClientProcedureGetNewCode> resultQuery = new ArrayList<ClientProcedureGetNewCode>();
        ClientProcedureGetNewCode objectDomain = new ClientProcedureGetNewCode();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_GETNEWCODE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_mail_code=" + objectDomain.getMailCode() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureUpdateMail findUpdateMail(Integer p_clientId, String p_mail) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId + " p_mail=" + p_mail);
        List<ClientProcedureUpdateMail> resultQuery = new ArrayList<ClientProcedureUpdateMail>();
        ClientProcedureUpdateMail objectDomain = new ClientProcedureUpdateMail();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_mail;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEMAIL", values);
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

    @Override
    public ClientProcedureActivateClient findActivateClient(Integer p_clientId, String p_mailCode) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId + " p_mailCode=" + p_mailCode);
        List<ClientProcedureActivateClient> resultQuery = new ArrayList<ClientProcedureActivateClient>();
        ClientProcedureActivateClient objectDomain = new ClientProcedureActivateClient();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_mailCode;
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATECLIENT", values);
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

    @Override
    public ClientProcedureUpdatePassword findUpdatePassword(Integer p_clientId, String p_password) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId + " p_password= ***");
        List<ClientProcedureUpdatePassword> resultQuery = new ArrayList<ClientProcedureUpdatePassword>();
        ClientProcedureUpdatePassword objectDomain = new ClientProcedureUpdatePassword();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_password;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEPASSWORD", values);
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

    @Override
    public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail+" findGetPasswordCode");
        List<ClientProcedureGetPasswordCode> resultQuery = new ArrayList<ClientProcedureGetPasswordCode>();
        ClientProcedureGetPasswordCode objectDomain = new ClientProcedureGetPasswordCode();
        try {
            Object[] values = new Object[2];
            values[0] = p_mail;
            values[1] = p_password_code;
            resultQuery = super.findForNamed("CLIENTUPDATE_GETPASSWORDCODE", values);
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

    @Override
    public ClientProcedureResetNewPassword resetNewPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail);
        List<ClientProcedureResetNewPassword> resultQuery = new ArrayList<ClientProcedureResetNewPassword>();
        ClientProcedureResetNewPassword objectDomain = new ClientProcedureResetNewPassword();
        try {
            Object[] values = new Object[4];
            values[0] = p_mail;
            values[1] = p_password_code;
            values[2] = p_password_1;
            values[3] = p_password_2;
            resultQuery = super.findForNamed("CLIENTUPDATE_RESETNEWPASSWORD", values);
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

    @Override
    public ClientProcedureActivateClientSamp activateClientSamp(String p_client_id, String p_mail, String p_mail_code, String p_random_code, String p_game_code)
            throws Exception {
        LoggerApi.Log.info("p_client_id=" + p_client_id + " p_mail=" + p_mail + " p_mail_code=" + p_mail_code + " p_random_code=" + p_random_code + " p_game_code="
                + p_game_code);
        List<ClientProcedureActivateClientSamp> resultQuery = new ArrayList<ClientProcedureActivateClientSamp>();
        ClientProcedureActivateClientSamp objectDomain = new ClientProcedureActivateClientSamp();
        try {
            Object[] values = new Object[5];
            values[0] = p_client_id;
            values[1] = p_mail;
            values[2] = p_mail_code;
            values[3] = p_random_code;
            values[4] = p_game_code;
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATECLIENTSAMP", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage() + " p_game_message="
                        + objectDomain.getGameMessage());
        }
        return objectDomain;
    }

	@Override
	public PromoFirstAccount promotionFirstAccount(Integer cb_client_id,
			Integer cb_balance_item) throws Exception {
		LoggerApi.Log.info("cb_client_id=" + cb_client_id + " cb_balance_item=" + cb_balance_item);
		List<PromoFirstAccount> resultQuery = new ArrayList<PromoFirstAccount>();
		PromoFirstAccount objectDomain = new PromoFirstAccount();
		try{
			Object[] values = new Object[2];
			values[0] = cb_client_id;
			values[1] = cb_balance_item;
			resultQuery = super.findForNamed("CLIENTSALE_PROMO_FIRST_ACCOUNT", values);
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

	@Override
	public ClientProcedureVerifyClientPromo verifyClientPromo(String p_client_id,
			String p_mail, String p_mail_code, String p_random_code)
			throws Exception {
		 LoggerApi.Log.info("p_client_id=" + p_client_id + " p_mail=" + p_mail + " p_mail_code=" + p_mail_code + " p_random_code=" + p_random_code);
	        List<ClientProcedureVerifyClientPromo> resultQuery = new ArrayList<ClientProcedureVerifyClientPromo>();
	        ClientProcedureVerifyClientPromo objectDomain = new ClientProcedureVerifyClientPromo();
	        try {
	            Object[] values = new Object[4];
	            values[0] = p_client_id;
	            values[1] = p_mail;
	            values[2] = p_mail_code;
	            values[3] = p_random_code;
	            resultQuery = super.findForNamed("CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENTPROMO", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage() + " p_game_message="
	                        + objectDomain.getGameMessage());
	        }
	        return objectDomain;
	}

	@Override
	public String updateClientPromo(ClientBean clientBean)
			throws Exception {
		LoggerApi.Log.info("pSessionid=" + clientBean.getpSessionid() + " pClientid=" + clientBean.getpClientid() + " pNombre=" + clientBean.getpNombre() + " pApPaterno="
	                + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate=" + clientBean.getpBirthDate() + " pTypeId="
	                + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName() + " pGender=" + clientBean.getpGender()
	                + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1() + " pMail2=" + clientBean.getpMail2()
	                + " pConfirm=" + clientBean.getpConfirm() + " pPrevpass=" + clientBean.getpPrevpass() + " pPassword=***" + " pCountry=" + clientBean.getpCountry()
	                + " pRegion=" + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers="
	                + clientBean.getpPNnumbers() + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId="
	                + clientBean.getpComNumberId() + " pComName=" + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry="
	                + clientBean.getpCountry() + " pComRegion=" + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress());
	        List<ClientProcedureUpdatePromo> resultQuery = new ArrayList<ClientProcedureUpdatePromo>();
	        ClientProcedureUpdatePromo objectDomain = new ClientProcedureUpdatePromo();
	        try {
	            Object[] values = new Object[33];
	            values[0] = clientBean.getpSessionid();
	            values[1] = clientBean.getpClientid();
	            values[2] = clientBean.getpNombre();
	            values[3] = clientBean.getpApPaterno();
	            values[4] = clientBean.getpApMaterno();
	            values[5] = clientBean.getpBirthDate();
	            values[6] = clientBean.getpTypeId();
	            values[7] = clientBean.getpNumberId();
	            values[8] = clientBean.getpNickName();
	            values[9] = clientBean.getpGender();
	            values[10] = clientBean.getpMarital();
	            values[11] = clientBean.getpUser();
	            values[12] = clientBean.getpMail1();
	            values[13] = clientBean.getpMail2();
	            values[14] = clientBean.getpConfirm();
	            values[15] = clientBean.getpPrevpass();
	            values[16] = clientBean.getpPassword();
	            values[17] = clientBean.getpCountry();
	            values[18] = clientBean.getpRegion();
	            values[19] = clientBean.getpAddress();
	            values[20] = clientBean.getpTerms();
	            values[21] = clientBean.getpPNnumbers();
	            values[22] = clientBean.getpPNumbers00();
	            values[23] = clientBean.getpComTypeId();
	            values[24] = clientBean.getpComNumberId();
	            values[25] = clientBean.getpComName();
	            values[26] = clientBean.getpComPhones();
	            values[27] = clientBean.getpCountry();
	            values[28] = clientBean.getpComRegion();
	            values[29] = clientBean.getpComAddress();
	            values[30] = clientBean.getpLuckyIcon();
	            values[31] = clientBean.getpFixedPhone();
	            values[32] = clientBean.getpMobilePhone();
	     	            
	            resultQuery = super.findForNamed("CLIENTSALE_UPDATECLIENTPROMO", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info(" p_message=" + objectDomain.getMessage());
	        }
	        return "OK";


	}
	
	/*@Override
	public ClientProcedureVerifyClient verifyClient(String p_client_id,
			String p_mail, String p_mail_code)
			throws Exception {
		 LoggerApi.Log.info("p_client_id=" + p_client_id + " p_mail=" + p_mail + " p_mail_code=" + p_mail_code);
	        List<ClientProcedureVerifyClientPromo> resultQuery = new ArrayList<ClientProcedureVerifyClientPromo>();
	        ClientProcedureVerifyClientPromo objectDomain = new ClientProcedureVerifyClientPromo();
	        try {
	            Object[] values = new Object[4];
	            values[0] = p_client_id;
	            values[1] = p_mail;
	            values[2] = p_mail_code;
	            values[3] = p_random_code;
	            resultQuery = super.findForNamed("CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENTPROMO", values);
	            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (objectDomain != null)
	                LoggerApi.Log.info("p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage() + " p_game_message="
	                        + objectDomain.getGameMessage());
	        }
	        return objectDomain;
	}*/
	
	@Override
	public ClientProcedureVerifyClient verifyClient(String p_client_id,
	String p_mail, String p_mail_code)
	throws Exception {
		LoggerApi.Log.info("p_client_id=" + p_client_id + " p_mail=" + p_mail + " p_mail_code=" + p_mail_code);
		List<ClientProcedureVerifyClient> resultQuery = new ArrayList<ClientProcedureVerifyClient>();
		ClientProcedureVerifyClient objectDomain = new ClientProcedureVerifyClient();
		try {
		    Object[] values = new Object[2];
		    values[0] = p_client_id;
		    values[1] = p_mail_code;
		    resultQuery = super.findForNamed("CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENT", values);
		    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch (Exception e) {
		    LoggerApi.severe(e);
		    throw e;
		} finally {
		    if (objectDomain != null)
		        LoggerApi.Log.info("p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}
	
	@Override
	public ClientProcedureVerifyClientBond verifyClientBond(String p_client_id, String p_bond_code)
	throws Exception {
		LoggerApi.Log.info("p_client_id=" + p_client_id + " p_bond_code=" + p_bond_code);
		List<ClientProcedureVerifyClientBond> resultQuery = new ArrayList<ClientProcedureVerifyClientBond>();
		ClientProcedureVerifyClientBond objectDomain = new ClientProcedureVerifyClientBond();
		try {
		    Object[] values = new Object[2];
		    values[0] = p_client_id;
		    values[1] = p_bond_code;
		    resultQuery = super.findForNamed("CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENTBOND", values);
		    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch (Exception e) {
		    LoggerApi.severe(e);
		    throw e;
		} finally {
		    if (objectDomain != null)
		        LoggerApi.Log.info("p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}
	

    @Override
    public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid + " channel=" + channel);
        List<ClientProcedureTokenGeneration> resultQuery = new ArrayList<ClientProcedureTokenGeneration>();
        ClientProcedureTokenGeneration objectDomain = new ClientProcedureTokenGeneration();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientid;
            values[1] = channel;
            values[2] = ip;
            resultQuery = super.findForNamed("CLIENTSALE_TOKENGENERATION", values);
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
    
    @Override
	public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureLPTokenGeneration> resultQuery = new ArrayList<ClientProcedureLPTokenGeneration>();
        ClientProcedureLPTokenGeneration objectDomain = new ClientProcedureLPTokenGeneration();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientid;
            values[1] = ip;
            resultQuery = super.findForNamed("LAPOLLAWS_TOKENGENERATION", values);
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

    @Override
	public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid);
        List<ClientProcedureTANTokenGeneration> resultQuery = new ArrayList<ClientProcedureTANTokenGeneration>();
        ClientProcedureTANTokenGeneration objectDomain = new ClientProcedureTANTokenGeneration();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientid;
            values[1] = ip;
            resultQuery = super.findForNamed("TEAPUESTOIFLEXMOBILE_TOKENGENERATION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("playerId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
	}
    
    @Override
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

    @Override
    public ClientProcedureUpdateAgreement updateAgreement(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId);
        List<ClientProcedureUpdateAgreement> resultQuery = new ArrayList<ClientProcedureUpdateAgreement>();
        ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEAGREEMENT", values);
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
    
    @Override
    public int findClientDNI(String dni) throws Exception {
		List<Long> resultQueryList = new ArrayList<Long>();
		Integer objectDomain = 0;
		try {
			Object[] values = new Object[3];
			values[0] = "S";
			values[1] = "DNI";
			values[2] = dni;
			String queryString = "SELECT COUNT(*) FROM Client c WHERE c.reniecValidStatus=? AND c.docType=? AND c.docNumber=?";
			resultQueryList = super.find(queryString, values);
			//for(int i=0;i<resultQueryList.size();i++) System.out.println(i+1+")"+resultQueryList.get(i));
			objectDomain = Integer.parseInt(DataAccessUtils.uniqueResult(resultQueryList).toString());
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(objectDomain != null)
				LoggerApi.Log.info("count=" + objectDomain);
		}
		return objectDomain;
	}

	@Override
	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId, String p_sms) throws Exception {
		 	LoggerApi.Log.info("p_clientId=" + p_clientId + " p_sms=" + p_sms);
	        List<ClientProcedurePutSmsRegisterData> resultQuery = new ArrayList<ClientProcedurePutSmsRegisterData>();
	        ClientProcedurePutSmsRegisterData objectDomain = new ClientProcedurePutSmsRegisterData();
	        try {
	            Object[] values = new Object[2];
	            values[0] = p_clientId;
	            values[1] = p_sms;
	            resultQuery = super.findForNamed("CLIENTSALE_PUTSMSREGISTERDATA", values);
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
	public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId, String p_sms, Integer p_time_minutes)
			throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_sms=" + p_sms + " p_time_minutes=" + p_time_minutes);
        List<ClientProcedureUpdateSmsRegister> resultQuery = new ArrayList<ClientProcedureUpdateSmsRegister>();
        ClientProcedureUpdateSmsRegister objectDomain = new ClientProcedureUpdateSmsRegister();
        try {
            Object[] values = new Object[3];
            values[0] = p_clientId;
            values[1] = p_sms;
            values[2] = p_time_minutes;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATESMSREGISTER", values);
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
	public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_phone=" + p_phone);
        List<ClientProcedureUpdatePhone> resultQuery = new ArrayList<ClientProcedureUpdatePhone>();
        ClientProcedureUpdatePhone objectDomain = new ClientProcedureUpdatePhone();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_phone;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEPHONE", values);
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
	public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivatePromotion> resultQuery = new ArrayList<ClientProcedureActivatePromotion>();
        ClientProcedureActivatePromotion objectDomain = new ClientProcedureActivatePromotion();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATEPROMOTION", values);
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
	public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivateWBPromotion> resultQuery = new ArrayList<ClientProcedureActivateWBPromotion>();
        ClientProcedureActivateWBPromotion objectDomain = new ClientProcedureActivateWBPromotion();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATEWBPROMOTION", values);
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
	public ClientProcedureCancelPromotion cancelPromotion(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureCancelPromotion> resultQuery = new ArrayList<ClientProcedureCancelPromotion>();
        ClientProcedureCancelPromotion objectDomain = new ClientProcedureCancelPromotion();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_CANCELPROMOTION", values);
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
	public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivatePromotionibk> resultQuery = new ArrayList<ClientProcedureActivatePromotionibk>();
        ClientProcedureActivatePromotionibk objectDomain = new ClientProcedureActivatePromotionibk();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATEPROMOTIONIBK", values);
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
	public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureActivateWBPromotionibk> resultQuery = new ArrayList<ClientProcedureActivateWBPromotionibk>();
        ClientProcedureActivateWBPromotionibk objectDomain = new ClientProcedureActivateWBPromotionibk();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_ACTIVATEWBPROMOTIONIBK", values);
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
	public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values) throws Exception {
		LoggerApi.Log.info("p_clientid=" + values[0] + " p_balance_item=" + values[1]);
        List<ClientProcedureCancelPromotionibk> resultQuery = new ArrayList<ClientProcedureCancelPromotionibk>();
        ClientProcedureCancelPromotionibk objectDomain = new ClientProcedureCancelPromotionibk();
        try {
            resultQuery = super.findForNamed("CLIENTSALE_CANCELPROMOTIONIBK", values);
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
	public PinPrinted findLotocard(String pin) throws Exception {
		PinPrinted objectDomain = new PinPrinted();
		List<PinPrinted> resultQuery = new ArrayList<PinPrinted>();
		String queryString = "FROM PinPrinted p WHERE p.pinNumberId=?";
		Object[] values = new Object[1];
		values[0] = StringLib.encodeLabel(pin);
		resultQuery = super.find(queryString, values);
		objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}

	@Override
	public String findMobileSmsStatus(Integer clientId) {
		List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = null;
		try {
			Object[] values = new Object[1];
			values[0] = clientId;
			String queryString = "FROM Client c WHERE c.idClient=?";
			resultQuery = super.find(queryString, values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			if(objectDomain != null)
				LoggerApi.Log.info("MobileSmsStatus=" + objectDomain.getMobileSmsStatus());
		}
		return objectDomain.getMobileSmsStatus();
	}
	
	@Override
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception {
		LoggerApi.Log.info("codePromotional="+values[0]+" clientId="+values[1]+" channel="+values[2]+" carrier="+values[3]+" amount="+values[4]+" ip="+values[5]);
        List<ClientProcedureCodeValidation> resultQuery = new ArrayList<ClientProcedureCodeValidation>();
        ClientProcedureCodeValidation objectDomain = new ClientProcedureCodeValidation();
        try {
            resultQuery = super.findForNamed("RECARGAWEB_APPLY_CODE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info(" p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage() + " p_id_code=" + objectDomain.getIdCodePromotional());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<ClientProcedureAccountDataPart> resultQuery = new ArrayList<ClientProcedureAccountDataPart>();
        ClientProcedureAccountDataPart objectDomain = new ClientProcedureAccountDataPart();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = super.findForNamed("CLIENTSALE_ACCOUNTDATAPART", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findAccountDataPart cid=" + p_clientId+" w_client_user=" + objectDomain.getClientUser() + " w_balance_amount=" + objectDomain.getBalanceAmount() 
                		+ " w_bonus_amount=" + objectDomain.getBonusAmount() + " w_other_amount=" + objectDomain.getOtherAmount());
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
	
	@Override
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_player_id_xpg) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_player_id_xpg=" + p_player_id_xpg);
        List<ClientProcedureUpdatePlayerId> resultQuery = new ArrayList<ClientProcedureUpdatePlayerId>();
        ClientProcedureUpdatePlayerId objectDomain = new ClientProcedureUpdatePlayerId();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_player_id_xpg;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEPLAYERID", values);
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
	public ClientProcedureGetPlayerId findGetPlayerId(Integer p_clientid) throws Exception {
		LoggerApi.Log.info("p_clientid=" + p_clientid );
        List<ClientProcedureGetPlayerId> resultQuery = new ArrayList<ClientProcedureGetPlayerId>();
        ClientProcedureGetPlayerId objectDomain = new ClientProcedureGetPlayerId();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientid;
            resultQuery = super.findForNamed("CLIENTSALE_GETPLAYERID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_player_id_xpg=" + objectDomain.getPlayerIdXpg());
        }
        return objectDomain;
	}
	
	@Override
	public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientId, String p_device) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_device=" + p_device);
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
	
	@Override
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
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws 
	Exception{ 
		List<ClientProcedureGetCasinoProductList> resultQueryList =  new ArrayList<ClientProcedureGetCasinoProductList>();
			try {			
		    resultQueryList = super.findForNamed("CLIENTSALE_GETCASINOPRODUCTS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETCASINOPRODUCTSORDER",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYAPRODUCTS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYAPRODUCTSORDER",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYAPRODUCTSPRICE",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYAPRODUCTSPOZO",null);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
    
    @Override
	public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception {
		LoggerApi.Log.info("p_name=" + p_name );
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
                LoggerApi.Log.info("w_game_id=" + objectDomain.getGameId());
        }
        return objectDomain;
	}
    
    @Override
	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId,String phoneUpdateAgora, String phoneUpdate) throws Exception {
		LoggerApi.Log.info("updateStateRechargeAgora cid=" + clientId + " phoneUpdateAgora=" + phoneUpdateAgora + " phoneUpdate=" + phoneUpdate);
		List<ClientProcedureUpdateStateRechargeAgora> resultQuery = new ArrayList<ClientProcedureUpdateStateRechargeAgora>();
		ClientProcedureUpdateStateRechargeAgora objectDomain = new ClientProcedureUpdateStateRechargeAgora();
		Object[] values = new Object[3];
        values[0] = clientId;
        values[1] = phoneUpdateAgora;
        values[2] = phoneUpdate;
        resultQuery = super.findForNamed("UPDATE_STATE_RECHARGE_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null)
            LoggerApi.Log.info("updateStateRechargeAgora cid=" + clientId+" o_message=" + objectDomain.getMessage() + " o_result=" + objectDomain.getResult());
		return objectDomain;
	}

	@Override
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate)
			throws Exception {
		LoggerApi.Log.info("validateNewPhoneAgora cid=" + clientId + " phoneUpdate=" + phoneUpdate);
		List<ClientProcedureValidateNewPhoneAgora> resultQuery = new ArrayList<ClientProcedureValidateNewPhoneAgora>();
		ClientProcedureValidateNewPhoneAgora objectDomain = new ClientProcedureValidateNewPhoneAgora();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = phoneUpdate;
        resultQuery = super.findForNamed("VALIDATE_NEW_PHONE_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null)
            LoggerApi.Log.info("validateNewPhoneAgora cid=" + clientId+" o_message=" + objectDomain.getMessage() + " o_result=" + objectDomain.getResult());
		return objectDomain;
	}
	
	@Override
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
	
	@Override
	public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception {
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
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesProductList> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesProductList>();
			try {			
		    resultQueryList = super.findForNamed("CLIENTSALE_GETVIRTUALESPRODUCTS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETVIRTUALESPRODUCTSORDER",null);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetCasinoProviderList> listProviders() throws 
	Exception{ 
		List<ClientProcedureGetCasinoProviderList> resultQueryList =  new ArrayList<ClientProcedureGetCasinoProviderList>();
			try {			
		    resultQueryList = super.findForNamed("CLIENTSALE_GETCASINOPROVIDERS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETCASINOCATEGORYPROVIDERS",null);
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
		String resultado = null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = nombre;
			String queryString ="select c.idClient from Client as c where c.docNumber=trim(lower(?)) and trim(lower(c.nombre))=trim(lower(?))";			
			resultado = DataAccessUtils.uniqueResult(super.find(queryString, params)).toString();
		return resultado;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultado != null){
				LoggerApi.Log.info("findCodUserfilter1 resultQuery =" + resultado);	
			}else{
				LoggerApi.Log.info("findCodUserfilter1 resultQuery =" + "null");
				return "";
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findCodUserfilter2(String dni, String correo) throws Exception {
		String resultado = null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = correo;
			String queryString ="select c.idClient from Client as c where c.docNumber=trim(lower(?)) and trim(lower(c.mail))=trim(lower(?))";						
			resultado = DataAccessUtils.uniqueResult(super.find(queryString, params)).toString();
		return resultado;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultado!=null){
				LoggerApi.Log.info("findCodUserfilter2 resultQuery =" + resultado);	
			}else{
				LoggerApi.Log.info("findCodUserfilter2 resultQuery =" + "null");
				return "";
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findCodUserfilter3(String dni, String celular) throws Exception {
		String resultado = null;
		try {			
			Object params[] = new Object[2];
			params[0] = dni;
			params[1] = celular;
			String queryString ="select c.idClient from Client as c where c.docNumber=trim(lower(?)) and trim(lower(c.mobilePhone))=trim(lower(?))";			
			resultado = DataAccessUtils.uniqueResult(super.find(queryString, params)).toString();
		return resultado;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			if(resultado!=null){
				LoggerApi.Log.info("findCodUserfilter3 resultQuery =" + resultado);	
			}else{
				LoggerApi.Log.info("findCodUserfilter3 resultQuery =" + "null");
				return "";
			}
		}
	}
	
	@Override
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
            LoggerApi.Log.info("getFavoriteProductvirtuales client_id=" + client_id);
        }
        return result;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws 
	Exception{ 
		List<ClientProcedureGetVirtualesProviderList> resultQueryList =  new ArrayList<ClientProcedureGetVirtualesProviderList>();
			try {			
		    resultQueryList = super.findForNamed("CLIENTSALE_GETVIRTUALESPROVIDERS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETVIRTUALESCATEGORYPROVIDERS",null);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@Override
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

	@Override
	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId)  throws Exception {
		LoggerApi.Log.info("p_clientId=" + clientId );
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
	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception {
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
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws 
	Exception{ 
		List<ClientProcedureGetRaspayaProviderList> resultQueryList =  new ArrayList<ClientProcedureGetRaspayaProviderList>();
			try {			
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYAPROVIDERS",null);
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
		    resultQueryList = super.findForNamed("CLIENTSALE_GETRASPAYACATEGORYPROVIDERS",null);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            
        }
        return resultQueryList;		
	}
	
	@Override
	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<ProcedureYapePlinVerifyTransaction> resultQuery = new ArrayList<ProcedureYapePlinVerifyTransaction>();
        ProcedureYapePlinVerifyTransaction objectDomain = new ProcedureYapePlinVerifyTransaction();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = channel;
            resultQuery = super.findForNamed("YAPE_PLIN_VERIFY_TRANSACTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("yapePlinVerifyTransaction cid=" + p_clientId+" amount=" + objectDomain.getAmount() + " status=" + objectDomain.getStatus());
        }
        return objectDomain;
	}

	@Transactional(readOnly = false)
	public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception {
        List<ClientProcedureTokenValidation> resultQuery = new ArrayList<ClientProcedureTokenValidation>();
        ClientProcedureTokenValidation objectDomain = new ClientProcedureTokenValidation();
        Object[] values = new Object[2];
        values[0] = p_token;
        values[1] = ip;
        resultQuery = super.findForNamed("RECARGAWEB_TOKENVALIDATION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);   
        return objectDomain;
	}

	@Override
	public ClientProcedureUpdateVisaSession setVisaSession(int p_clientid, String p_visasession) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientid + " p_visasession=" + p_visasession);
		List<ClientProcedureUpdateVisaSession> resultQuery = new ArrayList<ClientProcedureUpdateVisaSession>();
		ClientProcedureUpdateVisaSession objectDomain = new ClientProcedureUpdateVisaSession();
		try {
            Object[] values = new Object[2];
            values[0] = p_clientid;
            values[1] = p_visasession;
            resultQuery = super.findForNamed("RECARGAWEB_UPDATEVISASESSION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("state=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public String findVisaSessionById(Integer clientId) throws Exception {
		String resultQuery= null;
		try {			
			Object params[] = new Object[1];
			params[0] = clientId;
			String queryString ="select c.visaSession from Client as c where c.idClient=?";			
			resultQuery= DataAccessUtils.uniqueResult(super.find(queryString,params)).toString();	
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("findVisaSessionById resultQuery =" + resultQuery);	
			}else{
				LoggerApi.Log.info("findVisaSessionById resultQuery =" + "null");
				return "";
			}
		}
		return resultQuery;
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
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount,
			String platform, String operatorId) throws Exception {
		LoggerApi.Log.info("p_client_id=" + clientId+" p_amount="+amount+" p_platform="+platform
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
            resultQuery = super.findForNamed("RECARGAWEB_ORIGINVISARECHARGE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info(" p_platform="+platform + " p_operatorId="+operatorId);
		List<ClientProcedureOriginPefeRecharge> resultQuery = new ArrayList<ClientProcedureOriginPefeRecharge>();
		ClientProcedureOriginPefeRecharge objectDomain = new ClientProcedureOriginPefeRecharge();
		try {
			Object[] values = new Object[3];
            values[0] = transactionId;
            values[1] = platform;
            values[2] = operatorId;
            resultQuery = super.findForNamed("RECARGAWEB_ORIGINPEFERECHARGE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info(" p_platform="+platform + " p_operatorId="+operatorId);
		List<ClientProcedureOriginBcpRecharge> resultQuery = new ArrayList<ClientProcedureOriginBcpRecharge>();
		ClientProcedureOriginBcpRecharge objectDomain = new ClientProcedureOriginBcpRecharge();
		try {
			Object[] values = new Object[3];
            values[0] = transactionId;
            values[1] = platform;
            values[2] = operatorId;
            resultQuery = super.findForNamed("RECARGAWEB_ORIGINBCPRECHARGE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId) throws Exception {
		LoggerApi.Log.info(" p_platform="+platform+" p_operatorId="+operatorId);
		List<ClientProcedureOriginLotocardRecharge> resultQuery = new ArrayList<ClientProcedureOriginLotocardRecharge>();
		ClientProcedureOriginLotocardRecharge objectDomain = new ClientProcedureOriginLotocardRecharge();
		try {
			Object[] values = new Object[3];
            values[0] = transactionId;
            values[1] = platform;
            values[2] = operatorId;
            resultQuery = super.findForNamed("RECARGAWEB_ORIGINLOTOCARDRECHARGE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("state=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@Override
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novus_id) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_novus_id=" + p_novus_id);
        List<ClientProcedureUpdateNovusId> resultQuery = new ArrayList<ClientProcedureUpdateNovusId>();
        ClientProcedureUpdateNovusId objectDomain = new ClientProcedureUpdateNovusId();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_novus_id;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATENOVUSID", values);
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
	public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception {
		LoggerApi.Log.info("p_clientid=" + p_clientid );
        List<ClientProcedureGetNovusId> resultQuery = new ArrayList<ClientProcedureGetNovusId>();
        ClientProcedureGetNovusId objectDomain = new ClientProcedureGetNovusId();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientid;
            resultQuery = super.findForNamed("CLIENTSALE_GETNOVUSID", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_user=" + objectDomain.getClientUser());
        }
        return objectDomain;
	}
	
	@Override
    public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception {
        LoggerApi.Log.info("user=" + p_user + " password=***");
        List<ClientProcedureGetLoginData> resultQuery = new ArrayList<ClientProcedureGetLoginData>();
        ClientProcedureGetLoginData objectDomain = new ClientProcedureGetLoginData();
        try {
            Object[] values = new Object[1];
            values[0] = p_user;
            resultQuery = super.findForNamed("CLIENTSALE_LOGIN_DATA", values);
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
                        + " p_agreement=" + objectDomain.getAgreement() + " p_mail_verified=" + objectDomain.getMailVerified()+ " p_mobile_phone=" + objectDomain.getMobilePhone()+ " p_mobile_sms_status=" + objectDomain.getMobileStatus()
                        + " p_promotion=" + objectDomain.getPromotion() + " p_promotion_ibk=" + objectDomain.getPromotionibk());
        }
        return objectDomain;
    }
	
	@Override
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception {
		LoggerApi.Log.info("p_clientId=" + p_clientId + " p_bonoQr=" + p_bonoQr);
        List<ClientProcedureUpdateBonoQr> resultQuery = new ArrayList<ClientProcedureUpdateBonoQr>();
        ClientProcedureUpdateBonoQr objectDomain = new ClientProcedureUpdateBonoQr();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_bonoQr;
            resultQuery = super.findForNamed("CLIENTSALE_UPDATEBONOQR", values);
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
	public ClientSecurityProcedureCheckIp findGetCheckIp(Integer p_clientId, String p_ip, String p_plataforma) throws Exception  {
		LoggerApi.Log.info("findGetCheckIp clientId=" + p_clientId+" ip="+p_ip);
		List<ClientSecurityProcedureCheckIp> resultQuery = new ArrayList<ClientSecurityProcedureCheckIp>();
		ClientSecurityProcedureCheckIp objectDomain = new ClientSecurityProcedureCheckIp();
		Object[] values = new Object[3];
        values[0] = p_clientId;
        values[1] = p_ip;
        values[2] = p_plataforma;
        
        resultQuery = super.findForNamed("LOTOCARD_CLIENTSECURITYTRANSACTION_CHECKIP", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("findGetCheckIp clientId=" + p_clientId+" ip="+p_ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}

	@Override
	public ClientSecurityWhiteList updateipWhitelis(Integer clientId, String ip, String respuesta_user, String p_plataforma)
			throws Exception {
		LoggerApi.Log.info("updateipWhitelis clientId=" + clientId+" ip="+ip + " respuesta_user:"+respuesta_user + " p_plataforma:"+p_plataforma);
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
        resultQuery = super.findForNamed("LOTOCARD_GET_CLIENTSECURITY_WHITELIST", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("getipWhitelist clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
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
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
        List<ProcedureYapePlinTupayVerifyTransaction> resultQuery = new ArrayList<ProcedureYapePlinTupayVerifyTransaction>();
        ProcedureYapePlinTupayVerifyTransaction objectDomain = new ProcedureYapePlinTupayVerifyTransaction();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = channel;
            resultQuery = super.findForNamed("YAPE_PLIN_TUPAY_VERIFY_TRANSACTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("yapePlinTupayVerifyTransaction cid=" + p_clientId+" amount=" + objectDomain.getAmount() + " status=" + objectDomain.getStatus());
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
	
	@Override
	public ClientGetCollectionType getClientAutoPayment(Integer p_clientId) throws Exception{
        LoggerApi.Log.info("ClientSaleDaoImpl: p_clientid=" + p_clientId);
        ClientGetCollectionType objectDomain = new ClientGetCollectionType();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection conexion = null;
        try {
            conexion = dataSource.getConnection();
            cstmt = conexion.prepareCall("call lotocard.tinkaexpressws.getcollectiontype(?,?)");
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
	public boolean updateAutoPaymentFlag(Integer p_clientId, String switchStatus) throws Exception{
	   LoggerApi.Log.info("ClientSaleDaoImpl updateAutoPaymentFlag: p_clientid=" + p_clientId);
	   boolean updated = false;
	
	    Connection conexion = null;
	    CallableStatement cstmt = null;
	
	    try {
	        conexion = dataSource.getConnection();
	        cstmt = conexion.prepareCall("{ call lotocard.tinkaexpressws.updatecollectiontype(?, ?, ?) }");
	
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