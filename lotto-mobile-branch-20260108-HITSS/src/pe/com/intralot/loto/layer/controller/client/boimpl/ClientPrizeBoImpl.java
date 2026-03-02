package pe.com.intralot.loto.layer.controller.client.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import pe.com.intralot.loto.card.setup.GenerateWinners;
import pe.com.intralot.loto.layer.controller.client.bo.ClientPrizeBo;
import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.model.bean.ClientGetCollectionType;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.UbicacionRedDigital;
import pe.com.intralot.loto.layer.model.pojo.UbicacionTerminal;
import pe.com.intralot.loto.model.Game;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.sale.tinkaexpress.GenerateWinners;

@Service("beanClientPrizeBo")
public class ClientPrizeBoImpl implements ClientPrizeBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProcedureDao beanProcedureDao;
	
	@Autowired
	private ClientDao beanClientDao;
 
	@SuppressWarnings("rawtypes")	
	public HashMap[] getPendingPrize(Integer id) throws Exception {
		//LoggerApi.Log.info("cid="+id+" getPendingPrize");
		HashMap[] objectMap= null;
		Integer gid = 0, fdrwid = 0, tdrwid = 0;
	    try {
	    	objectMap= beanProcedureDao.getPendingPrize(id);
	    	for(HashMap map : objectMap) {
				gid = (map.get("GAMEID")!=null)?Integer.parseInt(map.get("GAMEID").toString()):null;
				fdrwid = (map.get("GFROMDRAW")!=null)?Integer.parseInt(map.get("GFROMDRAW").toString()):null;
				tdrwid = (map.get("GTODRAW")!=null)?Integer.parseInt(map.get("GTODRAW").toString()):null;
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&fdrwid>5000) map.put("fdrwid", fdrwid-5000);
				else map.put("fdrwid", fdrwid);
				if((gid==Game.TINKA||gid==Game.GANAGOL||gid==Game.GANADIARIO||gid==Game.KABALA)&&tdrwid>5000) map.put("tdrwid", tdrwid-5000);
				else map.put("tdrwid", tdrwid);
			}
			return objectMap;
		} catch (Exception e) {
			e.printStackTrace();
			LoggerApi.severe(e);			
			throw new Exception(e);	
		} finally{
			/*
			if(objectMap!=null){
				LoggerApi.Log.info("cid="+id+" getPendingPrize objectMap: "+objectMap.length);
			}else{
				LoggerApi.Log.info("cid="+id+" getPendingPrize objectMap: null");	
			}
			*/
		}
	}
	
	public HashMap<String, Object> getPendingPrizeByTicketid(Integer gameid, Integer ticketid) throws Exception{
		HashMap<String, Object> objectMap=null;
		LoggerApi.Log.info("gameid: "+gameid+" ticketid: "+ticketid);
	    try {
	    	
	    	objectMap= beanProcedureDao.getPendingPrizeByTicketid(gameid, ticketid);
			
			return objectMap;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.size());
			}else{
				LoggerApi.Log.info("objectMap: "+"null");	
			}
			}
		
	}
	
	// @jmoran 2019-06-24 - inicio
	public HashMap<String, Object> getTicketById(Integer gameid, Integer ticketid) throws Exception{
		HashMap<String, Object> objectMap=null;
		LoggerApi.Log.info("gameid: "+gameid+" ticketid: "+ticketid);
	    try {
	    	
	    	objectMap= beanProcedureDao.getTicketById(gameid, ticketid);
			
			return objectMap;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.size());
			}else{
				LoggerApi.Log.info("objectMap: "+"null");	
			}
			}
		
	}
	// @jmoran 2019-06-24 - fin
	
	public List<UbicacionTerminal> findTerminalLocation(String latitude, String longitude) throws Exception  {
		
		List<UbicacionTerminal> resultQuery = new ArrayList<UbicacionTerminal>();
		LoggerApi.Log.info("latitude: "+latitude+" longitude: "+longitude);
	 	try {
	 		resultQuery = beanClientDao.findTerminalLocation(latitude, longitude);			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}

	public List<UbicacionRedDigital> findRedDigitalLocation(String latitude, String longitude) throws Exception {

		List<UbicacionRedDigital> resultQuery = new ArrayList<UbicacionRedDigital>();
		LoggerApi.Log.info("latitude: "+latitude+" longitude: "+longitude);
	 	try {
	 		resultQuery = beanClientDao.findRedDigitalLocation(latitude, longitude);			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}
	
    @Override
    public ClientInformationResponseDTO getClientAutoPayment(String p_clientId){
        LoggerApi.Log.info("ClientSaleBoImpl getClientAutoPayment: p_clientid=" + p_clientId);
        ClientInformationResponseDTO response = new ClientInformationResponseDTO();
        try {
        	ClientGetCollectionType clientInformation = beanClientDao.getClientAutoPayment(p_clientId);
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
    public ClientInformationResponseDTO updateAutoPaymentFlag(String p_clientId, String switchStatus) {
        LoggerApi.Log.info("ClientSaleBoImpl updateAutoPaymentFlag: p_clientid=" + p_clientId + " switchStatus=" + switchStatus);
        ClientInformationResponseDTO response = new ClientInformationResponseDTO();
        try {
        	boolean clientInformation = beanClientDao.updateAutoPaymentFlag(p_clientId, switchStatus);
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