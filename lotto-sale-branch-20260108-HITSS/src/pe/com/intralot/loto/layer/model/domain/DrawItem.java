package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRAW_ITEM database table.
 * 
 */
@Entity
@Table(name="LOTOCARD.DRAW_ITEM")
public class DrawItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrawItemPK id;

	@Column(name="DI_ASIGNACION")
	private String diAsignacion;

	@Column(name="DI_CUP_NAME")
	private String diCupName;

	@Column(name="DI_LOCAL_NAME")
	private String diLocalName;

	@Column(name="DI_LOCAL_SCORE")
	private String diLocalScore;

	@Column(name="DI_MESSAGE")
	private String diMessage;

	@Column(name="DI_RESULT")
	private String diResult;

	@Column(name="DI_VISITOR_NAME")
	private String diVisitorName;

	@Column(name="DI_VISITOR_SCORE")
	private String diVisitorScore;

	public DrawItemPK getId() {
		return this.id;
	}

	public void setId(DrawItemPK id) {
		this.id = id;
	}

	public String getDiAsignacion() {
		return this.diAsignacion;
	}

	public void setDiAsignacion(String diAsignacion) {
		this.diAsignacion = diAsignacion;
	}

	public String getDiCupName() {
		return this.diCupName;
	}

	public void setDiCupName(String diCupName) {
		this.diCupName = diCupName;
	}

	public String getDiLocalName() {
		return this.diLocalName;
	}

	public void setDiLocalName(String diLocalName) {
		this.diLocalName = diLocalName;
	}

	public String getDiLocalScore() {
		return this.diLocalScore;
	}

	public void setDiLocalScore(String diLocalScore) {
		this.diLocalScore = diLocalScore;
	}

	public String getDiMessage() {
		return this.diMessage;
	}

	public void setDiMessage(String diMessage) {
		this.diMessage = diMessage;
	}

	public String getDiResult() {
		return this.diResult;
	}

	public void setDiResult(String diResult) {
		this.diResult = diResult;
	}

	public String getDiVisitorName() {
		return this.diVisitorName;
	}

	public void setDiVisitorName(String diVisitorName) {
		this.diVisitorName = diVisitorName;
	}

	public String getDiVisitorScore() {
		return this.diVisitorScore;
	}

	public void setDiVisitorScore(String diVisitorScore) {
		this.diVisitorScore = diVisitorScore;
	}

}