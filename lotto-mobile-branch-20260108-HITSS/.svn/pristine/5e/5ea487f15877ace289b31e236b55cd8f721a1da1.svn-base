package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "UPDATE_STATE_RECHARGE_AGORA",
		query = "{ call LOTOCARD.CLIENTSALE.UPDATESTATERECHARGEAGORA(?,?,?,?) }",
		callable = true,
		resultClass = ClientProcedureUpdateStateRechargeAgora.class
		)
public class ClientProcedureUpdateStateRechargeAgora {
	
	@Id
	@Column(name = "o_id")
	private String id;
	
	@Column(name="o_result")	
	private String result;
	
	@Column(name="o_message")	
	private String message;

	@Column(name="o_state_update_phone")	
	private String stateUpdatePhone;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getStateUpdatePhone() {
		return stateUpdatePhone;
	}

	public void setStateUpdatePhone(String stateUpdatePhone) {
		this.stateUpdatePhone = stateUpdatePhone;
	}
}
