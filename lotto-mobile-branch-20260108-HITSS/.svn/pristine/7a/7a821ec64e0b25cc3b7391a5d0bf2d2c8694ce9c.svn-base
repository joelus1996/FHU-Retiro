package pe.com.intralot.loto.layer.model.pojo;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "VIRTUALSPORTSWS_LOGIN", query = "{ call LOTOCARD.VIRTUALSPORTSWS.LOGIN(?,?) }", callable = true, resultClass = ClientProcedureDDVVTokenLogin.class)
public class ClientProcedureDDVVTokenLogin {

    @Id
    @Column(name = "w_player_id")
    private String clientId;
    @Column(name = "w_session_id")
    private String token;
    @Column(name = "w_error_status")
    private String message;
    
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
