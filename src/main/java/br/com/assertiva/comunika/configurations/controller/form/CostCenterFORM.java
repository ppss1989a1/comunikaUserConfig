package br.com.assertiva.comunika.configurations.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.lang.NonNull;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.CostCenter;

public class CostCenterFORM{

	@NonNull
	private Integer userId;
	@NonNull
	private String name;
	
	public CostCenterFORM() {
		super();
	}
	
	public CostCenterFORM(Integer userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
}
