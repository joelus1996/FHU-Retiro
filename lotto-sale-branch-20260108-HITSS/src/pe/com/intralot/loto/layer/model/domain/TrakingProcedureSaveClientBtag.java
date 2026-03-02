package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Edgar Narro
 * @rol:	  Analista de desarrollo de sistemas
 * @proyecto: FHU Seguimiento de Marketing de Afiliados
 *
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "tracking_save_clientbtag",
		query = "{ call lotocard.affiliate_tracking.save_clientbtag(?,?,?) }",
		callable = true,
		resultClass = TrakingProcedureSaveClientBtag.class
		)
public class TrakingProcedureSaveClientBtag implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 7513917474731357601L;

	@Id
	@Column(name="o_id")	
	private String id;
    
    @Column(name="o_status")	
	private String state;
    
    @Column(name="o_error")	
	private String error;

	@Column(name="o_message")	
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}