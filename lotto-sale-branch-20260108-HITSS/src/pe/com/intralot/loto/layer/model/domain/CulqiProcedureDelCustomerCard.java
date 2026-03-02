package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "TRANSACTIONCULQI_DELCUSTOMERCARD",
		query = "{ call LOTOCARD.TRANSACTIONCULQI.DELCUSTOMERCARD(?,?,?) }",
		callable = true,
		resultClass = CulqiProcedureDelCustomerCard.class
)
public class CulqiProcedureDelCustomerCard {
	
	@Id	
	@Column(name="w_message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
