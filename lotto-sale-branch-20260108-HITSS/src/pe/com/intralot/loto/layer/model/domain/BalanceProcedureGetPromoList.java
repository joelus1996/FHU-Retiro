package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCESALE_GETPROMOLIST", query = "{ call LOTOCARD.BALANCESALE.GETPROMOLIST2(?,?) }", callable = true, resultClass = BalanceProcedureGetPromoList.class)
public class BalanceProcedureGetPromoList {

    @Id
    @Column(name = "w_prom_id")
    private String promId;
    
    @Column(name = "w_status")
    private String status;
    
    @Column(name = "w_prom_date")
    private String promDate;
    
    @Column(name = "w_description")
    private String description;
    
    @Column(name = "w_prom_count")
    private String promCount;
    
    @Column(name = "w_state")
    private String state;

	public String getPromId() {
		return promId;
	}

	public void setPromId(String promId) {
		this.promId = promId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
