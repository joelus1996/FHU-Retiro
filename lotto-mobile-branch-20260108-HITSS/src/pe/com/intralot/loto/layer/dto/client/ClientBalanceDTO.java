package pe.com.intralot.loto.layer.dto.client;

public class ClientBalanceDTO {
	private String description;
	private String clientCarrier;
	private String date;
	private Double amount;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClientCarrier() {
		return clientCarrier;
	}
	public void setClientCarrier(String clientCarrier) {
		this.clientCarrier = clientCarrier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
