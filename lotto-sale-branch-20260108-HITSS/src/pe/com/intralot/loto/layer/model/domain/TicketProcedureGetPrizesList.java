package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "TICKETSALE_GETPRIZESLIST",
		query = "{ call LOTOCARD.TICKETSALE.GETPRIZESLIST_PP3(?,?) }",
		callable = true,
		resultClass = TicketProcedureGetPrizesList.class
)
public class TicketProcedureGetPrizesList {
	
	@Id
	@Column(name="id")
	private String id;

	@Column(name="game_id")
	private Integer gameId;
	
	@Column(name="parameter_id")
	private String parameterId;
	
	@Column(name="game_name")
	private String gameName;
	
	@Column(name="sale_date")
	private String saleDate;
	
	@Column(name="ticket_id")
	private String ticketId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="table_id")
	private Integer tableId;
	
	@Column(name="prize")
	private String prize;
	
	@Column(name="more_prizes")
	private String morePrizes;
	
	@Column(name="expiration_date")
	private String expirationDate;	
	
	@Column(name="print_pay")
	private String printPay;
	
	@Column(name="prizes_set")
	private String prizesSet;
	
	@Column(name="print_compare")
	private String printCompare;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getMorePrizes() {
		return morePrizes;
	}

	public void setMorePrizes(String morePrizes) {
		this.morePrizes = morePrizes;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getPrintPay() {
		return printPay;
	}

	public void setPrintPay(String printPay) {
		this.printPay = printPay;
	}

	public String getPrizesSet() {
		return prizesSet;
	}

	public void setPrizesSet(String prizesSet) {
		this.prizesSet = prizesSet;
	}

	public String getPrintCompare() {
		return printCompare;
	}

	public void setPrintCompare(String printCompare) {
		this.printCompare = printCompare;
	}
	
	

}
