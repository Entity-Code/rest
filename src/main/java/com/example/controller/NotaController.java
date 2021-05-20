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
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.repository.NotaRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
	  public ResponseEntity<Nota> getUsersById(@PathVariable(value = "id") Long notaId) {
	    Nota nota =
	    		notaRepository
	            .findById(notaId)
	            .orElseThrow();
	    return ResponseEntity.ok().body(nota);
	  }

	@PostMapping("/create")
	public Nota createNote(@RequestBody Nota nota) {

		return notaRepository.save(nota);
	}

	@GetMapping("/getNota/{id}")
	public String getNotaById(@PathVariable Long id) {
		if(notaRepository.findById(id).isPresent()){
			return "Nota trovata : \n"+notaRepository.findById(id);
		}else return "Non è stata trovata nessuna nota.";
	}

<<<<<<< HEAD
	@GetMapping("/getNodaTitolo/{title}")
	public String getNotaByTitle(@PathVariable String title) {
		if(notaRepository.findByTitle(title).isPresent()){
			return "Nota con titolo, trovata.\n"+notaRepository.findByTitle(title);
		}else return "Non è stata trovata nessuna nota con questo titolo";
=======
	@RequestMapping(method = RequestMethod.GET,value = "/getNodaTitolo/{title}")
	public void getNotaByTitle(@PathVariable String title, HttpServletResponse response) throws IOException {
		if(!notaRepository.findByTitle(title).isEmpty()){
			response.getWriter().println("Nota con titolo, trovata:\nid,title,description");
		for(Nota str : notaRepository.findByTitle(title)){
			response.getWriter().println(str.getId()+", "+str.getTitle()+", "+str.getDescription());
		}
		}else response.getWriter().println("Nessuna nota trovata");
>>>>>>> efe8081f7194adcd1e467d7f9fce7dda492e732c
	}

	@PostMapping("/update/{id}")
	public Nota updateNota(@RequestBody Nota newNota, @PathVariable Long id) {
		
		return notaRepository.findById(id)
				.map(nota -> {
					nota.setTitle(newNota.getTitle());
					nota.setDescription(newNota.getDescription());
					return notaRepository.save(nota);
					
				}).orElseThrow();
	}
	
	
	@PostMapping("/deleteNota/{id}")
	public String deleteNota (@PathVariable Long id) {
		if(notaRepository.existsById(id)){
			notaRepository.deleteById(id);
			return "Nota con id: "+id+", eliminata";
		}else return "Nota non esistente con id: "+id+".";
	}


}




