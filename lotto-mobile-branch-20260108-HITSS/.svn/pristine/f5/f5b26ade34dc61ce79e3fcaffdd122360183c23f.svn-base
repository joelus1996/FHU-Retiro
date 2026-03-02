package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_TOKEN_CARD",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_TOKEN_CARD(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetTokenCard.class
		)
public class PaymentPrizeProcedureGetTokenCard {
	
	@Id
	@Column(name="o_client_id")	
	private Integer clientId;
	
	@Column(name="o_visa_token_response")	
	private String visaTokenResponse;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getVisaTokenResponse() {
		return visaTokenResponse;
	}

	public void setVisaTokenResponse(String visaTokenResponse) {
		this.visaTokenResponse = visaTokenResponse;
	}
}