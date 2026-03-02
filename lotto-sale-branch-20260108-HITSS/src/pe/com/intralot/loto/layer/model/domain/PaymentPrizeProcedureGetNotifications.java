package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_NOTIFICATIONS",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_NOTIFICATIONS(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetNotifications.class
		)
public class PaymentPrizeProcedureGetNotifications implements Serializable{
	
	private static final long serialVersionUID = 2826412284031774638L;

	@Id
	@Column(name="o_id")	
	private String id;

	@Column(name="o_client_id")	
	private Integer message;

	@Column(name="o_type")	
	private String type;
	
	@Column(name="o_amount")	
	private Double amount;
	
	@Column(name="o_ticket_id")	
	private Integer ticketId;
	
	@Column(name="o_game")	
	private String game;
	
	@Column(name="o_expiration_date")	
	private String expirationDate;
	
	@Column(name="o_request_number")	
	private Integer requestNumber;

	@Column(name="o_request_type")	
	private String requestType;
	
	@Column(name="o_flag")	
	private String flag;
	
	@Column(name="o_insert_date")	
	private String insertDate;
	

	public Integer getMessage() {
		return message;
	}

	public void setMessage(Integer message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
}
