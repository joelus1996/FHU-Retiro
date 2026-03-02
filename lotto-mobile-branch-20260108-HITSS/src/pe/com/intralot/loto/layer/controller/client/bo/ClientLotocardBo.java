package pe.com.intralot.loto.layer.controller.client.bo;


/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import pe.com.intralot.loto.layer.model.pojo.Client;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.pojo.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.pojo.PinPrinted;

public interface ClientLotocardBo {	

	public Client findClientById(Integer id) throws Exception;	
	public PinPrinted findLotocard(String pin) throws Exception;
	
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId, String mobilePhone, String docType, String docNumber) throws Exception;
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception;
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception;
}