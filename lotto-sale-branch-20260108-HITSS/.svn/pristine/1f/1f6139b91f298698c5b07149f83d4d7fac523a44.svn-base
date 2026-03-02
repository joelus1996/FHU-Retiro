package pe.com.intralot.loto.layer.service.client.boimpl;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.layer.service.client.bo.ClientBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ClientBoImpl implements ClientBo {

   
    @Autowired
    private ClientDao clientDao;

    @Override
    public Client findByIdClient(Integer idClient) throws Exception {
    	LoggerApi.Log.info("idClient=" + idClient);
        Client objectDomain = new Client();
        try {
            objectDomain = clientDao.findByIdClient(idClient);
        } catch (Exception e) {
        	LoggerApi.severe(e);
			throw e;
        } finally {
        	if (objectDomain != null) {
				LoggerApi.Log.info("idClient= " + objectDomain.getIdClient() + " mail=" + objectDomain.getMail());
			}
        }
        return objectDomain;
    }

    @Override
    public Client findByUser(String user) throws Exception {
    	LoggerApi.Log.info("user=" + user);
        Client objectDomain = new Client();
        try {
            objectDomain = clientDao.findByUser(user);
        } catch (Exception e) {
        	LoggerApi.severe(e);
			throw e;
        } finally {
        	if (objectDomain != null) {
				LoggerApi.Log.info("idClient= " + objectDomain.getIdClient() + " mail=" + objectDomain.getMail());
			}
        }
        return objectDomain;
    }

    @Override
    public Client findByUserByPassword(String user, String password) throws Exception {
    	LoggerApi.Log.info("user=" + user + " password=***");
        Client objectDomain = new Client();
        try {
            objectDomain = clientDao.findByUserByPassword(user, password);
        } catch (Exception e) {
        	LoggerApi.severe(e);
			throw e;
        } finally {
        	if (objectDomain != null) {
				LoggerApi.Log.info("idClient= " + objectDomain.getIdClient() + " mail=" + objectDomain.getMail());
			}
        }
        return objectDomain;
    }

	@Override
	public Client findByMail(String mail) throws Exception {
		LoggerApi.Log.info("mail=" + mail);
        Client objectDomain = new Client();
        try {
            objectDomain = clientDao.findByMail(mail);
        } catch (Exception e) {
        	LoggerApi.severe(e);
			throw e;
        } finally {
        	if (objectDomain != null) {
				LoggerApi.Log.info(" mail=" + objectDomain.getMail());
			}
        }
        return objectDomain;
	}

	@Override
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId,
			String mobilePhone, String docType, String docNumber) throws Exception {
		return clientDao.validateSession(tokenSession, clientId, mobilePhone, docType, docNumber);
	}

	@Override
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception {
		return clientDao.expiredSession(clientId);
	}

	@Override
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception {
		return clientDao.closedSession(clientId);
	}
}