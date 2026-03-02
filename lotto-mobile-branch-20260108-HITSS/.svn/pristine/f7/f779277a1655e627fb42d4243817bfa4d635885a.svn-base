package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.client.bo.ClientSaleBo;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureRegisterPopupLottery;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientDevice;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteVirtuales;
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


@Service
public class ClientSaleBoImpl implements ClientSaleBo {

    @Autowired
    private ClientSaleDao clientSaleDao;
    
    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        ClientProcedureGetClient objectDomain = new ClientProcedureGetClient();
        try {
            objectDomain = clientSaleDao.findClient(p_sessionid, p_clientid);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
            if (objectDomain != null)
                LoggerApi.Log.info("p_nombre=" + objectDomain.getNombre() + " p_birthdate=" + objectDomain.getBirthdate() + " p_mail=" + objectDomain.getMail()
                        + " p_mailstatus=" + objectDomain.getMailstatus() + " p_item=" + objectDomain.getItem() + " p_amount=" + objectDomain.getAmount() + " p_mail2="
                        + objectDomain.getMail2() + " p_mail2status=" + objectDomain.getMail2status() + " p_address=" + objectDomain.getAddress() + " p_region="
                        + objectDomain.getRegion() + " p_country=" + objectDomain.getCountry() + " p_status=" + objectDomain.getStatus() + " p_terms="
                        + objectDomain.getTerms() + " p_lucky_icon=" + objectDomain.getLuckyIcon() + " p_fixed_phone=" + objectDomain.getFixedPhone() + " p_mobile_phone="
                        + objectDomain.getMobilePhone() + " p_mail_code=" + objectDomain.getMailCode());
                        */
        }
        return objectDomain;
    }

    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception {
        LoggerApi.Log.info("p_sessionid=" + p_sessionid + " p_clientid=" + p_clientid);
        ClientProcedureGetDataClient objectDomain = new ClientProcedureGetDataClient();
        try {
            objectDomain = clientSaleDao.findGetDataClient(p_sessionid, p_clientid);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	/*
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
                        + " p_control_last_date=" + objectDomain.getControlLastDate());
                        */
        }
        return objectDomain;
    }
    
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
    
    public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientid, String p_device) throws Exception {
		 LoggerApi.Log.info("p_clientid=" + p_clientid + "  p_device= " + p_device);
		ClientProcedureUpdateClientDevice objectDomain =  new ClientProcedureUpdateClientDevice();
		try {
           objectDomain = clientSaleDao.updateDevice(p_clientid, p_device);
       } catch (Exception e) {
           LoggerApi.severe(e);
           throw e;
       } finally {
           if (objectDomain != null)
               LoggerApi.Log.info("status=" + objectDomain.getState() + " message=" + objectDomain.getMessage());
       }
       return objectDomain;
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
    
    public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception {
        LoggerApi.Log.info("p_name=" + p_name);
        ClientProcedureGetRaspayaGameId objectDomain = new ClientProcedureGetRaspayaGameId();
        try {
            objectDomain = clientSaleDao.findGetRaspayaGameId(p_name);
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
    
    public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception {
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
   
    @Override
	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId ) throws Exception {
		LoggerApi.Log.info("p_sessionid=" + sessionId + " p_clientid=" + clientId);
		ClientProcedureUpdateDataClient objectDomain = new ClientProcedureUpdateDataClient();
        try {
            objectDomain = clientSaleDao.updateClient(dataClient,sessionId, clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception{
		LoggerApi.Log.info("p_clientid=" + clientId);
		ClientProcedureUpdatePassClient objectDomain = new ClientProcedureUpdatePassClient();
        try {
            objectDomain = clientSaleDao.updatePass(clientId,passUpdate, passConfirm);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	
        }
        return objectDomain;
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
	public ClientProcedureGetSelfcontrol getDataSelfcontrol(Integer p_clientId) throws Exception {
		return clientSaleDao.getDataSelfcontrol(p_clientId);
	}
	
	@Override
	public ClientProcedureEditSelfcontrol editDataSelfcontrol(Integer p_clientId, double p_amount, String p_type) throws Exception {
		return clientSaleDao.editDataSelfcontrol(p_clientId,  p_amount, p_type);
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
			LoggerApi.Log.info("clientId:"+clientId+ " ip:"+ip + " respuesta_user:"+respuesta_user+" p_plataforma:"+p_plataforma);
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

}
