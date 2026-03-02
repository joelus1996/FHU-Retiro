package pe.com.intralot.loto.layer.model.bean;

public class ResultBean {
	
	private Integer state;
	private String message;
	private String code;
	
	public ResultBean() {
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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

}
