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
@Table(name="LOTOCARD.GANAGOL_LIST")
public class GanagolList implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="PROGRAMA")
	private Integer rawid;
	
	@Column(name="RESULTADOS")
	private String result;

	@Column(name="FECHA")
	private String date;
	
	@Transient
	private Integer drwid;
	
	@Transient
	private String resultadoG200;
	
    public GanagolList() {
    }

	public Integer getRawid() {
		return rawid;
	}

	public void setRawid(Integer rawid) {
		this.rawid = rawid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDrwid() {
		return drwid;
	}

	public void setDrwid(Integer drwid) {
		this.drwid = drwid;
	}

	public String getResultadoG200() {
		return resultadoG200;
	}

	public void setResultadoG200(String resultadoG200) {
		this.resultadoG200 = resultadoG200;
	}
	
}