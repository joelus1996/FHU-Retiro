package pe.com.intralot.loto.layer.model.pojo;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import com.google.gson.Gson;

@Entity
@NamedNativeQuery(name = "RECARGAWEB_ORIGINVISARECHARGE", query = "{ call LOTOCARD.RECARGAWEB.ORIGINVISARECHARGE(?,?,?,?,?,?) }", callable = true, resultClass = ClientProcedureOriginVisaRecharge.class)
public class ClientProcedureOriginVisaRecharge {

    @Id
    @Column(name = "w_transaction_id")
    private String transactionId;
    @Column(name = "w_message")
    private String message;
    @Column(name = "w_status")
    private String status;    
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
		
	@Override
    public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
    }

}
