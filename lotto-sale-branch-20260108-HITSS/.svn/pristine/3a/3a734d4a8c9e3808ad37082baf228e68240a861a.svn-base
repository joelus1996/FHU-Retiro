package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

import pe.com.intralot.loto.lib.StringLib;

@Entity
@NamedNativeQuery(
				
		name = "TICKETSALE_GETCLIENTTICKET",
		query = "{ call LOTOCARD.TICKETSALE.GETCLIENTTICKET_2(?,?,?,?) }",
		callable = true,
		resultClass = TicketProcedureGetClientTicket.class
)
public class TicketProcedureGetClientTicket {
	
	@Id
	@Column(name = "p_ctticketid")
	private String ctTicketId;
	
	@Column(name = "p_ctclientid")
	private String ctClientId;
	
	@Column(name = "p_ticketnum")
	private String ctTicketNumber;
	
	@Column(name = "p_ctgameid")
	private String ctGameId;
	
	@Column(name = "p_ticketdate")
	private String ctTicketDate;
	
	@Column(name = "p_zonecd")
	private String ctZoneCd;
	
	@Column(name = "p_sectorcd")
	private String ctSectorCd;
	
	@Column(name = "p_agencycd")
	private String ctAgencyCd;
	
	@Column(name = "p_terminalnr")
	private String ctTerminalNr;
	
	@Column(name = "p_receiptnr")
	private Integer ctReceiptNr;
	
	@Column(name = "p_trnsnum")
	private String ctTrnsNum;
	
	@Column(name = "p_crc")
	private Integer ctCrc;
	
	@Column(name = "p_numcolumns")
	private Integer ctNumColumns;
	
	@Column(name = "p_betmatrix1")
	private String ctBetMatrix1;
	
	@Column(name = "p_betmatrix2")
	private String ctBetMatrix2;
	
	@Column(name = "p_betmatrix3")
	private String ctBetMatrix3;
	
	@Column(name = "p_betmatrix4")
	private String ctBetMatrix4;
	
	@Column(name = "p_receiptamount")
	private Double ctReceiptAmount;
	
	@Column(name = "p_receiptdiscounted")
	private Double ctReceiptDiscounted;
	
	@Column(name = "p_drawid")
	private Integer ctDrawId;
	
	@Column(name = "p_fromdraw")
	private Integer ctFromDraw;
	
	@Column(name = "p_todraw")
	private Integer ctToDraw;
	
	@Column(name = "p_saletype")
	private String ctSaleType;
	
	@Column(name = "p_todrawdate")
	private String ctToDrawDate;
	
	@Column(name = "p_fromdrawdate")
	private String ctFromDrawDate;
	
	@Column(name = "p_betmultia")
	private Integer ctBetMultiA;
	
	@Column(name = "p_bet3exacta")
	private Integer ctBet3exactA;
	
	@Column(name = "p_bet3anya")
	private Integer ctBet3anyA;
	
	@Column(name = "p_bet2exacta")
	private Integer ctBet2exactA;
	
	@Column(name = "p_bet1exacta")
	private Integer ctBet1exactA;
	
	@Column(name = "p_betmultib")
	private Integer ctBetMultiB;
	
	@Column(name = "p_bet3exactb")
	private Integer ctBet3exactB;
	
	@Column(name = "p_bet3anyb")
	private Integer ctBet3anyB;
	
	@Column(name = "p_bet2exactb")
	private Integer ctBet2exactB;
	
	@Column(name = "p_bet1exactb")
	private Integer ctBet1exactB;
	
	@Column(name = "p_max_amount_winner")
	private Double ctMaxAmountWinner;

	@Column(name = "p_multiplier")
	private Integer ctMultiplier;
	
	@Column(name = "p_combined")
	private String ctCombined;
	
	@Column(name = "p_prizeflag")
	private String ctPrizeFlag;
	
	@Column(name = "p_twdefineprize")
	private String ctTwDefinePrize;
	
	@Column(name = "p_twprizeflag")
	private String ctTwPrizeFlag;
	
	@Column(name = "p_twprizeamount")
	private Double ctTwPrizeAmount;
	
	@Column(name = "p_twcashdate")
	private String ctTwCashDate;
	
	@Column(name = "p_comdocnum")
	private String ctComDocNum;
	
	@Column(name = "p_comname")
	private String ctComName;
	
