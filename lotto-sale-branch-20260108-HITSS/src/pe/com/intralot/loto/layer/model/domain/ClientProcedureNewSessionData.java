package pe.com.intralot.loto.layer.model.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_NEWSESSIONDATA",
		query = "{ call LOTOCARD.CLIENTSALE.NEW_SESSION_DATA(?,?,?,?) }",
		callable = true,
		resultClass = ClientProcedureNewSessionData.class
)

public class ClientProcedureNewSessionData {

	@Id
	@Column(name="w_message")
	private String message;
	
	@Column(name="w_date")
	private Date sessiondate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSessiondate() {
		return sessiondate;
	}

	public void setSessiondate(Date sessiondate) {
		this.sessiondate = sessiondate;
	}
	
}
