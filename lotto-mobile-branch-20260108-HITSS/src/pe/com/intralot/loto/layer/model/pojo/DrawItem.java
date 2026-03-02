package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LOTOCARD.DRAW_ITEM")
public class DrawItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrawItemPk drawpk;
	
	@Column(name="DI_LOCAL_NAME")
	private String localName;

	@Column(name="DI_LOCAL_SCORE")
	private String localScore;

	@Column(name="DI_RESULT")
	private String result;

	@Column(name="DI_VISITOR_NAME")
	private String visitorName;

	@Column(name="DI_VISITOR_SCORE")
	private String visitorScore;

	@Column(name = "DI_CUP_NAME")
    private String di_cup_name;
	
	@Column(name = "DI_MESSAGE")
    private String di_time_message;
	
	@Transient
	private Integer drwid;
	
    public DrawItem() {
    	
    }

	public DrawItemPk getDrawpk() {
		return drawpk;
	}

	public void setDrawpk(DrawItemPk drawpk) {
		this.drawpk = drawpk;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getLocalScore() {
		return localScore;
	}

	public void setLocalScore(String localScore) {
		this.localScore = localScore;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(String visitorScore) {
		this.visitorScore = visitorScore;
	}
	public String getDi_cup_name() {
		return di_cup_name;
	}

	public void setDi_cup_name(String di_cup_name) {
		this.di_cup_name = di_cup_name;
	}

	public String getDi_time_message() {
		return di_time_message;
	}

	public void setDi_time_message(String di_time_message) {
		this.di_time_message = di_time_message;
	}

	public Integer getDrwid() {
		return drwid;
	}

	public void setDrwid(Integer drwid) {
		this.drwid = drwid;
	}

}