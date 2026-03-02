package pe.com.intralot.loto.layer.model.pojo;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "TEAPUESTOIFLEXMOBILE_TOKENGENERATION", query = "{ call LOTOCARD.TEAPUESTOIFLEXMOBILE.TOKENGENERATION(?,?,?) }", callable = true, resultClass = ClientProcedureTANTokenGeneration.class)
public class ClientProcedureTANTokenGeneration {

    @Id
    @Column(name = "w_client_id")
    private String clientId;
    @Column(name = "w_token")
    private String tav2Token;
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
	public String getTav2Token() {
		return tav2Token;
	}
	public void setTav2Token(String tav2Token) {
		this.tav2Token = tav2Token;
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
