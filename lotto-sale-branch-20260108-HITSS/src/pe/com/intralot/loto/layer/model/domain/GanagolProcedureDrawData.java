package pe.com.intralot.loto.layer.model.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;


@Entity
@NamedNativeQuery(
		name = "GANAGOLSALE_DRAWDATA", 
		query = "{ call LOTOCARD.GANAGOLSALE.DRAW_DATA(?) }", 		
		callable = true, 
		resultClass = GanagolProcedureDrawData.class)
public class GanagolProcedureDrawData {
	@Id
	@Column(name = "w_item")
	private Integer item;

	@Column(name = "w_local")
	private String local;

	@Column(name = "w_visitor")
	private String visitor;

	@Column(name = "w_cup")
	private String cup;

	@Column(name = "w_odds")
	private String odds;

	@Column(name = "w_image_local")
	private String imageLocal;

	@Column(name = "w_image_visitor")
	private String imageVisitor;

	@Column(name = "w_image_cup")
	private String imageCup;

	@Column(name = "w_program")
	private Integer program;

	@Column(name = "w_notes")
	private String notes;

	@Column(name = "w_date")
	private Date date;

	@Column(name = "w_tv_channel")
	private String tvChannel;

	@Column(name = "w_comment")
	private String Comment;

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getOdds() {
		return odds;
	}

	public void setOdds(String odds) {
		this.odds = odds;
	}

	public String getImageLocal() {
		return imageLocal;
	}

	public void setImageLocal(String imageLocal) {
		this.imageLocal = imageLocal;
	}

	public String getImageVisitor() {
		return imageVisitor;
	}

	public void setImageVisitor(String imageVisitor) {
		this.imageVisitor = imageVisitor;
	}

	public String getImageCup() {
		return imageCup;
	}

	public void setImageCup(String imageCup) {
		this.imageCup = imageCup;
	}

	public Integer getProgram() {
		return program;
	}

	public void setProgram(Integer program) {
		this.program = program;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTvChannel() {
		return tvChannel;
	}

	public void setTvChannel(String tvChannel) {
		this.tvChannel = tvChannel;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
}
