package br.com.assertiva.comunika.configurations.controller.DTO;

public class ErrorDTO {
	
	private String field;
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
