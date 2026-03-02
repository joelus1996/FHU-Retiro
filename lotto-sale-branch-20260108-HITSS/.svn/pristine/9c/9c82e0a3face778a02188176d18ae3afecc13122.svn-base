package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_UPDATEDEVICE", query = "{ call LOTOCARD.CLIENTSALE.UPDATEDEVICE(?,?,?)}", callable = true, resultClass = ClientProcedureUpdateClientDevice.class)
public class ClientProcedureUpdateClientDevice implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_state")
    private Integer state;
    @Column(name = "p_message")
    private String message;

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
}
