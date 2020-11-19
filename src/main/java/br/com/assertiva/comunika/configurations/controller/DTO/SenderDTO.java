package br.com.assertiva.comunika.configurations.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.Sender;

public class SenderDTO {

	private Integer userId;
	private String name;
	private boolean activeResgister;
	private LocalDateTime inclusion;
	private LocalDateTime update;

	
	
	

	public SenderDTO() {
		super();
	}





	public SenderDTO(Sender s) {
		super();
		this.userId = s.getUserId();
		this.activeResgister = s.isActiveResgister();
		this.inclusion = s.getInclusion();
		this.update = s.getUpdate();
		this.name = s.getName();
	}









	public Integer getUserId() {
		return userId;
	}





	public String getName() {
		return name;
	}





	public boolean isActiveResgister() {
		return activeResgister;
	}





	public LocalDateTime getInclusion() {
		return inclusion;
	}





	public LocalDateTime getUpdate() {
		return update;
	}





	public static List<SenderDTO> converter(List<Sender> s) {
		return s.stream().map(SenderDTO::new).collect(Collectors.toList());
	}

}
