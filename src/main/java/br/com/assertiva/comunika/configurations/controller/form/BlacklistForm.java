package br.com.assertiva.comunika.configurations.controller.form;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.DataDeserializador;
import br.com.assertiva.comunika.configurations.domain.DataSerializador;
import br.com.assertiva.comunika.configurations.repository.BlacklistConfigurationsRepository;

public class BlacklistForm {
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
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime inclusion = LocalDateTime.now();
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime update;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getInclusion() {
		return inclusion;
	}
	public void setInclusion(LocalDateTime inclusion) {
		this.inclusion = inclusion;
	}
	public LocalDateTime getUpdate() {
		return update;
	}
	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}
	
	public Blacklist converter(BlacklistConfigurationsRepository repositoy) {
		return null;
	}

}
