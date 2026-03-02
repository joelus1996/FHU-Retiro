package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Victor Farro Veramendi
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
@NamedNativeQuery(name = "CLIENTSALE_GETNOVUSID", query = "{ call LOTOCARD.CLIENTSALE.GETNOVUSID(?,?) }", callable = true, resultClass = ClientProcedureGetNovusId.class)
public class ClientProcedureGetNovusId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_user")
    private String clientUser;
    @Column(name = "p_novus_id")
    private String playerIdXpg;
    @Column(name = "p_mail")
    private String clientMail;
    @Column(name = "p_nombre")
    private String nombre;
    


	public String getClientUser() {
		return clientUser;
	}




	public void setClientUser(String clientUser) {
		this.clientUser = clientUser;
	}




	public String getPlayerIdXpg() {
		return playerIdXpg;
	}




	public void setPlayerIdXpg(String playerIdXpg) {
		this.playerIdXpg = playerIdXpg;
	}




	public String getClientMail() {
		return clientMail;
	}




	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
}
