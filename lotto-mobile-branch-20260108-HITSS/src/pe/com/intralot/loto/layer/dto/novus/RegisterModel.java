package pe.com.intralot.loto.layer.dto.novus;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RegisterModel {

	private Long user_id;
	private String username;
	private String email;
	private String name;
		
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
}
