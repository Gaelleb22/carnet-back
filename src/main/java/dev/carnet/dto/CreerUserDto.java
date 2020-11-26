package dev.carnet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreerUserDto {
	
	@NotBlank
	@NotNull
	@Size(min=2)
	@JsonProperty("pseudo")
	private String pseudo;
	
	@NotBlank
	@NotNull
	@Size(min=2)
	@JsonProperty("password")
	private String password;
	
	@NotBlank
	@NotNull
	@Size(min=2)
	@JsonProperty("email")
	private String email;
	
	@NotBlank
	@NotNull
	@Size(min=2)
	@JsonProperty("role")
	private String role;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
