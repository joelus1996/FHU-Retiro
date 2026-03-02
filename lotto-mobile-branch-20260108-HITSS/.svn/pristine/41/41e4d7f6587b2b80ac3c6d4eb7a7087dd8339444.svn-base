package pe.com.intralot.loto.layer.controller.client.bo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.BalanceProcedureGetWinCup;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationRequestDTO;
import pe.com.intralot.loto.layer.dto.client.ClientBalanceInformationResponseDTO;
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
import pe.com.intralot.loto.layer.model.pojo.ProcedureDefineTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedurePayTransactionIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureRegisterErrorIzipay;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinTupayVerifyTransaction;
import pe.com.intralot.loto.layer.model.pojo.ProcedureYapePlinVerifyTransaction;

public interface ClientBalanceBo {	
	
	//public List<ClientBalance> getCurrentAccount(Integer id) throws Exception;
	
	public List<ClientProcedureGetBalanceList> getCurrentAccount(Integer p_clientId) throws Exception;
	
	public List<ClientProcedureGetTeApuestoBonusList> getTeApuestoBonusAccount (Integer p_clientId) throws Exception;
	
	public List<ClientProcedureGetTeApuestoPromoList> getTeApuestoPromoAccount (Integer p_clientId) throws Exception;
	
	public List<ClientProcedureGetBicolorPromoList> getBicolorPromoAccount (Integer p_clientId) throws Exception;
	
	public List<ListTicketBicolorClient> getListBicolorTickets (Integer p_clientId) throws Exception;
	
	public List<ClientProcedureGetGamesBonusList> getGamesBonusAccount (Integer p_clientId) throws Exception;
	
	public ClientProcedureAccountData findAccountData(Integer p_clientId) throws Exception;
	
	public ClientProcedureCodeValidation codePromotionalValidation(Object[] values) throws Exception;
	
	public List<BalanceProcedureGetMontoPorDia> findMontoPorDia(Integer clientId) throws Exception;
	
	public ClientProcedureAccountDataPart findAccountDataPart(Integer p_clientId) throws Exception;
	
	public List<BalanceProcedureGetMontoPorDiaAgora> findMontoPorDiaAgora(Integer clientId) throws Exception;

	public ClientProcedureUpdateStateRechargeAgora updateStateRechargeAgora(Integer clientId, String phoneUpdateAgora, String phoneUpdate) throws Exception;
	
	public ClientProcedureValidateNewPhoneAgora validateNewPhoneAgora(Integer clientId, String phoneUpdate) throws Exception;
	
	public BalanceProcedureResultEvalRulesAgora resultEvalRulesAgora(Integer clientId, Double amount) throws Exception;
	
	public BalanceProcedureResultEvalRulesVisa resultEvalRulesVisa(Integer clientId, Double amount) throws Exception;
	
	public BalanceProcedureGetWinCup findWinProm(Integer clientId, String p_prom_id) throws Exception;

	public ProcedureYapePlinVerifyTransaction yapePlinVerifyTransaction(Integer p_clientId, String channel) throws Exception;
	
	public BbvaProcedureDefineTransaction getDefineTransactionBBVA(String clientId, double amount, String bonokey, String platform, String operatorId) throws Exception;

	public List<BbvaProcedureCheckTransaction> getCheckTransactionBBVA(String clientId) throws Exception;
	
	public int expiryTransactionBBVA(String trx,String clientId) throws Exception;

	public Object[] verifyTransactionBBVA(String trx, String clientId) throws Exception;
	
	public BalanceProcedureResultEvalRulesPefe resultEvalRulesPefe(Integer clientId, Double amount) throws Exception;
	
	public BalanceProcedureResultEvalRulesSpay resultEvalRulesSpay(Integer clientId, Double amount) throws Exception;
	
	public ProcedurePayTransactionIzipay payTransactionIzipay(Object[] values) throws Exception;
	
	public ProcedureRegisterErrorIzipay registerErrorIzipay(Object[] values) throws Exception;
	
	public ProcedureDefineTransactionIzipay defineTransactionIzipay(Object[] values) throws Exception;
	
	public ProcedureYapePlinTupayVerifyTransaction yapePlinTupayVerifyTransaction(Integer p_clientId, String channel) throws Exception;
	
	public List<ClientProcedureGetBalanceListFilter> getCurrentAccountFilter(Integer p_clientId, String start_date, String end_date) throws Exception;

	ClientBalanceInformationResponseDTO getClientBalanceInformation(ClientBalanceInformationRequestDTO request) throws Exception;
}