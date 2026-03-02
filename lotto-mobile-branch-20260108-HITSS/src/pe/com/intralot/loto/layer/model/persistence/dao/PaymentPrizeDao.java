package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentLogPin;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentRequestIp;
import pe.com.intralot.loto.layer.model.pojo.TransactionPaymentValidatePin;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequest;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestAutomaticDQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTrans;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTransAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestTransV2;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestVisa;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureCreateRequestVisaAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureDefineDebitQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureDeleteAccount;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalPopupInformativo;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalRulesAutomatic;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureEvalRulesAutomaticV2;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetDataCollectPrizes;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetDataCookie;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetLastNotifications;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetNotifications;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetRequestByNumber;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesAgora;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesCash;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesTrans;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetResultEvalRulesVisa;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetSavingsAccount;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizes;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizesDebitQR;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTicketsPrizesOld;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureGetTokenCard;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureHasPendingNotificationsRead;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureHisPayment;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureInBlackList;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureListPrizesMajor;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedurePasswordNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureRegisterErrorCA;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureRegisterTYCPDPLog;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdateNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdatePasswordNotification;
import pe.com.intralot.loto.layer.model.pojo.PaymentPrizeProcedureUpdateTokenCard;
import pe.com.intralot.loto.layer.model.pojo.ProcedureErrorVisa;
import pe.com.intralot.loto.layer.model.pojo.ProcedureaApproveRequestVisa;
import pe.com.intralot.loto.layer.model.pojo.ProcedureaRefuseRequestAutomatic;

public interface PaymentPrizeDao {

	public PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes(Integer clientId) throws Exception;
	public List<PaymentPrizeProcedureHisPayment> getHisPayment(Integer clientId) throws Exception;
	public List<PaymentPrizeProcedureHisPayment> getHisPaymentByReangeDate(Integer clientId, String desde, String hasta) throws Exception;
	public List<PaymentPrizeProcedureGetTicketsPrizes> getTicketsPrizes(Integer clientId, Integer requestNumber) throws Exception;
	public List<PaymentPrizeProcedureGetTicketsPrizesOld> getTicketsPrizesOld(Integer clientId, String ticket) throws Exception;
	public List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> getTicketsPrizesDebitQR(Integer clientId, Integer requestNumber) throws Exception;
	public PaymentPrizeProcedureCreateRequest createRequest(String clientId, Double amount, String ip, String paymentType, String plataform, String imageDNI, String loadedImge) throws Exception;
	public Long generateTokenPurchaseNumber() throws Exception;
	public PaymentPrizeProcedureCreateRequestVisa createRequestVisa(String clientId, Double amount, String ip, String paymentType, String plataform, String cardToken, String cardNumber, String transactionId, String json, String imageDNI, String loadedImge, double comision) throws Exception;
	public PaymentPrizeProcedureGetResultEvalRulesVisa getResultEvalRulesVisa(Integer clientId, Double amountVisa) throws Exception;
	public PaymentPrizeProcedureGetResultEvalRulesAgora getResultEvalRulesAgora(Integer clientId, Double amountVisa) throws Exception;
	public PaymentPrizeProcedureGetResultEvalRulesCash getResultEvalRulesCash(Integer clientId, Double amountCash) throws Exception;
	public PaymentPrizeProcedureCreateRequestVisaAutomatic createRequestVisaAutomatic(String clientId, Double amount, String ip, String paymentType, String plataform, String cardToken, String cardNumber, String transactionId, String json, String imageDNI, String loadedImge, double comision) throws Exception;
	public ProcedureaApproveRequestVisa approveRequestVisa(Object[] values) throws Exception;
	public ProcedureaRefuseRequestAutomatic refuseRequestAutomatic(Object[] values) throws Exception;
	public PaymentPrizeProcedureCreateRequestAutomatic createRequestAutomatic(String clientId, Double amount, String ip, String paymentType, String plataform, String imageDNI, String loadedImge) throws Exception;
	public ProcedureErrorVisa errorVisa(Object[] values) throws Exception;
	public PaymentPrizeProcedureInBlackList inBlackList(Integer clientId) throws Exception;
	public PaymentPrizeProcedureEvalRulesAutomatic evalRulesAutomatic(Integer clientId) throws Exception;
	public PaymentPrizeProcedureEvalRulesAutomaticV2 evalRulesAutomaticV2(Integer clientId, String typePayment) throws Exception;
	public PaymentPrizeProcedureGetResultEvalRulesTrans getResultEvalRulesTrans(Integer clientId, Double amountTransferencia, String rango) throws Exception;
	public PaymentPrizeProcedureCreateRequestTransAutomatic createRequestTransAutomatic(String clientId, Double amountTransferencia, String ip, String typePaymentTransferencia, String plataform, String imgDNITransferencia, String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente) throws Exception;
	public PaymentPrizeProcedureCreateRequestTrans createRequestTrans(String clientId, Double amount, String ip, String typePayment, String plataform, String imgDNI, String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente, String rango, String tipo, String ticket, String gameId, Double prizeAmount, Double freeAmount) throws Exception;
	public PaymentPrizeProcedureCreateRequestTransV2 createRequestTransV2(String clientId, Double amount, String ip, String typePayment, String plataform, String imgDNI, String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente, String rango) throws Exception;
	public List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount(Integer clientId) throws Exception;
	public PaymentPrizeProcedureDeleteAccount deleteAccount(Integer clientId, String cuenta) throws Exception;
	public PaymentPrizeProcedureEvalPopupInformativo evalPopupInformativo(Integer clientId) throws Exception;
	public List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor(Integer clientId) throws Exception;
	public PaymentPrizeProcedureCreateRequestTrans createRequestTransPML(String clientId, Double amount, String ip,
			String typePayment, String plataform, String imgDNI, String loadedImage, String banco, String cuenta,
			String departamento, String idBanco, String guardarRecurrente, String ticketId) throws Exception;
	public List<PaymentPrizeProcedureGetNotifications> getNotifications(Integer clientId) throws Exception;
	
