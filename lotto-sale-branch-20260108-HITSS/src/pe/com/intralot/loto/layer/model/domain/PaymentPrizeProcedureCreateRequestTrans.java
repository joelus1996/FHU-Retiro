package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_CREATE_REQUEST_TRANS",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.CREATE_REQUEST_TRANS_v2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureCreateRequestTrans.class
		)
public class PaymentPrizeProcedureCreateRequestTrans {
	
	@Id
	@Column(name="s_message")	
	private String message;
	
	@Column(name="o_amount")	
	private Double amount;
	
	@Column(name="o_rpp_request_number")	
	private Integer requestNumber;
	
	@Column(name="o_days_elapsed_dni")	
	private Integer daysElapsedDni;

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

	public Integer getDaysElapsedDni() {
		return daysElapsedDni;
	}

	public void setDaysElapsedDni(Integer daysElapsedDni) {
		this.daysElapsedDni = daysElapsedDni;
	}
}
