package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "BALANCESALE_GETMONTO_AGORA",
        query = "{ call LOTOCARD.BALANCESALE.GETMONTO_AGORA(?,?) }",
        callable = true,
        resultClass = BalanceProcedureGetMontoPorDiaAgora.class)
public class BalanceProcedureGetMontoPorDiaAgora {

	@Id
    @Column(name = "o_id")
    private String id;
	
    @Column(name = "m_dia")
    private String montoPorDia;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMontoPorDia() {
		return montoPorDia;
	}

	public void setMontoPorDia(String montoPorDia) {
		this.montoPorDia = montoPorDia;
	}
}
