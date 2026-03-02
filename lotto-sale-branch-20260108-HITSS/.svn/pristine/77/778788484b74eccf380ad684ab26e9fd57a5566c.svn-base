package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_SALELOADPREPAIDCARD",
		query = "{ call LOTOCARD.CLIENTSALE.SALE_LOAD_PREPAID_CARD(?,?,?,?,?,?,?) }",
		callable = true,
		resultClass = ClientProcedureSaleLoadPrepaidCard.class
)
public class ClientProcedureSaleLoadPrepaidCard {
	@Id
	@Column(name="w_amount_loaded")
	private Double  amountLoaded;
	
	@Column(name="w_new_amount")
	private Double  newAmount;
	
	@Column(name="w_client_id")
	private Integer  clientId;
	
	@Column(name="w_balance_item")
	private Integer balanceItem;
	
	@Column(name="w_message")
	private String message;
	
	public Double getAmountLoaded() {
		return amountLoaded;
	}

	public void setAmountLoaded(Double amountLoaded) {
		this.amountLoaded = amountLoaded;
	}

	public Double getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(Double newAmount) {
		this.newAmount = newAmount;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getBalanceItem() {
		return balanceItem;
	}

	public void setBalanceItem(Integer balanceItem) {
		this.balanceItem = balanceItem;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
