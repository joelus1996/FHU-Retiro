package pe.com.intralot.loto.layer.model.pojo;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "LAPOLLAWS_TOKENGENERATION", query = "{ call LOTOCARD.LAPOLLAWS.TOKENGENERATION(?,?,?) }", callable = true, resultClass = ClientProcedureLPTokenGeneration.class)
public class ClientProcedureLPTokenGeneration {

    @Id
    @Column(name = "w_client_id")
    private String clientId;
    @Column(name = "w_token")
    private String lapollaToken;
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
	public String getLapollaToken() {
		return lapollaToken;
	}
	public void setLapollaToken(String lapollaToken) {
		this.lapollaToken = lapollaToken;
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
