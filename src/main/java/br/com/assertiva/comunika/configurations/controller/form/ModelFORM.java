package br.com.assertiva.comunika.configurations.controller.form;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.DataDeserializador;
import br.com.assertiva.comunika.configurations.domain.DataSerializador;
import br.com.assertiva.comunika.configurations.domain.Model;

public class ModelFORM {
	
	@NonNull
	private Integer userId;
	private String name;
	@NonNull
	private String message;
	@NonNull
	private String route;
	@NonNull
	private boolean active;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime inclusion = LocalDateTime.now();
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime update;

	
	
	

	public ModelFORM() {
		super();
	}





	public ModelFORM(Integer userId, String name, String message, String route, boolean active, LocalDateTime inclusion,
			LocalDateTime update) {
		super();
		this.userId = userId;
		this.name = name;
		this.message = message;
		this.route = route;
		this.active = active;
		this.inclusion = inclusion;
		this.update = update;
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
}
