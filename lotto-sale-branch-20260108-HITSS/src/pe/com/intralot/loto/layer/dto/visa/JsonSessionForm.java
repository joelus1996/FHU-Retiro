package pe.com.intralot.loto.layer.dto.visa;

import java.io.Serializable;

public class JsonSessionForm implements Serializable{
	
	private static final long serialVersionUID = -8669546115877997648L;
	private String sessionKey;
	private String expirationTime;
	private String token;
	private String process;
	private int httpCode;
	
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
}
