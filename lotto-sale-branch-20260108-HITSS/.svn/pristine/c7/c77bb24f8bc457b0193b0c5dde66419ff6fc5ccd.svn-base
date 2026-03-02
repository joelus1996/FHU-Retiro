package pe.com.intralot.loto.layer.model.domain;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "VIRTUALSPORTSWS_TOKENGENERATION", query = "{ call LOTOCARD.VIRTUALSPORTSWS.TOKENGENERATION(?,?,?,?) }", callable = true, resultClass = ClientProcedureDDVVTokenGeneration.class)
public class ClientProcedureDDVVTokenGeneration {

    @Id
    @Column(name = "w_client_id")
    private String clientId;
    @Column(name = "w_token")
    private String token;
    @Column(name = "w_channel")
    private Integer channel;
    @Column(name = "w_message")
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
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
