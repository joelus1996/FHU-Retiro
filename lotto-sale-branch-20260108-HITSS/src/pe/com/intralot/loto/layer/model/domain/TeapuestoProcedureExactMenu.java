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
		name="TEAPUESTOSALE_EXACTMENU",
		query="{ call LOTOCARD.TEAPUESTOSALE.EXACT_MENU(?) }",
		callable=true,
		resultSetMapping = "exactmenu-data"
		)
@SqlResultSetMapping(name = "exactmenu-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureExactMenu.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureExactMenu {

	@Id
	@Column(name="w_event_id")
	private Integer eventId;
	
	@Column(name="w_draw_id")
	private Integer drawId;
	
	@Column(name="w_teams_menu")
	private String teamsMenu;
	
	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getTeamsMenu() {
		return teamsMenu;
	}

	public void setTeamsMenu(String teamsMenu) {
		this.teamsMenu = teamsMenu;
	}

	

}