	@Column(name = "p_eventitems")
	private String ctEventItems;
	
	@Column(name = "p_twfree_columns")
	private Double twTwfreeColumns;
	
	@Column(name = "p_tw2x1_columns")
	private Double tw2x1Columns;
	
	@Column(name = "p_prize_expiration_date")
	private String ctPrizeExpirationDate;
	
	@Column(name = "p_free_expiration_date")
	private String ctFreeExpirationDate;
	
	@Column(name = "p_2x1_expiration_date")
	private String ct2x1ExpirationDate;	
	
	@Column(name = "p_twdraw_id")
	private Integer twDrawId;	
	
	@Column(name = "p_inprintedprice")
	private Double inPrintedPrice;	
	
	@Column(name = "p_ctaddon_1")
	private String ctAddOn1;	
	
	@Column(name = "p_ctaddon_2")
	private String ctAddOn2;	
	
	@Column(name = "p_ctaddon_3")
	private String ctAddOn3;	
	
	@Column(name = "p_ctaddon_4")
	private String ctAddOn4;
	
	@Column(name = "p_game_name")
	private String gameName;		

	@Column(name = "p_crc_v")
	private Integer crc_v;	
	
	@Column(name="p_last_draw")
	private Integer lastDraw;
	
	public String getCtClientId() {
		return ctClientId;
	}

	public void setCtClientId(String ctClientId) {
		this.ctClientId = ctClientId;
	}

	public String getCtTicketNumber() {
		return ctTicketNumber;
	}

	public void setCtTicketNumber(String ctTicketNumber) {
		this.ctTicketNumber = ctTicketNumber;
	}	

	public String getCtTicketId() {
		return ctTicketId;
	}

	public void setCtTicketId(String ctTicketId) {
		this.ctTicketId = ctTicketId;
	}

	public String getCtGameId() {
		return ctGameId;
	}

	public void setCtGameId(String ctGameId) {
		this.ctGameId = ctGameId;
	}

	public String getCtTicketDate() {
		return ctTicketDate;
	}

	public void setCtTicketDate(String ctTicketDate) {
		this.ctTicketDate = ctTicketDate;
	}

	public String getCtZoneCd() {
		return ctZoneCd;
	}

	public void setCtZoneCd(String ctZoneCd) {
		this.ctZoneCd = ctZoneCd;
	}

	public String getCtSectorCd() {
		return ctSectorCd;
	}

	public void setCtSectorCd(String ctSectorCd) {
		this.ctSectorCd = ctSectorCd;
	}

	public String getCtAgencyCd() {
		return ctAgencyCd;
	}

	public void setCtAgencyCd(String ctAgencyCd) {
		this.ctAgencyCd = ctAgencyCd;
	}

	public String getCtTerminalNr() {
		return ctTerminalNr;
	}

	public void setCtTerminalNr(String ctTerminalNr) {
		this.ctTerminalNr = ctTerminalNr;
	}

	public Integer getCtReceiptNr() {
		return ctReceiptNr;
	}

	public void setCtReceiptNr(Integer ctReceiptNr) {
		this.ctReceiptNr = ctReceiptNr;
	}

	public String getCtTrnsNum() {
		return ctTrnsNum;
	}

	public void setCtTrnsNum(String ctTrnsNum) {
		this.ctTrnsNum = ctTrnsNum;
	}

	public Integer getCtCrc() {
		return ctCrc;
	}

	public void setCtCrc(Integer ctCrc) {
		this.ctCrc = ctCrc;
	}

	public Integer getCtNumColumns() {
		return ctNumColumns;
	}

	public void setCtNumColumns(Integer ctNumColumns) {
		this.ctNumColumns = ctNumColumns;
	}

	public String getCtBetMatrix1() {
		return ctBetMatrix1;
	}

	public void setCtBetMatrix1(String ctBetMatrix1) {
		this.ctBetMatrix1 = ctBetMatrix1;
	}

	public String getCtBetMatrix2() {
		return ctBetMatrix2;
	}

	public void setCtBetMatrix2(String ctBetMatrix2) {
		this.ctBetMatrix2 = ctBetMatrix2;
	}

	public String getCtBetMatrix3() {
		return ctBetMatrix3;
	}

	public void setCtBetMatrix3(String ctBetMatrix3) {
		this.ctBetMatrix3 = ctBetMatrix3;
	}

