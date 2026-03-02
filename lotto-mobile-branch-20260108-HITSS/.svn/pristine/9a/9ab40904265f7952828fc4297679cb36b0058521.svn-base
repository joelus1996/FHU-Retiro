package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import oracle.jdbc.OracleTypes;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetWinCup;
import pe.com.intralot.loto.layer.model.persistence.dao.ClientBalanceDao;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDia;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetMontoPorDiaAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesPefe;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesSpay;
import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.BbvaProcedureCheckTransaction;
import pe.com.intralot.loto.layer.model.pojo.BbvaProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountData;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureAccountDataPart;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureCodeValidation;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBalanceListFilter;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetBicolorPromoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetGamesBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoBonusList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureGetTeApuestoPromoList;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureUpdateStateRechargeAgora;
import pe.com.intralot.loto.layer.model.pojo.ClientProcedureValidateNewPhoneAgora;
import pe.com.intralot.loto.layer.model.pojo.ListTicketBicolorClient;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureRegisterErrorIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinVerifyTransaction;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Component("beanClientBalanceDao")
public class ClientBalanceDaoImpl extends HibernateDaoSupport implements ClientBalanceDao {

	//protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public ClientBalanceDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".ClientBalanceDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	/*@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientBalance> finByPk(Integer pk) throws 
	Exception{
		LoggerApi.Log.info("");
		LoggerApi.Log.info("pk =" + pk);
		
		List<ClientBalance> resultQuery =  new ArrayList<ClientBalance>();
		try {			
			
			String queryString =
					" from ClientBalance as b where b.id.clientId = ? "+
			        //" and b.balanceDate between (sysdate - 90) AND sysdate "+		       
			        //" order by b.balanceDate desc";
			        "and   b.balanceDate >= add_months(sysdate, - 2)" + 
			        "		 and   b.anulado is null" + 
			        "		 order by b.id.balanceItem desc";
			
			resultQuery=getHibernateTemplate().find(queryString,pk);
			
			return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("size=" + resultQuery.size());
			}else{
				LoggerApi.Log.info("size=" +"null");	
			}
			
		}		
	}*/
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetBalanceList> finByPk(Integer p_clientId) throws 
	Exception{
		LoggerApi.Log.info("cid=" + p_clientId+" finByPk");		
		List<ClientProcedureGetBalanceList> resultQueryList =  new ArrayList<ClientProcedureGetBalanceList>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETBALANCELIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" finByPk size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetTeApuestoPromoList> findTeApuestoPromoByPk(Integer p_clientId) throws 
	Exception{ 
		LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoPromoByPk");		
		List<ClientProcedureGetTeApuestoPromoList> resultQueryList =  new ArrayList<ClientProcedureGetTeApuestoPromoList>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETPROMOLIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoPromoByPk size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetBicolorPromoList> findBicolorPromoByPk(Integer p_clientId) throws 
	Exception{ 
		LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoPromoByPk");		
		List<ClientProcedureGetBicolorPromoList> resultQueryList =  new ArrayList<ClientProcedureGetBicolorPromoList>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETBICOLORPROMOLIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findBicolorPromoByPk size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ListTicketBicolorClient> getListBicolorTickets(Integer p_clientId) throws 
	Exception{ 
		LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoPromoByPk");		
		List<ListTicketBicolorClient> resultQueryList =  new ArrayList<ListTicketBicolorClient>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETBICOLORPROMOLISTTICKETSCLIENT", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findListBicolorTicketsClient size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
    public BalanceProcedureGetWinCup findWinProm(Integer p_clientId, String p_prom_id) throws Exception {
        LoggerApi.Log.info("findPromoList cid=" + p_clientId);
        List<BalanceProcedureGetWinCup> resultQueryList = new ArrayList<BalanceProcedureGetWinCup>();
        BalanceProcedureGetWinCup objectDomain = new BalanceProcedureGetWinCup();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_prom_id;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCE_GETWINCUP", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQueryList);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findClienWin cid=" + p_clientId);
        }
        return objectDomain;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetTeApuestoBonusList> findTeApuestoBonusByPk(Integer p_clientId) throws 
	Exception{ 
		LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoBonusByPk");		
		List<ClientProcedureGetTeApuestoBonusList> resultQueryList =  new ArrayList<ClientProcedureGetTeApuestoBonusList>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETBONUSLIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findTeApuestoBonusByPk size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetGamesBonusList> findGamesBonusByPk(Integer p_clientId) throws 
	Exception{ 
		LoggerApi.Log.info("cid=" + p_clientId+" findGamesBonusByPk");		
		List<ClientProcedureGetGamesBonusList> resultQueryList =  new ArrayList<ClientProcedureGetGamesBonusList>();
			try {			
		    Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETOTHERLISTQUANTITY", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findGamesBonusByPk size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception {
		//LoggerApi.Log.info("cid=" + p_clientId+" findAccountData");
        List<ClientProcedureAccountData> resultQuery = new ArrayList<ClientProcedureAccountData>();
        ClientProcedureAccountData objectDomain = new ClientProcedureAccountData();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACCOUNTDATA", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("cid=" + p_clientId+" findAccountData w_client_name=" + objectDomain.getClientName() + " w_mail_status=" + objectDomain.getMailStatus() + " w_balance_amount="
                        + objectDomain.getBalanceAmount() + " w_promotional=" + objectDomain.getPromotional() + " w_num_prizes=" + objectDomain.getNumPrizes()
                        + " w_neoprize_amount=" + objectDomain.getNeoprizeAmount() + " w_kironprize_amount=" + objectDomain.getKironPrizeAmount() + " w_bonus_status=" + objectDomain.getBonusStatus()
                        + " w_bonus_message=" + objectDomain.getBonusMessage() + " w_bonus_date=" + objectDomain.getBonusDate() + " w_bonus_client_status=" + objectDomain.getBonusClientStatus()
                        + " w_bonus_added_balance=" + objectDomain.getBonusAddedBalance() + " w_bonus_forplay=" + objectDomain.getBonusForPlay() + " w_bonus_last_date=" + objectDomain.getBonusLastDate()
                        + " w_min_odd=" + objectDomain.getMinOdd() + " w_bonus_amount=" + objectDomain.getBonusAmount() + " w_bonus_limit=" + objectDomain.getBonusLimit() + " w_bonus_percentage=" + objectDomain.getBonusPercentage()
                        + " w_wb_status=" + objectDomain.getWelcomeBonusStatus() + " w_wb_percentage=" + objectDomain.getWelcomeBonusPercentaje() + " w_wb_message=" + objectDomain.getWelcomeBonusMessage()
                		+ " w_wb_bonus_last_date=" + objectDomain.getWelcomeBonusLastDate() + " w_bonus_game=" + objectDomain.getBonusGame() + " w_other_amount=" + objectDomain.getOtherAmount()
                		+ " w_promo=" + objectDomain.getPromo() + " w_promo_draw=" + objectDomain.getPromoDraw() + " w_promo_count=" + objectDomain.getPromoCount());
        }
        return objectDomain;
	}

	@Override
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception {
		LoggerApi.Log.info("codePromotional="+values[0]+" clientId="+values[1]+" channel="+values[2]+" carrier="+values[3]+" amount="+values[4]+" ip="+values[5]);
        List<ClientProcedureCodeValidation> resultQuery = new ArrayList<ClientProcedureCodeValidation>();
        ClientProcedureCodeValidation objectDomain = new ClientProcedureCodeValidation();
        try {
            resultQuery = getHibernateTemplate().findByNamedQuery("RECARGAWEB_APPLY_CODE", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info(" p_state=" + objectDomain.getState() + " p_message=" + objectDomain.getMessage() + " p_id_code=" + objectDomain.getIdCodePromotional());
        }
        return objectDomain;
	}
	
	@Override
    public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetMontoPorDia> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDia>();
        try {
            Object[] values = new Object[1]; 
            values[0] = p_clientId;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETMONTO", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("size= " + resultQueryList.size());
        }
        return resultQueryList;
    }
	
	@Override
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<ClientProcedureAccountDataPart> resultQuery = new ArrayList<ClientProcedureAccountDataPart>();
        ClientProcedureAccountDataPart objectDomain = new ClientProcedureAccountDataPart();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQuery = getHibernateTemplate().findByNamedQuery("CLIENTSALE_ACCOUNTDATAPART", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("findAccountDataPart cid=" + p_clientId+" w_client_user=" + objectDomain.getClientUser() + " w_balance_amount=" + objectDomain.getBalanceAmount() 
                		+ " w_bonus_amount=" + objectDomain.getBonusAmount() + " w_other_amount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
	}
	
	@Override
    public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetMontoPorDiaAgora> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDiaAgora>();
        BalanceProcedureGetMontoPorDiaAgora objectDomain = new BalanceProcedureGetMontoPorDiaAgora();
        Object[] values = new Object[1]; 
        values[0] = p_clientId;
        resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETMONTO_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQueryList);
        if(objectDomain!=null) {
        	 LoggerApi.Log.info("MontoPorDia= " + objectDomain.getMontoPorDia());
        } 
        return resultQueryList;
    }

	@Override
	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId,String phoneUpdateAgora, String phoneUpdate) throws Exception {
		LoggerApi.Log.info("updateStateRechargeAgora cid=" + clientId + " phoneUpdateAgora=" + phoneUpdateAgora + " phoneUpdate=" + phoneUpdate);
		List<ClientProcedureUpdateStateRechargeAgora> resultQuery = new ArrayList<ClientProcedureUpdateStateRechargeAgora>();
		ClientProcedureUpdateStateRechargeAgora objectDomain = new ClientProcedureUpdateStateRechargeAgora();
		Object[] values = new Object[3];
        values[0] = clientId;
        values[1] = phoneUpdateAgora;
        values[2] = phoneUpdate;
        resultQuery = getHibernateTemplate().findByNamedQuery("UPDATE_STATE_RECHARGE_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null)
            LoggerApi.Log.info("updateStateRechargeAgora cid=" + clientId+" o_message=" + objectDomain.getMessage() + " o_result=" + objectDomain.getResult());
		return objectDomain;
	}

	@Override
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate)
			throws Exception {
		LoggerApi.Log.info("validateNewPhoneAgora cid=" + clientId + " phoneUpdate=" + phoneUpdate);
		List<ClientProcedureValidateNewPhoneAgora> resultQuery = new ArrayList<ClientProcedureValidateNewPhoneAgora>();
		ClientProcedureValidateNewPhoneAgora objectDomain = new ClientProcedureValidateNewPhoneAgora();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = phoneUpdate;
        resultQuery = getHibernateTemplate().findByNamedQuery("VALIDATE_NEW_PHONE_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null)
            LoggerApi.Log.info("validateNewPhoneAgora cid=" + clientId+" o_message=" + objectDomain.getMessage() + " o_result=" + objectDomain.getResult());
		return objectDomain;
	}

	@Override
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception {
		LoggerApi.Log.info("resultEvalRulesAgora idClient=" + clientId + " amount="+amount);
		List<BalanceProcedureResultEvalRulesAgora> resultQuery = new ArrayList<BalanceProcedureResultEvalRulesAgora>();
		BalanceProcedureResultEvalRulesAgora objectDomain = new BalanceProcedureResultEvalRulesAgora();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amount;
        resultQuery = getHibernateTemplate().findByNamedQuery("BALANCESALE_RESULT_EVAL_RULES_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("resultEvalRulesAgora idClient=" + clientId + " amount="+amount + " o_result="+objectDomain.getResult() + " o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa(Integer clientId, Double amount) throws Exception {
		LoggerApi.Log.info("resultEvalRulesVisa idClient=" + clientId + " amount="+amount);
		List<BalanceProcedureResultEvalRulesVisa> resultQuery = new ArrayList<BalanceProcedureResultEvalRulesVisa>();
		BalanceProcedureResultEvalRulesVisa objectDomain = new BalanceProcedureResultEvalRulesVisa();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amount;
        resultQuery = getHibernateTemplate().findByNamedQuery("BALANCESALE_RESULT_EVAL_RULES_VISA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("resultEvalRulesVisa idClient=" + clientId + " amount="+amount + " o_result="+objectDomain.getResult() + " o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<ProcedureYapePlinVerifyTransaction> resultQuery = new ArrayList<ProcedureYapePlinVerifyTransaction>();
        ProcedureYapePlinVerifyTransaction objectDomain = new ProcedureYapePlinVerifyTransaction();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = channel;
            resultQuery = getHibernateTemplate().findByNamedQuery("YAPE_PLIN_VERIFY_TRANSACTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("yapePlinVerifyTransaction cid=" + p_clientId+" amount=" + objectDomain.getAmount() + " status=" + objectDomain.getStatus());
        }
        return objectDomain;
	}

	@Override
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey, String platform, String operatorId) throws Exception {
		LoggerApi.Log.info("getDefineTransactionBBVA cid="+clientId+" amount="+amount+ " bonokey="+bonokey+" platform="+platform+" operatorId="+operatorId);
        List<BbvaProcedureDefineTransaction> resultQuery = new ArrayList<BbvaProcedureDefineTransaction>();
        BbvaProcedureDefineTransaction objectDomain = new BbvaProcedureDefineTransaction();
        try {
            Object[] values = new Object[5];
            values[0] = clientId;
            values[1] = amount;
            values[2] = bonokey;
            values[3] = platform;
            values[4] = operatorId;
            resultQuery = getHibernateTemplate().findByNamedQuery("transactionbbva_defineTransaction", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("BbvaProcedureDefineTransaction cid=" + clientId+" transaction=" + objectDomain.getTransaction());
        }
        return objectDomain;
	}

	@Override
	public List<BbvaProcedureCheckTransaction> getCheckTransactionBBVA(String clientId) throws Exception {
		LoggerApi.Log.info("getCheckTransactionBBVA cid="+clientId);
        List<BbvaProcedureCheckTransaction> resultQuery = new ArrayList<BbvaProcedureCheckTransaction>();
        Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = getHibernateTemplate().findByNamedQuery("transactionbbva_checkTransaction", values);
        return resultQuery;
	}

	@Override
	public int expiryTransactionBBVA(String trx, String clientId) throws Exception {
		LoggerApi.Log.info("expiryTransactionBBVA cid="+clientId+" trx="+trx);
		int result = 0;
	    CallableStatement cstmt = null;
	    Connection conexion = dataSource.getConnection();
	    try {
        	cstmt = conexion.prepareCall("call LOTOCARD.transactionbbva.expiryTransaction(?,?,?)");
            cstmt.setString(1, trx);
            cstmt.setInt(2, Integer.parseInt(clientId));
            cstmt.registerOutParameter(3, OracleTypes.NUMBER);
            cstmt.execute();
            result = cstmt.getInt(3);
        } finally {
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("expiryTransactionBBVA cid="+clientId+" trx="+trx+" result="+result);
        }
        return result;
	}

	@Override
	public Object[] verifyTransactionBBVA(String trx, String clientId) throws Exception {
		LoggerApi.Log.info("verifyTransactionBBVA cid="+clientId+" trx="+trx);
		Object[] resultado = new Object[2];
		int result = 0;
		int amount = 0;
	    CallableStatement cstmt = null;
	    Connection conexion = dataSource.getConnection();
	    try {
        	cstmt = conexion.prepareCall("call LOTOCARD.transactionbbva.verifyTransaction(?,?,?,?)");
            cstmt.setString(1, trx);
            cstmt.setInt(2, Integer.parseInt(clientId));
            cstmt.registerOutParameter(3, OracleTypes.NUMBER);
            cstmt.registerOutParameter(4, OracleTypes.NUMBER);
            cstmt.execute();
            result = cstmt.getInt(3);
            amount = cstmt.getInt(4);
            resultado[0] = result;
            resultado[1] = amount;
        } finally {
        	if (cstmt != null)
                cstmt.close();
            if (conexion != null)
                conexion.close();
            LoggerApi.Log.info("verifyTransactionBBVA cid="+clientId+" trx="+trx+" result="+result);
        }
        return resultado;
	}

	@Override
	public BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe(Integer clientId, Double amount) throws Exception {
		LoggerApi.Log.info("resultEvalRulesPefe idClient=" + clientId + " amount="+amount);
		List<BalanceProcedureResultEvalRulesPefe> resultQuery = new ArrayList<BalanceProcedureResultEvalRulesPefe>();
		BalanceProcedureResultEvalRulesPefe objectDomain = new BalanceProcedureResultEvalRulesPefe();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amount;
        resultQuery = getHibernateTemplate().findByNamedQuery("BALANCESALE_RESULT_EVAL_RULES_PEFE", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("resultEvalRulesPefe idClient=" + clientId + " amount="+amount + " o_result="+objectDomain.getResult() + " o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay(Integer clientId, Double amount) throws Exception {
		LoggerApi.Log.info("resultEvalRulesSpay idClient=" + clientId + " amount="+amount);
		List<BalanceProcedureResultEvalRulesSpay> resultQuery = new ArrayList<BalanceProcedureResultEvalRulesSpay>();
		BalanceProcedureResultEvalRulesSpay objectDomain = new BalanceProcedureResultEvalRulesSpay();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amount;
        resultQuery = getHibernateTemplate().findByNamedQuery("BALANCESALE_RESULT_EVAL_RULES_SPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("resultEvalRulesSpay idClient=" + clientId + " amount="+amount + " o_result="+objectDomain.getResult() + " o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public ProcedurePayTransactionIzipay payTransactionIzipay(Object[] values) throws Exception {
		LoggerApi.Log.info("payTransactionIzipay");
		List<ProcedurePayTransactionIzipay> resultQuery = new ArrayList<ProcedurePayTransactionIzipay>();
		ProcedurePayTransactionIzipay objectDomain = new ProcedurePayTransactionIzipay();
        resultQuery = getHibernateTemplate().findByNamedQuery("PAY_TRANSACTION_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}

	@Override
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception {
		LoggerApi.Log.info("registerErrorIzipay");
		List<ProcedureRegisterErrorIzipay> resultQuery = new ArrayList<ProcedureRegisterErrorIzipay>();
		ProcedureRegisterErrorIzipay objectDomain = new ProcedureRegisterErrorIzipay();
        resultQuery = getHibernateTemplate().findByNamedQuery("PAY_REGISTER_ERROR_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
	
	@Override
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception {
		LoggerApi.Log.info("defineTransactionIzipay");
		List<ProcedureDefineTransactionIzipay> resultQuery = new ArrayList<ProcedureDefineTransactionIzipay>();
		ProcedureDefineTransactionIzipay objectDomain = new ProcedureDefineTransactionIzipay();
        resultQuery = getHibernateTemplate().findByNamedQuery("DEFINE_TRANSACTION_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
	
	@Override
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel)
			throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
        List<ProcedureYapePlinTupayVerifyTransaction> resultQuery = new ArrayList<ProcedureYapePlinTupayVerifyTransaction>();
        ProcedureYapePlinTupayVerifyTransaction objectDomain = new ProcedureYapePlinTupayVerifyTransaction();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = channel;
            resultQuery = getHibernateTemplate().findByNamedQuery("YAPE_PLIN_TUPAY_VERIFY_TRANSACTION", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("yapePlinTupayVerifyTransaction cid=" + p_clientId+" amount=" + objectDomain.getAmount() + " status=" + objectDomain.getStatus());
        }
        return objectDomain;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<ClientProcedureGetBalanceListFilter> finByBalanceFilter(Integer p_clientId, String start_date,
			String end_date) throws 
	Exception{
		LoggerApi.Log.info("cid=" + p_clientId+" start_date=" +start_date + " end_date=" + end_date);		
		List<ClientProcedureGetBalanceListFilter> resultQueryList =  new ArrayList<ClientProcedureGetBalanceListFilter>();
			try {			
		    Object[] values = new Object[3];
            values[0] = p_clientId;
            values[1] = start_date;
            values[2] = end_date;
            resultQueryList = getHibernateTemplate().findByNamedQuery("BALANCESALE_GETBALANCELIST_FILTER", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("cid=" + p_clientId+" finByBalanceFilter size= " + resultQueryList.size());
        }
        return resultQueryList;		
	}
}