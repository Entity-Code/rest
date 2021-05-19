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
	public Optional<Nota> getNotaById(@PathVariable Long id) {
		System.out.println("Nota:");
		return notaRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST,value = "/deleteNota/{id}")
	public String deleteNota (@PathVariable Long id) {
		if(notaRepository.existsById(id)){
			notaRepository.deleteById(id);
			return "Nota con id: "+id+", eliminata";
		}else return "Nota non esistente con id: "+id+".";
	}



}
