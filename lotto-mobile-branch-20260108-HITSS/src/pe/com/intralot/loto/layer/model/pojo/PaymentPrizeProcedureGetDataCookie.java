package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_DATA_BANNER_COOKIE",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_DATA_BANNER_COOKIE(?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetDataCookie.class
		)
public class PaymentPrizeProcedureGetDataCookie implements Serializable{
	
	private static final long serialVersionUID = 1187489054157100539L;

	@Id
	@Column(name="o_id")
	private String id;
	
	@Column(name="o_state_banner_cookie_modal")	
	private String stateBannerCookieModal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateBannerCookieModal() {
		return stateBannerCookieModal;
	}

	public void setStateBannerCookieModal(String stateBannerCookieModal) {
		this.stateBannerCookieModal = stateBannerCookieModal;
	}	
}
