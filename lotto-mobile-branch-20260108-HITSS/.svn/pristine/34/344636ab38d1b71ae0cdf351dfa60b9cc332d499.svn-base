package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   George Minaya
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "LOTOCARD.DRAW")
public class Draw implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private DrawPk drawPk;
    @Column(name = "DR_DATE")
    private Date drawDate;
    @Column(name = "DR_RESULT")
    private String result;
    @Column(name = "DR_ADDITIONAL")
    private String additional;
    @Column(name = "DR_EXTRA")
    private String extra;
    @Column(name = "DR_JACKPOT")
    private Double jackpot;
    @Column(name = "DR_GROSS_11")
    private Double gross11;
    @Column(name = "DR_CLOSE_HOUR")
    private String closeHour;
    @Column(name = "DR_CLOSE_MINUTE")
    private String closeMinute;
    @Column(name = "DR_OPEN_DATE")
    private Date openDate;
    @Column(name = "DR_OPEN_HOUR")
    private Integer openHour;
    @Column(name = "DR_OPEN_MINUTE")
    private Integer openMinute;
    @Column(name = "DR_CLOSE_DATE")
    private Date closeDate;
    @Column(name = "DR_OFICIAL")
    private Integer drOficial;
    @Column(name = "DR_DRAW_FLAG")
    private Integer drawFlag;
    @Column(name = "DR_ADDON_GROSS_1")
    private Double drAddonGross1;
    @Column(name = "DR_ADDON_RESULT_2")
    private String drAddonResult2;
    @Column(name = "DR_ADDON_RESULT_1")
    private String drAddonResult1;
    @Transient
	private Integer drwid;
    @Transient
    private Integer drawId2;
    @Transient
	private Double jackpot2;
    @Transient
    private String closeHour2;
    @Transient
    private String closeMinute2;
    @Transient
    private String closeDate2;
    @Transient
    private String closeDate1;

    public DrawPk getDrawPk() {
        return drawPk;
    }

    public Draw() {
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Double getJackpot() {
        return jackpot;
    }

    public void setJackpot(Double jackpot) {
        this.jackpot = jackpot;
    }

    public Double getGross11() {
        return gross11;
    }

    public void setGross11(Double gross11) {
        this.gross11 = gross11;
    }

    public String getCloseHour() {
        return (closeHour!=null)?StringUtils.leftPad(closeHour+"", 2, '0'):"";
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getCloseMinute() {
        return (closeMinute!=null)?StringUtils.leftPad(closeMinute+"", 2, '0'):"";
    }

    public void setCloseMinute(String closeMinute) {
        this.closeMinute = closeMinute;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Integer getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Integer openHour) {
        this.openHour = openHour;
    }

    public Integer getOpenMinute() {
        return openMinute;
    }

    public void setOpenMinute(Integer openMinute) {
        this.openMinute = openMinute;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getDrOficial() {
        return drOficial;
    }

    public void setDrOficial(Integer drOficial) {
        this.drOficial = drOficial;
    }

    public Integer getDrawFlag() {
        return drawFlag;
    }

    public void setDrawFlag(Integer drawFlag) {
        this.drawFlag = drawFlag;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setDrawPk(DrawPk drawPk) {
        this.drawPk = drawPk;
    }

    public Double getDrAddonGross1() {
        return drAddonGross1;
    }

    public void setDrAddonGross1(Double drAddonGross1) {
        this.drAddonGross1 = drAddonGross1;
    }

    public String getDrAddonResult2() {
        return drAddonResult2;
    }

    public void setDrAddonResult2(String drAddonResult2) {
        this.drAddonResult2 = drAddonResult2;
    }

    public Integer getDrwid() {
		return drwid;
	}

	public void setDrwid(Integer drwid) {
		this.drwid = drwid;
	}

	public Integer getDrawId2() {
		return drawId2;
	}

	public void setDrawId2(Integer drawId2) {
		this.drawId2 = drawId2;
	}

	public Double getJackpot2() {
		return jackpot2;
	}

	public void setJackpot2(Double jackpot2) {
		this.jackpot2 = jackpot2;
	}

	public String getCloseHour2() {
		return closeHour2;
	}

	public void setCloseHour2(String closeHour2) {
		this.closeHour2 = closeHour2;
	}

	public String getCloseMinute2() {
		return closeMinute2;
	}

	public void setCloseMinute2(String closeMinute2) {
		this.closeMinute2 = closeMinute2;
	}

	public String getCloseDate2() {
		return closeDate2;
	}

	public void setCloseDate2(String closeDate2) {
		this.closeDate2 = closeDate2;
	}

	public String getCloseDate1() {
		return closeDate1;
	}

	public void setCloseDate1(String closeDate1) {
		this.closeDate1 = closeDate1;
	}
	
	
	public String getDrAddonResult1() {
		return drAddonResult1;
	}

	public void setDrAddonResult1(String drAddonResult1) {
		this.drAddonResult1 = drAddonResult1;
	}

	@Override
    public String toString() {
        return " drawPk:" + drawPk + " drawDate:" + drawDate + " result:" + result + " additional:" + additional + " extra:" + extra + " jackpot:" + jackpot + " gross11:"
                + gross11 + " closeHour:" + closeHour + " closeMinute:" + closeMinute + " openDate:" + openDate + " openHour:" + openHour + " openMinute:" + openMinute
                + " closeDate:" + closeDate + " drOficial:" + drOficial + " drawFlag:" + drawFlag + " drAddonGross1:" + drAddonGross1 + " drAddonResult2:" + drAddonResult2 + " drAddonResult1:" + drAddonResult1;
    }
}