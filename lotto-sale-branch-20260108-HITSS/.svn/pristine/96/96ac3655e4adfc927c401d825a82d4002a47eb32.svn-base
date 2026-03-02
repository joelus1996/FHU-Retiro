package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequest;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGenerateTokenPurchaseNumber;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetDataCollectPrizes;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetDataCookie;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetLastNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesCash;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesTrans;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetSavingsAccount;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizes;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizesDebitQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureGetTicketsPrizesOld;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureHasPendingNotificationsRead;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureHisPayment;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureInBlackList;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureListPrizesMajor;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureRegisterTYCPDPLog;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureUpdateNotification;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.layer.model.persistence.dao.PaymentPrizeDao;
import pe.com.intralot.loto.layer.model.domain.ProcedureErrorVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomaticDQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTrans;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTransAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisaAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDefineDebitQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDeleteAccount;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalPopupInformativo;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomaticV2;
import pe.com.intralot.loto.layer.model.domain.ProcedureaApproveRequestVisa;
import pe.com.intralot.loto.layer.model.domain.ProcedureaRefuseRequestAutomatic;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentLogPin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentRequestIp;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentValidatePin;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class PaymentPrizeDaoImpl extends HibernateBaseDaoImpl implements PaymentPrizeDao{

	@Override
	public PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes(Integer clientId) throws Exception {
		LoggerApi.Log.info("getDataCollectPrizes idClient=" + clientId);
		List<PaymentPrizeProcedureGetDataCollectPrizes> resultQuery = new ArrayList<PaymentPrizeProcedureGetDataCollectPrizes>();
		PaymentPrizeProcedureGetDataCollectPrizes objectDomain = new PaymentPrizeProcedureGetDataCollectPrizes();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_DATA_COLLECT_PRIZES", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("getDataCollectPrizes o_client_id=" + objectDomain.getClientId() + 
            		" o_saldo_liquidable=" + objectDomain.getSaldoLiquidable() +
            		" o_item_x_page_hr_mobile=" + objectDomain.getItemXPageHRMobile() +
            		" o_item_x_page_hr_desktop=" + objectDomain.getItemXPageHRDesktop() +
            		" o_amount_min_request_cash=" + objectDomain.getAmountMinRequestCash() +
            		" o_amount_max_request_cash=" + objectDomain.getAmountMaxRequestCash());
        }
		return objectDomain;
	}

	@Override
	public List<PaymentPrizeProcedureHisPayment> getHisPayment(Integer clientId) throws Exception {
		LoggerApi.Log.info("getHisPayment idClient=" + clientId);
		List<PaymentPrizeProcedureHisPayment> resultQuery = new ArrayList<PaymentPrizeProcedureHisPayment>();
		Object[] values = new Object[4];
		values[0] = clientId;
		values[1] = "";
		values[2] = "";
		values[3] = 1;
        resultQuery = super.findForNamed("PRIZEPAYMENT_GET_HISTORY_PAYMENT", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getHisPayment size= " + resultQuery.size()+ " idClient="+clientId);
        return resultQuery;
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizes> getTicketsPrizes(Integer clientId, Integer requestNumber)
			throws Exception {
		LoggerApi.Log.info("getTicketsPrizes idClient=" + clientId + " requestNumber="+requestNumber);
		List<PaymentPrizeProcedureGetTicketsPrizes> resultQuery = new ArrayList<PaymentPrizeProcedureGetTicketsPrizes>();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = requestNumber;
        resultQuery = super.findForNamed("PRIZEPAYMENT_GET_TICKETS_PRIZES", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getTicketsPrizes size= " + resultQuery.size()+ " clientId="+clientId+ " requestNumber="+requestNumber);
		return resultQuery;
	}

	@Override
	public PaymentPrizeProcedureCreateRequest createRequest(String clientId, Double amount, String ip,
			String paymentType, String plataform, String imageDNI, String loadedImge) throws Exception {
		LoggerApi.Log.info("createRequest idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform);
		List<PaymentPrizeProcedureCreateRequest> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequest>();
		PaymentPrizeProcedureCreateRequest objectDomain = new PaymentPrizeProcedureCreateRequest();
		Object[] values = new Object[7];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = imageDNI;
        values[6] = loadedImge;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequest idClient=" + clientId +" amount="+amount+
            		" ip="+ip+" paymentType="+paymentType +" plataform="+plataform+ " s_message="+objectDomain.getMessage()+
            		" o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber());
        }
		return objectDomain;
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizesOld> getTicketsPrizesOld(Integer clientId, String ticket)
			throws Exception {
		LoggerApi.Log.info("getTicketsPrizesOld idClient=" + clientId + " ticket="+ticket);
		List<PaymentPrizeProcedureGetTicketsPrizesOld> resultQuery = new ArrayList<PaymentPrizeProcedureGetTicketsPrizesOld>();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = ticket;
        resultQuery = super.findForNamed("PRIZEPAYMENT_GET_TICKETS_PRIZES_OLD", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getTicketsPrizesOld size=" + resultQuery.size()+ " clientId="+clientId+ " ticket="+ticket);
		return resultQuery;
	}

	@Override
	public List<PaymentPrizeProcedureHisPayment> getHisPaymentByReangeDate(Integer clientId, String desde, String hasta)
			throws Exception {
		LoggerApi.Log.info("getHisPaymentByReangeDate idClient=" + clientId + " desde="+desde+" hasta="+hasta);
		List<PaymentPrizeProcedureHisPayment> resultQuery = new ArrayList<PaymentPrizeProcedureHisPayment>();
		Object[] values = new Object[4];
		values[0] = clientId;
		values[1] = desde;
		values[2] = hasta;
		values[3] = 0;
        resultQuery = super.findForNamed("PRIZEPAYMENT_GET_HISTORY_PAYMENT", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getHisPaymentByReangeDate size=" + resultQuery.size()+ " idClient="+clientId+ " desde="+desde+ " hasta="+hasta);
        return resultQuery;
	}
	
	@Override
	public Long generateTokenPurchaseNumber() throws Exception {
		LoggerApi.Log.info("generateTokenPurchaseNumber");
		List<PaymentPrizeProcedureGenerateTokenPurchaseNumber> resultQuery = new ArrayList<PaymentPrizeProcedureGenerateTokenPurchaseNumber>();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_GENERATE_TOKEN_PURCHASE_NUMBER", null);
		PaymentPrizeProcedureGenerateTokenPurchaseNumber tokenPurchaseNumber = (PaymentPrizeProcedureGenerateTokenPurchaseNumber) resultQuery.get(0);
		LoggerApi.Log.info("generateTokenPurchaseNumber:"+tokenPurchaseNumber.getTokenPurchaseNumber());
		return tokenPurchaseNumber.getTokenPurchaseNumber();
	}

	@Override
	public PaymentPrizeProcedureCreateRequestVisa createRequestVisa(String clientId, Double amount, String ip,
			String paymentType, String plataform, String cardToken, String cardNumber, String transactionId,
			String json, String imageDNI, String loadedImge, double comision) throws Exception {
		LoggerApi.Log.info("createRequestVisa idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform+" transactionId="+transactionId+" loadedImge="+loadedImge);
		List<PaymentPrizeProcedureCreateRequestVisa> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestVisa>();
		PaymentPrizeProcedureCreateRequestVisa objectDomain = new PaymentPrizeProcedureCreateRequestVisa();
		Object[] values = new Object[12];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = cardToken;
        values[6] = cardNumber;
        values[7] = transactionId;
        values[8] = json;
        values[9] = imageDNI;
        values[10] = loadedImge;
        values[11] = comision;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_VISA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequestVisa idClient=" + clientId +" amount="+amount+
            		" ip="+ip+" paymentType="+paymentType +" plataform="+plataform+" transactionId="+transactionId+" loadedImge="+loadedImge+ " s_message="+objectDomain.getMessage()+
            		" o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureGetResultEvalRulesVisa getResultEvalRulesVisa(Integer clientId, Double amountVisa) throws Exception {
		LoggerApi.Log.info("getResultEvalRulesVisa idClient=" + clientId + " amountVisa="+amountVisa);
		List<PaymentPrizeProcedureGetResultEvalRulesVisa> resultQuery = new ArrayList<PaymentPrizeProcedureGetResultEvalRulesVisa>();
		PaymentPrizeProcedureGetResultEvalRulesVisa objectDomain = new PaymentPrizeProcedureGetResultEvalRulesVisa();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amountVisa;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_RESULT_EVAL_RULES_VISA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("getResultEvalRulesVisa idClient=" + clientId + " amountVisa="+amountVisa + " o_result="+objectDomain.getResult());
        }
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedureGetResultEvalRulesCash getResultEvalRulesCash(Integer clientId, Double amountCash) throws Exception {
		LoggerApi.Log.info("getResultEvalRulesCash idClient=" + clientId + " amountCash="+amountCash);
		List<PaymentPrizeProcedureGetResultEvalRulesCash> resultQuery = new ArrayList<PaymentPrizeProcedureGetResultEvalRulesCash>();
		PaymentPrizeProcedureGetResultEvalRulesCash objectDomain = new PaymentPrizeProcedureGetResultEvalRulesCash();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amountCash;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_RESULT_EVAL_RULES_CASH", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("getResultEvalRulesCash idClient=" + clientId + " amountCash="+amountCash + " o_result="+objectDomain.getResult());
        }
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedureCreateRequestVisaAutomatic createRequestVisaAutomatic(String clientId, Double amount,
			String ip, String paymentType, String plataform, String cardToken, String cardNumber, String transactionId,
			String json, String imageDNI, String loadedImge, double comision) throws Exception {
		LoggerApi.Log.info("createRequestVisaAutomatic idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform+" transactionId="+transactionId+" loadedImge="+loadedImge);		
		List<PaymentPrizeProcedureCreateRequestVisaAutomatic> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestVisaAutomatic>();
		PaymentPrizeProcedureCreateRequestVisaAutomatic objectDomain = new PaymentPrizeProcedureCreateRequestVisaAutomatic();
		Object[] values = new Object[12];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = cardToken;
        values[6] = cardNumber;
        values[7] = transactionId;
        values[8] = json;
        values[9] = imageDNI;
        values[10] = loadedImge;
        values[11] = comision;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_VISA_AUTOMATIC", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequestVisaAutomatic idClient=" + clientId +" amount="+amount+
            		" ip="+ip+" paymentType="+paymentType +" plataform="+plataform+" transactionId="+transactionId+" loadedImge="+loadedImge+ " s_message="+objectDomain.getMessage()+
            		" o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber());
        }
		return objectDomain;
	}

	@Override
	public ProcedureaApproveRequestVisa approveRequestVisa(Object[] values) throws Exception {
		LoggerApi.Log.info("approveRequestVisa");		
		List<ProcedureaApproveRequestVisa> resultQuery = new ArrayList<ProcedureaApproveRequestVisa>();
		ProcedureaApproveRequestVisa objectDomain = new ProcedureaApproveRequestVisa();
		resultQuery = super.findForNamed("PRIZEPAYMENT_APPROVE_REQUEST_VISA", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	    if (objectDomain != null) {
	    	LoggerApi.Log.info("approveRequestVisa result="+objectDomain.getResult()+" message="+objectDomain.getMessage());
	    }
		return objectDomain;
	}

	@Override
	public ProcedureaRefuseRequestAutomatic refuseRequestAutomatic(Object[] values) throws Exception {
		LoggerApi.Log.info("refuseRequestAutomatic");		
		List<ProcedureaRefuseRequestAutomatic> resultQuery = new ArrayList<ProcedureaRefuseRequestAutomatic>();
		ProcedureaRefuseRequestAutomatic objectDomain = new ProcedureaRefuseRequestAutomatic();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_REFUSE_REQUEST_AUTOMATIC", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	    if (objectDomain != null) {
	    	LoggerApi.Log.info("refuseRequestAutomatic requestNumber="+objectDomain.getRequestNumber()+" message="+objectDomain.getMessage());
	    }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureCreateRequestAutomatic createRequestAutomatic(String clientId, Double amount, String ip,
			String paymentType, String plataform, String imageDNI, String loadedImge) throws Exception {
		LoggerApi.Log.info("createRequestAutomatic idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform);
		List<PaymentPrizeProcedureCreateRequestAutomatic> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestAutomatic>();
		PaymentPrizeProcedureCreateRequestAutomatic objectDomain = new PaymentPrizeProcedureCreateRequestAutomatic();
		Object[] values = new Object[7];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = imageDNI;
        values[6] = loadedImge;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_AUTOMATIC", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequestAutomatic idClient=" + clientId +" amount="+amount+
            		" ip="+ip+" paymentType="+paymentType +" plataform="+plataform+ " s_message="+objectDomain.getMessage()+
            		" o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber());
        }
		return objectDomain;
	}
	
	@Override
	public ProcedureErrorVisa errorVisa(Object[] values) throws Exception {
		LoggerApi.Log.info("errorVisa json="+values[5]);
		List<ProcedureErrorVisa> resultQuery = new ArrayList<ProcedureErrorVisa>();
		ProcedureErrorVisa objectDomain = new ProcedureErrorVisa();
        resultQuery = super.findForNamed("PRIZE_PAYMENT_REFUSE_ERROR_VISA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("errorVisa message=" + objectDomain.getMessage()+" result="+objectDomain.getResult());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureGetResultEvalRulesAgora getResultEvalRulesAgora(Integer clientId, Double amountAgora)
			throws Exception {
		LoggerApi.Log.info("getResultEvalRulesAgora idClient=" + clientId + " amountAgora="+amountAgora);
		List<PaymentPrizeProcedureGetResultEvalRulesAgora> resultQuery = new ArrayList<PaymentPrizeProcedureGetResultEvalRulesAgora>();
		PaymentPrizeProcedureGetResultEvalRulesAgora objectDomain = new PaymentPrizeProcedureGetResultEvalRulesAgora();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = amountAgora;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_RESULT_EVAL_RULES_AGORA", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("getResultEvalRulesAgora idClient=" + clientId + " amountAgora="+amountAgora + " o_result="+objectDomain.getResult());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureInBlackList inBlackList(Integer clientId) throws Exception {
		LoggerApi.Log.info("inBlackList clientId=" + clientId);
		List<PaymentPrizeProcedureInBlackList> resultQuery = new ArrayList<PaymentPrizeProcedureInBlackList>();
		PaymentPrizeProcedureInBlackList objectDomain = new PaymentPrizeProcedureInBlackList();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_IN_BLACKLIST", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("inBlackList clientId=" + clientId + " state="+objectDomain.getResult() + " message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureEvalRulesAutomatic evalRulesAutomatic(Integer clientId) throws Exception {
		LoggerApi.Log.info("evalRulesAutomatic clientId=" + clientId);
		List<PaymentPrizeProcedureEvalRulesAutomatic> resultQuery = new ArrayList<PaymentPrizeProcedureEvalRulesAutomatic>();
		PaymentPrizeProcedureEvalRulesAutomatic objectDomain = new PaymentPrizeProcedureEvalRulesAutomatic();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_EVAL_RULES_AUTOMATIC", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("evalRulesAutomatic clientId=" + clientId + " result="+objectDomain.getResult() + " message="+objectDomain.getMessage());
        }
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedureEvalRulesAutomaticV2 evalRulesAutomaticV2(Integer clientId, String typePayment) throws Exception {
		LoggerApi.Log.info("evalRulesAutomaticv2 clientId=" + clientId);
		List<PaymentPrizeProcedureEvalRulesAutomaticV2> resultQuery = new ArrayList<PaymentPrizeProcedureEvalRulesAutomaticV2>();
		PaymentPrizeProcedureEvalRulesAutomaticV2 objectDomain = new PaymentPrizeProcedureEvalRulesAutomaticV2();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = typePayment;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_EVAL_RULES_AUTOMATIC_V2", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("evalRulesAutomaticv2 clientId=" + clientId + " result="+objectDomain.getResult() + " message="+objectDomain.getMessage());
        }
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedureGetResultEvalRulesTrans getResultEvalRulesTrans(Integer clientId,
			Double amountTransferencia, String rango) throws Exception {
		LoggerApi.Log.info("getResultEvalRulesTrans idClient=" + clientId + " amountTransferencia="+amountTransferencia+" rango="+rango);
		List<PaymentPrizeProcedureGetResultEvalRulesTrans> resultQuery = new ArrayList<PaymentPrizeProcedureGetResultEvalRulesTrans>();
		PaymentPrizeProcedureGetResultEvalRulesTrans objectDomain = new PaymentPrizeProcedureGetResultEvalRulesTrans();
		Object[] values = new Object[3];
        values[0] = clientId;
        values[1] = amountTransferencia;
        values[2] = rango;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_RESULT_EVAL_RULES_TRANS", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("getResultEvalRulesTrans idClient=" + clientId + " amountTransferencia="+amountTransferencia + " o_result="+objectDomain.getResult()+" rango="+rango);
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureCreateRequestTransAutomatic createRequestTransAutomatic(String clientId, Double amount, String ip, String paymentType,
			String plataform, String imageDNI, String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente) throws Exception {
		LoggerApi.Log.info("createRequestTransAutomatic idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform+" banco="+banco+" cuenta="+cuenta+" departamento="+departamento+" guardarRecurrente="+guardarRecurrente);		
		List<PaymentPrizeProcedureCreateRequestTransAutomatic> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestTransAutomatic>();
		PaymentPrizeProcedureCreateRequestTransAutomatic objectDomain = new PaymentPrizeProcedureCreateRequestTransAutomatic();
		Object[] values = new Object[12];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = imageDNI;
        values[6] = loadedImage;
        values[7] = banco;
        values[8] = cuenta;
        values[9] = departamento;
        values[10] = idBanco;
        values[11] = guardarRecurrente;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_TRANS_AUTOMATIC", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequestTransAutomatic idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform+" banco="+banco+" cuenta="+cuenta+" departamento="+departamento+
            		" s_message="+objectDomain.getMessage()+" o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber()+" guardarRecurrente="+guardarRecurrente);
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureCreateRequestTrans createRequestTrans(String clientId, BigDecimal amount, String ip, 
			String paymentType, String plataform, String imageDNI, String loadedImge, String banco, String cuenta,
			String departamento, String idBanco, String guardarRecurrente, String rango, String tipo, String ticket, String gameId, Double prizeAmount, Double freeAmount) throws Exception {
		LoggerApi.Log.info("createRequestTrans idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType+" plataform="+plataform+" loadedImge="+loadedImge+" banco="+banco+" cuenta="+cuenta+" departamento="+departamento+" guardarRecurrente="+guardarRecurrente+" rango="+rango+" tipo="+tipo+" ticket="+ticket+" gameId="+gameId+" prizeAmount="+prizeAmount+" freeAmount="+freeAmount);
		List<PaymentPrizeProcedureCreateRequestTrans> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestTrans>();
		PaymentPrizeProcedureCreateRequestTrans objectDomain = new PaymentPrizeProcedureCreateRequestTrans();
		Object[] values = new Object[18];
        values[0] = clientId;
        values[1] = ip;
        values[2] = amount;
        values[3] = paymentType;
        values[4] = plataform;
        values[5] = imageDNI;
        values[6] = loadedImge;
        values[7] = banco;
        values[8] = cuenta;
        values[9] = departamento;
        values[10] = idBanco;
        values[11] = guardarRecurrente;
        values[12] = rango;
        values[13] = tipo;
        values[14] = ticket;
        values[15] = gameId;
        values[16] = prizeAmount;
        values[17] = freeAmount;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_TRANS", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("createRequestTrans idClient=" + clientId +" amount="+amount+" ip="+ip+" paymentType="+paymentType +" plataform="+plataform+ " guardarRecurrente="+guardarRecurrente+" rango="+rango+
            		" banco="+banco+" cuenta="+cuenta+" departamento="+departamento+" tipo="+tipo+" ticket="+ticket+" s_message="+objectDomain.getMessage()+ " o_amount="+objectDomain.getAmount()+" o_request_number="+objectDomain.getRequestNumber());
        }
		return objectDomain;
	}
	
	@Override
	public List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount(Integer clientId) throws Exception {
		LoggerApi.Log.info("getSavingsAccount idClient=" + clientId);
		List<PaymentPrizeProcedureGetSavingsAccount> resultQuery = new ArrayList<PaymentPrizeProcedureGetSavingsAccount>();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_SAVINGS_ACCOUNT", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getSavingsAccount size= " + resultQuery.size()+ " idClient="+clientId);
		return resultQuery;
	}

	@Override
	public PaymentPrizeProcedureDeleteAccount deleteAccount(Integer clientId, String cuenta) throws Exception {
		LoggerApi.Log.info("deleteAccount idClient=" + clientId + " cuenta="+cuenta);
		List<PaymentPrizeProcedureDeleteAccount> resultQuery = new ArrayList<PaymentPrizeProcedureDeleteAccount>();
		PaymentPrizeProcedureDeleteAccount objectDomain = new PaymentPrizeProcedureDeleteAccount();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = cuenta;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_DELETE_ACCOUNT", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("deleteAccount idClient="+clientId+" cuenta="+cuenta+" o_result="+objectDomain.getResult()+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureEvalPopupInformativo evalPopupInformativo(Integer clientId) throws Exception {
		LoggerApi.Log.info("evalPopupInformativo idClient=" + clientId);
		List<PaymentPrizeProcedureEvalPopupInformativo> resultQuery = new ArrayList<PaymentPrizeProcedureEvalPopupInformativo>();
		PaymentPrizeProcedureEvalPopupInformativo objectDomain = new PaymentPrizeProcedureEvalPopupInformativo();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_EVAL_POPUP_INFORMATIVO", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("evalPopupInformativo idClient="+clientId+" o_result="+objectDomain.getResult()+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor(Integer clientId) throws Exception {
		LoggerApi.Log.info("listPrizesMajor idClient=" + clientId);
		List<PaymentPrizeProcedureListPrizesMajor> resultQuery = new ArrayList<PaymentPrizeProcedureListPrizesMajor>();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_LIST_PRIZES_MAJOR", values);
        if (resultQuery != null)
            LoggerApi.Log.info("listPrizesMajor size= " + resultQuery.size()+ " idClient="+clientId);
		return resultQuery;
	}

	@Override
	public List<PaymentPrizeProcedureGetNotifications> getNotifications(Integer clientId) throws Exception {
		LoggerApi.Log.info("getNotifications clientId=" + clientId);
		List<PaymentPrizeProcedureGetNotifications> resultQuery = new ArrayList<PaymentPrizeProcedureGetNotifications>();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_NOTIFICATIONS", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getNotifications size= " + resultQuery.size()+ " clientId="+clientId);
		return resultQuery;
	}

	@Override
	public List<PaymentPrizeProcedureGetLastNotifications> getLastNotifications(Integer clientId) throws Exception {
		LoggerApi.Log.info("getLastNotifications clientId=" + clientId);
		List<PaymentPrizeProcedureGetLastNotifications> resultQuery = new ArrayList<PaymentPrizeProcedureGetLastNotifications>();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_LAST_NOTIFICATION", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getLastNotifications size= " + resultQuery.size()+ " clientId="+clientId);
		return resultQuery;
	}

	@Override
	public PaymentPrizeProcedureHasPendingNotificationsRead hasPendingNotificationsRead(Integer clientId)
			throws Exception {
		LoggerApi.Log.info("hasPendingNotificationsRead clientId=" + clientId);
		List<PaymentPrizeProcedureHasPendingNotificationsRead> resultQuery = new ArrayList<PaymentPrizeProcedureHasPendingNotificationsRead>();
		PaymentPrizeProcedureHasPendingNotificationsRead objectDomain = new PaymentPrizeProcedureHasPendingNotificationsRead();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_HAS_PENDING_NOTIFICATIONS_READ", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("hasPendingNotificationsRead idClient="+clientId+" o_pendientes="+objectDomain.getPendientes());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureUpdateNotification updateNotification(Integer clientId, String idNotificacion)
			throws Exception {
		LoggerApi.Log.info("updateNotification clientId=" + clientId+" idNotificacion="+idNotificacion);
		List<PaymentPrizeProcedureUpdateNotification> resultQuery = new ArrayList<PaymentPrizeProcedureUpdateNotification>();
		PaymentPrizeProcedureUpdateNotification objectDomain = new PaymentPrizeProcedureUpdateNotification();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = idNotificacion;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_UPDATE_NOTIFICATION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("updateNotification idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}
	
	@Override
	public TransactionPaymentRequestIp transactionRequestIp(String channel, String request, String clientId, String ip, String uuid, String medio, String amount)
	{
		LoggerApi.Log.info("transactionRequestIp clientId=" + clientId+" ip="+ip+" request="+request+" uuid="+uuid);
		List<TransactionPaymentRequestIp> resultQuery = new ArrayList<TransactionPaymentRequestIp>();
		TransactionPaymentRequestIp objectDomain = new TransactionPaymentRequestIp();
		Object[] values = new Object[7];
        values[0] = channel;
        values[1] = request;
        values[2] = clientId;
        values[3] = ip;
        values[4] = uuid;
        values[5] = medio;
        values[6] = amount;
        resultQuery = super.findForNamed("LOTOCARD_TRANSACTIONPAYMENTLOG_REQUESTIP", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("transactionRequestIp clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}
	
	@Override
	public TransactionPaymentCreatePin transactionCreatePin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String pin, String p_sms)
	{
		LoggerApi.Log.info("transactionCreatePin channel=" + channel+" request="+request+" clientId="+clientId+" ip="+ip+" pinuuid="+pinuuid +" medio="+medio + " amount="+amount + " pin="+pin + " p_sms="+p_sms);		
		List<TransactionPaymentCreatePin> resultQuery = new ArrayList<TransactionPaymentCreatePin>();
		TransactionPaymentCreatePin objectDomain = new TransactionPaymentCreatePin();
		Object[] values = new Object[9];
        values[0] = channel;
        values[1] = request;
        values[2] = clientId;
        values[3] = ip;
        values[4] = pinuuid;
        values[5] = medio;
        values[6] = amount;
        values[7] = pin;
        values[8] = p_sms;
        resultQuery = super.findForNamed("LOTOCARD_TRANSACTIONPAYMENTLOG_CREATEPIN", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("transactionCreatePin clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}
	
	public TransactionPaymentLogPin transactionLogPin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String status, String result)
	{
		LoggerApi.Log.info("transactionLogPin clientId=" + clientId+" ip="+ip+" request="+request+" pinuuid="+pinuuid+" status="+status+" result="+result);
		List<TransactionPaymentLogPin> resultQuery = new ArrayList<TransactionPaymentLogPin>();
		TransactionPaymentLogPin objectDomain = new TransactionPaymentLogPin();
		Object[] values = new Object[9];
        values[0] = channel;
        values[1] = request;
        values[2] = clientId;
        values[3] = ip;
        values[4] = pinuuid;
        values[5] = medio;
        values[6] = amount;
        values[7] = status;
        values[8] = result;
        resultQuery = super.findForNamed("LOTOCARD_TRANSACTIONPAYMENTLOG_LOGPIN", values);
                
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("transactionLogPin clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}
	
	
	@Override
	public TransactionPaymentValidatePin transactionValidatePin(String channel, String request, String clientId, String ip, String uuid, String medio, String amount, String mail, String pin)
	{
		LoggerApi.Log.info("transactionValidatePin clientId=" + clientId+" ip="+ip+" request="+request+" uuid="+uuid);
		List<TransactionPaymentValidatePin> resultQuery = new ArrayList<TransactionPaymentValidatePin>();
		TransactionPaymentValidatePin objectDomain = new TransactionPaymentValidatePin();
		Object[] values = new Object[9];
        values[0] = channel;
        values[1] = request;
        values[2] = clientId;
        values[3] = ip;
        values[4] = uuid;
        values[5] = medio;
        values[6] = amount;
        values[7] = mail;
        values[8] = pin;
        resultQuery = super.findForNamed("LOTOCARD_TRANSACTIONPAYMENTLOG_VALIDATEPIN", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
        	LoggerApi.Log.info("transactionValidatePin clientId=" + clientId+" ip="+ip+" objectDomain="+objectDomain);
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureGetDataCookie getDataCookie() throws Exception {
		LoggerApi.Log.info("getDataCookie");
		List<PaymentPrizeProcedureGetDataCookie> resultQuery = new ArrayList<PaymentPrizeProcedureGetDataCookie>();
		PaymentPrizeProcedureGetDataCookie objectDomain = new PaymentPrizeProcedureGetDataCookie();
        resultQuery = super.findForNamed("PRIZE_PAYMENT_GET_DATA_BANNER_COOKIE",null);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedurePasswordNotification passwordNotification(Integer clientId) throws Exception {
		LoggerApi.Log.info("passwordNotification clientId=" + clientId);
		List<PaymentPrizeProcedurePasswordNotification> resultQuery = new ArrayList<PaymentPrizeProcedurePasswordNotification>();
		PaymentPrizeProcedurePasswordNotification objectDomain = new PaymentPrizeProcedurePasswordNotification();
		Object[] values = new Object[1];
        values[0] = clientId;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_PASSWORD_NOTIFICATION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("passwordNotification idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}
	
	@Override
	public PaymentPrizeProcedureUpdatePasswordNotification updatePasswordNotification(Integer clientId, String idNotificacion)
			throws Exception {
		LoggerApi.Log.info("updateNotification clientId=" + clientId+" idNotificacion="+idNotificacion);
		List<PaymentPrizeProcedureUpdatePasswordNotification> resultQuery = new ArrayList<PaymentPrizeProcedureUpdatePasswordNotification>();
		PaymentPrizeProcedureUpdatePasswordNotification objectDomain = new PaymentPrizeProcedureUpdatePasswordNotification();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = idNotificacion;
        resultQuery = super.findForNamed("PRIZE_PAYMENT_UPDATE_PASSWORD_NOTIFICATION", values);
        objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        if (objectDomain != null) {
            LoggerApi.Log.info("updateNotification idClient="+clientId+" o_message="+objectDomain.getMessage());
        }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureRegisterErrorCA registerErrorCA(Object[] values) throws Exception {
		LoggerApi.Log.info("registerErrorCA");		
		List<PaymentPrizeProcedureRegisterErrorCA> resultQuery = new ArrayList<PaymentPrizeProcedureRegisterErrorCA>();
		PaymentPrizeProcedureRegisterErrorCA objectDomain = new PaymentPrizeProcedureRegisterErrorCA();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_REGISTER_ERROR_CA", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	    if (objectDomain != null) {
	    	LoggerApi.Log.info("registerErrorCA state="+objectDomain.getState()+" message="+objectDomain.getMessage());
	    }
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureRegisterTYCPDPLog registerTYCPDPLog(Object[] values) throws Exception {
		LoggerApi.Log.info("registerTYCPDPLog");		
		List<PaymentPrizeProcedureRegisterTYCPDPLog> resultQuery = new ArrayList<PaymentPrizeProcedureRegisterTYCPDPLog>();
		PaymentPrizeProcedureRegisterTYCPDPLog objectDomain = new PaymentPrizeProcedureRegisterTYCPDPLog();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_REGISTER_TYC_PDP_LOG", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
	    if (objectDomain != null) {
	    	LoggerApi.Log.info("registerTYCPDPLog state="+objectDomain.getState()+" message="+objectDomain.getMessage());
	    }
		return objectDomain;
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> getTicketsPrizesDebitQR(Integer clientId,
			Integer requestNumber) throws Exception {
		LoggerApi.Log.info("getTicketsPrizesDebitqr idClient=" + clientId + " requestNumber="+requestNumber);
		List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> resultQuery = new ArrayList<PaymentPrizeProcedureGetTicketsPrizesDebitQR>();
		Object[] values = new Object[2];
        values[0] = clientId;
        values[1] = requestNumber;
        resultQuery = super.findForNamed("PRIZEPAYMENT_GET_TICKETS_PRIZES_DEBITQR", values);
        if (resultQuery != null)
            LoggerApi.Log.info("getTicketsPrizesDebitqr size= " + resultQuery.size()+ " clientId="+clientId+ " requestNumber="+requestNumber);
		return resultQuery;
	}

	@Override
	public PaymentPrizeProcedureDefineDebitQR defineDebitQR(Object[] values) throws Exception {
		LoggerApi.Log.info("defineDebitQR clientId="+values[0]);		
		List<PaymentPrizeProcedureDefineDebitQR> resultQuery = new ArrayList<PaymentPrizeProcedureDefineDebitQR>();
		PaymentPrizeProcedureDefineDebitQR objectDomain = new PaymentPrizeProcedureDefineDebitQR();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_DEFINE_DEBITQR", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}

	@Override
	public PaymentPrizeProcedureCreateRequestAutomaticDQR createRequestAutomaticDQR(Integer clientId, Double amount,
			String paymentType, String plataform, String imageDNI, String loadedImge, Double amountKiron,
			Double amountNeo, Integer debitIdQr, Integer balanceItemKiron, Integer balanceItemNeo) throws Exception {
		LoggerApi.Log.info("createRequestAutomaticDQR idClient=" + clientId +" amount="+amount+" paymentType="+paymentType+" plataform="+plataform+" loadedImge="+loadedImge+" amountKiron="+amountKiron+" amountNeo="+amountNeo+" debitIdQr="+debitIdQr+" balanceItemKiron="+balanceItemKiron+" balanceItemNeo="+balanceItemNeo);
		Object[] values = new Object[11];
        values[0] = clientId;
        values[1] = amount;
        values[2] = paymentType;
        values[3] = plataform;
        values[4] = imageDNI;
        values[5] = loadedImge;
        values[6] = amountKiron;
        values[7] = amountNeo;
        values[8] = debitIdQr;
        values[9] = balanceItemKiron;
        values[10] = balanceItemNeo;
		List<PaymentPrizeProcedureCreateRequestAutomaticDQR> resultQuery = new ArrayList<PaymentPrizeProcedureCreateRequestAutomaticDQR>();
		PaymentPrizeProcedureCreateRequestAutomaticDQR objectDomain = new PaymentPrizeProcedureCreateRequestAutomaticDQR();
		resultQuery = super.findForNamed("PRIZE_PAYMENT_CREATE_REQUEST_AUTOMATIC_DQR", values);
	    objectDomain = DataAccessUtils.uniqueResult(resultQuery);
		return objectDomain;
	}
}
