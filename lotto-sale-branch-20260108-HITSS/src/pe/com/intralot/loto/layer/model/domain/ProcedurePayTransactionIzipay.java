package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PAY_TRANSACTION_IZIPAY",
		query = "{ call LOTOCARD.transactionizipay.payTransaction(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = ProcedurePayTransactionIzipay.class
		)
public class ProcedurePayTransactionIzipay {

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name = "o_status")
	private String status;
	
	@Column(name="o_new_amount")
	private Double newAmount;

	@Column(name="o_balance_item")
	private Integer balanceItem;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(Double newAmount) {
		this.newAmount = newAmount;
	}

	public Integer getBalanceItem() {
		return balanceItem;
	}

	public void setBalanceItem(Integer balanceItem) {
		this.balanceItem = balanceItem;
	}
}
