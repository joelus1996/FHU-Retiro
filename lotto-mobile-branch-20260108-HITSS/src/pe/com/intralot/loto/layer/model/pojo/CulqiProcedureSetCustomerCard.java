package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "TRANSACTIONCULQI_SETCUSTOMERCARD",
		query = "{ call LOTOCARD.TRANSACTIONCULQI.SETCUSTOMERCARD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = CulqiProcedureSetCustomerCard.class
)
public class CulqiProcedureSetCustomerCard {
	
	@Id	
	@Column(name="w_item_id")
	private String itemId;
	
	@Column(name="w_message")
	private String message;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
