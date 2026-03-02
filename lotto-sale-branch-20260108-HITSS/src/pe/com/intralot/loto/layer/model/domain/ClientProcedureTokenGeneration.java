package pe.com.intralot.loto.layer.model.domain;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_TOKENGENERATION", query = "{ call LOTOCARD.CLIENTSALE.TOKEN_GENERATION(?,?,?,?) }", callable = true, resultClass = ClientProcedureTokenGeneration.class)
public class ClientProcedureTokenGeneration {

    @Id
    @Column(name = "w_client_id")
    private String clientId;
    @Column(name = "w_iflex_token")
    private String iflexToken;
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
	public String getIflexToken() {
		return iflexToken;
	}
	public void setIflexToken(String iflexToken) {
		this.iflexToken = iflexToken;
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
