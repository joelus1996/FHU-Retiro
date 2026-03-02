package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.Client;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureClosedSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureExpiredSession;
import pe.com.intralot.loto.layer.model.domain.ClientUpdateProcedureValidateSession;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ClientDaoImpl extends HibernateBaseDaoImpl implements ClientDao {

	@Override
	public Client findByIdClient(Integer idClient) throws Exception {

		LoggerApi.Log.info("idClient=" + idClient);

		List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = new Client();

		try {

			Object[] values = new Object[1];
			values[0] = idClient;

			String queryString = " FROM " + " 		Client c " + " WHERE " + " 	  	c.idClient = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

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

		List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = new Client();

		try {

			Object[] values = new Object[1];
			values[0] = user;

			String queryString = " FROM " + " 		Client c " + " WHERE " + " 		c.user = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

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

		List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = new Client();

		try {

			String queryString = " FROM " + " 		Client c " + " WHERE  " + " 		c.user = ? " + " AND  c.password = ? ";

			Object[] values = new Object[2];
			values[0] = user;
			values[1] = password;

			resultQuery = super.find(queryString, values);

			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

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

		List<Client> resultQuery = new ArrayList<Client>();
		Client objectDomain = new Client();

		try {

			Object[] values = new Object[1];
			values[0] = mail;

			String queryString = "FROM Client c  WHERE c.mail = ? and c.mailStatus = 'ACT' and c.balanceItem is not null ";

			resultQuery = super.find(queryString, values);

			objectDomain = DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("mail=" + objectDomain.getMail());
			}
		}

		return objectDomain;
	}

	@Override
	public ClientUpdateProcedureValidateSession validateSession(String tokenSession, Integer clientId,
			String mobilePhone, String docType, String docNumber) throws Exception {
		LoggerApi.Log.info("validateSession clientId=" + clientId);
		List<ClientUpdateProcedureValidateSession> resultQuery = new ArrayList<ClientUpdateProcedureValidateSession>();
		ClientUpdateProcedureValidateSession objectDomain = new ClientUpdateProcedureValidateSession();
		Object[] values = new Object[5];
        values[0] = tokenSession;
        values[1] = clientId;
        values[2] = mobilePhone;
        values[3] = docType;
        values[4] = docNumber;
        resultQuery = super.findForNamed("CLIENT_UPDATE_VALIDATE_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("validateSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public ClientUpdateProcedureExpiredSession expiredSession(Integer clientId) throws Exception {
		LoggerApi.Log.info("expiredSession clientId=" + clientId);
		List<ClientUpdateProcedureExpiredSession> resultQuery = new ArrayList<ClientUpdateProcedureExpiredSession>();
		ClientUpdateProcedureExpiredSession objectDomain = new ClientUpdateProcedureExpiredSession();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("CLIENT_UPDATE_EXPIRED_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("expiredSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public ClientUpdateProcedureClosedSession closedSession(Integer clientId) throws Exception {
		LoggerApi.Log.info("closedSession clientId=" + clientId);
		List<ClientUpdateProcedureClosedSession> resultQuery = new ArrayList<ClientUpdateProcedureClosedSession>();
		ClientUpdateProcedureClosedSession objectDomain = new ClientUpdateProcedureClosedSession();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("CLIENT_UPDATE_CLOSED_SESSION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("closedSession idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

}