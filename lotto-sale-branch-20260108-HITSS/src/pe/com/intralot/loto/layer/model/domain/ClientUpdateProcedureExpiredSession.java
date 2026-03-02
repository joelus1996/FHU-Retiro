package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENT_UPDATE_EXPIRED_SESSION",
		query = "{ call LOTOCARD.CLIENTUPDATE.EXPIREDSESSION(?,?) }",
		callable = true,
		resultClass = ClientUpdateProcedureExpiredSession.class
		)
public class ClientUpdateProcedureExpiredSession implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9066267433220017541L;

	@Id
	@Column(name="o_id")	
	private String id;
    
    @Column(name="o_state")	
	private String state;

	@Column(name="o_message")	
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
}