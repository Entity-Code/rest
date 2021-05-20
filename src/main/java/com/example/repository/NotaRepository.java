package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Nota;

import java.util.ArrayList;
import java.util.Optional;


public interface NotaRepository extends CrudRepository<Nota,Long>{


     ArrayList<Nota> findByTitle(String title);

}


