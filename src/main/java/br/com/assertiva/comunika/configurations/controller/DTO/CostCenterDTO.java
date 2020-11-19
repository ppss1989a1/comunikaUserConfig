package br.com.assertiva.comunika.configurations.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.CostCenter;

public class CostCenterDTO {

	private Integer userId;
	private String name;
	
	public CostCenterDTO() {
		super();
	}
	
	public CostCenterDTO(CostCenter c) {
		super();
		this.userId = c.getUserId();
		this.name = c.getName();
	}
	public Integer getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	
	
	  public static List<CostCenterDTO> converter(List<CostCenter> c) { 
		  return  c.stream().map(CostCenterDTO::new).collect(Collectors.toList()); 
		  
	  }
	 

}
