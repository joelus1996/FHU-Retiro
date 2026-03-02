package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZEPAYMENT_GET_HISTORY_PAYMENT",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_HISTORY_PAYMENT(?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureHisPayment.class
		)
public class PaymentPrizeProcedureHisPayment {
	
	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_request_date")	
	private String requestDate;
	
	@Column(name="o_payment_type")	
	private String paymentType;
	
	@Column(name="o_request_amount")	
	private String requestAmount;
	
	@Column(name="o_request_state")	
	private String requestState;
	
	@Column(name="o_cash_date")	
	private String cashDate;
	
	@Column(name="o_prize")	
	private String prize;
	
	@Column(name="o_status")	
	private String status;
	
	@Column(name="o_comments")	
	private String comments;
	
	@Column(name="o_request_number")	
	private Integer requestNumber;
	
	@Column(name="o_request_date_hour")	
	private String requestDateHour;
	
	@Column(name="o_doc_number")	
	private String docNumber;
	
	@Column(name="o_version")	
	private String version;

	@Column(name="o_card_number")	
	private String cardNumber;
	
	@Column(name="o_id_bank")	
	private String idBank;
	
	@Column(name="o_account_number")	
	private String accountNumber;

	@Column(name="o_transfer_type")	
	private String transferType;
	
	@Column(name="o_bank")	
	private String bank;
	
	@Column(name="o_request_number_format")	
	private String requestNumberFormat;
	
	@Column(name="o_game")	
	private String game;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequestState() {
		return requestState;
	}

	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	public String getCashDate() {
		return cashDate;
	}

	public void setCashDate(String cashDate) {
		this.cashDate = cashDate;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getRequestDateHour() {
		return requestDateHour;
	}

	public void setRequestDateHour(String requestDateHour) {
		this.requestDateHour = requestDateHour;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIdBank() {
		return idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getRequestNumberFormat() {
		return requestNumberFormat;
	}

	public void setRequestNumberFormat(String requestNumberFormat) {
		this.requestNumberFormat = requestNumberFormat;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}	
	
	
}
