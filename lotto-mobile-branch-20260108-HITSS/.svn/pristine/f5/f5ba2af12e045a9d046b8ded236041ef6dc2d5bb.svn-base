package pe.com.intralot.loto.layer.model.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "PROMSORTEO_GETLISTFECHAPROMO", query = "{ call LOTOCARD.PROMSORTEO.GETFECHAPROMO(?,?) }", callable = true, resultClass = PromProcedureListFechaPromo.class)
public class PromProcedureListFechaPromo implements Serializable{
 
	private static final long serialVersionUID = 8010671709784397205L;

	@Id
    @Column(name = "PFC_VALUE")
    private String value;
       
    @Column(name = "PFC_DATE_INIT")
    private Date dateInit;

    @Column(name = "PFC_DATE_FIN")
    private Date dateFin;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
    
 
	
}