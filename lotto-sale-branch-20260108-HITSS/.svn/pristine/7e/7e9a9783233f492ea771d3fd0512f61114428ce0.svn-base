package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "LOTOCARD_GET_CLIENTSECURITY_WHITELIST",
		query = "{ call LOTOCARD.CLIENT_SECURITY.get_ip_in_whitelist(?,?,?) }",
		callable = true,
		resultClass = GetClientSecurity.class
		)
public class GetClientSecurity {
	
	@Id
	@Column(name="w_id")	
	private String id;

	@Column(name="w_status")	
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

	public String toString() {
		return "id="+id+" status="+status;
	}
}
