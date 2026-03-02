package pe.com.intralot.loto.layer.dto.visa;

public class VisanetParameters {
	// Parametros del cliente
	private String cardHolderName;
	private String cardHolderLastName;
	private String cardHolderEmail;
	private String scriptSrc;
	private String merchantLogo;
	private String timeoutUrl;
	private String pagoTokenUrl;
	private String typeCard;
	private Double comision;
	
	// Parametros del boton
	private String amount;
	
	// Parametros para actualizar el Saldo
	private Integer clientId;
	private String remoteAddr;
	
	// Session Key para buscar la Transaccion
	private String sk;
	
	// Parametros para bono
	private String actwbbono;
	private String actbono;
	
	private String codePromotional;
	private String channel;

	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardHolderLastName() {
		return cardHolderLastName;
	}
	public void setCardHolderLastName(String cardHolderLastName) {
		this.cardHolderLastName = cardHolderLastName;
	}
	public String getCardHolderEmail() {
		return cardHolderEmail;
	}
	public void setCardHolderEmail(String cardHolderEmail) {
		this.cardHolderEmail = cardHolderEmail;
	}
	public String getScriptSrc() {
		return scriptSrc;
	}
	public void setScriptSrc(String scriptSrc) {
		this.scriptSrc = scriptSrc;
	}
	public String getMerchantLogo() {
		return merchantLogo;
	}
	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	public String getTimeoutUrl() {
		return timeoutUrl;
	}
	public void setTimeoutUrl(String timeoutUrl) {
		this.timeoutUrl = timeoutUrl;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public String getSk() {
		return sk;
	}
	public void setSk(String sk) {
		this.sk = sk;
	}
	public String getActwbbono() {
		return actwbbono;
	}
	public void setActwbbono(String actwbbono) {
		this.actwbbono = actwbbono;
	}
	public String getActbono() {
		return actbono;
	}
	public void setActbono(String actbono) {
		this.actbono = actbono;
	}
	public String getPagoTokenUrl() {
		return pagoTokenUrl;
	}
	public void setPagoTokenUrl(String pagoTokenUrl) {
		this.pagoTokenUrl = pagoTokenUrl;
	}
	public String getTypeCard() {
		return typeCard;
	}
	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	public String getCodePromotional() {
		return codePromotional;
	}
	public void setCodePromotional(String codePromotional) {
		this.codePromotional = codePromotional;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
