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
@NamedNativeQuery(name = "CLIENTSALE_GETPLAYERID", query = "{ call LOTOCARD.CLIENTSALE.GETPLAYERID(?,?) }", callable = true, resultClass = ClientProcedureGetPlayerId.class)
public class ClientProcedureGetPlayerId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_clientid")
    private String clientId;
    @Column(name = "p_player_id_xpg")
    private String playerIdXpg;
	
    
    public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getPlayerIdXpg() {
		return playerIdXpg;
	}


	public void setPlayerIdXpg(String playerIdXpg) {
		this.playerIdXpg = playerIdXpg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}   
}
