package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "PROMSORTEO_GETFLAGCLIENT", query = "{ call LOTOCARD.PROMSORTEO.GETFLAGCLIENT(?,?,?) }", callable = true, resultClass = PromProcedureGetFlagClient.class)
public class PromProcedureGetFlagClient implements Serializable {
	 
	private static final long serialVersionUID = 375800277059284150L;
	
	@Id
	@Column(name = "p_state")
    private Integer state;
	@Column(name = "p_flagClient")
    private String flagClient;
    @Column(name = "p_message")
    private String message;
	public Integer getState() {
		return state;
	}
	public Boolean isFlagClient() {
		return Boolean.parseBoolean(this.flagClient);
	}
	public String getFlagClient() {
		return flagClient;
	}

	public void setFlagClient(String flagClient) {
		this.flagClient = flagClient;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
}