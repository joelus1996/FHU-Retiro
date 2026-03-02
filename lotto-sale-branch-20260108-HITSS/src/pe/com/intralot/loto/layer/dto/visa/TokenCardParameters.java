package pe.com.intralot.loto.layer.dto.visa;

import java.io.Serializable;

public class TokenCardParameters implements Serializable{
	
	private static final long serialVersionUID = -5845057709698604710L;
	private String transactionToken;
	private String securityToken;
	
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public String getSecurityToken() {
		return securityToken;
	}
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
}
