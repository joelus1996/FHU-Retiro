package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

/**
 * <p>
 * NOMBRE: ClientProcedureCodeValidation.java
 * <br></p>
 * <p>
 * FUNCION: Entidad Hibernate validacion de codigo promocional 
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   DPARRENO		  07/05/2019  First comment
 * </pre>
 * <br></p>
 */

@Entity
@NamedNativeQuery(name = "RECARGAWEB_APPLY_CODE", query = "{ call LOTOCARD.RECARGAWEB.APPLY_CODE(?,?,?,?,?,?,?) }", callable = true, resultClass = ClientProcedureCodeValidation.class)
public class ClientProcedureCodeValidation {

    @Id
    @Column(name = "p_status")
    private String state;
    @Column(name = "p_message")
    private String message;
    @Column(name = "p_id_code")
    private String idCodePromotional;
    @Column(name = "p_promotion_code")
    private String promotionCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getIdCodePromotional() {
		return idCodePromotional;
	}

	public void setIdCodePromotional(String idCodePromotional) {
		this.idCodePromotional = idCodePromotional;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
}
