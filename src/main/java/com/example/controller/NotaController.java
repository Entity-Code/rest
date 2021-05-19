package com.example.controller;

import com.example.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.repository.NotaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/")
public class NotaController {
	
	@Autowired
	NotaRepository notaRepository;
	
	public void test() {
		System.out.println("funziona");
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
