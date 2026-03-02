package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Renzo Jauregui Malpartida
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTUPDATE_RESETNEWPASSWORD", query = "{ call LOTOCARD.CLIENTUPDATE.RESETNEWPASSWORD(?,?,?,?,?)}", callable = true, resultClass = ClientProcedureResetNewPassword.class)
public class ClientProcedureResetNewPassword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_clientid")
    private Integer clientId;
    @Column(name = "p_message")
    private String message;
    @Column(name = "p_name")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
