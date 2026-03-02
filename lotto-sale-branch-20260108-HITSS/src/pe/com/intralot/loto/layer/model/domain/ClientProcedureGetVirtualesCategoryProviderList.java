package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETVIRTUALESCATEGORYPROVIDERS", 
		query = "{ call LOTOCARD.CLIENTSALE.GETVIRTUALESCATEGORYPROVIDERS(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetVirtualesCategoryProviderList.class
		)

public class ClientProcedureGetVirtualesCategoryProviderList {

    @Id
    @Column(name = "w_id")
    private String id;
    
    @Column(name = "w_category")
    private String category;
    
    @Column(name = "w_provider_id")
    private String providerid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
    
}
