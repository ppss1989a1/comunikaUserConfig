package br.com.assertiva.comunika.configurations.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Model  {
	private Integer id;
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


	
	
	public Model() {
		super();
	}

	
	



	public Model(Integer userId, String nome, String message, String route, boolean ativo,
			LocalDateTime inclusion, LocalDateTime update) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = nome;
		this.message = message;
		this.route = route;
		this.active = ativo;
		this.inclusion = inclusion;
		this.update = update;
	}






	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getName() {
		return name;
	}




	public void setNome(String name) {
		this.name = name;
	}




	public String getMessagem() {
		return message;
	}




	public void setMessagem(String messagem) {
		this.message = messagem;
	}




	public String getRoute() {
		return route;
	}




	public void setRota(String route) {
		this.route = route;
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




	public void setInclusao(LocalDateTime inclusion) {
		this.inclusion = inclusion;
	}




	public LocalDateTime getUpdate() {
		return update;
	}




	public void setAtualizacao(LocalDateTime atualizacao) {
		this.update = atualizacao;
	}




	public Integer getId() {
		return id;
	}




	@Override
	public int hashCode() {
		return Objects.hash(active, update, id, inclusion, message, name, route, userId);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Model)) {
			return false;
		}
		Model other = (Model) obj;
		return active == other.active && Objects.equals(update, other.update) && Objects.equals(id, other.id)
				&& Objects.equals(inclusion, other.inclusion) && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && route == other.route && Objects.equals(userId, other.userId);
	}




	@Override
	public String toString() {
		return String.format(
				"Modelo [id=%s, userId=%s, nome=%s, mensagem=%s, rota=%s, ativo=%s, inclusao=%s, atualizacao=%s]", id,
				userId, name, message, route, active, inclusion, update);
	}
	
	
	
	
	
	
	
}