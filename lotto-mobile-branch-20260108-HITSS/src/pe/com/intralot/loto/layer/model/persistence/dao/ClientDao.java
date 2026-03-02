package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.HashMap;
import java.util.List;

import pe.com.intralot.loto.layer.model.bean.ClientGetCollectionType;
import pe.com.intralot.loto.layer.model.bean.Reclamacion;
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
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.layer.model.pojo.Region;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;
import pe.com.intralot.loto.layer.model.pojo.UbicacionRedDigital;
import pe.com.intralot.loto.layer.model.pojo.UbicacionTerminal;

/**
 * <p>
 * NOMBRE: ClientDao.java
 * <br></p>
 * <p>
 * FUNCION: Objeto de acceso a datos de la cuenta
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Métodos para la activación y rechazo del bono de TA por recargas Interbank
 * 001   Cristian Cortez  06/10/2010  First comment
 * </pre>
 * <br></p>
 */

public interface ClientDao {
	
	public Client findByUser(Object params[]) throws Exception ;	
	
	public Client findByPk(Integer pk) throws Exception;
	
	public List<UbicacionTerminal> findTerminalLocation(String latitude, String longitude) throws Exception;
	
	public List<UbicacionRedDigital> findRedDigitalLocation(String latitude, String longitude) throws Exception;
	
	public HashMap[] updateAgreement(Integer p_clientId) throws Exception;
	
	public HashMap[] getPasswordCode(String mail, String password_code) throws Exception;
	
	public HashMap[] resetNewPassword(String mail, String password_code, String password1, String password2) throws Exception;
	
	public String fintUserByMail(String mail, String password_code) throws Exception;
	
	public List<Country> findCountry() throws Exception;
	
	public List<Region> findRegion() throws Exception; 
	
	public PromoFirstAccount promotionFirstAccount(Integer cb_client_id, Integer cb_balance_item) throws Exception;
	
	public Client findUserReminder(String email) throws Exception;
	
	public ClientProcedureGetPasswordCode findGetPasswordCode(String p_mail, String p_password_code) throws Exception;

    public ClientProcedureResetNewPassword resetPassword(String p_mail, String p_password_code, String p_password_1, String p_password_2) throws Exception;

	public ClientProcedureTokenGeneration getToken(Integer p_clientid, String channel, String ip) throws Exception;
	
	public ClientProcedureLPTokenGeneration getLPToken(Integer p_clientid, String ip) throws Exception;
	
	public ClientProcedureTANTokenGeneration getTANToken(Integer p_clientid, String ip) throws Exception;
	
	public ClientProcedureTokenValidation getTokenValidation(String p_token, String ip) throws Exception;
	
	public ClientProcedureUpdateClientMail resetMail(int p_clientid, String p_mail) throws Exception;
	
	public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception;
	
	public ClientProcedurePutSmsRegisterData putSmsRegisterData(Integer p_clientId,String p_sms) throws Exception;
	   
	public ClientProcedureUpdateSmsRegister updateSmsRegister(Integer p_clientId,String p_sms, Integer p_time_minutes) throws Exception;

	public ClientProcedureUpdatePhone updatePhoneClient(Integer p_clientId, String p_phone) throws Exception;
	
	public ClientProcedureActivatePromotion activatePromotion(Object[] values) throws Exception;
	
	public ClientProcedureActivateWBPromotion activateWBPromotion(Object[] values) throws Exception;
	   
	public ClientProcedureCancelPromotion cancelPromotion(Object[] values) throws Exception;
	
	public ClientProcedureActivateWBPromotionibk activateWBPromotionibk(Object[] values) throws Exception;
	
	public ClientProcedureActivatePromotionibk activatePromotionibk(Object[] values) throws Exception;
	   
	public ClientProcedureCancelPromotionibk cancelPromotionibk(Object[] values) throws Exception;
	
	public PinPrinted findLotocard(String pin) throws Exception;
	
	public ClientTutorial evalTutorial(Object[] values) throws Exception;
	
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception;
	
	public ClientProcedureUpdatePlayerId updatePlayerId(Integer p_clientId, String p_playerId) throws Exception;
	
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws Exception;
	
	public List<ClientProcedureGetCasinoProductListOrder> listCasinoProductsOrder() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductList> listRaspayaProducts() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductListOrder> listRaspayaProductsOrder() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductPriceList> listRaspayaProductsPrice() throws Exception;
	
	public List<ClientProcedureGetRaspayaProductPozoList> listRaspayaProductsPozo() throws Exception;
	
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws Exception;
	
	public List<ClientProcedureGetVirtualesProductListOrder> listVirtualesProductsOrder() throws Exception;
	
	public List<ClientProcedureGetCasinoProviderList> listProviders() throws Exception;
	
	public List<ClientProcedureGetCasinoCategoryProviderList> listCategoryProviders() throws Exception;
	
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws Exception;
	
	public List<ClientProcedureGetVirtualesCategoryProviderList> listCategoryProvidersVirtuales() throws Exception;
	
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws Exception;
	
	public List<ClientProcedureGetRaspayaCategoryProviderList> listCategoryProvidersRaspaya() throws Exception;
	
	public String findCodUserfilter1(String dni, String nombre) throws Exception;
	
	public String findCodUserfilter2(String dni, String correo) throws Exception;
	
	public String findCodUserfilter3(String dni, String celular) throws Exception;
	
	public ClientProcedureUpdateVisaSession setVisaSession(int clientId, String visaSession) throws Exception;
	
	public String findVisaSessionById(Integer clientId) throws Exception;
	
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureUpdateNovusId updateNovusId(Integer p_clientId, Long p_novusId) throws Exception;
	
	public ClientProcedureGetNovusId findGetNovusId(Integer p_clientid) throws Exception;
	
	public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception;
	
	public ClientProcedureUpdateBonoQr updateBonoQr(Integer p_clientId, String p_bonoQr) throws Exception;
	
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId, String mobilePhone, String docType, String docNumber) throws Exception;
	
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception;
	
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception;
	
    public ClientGetCollectionType getClientAutoPayment(String p_clientId) throws Exception;
   
    public boolean updateAutoPaymentFlag(String p_clientId, String switchStatus) throws Exception;
}