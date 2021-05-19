package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Nota;
import com.example.repository.NotaRepository;

@RestController
public class NotaController {
	
	@Autowired
	NotaRepository notaRepository;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createNote(@RequestBody Nota nota) {
			
		notaRepository.save(nota);
			
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public Nota updateNota(@RequestBody Nota newNota, @PathVariable Long id) {
		
		return notaRepository.findById(id)
			   .map(nota -> {
					nota.setTitle(newNota.getTitle());
					nota.setDescription(newNota.getDescription());
					return notaRepository.save(nota);
				}).orElseThrow();
	
	}
	
}


