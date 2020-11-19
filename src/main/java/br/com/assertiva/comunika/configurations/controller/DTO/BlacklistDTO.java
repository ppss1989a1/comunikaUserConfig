package br.com.assertiva.comunika.configurations.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.assertiva.comunika.configurations.domain.Blacklist;

public class BlacklistDTO {
	
	private Integer userId;
	private int dd;
	private int number;
	private String description;
	private boolean active;
	private LocalDateTime inclusion;
	private LocalDateTime update;
	
	public BlacklistDTO() {
		super();
	}

	public BlacklistDTO(Blacklist b) {
		super();
		this.userId = b.getUserId();
		this.dd = b.getDd();
		this.number = b.getNumber();
		this.description = b.getDescription();
		this.active = b.isActive();
		this.inclusion = b.getInclusion();
		this.update = b.getUpdate();
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
	
	
	public static List<BlacklistDTO> converter(List<Blacklist> b) {
		return b.stream().map(BlacklistDTO::new).collect(Collectors.toList());
	}

}
