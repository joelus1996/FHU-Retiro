package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.TEAPUESTO_EVENT")
public class Event_vista implements Serializable {
    
	private static final long serialVersionUID = 8799656478674716638L;
	
	@EmbeddedId
	private EventPk eventpk;
	
	@Column(name = "TE_DESCRIPTION")
    private String descripcion;
	
	@Column(name = "TE_TEAM_LOCAL")
    private String teamLocal;	
	
	@Column(name = "TE_TEAM_VISITOR")
    private String teamVisitor;	
	
	@Column(name = "TE_LEAGUE_ID")
    private String ideLeague;
	
	@Column(name = "TE_POSITION_LOCAL")
    private String positionLocal;
	
	@Column(name = "TE_POSITION_VISITOR")
    private String positionVisitor;	

	@Column(name = "TE_DATE")
    private Date datePrincipal;	
	
	@Column(name = "TE_CLOSE_DATE")
    private Date closeDate;
	
	@Column(name = "TE_CLOSE_HOUR")
    private Integer closeHour;	
	
	@Column(name = "TE_CLOSE_MINUTE")
    private Integer closeMinute;
	
	@Column(name = "TE_MINIMUM")
    private Integer minimum;
	
	@Column(name = "TE_1_LOAD")
    private Double unoLoad;
	
	@Column(name = "TE_X_LOAD")
    private Double xLoad;		
	
	@Column(name = "TE_2_LOAD")
    private Double dosLoad;
	
	@Column(name = "TE_1X_LOAD")
    private Double unoXLoad;		
	
	@Column(name = "TE_12_LOAD")
    private Double unoDosLoad;	
	
	@Column(name = "TE_X2_LOAD")
    private Double xDosLoad;	
	
	@Column(name = "TE_LOWER_2")
    private Double lower2;
	
	@Column(name = "TE_OVER_3")
    private Double ower2;	
	
	@Column(name = "TE_MODE")
    private Integer mode;
	
	@Column(name = "TE_STATUS")
    private String status;	
	
	@Column(name = "TE_RESULT")
    private String result;
	
	@Column(name = "TE_LO_RESULT")
    private String loResult;	
	
	@OneToMany(mappedBy="teapuestoEvent")
	private Set<Item> teapuestoItems;
	
    public Event_vista() {
    
    }

	public Set<Item> getTeapuestoItems() {
		return this.teapuestoItems;
	}

	public void setTeapuestoItems(Set<Item> teapuestoItems) {
		this.teapuestoItems = teapuestoItems;
	}

	public EventPk getEventpk() {
		return eventpk;
	}

	public void setEventpk(EventPk eventpk) {
		this.eventpk = eventpk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTeamLocal() {
		return teamLocal;
	}

	public void setTeamLocal(String teamLocal) {
		this.teamLocal = teamLocal;
	}

	public String getTeamVisitor() {
		return teamVisitor;
	}

	public void setTeamVisitor(String teamVisitor) {
		this.teamVisitor = teamVisitor;
	}

	public String getIdeLeague() {
		return ideLeague;
	}

	public void setIdeLeague(String ideLeague) {
		this.ideLeague = ideLeague;
	}

	public String getPositionLocal() {
		return positionLocal;
	}

	public void setPositionLocal(String positionLocal) {
		this.positionLocal = positionLocal;
	}

	public String getPositionVisitor() {
		return positionVisitor;
	}

	public void setPositionVisitor(String positionVisitor) {
		this.positionVisitor = positionVisitor;
	}

	public Date getDatePrincipal() {
		return datePrincipal;
	}

	public void setDatePrincipal(Date datePrincipal) {
		this.datePrincipal = datePrincipal;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Integer getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(Integer closeHour) {
		this.closeHour = closeHour;
	}

	public Integer getCloseMinute() {
		return closeMinute;
	}

	public void setCloseMinute(Integer closeMinute) {
		this.closeMinute = closeMinute;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Double getUnoLoad() {
		return unoLoad;
	}

	public void setUnoLoad(Double unoLoad) {
		this.unoLoad = unoLoad;
	}

	public Double getxLoad() {
		return xLoad;
	}

	public void setxLoad(Double xLoad) {
		this.xLoad = xLoad;
	}

	public Double getDosLoad() {
		return dosLoad;
	}

	public void setDosLoad(Double dosLoad) {
		this.dosLoad = dosLoad;
	}

	public Double getUnoXLoad() {
		return unoXLoad;
	}

	public void setUnoXLoad(Double unoXLoad) {
		this.unoXLoad = unoXLoad;
	}

	public Double getUnoDosLoad() {
		return unoDosLoad;
	}

	public void setUnoDosLoad(Double unoDosLoad) {
		this.unoDosLoad = unoDosLoad;
	}

	public Double getxDosLoad() {
		return xDosLoad;
	}

	public void setxDosLoad(Double xDosLoad) {
		this.xDosLoad = xDosLoad;
	}

	public Double getLower2() {
		return lower2;
	}

	public void setLower2(Double lower2) {
		this.lower2 = lower2;
	}

	public Double getOwer2() {
		return ower2;
	}

	public void setOwer2(Double ower2) {
		this.ower2 = ower2;
	}

	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLoResult() {
		return loResult;
	}

	public void setLoResult(String loResult) {
		this.loResult = loResult;
	}
	
}