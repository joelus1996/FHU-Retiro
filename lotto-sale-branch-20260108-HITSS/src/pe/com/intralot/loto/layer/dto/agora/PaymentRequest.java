package pe.com.intralot.loto.layer.dto.agora;

public class PaymentRequest {
	
	private Double amount;
	private String phone;
	private Integer clientId;
	private String promotionKey;
	private String plataform;
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getPromotionKey() {
		return promotionKey;
	}

	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}
	
	public String getPlataform() {
		return plataform;
	}

	public void setPlataform(String plataform) {
		this.plataform = plataform;
	}

	@Override
	public String toString() {
		return "PaymentRequest [amount=" + amount + ", phone=" + phone + ", clientId=" + clientId + ", promotionKey="
				+ promotionKey + ", plataform=" + plataform + "]";
	}
}
