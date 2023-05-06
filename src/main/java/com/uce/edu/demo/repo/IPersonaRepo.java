package com.uce.edu.demo.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.model.Persona;


@Repository
public interface IPersonaRepo extends ReactiveCrudRepository<Persona, Integer>{
	
}
