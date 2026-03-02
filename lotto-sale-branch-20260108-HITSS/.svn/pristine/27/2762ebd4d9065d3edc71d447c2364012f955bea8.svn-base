package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENT_UPDATE_CLOSED_SESSION",
		query = "{ call LOTOCARD.CLIENTUPDATE.CLOSEDSESSION(?,?) }",
		callable = true,
		resultClass = ClientUpdateProcedureClosedSession.class
		)
public class ClientUpdateProcedureClosedSession implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7149855692375666026L;

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