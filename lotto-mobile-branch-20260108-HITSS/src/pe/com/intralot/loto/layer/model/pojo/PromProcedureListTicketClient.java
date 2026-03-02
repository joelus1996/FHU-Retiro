package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "PROMSORTEO_GETLISTTICKETSCLIENT", query = "{ call LOTOCARD.PROMSORTEO.GETLISTTICKETSCLIENT(?,?,?) }", callable = true, resultClass = PromProcedureListTicketClient.class)
public class PromProcedureListTicketClient implements Serializable{
 
	private static final long serialVersionUID = 8010671709784397205L;

	@Id
    @Column(name = "PCT_TICKET_ID")
    private String ticketId;
       
    @Column(name = "PCT_CLIENT_ID")
    private String clientId;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
