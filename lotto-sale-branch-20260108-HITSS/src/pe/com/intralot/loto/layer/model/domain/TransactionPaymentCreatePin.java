package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "LOTOCARD_TRANSACTIONPAYMENTLOG_CREATEPIN",
		query = "{ call LOTOCARD.TRANSACTIONPAYMENTLOG.CREATEPIN( ?,?,?,?,? ,?,?,?,?,?) }",
		callable = true,
		resultClass = TransactionPaymentCreatePin.class
		)
public class TransactionPaymentCreatePin {
		
	@Id
	@Column(name="o_id")	
	private String id;

	@Column(name="o_status")	
	private String status;

	@Column(name="o_titulo")	
	private String titulo;

	@Column(name="o_mensaje")	
	private String mensaje;

	@Column(name="o_nombre")	
	private String nombre;

	@Column(name="o_mail")	
	private String mail;

	@Column(name="o_phone")	
	private String phone;	

	@Column(name="o_mensajeerror")	
	private String mensajeError;

	@Column(name="o_boton")	
	private String boton;	
	
	@Column(name="o_minutos")	
	private String minutos;	

	@Column(name="o_cont_correo")	
	private Integer cont_correo;
	
	@Column(name="o_cont_sms")	
	private Integer cont_sms;	
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeerror(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String getBoton() {
		return boton;
	}

	public void setBoton(String boton) {
		this.boton = boton;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getCont_correo() {
		return cont_correo;
	}

	public void setCont_correo(Integer cont_correo) {
		this.cont_correo = cont_correo;
	}

	public Integer getCont_sms() {
		return cont_sms;
	}

	public void setCont_sms(Integer cont_sms) {
		this.cont_sms = cont_sms;
	}

	public String toString() {
		return "id="+id+" status="+status+" titulo="+titulo+" mensaje="+mensaje+" nombre="+nombre+" mail="+mail+" phone="+phone+ " mensaje="+mensaje+" mensajeError="+mensajeError;
	}
}
