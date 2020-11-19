package br.com.assertiva.comunika.configurations.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.DataDeserializador;
import br.com.assertiva.comunika.configurations.domain.DataSerializador;
import br.com.assertiva.comunika.configurations.domain.Model;

public class ModelDTO {
	
	private Integer userId;
	private String name;
	private String message;
	private String route;
	private boolean active;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime inclusion;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime update;

	
	
	

	public ModelDTO() {
		super();
	}





	public ModelDTO(Model m) {
		super();
		this.userId = m.getUserId();
		this.name = m.getName();
		this.message = m.getMessagem();
		this.route = m.getRoute();
		this.active = m.isActive();
		this.inclusion = m.getInclusion();
		this.update = m.getUpdate();
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getRoute() {
		return route;
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

	public static List<ModelDTO> converter(List<Model> m) {
		return m.stream().map(ModelDTO::new).collect(Collectors.toList());
	}

}
