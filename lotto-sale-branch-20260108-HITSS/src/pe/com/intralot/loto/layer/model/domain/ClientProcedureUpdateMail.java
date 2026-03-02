package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_UPDATEMAIL", query = "{ call LOTOCARD.CLIENTSALE.UPDATEMAIL_2(?,?,?)}", callable = true, resultClass = ClientProcedureUpdateMail.class)
public class ClientProcedureUpdateMail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_clientid")
    private Integer clientId;
    @Column(name = "p_message")
    private String message;
    @Column(name = "p_mail_verified")
    private String mailVerified;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getMailVerified() {
		return mailVerified;
	}

	public void setMailVerified(String mailVerified) {
		this.mailVerified = mailVerified;
	}
    
}
