package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobil
 *
 */

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LOTOCARD.SUPER3_LIST")
public class Super3List implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SORTEO")
	private Integer rawid;
	
	@Column(name="RESULTADO")
	private String result;
	
	@Column(name="FECHA")
	private String date;
	
	@Transient
	private Integer drwid;
	 
    public Super3List() {
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
    
}