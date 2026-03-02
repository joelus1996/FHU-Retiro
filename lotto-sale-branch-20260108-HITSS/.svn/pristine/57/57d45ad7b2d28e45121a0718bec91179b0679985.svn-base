package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_REFUSE_REQUEST_AUTOMATIC",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.REFUSE_REQUEST_AUTOMATIC(?,?,?) }",
		callable = true,
		resultClass = ProcedureaRefuseRequestAutomatic.class
		)
public class ProcedureaRefuseRequestAutomatic {
	
	@Id
	@Column(name="o_rpp_request_number")	
	private Integer requestNumber;
	
	@Column(name="o_message")	
	private String message;
	
	@Column(name="o_state")	
	private Integer state;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
