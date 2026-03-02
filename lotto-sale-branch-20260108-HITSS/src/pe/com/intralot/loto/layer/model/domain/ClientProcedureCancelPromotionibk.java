package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

/**
 * <p>
 * NOMBRE: ClientProcedureCancelPromotionibk.java
 * <br></p>
 * <p>
 * FUNCION: Entidad Hibernate Rechazo bono TA recargas Interbank 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 002   Cristian Cortez  25/06/2018  Variables para rechazar el bono TA por recargas Interbank
 * 001   Cristian Cortez  19/06/2018  First comment
 * </pre>
 * <br></p>
 */

@Entity
@NamedNativeQuery(name = "CLIENTSALE_CANCELPROMOTIONIBK", query = "{ call LOTOCARD.CLIENTSALE.CANCELPROMOTION_IBK(?,?,?) }", callable = true, resultClass = ClientProcedureCancelPromotionibk.class)
public class ClientProcedureCancelPromotionibk {

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
