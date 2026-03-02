package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.CulqiCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureDelCustomerCard;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureNotifyTransaction;
import pe.com.intralot.loto.layer.model.domain.CulqiProcedureSetCustomerCard;
import pe.com.intralot.loto.layer.model.persistence.dao.CulqiDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class CulqiDaoImpl extends HibernateBaseDaoImpl implements CulqiDao {

    @Override
    public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception {
        List<CulqiProcedureDefineTransaction> resultQuery = new ArrayList<CulqiProcedureDefineTransaction>();
        CulqiProcedureDefineTransaction objectDomain = new CulqiProcedureDefineTransaction();
        try {
			resultQuery = super.findForNamed("TRANSACTIONCULQI_DEFINETRANSACTION", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
            	LoggerApi.Log.info("w_transaction_id=" + objectDomain.getTransactionId() + " w_session_id=" + objectDomain.getSessionId() + " w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    @Override
    public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception {
        List<CulqiProcedureNotifyTransaction> resultQuery = new ArrayList<CulqiProcedureNotifyTransaction>();
        CulqiProcedureNotifyTransaction objectDomain = new CulqiProcedureNotifyTransaction();
        try {
			resultQuery = super.findForNamed("TRANSACTIONCULQI_NOTIFYTRANSACTION", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
            	LoggerApi.Log.info("w_balance_item=" + objectDomain.getBalanceItem() + " w_client_id=" + objectDomain.getClientId() + " w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    @Override
    public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception {
        List<CulqiProcedureSetCustomerCard> resultQuery = new ArrayList<CulqiProcedureSetCustomerCard>();
        CulqiProcedureSetCustomerCard objectDomain = new CulqiProcedureSetCustomerCard();
        try {
			resultQuery = super.findForNamed("TRANSACTIONCULQI_SETCUSTOMERCARD", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
            	LoggerApi.Log.info("w_item_id=" + objectDomain.getItemId() + " w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
    
    /*@Override
    public List<CulqiProcedureListCustomerCard> listCustomerCard(int clientId) throws Exception {
        List<CulqiProcedureListCustomerCard> resultQuery = new ArrayList<CulqiProcedureListCustomerCard>();
        //CulqiProcedureListCustomerCard objectDomain = new CulqiProcedureListCustomerCard();
        try {
        	Object[] values = new Object[1];
        	values[0] = clientId;
			resultQuery = super.findForNamed("TRANSACTIONCULQI_LISTCUSTOMERCARD", values);
			//objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQuery != null)
            	LoggerApi.Log.info("size=" + resultQuery.size());
        }
        return resultQuery;
    }*/
    @Override
    public List<CulqiCard> listCustomerCard(int clientId) throws Exception {
        List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = "ACT";
            String queryString = "SELECT c.id.itemId, c.lastFour, c.cardBrand FROM CulqiCard c WHERE c.id.clientId=? AND c.cardStatus=?";
            resultQuery = super.find(queryString, values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("size= " + resultQuery.size());
        }
        return resultQuery;
    }
    
    @Override
    public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception {
        List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
        CulqiCard objectDomain = new CulqiCard();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = itemId;
			resultQuery = super.find("FROM CulqiCard c WHERE c.id.clientId = ? AND c.id.itemId = ?", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
            	LoggerApi.Log.info("qc_last_four=" + objectDomain.getLastFour());
        }
        return objectDomain;
    }
    
    @Override
    public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception {
        List<CulqiProcedureDelCustomerCard> resultQuery = new ArrayList<CulqiProcedureDelCustomerCard>();
        CulqiProcedureDelCustomerCard objectDomain = new CulqiProcedureDelCustomerCard();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = itemId;
			resultQuery = super.findForNamed("TRANSACTIONCULQI_DELCUSTOMERCARD", values);
			objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
            	LoggerApi.Log.info("w_message=" + objectDomain.getMessage());
        }
        return objectDomain;
    }
}
