package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "PROMSORTEO_GETTICKETSCLIENT", query = "{ call LOTOCARD.PROMSORTEO.GETTICKETSCLIENT(?,?,?) }", callable = true, resultClass = PromProcedureGetTicketsClient.class)
public class PromProcedureGetTicketsClient implements Serializable {
	 
	private static final long serialVersionUID = -7239080604577883210L;

	@Id
    @Column(name = "promo_id")
    private String promId;
       
    @Column(name = "promo_date")
    private String promDate;
    
    @Column(name = "promo_description")
    private String description;
    
    @Column(name = "promo_count")
    private String promCount;

	public String getPromId() {
		return promId;
	}

	public void setPromId(String promId) {
		this.promId = promId;
	}

	public String getPromDate() {
		return promDate;
	}

	public void setPromDate(String promDate) {
		this.promDate = promDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPromCount() {
		return promCount;
	}

	public void setPromCount(String promCount) {
		this.promCount = promCount;
	}

}
