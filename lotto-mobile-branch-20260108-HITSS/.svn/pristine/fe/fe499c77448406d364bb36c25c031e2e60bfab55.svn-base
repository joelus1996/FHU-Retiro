package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "DEFINE_TRANSACTION_IZIPAY",
		query = "{ call LOTOCARD.transactionizipay.defineTransaction(?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = ProcedureDefineTransactionIzipay.class
		)
public class ProcedureDefineTransactionIzipay {

	@Id
	@Column(name="o_id_transaction_izipay")	
	private Integer idTransactionIzipay;
	
	@Column(name = "o_status")
	private String status;
		

	public Integer getIdTransactionIzipay() {
		return idTransactionIzipay;
	}

	public void setIdTransactionIzipay(Integer idTransactionIzipay) {
		this.idTransactionIzipay = idTransactionIzipay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
