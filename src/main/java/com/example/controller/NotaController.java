package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Nota;
import com.example.repository.NotaRepository;

@RestController
@RequestMapping(path="/demo")
public class NotaController {
	
	@Autowired
	NotaRepository notaRepository;
	
	  @GetMapping("/note")
	  List<Nota> all() {
	    return (List<Nota>) notaRepository.findAll();
	  }
	  
	  @GetMapping("/note/{id}")
	  public ResponseEntity<Nota> getUsersById(@PathVariable(value = "id") Long notaId)
	      throws ResourceNotFoundException {
	    Nota nota =
	    		notaRepository
	            .findById(notaId)
	            .orElseThrow(() -> new ResourceNotFoundException("nota not found on :: " + notaId));
	    return ResponseEntity.ok().body(nota);
	  }

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createNote(@RequestBody Nota nota) {
			
		notaRepository.save(nota);
			
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public Nota updateNota(@RequestBody Nota newNota, @PathVariable Long id) throws ResourceNotFoundException {
		
		return notaRepository.findById(id)
			   .map(nota -> {
					nota.setTitle(newNota.getTitle());
					nota.setDescription(newNota.getDescription());
					return notaRepository.save(nota);
				}).orElseThrow(() -> new ResourceNotFoundException("id not found on :: " + id));

	
	}
	
}