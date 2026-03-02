package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NamedNativeQuery;

import com.google.gson.Gson;

@Entity
@NamedNativeQuery(name = "RECARGAWEB_TOKENVALIDATION", query = "{ call LOTOCARD.RECARGAWEB.TOKENVALIDATION(?,?,?) }", callable = true, resultClass = ClientProcedureTokenValidation.class)
public class ClientProcedureTokenValidation {

    @Id
    @Column(name = "w_client_id")
    private String clientId;
    @Column(name = "w_token")
    private String rechargeToken;
    @Column(name = "w_message")
    private String message;
    @Column(name = "w_status")
    private String status;
    @Column(name = "w_operator_id")
    private String operatorId;
    
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getRechargeToken() {
		return rechargeToken;
	}
	public void setRechargeToken(String tav2Token) {
		this.rechargeToken = tav2Token;
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
	
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	@Override
    public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
    }

}
