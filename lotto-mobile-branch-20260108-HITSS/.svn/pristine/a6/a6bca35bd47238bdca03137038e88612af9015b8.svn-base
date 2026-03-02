package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_RESULT_EVAL_RULES_AGORA",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_RESULT_EVAL_RULES_AGORA(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetResultEvalRulesAgora.class
		)
public class PaymentPrizeProcedureGetResultEvalRulesAgora {
	
	@Id
	@Column(name = "o_id")
	private String id;
	
	@Column(name="o_result")	
	private String result;
	
	@Column(name="o_message")	
	private String message;
	
	@Column(name="o_clean")	
	private String clean;
	
	@Column(name="o_acc_amt_agora")	
	private Integer accAmtAgora;

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

	public String getClean() {
		return clean;
	}

	public void setClean(String clean) {
		this.clean = clean;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAccAmtAgora() {
		return accAmtAgora;
	}

	public void setAccAmtAgora(Integer accAmtAgora) {
		this.accAmtAgora = accAmtAgora;
	}
}
