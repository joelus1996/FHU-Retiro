package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENT", query = "{ call LOTOCARD.CLIENTSALE.VERIFYCLIENT(?,?,?) }", callable = true, resultClass = ClientProcedureVerifyClient.class)
public class ClientProcedureVerifyClient {
	
	@Id
	@Column(name = "p_clientid")
	private String clientId;
	
    @Column(name = "p_user")
    private String user;
    @Column(name = "p_password")
    private String password;
    @Column(name = "p_message")
    private String message;

    public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
