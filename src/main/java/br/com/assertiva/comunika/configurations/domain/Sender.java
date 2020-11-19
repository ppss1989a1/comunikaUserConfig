package br.com.assertiva.comunika.configurations.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Sender {
	private Integer id;
	private String name;
	private Integer userId;
	private boolean activeResgister;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime inclusion;
	@JsonSerialize(using=DataSerializador.class)
	@JsonDeserialize(using=DataDeserializador.class)
	private LocalDateTime update;
	
	public Sender() {
		super();
	}


	

	public Sender( String nome, Integer userId, boolean registroAtivo, LocalDateTime inclusao,
			LocalDateTime atualizacao) {
		super();
		this.name = nome;
		this.userId = userId;
		this.activeResgister = registroAtivo;
		this.inclusion = inclusao;
		this.update = atualizacao;
	}




	public String getName() {
		return name;
	}


	public void setNome(String name) {
		this.name = name;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getId() {
		return id;
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




	public boolean isActiveResgister() {
		return activeResgister;
	}




	public void setActiveResgister(boolean activeResgister) {
		this.activeResgister = activeResgister;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setInclusion(LocalDateTime inclusion) {
		this.inclusion = inclusion;
	}




	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}




	public void setAtualizacao(LocalDateTime update) {
		this.update = update;
	}




	@Override
	public int hashCode() {
		return Objects.hash(update, id, inclusion, name, activeResgister, userId);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sender)) {
			return false;
		}
		Sender other = (Sender) obj;
		return Objects.equals(update, other.update) && Objects.equals(id, other.id)
				&& Objects.equals(inclusion, other.update) && Objects.equals(name, other.name)
				&& activeResgister == other.activeResgister && Objects.equals(userId, other.userId);
	}




	@Override
	public String toString() {
		return String.format("Remetente [id=%s, nome=%s, userId=%s, registroAtivo=%s, inclusao=%s, atualizacao=%s]", id,
				name, userId, activeResgister, inclusion, update);
	}


	
	
	
	


}