	public String getCtBetMatrix4() {
		return ctBetMatrix4;
	}

	public void setCtBetMatrix4(String ctBetMatrix4) {
		this.ctBetMatrix4 = ctBetMatrix4;
	}

	public Double getCtReceiptAmount() {
		return ctReceiptAmount;
	}

	public void setCtReceiptAmount(Double ctReceiptAmount) {
		this.ctReceiptAmount = ctReceiptAmount;
	}

	public Double getCtReceiptDiscounted() {
		return ctReceiptDiscounted;
	}

	public void setCtReceiptDiscounted(Double ctReceiptDiscounted) {
		this.ctReceiptDiscounted = ctReceiptDiscounted;
	}

	public Integer getCtFromDraw() {
		return ctFromDraw;
	}

	public void setCtFromDraw(Integer ctFromDraw) {
		this.ctFromDraw = ctFromDraw;
	}

	public Integer getCtToDraw() {
		return ctToDraw;
	}

	public void setCtToDraw(Integer ctToDraw) {
		this.ctToDraw = ctToDraw;
	}

	public String getCtSaleType() {
		return ctSaleType;
	}

	public void setCtSaleType(String ctSaleType) {
		this.ctSaleType = ctSaleType;
	}

	public String getCtToDrawDate() {
		return ctToDrawDate;
	}

	public void setCtToDrawDate(String ctToDrawDate) {
		this.ctToDrawDate = ctToDrawDate;
	}

	public String getCtFromDrawDate() {
		return ctFromDrawDate;
	}

	public void setCtFromDrawDate(String ctFromDrawDate) {
		this.ctFromDrawDate = ctFromDrawDate;
	}

	public Integer getCtBetMultiA() {
		return ctBetMultiA;
	}

	public void setCtBetMultiA(Integer ctBetMultiA) {
		this.ctBetMultiA = ctBetMultiA;
	}

	public Integer getCtBet3exactA() {
		return ctBet3exactA;
	}

	public void setCtBet3exactA(Integer ctBet3exactA) {
		this.ctBet3exactA = ctBet3exactA;
	}

	public Integer getCtBet3anyA() {
		return ctBet3anyA;
	}

	public void setCtBet3anyA(Integer ctBet3anyA) {
		this.ctBet3anyA = ctBet3anyA;
	}

	public Integer getCtBet2exactA() {
		return ctBet2exactA;
	}

	public void setCtBet2exactA(Integer ctBet2exactA) {
		this.ctBet2exactA = ctBet2exactA;
	}

	public Integer getCtBet1exactA() {
		return ctBet1exactA;
	}

	public void setCtBet1exactA(Integer ctBet1exactA) {
		this.ctBet1exactA = ctBet1exactA;
	}

	public Integer getCtBetMultiB() {
		return ctBetMultiB;
	}

	public void setCtBetMultiB(Integer ctBetMultiB) {
		this.ctBetMultiB = ctBetMultiB;
	}

	public Integer getCtBet3exactB() {
		return ctBet3exactB;
	}

	public void setCtBet3exactB(Integer ctBet3exactB) {
		this.ctBet3exactB = ctBet3exactB;
	}

	public Integer getCtBet3anyB() {
		return ctBet3anyB;
	}

	public void setCtBet3anyB(Integer ctBet3anyB) {
		this.ctBet3anyB = ctBet3anyB;
	}

	public Integer getCtBet2exactB() {
		return ctBet2exactB;
	}

	public void setCtBet2exactB(Integer ctBet2exactB) {
		this.ctBet2exactB = ctBet2exactB;
	}

	public Integer getCtBet1exactB() {
		return ctBet1exactB;
	}

	public void setCtBet1exactB(Integer ctBet1exactB) {
		this.ctBet1exactB = ctBet1exactB;
	}
	
	public Double getCtMaxAmountWinner() {
		return ctMaxAmountWinner;
	}

	public void setCtMaxAmountWinner(Double ctMaxAmountWinner) {
		this.ctMaxAmountWinner = ctMaxAmountWinner;
	}

	public int getCtGameNumber() {
		int gameNumber;
		try { gameNumber = Integer.parseInt(ctGameId); } 
		catch(Exception e) { gameNumber=0; }
		return gameNumber;
	}
	
	public Integer getCtDrawId() {
		return ctDrawId;
	}

	public void setCtDrawId(Integer ctDrawId) {
		this.ctDrawId = ctDrawId;
	}

