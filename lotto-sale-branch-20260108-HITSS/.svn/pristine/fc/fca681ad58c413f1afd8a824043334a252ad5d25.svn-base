package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "transactionbbva_checkTransaction",
		query = "{ call lotocard.transactionbbva.checkTransaction(?,?) }",
		callable = true,
		resultClass = BbvaProcedureCheckTransaction.class
		)

public class BbvaProcedureCheckTransaction {
	
	@Id
	@Column(name="o_transaction_id")	
	private String id;
	
	@Column(name="o_amount")
	private Double amount;
	
	@Column(name="o_status")
	private String status;
	
	@Column(name="o_expiry_date")
	private String expiryDate;
	
	@Column(name="o_insert_date")
	private String insertDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
}