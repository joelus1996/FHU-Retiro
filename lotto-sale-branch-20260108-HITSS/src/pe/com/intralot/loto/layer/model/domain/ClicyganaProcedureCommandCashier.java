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
		name = "CLICYGANASALE_COMMANDCASHIER",
		query = "{call LOTOCARD.CLICYGANASALE.COMMANDCASHIER(?,?)}",
		callable = true,
		resultClass = ClicyganaProcedureCommandCashier.class)
public class ClicyganaProcedureCommandCashier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="s_message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
