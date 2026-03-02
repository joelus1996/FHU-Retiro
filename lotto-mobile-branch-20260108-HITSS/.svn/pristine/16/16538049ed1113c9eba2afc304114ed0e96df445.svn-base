package pe.com.intralot.loto.layer.controller.client.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;
import java.util.List;

import pe.com.intralot.loto.layer.dto.client.ClientInformationResponseDTO;
import pe.com.intralot.loto.layer.model.pojo.UbicacionRedDigital;
import pe.com.intralot.loto.layer.model.pojo.UbicacionTerminal;

public interface ClientPrizeBo {	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getPendingPrize(Integer id) throws Exception;
	
	public HashMap<String, Object> getPendingPrizeByTicketid(Integer gameid, Integer ticketid) throws Exception;
	
	public HashMap<String, Object> getTicketById(Integer gameid, Integer ticketid) throws Exception; // @jmoran 2019-06-24

	public List<UbicacionTerminal> findTerminalLocation(String latitude, String longitude) throws Exception;
	
	public List<UbicacionRedDigital> findRedDigitalLocation(String latitude, String longitude) throws Exception;
	
    public ClientInformationResponseDTO getClientAutoPayment(String p_clientId) throws Exception;
    
    public ClientInformationResponseDTO updateAutoPaymentFlag(String p_clientId, String switchStatus) throws Exception;
		
}