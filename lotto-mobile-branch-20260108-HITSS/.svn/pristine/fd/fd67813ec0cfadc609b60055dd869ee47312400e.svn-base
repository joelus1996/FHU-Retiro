package pe.com.intralot.loto.layer.controller.client.bo;

import java.util.List;
import pe.com.intralot.loto.layer.model.pojo.ClientAddressLog;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoCategoryProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProductListOrder;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetCasinoProviderList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLoginData;
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
import pe.com.intralot.loto.layer.model.bean.Reclamacion;
import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginBcpRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginLotocardRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginPefeRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureOriginVisaRecharge;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientMail;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateVisaSession;
import pe.com.intralot.loto.layer.model.pojo.ClientTutorial;
import pe.com.intralot.loto.layer.model.pojo.Country;
import pe.com.intralot.loto.layer.model.pojo.PromoFirstAccount;
import pe.com.intralot.loto.layer.model.pojo.Region;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */
public interface ClientAccountBo {	

	public Client findClientById(Integer id) throws Exception;
	
	public List<Country> findCountry() throws Exception;
	
	public List<Region> findRegion() throws Exception;
	
	public PromoFirstAccount promotionFirstAccount(Integer cb_client_id, Integer cb_balance_item) throws Exception;

	public ClientProcedureUpdateClientMail updateMail(Integer p_clientid,String mail) throws Exception;

	public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception;
	
	public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception;
	
	public ClientTutorial evalTutorial(Object[] values)throws Exception;
	
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception;
	
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
	
	public ClientProcedureUpdateVisaSession setVisaSession(Integer clientId, String visaSession) throws Exception;
	
	public String findVisaSessionById(Integer clientId) throws Exception;
	
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId, double amount, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId) throws Exception;
	
	public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception;
	
}