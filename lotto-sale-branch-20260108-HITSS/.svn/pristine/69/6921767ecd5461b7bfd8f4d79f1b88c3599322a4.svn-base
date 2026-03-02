package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_DEFINE_DEBITQR",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.DEFINE_DEBITQR(?,?,?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureDefineDebitQR.class
		)
public class PaymentPrizeProcedureDefineDebitQR implements Serializable{
	
	private static final long serialVersionUID = -3893759096331373973L;

	@Id
	@Column(name="o_id")	
	private String id;

	@Column(name="o_message")	
	private String message;
	
	@Column(name="o_state")	
	private String state;
		
	@Column(name="o_debit_id_qr")	
	private Integer debitIdQR;

	@Column(name="o_kironprize_amount")	
	private Double kironprizeAmount;
	
	@Column(name="o_neoprize_amount")	
	private Double neoprizeAmount;
	
	@Column(name="o_balance_item_kiron")	
	private Integer balanceItemKiron;
	
	@Column(name="o_balance_item_neo")	
	private Integer balanceItemNeo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDebitIdQR() {
		return debitIdQR;
	}

	public void setDebitIdQR(Integer debitIdQR) {
		this.debitIdQR = debitIdQR;
	}

	public Double getKironprizeAmount() {
		return kironprizeAmount;
	}

	public void setKironprizeAmount(Double kironprizeAmount) {
		this.kironprizeAmount = kironprizeAmount;
	}

	public Double getNeoprizeAmount() {
		return neoprizeAmount;
	}

	public void setNeoprizeAmount(Double neoprizeAmount) {
		this.neoprizeAmount = neoprizeAmount;
	}

	public Integer getBalanceItemKiron() {
		return balanceItemKiron;
	}

	public void setBalanceItemKiron(Integer balanceItemKiron) {
		this.balanceItemKiron = balanceItemKiron;
	}

	public Integer getBalanceItemNeo() {
		return balanceItemNeo;
	}

	public void setBalanceItemNeo(Integer balanceItemNeo) {
		this.balanceItemNeo = balanceItemNeo;
	}
}
