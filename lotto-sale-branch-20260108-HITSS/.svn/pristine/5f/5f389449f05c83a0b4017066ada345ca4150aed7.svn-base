package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_PASSWORD_NOTIFICATION",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.PASSWORD_NOTIFICATION(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedurePasswordNotification.class
		)
public class PaymentPrizeProcedurePasswordNotification implements Serializable{
		
	private static final long serialVersionUID = 7817311708412947467L;

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_message")	
	private String message;

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
}
