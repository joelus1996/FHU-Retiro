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
		name = "CLIENTWEB_GET_SELFCONTROL",
		query = "{ call LOTOCARD.CLIENTWEB.GETSELFCONTROL(?,?) }",
		callable = true,
		resultClass = ClientProcedureGetSelfcontrol.class
		)
public class ClientProcedureGetSelfcontrol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="o_client_id")	
	private Integer clientId;
	
	@Column(name="o_show_disable")	
	private String showDisable;
	
	@Column(name="o_type_limit")	
	private String typeLimit;
	
	@Column(name="o_value_limit")	
	private Integer valueLimit;
	
	@Column(name="o_date_limit")	
	private String dateLimit;
	
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getShowDisable() {
		return showDisable;
	}

	public void setShowDisable(String showDisable) {
		this.showDisable = showDisable;
	}

	public String getTypeLimit() {
		return typeLimit;
	}

	public void setTypeLimit(String typeLimit) {
		this.typeLimit = typeLimit;
	}

	public Integer getValueLimit() {
		return valueLimit;
	}

	public void setValueLimit(Integer valueLimit) {
		this.valueLimit = valueLimit;
	}

	public String getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(String dateLimit) {
		this.dateLimit = dateLimit;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
	
    public String toJson(Gson gson) {
	    return gson.toJson(this);
    }

}
