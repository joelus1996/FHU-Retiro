package pe.com.intralot.loto.layer.model.pojo;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_GETRASPAYAGAMEID", query = "{ call LOTOCARD.CLIENTSALE.GETRASPAYAGAMEID(?,?) }", callable = true, resultClass = ClientProcedureGetRaspayaGameId.class)
public class ClientProcedureGetRaspayaGameId {

    @Id
    @Column(name = "w_game_id")
    private String gameId;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
}
