package br.com.assertiva.comunika.configurations.domain;

import java.time.LocalDateTime;
import java.util.Objects;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Blacklist {
	private Integer id;
	private Integer userId;
	private int dd;
	private int number;
	private String description;
	private boolean active;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime inclusion;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime update;
	
	
	
	public Blacklist() {
		super();
	}



	public Blacklist( Integer userId, int number, String description, boolean active,
			LocalDateTime inclusao, LocalDateTime update) {
		super();
		this.userId = userId;
		this.number = number;
		this.description = description;
		this.active = active;
		this.inclusion = inclusion;
		this.update = update;
	}


	
	public int getDd() {
		return dd;
	}



	public void setDd(int dd) {
		this.dd = dd;
	}
	

	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int numero) {
		this.number = numero;
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



	public void setCriado(LocalDateTime inclusion) {
		this.inclusion = inclusion;
	}



	public LocalDateTime getUpdate() {
		return update;
	}



	public void setAtualizado(LocalDateTime update) {
		this.update = update;
	}



	public Integer getId() {
		return id;
	}



	public void setInclusion(LocalDateTime inclusion) {
		this.inclusion = inclusion;
	}



	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}



	@Override
	public int hashCode() {
		return Objects.hash(update, inclusion, description, id, number, active, userId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Blacklist)) {
			return false;
		}
		Blacklist other = (Blacklist) obj;
		return Objects.equals(update, other.update) && Objects.equals(inclusion, other.inclusion)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(number, other.number) && active == other.active
				&& Objects.equals(userId, other.userId);
	}
	
	
	

}
