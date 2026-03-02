package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "LOTOCARD_TRANSACTIONPAYMENTLOG_VALIDATEPIN",
		query = "{ call LOTOCARD.TRANSACTIONPAYMENTLOG.VALIDATEPIN(?,?,?,?,?, ?,?,?,?,?) }",
		callable = true,
		resultClass = TransactionPaymentValidatePin.class
		)
public class TransactionPaymentValidatePin {
		
	@Id
	@Column(name="o_id")	
	private String id;

	@Column(name="o_status")	
	private String status;

	@Column(name="o_message")	
	private String message;

	@Column(name="o_mensajeerror")	
	private String mensajeError;

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

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeerror(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String toString() {
		return "id="+id+" status="+status+" mensajeError="+mensajeError+" message="+message;
	}
}
