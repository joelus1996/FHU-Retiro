package pe.com.intralot.loto.layer.controller.client.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import pe.com.intralot.loto.layer.dto.client.ClientGameInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientGameInformationResponseDTO;
import pe.com.intralot.loto.layer.model.pojo.Client;

public interface ClientPlayBo {	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getClientPlayCouponAll(Integer id) throws Exception;	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getClientPlayCouponPP(Integer id, Integer ticket) throws Exception;	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getClientPlayCouponFilterAll(Integer id, String start_date, String end_date) throws Exception;	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getTicketDetailRetail(Integer p_clientId, Integer gameId, String ticket) throws Exception;	
	
	@SuppressWarnings("rawtypes")
	public HashMap[]  getTicketDetailRetailGrecia(Integer p_programa, Integer cpn) throws Exception;	
	
	public Client findClientById(Integer id) throws Exception;	
	
	public pe.com.intralot.loto.layer.model.bean.Client findAccountData(Integer id) throws Exception;	
	
	ClientGameInformationResponseDTO getClientGameInformation(ClientGameInformationRequestDTO request, HttpSession session) throws Exception;

	
}