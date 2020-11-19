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

import br.com.assertiva.comunika.configurations.controller.DTO.BlacklistDTO;
import br.com.assertiva.comunika.configurations.controller.DTO.SenderDTO;
import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.Sender;
import br.com.assertiva.comunika.configurations.repository.SenderConfigurationsRepository;

@RestController
@RequestMapping("/senders")
public class SenderConfigurationsController {
	
	SenderConfigurationsRepository repository;
	  
	@Inject
	public SenderConfigurationsController(SenderConfigurationsRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public  List<SenderDTO> loadAll() {
		List<Sender> s = repository.loadAll();
		return SenderDTO.converter(s);
	}
	
	
	@GetMapping("/{id}")
	public  List<SenderDTO> loadByID(@PathVariable int id) {
		List<Sender> b = repository.loadbyId(id);
		return new SenderDTO().converter(b);
	}

	
	
	@PostMapping
	public int create(@RequestBody Sender s) {
		return repository.createSender(s);
	}
	
	@PutMapping	("/{id}")
	@Transactional
	public int update(@PathVariable int id, @RequestBody Sender s) {
		return repository.update(id, s);
	}


	@DeleteMapping("/{id}")
	@Transactional
	public int delete(@PathVariable int id) {
		return repository.delete(id);
	}

	
	
	
	
	


}
