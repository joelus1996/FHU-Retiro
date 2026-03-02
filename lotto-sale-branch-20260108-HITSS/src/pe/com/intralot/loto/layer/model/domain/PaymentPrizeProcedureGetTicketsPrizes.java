package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZEPAYMENT_GET_TICKETS_PRIZES",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_TICKETS_PRIZES(?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetTicketsPrizes.class
		)
public class PaymentPrizeProcedureGetTicketsPrizes implements Serializable{
	
	private static final long serialVersionUID = -8109946026775720655L;

	@Id
	@Column(name="o_id")	
	private Integer id;
	
	@Column(name="o_prize")	
	private String prize;
	
	@Column(name="o_status")	
	private String status;
	
	@Column(name="o_barcode")	
	private String barcode;
	
	@Column(name="o_val_printed")	
	private String valPrinted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getValPrinted() {
		return valPrinted;
	}

	public void setValPrinted(String valPrinted) {
		this.valPrinted = valPrinted;
	}
}
