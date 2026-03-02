package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "transactionbbva_defineTransaction",
		query = "{ call lotocard.transactionbbva.defineTransaction(?,?,?,?,?,?) }",
		callable = true,
		resultClass = BbvaProcedureDefineTransaction.class
		)

public class BbvaProcedureDefineTransaction {
	
	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_transaction")
	private String transaction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
}