	public List<PaymentPrizeProcedureGetLastNotifications> getLastNotifications(Integer clientId) throws Exception;
	public PaymentPrizeProcedureHasPendingNotificationsRead hasPendingNotificationsRead(Integer clientId) throws Exception;
	public PaymentPrizeProcedureUpdateNotification updateNotification(Integer clientId, String idNotificacion) throws Exception;
	public TransactionPaymentRequestIp transactionRequestIp(String channel, String request, String clientId, String ip, String uuid, String medio, String amount);
	public TransactionPaymentCreatePin transactionCreatePin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String pin, String p_sms);
	public TransactionPaymentLogPin transactionLogPin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String mail, String result);
	public TransactionPaymentValidatePin transactionValidatePin(String channel, String request, String clientId, String ip, String uuid, String medio, String amount, String mail, String pin);
	public PaymentPrizeProcedureGetDataCookie getDataCookie() throws Exception;
	public PaymentPrizeProcedurePasswordNotification passwordNotification(Integer clientId) throws Exception;
	public PaymentPrizeProcedureUpdatePasswordNotification updatePasswordNotification(Integer clientId, String idNotificacion) throws Exception;
	public PaymentPrizeProcedureRegisterErrorCA registerErrorCA(Object[] values) throws Exception;
	public PaymentPrizeProcedureRegisterTYCPDPLog registerTYCPDPLog(Object[] values) throws Exception;
	public PaymentPrizeProcedureGetRequestByNumber getRequestByNumber(Object[] values) throws Exception;	
	public PaymentPrizeProcedureUpdateTokenCard updateTokenCard(Object[] values) throws Exception;
	public PaymentPrizeProcedureGetTokenCard getTokenCard(Object[] values) throws Exception;
	
	public PaymentPrizeProcedureDefineDebitQR defineDebitQR(Object[] values) throws Exception;
	public PaymentPrizeProcedureCreateRequestAutomaticDQR createRequestAutomaticDQR(Integer clientId, Double amount, String paymentType, String plataform, String imageDNI, String loadedImge, Double amountKiron, Double amountNeo, Integer debitIdQr, Integer balanceItemKiron, Integer balanceItemNeo) throws Exception;
}
