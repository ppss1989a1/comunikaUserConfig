package br.com.assertiva.comunika.configurations.controller.form;

import org.springframework.lang.NonNull;

public class ErrorDTO {
	
	@NonNull
	private String field;
	@NonNull
	private String error;
	
	public ErrorDTO(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}
	
	
	

}
