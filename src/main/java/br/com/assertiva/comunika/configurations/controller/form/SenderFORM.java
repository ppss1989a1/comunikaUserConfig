package br.com.assertiva.comunika.configurations.controller.form;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.lang.NonNull;

import br.com.assertiva.comunika.configurations.controller.DTO.SenderDTO;
import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.Sender;

public class SenderFORM {

	@NonNull
	private Integer userId;
	@NonNull
	private int dd;
	@NonNull
	private int number;
	@NonNull
	private String description;
	@NonNull
	private boolean active;
	@NonNull
	private LocalDateTime inclusion;
	@NonNull
	private LocalDateTime update;

	
	
	

	public SenderFORM() {
		super();
	}





	public SenderFORM(Integer userId, int dd, int number, String description, boolean active, LocalDateTime inclusion,
			LocalDateTime update) {
		super();
		this.userId = userId;
		this.dd = dd;
		this.number = number;
		this.description = description;
		this.active = active;
		this.inclusion = inclusion;
		this.update = update;
	}





	public Integer getUserId() {
		return userId;
	}





	public int getDd() {
		return dd;
	}





	public int getNumber() {
		return number;
	}





	public String getDescription() {
		return description;
	}





	public boolean isActive() {
		return active;
	}





	public LocalDateTime getInclusion() {
		return inclusion;
	}





	public LocalDateTime getUpdate() {
		return update;
	}
}
