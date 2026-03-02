package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Cristian Cortez
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
		name="CLIENTSALE_UPDATEAGREEMENT",
		query="{ call LOTOCARD.CLIENTSALE.UPDATEAGREEMENT(?,?)}",
		callable=true,
		resultClass=ClientProcedureUpdateAgreement.class
		)
public class ClientProcedureUpdateAgreement implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column(name="p_clientid")
	private Integer clientId;
	
	@Column(name="p_message")
	private String message;

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

}
