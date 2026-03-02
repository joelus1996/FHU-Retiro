package pe.com.intralot.loto.layer.model.bean;


public class ResponseQTBean {
	
	private String	access_token;
	private String	code;
	private String	message;
	private String	url;
	
	public boolean isTokenError() {
		if (code != null && !code.equals("") ) {
			return true;
		}
		return false;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	 
}
