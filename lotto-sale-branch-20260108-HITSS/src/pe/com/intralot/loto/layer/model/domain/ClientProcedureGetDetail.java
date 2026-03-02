package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "SP_CLIENT_DETAIL", query = "{ call LOTOCARD.TICKETSALE.GETCLIENTDETAIL(?,?) }", callable = true, resultClass = ClientProcedureGetDetail.class)
public class ClientProcedureGetDetail {

    @Id
    @Column(name = "p_cldocnumber")
    private String clDocNumber;    
    
    @Column(name = "p_cldoctype")
    private String clDocType;

    @Column(name = "p_clname")
    private String clName;

	public String getClDocNumber() {
		return clDocNumber;
	}

	public void setClDocNumber(String clDocNumber) {
		this.clDocNumber = clDocNumber;
	}

	public String getClDocType() {
		return clDocType;
	}

	public void setClDocType(String clDocType) {
		this.clDocType = clDocType;
	}

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	
}