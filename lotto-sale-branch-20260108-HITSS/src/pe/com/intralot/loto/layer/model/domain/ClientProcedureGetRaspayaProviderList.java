package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETRASPAYAPROVIDERS", 
		query = "{ call LOTOCARD.CLIENTSALE.GETRASPAYAPROVIDERS(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetRaspayaProviderList.class
		)

public class ClientProcedureGetRaspayaProviderList {

    @Id
    @Column(name = "w_provider_id")
    private String providerid;
    
    @Column(name = "w_name")
    private String name;

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
