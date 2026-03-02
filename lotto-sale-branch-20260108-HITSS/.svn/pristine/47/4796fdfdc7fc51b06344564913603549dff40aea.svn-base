package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_PUTNEWCLIENT", query = "{ call LOTOCARD.CLIENTSALE.PUTNEWCLIENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }", callable = true, resultClass = ClientProcedurePutNewClient.class)
public class ClientProcedurePutNewClient {

    @Id
    @Column(name = "p_clientid")
    private Integer clientId = 0;
    @Column(name = "p_state")
    private Integer state;
    @Column(name = "p_mail_code")
    private String mailCode;
    @Column(name = "p_message")
    private String message;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
