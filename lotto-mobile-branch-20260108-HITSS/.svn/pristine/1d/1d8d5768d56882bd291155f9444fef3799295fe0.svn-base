package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PAY_REGISTER_ERROR_IZIPAY",
		query = "{ call LOTOCARD.transactionizipay.registerError(?,?,?,?,?,?,?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = ProcedureRegisterErrorIzipay.class
		)
public class ProcedureRegisterErrorIzipay implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name = "o_status")
	private String status;
	
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
}
