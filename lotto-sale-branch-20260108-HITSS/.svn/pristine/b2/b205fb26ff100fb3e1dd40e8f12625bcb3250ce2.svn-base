package pe.com.intralot.loto.layer.service.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import pe.com.intralot.loto.layer.service.client.bo.BalanceSaleBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class BalanceSaleBoImpl implements BalanceSaleBo {

	@Autowired
	private BalanceSaleDao balanceSaleDao;

	@Override
	public List<BalanceProcedureGetBalanceList> findBalanceList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId=" + p_clientId);

		List<BalanceProcedureGetBalanceList> resultQueryList = new ArrayList<BalanceProcedureGetBalanceList>();
		try {
			resultQueryList = balanceSaleDao.findBalanceList(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	@Override
	public List<BalanceProcedureGetBonusList> findBonusList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId=" + p_clientId);

		List<BalanceProcedureGetBonusList> resultQueryList = new ArrayList<BalanceProcedureGetBonusList>();
		try {
			resultQueryList = balanceSaleDao.findBonusList(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

	@Override
	public List<BalanceProcedureGetOtherList> findOtherList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId=" + p_clientId);

		List<BalanceProcedureGetOtherList> resultQueryList = new ArrayList<BalanceProcedureGetOtherList>();
		try {
			resultQueryList = balanceSaleDao.findOtherList(p_clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	@Override
	public List<BalanceProcedureGetPromoList> findPromoList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("findPromoList clientId=" + p_clientId);

		List<BalanceProcedureGetPromoList> resultQueryList = new ArrayList<BalanceProcedureGetPromoList>();
		try {
			resultQueryList = balanceSaleDao.findPromoList(p_clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("findPromoList size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	@Override
	public List<ClientProcedureGetBicolorPromoList> findPromoBicolorList(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("findPromoList clientId=" + p_clientId);

		List<ClientProcedureGetBicolorPromoList> resultQueryList = new ArrayList<ClientProcedureGetBicolorPromoList>();
		try {
			resultQueryList = balanceSaleDao.findPromoBicolorList(p_clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("findPromoList size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	@Override
	public List<ListTicketBicolorClient> getListBicolorTickets(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("findPromoList clientId=" + p_clientId);

		List<ListTicketBicolorClient> resultQueryList = new ArrayList<ListTicketBicolorClient>();
		try {
			resultQueryList = balanceSaleDao.getListBicolorTickets(p_clientId);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("findPromoList size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	
	@Override
	public List<BalanceProcedureGetWinCup> findWinProm(Integer p_clientId, String p_prom_id) throws Exception {

		LoggerApi.Log.info("findPromoList clientId=" + p_clientId);

		List<BalanceProcedureGetWinCup> resultQueryList = new ArrayList<BalanceProcedureGetWinCup>();
		try {
			resultQueryList = balanceSaleDao.findWinProm(p_clientId,p_prom_id);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("findIdClientWin = " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	
	
	
	
	
	@Override
	public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId=" + p_clientId);

		List<BalanceProcedureGetMontoPorDia> resultQueryList = new ArrayList<BalanceProcedureGetMontoPorDia>();
		try {
			resultQueryList = balanceSaleDao.findMontoPorDia(p_clientId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

	@Override
	public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer p_clientId) throws Exception {
		return balanceSaleDao.findMontoPorDiaAgora(p_clientId);
	}

	@Override
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception {
		return balanceSaleDao.resultEvalRulesAgora(clientId, amount);
	}

	@Override
	public BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa(Integer clientId, Double amount) throws Exception {
		return balanceSaleDao.resultEvalRulesVisa(clientId, amount);
	}

	@Override
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey,
			String platform, String operatorId) throws Exception {
		return balanceSaleDao.getDefineTransactionBBVA(clientId, amount, bonokey, platform, operatorId);
	}

	@Override
	public List<BbvaProcedureCheckTransaction> getCheckTransactionBBVA(String clientId) throws Exception {
		return balanceSaleDao.getCheckTransactionBBVA(clientId);
	}

	@Override
	public int expiryTransactionBBVA(String trx, String clientId) throws Exception {
		return balanceSaleDao.expiryTransactionBBVA(trx, clientId);
	}

	@Override
	public Object[] verifyTransactionBBVA(String trx, String clientId) throws Exception {
		return balanceSaleDao.verifyTransactionBBVA(trx, clientId);
	}

	@Override
	public BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe(Integer clientId, Double amount) throws Exception {
		return balanceSaleDao.resultEvalRulesPefe(clientId, amount);
	}

	@Override
	public BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay(Integer clientId, Double amount) throws Exception {
		return balanceSaleDao.resultEvalRulesSpay(clientId, amount);
	}

	@Override
	public ProcedurePayTransactionIzipay payTransactionIzipay(Object[] values) throws Exception {
		return balanceSaleDao.payTransactionIzipay(values);
	}

	@Override
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception {
		return balanceSaleDao.registerErrorIzipay(values);
	}

	@Override
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception {
		return balanceSaleDao.defineTransactionIzipay(values);
	}
	
	@Override
	public List<BalanceProcedureGetBalanceListFilter> findBalanceListFilter(Integer clientId, String start_date,
			String end_date) throws Exception {
		LoggerApi.Log.info("clientId=" + clientId + "start_date=" + start_date + "end_date=" + end_date);

		List<BalanceProcedureGetBalanceListFilter> resultQueryList = new ArrayList<BalanceProcedureGetBalanceListFilter>();
		try {
			resultQueryList = balanceSaleDao.findBalanceListFilter(clientId, start_date, end_date);
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
			
				LoggerApi.Log.info("findBalanceListFilter size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
}
