package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_DELETE_ACCOUNT",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.DELETE_ACCOUNT(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureDeleteAccount.class
		)
public class PaymentPrizeProcedureDeleteAccount {
	
	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_message")	
	private String message;

	@Column(name="o_result")	
	private String result;

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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}