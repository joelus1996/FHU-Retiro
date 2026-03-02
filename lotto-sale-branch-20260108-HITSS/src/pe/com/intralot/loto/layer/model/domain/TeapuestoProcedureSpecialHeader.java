package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@NamedNativeQuery(
		name="TEAPUESTOSALE_SPECIALHEADER",
		query="{ call LOTOCARD.TEAPUESTOSALE.SPECIAL_HEADER(?) }",
		callable=true,
		resultSetMapping = "specialheader-data"
		)
@SqlResultSetMapping(name = "specialheader-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureSpecialHeader.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureSpecialHeader {

	@Id
	@Column(name="w_header")
	private String header;
	
	@Column(name="w_name")
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}
