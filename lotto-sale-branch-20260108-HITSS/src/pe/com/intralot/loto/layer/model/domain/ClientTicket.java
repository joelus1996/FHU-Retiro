package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;
import javax.persistence.*;

import pe.com.intralot.loto.lib.StringLib;


/**
 * The persistent class for the CLIENT_TICKET database table.
 * 
 */
@Entity
@Table(name="LOTOCARD.CLIENT_TICKET")
public class ClientTicket implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TICKET_ID")
	private String ticketId;

	@Column(name="CL_COM_PRINTS")
	private Integer clComPrints;

	@Column(name="CT_AGENCY_CD")
	private String ctAgencyCd;

	@Column(name="CT_BALANCE_ITEM")
	private String ctBalanceItem;

	@Column(name="CT_BALANCE_ITEM_EXT")
	private String ctBalanceItemExt;

	@Column(name="CT_BET_1EXACT_A")
	private Integer ctBet1exactA;

	@Column(name="CT_BET_1EXACT_B")
	private Integer ctBet1exactB;

	@Column(name="CT_BET_2EXACT_A")
	private Integer ctBet2exactA;

	@Column(name="CT_BET_2EXACT_B")
	private Integer ctBet2exactB;

	@Column(name="CT_BET_3ANY_A")
	private Integer ctBet3anyA;

	@Column(name="CT_BET_3ANY_B")
	private Integer ctBet3anyB;

	@Column(name="CT_BET_3EXACT_A")
	private Integer ctBet3exactA;

	@Column(name="CT_BET_3EXACT_B")
	private Integer ctBet3exactB;

	@Column(name="CT_BET_MATRIX1")
	private String ctBetMatrix1;

	@Column(name="CT_BET_MATRIX2")
	private String ctBetMatrix2;

	@Column(name="CT_BET_MATRIX3")
	private String ctBetMatrix3;

	@Column(name="CT_BET_MATRIX4")
	private String ctBetMatrix4;

	@Column(name="CT_BET_MULTI_A")
	private Integer ctBetMultiA;

	@Column(name="CT_BET_MULTI_B")
	private Integer ctBetMultiB;

	@Column(name="CT_BOOK")
	private Integer ctBook;

	@Column(name="CT_CANCEL_DATE")
	private String ctCancelDate;

	@Column(name="CT_CARRIER_PHONE")
	private String ctCarrierPhone;

	@Column(name="CT_CLIENT_ID")
	private String ctClientId;

	@Column(name="CT_CLIENT_PHONE")
	private String ctClientPhone;

	@Column(name="CT_CONSECUTIVE")
	private Integer ctConsecutive;

	@Column(name="CT_CRC")
	private Integer ctCrc;

	@Column(name="CT_DOC_NUMBER")
	private String ctDocNumber;

	@Column(name="CT_DOC_TYPE")
	private String ctDocType;

	@Column(name="CT_DRAW_FLAG")
	private String ctDrawFlag;

	@Column(name="CT_DRAW_ID")
	private String ctDrawId;

	@Column(name="CT_EDITION_ID")
	private Integer ctEditionId;

	@Column(name="CT_FROM_DRAW")
	private Integer ctFromDraw;

	@Column(name="CT_FROM_DRAW_DATE")
	private String ctFromDrawDate;

	@Column(name="CT_GAME_ID")
	private String ctGameId;

	@Column(name="CT_INSERT_DATE")
	private String ctInsertDate;

	@Column(name="CT_LAST_DRAW_MAIL_MESSAGE")
	private Integer ctLastDrawMailMessage;

	@Column(name="CT_LAST_DRAW_SMS_MESSAGE")
	private Integer ctLastDrawSmsMessage;

	@Column(name="CT_MESSAGE_ID")
	private String ctMessageId;

	@Column(name="CT_MOVIL_COMPANY")
	private String ctMovilCompany;

	@Column(name="CT_NUM_COLUMNS")
	private Integer ctNumColumns;

	@Column(name="CT_NUM_GROUPS")
	private Integer ctNumGroups;

	@Column(name="CT_PREV_PHONE_CLIENT")
	private Integer ctPrevPhoneClient;

	@Column(name="CT_PREV_TICKET_ID")
	private Integer ctPrevTicketId;

	@Column(name="CT_PRIZE_FLAG")
	private String ctPrizeFlag;

	@Column(name="CT_PROM_DRAWS")
	private Integer ctPromDraws;

	@Column(name="CT_PROM_GAME")
	private Integer ctPromGame;

	@Column(name="CT_PROM_GROUPS")
	private Integer ctPromGroups;

	@Column(name="CT_PROM_TICKET_1")
	private Integer ctPromTicket1;

	@Column(name="CT_PROM_TICKET_2")
	private Integer ctPromTicket2;

	@Column(name="CT_RECEIPT_AMOUNT")
	private Double ctReceiptAmount;

	@Column(name="CT_RECEIPT_DISCOUNTED")
	private Double ctReceiptDiscounted;

	@Column(name="CT_RECEIPT_NR")
	private Integer ctReceiptNr;

	@Column(name="CT_SALE_TYPE")
	private String ctSaleType;

	@Column(name="CT_SECTOR_CD")
	private String ctSectorCd;

	@Column(name="CT_TERMINAL_NR")
	private String ctTerminalNr;

	@Column(name="CT_TICKET_DATE")
	private String ctTicketDate;

	@Column(name="CT_TICKET_FLAG")
	private Integer ctTicketFlag;

	@Column(name="CT_TICKET_NUM")
	private Integer ctTicketNum;

	@Column(name="CT_TICKET_NUMBER")
	private String ctTicketNumber;

	@Column(name="CT_TO_DRAW")
	private Integer ctToDraw;

	@Column(name="CT_TO_DRAW_DATE")
	private String ctToDrawDate;

	@Column(name="CT_TRNS_NUM")
	private String ctTrnsNum;

	@Column(name="CT_ZONE_CD")
	private String ctZoneCd;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getClComPrints() {
		return clComPrints;
	}

	public void setClComPrints(Integer clComPrints) {
		this.clComPrints = clComPrints;
	}

	public String getCtAgencyCd() {
		return ctAgencyCd;
	}

	public void setCtAgencyCd(String ctAgencyCd) {
		this.ctAgencyCd = ctAgencyCd;
	}

	public String getCtBalanceItem() {
		return ctBalanceItem;
	}

	public void setCtBalanceItem(String ctBalanceItem) {
		this.ctBalanceItem = ctBalanceItem;
	}

	public String getCtBalanceItemExt() {
		return ctBalanceItemExt;
	}

	public void setCtBalanceItemExt(String ctBalanceItemExt) {
		this.ctBalanceItemExt = ctBalanceItemExt;
	}

	public Integer getCtBet1exactA() {
		return ctBet1exactA;
	}

	public void setCtBet1exactA(Integer ctBet1exactA) {
		this.ctBet1exactA = ctBet1exactA;
	}

	public Integer getCtBet1exactB() {
		return ctBet1exactB;
	}

	public void setCtBet1exactB(Integer ctBet1exactB) {
		this.ctBet1exactB = ctBet1exactB;
	}

	public Integer getCtBet2exactA() {
		return ctBet2exactA;
	}

	public void setCtBet2exactA(Integer ctBet2exactA) {
		this.ctBet2exactA = ctBet2exactA;
	}

	public Integer getCtBet2exactB() {
		return ctBet2exactB;
	}

	public void setCtBet2exactB(Integer ctBet2exactB) {
		this.ctBet2exactB = ctBet2exactB;
	}

	public Integer getCtBet3anyA() {
		return ctBet3anyA;
	}

	public void setCtBet3anyA(Integer ctBet3anyA) {
		this.ctBet3anyA = ctBet3anyA;
	}

	public Integer getCtBet3anyB() {
		return ctBet3anyB;
	}

	public void setCtBet3anyB(Integer ctBet3anyB) {
		this.ctBet3anyB = ctBet3anyB;
	}

	public Integer getCtBet3exactA() {
		return ctBet3exactA;
	}

	public void setCtBet3exactA(Integer ctBet3exactA) {
		this.ctBet3exactA = ctBet3exactA;
	}

	public Integer getCtBet3exactB() {
		return ctBet3exactB;
	}

	public void setCtBet3exactB(Integer ctBet3exactB) {
		this.ctBet3exactB = ctBet3exactB;
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

	public Integer getCtBetMultiA() {
		return ctBetMultiA;
	}

	public void setCtBetMultiA(Integer ctBetMultiA) {
		this.ctBetMultiA = ctBetMultiA;
	}

	public Integer getCtBetMultiB() {
		return ctBetMultiB;
	}

	public void setCtBetMultiB(Integer ctBetMultiB) {
		this.ctBetMultiB = ctBetMultiB;
	}

	public Integer getCtBook() {
		return ctBook;
	}

	public void setCtBook(Integer ctBook) {
		this.ctBook = ctBook;
	}

	public String getCtCancelDate() {
		return ctCancelDate;
	}

	public void setCtCancelDate(String ctCancelDate) {
		this.ctCancelDate = ctCancelDate;
	}

	public String getCtCarrierPhone() {
		return ctCarrierPhone;
	}

	public void setCtCarrierPhone(String ctCarrierPhone) {
		this.ctCarrierPhone = ctCarrierPhone;
	}

	public String getCtClientId() {
		return ctClientId;
	}

	public void setCtClientId(String ctClientId) {
		this.ctClientId = ctClientId;
	}

	public String getCtClientPhone() {
		return ctClientPhone;
	}

	public void setCtClientPhone(String ctClientPhone) {
		this.ctClientPhone = ctClientPhone;
	}

	public Integer getCtConsecutive() {
		return ctConsecutive;
	}

	public void setCtConsecutive(Integer ctConsecutive) {
		this.ctConsecutive = ctConsecutive;
	}

	public Integer getCtCrc() {
		return ctCrc;
	}

	public void setCtCrc(Integer ctCrc) {
		this.ctCrc = ctCrc;
	}

	public String getCtDocNumber() {
		return ctDocNumber;
	}

	public void setCtDocNumber(String ctDocNumber) {
		this.ctDocNumber = ctDocNumber;
	}

	public String getCtDocType() {
		return ctDocType;
	}

	public void setCtDocType(String ctDocType) {
		this.ctDocType = ctDocType;
	}

	public String getCtDrawFlag() {
		return ctDrawFlag;
	}

	public void setCtDrawFlag(String ctDrawFlag) {
		this.ctDrawFlag = ctDrawFlag;
	}

	public String getCtDrawId() {
		return ctDrawId;
	}

	public void setCtDrawId(String ctDrawId) {
		this.ctDrawId = ctDrawId;
	}

	public Integer getCtEditionId() {
		return ctEditionId;
	}

	public void setCtEditionId(Integer ctEditionId) {
		this.ctEditionId = ctEditionId;
	}

	public Integer getCtFromDraw() {
		return ctFromDraw;
	}

	public void setCtFromDraw(Integer ctFromDraw) {
		this.ctFromDraw = ctFromDraw;
	}

	public String getCtFromDrawDate() {
		return ctFromDrawDate;
	}

	public void setCtFromDrawDate(String ctFromDrawDate) {
		this.ctFromDrawDate = ctFromDrawDate;
	}

	public String getCtGameId() {
		return ctGameId;
	}

	public void setCtGameId(String ctGameId) {
		this.ctGameId = ctGameId;
	}

	public String getCtInsertDate() {
		return ctInsertDate;
	}

	public void setCtInsertDate(String ctInsertDate) {
		this.ctInsertDate = ctInsertDate;
	}

	public Integer getCtLastDrawMailMessage() {
		return ctLastDrawMailMessage;
	}

	public void setCtLastDrawMailMessage(Integer ctLastDrawMailMessage) {
		this.ctLastDrawMailMessage = ctLastDrawMailMessage;
	}

	public Integer getCtLastDrawSmsMessage() {
		return ctLastDrawSmsMessage;
	}

	public void setCtLastDrawSmsMessage(Integer ctLastDrawSmsMessage) {
		this.ctLastDrawSmsMessage = ctLastDrawSmsMessage;
	}

	public String getCtMessageId() {
		return ctMessageId;
	}

	public void setCtMessageId(String ctMessageId) {
		this.ctMessageId = ctMessageId;
	}

	public String getCtMovilCompany() {
		return ctMovilCompany;
	}

	public void setCtMovilCompany(String ctMovilCompany) {
		this.ctMovilCompany = ctMovilCompany;
	}

	public Integer getCtNumColumns() {
		return ctNumColumns;
	}

	public void setCtNumColumns(Integer ctNumColumns) {
		this.ctNumColumns = ctNumColumns;
	}

	public Integer getCtNumGroups() {
		return ctNumGroups;
	}

	public void setCtNumGroups(Integer ctNumGroups) {
		this.ctNumGroups = ctNumGroups;
	}

	public Integer getCtPrevPhoneClient() {
		return ctPrevPhoneClient;
	}

	public void setCtPrevPhoneClient(Integer ctPrevPhoneClient) {
		this.ctPrevPhoneClient = ctPrevPhoneClient;
	}

	public Integer getCtPrevTicketId() {
		return ctPrevTicketId;
	}

	public void setCtPrevTicketId(Integer ctPrevTicketId) {
		this.ctPrevTicketId = ctPrevTicketId;
	}

	public String getCtPrizeFlag() {
		return ctPrizeFlag;
	}

	public void setCtPrizeFlag(String ctPrizeFlag) {
		this.ctPrizeFlag = ctPrizeFlag;
	}

	public Integer getCtPromDraws() {
		return ctPromDraws;
	}

	public void setCtPromDraws(Integer ctPromDraws) {
		this.ctPromDraws = ctPromDraws;
	}

	public Integer getCtPromGame() {
		return ctPromGame;
	}

	public void setCtPromGame(Integer ctPromGame) {
		this.ctPromGame = ctPromGame;
	}

	public Integer getCtPromGroups() {
		return ctPromGroups;
	}

	public void setCtPromGroups(Integer ctPromGroups) {
		this.ctPromGroups = ctPromGroups;
	}

	public Integer getCtPromTicket1() {
		return ctPromTicket1;
	}

	public void setCtPromTicket1(Integer ctPromTicket1) {
		this.ctPromTicket1 = ctPromTicket1;
	}

	public Integer getCtPromTicket2() {
		return ctPromTicket2;
	}

	public void setCtPromTicket2(Integer ctPromTicket2) {
		this.ctPromTicket2 = ctPromTicket2;
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

	public Integer getCtReceiptNr() {
		return ctReceiptNr;
	}

	public void setCtReceiptNr(Integer ctReceiptNr) {
		this.ctReceiptNr = ctReceiptNr;
	}

	public String getCtSaleType() {
		return ctSaleType;
	}

	public void setCtSaleType(String ctSaleType) {
		this.ctSaleType = ctSaleType;
	}

	public String getCtSectorCd() {
		return ctSectorCd;
	}

	public void setCtSectorCd(String ctSectorCd) {
		this.ctSectorCd = ctSectorCd;
	}

	public String getCtTerminalNr() {
		return ctTerminalNr;
	}

	public void setCtTerminalNr(String ctTerminalNr) {
		this.ctTerminalNr = ctTerminalNr;
	}

	public String getCtTicketDate() {
		return ctTicketDate;
	}

	public void setCtTicketDate(String ctTicketDate) {
		this.ctTicketDate = ctTicketDate;
	}

	public Integer getCtTicketFlag() {
		return ctTicketFlag;
	}

	public void setCtTicketFlag(Integer ctTicketFlag) {
		this.ctTicketFlag = ctTicketFlag;
	}

	public Integer getCtTicketNum() {
		return ctTicketNum;
	}

	public void setCtTicketNum(Integer ctTicketNum) {
		this.ctTicketNum = ctTicketNum;
	}

	public String getCtTicketNumber() {
		return ctTicketNumber;
	}

	public void setCtTicketNumber(String ctTicketNumber) {
		this.ctTicketNumber = ctTicketNumber;
	}

	public Integer getCtToDraw() {
		return ctToDraw;
	}

	public void setCtToDraw(Integer ctToDraw) {
		this.ctToDraw = ctToDraw;
	}

	public String getCtToDrawDate() {
		return ctToDrawDate;
	}

	public void setCtToDrawDate(String ctToDrawDate) {
		this.ctToDrawDate = ctToDrawDate;
	}

	public String getCtTrnsNum() {
		return ctTrnsNum;
	}

	public void setCtTrnsNum(String ctTrnsNum) {
		this.ctTrnsNum = ctTrnsNum;
	}

	public String getCtZoneCd() {
		return ctZoneCd;
	}

	public void setCtZoneCd(String ctZoneCd) {
		this.ctZoneCd = ctZoneCd;
	}
	
	public int getCtGameNumber() {
		int gameNumber;
		try { gameNumber = Integer.parseInt(ctGameId); } 
		catch(Exception e) { gameNumber=0; }
		return gameNumber;
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

}