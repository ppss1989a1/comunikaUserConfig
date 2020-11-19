package br.com.assertiva.comunika.configurations.controller;

import java.awt.print.Pageable;
import java.util.List;

import javax.inject.Inject;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.assertiva.comunika.configurations.controller.DTO.BlacklistDTO;
import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.repository.BlacklistConfigurationsRepository;

@RestController
@RequestMapping("/blacklists")
public class BlacklistController {
	//paginação, passar form ao inves de objeto, ordenação, melhorar tratamento de erro,teste unitário
	// implementar router
    
	BlacklistConfigurationsRepository repository;
  
	@Inject
	public BlacklistController(BlacklistConfigurationsRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public  List<BlacklistDTO> loadAll() {
		List<Blacklist> b = repository.loadAll();
		return BlacklistDTO.converter(b);
	}
	
	
	@GetMapping("/{id}")
	public  List<BlacklistDTO> loadByID(@RequestParam @PathVariable int id, int page,int amount) {
		//Pageable pag = PageRequest.of(page,amount);
		List<Blacklist> b = repository.loadbyId(id);
		return new BlacklistDTO().converter(b);
	}

	
	
	@PostMapping
	public int create(@RequestBody Blacklist b) {
		return repository.createBlacklist(b);
	}
	
	@PutMapping	("/{id}")
	@Transactional
	public int update(@PathVariable int id, @RequestBody Blacklist b) {
		return repository.update(id, b);
	}


	@DeleteMapping("/{id}")
	@Transactional
	public int delete(@PathVariable int id) {
		return repository.delete(id);
	}

	
	
	
	
	
}
