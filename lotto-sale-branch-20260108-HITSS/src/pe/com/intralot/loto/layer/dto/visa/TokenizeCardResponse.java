package pe.com.intralot.loto.layer.dto.visa;

import java.io.Serializable;

public class TokenizeCardResponse implements Serializable{

	private static final long serialVersionUID = -6381294844072297077L;
	private Integer errorCode;
	private String errorMessage;
	private HeaderCard header;
	private Card card;
	private Order order;
	private Token token;
	private String json;
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HeaderCard getHeader() {
		return header;
	}
	public void setHeader(HeaderCard header) {
		this.header = header;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
