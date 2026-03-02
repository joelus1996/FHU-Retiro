package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_UPDATE_NOTIFICATION",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.UPDATE_NOTIFICATION(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureUpdateNotification.class
		)
public class PaymentPrizeProcedureUpdateNotification {
		
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
