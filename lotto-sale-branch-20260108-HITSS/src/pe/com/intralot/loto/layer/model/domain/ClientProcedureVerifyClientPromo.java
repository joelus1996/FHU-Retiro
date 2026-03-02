package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTSALE_CLIENTPROCEDUREVERIFYCLIENTPROMO", query = "{ call LOTOCARD.CLIENTSALE.VERIFYCLIENTPROMO(?,?,?,?,?) }", callable = true, resultClass = ClientProcedureVerifyClientPromo.class)
public class ClientProcedureVerifyClientPromo {
	
	@Id
	@Column(name = "p_message")
	private String message;
	
    @Column(name = "p_user")
    private String user;
    @Column(name = "p_password")
    private String password;
    @Column(name = "p_game_message")
    private String gameMessage;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGameMessage() {
        return gameMessage;
    }

    public void setGameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

}
