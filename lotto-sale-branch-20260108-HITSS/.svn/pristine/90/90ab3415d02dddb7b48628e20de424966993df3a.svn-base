package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "YAPE_PLIN_TUPAY_VERIFY_TRANSACTION",
		query = "{ call lotocard.transactiontupay.verify_transaction(?,?,?) }",
		callable = true,
		resultClass = ProcedureYapePlinTupayVerifyTransaction.class
		)
public class ProcedureYapePlinTupayVerifyTransaction {

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name = "o_result")
	private String result;

	@Column(name = "o_message")
	private String message;

	@Column(name = "tt_status")
	private String status;
	
	@Column(name="tt_amount")
	private Double amount;
	
	@Column(name="cb_promotion_message")
	private String promotionMessage;
	
	@Column(name="cb_promotion_eco")
	private String promotionEco;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPromotionMessage() {
		return promotionMessage;
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}

	public String getPromotionEco() {
		return promotionEco;
	}

	public void setPromotionEco(String promotionEco) {
		this.promotionEco = promotionEco;
	}
}
