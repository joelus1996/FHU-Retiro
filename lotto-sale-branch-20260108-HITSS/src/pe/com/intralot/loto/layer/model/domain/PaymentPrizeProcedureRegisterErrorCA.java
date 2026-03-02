package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_REGISTER_ERROR_CA",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.REGISTER_ERROR_CA(?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureRegisterErrorCA.class
		)
public class PaymentPrizeProcedureRegisterErrorCA {

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_message")	
	private String message;
	
	@Column(name="o_state")	
	private String state;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
