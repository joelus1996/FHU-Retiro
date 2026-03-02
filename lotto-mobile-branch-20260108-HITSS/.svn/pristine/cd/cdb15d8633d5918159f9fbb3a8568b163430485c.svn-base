package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCESALE_GETMONTO", query = "{ call LOTOCARD.BALANCESALE.GETMONTO(?,?) }", callable = true, resultClass = BalanceProcedureGetMontoPorDia.class)
public class BalanceProcedureGetMontoPorDia {

	
	@Id
    @Column(name = "m_dia")
    private String m_dia;

	
	public String getM_dia() {
		return m_dia;
	}

	public void setM_dia(String m_dia) {
		this.m_dia = m_dia;
	}
}
