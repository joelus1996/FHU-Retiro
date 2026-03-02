package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Renzo Jauregui Malpartida
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="CLIENTUPDATE_GETPASSWORDCODE",
		query="{ call LOTOCARD.CLIENTUPDATE.GETPASSWORDCODE(?,?,?)}",
		callable=true,
		resultClass=ClientProcedureGetPasswordCode.class
		)

public class ClientProcedureGetPasswordCode implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column(name="p_clientid")
	private Integer clientId;
	
	@Column(name="p_message")
	private String message;
	
	@Column(name="p_mail")
	private String mail;
	
	@Column(name="p_name")
	private String name;

	@Column(name="p_password_code")
	private String passwordCode;

	@Column(name="p_user")
	private String user;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordCode() {
		return passwordCode;
	}

	public void setPasswordCode(String passwordCode) {
		this.passwordCode = passwordCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
}
