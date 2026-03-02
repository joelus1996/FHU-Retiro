package pe.com.intralot.loto.layer.dto.visa;

public class FundsDisbursementsRequest {
	
	private String requestAmount;
	private String cardToken; 
	private String clientId; 
	private String nombres;
	private String apellido; 
	private String requestNumber;
	
	public String getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}
	public String getCardToken() {
		return cardToken;
	}
	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
}
