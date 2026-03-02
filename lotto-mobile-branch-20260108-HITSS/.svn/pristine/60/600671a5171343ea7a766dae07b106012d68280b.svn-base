package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

import pe.com.intralot.loto.lib.StringLib;

@Entity
@NamedNativeQuery(
				
		name = "TICKETSALE_GETCLIENTTICKET_RETAIL",
		query = "{ call LOTOCARD.TICKETSALE.getclientticket_retail(?,?,?,?) }",
		callable = true,
		resultClass = TicketProcedureGetClientTicketRetail.class
)
public class TicketProcedureGetClientTicketRetail {
	
	@Id
	@Column(name = "p_ctticketid") //SI
	private String ctTicketId;
	
	@Column(name = "p_cldoctype") //SI
	private String clDocType;
	
	@Column(name = "p_cldocnumber") //SI
	private String clDocNumber;
	
	@Column(name = "p_clname") //SI
	private String clName;
	
	@Column(name = "p_ctclientid") //SI
	private String ctClientId;
	
	@Column(name = "p_ticketnum")
	private String ctTicketNumber; //SI
	
	@Column(name = "p_ctgameid") //SI
	private String ctGameId;
	
	@Column(name = "p_ticketdate") //SI
	private String ctTicketDate;
	
	@Column(name = "p_terminalnr")
	private String ctTerminalNr;
	
	@Column(name = "p_receiptnr") //SI
	private Integer ctReceiptNr;
	
	@Column(name = "p_trnsnum") // SI
	private String ctTrnsNum;
	
	@Column(name = "p_numcolumns") //SI
	private Integer ctNumColumns;
	
	@Column(name = "p_betmatrix1") // SI
	private String ctBetMatrix1;
	
	@Column(name = "p_betmatrix2") // SI
	private String ctBetMatrix2;
	
	@Column(name = "p_betmatrix3")// SI
	private String ctBetMatrix3;
	
	@Column(name = "p_betmatrix4")// SI
	private String ctBetMatrix4;
	
	@Column(name = "p_receiptamount")// SI
	private Double ctReceiptAmount;
	
	/*@Column(name = "p_receiptdiscounted") //SI
	private Double ctReceiptDiscounted;*/
	
	@Column(name = "p_fromdraw") //SI
	private Integer ctFromDraw;
	
	@Column(name = "p_todraw") //SI
	private Integer ctToDraw;
	
	/*@Column(name = "p_saletype")
	private String ctSaleType;*/
	
	@Column(name = "p_todrawdate")  //SI
	private String ctToDrawDate;
	
	@Column(name = "p_fromdrawdate")
	private String ctFromDrawDate; //SI
	
	
	public String getCtClientId() {
		return ctClientId;
	}

	public void setCtClientId(String ctClientId) {
		this.ctClientId = ctClientId;
	}

	public String getClDocType() {
		return clDocType;
	}

	public void setClDocType(String clDocType) {
		this.clDocType = clDocType;
	}

	public String getClDocNumber() {
		return clDocNumber;
	}

	public void setClDocNumber(String clDocNumber) {
		this.clDocNumber = clDocNumber;
	}

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
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
