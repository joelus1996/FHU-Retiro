package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Victor Farro Veramendi
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
		name="CLIENTSALE_GETNEWCODE",
		query="{ call LOTOCARD.CLIENTSALE.GETNEWCODE(?,?)}",
		callable=true,
		resultClass=ClientProcedureGetNewCode.class
		)
public class ClientProcedureGetNewCode implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column(name="p_clientid")
	private Integer clientId;
	
	@Column(name="p_mail_code")
	private String mailCode;
	
	@Column(name="p_message")
	private String message;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getMailCode() {
		return mailCode;
	}

	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
