package pe.com.intralot.loto.layer.dto.novus;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RegisterDataResponse {
	
	private RegisterNovusResponse data;
	private NovusError error;
	private String responseCodeMessage;
	private String result;
	private String jsonString;
	
	
	public boolean isTokenError() {
		if (error.getError_code()==1001 || error.getError_code()==500042 ) {
			return true;
		}
		return false;
	}
	
	
		public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public RegisterNovusResponse getData() {
		return data;
	}

	public void setData(RegisterNovusResponse data) {
		this.data = data;
	}

	public NovusError getError() {
		return error;
	}


	public void setError(NovusError error) {
		this.error = error;
	}


	public String getResponseCodeMessage() {
		return responseCodeMessage;
	}


	public void setResponseCodeMessage(String responseCodeMessage) {
		this.responseCodeMessage = responseCodeMessage;
	}


	public String getJsonString() {
		return jsonString;
	}


	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}


	@Override
    public String toString() {
	    return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
	
}
