package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZEPAYMENT_GET_TICKETS_PRIZES_DEBITQR",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_TICKETS_PRIZES_DEBITQR(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetTicketsPrizesDebitQR.class
		)
public class PaymentPrizeProcedureGetTicketsPrizesDebitQR implements Serializable{
	
	private static final long serialVersionUID = 8448604095359893164L;

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_prize")	
	private String prize;
	
	@Column(name="o_status")	
	private String status;
	
	@Column(name="o_barcode")	
	private String barcode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
