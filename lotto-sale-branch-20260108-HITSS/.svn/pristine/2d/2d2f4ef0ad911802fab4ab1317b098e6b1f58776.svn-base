package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_LIST_PRIZES_MAJOR",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.LIST_PRIZES_MAJOR(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureListPrizesMajor.class
		)
public class PaymentPrizeProcedureListPrizesMajor implements Serializable{
	
	private static final long serialVersionUID = -3243589903842310408L;

	@Id
	@Column(name="o_id")
	private String id;
	
	@Column(name="o_client_id")
	private Integer clientId;
	
	@Column(name="o_draw_id")
	private Integer drawId;

	@Column(name="o_game_id")
	private Integer gameId;
	
	@Column(name="o_game_name")
	private String gameName;
	
    @Column(name = "o_prize_amount")
    private Double prizeAmount;

    @Column(name = "o_amount_base")
    private Double amountBase;
    
    @Column(name = "o_amount_tax")
    private Double amountTax;
    
	@Column(name="o_ticket_id")
	private Integer ticketId;
	
	@Column(name="o_expiration_date")
	private String expirationDate;
	
	@Column(name="o_ticket_number")
	private String ticketNumber;
	
	@Column(name="o_free_columns")
	private Integer freeColumns;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Double getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(Double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public Double getAmountBase() {
		return amountBase;
	}

	public void setAmountBase(Double amountBase) {
		this.amountBase = amountBase;
	}

	public Double getAmountTax() {
		return amountTax;
	}

	public void setAmountTax(Double amountTax) {
		this.amountTax = amountTax;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Integer getFreeColumns() {
		return freeColumns;
	}

	public void setFreeColumns(Integer freeColumns) {
		this.freeColumns = freeColumns;
	}	
}

