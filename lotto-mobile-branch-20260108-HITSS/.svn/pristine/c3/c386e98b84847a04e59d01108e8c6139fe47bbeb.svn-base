package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.HashMap;
import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteRaspaya;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureDDVVTokenLogin;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureEditSelfcontrol;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetLotteryProductList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetRaspayaGameId;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureIIVVTokenGeneration;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureRegisterPopupLottery;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientDevice;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavorite;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateClientFavoriteVirtuales;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateDataClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePassClient;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdatePlayerIdVl;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityProcedureCheckIp;
import pe.com.intralot.loto.layer.model.pojo.ClientSecurityWhiteList;
import pe.com.intralot.loto.layer.model.pojo.GetClientSecurity;


public interface ClientSaleDao {

    public ClientProcedureGetClient findClient(Integer p_sessionid, Integer p_clientid) throws Exception;
    public ClientProcedureGetDataClient findGetDataClient(Integer p_sessionid, Integer p_clientid) throws Exception;
    public ClientProcedureIIVVTokenGeneration getIIVVToken(Integer p_clientid, String ip, String device) throws Exception;
    public ClientProcedureUpdateClientDevice updateDevice(Integer p_clientid, String p_device) throws Exception;
    public ClientProcedureUpdateClientFavorite updateFavorite(String p_flagDelete, Integer p_clientid, String p_device) throws Exception;
    public HashMap[] getFavoriteProduct(String client_id) throws Exception;
    public ClientProcedureGetRaspayaGameId findGetRaspayaGameId(String p_name) throws Exception;
    public ClientProcedureDDVVTokenGeneration getDDVVToken(Integer p_clientid, String ip, String device) throws Exception;
    public ClientProcedureDDVVTokenLogin getDDVVLogin(String p_token) throws Exception;
    public ClientProcedureUpdateClientFavoriteVirtuales updateFavoriteVirtuales(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception;
    public HashMap[] getFavoriteProductVirtuales(String client_id) throws Exception;
    public ClientProcedureRegisterPopupLottery registerPopupLottery(Integer p_clientId, String p_device, String p_source, Integer p_game_id) throws Exception;
    public HashMap[] getPromoHincha(String client_id) throws Exception;
    public HashMap[] getFavoriteProductRaspaya(String client_id) throws Exception;
    public ClientProcedureUpdateClientFavoriteRaspaya updateFavoriteRaspaya(String p_flagDelete, Integer p_clientid, String p_productid) throws Exception;    
	public ClientProcedureUpdateDataClient updateClient(ClientProcedureGetDataClient dataClient, Integer sessionId, Integer clientId) throws Exception;
	public ClientProcedureUpdatePassClient updatePass(Integer clientId, String passUpdate, String passConfirm) throws Exception;
	public HashMap[] getMostPlayedCasino() throws Exception;
	public HashMap[] getMostPlayedRaspaya() throws Exception;
	public HashMap[] getMostPlayedVirtual() throws Exception;
	public ClientSecurityProcedureCheckIp findGetCheckIp(Integer p_clientId, String ip, String c_plataforma) throws Exception; 
	public ClientSecurityWhiteList updateipWhitelis(Integer clientId, String ip, String respuesta_user, String p_plataforma) throws Exception;
	public GetClientSecurity getipWhitelist(Integer clientId, String ip) throws Exception;
	
	public ClientProcedureGetSelfcontrol getDataSelfcontrol(Integer p_clientId) throws Exception ;
	
	public ClientProcedureEditSelfcontrol editDataSelfcontrol(Integer p_clientId, double p_amount, String p_type) throws Exception;
	public List<ClientProcedureGetLotteryProductList> listLotteryProducts() throws Exception;
	public ClientProcedureUpdatePlayerIdVl updatePlayerIdVl(Integer p_clientId, String p_player_id_vl) throws Exception;

}
