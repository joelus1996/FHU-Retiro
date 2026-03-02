package pe.com.intralot.loto.layer.service.client.boimpl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequest;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestAutomaticDQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTrans;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestTransAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisa;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureCreateRequestVisaAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDefineDebitQR;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureDeleteAccount;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalPopupInformativo;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomatic;
import pe.com.intralot.loto.layer.model.domain.PaymentPrizeProcedureEvalRulesAutomaticV2;
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
import pe.com.intralot.loto.layer.model.domain.ProcedureErrorVisa;
import pe.com.intralot.loto.layer.model.domain.ProcedureaApproveRequestVisa;
import pe.com.intralot.loto.layer.model.domain.ProcedureaRefuseRequestAutomatic;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentCreatePin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentLogPin;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentRequestIp;
import pe.com.intralot.loto.layer.model.domain.TransactionPaymentValidatePin;
import pe.com.intralot.loto.layer.model.persistence.dao.PaymentPrizeDao;
import pe.com.intralot.loto.layer.service.client.bo.PaymentPrizeBo;

@Service
public class PaymentPrizeBoImpl implements PaymentPrizeBo{

	@Autowired
	PaymentPrizeDao paymentPrizeDao;
	
	@Override
	public PaymentPrizeProcedureGetDataCollectPrizes getDataCollectPrizes(Integer clientId) throws Exception {
		return paymentPrizeDao.getDataCollectPrizes(clientId);
	}

