package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_CREATE_REQUEST_AUTOMATIC",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.CREATE_REQUEST_AUTOMATIC(?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureCreateRequestAutomatic.class
		)
public class PaymentPrizeProcedureCreateRequestAutomatic {
	
	@Id
	@Column(name="s_message")	
	private String message;
	
	@Column(name="o_amount")	
	private Double amount;
	
	@Column(name="o_rpp_request_number")	
	private Integer requestNumber;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}
}
