package pe.com.intralot.loto.layer.model.bean;

import java.io.Serializable;

public class DataGenericResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Boolean status;
	private String message;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
