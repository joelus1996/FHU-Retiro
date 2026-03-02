package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZEPAYMENT_APPROVE_REQUEST_VISA",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.APPROVE_REQUEST_VISA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = ProcedureaApproveRequestVisa.class
		)
public class ProcedureaApproveRequestVisa {

	@Id
	@Column(name = "o_result")
	private String result;

	@Column(name = "o_message")
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
