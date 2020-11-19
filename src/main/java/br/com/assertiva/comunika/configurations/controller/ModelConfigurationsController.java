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

import br.com.assertiva.comunika.configurations.controller.DTO.ModelDTO;
import br.com.assertiva.comunika.configurations.domain.Model;
import br.com.assertiva.comunika.configurations.repository.ModelConfigurationsRepository;

@RestController
@RequestMapping("/models")
public class ModelConfigurationsController {
	
    
	ModelConfigurationsRepository repository;
  
	@Inject
	public ModelConfigurationsController(ModelConfigurationsRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public  List<ModelDTO> loadAll() {
		List<Model> b = repository.loadAll();
		return ModelDTO.converter(b);
	}
	
	
	@GetMapping("/{id}")
	public  List<ModelDTO> loadByID(@PathVariable int id) {
		List<Model> b = repository.loadbyId(id);
		return new ModelDTO().converter(b);
	}

	
	
	@PostMapping
	public int create(@RequestBody Model m) {
		return repository.createModel(m);
	}
	
	@PutMapping	("/{id}")
	@Transactional
	public int update(@PathVariable int id, @RequestBody Model m) {
		
		return repository.update(id, m);
	}


	@DeleteMapping("/{id}")
	@Transactional
	public int delete(@PathVariable int id) {
		return repository.delete(id);
	}

	
	
	
	
	
}
