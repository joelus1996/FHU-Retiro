package pe.com.intralot.loto.layer.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="SUPER3SALE_DRAWDATA",
		query="{ call LOTOCARD.SUPER3SALE.DRAW_DATA(?) }",
		callable=true,
		resultClass=Super3ProcedureDrawData.class
		)
public class Super3ProcedureDrawData {

	@Id
	@Column(name="w_num_draws")
	private Integer numDraws;
	
	@Column(name="w_draw_id")
	private Integer drawId;
	
	@Column(name="w_draw_date")
	private Date drawDate;
	
	@Column(name="w_message_draw")
	private String messageDraw;
	
	public Integer getNumDraws() {
		return numDraws;
	}

	public void setNumDraws(Integer numDraws) {
		this.numDraws = numDraws;
	}

	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public Date getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	public String getMessageDraw() {
		return messageDraw;
	}

	public void setMessageDraw(String messageDraw) {
		this.messageDraw = messageDraw;
	}

}
