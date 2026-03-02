package pe.com.intralot.loto.layer.service.client.boimpl;

/**
 * @author:   Cristian Cortez
 * @rol:	  Analista en Desarrollo de Sistemas
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.CulqiCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDelCustomerCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureNotifyTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureSetCustomerCard;
import pe.com.intralot.loto.layer.model.persistence.dao.CulqiDao;
import pe.com.intralot.loto.layer.service.client.bo.CulqiBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class CulqiBoImpl implements CulqiBo{

	@Autowired
	private CulqiDao culqiDao;
	
	@Override	
	public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception {
		LoggerApi.Log.info("ClientId= " + values[0]);
		CulqiProcedureDefineTransaction objectDomain = new CulqiProcedureDefineTransaction();
		try {
			objectDomain = culqiDao.defineTransaction(values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("TransactionId=" + objectDomain.getTransactionId() + " SessionId=" + objectDomain.getSessionId() + " Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
	
	@Override	
	public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception {
		LoggerApi.Log.info("TransactionId= " + values[0]);
		CulqiProcedureNotifyTransaction objectDomain = new CulqiProcedureNotifyTransaction();
		try {
			objectDomain = culqiDao.notifyTransaction(values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("BalanceItem=" + objectDomain.getBalanceItem() + " ClientId=" + objectDomain.getClientId() + " Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
	
	@Override	
	public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception {
		LoggerApi.Log.info("ClientId= " + values[0]);
		CulqiProcedureSetCustomerCard objectDomain = new CulqiProcedureSetCustomerCard();
		try {
			objectDomain = culqiDao.setCustomerCard(values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("ItemId=" + objectDomain.getItemId() + " Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
	
	/*@Override	
	public List<CulqiProcedureListCustomerCard> listCustomerCard(int clientId) throws Exception {
		LoggerApi.Log.info("ClientId= " + clientId);
		List<CulqiProcedureListCustomerCard> resultQuery = new ArrayList<CulqiProcedureListCustomerCard>();
		try {
			resultQuery = culqiDao.listCustomerCard(clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQuery != null) {
				LoggerApi.Log.info("size=" + resultQuery.size());
			}
		}
		return resultQuery;
	}*/
	public List<CulqiCard> listCustomerCard(int clientId) throws Exception {
		LoggerApi.Log.info("ClientId= " + clientId);
		List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
		try {
			resultQuery = culqiDao.listCustomerCard(clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQuery != null) {
				LoggerApi.Log.info("size=" + resultQuery.size());
			}
		}
		return resultQuery;
	}
	
	@Override	
	public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception {
		LoggerApi.Log.info("ClientId= " + clientId + " ItemId="+itemId);
		CulqiCard objectDomain = new CulqiCard();
		try {
			objectDomain = culqiDao.getCustomerCard(clientId, itemId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("CardId=" + objectDomain.getLastFour());
			}
		}
		return objectDomain;
	}
	
	@Override	
	public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception {
		LoggerApi.Log.info("ClientId= " + clientId + " ItemId="+itemId);
		CulqiProcedureDelCustomerCard objectDomain = new CulqiProcedureDelCustomerCard();
		try {
			objectDomain = culqiDao.delCustomerCard(clientId, itemId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
}
