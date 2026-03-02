package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_HAS_PENDING_NOTIFICATIONS_READ",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.HAS_PENDING_NOTIFICATIONS_READ(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureHasPendingNotificationsRead.class
		)
public class PaymentPrizeProcedureHasPendingNotificationsRead {
		
	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_pendientes")	
	private Integer pendientes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPendientes() {
		return pendientes;
	}

	public void setPendientes(Integer pendientes) {
		this.pendientes = pendientes;
	}
}
