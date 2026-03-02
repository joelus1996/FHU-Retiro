package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LOTOCARD.KABALA_LIST")
public class KabalaList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SORTEO")
    private Integer rawid;
    @Column(name = "BOLOS")
    private String result;
    @Column(name = "FECHA")
    private String date;
    @Column(name = "CHANCE")
    private String extra1;
    @Column(name = "SI_O_SI")
    private String extra2;
    @Column(name = "DR_ADDON_RESULT_2")
    private String addonResult2;
    @Transient
	private Integer drwid;

    public KabalaList() {
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

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getAddonResult2() {
        return addonResult2;
    }

    public void setAddonResult2(String addonResult2) {
        this.addonResult2 = addonResult2;
    }

	public Integer getDrwid() {
		return drwid;
	}

	public void setDrwid(Integer drwid) {
		this.drwid = drwid;
	}
    
}