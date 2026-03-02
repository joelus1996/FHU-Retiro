package pe.com.intralot.loto.layer.model.bean;

public class DebitIdQrResponse {
	
	private String id;
	private String debitQR;
	private String debitId;
	private String amountTotal;
	private String amountNeoga;
	private String amountKiron;
	private String balanceItemKiron;
	private String balanceItemNeoga;
	private String estado;
	private String mensaje;
	private String debug;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDebitQR() {
		return debitQR;
	}
	public void setDebitQR(String debitQR) {
		this.debitQR = debitQR;
	}
	public String getDebitId() {
		return debitId;
	}
	public void setDebitId(String debitId) {
		this.debitId = debitId;
	}
	public String getAmountNeoga() {
		return amountNeoga;
	}
	public void setAmountNeoga(String amountNeoga) {
		this.amountNeoga = amountNeoga;
	}
	public String getAmountKiron() {
		return amountKiron;
	}
	public void setAmountKiron(String amountKiron) {
		this.amountKiron = amountKiron;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public String getAmountTotal() {
		return amountTotal;
	}
	public void setAmountTotal(String amountTotal) {
		this.amountTotal = amountTotal;
	}
	public String getBalanceItemKiron() {
		return balanceItemKiron;
	}
	public void setBalanceItemKiron(String balanceItemKiron) {
		this.balanceItemKiron = balanceItemKiron;
	}
	public String getBalanceItemNeoga() {
		return balanceItemNeoga;
	}
	public void setBalanceItemNeoga(String balanceItemNeoga) {
		this.balanceItemNeoga = balanceItemNeoga;
	}
}
