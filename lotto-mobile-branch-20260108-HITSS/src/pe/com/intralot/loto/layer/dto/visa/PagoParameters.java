package pe.com.intralot.loto.layer.dto.visa;

public class PagoParameters {
	// Parametros del cliente
	private String transactionToken;
	private String sessionKey;
	private String email;
	private String channel;
	
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String customerEmail) {
		this.email = customerEmail;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
}
