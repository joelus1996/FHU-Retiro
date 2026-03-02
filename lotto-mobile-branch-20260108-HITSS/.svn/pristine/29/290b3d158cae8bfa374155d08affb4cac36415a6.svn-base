package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_REQUEST_BY_NUMBER",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_REQUEST_BY_NUMBER(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetRequestByNumber.class
		)
public class PaymentPrizeProcedureGetRequestByNumber implements Serializable{
	
	private static final long serialVersionUID = 4303658074094311384L;

	@Id
	@Column(name="o_request_number")
	private Integer requestNumber;
	
	@Column(name="o_request_amount")	
	private String requestAmount;
	
	@Column(name="o_request_date_hour")	
	private String requestDateHour;
	
	@Column(name="o_client_id")
	private Integer clientId;
	
    @Column(name = "o_nombre")
	private String nombre;
    
	@Column(name = "o_apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name = "o_apellido_materno")
	private String apellidoMaterno;
	
	@Column(name = "o_doc_number")
	private String docNumber;

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequestDateHour() {
		return requestDateHour;
	}

	public void setRequestDateHour(String requestDateHour) {
		this.requestDateHour = requestDateHour;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
}
