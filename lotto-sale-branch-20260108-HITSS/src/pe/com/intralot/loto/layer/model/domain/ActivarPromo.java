package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.PROMBICOLORPARAM")
public class ActivarPromo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CANT_TICKETS")
	private String numTickets;

	@Column(name = "SQ_GANADORES")
	private String secuencia;
	
	@Column(name = "FLAG_ORDEN")
	private String orden;
	
	@Column(name = "STATUS_PROMO")
	private String statusPromo;

	public String getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(String numTickets) {
		this.numTickets = numTickets;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getStatusPromo() {
		return statusPromo;
	}

	public void setStatusPromo(String statusPromo) {
		this.statusPromo = statusPromo;
	}
	
	

}
