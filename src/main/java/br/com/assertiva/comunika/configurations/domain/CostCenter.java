package br.com.assertiva.comunika.configurations.domain;


import java.util.Objects;

public class CostCenter {
	
	private Integer id;
	private Integer userId;
	private String name;
	
	
	public CostCenter(Integer userId, String nome) {
		super();
		this.userId = userId;
		this.name = nome;
	}
	public CostCenter() {
		super();
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
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CostCenter)) {
			return false;
		}
		CostCenter other = (CostCenter) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return String.format("CentroCusto [id=%s, userId=%s, nome=%s]", id, userId, name);
	}
	
	

}
