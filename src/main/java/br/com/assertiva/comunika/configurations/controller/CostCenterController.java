package br.com.assertiva.comunika.configurations.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.assertiva.comunika.configurations.controller.DTO.CostCenterDTO;
import br.com.assertiva.comunika.configurations.domain.CostCenter;
import br.com.assertiva.comunika.configurations.repository.CostCenterConfigurationsRepository;

@RestController
@RequestMapping("/costcenter")		    
public class CostCenterController {
	
		
		CostCenterConfigurationsRepository repository;
	  
		@Inject
		public CostCenterController(CostCenterConfigurationsRepository repository) {
			super();
			this.repository = repository;
		}

		@GetMapping
		public  List<CostCenter> loadAll() {
			List<CostCenter> c = repository.loadAll();
			return null;//CostCenterDTO.converter(c);
		}
		
		
		@GetMapping("/{id}")
		public  List<CostCenterDTO> loadByID(@PathVariable int id) {
			List<CostCenter> b = repository.loadbyId(id);
			return null;//new CostCenterDTO().converter(b);
		}

		
		
		@PostMapping
		public int create(@RequestBody CostCenter c) {
			return repository.createCenterCost(c);
		}
		
		@PutMapping	("/{id}")
		@Transactional
		public int update(@PathVariable int id, @RequestBody CostCenter c) {
			return repository.update(id, c);
		}


		@DeleteMapping("/{id}")
		@Transactional
		public int delete(@PathVariable int id) {
			return repository.delete(id);
		}

}