	@Override
	public List<PaymentPrizeProcedureHisPayment> getHisPayment(Integer clientId) throws Exception {
		return paymentPrizeDao.getHisPayment(clientId);
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizes> getTicketsPrizes(Integer clientId, Integer requestNumber)
			throws Exception {
		return paymentPrizeDao.getTicketsPrizes(clientId, requestNumber);
	}

	@Override
	public PaymentPrizeProcedureCreateRequest createRequest(String clientId, Double amount, String ip, String paymentType, String plataform, String imageDNI, String loadedImge)
			throws Exception {
		return paymentPrizeDao.createRequest(clientId, amount, ip, paymentType, plataform, imageDNI, loadedImge);
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizesOld> getTicketsPrizesOld(Integer clientId, String ticket)
			throws Exception {
		return paymentPrizeDao.getTicketsPrizesOld(clientId, ticket);
	}

	@Override
	public List<PaymentPrizeProcedureHisPayment> getHisPaymentByReangeDate(Integer clientId, String desde, String hasta)
			throws Exception {
		return paymentPrizeDao.getHisPaymentByReangeDate(clientId, desde, hasta);
	}
	
	@Override
	public Long generateTokenPurchaseNumber() throws Exception {
		return paymentPrizeDao.generateTokenPurchaseNumber();
	}

	@Override
	public PaymentPrizeProcedureCreateRequestVisa createRequestVisa(String clientId, Double amount, String ip,
			String paymentType, String plataform, String cardToken, String cardNumber, String transactionId,
			String json, String imageDNI, String loadedImge, double comision) throws Exception {
		return paymentPrizeDao.createRequestVisa(clientId, amount, ip, paymentType, plataform, cardToken, cardNumber, transactionId, json, imageDNI, loadedImge, comision);
	}

	@Override
	public PaymentPrizeProcedureGetResultEvalRulesVisa getResultEvalRulesVisa(Integer clientId, Double amountVisa) throws Exception {
		return paymentPrizeDao.getResultEvalRulesVisa(clientId, amountVisa);
	}

	@Override
	public PaymentPrizeProcedureCreateRequestVisaAutomatic createRequestVisaAutomatic(String clientId, Double amount,
			String ip, String paymentType, String plataform, String cardToken, String cardNumber, String transactionId,
			String json, String imageDNI, String loadedImge, double comision) throws Exception {
		return paymentPrizeDao.createRequestVisaAutomatic(clientId, amount, ip, paymentType, plataform, cardToken, cardNumber, transactionId, json, imageDNI, loadedImge, comision);
	}

	@Override
	public ProcedureaApproveRequestVisa approveRequestVisa(Object[] values) throws Exception {
		return paymentPrizeDao.approveRequestVisa(values);
	}

	@Override
	public ProcedureaRefuseRequestAutomatic refuseRequestAutomatic(Object[] values) throws Exception {
		return paymentPrizeDao.refuseRequestAutomatic(values);
	}

	@Override
	public PaymentPrizeProcedureCreateRequestAutomatic createRequestAutomatic(String clientId, Double amount, String ip,
			String paymentType, String plataform, String imageDNI, String loadedImge) throws Exception {
		return paymentPrizeDao.createRequestAutomatic(clientId, amount, ip, paymentType, plataform, imageDNI, loadedImge);
	}
	
	@Override
	public PaymentPrizeProcedureGetResultEvalRulesCash getResultEvalRulesCash(Integer clientId, Double amountCash)
			throws Exception {
		return paymentPrizeDao.getResultEvalRulesCash(clientId, amountCash);
	}

	@Override
	public ProcedureErrorVisa errorVisa(Object[] values) throws Exception {
		return paymentPrizeDao.errorVisa(values);
	}
	
	@Override
	public PaymentPrizeProcedureGetResultEvalRulesAgora getResultEvalRulesAgora(Integer clientId, Double amountVisa)
			throws Exception {
		return paymentPrizeDao.getResultEvalRulesAgora(clientId, amountVisa);
	}

	@Override
	public PaymentPrizeProcedureInBlackList inBlackList(Integer clientId) throws Exception {
		return paymentPrizeDao.inBlackList(clientId);
	}

	@Override
	public PaymentPrizeProcedureEvalRulesAutomatic evalRulesAutomatic(Integer clientId) throws Exception {
		return paymentPrizeDao.evalRulesAutomatic(clientId);
	}
	
	@Override
	public PaymentPrizeProcedureEvalRulesAutomaticV2 evalRulesAutomaticV2(Integer clientId, String typePayment) throws Exception {
		return paymentPrizeDao.evalRulesAutomaticV2(clientId, typePayment);
	}
	
	@Override
	public PaymentPrizeProcedureGetResultEvalRulesTrans getResultEvalRulesTrans(Integer clientId,
			Double amountTransferencia, String rango) throws Exception {
		return paymentPrizeDao.getResultEvalRulesTrans(clientId,amountTransferencia, rango);
	}

	@Override
	public PaymentPrizeProcedureCreateRequestTransAutomatic createRequestTransAutomatic(String clientId, Double amountTransferencia, String ip, 
			String typePaymentTransferencia, String plataform, String imgDNITransferencia, String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente) throws Exception {
		return paymentPrizeDao.createRequestTransAutomatic(clientId, amountTransferencia, ip, typePaymentTransferencia, plataform, imgDNITransferencia, loadedImage, banco, cuenta, departamento,idBanco,guardarRecurrente);
	}

	@Override
	public PaymentPrizeProcedureCreateRequestTrans createRequestTrans(String clientId, BigDecimal amount, String ip, String typePayment, String plataform, String imgDNI, 
			String loadedImage, String banco, String cuenta, String departamento, String idBanco, String guardarRecurrente, String rango, String tipo, String ticket, String gameId, Double prizeAmount, Double freeAmount) throws Exception {
		return paymentPrizeDao.createRequestTrans(clientId, amount, ip, typePayment, plataform, imgDNI, loadedImage, banco, cuenta, departamento,idBanco, guardarRecurrente, rango, tipo, ticket, gameId,prizeAmount,freeAmount);
	}
	
	@Override
	public List<PaymentPrizeProcedureGetSavingsAccount> getSavingsAccount(Integer clientId) throws Exception {
		return paymentPrizeDao.getSavingsAccount(clientId);
	}

	@Override
	public PaymentPrizeProcedureDeleteAccount deleteAccount(Integer clientId, String cuenta) throws Exception {
		return paymentPrizeDao.deleteAccount(clientId, cuenta);
	}

	@Override
	public PaymentPrizeProcedureEvalPopupInformativo evalPopupInformativo(Integer clientId) throws Exception {
		return paymentPrizeDao.evalPopupInformativo(clientId);
	}

	@Override
	public List<PaymentPrizeProcedureListPrizesMajor> listPrizesMajor(Integer clientId) throws Exception {
		return paymentPrizeDao.listPrizesMajor(clientId);
	}

	@Override
	public List<PaymentPrizeProcedureGetNotifications> getNotifications(Integer clientId) throws Exception {
		return paymentPrizeDao.getNotifications(clientId);
	}
	
	@Override
	public List<PaymentPrizeProcedureGetLastNotifications> getLastNotifications(Integer clientId) throws Exception {
		return paymentPrizeDao.getLastNotifications(clientId);
	}

	@Override
	public PaymentPrizeProcedureHasPendingNotificationsRead hasPendingNotificationsRead(Integer clientId)
			throws Exception {
		return paymentPrizeDao.hasPendingNotificationsRead(clientId);
	}

	@Override
	public PaymentPrizeProcedureUpdateNotification updateNotification(Integer clientId, String idNotificacion)
			throws Exception {
		return paymentPrizeDao.updateNotification(clientId, idNotificacion);
	}

	@Override
	public TransactionPaymentRequestIp transactionRequestIp(String channel, String request, String clientId, String ip, String uuid, String medio, String amount)
	{
		return paymentPrizeDao.transactionRequestIp(channel, request, clientId, ip, uuid, medio, amount);
	}

	@Override
	public TransactionPaymentCreatePin transactionCreatePin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String pin, String p_sms)
	{
		return paymentPrizeDao.transactionCreatePin(channel, request, clientId, ip, pinuuid, medio, amount, pin, p_sms);
	}

	@Override
	public TransactionPaymentLogPin transactionLogPin(String channel, String request, String clientId, String ip, String pinuuid, String medio, String amount, String status, String result)
	{
		return paymentPrizeDao.transactionLogPin(channel, request, clientId, ip, pinuuid, medio, amount, status, result);
	}
	
	@Override
	public TransactionPaymentValidatePin transactionValidatePin(String channel, String request, String clientId, String ip, String uuid, String medio, String amount, String mail, String pin)
	{
		return paymentPrizeDao.transactionValidatePin(channel, request, clientId, ip, uuid, medio, amount, mail, pin);
	}

	@Override
	public PaymentPrizeProcedureGetDataCookie getDataCookie() throws Exception {
		return paymentPrizeDao.getDataCookie();
	}
	
	@Override
	public PaymentPrizeProcedurePasswordNotification passwordNotification(Integer clientId) throws Exception {
		return paymentPrizeDao.passwordNotification(clientId);
	}
	
	@Override
	public PaymentPrizeProcedureUpdatePasswordNotification updatePasswordNotification(Integer clientId, String idNotificacion)
			throws Exception {
		return paymentPrizeDao.updatePasswordNotification(clientId, idNotificacion);
	}

	@Override
	public PaymentPrizeProcedureRegisterErrorCA registerErrorCA(Object[] values) throws Exception {
		return paymentPrizeDao.registerErrorCA(values);
	}

	@Override
	public PaymentPrizeProcedureRegisterTYCPDPLog registerTYCPDPLog(Object[] values) throws Exception {
		return paymentPrizeDao.registerTYCPDPLog(values);
	}

	@Override
	public List<PaymentPrizeProcedureGetTicketsPrizesDebitQR> getTicketsPrizesDebitQR(Integer clientId,
			Integer requestNumber) throws Exception {
		return paymentPrizeDao.getTicketsPrizesDebitQR(clientId, requestNumber);
	}

	@Override
	public PaymentPrizeProcedureDefineDebitQR defineDebitQR(Object[] values) throws Exception {
		return paymentPrizeDao.defineDebitQR(values);
	}

	@Override
	public PaymentPrizeProcedureCreateRequestAutomaticDQR createRequestAutomaticDQR(Integer clientId, Double amount,
			String paymentType, String plataform, String imageDNI, String loadedImge, Double amountKiron,
			Double amountNeo, Integer debitIQr, Integer balanceItemKiron, Integer balanceItemNeo) throws Exception {
		return paymentPrizeDao.createRequestAutomaticDQR(clientId, amount, paymentType, plataform, imageDNI, loadedImge, amountKiron, amountNeo, debitIQr, balanceItemKiron, balanceItemNeo);
	}
}
