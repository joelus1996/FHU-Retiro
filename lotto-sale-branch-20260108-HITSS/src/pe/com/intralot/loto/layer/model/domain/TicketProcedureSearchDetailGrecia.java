package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "SEARCH_DETAIL_GRECIA", query = "{ call LOTOCARD.TICKETSALE.SEARCH_DETAIL_GRECIA(?,?,?) }", callable = true, resultClass = TicketProcedureSearchDetailGrecia.class)
public class TicketProcedureSearchDetailGrecia {

	@Id
	@Column(name = "o_id")
	private String id;
	
	@Column(name = "o_found")
	private String found;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getFound() {
		return found;
	}

	public void setFound(String found) {
		this.found = found;
	}

   
}