	public Integer getCtMultiplier() {
		return ctMultiplier;
	}

	public void setCtMultiplier(Integer ctMultiplier) {
		this.ctMultiplier = ctMultiplier;
	}

	public String getCtCombined() {
		return ctCombined;
	}

	public void setCtCombined(String ctCombined) {
		this.ctCombined = ctCombined;
	}

	public String getCtPrizeFlag() {
		return ctPrizeFlag;
	}

	public void setCtPrizeFlag(String ctPrizeFlag) {
		this.ctPrizeFlag = ctPrizeFlag;
	}

	public String getCtTwDefinePrize() {
		return ctTwDefinePrize;
	}

	public void setCtTwDefinePrize(String ctTwDefinePrize) {
		this.ctTwDefinePrize = ctTwDefinePrize;
	}

	public String getCtTwPrizeFlag() {
		return ctTwPrizeFlag;
	}

	public void setCtTwPrizeFlag(String ctTwPrizeFlag) {
		this.ctTwPrizeFlag = ctTwPrizeFlag;
	}

	public Double getCtTwPrizeAmount() {
		return ctTwPrizeAmount;
	}

	public void setCtTwPrizeAmount(Double ctTwPrizeAmount) {
		this.ctTwPrizeAmount = ctTwPrizeAmount;
	}

	public String getCtTwCashDate() {
		return ctTwCashDate;
	}

	public void setCtTwCashDate(String ctTwCashDate) {
		this.ctTwCashDate = ctTwCashDate;
	}

	public String getCtComDocNum() {
		return ctComDocNum;
	}

	public void setCtComDocNum(String ctComDocNum) {
		this.ctComDocNum = ctComDocNum;
	}

	public String getCtComName() {
		return ctComName;
	}

	public void setCtComName(String ctComName) {
		this.ctComName = ctComName;
	}

	public String getCtEventItems() {
		return ctEventItems;
	}

	public void setCtEventItems(String ctEventItems) {
		this.ctEventItems = ctEventItems;
	}
	
	public Double getTwTwfreeColumns() {
		return twTwfreeColumns;
	}

	public void setTwTwfreeColumns(Double twTwfreeColumns) {
		this.twTwfreeColumns = twTwfreeColumns;
	}

	public Double getTw2x1Columns() {
		return tw2x1Columns;
	}

	public void setTw2x1Columns(Double tw2x1Columns) {
		this.tw2x1Columns = tw2x1Columns;
	}

	public String getCtPrizeExpirationDate() {
		return ctPrizeExpirationDate;
	}

	public void setCtPrizeExpirationDate(String ctPrizeExpirationDate) {
		this.ctPrizeExpirationDate = ctPrizeExpirationDate;
	}

	public String getCtFreeExpirationDate() {
		return ctFreeExpirationDate;
	}

	public void setCtFreeExpirationDate(String ctFreeExpirationDate) {
		this.ctFreeExpirationDate = ctFreeExpirationDate;
	}

	public String getCt2x1ExpirationDate() {
		return ct2x1ExpirationDate;
	}

	public void setCt2x1ExpirationDate(String ct2x1ExpirationDate) {
		this.ct2x1ExpirationDate = ct2x1ExpirationDate;
	}
	
	public Integer getTwDrawId() {
		return twDrawId;
	}

	public void setTwDrawId(Integer twDrawId) {
		this.twDrawId = twDrawId;
	}	

	public Double getInPrintedPrice() {
		return inPrintedPrice;
	}

	public void setInPrintedPrice(Double inPrintedPrice) {
		this.inPrintedPrice = inPrintedPrice;
	}	

	public String getCtAddOn1() {
		return ctAddOn1;
	}

	public void setCtAddOn1(String ctAddOn1) {
		this.ctAddOn1 = ctAddOn1;
	}

	public String getCtAddOn2() {
		return ctAddOn2;
	}

	public void setCtAddOn2(String ctAddOn2) {
		this.ctAddOn2 = ctAddOn2;
	}

	public String getCtAddOn3() {
		return ctAddOn3;
	}

	public void setCtAddOn3(String ctAddOn3) {
		this.ctAddOn3 = ctAddOn3;
	}

	public String getCtAddOn4() {
		return ctAddOn4;
	}

	public void setCtAddOn4(String ctAddOn4) {
		this.ctAddOn4 = ctAddOn4;
	}
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Integer getCrc_v() {
		return crc_v;
	}

