package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "KINELOSALE_DRAWDATA", 
		query = "{ call LOTOCARD.KINELOSALE.DRAW_DATA(?) }", 		
		callable = true, 
		resultClass = KineloProcedureDrawData.class)
public class KineloProcedureDrawData {
	
	@Id
	@Column(name="w_draw_id")
	private Integer drawId;
	
	@Column(name="w_num_draws")
	private Integer numDraws;
	
	@Column(name="w_draw_date")
	private String drawDate;	
	
	@Column(name="w_message_draw")
	private String messageDraw;

	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public Integer getNumDraws() {
		return numDraws;
	}

	public void setNumDraws(Integer numDraws) {
		this.numDraws = numDraws;
	}

	public String getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(String drawDate) {
		this.drawDate = drawDate;
	}

	public String getMessageDraw() {
		return messageDraw;
	}

	public void setMessageDraw(String messageDraw) {
		this.messageDraw = messageDraw;
	}
	
}
