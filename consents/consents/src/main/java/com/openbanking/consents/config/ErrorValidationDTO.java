package com.openbanking.consents.config;

public class ErrorValidationDTO {
	public String atributo;
    private String error;
	public ErrorValidationDTO(String atributo, String error) {
		super();
		this.atributo = atributo;
		this.error = error;
	}
	public String getAtributo() {
		return atributo;
	}
	public String getError() {
		return error;
	}
}
