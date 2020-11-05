package dev.carnet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreerAstuceDto {
	
	private String astuce;

	public String getAstuce() {
		return astuce;
	}

	public void setAstuce(String astuce) {
		this.astuce = astuce;
	}
	

}
