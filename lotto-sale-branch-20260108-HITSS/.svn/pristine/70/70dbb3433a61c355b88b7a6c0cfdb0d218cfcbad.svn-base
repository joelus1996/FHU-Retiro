package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_UPDATECLIENT", query = "{ call LOTOCARD.CLIENTSALE.UPDATECLIENT_3(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }", callable = true, resultClass = ClientProcedureUpdateClient.class)
public class ClientProcedureUpdateClient {

    @Id
    @Column(name = "p_state")
    private Integer state;
    @Column(name = "p_message")
    private String message;
    @Column(name = "p_mobile_status")
    private String mobileStatus;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(String mobileStatus) {
		this.mobileStatus = mobileStatus;
	}
}
