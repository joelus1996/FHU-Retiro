package pe.com.intralot.loto.layer.model.persistence.dao;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

public interface ClientDao {
		
	public Client findByIdClient(Integer idClient) throws Exception;
	public Client findByUser(String user) throws Exception;
	public Client findByUserByPassword(String user,String password) throws Exception;
	public Client findByMail(String mail) throws Exception;
	
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId, String mobilePhone, String docType, String docNumber) throws Exception;
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception;
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception;

}