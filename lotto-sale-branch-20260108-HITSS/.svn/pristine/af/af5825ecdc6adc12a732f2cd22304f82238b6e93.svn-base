package pe.com.intralot.loto.layer.service.client.boimpl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import pe.com.intralot.loto.layer.model.domain.ClientProcedureIIVVTokenGeneration;
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
import pe.com.intralot.loto.layer.model.persistence.dao.ClientSaleDao;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.service.client.bo.ClientSaleBo;
//import pe.com.intralot.loto.card.setup.GenerateWinners;
import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.dto.img.ImgDto;
import pe.com.intralot.loto.lib.ConnectionFactory;
//import pe.com.intralot.loto.lib.MailLib;
import pe.com.intralot.loto.lib.StringLib;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.sale.tinkaexpress.GenerateWinners;
import pe.com.intralot.loto.util.Constants;
import pe.com.intralot.loto.util.MailLib;
import pe.com.intralot.loto.www.sale.client.lib.ClientUtils;

/**
 * <p>
 * NOMBRE: ClientSaleBoImpl.java
 * <br></p>
 * <p>
 * FUNCION: Implementación del objeto de lógica del negocio de datos de la cuenta 
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

@Service
public class ClientSaleBoImpl implements ClientSaleBo {

    @Autowired
    private ClientSaleDao clientSaleDao;
    
    @Override
    public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception {
        //LoggerApi.Log.info("cid=" + p_clientId);
        ClientProcedureAccountData objectDomain = new ClientProcedureAccountData();
        try {
            objectDomain = clientSaleDao.findAccountData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
           /* if (objectDomain != null)
                LoggerApi.Log.info("findAccountData cid=" + p_clientId);
           */
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureActivateClient findActivateClient(Integer p_clientId, String p_mailCode) throws Exception {
        LoggerApi.Log.info("p_clientId =" + p_clientId + " p_mailCode =" + p_mailCode);
        ClientProcedureActivateClient objectDomain = new ClientProcedureActivateClient();
        try {
            objectDomain = clientSaleDao.findActivateClient(p_clientId, p_mailCode);
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
    public boolean isAllowedGoIn(String user) {
        boolean isAccountSale = Boolean.valueOf(ConnectionFactory.operationProperty("accountSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String accountSaleUsers = String.valueOf(ConnectionFactory.operationProperty("accountSaleUsers", Constants.contextSale)).toString().trim();
        if (isAccountSale == false) {
            if (accountSaleUsers != null && !accountSaleUsers.equals("")) {
                String[] saleUsers = accountSaleUsers.split(",");
                for (String saleUser : saleUsers)
                    if (saleUser.equals(user)) {
                        isAllowed = true;
                        break;
                    } else
                        isAllowed = false;
            }
        } else
            isAllowed = true;
        return isAllowed;
    }

    @Override
    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        ClientProcedureGetClient objectDomain = new ClientProcedureGetClient();
        try {
            objectDomain = clientSaleDao.findClient(p_sessionid, p_clientid);
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
    public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid + " channel=" + channel);
        ClientProcedureTokenGeneration objectDomain = new ClientProcedureTokenGeneration();
        try {
            objectDomain = clientSaleDao.getToken(p_clientid, channel, ip);
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
        ClientProcedureLPTokenGeneration objectDomain = new ClientProcedureLPTokenGeneration();
        try {
            objectDomain = clientSaleDao.getLPToken(p_clientid, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " lapollaToken=" + objectDomain.getLapollaToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
    
    @Override
    public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid);
        ClientProcedureTANTokenGeneration objectDomain = new ClientProcedureTANTokenGeneration();
        try {
            objectDomain = clientSaleDao.getTANToken(p_clientid, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " tav2Token=" + objectDomain.getTav2Token() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
    
    @Override
    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        ClientProcedureGetDataClient objectDomain = new ClientProcedureGetDataClient();
        try {
            objectDomain = clientSaleDao.findGetDataClient(p_sessionid, p_clientid);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + objectDomain.getClientId() + " p_nombre=" + objectDomain.getNombre() + " p_appaterno=" + objectDomain.getApPaterno()
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
        ClientProcedureGetNewCode objectDomain = new ClientProcedureGetNewCode();
        try {
            objectDomain = clientSaleDao.findGetNewCode(p_clientId);
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
    public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception {
        LoggerApi.Log.info("findLogin user=" + p_user + " password=***");
        ClientProcedureLogin objectDomain = new ClientProcedureLogin();
        try {
            objectDomain = clientSaleDao.findLogin(p_user, p_password);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin cid=" + objectDomain.getClientId());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedurePutClient findPutclient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pNombre=" + clientBean.getpNombre() + " pApPaterno=" + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate= "
                + clientBean.getpBirthDate() + " pTypeId=" + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName()
                + " pGender=" + clientBean.getpGender() + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1()
                + " pMail2=" + clientBean.getpMail2() + " pConfirm=" + clientBean.getpConfirm() + " pPassword=***" + " pCountry=" + clientBean.getpCountry() + " pRegion="
                + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers=" + clientBean.getpPNnumbers()
                + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId=" + clientBean.getpComNumberId() + " pComName="
                + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry=" + clientBean.getpCountry() + " pComRegion="
                + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress() + " pMode=" + clientBean.getpMode());
        ClientProcedurePutClient objectDomain = new ClientProcedurePutClient();
        try {
            objectDomain = clientSaleDao.findPutclient(clientBean);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() 
                        + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    @Override
    public ClientProcedurePutNewClient putNewClient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pNombre=" + clientBean.getpNombre() + " pApPaterno=" + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate= "
                + clientBean.getpBirthDate() + " pTypeId=" + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName()
                + " pGender=" + clientBean.getpGender() + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1()
                + " pMail2=" + clientBean.getpMail2() + " pConfirm=" + clientBean.getpConfirm() + " pPassword=***" + " pCountry=" + clientBean.getpCountry() + " pRegion="
                + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers=" + clientBean.getpPNnumbers()
                + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId=" + clientBean.getpComNumberId() + " pComName="
                + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry=" + clientBean.getpCountry() + " pComRegion="
                + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress() + " pMode=" + clientBean.getpMode()+ " pReniecValid=" + clientBean.getpReniecValid());
        ClientProcedurePutNewClient objectDomain = new ClientProcedurePutNewClient();
        try {
            objectDomain = clientSaleDao.putNewClient(clientBean);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + objectDomain.getClientId() + " p_state=" + objectDomain.getState() + " p_mail_code=" + objectDomain.getMailCode()
                        + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureSaleLoadPrepaidCard findSaleLoadPrepaidCard(Integer p_clientId, String p_company, String p_carrier, String p_phone, String p_ip, String p_pin)
            throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId + " company=" + p_company + " carrier=" + p_carrier + " phone=" + p_phone + " ip=" + p_ip + " pin=" + StringLib.cover(p_pin));
        ClientProcedureSaleLoadPrepaidCard objectDomain = new ClientProcedureSaleLoadPrepaidCard();
        try {
            objectDomain = clientSaleDao.findSaleLoadPrepaidCard(p_clientId, p_company, p_carrier, p_phone, p_ip, p_pin);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid="+objectDomain.getClientId()+" w_amount_loaded=" + objectDomain.getAmountLoaded() + " w_new_amount=" + objectDomain.getNewAmount() + " w_client_id="
                        + objectDomain.getClientId() + " w_balance_item=" + objectDomain.getBalanceItem() + " w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureUpdateMail findUpdateMail(Integer p_clientId, String p_mail) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId + " p_mail=" + p_mail);
        ClientProcedureUpdateMail objectDomain = new ClientProcedureUpdateMail();
        try {
            objectDomain = clientSaleDao.findUpdateMail(p_clientId, p_mail);
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
    public ClientProcedureNewSessionData setClientRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid + " p_randomcode=" + p_randomcode);
        ClientProcedureNewSessionData objectDomain = new ClientProcedureNewSessionData();
        try {
            objectDomain = clientSaleDao.setRandomCode(p_sessionid, p_clientid, p_randomcode);
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
    public ClientProcedureUpdatePassword findUpdatePassword(Integer p_clientId, String p_password) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId + " p_password=***");
        ClientProcedureUpdatePassword objectDomain = new ClientProcedureUpdatePassword();
        try {
            objectDomain = clientSaleDao.findUpdatePassword(p_clientId, p_password);
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
    public ClientProcedureUpdateClient updateClient(ClientBean clientBean) throws Exception {
        LoggerApi.Log.info("pSessionid=" + clientBean.getpSessionid() + " pClientid=" + clientBean.getpClientid() + " pNombre=" + clientBean.getpNombre() + " pApPaterno="
                + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate=" + clientBean.getpBirthDate() + " pTypeId="
                + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName() + " pGender=" + clientBean.getpGender()
                + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1() + " pMail2=" + clientBean.getpMail2()
                + " pConfirm=" + clientBean.getpConfirm() + " pPrevpass=***" + " pPassword=***" + " pCountry=" + clientBean.getpCountry()
                + " pRegion=" + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers="
                + clientBean.getpPNnumbers() + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId="
                + clientBean.getpComNumberId() + " pComName=" + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry="
                + clientBean.getpCountry() + " pComRegion=" + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress());
        ClientProcedureUpdateClient objectDomain = new ClientProcedureUpdateClient();
        try {
            objectDomain = clientSaleDao.updateClient(clientBean);
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
    public ClientProcedureSessionData updateRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid + " p_randomcode=" + p_randomcode);
        ClientProcedureSessionData objectDomain = new ClientProcedureSessionData();
        try {
            objectDomain = clientSaleDao.updateRandomCode(p_sessionid, p_clientid, p_randomcode);
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
    public String toUC1stLetter(String s) {
        String newString = "";
        s = s.trim();
        if (!"".equals(s)) {
            String words[] = s.replaceAll(" +", " ").split(" ");
            for (String word : words)
                newString = newString + ucFirst(word) + " ";
        }
        return newString.trim();
    }

    private String ucFirst(String word) {
        String exWords[] = { "a", "de", "del", "la", "los", "las", "van", "von", "der", "di" };
        boolean state = false;
        for (String exWord : exWords)
            if (exWord.equals(word.toLowerCase())) {
                state = true;
                break;
            }
        if (state)
            return word.toLowerCase();
        else
            return word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase();
    }

    public boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @Override
    public String clientSendMail(String email, String name, String code, int option, String user) {
        /* System.out.println("INGRESO PARA ENVIAR EMAIL "); */
        //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        StringBuffer mailBodyConfirm = new StringBuffer();
        StringBuffer mailBodyNewCode = new StringBuffer();
        StringBuffer mailBodyPass = new StringBuffer();
        String mailSender = email;
        String mailSubject = "[LA TINKA]";
        String mailBody = "";
        String result = "";
        String codedecoded = "";
        
        try {
            codedecoded = StringLib.decodeLabel(code);
        } catch (Exception e) {}
               
        mailBodyPass.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>" + "<tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-recordar-clave.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td width='549' valign='top' bgcolor='#F7F7F7' style='background: #F7F7F7; "
                + "font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e; text-align:justify;'><strong>Hola "
                + ClientUtils.formatHtml(name)
                + "</strong><br/><br/>Este mensaje de correo ha sido generado porque se ha realizado una solicitud de env&iacute;o "
                + "del c&oacute;digo de autorizaci&oacute;n de cambio de contrase&ntilde;a al correo "
                + "electr&oacute;nico del cual usted es el titular.<br/><br/>El c&oacute;digo de autorizaci&oacute;n "
                + "de cambio de contrase&ntilde;a es: <strong style='color:#f78f1e'>"
                + codedecoded
                + "</strong><br/><br/>"
                + "C&oacute;digo de autorizaci&oacute;n: <strong style='color:#f78f1e'>"+ codedecoded+ "</strong><br/>"
                + "Usuario: <strong style='color:#f78f1e'>"+ user+ "</strong><br/>"
                + "</td><td style='"
                + "background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-right.gif) repeat-y; "
                + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr><tr><td colspan='3' align='center'><table "
                + "width='768' border='0' cellspacing='0' cellpadding='0'><tr><td width='75'>&nbsp;</td><td width='616' "
                + "style='font-family: Arial, Helvetica, sans-serif; font-size: 10px; color:#999999; text-align: justify;'>"
                + "Derechos Reservados. En <a href='http://www.latinka.com.pe/' title='http://www.latinka.com.pe/'>LA TINKA "
                + "de Per&uacute; S.A.</a> nos comprometemos con la privacidad de los datos de nuestros usuarios suscriptores. "
                + "Su direcci&oacute;n de correo electr&oacute;nico figura suscrita a la lista de correos electr&oacute;nicos "
                + "de nuestro sistema de suscripci&oacute;n on line, formando parte de un fichero automatizado de env&iacute;o "
                + "de informaci&oacute;n seleccionada por el suscriptor. Si tiene alguna pregunta o comentario que hacernos, o "
                + "si desea plantearnos alguna preocupaci&oacute;n, ll&aacute;menos al n&uacute;mero de tel&eacute;fono 01 513 5502<span>"
                //+ "CallCenter@intralot.com.pe o ll&aacute;menos de forma gratuita al 0800-17378.<br/>Si desea dejar sin efecto la "
//                + "CallCenter@intralot.com.pe<span>"
                + ".</span><br/>Si desea dejar sin efecto la "
                /*
                + "suscripci&oacute;n deber&aacute; ingresar a su cuenta de usuario en <a href='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/' title='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "'>Intralot Virtual</a> y eliminar la selecci&oacute;n de la "
                + "opci&oacute;n &quot;Permito recibir noticias y promociones en mi correo electr&oacute;nico&quot;.</td>"
                */
                + "suscripci&oacute;n deber&aacute; ingresar a la secci&oacute;n \"Mis datos\" de su cuenta La Tinka y deshabilitar la opci&oacute;n \"Deseo recibir promociones y noticias a mi correo electr&oacute;nico y/o celular brindado\".</td>"
                + "<td width='77'>&nbsp;</td></tr></table></td></tr></table></td></tr></table></body></html>");
        switch (option) {
            case 1:
                mailSubject += " " + "Confirmación de correo electrónico";
                mailBody = mailBodyConfirm.toString();
                break;
            case 2:
                mailSubject += " " + "Solicitud de código de seguridad";
                mailBody = mailBodyNewCode.toString();
                break;
            case 3:
                //mailSubject += " " + "Recordatorio de contraseña";
                mailBody = mailBodyPass.toString();
                break;
            default:
                break;
        }
        try {
            MailLib.sendMail(mailSender, mailSubject, mailBody);
            result = "Se ha enviado un mensaje a su direcci&oacute;n de correo electr&oacute;nico.";
        } catch (Exception e) {
            LoggerApi.severe(e);
            result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
    }
    
    @Override
    public String clientSendMail2(String email, String name, String code, int option, String user,String game) {
        /* System.out.println("INGRESO PARA ENVIAR EMAIL "); */
        //String context = "CARD-WEB";
        String context = Constants.contextCardWeb;
        StringBuffer mailBodyConfirm = new StringBuffer();
        StringBuffer mailBodyNewCode = new StringBuffer();
        StringBuffer mailBodyPass = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Cambia tu contraseña";
        String mailBody = "";
        String result = "";
        String codedecoded = "";
        String urlRecuperarContrasenia="";
        String emailEncryt ="";
        Client client = null;
       
        try {
        	client = clientSaleDao.findUserReminder(email);
            codedecoded = StringLib.decodeLabel(code);
            System.out.println("codigo encriptado : "+code);
            emailEncryt = StringLib.encodeLabel(email);
            System.out.println("codigo email encriptado : "+emailEncryt);
        } catch (Exception e) {}
        
        if(game.equals("1")) {
       	 urlRecuperarContrasenia = Constants.latinkaUrlContrasenia+"?param1="+code+"&&param2="+emailEncryt;
            System.out.println(urlRecuperarContrasenia);
       }else if (game.equals("2")) {
       	 urlRecuperarContrasenia = Constants.latinkaUrlContraseniaTA+"?param1="+code+"&&param2="+emailEncryt;
           System.out.println(urlRecuperarContrasenia);
       }
        
       String imgTinka= ConnectionFactory.operationProperty("logoTinka", context);
       String imgBanner= ConnectionFactory.operationProperty("bannerTinka", context); 
       String imgButton= ConnectionFactory.operationProperty("buttonContrasenia", context); 
        
        mailBodyConfirm.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>" + "<tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-email-val.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td width='549' valign='top' bgcolor='#F7F7F7' style='background: #F7F7F7; "
                + "font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e; text-align:justify;'><strong>Hola "
                + ClientUtils.formatHtml(name)
                + "</strong><br/><br/>&iexcl;Bienvenido a La Tinka!<br/><br/>Con el fin de completar tu registro y "
                + "convertirte en un miembro de La Tinka, debes activar el registro de tu correo electr&oacute;nico. Por "
                + "favor, haz clic en el siguiente v&iacute;nculo para confirmar la activaci&oacute;n de su correo "
                + "(de no haber ingresado al sistema previamente deber&aacute; hacerlo para poder activar su cuenta):"
                + "<br/><br/><a href='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "p/inicio.html#activar'>Activar mi cuenta</a><br/>"
                + "<br/>Si al hacer clic en el v&iacute;nculo parece que est&aacute; roto, c&oacute;pialo "
                + "y p&eacute;galo en una ventana nueva del navegador. Accede a tu cuenta La Tinka con tu usuario y "
                + "contrase&ntilde;a e ingresa el siguiente c&oacute;digo, cuando el sistema lo requiera.<br/>"
                + "<br/>C&oacute;digo: <strong style='color:#f78f1e'>"
                + code
                + "</strong><br/><br/>Gracias a esta confirmaci&oacute;n, tendr&aacute;s la "
                + "satisfacci&oacute;n de recibir en la cuenta de correo "
                + email
                + ", desde la comodidad de tu casa, mensajes sobre "
                + "promociones, resultados de los sorteos, los tickets de tus jugadas y los premios que has ganado.<br/><br/>"
                + "<br/>Le deseamos suerte con sus jugadas <br/>Departamento de Marketing de La Tinka.</td><td style='"
                + "background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-right.gif) repeat-y; "
                + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr><tr><td colspan='3' align='center'><table "
                + "width='768' border='0' cellspacing='0' cellpadding='0'><tr><td width='75'>&nbsp;</td><td width='616' "
                + "style='font-family: Arial, Helvetica, sans-serif; font-size: 10px; color:#999999; text-align: justify;'>"
                + "Derechos Reservados. En <a href='http://www.latinka.com.pe/' title='http://www.latinka.com.pe/'>LA TINKA "
                + "de Per&uacute; S.A.</a> nos comprometemos con la privacidad de los datos de nuestros usuarios suscriptores. "
                + "Su direcci&oacute;n de correo electr&oacute;nico figura suscrita a la lista de correos electr&oacute;nicos "
                + "de nuestro sistema de suscripci&oacute;n on line, formando parte de un fichero automatizado de env&iacute;o "
                + "de informaci&oacute;n seleccionada por el suscriptor. Si tiene alguna pregunta o comentario que hacernos, o "
                + "si desea plantearnos alguna preocupaci&oacute;n, ll&aacute;menos al n&uacute;mero de tel&eacute;fono 01 513 5502<span>.</span></td>"
                //+ "CallCenter@intralot.com.pe o ll&aacute;menos de forma gratuita al 0800-17378.</td>"
//                + "CallCenter@intralot.com.pe<span>.</span></td>"
                + "<td width='77'>&nbsp;</td></tr></table></td></tr></table></td></tr></table></body></html>");
        mailBodyNewCode.append("<html><head></head><body bgcolor='#FFFFFF' marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' "
                + "rightmargin='0' bottommargin='0'><table width='768' border='0' align='center' cellpadding='0' cellspacing='0'>" + "<tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-intralot."
                + "jpg) center no-repeat; border: 0; margin: 0; padding: 0; width: 768px; height: 108px;'></td></tr><tr><td>"
                + "<table width='768' border='0' cellspacing='0' cellpadding='0'><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/header-email-val.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 110px;'></td></tr><tr><td style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-left.gif) repeat-y; border: 0; margin: 0; "
                + "padding: 0; width: 109px;'></td><td width='549' valign='top' bgcolor='#F7F7F7' style='background: #F7F7F7; "
                + "font-family: Arial, Helvetica, sans-serif; font-size: 11px; color:#434d3e; text-align:justify;'><strong>Hola "
                + ClientUtils.formatHtml(name)
                + "</strong><br/><br/>&iexcl;Solicitud de c&oacute;digo de seguridad!<br/><br/>Se ha generado un nuevo c&oacute;digo de seguridad para "
                + "activar el registro de tu correo electr&oacute;nico. Por "
                + "favor, haz clic en el siguiente v&iacute;nculo para confirmar la activaci&oacute;n de su correo "
                + "(de no haber ingresado al sistema previamente deber&aacute; hacerlo para poder activar su cuenta):"
                + "<br/><br/><a href='"
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "p/inicio.html#activar'>Activar mi cuenta</a><br/>"
                + "<br/>Si al hacer clic en el v&iacute;nculo parece que est&aacute; roto, c&oacute;pialo "
                + "y p&eacute;galo en una ventana nueva del navegador. Accede a tu cuenta La Tinka con tu usuario y "
                + "contrase&ntilde;a e ingresa el siguiente c&oacute;digo para proceder con la activaci&oacute;n.<br/>"
                + "<br/>C&oacute;digo: <strong style='color:#f78f1e'>"
                + code
                + "</strong><br/><br/>Gracias a esta confirmaci&oacute;n, tendr&aacute;s la satisfacci&oacute;n de recibir en la cuenta de correo "
                + email
                + ", desde la comodidad de tu casa, mensajes sobre "
                + "promociones, resultados de los sorteos, los tickets de tus jugadas y los premios que has ganado.<br/><br/>"
                + "<br/>Le deseamos suerte con sus jugadas <br/>Departamento de Marketing de La Tinka.</td><td style='"
                + "background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/box-right.gif) repeat-y; "
                + "border: 0; margin: 0; padding: 0; width: 110px;'></td></tr><tr><td colspan='3' style='background:url("
                + ConnectionFactory.operationProperty("lotocardServerURI", context)
                + "/img/account/footer-box.gif) center no-repeat; border: 0; "
                + "margin: 0; padding: 0; width: 768px; height: 45px;'></td></tr><tr><td colspan='3' align='center'><table "
                + "width='768' border='0' cellspacing='0' cellpadding='0'><tr><td width='75'>&nbsp;</td><td width='616' "
                + "style='font-family: Arial, Helvetica, sans-serif; font-size: 10px; color:#999999; text-align: justify;'>"
                + "Derechos Reservados. En <a href='http://www.latinka.com.pe/' title='http://www.latinka.com.pe/'>LA TINKA "
                + "de Per&uacute; S.A.</a> nos comprometemos con la privacidad de los datos de nuestros usuarios suscriptores. "
                + "Su direcci&oacute;n de correo electr&oacute;nico figura suscrita a la lista de correos electr&oacute;nicos "
                + "de nuestro sistema de suscripci&oacute;n on line, formando parte de un fichero automatizado de env&iacute;o "
                + "de informaci&oacute;n seleccionada por el suscriptor. Si tiene alguna pregunta o comentario que hacernos, o "
                + "si desea plantearnos alguna preocupaci&oacute;n, ll&aacute;menos al n&uacute;mero de tel&eacute;fono 01 513 5502<span>.</span></td>"
                //+ "CallCenter@intralot.com.pe o ll&aacute;menos de forma gratuita al 0800-17378.</td>"
//                + "CallCenter@intralot.com.pe<span>.</span></td>"
                + "<td width='77'>&nbsp;</td></tr></table></td></tr></table></td></tr></table></body></html>");
       /* mailBodyPass.append("<html><head></head>" + 
        		"<body marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' bottommargin='0'>" + 
        		"<div><table width='600px' border='0' align='center' cellpadding='0' cellspacing='0' style='text-align:center;'>" + 
        		"<tr><td width='50px' style='background-color:#ffe510;'>&nbsp;</td><td width='500px' style='background-color:#ffe510;'>&nbsp; " + 
        		"</td><td width='50px' style='background-color:#ffe510;'>&nbsp;</td> " + 
        		"<tr><td width='50px' style='background-color:#ffe510;'>&nbsp;</td>" + 
        		"<td width='500px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"</td><td width='50px' style='background-color:#ffe510;'>&nbsp;</td></tr><tr>  " + 
        		"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr><tr>" + 
        		"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' height='35px' style=\"text-align: left;\"><img src='"+imgTinka+"' style='margin-left:10px;'>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#ffe510;'>&nbsp;" + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#5a5a5a;'><strong><span>¡Hola "+client.getName()+"!</span></strong>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'><span>Haz click para cambiar tu contraseña en la Tinka.</span>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'><a style='text-decoration: none;color: white;border-radius: 1.45em;background-color: #1a6d30;padding-top: 10px;padding-bottom: 10px;padding-left: 15px;padding-right: 15px;font-weight: 800;' href='"+urlRecuperarContrasenia+"'>CAMBIAR CONTRASE&Ntilde;A</a><br/>" + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'>Si tu no pediste el cambio, ignora este correo.  " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"         <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp; " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp; " + 
        		"			</td>" + 
        		"		</tr>" + 
        		"        <tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td> " + 
        		"            <td width='500px' style='background-color:#ffff;'>&nbsp;</td> " + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;</td></tr><tr>  " + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td> " + 
        		"            <td width='500px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr><tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;</td>   " + 
        		"            <td width='500px' style='background-color:#dedede;font-family: Arial, Helvetica, sans-serif; font-size: 12.3px; color:#999999;'><span>&Eacute;ste es un correo generado autom&aacute;ticamente y caducar&aacute; a las 24hrs de la fecha." + 
        		"			</span><br/><span>en que lo recibiste. Si quieres actualizar tus datos o necesitas informaci&oacute;n</span><br/>" + 
        		"			<span>adicional, cont&aacute;ctate con nosotros al 513 5502.</span></td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr><tr>" + 
        		"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td>" + 
        		"            <td width='500px' style='background-color:#dedede;'>&nbsp;  " + 
        		"			</td>" + 
        		"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
        		"			</td></tr>" +
        		"<tr>" + 
        		"        <td  colspan='3' width='600px' style='background-color:#dedede;'> <img src='"+imgBanner+"' >" + 
        		"		</td>" +  
        		"		</tr>"+
        		"</table></div></div></body></html>");*/
        
        mailBodyPass.append("<html>" + 
        		"<head>" + 
        		"<title>La Tinka - Cambia tu contrase&ntilde;a</title>" + 
        		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + 
        		"</head>" + 
        		"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" + 
        		"<table width=\"600\" height=\"700\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" + 
        		"	<tr>" + 
        		"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
        		"		<td bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>" + 
        		"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td>" + 
        		"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td rowspan=\"9\" bgcolor=\"#dedede\"  width=\"65\" height=\"359\" alt=\"\"></td>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>" + 
        		"		<td rowspan=\"9\" bgcolor=\"#dedede\"  width=\"65\" height=\"359\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>¡Hola "+client.getNombre()+"!</strong></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Haz click aqu&iacute; para cambiar tu contrase&ntilde;a en La Tinka.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" align=\"center\"><a href='"+urlRecuperarContrasenia+"' target=_blank>" + 
        		"			<img src='"+imgButton+"' width=265 height=36 alt=Cambiar contrase&ntilde;a style='display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;'></a></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"25\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Si t&uacute; no pediste el cambio, ignora este correo.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"49\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td bgcolor=\"#dedede\" width=\"470\" height=\"76\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\">Este es un correo generado autom&aacute;ticamente. El enlace cambiar contraseña <strong>caducar&aacute; a las 24hrs</strong> de la fecha en que lo recibiste. Si quieres actualizar tus datos o necesitas informaci&oacute;n adicional, cont&aacute;ctate con nosotros al 5135502.</td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td colspan=\"3\" bgcolor=\"#dedede\">" + 
        		"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>" + 
        		"	</tr>" + 
        		"	<tr>" + 
        		"		<td colspan=\"3\" bgcolor=\"#dedede\" width=\"600\" height=\"117\" alt=\"\"></td>" + 
        		"	</tr>" + 
        		"</table>" + 
        		"</body>" + 
        		"</html>");
        
        switch (option) {
            case 1:
                mailSubject += " " + "Confirmación de correo electrónico";
                mailBody = mailBodyConfirm.toString();
                break;
            case 2:
                mailSubject += " " + "Solicitud de código de seguridad";
                mailBody = mailBodyNewCode.toString();
                break;
            case 3:
                
                mailBody = mailBodyPass.toString();
                break;
            default:
                break;
        }
        try {
            MailLib.sendMail(mailSender, mailSubject, mailBody);
            result = "Se ha enviado un mensaje a su direcci&oacute;n de correo electr&oacute;nico.";
        } catch (Exception e) {
            LoggerApi.severe(e);
            result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
    }
    
    @Override
    public String clientSendUserMail(String email) {
    	//String context = "CARD-WEB";
    	String context = Constants.contextCardWeb;
        StringBuffer mailBodyUser = new StringBuffer();
        String mailSender = email;
        String mailSubject = "Recordatorio de usuario";
        String mailBody = "";
        String result = "KO";
        
        String imgTinka= ConnectionFactory.operationProperty("logoTinka", context);
        String imgBanner= ConnectionFactory.operationProperty("bannerTinka", context); 
        
        try {
	        Client client = clientSaleDao.findUserReminder(email);
	        if(client!=null && client.getIdClient()!=null && client.getIdClient()!=0) {
	        	/*mailBodyUser.append("<html><head></head><body marginheight='0' marginwidth='0' topmargin='0' leftmargin='0' rightmargin='0' bottommargin='0'>" + 
	        			"<div><table width='600px' border='0' align='center' cellpadding='0' cellspacing='0' style='text-align:center;'><tr>" + 
	        			"<td width='50px' style='background-color:#ffe510;'>&nbsp;</td><td width='500px' style='background-color:#ffe510;'>&nbsp;</td>" + 
	        			"<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"</td><tr>" + 
	        			"        	<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"		</td>  " + 
	        			"			" + 
	        			"        </tr>" + 
	        			"		<tr>" + 
	        			"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        " + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' height='35px' style=\"text-align: left;\"><img src='"+imgTinka+"' style='margin-left:10px;'>" +  
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#ffe510;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        " + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#5a5a5a;'><strong><span>¡Hola "+client.getName()+"!</span></strong>   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp; " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-size:14px;color:#5a5a5a;font-family: Arial, Helvetica, sans-serif;'><span>Tu nombre de usuario es</span>  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;font-family: Arial, Helvetica, sans-serif; font-size: 22px; color:#126639;'><strong><span>"+client.getUser()+"</span></strong>   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"         <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#ffff;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;font-family: Arial, Helvetica, sans-serif; font-size: 12.3px; color:#999999;'><span>&Eacute;ste es un correo generado autom&aacute;ticamente y caducar&aacute; las 24hrs de la fecha." + 
	        			"									<br/>en que lo recibiste. Si quieres actualizar tus datos o necesitas informacio&acute;n<br/> " + 
	        			"									adicional, cont&aacute;ctate con nosotros al 513 5502.</span>  " + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;   " + 
	        			"			</td>" + 
	        			"		</tr>" + 
	        			"        <tr>" + 
	        			"			<td width='50px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='500px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"            <td width='50px' style='background-color:#dedede;'>&nbsp;" + 
	        			"			</td>" + 
	        			"		</tr>" + 
	            		"<tr>" + 
	            		"        <td  colspan='3' width='600px' style='background-color:#dedede;'> <img src='"+imgBanner+"' >" + 
	            		"		</td>" +  
	            		"		</tr>"+
	        			"</table></div></div></body></html>");*/
	                
	        	mailBodyUser.append("<html>" + 
	        			"<head>" + 
	        			"<title>La Tinka - Recordatorio de usuario</title>" + 
	        			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + 
	        			"</head>" + 
	        			"<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" + 
	        			"<table width=\"600\" height=\"365\" bgcolor=\"#FFFFFF\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" + 
	        			"	<tr>" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
	        			"		<td bgcolor=\"#ffe510\" width=\"470\" height=\"53\" alt=\"\"></td>" + 
	        			"		<td rowspan=\"2\" bgcolor=\"#ffe510\" width=\"65\" height=\"106\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td>" + 
	        			"			<img src='"+imgTinka+"' width=\"470\" height=\"53\" alt=\"LA TINKA\" style=\"display:block; color:#5a5a5a; text-align:left; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:18px;\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td rowspan=\"6\" bgcolor=\"#dedede\"  width=\"65\" height=\"283\" alt=\"\"></td>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"38\" alt=\"\"></td>" + 
	        			"		<td rowspan=\"6\" bgcolor=\"#dedede\"  width=\"65\" height=\"283\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"44\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>¡Hola "+client.getNombre()+"!</strong></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"33\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:14px;\">Tu nombre de usuario es</td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"43\" align=\"center\" style=\"display:block; color:#126639; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:22px;\"><strong>"+client.getUser()+"</strong></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#ffffff\" width=\"470\" height=\"49\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td bgcolor=\"#dedede\" width=\"470\" height=\"76\" alt=\"\" style=\"color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\">Este es un correo generado autom&aacute;ticamente. Si quieres actualizar tus datos o necesitas informaci&oacute;n adicional, cont&aacute;ctate con nosotros al 5135502.</td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td colspan=\"3\" bgcolor=\"#dedede\">" + 
	        			"			<img src='"+imgBanner+"' width=\"600\" height=\"118\" alt=\"Tinka - Te Apuesto - Casino - RaspaY&aacute; - Deportes Virtuales - Ganagol - K&aacute;bala - Gana Diario - Kinelo\" style=\"display:block; color:#5a5a5a; text-align:center; font-family: Open Sans, Arial, Helvetica, sans-serif; font-size:12px;\"></td>" + 
	        			"	</tr>" + 
	        			"	<tr>" + 
	        			"		<td colspan=\"3\" bgcolor=\"#dedede\" width=\"600\" height=\"117\" alt=\"\"></td>" + 
	        			"	</tr>" + 
	        			"</table>" + 
	        			"</body>" + 
	        			"</html>");
	        	
	                mailBody = mailBodyUser.toString();
		            MailLib.sendMail(mailSender, mailSubject, mailBody);
		            result = "OK";
		        } else {
		        	result = "NE";
		        }
	        } catch (Exception e) {
	            result = "KO";
	            LoggerApi.severe(e);
	        } finally {
	        	LoggerApi.Log.info(result);
	        }
        return result;
    }

    @Override
    public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception {
        LoggerApi.Log.info("findGetPasswordCode p_mail=" + p_mail);
        ClientProcedureGetPasswordCode objectDomain = new ClientProcedureGetPasswordCode();
        try {
            objectDomain = clientSaleDao.findGetPasswordCode(p_mail, p_password_code);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_mail=" + p_mail+" p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage() + " p_mail=" + objectDomain.getMail()
                        + " p_passsword_code=***" );
            else {
            	LoggerApi.Log.info("objectDomain="+objectDomain);
            }
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureResetNewPassword resetNewPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail+" p_password_code=***");
        ClientProcedureResetNewPassword objectDomain = new ClientProcedureResetNewPassword();
        try {
            objectDomain = clientSaleDao.resetNewPassword(p_mail, p_password_code, p_password_1, p_password_2);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_mail=" + p_mail+" p_clientid=" + objectDomain.getClientId() + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }

    @Override
    public ClientProcedureActivateClientSamp activateClientSamp(String p_client_id, String p_mail, String p_mail_code, String p_random_code, String p_game_code)
            throws Exception {
        LoggerApi.Log.info("p_mail=" + p_mail);
        ClientProcedureActivateClientSamp objectDomain = new ClientProcedureActivateClientSamp();
        try {
            objectDomain = clientSaleDao.activateClientSamp(p_client_id, p_mail, p_mail_code, p_random_code, p_game_code);
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
    public PromoFirstAccount promotionFirstAccount(Integer cb_client_id, Integer cb_balance_item) throws Exception {
        LoggerApi.Log.info("cb_client_id=" + cb_client_id + "  cb_balance_item= " + cb_balance_item);
        PromoFirstAccount objectDomain = new PromoFirstAccount();
        try {
            objectDomain = clientSaleDao.promotionFirstAccount(cb_client_id, cb_balance_item);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("getPromotion_eco=" + objectDomain.getPromotion_eco() + " getPromotion_message=" + objectDomain.getPromotion_message());
        }
        return objectDomain;
    }

	@Override
	public ClientProcedureVerifyClientPromo verifyClientPromo(String p_client_id,
			String p_mail, String p_mail_code, String p_random_code)
			throws Exception {
		LoggerApi.Log.info("cid="+p_client_id+" p_mail=" + p_mail);
		ClientProcedureVerifyClientPromo objectDomain = new ClientProcedureVerifyClientPromo();
        try {
            objectDomain = clientSaleDao.verifyClientPromo(p_client_id, p_mail, p_mail_code, p_random_code);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid="+p_client_id+" p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage() + " p_game_message="
                        + objectDomain.getGameMessage());
        }
        return objectDomain;
	}

	@Override
	public String updateClientPromo(ClientBean clientBean)
			throws Exception {
		 LoggerApi.Log.info("cid=" + clientBean.getpClientid() + " pSessionid=" + clientBean.getpSessionid() + " pNombre=" + clientBean.getpNombre() + " pApPaterno="
	                + clientBean.getpApPaterno() + " pApMaterno=" + clientBean.getpApMaterno() + " pBirthDate=" + clientBean.getpBirthDate() + " pTypeId="
	                + clientBean.getpTypeId() + " pNumberId=" + clientBean.getpNumberId() + " pNickName=" + clientBean.getpNickName() + " pGender=" + clientBean.getpGender()
	                + " pMarital=" + clientBean.getpMarital() + " pUser=" + clientBean.getpUser() + " pMail1=" + clientBean.getpMail1() + " pMail2=" + clientBean.getpMail2()
	                + " pConfirm=" + clientBean.getpConfirm() + " pPrevpass=***" + " pPassword=***" + " pCountry=" + clientBean.getpCountry()
	                + " pRegion=" + clientBean.getpRegion() + " pAddress=" + clientBean.getpAddress() + " pTerms=" + clientBean.getpTerms() + " pPNnumbers="
	                + clientBean.getpPNnumbers() + " pPNumbers00=" + clientBean.getpPNumbers00() + " pComTypeId=" + clientBean.getpComTypeId() + " pComNumberId="
	                + clientBean.getpComNumberId() + " pComName=" + clientBean.getpComName() + " pComPhones=" + clientBean.getpComPhones() + " pCountry="
	                + clientBean.getpCountry() + " pComRegion=" + clientBean.getpComRegion() + " pComAddress=" + clientBean.getpComAddress());
	        String mensaje ="";
	        try {
	        	mensaje = clientSaleDao.updateClientPromo(clientBean);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (mensaje != null)
	                LoggerApi.Log.info(" p_message=" + mensaje);
	        }
	        return mensaje;

	}
	
	@Override
	public ClientProcedureVerifyClient verifyClient(String p_client_id,
			String p_mail, String p_mail_code)
			throws Exception {
		LoggerApi.Log.info("cid="+p_client_id+" p_mail=" + p_mail);
		ClientProcedureVerifyClient objectDomain = new ClientProcedureVerifyClient();
        try {
            objectDomain = clientSaleDao.verifyClient(p_client_id, p_mail, p_mail_code);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid="+p_client_id+" p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}
	
	@Override
	public ClientProcedureVerifyClientBond verifyClientBond(String p_client_id, String p_bond_code)
			throws Exception {
		LoggerApi.Log.info("cid="+p_client_id);
		ClientProcedureVerifyClientBond objectDomain = new ClientProcedureVerifyClientBond();
        try {
            objectDomain = clientSaleDao.verifyClientBond(p_client_id, p_bond_code);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid="+p_client_id+" p_user=" + objectDomain.getUser() + " p_password=***" + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

    /*@Override
    public ClientProcedureLoginTokenGeneration findLoginTokenGeneration(String p_user, String p_password, String channel, String ip) throws Exception {
        ClientProcedureLoginTokenGeneration objectDomain = new ClientProcedureLoginTokenGeneration();
        try {
            objectDomain = clientSaleDao.findLoginTokenGeneration(p_user, p_password, channel, ip);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            ;
        }
        return objectDomain;
    }*/

    @Override
    public ClientProcedureUpdateAgreement updateAgreement(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("p_clientId=" + p_clientId);
        ClientProcedureUpdateAgreement objectDomain = new ClientProcedureUpdateAgreement();
        try {
            objectDomain = clientSaleDao.updateAgreement(p_clientId);
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
		Integer objectPojo= 0;
		try {
			LoggerApi.Log.info("dni:"+dni);
			objectPojo = clientSaleDao.findClientDNI(dni);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{
			if (objectPojo != null) LoggerApi.Log.info("objectPojo: "+objectPojo);
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	@Override
	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId, String p_sms) throws Exception {
		ClientProcedurePutSmsRegisterData objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_sms:"+p_sms);
			objectPojo = clientSaleDao.putSmsRegisterData(p_clientId, p_sms);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	@Override
	public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId, String p_sms, Integer p_time_minutes)
			throws Exception {
		ClientProcedureUpdateSmsRegister objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_sms:"+p_sms+" p_time_minutes:"+p_time_minutes);
			objectPojo = clientSaleDao.updateSmsRegister(p_clientId, p_sms, p_time_minutes);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone)
			throws Exception {
		ClientProcedureUpdatePhone objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_phone:"+p_phone);
			objectPojo = clientSaleDao.updatePhoneClient(p_clientId, p_phone);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureActivatePromotion activatePromotion(Object[] values)
			throws Exception {
		ClientProcedureActivatePromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.activatePromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values)
			throws Exception {
		ClientProcedureActivateWBPromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.activateWBPromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureCancelPromotion cancelPromotion(Object[] values)
			throws Exception {
		ClientProcedureCancelPromotion objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.cancelPromotion(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values)
			throws Exception {
		ClientProcedureActivatePromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.activatePromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values)
			throws Exception {
		ClientProcedureActivateWBPromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.activateWBPromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values)
			throws Exception {
		ClientProcedureCancelPromotionibk objectPojo= null;
		try {
			LoggerApi.Log.info("ClientId:"+values[0]+ " BalanceItem:"+values[1]);
			objectPojo = clientSaleDao.cancelPromotionibk(values);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	@Override
	public PinPrinted findLotocard(String pin) throws Exception {
		return clientSaleDao.findLotocard(pin);
	}

	@Override
	public String findMobileSmsStatus(Integer parseInt) {
		return clientSaleDao.findMobileSmsStatus(parseInt);
	}
	
	@Override
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception {
		return clientSaleDao.codePromotionalValidation(values);
	}
	
	@Override
	public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception {
		clientSaleDao.saveLoginLog(clientAddressLog);		
	}
	
	@Override
    public ClientProcedureIIVVTokenGeneration getIIVVToken(Integer p_clientid, String ip, String device) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid);
        ClientProcedureIIVVTokenGeneration objectDomain = new ClientProcedureIIVVTokenGeneration();
        try {
            objectDomain = clientSaleDao.getIIVVToken(p_clientid, ip, device);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " Token=" + objectDomain.getToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
	
	@Override
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception {
	    return clientSaleDao.findAccountDataPart(p_clientId);
	}

	@Override
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception {
		return clientSaleDao.registrarReclamacion(reclamacion);
	}	
	
	@Override
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_player_id_xpg)
			throws Exception {
		ClientProcedureUpdatePlayerId objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_player_id_xpg:"+p_player_id_xpg);
			objectPojo = clientSaleDao.updatePlayerId(p_clientId, p_player_id_xpg);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
    public ClientProcedureGetPlayerId findGetPlayerId(Integer p_clientid) throws Exception {
        LoggerApi.Log.info("findGetPlayerId p_clientid=" + p_clientid);
        ClientProcedureGetPlayerId objectDomain = new ClientProcedureGetPlayerId();
        try {
            objectDomain = clientSaleDao.findGetPlayerId(p_clientid);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin cid=" + objectDomain.getClientId());
        }
        return objectDomain;
    }
	
	@Override
	public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientId, String p_device)
			throws Exception {
		ClientProcedureUpdateClientDevice objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_device:"+p_device);
			objectPojo = clientSaleDao.updateDevice(p_clientId, p_device);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	public ClientProcedureUpdateClientFavorite updateFavorite(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception {
		 LoggerApi.Log.info("p_clientid=" + p_clientid + "  p_productid= " + p_productid);
		 ClientProcedureUpdateClientFavorite objectDomain =  new ClientProcedureUpdateClientFavorite();
		try {
         objectDomain = clientSaleDao.updateFavorite(p_flagDelete, p_clientid, p_productid);
     } catch (Exception e) {
         LoggerApi.severe(e);
         throw e;
     } finally {
         if (objectDomain != null)
             LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
     }
     return objectDomain;
	}
	
	public HashMap[] getFavoriteProduct(String client_id) throws Exception {
        LoggerApi.Log.info("client_id=" + client_id);
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getFavoriteProduct(client_id);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }
	
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws Exception {
		List<ClientProcedureGetCasinoProductList> resultQueryList = new ArrayList<ClientProcedureGetCasinoProductList>();
		try {
			resultQueryList = clientSaleDao.listCasinoProducts();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCasinoProducts size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCasinoProducts objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetCasinoProductListOrder> listCasinoProductsOrder() throws Exception {
		List<ClientProcedureGetCasinoProductListOrder> resultQueryList = new ArrayList<ClientProcedureGetCasinoProductListOrder>();
		try {
			resultQueryList = clientSaleDao.listCasinoProductsOrder();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCasinoProductsOrder size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCasinoProductsOrder objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaProductList> listRaspayaProducts() throws Exception {
		List<ClientProcedureGetRaspayaProductList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProductList>();
		try {
			resultQueryList = clientSaleDao.listRaspayaProducts();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listRaspayaProducts size= " + resultQueryList.size());
			else LoggerApi.Log.info("listRaspayaProducts objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaProductListOrder> listRaspayaProductsOrder() throws Exception {
		List<ClientProcedureGetRaspayaProductListOrder> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProductListOrder>();
		try {
			resultQueryList = clientSaleDao.listRaspayaProductsOrder();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listRaspayaProductsOrder size= " + resultQueryList.size());
			else LoggerApi.Log.info("listRaspayaProductsOrder objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaProductPriceList> listRaspayaProductsPrice() throws Exception {
		List<ClientProcedureGetRaspayaProductPriceList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProductPriceList>();
		try {
			resultQueryList = clientSaleDao.listRaspayaProductsPrice();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listRaspayaProductsPrice size= " + resultQueryList.size());
			else LoggerApi.Log.info("listRaspayaProductsPrice objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaProductPozoList> listRaspayaProductsPozo() throws Exception {
		List<ClientProcedureGetRaspayaProductPozoList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProductPozoList>();
		try {
			resultQueryList = clientSaleDao.listRaspayaProductsPozo();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listRaspayaProductsPozo size= " + resultQueryList.size());
			else LoggerApi.Log.info("listRaspayaProductsPozo objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	@Override
    public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception {
        LoggerApi.Log.info("findGetRaspayaGameId p_name=" + p_name);
        ClientProcedureGetRaspayaGameId objectDomain = new ClientProcedureGetRaspayaGameId();
        try {
            objectDomain = clientSaleDao.findGetRaspayaGameId(p_name);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findGetRaspayaGameId gid=" + objectDomain.getGameId());
        }
        return objectDomain;
    }

	@Override
	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId, String phoneUpdateAgora,
			String phoneUpdate) throws Exception {
		return clientSaleDao.updateStateRechargeAgora(clientId, phoneUpdateAgora, phoneUpdate);
	}

	@Override
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate)
			throws Exception {
		return clientSaleDao.validateNewPhoneAgora(clientId, phoneUpdate);
	}
	
	@Override
    public ClientProcedureDDVVTokenGeneration getDDVVToken(Integer p_clientid, String ip, String device) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientid);
        ClientProcedureDDVVTokenGeneration objectDomain = new ClientProcedureDDVVTokenGeneration();
        try {
            objectDomain = clientSaleDao.getDDVVToken(p_clientid, ip, device);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " Token=" + objectDomain.getToken() 
                		+ " channel=" + objectDomain.getChannel());
        }
        return objectDomain;
    }
	
	@Override
    public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception {
        LoggerApi.Log.info("p_token=" + p_token);
        ClientProcedureDDVVTokenLogin objectDomain = new ClientProcedureDDVVTokenLogin();
        try {
            objectDomain = clientSaleDao.getDDVVLogin(p_token);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("clientId=" + objectDomain.getClientId() + " Token=" + objectDomain.getToken());
        }
        return objectDomain;
    }
	
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws Exception {
		List<ClientProcedureGetVirtualesProductList> resultQueryList = new ArrayList<ClientProcedureGetVirtualesProductList>();
		try {
			resultQueryList = clientSaleDao.listVirtualesProducts();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listVirtualesProducts size= " + resultQueryList.size());
			else LoggerApi.Log.info("listVirtualesProducts objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetVirtualesProductListOrder> listVirtualesProductsOrder() throws Exception {
		List<ClientProcedureGetVirtualesProductListOrder> resultQueryList = new ArrayList<ClientProcedureGetVirtualesProductListOrder>();
		try {
			resultQueryList = clientSaleDao.listVirtualesProductsOrder();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listVirtualesProductsOrder size= " + resultQueryList.size());
			else LoggerApi.Log.info("listVirtualesProductsOrder objectPojo: nulll");
		}
		return resultQueryList;
	}
	public List<ClientProcedureGetCasinoProviderList> listProviders() throws Exception {
		List<ClientProcedureGetCasinoProviderList> resultQueryList = new ArrayList<ClientProcedureGetCasinoProviderList>();
		try {
			resultQueryList = clientSaleDao.listProviders();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listProviders size= " + resultQueryList.size());
			else LoggerApi.Log.info("listProviders objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetCasinoCategoryProviderList> listCategoryProviders() throws Exception {
		List<ClientProcedureGetCasinoCategoryProviderList> resultQueryList = new ArrayList<ClientProcedureGetCasinoCategoryProviderList>();
		try {
			resultQueryList = clientSaleDao.listCategoryProviders();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProviders size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProviders objectPojo: nulll");
		}
		return resultQueryList;
	}	
	
	
	@Override
	public String enviarMailPD(ByteArrayOutputStream bis,List<ImgDto> listImgDto,String mailBody,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento,String numeroDocumento) {
		
		String result="";
		//String mailSubject = "Solicitud de Derechos Arco de " + tipo_solicitud +"-" + apellidos +" "+nombres+ "-"+ tipoDocumento + " "+ numeroDocumento;
		String mailSubject = "###WEB Derechos ARCO";
		
		try {
			//MailLib.sendValidMailPD(null,"SoporteWeb@latinka.com.pe",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
			MailLib.sendValidMailPD(null,"soporteweb@sdp730275231.zm.sdpondemand.com",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
			MailLib.sendValidMailPD(null,"soporteweb@latinka.com.pe",mailSubject,mailBody,"text/html; charset=UTF-8",bis,"",listImgDto);
            //result = "Se ha enviado un mensaje a su direcci&oacute;n de correo electr&oacute;nico.";
			result = "OK";
        } catch (Exception e) {
            LoggerApi.severe(e);
            //result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
            result = "KO";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
	}
	
	@Override
	public String enviarMailClientePD(String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento, String numeroDocumento, String email) {
		
		String result="";
		String mailSubject = "Solicitud de Derechos Arco de " + tipo_solicitud +"-" + apellidos +" "+nombres+ "-"+ tipoDocumento + " "+ numeroDocumento;
		//String mailSubject = "###WEB Derehos ARCO";
		String mailTarget = email+","+"datospersonales@latinka.com.pe";
		
		try {
			MailLib.sendMail(mailTarget, mailSubject, body);
            //result = "Se ha enviado un mensaje a su direcci&oacute;n de correo electr&oacute;nico.";
			result = "OK";
        } catch (Exception e) {
            LoggerApi.severe(e);
            //result = "Ocurri&oacute; un problema inesperado. Por favor realice la acci&oacute;n nuevamente.";
            result = "KO";
        } finally {
            LoggerApi.Log.info(result);
        }
        return result;
	}
	
	@Override
	public String findCodUserfilter1(String dni, String nombre) throws Exception {
		 String result=null;
	        try {
	        	result = clientSaleDao.findCodUserfilter1(dni, nombre);
	        	return result;
	        } catch (Exception e) {
	            LoggerApi.severe(e);           
	            throw new Exception(e);	
	        } finally {
	        	if(result!=null){
					LoggerApi.Log.info("objectMap: "+result);
				} else {
					LoggerApi.Log.info("objectMap: "+"null");
					return "";
				}
	          
	        }
	}

	@Override
	public String findCodUserfilter2(String dni, String correo) throws Exception {
		String result= null;
        try {
        	result = clientSaleDao.findCodUserfilter2(dni, correo);
        	return result;
        } catch (Exception e) {
            LoggerApi.severe(e);           
            throw new Exception(e);	
        } finally {
        	if(result!=null){
				LoggerApi.Log.info("objectMap: "+result);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");
				return "";
			}
          
        }
	}

	@Override
	public String findCodUserfilter3(String dni, String celular) throws Exception {
		String result= null;
        try {
        	result = clientSaleDao.findCodUserfilter3(dni, celular);
        	return result;
        } catch (Exception e) {
            LoggerApi.severe(e);           
            throw new Exception(e);	
        } finally {
        	if(result!=null){
				LoggerApi.Log.info("objectMap: "+result);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");
				return "";
			}
          
        }
	}
	
	public ClientProcedureUpdateClientFavoriteVirtuales updateFavoriteVirtuales(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception {
		 LoggerApi.Log.info("p_clientid=" + p_clientid + "  p_productid= " + p_productid);
		 ClientProcedureUpdateClientFavoriteVirtuales objectDomain =  new ClientProcedureUpdateClientFavoriteVirtuales();
		try {
        objectDomain = clientSaleDao.updateFavoriteVirtuales(p_flagDelete, p_clientid, p_productid);
    } catch (Exception e) {
        LoggerApi.severe(e);
        throw e;
    } finally {
        if (objectDomain != null)
            LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
    }
    return objectDomain;
	}
	
	public HashMap[] getFavoriteProductVirtuales(String client_id) throws Exception {
       LoggerApi.Log.info("client_id=" + client_id);
       HashMap[] objectMap= null;
       try {
       	objectMap = clientSaleDao.getFavoriteProductVirtuales(client_id);
       	return objectMap;
       } catch (Exception e) {
           LoggerApi.severe(e);
           //throw e;
           throw new Exception(e);	
       } finally {
       	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
           
       }
   }
	
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws Exception {
		List<ClientProcedureGetVirtualesProviderList> resultQueryList = new ArrayList<ClientProcedureGetVirtualesProviderList>();
		try {
			resultQueryList = clientSaleDao.listProvidersVirtuales();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listProvidersVirtuales size= " + resultQueryList.size());
			else LoggerApi.Log.info("listProvidersVirtuales objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetVirtualesCategoryProviderList> listCategoryProvidersVirtuales() throws Exception {
		List<ClientProcedureGetVirtualesCategoryProviderList> resultQueryList = new ArrayList<ClientProcedureGetVirtualesCategoryProviderList>();
		try {
			resultQueryList = clientSaleDao.listCategoryProvidersVirtuales();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProvidersVirtuales size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProvidersVirtuales objectPojo: nulll");
		}
		return resultQueryList;
	}	
	
	public ClientProcedureRegisterPopupLottery registerPopupLottery(Integer p_clientId, String p_device, String p_source, Integer p_game_id) throws Exception {
		ClientProcedureRegisterPopupLottery objectDomain =  new ClientProcedureRegisterPopupLottery();
			try {
	        objectDomain = clientSaleDao.registerPopupLottery(p_clientId, p_device, p_source, p_game_id);
	    } catch (Exception e) {
	        LoggerApi.severe(e);
	        throw e;
	    } finally {
	        if (objectDomain != null)
	            LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
	    }
		return objectDomain;
	}
	
	public HashMap[] getPromoHincha(String client_id) throws Exception {
        LoggerApi.Log.info("client_id=" + client_id);
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getPromoHincha(client_id);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }
	
	public HashMap[] getFavoriteProductRaspaya(String client_id) throws Exception {
        LoggerApi.Log.info("client_id=" + client_id);
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getFavoriteProductRaspaya(client_id);
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }
	
	public ClientProcedureUpdateClientFavoriteRaspaya updateFavoriteRaspaya(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception {
		 LoggerApi.Log.info("p_clientid=" + p_clientid + "  p_productid= " + p_productid);
		 ClientProcedureUpdateClientFavoriteRaspaya objectDomain =  new ClientProcedureUpdateClientFavoriteRaspaya();
		try {
	       objectDomain = clientSaleDao.updateFavoriteRaspaya(p_flagDelete, p_clientid, p_productid);
	   } catch (Exception e) {
	       LoggerApi.severe(e);
	       throw e;
	   } finally {
	       if (objectDomain != null)
	           LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
	   }
	   return objectDomain;
	}
	
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws Exception {
		List<ClientProcedureGetRaspayaProviderList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProviderList>();
		try {
			resultQueryList = clientSaleDao.listProvidersRaspaya();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listProvidersRaspaya size= " + resultQueryList.size());
			else LoggerApi.Log.info("listProvidersRaspaya objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaCategoryProviderList> listCategoryProvidersRaspaya() throws Exception {
		List<ClientProcedureGetRaspayaCategoryProviderList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaCategoryProviderList>();
		try {
			resultQueryList = clientSaleDao.listCategoryProvidersRaspaya();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProvidersRaspaya size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProvidersRaspaya objectPojo: nulll");
		}
		return resultQueryList;
	}	
	

	@Override
	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId) throws Exception{
		LoggerApi.Log.info("p_clientId =" + clientId + " p_sessionId =" + sessionId);
		ClientProcedureUpdateDataClient objectDomain = new ClientProcedureUpdateDataClient();
        try {
            objectDomain = clientSaleDao.updateClient(dataClient, sessionId , clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + clientId + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception {
		LoggerApi.Log.info("p_clientId =" + clientId );
		ClientProcedureUpdatePassClient objectDomain = new ClientProcedureUpdatePassClient();
        try {
            objectDomain = clientSaleDao.updatePass(clientId, passUpdate , passConfirm);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("p_clientid=" + clientId + " p_message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	@Override
	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel) throws Exception {
		return clientSaleDao.yapePlinVerifyTransaction(p_clientId, channel);
	}

	public ClientProcedureUpdateVisaSession setVisaSession(Integer clientId, String visaSession) throws Exception {
		LoggerApi.Log.info("clientId=" + clientId + "  visaSession= " + visaSession);
		return clientSaleDao.setVisaSession(clientId, visaSession);
	}

	@Override
	public String findVisaSessionById(Integer clientId) throws Exception {
		LoggerApi.Log.info("findVisaSessionById clientId=" + clientId );
		return clientSaleDao.findVisaSessionById(clientId);
	}
	
	public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception {
        return clientSaleDao.getTokenValidation(p_token, ip);
    }
	
	public HashMap[] getMostPlayedCasino() throws Exception {
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getMostPlayedCasino();
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }
	
	public HashMap[] getMostPlayedRaspaya() throws Exception {
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getMostPlayedRaspaya();
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }
	
	public HashMap[] getMostPlayedVirtual() throws Exception {
        HashMap[] objectMap= null;
        try {
        	objectMap = clientSaleDao.getMostPlayedVirtual();
        	return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            //throw e;
            throw new Exception(e);	
        } finally {
        	if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			} else {
				LoggerApi.Log.info("objectMap: "+"null");	
			}
            
        }
    }

	@Override
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount,
			String platform, String operatorId) throws Exception {
		LoggerApi.Log.info("clientId=" + clientId+" amount="+amount+" platform="+platform
				+" operatorId="+operatorId);
		return clientSaleDao.setOriginVisaRecharge(sessionKey, clientId, amount, platform, operatorId);
	}

	@Override
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info(" platform="+platform +" operatorId="+operatorId);
		return clientSaleDao.setOriginPefeRecharge(transactionId, platform, operatorId);
	}

	@Override
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info(" platform="+platform +" operatorId="+operatorId);
		return clientSaleDao.setOriginBcpRecharge(transactionId, platform, operatorId);
	}

	@Override
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId) throws Exception {
		LoggerApi.Log.info(" platform="+platform+" operatorId="+operatorId);
		return clientSaleDao.setOriginLotocardRecharge(transactionId, platform, operatorId);
	}
	
	@Override
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novus_id)
			throws Exception {
		ClientProcedureUpdateNovusId objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_novus_id:"+p_novus_id);
			objectPojo = clientSaleDao.updateNovusId(p_clientId, p_novus_id);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
    public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception {
        LoggerApi.Log.info("findGetNovusId p_clientid=" + p_clientid);
        ClientProcedureGetNovusId objectDomain = new ClientProcedureGetNovusId();
        try {
            objectDomain = clientSaleDao.findGetNovusId(p_clientid);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findGetNovusId cid=" + objectDomain.getClientUser());
        }
        return objectDomain;
    }
    
    public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception {
        LoggerApi.Log.info("findLogin user=" + p_user + " password=***");
        ClientProcedureGetLoginData objectDomain = new ClientProcedureGetLoginData();
        try {
            objectDomain = clientSaleDao.getLoginData(p_user);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin cid=" + objectDomain.getClientId());
        }
        return objectDomain;
    }
	
	@Override
	public String getLinkRecoverPassword(String email, String name, String code, int option, String user,String game) {
		String urlRecuperarContrasenia="";
		String emailEncryt ="";
		String codedecoded = "";
		try {
            codedecoded = StringLib.decodeLabel(code);
            System.out.println("codigo encriptado : "+code);
            emailEncryt = StringLib.encodeLabel(email);
            System.out.println("codigo email encriptado : "+emailEncryt);
			
            System.out.println("codigo encriptado : "+code);
            emailEncryt = StringLib.encodeLabel(email);
            System.out.println("codigo email encriptado : "+emailEncryt);
        } catch (Exception e) {}
        
        if(game.equals("1")) {
       	 urlRecuperarContrasenia = Constants.latinkaUrlContrasenia+"?param1="+code+"&&param2="+emailEncryt;
            System.out.println(urlRecuperarContrasenia);
       }else if (game.equals("2")) {
       	 urlRecuperarContrasenia = Constants.latinkaUrlContraseniaTA+"?param1="+code+"&&param2="+emailEncryt;
           System.out.println(urlRecuperarContrasenia);
       }
        
        return urlRecuperarContrasenia;
    }
	
	@Override
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr)
			throws Exception {
		ClientProcedureUpdateBonoQr objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_bonoQr:"+p_bonoQr);
			objectPojo = clientSaleDao.updateBonoQr(p_clientId, p_bonoQr);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureGetSelfcontrol getDataSelfcontrol(Integer p_clientId) throws Exception {
		return clientSaleDao.getDataSelfcontrol(p_clientId);
	}

	@Override
	public ClientSecurityProcedureCheckIp findGetCheckIp(Integer clientId, String ip, String c_plataforma) throws Exception{
		ClientSecurityProcedureCheckIp objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+clientId+ " p_bonoQr:"+ip);
			objectPojo = clientSaleDao.findGetCheckIp(clientId, ip, c_plataforma);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getStatus()+" message: "+objectPojo.getMensaje());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}

	@Override
	public ClientSecurityWhiteList updateipWhitelis(Integer clientId, String ip, String respuesta_user, String p_plataforma)
			throws Exception {
		ClientSecurityWhiteList objectPojo= null;
		try {
			LoggerApi.Log.info("clientId:"+clientId+ " ip:"+ip + " respuesta_user:"+respuesta_user + " p_plataforma:"+p_plataforma);
			objectPojo = clientSaleDao.updateipWhitelis(clientId, ip, respuesta_user, p_plataforma);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getStatus()+" message: "+objectPojo.getMensaje());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public GetClientSecurity getipWhitelist(Integer clientId, String ip)
			throws Exception {
		GetClientSecurity objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+clientId+ " p_bonoQr:"+ip);
			objectPojo = clientSaleDao.getipWhitelist(clientId, ip);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getStatus());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
	@Override
	public ClientProcedureEditSelfcontrol editDataSelfcontrol(Integer p_clientId, double p_amount, String p_type) throws Exception {
		return clientSaleDao.editDataSelfcontrol(p_clientId,  p_amount, p_type);
	}
	
	@Override
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel)
			throws Exception {
		return clientSaleDao.yapePlinTupayVerifyTransaction(p_clientId, channel);
	}
	
	@Override
	public List<ClientProcedureGetLotteryProductList> listLotteryProducts() throws Exception {
		List<ClientProcedureGetLotteryProductList> resultQueryList = new ArrayList<ClientProcedureGetLotteryProductList>();
		try {
			resultQueryList = clientSaleDao.listLotteryProducts();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listLotteryProducts size= " + resultQueryList.size());
			else LoggerApi.Log.info("listLotteryProducts objectPojo: nulll");
		}
		return resultQueryList;
	}

	@Override
	public ClientProcedureUpdatePlayerIdVl updatePlayerIdVl(Integer p_clientId, String p_player_id_vl)
			throws Exception {
		ClientProcedureUpdatePlayerIdVl objectPojo= null;
		try {
			LoggerApi.Log.info("p_clientId:"+p_clientId+ " p_player_id_vl:"+p_player_id_vl);
			objectPojo = clientSaleDao.updatePlayerIdVl(p_clientId, p_player_id_vl);
			return objectPojo;
		} catch (Exception e) {
			LoggerApi.severe(e);
            throw e;
		} finally{ 
			if (objectPojo != null) LoggerApi.Log.info("state: "+objectPojo.getState()+" message: "+objectPojo.getMessage());
			else LoggerApi.Log.info("objectPojo: "+"null");
		}
	}
	
    @Override
    public ClientInformationResponseDTO getClientAutoPayment(Integer p_clientId){
        LoggerApi.Log.info("ClientSaleBoImpl getClientAutoPayment: p_clientid=" + p_clientId);
        ClientInformationResponseDTO response = new ClientInformationResponseDTO();
        try {
        	ClientGetCollectionType clientInformation = clientSaleDao.getClientAutoPayment(p_clientId);
        	response.setStatus("OK");
			response.setClientInformation(clientInformation);
			LoggerApi.Log.info("ClientSaleBoImpl getClientAutoPayment: FLAG autopayment = " 
		            + (clientInformation != null ? clientInformation.getPrizeCollection() : "null") 
		            + ", p_clientid=" + p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
        	response.setStatus("ERROR");
			response.setMessage(e.getMessage());
        } 
        return response;
    }
    
    @Override
    public ClientInformationResponseDTO updateAutoPaymentFlag(Integer p_clientId, String switchStatus) {
        LoggerApi.Log.info("ClientSaleBoImpl updateAutoPaymentFlag: p_clientid=" + p_clientId + " switchStatus=" + switchStatus);
        ClientInformationResponseDTO response = new ClientInformationResponseDTO();
        try {
        	boolean clientInformation = clientSaleDao.updateAutoPaymentFlag(p_clientId, switchStatus);
        	if(clientInformation) {
            	response.setStatus("OK");
            	
            	// Validar si es una migración de PDV a WEB para verificacion de boletos
            	if(switchStatus.equals("WEB") && response.getStatus().equals("OK")) {
            		final String clientString=String.valueOf(p_clientId);
            		// Iniciar escrutinio y premiación en segundo plano
            	    new Thread(new Runnable() {
            	        public void run() {
            	            try {            	            	
								GenerateWinners.runPremiadorTinkaexpress("41", clientString, "%", "%");
							} catch (Exception e) {
								LoggerApi.severe(e);
							}
            	        }
            	    }).start();
            	}
            	
    			LoggerApi.Log.info("ClientSaleBoImpl updateAutoPaymentFlag: FLAG Actualizado p_clientId=" + p_clientId + " switchStatus=" + switchStatus);
        	}else {
            	response.setStatus("ERROR");
    			LoggerApi.Log.info("ClientSaleBoImpl updateAutoPaymentFlag: FLAG NO Actualizado p_clientId=" + p_clientId + " switchStatus=" + switchStatus);
        	}
        } catch (Exception e) {
            LoggerApi.severe(e);
        	response.setStatus("ERROR");
			response.setMessage(e.getMessage());
        } 
        return response;
    }
}