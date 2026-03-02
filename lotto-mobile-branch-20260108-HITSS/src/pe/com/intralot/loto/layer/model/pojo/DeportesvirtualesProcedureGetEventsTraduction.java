package pe.com.intralot.loto.layer.model.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "DEPORTESVIRTUALESSALE_GETEVENTSTRADUCTION",
		query = "{call LOTOCARD.DEPORTESVIRTUALESSALE.GET_EVENTS_TRADUCTION(?,?)}",
		callable = true,
		resultClass = DeportesvirtualesProcedureGetEventsTraduction.class)
public class DeportesvirtualesProcedureGetEventsTraduction {
	


	@Id
	@Column(name = "o_transaccion_id")
	private String transaccionId;

	@Column(name = "o_message")
	private String message;
	
	@Column(name = "o_playlist_traduction")
	private String playlistTraduction;
	

	public String getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(String transaccionId) {
		this.transaccionId = transaccionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPlaylistTraduction() {
		return playlistTraduction;
	}

	public void setPlaylistTraduction(String playlistTraduction) {
		this.playlistTraduction = playlistTraduction;
	}

}
