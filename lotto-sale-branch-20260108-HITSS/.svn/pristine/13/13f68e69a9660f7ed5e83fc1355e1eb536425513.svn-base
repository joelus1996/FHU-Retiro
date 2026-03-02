package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_CREATE_REQUEST_VISA",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.CREATE_REQUEST_VISA(?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureCreateRequestVisa.class
		)
public class PaymentPrizeProcedureCreateRequestVisa implements Serializable{
	
	private static final long serialVersionUID = -8292077414917473104L;

	@Id
	@Column(name="s_message")	
	private String message;
	
	@Column(name="o_amount")	
	private Double amount;
	
	@Column(name="o_rpp_request_number")	
	private Integer requestNumber;

	@Column(name="o_new_saldo_liquidable")	
	private Double newSaldoLiquidable;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public Double getNewSaldoLiquidable() {
		return newSaldoLiquidable;
	}

	public void setNewSaldoLiquidable(Double newSaldoLiquidable) {
		this.newSaldoLiquidable = newSaldoLiquidable;
	}
}
