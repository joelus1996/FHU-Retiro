package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "LOTOCARD_CLIENTSECURITY_WHITELIST_IP",
		query = "{ call LOTOCARD.CLIENT_SECURITY.update_ip_in_whitelist(?,?,?,?,?) }",
		callable = true,
		resultClass = ClientSecurityWhiteList.class
		)
public class ClientSecurityWhiteList {
	
	@Id
	@Column(name="w_id")	
	private String id;

	@Column(name="w_status")	
	private String status;

	@Column(name="w_titulo")	
	private String titulo;

	@Column(name="w_mensaje")	
	private String mensaje;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String toString() {
		return "id="+id+" status="+status+" titulo="+titulo+" mensaje="+mensaje;
	}
}
