package pe.com.intralot.loto.layer.dto.agora;

public class PaymentResponse {

	private String state;
	private String message;
	private String json;
	private String code;
	private int httpCode;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "PaymentResponse [state=" + state + ", message=" + message + ", json=" + json + ", code=" + code
				+ ", httpCode=" + httpCode + "]";
	}
}
