package pe.com.intralot.loto.layer.service.client.bo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.dto.img.ImgDto;
import pe.com.intralot.loto.layer.model.bean.ClientBean;
import pe.com.intralot.loto.layer.model.domain.ClientAddressLog;
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
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetCasinoProviderList;
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
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateMail;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateNovusId;
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
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureLPTokenGeneration;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureUpdatePassClient;


/**
 * <p>
 * NOMBRE: ClientSaleBo.java
 * <br></p>
 * <p>
 * FUNCION: Objeto de lógica del negocio de datos de la cuenta 
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

public interface ClientSaleBo {

    public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception;

    public ClientProcedureActivateClient findActivateClient(Integer p_clientId, String p_mailCode) throws Exception;

    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception;

    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception;

    public ClientProcedureGetNewCode findGetNewCode(Integer p_clientId) throws Exception;

    public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception;

    public ClientProcedureResetNewPassword resetNewPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception;

    public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception;

    public ClientProcedurePutClient findPutclient(ClientBean clientBean) throws Exception;
    
    public ClientProcedurePutNewClient putNewClient(ClientBean clientBean) throws Exception;

    public ClientProcedureSaleLoadPrepaidCard findSaleLoadPrepaidCard(Integer p_clientId, String p_company, String p_carrier, String p_phone, String p_ip, String p_pin)
            throws Exception;

    public ClientProcedureUpdateMail findUpdateMail(Integer p_clientId, String p_mail) throws Exception;

    public ClientProcedureUpdatePassword findUpdatePassword(Integer p_clientId, String p_password) throws Exception;

    public ClientProcedureNewSessionData setClientRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception;

    public ClientProcedureUpdateClient updateClient(ClientBean clientBean) throws Exception;

    public ClientProcedureSessionData updateRandomCode(Integer p_sessionid, Integer p_clientid, String p_randomcode) throws Exception;

    public String clientSendMail(String email, String name, String code, int option, String user);
    
    public String clientSendMail2(String email, String name, String code, int option, String user,String game);
    
	public String enviarMailPD(ByteArrayOutputStream bis,List<ImgDto>listImgDto,String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento,String numeroDocumento);
	
	public String enviarMailClientePD(String body,String tipo_solicitud,String nombres,String apellidos,String tipoDocumento, String numeroDocumento,String email);
	
    public String clientSendUserMail(String email);

    public boolean isAllowedGoIn(String user);

    public String toUC1stLetter(String s);

    public ClientProcedureActivateClientSamp activateClientSamp(String p_client_id, String p_mail, String p_mail_code, String p_random_code, String p_game_code)
            throws Exception;

    public PromoFirstAccount promotionFirstAccount(Integer cb_client_id, Integer cb_balance_item) throws Exception;
    
    public  ClientProcedureVerifyClientPromo verifyClientPromo(String p_client_id, String p_mail, String p_mail_code, String p_random_code) throws Exception;
    
    public String updateClientPromo(ClientBean clientBean) throws Exception;
    
    public ClientProcedureVerifyClient verifyClient(String p_client_id, String p_mail, String p_mail_code) throws Exception;
    
    public ClientProcedureVerifyClientBond verifyClientBond(String p_client_id, String p_mail_code) throws Exception;

    public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception;
    
    public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception;
 
    public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception;
    
    public ClientProcedureIIVVTokenGeneration getIIVVToken(Integer p_clientid, String ip, String device) throws Exception;
    
    public ClientProcedureUpdateAgreement updateAgreement(Integer p_clientId) throws Exception;
    
    public int findClientDNI(String dni) throws Exception;
    
    public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId,String p_sms) throws Exception;
    
    public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId,String p_sms, Integer p_time_minutes) throws Exception;

    public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception;
    
    public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception;
    
    public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception;
    
    public ClientProcedureCancelPromotion cancelPromotion(Object[] values) throws Exception;
    
    public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception;
    
    public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception;
    
    public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values) throws Exception;

    public PinPrinted findLotocard(String pin) throws Exception;

	public String findMobileSmsStatus(Integer parseInt);
	
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception;
	
	public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception;
	
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception;
	
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception;
	
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_player_id_xpg) throws Exception;
	
	public ClientProcedureGetPlayerId findGetPlayerId(Integer p_clientid) throws Exception;
	
	public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientId, String p_player_id_xpg) throws Exception;
	
	public ClientProcedureUpdateClientFavorite updateFavorite(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception;
	
	public HashMap[] getFavoriteProduct(String client_id) throws Exception;
	
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws Exception;
	
	public List<ClientProcedureGetCasinoProductListOrder> listCasinoProductsOrder() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductList> listRaspayaProducts() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductListOrder> listRaspayaProductsOrder() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductPriceList> listRaspayaProductsPrice() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductPozoList> listRaspayaProductsPozo() throws Exception;
	
	public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception;
	
	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId, String phoneUpdateAgora, String phoneUpdate) throws Exception;
		
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate) throws Exception;
	
	public ClientProcedureDDVVTokenGeneration getDDVVToken(Integer p_clientid, String ip, String device) throws Exception;
	
	public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception;
	
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws Exception;
	
	public List<ClientProcedureGetVirtualesProductListOrder> listVirtualesProductsOrder() throws Exception;
		
	public List<ClientProcedureGetCasinoProviderList> listProviders() throws Exception;
	
	public List<ClientProcedureGetCasinoCategoryProviderList> listCategoryProviders() throws Exception;
	
	public String findCodUserfilter1(String dni, String nombre) throws Exception;
	
	public String findCodUserfilter2(String dni, String correo) throws Exception;
	
	public String findCodUserfilter3(String dni, String celular) throws Exception;
	
	public ClientProcedureUpdateClientFavoriteVirtuales updateFavoriteVirtuales(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception;
	
	public HashMap[] getFavoriteProductVirtuales(String client_id) throws Exception;
	
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws Exception;
	
	public List<ClientProcedureGetVirtualesCategoryProviderList> listCategoryProvidersVirtuales() throws Exception;
	
	public ClientProcedureRegisterPopupLottery registerPopupLottery(Integer p_clientId, String p_device, String p_source, Integer p_game_id) throws Exception;
	
	public HashMap[] getPromoHincha(String client_id) throws Exception;

	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId) throws Exception;

	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception;

	public HashMap[] getFavoriteProductRaspaya(String client_id) throws Exception;
	
	public ClientProcedureUpdateClientFavoriteRaspaya updateFavoriteRaspaya(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception;
	
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws Exception;
	
	public List<ClientProcedureGetRaspayaCategoryProviderList> listCategoryProvidersRaspaya() throws Exception;
	
	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel) throws Exception;
	
	public ClientProcedureUpdateVisaSession setVisaSession(Integer clientId, String visaSession) throws Exception;
	
	public String findVisaSessionById(Integer clientId) throws Exception;
	
    public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception;
	
	public HashMap[] getMostPlayedCasino() throws Exception;
	
	public HashMap[] getMostPlayedRaspaya() throws Exception;
	
	public HashMap[] getMostPlayedVirtual() throws Exception;
	
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novus_id) throws Exception;
	
	public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception;
	
	public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception;
	
	public String getLinkRecoverPassword(String email, String name, String code, int option, String user,String game);
	
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception;
	
	public ClientProcedureGetSelfcontrol getDataSelfcontrol(Integer p_clientId ) throws Exception;

	public ClientSecurityProcedureCheckIp findGetCheckIp(Integer clientId, String ip, String c_plataforma) throws Exception;
	
	public ClientSecurityWhiteList updateipWhitelis(Integer clientId, String ip, String respuesta_user, String p_plataforma) throws Exception;
	
	public GetClientSecurity getipWhitelist(Integer clientId, String ip) throws Exception;
	
	public ClientProcedureEditSelfcontrol editDataSelfcontrol(Integer p_clientId, double p_amount, String p_type) throws Exception;
	
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel) throws Exception;
	
    public List<ClientProcedureGetLotteryProductList> listLotteryProducts() throws Exception;
	
	public ClientProcedureUpdatePlayerIdVl updatePlayerIdVl(Integer p_clientId, String p_player_id_vl) throws Exception;
	
    public ClientInformationResponseDTO getClientAutoPayment(Integer p_clientId) throws Exception;
    
    public ClientInformationResponseDTO updateAutoPaymentFlag(Integer p_clientId, String switchStatus) throws Exception;

}