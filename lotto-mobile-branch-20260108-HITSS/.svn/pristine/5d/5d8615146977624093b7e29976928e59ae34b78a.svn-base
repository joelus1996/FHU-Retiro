package pe.com.intralot.loto.layer.controller.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.client.bo.ClientPaymentBo;
import pe.com.intralot.loto.layer.model.persistence.dao.CulqiDao;
import pe.com.intralot.loto.layer.model.pojo.CulqiCard;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureDelCustomerCard;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureNotifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.CulqiProcedureSetCustomerCard;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author cristian.cortez
 */
@Service("beanClientPaymentBo")
public class ClientPaymentBoImpl implements ClientPaymentBo {
  
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CulqiDao beanCulqiDao;	
 		
	public List<CulqiCard> listCustomerCard(int clientId) throws Exception {
		LoggerApi.Log.info("cid=" + clientId+" ClientPaymentBoImpl listCustomerCard");
		List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
		try {
			resultQuery = beanCulqiDao.listCustomerCard(clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQuery != null) {
				LoggerApi.Log.info("cid=" + clientId+" ClientPaymentBoImpl listCustomerCard size=" + resultQuery.size());
			}
		}
		return resultQuery;
	}
	
	public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception {
		LoggerApi.Log.info("cid=" + values[0]+" defineTransaction");
		CulqiProcedureDefineTransaction objectDomain = new CulqiProcedureDefineTransaction();
		try {
			objectDomain = beanCulqiDao.defineTransaction(values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("cid=" + values[0]+" TransactionId=" + objectDomain.getTransactionId() + " SessionId=" + objectDomain.getSessionId() + " Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
	
	public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception {
		LoggerApi.Log.info("TransactionId= " + values[0]);
		CulqiProcedureNotifyTransaction objectDomain = new CulqiProcedureNotifyTransaction();
		try {
			objectDomain = beanCulqiDao.notifyTransaction(values);
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
	
	public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception {
		LoggerApi.Log.info("cid=" + values[0]+" setCustomerCard");
		CulqiProcedureSetCustomerCard objectDomain = new CulqiProcedureSetCustomerCard();
		try {
			objectDomain = beanCulqiDao.setCustomerCard(values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("cid=" + values[0]+" ItemId=" + objectDomain.getItemId() + " Message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}
	
	public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception {
		LoggerApi.Log.info("cid= " + clientId + " ItemId="+itemId+" getCustomerCard");
		CulqiCard objectDomain = new CulqiCard();
		try {
			objectDomain = beanCulqiDao.getCustomerCard(clientId, itemId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("cid= " + clientId +" CardId=" + objectDomain.getLastFour());
			}
		}
		return objectDomain;
	}
	
	public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception {
		LoggerApi.Log.info("cid=" + clientId + " ItemId="+itemId+" delCustomerCard");
		CulqiProcedureDelCustomerCard objectDomain = new CulqiProcedureDelCustomerCard();
		try {
			objectDomain = beanCulqiDao.delCustomerCard(clientId, itemId);
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