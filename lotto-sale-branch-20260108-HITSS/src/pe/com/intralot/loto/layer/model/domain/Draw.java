package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DRAW database table.
 * 
 */
@Entity
@Table(name="LOTOCARD.DRAW")
public class Draw implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DrawPK id;

	@Column(name="DR_ADDITIONAL")
	private String drAdditional;

	@Column(name="DR_CAT_1")
	private BigDecimal drCat1;

	@Column(name="DR_CAT_10")
	private BigDecimal drCat10;

	@Column(name="DR_CAT_11")
	private BigDecimal drCat11;

	@Column(name="DR_CAT_2")
	private BigDecimal drCat2;

	@Column(name="DR_CAT_3")
	private BigDecimal drCat3;

	@Column(name="DR_CAT_4")
	private BigDecimal drCat4;

	@Column(name="DR_CAT_5")
	private BigDecimal drCat5;

	@Column(name="DR_CAT_6")
	private BigDecimal drCat6;

	@Column(name="DR_CAT_7")
	private BigDecimal drCat7;

	@Column(name="DR_CAT_8")
	private BigDecimal drCat8;

	@Column(name="DR_CAT_9")
	private BigDecimal drCat9;

	@Column(name="DR_CAT_TOTAL")
	private BigDecimal drCatTotal;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_CLOSE_DATE")
	private Date drCloseDate;

	@Column(name="DR_CLOSE_HOUR")
	private BigDecimal drCloseHour;

	@Column(name="DR_CLOSE_MINUTE")
	private BigDecimal drCloseMinute;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_DATE")
	private Date drDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_DATE_UPDATE")
	private Date drDateUpdate;

	@Column(name="DR_DRAW_FLAG")
	private BigDecimal drDrawFlag;

	@Column(name="DR_EDITION_ID")
	private BigDecimal drEditionId;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_EXPIRATION_2X1_DATE")
	private Date drExpiration2x1Date;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_EXPIRATION_FREE_DATE")
	private Date drExpirationFreeDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_EXPIRATION_PRIZE_DATE")
	private Date drExpirationPrizeDate;

	@Column(name="DR_EXTRA")
	private String drExtra;

	@Column(name="DR_GROSS_1")
	private BigDecimal drGross1;

	@Column(name="DR_GROSS_10")
	private BigDecimal drGross10;

	@Column(name="DR_GROSS_11")
	private BigDecimal drGross11;

	@Column(name="DR_GROSS_2")
	private BigDecimal drGross2;

	@Column(name="DR_GROSS_3")
	private BigDecimal drGross3;

	@Column(name="DR_GROSS_4")
	private BigDecimal drGross4;

	@Column(name="DR_GROSS_5")
	private BigDecimal drGross5;

	@Column(name="DR_GROSS_6")
	private BigDecimal drGross6;

	@Column(name="DR_GROSS_7")
	private BigDecimal drGross7;

	@Column(name="DR_GROSS_8")
	private BigDecimal drGross8;

	@Column(name="DR_GROSS_9")
	private BigDecimal drGross9;

	@Column(name="DR_GROSS_TOTAL")
	private BigDecimal drGrossTotal;

	@Column(name="DR_JACKPOT")
	private BigDecimal drJackpot;

	@Column(name="DR_MESSAGE")
	private String drMessage;

	@Column(name="DR_NET_1")
	private BigDecimal drNet1;

	@Column(name="DR_NET_10")
	private BigDecimal drNet10;

	@Column(name="DR_NET_11")
	private BigDecimal drNet11;

	@Column(name="DR_NET_2")
	private BigDecimal drNet2;

	@Column(name="DR_NET_3")
	private BigDecimal drNet3;

	@Column(name="DR_NET_4")
	private BigDecimal drNet4;

	@Column(name="DR_NET_5")
	private BigDecimal drNet5;

	@Column(name="DR_NET_6")
	private BigDecimal drNet6;

	@Column(name="DR_NET_7")
	private BigDecimal drNet7;

	@Column(name="DR_NET_8")
	private BigDecimal drNet8;

	@Column(name="DR_NET_9")
	private BigDecimal drNet9;

	@Column(name="DR_NUMBERS")
	private String drNumbers;

	@Column(name="DR_OFICIAL")
	private BigDecimal drOficial;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_OPEN_DATE")
	private Date drOpenDate;

	@Column(name="DR_OPEN_HOUR")
	private BigDecimal drOpenHour;

	@Column(name="DR_OPEN_MINUTE")
	private BigDecimal drOpenMinute;

	@Column(name="DR_PERCENT")
	private BigDecimal drPercent;

	@Column(name="DR_PRICE")
	private BigDecimal drPrice;

	@Column(name="DR_PRINTED_1")
	private String drPrinted1;

	@Column(name="DR_PRINTED_10")
	private String drPrinted10;

	@Column(name="DR_PRINTED_11")
	private String drPrinted11;

	@Column(name="DR_PRINTED_2")
	private String drPrinted2;

	@Column(name="DR_PRINTED_3")
	private String drPrinted3;

	@Column(name="DR_PRINTED_4")
	private String drPrinted4;

	@Column(name="DR_PRINTED_5")
	private String drPrinted5;

	@Column(name="DR_PRINTED_6")
	private String drPrinted6;

	@Column(name="DR_PRINTED_7")
	private String drPrinted7;

	@Column(name="DR_PRINTED_8")
	private String drPrinted8;

	@Column(name="DR_PRINTED_9")
	private String drPrinted9;

	@Column(name="DR_PROMOTION")
	private String drPromotion;

	@Column(name="DR_RESULT")
	private String drResult;

	@Temporal(TemporalType.DATE)
	@Column(name="DR_RESULT_DATE")
	private Date drResultDate;

	@Column(name="DR_SMS_MESSAGE_1")
	private String drSmsMessage1;

	@Column(name="DR_SMS_MESSAGE_2")
	private String drSmsMessage2;

	@Column(name="DR_TICKETS")
	private BigDecimal drTickets;

	@Column(name="DR_USER_UPDATE")
	private String drUserUpdate;
	
	@Column(name="DR_ADDON_RESULT_2")
	private String drAddonResult2;

	@Column(name="DR_CAT_15")
	private BigDecimal drCat15;

	@Column(name="DR_CAT_16")
	private BigDecimal drCat16;
	
	@Column(name="DR_ADDON_RESULT_1")
	private String drAddonResult1;
	
	
	public DrawPK getId() {
		return this.id;
	}

	public void setId(DrawPK id) {
		this.id = id;
	}

	public String getDrAdditional() {
		return this.drAdditional;
	}

	public void setDrAdditional(String drAdditional) {
		this.drAdditional = drAdditional;
	}

	public BigDecimal getDrCat1() {
		return this.drCat1;
	}

	public void setDrCat1(BigDecimal drCat1) {
		this.drCat1 = drCat1;
	}

	public BigDecimal getDrCat10() {
		return this.drCat10;
	}

	public void setDrCat10(BigDecimal drCat10) {
		this.drCat10 = drCat10;
	}

	public BigDecimal getDrCat11() {
		return this.drCat11;
	}

	public void setDrCat11(BigDecimal drCat11) {
		this.drCat11 = drCat11;
	}

	public BigDecimal getDrCat2() {
		return this.drCat2;
	}

	public void setDrCat2(BigDecimal drCat2) {
		this.drCat2 = drCat2;
	}

	public BigDecimal getDrCat3() {
		return this.drCat3;
	}

	public void setDrCat3(BigDecimal drCat3) {
		this.drCat3 = drCat3;
	}

	public BigDecimal getDrCat4() {
		return this.drCat4;
	}

	public void setDrCat4(BigDecimal drCat4) {
		this.drCat4 = drCat4;
	}

	public BigDecimal getDrCat5() {
		return this.drCat5;
	}

	public void setDrCat5(BigDecimal drCat5) {
		this.drCat5 = drCat5;
	}

	public BigDecimal getDrCat6() {
		return this.drCat6;
	}

	public void setDrCat6(BigDecimal drCat6) {
		this.drCat6 = drCat6;
	}

	public BigDecimal getDrCat7() {
		return this.drCat7;
	}

	public void setDrCat7(BigDecimal drCat7) {
		this.drCat7 = drCat7;
	}

	public BigDecimal getDrCat8() {
		return this.drCat8;
	}

	public void setDrCat8(BigDecimal drCat8) {
		this.drCat8 = drCat8;
	}

	public BigDecimal getDrCat9() {
		return this.drCat9;
	}

	public void setDrCat9(BigDecimal drCat9) {
		this.drCat9 = drCat9;
	}

	public BigDecimal getDrCatTotal() {
		return this.drCatTotal;
	}

	public void setDrCatTotal(BigDecimal drCatTotal) {
		this.drCatTotal = drCatTotal;
	}

	public Date getDrCloseDate() {
		return this.drCloseDate;
	}

	public void setDrCloseDate(Date drCloseDate) {
		this.drCloseDate = drCloseDate;
	}

	public BigDecimal getDrCloseHour() {
		return this.drCloseHour;
	}

	public void setDrCloseHour(BigDecimal drCloseHour) {
		this.drCloseHour = drCloseHour;
	}

	public BigDecimal getDrCloseMinute() {
		return this.drCloseMinute;
	}

	public void setDrCloseMinute(BigDecimal drCloseMinute) {
		this.drCloseMinute = drCloseMinute;
	}

	public Date getDrDate() {
		return this.drDate;
	}

	public void setDrDate(Date drDate) {
		this.drDate = drDate;
	}

	public Date getDrDateUpdate() {
		return this.drDateUpdate;
	}

	public void setDrDateUpdate(Date drDateUpdate) {
		this.drDateUpdate = drDateUpdate;
	}

	public BigDecimal getDrDrawFlag() {
		return this.drDrawFlag;
	}

	public void setDrDrawFlag(BigDecimal drDrawFlag) {
		this.drDrawFlag = drDrawFlag;
	}

	public BigDecimal getDrEditionId() {
		return this.drEditionId;
	}

	public void setDrEditionId(BigDecimal drEditionId) {
		this.drEditionId = drEditionId;
	}

	public Date getDrExpiration2x1Date() {
		return this.drExpiration2x1Date;
	}

	public void setDrExpiration2x1Date(Date drExpiration2x1Date) {
		this.drExpiration2x1Date = drExpiration2x1Date;
	}

	public Date getDrExpirationFreeDate() {
		return this.drExpirationFreeDate;
	}

	public void setDrExpirationFreeDate(Date drExpirationFreeDate) {
		this.drExpirationFreeDate = drExpirationFreeDate;
	}

	public Date getDrExpirationPrizeDate() {
		return this.drExpirationPrizeDate;
	}

	public void setDrExpirationPrizeDate(Date drExpirationPrizeDate) {
		this.drExpirationPrizeDate = drExpirationPrizeDate;
	}

	public String getDrExtra() {
		return this.drExtra;
	}

	public void setDrExtra(String drExtra) {
		this.drExtra = drExtra;
	}

	public BigDecimal getDrGross1() {
		return this.drGross1;
	}

	public void setDrGross1(BigDecimal drGross1) {
		this.drGross1 = drGross1;
	}

	public BigDecimal getDrGross10() {
		return this.drGross10;
	}

	public void setDrGross10(BigDecimal drGross10) {
		this.drGross10 = drGross10;
	}

	public BigDecimal getDrGross11() {
		return this.drGross11;
	}

	public void setDrGross11(BigDecimal drGross11) {
		this.drGross11 = drGross11;
	}

	public BigDecimal getDrGross2() {
		return this.drGross2;
	}

	public void setDrGross2(BigDecimal drGross2) {
		this.drGross2 = drGross2;
	}

	public BigDecimal getDrGross3() {
		return this.drGross3;
	}

	public void setDrGross3(BigDecimal drGross3) {
		this.drGross3 = drGross3;
	}

	public BigDecimal getDrGross4() {
		return this.drGross4;
	}

	public void setDrGross4(BigDecimal drGross4) {
		this.drGross4 = drGross4;
	}

	public BigDecimal getDrGross5() {
		return this.drGross5;
	}

	public void setDrGross5(BigDecimal drGross5) {
		this.drGross5 = drGross5;
	}

	public BigDecimal getDrGross6() {
		return this.drGross6;
	}

	public void setDrGross6(BigDecimal drGross6) {
		this.drGross6 = drGross6;
	}

	public BigDecimal getDrGross7() {
		return this.drGross7;
	}

	public void setDrGross7(BigDecimal drGross7) {
		this.drGross7 = drGross7;
	}

	public BigDecimal getDrGross8() {
		return this.drGross8;
	}

	public void setDrGross8(BigDecimal drGross8) {
		this.drGross8 = drGross8;
	}

	public BigDecimal getDrGross9() {
		return this.drGross9;
	}

	public void setDrGross9(BigDecimal drGross9) {
		this.drGross9 = drGross9;
	}

	public BigDecimal getDrGrossTotal() {
		return this.drGrossTotal;
	}

	public void setDrGrossTotal(BigDecimal drGrossTotal) {
		this.drGrossTotal = drGrossTotal;
	}

	public BigDecimal getDrJackpot() {
		return this.drJackpot;
	}

	public void setDrJackpot(BigDecimal drJackpot) {
		this.drJackpot = drJackpot;
	}

	public String getDrMessage() {
		return this.drMessage;
	}

	public void setDrMessage(String drMessage) {
		this.drMessage = drMessage;
	}

	public BigDecimal getDrNet1() {
		return this.drNet1;
	}

	public void setDrNet1(BigDecimal drNet1) {
		this.drNet1 = drNet1;
	}

	public BigDecimal getDrNet10() {
		return this.drNet10;
	}

	public void setDrNet10(BigDecimal drNet10) {
		this.drNet10 = drNet10;
	}

	public BigDecimal getDrNet11() {
		return this.drNet11;
	}

	public void setDrNet11(BigDecimal drNet11) {
		this.drNet11 = drNet11;
	}

	public BigDecimal getDrNet2() {
		return this.drNet2;
	}

	public void setDrNet2(BigDecimal drNet2) {
		this.drNet2 = drNet2;
	}

	public BigDecimal getDrNet3() {
		return this.drNet3;
	}

	public void setDrNet3(BigDecimal drNet3) {
		this.drNet3 = drNet3;
	}

	public BigDecimal getDrNet4() {
		return this.drNet4;
	}

	public void setDrNet4(BigDecimal drNet4) {
		this.drNet4 = drNet4;
	}

	public BigDecimal getDrNet5() {
		return this.drNet5;
	}

	public void setDrNet5(BigDecimal drNet5) {
		this.drNet5 = drNet5;
	}

	public BigDecimal getDrNet6() {
		return this.drNet6;
	}

	public void setDrNet6(BigDecimal drNet6) {
		this.drNet6 = drNet6;
	}

	public BigDecimal getDrNet7() {
		return this.drNet7;
	}

	public void setDrNet7(BigDecimal drNet7) {
		this.drNet7 = drNet7;
	}

	public BigDecimal getDrNet8() {
		return this.drNet8;
	}

	public void setDrNet8(BigDecimal drNet8) {
		this.drNet8 = drNet8;
	}

	public BigDecimal getDrNet9() {
		return this.drNet9;
	}

	public void setDrNet9(BigDecimal drNet9) {
		this.drNet9 = drNet9;
	}

	public String getDrNumbers() {
		return this.drNumbers;
	}

	public void setDrNumbers(String drNumbers) {
		this.drNumbers = drNumbers;
	}

	public BigDecimal getDrOficial() {
		return this.drOficial;
	}

	public void setDrOficial(BigDecimal drOficial) {
		this.drOficial = drOficial;
	}

	public Date getDrOpenDate() {
		return this.drOpenDate;
	}

	public void setDrOpenDate(Date drOpenDate) {
		this.drOpenDate = drOpenDate;
	}

	public BigDecimal getDrOpenHour() {
		return this.drOpenHour;
	}

	public void setDrOpenHour(BigDecimal drOpenHour) {
		this.drOpenHour = drOpenHour;
	}

	public BigDecimal getDrOpenMinute() {
		return this.drOpenMinute;
	}

	public void setDrOpenMinute(BigDecimal drOpenMinute) {
		this.drOpenMinute = drOpenMinute;
	}

	public BigDecimal getDrPercent() {
		return this.drPercent;
	}

	public void setDrPercent(BigDecimal drPercent) {
		this.drPercent = drPercent;
	}

	public BigDecimal getDrPrice() {
		return this.drPrice;
	}

	public void setDrPrice(BigDecimal drPrice) {
		this.drPrice = drPrice;
	}

	public String getDrPrinted1() {
		return this.drPrinted1;
	}

	public void setDrPrinted1(String drPrinted1) {
		this.drPrinted1 = drPrinted1;
	}

	public String getDrPrinted10() {
		return this.drPrinted10;
	}

	public void setDrPrinted10(String drPrinted10) {
		this.drPrinted10 = drPrinted10;
	}

	public String getDrPrinted11() {
		return this.drPrinted11;
	}

	public void setDrPrinted11(String drPrinted11) {
		this.drPrinted11 = drPrinted11;
	}

	public String getDrPrinted2() {
		return this.drPrinted2;
	}

	public void setDrPrinted2(String drPrinted2) {
		this.drPrinted2 = drPrinted2;
	}

	public String getDrPrinted3() {
		return this.drPrinted3;
	}

	public void setDrPrinted3(String drPrinted3) {
		this.drPrinted3 = drPrinted3;
	}

	public String getDrPrinted4() {
		return this.drPrinted4;
	}

	public void setDrPrinted4(String drPrinted4) {
		this.drPrinted4 = drPrinted4;
	}

	public String getDrPrinted5() {
		return this.drPrinted5;
	}

	public void setDrPrinted5(String drPrinted5) {
		this.drPrinted5 = drPrinted5;
	}

	public String getDrPrinted6() {
		return this.drPrinted6;
	}

	public void setDrPrinted6(String drPrinted6) {
		this.drPrinted6 = drPrinted6;
	}

	public String getDrPrinted7() {
		return this.drPrinted7;
	}

	public void setDrPrinted7(String drPrinted7) {
		this.drPrinted7 = drPrinted7;
	}

	public String getDrPrinted8() {
		return this.drPrinted8;
	}

	public void setDrPrinted8(String drPrinted8) {
		this.drPrinted8 = drPrinted8;
	}

	public String getDrPrinted9() {
		return this.drPrinted9;
	}

	public void setDrPrinted9(String drPrinted9) {
		this.drPrinted9 = drPrinted9;
	}

	public String getDrPromotion() {
		return this.drPromotion;
	}

	public void setDrPromotion(String drPromotion) {
		this.drPromotion = drPromotion;
	}

	public String getDrResult() {
		return this.drResult;
	}

	public void setDrResult(String drResult) {
		this.drResult = drResult;
	}

	public Date getDrResultDate() {
		return this.drResultDate;
	}

	public void setDrResultDate(Date drResultDate) {
		this.drResultDate = drResultDate;
	}

	public String getDrSmsMessage1() {
		return this.drSmsMessage1;
	}

	public void setDrSmsMessage1(String drSmsMessage1) {
		this.drSmsMessage1 = drSmsMessage1;
	}

	public String getDrSmsMessage2() {
		return this.drSmsMessage2;
	}

	public void setDrSmsMessage2(String drSmsMessage2) {
		this.drSmsMessage2 = drSmsMessage2;
	}

	public BigDecimal getDrTickets() {
		return this.drTickets;
	}

	public void setDrTickets(BigDecimal drTickets) {
		this.drTickets = drTickets;
	}

	public String getDrUserUpdate() {
		return this.drUserUpdate;
	}

	public void setDrUserUpdate(String drUserUpdate) {
		this.drUserUpdate = drUserUpdate;
	}

	public String getDrAddonResult2() {
		return drAddonResult2;
	}

	public void setDrAddonResult2(String drAddonResult2) {
		this.drAddonResult2 = drAddonResult2;
	}

	public BigDecimal getDrCat15() {
		return drCat15;
	}

	public void setDrCat15(BigDecimal drCat15) {
		this.drCat15 = drCat15;
	}

	public BigDecimal getDrCat16() {
		return drCat16;
	}

	public void setDrCat16(BigDecimal drCat16) {
		this.drCat16 = drCat16;
	}

	public String getDrAddonResult1() {
		return drAddonResult1;
	}

	public void setDrAddonResult1(String drAddonResult1) {
		this.drAddonResult1 = drAddonResult1;
	}
	

}