package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_CREATE_REQUEST_AUTOMATIC_DQR",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.CREATE_REQUEST_AUTOMATIC_DQR(?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureCreateRequestAutomaticDQR.class
		)
public class PaymentPrizeProcedureCreateRequestAutomaticDQR implements Serializable{
	
	private static final long serialVersionUID = -7362827944676397561L;

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_message")	
	private String message;
	
	@Column(name="o_rpp_request_number")	
	private Integer requestNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}
}
