package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NamedNativeQuery;

import com.google.gson.Gson;

@Entity
@NamedNativeQuery(
		name = "CLIENTWEB_EDIT_SELFCONTROL",
		query = "{ call LOTOCARD.CLIENTWEB.EDITSELFCONTROL(?,?,?,?) }",
		callable = true,
		resultClass = ClientProcedureEditSelfcontrol.class
		)
public class ClientProcedureEditSelfcontrol implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="o_client_id")	
	private String clientId;
	
	@Column(name="o_mensaje")
	private String mensaje;
	
	@Column(name="o_monto_control")
	private Double montoControl;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Double getMontoControl() {
		return montoControl;
	}

	public void setMontoControl(Double montoControl) {
		this.montoControl = montoControl;
	}

	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
	
    public String toJson(Gson gson) {
	    return gson.toJson(this);
    }

}
