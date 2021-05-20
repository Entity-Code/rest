package com.example.controller;

import com.example.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.repository.NotaRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
	public void getNotaByTitle(@PathVariable String title, HttpServletResponse response) throws IOException {
		if(!notaRepository.findByTitle(title).isEmpty()){
			response.getWriter().println("Nota con titolo, trovata:\nid,title,description");
			for(Nota str : notaRepository.findByTitle(title)){
				response.getWriter().println(str.getId()+", "+str.getTitle()+", "+str.getDescription());
			}
		}else response.getWriter().println("Nessuna nota trovata");
	}

	@RequestMapping(method = RequestMethod.POST,value = "/deleteNota/{id}")
	public String deleteNota (@PathVariable Long id) {
		if(notaRepository.existsById(id)){
			notaRepository.deleteById(id);
			return "Nota con id: "+id+", eliminata";
		}else return "Nota non esistente con id: "+id+".";
	}


}




