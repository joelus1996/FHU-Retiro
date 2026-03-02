package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_UPDATECLIENTPROMO", query = "{ call LOTOCARD.CLIENTSALE.UPDATECLIENTPROMO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }", callable = true, resultClass = ClientProcedureUpdatePromo.class)

public class ClientProcedureUpdatePromo {

	@Id
	@Column(name="p_message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
