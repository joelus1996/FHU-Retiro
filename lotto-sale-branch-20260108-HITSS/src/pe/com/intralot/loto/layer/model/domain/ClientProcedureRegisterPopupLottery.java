package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_REGISTERPOPUPLOTTERY", query = "{ call LOTOCARD.CLIENTSALE.REGISTERPOPUPLOTTERY(?,?,?,?,?) }", callable = true, resultClass = ClientProcedureRegisterPopupLottery.class)
public class ClientProcedureRegisterPopupLottery {
    
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
