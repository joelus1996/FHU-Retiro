package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
@Component("beanCulqiDao")
public class CulqiDaoImpl extends HibernateDaoSupport implements CulqiDao {

	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public CulqiDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".CulqiDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public List<CulqiCard> listCustomerCard(int clientId) throws Exception {
        List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = "ACT";
            String queryString = "SELECT c.id.itemId, c.lastFour, c.cardBrand FROM CulqiCard c WHERE c.id.clientId=? AND c.cardStatus=?";
            resultQuery = getHibernateTemplate().find(queryString, values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if(resultQuery != null) LoggerApi.Log.info("size= " + resultQuery.size());
        }
        return resultQuery;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public CulqiProcedureDefineTransaction defineTransaction(Object[] values) throws Exception {
        List<CulqiProcedureDefineTransaction> resultQuery = new ArrayList<CulqiProcedureDefineTransaction>();
        CulqiProcedureDefineTransaction objectDomain = new CulqiProcedureDefineTransaction();
        try {
			resultQuery = getHibernateTemplate().findByNamedQuery("TRANSACTIONCULQI_DEFINETRANSACTION", values);
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
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public CulqiProcedureNotifyTransaction notifyTransaction(Object[] values) throws Exception {
        List<CulqiProcedureNotifyTransaction> resultQuery = new ArrayList<CulqiProcedureNotifyTransaction>();
        CulqiProcedureNotifyTransaction objectDomain = new CulqiProcedureNotifyTransaction();
        try {
			resultQuery = getHibernateTemplate().findByNamedQuery("TRANSACTIONCULQI_NOTIFYTRANSACTION", values);
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
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public CulqiProcedureSetCustomerCard setCustomerCard(Object[] values) throws Exception {
        List<CulqiProcedureSetCustomerCard> resultQuery = new ArrayList<CulqiProcedureSetCustomerCard>();
        CulqiProcedureSetCustomerCard objectDomain = new CulqiProcedureSetCustomerCard();
        try {
			resultQuery = getHibernateTemplate().findByNamedQuery("TRANSACTIONCULQI_SETCUSTOMERCARD", values);
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
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public CulqiCard getCustomerCard(int clientId, int itemId) throws Exception {
        List<CulqiCard> resultQuery = new ArrayList<CulqiCard>();
        CulqiCard objectDomain = new CulqiCard();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = itemId;
			resultQuery = getHibernateTemplate().find("FROM CulqiCard c WHERE c.id.clientId = ? AND c.id.itemId = ?", values);
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
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public CulqiProcedureDelCustomerCard delCustomerCard(int clientId, int itemId) throws Exception {
        List<CulqiProcedureDelCustomerCard> resultQuery = new ArrayList<CulqiProcedureDelCustomerCard>();
        CulqiProcedureDelCustomerCard objectDomain = new CulqiProcedureDelCustomerCard();
        try {
        	Object[] values = new Object[2];
        	values[0] = clientId;
        	values[1] = itemId;
			resultQuery = getHibernateTemplate().findByNamedQuery("TRANSACTIONCULQI_DELCUSTOMERCARD", values);
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