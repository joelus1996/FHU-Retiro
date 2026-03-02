package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Loader(namedQuery="TEAPUESTOSALE_DRAWMENU")
@NamedNativeQuery(
		name="TEAPUESTOSALE_DRAWMENU",
		query="{call LOTOCARD.TEAPUESTOSALE.DRAW_MENU(?)}",
		callable=true,
		resultSetMapping = "drawmenu-data"
		)
@SqlResultSetMapping(name = "drawmenu-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureDrawMenu.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TeapuestoProcedureDrawMenu {
	
	@Id
	@Column(name="w_draw")
	private Integer drawId;
	
	@Column(name="w_date")
	private String date;

	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer draw) {
		this.drawId = draw;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
