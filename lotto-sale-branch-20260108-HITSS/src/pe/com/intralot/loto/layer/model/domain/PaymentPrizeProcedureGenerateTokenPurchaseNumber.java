package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GENERATE_TOKEN_PURCHASE_NUMBER",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GENERATE_TOKEN_PURCHASE_NUMBER(?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGenerateTokenPurchaseNumber.class
		)
public class PaymentPrizeProcedureGenerateTokenPurchaseNumber implements Serializable{
	
	private static final long serialVersionUID = -8860042588459981808L;
	@Id
	@Column(name="o_token_purchase_number")	
	private Long tokenPurchaseNumber;

	public Long getTokenPurchaseNumber() {
		return tokenPurchaseNumber;
	}

	public void setTokenPurchaseNumber(Long tokenPurchaseNumber) {
		this.tokenPurchaseNumber = tokenPurchaseNumber;
	}
}
