package pe.com.intralot.loto.layer.dto.client;

public class ClientGameInformationResponseDTO {
	private String status;
	private String message;
	private String token;
	private ClientGameDataDTO data;
	private String dataSession;
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public ClientGameDataDTO getData() {
		return this.data;
	}
	
	public void setData(ClientGameDataDTO data) {
		this.data = data;
	}

	public String getDataSession() {
		return dataSession;
	}

	public void setDataSession(String dataSession) {
		this.dataSession = dataSession;
	}
	
}
