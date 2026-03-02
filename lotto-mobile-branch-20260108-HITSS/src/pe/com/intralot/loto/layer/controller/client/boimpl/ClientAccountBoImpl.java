package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.client.bo.ClientAccountBo;
import pe.com.intralot.loto.layer.model.bean.Reclamacion;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientAddressLogDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.pojo.Client;
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
import pe.com.intralot.loto.sale.lib.LoggerApi;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */
@Service("beanClientAccountBo")
public class ClientAccountBoImpl implements ClientAccountBo {
  
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ClientDao beanClientDao;	
	
	@Autowired
	private ClientAddressLogDao beanClientAddressLogDao;
 		
	public Client findClientById(Integer id) throws Exception {
		Client objectPojo= new Client();
		LoggerApi.Log.info("cid=" + id+" ClientAccountBoImpl.findClientById");
		try {
			objectPojo= beanClientDao.findByPk(id);
			
			return objectPojo;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally {
			if(objectPojo!=null){
				LoggerApi.Log.info("cid=" + id+" ClientAccountBoImpl.findClientById objectPojo: "+objectPojo.toString());
			}else{
				LoggerApi.Log.info("cid=" + id+" ClientAccountBoImpl.findClientById objectPojo: "+"nulll");
			}
		}
	}
	
	public List<Country> findCountry() throws Exception {
		LoggerApi.Log.info("findCountry");
		List<Country> resultQueryList = new ArrayList<Country>();
		try {
			resultQueryList = beanClientDao.findCountry();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("findCountry size= " + resultQueryList.size());
			else LoggerApi.Log.info("findCountry objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<Region> findRegion() throws Exception {
		LoggerApi.Log.info("findRegion");
		List<Region> resultQueryList = new ArrayList<Region>();
		try {
			resultQueryList = beanClientDao.findRegion();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("findRegion size= " + resultQueryList.size());
			else LoggerApi.Log.info("findRegion objectPojo: nulll");
		}
		return resultQueryList;
	}
	
    public PromoFirstAccount promotionFirstAccount(Integer cb_client_id, Integer cb_balance_item) throws Exception {
        LoggerApi.Log.info("cid=" + cb_client_id + "  cb_balance_item= " + cb_balance_item+" promotionFirstAccount");
        PromoFirstAccount objectDomain = new PromoFirstAccount();
        try {
            objectDomain = beanClientDao.promotionFirstAccount(cb_client_id, cb_balance_item);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + cb_client_id + " getPromotion_eco=" + objectDomain.getPromotion_eco() + " getPromotion_message=" + objectDomain.getPromotion_message()+" promotionFirstAccount");
        }
        return objectDomain;
    }

	
	public ClientProcedureUpdateClientMail updateMail(Integer p_clientid, String mail) throws Exception {
		 LoggerApi.Log.info("status=" + p_clientid + "  message= " + mail);
		ClientProcedureUpdateClientMail objectDomain =  new ClientProcedureUpdateClientMail();
		try {
            objectDomain = beanClientDao.resetMail(p_clientid, mail);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
        }
        return objectDomain;
	}

	public ClientProcedureLogin findLogin(String p_user, String p_password) throws Exception {
		LoggerApi.Log.info("findLogin user=" + p_user + " password=***");
        ClientProcedureLogin objectDomain = new ClientProcedureLogin();
        try {
            objectDomain = beanClientDao.findLogin(p_user, p_password);
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
	public void saveLoginLog(ClientAddressLog clientAddressLog) throws Exception{
		beanClientAddressLogDao.saveLoginLog(clientAddressLog);
	}

	@Override
	public ClientTutorial evalTutorial(Object[] values)	throws Exception {
		return beanClientDao.evalTutorial(values);
	}

	@Override
	public Reclamacion registrarReclamacion(Reclamacion reclamacion) throws Exception {
		return beanClientDao.registrarReclamacion(reclamacion);
	}
	
	public List<ClientProcedureGetCasinoProductList> listCasinoProducts() throws Exception {
		List<ClientProcedureGetCasinoProductList> resultQueryList = new ArrayList<ClientProcedureGetCasinoProductList>();
		try {
			resultQueryList = beanClientDao.listCasinoProducts();
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
			resultQueryList = beanClientDao.listCasinoProductsOrder();
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
			resultQueryList = beanClientDao.listRaspayaProducts();
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
			resultQueryList = beanClientDao.listRaspayaProductsOrder();
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
			resultQueryList = beanClientDao.listRaspayaProductsPrice();
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
			resultQueryList = beanClientDao.listRaspayaProductsPozo();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listRaspayaProductsPozo size= " + resultQueryList.size());
			else LoggerApi.Log.info("listRaspayaProductsPozo objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetVirtualesProductList> listVirtualesProducts() throws Exception {
		List<ClientProcedureGetVirtualesProductList> resultQueryList = new ArrayList<ClientProcedureGetVirtualesProductList>();
		try {
			resultQueryList = beanClientDao.listVirtualesProducts();
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
			resultQueryList = beanClientDao.listVirtualesProductsOrder();
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
			resultQueryList = beanClientDao.listProviders();
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
			resultQueryList = beanClientDao.listCategoryProviders();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProviders size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProviders objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetVirtualesProviderList> listProvidersVirtuales() throws Exception {
		List<ClientProcedureGetVirtualesProviderList> resultQueryList = new ArrayList<ClientProcedureGetVirtualesProviderList>();
		try {
			resultQueryList = beanClientDao.listProvidersVirtuales();
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
			resultQueryList = beanClientDao.listCategoryProvidersVirtuales();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProvidersVirtuales size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProvidersVirtuales objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public List<ClientProcedureGetRaspayaProviderList> listProvidersRaspaya() throws Exception {
		List<ClientProcedureGetRaspayaProviderList> resultQueryList = new ArrayList<ClientProcedureGetRaspayaProviderList>();
		try {
			resultQueryList = beanClientDao.listProvidersRaspaya();
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
			resultQueryList = beanClientDao.listCategoryProvidersRaspaya();
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList != null) LoggerApi.Log.info("listCategoryProvidersRaspaya size= " + resultQueryList.size());
			else LoggerApi.Log.info("listCategoryProvidersRaspaya objectPojo: nulll");
		}
		return resultQueryList;
	}
	
	public ClientProcedureUpdateVisaSession setVisaSession(Integer clientId, String visaSession) throws Exception {
		LoggerApi.Log.info("clientId=" + clientId + "  visaSession= " + visaSession);
		ClientProcedureUpdateVisaSession objectDomain = new ClientProcedureUpdateVisaSession();
		try {
			objectDomain = beanClientDao.setVisaSession(clientId, visaSession);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}

	@Override
	public String findVisaSessionById(Integer clientId) throws Exception {
		LoggerApi.Log.info("findVisaSessionById clientId=" + clientId);
		String result = "";
		try {
			result = beanClientDao.findVisaSessionById(clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (result == null || result.equals(""))
				LoggerApi.Log.info("findVisaSessionById Hubo un error al intentar obtener VisaSession");
		}
		return result;
	}

	@Override
	public ClientProcedureOriginVisaRecharge setOriginVisaRecharge(String sessionKey, String clientId,
			double amount, String platform, String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginVisaRecharge clientId=" + clientId+" amount="+amount+" platform="+platform
				+" operatorId="+operatorId);
		ClientProcedureOriginVisaRecharge objectDomain = new ClientProcedureOriginVisaRecharge();
		try {
			objectDomain = beanClientDao.setOriginVisaRecharge(sessionKey, clientId, amount, platform, operatorId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("status=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}

	@Override
	public ClientProcedureOriginPefeRecharge setOriginPefeRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginPefeRecharge platform="+platform + " operatorId="+operatorId);
		ClientProcedureOriginPefeRecharge objectDomain = new ClientProcedureOriginPefeRecharge();
		try {
			objectDomain = beanClientDao.setOriginPefeRecharge(transactionId, platform, operatorId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("status=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}

	@Override
	public ClientProcedureOriginBcpRecharge setOriginBcpRecharge(String transactionId, String platform,
			String operatorId) throws Exception {
		LoggerApi.Log.info("setOriginBcpRecharge platform="+platform + " operatorId="+operatorId);
		ClientProcedureOriginBcpRecharge objectDomain = new ClientProcedureOriginBcpRecharge();
		try {
			objectDomain = beanClientDao.setOriginBcpRecharge(transactionId, platform, operatorId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("status=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}

	@Override
	public ClientProcedureOriginLotocardRecharge setOriginLotocardRecharge(String transactionId, String platform, String operatorId)
			throws Exception {
		LoggerApi.Log.info("setOriginLotocardRecharge platform="+platform+" operatorId="+operatorId);
		ClientProcedureOriginLotocardRecharge objectDomain = new ClientProcedureOriginLotocardRecharge();
		try {
			objectDomain = beanClientDao.setOriginLotocardRecharge(transactionId, platform, operatorId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null)
				LoggerApi.Log.info("status=" + objectDomain.getStatus() + " message=" + objectDomain.getMessage());
		}
		return objectDomain;
	}
	
	public ClientProcedureGetLoginData getLoginData(String p_user) throws Exception {
		LoggerApi.Log.info("findLogin user=" + p_user + " password=***");
		ClientProcedureGetLoginData objectDomain = new ClientProcedureGetLoginData();
        try {
            objectDomain = beanClientDao.getLoginData(p_user);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findLogin cid=" + objectDomain.getClientId());
        }
        return objectDomain;
	}

}