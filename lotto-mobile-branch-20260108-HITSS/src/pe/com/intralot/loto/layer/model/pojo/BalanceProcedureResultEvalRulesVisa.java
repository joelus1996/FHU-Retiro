package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "BALANCESALE_RESULT_EVAL_RULES_VISA",
		query = "{ call LOTOCARD.BALANCESALE.RESULT_EVAL_RULES_VISA(?,?,?) }",
		callable = true,
		resultClass = BalanceProcedureResultEvalRulesVisa.class
		)
public class BalanceProcedureResultEvalRulesVisa {
	
	@Id
	@Column(name = "o_id")
	private String id;
	
	@Column(name="o_result")	
	private String result;
	
	@Column(name="o_message")	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
