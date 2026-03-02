package pe.com.intralot.loto.layer.dto.visa;

import java.io.Serializable;

public class TokenSessionParameters implements Serializable{

	private static final long serialVersionUID = 7011776105641909685L;
	private String userToken;
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

}
