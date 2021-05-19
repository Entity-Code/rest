package controller;

import org.springframework.beans.factory.annotation.Autowired;

import repository.NotaRepository;

public class NotaController {
	
	@Autowired
	NotaRepository notaRepository;
	
	public void test() {
		System.out.println("funziona");
	}

	public void test2() {
		System.out.println("funzioan con stefano");
	}

}