	public void setCrc_v(Integer crc_v) {
		this.crc_v = crc_v;
	}

	public String getCtTrmId() {
		return (ctZoneCd!=null?ctZoneCd:"")+
               (ctSectorCd!=null?StringLib.padLeft(ctSectorCd, '0', 2):"")+
               (ctAgencyCd!=null?StringLib.padLeft(ctAgencyCd, '0', 3):"")+
               StringLib.padLeft(ctTerminalNr, '0', 2);
	}
	
	public String getFromDrawDay() {
		String output=null;
		try { output=ctFromDrawDate==null?"":ctFromDrawDate.substring(0, 10); }
		catch(Exception e) { output=""; }
		return output;
	}
	
	public Integer getLastDraw() {
		return lastDraw;
	}

	public void setLastDraw(Integer lastDraw) {
		this.lastDraw = lastDraw;
	}

	public String toString() {
		return   " ctTicketId="+ctTicketId+
                 " ctClientId="+ctClientId+
                 " ctTicketNumber="+ctTicketNumber+
                 " ctGameId="+ctGameId+
                 " ctTicketDate="+ctTicketDate+
                 " ctZoneCd="+ctZoneCd+
                 " ctSectorCd="+ctSectorCd+
                 " ctAgencyCd="+ctAgencyCd+
                 " ctTerminalNr="+ctTerminalNr+
                 " ctReceiptNr="+ctReceiptNr+
                 " ctTrnsNum="+ctTrnsNum+
                 " ctCrc="+ctCrc+
                 " ctNumColumns="+ctNumColumns+
                 " ctBetMatrix1="+ctBetMatrix1+
                 " ctBetMatrix2="+ctBetMatrix2+
                 " ctBetMatrix3="+ctBetMatrix3+
                 " ctBetMatrix4="+ctBetMatrix4+
                 " ctReceiptAmount="+ctReceiptAmount+
                 " ctReceiptDiscounted="+ctReceiptDiscounted+
                 " ctDrawId="+ctDrawId+
                 " ctFromDraw="+ctFromDraw+
                 " ctToDraw="+ctFromDraw+
                 " ctSaleType="+ctSaleType+
                 " ctToDrawDate="+ctToDrawDate+
                 " ctFromDrawDate="+ctFromDrawDate+
                 " ctBetMultiA="+ctBetMultiA+
                 " ctBet3exactA="+ctBet3exactA+
                 " ctBet3anyA="+ctBet3anyA+
                 " ctBet2exactA="+ctBet2exactA+
                 " ctBet1exactA="+ctBet1exactA+
                 " ctBetMultiB="+ctBetMultiB+
                 " ctBet3exactB="+ctBet3exactB+
                 " ctBet3anyB="+ctBet3anyB+
                 " ctBet2exactB="+ctBet2exactB+
                 " ctBet1exactB="+ctBet1exactB+
                 " ctMaxAmountWinner="+ctMaxAmountWinner+
                 " ctMultiplier="+ctMultiplier+
                 " ctCombined="+ctCombined+
                 " ctPrizeFlag="+ctPrizeFlag+
                 " ctTwDefinePrize="+ctTwDefinePrize+
                 " ctTwPrizeFlag="+ctTwPrizeFlag+
                 " ctTwPrizeAmount="+ctTwPrizeAmount+
                 " ctTwCashDate="+ctTwCashDate+
                 " ctComDocNum="+ctComDocNum+
                 " ctComName="+ctComName+
                 " ctEventItems="+ctEventItems+
                 " twTwfreeColumns="+twTwfreeColumns+
                 " tw2x1Columns="+tw2x1Columns+
                 " ctPrizeExpirationDate="+ctPrizeExpirationDate+
                 " ctFreeExpirationDate="+ctFreeExpirationDate+
                 " ct2x1ExpirationDate="+ct2x1ExpirationDate+
                 " twDrawId="+twDrawId+
                 " inPrintedPrice="+inPrintedPrice+
                 " ctAddOn1="+ctAddOn1+	
                 " ctAddOn2="+ctAddOn2+
                 " ctAddOn3="+ctAddOn3+
                 " ctAddOn4="+ctAddOn4+
                 " gameName="+gameName+
                 " crc_v="+crc_v+
				 " lastDraw="+lastDraw;
		
	}
}
