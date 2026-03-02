package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

/**
 * <p>
 * NOMBRE: ClientProcedureActivateWBPromotion.java
 * <br></p>
 * <p>
 * FUNCION: Entidad Hibernate Activación bono Bienvenida recargas Red Digital 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Cristian Cortez  10/07/2018  Variables para la activación del bono Bienvenida por recargas Red Digital
 * </pre>
 * <br></p>
 */

@Entity
@NamedNativeQuery(name = "CLIENTSALE_ACTIVATEWBPROMOTION", query = "{ call LOTOCARD.CLIENTSALE.ACTIVATEWBPROMOTION(?,?,?) }", callable = true, resultClass = ClientProcedureActivateWBPromotion.class)
public class ClientProcedureActivateWBPromotion {

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
