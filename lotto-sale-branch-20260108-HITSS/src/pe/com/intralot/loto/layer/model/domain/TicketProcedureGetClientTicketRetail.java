package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;
import pe.com.intralot.loto.lib.StringLib;

@Entity
@NamedNativeQuery(
				
		name = "TICKETSALE_GETCLIENTTICKET_RETAIL",
		query = "{ call RETAIL.CLIENTPRO.GETCLIENTTICKETDETAIL(?,?,?,?) }",
		callable = true,
		resultClass = TicketProcedureGetClientTicketRetail.class
)
public class TicketProcedureGetClientTicketRetail {
	
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
	
	@Column(name = "p_terminalnr")
	private String ctTerminalNr;
	
	@Column(name = "p_receiptnr")
	private Integer ctReceiptNr;
	
	@Column(name = "p_trnsnum")
	private String ctTrnsNum;
	
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

	@Column(name = "p_fromdraw")
	private Integer ctFromDraw;
	
	@Column(name = "p_todraw")
	private Integer ctToDraw;
	
	@Column(name = "p_todrawdate")
	private String ctToDrawDate;
	
	@Column(name = "p_fromdrawdate")
	private String ctFromDrawDate;
	
	@Column(name = "p_betmatrix01")
	private String ctBetMatrix01;
	
	@Column(name = "p_maxamountwinner")
	private Double ctMaxAmountWinner; // premio aproximado
	
	@Column(name = "p_prize_amount")
	private Double ctPrizeAmount; // premio ganado
	
	@Column(name = "p_combination")
	private String ctCombination; 
	
	@Column(name = "p_estado")
	private String ctEstado; 
	
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
	
	public String getCtBetMatrix01() {
		return ctBetMatrix01;
	}

	public void setCtBetMatrix01(String ctBetMatrix01) {
		this.ctBetMatrix01 = ctBetMatrix01;
	}

	public Double getCtMaxAmountWinner() {
		return ctMaxAmountWinner;
	}

	public void setCtMaxAmountWinner(Double ctMaxAmountWinner) {
		this.ctMaxAmountWinner = ctMaxAmountWinner;
	}
	
	public Double getCtPrizeAmount() {
		return ctPrizeAmount;
	}

	public void setCtPrizeAmount(Double ctPrizeAmount) {
		this.ctPrizeAmount = ctPrizeAmount;
	}

	public String getCtCombination() {
		return ctCombination;
	}

	public void setCtCombination(String ctCombination) {
		this.ctCombination = ctCombination;
	}

	public String getCtEstado() {
		return ctEstado;
	}

	public void setCtEstado(String ctEstado) {
		this.ctEstado = ctEstado;
	}

	public int getCtGameNumber() {
		int gameNumber;
		try { gameNumber = Integer.parseInt(ctGameId); } 
		catch(Exception e) { gameNumber=0; }
		return gameNumber;
	}
	
	public String getCtTrmId() {
		return StringLib.padLeft(ctTerminalNr, '0', 2);
	}
	public String getFromDrawDay() {
		String output=null;
		try { output=ctFromDrawDate==null?"":ctFromDrawDate.substring(0, 10); }
		catch(Exception e) { output=""; }
		return output;
	}


	public String toString() {
		return   " ctTicketId="+ctTicketId+
                 " ctClientId="+ctClientId+
                 " ctTicketNumber="+ctTicketNumber+
                 " ctGameId="+ctGameId+
                 " ctTicketDate="+ctTicketDate+
                 " ctReceiptNr="+ctReceiptNr+
                 " ctTrnsNum="+ctTrnsNum+
                 " ctNumColumns="+ctNumColumns+
                 " ctBetMatrix1="+ctBetMatrix1+
                 " ctBetMatrix2="+ctBetMatrix2+
                 " ctBetMatrix3="+ctBetMatrix3+
                 " ctBetMatrix4="+ctBetMatrix4+
                 " ctReceiptAmount="+ctReceiptAmount+
                 " ctFromDraw="+ctFromDraw+
                 " ctToDraw="+ctFromDraw+
                 " ctToDrawDate="+ctToDrawDate+
                 " ctFromDrawDate="+ctFromDrawDate;
		
	}
}
