package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_CANCELPROMOTION", query = "{ call LOTOCARD.CLIENTSALE.CANCELPROMOTION(?,?,?) }", callable = true, resultClass = ClientProcedureCancelPromotion.class)
public class ClientProcedureCancelPromotion {

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
