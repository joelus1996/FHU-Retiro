package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "RECARGAWEB_UPDATEVISASESSION", query = "{ call LOTOCARD.RECARGAWEB.UPDATEVISASESSION(?,?,?) }", callable = true, resultClass = ClientProcedureUpdateVisaSession.class)
public class ClientProcedureUpdateVisaSession {
    
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
