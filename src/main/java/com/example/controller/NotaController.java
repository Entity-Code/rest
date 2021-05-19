package com.example.controller;

import com.example.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.repository.NotaRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/")
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

	@RequestMapping(method = RequestMethod.GET,value = "/getNota/{id}")
	public String getNotaById(@PathVariable Long id) {
		if(notaRepository.findById(id).isPresent()){
			return "Nota trovata : \n"+notaRepository.findById(id);
		}else return "Non è stata trovata nessuna nota.";
	}

	@RequestMapping(method = RequestMethod.GET,value = "/getNodaTitolo/{title}")
	public String getNotaByTitle(@PathVariable String title) {
		if(notaRepository.findByTitle(title).isPresent()){
			return "Nota con titolo, trovata.\n"+notaRepository.findByTitle(title);
		}else return "Non è stata trovata nessuna nota con questo titolo";
	}

	@RequestMapping(method = RequestMethod.POST,value = "/deleteNota/{id}")
	public String deleteNota (@PathVariable Long id) {
		if(notaRepository.existsById(id)){
			notaRepository.deleteById(id);
			return "Nota con id: "+id+", eliminata";
		}else return "Nota non esistente con id: "+id+".";
	}


}




