package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCESALE_GETBICOLORPROMOLISTTICKETSCLIENT", query = "{ call LOTOCARD.BALANCESALE.GETTICKETSCLIENTE(?,?) }", callable = true, resultClass = ListTicketBicolorClient.class)
public class ListTicketBicolorClient {
	
	@Id
    @Column(name = "TICKET_ID")
    private String ticketId;
       
    @Column(name = "CLIENT_ID")
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


