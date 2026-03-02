package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_PROMO_FIRST_ACCOUNT",
		query = "{ call LOTOCARD.CLIENTSALE.PROMO_FIRST_ACCOUNT(?,?,?) }",
		callable = true,
		resultClass = PromoFirstAccount.class
)
public class PromoFirstAccount {
	@Id	
	@Column(name="cb_promotion_message")
	private String promotion_message;
	
	@Column(name="cb_promotion_eco")
	private String promotion_eco;

	public String getPromotion_message() {
		return promotion_message;
	}

	public void setPromotion_message(String promotion_message) {
		this.promotion_message = promotion_message;
	}

	public String getPromotion_eco() {
		return promotion_eco;
	}

	public void setPromotion_eco(String promotion_eco) {
		this.promotion_eco = promotion_eco;
	}
	
	
}
