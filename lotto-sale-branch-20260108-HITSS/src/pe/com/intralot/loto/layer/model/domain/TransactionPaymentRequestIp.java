package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "LOTOCARD_TRANSACTIONPAYMENTLOG_REQUESTIP",
		query = "{ call LOTOCARD.TRANSACTIONPAYMENTLOG.REQUESTIP(?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = TransactionPaymentRequestIp.class
		)
public class TransactionPaymentRequestIp {
		
	@Id
	@Column(name="o_id")	
	private String id;

	@Column(name="o_status")	
	private String status;

	@Column(name="o_message")	
	private String message;

	@Column(name="o_user_message")	
	private String usermessage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsermessage() {
		return usermessage;
	}

	public void setUsermessage(String usermessage) {
		this.usermessage = usermessage;
	}

	public String toString() {
		return "id="+id+" status="+status+" usermessage="+usermessage+" message="+message;
	}
}
