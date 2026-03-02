package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "TRANSACTIONCULQI_DEFINETRANSACTION",
		query = "{ call LOTOCARD.TRANSACTIONCULQI.DEFINETRANSACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = CulqiProcedureDefineTransaction.class
)
public class CulqiProcedureDefineTransaction {
	
	@Id	
	@Column(name="w_transaction_id")
	private String transactionId;
	
	@Column(name="w_session_id")
	private String sessionId;
	
	@Column(name="w_message")
	private String message;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
