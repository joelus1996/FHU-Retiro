package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

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

public interface BalanceSaleDao {
	
	public List<BalanceProcedureGetBalanceList> findBalanceList(Integer clientId) throws Exception;
	
	public List<BalanceProcedureGetBonusList> findBonusList(Integer clientId) throws Exception;

	public List<BalanceProcedureGetOtherList> findOtherList(Integer clientId) throws Exception;
	
	public List<BalanceProcedureGetPromoList> findPromoList(Integer clientId) throws Exception;
	
	public List<ClientProcedureGetBicolorPromoList> findPromoBicolorList(Integer clientId) throws Exception;
	
	public List<ListTicketBicolorClient> getListBicolorTickets(Integer clientId) throws Exception;
	
	public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer clientId) throws Exception;
	
	public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer clientId) throws Exception;
	
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception;
	
	public BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa(Integer clientId, Double amount) throws Exception;
	
	public List<BalanceProcedureGetWinCup> findWinProm(Integer clientId, String p_prom_id) throws Exception;
	
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey, String platform, String operatorId) throws Exception;

	public List<BbvaProcedureCheckTransaction> getCheckTransactionBBVA(String clientId) throws Exception;
	
	public int expiryTransactionBBVA(String trx, String clientId) throws Exception;
	
	public Object[] verifyTransactionBBVA(String trx, String clientId) throws Exception;
	
	public BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe(Integer clientId, Double amount) throws Exception;
	
	public BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay(Integer clientId, Double amount) throws Exception;
	
	public ProcedurePayTransactionIzipay payTransactionIzipay(Object[] values) throws Exception;
	
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception;
	
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception;
	
	public List<BalanceProcedureGetBalanceListFilter> findBalanceListFilter(Integer clientId, String start_date, String end_date) throws Exception;
}
