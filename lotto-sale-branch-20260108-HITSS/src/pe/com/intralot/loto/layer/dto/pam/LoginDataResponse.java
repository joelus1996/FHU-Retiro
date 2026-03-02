package pe.com.intralot.loto.layer.dto.pam;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginDataResponse {
	
	private SecurityTokenError error;
	private LoginDataBean result;
	
	public SecurityTokenError getError() {
		return error;
	}


	public void setError(SecurityTokenError error) {
		this.error = error;
	}


	public LoginDataBean getResult() {
		return result;
	}


	public void setResult(LoginDataBean result) {
		this.result = result;
	}


	@Override
    public String toString() {
	    return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
	
}
