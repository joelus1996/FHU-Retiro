package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBalanceList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBalanceListFilter;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetBonusList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetMontoPorDia;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetMontoPorDiaAgora;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetOtherList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetPromoList;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureGetWinCup;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesPefe;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesSpay;
import pe.com.intralot.loto.layer.model.domain.BalanceProcedureResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.domain.BbvaProcedureCheckTransaction;
import pe.com.intralot.loto.layer.model.domain.BbvaProcedureDefineTransaction;
import pe.com.intralot.loto.layer.model.domain.ClientProcedureGetBicolorPromoList;
import pe.com.intralot.loto.layer.model.domain.ListTicketBicolorClient;
import pe.com.intralot.loto.layer.model.domain.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.domain.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.domain.ProcedureRegisterErrorIzipay;
import pe.com.intralot.loto.layer.model.persistence.dao.BalanceSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class BalanceSaleDaoImpl extends HibernateBaseDaoImpl implements BalanceSaleDao {
	
	@Autowired
	private DataSource dataSource;

    @Override
    public List<BalanceProcedureGetBalanceList> findBalanceList(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetBalanceList> resultQueryList = new ArrayList<BalanceProcedureGetBalanceList>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETBALANCELIST", values);
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
    public List<BalanceProcedureGetBonusList> findBonusList(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetBonusList> resultQueryList = new ArrayList<BalanceProcedureGetBonusList>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETBONUSLIST", values);
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
    public List<BalanceProcedureGetOtherList> findOtherList(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetOtherList> resultQueryList = new ArrayList<BalanceProcedureGetOtherList>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETOTHERLISTQUANTITY", values);
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
    public List<BalanceProcedureGetPromoList> findPromoList(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("findPromoList cid=" + p_clientId);
        List<BalanceProcedureGetPromoList> resultQueryList = new ArrayList<BalanceProcedureGetPromoList>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETPROMOLIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("findPromoList size= " + resultQueryList.size());
        }
        return resultQueryList;
    }
    
    @Override
    public List<ClientProcedureGetBicolorPromoList> findPromoBicolorList(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("findPromoList cid=" + p_clientId);
        List<ClientProcedureGetBicolorPromoList> resultQueryList = new ArrayList<ClientProcedureGetBicolorPromoList>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETBICOLORPROMOLIST", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("findPromoBicolorList size= " + resultQueryList.size());
        }
        return resultQueryList;
    }
    
    @Override
    public List<ListTicketBicolorClient> getListBicolorTickets(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("findPromoList cid=" + p_clientId);
        List<ListTicketBicolorClient> resultQueryList = new ArrayList<ListTicketBicolorClient>();
        try {
            Object[] values = new Object[1];
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETBICOLORPROMOLISTTICKETSCLIENT", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("getListBicolorTickets size= " + resultQueryList.size());
        }
        return resultQueryList;
    }
    
    @Override
    public List<BalanceProcedureGetWinCup> findWinProm(Integer p_clientId, String p_prom_id) throws Exception {
        LoggerApi.Log.info("findPromoList cid=" + p_clientId);
        List<BalanceProcedureGetWinCup> resultQueryList = new ArrayList<BalanceProcedureGetWinCup>();
        try {
            Object[] values = new Object[2];
            values[0] = p_clientId;
            values[1] = p_prom_id;
            resultQueryList = super.findForNamed("BALANCE_GETWINCUP", values);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("findIdClientWin = " + resultQueryList.size());
        }
        return resultQueryList;
    }
    
    @Override
    public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetMontoPorDia> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDia>();
        try {
            Object[] values = new Object[1]; 
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETMONTO", values);
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
	public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("cid=" + p_clientId);
        List<BalanceProcedureGetMontoPorDiaAgora> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDiaAgora>();
        try {
            Object[] values = new Object[1]; 
            values[0] = p_clientId;
            resultQueryList = super.findForNamed("BALANCESALE_GETMONTO_AGORA", values);
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
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception {
		LoggerApi.Log.info("resultEvalRulesAgora idClient=" + clientId + " amount="+amount);
		List<BalanceProcedureResultEvalRulesAgora> resultQuery = new ArrayList<BalanceProcedureResultEvalRulesAgora>();
		BalanceProcedureResultEvalRulesAgora objectDomain = new BalanceProcedureResultEvalRulesAgora();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amount;
        resultQuery = super.findForNamed("BALANCESALE_RESULT_EVAL_RULES_AGORA", values);
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
        resultQuery = super.findForNamed("BALANCESALE_RESULT_EVAL_RULES_VISA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("resultEvalRulesVisa idClient=" + clientId + " amount="+amount + " o_result="+objectDomain.getResult() + " o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey,
			String platform, String operatorId) throws Exception {
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
            resultQuery = super.findForNamed("transactionbbva_defineTransaction", values);
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
        resultQuery = super.findForNamed("transactionbbva_checkTransaction", values);
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
        resultQuery = super.findForNamed("BALANCESALE_RESULT_EVAL_RULES_PEFE", values);
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
        resultQuery = super.findForNamed("BALANCESALE_RESULT_EVAL_RULES_SPAY", values);
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
        resultQuery = super.findForNamed("PAY_TRANSACTION_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
	
	@Override
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception {
		LoggerApi.Log.info("registerErrorIzipay");
		List<ProcedureRegisterErrorIzipay> resultQuery = new ArrayList<ProcedureRegisterErrorIzipay>();
		ProcedureRegisterErrorIzipay objectDomain = new ProcedureRegisterErrorIzipay();
        resultQuery = super.findForNamed("PAY_REGISTER_ERROR_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}

	@Override
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception {
		LoggerApi.Log.info("defineTransactionIzipay");
		List<ProcedureDefineTransactionIzipay> resultQuery = new ArrayList<ProcedureDefineTransactionIzipay>();
		ProcedureDefineTransactionIzipay objectDomain = new ProcedureDefineTransactionIzipay();
        resultQuery = super.findForNamed("DEFINE_TRANSACTION_IZIPAY", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
	
	@Override
	public List<BalanceProcedureGetBalanceListFilter> findBalanceListFilter(Integer clientId, String start_date,
			String end_date) throws Exception {
		 LoggerApi.Log.info("cid=" + clientId + "start_date=" + start_date + "end_date=" + end_date );
	        List<BalanceProcedureGetBalanceListFilter> resultQueryList = new ArrayList<BalanceProcedureGetBalanceListFilter>();
	        try {
	            Object[] values = new Object[3];
	            values[0] = clientId;
	            values[1] = start_date;
	            values[2] = end_date;
	            resultQueryList = super.findForNamed("BALANCESALE_GETBALANCELIST_FILTER", values);
	        } catch (Exception e) {
	            LoggerApi.severe(e);
	            throw e;
	        } finally {
	            if (resultQueryList != null)
	                LoggerApi.Log.info("findBalanceListFilter size= " + resultQueryList.size());
	        }
	        return resultQueryList;
	}
}
