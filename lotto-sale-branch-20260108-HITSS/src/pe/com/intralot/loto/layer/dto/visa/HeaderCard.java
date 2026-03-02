package pe.com.intralot.loto.layer.dto.visa;

import java.io.Serializable;

public class HeaderCard implements Serializable{

	private static final long serialVersionUID = 7051782684510099712L;
	private String ecoreTransactionUUID;
	private String ecoreTransactionDate;
	private String millis;
	
	public String getEcoreTransactionUUID() {
		return ecoreTransactionUUID;
	}
	public void setEcoreTransactionUUID(String ecoreTransactionUUID) {
		this.ecoreTransactionUUID = ecoreTransactionUUID;
	}
	public String getEcoreTransactionDate() {
		return ecoreTransactionDate;
	}
	public void setEcoreTransactionDate(String ecoreTransactionDate) {
		this.ecoreTransactionDate = ecoreTransactionDate;
	}
	public String getMillis() {
		return millis;
	}
	public void setMillis(String millis) {
		this.millis = millis;
	}
}
